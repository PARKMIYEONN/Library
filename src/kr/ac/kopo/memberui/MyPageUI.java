package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.Entrance.BaseUI;

public class MyPageUI extends BaseUI{
	
	private int menu() {
		System.out.println("1. 도서대출");
		System.out.println("2. 도서반납");
		System.out.println("3. 마이페이지");
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
			CheckOut coBook = new CheckOut();
			System.out.println("도서대출");
			break;
		case 2 :
			System.out.println("도서반납");
			break;
		case 3 :
			System.out.println("마이페이지");
			break;			
		}
	}

}
