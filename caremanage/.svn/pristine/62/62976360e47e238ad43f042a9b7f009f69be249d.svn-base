package com.anticw.aged.service.professional.handle;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessHandleTree;

@Service
public class HandleTreeService {

	public MAssessHandleTree handled(MAssessHandle mHandleTree) throws IllegalAccessException, InvocationTargetException{
		MAssessHandleTree mTree = new MAssessHandleTree(); 
		mTree.setUserId(mHandleTree.getUserId());
		
		mTree.setSex(mHandleTree.getSex());
		Integer age = mHandleTree.getAge();
		if (age < 70) {
				age = 1;
			} else if (70 <=age && age <=74) {
				age = 2;
			} else if (75 <=age && age <=79) {
				age = 3;
			} else if (80 <=age && age <=84){
				age = 4;
			} else{
				age = 5;
			}
		mTree.setAge(age);
		Integer nation = mHandleTree.getNation();
		if (nation != null) {
			if (nation != 1) {
				nation = 2;
			}
			mTree.setNation(nation);
		}
		Integer sheng = mHandleTree.getSheng();
		 /**
		  * 东部：北京1、天津2、河北3、上海9、江苏10、浙江11、福建13、山东15、广东19、海南21
		  * 东北部:辽宁6、吉林7、黑龙江8
		  * 中部：山西4、安徽12、江西14、河南16、湖北17、湖南18
		  * 西部：内蒙古、广西、重庆、四川、贵州、云南、西藏、陕西、甘肃、青海、宁夏、新疆
		  */
		
		if (sheng != null) {
			if ("1,2,3,9,10,11,13,15,19,21".contains(sheng + "")) {
				sheng = 1;
			} else if ("6,7,8".contains(sheng + "")) {
				sheng = 2;
			} else if ("4,12,14,16,17,18".contains(sheng + "")) {
				sheng = 3;
			} else {
				sheng = 4;
			}
			mTree.setSheng(sheng);
		}
		Integer education = mHandleTree.getEducation();
		if (education != null) {
			if (education < 1) {
				education = 1;
			} else if (1 <= education && education <= 6) {
				education = 2;
			} else if (6 < education && education <= 9) {
				education = 3;
			} else if (9 < education && education <= 12) {
				education = 4;
			} else {
				education = 5;
			}
			mTree.setEducation(education);
		}
		Integer job= mHandleTree.getJob();
		if (job != null) {
			if (job == 0 || job == 1 || job == 2) {
				job = 0;
			} else {
				job = 1;
			}
			mTree.setJob(job);
		}
		Integer sourceincome = mHandleTree.getSourceincome();
		if (sourceincome != null) {
			if (sourceincome == 1) {
				sourceincome = 1;
			} else if (sourceincome == 2 || sourceincome == 3
					|| sourceincome == 4 || sourceincome == 5) {
				sourceincome = 2;
			} else if (sourceincome == 6) {
				sourceincome = 4;
			} else if (sourceincome == 7) {
				sourceincome = 3;
			} else {
				sourceincome = 5;
			}
			mTree.setSourceincome(sourceincome);
		}
		mTree.setBooleanIncome(mHandleTree.getBooleanIncome());
		mTree.setLivewith(mHandleTree.getLivewith());
		mTree.setResidenc(mHandleTree.getResidenc());
		Integer economic = mHandleTree.getEconomic();
		if (economic != null) {
			if (economic == 1 || economic == 2) {
				economic = 1;
			} else if (economic == 3) {
				economic = 2;
			} else {
				economic = 3;
			}
			mTree.setEconomic(economic);
		}
		Integer marriage = mHandleTree.getMarriage();
		if (marriage != null) {
			if (marriage == 1 || marriage == 2) {
				marriage = 1;
			} else {
				marriage = 2;
			}
			mTree.setMarriage(marriage);
		}
		
		Integer b23 = mHandleTree.getB23();
		if (b23 != null) {
			if (b23 == 1 || b23 == 2) {
				b23 = 1;
				 
			} else if (b23 == 3) {
				b23 = 2;
			} else {
				b23 = 3;
			}
			mTree.setB23(b23);
		}
		Integer b24 = mHandleTree.getB24();
		if (b24 != null) {
			if (b24 == 1 || b24 == 2) {
				b24 = 1;
				 
			} else if (b24 == 3) {
				b24 = 2;
			} else {
				b24 = 3;
			}
			mTree.setB24(b24);
		}
		 
		 
		Integer d41  = mHandleTree.getD41();
		mTree.setD41(d41);
		Integer e1 = mHandleTree.getE1();
		Integer e2 = mHandleTree.getE2();
		Integer e3 = mHandleTree.getE3();
		Integer e4 = mHandleTree.getE4();
		Integer e5 = mHandleTree.getE5();
		Integer e6 = mHandleTree.getE6();
		Integer econ = 0;
		if (e1 != null && e2 != null && e3 != null && e4 != null && e5 != null && e6 != null) {
			if (e1 == 3 || e2 == 3 || e3 == 3 || e4 == 3 || e5 == 3 || e6 == 3) {
				econ = 1;
			} else {
				econ = 0;
			}
			mTree.setECon(econ);
		}
		Integer f11 = mHandleTree.getF11();
		mTree.setF11(f11);
		Integer f31 = mHandleTree.getF31();
		if (f31 != null) {
			if (f31 == 1 || f31 == 2) {
				f31 = 1;//做家务多
			}else{
				f31 = 2;//做家务少
			}
			mTree.setF31(f31);
		}
		
		Integer f38 = mHandleTree.getF38();
		if (f38 != null) {
			if (f31 == 1 || f38 == 2) {
				f38 = 1;  // 参加社会活动多
			}else{      // 参加社会活动少
				f38 = 2;
			}
			mTree.setF38(f38);
		}

		Integer g01 = mHandleTree.getG01()==null?0:1;
		Integer g02 = mHandleTree.getG02()==null?0:1;
		Integer g03 = mHandleTree.getG03()==null?0:1;
		Integer g04 = mHandleTree.getG04()==null?0:1;
		Integer g05 = mHandleTree.getG05()==null?0:1;
		Integer g06 = mHandleTree.getG06()==null?0:1;
		Integer g07 = mHandleTree.getG07()==null?0:1;
		Integer g08 = mHandleTree.getG08()==null?0:1;
		Integer g09 = mHandleTree.getG09()==null?0:1;
		Integer g11 = mHandleTree.getG11()==null?0:1;
		Integer g12 = mHandleTree.getG12()==null?0:1;
		Integer g13 = mHandleTree.getG13()==null?0:1;
		Integer g14 = mHandleTree.getG14()==null?0:1;
		Integer g15 = mHandleTree.getG15()==null?0:1;
		Integer gcon = 0;
		if (g01 ==1) {
			gcon++;
		}
		if (g02 ==1) {
			gcon++;
		}
		if (g03 ==1) {
			gcon++;
		}
		if (g04 ==1) {
			gcon++;
		}
		if (g05 ==1) {
			gcon++;
		}
		if (g06 ==1) {
			gcon++;
		}
		if (g07 ==1) {
			gcon++;
		}
		if (g08 ==1) {
			gcon++;
		}
		if (g09 ==1) {
			gcon++;
		}
		if (g11 ==1) {
			gcon++;
		}
		if (g12 ==1) {
			gcon++;
		}
		if (g13 ==1) {
			gcon++;
		}
		if (g14 ==1) {
			gcon++;
		}
		if (g15 ==1) {
			gcon++;
		}
		if (gcon >= 0) {
			mTree.setGJibing(1);  // 有疾病
		} else {
			mTree.setGJibing(2); // 没有疾病
		}

		return mTree;
	}
}
