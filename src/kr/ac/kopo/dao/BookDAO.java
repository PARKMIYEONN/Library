package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;

public class BookDAO {
	
	private List<BookVO> bookList;
	
	public BookDAO() {
		
	}
	
	public void addBook(BookVO book) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into books(b_no, b_title, b_writer, b_publisher) values(seq_books_no.nextval, ?, ?, ?) ");
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			pstmt.setString(1, book.getBookTitle());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookPublisher());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from books where b_no = ? and b_title = ? " );
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, book.getBookNO());
			pstmt.setString(2, book.getBookTitle());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookVO> selectAllBook(){
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from books");
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bookNo = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				
				BookVO book = new BookVO(bookNo, bookTitle, bookWriter, bookPublisher);
				
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public BookVO selectBy(String theBookTitle) {
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from books where b_title = ? order by b_no desc");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, theBookTitle);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int bookNo = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				
				book = new BookVO(bookNo, bookTitle, bookWriter, bookPublisher);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}

}
