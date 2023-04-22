package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.service.RentalService;
import kr.ac.kopo.vo.BillyeoVO;

public class ReturnUI extends BaseUI{
	
	private RentalService rentDao;
	private BillyeoService bilService;
	
	
	public ReturnUI() {
		rentDao = new RentalService();
		bilService = new BillyeoService();
		
	}

	@Override
	public void enter() throws Exception {
	
		List<BillyeoVO> billin = bilService.billiThing();
		System.out.println("====================================================================================================================");

		System.out.println("대여중인 책 목록");
		System.out.println("====================================================================================================================");

		System.out.println("고유번호\t제목\t글쓴이\t출판사");
		System.out.println("====================================================================================================================");

		for(BillyeoVO billinlist : billin) {
			
			if(billin.size() == 0) {
				break;
			} else {
				System.out.println(billinlist.getBookNo() + "\t" + billinlist.getBookTitle() + "\t" + billinlist.getBookWriter() + "\t" + billinlist.getBookPublisher());
			}
		}
		if(billin.size() == 0) {
			System.out.println("대여중인 책이 없습니다");
		}else {
			
			System.out.println();
			int bookNo = scanInt("반납할 책의 고유번호를 입력하세요 (0 입력시 이전 메뉴로 이동) : ");
			if(bookNo == 0) {
				MyPageUI mpg = new MyPageUI();
				mpg.enter();
			}else {
				
				List<Integer> bNolist = rentDao.rentBNO(bookNo);
				if(bNolist.size() != 0) {
					rentDao.returnB(bookNo);
					System.out.println("반납이 완료되었습니다");
				} else {
					System.out.println("대여중인 책이 아닙니다");
				}
			}
		}
		
		MyPageUI mpg = new MyPageUI();
		mpg.enter();
		
	}
	
	

}
