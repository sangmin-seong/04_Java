package ex;
/* 자바 코드 실행 방법
 * 1) 위에 Run 버튼 (>)
 * 2) ctrl + F11
 * 
 * System.out.println()
 * -sysout -> ctrl + space -> enter
 * */

public class VariableEx1 {
	
	/** [main method]
	 * <p> 
	 *  자바 프로그램을 실행 시키기 위한 구문(기능)
	 * </p>
	 *	
	 * */
	public static void main(String[] args) {
		
		// 변수 : 메모리에 값을 저장하는 공간
		//		  변수에 저장된 값은 바꿀 수 있음
		
		/* 자료형 (Data Type)
		 * - 변수에 저장되는 값의 종류/크기	
		 *
		 * [Java 기본 자료형 8가지]
		 * 
		 * -논리형-
		 * boolean (1byte) - true / false
		 * 
		 * -정수형-
		 * byte     (1btye) 
		 * short    (2btye)
		 * int	    (4btye) - 정수 기본형(숫자를 기입하면 기본으로 적용되는 형태)
		 * long	 	(8btye) - 숫자 뒤에 l 또는 L 붙임(123L)
		 * 
		 * -실수형-
		 * float    (4byte) - 숫자 뒤에 f 또는 F(3.14f)
		 * double   (8byte) - 실수 기본형
		 * 
		 * -문자형-
		 * char     (2byte) - 문자하나를 의미, 'A'형식으로 작성
		 * String	참조형  - "abc" 형식으로 작성
		 * */
		
		// 변수 선언 : 메모리에 값을 저장할 공간을 만듦(== 할당)
		
		int num1; // 메모리에 int형 데이터(정수)를 저장하기 위한 공간
				  // 4byte를 할당하고 변수이름을 num1이라고 지정 
		
		// 자바는 초기화(처음값 대입) 되지 않은 지역변수를 출력, 연산할 수 없다!!!!
		// 대입연산만 가능
		
		// 
		// System.out.println(num1);
		
		// 변수에 값 대입
		num1 = 2000;
		System.out.println(num1); // 값이 대입되면 오류 X
		
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("[자료형별 리터럴 작성법]");
		
		// 논리형(1byte)
		boolean isTrue = true;
		boolean isFalse = false;
		
		System.out.println("isTrue : " + isTrue);
		System.out.println("isFalse : " + isFalse);
		
		// JS에서는 true == 1 비교 가능하지만 Java는 안됨!
		// 왜? 자료형이 같지 않아서 비교불가
		// System.out.println(true == 1);
		
		// [정수형]
		int intNum = 2147483647;
		
		// int 범위 초과 대입 -> 오류발생
		// The ineral 2147836418 of type int is out of range
		// int intNum = 2147483648; // int 최대값 + 1
		
		// long longNum = 2147483648; // 일반 정수값 == int(기본형)
		long longNum = 2147483648L; // 뒤에 L == long 표기
		
		System.out.println("intNum : " + intNum);
		System.out.println("longNum : " + longNum);
		// longNum 뒤에 L 안붙어서 출력됨
		// -> 코드에만 리터럴 표기법 작성 / 출력 시 미표기
		
		// [실수형]
		float floatNum = 1.23f; // 뒤에 f == float 자료형  
		// float floatNum = 1.23;  
		// Type mismatch: cannot convert from double to float
		// -> float 변수에 double 값을 저장할 수 없다
		
		// 왜? 실수 기본형 double
		// (1.23 처럼 보통 실수 표기법이 double로 인식됨)
		
		double doubleNum = 3.14;
		
		System.out.println("floatNum : "+ floatNum);
		System.out.println("doubleNum : " + doubleNum);
		
		// [문자형]
		
		char ch1 = 'A'; // 2byte
		char ch2 = '가'; 
		char ch3 = '♥';
		char ch4 = '棟';

		//char ch5 = 'ab'; // 두개 안됨
		//char ch6 = "A"; // 쌍따옴표 안됨
		
		System.out.println("ch1 : " + ch1);
		System.out.println("ch2 : " + ch2);
		System.out.println("ch3 : " + ch3);
		System.out.println("ch4 : " + ch4);
		
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("[float와 double의 차이점]");
		
		/* float 	(4byte), double	(8byte)
		 * byte 크기가 2배라서 double이 아님!!!
		 * 
		 * 정확도가 2배 == 소수점 표현 자릿수가 2배라서 double!!!!
		 * 
		 * 
		 * */
		
		// 소수점 아래 19자리
		float test1 = 1.1234567890123456789f;
		double test2 = 1.1234567890123456789;
		
		System.out.println(test1); //1.1234568 float == 7~8자리
		System.out.println(test2); //1.1234567890123457 double ==  15~16자리	
		
		
		// ================================================================================================
		
		/* String(문자열)
		 * - 기본 자료형 (8가지)에 포함되지 않음
		 * 
		 * - 기본 자료형 O : 변수에 직접 값을 저장
		 * 
		 * - 기본 자료형 X : 변수에 값의 위치(주소) 를 저장
		 * 	 == 참조형
		 * */
		
		String str = "문자열 리터럴 표기법은 쌍따옴표";
		String str2 = "String은 주소를 저장하고 찾아가는 참조형";
		
		System.out.println(str);
		System.out.println(str2);
	}
	
}
