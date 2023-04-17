package kr.ac.kopo;

import kr.ac.kopo.Entrance.LibEntrance;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		try {
			new LibEntrance().enter();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
