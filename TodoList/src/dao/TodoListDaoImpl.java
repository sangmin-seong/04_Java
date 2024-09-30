package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao{
	
	// 할일 리스트가 저장될 경로를 상수로 지정
	private final String FILE_PATH = "/io_test/TodoList.dat";
	
	// 할일 리스트 목록을 저장해 둘 List 객체
	private List<Todo> TodoList = null;
	
	// 스트림 객체 참조 변수
	private ObjectInputStream  ois = null;
	private ObjectOutputStream oos = null;
	
	// 기본 생성자
	@SuppressWarnings("unchecked")
	public TodoListDaoImpl() throws FileNotFoundException,
									IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {
				ois = new ObjectInputStream
						(new FileInputStream(FILE_PATH));
				
				TodoList = (ArrayList<Todo>) ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}else {
			TodoList = new ArrayList<Todo>();
		}
	}
	
	@Override
	public List<Todo> getTodoList(){
		return TodoList;		
	}
	
	@Override
	public boolean addTodo(Todo todo) throws IOException {
		
		
		TodoList.add(todo);
		
		saveFile();
		
		return true;
	}

	
	@Override
	public void saveFile() throws IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			
			oos.writeObject(TodoList);
		}finally {
			if(oos != null) oos.close();
		}
	}
	
	@Override
	public String toString() {
		return TodoList.get(0).getTitle();
	}
}
