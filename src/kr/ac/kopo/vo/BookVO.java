package kr.ac.kopo.vo;

public class BookVO {
	
	private int bookNO;
	private String bookTitle;
	private String bookWriter;
	private String bookPublisher;
	
	public BookVO() {
		
	}



	public BookVO(int bookNO, String bookTitle, String bookWriter, String bookPublisher) {
		super();
		this.bookNO = bookNO;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
	}

	public int getBookNO() {
		return bookNO;
	}

	public void setBookNO(int bookNO) {
		this.bookNO = bookNO;
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

	@Override
	public String toString() {
		return "BookVO [bookNO=" + bookNO + ", bookTitle=" + bookTitle + ", bookWriter=" + bookWriter
				+ ", bookPublisher=" + bookPublisher + "]";
	}
	
	

}
