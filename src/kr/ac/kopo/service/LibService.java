package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class LibService {
	
	private MemberDAO memberDao;
	
	public LibService() {
		memberDao = new MemberDAO();
	}
	
	public void insertMember(MemberVO member) {
		
		memberDao.insertMember(member);
		
	}
	
	public List<MemberVO> allmem(){
		List<MemberVO> memberList = memberDao.allMember();
		return memberList;
	}
	

}
