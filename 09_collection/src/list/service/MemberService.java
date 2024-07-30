package list.service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import list.dto.MemberDTO;

public class MemberService {
	
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	
	
	public MemberService() {
		memberList.add(new MemberDTO("짱구", "떡잎마을", 5, "24001", "1234"));
		memberList.add(new MemberDTO("철수", "떡잎마을", 5, "24002", "1234"));
		memberList.add(new MemberDTO("맹구", "떡잎마을", 5, "24003", "1234"));
		memberList.add(new MemberDTO("훈이", "떡잎마을", 5, "24004", "1234"));
				
	}


	public List<MemberDTO> selectAll() {
		return memberList;
	}
	
	
	
	
	
	
	
	
	
	
}
