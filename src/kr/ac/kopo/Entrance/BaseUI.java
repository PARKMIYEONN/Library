package kr.ac.kopo.Entrance;

import java.util.Scanner;

public abstract class BaseUI implements ILibEntrance{
	
	private Scanner sc;
	
	public BaseUI() {		//UI에서만 사용할 수 있으면 되니까 protected로 만들어보자
		sc = new Scanner(System.in);	
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

}
