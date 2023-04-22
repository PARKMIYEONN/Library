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



	public void insertMember(MemberVO member) {		//회원 등록
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into members(no, id, password, name, phone_no, birthday) values(seq_members_no.nextval,?,?,?,?,to_date(?,'yyyymmdd')) ");
		
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
	
	public List<MemberVO> allMember(){			//모든 멤버의 모든 정보를 가진 리스트 리턴
		
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, phone_no, to_char(birthday,'yyyy-mm-dd')as birthday from members order by no");
		
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
	
	public List<MemberVO> myInfo(){		//현재 로그인 중인 멤버의 회원 정보 리스트 리턴
		
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, phone_no, to_char(birthday,'yyyy-mm-dd')as birthday from members");
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
	
	public void talMember(String password) {			//입력받은 비밀번호가 현재 아이디의 비밀번호와 같으면 회원 탈퇴
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
	
	public List<String> passwdCheck(String password){		//현재 로그인한 아이디와 패스워드가 같은 열 생성. 다르면 생성되지 않음
															//나중에 리스트의 길이로 아이디와 패스워드 판단 가능
		
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
			e.printStackTrace();
			;
		}
		return passwd;
	}

	public List<MemberVO> allMembers() {					//패스워드를 제외한 모든 회원의 정보 리스트 리턴

		List<MemberVO> memberList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, name, phone_no, to_char(birthday,'yyyy-mm-dd')as birthday from members order by no");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phoneNo = rs.getString("phone_no");
				String birthday = rs.getString("birthday");
				
				MemberVO member = new MemberVO(no, id, name, phoneNo, birthday);

				memberList.add(member);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;

	}
	
	public void pwSujeong(String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("update members set password = ? where id = ?");
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, password);
			pstmt.setString(2, IDFactory.getID());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void nameSujeong(String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("update members set name = ? where id = ?");
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					){
				pstmt.setString(1, name);
				pstmt.setString(2, IDFactory.getID());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void phNSujeong(String phoneNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update members set phone_no = ? where id = ?");
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					){
				pstmt.setString(1, phoneNo);
				pstmt.setString(2, IDFactory.getID());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
