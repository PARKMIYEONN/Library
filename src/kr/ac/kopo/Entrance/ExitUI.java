package kr.ac.kopo.Entrance;

public class ExitUI extends BaseUI {

	@Override
	public void enter() throws Exception {
		System.out.println("===========================================");
		System.out.println("\t도서 관리 프로그램을 종료합니다.");
		System.out.println("===========================================");
		System.exit(0);

	}

}
