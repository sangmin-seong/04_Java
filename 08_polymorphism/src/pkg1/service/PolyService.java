package pkg1.service;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class PolyService {
	
	
	/** [ 매개 변수의 다형성 ]
	 * 
	 * 
	 * 
	 * 객체가 가지고 있는 필드 정보 출력
	 * @param obj : Object 객체를 참조하는 참조 변수
	 *    - Object -> 모든 클래스의 최상위 부모!!!
	 */
	public void printObject(Object obj) {
		
		// Object obj가 참조할 수 있는 객체
				// -> Object / Parent / Child
				// -> 왜?? 다형성 - 업 캐스팅 때문에 참조 가능
		
		System.out.println("----------------------------------");
		
		 // 전달받은 주소의 객체가 Child 객체인 경우
		if(obj instanceof Child) {
			System.out.println("[Child]");
			
			Child ch = (Child)obj; // obj 다운 캐스팅
			
			// 김 / 50000 / 소나타
			System.out.printf("%s / %s / %s \n", 
					ch.getLastName(), ch.getMoney(), ch.getCar());
		}
		 // 전달받은 주소의 객체가 Parent 객체인 경우
		else if(obj instanceof Parent) {
			System.out.println("[Parent]");
			
			Parent p = (Parent)obj;
			
			// 김 / 50000
			System.out.printf("%s / %s \n", 
					p.getLastName(), p.getMoney());
		}
		else {
			System.out.println("[Object 는 필드 없음]");
		}
			
		System.out.println("----------------------------------");
	}
	
	public void test1() {
		
		Object o = new Object();
		Parent p = new Parent("홍", 100);
		Child  c = new Child("박", 333, "모닝");
		
		printObject(0);
		printObject(p);
		printObject(c);
		
		// 매개변수의 다형성이 적용되지 않았다면
		// 각 자료형 별로 매개 변수를 전달받는 메서드를
		// 계속 오버로딩을 해야하는 문제가 발생!!!
		
		// ex)
		// public void printObject(Object o);
		// public void printObject(Parent p);
		// public void printObject(Child c);
	}
	
	/**
	 * 전달받은 값에 따라 알맞은 객체를 만들어서 반환
	 * @param num 1: Object, 2 : Parent, 3 : Child
	 * @return 생성된 객체 반환
	 */
	public Object getInstance(int num) {
		
		if(num ==1) return new Object();
		// 생성된 객체 타입 : Object
		// 주소 : 0X100
		
		if(num ==2) return new Parent();
		// 생성된 객체 타입 : Parent
		// 주소 : 0X200
		
		return new Child();
		// 생성된 객체 타입 : Child
		// 주소 : 0X300
	}
	
	public void test2() {
		
		Object o1 =	getInstance(1); // Object 객체, 0X100
		
		//부모참조변수 = 자식 객체 -> 업 캐스팅 적용
		Object o2 =	getInstance(2); // Parent 객체, 0X200
		Object o3 =	getInstance(3); // Child 객체,  0X300
		
		printObject(o1);
		printObject(o2);
		printObject(o3);
	}
	
	/**
	 * 바인딩 확인
	 */
	public void test3() {
		
		Parent p1 = new Parent(); // 부모 = 부모
		
		Child c2 = new Child();	  // 자식 = 자식
		
		Parent p3 = new Child();  // 부모 = 자식 (업 캐스팅)
		
		System.out.println( p1.toString() ); // Parent.toString()
		System.out.println( c2.toString() ); // Child.toString()
		System.out.println( p3.toString() ); 
		// [정적 바인딩 - 프로그램 실행 "전"]
		// Parent.toString()과 연결됨 -- 정적 바인딩
		// -> 왜 Parent와 연결??
		//    --> 참조변수가 Parent 타입이라 업캐스팅 적용됨
		
		// [동적 바인딩 - 프로그램 실행 "후"]
		// Child.toString()과 연결됨 -- 동적 바인딩
		// toStirng() 호출 구문이 Parent -> Child로 변경
		// -> 왜???? Child로 바낌???
		// --> Child가 Parent의 toString()을 Overriding 하였기 때문에
		//     우선권을 갖게 됨......(암기)
		
		// * 업 캐스팅 상태에서 오버라이딩한 메서드가 우선권을 갖는다!
	}
	
	/**
	 * 객체 배열의 다형성 + 바인딩 예제
	 */
	public void test4() {
		
		Object[] arr = new Object[4];
		// 참조 변수 타입 == Object
		// 대입되는 객체 주소 == Parent, Child(자식 타입)
		// -> 업 캐스팅이 적용된 상태!!!
		 
		arr[0] = new Parent();
		arr[1] = new Parent("이", 30_000);
		arr[2] = new Child();
		arr[3] = new Child("박", 60_000, "캐스퍼");
		
		for(Object obj:arr) {
			System.out.println(obj);
			// 실행 전 : Object.toString() 연결 (정적 바인딩)
			// 실행 중 : Parent.toString(), Child.toString() 연결 (동적 바인딩)
		
		 
			// print 관련 구문에
			// 참조변수명을 작성하면
			// 자동으로 toString() 메서드를 호출
			 
		 }
		System.out.println("------------------------------------------");
		
		System.out.println("[만약 동적 바인딩이 없었다면]");
		
		for(Object obj : arr) {
			
			if(obj instanceof Child) {
				System.out.println(((Child)obj).toString());
			}
			else if(obj instanceof Parent) {
				System.out.println(((Parent)obj).toString());
			}
			else {
				System.out.println(obj.toString());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
