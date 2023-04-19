package kr.ac.kopo.vo;

public class OriginVO {
	
	private int no;
	private String id;
	private String password;
	private String name;
	private String phoneNo;
	private String birthday;
	
	public OriginVO() {
		
	}

	public OriginVO(int no, String id, String password, String name, String phoneNo, String birthday) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNo = phoneNo;
		this.birthday = birthday;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "OriginVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", phoneNo="
				+ phoneNo + ", birthday=" + birthday + "]";
	}
	
	

}
