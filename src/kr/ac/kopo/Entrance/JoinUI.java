package kr.ac.kopo.Entrance;

import java.util.List;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class JoinUI extends BaseUI {

	private MemberService memberDao;

	public JoinUI() {
		memberDao = new MemberService();
	}

	@Override
	public void enter() throws Exception {
		int cntID = 0;
		String id = scanStr("등록할 ID를 입력하세요 : ");
		List<MemberVO> memberlist = memberDao.allmem();
		for(int i = 0; i <memberlist.size(); i++) {
			if(memberlist.get(i).getId().equals(id)) {
				break;
			} else {
				cntID++;
			}
		}
		if(cntID != memberlist.size()) {
			System.out.println("이미 존재하는 ID 입니다");
			this.enter();
		}
		String password = scanStr("비밀번호를 입력하세요 (최대 16자리): ");
		String name = scanStr("이름을 입력하세요 : ");
		String phoneNo = scanStr("전화번호를 입력하세요 : ");
		String birthday = scanStr("생년월일을 입력하세요 (8자리): ");
		
		MemberVO member = new MemberVO();

		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setPhoneNo(phoneNo);
		member.setBirthDay(birthday);

		memberDao.insertMember(member);

		System.out.println("회원가입이 완료되었습니다");
		
		LibEntrance le = new LibEntrance();
		le.enter();
		
		

	}

}
