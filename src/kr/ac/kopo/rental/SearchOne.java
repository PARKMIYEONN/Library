package kr.ac.kopo.rental;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchOne extends BaseUI{
	
	private BookService service;
	
	public SearchOne() {
		service = new BookService();
	}

	@Override
	public void enter() throws Exception {
		
		String theBookTitle = scanStr("검색할 책의 제목을 입력하세요 : ");
		BookVO book = service.selectByB(theBookTitle);
		
		System.out.println("=====================================");
		if(book != null) {
			System.out.println("고유번호\t" + book.getBookNO());
			System.out.println("책 제 목\t" + book.getBookTitle());
			System.out.println("글 쓴 이\t" + book.getBookWriter());
			System.out.println("출 판 사\t" + book.getBookPublisher());
		} else {
			System.out.println(theBookTitle + "은(는) 보유하고 있는 책이 아닙니다");
		}
		System.out.println("=====================================");
		
		
	}
	
	

}
