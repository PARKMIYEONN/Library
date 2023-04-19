package kr.ac.kopo.books;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class DelBooks extends BaseUI{
	
	private BookService bookDao;
	
	public DelBooks(){
		bookDao = new BookService();
	}
	
	@Override
	public void enter() throws Exception{
		String bookTitle = scanStr("삭제할 책 제목을 입력하세요 : ");
		int bookNo = scanInt("삭제할 책의 고유번호를 입력하세요 : ");
		
		BookVO book = new BookVO();
		
		book.setBookNO(bookNo);
		book.setBookTitle(bookTitle);
		
		bookDao.delBk(book);
		
		System.out.println("도서 삭제가 완료되었습니다");
	}

}
