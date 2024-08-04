package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDao dao = null;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	// String formattedDateTime = currentDateTime.format(formatter);
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException{
		dao = new TodoListDaoImpl();
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
	
	@Override
	public List<Todo> getTodoList(){
		return dao.getTodoList();
	}

	@Override
	public List<Todo> selectTitle(String searchTitle) {
		
		// DAO를 이용해서 전체 목록 조회
		List<Todo> TodoList = dao.getTodoList();
		
		List<Todo> searchList = new ArrayList<Todo>();
		
		for(Todo todo : TodoList) {
			if(todo.getTitle().equals(searchTitle)) {
				searchList.add(todo);
			}
		}
		
		return searchList;
	}

	@Override
	public String completeTodo(Todo target, String complete) throws IOException {
		
		target.setComplete(true);
		
		StringBuilder sb = new StringBuilder();
		
		if(target.isComplete() == true) {
			
			String str = String.format("\n 할 일이 완료로 수정되었습니다.");
			
			sb.append(str);
		}
		
		dao.saveFile();
		
		
		return sb.toString();
	}

	@Override
	public String updateDetail(Todo target, String detail) throws IOException {
		
		target.setDetail(detail);
		
		StringBuilder sb = new StringBuilder();
		sb.append("할 일의 내용이 수정되었습니다.");
		
		dao.saveFile();
		
		
		return sb.toString();
	}

	@Override
	public String removeMember(Todo target) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("할 일이 삭제처리 되었습니다.");
		
		List<Todo> todoList = dao.getTodoList();
		
		todoList.remove(target);
		
		dao.saveFile();
		
		return sb.toString();
	}


	

	
	
}
