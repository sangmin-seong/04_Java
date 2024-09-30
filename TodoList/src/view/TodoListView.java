package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;


public class TodoListView {
	
	// 필드 생성
	private TodoListServiceImpl service = null;
	private BufferedReader br = null;
	
	
	public TodoListView() {
		
		try {
			
			service = new TodoListServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		}catch (Exception e) {
			System.out.println("*** 프로그램 실행 중 오류발생 ***");
			e.printStackTrace();
			System.exit(0);
		}
	}
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	// 메인 메뉴
	
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("====== Todo List =====");
		System.out.println("1. Todo List Full View"); // 할일 목록 전체 조회
		System.out.println("2. Todo Detail View");    // 자세히 보기?
		System.out.println("3. Todo Add");			  // 할일 추가
		System.out.println("4. Todo Complete");       // 완료
		System.out.println("5. Todo Update");	  	  // 수정
		System.out.println("6. Todo Delete"); 		  // 삭제
		System.out.println("0. EXIT");				  // 프로그램 종료
		
		System.out.println("select menu number >>>");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
		
	}
	
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			
			try {
				
				input = selectMenu();
			
				switch(input) {
				case 1 : ListAll();  break;
				case 2 : detailView();  break;
				case 3 : addTodo();  break;
				case 4 : completeTodo(); break;
				case 5 : updateTodo();  break;
				case 6 : deleteTodo(); break;
				case 0 : System.out.println("\n@@@ 프로그램 종료 @@@\n"); break;
				default : System.out.println("잘못 입력하였습니다.");;
			}
			
				System.out.println("==============================================");
			}catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요 ###\n");
				input = -1; // 첫 반복에서 종료되지 않게 값 변경 // 
			}catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n"); 
				e.printStackTrace();
			}catch (Exception e) { // 나머지 예외 처리
				e.printStackTrace();
			}
			
		}while(input != 0);
	}
	
	
	
	//[1] 할일 목록 전체 보기 
	private void ListAll() {
		System.out.println("\n=== Todo List Full View ===\n");
		
		List<Todo> TodoList = service.getTodoList();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		long completeCount = TodoList.stream().filter(Todo::isComplete).count();
		
		// 조회할 할일 목록이 없을 경우
		
		if(TodoList.isEmpty()) {
			System.out.println("\n### 할일 목록이 존재하지 않습니다. ###\n");
			return;
		}
		
			
		
		System.out.printf("완료된 Todo 개수 / 전체 Todo 수 : %d / %d \n", completeCount,TodoList.size());
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("%-10s %-7s %15s %13s \n",
				"[인덱스]", "[등록일]", "[완료여부]", "[할 일 제목]");
		System.out.println("-------------------------------------------------------------------------------");

		for(int i =0; i < TodoList.size(); i++) {
			Todo todo = TodoList.get(i);
			
			String complete = todo.isComplete() ? "(O)" : "(X)";
			System.out.printf(" [%4s] %23s %9s %15s \n",
					i, todo.getRegDate().format(formatter), complete, todo.getTitle());
			}
	}
	
	
	// [2] 자세히 보기
	private void detailView() throws IOException {
		System.out.println("\n=== TodoList detail view ===\n");
		
		// 과제명으로 검색하기
		System.out.println("인덱스 번호 입력 >>>>");
		int input = Integer.parseInt(br.readLine());
		
		// 목록에서 이름으로 검샐 후 결과 반환
		List<Todo> searchList = service.selectIndex(input);
		
		// 검색결과가 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 검색 결과가 없습니다 ###\n");
			return;
		}
		
		
		// 검색결과 있을 경우
		for(Todo todo : searchList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			System.out.println("------------------------------------");
			System.out.println("제목 : " + todo.getTitle());
			System.out.println("등록일 : " + todo.getRegDate().format(formatter));
			System.out.println("완료 여부 : " + (todo.isComplete() ? "O" : "X"));
			System.out.println("------------------------------------");
			System.out.println("[세부 내용]\n" + todo.getDetail());
		}
	}
	
	
	// [3] 할일 목록 추가
	private void addTodo() throws IOException {
		System.out.println("\n=== Todo Add ===\n");
		
		System.out.println("제목 : ");
		String title = br.readLine();
		
		StringBuilder detailBuilder = new StringBuilder();
        String line;

        // 세부내용 입력 안내 메시지를 한 번만 출력
        System.out.println("세부내용 작성(입력 종료 시 !wq 작성 후 엔터)");
        System.out.println("----------------------------------------------");
        
        while (true) {
            line = br.readLine();
            if ("!wq".equals(line.trim())) { // 사용자가 입력한 문자열이 !wq인지 확인
                System.out.println("----------------------------------------------");
                break;
            }
            detailBuilder.append(line).append("\n"); // 세부내용을 StringBuilder에 추가
        }
        
        String detail = detailBuilder.toString().trim(); // 세부내용의 앞뒤 공백 및 개행 제거
        
        // 제목, 상세내용으로 할일 목록 추가 후 결과 반환받기
        boolean result = service.addTodoList(title, detail);
		
		if(result) {
			List<Todo> todoList = service.getTodoList();
			
			for(int i = 0; i < todoList.size(); i++) {
				if(todoList.get(i).getTitle().equals(title)) {
					System.out.printf("\n*** [%s] 인덱스에 추가되었습니다. ***\n", i);
					break;
				}
			}
		}
	}
	
	// [4] 할일 완료 여부
	private void completeTodo() throws IOException {
		System.out.println("\n=== Todo Complete ===\n");
		
		System.out.print("O <-> X 변경할 인덱스 번호 입력 :");
		int input = Integer.parseInt(br.readLine());
		
		List<Todo> searchList = service.selectIndex(input);
		
		
		
		if(searchList.isEmpty()) {
			System.out.println("\n### 일치하는 Todo가 없습니다. ###\n");
			return;
		}
		
		Todo todo = searchList.get(0);
		
		boolean complete = !todo.isComplete();
		todo.setComplete(complete);
			
		System.out.println("[변경 되었습니다.]");
	}
	
		
		
	
	
	// [5] 할일 목록 수정하기
	private void updateTodo() throws IOException {
		System.out.println("\n=== Todo Update ===\n");
		
		System.out.print("수정할 할 일 인덱스 번호 입력 >>>>>");
		int input = Integer.parseInt(br.readLine());
		
		List<Todo> searchList = service.selectIndex(input);
		
		if(searchList.isEmpty()) {
			System.out.println("\n### 일치하는 할 일이 없습니다. ###\n");
			return;
		}
		
		
		for(Todo todo : searchList) {
			
			System.out.println("@@@@@@@@@@@[수정 전]@@@@@@@@@@@@@@@");
			System.out.println("--------------------------------------------");
		
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
			System.out.println("------------------------------------");
			System.out.println("제목 : " + todo.getTitle());
			System.out.println("등록일 : " + todo.getRegDate().format(formatter));
			System.out.println("완료 여부 : " + (todo.isComplete() ? "O" : "X"));
			System.out.println("------------------------------------");
			System.out.println("[세부 내용]\n" + todo.getDetail());
		}
		
		// 수정할 상세 내용 입력
		System.out.println("제목 : ");
		String title = br.readLine();
		
		StringBuilder detailBuilder = new StringBuilder();
        String line;

        // 세부내용 입력 안내 메시지를 한 번만 출력
        System.out.println("세부내용 작성(입력 종료 시 !wq 작성 후 엔터)");
        System.out.println("----------------------------------------------");
        
        while (true) {
            line = br.readLine();
            if ("!wq".equals(line.trim())) { // 사용자가 입력한 문자열이 !wq인지 확인
                System.out.println("----------------------------------------------");
                break;
            }
            detailBuilder.append(line).append("\n"); // 세부내용을 StringBuilder에 추가
        }
        
        String detail = detailBuilder.toString().trim(); // 세부내용의 앞뒤 공백 및 개행 제거
        
        // 제목, 상세내용으로 할일 목록 추가 후 결과 반환받기
        boolean result = service.addTodoList(title, detail);
		
		if(result) {
			List<Todo> todoList = service.getTodoList();
			
			for(int i = 0; i < todoList.size(); i++) {
				if(todoList.get(i).getTitle().equals(title)) {
					System.out.printf("\n*** [수정 되었습니다.] ***\n", i);
					break;
				}
			}
		}
	}
	
	// [6] 할일 삭제하기
	private void deleteTodo() throws IOException {
		System.out.print("\n### Todo Delete ###\n");
		  
		// 삭제할 할 일 제목 입력받기
		System.out.print("삭제할 할 일 인덱스 번호 입력 >>> ");
		int input = Integer.parseInt(br.readLine());
				
		// 제목이 일치하는 회원 모두 조회
		List<Todo> searchList = service.selectIndex(input);
				
		// 제목이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 제목이 일치하는 할 일이 없습니다. ###\n");
			return;
			}
				
		
		// 정말 삭제를 할 것인지 확인 
		System.out.print("정말 삭제 처리 하시겠습니까? (Y/N)");
				
		// 입력받은 문자열을 소문자로 만들어
		// 제일 앞 문자 하나만 반환 받기
		char check = br.readLine().toLowerCase().charAt(0);
			
		if(check == 'n') { // n 입력한 경우
			System.out.print("\n### 삭제 취소 ###\n");
			return;
		}
				
		if(check != 'y') { // 잘못 입력한 경우
			System.out.println("\\n### 잘못 입력 하였습니다. 다시 시도해주세요. ###\\n");
			return;
		}

		
		String result = service.removeMember(input);
				
		System.out.println(result);  
	}
	
	
}
