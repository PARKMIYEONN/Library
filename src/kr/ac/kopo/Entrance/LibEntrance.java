package kr.ac.kopo.Entrance;

import java.util.Scanner;

public class LibEntrance extends BaseUI{
	
	private int logInMenu() {
		System.out.println("************* 도서 관리 프로그램 *************");
		System.out.println(" 1. 로그인   2. 회원가입  3. 종료");
		System.out.println("==========================================");
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 항목을 선택하세요 : ");
		int log = sc.nextInt();
		sc.nextLine();
		return log;
	}
	
	@Override
	public void enter() throws Exception{
		while(true) {		
			int log = logInMenu();
			ILibEntrance door = null;
			switch(log) {
			case 1 : 
				door = new LogInUI();
						
				break;
			case 2 :
				door = new JoinUI();
				
				break;
			case 3 :
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

}
