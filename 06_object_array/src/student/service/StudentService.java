package student.service;

import java.util.Random;

import student.dto.StudentDTO;
import student.view.StudentView;

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

	
	/**
	 * 전달받은 index가 students 범위 내인지
	 * + 정상 범위라면 해당 index가 학생 객체를 참조하는지 인
	 */
	public int checkIndex(int index) {
		// 입력받은 index가 정상인지 판별
					// 1 == 범위 초과
					// 2 == 학생없음
					// 3 == 정상
		if(index < 0 || index >= students.length) return 1;
			
		if(students[index] == null) return 2;
		
		return 3;
	}
	
	/**
	 * 전달받은 index 번째 학생의 점수 수정
	 * @param index
	 * @param scores
	 */
	public void updateScores(int index, StudentDTO other) {
		
		// 객체 배열 : 객체 참조형 변수를 묶음으로 다루는 것
		
		// students[index] 번째 저장된 주소 얕은 복사
		StudentDTO s = students[index];
		
		s.setHtml(other.getHtml());
		s.setCss(other.getCss());
		s.setJs(other.getJs());
		s.setJava(other.getJava());
		
		return; // 안써도 컴파일러가 추가해줌
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

	
	
	/**
	 * 평균 최대 최소 구하기
	  * @return 
		최고점 : 짱구(85.4)
		최저점 : 맹구(61.5)
	 */
	public String selectMaxMin() {
		
		double maxAverage = 0;
		double minAverage = 0;
		String maxName = null;
		String minName = null;
		
		for(StudentDTO std : students) {
			
			if(std == null) break;
			
			
			int sum = std.getJava() + std.getCss() + std.getHtml() + std.getJs();
			
			double average = sum/4;
	
		
			if(maxAverage == 0) {
				maxAverage = average;
				minAverage = average;
				maxName = std.getName();
				continue;
			}
			
			if(average > maxAverage) { 
				maxAverage = average;
				maxName = std.getName();
			}
			if(average < minAverage) {
				minAverage = average;
				minName = std.getName();
			}
		}
		String result
			= String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)\n",
				maxName, maxAverage, minName, minAverage);
		
		return result;


	}

	
	/*
	 * int[] arr = {50,30,10,70,40};
	 * 
	 * int max = 0; // 최대값을 저장할 변수 int min = 0; // 최소값을 저장할 변수
	 * 
	 * for(int i = 0; i < arr.length; i++) { if(i == 0) { // 맨 처음 max = arr[i]; min
	 * = arr[i]; continue; }
	 * 
	 * // 최대 값 비교 if(max < arr[i]) max = arr[i];
	 * 
	 * // 최소 값 비교 if(min > arr[i]) min = arr[i];
	 * 
	 * } System.out.println("max : " + max); System.out.println("min : " + min);
	 */
	

	
	
	
	
	
	
	 
}
