package service;

import java.util.List;

import dao.TodoListDao;
import dto.Todo;

public class TodoListServiceImpl {

	
	public List<Todo> getTodoList(){
		return dao.getTodoList();
	}
	
}
