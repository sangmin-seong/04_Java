package condition.ex;

import java.util.Scanner;


/**
 * 조건문 예시 기능용 클래스
 */
public class ConditionEx {
	
	// 필드(field) == 멤버 변수 == 인스턴스 변수(전역 변수)
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 1~ 10 사이 난수가 짝수 인지 홀수 인지
	 */
	public void method1() {
		int ran = (int) (Math.random() * 10 + 1);
		
		if(ran % 2 != 1) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
	}
	
	/**
	 * 나이를 입력 받아
	 * 13세 이하 어린이
	 * 14세 이상 19세 이하 청소년
	 * 20세 이상 성인 구분
	 */
	public void method2() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt(); // 필드 sc이용
		
		String result;
		
		if(age <= 13 ) {
			result = "어린이";
			//System.out.println("어린이");
		}else if(age > 20) {
			result = "성인";
			//System.out.println("성인");
		}else {
			result = "청소년";
			//System.out.println("청소년");
		}
		
		System.out.println(result);
	}
	
	/**
	 * 나이를 입력 받아
	 * 13세 이하 어린이
	 * 14세 이상 19세 이하 청소년
	 * 	- 14 ~ 16 : 청소년(중)
	 * 	- 17 ~ 19 : 청소년(고)
	 * 20세 이상 성인 구분
	 * 
	 * 0이하 또는 100 초과 : 잘못 입력하셨습니다.
	 */
	public void method3() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if(age <= 0 || age >100) {
			result ="잘못 입력하였습니다.";
		}else {
			if(age <= 13) {
				result = "어린이";
			}else if(age <=19) {
				if(age < 17) {
					result = "청소년(중)";
				}else {
					result = "청소년(고)";
					}
			}else {result = "성인";}
		
			System.out.println(result);
		}
	}
	
	
	public void method4() {
		System.out.print("월 입력 :");
		int month = sc.nextInt();
		
		System.out.print("온도 입력 : ");
		int temperature = sc.nextInt();
		
		String season;
		
		if(month == 1 || month == 2 || month == 3 ) {
			season = "겨울";
			if(temperature <= -15) {
				season += "한파 경보";
			}else if(temperature <= -12) {
				season += "한파 주의보";
			}
		}else if(month >= 3 && month <= 5) {
			season = "봄";
		}else if(month >= 6 && month <= 8) { 
			season = "여름";
			if(temperature >= 35) {
				season += "폭염 경보";
			}else if(temperature >= 33) {
				season += "폭염 주의보";
			}
		}else if(month >= 9 && month <= 11) {
			season = "가을";
		}else { season = "해당하는 계절이 없습니다.";}
		
		System.out.println(season);
	}
	
	
	
	
	/**
	 * [switch를 이용한 메서드 호출]
	 */
	public void displayMenu() {
		System.out.println("1. method1()- 난수 홀짝");
		System.out.println("2. method2()- 나이구분 1");
		System.out.println("3. method3()- 나이구분 2");
		System.out.println("4. method4()- if 계절 찾기");
		System.out.println("5. method5()- switch 계절 찾기");
		System.out.println("6. method7()- 삼항연산자 / if 성적 판별기");
		System.out.println("7. method7()- switch 성적 판별기");
		
		System.out.print("번호 선택 >> ");
		int num = sc.nextInt();
		
		System.out.println("--------------------------------------------------------------");
		
		switch(num){
			case 1 : method1(); break;
			
			case 2 : method2(); break;
			
			case 3 : method3(); break;
			
			case 4 : method4(); break;
			
			case 5 : method5(); break;
			
			case 6 : method6(); break;
			
			case 7 : method7(); break;
			
			
			
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
	}
	
	/**
	 * 입력된 달(월) 의 계절 출력하기
	 */
	
	public void method5() {
		System.out.print("달(월) 입력 :");
		int month = sc.nextInt();
		
		String result;
		
		switch(month) {

		// 1) 세로로 작성
		case 3 : result = "봄";  
		case 4 : result = "봄";  
		case 5 : result = "봄"; break;
		
		// 2) 가로로 작성
		case 6 : case 7 : case 8 : result = "여름"; break;  
		
		// 3) case 값, 값, 값 형식
		case 9, 10, 11 : result = "가을"; break;
		
		case 12, 1, 2 : result = "겨울"; break;   
		
		default : result = "잘못 입력하였습니다.";
		}
		System.out.println(result);
	}
	
	
	/**[성적 판별기]
	 * 
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적부여
	 * 
	 * - 중간고사 40%, 기말고사 50%, 과제 10%
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지 	 : F
	 * 
	 * 
	 * [실행화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%)	 : 50
	 * 
	 * 최종점수 : 85점
	 * 성적 : B+
	 */
	public void method6() {
		
		System.out.print("이름 :");
		String name =sc.next();
		
		System.out.print("중간고사 성적 :");
		int mid = sc.nextInt();
		
		System.out.print("기말고사 성적 :");
		int fin = sc.nextInt();
		
		System.out.print("과제 성적 :");
		int task = sc.nextInt();
		
		Double result =((mid * 0.4) + (fin * 0.5) + (task * 0.1));		
		
		String score;
		
		/* [방법 1]
		 * if(result >= 95) {score = "A+"; 
		 * }else if(result >= 90) {score = "A"; 
		 * }else if(result >= 85) {score = "B+"; 
		 * }else if(result >= 80) {score = "B"; 
		 * }else if(result >= 75) {score = "C+"; 
		 * }else if(result >= 70) {score = "C"; 
		 * }else if(result >= 65) {score = "D+"; 
		 * }else if(result >= 60) {score = "D";
		 * }else{score = "F";};
		 * 
		 * 			[방법 2]
		 *			if(sum >= 95) result = "A+";
		 *			else if(sum >= 90) result = "A";
		 *			else if(sum >= 85) result = "B+";
		 *			else if(sum >= 80) result = "B";
		 *			else if(sum >= 75) result = "C+";
		 *			else if(sum >= 70) result = "C";
		 *			else if(sum >= 65) result = "D+";
		 *			else if(sum >= 60) result = "D";
		 *			else  result = "F";	
		 */
	
		 
		
		score = (result >= 95) ? ("A+") : 
					(result>=90? ("A") : 
						(result>=85 ? ("B+"):
							(result>=80?("B"):
								(result>=75?("C+"):
									(result>=70? ("C"):
										(result>=65?("D+"):
											(result>=60? "D":"F")))))));
		
		System.out.println("이름 : " + name);
		System.out.println("중간고사 점수 : " + mid);
		System.out.println("기말고사 점수 : " + fin);
		System.out.println("과제 점수 : " + task);
		System.out.println();
		System.out.println("홍길동의 최종점수 : " + result + "점");
		 
		System.out.println("성적 : " + score);
		
		
		}
	
	public void method7() {
		System.out.print("이름 :");
		String name =sc.next();
		
		System.out.print("중간고사 성적 :");
		int mid = sc.nextInt();
		
		System.out.print("기말고사 성적 :");
		int fin = sc.nextInt();
		
		System.out.print("과제 성적 :");
		int task = sc.nextInt();
		
		Double result = (mid * 0.4) + (fin * 0.5) + (task * 0.1);		
		
		String score;
		// [방법 3]
		// switch () 에 들어갈 수 있는 값 : int or String
		switch((int)(result/5)) {
		case 20,19 : score = "A+"; break;
		case 18 : score = "A"; break;
		case 17 : score = "B+"; break;
		case 16 : score = "B"; break;
		case 15 : score = "C+"; break;
		case 14 : score = "C"; break;
		case 13 : score = "D+"; break;
		case 12 : score = "D"; break;
		default : score = "F"; break;
		}
		
		// [방법 4]
//		switch( (int)result/10 ) {
//		case 10, 9 : score = "A"; break;
//		case 8 : score = "B"; break;
//		case 7 : score = "C"; break;
//		case 6 : score = "D"; break;
//		default : score = "F";
//		}
//		
//		if(result > 60 && result % 10 >= 5)  score += "+";
		
		System.out.println("이름 : " + name);
		System.out.println("중간고사 점수 : " + mid);
		System.out.println("기말고사 점수 : " + fin);
		System.out.println("과제 점수 : " + task);
		System.out.println();
		System.out.println("홍길동의 최종점수 : " + result + "점");
		 
		System.out.println("성적 : " + score);
		
		System.out.printf("%s의 중간고사 점수 : %d점, 기말고사 점수 %d점, 과제점수 : %d점로 %s의 최종점수는 %.1f, 성적은 %s입니다",
							name, mid, fin, task, name, result, score);
		
	}
	
	
	/** [연습 문제]
	 * 국어, 영어, 수학, 사탐, 과탐 점수를 입력 받아
	 * 40점 미만 과목이 있으면 FAIL
	 * 평균이 60점 미만인 경우도 FAIL
	 * 모든 과목 40점 이상, 평균 60점 이상인 경우 PASS
 	 * 
 	 * [출력예시]
 	 * 점수입력(국 영 수 사 과) : 100 50 60 70 80
 	 * 
 	 * 
 	 * 1) 40점 미만 과목이 존재하는 경우
	 * FAIL [40점 미만 과목 : 국어 영어]
	 * 
	 * 
	 * 2) 평균 60점 미만인 경우
	 * FAIL [점수 : 50.4 (평균 미달)]
	 * 
	 * 3) PASS인 경우
	 * PASS [점수 : 83.4 / 100]
	 */
	public void practice() {
		System.out.print("점수 입력(국 영 수 사 과) : ");
		
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int mat = sc.nextInt();
		int soc = sc.nextInt();
		int sci = sc.nextInt();
		
		
		
//		System.out.println(kor);
//		System.out.println(eng);
//		System.out.println(mat);
//		System.out.println(soc);
//		System.out.println(sci);
		
//		if ((kor||eng||mat||soc||sci) <40 || average < 60) {"Fail"
//		}else { "PASS"};
		
		//40점 미만인 과목 검사
		boolean flag = false;
		
		String str = ""; // 빈칸 (자료형 : String, 내용x)
		
		if( kor < 40) {
			flag = true;
			str += "국어 ";
		}
		if( eng < 40) {
			flag = true;
			str += "영어 ";
		}
		if( mat < 40) {
			flag = true;
			str += "수학 ";
		}
		if( soc < 40) {
			flag = true;
			str += "사회 ";
		}
		if( sci < 40) {
			flag = true;
			str += "과학 ";
		}
		
		// 40점 미만 과목이 존재하는 경우
		if(flag) {
			System.out.printf("FAIL [40점 미만 과목 : %s]", str);
			return;
		}
		
		// 평균 (double형 결과를 반환받기 위해 5.0 으로 나눔)
		double average = (kor + eng + mat + soc + sci)/5.0;
		
		if(average < 60.0) {
			System.out.printf("FAIL [점수 : %.1f (평균 미달)]", average);
			return; // early return; (중간에 메서드를 종료)
		}
		System.out.printf("PASS [점수 : %.1f / 100]", average);
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

