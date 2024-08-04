package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		// 조회할 할일 목록이 없을 경우
		
		if(TodoList.isEmpty()) {
			System.out.println("\n### 할일 목록이 존재하지 않습니다. ###\n");
			return;
		}
		
		for(Todo todo : TodoList) {
			System.out.printf("%s %s %s",
					todo.getTitle(), todo.getDetail(), todo.getRegDate());
		}
	}
	
	
	// [2] 자세히 보기
	private void detailView() throws IOException {
		System.out.println("\n=== TodoList detail view ===\n");
		
		// 과제명으로 검색하기
		System.out.println("조회할 할일 제목 입력 >>>>");
		String searchTitle = br.readLine();
		
		// 목록에서 이름으로 검샐 후 결과 반환
		List<Todo> searchList = service.selectTitle(searchTitle);
		
		// 검색결과가 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 검색 결과가 없습니다 ###\n");
			return;
		}
		
		// 검색결과 있을 경우
		for(Todo todo : searchList) {
			System.out.println(todo);
		}
	}
	
	
	// [3] 할일 목록 추가
	private void addTodo() throws IOException {
		System.out.println("\n=== Todo Add ===\n");
		
		System.out.println("제목 : ");
		String title = br.readLine();
		
		System.out.println("상세내용 : ");
		String detail = br.readLine();
		
		// 제목, 상세내용으로 할일 목록 추가 후 결과 반환받기
		boolean result = service.addTodoList(title, detail);
		
		if(result) {
			System.out.println("\n*** 목록에 추가되었습니다. ***\n");
		}
	}
	
	// [4] 할일 완료 여부
	private void completeTodo() throws IOException {
		System.out.println("\n=== Todo Complete ===\n");
		
		System.out.print("완료여부 수정할 할 일 이름 입력 >>>>>");
		String targetTitle = br.readLine();
		
		List<Todo> searchList = service.selectTitle(targetTitle);
		
		if(searchList.isEmpty()) {
			System.out.println("\n### 일치하는 할 일이 없습니다. ###\n");
			return;
		}
		
		Todo target = null;
		
		// 동일한 제목이 있을 경우
		if(searchList.size()>1) {
			System.out.println("\n### 할 일을 선택해주세요. ###\n");
			
			for(int i=0; i<searchList.size();i++) {
				
				System.out.printf("%d) %s %s \n",
						i+1, searchList.get(i).getTitle(), searchList.get(i).getDetail() );
			}
			
			System.out.println("선택할 할 일 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine());
			
			
			if(input >= searchList.size() || input < 0) {
				System.out.println("\n## 없는 할 일 번호입니다. 다시 시도해주세요. ###\n");
				return;
				
			}
			target = searchList.get(input);
			
		}else {
			target = searchList.get(0);
		}
		System.out.println("완료한 경우 '완료'를 입력 해주세요");
		String complete = br.readLine();
		
		// 할 일, 완료여부를 서비스로 전단
		// - 완료여부 변경
		// 파일에 데이터로 저장
		
		String result = service.completeTodo(target, complete);
		
		System.out.println(result);
		
		
	}
	
	// [5] 할일 목록 수정하기
	private void updateTodo() throws IOException {
		System.out.println("\n=== Todo Update ===\n");
		
		System.out.print("수정할 할 일 이름 입력 >>>>>");
		String targetTitle = br.readLine();
		
		List<Todo> searchList = service.selectTitle(targetTitle);
		
		if(searchList.isEmpty()) {
			System.out.println("\n### 일치하는 할 일이 없습니다. ###\n");
			return;
		}
		
		Todo target = null;
		
		// 동일한 제목이 있을 경우
		if(searchList.size()>1) {
			System.out.println("\n### 할 일을 선택해주세요. ###\n");
			
			for(int i=0; i<searchList.size();i++) {
				
				System.out.printf("%d) %s %s \n",
						i+1, searchList.get(i).getTitle(), searchList.get(i).getDetail() );
			}
			
			System.out.println("선택할 할 일 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine());
			
			
			if(input >= searchList.size() || input < 0) {
				System.out.println("\n## 없는 할 일 번호입니다. 다시 시도해주세요. ###\n");
				return;
				
			}
			target = searchList.get(input);
			
		}else {
			target = searchList.get(0);
		}
		
		// 수정할 상세 내용 입력
		System.out.print("수정할 내용을 입력하세요.");
		
		String detail = br.readLine();
		
		String result = service.updateDetail(target, detail);
		
		System.out.println(result);
	}
	
	// [6] 할일 삭제하기
	private void deleteTodo() throws IOException {
		System.out.print("\n### Todo Delete ###\n");
		  
		// 삭제할 할 일 제목 입력받기
		System.out.print("삭제할 할 일 제목 입력 >>> ");
		String targetName = br.readLine();
				
		// 제목이 일치하는 회원 모두 조회
		List<Todo> searchList = service.selectTitle(targetName);
				
		// 제목이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 제목이 일치하는 할 일이 없습니다. ###\n");
			return;
			}
				
		// 삭제할 할일 제목만 참조할 Member 참조 변수 선언
		Todo target = null;
		
		if(searchList.size() > 1) {
			System.out.println("\n*** 삭제할 제목을 선택해주세요 ***\n");
			
			for(int i = 0; i < searchList.size(); i++) {
				System.out.printf("%d) %s (%s)\n",
									i+1,
									searchList.get(i).getTitle(),
									searchList.get(i).getDetail());
			}
					
			System.out.print("삭제할 할 일의 번호를 입력 : ");
					
			int input = Integer.parseInt(br.readLine()) -1;
			
			if(input >= searchList.size() || input < 0) {
				System.out.println("\n### 없는 할 일 번호 입니다. 다시 시도해주세요. ###\n");
				return;				
			}
			
			target = searchList.get(input);
			
		}else {
			target =searchList.get(0);
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
				
		// y 입력한 경우		
		// 삭제 서비스 호출 후 결과 문자열 반환 받기
		String result = service.removeMember(target);
				
		System.out.println(result);  
	}
	
	
}
