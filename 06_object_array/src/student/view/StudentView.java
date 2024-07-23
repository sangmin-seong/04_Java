package student.view;

import java.util.Scanner;

import student.dto.StudentDTO;
import student.service.StudentService;

// 콘솔창에 보여지는 용도
// == 클라이언트의 입력/출력을 담당하는 클래스
public class StudentView {

	// 필드
	private Scanner sc = new Scanner(System.in); // 키보드로 입력한 내용을 가져오는 필드 값
	private StudentService service = new StudentService();
	
	
	/**
	 * 메인 메뉴 출력
	 */
	public void mainMenu() {
		
		int input = 0; // 입력받은 메뉴번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X -> 동명이인 없다는 가정
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			
			input = sc.nextInt();
			sc.nextLine(); // 입력버퍼에 남아있는 엔터 제거
			
			System.out.println();
			
			switch(input) {
			case 1 : addStudent(); break;
			
			case 2 : allStudent(); break;
			
			case 3 : selectIndex(); break;
			
			case 4 : selectName(); break;
			
			case 5 : updateIndex(); break;
			
			case 6 : selectScore(); break;
			     	//score(); break;
			
			case 7 : selectMaxMin(); break;
			
			case 0 : System.out.println("*** 프로그램 종료 ***"); break;
			
			default : System.out.println("*** 메뉴 번호 잘못 입력 ***"); break;
			}
			
		}while(input != 0);
		
		
	}
	
	/**
	 * 학생 추가 화면
	 * 
	 * 학번, 이름, 성별을 입력받아
	 * Student 객체로 만들어서
	 * StudentService로 전달
	 * -> 추가 성공 시 true / 실패 시 false 반환 받아 결과 출력
	 */
	private void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(남/여) :");
		char gender = sc.next().charAt(0);
		
		//학생 객체를 생성하여 입력 받은 데이터를 저장(세팅)
		StudentDTO std = new StudentDTO(studentNumber, name, gender);
		
		// StudentService 객체의 addStudent() 호출 후
		// 결과 반환 받기
		
		boolean result = service.addStudent(std);
		
		if(result) {
			System.out.println(name + " 학생이 추가 되었습니다.");
		}else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
	}
	
	
	/**
	 * StudentService에 있는 students 객체 배열을 얻어와
	 * 모든 학생 정보를 출력
	 */
	private void allStudent() {
		
		System.out.println("\n ----- 학생 전체 조회 ----- \n");
		
		// StudentService에 있는 students 객체 배열을 얻어오기
		StudentDTO[] students = service.getStudents();
		
		for(StudentDTO std : students) {//향상된 for문
			
			// null인 경우 == 저장된 학생이 없을때
			// -> NullPointerException 방지
			//    ( 참조 변수가 null을 저장하고 있는데 사용하려고 할 때)
			if(std == null) return;
				
			System.out.println(std.toString());
			System.out.println("-------------------------------");
		}
		
		
	}
	
	/**
	 * 인덱스를 입력받아 service에 전달하여
	 * 해당 인덱스번째 학생 객체 하나(StudentDTO)를 반환받아 출력
	 */
	private void selectIndex(){
		
		System.out.println("\n----- 학생 1명 조회(index) -----\n");
		
		System.out.print("조회할 인덱스를 입력 : ");
		int index = sc.nextInt();
		
		// service 메서드 호출 후 학생 1명 정보 반환받기
		// null || 학생 객체 주소
		StudentDTO std = service.selectIndex(index);
		
		if(std == null) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다 ***");
			return;
		}
		
		System.out.println(index + "번째 학생 정보");
		System.out.println(std.toString());
	}
	
	/**
	 * 이름을 입력받아 service의 students 배열에서
	 * 같은 이름을 가진 학생 객체를 얻어와 출력
	 * -> 이름 검색
	 */
	private void selectName() {
		
		System.out.println("\n----- 학생 이름으로 조회 -----\n");
		
		System.out.print("조회할 학생 이름를 입력 : ");
		String targetName = sc.nextLine();
		
		// 입력받은 이름(targetName)을 서비스로 전달하여
		// 일치하는 이름을 가진 학생객체(주소값) 반환받기
		// -> null || 일치하는 학생 객체(주소값)
		
		StudentDTO std = service.selectName(targetName);
		
		if(std == null) {
			System.out.println("*** 같은 이름의 학생이 존재하지 않습니다 ***");
		}
		
		System.out.println(std.toString());
		
	}
	
	
	/**
	 * 인덱스 번호를 입력받아 일치하는 학생의 
	 * html, css, js, java 점수 수정
	 * 
	 * 단, 입력된 인덱스가 0 미만
	 *     students배열 마지막 인덱스 초과한 경우,
	 *     "인덱스 범위가 올바르지 않습니다"   (1)
	 *     
	 *     정상범위 인덱스 이지만 학생이 존재하지 않는 경우,
	 *     "해당 인덱스에 학생 정보가 존재하지 않습니다" 출력  (2)
	 *     
	 *     정상(3)
	 * @param std : 전달 받은 Student 객체 참조 주소
	 */
	
	private void updateIndex() {
		
		System.out.println("\n----- 학생 점수 수정-----\n");
		
		System.out.print("점수 수정할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		
		// 입력받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생없음
		// 3 == 정상
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다");
			return;
		}
		
		/* 학생이 존재하는 경우 */
		// HTML, CSS, JS, Java 순서로 점수 입력 : 100 40 60 70
		System.out.print("HTML, CSS, JS, Java 순서로 점수 입력 : ");
		
		int html = sc.nextInt();
		int css  = sc.nextInt();
		int js   = sc.nextInt();
		int java = sc.nextInt();
		
		
		// 점수만 담는 용도의 StudentDTO 객체 생성
		StudentDTO scores = new StudentDTO(html, css, js, java);
		
		// 점수 수정 서비스 메서드 호출
		// -> 절대 실패할 일이 없기 때문에 반환 값 없음
		service.updateScores(index, scores);
		
		System.out.println("*** 점수 수정 완료 ***");
	}
	
	/**
	 * 학생 1명(이름) 점수 조회(점수, 합계, 평균)
	 */
	private void score() {
		
		System.out.println("\n----- 학생 1명 점수 조회 -----\n");
		
		System.out.println("조회할 학생의 이름을 입력 : ");
		String targetName = sc.next();
		
		StudentDTO std = service.score(targetName);
		
		if(std == null) {
			System.out.println("*** 이름이 일치하는 학생이 없습니다 ***");
		}
		
		int sum = std.getJava()+std.getCss()+std.getHtml()+ std.getJs();
		
		System.out.printf("Java : %d, css : %d, html : %d, JS : %d , 합계 : %d, 평균 : %.1f",
				std.getJava(), std.getCss(), std.getHtml(), std.getJs(),
				sum , (double)sum/4);
	}
	
	/**
	 * 입력 받은 index번째 학생의 점수, 합계, 평균 출력
	 * 
	 * 단, 정상 index인지 확인
	 * 
	 * ex) 인덱스 입력 : 0
	 * 
	 * 이름 : 짱구
	 * HTML(80) CSS(70) JS(50) Java(90)
	 * 합계 : 290
	 * 평균 : 72.5
	 * --------------------------------------------------
	 */
	private void selectScore() {
		
		System.out.println("\n----- 학생 점수 조회-----\n");
		
		System.out.print("점수 확인할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		
		// 입력받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생없음
		// 3 == 정상
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다");
			return;
		}
		
		// 인덱스 번째 학생 조회
		StudentDTO std = service.selectIndex(index);
		
		System.out.println("-------------------------------------------------");
		System.out.println("이름 : " + std.getName());
		System.out.printf("HTML(%d) CSS(%d) JS(%d) Java(%d)\n",
				std.getHtml(), std.getCss(), std.getJs(), std.getJava());
		//합계
		int sum = std.getJava()+std.getCss()+std.getHtml()+ std.getJs();
		
		System.out.printf("합계 : %d", sum );
		
		//평균
		double aver = sum/4; 
		System.out.printf("평균 : %f ", aver);		
		System.out.println("-------------------------------------------------");
	}
	
	/**
	 * 평균 최고점, 최저점 조회
	 * 
	 * 최고점 : 짱구(85.4)
	 * 최저점 : 맹구(61.5)
	 */
	private void selectMaxMin() {
		
		System.out.println("\n----- 평균 최고점 학생, 최저점 학생 -----\n");

		// service.selectMaxMin() 반환되는 문자열 모양
		//최고점 : 짱구(85.4)
		// 최저점 : 맹구(61.5)
		String result = service.selectMaxMin();
		
		System.out.println(result);
	}
	
	
	
	
	private void testMaxMin() {
		// 테스트 코드
		int[] arr = {50,30,10,70,40};
		
		int max = 0; // 최대값을 저장할 변수
		int min = 0; // 최소값을 저장할 변수
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) { // 맨 처음
				max = arr[i];
				min = arr[i];
				continue;
			}
			
			// 최대 값 비교
			if(max < arr[i]) max = arr[i];

			// 최소 값 비교
			if(min > arr[i]) min = arr[i];
		
		}
		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}
}
