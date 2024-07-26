package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

// view : 사용자에게 보여지는 부분(출력, 입력)

public class BookView {

	private Scanner sc = new Scanner(System.in);
	
	private BookService service = new BookService();
	
	/**
	 * 사용자에게 보여질 메인 화면 
	 */
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n****** 도서관리 프로그램 ******\n");
			
			System.out.println("1. 전체 조회"); 
			System.out.println("2. index로 조회"); 
			System.out.println("3. 도서 이름으로 조회(포함)"); 
			System.out.println("4. 글쓴이 이름으로 조회(포함)"); 
			System.out.println("5. 도서 가격으로 조회"); 
			
			System.out.println("6. 도서 추가하기"); 
			System.out.println("7. 도서 제거하기"); 
			System.out.println("8. 도서 가격 수정하기"); 
			
			System.out.println("0. 종료");
			
			System.out.println();
			System.out.print("메뉴선택 >> ");
			input = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(input) {
			case 1 : selectAll();    break;
			case 2 : selectIndex();  break;
			case 3 : selectTitle();  break;
			case 4 : selectWriter(); break;
			case 5 : selectPrice();  break;
			
			case 6 : addBook(); break;
			case 7 : removeBook(); break;
			case 8 : updateBook(); break;
			
			case 0 : System.out.println("*** 프로그램 종료 ***"); break;
			default : System.out.println("=-=-=잘못 입력=-=-=");
			}
			
		}while(input != 0);
		
	}// mainMenu 메서드 끝!
	
	/**
	 * 전체 조회
	 * - BookService에 있는 BookList를 얻어와
	 * 	 존재하는 모든 요소의 정보를 출력
	 */
	private void selectAll() {
		System.out.println("\n@@@ 전체조회 @@@\n");
		
		List<BookDTO> bookList = service.selectAll();
		
		for(int i = 0; i < bookList.size(); i++) {
			
			System.out.println(i+ ") " + bookList.get(i));
		}
	}
	/**
	 * 입력받은 index번째 BookDTO를 반환 받아와 출력
	 */
	private void selectIndex() {
		System.out.println("\n@@@ index로 조회 @@@\n");
		
		System.out.print("조회할 index 입력 : ");
		int index = sc.nextInt();
		
		// 전달한 index번째 요소가 존재하면 BookDTO 객체 주소
		// 없다면 null 반환
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getWriter());
		System.out.println("가격 : " + book.getPrice() + "원");
		
	}
	
	/**
	 * 입력 받은 도서 제목이 포함된 모든 도서 조회
	 * 단, 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectTitle() {
		System.out.println("\n@@@ 도서 이름으로 조회(포함) @@@\n");
		
		System.out.print("검색할 도서 이름을 입력하세요 : ");
		String title =sc.nextLine();
		
		List<BookDTO> searchList = service.selectTitle(title);
		
		// 만약 검색 결과가 없을 경우 == 비어있는 경우
//		if(searchList.size() == 0 ) {
		if(searchList.isEmpty()) {
			System.out.println("=-=-=조회 결과가 없습니다=-=-=");
			return;
		}
		
		// 검색결과있는 경우
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
		
	}
	
	
	/**
	 * 입력 받은 글쓴이 이름이 같은 모든 도서 조회하여 출력하기
	 * 단, 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectWriter() {
		System.out.println("\n@@@ 글쓴이 이름으로 조회(포함) @@@\n");
	
		System.out.print("검색할 글쓴이 이름을 입력하세요 : ");
		String writer = sc.nextLine();
		
		List<BookDTO> searchList = service.selectWriter(writer);
		if(searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
	}
	
	/**
	 * 검색할 가격의 범위(최소값, 최대값)을 입력받아
	 * 가격범위 내의 모든 도서 조회하여 출력하기
	 * 단, 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectPrice() {
		System.out.println("\n@@@ 도서 가격으로 조회 @@@\n");
	
		int min = 0;
		int max = 0;
		
		System.out.print("가격의 범위(최소값, 최대값)를 입력하세요 : ");
		int price1 = sc.nextInt();
		int price2 = sc.nextInt();
	
		if( price1 > price2 ) {
			max = price1;
			min = price2;
		}else {
			max = price2;
			min = price1;
		}
		
		List<BookDTO> searchList = service.selectPrice(max, min);
		
		if(searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
		
	}
	
	/**
	 * 제목, 글쓴이 가격을 입력받아
	 * BookService 의 bookList에 도서 추가하기
	 */
	private void addBook() {
		System.out.println("\n@@@@@ 도서 추가하기 @@@@@\n");
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("글쓴이 : ");
		String writer = sc.nextLine();
		
		System.out.print("가격 : ");
		int Price = sc.nextInt();
		
		// 입력받은 정보를 묶어서 Service로 전달할 수 있도록
		// BookDTO 객체를 생성
		
		BookDTO newBook = new BookDTO(title, writer, Price);
		
		boolean result = service.addBook(newBook);
		
		if(result) {
			System.out.println("*** 추가 완료 ***");
		}else {
			System.out.println("*** 추가 중 문제발생 ***");
		}
		
	}
	
	/**
	 * 인덱스 번호를 입력받아
	 *1) 일치하는 인덱스가 있으면 bookList에서 제거 후
	 * "[책제목] 책이 목록에서 제거 되었습니다" 출력
	 * 
	 * 2) 일치하는 인덱스가 없으면
	 * "해당 인덱스에 존재하는 책이 없습니다" 출력
	 */
	private void removeBook() {
		System.out.println("\n@@@@@ 도서 제거하기 @@@@@\n");
		
		System.out.print("제거하고자 하는 도서의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
	
				
		// 전달한 index번째 요소가 존재하면 BookDTO 객체 주소
		// 없다면 null 반환
		String result = service.removeBook(index);
		
		
		
		
		if(result == null) {
			System.out.println("해당 인덱스에 존재하는 책이 없습니다");
			return;
		}
				
		
		System.out.printf("[%s] 책이 목록에서 제거 되었습니다",
							result);
	}
	
	/**
	 * 인덱스 번호를 입력 받아
	 * 해당 인덱스에 도서가 존재하지 않으면
	 * -> " 해당 인덱스에 책이 존재하지 않습니다" 출력 후 메서드 종료
	 * 해당 인덱스에 도서가 존재하면
	 * -> 수정할 가격을 입력 후 수정
	 * -> "[도서 제목] 가격이 (이전 가격)원 -> (새 가격) 수정되었습니다"
	 */
	private void updateBook() {
		System.out.println("\n@@@ 도서 가격 수정하기 @@@\n");
		
		System.out.print("가격을 수정할 도서의 index 입력 : ");
		int index = sc.nextInt();
		
		// 인덱스가 일치하는 요소의 BookDTO(참조주소)를 반환받기
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		System.out.print("수정할 가격을 입력하세요 : ");
		int newPrice = sc.nextInt();
		
		int price = book.getPrice();
		
		book.setPrice(newPrice);
		
		System.out.printf("[%s] 가격이 (%d)원 -> (%d)원으로 수정되었습니다",
				           book.getTitle(), price, book.getPrice());
		
	}
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

