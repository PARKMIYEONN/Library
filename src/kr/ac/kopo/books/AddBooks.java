package kr.ac.kopo.books;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddBooks extends BaseUI{
	
	private BookService bookDao;
	
	public AddBooks() {
		bookDao = new BookService();
	}
	
	@Override
	public void enter() throws Exception{
		String bookTitle = scanStr("책 제목을 입력하세요 : ");
		String bookWriter = scanStr("글쓴이를 입력하세요 : ");
		String bookPublisher = scanStr("출판사를 입력하세요 : ");
		
		BookVO book = new BookVO();
		
		book.setBookTitle(bookTitle);
		book.setBookWriter(bookWriter);
		book.setBookPublisher(bookPublisher);
		
		bookDao.addBk(book);
		System.out.println("도서 등록이 완료되었습니다");
	}
	

}
