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
	
	public void addBook(BookVO book) {					//책 정보 입력
		
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
	
	public void delBook(BookVO book) {							//책 정보 삭제
		StringBuilder sql = new StringBuilder();
		sql.append("delete from books where b_no = ? " );
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, book.getBookNO());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookVO> selectAllBook(){					//모든 책에 대한 정보 리스트 리턴
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from books order by b_no");
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
	
	public BookVO selectBy(String theBookTitle) {				//책 제목을 받아서 그 책의 모든 정보 리턴
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from books where b_title = ? order by b_no");
		
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
	
	public List<BookVO> selectByAll(String allofbook) {		//책 정보의 일부분을 String으로 받아 그 정보를 포함한 책 정보 리스트 리턴 
		List<BookVO> book = new ArrayList<>();
		int bookh = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select instr((b_no || b_title || b_writer || b_publisher), ?)as bookh");
		sql.append(" , b_no, b_title, b_writer, b_publisher");
		sql.append(" from books");
		sql.append(" where instr((b_no || b_title || b_writer || b_publisher), ?) != 0");
		sql.append(" order by b_no");	
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, allofbook);
			pstmt.setString(2, allofbook);
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bookNo = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				
				BookVO booklit = new BookVO(bookNo, bookTitle, bookWriter, bookPublisher);
				book.add(booklit);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public int selectByAllChck(String allofbook) {		//책에 관한 정보를 String으로 얻고 그 책의 정보를 가진 instr컬름의 값을 리턴
		int book = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select instr((b_no || b_title || b_writer || b_publisher), ?) as book");
		sql.append(" from rental");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, allofbook);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				book = rs.getInt("book");		
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
