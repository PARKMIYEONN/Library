package kr.ac.kopo.Entrance;

import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.administrator.AdminPage;
import kr.ac.kopo.memberui.MyPageUI;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class LogInUI extends BaseUI{
	
	private MemberService memberDao;
	  
	
	public LogInUI() {
		memberDao = new MemberService();
		
	}
	
	@Override
	public void enter() throws Exception{
		int cntID = 0;
		String id = scanStr("아이디를 입력하세요 : ");
		IDFactory.setID(id);;		//static 변수에 현재 아이디 입력	
		
		
		List<MemberVO> memberlist = memberDao.allmem();
		for(int i = 0; i < memberlist.size(); i++) {
			if(memberlist.get(i).getId().equals(id)) {
				break;
			} else {
				cntID++;
			}
		}
		if(cntID == memberlist.size()) {
			System.out.println("입력하신 ID는 존재하지 않습니다");
			this.enter();
		}
		String password = scanStr("비밀번호를 입력하세요 : ");
		if(!(memberlist.get(cntID).getPassword().equals(password))) {
			System.out.println("패스워드가 올바르지 않습니다");
			this.enter();
		}
		
		System.out.println("로그인 성공!");
		
		if(memberlist.get(0).getId().equals(id)) {
			new AdminPage().enter();
		} else {
			
			new MyPageUI().enter();
		}
		System.exit(0);
		
		
		
		
	}

}
