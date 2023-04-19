package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.rental.SearchAllRntBooks;
import kr.ac.kopo.rental.SearchOne;

public class RentalUI extends BaseUI{

	private int rentalMenu() {
		System.out.println("********** 도서 대출 메뉴 **********");
		System.out.println("1. 도서 검색");
		System.out.println("2. 도서 대출");
		System.out.println("3. 대출 도서 목록 출력");
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
			
			int type = rentalMenu();
			switch(type) {
			case 1 : 
				SearchOne so = new SearchOne();
				so.enter();
				break;
			case 2 :
				DaeyeoUI dy = new DaeyeoUI();
				dy.enter();
				break;
			case 3 :
				SearchAllRntBooks sarb = new SearchAllRntBooks();
				sarb.enter();
				break;
			case 4 :
				MyPageUI mpu = new MyPageUI();
				mpu.enter();
				break;
			}
		}
		
	}	

}
