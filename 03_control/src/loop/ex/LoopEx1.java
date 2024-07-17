package loop.ex;

import java.util.Scanner;

public class LoopEx1 {
	//필드(전역 변수 선언)
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1부터 10까지 출력하기
	 */
	public void method1() {
		
		// Java는 초기식 변수 선언 시 let X -> Java 자료형 사용
		for(int i = 1; i < 11; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * 첫 번째 입력받은 수부터
	 * 두 번째 입력 받은 수 이하 까지
	 * 세 번째 입력 받은 수 만큼 증가하며 출력하기
	 */
	public void method2() {
		System.out.print("시작 끝 증가값 : ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		int value = sc.nextInt();
		
		for(int i = start; i <= end; i += value) {
			System.out.println(i);
		}
	}
	
	/**
	 * 두 수를 입력받아
	 * 작은 수부터 큰 수 이하 까지 1씩 증가 하며 반복
	 */
	public void method3() {
		System.out.print("숫자 2개 입력 :");
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A > B) {
			for (int i = B; i <= A; i++) {
				System.out.println(i);}
				}else {
					for (int i = A; i <= B; i++){
					System.out.println(i);
					}
				}
		System.out.println("-------------------------------------------------------------");
		
		// 추가 변수를 이용한 시작, 종료 값 지정하기
		
		int start = A;
		int end = B;
		
		if(A > B) { // 시작이 끝보다 큰 경우
			start = B;
			end   = A;
		}
		for (int i = start; i <= end; i++) {
			System.out.println(i);
			}
		
		System.out.println("-----------------------------------------------------------------");
		// a에는 작은 값, b에는 큰 값 저장하게 만들기
		if(A > B) { // A가 B보다 큰 경우 A <-> B 값 변경
			int temp = A; // A 값 임시보관
			A = B;
			B = temp;
		}
		
		for (int i = A; i <= B; i++) {
			System.out.println(i);
		}
		System.out.println("-----------------------------------------------------------------");
		
		// 자바에서 제공하는 기능(메서드) 이용
		int min = Math.min(A,B); // A, B중 작은 값
		int max = Math.max(A,B); // A, B중 큰 값
		
		for(int i = min; i <= max; i++) {
			System.out.println(i);
		}
	}
	
	
	/**
	 * 1부터 100 사이에 정수 중 5의 배수 합, 개수 구하기
	 */
	public void method4() {
		int sum = 0;
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			
			if( i % 5 == 0 ) {//5의 배수인 경우
				sum += i; // sum에 5의 배수 누적(5의 배수 합계)
				count++; // count 1씩 증가(5의 배수 카운트)
			}
		}
		System.out.printf("합계 : %d / 개수 : %d", sum, count);
	}
	
	/**
	 * 구구단 3단 출력하기
	 */
	public void method5() {
//		System.out.print("숫자 입력 : ");
//		int dan = sc.nextInt();
		for(int i = 1; i <=9; i++ ) {
			System.out.printf("3 X %d = %d \n", i, (3*i));
		}
	}
	/**
	 * 입력 받은 구구단 출력하기
	 * 단, 입력 받은 단이 2 ~9 사이 숫자가 아니면
	 * "잘못 입력하셨습니다" 출력
	 */
	public void method6() {
		
		System.out.print("단 : ");
		int dan = sc.nextInt();
		
		
		if(dan > 9 || dan < 2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		for(int i = 1; i <=9; i++ ) {
			System.out.printf("%d X %d = %d \n", dan, i, (dan*i));
		}
		
		System.out.println("-------------------------------------------------");
		
		for(int num = dan ; num <= 9; num++) {
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d \n", num, i, (num*i));
			}
		}
		
	}
	
	/**
	 * while문 기본작성
	 */
	public void method7() {
		int num = 1;
		
		// while(조건식) -> 조건식이 true인 경우에 반복 수행
		while(num<= 10) {
			System.out.print(num+ " ");
			num++;
		}
	}
	
	//for((초기식; 조건식; 증감식)
	// -> 지정된 횟수 만큼 반복
	
	//while(조건식) 
	//-> 조건식이 false가 될 때 까지 반복
	//   == 몇회 반복인지 모르겠지만 끝날때 까지 반복하겠다
	
	/**
	 * 입력 받은 구구단 출력하기 version.2
	 * 단, 입력 받은 단이 2 ~9 사이 숫자가 아니면
	 * "잘못 입력하셨습니다" 출력 후
	 * 다시 단 입력받기
	 */
	public void method8() {
		
		int dan;
		
		while(true) {// 무한 반복
			System.out.print("단 : ");
			dan = sc.nextInt();
			
		
			if(dan >= 2 && dan <= 9) {//2~9사이
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		
			for(int i = 1; i <=9; i++ ) {
				System.out.printf("%d X %d = %d \n", dan, i, (dan * i));
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

