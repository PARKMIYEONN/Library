package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.LibEntrance;

public class MyPageUI extends BaseUI{
	
	private int menu() {
		System.out.println("************* 회원 메뉴 *************");
		System.out.println("1. 도서대출");
		System.out.println("2. 도서반납");
		System.out.println("3. 마이페이지");
		System.out.println("4. 로그아웃");
		System.out.println("5. 종료");
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
		switch(act) {
		case 1 :
			RentalUI rt = new RentalUI();
			rt.enter();
			break;
		case 2 :
			ReturnUI rtn = new ReturnUI();
			rtn.enter();
			System.out.println("도서반납");
			break;
		case 3 :
			System.out.println("마이페이지");
			break;	
		case 4 :
			IDFactory idf = new IDFactory();
			idf.enitialID();
			idf.enitialBNO();
			LibEntrance le = new LibEntrance();
			le.enter();
			break;	
		case 5 :
			System.out.println("도서 관리 프로그램을 종료합니다");
			System.exit(0);
			
		}
	}

}
