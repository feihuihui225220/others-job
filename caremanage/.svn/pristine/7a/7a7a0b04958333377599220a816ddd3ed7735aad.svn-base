package com.anticw.aged.utils.file;

import java.util.Comparator;
import com.anticw.aged.vo.icare.ActiveVO;

public class SortByDate implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		ActiveVO za=(ActiveVO)o1;
		ActiveVO photo=(ActiveVO)o2;
		return photo.getCreatedAt().compareTo(za.getCreatedAt()); 
	}
	
}
