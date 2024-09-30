package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDao dao = null;
	
	
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException{
		dao = new TodoListDaoImpl();
	}
	
	
	// [1] 할 일 목록 전체 조회
	@Override
	public List<Todo> getTodoList(){
		return dao.getTodoList();
	}

	// [2] 상세 조회
	@Override
	public List<Todo> selectIndex(int input) {
		
		// DAO를 이용해서 전체 목록 조회
		List<Todo> TodoList = dao.getTodoList();
		
		List<Todo> searchList = new ArrayList<Todo>();
		
		for(int i = 0; i < TodoList.size(); i++) {
			if(TodoList.get(i).equals(TodoList.get(input))) {
				searchList.add(TodoList.get(i));
				
			}
		}
		
		return searchList;
	}

	// [3] 목록 추가
	@Override
	public boolean addTodoList(String title, String detail) throws IOException {
		
		// 1) 할일 목록을 받아와 내용 중복검사
		List<Todo> TodoList = dao.getTodoList();
		
		// 중복인 경우
		for( Todo todo : TodoList) {
			
			if(detail.equals(todo.getDetail())) {
				
				return false;
				
			}
		}
		
		// 2) 중복이 아닌 경우
		// 	  입력받은 정보를 이용 todo 객체 생성
		//    DAO로 전달해서 파일에 저장
		
		Todo todo = new Todo(title , detail, false, LocalDateTime.now());
		
		// Dao 메서드 호출 후 결과 반환
		boolean result = dao.addTodo(todo);
		
		
		
		
		
		return false;
	}
	
	
	
//	// [5] 내용 수정
//	@Override
//	public String updateTodo(todo) throws IOException {
//		
//		todo.setDetail(todo);
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("할 일의 내용이 수정되었습니다.");
//		
//		dao.saveFile();
//		
//		
//		return sb.toString();
//	}

	// [6] 
	@Override
	public String removeMember(int input) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[삭제 되었습니다.]");
		
		List<Todo> todoList = dao.getTodoList();
		
		todoList.remove(input);
		
		dao.saveFile();
		
		return sb.toString();
	}




	

	
	
}
