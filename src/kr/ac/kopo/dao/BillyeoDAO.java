package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BillyeoVO;

public class BillyeoDAO {
	
	private List<BillyeoDAO> billyeoList;
	
	public BillyeoDAO() {
		
	}
	
	public List<BillyeoVO> billinsaram(){				//책을 빌린 사람 정보와 빌린 책 정보 리스트 리턴
		
		List<BillyeoVO> billyeoList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, b.id, password, name, phone_no, to_char(birthday,'yyyy-mm-dd')as birthday, a.b_no, b_title, b_writer, b_publisher, to_char(rnt_date, 'yyyy-mm-dd')as rnt_date, to_char((rnt_date + 7), 'yyyy-mm-dd')as rt_date ");
		sql.append(" from rental a join members b on b.id = a.id join books c on c.b_no = a.b_no ");
		sql.append(" where b.id = ? ");
		sql.append(" group by no, b.id, password, name, phone_no, to_char(birthday,'yyyy-mm-dd'), a.b_no, b_title, b_writer, b_publisher, rnt_date");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, IDFactory.getID());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phoneNo = rs.getString("phone_no");
				String birthday = rs.getString("birthday");
				int bookNo = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				String rntDate = rs.getString("rnt_date");
				String rtDate = rs.getString("rt_date");
				
				BillyeoVO billyeo = new BillyeoVO(no, id, password, name, phoneNo, birthday, bookNo, bookTitle, bookWriter, bookPublisher, rntDate, rtDate);
				billyeoList.add(billyeo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billyeoList;
	}
	
	public List<BillyeoVO> billinsaramAll(){			//대출중인 모든 사람에 대한 정보와 빌린 책 정보 리스트 리턴
		
		List<BillyeoVO> billyeoList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, b.id, name, phone_no, to_char(birthday,'yyyy-mm-dd')as birthday, a.b_no, b_title, b_writer, b_publisher, to_char(rnt_date,'yyyy-mm-dd')as rnt_date, to_char((rnt_date + 7),'yyyy-mm-dd')as rt_date ");
		sql.append(" from rental a join members b on b.id = a.id join books c on c.b_no = a.b_no ");
		sql.append(" group by no, b.id, name, phone_no, to_char(birthday,'yyyy-mm-dd'), a.b_no, b_title, b_writer, b_publisher, rnt_date");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phoneNo = rs.getString("phone_no");
				String birthday = rs.getString("birthday");
				int bookNo = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				String rntDate = rs.getString("rnt_date");
				String rtDate = rs.getString("rt_date");
				
				BillyeoVO billyeo = new BillyeoVO(no, id, name, phoneNo, birthday, bookNo, bookTitle, bookWriter, bookPublisher, rntDate, rtDate);
				billyeoList.add(billyeo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billyeoList;
	}
	
	public List<BillyeoVO> billinBook(int allofBook){			//받은 책 고유번호에 대한 책의 정보 리스트 리턴
		List<BillyeoVO> billList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select a.b_no, b_title, b_writer, b_Publisher");
		sql.append(" from rental a join members b on b.id = a.id join books c on c.b_no = a.b_no ");
		sql.append(" where a.b_no = ?");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
				){
			
			pstmt.setInt(1, allofBook);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bookNO = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				
				BillyeoVO billyeo = new BillyeoVO(bookNO, bookTitle, bookWriter, bookPublisher);
				billList.add(billyeo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billList;
	}
	
	public List<BillyeoVO> billinThing(){						//현재 로그인한 사람이 빌린 책에 대한 정보 리스트 리턴
		List<BillyeoVO> billList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select a.b_no, b_title, b_writer, b_publisher");
		sql.append(" from rental a join members b on b.id = a.id join books c on c.b_no = a.b_no ");
		sql.append(" where a.id = ?");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, IDFactory.getID());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bookNO = rs.getInt("b_no");
				String bookTitle = rs.getString("b_title");
				String bookWriter = rs.getString("b_writer");
				String bookPublisher = rs.getString("b_publisher");
				
				BillyeoVO billyeo = new BillyeoVO(bookNO, bookTitle, bookWriter, bookPublisher);
				billList.add(billyeo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return billList;
	}
	

}
