package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.dto.MemberDTO;
import list.service.MemberService;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n****** 회원관리 프로그램 ******\n");
			
			System.out.println("1. 전체 조회"); 
			System.out.println("2. 회원 ID로 조회"); 
			System.out.println("3. 회원 이름으로 조회(포함)"); 
			System.out.println("4. "); 
			System.out.println("5. "); 
			
			System.out.println("6. "); 
			System.out.println("7. "); 
			System.out.println("8. "); 
			
			System.out.println("0. 종료");
			
			System.out.println();
			System.out.print("메뉴선택 >> ");
			input = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(input) {
			case 1 : selectAll(); break;
			case 2 :  break;
			case 3 :  break;
			case 4 :  break;
			case 5 :  break;
			
			case 6 :  break;
			case 7 :  break;
			case 8 :  break;
			
			case 0 : System.out.println("*** 프로그램 종료 ***"); break;
			default : System.out.println("=-=-=잘못 입력=-=-=");
			}
			
		}while(input != 0);
		
	}// mainMenu 메서드 끝!
	
	public void selectAll() {

		List<MemberDTO> memberList = service.selectAll();
		
		for(int i = 0; i < memberList.size(); i++) {
			System.out.println(i + "번" + memberList.get(i));
		}
	}
	
}
