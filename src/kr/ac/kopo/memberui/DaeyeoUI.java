package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.RentalService;
import kr.ac.kopo.vo.BillyeoVO;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.RentalVO;

public class DaeyeoUI extends BaseUI{
	
	private RentalService rentDao;
	private BookService bkService;
	private BillyeoService bilService;
   
    
	public DaeyeoUI() {
		rentDao = new RentalService();
		bkService = new BookService();
		bilService = new BillyeoService();
		
	}

	@Override
	public void enter() throws Exception {
		
		
		int bookNo = scanInt("대여할 책의 고유번호를 입력하세요 : ");
		
		List<Integer> bNolist = rentDao.rentBNO(bookNo);
		List<BookVO> book = bkService.selectByAll(Integer.toString(bookNo));
		List<BillyeoVO> billin = null;
		
		if(bNolist.size() == 0) {
			
			IDFactory.setBOOK_NO(bookNo);
			String id = IDFactory.getID();
			
			RentalVO rntBook = new RentalVO();
			
			rntBook.setId(id);
			rntBook.setBookNo(bookNo);
			
			
			rentDao.rentBook(rntBook);
			for(BookVO booklist : book) {
				billin = bilService.billi(booklist.getBookNO());
				System.out.print("\"" + billin.get(0).getBookTitle() + "\"" + "  ");
			}
			
			System.out.println("대출완료");
		} else {
			System.out.println("해당 책은 대출중입니다");
		}
			
		
		RentalUI rtu = new RentalUI();
		rtu.enter();
		
	}
	

}
