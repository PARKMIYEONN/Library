package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.ILibEntrance;
import kr.ac.kopo.rental.SearchAllRntBooks;

public class MypageUI02 extends BaseUI{
	
	private int mypagemenu() {
		System.out.println("*******************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t마이페이지");
		System.out.println("*******************************************************************************************************************");
		
		System.out.println("1. 내정보 2. 정보 수정 3. 이전 페이지");
		System.out.println("====================================================================================================================");

		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 항목을 선택하세요 : ");
		int my = sc.nextInt();
		sc.nextLine();
		return my;

	}

	@Override
	public void enter() throws Exception {
		while(true) {
			int my = mypagemenu();
			ILibEntrance door = null;
			switch(my) {
			case 1 :
				door = new SearchAllRntBooks();
				
				break;
			case 2 :
				door = new SujeongUI();
				break;
			case 3 :
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
