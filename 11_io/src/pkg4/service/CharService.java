package pkg4.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 문자 기반 스트림
 * 
 * - 2byte 문자(char) 단위로 입출력하는 스트림
 * 
 * - 문자만 작성된 파일(txt), 채팅, 
 * 	 인터넷 요청(주소) / 응답 (html)
 * 
 * - Reader(입력), Writer(출력) 최상위 인터페이스
 */
public class CharService {
	
	/**
	 * 문자 기반 스트림을 이용해 출력하기 1
	 * - 기반 스트림만 이용 
	 */
	public void fileOutput1() {
		
		// StringBuilder : String의 불변성을 해결한 객체
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘은 8월 1일 입니다.\n");
		sb.append("아쉽게도 목요일이네요\n");
		sb.append("아.... 집가고 싶다\n");
		sb.append("asdfghjkls\n");
		
		String str = sb.toString();
		
		// 문자 기반 스트림 참조변수 선언
		FileWriter fw = null;
		
		
		try { // 예외가 발생할 것 같은 코드를 작성하는 구문
			// 해당 폴더가 없으면 만들어 주기
			File folder = new File("/io_test/char");
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// 문자 기반 스트림 객체 생성
			fw = new FileWriter("/io_test/char/문자테스트.txt");
			
			// 문자열을 지정된 파일에 출력
			// -> 자동으로 전달한 String을 한 글자씩 출력
			fw.write(str);
			
			// 스트림 밖으로 데이터를 흘려 보냄
			fw.flush();
			
			System.out.println("[출력 완료]");
			
			
		}catch(Exception e) { // try 에서 던져진 예외를 잡아서 쳐리하는 구문
			e.printStackTrace();
		}finally { // try에서 예외 발생 유무에 상관없이 무조건 시행하는 구문
			try {
				// close() : flush() 후 스트림 닫기
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public void fileOutput2() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("문자 기반 보조 스트림\n");
		sb.append("bufferedWriter를 이용해\n");
		sb.append("출력한 결과 입니다.\n");
		
		String str = sb.toString();
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			File folder = new File("/io_test/char");
			
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			fw = new FileWriter("/io_test/char/문자 기반 보조 스트림.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(str); // 보조스트림을 이용해 출력

			// bw.flush(); // 스트림에 존재하는 데이터 내보내기
			
			System.out.println("[출력 완료]");
					
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 문자 기반 입력 스트림을 이용해 
	 * /io_test/char/문자테스트.txt
	 * 파일 내용을 읽어와 콘솔 출력
	 */
	public void fileInput1() {
		FileReader fr = null;
		
		try {

			fr = new FileReader("/io_test/char/문자테스트.txt");
			
			int value = 0; // 읽어온 1byte를 저장할 변수
		
			// 읽어온 값을 누적 저장할 객체 생성
			StringBuilder str = new StringBuilder(); 

			while(true) { // 무한 반복
			
				value  = fr.read();
			
				if(value == -1) break; // 반복 종료
			
				str.append( (char)value );
			}
		
			// 읽어온 값 콘솔에 출력
			System.out.println(str.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(fr != null) fr.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 문자 기반 입력 스트림을 이용해 
	 * /io_test/char/문자 기반 보조 스트림.txt
	 * 파일 내용을 읽어와 콘솔 출력
	 */
	public void fileInput2() {
		
		// 기반/보조 스트림 참조 변수 선언
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// 스트림 객체 생성
			
			fr = new FileReader("/io_test/char/문자 기반 보조 스트림.txt");
			br = new BufferedReader(fr);
			
			// String br.readLine();
			// -> 한 줄을 읽어 옴, 없으면 null 반환
			// -> \n은 읽어오지 않음!!! 
			String line = null; // 읽어온 한 줄을 저장할 변수
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				
				line = br.readLine(); 
				
				if(line == null) break;
					
				sb.append(line);
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
