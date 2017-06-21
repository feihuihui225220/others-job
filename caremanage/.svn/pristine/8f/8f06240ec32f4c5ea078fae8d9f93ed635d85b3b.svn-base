package com.anticw.aged.service.professional.handle;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessHandled;

@Service
public class HandleToolService {

	public MAssessHandled handled(MAssessHandle mAssessHandle) throws IllegalAccessException, InvocationTargetException{
		MAssessHandled m = new MAssessHandled(); 
		m.setUserId(mAssessHandle.getUserId());
		Integer age = mAssessHandle.getAge();
		 if (age != null) {
			 if (age < 70) {
					age = 1;
				} else if (70 <=age && age <=79) {
					age = 2;
				} else if (80 <=age && age <=89) {
					age = 3;
				} else if (90 <=age && age <=99){
					age = 4;
				} else{
					age = 5;
				}
			 m.setAge(age);
		}
		 
		m.setSex(mAssessHandle.getSex());
		Integer age1 = mAssessHandle.getAge();
		if (age1 < 70) {
				age1 = 1;
			} else if (70 <=age1 && age1 <=74) {
				age = 2;
			} else if (75 <=age1 && age1 <=79) {
				age1 = 3;
			} else if (80 <=age1 && age1 <=84){
				age1 = 4;
			} else{
				age1 = 5;
			}
		m.setAge1(age1);
		Integer nation = mAssessHandle.getNation();
		if (nation != null) {
			if (nation != 1) {
				nation = 2;
			}
			m.setNation(nation);
		}
		Integer sheng = mAssessHandle.getSheng();
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
			m.setSheng(sheng);
		}
		Integer education = mAssessHandle.getEducation();
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
			m.setEducation(education);
		}
		Integer job= mAssessHandle.getJob();
		if (job != null) {
			if (job == 0 || job == 1 || job == 2) {
				job = 0;
			} else {
				job = 1;
			}
			m.setJob(job);
		}
		Integer sourceincome = mAssessHandle.getSourceincome();
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
			m.setSourceincome(sourceincome);
		}
		m.setBooleanIncome(mAssessHandle.getBooleanIncome());
		m.setLivewith(mAssessHandle.getLivewith());
		m.setResidenc(mAssessHandle.getResidenc());
		Integer economic = mAssessHandle.getEconomic();
		if (economic != null) {
			if (economic == 1 || economic == 2) {
				economic = 1;
			} else if (economic == 3) {
				economic = 2;
			} else {
				economic = 3;
			}
			m.setEconomic(economic);
		}
		Integer marriage = mAssessHandle.getMarriage();
		if (marriage != null) {
			if (marriage == 1 || marriage == 2) {
				marriage = 1;
			} else {
				marriage = 2;
			}
			m.setMarriage(marriage);
		}
		Integer b11 = mAssessHandle.getB11();
		Integer goodEmotion = 0;
		Integer badEmotion = 0;
		if (b11 != null) {
			if (b11 == 1 || b11 == 2) {
				b11 = 1;
				goodEmotion++;
			} else if (b11 == 3) {
				b11 = 2;
			} else {
				b11 = 3;
			}
			m.setB11(b11);
		}
		Integer b12 = mAssessHandle.getB12();
		if (b12 != null) {
			if (b12 == 1 || b12 == 2) {
				b12 = 1;
				goodEmotion++;
			} else if (b12 == 3) {
				b12 = 2;
			} else {
				b12 = 3;
			}
			m.setB12(b12);
		}
		Integer b13 = mAssessHandle.getB13();
      	if (b13 != null) {
			if (b13 == 1 || b13 == 2) {
				b13 = 1;
				goodEmotion++;
			} else if (b13 == 3) {
				b13 = 2;
			} else {
				b13 = 3;
			}
			m.setB13(b13);
		}
		Integer b21 = mAssessHandle.getB21();
		if (b21 != null) {
			if (b21 == 1 || b21 == 2) {
				b21 = 1;
				goodEmotion++;
			} else if (b21 == 3) {
				b21 = 2;
			} else {
				b21 = 3;
			}
			m.setB21(b21);
		}
		Integer b22 = mAssessHandle.getB22();
		if (b22 != null) {
			if (b22 == 1 || b22 == 2) {
				b22 = 1;
				goodEmotion++;
			} else if (b22 == 3) {
				b22 = 2;
			} else {
				b22 = 3;
			}
			m.setB22(b22);
		}
		Integer b23 = mAssessHandle.getB23();
		if (b23 != null) {
			if (b23 == 1 || b23 == 2) {
				b23 = 1;
				badEmotion++;
			} else if (b23 == 3) {
				b23 = 2;
			} else {
				b23 = 3;
			}
			m.setB23(b23);
		}
		Integer b24 = mAssessHandle.getB24();
		if (b24 != null) {
			if (b24 == 1 || b24 == 2) {
				b24 = 1;
				badEmotion++;
			} else if (b24 == 3) {
				b24 = 2;
			} else {
				b24 = 3;
			}
			m.setB24(b24);
		}
		Integer b25 = mAssessHandle.getB25();
		if (b25 != null) {
			if (b25 == 1 || b25 == 2) {
				b25 = 1;
			} else if (b25 == 3) {
				b25 = 2;
			} else {
				b25 = 3;
			}
			m.setB25(b25);
		}
		Integer b26 = mAssessHandle.getB26();
		if (b26 != null) {
			if (b26 == 1 || b26 == 2) {
				b26 = 1;
				badEmotion++;
			} else if (b26 == 3) {
				b26 = 2;
			} else {
				b26 = 3;
			}
			m.setB26(b26);
		}
		Integer b27 = mAssessHandle.getB27();
		if (b27 != null) {
			if (b27 == 1 || b27 == 2) {
				b27 = 1;
				goodEmotion++;
			} else if (b27 == 3) {
				b27 = 2;
			} else {
				b27 = 3;
			}
			m.setB27(b27);
		}
		m.setGoodEmotion(goodEmotion);
		m.setBadEmotion(badEmotion);
		Integer score = 0;
		Integer c11 = mAssessHandle.getC11();
		if (c11 != null) {
			if (c11 == 1) {
				score++;
			}
			m.setC11(c11);
		}
		Integer c12 = mAssessHandle.getC12();
		if (c12 != null) {
			if (c12 == 1) {
				score++;
			}
			m.setC12(c12);
		}
		Integer c13 = mAssessHandle.getC13();
		if (c13 != null) {
			if (c13 == 1) {
				score++;
			}
			m.setC13(c13);
		}
		Integer c14 = mAssessHandle.getC14();
		if (c14 != null) {
			if (c14 == 1) {
				score++;
			}
			m.setC14(c14);
		}
		Integer c15 = mAssessHandle.getC15();
		if (c15 != null) {
			if (c15 == 1) {
				score++;
			}
			m.setC15(c15);
		}
		Integer c16 = mAssessHandle.getC16();
		if (c16 != null) {
			if (c16 == 1) {
				score++;
			}
			m.setC16(c16);
		}
		Integer c211 = mAssessHandle.getC211();   
		if (c211 != null) {
			if (c211 == 1) {
				score++;
			}
			m.setC211(c211);
		}
		Integer c212 = mAssessHandle.getC212();  
		if (c212 != null) {
			if (c212 == 1) {
				score++;
			}
			m.setC212(c212);
		}
		Integer c213 = mAssessHandle.getC213();
		if (c213 != null) {
			if (c213 == 1) {
				score++;
			}
			m.setC213(c213);
		}
		Integer c22 = mAssessHandle.getC22();
		if (c22 != null) {
			if (c22 == 1) {
				score++;
			}
			m.setC22(c22);
		}
		Integer c311 = mAssessHandle.getC311(); 
		if (c311 != null) {
			if (c311 == 1) {
				score++;
			}
			m.setC311(c311);
		}
		Integer c312 = mAssessHandle.getC312();
		if (c312 != null) {
			if (c312 == 1) {
				score++;
			}
			m.setC312(c312);
		}
		Integer c313 = mAssessHandle.getC313();
		if (c313 != null) {
			if (c313 == 1) {
				score++;
			}
			m.setC313(c313);
		}
		Integer c314 = mAssessHandle.getC314();
		if (c314 != null) {
			if (c314 == 1) {
				score++;
			}
			m.setC314(c314);
		}
		Integer c315 = mAssessHandle.getC315();
		if (c315 != null) {
			if (c315 == 1) {
				score++;
			}
			m.setC315(c315);
		}
		Integer c32 = mAssessHandle.getC312();
		if (c32 != null) {
			if (c32 == 1) {
				score++;
			}
			m.setC32(c32);
		}
		Integer c411 = mAssessHandle.getC411();
		if (c411 != null) {
			if (c411 == 1) {
				score++;
			}
			m.setC411(c411);
		}
		Integer c412 = mAssessHandle.getC412();
		if (c412 != null) {
			if (c412 == 1) {
				score++;
			}
			m.setC412(c412);
		}
		Integer c413 = mAssessHandle.getC413();
		if (c413 != null) {
			if (c413 == 1) {
				score++;
			}
			m.setC413(c413);
		}
		Integer c511 =  mAssessHandle.getC511();
		if (c511 != null) {
			if (c511 == 1) {
				score++;
			}
			m.setC511(c511);
		}
		Integer c512 = mAssessHandle.getC512();
		if (c512 != null) {
			if (c512 == 1) {
				score++;
			}
			m.setC512(c512);
		}
		Integer c52 = mAssessHandle.getC52();
		if (c52 != null) {
			if (c52 == 1) {
				score++;
			}
			m.setC52(c52);
		}
		Integer c521 =mAssessHandle.getC521();
		if (c521 != null) {
			if (c521 == 1) {
				score++;
			}
			m.setC521(c521);
		}
		Integer c522 =mAssessHandle.getC522();
		if (c522 != null) {
			if (c522 == 1) {
				score++;
			}
			m.setC522(c522);
		}
		Integer c531 = mAssessHandle.getC531();
		if (c531 != null) {
			if (c531 == 1) {
				score++;
			}
			m.setC531(c531);
		}
		Integer c532 = mAssessHandle.getC532();
		if (c532 != null) {
			if (c532 == 1) {
				score++;
			}
			m.setC532(c532);
		}
		Integer c533 = mAssessHandle.getC533();
		if (c533 != null) {
			if (c533 == 1) {
				score++;
			}
			m.setC533(c533);
		}
		m.setScore(score);
		Integer d11 = mAssessHandle.getD11();
		Integer d12 = mAssessHandle.getD12();
		Integer dconstruct = 0;
		if (d11 != null) {
			if (d11 == 1) {
				dconstruct++;
			}
			m.setD11(d11);
		}
		if (d12 != null) {
			if (d12 == 1) {
				dconstruct++;
			}
			m.setD12(d12); 
		}
		m.setDConstruct(dconstruct);
		Integer dconnow = 0;
		Integer dconnow60 = 0;
		Integer d221 = mAssessHandle.getD221();
		if (d221 != null) {
			if (d221 == 1 || d221 == 2) {
				d221 = 1;
				dconnow++;
			} else if (d221 == 3 || d221 == 4) {
				d221 = 2;
			} else {
				d221 = 3;
			}
			m.setD221(d221);
		}
		Integer d2211  = mAssessHandle.getD2211();
		if (d2211 != null) {
			if (d2211 == 1 || d2211 == 2) {
				d2211 = 1;
				dconnow60++;
			} else if (d2211 == 3 || d2211 == 4) {
				d2211 = 2;
			} else {
				d2211 = 3;
			}
			m.setD2211(d2211);
		}
		Integer d222 = mAssessHandle.getD222();
		if (d222 != null) {
			if (d222 == 1 || d222 == 2) {
				dconnow++;
				d221 = 1;
			} else if (d222 == 3 || d222 == 4) {
				d222 = 2;
			} else {
				d222 = 3;
			}
			m.setD222(d222);
		}
		Integer d2221 = mAssessHandle.getD2221();
		if (d2221 != null) {
			if (d2221 == 1 || d2221 == 2) {
				d221 = 1;
				dconnow60++;
			} else if (d2221 == 3 || d2221 == 4) {
				d2221 = 2;
			} else {
				d2221 = 3;
			}
			m.setD2221(d2221);
		}
		Integer d223 = mAssessHandle.getD223();
		if (d223 != null) {
			if (d223 == 1 || d223 == 2) {
				d223 = 1;
				dconnow++;
			} else if (d223 == 3 || d223 == 4) {
				d223 = 2;
			} else {
				d223 = 3;
			}
			m.setD223(d223);
		}
		Integer d2231 = mAssessHandle.getD2231();
		if (d2231 != null) {
			if (d2231 == 1 || d2231 == 2) {
				d2231 = 1;
				dconnow60++;
			} else if (d2231 == 3 || d2231 == 4) {
				d2231 = 2;
			} else {
				d2231 = 3;
			}
			m.setD2231(d2231);
		}
		m.setDConnow(dconnow);
		m.setDConnow60(dconnow60);
		Integer d31  = mAssessHandle.getD31();
		Integer d32  = mAssessHandle.getD32();
		Integer d3Con = 0;
		if (d31 != null && d32 != null) {
			if (d31 == 1 && d32 == 1) {
				d3Con = 1;
			} else if (d31 == 1 && d32 == 2) {
				d3Con = 2;
			} else if (d31 == 2 && d32 == 1) {
				d3Con = 3;
			} else if (d31 == 2 && d32 == 2) {
				d3Con = 4;
			}
			m.setD31(d31);
			m.setD32(d32);
		}
		m.setD3Con(d3Con);
		Integer d41  = mAssessHandle.getD41();
		Integer d42 = mAssessHandle.getD42();
		Integer d4Con = 0;
		if (d41 != null && d42 != null) {
			if (d41 == 1 && d42 == 1) {
				d4Con = 1;
			} else if (d41 == 1 && d42 == 2) {
				d4Con = 2;
			} else if (d41 == 2 && d42 == 1) {
				d4Con = 3;
			} else if (d41 == 2 && d42 == 2) {
				d4Con = 4;
			}
			m.setD41(d41);
			m.setD42(d42);
		}
		m.setD4Con(d4Con);
		Integer e1 = mAssessHandle.getE1();
		Integer e2 = mAssessHandle.getE2();
		Integer e3 = mAssessHandle.getE3();
		Integer e4 = mAssessHandle.getE4();
		Integer e5 = mAssessHandle.getE5();
		Integer e6 = mAssessHandle.getE6();
		Integer econ = 0;
		if (e1 != null && e2 != null && e3 != null && e4 != null && e5 != null && e6 != null) {
			if (e1 == 3 || e2 == 3 || e3 == 3 || e4 == 3 || e5 == 3 || e6 == 3) {
				econ = 1;
			} else {
				econ = 0;
			}
			m.setE1(e1);
			m.setE2(e2);
			m.setE3(e3);
			m.setE4(e4);
			m.setE5(e5);
			m.setE6(e6);
			m.setECon(econ);
		}
		Integer f11 = mAssessHandle.getF11();
		Integer f12 = mAssessHandle.getF12();
		Integer f1con = 0;
		if (f11 !=null && f12 !=null) {
			if (f11 == 1 && f12 == 1) {
				f1con = 1;
			} else if (f11 == 1 && f12 == 2) {
				f1con = 2;
			} else if (f11 == 2 && f12 == 1) {
				f1con = 3;
			} else if (f11 == 2 && f12 == 2) {
				f1con = 4;
			}
			m.setF11(f11);
			m.setF12(f12);
			m.setF1Con(f1con);
		}
		m.setF21(mAssessHandle.getF21());
		Integer f3con = 0;
		Integer f3con1 = 0;
		Integer f31 = mAssessHandle.getF31();
		if (f31 != null) {
			if (f31 == 1 || f31 == 2) {
				f3con++;
			}
			m.setF31(f31);
		}
		Integer f32 = mAssessHandle.getF32();
		if (f32 != null) {
			if (f32 == 1 || f32 == 2) {
				f3con++;
			}
			m.setF32(f32);
		}
		Integer f33 = mAssessHandle.getF33();
		if (f33 != null) {
			if (f33 == 1 || f33 == 2) {
				f3con++;
			}
			m.setF33(f33);
		}
		Integer f34 = mAssessHandle.getF34();
		if (f34 != null) {
			if (f34 == 1 || f34 == 2) {
				f3con++;
			}
			m.setF34(f34);
		}
		Integer f35 = mAssessHandle.getF35();
		if (f35 != null) {
			if (f35 == 1 || f35 == 2) {
				f3con++;
			}
			m.setF35(f35);
		}
		Integer f36 = mAssessHandle.getF36();
		if (f36 != null) {
			if (f36 == 1 || f36 == 2) {
				f3con1++;
			}
			m.setF36(f36);
		}
		Integer f37 = mAssessHandle.getF37();
		if (f37 != null) {
			if (f37 == 1 || f37 == 2) {
				f3con++;
			}
			m.setF37(f37);
		}
		Integer f38 = mAssessHandle.getF38();
		if (f38 != null) {
			if (f31 == 8 || f38 == 2) {
				f3con1++;
			}
			m.setF38(f38);
		}
		m.setF3Con(f3con);
		m.setF3Con1(f3con1);
		
		m.setF4(mAssessHandle.getF4());
		
		Integer g1 = mAssessHandle.getG1();
		if (g1 != null) {
			if (g1 == 1 || g1 == 2) {
				g1 = 1;
			} else {
				g1 = 2;
			}
			m.setG1(g1);
		}
		Integer g01 = mAssessHandle.getG01()==null?0:1;
		Integer g02 = mAssessHandle.getG02()==null?0:1;
		Integer g03 = mAssessHandle.getG03()==null?0:1;
		Integer g04 = mAssessHandle.getG04()==null?0:1;
		Integer g05 = mAssessHandle.getG05()==null?0:1;
		Integer g06 = mAssessHandle.getG06()==null?0:1;
		Integer g07 = mAssessHandle.getG07()==null?0:1;
		Integer g08 = mAssessHandle.getG08()==null?0:1;
		Integer g09 = mAssessHandle.getG09()==null?0:1;
		Integer g10 = mAssessHandle.getG10()==null?0:1;
		Integer g11 = mAssessHandle.getG11()==null?0:1;
		Integer g12 = mAssessHandle.getG12()==null?0:1;
		Integer g13 = mAssessHandle.getG13()==null?0:1;
		Integer g14 = mAssessHandle.getG14()==null?0:1;
		Integer g15 = mAssessHandle.getG15()==null?0:1;
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
		if (g11 ==1) {
			gcon++;
		}
		if (g12 ==1) {
			gcon++;
		}
		if (g14 ==1) {
			gcon++;
		}
		if (g15 ==1) {
			gcon++;
		}
		if (gcon >= 0) {
			m.setGJibing(1);
		} else {
			m.setGJibing(2);
		}
		m.setG01(g01);
		m.setG02(g02);
		m.setG03(g03);
		m.setG04(g04);
		m.setG05(g05);
		m.setG06(g06);
		m.setG07(g07);
		m.setG08(g08);
		m.setG09(g09);
		m.setG10(g10);
		m.setG11(g11);
		m.setG12(g12);
		m.setG13(g13);
		m.setG14(g14);
		m.setG15(g15);
		m.setGCon(gcon);
		
		//BeanUtils.copyProperties(m, mAssessHandle);	
	
		return m;
	}
}
