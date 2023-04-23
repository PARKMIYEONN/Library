package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.ILibEntrance;
import kr.ac.kopo.books.SearchAllBookUI;
import kr.ac.kopo.rental.SearchOne;

public class RentalUI extends BaseUI{

	private int rentalMenu() {
		System.out.println("********************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t도서 대출 메뉴");
		System.out.println("********************************************************************************************************************");
		
		
		System.out.println("1. 전체 도서 목록");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 대출");
		System.out.println("4. 회원 메뉴로 이동");
		Scanner sc = new Scanner(System.in);
		System.out.print("원하시는 항목을 입력하세요 : ");
		int type = sc.nextInt();
		sc.nextLine();
		return type;
	}
	
	@Override
	public void enter() throws Exception {
		while(true) {
			ILibEntrance door = null;
			int type = rentalMenu();
			switch(type) {
			case 1 : 
				door = new SearchAllBookUI();
				
				break;
			case 2 : 
				door = new SearchOne();
				
				break;
			case 3 :
				door = new DaeyeoUI();
				
				break;
			case 4 :
				door = new MyPageUI();
				
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
