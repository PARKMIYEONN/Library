package kr.ac.kopo.Entrance;

import java.util.Scanner;

public class LibEntrance extends BaseUI{
	
	private int logInMenu() {
		System.out.println("************* 도서 관리 프로그램 *************");
		System.out.println(" 1. 로그인   2. 회원가입  3. 관리자모드 4. 종료");
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 항목을 선택하세요 : ");
		int log = sc.nextInt();
		sc.nextLine();
		return log;
	}
	
	@Override
	public void enter() throws Exception{
		int log = logInMenu();
		ILibEntrance door = null;
		switch(log) {
		case 1 : 
			door = new LogInUI();
			door.enter();		
			break;
		case 2 :
			door = new JoinUI();
			door.enter();
			break;
		case 3 :
			System.out.println("관리자 모드");
			break;
		case 4 :
			System.out.println("**** 도서 관리 프로그램을 종료합니다 ****");
			System.exit(0);
		}
	}

}