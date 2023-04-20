package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BillyeoDAO;
import kr.ac.kopo.vo.BillyeoVO;

public class BillyeoService {
	
	private BillyeoDAO billyeoDao;
	
	public BillyeoService() {
		billyeoDao = new BillyeoDAO();
	}
	
	public List<BillyeoVO> billin(){
		List<BillyeoVO> billyeoList = billyeoDao.billinsaram();
		return billyeoList;
	}
	
	public List<BillyeoVO> billinAll(){
		List<BillyeoVO> billyeoList = billyeoDao.billinsaramAll();
		return billyeoList;
	}
	
	public int billi(String allofBook) {
		int billin = billyeoDao.billinBook(allofBook);
		return billin;
	}

}
