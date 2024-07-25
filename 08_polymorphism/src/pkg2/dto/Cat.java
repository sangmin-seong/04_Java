package pkg2.dto;

public class Cat extends Animal{
	// The type Cat must implement the inherited
	// abstract method Animal.move()
	// -> 상속 받은 move() 구현해야 한다
	
	// 필드
	private int beard; // 수염
	
	// 생성자
	public Cat() {
		super(); // 부모(Animal) 객체 생성
	}
	
	// 매개 변수 생성자	
	public Cat(int eyes, int beard) {
		super(eyes);
		this.beard = beard;
	}

	// getter / setter
	public int getBeard() {
		return beard;
	}

	public void setBeard(int beard) {
		this.beard = beard;
	}

	
	
	@Override
	public String toString() {
		return "Cat : " + beard + " / " + getEyes();
	}
	
	
	/* Animal로부터 상속받은 abstract 메서드를
	 * 구현(오버라이딩)하라고 오류 발생함
	 * -> 오버라이딩 강제화 
	 */
	@Override
	public void move() {
		System.out.println("고양이 : 사뿐 사뿐 움직임");
	}
	

	@Override
	public void sleep() {
		System.out.println("고양이 : 엎드려 잠");
	}
	
	@Override
	public void eat() {
		System.out.println("고양이 : 냠냠 먹음");
	}
	
	
	
	
}
