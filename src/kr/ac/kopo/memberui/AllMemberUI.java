package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class AllMemberUI extends BaseUI {
	
	private MemberService memService;
	
	

	public AllMemberUI() {
		memService = new MemberService();
	}



	@Override
	public void enter() throws Exception {
		
		List<MemberVO> memberList = memService.allmems();
		System.out.println("====================================================================================================================");

		System.out.println("회원번호\t아이디\t이름\t전화번호\t\t생일");
		System.out.println("====================================================================================================================");

		
		if(memberList == null || memberList.size() == 0) {
			System.out.println("\t게시글이 존재하지 않습니다");
			System.out.println("====================================================================================================================");

			
		}else {
			for(MemberVO member : memberList) {
				System.out.println(member.getNo() + "\t" + member.getId() + "\t" + member.getName() + "\t" + member.getPhoneNo() + "\t" + member.getBirthDay());;
			}
			System.out.println("====================================================================================================================");
		}

	}

}
