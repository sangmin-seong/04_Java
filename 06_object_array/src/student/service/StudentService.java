package student.service;

import java.util.Random;

import student.dto.StudentDTO;
import student.view.StudentDTD;

// 기능 제공용 클래스
// 비즈니스 로직 == 업무 기능
public class StudentService {
	
	// StudentDTO 객체를 참조하는 
	// StudentDTO 참조 변수 5개 묶음 배열을 생성
	// 인덱스 0 ~ 4
	// 각 인덱스 요소 : 초기값 null  
	
	private StudentDTO[] students = new StudentDTO[5];
	
	/*기본 생성자*/
	 public StudentService() {
		 
		// 학생 객체 배열(students)에 샘플 학생 3명 추가
			
			
			//students[0] : StudentDTO 자료형 참조 변수
			
			students[0] = new StudentDTO("24001", "짱구" ,'남');
			students[1] = new StudentDTO("24002", "유리" ,'여');
			students[2] = new StudentDTO("24003", "맹구" ,'남');
			
			// students[3] / [4] == null
			
			// 0 ~ 100 사이 난수 발생
			// 1) Math.floor(Math.random() * 101) == 0 ~ 100;
			
			// 2) Random random = new Random()
			//    random.nextInt(101); == 0 ~ 100
			
			
			Random random = new Random();
			for( StudentDTO std : students ) { // 향상된 for문
 				
				// 현재 접근한 요소가 참조하는 객체가 없다면
				// 반복 종료
				if(std == null) break;
				
				// random.nextInt(101) : 0 이상 101 미만 정수형 난수
				std.setHtml(random.nextInt(101));
				std.setCss(random.nextInt(101));
				std.setJs(random.nextInt(101));
				std.setJava(random.nextInt(101));
			}
					
			
	 }
	 
	 /**
	  * 학생 객체 배열 Students 중 비어있는 인덱스에
	  * 전달받은 학생 객체(std) 추가 
	  * @param std : 입력받은 값을 저장한 학생 객체 주소
	  * @return true : 추가 성공 / false : 추가 실패
	  *  - 실패 조건 : Students 배열에 꽉 차있는데 추가 학생이 전달된 경우
	  */
	 public boolean addStudent(StudentDTO std) {
		 
		 // 0번 인덱스 부터 순서대로 비어있는(null) 요소를 찾아
		 // 전달받은 std를 대입하는 코드
		
		 for ( int i = 0; i < students.length; i++) {
			 if(students[i] == null) { // i번째 요소가 비어있는 경우
				 students[i] = std;
				 return true;
			 }
		 }
		 
		 // 비어있는(null) 요소가 없을 경우 false 반환
		 return false;
	 }

	/**
	 * students 객체 배열에 저장된 주소를 얻어가게 하는 메서드
	 * @return : students 객체 배열에 저장된 주소
	 */
	public StudentDTO[] getStudents() {
		return students;
	}

	
	/**
	 * 학생 1명 정보 조회(index 검색)
	 * @param index
	 * @return : 조회된 학생 객체 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		
		// 전달 받은 index 범위가 students의 인덱스 범위 밖인 경우
		if(index < 0 || index >= students.length) {
			return null;
		}
		
		return students[index];
	}

	
	/**
	 * 전달받은 이름(targetName)과 이름이 일치하는 학생 객체 반환
	 * @param targetName
	 * @return : null || 일치하는 학생 객체(주소값)
	 */
	public StudentDTO selectName(String targetName) {

		for(StudentDTO std : students) {// 향상된 for문
			
			// 저장된 학생이 없을 경우, 뒤에도 없을 것!!!, 그냥 여기서 종료
			if( std == null ) return null;
			
			// == : 기본 자료형 비교
			// A.equals(B) : 참조형(객체) 비교
			if( std.getName().equals(targetName) ) {
				return std;
			}
		}
		
		return null;
	}

	public StudentDTO updateInform(int index) {
		
		if( index < 0 || index >= students.length ) {
			return null;
		}
		
		return students[index];
	}

	public StudentDTO score(String targetName) {
		for(StudentDTO std : students) {
			
			if( std == null) return null;
			
			if( std.getName().equals(targetName) ) {
				return std;
			}
		}
		return null;
	}

	public StudentDTD average() {
		
		return null;
	}
	
	
	
	
	
	 
}
