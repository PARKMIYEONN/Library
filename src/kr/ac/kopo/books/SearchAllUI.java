package kr.ac.kopo.books;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchAllUI extends BaseUI{
	
	private BookService bookService;
	
	public SearchAllUI() {
		bookService = new BookService();
	}
	
	public void enter() throws Exception{
		List<BookVO> bookList = bookService.selectAll();
		
		System.out.println("==========================================");
		System.out.println("고유번호\t책 제목\t\t글쓴이\t출판사");
		System.out.println("==========================================");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("==========================================");
			System.out.println("보유하고 있는 책이 없습니다");
			System.out.println("==========================================");
		} else {
			for(BookVO book : bookList) {
				System.out.println(book.getBookNO() + "\t" + book.getBookTitle() + "\t" + book.getBookWriter() + "\t" + book.getBookPublisher());
				System.out.println("==========================================");
			}
		}
		
	
	}
	

}
