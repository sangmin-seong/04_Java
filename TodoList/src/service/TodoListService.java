package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;



public interface TodoListService {
	
	public abstract boolean addTodoList(String title, String detail) throws IOException;

	public abstract	List<Todo> getTodoList();
	
	
	public List<Todo> selectIndex(int input) ;
		
	String removeMember(int input) throws IOException;

}
