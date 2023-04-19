package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.RentalService;

public class ReturnUI extends BaseUI{
	
	private RentalService rentDao;
	
	public ReturnUI() {
		rentDao = new RentalService();
	}

	@Override
	public void enter() throws Exception {
		
		int bookNo = scanInt("반납할 책의 고유번호를 입력하세요 : ");
		List<Integer> bNolist = rentDao.rentBNO(bookNo);
		
		if(bNolist.size() != 0) {
			rentDao.returnB(bookNo);
			System.out.println("반납이 완료되었습니다");
		} else {
			System.out.println("대여중인 책이 아닙니다");
		}
		
		MyPageUI mpg = new MyPageUI();
		mpg.enter();
		
	}
	
	

}
