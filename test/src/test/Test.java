package test;

import java.util.ArrayList;
import java.util.List;

import test.Student;

public class Test {
	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		//Cannot invoke "java.util.ArrayList.add(Object)" because "list" is null
		// -> list가 null이기 때문에 호출할 수 없다는 오류 발생
		// ArrayList<Student> list를 생성시 null이 아닌 
		// ArrayList<Student> list = new ArrayList<Student>(); 로 수정이 필요
		
		list.add(new Student("강건강", 84));
		list.add(new Student("남나눔", 78));
		list.add(new Student("도대담", 96));
		list.add(new Student("류라라", 67));
		// The constructor Student(String, int) is undefined
		// String, int 변수를 가진 매개변수 생성자가 정의되지 않음
		// Student에서 매개변수 생성자를 생성해야 됨
		
		
		
		for(int i = 0; i < list.size(); i++) { 
			//The method length() is...... undefined for the type ArrayList<Student>
			// ArrayList<Student>의 length가 정의되지 않았다는 오류
			// ArrayList<Student> 는 length가 아닌 size로 정의해야 됨.
			// for (int i = 0; i < list.size(); i++)로 수정 필요
			
			// 현재 해당 객체의 주소만 저장되고 있음.
			// 강건강 84 형태로 출력 희망
			Student s = list.get(i);
			System.out.println(s);
			
		}
	}
}
