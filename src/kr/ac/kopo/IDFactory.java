package kr.ac.kopo;

public class IDFactory {
	
	private static String ID;
	private static int BOOK_NO;
	
	public IDFactory(String id) {
		IDFactory.ID = id;
	}
	
	public IDFactory(int bookNo) {
		IDFactory.BOOK_NO = bookNo;
	}
	
	public IDFactory() {
		
	}
	
	

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	public static int getBOOK_NO() {
		return BOOK_NO;
	}

	public static void setBOOK_NO(int bOOK_NO) {
		BOOK_NO = bOOK_NO;
	}

	public String enitialID() {
		IDFactory.ID = null;
		return IDFactory.ID;
	}
	
	public int enitialBNO() {
		IDFactory.BOOK_NO = 0;
		return IDFactory.BOOK_NO;
	}
	

}
