package ex;

//java.util.Scanner 클래스 가져오기
import java.util.Scanner; 

public class ScannerEx2 {

	public static void main(String[] args) {
		
		// 스캐너 객체 생성구문
		Scanner sc = new Scanner(System.in);
		
		// 홍길동은 20세, 키 212.5cm의 남성입니다.
		// 자기소개 : 농구 잘할 수 있습니다.
		
		System.out.print("이름 입력 :");
	    String name = sc.next(); // 문자열 입력(띄어쓰기X)
	    
	    System.out.print("나이 입력 :");
	    int age = sc.nextInt();
	    
	    System.out.print("키 입력(cm) : ");
	    double height = sc.nextDouble();
	    
	    
	    
	    
	    System.out.print("성별 입력(남/여) :");
	    char gender = sc.next().charAt(0);
	    
	     /* Scanner는 char를 제외한 
	      * 기본 자료형 7가지를 입력받는 기능을 제공
	     * 
	     * + 문자열 입력방법 2개 제공
	     * (next(), nextLine())
	     * 
	     * * 문자열.charAt(index)
	     * -> 문자열에서 index번째 문자하나를 char형태로 반환
	     * 
	     * "남".charAt(0) -> '남' (char)
	     */
	    
	    
	    System.out.println("자기소개 :");
	    sc.nextLine(); 	//버퍼에 남아있는 개행문자(== 엔터) 제거
	    				// 자세한 설명은 class아래 확인
	    String introduce = sc.nextLine();
	    
		// 홍길동은 20세, 키 212.5cm의 남성입니다.
	    // \n == 줄바꿈(개행) 문자
	    System.out.printf("%s는 %d세, 키%.1fcm의 %c성입니다.\n ",
	    		name, age, height, gender);
	    
	    // 자기소개 : 농구 잘할 수 있습니다.
	    System.out.println("자기소개 : " + introduce);

	}

}

/* [Scanner가 키보드 입력을 받아오는 원리]
 * 
 * ex) int num = sc.nextInt();
 * 
 * 키보드 입력 -> 입력 버퍼 -> sc.next자료형() 구문 위치
 *
 * - nextLine()을 제외한 next관련 구문들은
 * 	 입력버퍼에 저장된 값 중 해당 자료형 갑을 앞에서부터 읽어옴
 * 	 단, 제일 앞에 [enter] 있으면 "제거" 후 그다음부터 읽음
 * 
 * - nextLine() : 
 * 	 nextLine()은 입력버퍼에서 다음 [엔터]까지
 * 	 존재하는 모든 내용을 읽어옴
 * 
 * 	*** 문제 상황 ***
 * 	int num = sc.nextInt();
 * 	String str = sc.nextLine();
 * 
 * - nextInt() 입력 후 버퍼에 엔터가 남아있어서
 * 	 다음 nextLine()이 남아 있는 [엔터]를 읽어오고 동작종료
 * 
 *  * 해결방법
 *  	-> 중간에 nextLine() 구문을 추가하여 남아있는 [엔터]를 꺼내가서 없애라
 *  
 *  	int num = sc.nextInt();
 *  	sc.nextLine(); // 입력 버퍼에 남아있는 [엔터] 제거
 * 		String str = sc.nextLine();
*/