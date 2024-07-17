package loop.ex;

import java.util.Scanner;

public class LoopEx2 {
	//필드(전역 변수 비슷)
	Scanner sc = new Scanner(System.in);
	
	
	/** 이중 for문
	 *  다음 모양 출력하기
	 *  1234
	 *  1234
	 *  1234
	 */
	public void method1() {
		
		for(int i = 0; i < 3; i ++ ) {
			
			for (int num = 1; num <= 4; num++) {
				System.out.print(num);
			}
			System.out.println(); //한 행이 끝나면 줄 바꿈	
		}
	}
	
	/** 이중 for문
	 *  다음 모양 출력하기
	 *  54321
	 *  54321
	 *  54321
	 *  54321
	 *  
	 */
	public void method2() {
		
		for (int i = 1; i <=4; i++) {
			for (int num = 5; num > 0; num--) {
				System.out.print(num);
			}
			System.out.println();
		}
	}

	/** 
	 * 행, 열, 정방향(0) /역방향(1)
	 * 
	 * 행 입력 : 3
	 * 열 입력 : 6
	 * 정방향(1) /역방향(-1) : 1
	 * 
	 * 123456
	 * 123456
	 * 123456
	 */
	public void method3() {
		
		System.out.println("행 입력 : ");
		int row = sc.nextInt();
		
		System.out.println("열 입력 : ");
		int col = sc.nextInt();
		
		System.out.println("정방향(1) /역방향(-1) : ");
		int direction = sc.nextInt();
		
		
		
			for (int i = 1; i <= row; i++) {
				if(direction > 0) {
					for (int y = 1; y <= col; y++) {
						System.out.print(y);
					}
				}else {	
					for(int y = col; y > 0; y--) {
						System.out.print(y);
						}
					}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------");
			
			int start = 1;
			int end = col;
					
			if(direction == -1) { // 역방향
				start = col;
				end = 1;
			}
			
//			for (int q = 1; q <= row; q++) {
//				for (int y = start; y <= end; y+=direction) {
//					System.out.print(y);
//				}
//				System.out.println();
//			}
			System.out.println("-----------------------------------------------------");
			
			
			for (int x = 1; x <= row; x++) {
				
				for (int y = start; ; y += direction) {
					
					if(direction == 1 && y <= end) {
						System.out.print(y);
						continue;
					}
					
					if(direction == -1 && y >= end) {
						System.out.print(y);
						continue;
					}
					break;
				}
				
				System.out.println();
			}
		}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 */
	public void method4() {
		for(int row = 0; row <= 2; row++) {
			for(int col = 0; col <= 2; col++) {
				System.out.printf("(%s,%s) ", row, col);
			}
			System.out.println();
		}
		
	}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) 
	 * (1,0) (1,1) 
	 * (2,0) (2,1) (2,2)
	 */
	public void method5() {
		for(int row = 0; row <= 2; row++) {
			for(int col = 0; col <= 2; col++) {
				if(row >= col) {
				System.out.printf("(%s,%s) ", row, col);
				}
			}
			System.out.println();
		}
		
	}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) 
	 * (2,0) 
	 */
	public void method6() {
		for(int row = 0; row <= 2; row++) {
			
			for(int col = 0; col <= (2 -row); col++) {
				
				System.out.printf("(%s,%s)", row, col);
				
				}
			System.out.println();
			}
		}
	
	
	/**[do ~ while]
	 * - 최소 1회 이상 반복하는 while문
	 */
	public void method7() {
		
		int num = 10;
		
		 do{
			System.out.println("반복 출력");
			
		} while(num < 10);
		 
		System.out.println("------- 종료 --------");
	}
	
	/**
	 * 0 이 입력 될때까지 입력된 모든 수의 합
	 */
	public void method8() {
		
		int input = 0; // 숫자 입력 변수
		int sum = 0; // 합계 저장 변수
		
		 do{
			System.out.println("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		 }while(input != 0);
		 
		 System.out.println(sum);
		
	}
	
	
	

































}
