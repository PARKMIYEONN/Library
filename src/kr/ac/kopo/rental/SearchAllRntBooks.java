package kr.ac.kopo.rental;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.BillyeoVO;
import kr.ac.kopo.vo.MemberVO;

public class SearchAllRntBooks extends BaseUI{
	
	private MemberService memberService;
	private BillyeoService bllyService;
	
	public SearchAllRntBooks() {
		memberService = new MemberService();
		bllyService = new BillyeoService();
	}

	@Override
	public void enter() throws Exception {
		
		List<MemberVO> memberList = memberService.myInformation();
		List<BillyeoVO> billyeoList = bllyService.billin();
		System.out.println("====================================================================================================================");

		System.out.println("회원번호\t아이디\t비밀번호\t\t이름\t전화번호\t\t생일");
		System.out.println("====================================================================================================================");

		for(MemberVO mList : memberList) {
			System.out.println(mList.getNo() + "\t" + mList.getId() + "\t" + mList.getPassword() + "\t" + mList.getName() + "\t" + mList.getPhoneNo() + "\t" + mList.getBirthDay());
		}
		if(billyeoList.size() == 0) {		// billyeoList == null; [] null이 아니라 []가 나온다
			System.out.println("********************************************************************************************************************");
			System.out.println("대여중인 책이 없습니다");
			System.out.println("====================================================================================================================");

		} else {
			System.out.println("********************************************************************************************************************");
			System.out.println("책번호\t책제목\t글쓴이\t출판사\t대여일\t\t반납일");
			System.out.println("====================================================================================================================");

			for(BillyeoVO bList : billyeoList) {
				System.out.println(bList.getBookNo() + "\t" + bList.getBookTitle() + "\t" + bList.getBookWriter() + "\t" + bList.getBookPublisher() + "\t" + bList.getRntDate() + "\t" + bList.getRtDate());
			}
			System.out.println("====================================================================================================================");
			
			
		}
		
		
		

	}

	
	
	
	
	

}
