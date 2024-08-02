package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	
	// 필드 생성
	private TodoListService service = null;
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
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
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
				case 1 : ListFull();  break;
				case 2 :   break;
				case 3 :   break;
				case 4 :   break;
				case 5 :   break;
				case 6 :   break;
				case 0 :   break;
				default :  ;
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

	private void ListFull() {
		System.out.println("\n=== Todo List Full View ===\n");
		
		List<Todo> TodoList = service.getTodoList();
		
	}
}
