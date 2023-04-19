package kr.ac.kopo.administrator;

import java.util.Scanner;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.LibEntrance;
import kr.ac.kopo.books.AddBooks;
import kr.ac.kopo.books.DelBooks;
import kr.ac.kopo.books.SearchAllUI;

public class AdminPage extends BaseUI{
	
	private int adminMenu() {
		System.out.println("************* 관리자 모드 *************");
		System.out.println("1. 도서등록");
		System.out.println("2. 도서삭제");
		System.out.println("3. 도서 목록 출력");
		System.out.println("4. 대출 현황 출력");
		System.out.println("5. 로그아웃");
		
		System.out.println("====================================");
		Scanner sc = new Scanner(System.in);
		System.out.print("원하시는 항목을 입력하세요 : ");
		int type = sc.nextInt();
		return type;
		
	}
	
	@Override
	public void enter() throws Exception{
		while(true) {
			
			int type = adminMenu();
			switch(type) {
			case 1 :
				AddBooks ab = new AddBooks();
				ab.enter();
				break;
			case 2 :
				DelBooks dbs = new DelBooks();
				dbs.enter();
				break;
			case 3 :
				SearchAllUI sa = new SearchAllUI();
				sa.enter();
				break;
			case 4 :
				IDFactory idf = new IDFactory();
				idf.enitialID();
				idf.enitialBNO();
				LibEntrance le = new LibEntrance();
				le.enter();
				break;
			}
		}
		
	}

}
