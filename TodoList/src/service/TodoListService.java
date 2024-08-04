package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;



public interface TodoListService {
	
	public abstract boolean addTodoList(String title, String detail) throws IOException;

	public abstract	List<Todo> getTodoList();
	
	
	public List<Todo> selectTitle(String searchTitle);
		
	public String completeTodo(Todo target, String complete) throws IOException;
		
	public String updateDetail(Todo target, String detail) throws IOException;
	
	public String removeMember(Todo target) throws IOException;
}
