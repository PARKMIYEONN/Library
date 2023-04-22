package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.MemberService;

public class NameSujeongUI extends BaseUI{
	
	private MemberService memberService;

	public NameSujeongUI() {
		memberService = new MemberService();
	}

	@Override
	public void enter() throws Exception {
		
		String password = scanStr("비밀번호를 입력하세요 : ");
		List<String> pwd = memberService.pwdCheck(password);
		
		while(pwd.size() == 0) {
			System.out.println("비밀번호가 틀립니다");
			password = scanStr("비밀번호를 입력하세요 : ");
			pwd = memberService.pwdCheck(password);
		}
		
		String name = scanStr("수정할 이름을 입력하세요 : ");
		memberService.nameSu(name);
		System.out.println(name + "(으)로 이름 수정이 완료되었습니다");
		new MypageUI02().enter();
		
	}
	
	
	

}
