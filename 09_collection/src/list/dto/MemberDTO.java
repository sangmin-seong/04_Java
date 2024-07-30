package list.dto;

public class MemberDTO {
	
	private String memberName;
	private String memberAddress;
	private int    memberAge;
	private String memberId;
	private String memberPw;
	
	// 기본 생성자
	public MemberDTO() {}

	// 매개 변수 생성자
	public MemberDTO(String memberName, String memberAddress, int memberAge, String memberId, String memberPw) {
		super();
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberAge = memberAge;
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	// getter/setter
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberName=" + memberName + ", memberAddress=" + memberAddress + ", memberAge=" + memberAge
				+ ", memberId=" + memberId + ", memberPw=" + memberPw + "]";
	};
	
	
	
	
	
	
	
}
