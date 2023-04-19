package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.RentalDAO;
import kr.ac.kopo.vo.RentalVO;

public class RentalService {
	
	private RentalDAO rentDao;

	public RentalService() {
		rentDao = new RentalDAO();
	}
	
	public void rentBook(RentalVO rent) {
		rentDao.rentBook(rent);
	}
	
	public List<Integer> rentBNO(int bNO){
		List<Integer> bNOlist = rentDao.selectbyBookNo(bNO);
		return bNOlist;
	}
	
	public void returnB(int bNo) {
		rentDao.returnBook(bNo);;
	}
	
	

}
