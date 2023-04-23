package kr.ac.kopo.rental;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.vo.BillyeoVO;

public class AllRentalSaram extends BaseUI{
	
	private BillyeoService blyService;
	
	public AllRentalSaram() {
		blyService = new BillyeoService();
	}

	@Override
	public void enter() throws Exception {
		List<BillyeoVO> bilList = blyService.billinAll();
		
		System.out.println("====================================================================================================================");

		System.out.println("회원번호\t아이디\t이름\t전화번호\t\t생일\t\t책번호\t책제목\t\t글쓴이\t출판사\t대여일\t\t반납일");
		System.out.println("====================================================================================================================");


		
		if(bilList == null || bilList.size() == 0) {
			System.out.println("====================================================================================================================");


			System.out.println("책이 없습니다");
			System.out.println("====================================================================================================================");


		} else {
			for(BillyeoVO bList : bilList) {
				System.out.println(bList.getNo() + "\t" + bList.getId() + "\t" + bList.getName() + "\t" + bList.getPhoneNo() + "\t" + bList.getBirthday()
				 + "\t" + bList.getBookNo() + "\t" + bList.getBookTitle() + "      "+  "\t" + bList.getBookWriter() + "\t" + bList.getBookPublisher() + "\t" + bList.getRntDate() + "\t" + bList.getRtDate());
			}
		}
	}

	
	
}
