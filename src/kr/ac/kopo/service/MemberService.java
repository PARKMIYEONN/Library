package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService {
	
	private MemberDAO memberDao;

	
	public MemberService() {
		memberDao = new MemberDAO();
		
		
	}
	
	public void insertMember(MemberVO member) {
		
		memberDao.insertMember(member);
		
	}
	
	public List<MemberVO> allmem(){
		List<MemberVO> memberList = memberDao.allMember();
		return memberList;
	}
	
	public List<MemberVO> myInformation(){
		List<MemberVO> memberList = memberDao.myInfo();
		return memberList;
	}
	
	

}
