package kr.ac.kopo.vo;

public class RentalVO {
	
	private int rentNo;
	private String id;
	private int bookNo;
	private String rntDate;
	
	
	
	public RentalVO() {
		
	}

	public RentalVO(int rentNo, String id, int bookNo, String rntDate) {
		super();
		this.rentNo = rentNo;
		this.id = id;
		this.bookNo = bookNo;
		this.rntDate = rntDate;
	}

	public int getRentNo() {
		return rentNo;
	}

	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getRntDate() {
		return rntDate;
	}

	public void setRntDate(String rntDate) {
		this.rntDate = rntDate;
	}

	@Override
	public String toString() {
		return "RentalVO [rentNo=" + rentNo + ", id=" + id + ", bookNo=" + bookNo + ", rntDate=" + rntDate + "]";
	}

	
	
	
	
	

}
