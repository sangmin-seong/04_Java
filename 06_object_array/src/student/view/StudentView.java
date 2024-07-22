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
			
			case 5 : updateInform(); break;
			
			case 6 : score(); break;
			
			case 7 : averageMM(); break;
			
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
	 * 학생 정보 수정(인덱스) 메서드
	 * @param std : 전달 받은 Student 객체 참조 주소
	 */
	
	private void updateInform() {
		
		System.out.println("\n----- 학생 정보 수정-----\n");
		
		System.out.print("정보 수정할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		StudentDTO std = service.updateInform(index);
		
		if(std == null) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다 ***");
		}
		
		System.out.println(std.toString());
		
		System.out.print("--- 해당 인덱스의 학생 정보를 수정하시겠습니까? (y/n)");
		
		// String.toUpperCase()  -> 대문자 변환
		// String.toLowerCase()  -> 소문자 변환
		char check = sc.next().toLowerCase().charAt(0);
		
		if(check == 'n') {// 'n'이 입력된 경우
			System.out.println("=== 정보 수정 취소됨===");
			return;
		}
		
		//'y'가 입력되었을 때
		System.out.println("이름 : ");
		String newName = sc.next();
		
		System.out.println("학번 : ");
		String newStudentNumber = sc.next();
		
		System.out.println("성별(남/여) : ");
		char newGender = sc.next().charAt(0); 
		
		std.setName(newName);// 새로운 이름을 std가 참조하는 객체에 세팅
		std.setStudentNumber(newStudentNumber);
		std.setGender(newGender);
		
		System.out.println("=== 학생 정보 수정 완료===");
		
	}
	
	/**
	 * 학생 1명(이름, 인덱스) 점수 조회(점수, 합계, 평균)
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
	 * 평균 최고점, 최저점 학생
	 */
	private void averageMM() {
		
		System.out.println("\n----- 평균 최고점 학생, 최저점 학생 -----\n");
		
		StudentDTD std = service.average();
	}
}
