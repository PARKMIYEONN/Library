package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.MemberService;

public class PWSujeongUI extends BaseUI{
	
	private MemberService memberservice;

	public PWSujeongUI() {
		memberservice = new MemberService();
	}

	@Override
	public void enter() throws Exception {
		
		String password = scanStr("비밀번호를 입력하세요 : ");
		List<String> pwd = memberservice.pwdCheck(password);
		
		while(pwd.size() == 0) {
			System.out.println("비밀번호가 틀립니다");
			password = scanStr("비밀번호를 입력하세요 : ");
			pwd = memberservice.pwdCheck(password);
		}
		String passwordsu = scanStr("수정할 비밀번호를 입력하세요 : ");
		memberservice.pwSu(passwordsu);
		System.out.println("비밀번호 수정이 완료되었습니다");
		new MypageUI02().enter();
		
	}
	
	

	
	

}
