package field.pkg2;

import field.pkg1.FieldTest1;

// 다른 패키지
public class FieldRun2 extends FieldTest1{
						 /* 상속구문 */
	
	public static void main(String[] args) {
		
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		//public
		System.out.println(f1.publicValue);
		
		// protected -> 문제 발생? => (상속관계 X)
		// 
//		System.out.println(f1.protectedValue);

		
		//(default) -> 문제 발생
//		System.out.println(f1.defaultValue);
		
		//private -> 문제발생
//		System.out.println(f1.privateValue);
		
	}
	
	public void method() {
		
		//protected -> 상속관계이기 때문에 직접접근 가능!!!
		System.out.println(protectedValue);
	}
}
