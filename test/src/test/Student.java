package test;

import lombok.AllArgsConstructor;
@AllArgsConstructor


public class Student {
	private String name;
	private int score;
	
	
	
	public Student() {}
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score@;
	}
	// The constructor Student(String, int) is undefined 에 대한
	// 오류 수정

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(System.out.printf("%s 학생의 점수 : %d", name, score));
		 
		return name + "학생의 점수 : " + score + "점";
	}

	
	
	
}
