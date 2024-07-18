package basic;

// 클래스(Class)
// - 객체가 가져야할 속성(값), 기능(메서드)를
// 글(코드)로 작성해둔 문서
//	-> 객체를 정의한 문서

// - 클래스는 객체를 만들 때 셀계도로 사용된다

/**
 * 국민 객체를 정의한 클래스
 * == 국민이라는 객체를 만들어 위한 설계도
 */
public class Nation {

	/* 속성 */ 
	// 국민이라면 모두 가지고 있을 공통적인 속성만 작성
		String name;
		int age;
		char gender;
		String juminNumber;
		String tel;
		String adaress;
		
	/* 기능 */
		public void speakKorean() {
			System.out.println("한국어가능");
		}
		public void 납세의의무() {
			
			if(age>=19) {
				System.out.printf("%s님은 세금납부하셔야합니다", name);
				
			}else{
				System.out.printf("%s님은 미성년자로 세금납부 대상자가 아닙니다.", name);
			}
		}
		
		 public void introduce() {
		      System.out.printf("이름은 %s이고, %d세 %c성 입니다\n", 
		                                 name, age, gender);
		   }
}
