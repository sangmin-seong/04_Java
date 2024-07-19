package practice;

import java.util.Scanner;

public class ArrayPractice {
	Scanner sc = new Scanner(System.in);
	
	
	
	
	 public void practice1(){
		 //길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		 //순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 //짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		 int[] arr = new int[9]; // 배열 선언/할당
		 
		 // 배열 요소 초기화
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = i + 1;
		 }

		 // 출력 및 합계
		 int sum = 0;
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i] + " ");
			 
			 if(i % 2 == 0) { // 짝수번째 인덱스 합 
				sum += arr[i];
			 }
			
		 }
		 System.out.println("\n짝수번째 인덱스 합 : " + sum);
	 }
	 
	 
	 public void practice2() {
	 //길이가 9인 배열을 선언 및 할당하고,
	 //9부터 1까지의 값을 반복문을 이용하여
	 //순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	 //홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		 int[] arr = new int[9]; // 길이가 9인 배열선언 / 할당
		 
		 for(int i =0; i < arr.length; i++) { // 반복문 이용, 배열 요소 초기화
			 arr[i] = arr.length- i;
		 }
		 
		 int sum = 0;
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i] + " ");
			 
			 if(i % 2 == 1) {
				 sum += arr[i];
			 }
		 }
		 System.out.println("\n 홀수번째 인덱스 합 : "+ sum);
	 }	 
	 
	public void practice3(){
	 //사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
	 //1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		
		System.out.println("숫자입력 :"); // 사용자 숫자입력
		int len = sc.nextInt();
		
		int[] arr = new int[len]; // 사용자 숫자 입력 만큼 배열 길이 할당
		
		for(int i = 0; i < arr.length; i++) { // 배열 초기화
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public void practice4(){
	//정수 5개를 입력 받아 배열을 초기화 하고
	//검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
	//배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		
		int[] arr = new int[5]; // 길이 5인 배열 선언
		
		System.out.println("입력 0 : "); // 정수 5개 입력 시 저장할 변수 선언
		int num1 = sc.nextInt();
		System.out.println("입력 1 : "); // 정수 5개 입력 시 저장할 변수 선언
		int num2 = sc.nextInt();
		System.out.println("입력 2 : "); // 정수 5개 입력 시 저장할 변수 선언
		int num3 = sc.nextInt();
		System.out.println("입력 3 : "); // 정수 5개 입력 시 저장할 변수 선언
		int num4 = sc.nextInt();
		System.out.println("입력 4 : "); // 정수 5개 입력 시 저장할 변수 선언
		int num5 = sc.nextInt();
		
		for(int i = 0; i < arr.length; i++) { // 입력 받은 정수로 배열 초기화
			arr[i] = num1 + i;
			System.out.print(arr[i] + "");
		}
		
		System.out.print("\n찾을 숫자 입력 : ");
		int search = sc.nextInt();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != search) {
				System.out.println("일치하는 값이 존재하지 않습니다.");
				return;
			}else {
				System.out.println("인덱스 :" + i);
				return;
			}
		}
		
	}
	 
	 
	
	public void practice5(){
	//사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
	//배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
	//그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		System.out.println("정수 : ");
		int len = sc.nextInt(); // 배열 길이 입력
		
		int[] arr = new int[len]; // 배열 길이 값 만큼의 배열 선언 / 할당
		
		
		for(int i = 0; i < len; i++) {
			System.out.printf("배열 %d 번째 인덱스에 넣을 값 :  ", i);
			int num = sc.nextInt();
			
			arr[i] = num;
			
		}
		int sum = 0;

		for( int i = 0; i < len; i++) {
			sum += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n인덱스 총 합 : " + sum);
		
		
	}
	
	
	
	public void practice6(){
	//주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
	//단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
		char[] arr = new char[14];
		
		System.out.println("주민등록번호(-포함) : "); // 주민번호 입력
		String str = sc.next();
		
		
		for(char i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			
			if(i > 7)  arr[i] = '*'; 
			
		}
		System.out.println(arr);
	}
	
	public void practice7(){
		// 3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		// 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		// 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
		// 다시 정수를 받도록 하세요.
				
		
			
		
			

			
	}
		
		
	
	
	
	
	
	public void practice8(){
	//10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
	//1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		
	}
	 
}
