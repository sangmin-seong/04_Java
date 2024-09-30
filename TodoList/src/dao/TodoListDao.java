package dao;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListDao {
	
	/**
	 * DAO 객체가 가지고 있는 TodoList 반환
	 * @return TodoList
	 */
	List<Todo> getTodoList();
	
	
	boolean addTodo(Todo todo) throws IOException;
	
	public void saveFile() throws IOException;
	
	@Override
	String toString();
	
}
