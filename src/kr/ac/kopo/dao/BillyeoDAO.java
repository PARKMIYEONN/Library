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
	
	public List<BillyeoVO> billinsaram(){
		
		List<BillyeoVO> billyeoList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, b.id, password, name, phone_no, birthday, a.b_no, b_title, b_writer, b_publisher, rnt_date, (rnt_date + 7)as rt_date ");
		sql.append(" from rental a join members b on b.id = a.id join books c on c.b_no = a.b_no ");
		sql.append(" where b.id = ? ");
		sql.append(" group by no, b.id, password, name, phone_no, birthday, a.b_no, b_title, b_writer, b_publisher, rnt_date");
		
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
	
	

}