package constructor;

public class Member {

	/* 필드 */
	
	// 인스턴스 변수 : 객체 생성 시 할당되는 변수
	private String memberId;   // 아이디
	private String memberPw;   // 비밀번호
	private String memberName; // 회원 이름
	private int    memberAge;  // 나이
	
	// 인스턴스 변수에 대입되는 값이 없다면
	// 각 자료형의 기본값으로 초기화
	// ex) int : 0       /   double : 0.0     /   boolean : false
	//     참조형 : null 
	
	/* null : 현재 참조하고 있는 객체가 없음을 의미( ==값이 없음 ) */
	
	
	/* 생성자 */
	/* -- 작성 규칙-- 
	 * 1. 반환형 없음(void, String, int .... 안씀)
	 * 2. 생성자 이름은 클래스명과 동일
	 */
	/** 기본생성자 
	 *  - 매개변수가 없는 생성자를 의미
	 *  
	 *  * 중요 *
	 *    - 클래스에 생성자가 "하나도" 없을 경우
	 *    	컴파일러가 컴파일 시 기본 생성자를 추가해줌
	 *      ex) public Member() {}
	 *      
	 * */
	public Member() {
		
		//this() 생성자 : 다른 생성자 호출(재활용)
		//  -> [주의사항] : 반드시 생성자 첫번째 줄에 작성!!!
		this("ID", "PW", "NAME", 100);
		
		
		
		// Member 객체가 생성될 때 println 구문을 수행
		System.out.println("**** Member 객체 생성됨 ****");
	}
	
	
	
	
	/** 매개변수 생성자
	 * - 매개변수가 존재하는 생성자
	 * 
	 * - 전달받은 매개변수를 이용해 생성되는 객체의 필드를
	 *   초기화하는 용도로 많이 사용
	 */
	
	public Member(String memberId,
				  String memberPw,
				  String memberName,
				  int    memberAge) {
		// ** 오버로딩 적용!!!! -> 매개변수의 개수가 다름
		
		this.memberId   = memberId;
		this.memberPw   = memberPw;
		this.memberName = memberName;
		this.memberAge  = memberAge;
		
		// -> setter 4개를 합친 모양
	}
	
	
	
	
	
	
	// 변수명 중복 테스트
//	int num = 10;
//	int num = 20;
	// Duplicate field Member.num -> 중복 X
	
	
	// 메서드명 중복 Test
	public void method() {}
//	public void method() {}   // 동일하게 작성    -> 중복
//	private void method() {}  // 접근 제한자 다름 -> 중복 
//	public String method() {} // 반환형 다름      -> 중복
	// Duplicate method method() in type Member -> 중복 X
	
	/* 오버로딩(Overloading, 과적) 
	 * 
	 * - 하나의 클래스에 동일한 이름의 메서드를 여러개 작성하는 기법 
	 * 
	 * - 같은 이름의 메서드가 수행하는 기능은 기본적으로 같으나,
	 * 	 전달받은 매개변수에 따라 조금씩 동작이 달라야하는 경우
	 * 	 상황별로 메서드를 정의할 수 있음
	 * 
	 * 	 ex) public void sum(int a, int b){a + b 출력}
	 * 
	 * 	     public void sum(int a, int b, int c){a + b + c 출력}
	 * 		
	 * 	*** 오버로딩 성립 조건 ***
	 * 	1) 메서드의 이름이 동일해야 한다.
	 * 	2) 매개변수의 개수, 자료형의 순서, 자료형 중 하나라도 달라야 한다.	 
	 * */
	
	public void method(int a) {}           // 매개변수 개수 다름
	
	public void method(int a, String b) {} // 매개변수 개수 다름
	
	public void method(String b, int a) {} // 자료형 순서 다름 

	public void method(String b, long a) {} // 자료형 다름
	
	

	
	/* 메서드 */
	
	// getter 
	public String getMemberId() {
		return memberId;
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public int getMemberAge() {
		return memberAge;
	}
	
	
	// setter
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
	public void setMemberPw(String memberPw){
		this.memberPw = memberPw;
	}
	
	public void setMemberName(String memberName){
		this.memberName = memberName;
	}
	
	public void setMemberAge(int memberAge){
		this.memberAge = memberAge;
	}
	
	/** 
	 *  현재 객체가 가지고 있는 필드값 모두 출력하는 메서드
	 */
	public void inform() {
		System.out.println("--------------------------");
		System.out.println("memberId   : " + memberId);
		System.out.println("memberPw   : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberAge  : " + memberAge);
		System.out.println("--------------------------\n");
	}
	
	
	
	
	
	
	
	
	
}
