package field.pkg3;

public class StaticTestRun {

	public static void main(String[] args) {
		
		
		// Korean 객체 2개 생성
		Korean k1 = new Korean();
		
		k1.setName("김철수");
		k1.setId("123456-1234567");
		
		Korean k2 = new Korean();
		k2.setName("박영희");
		k2.setId("123456-2134567");
		
		// ---------------------------------------
		
		System.out.println("[생성된 객체의 필드 값 확인]");
		
		System.out.printf("k1 : %d / %s / %s \n", 
				k1.nationalCode, k1.getName(), k1.getId());

		System.out.printf("k2 : %d / %s / %s \n", 
				k2.nationalCode, k2.getName(), k2.getId());
		// -----------------------------------------------------
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("\n\n [static 변수 값 변경 확인]");
		
		// static은 값을 공유하고 있기 때문에
		// 한번만 바꾸면 공유하는 모든 객체의 값이 변경됨
		k1.nationalCode = 10;
//		k2.nationalCode = 10; // 불필요한 코드
		
		System.out.printf("k1 : %d / %s / %s \n", 
				k1.nationalCode, k1.getName(), k1.getId());

		System.out.printf("k2 : %d / %s / %s \n", 
				k2.nationalCode, k2.getName(), k2.getId());
		
		//-----------------------------------------------------------------------------------
		
		// 왜 k1.nationalCode, k2.nationalCode에 노란줄????
		// 
		//The static field Korean.nationalCode should be accessed in a static way
		//->정적 필드 Korean.National 코드는 정적 방식으로 액세스해야 합니다
		// -> 정적방식으로 접근하는게 좋아~
		// -> Static영역에 생성된 이름으로 호출하는게 좋다! (클래스명.필드명)
		System.out.println( "\n\n");
		
		System.out.println("[Static에 선언된 이름 사용하기]");
		
		System.out.println("Korean.nationalCode : " + Korean.nationalCode);
		
		System.out.println("--값 변경--");
		
		Korean.nationalCode = 1;
		
		System.out.println("Korean.nationalCode : " + Korean.nationalCode);
		System.out.println(k1.nationalCode);
		System.out.println(k2.nationalCode);
		
		
		System.out.println("--------------------------------------------------------------");
		//Static Final???? -> 
		// final 변수  == 상수
		// Static 변수 == 공유하는 변수
		
		// static final || final static
		// -> 공유가능한 상수
		
		// --> 무슨용도?????  전체적으로 사용되면서 변하면 안되는 값

		// 		ex) Math.PI(원주율)
		//			Integer.MAX_VALUE(int 최대값)
		//			Integer.MIN_VALUE(int 최소값)
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}
}
