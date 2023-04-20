package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.ExitUI;
import kr.ac.kopo.Entrance.ILibEntrance;
import kr.ac.kopo.Entrance.LibEntrance;
import kr.ac.kopo.rental.SearchAllRntBooks;

public class MyPageUI extends BaseUI{
	
	private int menu() {
		System.out.println("************* 회원 메뉴 *************");
		System.out.println("1. 도서대출");
		System.out.println("2. 도서반납");
		System.out.println("3. 마이페이지");
		System.out.println("4. 회원탈퇴");		
		System.out.println("5. 로그아웃");
		System.out.println("6. 종료");
		System.out.println("===================================");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int act = sc.nextInt();
		sc.nextLine();
		return act;
	}
	
	@Override
	public void enter() throws Exception{
		int act = menu();
		ILibEntrance door = null;
		switch(act) {
		case 1 :
			door = new RentalUI();
			
			break;
		case 2 :
			door = new ReturnUI();
			
			
			break;
		case 3 :
			door = new SearchAllRntBooks();
			break;	
		case 4 :
			door = new TalUI();
			
			
			break;	
		case 5 :
			IDFactory idf = new IDFactory();
			idf.enitialID();
			idf.enitialBNO();
			door = new LibEntrance();
			
			break;	
		case 6 :
			door = new ExitUI();
			break;
			
		}
		if(door != null) {
			door.enter();
		} else {
			System.out.println("잘못입력하셨습니다");
		}
		
	}

}
