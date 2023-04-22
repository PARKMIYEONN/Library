package kr.ac.kopo.books;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.RentalService;
import kr.ac.kopo.vo.BookVO;

public class DelBooks extends BaseUI{
	
	private BookService bookDao;
	private RentalService rntService;
	
	
	public DelBooks(){
		bookDao = new BookService();
		rntService = new RentalService();
	}
	
	@Override
	public void enter() throws Exception {						//도서 삭제
		List<BookVO> bookList = bookDao.selectAll();
		bookDao.selectAll();
		SearchAllBookUI sab = new SearchAllBookUI();
		sab.enter();
		
		int bookNo = scanInt("삭제할 책의 고유번호를 입력하세요 : ");
		List<Integer> bNo = rntService.rentBNO(bookNo);
		if(bNo.size() == 0) {									//Rental테이블에 없으면 보유중이므로 삭제 가능
			
			BookVO bookil = new BookVO();
			bookil.setBookNO(bookNo);
			
			bookDao.delBk(bookil);
			
			System.out.println("도서 삭제가 완료되었습니다");
		} else {
			System.out.println("대출중인 책. 삭제 불가합니다");
		}


	}

}
