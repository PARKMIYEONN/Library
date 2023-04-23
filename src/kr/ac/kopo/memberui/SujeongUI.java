package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.Entrance.ILibEntrance;

public class SujeongUI extends BaseUI{
	
	private int suj() {
		System.out.println("********************************************************************************************************************");
		System.out.println("\t\t\t\t\t\t정보 수정");
		System.out.println("********************************************************************************************************************");
		
		
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 이전 페이지");
		System.out.println("====================================================================================================================");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 항목을 선택하세요 : ");
		int su = sc.nextInt();
		sc.nextLine();
		return su;
	}

	@Override
	public void enter() throws Exception {
		while(true) {
			int su = suj();
			ILibEntrance door = null;
			switch(su) {
			case 1 :
				door = new PWSujeongUI();
				break;
			case 2 :
				door = new NameSujeongUI();
				break;
			case 3 :
				door = new PhNoSujeongUI();
				break;
			case 4 :
				door = new MypageUI02();
				break;
			}
			if(door != null) {
				door.enter();
			} else {
				System.out.println("잘못 입력하셨습니다");
			}
		}
		
	}
	
	
	

}
