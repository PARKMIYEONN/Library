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

}
