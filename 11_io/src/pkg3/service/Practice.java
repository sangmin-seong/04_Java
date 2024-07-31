package pkg3.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Practice {

	
	// 출력용 바이트 기반 스트림
	public void FileOutput() {
		
		// 스트림 객체 생성
		FileOutputStream fos = null;
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(fos != null) fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 버퍼를 활용한 출력용 바이트 기반 스트림
	public void BufferedFileOutput() {
		
		// 기반/ 보조 스트림 객체 생성
		FileOutputStream fos   = null;
		BufferedOutputStream bos = null;
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos != null) bos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	// 입력용 바이트 기반 스트림
	public void FileInput() {
		
		// 스트림 객체 생성
		FileInputStream fis = null;
		
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(fis != null) fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 버퍼를 활용한 입력용 바이트 기반 스트림
		public void BufferedFileInput() {
			
			// 기반/ 보조 스트림 객체 생성
			FileInputStream fis   = null;
			BufferedInputStream bis = null;
			
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(bis != null) bis.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
