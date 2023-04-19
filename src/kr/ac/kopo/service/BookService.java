package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;

public class BookService {
	
	private BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}
	
	public void addBk(BookVO book) {
		
		bookDao.addBook(book);
		
	}
	
	public void delBk(BookVO book) {
		bookDao.delBook(book);
	}
	
	public List<BookVO> selectAll(){
		List<BookVO> bookList = bookDao.selectAllBook();
		return bookList;
	}
	
	public BookVO selectByB(String theBookTitle) {
		BookVO book = bookDao.selectBy(theBookTitle);
		return book;
	}
	

}
