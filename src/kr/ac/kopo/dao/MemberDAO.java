package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.LibEntrance;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {
	
	private List<MemberVO> memberList;
	
	public MemberDAO(){
		
	}



	public void insertMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into members(no, id, password, name, phone_no, birthday) values(seq_members_no.nextval,?,?,?,?,?) ");
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhoneNo());
			pstmt.setString(5, member.getBirthDay());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> allMember(){
		
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, phone_no, birthday from members");
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
				){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phoneNo = rs.getString("phone_no");
				String birthday = rs.getString("birthday");
				
				MemberVO member = new MemberVO(no, id, password, name, phoneNo, birthday);
				
				memberList.add(member);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
		
	}
	
	public List<MemberVO> myInfo(){
		
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, phone_no, birthday from members");
		sql.append(" where id = ? ");
		
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
				
				MemberVO member = new MemberVO(no, id, password, name, phoneNo, birthday);
				
				memberList.add(member);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
		
	}
	
	public void talMember(String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from members where id = ?");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, IDFactory.getID());
			pstmt.executeUpdate();
			
			System.out.println("탈퇴가 완료되었습니다");
			
			IDFactory idf = new IDFactory();
			idf.enitialID();
			idf.enitialBNO();
			LibEntrance le = new LibEntrance();
			le.enter();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> passwdCheck(String password){
		
		List<String> passwd = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select password from members where id = ? and password = ?");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, IDFactory.getID());
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String pswd = rs.getString("password");
				passwd.add(pswd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return passwd;
	}
	
	

}
