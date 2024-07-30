package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.BookDTO;

// Service : 기능(비즈니스 로직) 제공용 클래스
public class BookService {

	// BookDTO 객체 참조 변수만을 저장하는
	// ArrayList 객체 생성
	// -> <BookDTO> == 제네릭(타입 제한)
	private List<BookDTO> bookList = new ArrayList<BookDTO>();

	
	// 기본 생성자
	public BookService() {
		
		bookList.add(new BookDTO("자바 프로그래밍 입문", "박은종", 25000));
		bookList.add(new BookDTO("선재 업고 튀어 대본집 세트", "이시은", 45000));
		bookList.add(new BookDTO("THE MONEY BOOK", "토스", 19800));
		
		bookList.add(new BookDTO("자바의 정석", "남궁 성", 35000));
		bookList.add(new BookDTO("눈물의 여왕 대본집 세트", "박지은", 60000));
		bookList.add(new BookDTO("삼국지 전권 세트", "이문열", 300000));
		
	}
	
	
	/**
	 * bookList를 반환하는 서비스 메서드
	 * @return bookList
	 */
	public List<BookDTO> selectAll() {
		return bookList;
	}


	/**
	 * bookList에 전달 받은 index가 존재하면 
	 * 해당 index번째 요소(BookDTO) 반환.
	 * 없으면 null 반환
	 * @param index
	 * @return BookDTO 또는 null
	 */
	public BookDTO seletIndex(int index) {
		
		// index 범위가 bookList의 인덱스 범위 밖인 경우
		if( index < 0 || index >= bookList.size() )  return null;
		
		// 정상 범위인 경우
		return bookList.get(index);
	}
	
	
	
	/**
	 * bookList 요소의 제목 중 
	 * 전달 받은 title이 포함된 책을 모두 반환
	 * @param title
	 * @return searchList (찾은 책이 저장된 리스트)
	 */
	public List<BookDTO> selectTitle(String title) {

		// 검색 결과를 저장할 List 생성
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		// bookList 모든 요소 순차 접근
		for(BookDTO book : bookList) {
			// 책 제목에 title이 포함되어 있을 경우
			if(book.getTitle().contains(title)) {
				searchList.add(book); // 찾은 책을 searchList에 추가
			}
		}
		
		return searchList; // 검색 결과 반환
	}


	public List<BookDTO> selectWriter(String writer) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			
			// 글쓴이가 포함되는 책을 searchList에 추가
			if(book.getWriter().contains(writer)) {
				searchList.add(book); 
			}
		}
		
		return searchList; // 검색 결과 반환
	}


	/**
	 * 가격 범위 내 모든 책을 찾아서 반환
	 * @param min
	 * @param max
	 * @return searchList
	 */
	public List<BookDTO> selectPrice(int min, int max) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			
			int price = book.getPrice();
			
			// 책의 가격이 최소~최대 사이 범위에 있을 때
			if(price >= min && price <= max) {
				searchList.add(book);
			}
		}
		
		return searchList;
	}
	
	
	/**
	 * 전달 받은 newBook을 bookList에 추가
	 * @param newBook
	 * @return true (List의 add() 구문은 무조건 성공하기 때문에)
	 */
	public boolean addBook(BookDTO newBook) {
		return bookList.add(newBook);
	}
	
	
	/**
	 * 전달 받은 index요소 제거하기
	 * @param index
	 * @return null : index 범위가 맞지 않음
	 * 		   제목 : index가 정상 범위
	 */
	public String removeBook(int index) {
		
		// 1) index가 bookList 범위 내 인덱스가 맞는지 확인
		if(index < 0 || index >= bookList.size()) { // 범위 밖
			return null;
		}
		
		// 2) 정상 범위인 경우 index번째 요소를 제거한 후
		//  "제거된 책 제목"을 반환
		
		// bookList.remove(index) -> 제거된 책(BookDTO) 반환
		
		// bookList.remove(index).getTitle()
		// -> 제거된 책의 제목 얻어오기
		
		// * method chaining : 메서드의 결과(반환값)를 이용해
		//					   또 다른 메서드를 호출
		return bookList.remove(index).getTitle();
	}
	
	
	
	
	
	
}
