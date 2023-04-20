package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.RentalService;

public class TalUI extends BaseUI{
	
	private MemberService memberDao;
	private RentalService rentalDao;
	
	public TalUI() {
		memberDao = new MemberService();
		rentalDao = new RentalService();
	}

	@Override
	public void enter() throws Exception {
		
		
		List<Integer> bNolist = rentalDao.retCheck();
		
		if(bNolist.size() == 0) {
			String password = scanStr("비밀번호를 입력하세요 : ");
			
			List<String> pwd = memberDao.pwdCheck(password);
			
			if(pwd.size() != 0) {
				memberDao.talmem(password);
			} else {
				System.out.println("비밀번호를 잘못 입력하셨습니다");
				this.enter();
			}
			
		} else {
			System.out.println("대여중인 책이 있습니다 반납하세요");
			ReturnUI rt = new ReturnUI();
			rt.enter();
			
		}
		
	}
	
	

}
