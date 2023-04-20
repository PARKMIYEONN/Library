package kr.ac.kopo.vo;

public class BillyeoVO {
	
	private int no;
	private String id;
	private String password;
	private String name;
	private String phoneNo;
	private String birthday;
	private int bookNo;
	private String bookTitle;
	private String bookWriter;
	private String bookPublisher;
	private String rntDate;
	private String rtDate;
	
	public BillyeoVO() {
		
	}
	
	

	





	public BillyeoVO(int bookNo, String bookTitle, String bookWriter, String bookPublisher) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
	}









	public BillyeoVO(int no, String id, String name, String phoneNo, String birthday, int bookNo, String bookTitle,
			String bookWriter, String bookPublisher, String rntDate, String rtDate) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.birthday = birthday;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.rntDate = rntDate;
		this.rtDate = rtDate;
	}





	public BillyeoVO(int no, String id, String password, String name, String phoneNo, String birthday, int bookNo,
			String bookTitle, String bookWriter, String bookPublisher, String rntDate, String rtDate) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNo = phoneNo;
		this.birthday = birthday;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.rntDate = rntDate;
		this.rtDate = rtDate;
	}



	public String getRtDate() {
		return rtDate;
	}



	public void setRtDate(String rtDate) {
		this.rtDate = rtDate;
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

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getRntDate() {
		return rntDate;
	}

	public void setRntDate(String rntDate) {
		this.rntDate = rntDate;
	}
	
	



	@Override
	public String toString() {
		return "BillyeoVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", phoneNo="
				+ phoneNo + ", birthday=" + birthday + ", bookNo=" + bookNo + ", bookTitle=" + bookTitle
				+ ", bookWriter=" + bookWriter + ", bookPublisher=" + bookPublisher + ", rntDate=" + rntDate
				+ ", rtDate=" + rtDate + "]";
	}


	
	
	
	

}
