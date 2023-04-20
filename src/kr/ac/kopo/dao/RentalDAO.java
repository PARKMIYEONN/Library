package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.RentalVO;

public class RentalDAO {
	
	private List<RentalVO> rentalList;
	
	public RentalDAO() {
		
	}
	
	public void rentBook(RentalVO rent) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into rental (rnt_no, id, b_no) values(seq_rental_no.nextval, ?, ?) " );
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, rent.getId());
			pstmt.setInt(2, rent.getBookNo());
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> selectbyBookNo(int bookNo){
		
		List<Integer> bNolist = new ArrayList<>();		
		StringBuilder sql = new StringBuilder();
		sql.append("select b_no from rental where b_no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, bookNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bNo = rs.getInt("b_no");
				
				bNolist.add(bNo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bNolist;
	}
	
	public void returnBook(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from rental where b_no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, bookNo);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> rentalCheck(){
		
		List<Integer> rb = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select b_no from rental where id = ?");
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, IDFactory.getID());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rbook = rs.getInt("b_no");
				rb.add(rbook);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}


}
