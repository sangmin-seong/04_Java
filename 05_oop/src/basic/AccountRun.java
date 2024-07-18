package basic;

public class AccountRun {

	public static void main(String[] args) {
		
		// Account 객체 생성
		Account a1 = new Account();
		
		// The field Account.name is not visible
		// -> 캡슐화(private)으로 인해 변수가 보이지 않아 오류
		
//		a1.name			 = "홍길동";
//		a1.accountNumber = "1234567890";
//		a1.balance		 = 10000;
//		a1.password		 = "1q2w3e4r";
		
		// 간접 접근 기능을 이용해 세팅
		a1.setName("홍길동");
		a1.setAccountNumber("1234567890");
		a1.setPassword("1q2w3e4r!");
		a1.setBalance(10000);
		
		
		
		// a1 계좌 잔액, 비밀번호 바꾸기
//		System.out.println("a1 잔액 : "+  a1.balance);		
		
//		a1.balance = 0;
//		a1.password = "adsf1234";
		
		// 간접 기능을 이용해 값 얻어오기
		String name1 = a1.getName();
		String accountNumber1 = a1.getAccountNumber();
		long balance1 = a1.getBalance();
		String password1 = a1.getPassword();
		
		System.out.printf("%s / %s / %d / %s \n", name1, accountNumber1, balance1, password1);
		
		
		
		// 입금기능 호출
		
		a1.deposit(5000); // a1이 참조하는 계좌의 잔액을 5000추가
		
		
		System.out.println("\n========================");
		
		//출금 기능
		a1.withdraw("1q2w3e4r", 10000);
		a1.withdraw("1q2w3e4r!", 25000);
		a1.withdraw("1q2w3e4r!", 7000);
		a1.withdraw("1q2w3e4r!", 8000);
		
		
		
		
		
		
		
	}
	
}
