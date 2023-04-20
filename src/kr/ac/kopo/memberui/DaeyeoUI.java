package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.IDFactory;
import kr.ac.kopo.Entrance.BaseUI;
import kr.ac.kopo.service.RentalService;
import kr.ac.kopo.vo.RentalVO;

public class DaeyeoUI extends BaseUI{
	
	private RentalService rentDao;
   
    
	public DaeyeoUI() {
		rentDao = new RentalService();
		
	}

	@Override
	public void enter() throws Exception {
		
		int bookNo = scanInt("대여할 책의 고유번호를 입력하세요 : ");
		
		List<Integer> bNolist = rentDao.rentBNO(bookNo);
		
		if(bNolist.size() == 0) {
			
			IDFactory.setBOOK_NO(bookNo);
			String id = IDFactory.getID();
			
			RentalVO rntBook = new RentalVO();
			
			rntBook.setId(id);
			rntBook.setBookNo(bookNo);
			
			
			rentDao.rentBook(rntBook);
			
			System.out.println(rntBook + "대여완료");
		} else {
			System.out.println("해당 책은 대여중입니다");
		}
			
		
		MyPageUI mpu = new MyPageUI();
		mpu.enter();
		
	}
	

}
