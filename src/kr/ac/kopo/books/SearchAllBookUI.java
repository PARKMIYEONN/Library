package kr.ac.kopo.books;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.BillyeoService;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BillyeoVO;
import kr.ac.kopo.vo.BookVO;

public class SearchAllBookUI extends BaseUI{
	
	private BookService bookService;
	private BillyeoService bilService;
	
	public SearchAllBookUI() {
		bookService = new BookService();
		bilService = new BillyeoService();
	}
	
	public void enter() throws Exception{
		List<BookVO> bookList = bookService.selectAll();
		
		System.out.println("====================================================================================================================");

		System.out.println("고유번호\t책 제목\t글쓴이\t출판사\t대출여부");
		System.out.println("====================================================================================================================");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("====================================================================================================================");

			System.out.println("보유하고 있는 책이 없습니다");
			System.out.println("====================================================================================================================");

		} else {
			for(BookVO book : bookList) {
				System.out.print(book.getBookNO() + "\t" + book.getBookTitle() + "\t" + book.getBookWriter() + "\t" + book.getBookPublisher());
				List<BillyeoVO> billin = bilService.billi(book.getBookNO());
				
				if(billin.size() == 0) {				//Rental테이블에 없으면 도서 보유중
					System.out.println("\t도서 보유중");		
				}else {
					System.out.println("\t대출중");
				}
			}
		}
		
	
	}
	

}
