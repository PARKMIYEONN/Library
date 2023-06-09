package kr.ac.kopo.administrator;

import java.util.Scanner;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.ILibEntrance;
import kr.ac.kopo.Entrance.LibEntrance;
import kr.ac.kopo.books.AddBooks;
import kr.ac.kopo.books.DelBooks;
import kr.ac.kopo.books.SearchAllBookUI;
import kr.ac.kopo.memberui.AllMemberUI;
import kr.ac.kopo.rental.AllRentalSaram;

public class AdminPage extends BaseUI{
	
	private int adminMenu() {
		System.out.println("*******************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t관리자 모드");
		System.out.println("*******************************************************************************************************************");
		System.out.println("1. 도서등록");
		System.out.println("2. 도서삭제");
		System.out.println("3. 도서 목록 출력");
		System.out.println("4. 회원 목록 출력");
		System.out.println("5. 대출 현황 출력");
		System.out.println("6. 로그아웃");
		
		System.out.println("====================================================================================================================");

		Scanner sc = new Scanner(System.in);
		System.out.print("원하시는 항목을 입력하세요 : ");
		int type = sc.nextInt();
		sc.nextLine();
		return type;
		
	}
	
	@Override
	public void enter() throws Exception{
		while(true) {
			
			int type = adminMenu();
			ILibEntrance door = null;
			switch(type) {
			case 1 :
				door = new AddBooks();
				
				break;
			case 2 :
				door = new DelBooks();
				
				break;
			case 3 :
				door = new SearchAllBookUI();
				
				break;
			case 4 :
				door = new AllMemberUI();
				
				break;
			case 5 :
				door = new AllRentalSaram();
				
				break;
			case 6 :
				IDFactory idf = new IDFactory();
				idf.enitialID();
				idf.enitialBNO();
				door = new LibEntrance();
				
				break;
			}
			if(door != null) {
				door.enter();
			} else {
				System.out.println("잘못입력하셨습니다");
			}
		}
		
	}

}
