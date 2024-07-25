package pkg1.dto;

public class Child extends Parent{

	private String car;
	
	public Child() {
		super();
	}

	// 자식 객체 생성 시 
	// 자식 + 부모 필드 한 번에 초기화
	public Child(String lastName, int money, String car) {
		super(lastName, money);
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	//Parent의 toString 오버라이딩 하기
	@Override
	public String toString() {
		return "Child : " + getLastName() + " / " 
						  + getMoney() + " / "
						  + car 	;
	}
	
}
