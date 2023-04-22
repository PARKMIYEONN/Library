package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.MemberService;

public class PhNoSujeongUI extends BaseUI{
	
	private MemberService memberService;

	public PhNoSujeongUI() {
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
		
		String PhoneNO = scanStr("수정할 전화번호를 입력하세요 (- 포함 입력) : ");
		memberService.phNoSu(PhoneNO);
		System.out.println(PhoneNO + "(으)로 전화번호 수정이 완료되었습니다");
		new MypageUI02().enter();
		
	}
	
	
	
	

}
