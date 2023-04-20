package kr.ac.kopo.rental;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchOne extends BaseUI{
	
	private BillyeoService bilService;
	private BookService bkService;
	
	public SearchOne() {
		
		bkService = new BookService();
	}

	@Override
	public void enter() throws Exception {
		
		
		String allofBook = scanStr("검색할 책의 정보를 입력하세요 : ");
		
		List<BookVO> book = bkService.selectByAll(allofBook);
		

		System.out.println("=====================================");
		if (book.size() != 0) {
			System.out.println("고유번호\t책제목\t글쓴이\t출판사");
			for(BookVO booklist : book) {
				System.out.println(booklist.getBookNO() + "\t" + booklist.getBookTitle() + "\t" + booklist.getBookWriter() + "\t" + booklist.getBookPublisher());
			}
		} else {
			System.out.println(allofBook + "(와)과 관련된 책이 없습니다");
		}
		System.out.println("=====================================");

	}
	
	

}
