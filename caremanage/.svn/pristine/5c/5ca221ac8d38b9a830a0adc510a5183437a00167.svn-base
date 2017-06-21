package com.anticw.aged.dao.professional.assess.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import com.anticw.aged.vo.professional.service.MPressureVO;
import com.anticw.aged.vo.professional.vender.FitnessVO1;
import com.anticw.aged.vo.professional.vender.FitnessVO2;
import com.anticw.aged.vo.professional.vender.MyBeanWithPerson;
import com.anticw.aged.vo.professional.vender.QuestionVO;
import com.anticw.aged.vo.professional.vender.RecordMOVO;
import com.anticw.aged.vo.professional.vender.RecordVO;

/**
 * 
 * @author DX-T检验
 *
 */
public class assessUtil {

	/**
	 * T对应数据之差的标准差
	 * @param sRe
	 * @param eRe
	 * @param d_
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Double getT(List<RecordVO> sRe,List<RecordVO> eRe,double d_){
		double score=0.0;
		for(int i=0;i<sRe.size();i++){
			RecordVO s=sRe.get(i);
			RecordVO e=eRe.get(i);
			double s_=0.0;
			double e_=0.0;
			 
			MyBeanWithPerson mb=getMyBeanWithPerson(s);
			List<QuestionVO> qu=mb.getResult();
			for(QuestionVO q:qu){
				s_+=Integer.parseInt(q.getScore());
			}
			 
			MyBeanWithPerson mb1=getMyBeanWithPerson(e);
			List<QuestionVO> qu1=mb1.getResult();
			for(QuestionVO q:qu1){
				e_+=Integer.parseInt(q.getScore());
			}
			score+=Math.pow(e_-s_-d_,2);
		}
		
		return score;
	}
	
	
	public static Double getTsls(List<FitnessVO1> recod,double d_,int calibrations){
		double score=0.0;
		for(FitnessVO1 v1:recod){
			double resulet=v1.getResultS();
			double resulet1=v1.getResultE();
			double s1=0.0;
			double e1=0.0;
			if (v1.getSex() == 0&&calibrations==5) {// 女性
				if (v1.getAge() < 65) {
					if(resulet<=52)s1+=5.0;else if(resulet<=60&&resulet>52)s1+=10.0;else if(resulet<=66 &&resulet>60 )s1+=15.0;else if(resulet<=71 &&resulet>66 )s1+=20.0;
					else if(resulet<=75 &&resulet>71 )s1+=25.0;else if(resulet<=79 &&resulet>75 )s1+=30.0;else if(resulet<=82 &&resulet>79 )s1+=35.0;else if(resulet<=85 &&resulet>82 )s1+=40.0;
					else if(resulet<=88 &&resulet>85 )s1+=45.0;else if(resulet<=91 &&resulet>88 )s1+=50.0;else if(resulet<=94 &&resulet>91 )s1+=55.0;else if(resulet<=97 &&resulet>94 )s1+=60.0;
					else if(resulet<=100 &&resulet>97 )s1+=65.0;else if(resulet<=103 &&resulet>100 )s1+=70.0;else if(resulet<=107 &&resulet>103 )s1+=75.0;else if(resulet<=111 &&resulet>107 )s1+=80.0;
					else if(resulet<=116 &&resulet>111 )s1+=85.0;else if(resulet<=122 &&resulet>116 )s1+=90.0;else if(resulet>122 )s1+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=47)s1+=5.0;else if(resulet<=57 &&resulet>47 )s1+=10.0;else if(resulet<=63 &&resulet>57 )s1+=15.0;
					else if(resulet<=68 &&resulet>63 )s1+=20.0;else if(resulet<=73 &&resulet>68 )s1+=25.0;else if(resulet<=76 &&resulet>73 )s1+=30.0;else if(resulet<=80 &&resulet>76 )s1+=35.0;
					else if(resulet<=84 &&resulet>80 )s1+=40.0;else if(resulet<=87 &&resulet>84 )s1+=45.0;else if(resulet<=90 &&resulet>87 )s1+=50.0;else if(resulet<=93 &&resulet>90 )s1+=55.0;
					else if(resulet<=96 &&resulet>93 )s1+=60.0;else if(resulet<=100 &&resulet>96 )s1+=65.0;else if(resulet<=104 &&resulet>100 )s1+=70.0;else if(resulet<=107 &&resulet>104 )s1+=75.0;
					else if(resulet<=112 &&resulet>107 )s1+=80.0;else if(resulet<=117 &&resulet>112 )s1+=85.0;else if(resulet<=123 &&resulet>117 )s1+=90.0;else if(resulet>123 )s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=43)s1+=5.0;else if(resulet<=52 &&resulet>43 )s1+=10.0;
					else if(resulet<=58 &&resulet>52 )s1+=15.0;else if(resulet<=63 &&resulet>58 )s1+=20.0;else if(resulet<=68 &&resulet>63 )s1+=25.0;else if(resulet<=71 &&resulet>68 )s1+=30.0;
					else if(resulet<=74 &&resulet>71 )s1+=35.0;else if(resulet<=78 &&resulet>74 )s1+=40.0;else if(resulet<=81 &&resulet>78 )s1+=45.0;else if(resulet<=84 &&resulet>81 )s1+=50.0;
					else if(resulet<=87 &&resulet>84 )s1+=55.0;else if(resulet<=90 &&resulet>87 )s1+=60.0;else if(resulet<=94 &&resulet>90 )s1+=65.0;else if(resulet<=97 &&resulet>94 )s1+=70.0;
					else if(resulet<=101 &&resulet>97 )s1+=75.0;else if(resulet<=105 &&resulet>101 )s1+=80.0;else if(resulet<=110 &&resulet>105 )s1+=85.0;else if(resulet>116 )s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=45)s1+=5.0;else if(resulet<=53 &&resulet>45 )s1+=10.0;else if(resulet<=59 &&resulet>53 )s1+=15.0;
					else if(resulet<=64 &&resulet>59 )s1+=20.0;else if(resulet<=68 &&resulet>64 )s1+=25.0;else if(resulet<=72 &&resulet>68 )s1+=30.0;else if(resulet<=75 &&resulet>72 )s1+=35.0;
					else if(resulet<=78 &&resulet>75 )s1+=40.0;else if(resulet<=81 &&resulet>78 )s1+=45.0;else if(resulet<=84 &&resulet>81 )s1+=50.0;else if(resulet<=87 &&resulet>84 )s1+=55.0;
					else if(resulet<=90 &&resulet>87 )s1+=60.0;else if(resulet<=93 &&resulet>90 )s1+=65.0;else if(resulet<=96 &&resulet>93 )s1+=70.0;else if(resulet<=100 &&resulet>96 )s1+=75.0;
					else if(resulet<=104 &&resulet>100 )s1+=80.0;else if(resulet<=109 &&resulet>104 )s1+=85.0;else if(resulet<=115 &&resulet>109 )s1+=90.0;else if(resulet>115 )s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=37)s1+=5.0;else if(resulet<=46 &&resulet>37 )s1+=10.0;else if(resulet<=51 &&resulet>46 )s1+=15.0;
					else if(resulet<=56 &&resulet>51 )s1+=20.0;else if(resulet<=60 &&resulet>56 )s1+=25.0;else if(resulet<=63 &&resulet>60  )s1+=30.0;else if(resulet<=66 &&resulet>63  )s1+=35.0;
					else if(resulet<=69 &&resulet>66  )s1+=40.0;else if(resulet<=72 &&resulet>69  )s1+=45.0;else if(resulet<=75 &&resulet>72  )s1+=50.0;else if(resulet<=78 &&resulet>75  )s1+=55.0;
					else if(resulet<=81 &&resulet>78  )s1+=60.0;else if(resulet<=84 &&resulet>81  )s1+=65.0;else if(resulet<=87 &&resulet>84  )s1+=70.0;else if(resulet<=90 &&resulet>87  )s1+=75.0;
					else if(resulet<=94 &&resulet>90  )s1+=80.0;else if(resulet<=99 &&resulet>94  )s1+=85.0;else if(resulet<=104 &&resulet>99 )s1+=90.0;else if(resulet>104  )s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=39)s1+=5.0;else if(resulet<=42 &&resulet>39 )s1+=10.0;else if(resulet<=47 &&resulet>42 )s1+=15.0;
					else if(resulet<=52 &&resulet>47 )s1+=20.0;else if(resulet<=55 &&resulet>52 )s1+=25.0;else if(resulet<=59 &&resulet>55 )s1+=30.0;else if(resulet<=61 &&resulet>59 )s1+=35.0;
					else if(resulet<=64 &&resulet>61 )s1+=40.0;else if(resulet<=67 &&resulet>64 )s1+=45.0;else if(resulet<=70 &&resulet>67 )s1+=50.0;else if(resulet<=73 &&resulet>70 )s1+=55.0;
					else if(resulet<=76 &&resulet>73 )s1+=60.0;else if(resulet<=79 &&resulet>76 )s1+=65.0;else if(resulet<=81 &&resulet>79 )s1+=70.0;else if(resulet<=85 &&resulet>81 )s1+=75.0;
					else if(resulet<=88 &&resulet>85 )s1+=80.0;else if(resulet<=93 &&resulet>88 )s1+=85.0;else if(resulet<=98 &&resulet>93 )s1+=90.0;else if(resulet>98  )s1+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet<=24)s1+=5.0;else if(resulet<=31 &&resulet>24 )s1+=10.0;else if(resulet<=36 &&resulet>31 )s1+=15.0;
					else if(resulet<=40 &&resulet>36 )s1+=20.0;else if(resulet<=44 &&resulet>40 )s1+=25.0;else if(resulet<=47 &&resulet>44 )s1+=30.0;else if(resulet<=50 &&resulet>47 )s1+=35.0;
					else if(resulet<=53 &&resulet>50 )s1+=40.0;else if(resulet<=55 &&resulet>53 )s1+=45.0;else if(resulet<=58 &&resulet>55 )s1+=50.0;else if(resulet<=61 &&resulet>58 )s1+=55.0;
					else if(resulet<=63 &&resulet>61 )s1+=60.0;else if(resulet<=66 &&resulet>63 )s1+=65.0;else if(resulet<=69 &&resulet>66 )s1+=70.0;else if(resulet<=72 &&resulet>69 )s1+=75.0;
					else if(resulet<=76 &&resulet>72 )s1+=80.0;else if(resulet<=80 &&resulet>76 )s1+=85.0;else if(resulet<=85 &&resulet>80 )s1+=90.0;else if(resulet>85  )s1+=95.0;
				}
			}
			if (v1.getSex() == 0&&calibrations==6) {// 女性
				if (v1.getAge() < 65) {
					if(resulet >=-6.4 &&resulet<-5.2 ) s1+=5.0;else if(resulet >=-5.2 &&resulet<-4.3 )  s1+=10.0;else if(resulet >= -4.3 &&resulet<-3.6 ) s1+=15.0;
					else if(resulet >=-3.6  &&resulet<-3 ) s1+=20.0;else if(resulet >= -3 &&resulet<-2.5 ) s1+=25.0;else if(resulet >=-2.5  &&resulet<-2.1 ) s1+=30.0;else if(resulet >= -2.1 &&resulet< -1.6) s1+=35.0;
					else if(resulet >= -1.6 &&resulet<-1.2 ) s1+=40.0;else if(resulet >= -1.2 &&resulet<-0.7 ) s1+=45.0;else if(resulet >= -0.7 &&resulet<-0.2 ) s1+=50.0;else if(resulet >= -0.2 &&resulet<0.2 ) s1+=55.0;
					else if(resulet >= 0.2 &&resulet< 0.7) s1+=60.0;else if(resulet >= 0.7 &&resulet< 1.1) s1+=65.0;else if(resulet >= 1.1 &&resulet< 1.6) s1+=70.0;else if(resulet >= 1.6 &&resulet<2.2 ) s1+=75.0;
					else if(resulet >= 2.2 &&resulet<2.9 ) s1+=80.0;else if(resulet >= 2.9 &&resulet<3.8 ) s1+=85.0;else if(resulet >= 3.8 &&resulet<5 ) s1+=90.0;else if(resulet >=  5 ) s1+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet >=-7.3 &&resulet<-5.9 ) s1+=5.0;else if(resulet >=-5.9 &&resulet< -5)  s1+=10.0;else if(resulet >= -5 &&resulet< -4.3) s1+=15.0;
					else if(resulet >= -4.3 &&resulet< -3.7) s1+=20.0;else if(resulet >= -3.7 &&resulet< -3.1) s1+=25.0;else if(resulet >= -3.1 &&resulet< -2.6) s1+=30.0;else if(resulet >= -2.6 &&resulet< -2.1) s1+=35.0;
					else if(resulet >= -2.1 &&resulet< -1.7) s1+=40.0;else if(resulet >= -1.7 &&resulet< -1.2) s1+=45.0;else if(resulet >= -1.2 &&resulet<-0.7 ) s1+=50.0;else if(resulet >= -0.7 &&resulet<-0.3 ) s1+=55.0;
					else if(resulet >= -0.3 &&resulet< 0.2) s1+=60.0;else if(resulet >= 0.2 &&resulet<0.7 ) s1+=65.0;else if(resulet >= 0.7 &&resulet<1.3 ) s1+=70.0;else if(resulet >= 1.3 &&resulet<1.9 ) s1+=75.0;
					else if(resulet >= 1.9 &&resulet<2.6 ) s1+=80.0;else if(resulet >= 2.6 &&resulet<3.5 ) s1+=85.0;else if(resulet >= 3.5 &&resulet<4.9 ) s1+=90.0;else if(resulet >= 4.9  ) s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=43)s1+=5.0;else if(resulet<=52 &&resulet>43 )s1+=10.0;
					if(resulet >=-7.9 &&resulet<-6.6 ) s1+=5.0;else if(resulet >=-6.6 &&resulet<-5.7 )  s1+=10.0;else if(resulet >=-5.7  &&resulet<-4.9 ) s1+=15.0;
					else if(resulet >=-4.9  &&resulet<-4.2 ) s1+=20.0;else if(resulet >=-4.2  &&resulet<-3.7 ) s1+=25.0;else if(resulet >=-3.7  &&resulet<-3.2 ) s1+=30.0;else if(resulet >=-3.2  &&resulet<-2.6 ) s1+=35.0;
					else if(resulet >=-2.6  &&resulet<-2.2 ) s1+=40.0;else if(resulet >=-2.2  &&resulet<-1.7 ) s1+=45.0;else if(resulet >=-1.7  &&resulet<-1.2 ) s1+=50.0;else if(resulet >=-1.2  &&resulet<-0.8 ) s1+=55.0;
					else if(resulet >=-0.8  &&resulet<-0.2 ) s1+=60.0;else if(resulet >=-0.2  &&resulet<0.3 ) s1+=65.0;else if(resulet >=0.3  &&resulet<0.8 ) s1+=70.0;else if(resulet >=0.8  &&resulet<1.5 ) s1+=75.0;
					else if(resulet >=1.5  &&resulet<2.3 ) s1+=80.0;else if(resulet >=2.3  &&resulet< 3.2) s1+=85.0;else if(resulet >=3.2  &&resulet<4.5 ) s1+=90.0;else if(resulet >= 4.5  ) s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=8.9  &&resulet>8.3 ) s1+=5.0;else if(resulet<=8.3  &&resulet>8 ) s1+=10.0;else if(resulet<=8  &&resulet>7.6 ) s1+=15.0;else if(resulet<=7.6  &&resulet>7.4 ) s1+=20.0;
					else if(resulet<=7.4  &&resulet>7.1 ) s1+=25.0;else if(resulet<=7.1  &&resulet>6.9 ) s1+=30.0;else if(resulet<=6.9  &&resulet>6.7 ) s1+=35.0;
					else if(resulet<=6.7  &&resulet>6.5 ) s1+=40.0;else if(resulet<=6.5  &&resulet>6.3 ) s1+=45.0;else if(resulet<=6.3  &&resulet>6.1 ) s1+=50.0;else if(resulet<=6.1  &&resulet>5.9 ) s1+=55.0;
					else if(resulet<=5.9  &&resulet>5.7 ) s1+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) s1+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) s1+=70.0;else if(resulet<=5.2  &&resulet>5 ) s1+=75.0;
					else if(resulet<=5  &&resulet>4.6 ) s1+=80.0;else if(resulet<=4.6  &&resulet>4.3 ) s1+=85.0;else if(resulet<=4.3  &&resulet>4 ) s1+=90.0;else if(resulet<=4   ) s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet >=-9.5 &&resulet<-8 ) s1+=5.0;else if(resulet >=-8 &&resulet<-7 )  s1+=10.0;else if(resulet >=-7  &&resulet<-6.1 ) s1+=15.0;
					else if(resulet >=-6.1  &&resulet<-5.4 ) s1+=20.0;else if(resulet >=-5.4  &&resulet<-4.8 ) s1+=25.0;else if(resulet >=-4.8  &&resulet<-4.2 ) s1+=30.0;else if(resulet >=-4.2  &&resulet<-3.7 ) s1+=35.0;
					else if(resulet >=-3.7  &&resulet<-3.1 ) s1+=40.0;else if(resulet >=-3.1  &&resulet<-2.6 ) s1+=45.0;else if(resulet >=-2.6  &&resulet<-2.1 ) s1+=50.0;else if(resulet >=-2.1  &&resulet<-1.6 ) s1+=55.0;
					else if(resulet >=-1.6 &&resulet< -1) s1+=60.0;else if(resulet >=  -1&&resulet<-0.4) s1+=65.0;else if(resulet >=  -0.4 &&resulet<  0.2 ) s1+=70.0;else if(resulet >= 0.2 &&resulet< 0.9 ) s1+=75.0;
					else if(resulet >= 0.9 &&resulet<1.8 ) s1+=80.0;else if(resulet >=  2.8&&resulet<2.8 ) s1+=85.0;else if(resulet >= 2.8  &&resulet<4.3 ) s1+=90.0;else if(resulet >= 4.3  ) s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet >=-11.3 &&resulet<-9.7 ) s1+=5.0;else if(resulet >=-9.7 &&resulet<-8.6 )  s1+=10.0;else if(resulet >=-8.6  &&resulet<-7.7 ) s1+=15.0;
					else if(resulet >=-7.7  &&resulet<-6.9 ) s1+=20.0;else if(resulet >=-6.9  &&resulet<-6.2 ) s1+=25.0;else if(resulet >=-6.2  &&resulet<-5.7 ) s1+=30.0;else if(resulet >=-5.7  &&resulet<-5 ) s1+=35.0;
					else if(resulet >=-5  &&resulet<-4.5 ) s1+=40.0;else if(resulet >=-4.5  &&resulet<-3.9 ) s1+=45.0;else if(resulet >=-3.9  &&resulet<-3.3 ) s1+=50.0;else if(resulet >=-3.3  &&resulet<-2.8 ) s1+=55.0;
					else if(resulet >=-2.8  &&resulet<-2.1 ) s1+=60.0;else if(resulet >=-2.1  &&resulet<-1.6 ) s1+=65.0;else if(resulet >=-1.6  &&resulet<-0.9 ) s1+=70.0;else if(resulet >=-0.9  &&resulet<-0.1 ) s1+=75.0;
					else if(resulet >=-0.1  &&resulet<1.8 ) s1+=80.0;else if(resulet >=1.8  &&resulet<1.9 ) s1+=85.0;else if(resulet >= 1.9 &&resulet<3.5 ) s1+=90.0;else if(resulet >= 3.5  ) s1+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet >=-13 &&resulet<-11.2 ) s1+=5.0;else if(resulet >=-11.2 &&resulet<-9.9 )  s1+=10.0;else if(resulet >=-9.9  &&resulet<-8.9 ) s1+=15.0;
					else if(resulet >=-8.9  &&resulet<-8 ) s1+=20.0;else if(resulet >=-8  &&resulet<-7.2 ) s1+=25.0;else if(resulet >= -7.2 &&resulet<-6.5 ) s1+=30.0;else if(resulet >= -6.5 &&resulet<-5.8 ) s1+=35.0;
					else if(resulet >= -5.8 &&resulet<-5.2 ) s1+=40.0;else if(resulet >=-5.2  &&resulet<-4.5 ) s1+=45.0;else if(resulet >=-4.5  &&resulet<-3.8 ) s1+=50.0;else if(resulet >= -3.8 &&resulet<-3.2 ) s1+=55.0;
					else if(resulet >= -3.2 &&resulet<-2.5 ) s1+=60.0;else if(resulet >=-2.5  &&resulet<-1.8 ) s1+=65.0;else if(resulet >=-1.8  &&resulet<-1 ) s1+=70.0;else if(resulet >=-1  &&resulet<-0.1 ) s1+=75.0;
					else if(resulet >=-0.1  &&resulet<0.9 ) s1+=80.0;else if(resulet >=0.9  &&resulet<2.2 ) s1+=85.0;else if(resulet >=2.2  &&resulet<3.9 ) s1+=90.0;else if(resulet >=3.9   ) s1+=95.0;
				}
			}
			if (v1.getSex() == 0&&calibrations==7) {// 女性
				if (v1.getAge() < 65) {
					
					 if(resulet<=7.2  &&resulet>6.7 ) s1+=5.0;else if(resulet<=6.7  &&resulet>6.4 ) s1+=10.0;else if(resulet<=6.4  &&resulet>6.2 ) s1+=15.0;
					else if(resulet<=6.2  &&resulet>6 ) s1+=20.0;else if(resulet<=6  &&resulet>5.8 ) s1+=25.0;else if(resulet<=5.8  &&resulet>5.7 ) s1+=30.0;else if(resulet<=5.7  &&resulet>5.5 ) s1+=35.0;
					else if(resulet<=5.5  &&resulet>5.4 ) s1+=40.0;else if(resulet<=5.4  &&resulet>5.2 ) s1+=45.0;else if(resulet<=5.2  &&resulet>5 ) s1+=50.0;else if(resulet<=5  &&resulet>4.9 ) s1+=55.0;
					else if(resulet<=4.9  &&resulet>4.7 ) s1+=60.0;else if(resulet<=4.7  &&resulet>4.6 ) s1+=65.0;else if(resulet<=4.6  &&resulet>4.4 ) s1+=70.0;else if(resulet<=4.4  &&resulet>4.2 ) s1+=75.0;
					else if(resulet<=4.2  &&resulet>4 ) s1+=80.0;else if(resulet<=4  &&resulet>3.7 ) s1+=85.0;else if(resulet<=3.7  &&resulet>3.2 ) s1+=90.0;else if(resulet<=3.2   ) s1+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=7.6  &&resulet>7.1 ) s1+=5.0;else if(resulet<=7.1  &&resulet>6.8 ) s1+=10.0;else if(resulet<=6.8  &&resulet>6.6 ) s1+=15.0;else if(resulet<=6.6  &&resulet>6.4 ) s1+=20.0;else if(resulet<=6.4  &&resulet>6.2 ) s1+=25.0;else if(resulet<=6.2  &&resulet>6.1 ) s1+=30.0;else if(resulet<=6.1 &&resulet>5.9 ) s1+=35.0;
					else if(resulet<=5.9  &&resulet>5.8 ) s1+=40.0;else if(resulet<=5.8  &&resulet>5.6 ) s1+=45.0;else if(resulet<=5.6  &&resulet>5.4 ) s1+=50.0;else if(resulet<=5.4  &&resulet>5.3 ) s1+=55.0;
					else if(resulet<=5.3  &&resulet>5.1 ) s1+=60.0;else if(resulet<=5.1  &&resulet>5 ) s1+=65.0;else if(resulet<=5  &&resulet>4.8 ) s1+=70.0;else if(resulet<=4.8  &&resulet>4.6 ) s1+=75.0;
					else if(resulet<=4.6  &&resulet>4.4 ) s1+=80.0;else if(resulet<=4.4  &&resulet>4.1 ) s1+=85.0;else if(resulet<=4.1  &&resulet>3.6 ) s1+=90.0;else if(resulet<=3.6) s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=8.6  &&resulet>8 ) s1+=5.0;else if(resulet<=8  &&resulet>7.7 ) s1+=10.0;else if(resulet<=7.7  &&resulet>7.3 ) s1+=15.0;
					else if(resulet<=7.3  &&resulet>7.1 ) s1+=20.0;else if(resulet<=7.1  &&resulet>6.8 ) s1+=25.0;else if(resulet<=6.8  &&resulet>6.6 ) s1+=30.0;else if(resulet<=6.6  &&resulet>6.4 ) s1+=35.0;
					else if(resulet<=6.4  &&resulet>6.2 ) s1+=40.0;else if(resulet<=6.2  &&resulet>6 ) s1+=45.0;else if(resulet<=6  &&resulet>5.8 ) s1+=50.0;else if(resulet<=5.8  &&resulet>5.6 ) s1+=55.0;
					else if(resulet<=5.6  &&resulet>5.4 ) s1+=60.0;else if(resulet<=5.4  &&resulet>5.2 ) s1+=65.0;else if(resulet<=5.2  &&resulet>4.9 ) s1+=70.0;else if(resulet<=4.9  &&resulet>4.7 ) s1+=75.0;
					else if(resulet<=4.7  &&resulet>4.3 ) s1+=80.0;else if(resulet<=4.3  &&resulet>4 ) s1+=85.0;else if(resulet<=4  &&resulet>3.8 ) s1+=90.0;else if(resulet<= 3.8  ) s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet >=-8.8 &&resulet<-7.3 ) s1+=5.0;else if(resulet >=-7.3 &&resulet<-6.4 )  s1+=10.0;else if(resulet >=-6.4  &&resulet<-5.5 ) s1+=15.0;
					else if(resulet >=-5.5  &&resulet<-4.8 ) s1+=20.0;else if(resulet >=-4.8  &&resulet<-4.2 ) s1+=25.0;else if(resulet >=-4.2  &&resulet<-3.7 ) s1+=30.0;else if(resulet >=-3.7  &&resulet<-3.1 ) s1+=35.0;
					else if(resulet >=-3.1  &&resulet<-2.6 ) s1+=40.0;else if(resulet >=-2.6  &&resulet<-2.1 ) s1+=45.0;else if(resulet >=-2.1  &&resulet<-1.6 ) s1+=50.0;else if(resulet >=-1.6  &&resulet<-1.1 ) s1+=55.0;
					else if(resulet >=-1.1 &&resulet<-0.5 ) s1+=60.0;else if(resulet >=-0.5  &&resulet<0 ) s1+=65.0;else if(resulet >=0  &&resulet<0.6 ) s1+=70.0;else if(resulet >=0.6  &&resulet<1.3 ) s1+=75.0;
					else if(resulet >=1.3  &&resulet<2.2 ) s1+=80.0;else if(resulet >=2.2  &&resulet<3.1 ) s1+=85.0;else if(resulet >=3.1  &&resulet<4.5 ) s1+=90.0;else if(resulet >= 4.5  ) s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=10.8  &&resulet> 10) s1+=5.0;else if(resulet<=10  &&resulet>9.5 ) s1+=10.0;else if(resulet<=9.5  &&resulet>9 ) s1+=15.0;
					else if(resulet<=9  &&resulet>8.7 ) s1+=20.0;else if(resulet<=8.7  &&resulet>8.3 ) s1+=25.0;else if(resulet<=8.3  &&resulet>8.1 ) s1+=30.0;else if(resulet<=8.1  &&resulet>7.8 ) s1+=35.0;
					else if(resulet<=7.8  &&resulet>7.5 ) s1+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) s1+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) s1+=50.0;else if(resulet<=6.9  &&resulet>6.7 ) s1+=55.0;
					else if(resulet<=6.7  &&resulet>6.3 ) s1+=60.0;else if(resulet<=6.3  &&resulet>6.1 ) s1+=65.0;else if(resulet<=6.1  &&resulet>5.7 ) s1+=70.0;else if(resulet<=5.7 &&resulet>5.4 ) s1+=75.0;
					else if(resulet<=5.4  &&resulet>4.9 ) s1+=80.0;else if(resulet<=4.9  &&resulet>4.4 ) s1+=85.0;else if(resulet<=4.4  &&resulet>4 ) s1+=90.0;else if(resulet<=4   ) s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=12  &&resulet>11.1 ) s1+=5.0;else if(resulet<=11.1  &&resulet>10.5 ) s1+=10.0;else if(resulet<=10.5  &&resulet>10 ) s1+=15.0;
					else if(resulet<=10  &&resulet>9.6 ) s1+=20.0;else if(resulet<=9.6  &&resulet>9.2 ) s1+=25.0;else if(resulet<=9.2  &&resulet>8.9 ) s1+=30.0;else if(resulet<=8.9  &&resulet>8.5 ) s1+=35.0;
					else if(resulet<=8.5  &&resulet>8.2 ) s1+=40.0;else if(resulet<=8.2  &&resulet>7.9 ) s1+=45.0;else if(resulet<=7.9  &&resulet>7.6 ) s1+=50.0;else if(resulet<=7.6  &&resulet>7.3 ) s1+=55.0;
					else if(resulet<=7.3  &&resulet>6.9 ) s1+=60.0;else if(resulet<=6.9  &&resulet>6.6 ) s1+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) s1+=70.0;else if(resulet<=6.2  &&resulet>5.8 ) s1+=75.0;
					else if(resulet<=5.8  &&resulet>5.3 ) s1+=80.0;else if(resulet<=5.3  &&resulet>4.7 ) s1+=85.0;else if(resulet<=4.7  &&resulet>4.5 ) s1+=90.0;else if(resulet<=4.5   ) s1+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet<=14.6  &&resulet>13.5 ) s1+=5.0;else if(resulet<=13.5  &&resulet>12.7 ) s1+=10.0;else if(resulet<=12.7  &&resulet>12.1 ) s1+=15.0;
					else if(resulet<=12.1  &&resulet>11.5 ) s1+=20.0;else if(resulet<=11.5  &&resulet>11.1 ) s1+=25.0;else if(resulet<=11.1  &&resulet>10.6 ) s1+=30.0;else if(resulet<=10.6  &&resulet>10.2) s1+=35.0;
					else if(resulet<=10.2  &&resulet>9.8 ) s1+=40.0;else if(resulet<=9.8  &&resulet>9.4 ) s1+=45.0;else if(resulet<=9.4  &&resulet>9 ) s1+=50.0;else if(resulet<=9  &&resulet>8.6 ) s1+=55.0;
					else if(resulet<=8.6  &&resulet>8.2 ) s1+=60.0;else if(resulet<=8.2  &&resulet>7.7 ) s1+=65.0;else if(resulet<=7.7  &&resulet>7.3 ) s1+=70.0;else if(resulet<=7.3  &&resulet>6.7 ) s1+=75.0;
					else if(resulet<= 6.7 &&resulet>6.1 ) s1+=80.0;else if(resulet<=6.1  &&resulet>5.3 ) s1+=85.0;else if(resulet<=5.3 &&resulet>5 ) s1+=90.0;else if(resulet<= 5  ) s1+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==5) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet<=67)s1+=5.0;else if(resulet<=74 &&resulet>67 )s1+=10.0;else if(resulet<=79 &&resulet>74 )s1+=15.0;
					else if(resulet<=83 &&resulet>79 )s1+=20.0;else if(resulet<=87 &&resulet>83 )s1+=25.0;else if(resulet<=90 &&resulet>87 )s1+=30.0;else if(resulet<=93 &&resulet>90 )s1+=35.0;
					else if(resulet<=96 &&resulet>93)s1+=40.0;else if(resulet<=98 &&resulet>96 )s1+=45.0;else if(resulet<=101 &&resulet>98 )s1+=50.0;else if(resulet<=104 &&resulet>101 )s1+=55.0;
					else if(resulet<=106 &&resulet>104 )s1+=60.0;else if(resulet<=109 &&resulet>106 )s1+=65.0;else if(resulet<=112 &&resulet>109 )s1+=70.0;else if(resulet<=115 &&resulet>112 )s1+=75.0;
					else if(resulet<=119 &&resulet>115 )s1+=80.0;else if(resulet<=123 &&resulet>119 )s1+=85.0;else if(resulet<=128 &&resulet>123 )s1+=90.0;else if(resulet>128  )s1+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=67)s1+=5.0;else if(resulet<=72 &&resulet>67 )s1+=10.0;else if(resulet<=77 &&resulet>72 )s1+=15.0;
					else if(resulet<=82 &&resulet>77 )s1+=20.0;else if(resulet<=86 &&resulet>82 )s1+=25.0;	else if(resulet<=89 &&resulet>86 )s1+=30.0;else if(resulet<=92 &&resulet>89 )s1+=35.0;
					else if(resulet<=95 &&resulet>92 )s1+=40.0;else if(resulet<=98 &&resulet>95 )s1+=45.0;else if(resulet<=101 &&resulet>98 )s1+=50.0;else if(resulet<=104 &&resulet>101 )s1+=55.0;
					else if(resulet<=107 &&resulet>104 )s1+=60.0;else if(resulet<=110 &&resulet>107 )s1+=65.0;else if(resulet<=113 &&resulet>110 )s1+=70.0;else if(resulet<=116 &&resulet>113 )s1+=75.0;
					else if(resulet<=120 &&resulet>116 )s1+=80.0;else if(resulet<=125 &&resulet>120 )s1+=85.0;else if(resulet<=130 &&resulet>125 )s1+=90.0;else if(resulet>130  )s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=67)s1+=5.0;else if(resulet<=66 &&resulet>67 )s1+=10.0;
					else if(resulet<=71 &&resulet>66 )s1+=15.0;else if(resulet<=76 &&resulet>71 )s1+=20.0;else if(resulet<=80 &&resulet>76 )s1+=25.0;else if(resulet<=83 &&resulet>80 )s1+=30.0;else if(resulet<=86 &&resulet>83 )s1+=35.0;
					else if(resulet<=89 &&resulet>86 )s1+=40.0;else if(resulet<=92 &&resulet>89 )s1+=45.0;else if(resulet<=95 &&resulet>92 )s1+=50.0;else if(resulet<=98 &&resulet>95 )s1+=55.0;
					else if(resulet<=101 &&resulet>98 )s1+=60.0;else if(resulet<=104 &&resulet>101 )s1+=65.0;else if(resulet<=107 &&resulet>104 )s1+=70.0;else if(resulet<=110 &&resulet>107 )s1+=75.0;
					else if(resulet<=114 &&resulet>110 )s1+=80.0;else if(resulet<=119 &&resulet>114 )s1+=85.0;else if(resulet<=124 &&resulet>119 )s1+=90.0;else if(resulet>124  )s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=47)s1+=5.0;else if(resulet<=56 &&resulet>47 )s1+=10.0;else if(resulet<=63 &&resulet>56 )s1+=15.0;
					else if(resulet<=68 &&resulet>63 )s1+=20.0;else if(resulet<=73 &&resulet>68 )s1+=25.0;else if(resulet<=77 &&resulet>73 )s1+=30.0;else if(resulet<=80 &&resulet>77 )s1+=35.0;
					else if(resulet<=84 &&resulet>80 )s1+=40.0;else if(resulet<=87 &&resulet>84 )s1+=45.0;else if(resulet<=91 &&resulet>87 )s1+=50.0;else if(resulet<=95 &&resulet>91 )s1+=55.0;
					else if(resulet<=98 &&resulet>95 )s1+=60.0;else if(resulet<=102 &&resulet>98 )s1+=65.0;else if(resulet<=105 &&resulet>102 )s1+=70.0;else if(resulet<=109 &&resulet>105 )s1+=75.0;
					else if(resulet<=114 &&resulet>109 )s1+=80.0;else if(resulet<=119 &&resulet>114 )s1+=85.0;else if(resulet<=126 &&resulet>119 )s1+=90.0;else if(resulet>126  )s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=48)s1+=5.0;else if(resulet<=56 &&resulet>48 )s1+=10.0;else if(resulet<=62 &&resulet>56 )s1+=15.0;else if(resulet<=67 &&resulet>62 )s1+=20.0;else if(resulet<=71 &&resulet>67 )s1+=25.0;else if(resulet<=75 &&resulet>71 )s1+=30.0;
					else if(resulet<=78 &&resulet>75 )s1+=35.0;else if(resulet<=81 &&resulet>78 )s1+=40.0;else if(resulet<=84 &&resulet>81 )s1+=45.0;else if(resulet<=87 &&resulet>84 )s1+=50.0;else if(resulet<=90 &&resulet>87 )s1+=55.0;
					else if(resulet<=93 &&resulet>90 )s1+=60.0;else if(resulet<=96 &&resulet>93 )s1+=65.0;else if(resulet<=99 &&resulet>96 )s1+=70.0;else if(resulet<=103 &&resulet>99 )s1+=75.0;
					else if(resulet<=107 &&resulet>103 )s1+=80.0;else if(resulet<=112 &&resulet>107 )s1+=85.0;else if(resulet<=118 &&resulet>112 )s1+=90.0;else if(resulet>118  )s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=36)s1+=5.0;else if(resulet<=44 &&resulet>36 )s1+=10.0;else if(resulet<=50 &&resulet>44 )s1+=15.0;else if(resulet<=55 &&resulet>50 )s1+=20.0;
					else if(resulet<=59 &&resulet>55 )s1+=25.0;else if(resulet<=63 &&resulet>59 )s1+=30.0;else if(resulet<=66 &&resulet>63 )s1+=35.0;else if(resulet<=69 &&resulet>66 )s1+=40.0;else if(resulet<=72 &&resulet>69 )s1+=45.0;
					else if(resulet<=75 &&resulet>72 )s1+=50.0;else if(resulet<=78 &&resulet>75 )s1+=55.0;else if(resulet<=81 &&resulet>78 )s1+=60.0;else if(resulet<=84 &&resulet>81 )s1+=65.0;else if(resulet<=87 &&resulet>84 )s1+=70.0;
					else if(resulet<=91 &&resulet>87 )s1+=75.0;else if(resulet<=95 &&resulet>91 )s1+=80.0;else if(resulet<=100 &&resulet>95 )s1+=85.0;else if(resulet<=106 &&resulet>100 )s1+=90.0;else if(resulet>106  )s1+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet<=26)s1+=5.0;else if(resulet<=36 &&resulet>26 )s1+=10.0;else if(resulet<=42 &&resulet>36 )s1+=15.0;else if(resulet<=47 &&resulet>42 )s1+=20.0;
					else if(resulet<=52 &&resulet>47 )s1+=25.0;else if(resulet<=55 &&resulet>52 )s1+=30.0;else if(resulet<=59 &&resulet>55 )s1+=35.0;else if(resulet<=62 &&resulet>59 )s1+=40.0;else if(resulet<=66 &&resulet>62 )s1+=45.0;
					else if(resulet<=69 &&resulet>66 )s1+=50.0;else if(resulet<=72 &&resulet>69 )s1+=55.0;else if(resulet<=76 &&resulet>72 )s1+=60.0;else if(resulet<=79 &&resulet>76 )s1+=65.0;else if(resulet<=83 &&resulet>79 )s1+=70.0;
					else if(resulet<=86 &&resulet>83 )s1+=75.0;else if(resulet<=91 &&resulet>86 )s1+=80.0;else if(resulet<=96 &&resulet>91 )s1+=85.0;else if(resulet<=102 &&resulet>96 )s1+=90.0;else if(resulet>102  )s1+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==6) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet >=-11.3    && resulet<-9.5) s1+=5.0;else if(resulet >=-9.5 && resulet<-8.4)  s1+=10.0;else if(resulet >=-8.4 && resulet<-7.4) s1+=15.0;
					else if(resulet >=-7.4 && resulet<-6.6) s1+=20.0;else if(resulet >=-6.6 && resulet<-5.9) s1+=25.0;else if(resulet >=-5.9 && resulet<-5.3) s1+=30.0;else if(resulet >=-5.3 && resulet<-4.6) s1+=35.0;
					else if(resulet >=-4.6 && resulet<-4  ) s1+=40.0;else if(resulet >=-4   && resulet<-3.4) s1+=45.0;else if(resulet >=-3.4 && resulet<-2.8) s1+=50.0;else if(resulet >=-2.8 && resulet<-2.2) s1+=55.0;
					else if(resulet >=-2.2 && resulet<-1.5) s1+=60.0;else if(resulet >=-1.5 && resulet<-0.9) s1+=65.0;else if(resulet >=-0.9 && resulet<-0.2) s1+=70.0;else if(resulet >=-0.2 && resulet< 0.6) s1+=75.0;
					else if(resulet >=0.6  && resulet< 1.6) s1+=80.0;else if(resulet >=1.6  && resulet< 2.7) s1+=85.0;else if(resulet >=2.7  && resulet< 4.5) s1+=85.0;else if(resulet >4.5 ) s1+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet>=-12.1&&resulet<-10.4 ) s1+=5.0;else if(resulet>=-10.4 &&resulet<-9.2 )  s1+=10.0;else if(resulet>=-9.2  &&resulet<-8.2 ) s1+=15.0;
					else if(resulet>=-8.2  &&resulet<-7.4 ) s1+=20.0;else if(resulet>=-7.4 &&resulet<-6.6 ) s1+=25.0;else if(resulet>=-6.6  &&resulet<-6 ) s1+=30.0;else if(resulet>= -6 &&resulet<-5.3 ) s1+=35.0;
					else if(resulet>=-5.3  &&resulet<-4.7 ) s1+=40.0;else if(resulet>=-4.7  &&resulet<-4.1 ) s1+=45.0;else if(resulet>=-4.1  &&resulet<-3.5 ) s1+=50.0;else if(resulet>=-3.5  &&resulet<-2.9 ) s1+=55.0;
					else if(resulet>=-2.9  &&resulet<-2.2 ) s1+=60.0;else if(resulet>=-2.2  &&resulet<-1.6 ) s1+=65.0;else if(resulet>=-1.6  &&resulet<-0.8 ) s1+=70.0;else if(resulet>=-0.8  &&resulet<0 ) s1+=75.0;
					else if(resulet>=0  &&resulet<1)s1+=80.0;else if(resulet>=1  &&resulet<2.2)s1+=85.0;else if(resulet>=2.2  &&resulet<3.9)s1+=90.0;else if(resulet>= 3.9  ) s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet >=-12.5 &&resulet<-10.8 ) s1+=5.0;else if(resulet >=-10.8 &&resulet<-9.6 )  s1+=10.0;
					else if(resulet >=-9.6  &&resulet<-8.6 ) s1+=15.0;else if(resulet >=-8.6 &&resulet<-7.8 ) s1+=20.0;else if(resulet >=-7.8  &&resulet<-7 ) s1+=25.0;else if(resulet >=-7 &&resulet<-6.4 ) s1+=30.0;
					else if(resulet >-6.4 &&resulet<-5.7 ) s1+=35.0;else if(resulet >=-5.7  &&resulet<-5.1 ) s1+=40.0;else if(resulet >=-5.1  &&resulet<-4.5 ) s1+=45.0;else if(resulet >=-4.5  &&resulet<-3.9 ) s1+=50.0;
					else if(resulet >=-3.9  &&resulet<-3.3 ) s1+=55.0;else if(resulet >=-3.3  &&resulet<-2.6 ) s1+=60.0;else if(resulet >=-2.6 &&resulet< -2) s1+=65.0;
					else if(resulet >= -2 &&resulet<-1.2 ) s1+=70.0;else if(resulet >=-1.2  &&resulet<-0.4 ) s1+=75.0;
					else if(resulet >=-0.4  &&resulet<0.6 ) s1+=80.0;else if(resulet >= 0.6 &&resulet<1.8 ) s1+=85.0;else if(resulet >=1.8  &&resulet<3.5 ) s1+=90.0;else if(resulet >= 3.5  ) s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet >=-14 &&resulet<-12.1 ) s1+=5.0;else if(resulet >=-12.1 &&resulet<-10.9 )  s1+=10.0;else if(resulet >= -10.9 &&resulet<-9.9 ) s1+=15.0;
					else if(resulet >=-9.9  &&resulet<-9 ) s1+=20.0;else if(resulet >=-9  &&resulet< -8.3) s1+=25.0;else if(resulet >=-8.3  &&resulet<-7.6 ) s1+=30.0;else if(resulet >= -7.6 &&resulet<-6.9 ) s1+=35.0;
					else if(resulet >=-6.9  &&resulet<-6.3 ) s1+=40.0;else if(resulet >=-6.3  &&resulet<-5.6 ) s1+=45.0;else if(resulet >=-5.6  &&resulet<-4.9 ) s1+=50.0;else if(resulet >=-4.9  &&resulet<-4.3 ) s1+=55.0;
					else if(resulet >=-4.3  &&resulet< -3.6) s1+=60.0;else if(resulet >= -3.6 &&resulet< -2.9) s1+=65.0;else if(resulet >=-2.9  &&resulet< -2.2) s1+=70.0;else if(resulet >= -2.2 &&resulet< -1.3) s1+=75.0;
					else if(resulet >= -1.3 &&resulet<-0.3 ) s1+=80.0;else if(resulet >= -0.3 &&resulet< 0.9) s1+=85.0;else if(resulet >= 0.9 &&resulet<2.8 ) s1+=90.0;else if(resulet >= 2.8  ) s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet >=-14.6 &&resulet<-12.6 ) s1+=5.0;else if(resulet >=-12.6 &&resulet<-11.3 )  s1+=10.0;else if(resulet >=-11.3  &&resulet<-10.2 ) s1+=15.0;
					else if(resulet >= -10.2 &&resulet<-9.3 ) s1+=20.0;else if(resulet >=-9.3  &&resulet<-8.5 ) s1+=25.0;else if(resulet >=-8.5  &&resulet<-7.8 ) s1+=30.0;else if(resulet >=-7.8  &&resulet<-7.1 ) s1+=35.0;
					else if(resulet >=-7.1  &&resulet<-6.4 ) s1+=40.0;else if(resulet >=-6.4  &&resulet<-5.7 ) s1+=45.0;else if(resulet >=-5.7  &&resulet<-5 ) s1+=50.0;else if(resulet >= -5 &&resulet<-4.3 ) s1+=55.0;
					else if(resulet >= -4.3 &&resulet< -3.6) s1+=60.0;else if(resulet >= -3.6 &&resulet<-2.9 ) s1+=65.0;else if(resulet >= -2.9 &&resulet<-2.1 ) s1+=70.0;else if(resulet >= -2.1 &&resulet<-1.2 ) s1+=75.0;
					else if(resulet >= -1.2 &&resulet<-0.1 ) s1+=80.0;else if(resulet >= -0.1  &&resulet< 1.2) s1+=85.0;else if(resulet >= 1.2 &&resulet<3.2 ) s1+=90.0;else if(resulet >= 3.2  ) s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=11.5  &&resulet>10.5 ) s1+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) s1+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) s1+=15.0;
					else if(resulet<=9.4  &&resulet>8.9 ) s1+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) s1+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) s1+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) s1+=35.0;
					else if(resulet<=7.9  &&resulet>7.5 ) s1+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) s1+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) s1+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) s1+=55.0;
					else if(resulet<=6.5  &&resulet>6.2 ) s1+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) s1+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) s1+=70.0;else if(resulet<=5.5  &&resulet>5 ) s1+=75.0;
					else if(resulet<=5  &&resulet>4.5 ) s1+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) s1+=85.0;else if(resulet<=4.3  &&resulet>4 ) s1+=90.0;else if(resulet<=4   ) s1+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet >=-15.1 &&resulet<-13.3 ) s1+=5.0;else if(resulet >=-13.3 &&resulet<-12.2 )  s1+=10.0;else if(resulet >= -12.2 &&resulet<-11.2 ) s1+=15.0;
					else if(resulet >= -11.2 &&resulet<-10.4 ) s1+=20.0;	else if(resulet >= -10.4 &&resulet<-9.7 ) s1+=25.0;else if(resulet >= -9.7 &&resulet<-9.1 ) s1+=30.0;else if(resulet >= -9.1 &&resulet<-8.4 ) s1+=35.0;
					else if(resulet >= -8.4 &&resulet<-7.8 ) s1+=40.0;else if(resulet >= -7.8 &&resulet<-7.2 ) s1+=45.0;else if(resulet >= -7.2 &&resulet<-6.6 ) s1+=50.0;else if(resulet >= -6.6 &&resulet<-6 ) s1+=55.0;
					else if(resulet >= -6 &&resulet<-5.3 ) s1+=60.0;else if(resulet >= -5.3 &&resulet<-4.7 ) s1+=65.0;else if(resulet >= -4.7 &&resulet<-4 ) s1+=70.0;else if(resulet >= -4 &&resulet<-3.2 ) s1+=75.0;
					else if(resulet >= -3.2 &&resulet<-2.2 ) s1+=80.0;else if(resulet >= -2.2 &&resulet<-1.1 ) s1+=85.0;else if(resulet >=-1.1  &&resulet<0.7 ) s1+=90.0;else if(resulet >=0.7   ) s1+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==7) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet <=6.8 &&resulet>6.4 ) s1+=5.0;else if(resulet <=6.4 &&resulet>6.1  )  s1+=10.0;
					else if(resulet <=6.1  &&resulet>5.8  ) s1+=15.0;else if(resulet <=5.8  &&resulet>5.6 ) s1+=20.0;else if(resulet >=5.6  &&resulet>5.4 ) s1+=25.0;else if(resulet <=5.4  &&resulet>5.2 ) s1+=30.0;
					else if(resulet <=5.2&&resulet>5.0 ) s1+=35.0;else if(resulet <=5.0 &&resulet>4.9 ) s1+=40.0;else if(resulet <=4.9  &&resulet>4.7 ) s1+=45.0;else if(resulet <=4.7  &&resulet>4.5 ) s1+=50.0;
					else if(resulet <=4.5 &&resulet>4.4) s1+=55.0;else if(resulet <=4.4  &&resulet>4.2 ) s1+=60.0;else if(resulet <=4.2  &&resulet>4.0) s1+=65.0;else if(resulet <=4.0  &&resulet>3.8 ) s1+=70.0;
					else if(resulet <=3.8  &&resulet>3.6 ) s1+=75.0;else if(resulet <=3.6  &&resulet>3.3) s1+=80.0;else if(resulet <=3.3  &&resulet>3) s1+=85.0;else if(resulet <=3 ) s1+=90.0;
				
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet <=7.1 &&resulet>6.6 ) s1+=5.0;else if(resulet <=6.6  &&resulet> 6.3 )  s1+=10.0;else if(resulet <=6.3  &&resulet>6.1  ) s1+=15.0;
					else if(resulet <=6.1  &&resulet>5.9 ) s1+=20.0;else if(resulet <=5.9  &&resulet>5.7 ) s1+=25.0;else if(resulet <=5.7  &&resulet>5.6 ) s1+=30.0;else if(resulet <=5.6  &&resulet>5.4 ) s1+=35.0;
					else if(resulet <=5.4  &&resulet>5.3 ) s1+=40.0;else if(resulet <=5.3 &&resulet>5.1 ) s1+=45.0;else if(resulet <=5.1  &&resulet>4.9 ) s1+=50.0;else if(resulet <= 4.9&&resulet>4.8) s1+=55.0;
					else if(resulet <=4.8  &&resulet>4.6 ) s1+=60.0;else if(resulet <=4.6  &&resulet>4.5) s1+=65.0;else if(resulet <=4.5  &&resulet>4.3 ) s1+=70.0;else if(resulet <=4.3  &&resulet>4.1 ) s1+=75.0;
					else if(resulet <=4.1  &&resulet>3.9) s1+=80.0;else if(resulet <=3.9  &&resulet>3.6) s1+=85.0;else if(resulet <=3.6 &&resulet>3.1 ) s1+=90.0;else if(resulet <=3.1   ) s1+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					 if(resulet <=7.4 &&resulet>7 ) s1+=5.0;else if(resulet <=7 &&resulet> 6.7 )  s1+=10.0;else if(resulet <= 6.7 &&resulet> 6.4  ) s1+=15.0;
					else if(resulet <= 6.4 &&resulet> 6.2 ) s1+=20.0;else if(resulet <= 6.2 &&resulet>6 ) s1+=25.0;else if(resulet <= 6 &&resulet>5.8 ) s1+=30.0;else if(resulet <=5.8&&resulet>5.6 ) s1+=35.0;
					else if(resulet <=5.6 &&resulet>5.5 ) s1+=40.0;else if(resulet <=5.5  &&resulet>5.3 ) s1+=45.0;else if(resulet <=5.3  &&resulet>5.1 ) s1+=50.0;else if(resulet <=5.1 &&resulet>5 ) s1+=55.0;
					else if(resulet <=5  &&resulet>4.8 ) s1+=60.0;else if(resulet <=4.8  &&resulet>4.6) s1+=65.0;else if(resulet <=4.6  &&resulet>4.4 ) s1+=70.0;else if(resulet <=4.4  &&resulet>4.2 ) s1+=75.0;
					else if(resulet <=4.2  &&resulet>3.9 ) s1+=80.0;else if(resulet <=3.9  &&resulet>3.6) s1+=85.0;else if(resulet <=3.6 &&resulet>3.2 ) s1+=90.0;else if(resulet <=3.2   ) s1+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet <=9 &&resulet<8.3 ) s1+=5.0;else if(resulet <=8.3 &&resulet>7.9)  s1+=10.0;else if(resulet <=7.9 &&resulet>7.5) s1+=15.0;
					else if(resulet <=7.5 &&resulet>7.2) s1+=20.0;else if(resulet <=7.2 &&resulet>6.9) s1+=25.0;else if(resulet <=6.9 &&resulet>6.6) s1+=30.0;else if(resulet <=6.6 &&resulet>6.4) s1+=35.0;
					else if(resulet <=6.4 &&resulet>6.1) s1+=40.0;else if(resulet <=6.1 &&resulet>5.9) s1+=45.0;else if(resulet <=5.9 &&resulet>5.7) s1+=50.0;else if(resulet <=5.7 &&resulet>5.4) s1+=55.0;
					else if(resulet <=5.4 &&resulet>5.2) s1+=60.0;else if(resulet <=5.2 &&resulet>4.9) s1+=65.0;else if(resulet <=4.9  &&resulet>4.6) s1+=70.0;else if(resulet <=4.6 &&resulet>4.3) s1+=75.0;
					else if(resulet <=4.3  &&resulet>3.9) s1+=80.0;else if(resulet <=3.9  &&resulet>3.5) s1+=85.0;else if(resulet <=3.5 &&resulet>3.3) s1+=90.0;else if(resulet <=3.3   ) s1+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=9.4  &&resulet>8.7 ) s1+=5.0;else if(resulet<=8.7  &&resulet>8.3 ) s1+=10.0;else if(resulet<=8.3  &&resulet>7.9 ) s1+=15.0;
					else if(resulet<=7.9  &&resulet>7.6 ) s1+=20.0;else if(resulet<=7.6  &&resulet>7.3 ) s1+=25.0;else if(resulet<=7.3  &&resulet>7.1 ) s1+=30.0;else if(resulet<=7.1  &&resulet>6.9 ) s1+=35.0;
					else if(resulet<=6.9  &&resulet>6.6 ) s1+=40.0;else if(resulet<=6.6  &&resulet>6.4 ) s1+=45.0;else if(resulet<=6.4  &&resulet>6.2 ) s1+=50.0;else if(resulet<=6.2  &&resulet>6 ) s1+=55.0;
					else if(resulet<=6    &&resulet>5.7 ) s1+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) s1+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) s1+=70.0;else if(resulet<=5.2  &&resulet>4.9 ) s1+=75.0;
					else if(resulet<=4.9  &&resulet>4.5 ) s1+=80.0;else if(resulet<=4.5  &&resulet>4.1 ) s1+=85.0;else if(resulet<=4.1  &&resulet>4 ) s1+=90.0;else if(resulet<=4   ) s1+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=11.5  &&resulet>10.5 ) s1+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) s1+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) s1+=15.0;
					else if(resulet<=9.4  &&resulet>8.9 ) s1+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) s1+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) s1+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) s1+=35.0;
					else if(resulet<=7.9  &&resulet>7.5 ) s1+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) s1+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) s1+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) s1+=55.0;
					else if(resulet<=6.5  &&resulet>6.2 ) s1+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) s1+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) s1+=70.0;else if(resulet<=5.5  &&resulet>5 ) s1+=75.0;
					else if(resulet<=5  &&resulet>4.5 ) s1+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) s1+=85.0;else if(resulet<=4.3  &&resulet>4 ) s1+=90.0;else if(resulet<=4   ) s1+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet<=12.9  &&resulet>11.8 ) s1+=5.0;else if(resulet<=11.8  &&resulet>11.1 ) s1+=10.0;else if(resulet<=11.1  &&resulet>10.5 ) s1+=15.0;
					else if(resulet<=10.5  &&resulet>10 ) s1+=20.0;else if(resulet<=10  &&resulet>9.6 ) s1+=25.0;else if(resulet<=9.6  &&resulet>9.2 ) s1+=30.0;else if(resulet<=9.2  &&resulet>8.8 ) s1+=35.0;
					else if(resulet<=8.8  &&resulet>8.5 ) s1+=40.0;else if(resulet<=8.5  &&resulet>8.1 ) s1+=45.0;else if(resulet<=8.1  &&resulet>7.7 ) s1+=50.0;else if(resulet<=7.7  &&resulet>7.4 ) s1+=55.0;
					else if(resulet<=7.4  &&resulet>7 ) s1+=60.0;else if(resulet<=7  &&resulet>6.6 ) s1+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) s1+=70.0;else if(resulet<=6.2  &&resulet>5.7 ) s1+=75.0;
					else if(resulet<=5.7  &&resulet>5.1 ) s1+=80.0;else if(resulet<=5.1  &&resulet>4.5 ) s1+=85.0;else if(resulet<=4.5  &&resulet>4.3 ) s1+=90.0;else if(resulet<=4.3   ) s1+=95.0;
				
				}
			}
			e1=getE1(v1, calibrations,resulet1);
			score+=Math.pow(e1-s1-d_,2);
		}
		return score;
	}
	public static Double getE1(FitnessVO1 v1,int calibrations,double resulet1){
		double e1=0.0;
		if (v1.getSex() == 0&&calibrations==5) {// 女性
			if (v1.getAge() < 65) {
				if(resulet1<=52)e1+=5.0;else if(resulet1<=60&&resulet1>52)e1+=10.0;else if(resulet1<=66 &&resulet1>60 )e1+=15.0;else if(resulet1<=71 &&resulet1>66 )e1+=20.0;
				else if(resulet1<=75 &&resulet1>71 )e1+=25.0;else if(resulet1<=79 &&resulet1>75 )e1+=30.0;else if(resulet1<=82 &&resulet1>79 )e1+=35.0;else if(resulet1<=85 &&resulet1>82 )e1+=40.0;
				else if(resulet1<=88 &&resulet1>85 )e1+=45.0;else if(resulet1<=91 &&resulet1>88 )e1+=50.0;else if(resulet1<=94 &&resulet1>91 )e1+=55.0;else if(resulet1<=97 &&resulet1>94 )e1+=60.0;
				else if(resulet1<=100 &&resulet1>97 )e1+=65.0;else if(resulet1<=103 &&resulet1>100 )e1+=70.0;else if(resulet1<=107 &&resulet1>103 )e1+=75.0;else if(resulet1<=111 &&resulet1>107 )e1+=80.0;
				else if(resulet1<=116 &&resulet1>111 )e1+=85.0;else if(resulet1<=122 &&resulet1>116 )e1+=90.0;else if(resulet1>122 )e1+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1<=47)e1+=5.0;else if(resulet1<=57 &&resulet1>47 )e1+=10.0;else if(resulet1<=63 &&resulet1>57 )e1+=15.0;
				else if(resulet1<=68 &&resulet1>63 )e1+=20.0;else if(resulet1<=73 &&resulet1>68 )e1+=25.0;else if(resulet1<=76 &&resulet1>73 )e1+=30.0;else if(resulet1<=80 &&resulet1>76 )e1+=35.0;
				else if(resulet1<=84 &&resulet1>80 )e1+=40.0;else if(resulet1<=87 &&resulet1>84 )e1+=45.0;else if(resulet1<=90 &&resulet1>87 )e1+=50.0;else if(resulet1<=93 &&resulet1>90 )e1+=55.0;
				else if(resulet1<=96 &&resulet1>93 )e1+=60.0;else if(resulet1<=100 &&resulet1>96 )e1+=65.0;else if(resulet1<=104 &&resulet1>100 )e1+=70.0;else if(resulet1<=107 &&resulet1>104 )e1+=75.0;
				else if(resulet1<=112 &&resulet1>107 )e1+=80.0;else if(resulet1<=117 &&resulet1>112 )e1+=85.0;else if(resulet1<=123 &&resulet1>117 )e1+=90.0;else if(resulet1>123 )e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet1<=43)e1+=5.0;else if(resulet1<=52 &&resulet1>43 )e1+=10.0;
				else if(resulet1<=58 &&resulet1>52 )e1+=15.0;else if(resulet1<=63 &&resulet1>58 )e1+=20.0;else if(resulet1<=68 &&resulet1>63 )e1+=25.0;else if(resulet1<=71 &&resulet1>68 )e1+=30.0;
				else if(resulet1<=74 &&resulet1>71 )e1+=35.0;else if(resulet1<=78 &&resulet1>74 )e1+=40.0;else if(resulet1<=81 &&resulet1>78 )e1+=45.0;else if(resulet1<=84 &&resulet1>81 )e1+=50.0;
				else if(resulet1<=87 &&resulet1>84 )e1+=55.0;else if(resulet1<=90 &&resulet1>87 )e1+=60.0;else if(resulet1<=94 &&resulet1>90 )e1+=65.0;else if(resulet1<=97 &&resulet1>94 )e1+=70.0;
				else if(resulet1<=101 &&resulet1>97 )e1+=75.0;else if(resulet1<=105 &&resulet1>101 )e1+=80.0;else if(resulet1<=110 &&resulet1>105 )e1+=85.0;else if(resulet1>116 )e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1<=45)e1+=5.0;else if(resulet1<=53 &&resulet1>45 )e1+=10.0;else if(resulet1<=59 &&resulet1>53 )e1+=15.0;
				else if(resulet1<=64 &&resulet1>59 )e1+=20.0;else if(resulet1<=68 &&resulet1>64 )e1+=25.0;else if(resulet1<=72 &&resulet1>68 )e1+=30.0;else if(resulet1<=75 &&resulet1>72 )e1+=35.0;
				else if(resulet1<=78 &&resulet1>75 )e1+=40.0;else if(resulet1<=81 &&resulet1>78 )e1+=45.0;else if(resulet1<=84 &&resulet1>81 )e1+=50.0;else if(resulet1<=87 &&resulet1>84 )e1+=55.0;
				else if(resulet1<=90 &&resulet1>87 )e1+=60.0;else if(resulet1<=93 &&resulet1>90 )e1+=65.0;else if(resulet1<=96 &&resulet1>93 )e1+=70.0;else if(resulet1<=100 &&resulet1>96 )e1+=75.0;
				else if(resulet1<=104 &&resulet1>100 )e1+=80.0;else if(resulet1<=109 &&resulet1>104 )e1+=85.0;else if(resulet1<=115 &&resulet1>109 )e1+=90.0;else if(resulet1>115 )e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1<=37)e1+=5.0;else if(resulet1<=46 &&resulet1>37 )e1+=10.0;else if(resulet1<=51 &&resulet1>46 )e1+=15.0;
				else if(resulet1<=56 &&resulet1>51 )e1+=20.0;else if(resulet1<=60 &&resulet1>56 )e1+=25.0;else if(resulet1<=63 &&resulet1>60  )e1+=30.0;else if(resulet1<=66 &&resulet1>63  )e1+=35.0;
				else if(resulet1<=69 &&resulet1>66  )e1+=40.0;else if(resulet1<=72 &&resulet1>69  )e1+=45.0;else if(resulet1<=75 &&resulet1>72  )e1+=50.0;else if(resulet1<=78 &&resulet1>75  )e1+=55.0;
				else if(resulet1<=81 &&resulet1>78  )e1+=60.0;else if(resulet1<=84 &&resulet1>81  )e1+=65.0;else if(resulet1<=87 &&resulet1>84  )e1+=70.0;else if(resulet1<=90 &&resulet1>87  )e1+=75.0;
				else if(resulet1<=94 &&resulet1>90  )e1+=80.0;else if(resulet1<=99 &&resulet1>94  )e1+=85.0;else if(resulet1<=104 &&resulet1>99 )e1+=90.0;else if(resulet1>104  )e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1<=39)e1+=5.0;else if(resulet1<=42 &&resulet1>39 )e1+=10.0;else if(resulet1<=47 &&resulet1>42 )e1+=15.0;
				else if(resulet1<=52 &&resulet1>47 )e1+=20.0;else if(resulet1<=55 &&resulet1>52 )e1+=25.0;else if(resulet1<=59 &&resulet1>55 )e1+=30.0;else if(resulet1<=61 &&resulet1>59 )e1+=35.0;
				else if(resulet1<=64 &&resulet1>61 )e1+=40.0;else if(resulet1<=67 &&resulet1>64 )e1+=45.0;else if(resulet1<=70 &&resulet1>67 )e1+=50.0;else if(resulet1<=73 &&resulet1>70 )e1+=55.0;
				else if(resulet1<=76 &&resulet1>73 )e1+=60.0;else if(resulet1<=79 &&resulet1>76 )e1+=65.0;else if(resulet1<=81 &&resulet1>79 )e1+=70.0;else if(resulet1<=85 &&resulet1>81 )e1+=75.0;
				else if(resulet1<=88 &&resulet1>85 )e1+=80.0;else if(resulet1<=93 &&resulet1>88 )e1+=85.0;else if(resulet1<=98 &&resulet1>93 )e1+=90.0;else if(resulet1>98  )e1+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet1<=24)e1+=5.0;else if(resulet1<=31 &&resulet1>24 )e1+=10.0;else if(resulet1<=36 &&resulet1>31 )e1+=15.0;
				else if(resulet1<=40 &&resulet1>36 )e1+=20.0;else if(resulet1<=44 &&resulet1>40 )e1+=25.0;else if(resulet1<=47 &&resulet1>44 )e1+=30.0;else if(resulet1<=50 &&resulet1>47 )e1+=35.0;
				else if(resulet1<=53 &&resulet1>50 )e1+=40.0;else if(resulet1<=55 &&resulet1>53 )e1+=45.0;else if(resulet1<=58 &&resulet1>55 )e1+=50.0;else if(resulet1<=61 &&resulet1>58 )e1+=55.0;
				else if(resulet1<=63 &&resulet1>61 )e1+=60.0;else if(resulet1<=66 &&resulet1>63 )e1+=65.0;else if(resulet1<=69 &&resulet1>66 )e1+=70.0;else if(resulet1<=72 &&resulet1>69 )e1+=75.0;
				else if(resulet1<=76 &&resulet1>72 )e1+=80.0;else if(resulet1<=80 &&resulet1>76 )e1+=85.0;else if(resulet1<=85 &&resulet1>80 )e1+=90.0;else if(resulet1>85  )e1+=95.0;
			}
		}
		if (v1.getSex() == 0&&calibrations==6) {// 女性
			if (v1.getAge() < 65) {
				if(resulet1 >=-6.4 &&resulet1<-5.2 ) e1+=5.0;else if(resulet1 >=-5.2 &&resulet1<-4.3 )  e1+=10.0;else if(resulet1 >= -4.3 &&resulet1<-3.6 ) e1+=15.0;
				else if(resulet1 >=-3.6  &&resulet1<-3 ) e1+=20.0;else if(resulet1 >= -3 &&resulet1<-2.5 ) e1+=25.0;else if(resulet1 >=-2.5  &&resulet1<-2.1 ) e1+=30.0;else if(resulet1 >= -2.1 &&resulet1< -1.6) e1+=35.0;
				else if(resulet1 >= -1.6 &&resulet1<-1.2 ) e1+=40.0;else if(resulet1 >= -1.2 &&resulet1<-0.7 ) e1+=45.0;else if(resulet1 >= -0.7 &&resulet1<-0.2 ) e1+=50.0;else if(resulet1 >= -0.2 &&resulet1<0.2 ) e1+=55.0;
				else if(resulet1 >= 0.2 &&resulet1< 0.7) e1+=60.0;else if(resulet1 >= 0.7 &&resulet1< 1.1) e1+=65.0;else if(resulet1 >= 1.1 &&resulet1< 1.6) e1+=70.0;else if(resulet1 >= 1.6 &&resulet1<2.2 ) e1+=75.0;
				else if(resulet1 >= 2.2 &&resulet1<2.9 ) e1+=80.0;else if(resulet1 >= 2.9 &&resulet1<3.8 ) e1+=85.0;else if(resulet1 >= 3.8 &&resulet1<5 ) e1+=90.0;else if(resulet1 >=  5 ) e1+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1 >=-7.3 &&resulet1<-5.9 ) e1+=5.0;else if(resulet1 >=-5.9 &&resulet1< -5)  e1+=10.0;else if(resulet1 >= -5 &&resulet1< -4.3) e1+=15.0;
				else if(resulet1 >= -4.3 &&resulet1< -3.7) e1+=20.0;else if(resulet1 >= -3.7 &&resulet1< -3.1) e1+=25.0;else if(resulet1 >= -3.1 &&resulet1< -2.6) e1+=30.0;else if(resulet1 >= -2.6 &&resulet1< -2.1) e1+=35.0;
				else if(resulet1 >= -2.1 &&resulet1< -1.7) e1+=40.0;else if(resulet1 >= -1.7 &&resulet1< -1.2) e1+=45.0;else if(resulet1 >= -1.2 &&resulet1<-0.7 ) e1+=50.0;else if(resulet1 >= -0.7 &&resulet1<-0.3 ) e1+=55.0;
				else if(resulet1 >= -0.3 &&resulet1< 0.2) e1+=60.0;else if(resulet1 >= 0.2 &&resulet1<0.7 ) e1+=65.0;else if(resulet1 >= 0.7 &&resulet1<1.3 ) e1+=70.0;else if(resulet1 >= 1.3 &&resulet1<1.9 ) e1+=75.0;
				else if(resulet1 >= 1.9 &&resulet1<2.6 ) e1+=80.0;else if(resulet1 >= 2.6 &&resulet1<3.5 ) e1+=85.0;else if(resulet1 >= 3.5 &&resulet1<4.9 ) e1+=90.0;else if(resulet1 >= 4.9  ) e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet1<=43)e1+=5.0;else if(resulet1<=52 &&resulet1>43 )e1+=10.0;
				if(resulet1 >=-7.9 &&resulet1<-6.6 ) e1+=5.0;else if(resulet1 >=-6.6 &&resulet1<-5.7 )  e1+=10.0;else if(resulet1 >=-5.7  &&resulet1<-4.9 ) e1+=15.0;
				else if(resulet1 >=-4.9  &&resulet1<-4.2 ) e1+=20.0;else if(resulet1 >=-4.2  &&resulet1<-3.7 ) e1+=25.0;else if(resulet1 >=-3.7  &&resulet1<-3.2 ) e1+=30.0;else if(resulet1 >=-3.2  &&resulet1<-2.6 ) e1+=35.0;
				else if(resulet1 >=-2.6  &&resulet1<-2.2 ) e1+=40.0;else if(resulet1 >=-2.2  &&resulet1<-1.7 ) e1+=45.0;else if(resulet1 >=-1.7  &&resulet1<-1.2 ) e1+=50.0;else if(resulet1 >=-1.2  &&resulet1<-0.8 ) e1+=55.0;
				else if(resulet1 >=-0.8  &&resulet1<-0.2 ) e1+=60.0;else if(resulet1 >=-0.2  &&resulet1<0.3 ) e1+=65.0;else if(resulet1 >=0.3  &&resulet1<0.8 ) e1+=70.0;else if(resulet1 >=0.8  &&resulet1<1.5 ) e1+=75.0;
				else if(resulet1 >=1.5  &&resulet1<2.3 ) e1+=80.0;else if(resulet1 >=2.3  &&resulet1< 3.2) e1+=85.0;else if(resulet1 >=3.2  &&resulet1<4.5 ) e1+=90.0;else if(resulet1 >= 4.5  ) e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1<=8.9  &&resulet1>8.3 ) e1+=5.0;else if(resulet1<=8.3  &&resulet1>8 ) e1+=10.0;else if(resulet1<=8  &&resulet1>7.6 ) e1+=15.0;else if(resulet1<=7.6  &&resulet1>7.4 ) e1+=20.0;
				else if(resulet1<=7.4  &&resulet1>7.1 ) e1+=25.0;else if(resulet1<=7.1  &&resulet1>6.9 ) e1+=30.0;else if(resulet1<=6.9  &&resulet1>6.7 ) e1+=35.0;
				else if(resulet1<=6.7  &&resulet1>6.5 ) e1+=40.0;else if(resulet1<=6.5  &&resulet1>6.3 ) e1+=45.0;else if(resulet1<=6.3  &&resulet1>6.1 ) e1+=50.0;else if(resulet1<=6.1  &&resulet1>5.9 ) e1+=55.0;
				else if(resulet1<=5.9  &&resulet1>5.7 ) e1+=60.0;else if(resulet1<=5.7  &&resulet1>5.5 ) e1+=65.0;else if(resulet1<=5.5  &&resulet1>5.2 ) e1+=70.0;else if(resulet1<=5.2  &&resulet1>5 ) e1+=75.0;
				else if(resulet1<=5  &&resulet1>4.6 ) e1+=80.0;else if(resulet1<=4.6  &&resulet1>4.3 ) e1+=85.0;else if(resulet1<=4.3  &&resulet1>4 ) e1+=90.0;else if(resulet1<=4   ) e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1 >=-9.5 &&resulet1<-8 ) e1+=5.0;else if(resulet1 >=-8 &&resulet1<-7 )  e1+=10.0;else if(resulet1 >=-7  &&resulet1<-6.1 ) e1+=15.0;
				else if(resulet1 >=-6.1  &&resulet1<-5.4 ) e1+=20.0;else if(resulet1 >=-5.4  &&resulet1<-4.8 ) e1+=25.0;else if(resulet1 >=-4.8  &&resulet1<-4.2 ) e1+=30.0;else if(resulet1 >=-4.2  &&resulet1<-3.7 ) e1+=35.0;
				else if(resulet1 >=-3.7  &&resulet1<-3.1 ) e1+=40.0;else if(resulet1 >=-3.1  &&resulet1<-2.6 ) e1+=45.0;else if(resulet1 >=-2.6  &&resulet1<-2.1 ) e1+=50.0;else if(resulet1 >=-2.1  &&resulet1<-1.6 ) e1+=55.0;
				else if(resulet1 >=-1.6 &&resulet1< -1) e1+=60.0;else if(resulet1 >=  -1&&resulet1<-0.4) e1+=65.0;else if(resulet1 >=  -0.4 &&resulet1<  0.2 ) e1+=70.0;else if(resulet1 >= 0.2 &&resulet1< 0.9 ) e1+=75.0;
				else if(resulet1 >= 0.9 &&resulet1<1.8 ) e1+=80.0;else if(resulet1 >=  2.8&&resulet1<2.8 ) e1+=85.0;else if(resulet1 >= 2.8  &&resulet1<4.3 ) e1+=90.0;else if(resulet1 >= 4.3  ) e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1 >=-11.3 &&resulet1<-9.7 ) e1+=5.0;else if(resulet1 >=-9.7 &&resulet1<-8.6 )  e1+=10.0;else if(resulet1 >=-8.6  &&resulet1<-7.7 ) e1+=15.0;
				else if(resulet1 >=-7.7  &&resulet1<-6.9 ) e1+=20.0;else if(resulet1 >=-6.9  &&resulet1<-6.2 ) e1+=25.0;else if(resulet1 >=-6.2  &&resulet1<-5.7 ) e1+=30.0;else if(resulet1 >=-5.7  &&resulet1<-5 ) e1+=35.0;
				else if(resulet1 >=-5  &&resulet1<-4.5 ) e1+=40.0;else if(resulet1 >=-4.5  &&resulet1<-3.9 ) e1+=45.0;else if(resulet1 >=-3.9  &&resulet1<-3.3 ) e1+=50.0;else if(resulet1 >=-3.3  &&resulet1<-2.8 ) e1+=55.0;
				else if(resulet1 >=-2.8  &&resulet1<-2.1 ) e1+=60.0;else if(resulet1 >=-2.1  &&resulet1<-1.6 ) e1+=65.0;else if(resulet1 >=-1.6  &&resulet1<-0.9 ) e1+=70.0;else if(resulet1 >=-0.9  &&resulet1<-0.1 ) e1+=75.0;
				else if(resulet1 >=-0.1  &&resulet1<1.8 ) e1+=80.0;else if(resulet1 >=1.8  &&resulet1<1.9 ) e1+=85.0;else if(resulet1 >= 1.9 &&resulet1<3.5 ) e1+=90.0;else if(resulet1 >= 3.5  ) e1+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet1 >=-13 &&resulet1<-11.2 ) e1+=5.0;else if(resulet1 >=-11.2 &&resulet1<-9.9 )  e1+=10.0;else if(resulet1 >=-9.9  &&resulet1<-8.9 ) e1+=15.0;
				else if(resulet1 >=-8.9  &&resulet1<-8 ) e1+=20.0;else if(resulet1 >=-8  &&resulet1<-7.2 ) e1+=25.0;else if(resulet1 >= -7.2 &&resulet1<-6.5 ) e1+=30.0;else if(resulet1 >= -6.5 &&resulet1<-5.8 ) e1+=35.0;
				else if(resulet1 >= -5.8 &&resulet1<-5.2 ) e1+=40.0;else if(resulet1 >=-5.2  &&resulet1<-4.5 ) e1+=45.0;else if(resulet1 >=-4.5  &&resulet1<-3.8 ) e1+=50.0;else if(resulet1 >= -3.8 &&resulet1<-3.2 ) e1+=55.0;
				else if(resulet1 >= -3.2 &&resulet1<-2.5 ) e1+=60.0;else if(resulet1 >=-2.5  &&resulet1<-1.8 ) e1+=65.0;else if(resulet1 >=-1.8  &&resulet1<-1 ) e1+=70.0;else if(resulet1 >=-1  &&resulet1<-0.1 ) e1+=75.0;
				else if(resulet1 >=-0.1  &&resulet1<0.9 ) e1+=80.0;else if(resulet1 >=0.9  &&resulet1<2.2 ) e1+=85.0;else if(resulet1 >=2.2  &&resulet1<3.9 ) e1+=90.0;else if(resulet1 >=3.9   ) e1+=95.0;
			}
		}
		if (v1.getSex() == 0&&calibrations==7) {// 女性
			if (v1.getAge() < 65) {
				
				 if(resulet1<=7.2  &&resulet1>6.7 ) e1+=5.0;else if(resulet1<=6.7  &&resulet1>6.4 ) e1+=10.0;else if(resulet1<=6.4  &&resulet1>6.2 ) e1+=15.0;
				else if(resulet1<=6.2  &&resulet1>6 ) e1+=20.0;else if(resulet1<=6  &&resulet1>5.8 ) e1+=25.0;else if(resulet1<=5.8  &&resulet1>5.7 ) e1+=30.0;else if(resulet1<=5.7  &&resulet1>5.5 ) e1+=35.0;
				else if(resulet1<=5.5  &&resulet1>5.4 ) e1+=40.0;else if(resulet1<=5.4  &&resulet1>5.2 ) e1+=45.0;else if(resulet1<=5.2  &&resulet1>5 ) e1+=50.0;else if(resulet1<=5  &&resulet1>4.9 ) e1+=55.0;
				else if(resulet1<=4.9  &&resulet1>4.7 ) e1+=60.0;else if(resulet1<=4.7  &&resulet1>4.6 ) e1+=65.0;else if(resulet1<=4.6  &&resulet1>4.4 ) e1+=70.0;else if(resulet1<=4.4  &&resulet1>4.2 ) e1+=75.0;
				else if(resulet1<=4.2  &&resulet1>4 ) e1+=80.0;else if(resulet1<=4  &&resulet1>3.7 ) e1+=85.0;else if(resulet1<=3.7  &&resulet1>3.2 ) e1+=90.0;else if(resulet1<=3.2   ) e1+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1<=7.6  &&resulet1>7.1 ) e1+=5.0;else if(resulet1<=7.1  &&resulet1>6.8 ) e1+=10.0;else if(resulet1<=6.8  &&resulet1>6.6 ) e1+=15.0;else if(resulet1<=6.6  &&resulet1>6.4 ) e1+=20.0;else if(resulet1<=6.4  &&resulet1>6.2 ) e1+=25.0;else if(resulet1<=6.2  &&resulet1>6.1 ) e1+=30.0;else if(resulet1<=6.1 &&resulet1>5.9 ) e1+=35.0;
				else if(resulet1<=5.9  &&resulet1>5.8 ) e1+=40.0;else if(resulet1<=5.8  &&resulet1>5.6 ) e1+=45.0;else if(resulet1<=5.6  &&resulet1>5.4 ) e1+=50.0;else if(resulet1<=5.4  &&resulet1>5.3 ) e1+=55.0;
				else if(resulet1<=5.3  &&resulet1>5.1 ) e1+=60.0;else if(resulet1<=5.1  &&resulet1>5 ) e1+=65.0;else if(resulet1<=5  &&resulet1>4.8 ) e1+=70.0;else if(resulet1<=4.8  &&resulet1>4.6 ) e1+=75.0;
				else if(resulet1<=4.6  &&resulet1>4.4 ) e1+=80.0;else if(resulet1<=4.4  &&resulet1>4.1 ) e1+=85.0;else if(resulet1<=4.1  &&resulet1>3.6 ) e1+=90.0;else if(resulet1<=3.6) e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet1<=8.6  &&resulet1>8 ) e1+=5.0;else if(resulet1<=8  &&resulet1>7.7 ) e1+=10.0;else if(resulet1<=7.7  &&resulet1>7.3 ) e1+=15.0;
				else if(resulet1<=7.3  &&resulet1>7.1 ) e1+=20.0;else if(resulet1<=7.1  &&resulet1>6.8 ) e1+=25.0;else if(resulet1<=6.8  &&resulet1>6.6 ) e1+=30.0;else if(resulet1<=6.6  &&resulet1>6.4 ) e1+=35.0;
				else if(resulet1<=6.4  &&resulet1>6.2 ) e1+=40.0;else if(resulet1<=6.2  &&resulet1>6 ) e1+=45.0;else if(resulet1<=6  &&resulet1>5.8 ) e1+=50.0;else if(resulet1<=5.8  &&resulet1>5.6 ) e1+=55.0;
				else if(resulet1<=5.6  &&resulet1>5.4 ) e1+=60.0;else if(resulet1<=5.4  &&resulet1>5.2 ) e1+=65.0;else if(resulet1<=5.2  &&resulet1>4.9 ) e1+=70.0;else if(resulet1<=4.9  &&resulet1>4.7 ) e1+=75.0;
				else if(resulet1<=4.7  &&resulet1>4.3 ) e1+=80.0;else if(resulet1<=4.3  &&resulet1>4 ) e1+=85.0;else if(resulet1<=4  &&resulet1>3.8 ) e1+=90.0;else if(resulet1<= 3.8  ) e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1 >=-8.8 &&resulet1<-7.3 ) e1+=5.0;else if(resulet1 >=-7.3 &&resulet1<-6.4 )  e1+=10.0;else if(resulet1 >=-6.4  &&resulet1<-5.5 ) e1+=15.0;
				else if(resulet1 >=-5.5  &&resulet1<-4.8 ) e1+=20.0;else if(resulet1 >=-4.8  &&resulet1<-4.2 ) e1+=25.0;else if(resulet1 >=-4.2  &&resulet1<-3.7 ) e1+=30.0;else if(resulet1 >=-3.7  &&resulet1<-3.1 ) e1+=35.0;
				else if(resulet1 >=-3.1  &&resulet1<-2.6 ) e1+=40.0;else if(resulet1 >=-2.6  &&resulet1<-2.1 ) e1+=45.0;else if(resulet1 >=-2.1  &&resulet1<-1.6 ) e1+=50.0;else if(resulet1 >=-1.6  &&resulet1<-1.1 ) e1+=55.0;
				else if(resulet1 >=-1.1 &&resulet1<-0.5 ) e1+=60.0;else if(resulet1 >=-0.5  &&resulet1<0 ) e1+=65.0;else if(resulet1 >=0  &&resulet1<0.6 ) e1+=70.0;else if(resulet1 >=0.6  &&resulet1<1.3 ) e1+=75.0;
				else if(resulet1 >=1.3  &&resulet1<2.2 ) e1+=80.0;else if(resulet1 >=2.2  &&resulet1<3.1 ) e1+=85.0;else if(resulet1 >=3.1  &&resulet1<4.5 ) e1+=90.0;else if(resulet1 >= 4.5  ) e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1<=10.8  &&resulet1> 10) e1+=5.0;else if(resulet1<=10  &&resulet1>9.5 ) e1+=10.0;else if(resulet1<=9.5  &&resulet1>9 ) e1+=15.0;
				else if(resulet1<=9  &&resulet1>8.7 ) e1+=20.0;else if(resulet1<=8.7  &&resulet1>8.3 ) e1+=25.0;else if(resulet1<=8.3  &&resulet1>8.1 ) e1+=30.0;else if(resulet1<=8.1  &&resulet1>7.8 ) e1+=35.0;
				else if(resulet1<=7.8  &&resulet1>7.5 ) e1+=40.0;else if(resulet1<=7.5  &&resulet1>7.2 ) e1+=45.0;else if(resulet1<=7.2  &&resulet1>6.9 ) e1+=50.0;else if(resulet1<=6.9  &&resulet1>6.7 ) e1+=55.0;
				else if(resulet1<=6.7  &&resulet1>6.3 ) e1+=60.0;else if(resulet1<=6.3  &&resulet1>6.1 ) e1+=65.0;else if(resulet1<=6.1  &&resulet1>5.7 ) e1+=70.0;else if(resulet1<=5.7 &&resulet1>5.4 ) e1+=75.0;
				else if(resulet1<=5.4  &&resulet1>4.9 ) e1+=80.0;else if(resulet1<=4.9  &&resulet1>4.4 ) e1+=85.0;else if(resulet1<=4.4  &&resulet1>4 ) e1+=90.0;else if(resulet1<=4   ) e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1<=12  &&resulet1>11.1 ) e1+=5.0;else if(resulet1<=11.1  &&resulet1>10.5 ) e1+=10.0;else if(resulet1<=10.5  &&resulet1>10 ) e1+=15.0;
				else if(resulet1<=10  &&resulet1>9.6 ) e1+=20.0;else if(resulet1<=9.6  &&resulet1>9.2 ) e1+=25.0;else if(resulet1<=9.2  &&resulet1>8.9 ) e1+=30.0;else if(resulet1<=8.9  &&resulet1>8.5 ) e1+=35.0;
				else if(resulet1<=8.5  &&resulet1>8.2 ) e1+=40.0;else if(resulet1<=8.2  &&resulet1>7.9 ) e1+=45.0;else if(resulet1<=7.9  &&resulet1>7.6 ) e1+=50.0;else if(resulet1<=7.6  &&resulet1>7.3 ) e1+=55.0;
				else if(resulet1<=7.3  &&resulet1>6.9 ) e1+=60.0;else if(resulet1<=6.9  &&resulet1>6.6 ) e1+=65.0;else if(resulet1<=6.6  &&resulet1>6.2 ) e1+=70.0;else if(resulet1<=6.2  &&resulet1>5.8 ) e1+=75.0;
				else if(resulet1<=5.8  &&resulet1>5.3 ) e1+=80.0;else if(resulet1<=5.3  &&resulet1>4.7 ) e1+=85.0;else if(resulet1<=4.7  &&resulet1>4.5 ) e1+=90.0;else if(resulet1<=4.5   ) e1+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet1<=14.6  &&resulet1>13.5 ) e1+=5.0;else if(resulet1<=13.5  &&resulet1>12.7 ) e1+=10.0;else if(resulet1<=12.7  &&resulet1>12.1 ) e1+=15.0;
				else if(resulet1<=12.1  &&resulet1>11.5 ) e1+=20.0;else if(resulet1<=11.5  &&resulet1>11.1 ) e1+=25.0;else if(resulet1<=11.1  &&resulet1>10.6 ) e1+=30.0;else if(resulet1<=10.6  &&resulet1>10.2) e1+=35.0;
				else if(resulet1<=10.2  &&resulet1>9.8 ) e1+=40.0;else if(resulet1<=9.8  &&resulet1>9.4 ) e1+=45.0;else if(resulet1<=9.4  &&resulet1>9 ) e1+=50.0;else if(resulet1<=9  &&resulet1>8.6 ) e1+=55.0;
				else if(resulet1<=8.6  &&resulet1>8.2 ) e1+=60.0;else if(resulet1<=8.2  &&resulet1>7.7 ) e1+=65.0;else if(resulet1<=7.7  &&resulet1>7.3 ) e1+=70.0;else if(resulet1<=7.3  &&resulet1>6.7 ) e1+=75.0;
				else if(resulet1<= 6.7 &&resulet1>6.1 ) e1+=80.0;else if(resulet1<=6.1  &&resulet1>5.3 ) e1+=85.0;else if(resulet1<=5.3 &&resulet1>5 ) e1+=90.0;else if(resulet1<= 5  ) e1+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==5) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet1<=67)e1+=5.0;else if(resulet1<=74 &&resulet1>67 )e1+=10.0;else if(resulet1<=79 &&resulet1>74 )e1+=15.0;
				else if(resulet1<=83 &&resulet1>79 )e1+=20.0;else if(resulet1<=87 &&resulet1>83 )e1+=25.0;else if(resulet1<=90 &&resulet1>87 )e1+=30.0;else if(resulet1<=93 &&resulet1>90 )e1+=35.0;
				else if(resulet1<=96 &&resulet1>93)e1+=40.0;else if(resulet1<=98 &&resulet1>96 )e1+=45.0;else if(resulet1<=101 &&resulet1>98 )e1+=50.0;else if(resulet1<=104 &&resulet1>101 )e1+=55.0;
				else if(resulet1<=106 &&resulet1>104 )e1+=60.0;else if(resulet1<=109 &&resulet1>106 )e1+=65.0;else if(resulet1<=112 &&resulet1>109 )e1+=70.0;else if(resulet1<=115 &&resulet1>112 )e1+=75.0;
				else if(resulet1<=119 &&resulet1>115 )e1+=80.0;else if(resulet1<=123 &&resulet1>119 )e1+=85.0;else if(resulet1<=128 &&resulet1>123 )e1+=90.0;else if(resulet1>128  )e1+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1<=67)e1+=5.0;else if(resulet1<=72 &&resulet1>67 )e1+=10.0;else if(resulet1<=77 &&resulet1>72 )e1+=15.0;
				else if(resulet1<=82 &&resulet1>77 )e1+=20.0;else if(resulet1<=86 &&resulet1>82 )e1+=25.0;	else if(resulet1<=89 &&resulet1>86 )e1+=30.0;else if(resulet1<=92 &&resulet1>89 )e1+=35.0;
				else if(resulet1<=95 &&resulet1>92 )e1+=40.0;else if(resulet1<=98 &&resulet1>95 )e1+=45.0;else if(resulet1<=101 &&resulet1>98 )e1+=50.0;else if(resulet1<=104 &&resulet1>101 )e1+=55.0;
				else if(resulet1<=107 &&resulet1>104 )e1+=60.0;else if(resulet1<=110 &&resulet1>107 )e1+=65.0;else if(resulet1<=113 &&resulet1>110 )e1+=70.0;else if(resulet1<=116 &&resulet1>113 )e1+=75.0;
				else if(resulet1<=120 &&resulet1>116 )e1+=80.0;else if(resulet1<=125 &&resulet1>120 )e1+=85.0;else if(resulet1<=130 &&resulet1>125 )e1+=90.0;else if(resulet1>130  )e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet1<=67)e1+=5.0;else if(resulet1<=66 &&resulet1>67 )e1+=10.0;
				else if(resulet1<=71 &&resulet1>66 )e1+=15.0;else if(resulet1<=76 &&resulet1>71 )e1+=20.0;else if(resulet1<=80 &&resulet1>76 )e1+=25.0;else if(resulet1<=83 &&resulet1>80 )e1+=30.0;else if(resulet1<=86 &&resulet1>83 )e1+=35.0;
				else if(resulet1<=89 &&resulet1>86 )e1+=40.0;else if(resulet1<=92 &&resulet1>89 )e1+=45.0;else if(resulet1<=95 &&resulet1>92 )e1+=50.0;else if(resulet1<=98 &&resulet1>95 )e1+=55.0;
				else if(resulet1<=101 &&resulet1>98 )e1+=60.0;else if(resulet1<=104 &&resulet1>101 )e1+=65.0;else if(resulet1<=107 &&resulet1>104 )e1+=70.0;else if(resulet1<=110 &&resulet1>107 )e1+=75.0;
				else if(resulet1<=114 &&resulet1>110 )e1+=80.0;else if(resulet1<=119 &&resulet1>114 )e1+=85.0;else if(resulet1<=124 &&resulet1>119 )e1+=90.0;else if(resulet1>124  )e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1<=47)e1+=5.0;else if(resulet1<=56 &&resulet1>47 )e1+=10.0;else if(resulet1<=63 &&resulet1>56 )e1+=15.0;
				else if(resulet1<=68 &&resulet1>63 )e1+=20.0;else if(resulet1<=73 &&resulet1>68 )e1+=25.0;else if(resulet1<=77 &&resulet1>73 )e1+=30.0;else if(resulet1<=80 &&resulet1>77 )e1+=35.0;
				else if(resulet1<=84 &&resulet1>80 )e1+=40.0;else if(resulet1<=87 &&resulet1>84 )e1+=45.0;else if(resulet1<=91 &&resulet1>87 )e1+=50.0;else if(resulet1<=95 &&resulet1>91 )e1+=55.0;
				else if(resulet1<=98 &&resulet1>95 )e1+=60.0;else if(resulet1<=102 &&resulet1>98 )e1+=65.0;else if(resulet1<=105 &&resulet1>102 )e1+=70.0;else if(resulet1<=109 &&resulet1>105 )e1+=75.0;
				else if(resulet1<=114 &&resulet1>109 )e1+=80.0;else if(resulet1<=119 &&resulet1>114 )e1+=85.0;else if(resulet1<=126 &&resulet1>119 )e1+=90.0;else if(resulet1>126  )e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1<=48)e1+=5.0;else if(resulet1<=56 &&resulet1>48 )e1+=10.0;else if(resulet1<=62 &&resulet1>56 )e1+=15.0;else if(resulet1<=67 &&resulet1>62 )e1+=20.0;else if(resulet1<=71 &&resulet1>67 )e1+=25.0;else if(resulet1<=75 &&resulet1>71 )e1+=30.0;
				else if(resulet1<=78 &&resulet1>75 )e1+=35.0;else if(resulet1<=81 &&resulet1>78 )e1+=40.0;else if(resulet1<=84 &&resulet1>81 )e1+=45.0;else if(resulet1<=87 &&resulet1>84 )e1+=50.0;else if(resulet1<=90 &&resulet1>87 )e1+=55.0;
				else if(resulet1<=93 &&resulet1>90 )e1+=60.0;else if(resulet1<=96 &&resulet1>93 )e1+=65.0;else if(resulet1<=99 &&resulet1>96 )e1+=70.0;else if(resulet1<=103 &&resulet1>99 )e1+=75.0;
				else if(resulet1<=107 &&resulet1>103 )e1+=80.0;else if(resulet1<=112 &&resulet1>107 )e1+=85.0;else if(resulet1<=118 &&resulet1>112 )e1+=90.0;else if(resulet1>118  )e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1<=36)e1+=5.0;else if(resulet1<=44 &&resulet1>36 )e1+=10.0;else if(resulet1<=50 &&resulet1>44 )e1+=15.0;else if(resulet1<=55 &&resulet1>50 )e1+=20.0;
				else if(resulet1<=59 &&resulet1>55 )e1+=25.0;else if(resulet1<=63 &&resulet1>59 )e1+=30.0;else if(resulet1<=66 &&resulet1>63 )e1+=35.0;else if(resulet1<=69 &&resulet1>66 )e1+=40.0;else if(resulet1<=72 &&resulet1>69 )e1+=45.0;
				else if(resulet1<=75 &&resulet1>72 )e1+=50.0;else if(resulet1<=78 &&resulet1>75 )e1+=55.0;else if(resulet1<=81 &&resulet1>78 )e1+=60.0;else if(resulet1<=84 &&resulet1>81 )e1+=65.0;else if(resulet1<=87 &&resulet1>84 )e1+=70.0;
				else if(resulet1<=91 &&resulet1>87 )e1+=75.0;else if(resulet1<=95 &&resulet1>91 )e1+=80.0;else if(resulet1<=100 &&resulet1>95 )e1+=85.0;else if(resulet1<=106 &&resulet1>100 )e1+=90.0;else if(resulet1>106  )e1+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet1<=26)e1+=5.0;else if(resulet1<=36 &&resulet1>26 )e1+=10.0;else if(resulet1<=42 &&resulet1>36 )e1+=15.0;else if(resulet1<=47 &&resulet1>42 )e1+=20.0;
				else if(resulet1<=52 &&resulet1>47 )e1+=25.0;else if(resulet1<=55 &&resulet1>52 )e1+=30.0;else if(resulet1<=59 &&resulet1>55 )e1+=35.0;else if(resulet1<=62 &&resulet1>59 )e1+=40.0;else if(resulet1<=66 &&resulet1>62 )e1+=45.0;
				else if(resulet1<=69 &&resulet1>66 )e1+=50.0;else if(resulet1<=72 &&resulet1>69 )e1+=55.0;else if(resulet1<=76 &&resulet1>72 )e1+=60.0;else if(resulet1<=79 &&resulet1>76 )e1+=65.0;else if(resulet1<=83 &&resulet1>79 )e1+=70.0;
				else if(resulet1<=86 &&resulet1>83 )e1+=75.0;else if(resulet1<=91 &&resulet1>86 )e1+=80.0;else if(resulet1<=96 &&resulet1>91 )e1+=85.0;else if(resulet1<=102 &&resulet1>96 )e1+=90.0;else if(resulet1>102  )e1+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==6) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet1 >=-11.3    && resulet1<-9.5) e1+=5.0;else if(resulet1 >=-9.5 && resulet1<-8.4)  e1+=10.0;else if(resulet1 >=-8.4 && resulet1<-7.4) e1+=15.0;
				else if(resulet1 >=-7.4 && resulet1<-6.6) e1+=20.0;else if(resulet1 >=-6.6 && resulet1<-5.9) e1+=25.0;else if(resulet1 >=-5.9 && resulet1<-5.3) e1+=30.0;else if(resulet1 >=-5.3 && resulet1<-4.6) e1+=35.0;
				else if(resulet1 >=-4.6 && resulet1<-4  ) e1+=40.0;else if(resulet1 >=-4   && resulet1<-3.4) e1+=45.0;else if(resulet1 >=-3.4 && resulet1<-2.8) e1+=50.0;else if(resulet1 >=-2.8 && resulet1<-2.2) e1+=55.0;
				else if(resulet1 >=-2.2 && resulet1<-1.5) e1+=60.0;else if(resulet1 >=-1.5 && resulet1<-0.9) e1+=65.0;else if(resulet1 >=-0.9 && resulet1<-0.2) e1+=70.0;else if(resulet1 >=-0.2 && resulet1< 0.6) e1+=75.0;
				else if(resulet1 >=0.6  && resulet1< 1.6) e1+=80.0;else if(resulet1 >=1.6  && resulet1< 2.7) e1+=85.0;else if(resulet1 >=2.7  && resulet1< 4.5) e1+=85.0;else if(resulet1 >4.5 ) e1+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1>=-12.1&&resulet1<-10.4 ) e1+=5.0;else if(resulet1>=-10.4 &&resulet1<-9.2 )  e1+=10.0;else if(resulet1>=-9.2  &&resulet1<-8.2 ) e1+=15.0;
				else if(resulet1>=-8.2  &&resulet1<-7.4 ) e1+=20.0;else if(resulet1>=-7.4 &&resulet1<-6.6 ) e1+=25.0;else if(resulet1>=-6.6  &&resulet1<-6 ) e1+=30.0;else if(resulet1>= -6 &&resulet1<-5.3 ) e1+=35.0;
				else if(resulet1>=-5.3  &&resulet1<-4.7 ) e1+=40.0;else if(resulet1>=-4.7  &&resulet1<-4.1 ) e1+=45.0;else if(resulet1>=-4.1  &&resulet1<-3.5 ) e1+=50.0;else if(resulet1>=-3.5  &&resulet1<-2.9 ) e1+=55.0;
				else if(resulet1>=-2.9  &&resulet1<-2.2 ) e1+=60.0;else if(resulet1>=-2.2  &&resulet1<-1.6 ) e1+=65.0;else if(resulet1>=-1.6  &&resulet1<-0.8 ) e1+=70.0;else if(resulet1>=-0.8  &&resulet1<0 ) e1+=75.0;
				else if(resulet1>=0  &&resulet1<1)e1+=80.0;else if(resulet1>=1  &&resulet1<2.2)e1+=85.0;else if(resulet1>=2.2  &&resulet1<3.9)e1+=90.0;else if(resulet1>= 3.9  ) e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet1 >=-12.5 &&resulet1<-10.8 ) e1+=5.0;else if(resulet1 >=-10.8 &&resulet1<-9.6 )  e1+=10.0;
				else if(resulet1 >=-9.6  &&resulet1<-8.6 ) e1+=15.0;else if(resulet1 >=-8.6 &&resulet1<-7.8 ) e1+=20.0;else if(resulet1 >=-7.8  &&resulet1<-7 ) e1+=25.0;else if(resulet1 >=-7 &&resulet1<-6.4 ) e1+=30.0;
				else if(resulet1 >-6.4 &&resulet1<-5.7 ) e1+=35.0;else if(resulet1 >=-5.7  &&resulet1<-5.1 ) e1+=40.0;else if(resulet1 >=-5.1  &&resulet1<-4.5 ) e1+=45.0;else if(resulet1 >=-4.5  &&resulet1<-3.9 ) e1+=50.0;
				else if(resulet1 >=-3.9  &&resulet1<-3.3 ) e1+=55.0;else if(resulet1 >=-3.3  &&resulet1<-2.6 ) e1+=60.0;else if(resulet1 >=-2.6 &&resulet1< -2) e1+=65.0;
				else if(resulet1 >= -2 &&resulet1<-1.2 ) e1+=70.0;else if(resulet1 >=-1.2  &&resulet1<-0.4 ) e1+=75.0;
				else if(resulet1 >=-0.4  &&resulet1<0.6 ) e1+=80.0;else if(resulet1 >= 0.6 &&resulet1<1.8 ) e1+=85.0;else if(resulet1 >=1.8  &&resulet1<3.5 ) e1+=90.0;else if(resulet1 >= 3.5  ) e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1 >=-14 &&resulet1<-12.1 ) e1+=5.0;else if(resulet1 >=-12.1 &&resulet1<-10.9 )  e1+=10.0;else if(resulet1 >= -10.9 &&resulet1<-9.9 ) e1+=15.0;
				else if(resulet1 >=-9.9  &&resulet1<-9 ) e1+=20.0;else if(resulet1 >=-9  &&resulet1< -8.3) e1+=25.0;else if(resulet1 >=-8.3  &&resulet1<-7.6 ) e1+=30.0;else if(resulet1 >= -7.6 &&resulet1<-6.9 ) e1+=35.0;
				else if(resulet1 >=-6.9  &&resulet1<-6.3 ) e1+=40.0;else if(resulet1 >=-6.3  &&resulet1<-5.6 ) e1+=45.0;else if(resulet1 >=-5.6  &&resulet1<-4.9 ) e1+=50.0;else if(resulet1 >=-4.9  &&resulet1<-4.3 ) e1+=55.0;
				else if(resulet1 >=-4.3  &&resulet1< -3.6) e1+=60.0;else if(resulet1 >= -3.6 &&resulet1< -2.9) e1+=65.0;else if(resulet1 >=-2.9  &&resulet1< -2.2) e1+=70.0;else if(resulet1 >= -2.2 &&resulet1< -1.3) e1+=75.0;
				else if(resulet1 >= -1.3 &&resulet1<-0.3 ) e1+=80.0;else if(resulet1 >= -0.3 &&resulet1< 0.9) e1+=85.0;else if(resulet1 >= 0.9 &&resulet1<2.8 ) e1+=90.0;else if(resulet1 >= 2.8  ) e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1 >=-14.6 &&resulet1<-12.6 ) e1+=5.0;else if(resulet1 >=-12.6 &&resulet1<-11.3 )  e1+=10.0;else if(resulet1 >=-11.3  &&resulet1<-10.2 ) e1+=15.0;
				else if(resulet1 >= -10.2 &&resulet1<-9.3 ) e1+=20.0;else if(resulet1 >=-9.3  &&resulet1<-8.5 ) e1+=25.0;else if(resulet1 >=-8.5  &&resulet1<-7.8 ) e1+=30.0;else if(resulet1 >=-7.8  &&resulet1<-7.1 ) e1+=35.0;
				else if(resulet1 >=-7.1  &&resulet1<-6.4 ) e1+=40.0;else if(resulet1 >=-6.4  &&resulet1<-5.7 ) e1+=45.0;else if(resulet1 >=-5.7  &&resulet1<-5 ) e1+=50.0;else if(resulet1 >= -5 &&resulet1<-4.3 ) e1+=55.0;
				else if(resulet1 >= -4.3 &&resulet1< -3.6) e1+=60.0;else if(resulet1 >= -3.6 &&resulet1<-2.9 ) e1+=65.0;else if(resulet1 >= -2.9 &&resulet1<-2.1 ) e1+=70.0;else if(resulet1 >= -2.1 &&resulet1<-1.2 ) e1+=75.0;
				else if(resulet1 >= -1.2 &&resulet1<-0.1 ) e1+=80.0;else if(resulet1 >= -0.1  &&resulet1< 1.2) e1+=85.0;else if(resulet1 >= 1.2 &&resulet1<3.2 ) e1+=90.0;else if(resulet1 >= 3.2  ) e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1<=11.5  &&resulet1>10.5 ) e1+=5.0;else if(resulet1<=10.5  &&resulet1>9.9 ) e1+=10.0;else if(resulet1<=9.9  &&resulet1>9.4 ) e1+=15.0;
				else if(resulet1<=9.4  &&resulet1>8.9 ) e1+=20.0;else if(resulet1<=8.9  &&resulet1>8.6 ) e1+=25.0;else if(resulet1<=8.6  &&resulet1>8.2 ) e1+=30.0;else if(resulet1<=8.2  &&resulet1>7.9 ) e1+=35.0;
				else if(resulet1<=7.9  &&resulet1>7.5 ) e1+=40.0;else if(resulet1<=7.5  &&resulet1>7.2 ) e1+=45.0;else if(resulet1<=7.2  &&resulet1>6.9 ) e1+=50.0;else if(resulet1<=6.9  &&resulet1>6.5 ) e1+=55.0;
				else if(resulet1<=6.5  &&resulet1>6.2 ) e1+=60.0;else if(resulet1<=6.2  &&resulet1>5.8 ) e1+=65.0;else if(resulet1<=5.8  &&resulet1>5.5 ) e1+=70.0;else if(resulet1<=5.5  &&resulet1>5 ) e1+=75.0;
				else if(resulet1<=5  &&resulet1>4.5 ) e1+=80.0;else if(resulet1<=4.5  &&resulet1>4.3 ) e1+=85.0;else if(resulet1<=4.3  &&resulet1>4 ) e1+=90.0;else if(resulet1<=4   ) e1+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet1 >=-15.1 &&resulet1<-13.3 ) e1+=5.0;else if(resulet1 >=-13.3 &&resulet1<-12.2 )  e1+=10.0;else if(resulet1 >= -12.2 &&resulet1<-11.2 ) e1+=15.0;
				else if(resulet1 >= -11.2 &&resulet1<-10.4 ) e1+=20.0;	else if(resulet1 >= -10.4 &&resulet1<-9.7 ) e1+=25.0;else if(resulet1 >= -9.7 &&resulet1<-9.1 ) e1+=30.0;else if(resulet1 >= -9.1 &&resulet1<-8.4 ) e1+=35.0;
				else if(resulet1 >= -8.4 &&resulet1<-7.8 ) e1+=40.0;else if(resulet1 >= -7.8 &&resulet1<-7.2 ) e1+=45.0;else if(resulet1 >= -7.2 &&resulet1<-6.6 ) e1+=50.0;else if(resulet1 >= -6.6 &&resulet1<-6 ) e1+=55.0;
				else if(resulet1 >= -6 &&resulet1<-5.3 ) e1+=60.0;else if(resulet1 >= -5.3 &&resulet1<-4.7 ) e1+=65.0;else if(resulet1 >= -4.7 &&resulet1<-4 ) e1+=70.0;else if(resulet1 >= -4 &&resulet1<-3.2 ) e1+=75.0;
				else if(resulet1 >= -3.2 &&resulet1<-2.2 ) e1+=80.0;else if(resulet1 >= -2.2 &&resulet1<-1.1 ) e1+=85.0;else if(resulet1 >=-1.1  &&resulet1<0.7 ) e1+=90.0;else if(resulet1 >=0.7   ) e1+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==7) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet1 <=6.8 &&resulet1>6.4 ) e1+=5.0;else if(resulet1 <=6.4 &&resulet1>6.1  )  e1+=10.0;
				else if(resulet1 <=6.1  &&resulet1>5.8  ) e1+=15.0;else if(resulet1 <=5.8  &&resulet1>5.6 ) e1+=20.0;else if(resulet1 >=5.6  &&resulet1>5.4 ) e1+=25.0;else if(resulet1 <=5.4  &&resulet1>5.2 ) e1+=30.0;
				else if(resulet1 <=5.2&&resulet1>5.0 ) e1+=35.0;else if(resulet1 <=5.0 &&resulet1>4.9 ) e1+=40.0;else if(resulet1 <=4.9  &&resulet1>4.7 ) e1+=45.0;else if(resulet1 <=4.7  &&resulet1>4.5 ) e1+=50.0;
				else if(resulet1 <=4.5 &&resulet1>4.4) e1+=55.0;else if(resulet1 <=4.4  &&resulet1>4.2 ) e1+=60.0;else if(resulet1 <=4.2  &&resulet1>4.0) e1+=65.0;else if(resulet1 <=4.0  &&resulet1>3.8 ) e1+=70.0;
				else if(resulet1 <=3.8  &&resulet1>3.6 ) e1+=75.0;else if(resulet1 <=3.6  &&resulet1>3.3) e1+=80.0;else if(resulet1 <=3.3  &&resulet1>3) e1+=85.0;else if(resulet1 <=3 ) e1+=90.0;
			
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet1 <=7.1 &&resulet1>6.6 ) e1+=5.0;else if(resulet1 <=6.6  &&resulet1> 6.3 )  e1+=10.0;else if(resulet1 <=6.3  &&resulet1>6.1  ) e1+=15.0;
				else if(resulet1 <=6.1  &&resulet1>5.9 ) e1+=20.0;else if(resulet1 <=5.9  &&resulet1>5.7 ) e1+=25.0;else if(resulet1 <=5.7  &&resulet1>5.6 ) e1+=30.0;else if(resulet1 <=5.6  &&resulet1>5.4 ) e1+=35.0;
				else if(resulet1 <=5.4  &&resulet1>5.3 ) e1+=40.0;else if(resulet1 <=5.3 &&resulet1>5.1 ) e1+=45.0;else if(resulet1 <=5.1  &&resulet1>4.9 ) e1+=50.0;else if(resulet1 <= 4.9&&resulet1>4.8) e1+=55.0;
				else if(resulet1 <=4.8  &&resulet1>4.6 ) e1+=60.0;else if(resulet1 <=4.6  &&resulet1>4.5) e1+=65.0;else if(resulet1 <=4.5  &&resulet1>4.3 ) e1+=70.0;else if(resulet1 <=4.3  &&resulet1>4.1 ) e1+=75.0;
				else if(resulet1 <=4.1  &&resulet1>3.9) e1+=80.0;else if(resulet1 <=3.9  &&resulet1>3.6) e1+=85.0;else if(resulet1 <=3.6 &&resulet1>3.1 ) e1+=90.0;else if(resulet1 <=3.1   ) e1+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				 if(resulet1 <=7.4 &&resulet1>7 ) e1+=5.0;else if(resulet1 <=7 &&resulet1> 6.7 )  e1+=10.0;else if(resulet1 <= 6.7 &&resulet1> 6.4  ) e1+=15.0;
				else if(resulet1 <= 6.4 &&resulet1> 6.2 ) e1+=20.0;else if(resulet1 <= 6.2 &&resulet1>6 ) e1+=25.0;else if(resulet1 <= 6 &&resulet1>5.8 ) e1+=30.0;else if(resulet1 <=5.8&&resulet1>5.6 ) e1+=35.0;
				else if(resulet1 <=5.6 &&resulet1>5.5 ) e1+=40.0;else if(resulet1 <=5.5  &&resulet1>5.3 ) e1+=45.0;else if(resulet1 <=5.3  &&resulet1>5.1 ) e1+=50.0;else if(resulet1 <=5.1 &&resulet1>5 ) e1+=55.0;
				else if(resulet1 <=5  &&resulet1>4.8 ) e1+=60.0;else if(resulet1 <=4.8  &&resulet1>4.6) e1+=65.0;else if(resulet1 <=4.6  &&resulet1>4.4 ) e1+=70.0;else if(resulet1 <=4.4  &&resulet1>4.2 ) e1+=75.0;
				else if(resulet1 <=4.2  &&resulet1>3.9 ) e1+=80.0;else if(resulet1 <=3.9  &&resulet1>3.6) e1+=85.0;else if(resulet1 <=3.6 &&resulet1>3.2 ) e1+=90.0;else if(resulet1 <=3.2   ) e1+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet1 <=9 &&resulet1<8.3 ) e1+=5.0;else if(resulet1 <=8.3 &&resulet1>7.9)  e1+=10.0;else if(resulet1 <=7.9 &&resulet1>7.5) e1+=15.0;
				else if(resulet1 <=7.5 &&resulet1>7.2) e1+=20.0;else if(resulet1 <=7.2 &&resulet1>6.9) e1+=25.0;else if(resulet1 <=6.9 &&resulet1>6.6) e1+=30.0;else if(resulet1 <=6.6 &&resulet1>6.4) e1+=35.0;
				else if(resulet1 <=6.4 &&resulet1>6.1) e1+=40.0;else if(resulet1 <=6.1 &&resulet1>5.9) e1+=45.0;else if(resulet1 <=5.9 &&resulet1>5.7) e1+=50.0;else if(resulet1 <=5.7 &&resulet1>5.4) e1+=55.0;
				else if(resulet1 <=5.4 &&resulet1>5.2) e1+=60.0;else if(resulet1 <=5.2 &&resulet1>4.9) e1+=65.0;else if(resulet1 <=4.9  &&resulet1>4.6) e1+=70.0;else if(resulet1 <=4.6 &&resulet1>4.3) e1+=75.0;
				else if(resulet1 <=4.3  &&resulet1>3.9) e1+=80.0;else if(resulet1 <=3.9  &&resulet1>3.5) e1+=85.0;else if(resulet1 <=3.5 &&resulet1>3.3) e1+=90.0;else if(resulet1 <=3.3   ) e1+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet1<=9.4  &&resulet1>8.7 ) e1+=5.0;else if(resulet1<=8.7  &&resulet1>8.3 ) e1+=10.0;else if(resulet1<=8.3  &&resulet1>7.9 ) e1+=15.0;
				else if(resulet1<=7.9  &&resulet1>7.6 ) e1+=20.0;else if(resulet1<=7.6  &&resulet1>7.3 ) e1+=25.0;else if(resulet1<=7.3  &&resulet1>7.1 ) e1+=30.0;else if(resulet1<=7.1  &&resulet1>6.9 ) e1+=35.0;
				else if(resulet1<=6.9  &&resulet1>6.6 ) e1+=40.0;else if(resulet1<=6.6  &&resulet1>6.4 ) e1+=45.0;else if(resulet1<=6.4  &&resulet1>6.2 ) e1+=50.0;else if(resulet1<=6.2  &&resulet1>6 ) e1+=55.0;
				else if(resulet1<=6    &&resulet1>5.7 ) e1+=60.0;else if(resulet1<=5.7  &&resulet1>5.5 ) e1+=65.0;else if(resulet1<=5.5  &&resulet1>5.2 ) e1+=70.0;else if(resulet1<=5.2  &&resulet1>4.9 ) e1+=75.0;
				else if(resulet1<=4.9  &&resulet1>4.5 ) e1+=80.0;else if(resulet1<=4.5  &&resulet1>4.1 ) e1+=85.0;else if(resulet1<=4.1  &&resulet1>4 ) e1+=90.0;else if(resulet1<=4   ) e1+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet1<=11.5  &&resulet1>10.5 ) e1+=5.0;else if(resulet1<=10.5  &&resulet1>9.9 ) e1+=10.0;else if(resulet1<=9.9  &&resulet1>9.4 ) e1+=15.0;
				else if(resulet1<=9.4  &&resulet1>8.9 ) e1+=20.0;else if(resulet1<=8.9  &&resulet1>8.6 ) e1+=25.0;else if(resulet1<=8.6  &&resulet1>8.2 ) e1+=30.0;else if(resulet1<=8.2  &&resulet1>7.9 ) e1+=35.0;
				else if(resulet1<=7.9  &&resulet1>7.5 ) e1+=40.0;else if(resulet1<=7.5  &&resulet1>7.2 ) e1+=45.0;else if(resulet1<=7.2  &&resulet1>6.9 ) e1+=50.0;else if(resulet1<=6.9  &&resulet1>6.5 ) e1+=55.0;
				else if(resulet1<=6.5  &&resulet1>6.2 ) e1+=60.0;else if(resulet1<=6.2  &&resulet1>5.8 ) e1+=65.0;else if(resulet1<=5.8  &&resulet1>5.5 ) e1+=70.0;else if(resulet1<=5.5  &&resulet1>5 ) e1+=75.0;
				else if(resulet1<=5  &&resulet1>4.5 ) e1+=80.0;else if(resulet1<=4.5  &&resulet1>4.3 ) e1+=85.0;else if(resulet1<=4.3  &&resulet1>4 ) e1+=90.0;else if(resulet1<=4   ) e1+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet1<=12.9  &&resulet1>11.8 ) e1+=5.0;else if(resulet1<=11.8  &&resulet1>11.1 ) e1+=10.0;else if(resulet1<=11.1  &&resulet1>10.5 ) e1+=15.0;
				else if(resulet1<=10.5  &&resulet1>10 ) e1+=20.0;else if(resulet1<=10  &&resulet1>9.6 ) e1+=25.0;else if(resulet1<=9.6  &&resulet1>9.2 ) e1+=30.0;else if(resulet1<=9.2  &&resulet1>8.8 ) e1+=35.0;
				else if(resulet1<=8.8  &&resulet1>8.5 ) e1+=40.0;else if(resulet1<=8.5  &&resulet1>8.1 ) e1+=45.0;else if(resulet1<=8.1  &&resulet1>7.7 ) e1+=50.0;else if(resulet1<=7.7  &&resulet1>7.4 ) e1+=55.0;
				else if(resulet1<=7.4  &&resulet1>7 ) e1+=60.0;else if(resulet1<=7  &&resulet1>6.6 ) e1+=65.0;else if(resulet1<=6.6  &&resulet1>6.2 ) e1+=70.0;else if(resulet1<=6.2  &&resulet1>5.7 ) e1+=75.0;
				else if(resulet1<=5.7  &&resulet1>5.1 ) e1+=80.0;else if(resulet1<=5.1  &&resulet1>4.5 ) e1+=85.0;else if(resulet1<=4.5  &&resulet1>4.3 ) e1+=90.0;else if(resulet1<=4.3   ) e1+=95.0;
			
			}
		}
		return e1;
	}
	
	public static Double getTsl(List<FitnessVO1> recod,int calibrations){
		double score=0.0;
		for(FitnessVO1 v1:recod){
			double resulet=v1.getResultE();
			if (v1.getSex() == 0&&calibrations==5) {// 女性
				if (v1.getAge() < 65) {
					if(resulet<=52)score+=5.0;else if(resulet<=60&&resulet>52)score+=10.0;else if(resulet<=66 &&resulet>60 )score+=15.0;else if(resulet<=71 &&resulet>66 )score+=20.0;
					else if(resulet<=75 &&resulet>71 )score+=25.0;else if(resulet<=79 &&resulet>75 )score+=30.0;else if(resulet<=82 &&resulet>79 )score+=35.0;else if(resulet<=85 &&resulet>82 )score+=40.0;
					else if(resulet<=88 &&resulet>85 )score+=45.0;else if(resulet<=91 &&resulet>88 )score+=50.0;else if(resulet<=94 &&resulet>91 )score+=55.0;else if(resulet<=97 &&resulet>94 )score+=60.0;
					else if(resulet<=100 &&resulet>97 )score+=65.0;else if(resulet<=103 &&resulet>100 )score+=70.0;else if(resulet<=107 &&resulet>103 )score+=75.0;else if(resulet<=111 &&resulet>107 )score+=80.0;
					else if(resulet<=116 &&resulet>111 )score+=85.0;else if(resulet<=122 &&resulet>116 )score+=90.0;else if(resulet>122 )score+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=47)score+=5.0;else if(resulet<=57 &&resulet>47 )score+=10.0;else if(resulet<=63 &&resulet>57 )score+=15.0;
					else if(resulet<=68 &&resulet>63 )score+=20.0;else if(resulet<=73 &&resulet>68 )score+=25.0;else if(resulet<=76 &&resulet>73 )score+=30.0;else if(resulet<=80 &&resulet>76 )score+=35.0;
					else if(resulet<=84 &&resulet>80 )score+=40.0;else if(resulet<=87 &&resulet>84 )score+=45.0;else if(resulet<=90 &&resulet>87 )score+=50.0;else if(resulet<=93 &&resulet>90 )score+=55.0;
					else if(resulet<=96 &&resulet>93 )score+=60.0;else if(resulet<=100 &&resulet>96 )score+=65.0;else if(resulet<=104 &&resulet>100 )score+=70.0;else if(resulet<=107 &&resulet>104 )score+=75.0;
					else if(resulet<=112 &&resulet>107 )score+=80.0;else if(resulet<=117 &&resulet>112 )score+=85.0;else if(resulet<=123 &&resulet>117 )score+=90.0;else if(resulet>123 )score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=43)score+=5.0;else if(resulet<=52 &&resulet>43 )score+=10.0;
					else if(resulet<=58 &&resulet>52 )score+=15.0;else if(resulet<=63 &&resulet>58 )score+=20.0;else if(resulet<=68 &&resulet>63 )score+=25.0;else if(resulet<=71 &&resulet>68 )score+=30.0;
					else if(resulet<=74 &&resulet>71 )score+=35.0;else if(resulet<=78 &&resulet>74 )score+=40.0;else if(resulet<=81 &&resulet>78 )score+=45.0;else if(resulet<=84 &&resulet>81 )score+=50.0;
					else if(resulet<=87 &&resulet>84 )score+=55.0;else if(resulet<=90 &&resulet>87 )score+=60.0;else if(resulet<=94 &&resulet>90 )score+=65.0;else if(resulet<=97 &&resulet>94 )score+=70.0;
					else if(resulet<=101 &&resulet>97 )score+=75.0;else if(resulet<=105 &&resulet>101 )score+=80.0;else if(resulet<=110 &&resulet>105 )score+=85.0;else if(resulet>116 )score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=45)score+=5.0;else if(resulet<=53 &&resulet>45 )score+=10.0;else if(resulet<=59 &&resulet>53 )score+=15.0;
					else if(resulet<=64 &&resulet>59 )score+=20.0;else if(resulet<=68 &&resulet>64 )score+=25.0;else if(resulet<=72 &&resulet>68 )score+=30.0;else if(resulet<=75 &&resulet>72 )score+=35.0;
					else if(resulet<=78 &&resulet>75 )score+=40.0;else if(resulet<=81 &&resulet>78 )score+=45.0;else if(resulet<=84 &&resulet>81 )score+=50.0;else if(resulet<=87 &&resulet>84 )score+=55.0;
					else if(resulet<=90 &&resulet>87 )score+=60.0;else if(resulet<=93 &&resulet>90 )score+=65.0;else if(resulet<=96 &&resulet>93 )score+=70.0;else if(resulet<=100 &&resulet>96 )score+=75.0;
					else if(resulet<=104 &&resulet>100 )score+=80.0;else if(resulet<=109 &&resulet>104 )score+=85.0;else if(resulet<=115 &&resulet>109 )score+=90.0;else if(resulet>115 )score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=37)score+=5.0;else if(resulet<=46 &&resulet>37 )score+=10.0;else if(resulet<=51 &&resulet>46 )score+=15.0;
					else if(resulet<=56 &&resulet>51 )score+=20.0;else if(resulet<=60 &&resulet>56 )score+=25.0;else if(resulet<=63 &&resulet>60  )score+=30.0;else if(resulet<=66 &&resulet>63  )score+=35.0;
					else if(resulet<=69 &&resulet>66  )score+=40.0;else if(resulet<=72 &&resulet>69  )score+=45.0;else if(resulet<=75 &&resulet>72  )score+=50.0;else if(resulet<=78 &&resulet>75  )score+=55.0;
					else if(resulet<=81 &&resulet>78  )score+=60.0;else if(resulet<=84 &&resulet>81  )score+=65.0;else if(resulet<=87 &&resulet>84  )score+=70.0;else if(resulet<=90 &&resulet>87  )score+=75.0;
					else if(resulet<=94 &&resulet>90  )score+=80.0;else if(resulet<=99 &&resulet>94  )score+=85.0;else if(resulet<=104 &&resulet>99 )score+=90.0;else if(resulet>104  )score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=39)score+=5.0;else if(resulet<=42 &&resulet>39 )score+=10.0;else if(resulet<=47 &&resulet>42 )score+=15.0;
					else if(resulet<=52 &&resulet>47 )score+=20.0;else if(resulet<=55 &&resulet>52 )score+=25.0;else if(resulet<=59 &&resulet>55 )score+=30.0;else if(resulet<=61 &&resulet>59 )score+=35.0;
					else if(resulet<=64 &&resulet>61 )score+=40.0;else if(resulet<=67 &&resulet>64 )score+=45.0;else if(resulet<=70 &&resulet>67 )score+=50.0;else if(resulet<=73 &&resulet>70 )score+=55.0;
					else if(resulet<=76 &&resulet>73 )score+=60.0;else if(resulet<=79 &&resulet>76 )score+=65.0;else if(resulet<=81 &&resulet>79 )score+=70.0;else if(resulet<=85 &&resulet>81 )score+=75.0;
					else if(resulet<=88 &&resulet>85 )score+=80.0;else if(resulet<=93 &&resulet>88 )score+=85.0;else if(resulet<=98 &&resulet>93 )score+=90.0;else if(resulet>98  )score+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet<=24)score+=5.0;else if(resulet<=31 &&resulet>24 )score+=10.0;else if(resulet<=36 &&resulet>31 )score+=15.0;
					else if(resulet<=40 &&resulet>36 )score+=20.0;else if(resulet<=44 &&resulet>40 )score+=25.0;else if(resulet<=47 &&resulet>44 )score+=30.0;else if(resulet<=50 &&resulet>47 )score+=35.0;
					else if(resulet<=53 &&resulet>50 )score+=40.0;else if(resulet<=55 &&resulet>53 )score+=45.0;else if(resulet<=58 &&resulet>55 )score+=50.0;else if(resulet<=61 &&resulet>58 )score+=55.0;
					else if(resulet<=63 &&resulet>61 )score+=60.0;else if(resulet<=66 &&resulet>63 )score+=65.0;else if(resulet<=69 &&resulet>66 )score+=70.0;else if(resulet<=72 &&resulet>69 )score+=75.0;
					else if(resulet<=76 &&resulet>72 )score+=80.0;else if(resulet<=80 &&resulet>76 )score+=85.0;else if(resulet<=85 &&resulet>80 )score+=90.0;else if(resulet>85  )score+=95.0;
				}
			}
			if (v1.getSex() == 0&&calibrations==6) {// 女性
				if (v1.getAge() < 65) {
					if(resulet >=-6.4 &&resulet<-5.2 ) score+=5.0;else if(resulet >=-5.2 &&resulet<-4.3 )  score+=10.0;else if(resulet >= -4.3 &&resulet<-3.6 ) score+=15.0;
					else if(resulet >=-3.6  &&resulet<-3 ) score+=20.0;else if(resulet >= -3 &&resulet<-2.5 ) score+=25.0;else if(resulet >=-2.5  &&resulet<-2.1 ) score+=30.0;else if(resulet >= -2.1 &&resulet< -1.6) score+=35.0;
					else if(resulet >= -1.6 &&resulet<-1.2 ) score+=40.0;else if(resulet >= -1.2 &&resulet<-0.7 ) score+=45.0;else if(resulet >= -0.7 &&resulet<-0.2 ) score+=50.0;else if(resulet >= -0.2 &&resulet<0.2 ) score+=55.0;
					else if(resulet >= 0.2 &&resulet< 0.7) score+=60.0;else if(resulet >= 0.7 &&resulet< 1.1) score+=65.0;else if(resulet >= 1.1 &&resulet< 1.6) score+=70.0;else if(resulet >= 1.6 &&resulet<2.2 ) score+=75.0;
					else if(resulet >= 2.2 &&resulet<2.9 ) score+=80.0;else if(resulet >= 2.9 &&resulet<3.8 ) score+=85.0;else if(resulet >= 3.8 &&resulet<5 ) score+=90.0;else if(resulet >=  5 ) score+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet >=-7.3 &&resulet<-5.9 ) score+=5.0;else if(resulet >=-5.9 &&resulet< -5)  score+=10.0;else if(resulet >= -5 &&resulet< -4.3) score+=15.0;
					else if(resulet >= -4.3 &&resulet< -3.7) score+=20.0;else if(resulet >= -3.7 &&resulet< -3.1) score+=25.0;else if(resulet >= -3.1 &&resulet< -2.6) score+=30.0;else if(resulet >= -2.6 &&resulet< -2.1) score+=35.0;
					else if(resulet >= -2.1 &&resulet< -1.7) score+=40.0;else if(resulet >= -1.7 &&resulet< -1.2) score+=45.0;else if(resulet >= -1.2 &&resulet<-0.7 ) score+=50.0;else if(resulet >= -0.7 &&resulet<-0.3 ) score+=55.0;
					else if(resulet >= -0.3 &&resulet< 0.2) score+=60.0;else if(resulet >= 0.2 &&resulet<0.7 ) score+=65.0;else if(resulet >= 0.7 &&resulet<1.3 ) score+=70.0;else if(resulet >= 1.3 &&resulet<1.9 ) score+=75.0;
					else if(resulet >= 1.9 &&resulet<2.6 ) score+=80.0;else if(resulet >= 2.6 &&resulet<3.5 ) score+=85.0;else if(resulet >= 3.5 &&resulet<4.9 ) score+=90.0;else if(resulet >= 4.9  ) score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=43)score+=5.0;else if(resulet<=52 &&resulet>43 )score+=10.0;
					if(resulet >=-7.9 &&resulet<-6.6 ) score+=5.0;else if(resulet >=-6.6 &&resulet<-5.7 )  score+=10.0;else if(resulet >=-5.7  &&resulet<-4.9 ) score+=15.0;
					else if(resulet >=-4.9  &&resulet<-4.2 ) score+=20.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=25.0;else if(resulet >=-3.7  &&resulet<-3.2 ) score+=30.0;else if(resulet >=-3.2  &&resulet<-2.6 ) score+=35.0;
					else if(resulet >=-2.6  &&resulet<-2.2 ) score+=40.0;else if(resulet >=-2.2  &&resulet<-1.7 ) score+=45.0;else if(resulet >=-1.7  &&resulet<-1.2 ) score+=50.0;else if(resulet >=-1.2  &&resulet<-0.8 ) score+=55.0;
					else if(resulet >=-0.8  &&resulet<-0.2 ) score+=60.0;else if(resulet >=-0.2  &&resulet<0.3 ) score+=65.0;else if(resulet >=0.3  &&resulet<0.8 ) score+=70.0;else if(resulet >=0.8  &&resulet<1.5 ) score+=75.0;
					else if(resulet >=1.5  &&resulet<2.3 ) score+=80.0;else if(resulet >=2.3  &&resulet< 3.2) score+=85.0;else if(resulet >=3.2  &&resulet<4.5 ) score+=90.0;else if(resulet >= 4.5  ) score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=8.9  &&resulet>8.3 ) score+=5.0;else if(resulet<=8.3  &&resulet>8 ) score+=10.0;else if(resulet<=8  &&resulet>7.6 ) score+=15.0;else if(resulet<=7.6  &&resulet>7.4 ) score+=20.0;
					else if(resulet<=7.4  &&resulet>7.1 ) score+=25.0;else if(resulet<=7.1  &&resulet>6.9 ) score+=30.0;else if(resulet<=6.9  &&resulet>6.7 ) score+=35.0;
					else if(resulet<=6.7  &&resulet>6.5 ) score+=40.0;else if(resulet<=6.5  &&resulet>6.3 ) score+=45.0;else if(resulet<=6.3  &&resulet>6.1 ) score+=50.0;else if(resulet<=6.1  &&resulet>5.9 ) score+=55.0;
					else if(resulet<=5.9  &&resulet>5.7 ) score+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) score+=70.0;else if(resulet<=5.2  &&resulet>5 ) score+=75.0;
					else if(resulet<=5  &&resulet>4.6 ) score+=80.0;else if(resulet<=4.6  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet >=-9.5 &&resulet<-8 ) score+=5.0;else if(resulet >=-8 &&resulet<-7 )  score+=10.0;else if(resulet >=-7  &&resulet<-6.1 ) score+=15.0;
					else if(resulet >=-6.1  &&resulet<-5.4 ) score+=20.0;else if(resulet >=-5.4  &&resulet<-4.8 ) score+=25.0;else if(resulet >=-4.8  &&resulet<-4.2 ) score+=30.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=35.0;
					else if(resulet >=-3.7  &&resulet<-3.1 ) score+=40.0;else if(resulet >=-3.1  &&resulet<-2.6 ) score+=45.0;else if(resulet >=-2.6  &&resulet<-2.1 ) score+=50.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=55.0;
					else if(resulet >=-1.6 &&resulet< -1) score+=60.0;else if(resulet >=  -1&&resulet<-0.4) score+=65.0;else if(resulet >=  -0.4 &&resulet<  0.2 ) score+=70.0;else if(resulet >= 0.2 &&resulet< 0.9 ) score+=75.0;
					else if(resulet >= 0.9 &&resulet<1.8 ) score+=80.0;else if(resulet >=  2.8&&resulet<2.8 ) score+=85.0;else if(resulet >= 2.8  &&resulet<4.3 ) score+=90.0;else if(resulet >= 4.3  ) score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet >=-11.3 &&resulet<-9.7 ) score+=5.0;else if(resulet >=-9.7 &&resulet<-8.6 )  score+=10.0;else if(resulet >=-8.6  &&resulet<-7.7 ) score+=15.0;
					else if(resulet >=-7.7  &&resulet<-6.9 ) score+=20.0;else if(resulet >=-6.9  &&resulet<-6.2 ) score+=25.0;else if(resulet >=-6.2  &&resulet<-5.7 ) score+=30.0;else if(resulet >=-5.7  &&resulet<-5 ) score+=35.0;
					else if(resulet >=-5  &&resulet<-4.5 ) score+=40.0;else if(resulet >=-4.5  &&resulet<-3.9 ) score+=45.0;else if(resulet >=-3.9  &&resulet<-3.3 ) score+=50.0;else if(resulet >=-3.3  &&resulet<-2.8 ) score+=55.0;
					else if(resulet >=-2.8  &&resulet<-2.1 ) score+=60.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=65.0;else if(resulet >=-1.6  &&resulet<-0.9 ) score+=70.0;else if(resulet >=-0.9  &&resulet<-0.1 ) score+=75.0;
					else if(resulet >=-0.1  &&resulet<1.8 ) score+=80.0;else if(resulet >=1.8  &&resulet<1.9 ) score+=85.0;else if(resulet >= 1.9 &&resulet<3.5 ) score+=90.0;else if(resulet >= 3.5  ) score+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet >=-13 &&resulet<-11.2 ) score+=5.0;else if(resulet >=-11.2 &&resulet<-9.9 )  score+=10.0;else if(resulet >=-9.9  &&resulet<-8.9 ) score+=15.0;
					else if(resulet >=-8.9  &&resulet<-8 ) score+=20.0;else if(resulet >=-8  &&resulet<-7.2 ) score+=25.0;else if(resulet >= -7.2 &&resulet<-6.5 ) score+=30.0;else if(resulet >= -6.5 &&resulet<-5.8 ) score+=35.0;
					else if(resulet >= -5.8 &&resulet<-5.2 ) score+=40.0;else if(resulet >=-5.2  &&resulet<-4.5 ) score+=45.0;else if(resulet >=-4.5  &&resulet<-3.8 ) score+=50.0;else if(resulet >= -3.8 &&resulet<-3.2 ) score+=55.0;
					else if(resulet >= -3.2 &&resulet<-2.5 ) score+=60.0;else if(resulet >=-2.5  &&resulet<-1.8 ) score+=65.0;else if(resulet >=-1.8  &&resulet<-1 ) score+=70.0;else if(resulet >=-1  &&resulet<-0.1 ) score+=75.0;
					else if(resulet >=-0.1  &&resulet<0.9 ) score+=80.0;else if(resulet >=0.9  &&resulet<2.2 ) score+=85.0;else if(resulet >=2.2  &&resulet<3.9 ) score+=90.0;else if(resulet >=3.9   ) score+=95.0;
				}
			}
			if (v1.getSex() == 0&&calibrations==7) {// 女性
				if (v1.getAge() < 65) {
					
					 if(resulet<=7.2  &&resulet>6.7 ) score+=5.0;else if(resulet<=6.7  &&resulet>6.4 ) score+=10.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=15.0;
					else if(resulet<=6.2  &&resulet>6 ) score+=20.0;else if(resulet<=6  &&resulet>5.8 ) score+=25.0;else if(resulet<=5.8  &&resulet>5.7 ) score+=30.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=35.0;
					else if(resulet<=5.5  &&resulet>5.4 ) score+=40.0;else if(resulet<=5.4  &&resulet>5.2 ) score+=45.0;else if(resulet<=5.2  &&resulet>5 ) score+=50.0;else if(resulet<=5  &&resulet>4.9 ) score+=55.0;
					else if(resulet<=4.9  &&resulet>4.7 ) score+=60.0;else if(resulet<=4.7  &&resulet>4.6 ) score+=65.0;else if(resulet<=4.6  &&resulet>4.4 ) score+=70.0;else if(resulet<=4.4  &&resulet>4.2 ) score+=75.0;
					else if(resulet<=4.2  &&resulet>4 ) score+=80.0;else if(resulet<=4  &&resulet>3.7 ) score+=85.0;else if(resulet<=3.7  &&resulet>3.2 ) score+=90.0;else if(resulet<=3.2   ) score+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=7.6  &&resulet>7.1 ) score+=5.0;else if(resulet<=7.1  &&resulet>6.8 ) score+=10.0;else if(resulet<=6.8  &&resulet>6.6 ) score+=15.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=20.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=25.0;else if(resulet<=6.2  &&resulet>6.1 ) score+=30.0;else if(resulet<=6.1 &&resulet>5.9 ) score+=35.0;
					else if(resulet<=5.9  &&resulet>5.8 ) score+=40.0;else if(resulet<=5.8  &&resulet>5.6 ) score+=45.0;else if(resulet<=5.6  &&resulet>5.4 ) score+=50.0;else if(resulet<=5.4  &&resulet>5.3 ) score+=55.0;
					else if(resulet<=5.3  &&resulet>5.1 ) score+=60.0;else if(resulet<=5.1  &&resulet>5 ) score+=65.0;else if(resulet<=5  &&resulet>4.8 ) score+=70.0;else if(resulet<=4.8  &&resulet>4.6 ) score+=75.0;
					else if(resulet<=4.6  &&resulet>4.4 ) score+=80.0;else if(resulet<=4.4  &&resulet>4.1 ) score+=85.0;else if(resulet<=4.1  &&resulet>3.6 ) score+=90.0;else if(resulet<=3.6) score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=8.6  &&resulet>8 ) score+=5.0;else if(resulet<=8  &&resulet>7.7 ) score+=10.0;else if(resulet<=7.7  &&resulet>7.3 ) score+=15.0;
					else if(resulet<=7.3  &&resulet>7.1 ) score+=20.0;else if(resulet<=7.1  &&resulet>6.8 ) score+=25.0;else if(resulet<=6.8  &&resulet>6.6 ) score+=30.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=35.0;
					else if(resulet<=6.4  &&resulet>6.2 ) score+=40.0;else if(resulet<=6.2  &&resulet>6 ) score+=45.0;else if(resulet<=6  &&resulet>5.8 ) score+=50.0;else if(resulet<=5.8  &&resulet>5.6 ) score+=55.0;
					else if(resulet<=5.6  &&resulet>5.4 ) score+=60.0;else if(resulet<=5.4  &&resulet>5.2 ) score+=65.0;else if(resulet<=5.2  &&resulet>4.9 ) score+=70.0;else if(resulet<=4.9  &&resulet>4.7 ) score+=75.0;
					else if(resulet<=4.7  &&resulet>4.3 ) score+=80.0;else if(resulet<=4.3  &&resulet>4 ) score+=85.0;else if(resulet<=4  &&resulet>3.8 ) score+=90.0;else if(resulet<= 3.8  ) score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet >=-8.8 &&resulet<-7.3 ) score+=5.0;else if(resulet >=-7.3 &&resulet<-6.4 )  score+=10.0;else if(resulet >=-6.4  &&resulet<-5.5 ) score+=15.0;
					else if(resulet >=-5.5  &&resulet<-4.8 ) score+=20.0;else if(resulet >=-4.8  &&resulet<-4.2 ) score+=25.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=30.0;else if(resulet >=-3.7  &&resulet<-3.1 ) score+=35.0;
					else if(resulet >=-3.1  &&resulet<-2.6 ) score+=40.0;else if(resulet >=-2.6  &&resulet<-2.1 ) score+=45.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=50.0;else if(resulet >=-1.6  &&resulet<-1.1 ) score+=55.0;
					else if(resulet >=-1.1 &&resulet<-0.5 ) score+=60.0;else if(resulet >=-0.5  &&resulet<0 ) score+=65.0;else if(resulet >=0  &&resulet<0.6 ) score+=70.0;else if(resulet >=0.6  &&resulet<1.3 ) score+=75.0;
					else if(resulet >=1.3  &&resulet<2.2 ) score+=80.0;else if(resulet >=2.2  &&resulet<3.1 ) score+=85.0;else if(resulet >=3.1  &&resulet<4.5 ) score+=90.0;else if(resulet >= 4.5  ) score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=10.8  &&resulet> 10) score+=5.0;else if(resulet<=10  &&resulet>9.5 ) score+=10.0;else if(resulet<=9.5  &&resulet>9 ) score+=15.0;
					else if(resulet<=9  &&resulet>8.7 ) score+=20.0;else if(resulet<=8.7  &&resulet>8.3 ) score+=25.0;else if(resulet<=8.3  &&resulet>8.1 ) score+=30.0;else if(resulet<=8.1  &&resulet>7.8 ) score+=35.0;
					else if(resulet<=7.8  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.7 ) score+=55.0;
					else if(resulet<=6.7  &&resulet>6.3 ) score+=60.0;else if(resulet<=6.3  &&resulet>6.1 ) score+=65.0;else if(resulet<=6.1  &&resulet>5.7 ) score+=70.0;else if(resulet<=5.7 &&resulet>5.4 ) score+=75.0;
					else if(resulet<=5.4  &&resulet>4.9 ) score+=80.0;else if(resulet<=4.9  &&resulet>4.4 ) score+=85.0;else if(resulet<=4.4  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=12  &&resulet>11.1 ) score+=5.0;else if(resulet<=11.1  &&resulet>10.5 ) score+=10.0;else if(resulet<=10.5  &&resulet>10 ) score+=15.0;
					else if(resulet<=10  &&resulet>9.6 ) score+=20.0;else if(resulet<=9.6  &&resulet>9.2 ) score+=25.0;else if(resulet<=9.2  &&resulet>8.9 ) score+=30.0;else if(resulet<=8.9  &&resulet>8.5 ) score+=35.0;
					else if(resulet<=8.5  &&resulet>8.2 ) score+=40.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=45.0;else if(resulet<=7.9  &&resulet>7.6 ) score+=50.0;else if(resulet<=7.6  &&resulet>7.3 ) score+=55.0;
					else if(resulet<=7.3  &&resulet>6.9 ) score+=60.0;else if(resulet<=6.9  &&resulet>6.6 ) score+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) score+=70.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=75.0;
					else if(resulet<=5.8  &&resulet>5.3 ) score+=80.0;else if(resulet<=5.3  &&resulet>4.7 ) score+=85.0;else if(resulet<=4.7  &&resulet>4.5 ) score+=90.0;else if(resulet<=4.5   ) score+=95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if(resulet<=14.6  &&resulet>13.5 ) score+=5.0;else if(resulet<=13.5  &&resulet>12.7 ) score+=10.0;else if(resulet<=12.7  &&resulet>12.1 ) score+=15.0;
					else if(resulet<=12.1  &&resulet>11.5 ) score+=20.0;else if(resulet<=11.5  &&resulet>11.1 ) score+=25.0;else if(resulet<=11.1  &&resulet>10.6 ) score+=30.0;else if(resulet<=10.6  &&resulet>10.2) score+=35.0;
					else if(resulet<=10.2  &&resulet>9.8 ) score+=40.0;else if(resulet<=9.8  &&resulet>9.4 ) score+=45.0;else if(resulet<=9.4  &&resulet>9 ) score+=50.0;else if(resulet<=9  &&resulet>8.6 ) score+=55.0;
					else if(resulet<=8.6  &&resulet>8.2 ) score+=60.0;else if(resulet<=8.2  &&resulet>7.7 ) score+=65.0;else if(resulet<=7.7  &&resulet>7.3 ) score+=70.0;else if(resulet<=7.3  &&resulet>6.7 ) score+=75.0;
					else if(resulet<= 6.7 &&resulet>6.1 ) score+=80.0;else if(resulet<=6.1  &&resulet>5.3 ) score+=85.0;else if(resulet<=5.3 &&resulet>5 ) score+=90.0;else if(resulet<= 5  ) score+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==5) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet<=67)score+=5.0;else if(resulet<=74 &&resulet>67 )score+=10.0;else if(resulet<=79 &&resulet>74 )score+=15.0;
					else if(resulet<=83 &&resulet>79 )score+=20.0;else if(resulet<=87 &&resulet>83 )score+=25.0;else if(resulet<=90 &&resulet>87 )score+=30.0;else if(resulet<=93 &&resulet>90 )score+=35.0;
					else if(resulet<=96 &&resulet>93)score+=40.0;else if(resulet<=98 &&resulet>96 )score+=45.0;else if(resulet<=101 &&resulet>98 )score+=50.0;else if(resulet<=104 &&resulet>101 )score+=55.0;
					else if(resulet<=106 &&resulet>104 )score+=60.0;else if(resulet<=109 &&resulet>106 )score+=65.0;else if(resulet<=112 &&resulet>109 )score+=70.0;else if(resulet<=115 &&resulet>112 )score+=75.0;
					else if(resulet<=119 &&resulet>115 )score+=80.0;else if(resulet<=123 &&resulet>119 )score+=85.0;else if(resulet<=128 &&resulet>123 )score+=90.0;else if(resulet>128  )score+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet<=67)score+=5.0;else if(resulet<=72 &&resulet>67 )score+=10.0;else if(resulet<=77 &&resulet>72 )score+=15.0;
					else if(resulet<=82 &&resulet>77 )score+=20.0;else if(resulet<=86 &&resulet>82 )score+=25.0;	else if(resulet<=89 &&resulet>86 )score+=30.0;else if(resulet<=92 &&resulet>89 )score+=35.0;
					else if(resulet<=95 &&resulet>92 )score+=40.0;else if(resulet<=98 &&resulet>95 )score+=45.0;else if(resulet<=101 &&resulet>98 )score+=50.0;else if(resulet<=104 &&resulet>101 )score+=55.0;
					else if(resulet<=107 &&resulet>104 )score+=60.0;else if(resulet<=110 &&resulet>107 )score+=65.0;else if(resulet<=113 &&resulet>110 )score+=70.0;else if(resulet<=116 &&resulet>113 )score+=75.0;
					else if(resulet<=120 &&resulet>116 )score+=80.0;else if(resulet<=125 &&resulet>120 )score+=85.0;else if(resulet<=130 &&resulet>125 )score+=90.0;else if(resulet>130  )score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet<=67)score+=5.0;else if(resulet<=66 &&resulet>67 )score+=10.0;
					else if(resulet<=71 &&resulet>66 )score+=15.0;else if(resulet<=76 &&resulet>71 )score+=20.0;else if(resulet<=80 &&resulet>76 )score+=25.0;else if(resulet<=83 &&resulet>80 )score+=30.0;else if(resulet<=86 &&resulet>83 )score+=35.0;
					else if(resulet<=89 &&resulet>86 )score+=40.0;else if(resulet<=92 &&resulet>89 )score+=45.0;else if(resulet<=95 &&resulet>92 )score+=50.0;else if(resulet<=98 &&resulet>95 )score+=55.0;
					else if(resulet<=101 &&resulet>98 )score+=60.0;else if(resulet<=104 &&resulet>101 )score+=65.0;else if(resulet<=107 &&resulet>104 )score+=70.0;else if(resulet<=110 &&resulet>107 )score+=75.0;
					else if(resulet<=114 &&resulet>110 )score+=80.0;else if(resulet<=119 &&resulet>114 )score+=85.0;else if(resulet<=124 &&resulet>119 )score+=90.0;else if(resulet>124  )score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet<=47)score+=5.0;else if(resulet<=56 &&resulet>47 )score+=10.0;else if(resulet<=63 &&resulet>56 )score+=15.0;
					else if(resulet<=68 &&resulet>63 )score+=20.0;else if(resulet<=73 &&resulet>68 )score+=25.0;else if(resulet<=77 &&resulet>73 )score+=30.0;else if(resulet<=80 &&resulet>77 )score+=35.0;
					else if(resulet<=84 &&resulet>80 )score+=40.0;else if(resulet<=87 &&resulet>84 )score+=45.0;else if(resulet<=91 &&resulet>87 )score+=50.0;else if(resulet<=95 &&resulet>91 )score+=55.0;
					else if(resulet<=98 &&resulet>95 )score+=60.0;else if(resulet<=102 &&resulet>98 )score+=65.0;else if(resulet<=105 &&resulet>102 )score+=70.0;else if(resulet<=109 &&resulet>105 )score+=75.0;
					else if(resulet<=114 &&resulet>109 )score+=80.0;else if(resulet<=119 &&resulet>114 )score+=85.0;else if(resulet<=126 &&resulet>119 )score+=90.0;else if(resulet>126  )score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=48)score+=5.0;else if(resulet<=56 &&resulet>48 )score+=10.0;else if(resulet<=62 &&resulet>56 )score+=15.0;else if(resulet<=67 &&resulet>62 )score+=20.0;else if(resulet<=71 &&resulet>67 )score+=25.0;else if(resulet<=75 &&resulet>71 )score+=30.0;
					else if(resulet<=78 &&resulet>75 )score+=35.0;else if(resulet<=81 &&resulet>78 )score+=40.0;else if(resulet<=84 &&resulet>81 )score+=45.0;else if(resulet<=87 &&resulet>84 )score+=50.0;else if(resulet<=90 &&resulet>87 )score+=55.0;
					else if(resulet<=93 &&resulet>90 )score+=60.0;else if(resulet<=96 &&resulet>93 )score+=65.0;else if(resulet<=99 &&resulet>96 )score+=70.0;else if(resulet<=103 &&resulet>99 )score+=75.0;
					else if(resulet<=107 &&resulet>103 )score+=80.0;else if(resulet<=112 &&resulet>107 )score+=85.0;else if(resulet<=118 &&resulet>112 )score+=90.0;else if(resulet>118  )score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=36)score+=5.0;else if(resulet<=44 &&resulet>36 )score+=10.0;else if(resulet<=50 &&resulet>44 )score+=15.0;else if(resulet<=55 &&resulet>50 )score+=20.0;
					else if(resulet<=59 &&resulet>55 )score+=25.0;else if(resulet<=63 &&resulet>59 )score+=30.0;else if(resulet<=66 &&resulet>63 )score+=35.0;else if(resulet<=69 &&resulet>66 )score+=40.0;else if(resulet<=72 &&resulet>69 )score+=45.0;
					else if(resulet<=75 &&resulet>72 )score+=50.0;else if(resulet<=78 &&resulet>75 )score+=55.0;else if(resulet<=81 &&resulet>78 )score+=60.0;else if(resulet<=84 &&resulet>81 )score+=65.0;else if(resulet<=87 &&resulet>84 )score+=70.0;
					else if(resulet<=91 &&resulet>87 )score+=75.0;else if(resulet<=95 &&resulet>91 )score+=80.0;else if(resulet<=100 &&resulet>95 )score+=85.0;else if(resulet<=106 &&resulet>100 )score+=90.0;else if(resulet>106  )score+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet<=26)score+=5.0;else if(resulet<=36 &&resulet>26 )score+=10.0;else if(resulet<=42 &&resulet>36 )score+=15.0;else if(resulet<=47 &&resulet>42 )score+=20.0;
					else if(resulet<=52 &&resulet>47 )score+=25.0;else if(resulet<=55 &&resulet>52 )score+=30.0;else if(resulet<=59 &&resulet>55 )score+=35.0;else if(resulet<=62 &&resulet>59 )score+=40.0;else if(resulet<=66 &&resulet>62 )score+=45.0;
					else if(resulet<=69 &&resulet>66 )score+=50.0;else if(resulet<=72 &&resulet>69 )score+=55.0;else if(resulet<=76 &&resulet>72 )score+=60.0;else if(resulet<=79 &&resulet>76 )score+=65.0;else if(resulet<=83 &&resulet>79 )score+=70.0;
					else if(resulet<=86 &&resulet>83 )score+=75.0;else if(resulet<=91 &&resulet>86 )score+=80.0;else if(resulet<=96 &&resulet>91 )score+=85.0;else if(resulet<=102 &&resulet>96 )score+=90.0;else if(resulet>102  )score+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==6) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet >=-11.3    && resulet<-9.5) score+=5.0;else if(resulet >=-9.5 && resulet<-8.4)  score+=10.0;else if(resulet >=-8.4 && resulet<-7.4) score+=15.0;
					else if(resulet >=-7.4 && resulet<-6.6) score+=20.0;else if(resulet >=-6.6 && resulet<-5.9) score+=25.0;else if(resulet >=-5.9 && resulet<-5.3) score+=30.0;else if(resulet >=-5.3 && resulet<-4.6) score+=35.0;
					else if(resulet >=-4.6 && resulet<-4  ) score+=40.0;else if(resulet >=-4   && resulet<-3.4) score+=45.0;else if(resulet >=-3.4 && resulet<-2.8) score+=50.0;else if(resulet >=-2.8 && resulet<-2.2) score+=55.0;
					else if(resulet >=-2.2 && resulet<-1.5) score+=60.0;else if(resulet >=-1.5 && resulet<-0.9) score+=65.0;else if(resulet >=-0.9 && resulet<-0.2) score+=70.0;else if(resulet >=-0.2 && resulet< 0.6) score+=75.0;
					else if(resulet >=0.6  && resulet< 1.6) score+=80.0;else if(resulet >=1.6  && resulet< 2.7) score+=85.0;else if(resulet >=2.7  && resulet< 4.5) score+=85.0;else if(resulet >4.5 ) score+=95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet>=-12.1&&resulet<-10.4 ) score+=5.0;else if(resulet>=-10.4 &&resulet<-9.2 )  score+=10.0;else if(resulet>=-9.2  &&resulet<-8.2 ) score+=15.0;
					else if(resulet>=-8.2  &&resulet<-7.4 ) score+=20.0;else if(resulet>=-7.4 &&resulet<-6.6 ) score+=25.0;else if(resulet>=-6.6  &&resulet<-6 ) score+=30.0;else if(resulet>= -6 &&resulet<-5.3 ) score+=35.0;
					else if(resulet>=-5.3  &&resulet<-4.7 ) score+=40.0;else if(resulet>=-4.7  &&resulet<-4.1 ) score+=45.0;else if(resulet>=-4.1  &&resulet<-3.5 ) score+=50.0;else if(resulet>=-3.5  &&resulet<-2.9 ) score+=55.0;
					else if(resulet>=-2.9  &&resulet<-2.2 ) score+=60.0;else if(resulet>=-2.2  &&resulet<-1.6 ) score+=65.0;else if(resulet>=-1.6  &&resulet<-0.8 ) score+=70.0;else if(resulet>=-0.8  &&resulet<0 ) score+=75.0;
					else if(resulet>=0  &&resulet<1)score+=80.0;else if(resulet>=1  &&resulet<2.2)score+=85.0;else if(resulet>=2.2  &&resulet<3.9)score+=90.0;else if(resulet>= 3.9  ) score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					if(resulet >=-12.5 &&resulet<-10.8 ) score+=5.0;else if(resulet >=-10.8 &&resulet<-9.6 )  score+=10.0;
					else if(resulet >=-9.6  &&resulet<-8.6 ) score+=15.0;else if(resulet >=-8.6 &&resulet<-7.8 ) score+=20.0;else if(resulet >=-7.8  &&resulet<-7 ) score+=25.0;else if(resulet >=-7 &&resulet<-6.4 ) score+=30.0;
					else if(resulet >-6.4 &&resulet<-5.7 ) score+=35.0;else if(resulet >=-5.7  &&resulet<-5.1 ) score+=40.0;else if(resulet >=-5.1  &&resulet<-4.5 ) score+=45.0;else if(resulet >=-4.5  &&resulet<-3.9 ) score+=50.0;
					else if(resulet >=-3.9  &&resulet<-3.3 ) score+=55.0;else if(resulet >=-3.3  &&resulet<-2.6 ) score+=60.0;else if(resulet >=-2.6 &&resulet< -2) score+=65.0;
					else if(resulet >= -2 &&resulet<-1.2 ) score+=70.0;else if(resulet >=-1.2  &&resulet<-0.4 ) score+=75.0;
					else if(resulet >=-0.4  &&resulet<0.6 ) score+=80.0;else if(resulet >= 0.6 &&resulet<1.8 ) score+=85.0;else if(resulet >=1.8  &&resulet<3.5 ) score+=90.0;else if(resulet >= 3.5  ) score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet >=-14 &&resulet<-12.1 ) score+=5.0;else if(resulet >=-12.1 &&resulet<-10.9 )  score+=10.0;else if(resulet >= -10.9 &&resulet<-9.9 ) score+=15.0;
					else if(resulet >=-9.9  &&resulet<-9 ) score+=20.0;else if(resulet >=-9  &&resulet< -8.3) score+=25.0;else if(resulet >=-8.3  &&resulet<-7.6 ) score+=30.0;else if(resulet >= -7.6 &&resulet<-6.9 ) score+=35.0;
					else if(resulet >=-6.9  &&resulet<-6.3 ) score+=40.0;else if(resulet >=-6.3  &&resulet<-5.6 ) score+=45.0;else if(resulet >=-5.6  &&resulet<-4.9 ) score+=50.0;else if(resulet >=-4.9  &&resulet<-4.3 ) score+=55.0;
					else if(resulet >=-4.3  &&resulet< -3.6) score+=60.0;else if(resulet >= -3.6 &&resulet< -2.9) score+=65.0;else if(resulet >=-2.9  &&resulet< -2.2) score+=70.0;else if(resulet >= -2.2 &&resulet< -1.3) score+=75.0;
					else if(resulet >= -1.3 &&resulet<-0.3 ) score+=80.0;else if(resulet >= -0.3 &&resulet< 0.9) score+=85.0;else if(resulet >= 0.9 &&resulet<2.8 ) score+=90.0;else if(resulet >= 2.8  ) score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet >=-14.6 &&resulet<-12.6 ) score+=5.0;else if(resulet >=-12.6 &&resulet<-11.3 )  score+=10.0;else if(resulet >=-11.3  &&resulet<-10.2 ) score+=15.0;
					else if(resulet >= -10.2 &&resulet<-9.3 ) score+=20.0;else if(resulet >=-9.3  &&resulet<-8.5 ) score+=25.0;else if(resulet >=-8.5  &&resulet<-7.8 ) score+=30.0;else if(resulet >=-7.8  &&resulet<-7.1 ) score+=35.0;
					else if(resulet >=-7.1  &&resulet<-6.4 ) score+=40.0;else if(resulet >=-6.4  &&resulet<-5.7 ) score+=45.0;else if(resulet >=-5.7  &&resulet<-5 ) score+=50.0;else if(resulet >= -5 &&resulet<-4.3 ) score+=55.0;
					else if(resulet >= -4.3 &&resulet< -3.6) score+=60.0;else if(resulet >= -3.6 &&resulet<-2.9 ) score+=65.0;else if(resulet >= -2.9 &&resulet<-2.1 ) score+=70.0;else if(resulet >= -2.1 &&resulet<-1.2 ) score+=75.0;
					else if(resulet >= -1.2 &&resulet<-0.1 ) score+=80.0;else if(resulet >= -0.1  &&resulet< 1.2) score+=85.0;else if(resulet >= 1.2 &&resulet<3.2 ) score+=90.0;else if(resulet >= 3.2  ) score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=11.5  &&resulet>10.5 ) score+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) score+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) score+=15.0;
					else if(resulet<=9.4  &&resulet>8.9 ) score+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) score+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) score+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=35.0;
					else if(resulet<=7.9  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) score+=55.0;
					else if(resulet<=6.5  &&resulet>6.2 ) score+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) score+=70.0;else if(resulet<=5.5  &&resulet>5 ) score+=75.0;
					else if(resulet<=5  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet >=-15.1 &&resulet<-13.3 ) score+=5.0;else if(resulet >=-13.3 &&resulet<-12.2 )  score+=10.0;else if(resulet >= -12.2 &&resulet<-11.2 ) score+=15.0;
					else if(resulet >= -11.2 &&resulet<-10.4 ) score+=20.0;	else if(resulet >= -10.4 &&resulet<-9.7 ) score+=25.0;else if(resulet >= -9.7 &&resulet<-9.1 ) score+=30.0;else if(resulet >= -9.1 &&resulet<-8.4 ) score+=35.0;
					else if(resulet >= -8.4 &&resulet<-7.8 ) score+=40.0;else if(resulet >= -7.8 &&resulet<-7.2 ) score+=45.0;else if(resulet >= -7.2 &&resulet<-6.6 ) score+=50.0;else if(resulet >= -6.6 &&resulet<-6 ) score+=55.0;
					else if(resulet >= -6 &&resulet<-5.3 ) score+=60.0;else if(resulet >= -5.3 &&resulet<-4.7 ) score+=65.0;else if(resulet >= -4.7 &&resulet<-4 ) score+=70.0;else if(resulet >= -4 &&resulet<-3.2 ) score+=75.0;
					else if(resulet >= -3.2 &&resulet<-2.2 ) score+=80.0;else if(resulet >= -2.2 &&resulet<-1.1 ) score+=85.0;else if(resulet >=-1.1  &&resulet<0.7 ) score+=90.0;else if(resulet >=0.7   ) score+=95.0;
				}
			}
			if (v1.getSex() == 1&&calibrations==7) {// 男性
				if (v1.getAge() < 65) {	
					if(resulet <=6.8 &&resulet>6.4 ) score+=5.0;else if(resulet <=6.4 &&resulet>6.1  )  score+=10.0;
					else if(resulet <=6.1  &&resulet>5.8  ) score+=15.0;else if(resulet <=5.8  &&resulet>5.6 ) score+=20.0;else if(resulet >=5.6  &&resulet>5.4 ) score+=25.0;else if(resulet <=5.4  &&resulet>5.2 ) score+=30.0;
					else if(resulet <=5.2&&resulet>5.0 ) score+=35.0;else if(resulet <=5.0 &&resulet>4.9 ) score+=40.0;else if(resulet <=4.9  &&resulet>4.7 ) score+=45.0;else if(resulet <=4.7  &&resulet>4.5 ) score+=50.0;
					else if(resulet <=4.5 &&resulet>4.4) score+=55.0;else if(resulet <=4.4  &&resulet>4.2 ) score+=60.0;else if(resulet <=4.2  &&resulet>4.0) score+=65.0;else if(resulet <=4.0  &&resulet>3.8 ) score+=70.0;
					else if(resulet <=3.8  &&resulet>3.6 ) score+=75.0;else if(resulet <=3.6  &&resulet>3.3) score+=80.0;else if(resulet <=3.3  &&resulet>3) score+=85.0;else if(resulet <=3 ) score+=90.0;
				
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if(resulet <=7.1 &&resulet>6.6 ) score+=5.0;else if(resulet <=6.6  &&resulet> 6.3 )  score+=10.0;else if(resulet <=6.3  &&resulet>6.1  ) score+=15.0;
					else if(resulet <=6.1  &&resulet>5.9 ) score+=20.0;else if(resulet <=5.9  &&resulet>5.7 ) score+=25.0;else if(resulet <=5.7  &&resulet>5.6 ) score+=30.0;else if(resulet <=5.6  &&resulet>5.4 ) score+=35.0;
					else if(resulet <=5.4  &&resulet>5.3 ) score+=40.0;else if(resulet <=5.3 &&resulet>5.1 ) score+=45.0;else if(resulet <=5.1  &&resulet>4.9 ) score+=50.0;else if(resulet <= 4.9&&resulet>4.8) score+=55.0;
					else if(resulet <=4.8  &&resulet>4.6 ) score+=60.0;else if(resulet <=4.6  &&resulet>4.5) score+=65.0;else if(resulet <=4.5  &&resulet>4.3 ) score+=70.0;else if(resulet <=4.3  &&resulet>4.1 ) score+=75.0;
					else if(resulet <=4.1  &&resulet>3.9) score+=80.0;else if(resulet <=3.9  &&resulet>3.6) score+=85.0;else if(resulet <=3.6 &&resulet>3.1 ) score+=90.0;else if(resulet <=3.1   ) score+=95.0;
				} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
					 if(resulet <=7.4 &&resulet>7 ) score+=5.0;else if(resulet <=7 &&resulet> 6.7 )  score+=10.0;else if(resulet <= 6.7 &&resulet> 6.4  ) score+=15.0;
					else if(resulet <= 6.4 &&resulet> 6.2 ) score+=20.0;else if(resulet <= 6.2 &&resulet>6 ) score+=25.0;else if(resulet <= 6 &&resulet>5.8 ) score+=30.0;else if(resulet <=5.8&&resulet>5.6 ) score+=35.0;
					else if(resulet <=5.6 &&resulet>5.5 ) score+=40.0;else if(resulet <=5.5  &&resulet>5.3 ) score+=45.0;else if(resulet <=5.3  &&resulet>5.1 ) score+=50.0;else if(resulet <=5.1 &&resulet>5 ) score+=55.0;
					else if(resulet <=5  &&resulet>4.8 ) score+=60.0;else if(resulet <=4.8  &&resulet>4.6) score+=65.0;else if(resulet <=4.6  &&resulet>4.4 ) score+=70.0;else if(resulet <=4.4  &&resulet>4.2 ) score+=75.0;
					else if(resulet <=4.2  &&resulet>3.9 ) score+=80.0;else if(resulet <=3.9  &&resulet>3.6) score+=85.0;else if(resulet <=3.6 &&resulet>3.2 ) score+=90.0;else if(resulet <=3.2   ) score+=95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if(resulet <=9 &&resulet<8.3 ) score+=5.0;else if(resulet <=8.3 &&resulet>7.9)  score+=10.0;else if(resulet <=7.9 &&resulet>7.5) score+=15.0;
					else if(resulet <=7.5 &&resulet>7.2) score+=20.0;else if(resulet <=7.2 &&resulet>6.9) score+=25.0;else if(resulet <=6.9 &&resulet>6.6) score+=30.0;else if(resulet <=6.6 &&resulet>6.4) score+=35.0;
					else if(resulet <=6.4 &&resulet>6.1) score+=40.0;else if(resulet <=6.1 &&resulet>5.9) score+=45.0;else if(resulet <=5.9 &&resulet>5.7) score+=50.0;else if(resulet <=5.7 &&resulet>5.4) score+=55.0;
					else if(resulet <=5.4 &&resulet>5.2) score+=60.0;else if(resulet <=5.2 &&resulet>4.9) score+=65.0;else if(resulet <=4.9  &&resulet>4.6) score+=70.0;else if(resulet <=4.6 &&resulet>4.3) score+=75.0;
					else if(resulet <=4.3  &&resulet>3.9) score+=80.0;else if(resulet <=3.9  &&resulet>3.5) score+=85.0;else if(resulet <=3.5 &&resulet>3.3) score+=90.0;else if(resulet <=3.3   ) score+=95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if(resulet<=9.4  &&resulet>8.7 ) score+=5.0;else if(resulet<=8.7  &&resulet>8.3 ) score+=10.0;else if(resulet<=8.3  &&resulet>7.9 ) score+=15.0;
					else if(resulet<=7.9  &&resulet>7.6 ) score+=20.0;else if(resulet<=7.6  &&resulet>7.3 ) score+=25.0;else if(resulet<=7.3  &&resulet>7.1 ) score+=30.0;else if(resulet<=7.1  &&resulet>6.9 ) score+=35.0;
					else if(resulet<=6.9  &&resulet>6.6 ) score+=40.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=45.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=50.0;else if(resulet<=6.2  &&resulet>6 ) score+=55.0;
					else if(resulet<=6    &&resulet>5.7 ) score+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) score+=70.0;else if(resulet<=5.2  &&resulet>4.9 ) score+=75.0;
					else if(resulet<=4.9  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.1 ) score+=85.0;else if(resulet<=4.1  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if(resulet<=11.5  &&resulet>10.5 ) score+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) score+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) score+=15.0;
					else if(resulet<=9.4  &&resulet>8.9 ) score+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) score+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) score+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=35.0;
					else if(resulet<=7.9  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) score+=55.0;
					else if(resulet<=6.5  &&resulet>6.2 ) score+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) score+=70.0;else if(resulet<=5.5  &&resulet>5 ) score+=75.0;
					else if(resulet<=5  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if(resulet<=12.9  &&resulet>11.8 ) score+=5.0;else if(resulet<=11.8  &&resulet>11.1 ) score+=10.0;else if(resulet<=11.1  &&resulet>10.5 ) score+=15.0;
					else if(resulet<=10.5  &&resulet>10 ) score+=20.0;else if(resulet<=10  &&resulet>9.6 ) score+=25.0;else if(resulet<=9.6  &&resulet>9.2 ) score+=30.0;else if(resulet<=9.2  &&resulet>8.8 ) score+=35.0;
					else if(resulet<=8.8  &&resulet>8.5 ) score+=40.0;else if(resulet<=8.5  &&resulet>8.1 ) score+=45.0;else if(resulet<=8.1  &&resulet>7.7 ) score+=50.0;else if(resulet<=7.7  &&resulet>7.4 ) score+=55.0;
					else if(resulet<=7.4  &&resulet>7 ) score+=60.0;else if(resulet<=7  &&resulet>6.6 ) score+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) score+=70.0;else if(resulet<=6.2  &&resulet>5.7 ) score+=75.0;
					else if(resulet<=5.7  &&resulet>5.1 ) score+=80.0;else if(resulet<=5.1  &&resulet>4.5 ) score+=85.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=90.0;else if(resulet<=4.3   ) score+=95.0;
				
				}
			}
		}
		
		
		return score;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static Double getT_mmse(List<RecordMOVO> sRe,List<RecordMOVO> eRe,double d_,int calibrations){
		double scroe=0.0;
		for(int i=0;i<sRe.size();i++){
			RecordMOVO s_=sRe.get(i);
			MyBeanWithPerson mb1=getMyBeanWithPerson(s_.getDetailMMSE());
			MyBeanWithPerson mb2=getMyBeanWithPerson(s_.getDetailMOCA());
			List<QuestionVO> mmse=mb1.getResult();
			List<QuestionVO> moca=mb2.getResult();
			List<QuestionVO> mmse_=mb1.getResult();
			List<QuestionVO> moca_=mb2.getResult();
			double s1=0;
			double s2=0;
			double e1=0;
			double e2=0;
			for(QuestionVO q:mmse){
				int s=Integer.parseInt(q.getScore());
				if(calibrations==9&&q.getQuestion_id().equals("114")|q.getQuestion_id().equals("115")|q.getQuestion_id().equals("285")){
					s1+=s;
				}else if(calibrations==10|calibrations==16&&q.getQuestion_id().equals("117")){
					s1+=s;
				}else if(calibrations==11|calibrations==12&&q.getQuestion_id().equals("116")){
					s1+=s;
				}else if(calibrations==18&&q.getQuestion_id().equals("118")|q.getQuestion_id().equals("120")|q.getQuestion_id().equals("122")|q.getQuestion_id().equals("124")|q.getQuestion_id().equals("126")|q.getQuestion_id().equals("127")){
					s1+=s;
				}else if(calibrations==15&&q.getQuestion_id().equals("130")){
					s1+=s;
				}
				
			}
			for(QuestionVO q:moca){
				int s=Integer.parseInt(q.getScore());
				if(calibrations==9&&q.getQuestion_id().equals("391")){
					//定向力
					s2+=s;
				}
				else if(calibrations==13&&q.getQuestion_id().equals("389")){
					//抽象
					scroe+=s;
				}
				else if(calibrations==10&&q.getQuestion_id().equals("384")|q.getQuestion_id().equals("385")|q.getQuestion_id().equals("386")){
					//注意力
					s2+=s;
				}
				else if(calibrations==11&&q.getQuestion_id().equals("383")){
					//记忆力
					s2+=s;
				}
				else if(calibrations==12&&q.getQuestion_id().equals("390")){
					//回忆力
					s2+=s;
				}
				else if(calibrations==14&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
					//视结构技
					s2+=s;
				}
				else if(calibrations==15&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
					//执行能力
					s2+=s;
				}
				else if(calibrations==16&&q.getQuestion_id().equals("386")){
					//计算力
					s2+=s;
				}
				else if(calibrations==18&&q.getQuestion_id().equals("382")|q.getQuestion_id().equals("387")|q.getQuestion_id().equals("388")){
					s2+=s;
					
				}
				
			}
			for(QuestionVO q:mmse_){
				int s=Integer.parseInt(q.getScore());
				if(calibrations==9&&q.getQuestion_id().equals("114")|q.getQuestion_id().equals("115")|q.getQuestion_id().equals("285")){
					s1+=s;
				}else if(calibrations==10|calibrations==16&&q.getQuestion_id().equals("117")){
					s1+=s;
				}else if(calibrations==11|calibrations==12&&q.getQuestion_id().equals("116")){
					s1+=s;
				}else if(calibrations==18&&q.getQuestion_id().equals("118")|q.getQuestion_id().equals("120")|q.getQuestion_id().equals("122")|q.getQuestion_id().equals("124")|q.getQuestion_id().equals("126")|q.getQuestion_id().equals("127")){
					s1+=s;
				}else if(calibrations==15&&q.getQuestion_id().equals("130")){
					s1+=s;
				}
				
			}
			for(QuestionVO q:moca_){
				int s=Integer.parseInt(q.getScore());
				if(calibrations==9&&q.getQuestion_id().equals("391")){
					//定向力
					s2+=s;
				}
				else if(calibrations==13&&q.getQuestion_id().equals("389")){
					//抽象
					scroe+=s;
				}
				else if(calibrations==10&&q.getQuestion_id().equals("384")|q.getQuestion_id().equals("385")|q.getQuestion_id().equals("386")){
					//注意力
					s2+=s;
				}
				else if(calibrations==11&&q.getQuestion_id().equals("383")){
					//记忆力
					s2+=s;
				}
				else if(calibrations==12&&q.getQuestion_id().equals("390")){
					//回忆力
					s2+=s;
				}
				else if(calibrations==14&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
					//视结构技
					s2+=s;
				}
				else if(calibrations==15&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
					//执行能力
					s2+=s;
				}
				else if(calibrations==16&&q.getQuestion_id().equals("386")){
					//计算力
					s2+=s;
				}
				else if(calibrations==18&&q.getQuestion_id().equals("382")|q.getQuestion_id().equals("387")|q.getQuestion_id().equals("388")){
					s2+=s;
					
				}
				
			}
			
			double a= Math.pow(s1+s2-e1-e2-d_,2);
			scroe+=a;
		}
		
		return scroe;
	}
	
	public static Double getMPressure(double lp,double hp){
		double score=0.0;
		if(hp>=90&&hp<=140){
			score+=1;
		}else{
			score+=0.1;
		}
		if(lp>=60&&lp<=90){
			score+=1;
		}else{
			score+=0.1;
		}
		 
		return score;
	}
	
	
	/**************************************************************************************************/
	public static Double getTslq_one(List<FitnessVO2> recod,double cords,int evg,int calibrations){
		double score=0.0;
		for(FitnessVO2 f:recod){
			int age=f.getAge();
			double resulet=f.getResultS1();
			double resulet1=f.getResultS2();
			double s1=0.0;
			double s2=0.0;
			if(f.getSex()==0&&calibrations==3){//女
				//6 7
				if (resulet < 18) {
					s1 += 1.0;
				} else if (resulet >= 18 && resulet < 24.9) {
					s1 += 0.5;
				} else if (resulet > 24.9 && resulet < 29.9) {
					s1 += 0.5;
				} else if (resulet >= 29.9) {
					s1 +=0.1;
				}
				
			}
			if(f.getSex()==1&&calibrations==3){//男
				
				if (resulet < 18.5) {
					s1 += 1.0;
				} else if (resulet >= 18.5 && resulet < 23.9) {
					s1 += 1.0;
				} else if (resulet >= 23.9 && resulet < 27.9) {
					s1 += 0.5;
				} else if (resulet >= 27.9) {
					s1 +=0.1;
				}
			}
			
			if(f.getSex()==0&&calibrations==4){//女
				//1  5
				if (age < 65) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=20.0;}
					else if(resulet1==12){s2+=27.5;}else if(resulet1==13){s2+=35.0;}else if(resulet1==14){s2+=42.5;}else if(resulet1==15){s2+=52.5;}
					else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;}
					else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					if(resulet1<=17.8  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>17.8 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=26 &&resulet1>21.1 )s2+=70.0;else if( resulet1>26 )s2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=22.5;
					}else if(resulet1==12){s2+=27.5;}else if(resulet1==13){s2+=35.0;}else if(resulet1==14){s2+=42.5;}else if(resulet1==15){s2+=52.5;
					}else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;
					}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					
					if(resulet1<=16.6  )s2+=10.0;else if(resulet1<=19.8 &&resulet1>16.6 )s2+=30.0;
					else if(resulet1<=20.6 &&resulet1>19.8 )s2+=50.0;else if(resulet1<=26.4 &&resulet1>20.6 )s2+=70.0;else if( resulet1>26.4 )s2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1<=7){s2+=5.0;}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=15.0;}else if(resulet1==10){s2+=22.5;}else if(resulet1==11){s2+=32.5;
					}else if(resulet1==12){s2+=40.0;}else if(resulet1==13){s2+=25.5;}else if(resulet1==14){s2+=62.5;}else if(resulet1==15){s2+=72.5;
					}else if(resulet1==16){s2+=80.0;}else if(resulet1==17){s2+=85.0;}else if(resulet1==18){s2+=90.0;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=16.2  )s2+=10.0;else if(resulet1<=19.3 &&resulet1>16.2 )s2+=30.0;
					else if(resulet1<=20.1 &&resulet1>19.3 )s2+=50.0;else if(resulet1<=25.6 &&resulet1>20.1 )s2+=70.0;else if( resulet1>25.6 )s2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1<=6){s2+=5.0;}else if(resulet1==7){s2+=7.5;
					}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=17.5;}else if(resulet1==10){s2+=25.0;}else if(resulet1==11){s2+=32.5;
					}else if(resulet1==12){s2+=45.0;}else if(resulet1==13){s2+=57.5;}else if(resulet1==14){s2+=67.5;}else if(resulet1==15){s2+=75.0;
					}else if(resulet1==16){s2+=82.5;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.0;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=14.1  )s2+=10.0;else if(resulet1<=17.1 &&resulet1>14.1 )s2+=30.0;
					else if(resulet1<=17.6 &&resulet1>17.1 )s2+=50.0;else if(resulet1<=22.3 &&resulet1>17.6 )s2+=70.0;else if( resulet1>22.3 )s2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=7.5;}else if(resulet1==6){s2+=10.0;}else if(resulet1==7){s2+=15.0;
					}else if(resulet1==8){s2+=20.0;}else if(resulet1==9){s2+=27.5;}else if(resulet1==10){s2+=37.5;}else if(resulet1==11){s2+=47.5;
					}else if(resulet1==12){s2+=57.5;}else if(resulet1==13){s2+=70.0;}else if(resulet1==14){s2+=75.0;}else if(resulet1==15){s2+=80.0;
					}else if(resulet1==16){s2+=85.0;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=95.0;}
					
					if(resulet1<=12.4  )s2+=10.0;else if(resulet1<=15.2 &&resulet1>12.4 )s2+=30.0;else if(resulet1<=16.4 &&resulet1>15.2 )s2+=50.0;
					else if(resulet1<=23.1 &&resulet1>16.4 )s2+=70.0;else if( resulet1>23.1 )s2+=90.0; 
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=20.0;}else if(resulet1==8){s2+=27.5;}else if(resulet1==9){s2+=37.5;
					}else if(resulet1==10){s2+=47.5;}else if(resulet1==11){s2+=57.5;}else if(resulet1==12){s2+=67.5;}else if(resulet1==13){s2+=75.0;
					}else if(resulet1==14){s2+=82.5;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=92.5;}else if(resulet1==17){s2+=95.0;}
					
					if(resulet1<=10.2  )s2+=10.0;else if(resulet1<=17 &&resulet1>10.2 )s2+=30.0;else if(resulet1<=17.4 &&resulet1>17 )s2+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)s2+=70.0;else if( resulet1>23.1 )s2+=90.0;
					
				} else if (age >= 89 && age < 100) {
					if(resulet1==0){s2+=5.0;}else if(resulet1==1){s2+=10.0;}else if(resulet1==2){s2+=12.5;}else if(resulet1==3){s2+=15.0;
					}else if(resulet1==4){s2+=22.5;}else if(resulet1==5){s2+=30.0;}else if(resulet1==6){s2+=35.0;}else if(resulet1==7){s2+=42.5;
					}else if(resulet1==8){s2+=50.0;}else if(resulet1==9){s2+=62.5;}else if(resulet1==10){s2+=65.0;}else if(resulet1==11){s2+=72.5;}else if(resulet1==12){s2+=80.0;
					}else if(resulet1==13){s2+=85.0;}else if(resulet1==14){s2+=87.5;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=92.5;}
					
					if(resulet1<=10.2  )s2+=10.0;else if(resulet1<=17 &&resulet1>10.2 )s2+=30.0;else if(resulet1<=17.4 &&resulet1>17 )s2+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)s2+=70.0;else if( resulet1>23.1 )s2+=90.0;
				}
			}
			if(f.getSex()==1&&calibrations==4){//男
				if (age < 65) {
					if(resulet1<=9){s2+=5.0;}else if(resulet1==10){s2+=7.5;}else if(resulet1==11){s2+=10.0;}else if(resulet1==12){s2+=15.0;}else if(resulet1==13){s2+=20.0;}else if(resulet1==14){s2+=25.0;
					}else if(resulet1==15){s2+=37.5;}else if(resulet1==16){s2+=47.5;}else if(resulet1==17){s2+=57.5;}else if(resulet1==18){s2+=65.0;}else if(resulet1==19){s2+=72.5;
					}else if(resulet1==20){s2+=80.0;}else if(resulet1==21){s2+=85.0;}else if(resulet1==22){s2+=90.0;}else if(resulet1==23){s2+=95.0;}
					
					if(resulet1<=21.9 )s2+=10.0;else if(resulet1<=30.3 &&resulet1>21.9 )s2+=30.0;
					else if(resulet1<=31.2 &&resulet1>30.3 )s2+=50.0;else if(resulet1<=40 &&resulet1>31.2 )s2+=70.0;else if( resulet1>40 )s2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=12.5;}else if(resulet1==11){s2+=17.5;
					}else if(resulet1==12){s2+=25.0;}else if(resulet1==13){s2+=32.5;}else if(resulet1==14){s2+=40.0;}else if(resulet1==15){s2+=47.5;
					}else if(resulet1==16){s2+=57.5;}else if(resulet1==17){s2+=65.0;}else if(resulet1==18){s2+=72.5;}else if(resulet1==19){s2+=80.0;
					}else if(resulet1==20){s2+=85.0;}else if(resulet1==21){s2+=90.0;}else if(resulet1==22){s2+=92.5;}else if(resulet1==23){s2+=95.0;}
					
					if(resulet1<=27  )s2+=10.0;else if(resulet1<=30.9 &&resulet1>27 )s2+=30.0;
					else if(resulet1<=32.1 &&resulet1>30.9 )s2+=50.0;else if(resulet1<=39.6 &&resulet1>32.1 )s2+=70.0;else if( resulet1>39.6 )s2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=20.0;}else if(resulet1==12){s2+=27.5;
					}else if(resulet1==13){s2+=37.5;}else if(resulet1==14){s2+=47.5;}else if(resulet1==15){s2+=55.0;}else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;
					}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					
					if(resulet1<=23.9  )s2+=10.0;else if(resulet1<=28.7 &&resulet1>23.9 )s2+=30.0;
					else if(resulet1<=30 &&resulet1>28.7 )s2+=50.0;else if(resulet1<=38.4 &&resulet1>30 )s2+=70.0;else if( resulet1>38.4 )s2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1==7){s2+=5.0;}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=12.5;
					}else if(resulet1==10){s2+=17.5;}else if(resulet1==11){s2+=25.0;}else if(resulet1==12){s2+=32.5;}else if(resulet1==13){s2+=42.5;
					}else if(resulet1==14){s2+=50.0;}else if(resulet1==15){s2+=57.5;}else if(resulet1==16){s2+=67.5;}else if(resulet1==17){s2+=75.0;
					}else if(resulet1==18){s2+=82.5;}else if(resulet1==19){s2+=87.5;}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.5;}
					
					if(resulet1<=19.2  )s2+=10.0;else if(resulet1<=24.8 &&resulet1>19.2 )s2+=30.0;
					else if(resulet1<=25.8 &&resulet1>24.8 )s2+=50.0;else if(resulet1<=33.7 &&resulet1>25.8 )s2+=70.0;else if( resulet1>33.7 )s2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=6){s2+=5.0;}else if(resulet1==7){s2+=10.0;
					}else if(resulet1==8){s2+=15.0;}else if(resulet1==9){s2+=20.0;}else if(resulet1==10){s2+=27.5;}else if(resulet1==11){s2+=37.5; }else if(resulet1==12){s2+=47.5;}else if(resulet1==13){s2+=57.5;}else if(resulet1==14){s2+=67.5;}else if(resulet1==15){s2+=75.0;
					}else if(resulet1==16){s2+=82.5;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.5;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=19.4  )s2+=10.0;else if(resulet1<=23.2 &&resulet1>19.4 )s2+=30.0;
					else if(resulet1<=24.2 &&resulet1>23.2 )s2+=50.0;else if(resulet1<=30 &&resulet1>24.2 )s2+=70.0;else if( resulet1>30 )s2+=90.0;
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=20.0;
					}else if(resulet1==8){s2+=25.0;}else if(resulet1==9){s2+=32.5;}else if(resulet1==10){s2+=40.0;}else if(resulet1==11){s2+=47.5;
					}else if(resulet1==12){s2+=57.5;}else if(resulet1==13){s2+=67.5;}else if(resulet1==14){s2+=75.0;}else if(resulet1==15){s2+=80.0;
					}else if(resulet1==16){s2+=85.0;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.5;}else if(resulet1==17){s2+=95.0;}
					
					if(resulet1<=18.3  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=29 &&resulet1>21.1 )s2+=70.0;else if( resulet1>29 )s2+=90.0;
					
				} else if (age >= 90 && age <= 100) {
					if(resulet1<=3){s2+=5.0;}else if(resulet1==4){s2+=7.5;
					}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=22.5;}else if(resulet1==8){s2+=32.5;
					}else if(resulet1==9){s2+=42.5;}else if(resulet1==10){s2+=52.5;}else if(resulet1==11){s2+=62.5;}else if(resulet1==12){s2+=72.5;
					}else if(resulet1==13){s2+=80.0;}else if(resulet1==14){s2+=85.0;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=95.0;}
					
					if(resulet1<=18.3  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=29 &&resulet1>21.1 )s2+=70.0;else if( resulet1>29 )s2+=90.0;
					
				}
				
			}
			resulet= Math.pow(s1+s2-cords,2)/evg;
			score+=resulet;
		}
		return score;
	}
	
	public static Double getMPressure(List<MPressureVO> pres){
		double score=0.0;
		/*收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；
		舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；*/
		for(MPressureVO m:pres){
			double hp= m.getHighPressuree();
			double lp= m.getLowPressuree();
			if(hp>=90&&hp<=140){
				score+=1;
			}else{
				score+=0.1;
			}
			if(lp>=60&&lp<=90){
				score+=1;
			}else{
				score+=0.1;
			}
			
		}
		return score;
	}
	
	public static Double getMPressure(List<MPressureVO> pres,double d){
		double score=0.0;
		/*收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；
		舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；*/
		for(MPressureVO m:pres){
			double hp_= m.getHighPressures();
			double lp_= m.getLowPressures();
			double hp= m.getHighPressuree();
			double lp= m.getLowPressuree();
			double s1=0.0;
			double s2=0.0;
			double e1=0.0;
			double e2=0.0;
			if(hp_>=90&&hp_<=140){
				s1+=1;
			}else{
				s1+=0.1;
			}
			if(lp_>=60&&lp_<=90){
				s1+=1;
			}else{
				s1+=0.1;
			}
			if(hp>=90&&hp<=140){
				e1+=1;
			}else{
				e1+=0.1;
			}
			if(lp>=60&&lp<=90){
				e1+=1;
			}else{
				e1+=0.1;
			}
			score+=Math.pow(e1+e2-s1-s2-d,2);
		}
		return score;
	}
	/**************************************************************************************************/
	public static Double getTslq_s(List<FitnessVO2> recod,double cords,int calibrations){
		double score=0.0;
		for(FitnessVO2 f:recod){
			int age=f.getAge();
			double resulet=f.getResultS1();
			double resulet1=f.getResultS2();
			double resulete=f.getResultE1();
			double resulet1e=f.getResultE2();
			double s1=0.0;
			double s2=0.0;
			double e1=0.0;
			double e2=0.0;
			if(f.getSex()==0&&calibrations==3){//女
				//6 7
				if (resulet < 18) {
					s1 += 1.0;
				} else if (resulet >= 18 && resulet < 24.9) {
					s1 += 0.5;
				} else if (resulet > 24.9 && resulet < 29.9) {
					s1 += 0.5;
				} else if (resulet >= 29.9) {
					s1 +=0.1;
				}
				
			}
			if(f.getSex()==1&&calibrations==3){//男
				
				if (resulet < 18.5) {
					s1 += 1.0;
				} else if (resulet >= 18.5 && resulet < 23.9) {
					s1 += 1.0;
				} else if (resulet >= 23.9 && resulet < 27.9) {
					s1 += 0.5;
				} else if (resulet >= 27.9) {
					s1 +=0.1;
				}
			}
			
			if(f.getSex()==0&&calibrations==4){//女
				//1  5
				if (age < 65) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=20.0;}
					else if(resulet1==12){s2+=27.5;}else if(resulet1==13){s2+=35.0;}else if(resulet1==14){s2+=42.5;}else if(resulet1==15){s2+=52.5;}
					else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;}
					else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					if(resulet1<=17.8  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>17.8 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=26 &&resulet1>21.1 )s2+=70.0;else if( resulet1>26 )s2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=22.5;
					}else if(resulet1==12){s2+=27.5;}else if(resulet1==13){s2+=35.0;}else if(resulet1==14){s2+=42.5;}else if(resulet1==15){s2+=52.5;
					}else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;
					}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					
					if(resulet1<=16.6  )s2+=10.0;else if(resulet1<=19.8 &&resulet1>16.6 )s2+=30.0;
					else if(resulet1<=20.6 &&resulet1>19.8 )s2+=50.0;else if(resulet1<=26.4 &&resulet1>20.6 )s2+=70.0;else if( resulet1>26.4 )s2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1<=7){s2+=5.0;}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=15.0;}else if(resulet1==10){s2+=22.5;}else if(resulet1==11){s2+=32.5;
					}else if(resulet1==12){s2+=40.0;}else if(resulet1==13){s2+=25.5;}else if(resulet1==14){s2+=62.5;}else if(resulet1==15){s2+=72.5;
					}else if(resulet1==16){s2+=80.0;}else if(resulet1==17){s2+=85.0;}else if(resulet1==18){s2+=90.0;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=16.2  )s2+=10.0;else if(resulet1<=19.3 &&resulet1>16.2 )s2+=30.0;
					else if(resulet1<=20.1 &&resulet1>19.3 )s2+=50.0;else if(resulet1<=25.6 &&resulet1>20.1 )s2+=70.0;else if( resulet1>25.6 )s2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1<=6){s2+=5.0;}else if(resulet1==7){s2+=7.5;
					}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=17.5;}else if(resulet1==10){s2+=25.0;}else if(resulet1==11){s2+=32.5;
					}else if(resulet1==12){s2+=45.0;}else if(resulet1==13){s2+=57.5;}else if(resulet1==14){s2+=67.5;}else if(resulet1==15){s2+=75.0;
					}else if(resulet1==16){s2+=82.5;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.0;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=14.1  )s2+=10.0;else if(resulet1<=17.1 &&resulet1>14.1 )s2+=30.0;
					else if(resulet1<=17.6 &&resulet1>17.1 )s2+=50.0;else if(resulet1<=22.3 &&resulet1>17.6 )s2+=70.0;else if( resulet1>22.3 )s2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=7.5;}else if(resulet1==6){s2+=10.0;}else if(resulet1==7){s2+=15.0;
					}else if(resulet1==8){s2+=20.0;}else if(resulet1==9){s2+=27.5;}else if(resulet1==10){s2+=37.5;}else if(resulet1==11){s2+=47.5;
					}else if(resulet1==12){s2+=57.5;}else if(resulet1==13){s2+=70.0;}else if(resulet1==14){s2+=75.0;}else if(resulet1==15){s2+=80.0;
					}else if(resulet1==16){s2+=85.0;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=95.0;}
					
					if(resulet1<=12.4  )s2+=10.0;else if(resulet1<=15.2 &&resulet1>12.4 )s2+=30.0;else if(resulet1<=16.4 &&resulet1>15.2 )s2+=50.0;
					else if(resulet1<=23.1 &&resulet1>16.4 )s2+=70.0;else if( resulet1>23.1 )s2+=90.0; 
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=20.0;}else if(resulet1==8){s2+=27.5;}else if(resulet1==9){s2+=37.5;
					}else if(resulet1==10){s2+=47.5;}else if(resulet1==11){s2+=57.5;}else if(resulet1==12){s2+=67.5;}else if(resulet1==13){s2+=75.0;
					}else if(resulet1==14){s2+=82.5;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=92.5;}else if(resulet1==17){s2+=95.0;}
					
					if(resulet1<=10.2  )s2+=10.0;else if(resulet1<=17 &&resulet1>10.2 )s2+=30.0;else if(resulet1<=17.4 &&resulet1>17 )s2+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)s2+=70.0;else if( resulet1>23.1 )s2+=90.0;
					
				} else if (age >= 89 && age < 100) {
					if(resulet1==0){s2+=5.0;}else if(resulet1==1){s2+=10.0;}else if(resulet1==2){s2+=12.5;}else if(resulet1==3){s2+=15.0;
					}else if(resulet1==4){s2+=22.5;}else if(resulet1==5){s2+=30.0;}else if(resulet1==6){s2+=35.0;}else if(resulet1==7){s2+=42.5;
					}else if(resulet1==8){s2+=50.0;}else if(resulet1==9){s2+=62.5;}else if(resulet1==10){s2+=65.0;}else if(resulet1==11){s2+=72.5;}else if(resulet1==12){s2+=80.0;
					}else if(resulet1==13){s2+=85.0;}else if(resulet1==14){s2+=87.5;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=92.5;}
					
					if(resulet1<=10.2  )s2+=10.0;else if(resulet1<=17 &&resulet1>10.2 )s2+=30.0;else if(resulet1<=17.4 &&resulet1>17 )s2+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)s2+=70.0;else if( resulet1>23.1 )s2+=90.0;
				}
			}
			if(f.getSex()==1&&calibrations==4){//男
				if (age < 65) {
					if(resulet1<=9){s2+=5.0;}else if(resulet1==10){s2+=7.5;}else if(resulet1==11){s2+=10.0;}else if(resulet1==12){s2+=15.0;}else if(resulet1==13){s2+=20.0;}else if(resulet1==14){s2+=25.0;
					}else if(resulet1==15){s2+=37.5;}else if(resulet1==16){s2+=47.5;}else if(resulet1==17){s2+=57.5;}else if(resulet1==18){s2+=65.0;}else if(resulet1==19){s2+=72.5;
					}else if(resulet1==20){s2+=80.0;}else if(resulet1==21){s2+=85.0;}else if(resulet1==22){s2+=90.0;}else if(resulet1==23){s2+=95.0;}
					
					if(resulet1<=21.9 )s2+=10.0;else if(resulet1<=30.3 &&resulet1>21.9 )s2+=30.0;
					else if(resulet1<=31.2 &&resulet1>30.3 )s2+=50.0;else if(resulet1<=40 &&resulet1>31.2 )s2+=70.0;else if( resulet1>40 )s2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=12.5;}else if(resulet1==11){s2+=17.5;
					}else if(resulet1==12){s2+=25.0;}else if(resulet1==13){s2+=32.5;}else if(resulet1==14){s2+=40.0;}else if(resulet1==15){s2+=47.5;
					}else if(resulet1==16){s2+=57.5;}else if(resulet1==17){s2+=65.0;}else if(resulet1==18){s2+=72.5;}else if(resulet1==19){s2+=80.0;
					}else if(resulet1==20){s2+=85.0;}else if(resulet1==21){s2+=90.0;}else if(resulet1==22){s2+=92.5;}else if(resulet1==23){s2+=95.0;}
					
					if(resulet1<=27  )s2+=10.0;else if(resulet1<=30.9 &&resulet1>27 )s2+=30.0;
					else if(resulet1<=32.1 &&resulet1>30.9 )s2+=50.0;else if(resulet1<=39.6 &&resulet1>32.1 )s2+=70.0;else if( resulet1>39.6 )s2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1<=8){s2+=5.0;}else if(resulet1==9){s2+=10.0;}else if(resulet1==10){s2+=15.0;}else if(resulet1==11){s2+=20.0;}else if(resulet1==12){s2+=27.5;
					}else if(resulet1==13){s2+=37.5;}else if(resulet1==14){s2+=47.5;}else if(resulet1==15){s2+=55.0;}else if(resulet1==16){s2+=62.5;}else if(resulet1==17){s2+=72.5;
					}else if(resulet1==18){s2+=80.0;}else if(resulet1==19){s2+=85.0;}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.0;}
					
					if(resulet1<=23.9  )s2+=10.0;else if(resulet1<=28.7 &&resulet1>23.9 )s2+=30.0;
					else if(resulet1<=30 &&resulet1>28.7 )s2+=50.0;else if(resulet1<=38.4 &&resulet1>30 )s2+=70.0;else if( resulet1>38.4 )s2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1==7){s2+=5.0;}else if(resulet1==8){s2+=10.0;}else if(resulet1==9){s2+=12.5;
					}else if(resulet1==10){s2+=17.5;}else if(resulet1==11){s2+=25.0;}else if(resulet1==12){s2+=32.5;}else if(resulet1==13){s2+=42.5;
					}else if(resulet1==14){s2+=50.0;}else if(resulet1==15){s2+=57.5;}else if(resulet1==16){s2+=67.5;}else if(resulet1==17){s2+=75.0;
					}else if(resulet1==18){s2+=82.5;}else if(resulet1==19){s2+=87.5;}else if(resulet1==20){s2+=90.0;}else if(resulet1==21){s2+=95.5;}
					
					if(resulet1<=19.2  )s2+=10.0;else if(resulet1<=24.8 &&resulet1>19.2 )s2+=30.0;
					else if(resulet1<=25.8 &&resulet1>24.8 )s2+=50.0;else if(resulet1<=33.7 &&resulet1>25.8 )s2+=70.0;else if( resulet1>33.7 )s2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=6){s2+=5.0;}else if(resulet1==7){s2+=10.0;
					}else if(resulet1==8){s2+=15.0;}else if(resulet1==9){s2+=20.0;}else if(resulet1==10){s2+=27.5;}else if(resulet1==11){s2+=37.5; }else if(resulet1==12){s2+=47.5;}else if(resulet1==13){s2+=57.5;}else if(resulet1==14){s2+=67.5;}else if(resulet1==15){s2+=75.0;
					}else if(resulet1==16){s2+=82.5;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.5;}else if(resulet1==19){s2+=95.0;}
					
					if(resulet1<=19.4  )s2+=10.0;else if(resulet1<=23.2 &&resulet1>19.4 )s2+=30.0;
					else if(resulet1<=24.2 &&resulet1>23.2 )s2+=50.0;else if(resulet1<=30 &&resulet1>24.2 )s2+=70.0;else if( resulet1>30 )s2+=90.0;
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){s2+=5.0;}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=20.0;
					}else if(resulet1==8){s2+=25.0;}else if(resulet1==9){s2+=32.5;}else if(resulet1==10){s2+=40.0;}else if(resulet1==11){s2+=47.5;
					}else if(resulet1==12){s2+=57.5;}else if(resulet1==13){s2+=67.5;}else if(resulet1==14){s2+=75.0;}else if(resulet1==15){s2+=80.0;
					}else if(resulet1==16){s2+=85.0;}else if(resulet1==17){s2+=90.0;}else if(resulet1==18){s2+=92.5;}else if(resulet1==17){s2+=95.0;}
					
					if(resulet1<=18.3  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=29 &&resulet1>21.1 )s2+=70.0;else if( resulet1>29 )s2+=90.0;
					
				} else if (age >= 90 && age <= 100) {
					if(resulet1<=3){s2+=5.0;}else if(resulet1==4){s2+=7.5;
					}else if(resulet1==5){s2+=10.0;}else if(resulet1==6){s2+=15.0;}else if(resulet1==7){s2+=22.5;}else if(resulet1==8){s2+=32.5;
					}else if(resulet1==9){s2+=42.5;}else if(resulet1==10){s2+=52.5;}else if(resulet1==11){s2+=62.5;}else if(resulet1==12){s2+=72.5;
					}else if(resulet1==13){s2+=80.0;}else if(resulet1==14){s2+=85.0;}else if(resulet1==15){s2+=90.0;}else if(resulet1==16){s2+=95.0;}
					
					if(resulet1<=18.3  )s2+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )s2+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )s2+=50.0;else if(resulet1<=29 &&resulet1>21.1 )s2+=70.0;else if( resulet1>29 )s2+=90.0;
					
				}
				
			}
			if(f.getSex()==0&&calibrations==3){//女
				//6 7
				if (resulete < 18) {
					e1 += 1.0;
				} else if (resulete >= 18 && resulete < 24.9) {
					e1 += 0.5;
				} else if (resulete > 24.9 && resulete < 29.9) {
					e1 += 0.5;
				} else if (resulete >= 29.9) {
					e1 +=0.1;
				}
				
			}
			if(f.getSex()==1&&calibrations==3){//男
				
				if (resulete < 18.5) {
					e1 += 1.0;
				} else if (resulete >= 18.5 && resulete < 23.9) {
					e1 += 1.0;
				} else if (resulete >= 23.9 && resulete < 27.9) {
					e1 += 0.5;
				} else if (resulete >= 27.9) {
					e1 +=0.1;
				}
			}
			
			if(f.getSex()==0&&calibrations==4){//女
				//1  5
				if (age < 65) {
					if(resulet1e<=8){e2+=5.0;}else if(resulet1e==9){e2+=10.0;}else if(resulet1e==10){e2+=15.0;}else if(resulet1e==11){e2+=20.0;}
					else if(resulet1e==12){e2+=27.5;}else if(resulet1e==13){e2+=35.0;}else if(resulet1e==14){e2+=42.5;}else if(resulet1e==15){e2+=52.5;}
					else if(resulet1e==16){e2+=62.5;}else if(resulet1e==17){e2+=72.5;}else if(resulet1e==18){e2+=80.0;}else if(resulet1e==19){e2+=85.0;}
					else if(resulet1e==20){e2+=90.0;}else if(resulet1e==21){e2+=95.0;}
					if(resulet1e<=17.8  )e2+=10.0;else if(resulet1e<=20.6 &&resulet1e>17.8 )e2+=30.0;
					else if(resulet1e<=21.1 &&resulet1e>20.6 )e2+=50.0;else if(resulet1e<=26 &&resulet1e>21.1 )e2+=70.0;else if( resulet1e>26 )e2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1e<=8){e2+=5.0;}else if(resulet1e==9){e2+=10.0;}else if(resulet1e==10){e2+=15.0;}else if(resulet1e==11){e2+=22.5;
					}else if(resulet1e==12){e2+=27.5;}else if(resulet1e==13){e2+=35.0;}else if(resulet1e==14){e2+=42.5;}else if(resulet1e==15){e2+=52.5;
					}else if(resulet1e==16){e2+=62.5;}else if(resulet1e==17){e2+=72.5;}else if(resulet1e==18){e2+=80.0;}else if(resulet1e==19){e2+=85.0;
					}else if(resulet1e==20){e2+=90.0;}else if(resulet1e==21){e2+=95.0;}
					
					if(resulet1e<=16.6  )e2+=10.0;else if(resulet1e<=19.8 &&resulet1e>16.6 )e2+=30.0;
					else if(resulet1e<=20.6 &&resulet1e>19.8 )e2+=50.0;else if(resulet1e<=26.4 &&resulet1e>20.6 )e2+=70.0;else if( resulet1e>26.4 )e2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1e<=7){e2+=5.0;}else if(resulet1e==8){e2+=10.0;}else if(resulet1e==9){e2+=15.0;}else if(resulet1e==10){e2+=22.5;}else if(resulet1e==11){e2+=32.5;
					}else if(resulet1e==12){e2+=40.0;}else if(resulet1e==13){e2+=25.5;}else if(resulet1e==14){e2+=62.5;}else if(resulet1e==15){e2+=72.5;
					}else if(resulet1e==16){e2+=80.0;}else if(resulet1e==17){e2+=85.0;}else if(resulet1e==18){e2+=90.0;}else if(resulet1e==19){e2+=95.0;}
					
					if(resulet1e<=16.2  )e2+=10.0;else if(resulet1e<=19.3 &&resulet1e>16.2 )e2+=30.0;
					else if(resulet1e<=20.1 &&resulet1e>19.3 )e2+=50.0;else if(resulet1e<=25.6 &&resulet1e>20.1 )e2+=70.0;else if( resulet1e>25.6 )e2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1e<=6){e2+=5.0;}else if(resulet1e==7){e2+=7.5;
					}else if(resulet1e==8){e2+=10.0;}else if(resulet1e==9){e2+=17.5;}else if(resulet1e==10){e2+=25.0;}else if(resulet1e==11){e2+=32.5;
					}else if(resulet1e==12){e2+=45.0;}else if(resulet1e==13){e2+=57.5;}else if(resulet1e==14){e2+=67.5;}else if(resulet1e==15){e2+=75.0;
					}else if(resulet1e==16){e2+=82.5;}else if(resulet1e==17){e2+=90.0;}else if(resulet1e==18){e2+=92.0;}else if(resulet1e==19){e2+=95.0;}
					
					if(resulet1e<=14.1  )e2+=10.0;else if(resulet1e<=17.1 &&resulet1e>14.1 )e2+=30.0;
					else if(resulet1e<=17.6 &&resulet1e>17.1 )e2+=50.0;else if(resulet1e<=22.3 &&resulet1e>17.6 )e2+=70.0;else if( resulet1e>22.3 )e2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1e<=4){e2+=5.0;}else if(resulet1e==5){e2+=7.5;}else if(resulet1e==6){e2+=10.0;}else if(resulet1e==7){e2+=15.0;
					}else if(resulet1e==8){e2+=20.0;}else if(resulet1e==9){e2+=27.5;}else if(resulet1e==10){e2+=37.5;}else if(resulet1e==11){e2+=47.5;
					}else if(resulet1e==12){e2+=57.5;}else if(resulet1e==13){e2+=70.0;}else if(resulet1e==14){e2+=75.0;}else if(resulet1e==15){e2+=80.0;
					}else if(resulet1e==16){e2+=85.0;}else if(resulet1e==17){e2+=90.0;}else if(resulet1e==18){e2+=95.0;}
					
					if(resulet1e<=12.4  )e2+=10.0;else if(resulet1e<=15.2 &&resulet1e>12.4 )e2+=30.0;else if(resulet1e<=16.4 &&resulet1e>15.2 )e2+=50.0;
					else if(resulet1e<=23.1 &&resulet1e>16.4 )e2+=70.0;else if( resulet1e>23.1 )e2+=90.0; 
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1e<=4){e2+=5.0;}else if(resulet1e==5){e2+=10.0;}else if(resulet1e==6){e2+=15.0;}else if(resulet1e==7){e2+=20.0;}else if(resulet1e==8){e2+=27.5;}else if(resulet1e==9){e2+=37.5;
					}else if(resulet1e==10){e2+=47.5;}else if(resulet1e==11){e2+=57.5;}else if(resulet1e==12){e2+=67.5;}else if(resulet1e==13){e2+=75.0;
					}else if(resulet1e==14){e2+=82.5;}else if(resulet1e==15){e2+=90.0;}else if(resulet1e==16){e2+=92.5;}else if(resulet1e==17){e2+=95.0;}
					
					if(resulet1e<=10.2  )e2+=10.0;else if(resulet1e<=17 &&resulet1e>10.2 )e2+=30.0;else if(resulet1e<=17.4 &&resulet1e>17 )e2+=50.0;else if(resulet1e<=23.1 &&resulet1e> 17.4)e2+=70.0;else if( resulet1e>23.1 )e2+=90.0;
					
				} else if (age >= 89 && age < 100) {
					if(resulet1e==0){e2+=5.0;}else if(resulet1e==1){e2+=10.0;}else if(resulet1e==2){e2+=12.5;}else if(resulet1e==3){e2+=15.0;
					}else if(resulet1e==4){e2+=22.5;}else if(resulet1e==5){e2+=30.0;}else if(resulet1e==6){e2+=35.0;}else if(resulet1e==7){e2+=42.5;
					}else if(resulet1e==8){e2+=50.0;}else if(resulet1e==9){e2+=62.5;}else if(resulet1e==10){e2+=65.0;}else if(resulet1e==11){e2+=72.5;}else if(resulet1e==12){e2+=80.0;
					}else if(resulet1e==13){e2+=85.0;}else if(resulet1e==14){e2+=87.5;}else if(resulet1e==15){e2+=90.0;}else if(resulet1e==16){e2+=92.5;}
					
					if(resulet1e<=10.2  )e2+=10.0;else if(resulet1e<=17 &&resulet1e>10.2 )e2+=30.0;else if(resulet1e<=17.4 &&resulet1e>17 )e2+=50.0;else if(resulet1e<=23.1 &&resulet1e> 17.4)e2+=70.0;else if( resulet1e>23.1 )e2+=90.0;
				}
			}
			if(f.getSex()==1&&calibrations==4){//男
				if (age < 65) {
					if(resulet1e<=9){e2+=5.0;}else if(resulet1e==10){e2+=7.5;}else if(resulet1e==11){e2+=10.0;}else if(resulet1e==12){e2+=15.0;}else if(resulet1e==13){e2+=20.0;}else if(resulet1e==14){e2+=25.0;
					}else if(resulet1e==15){e2+=37.5;}else if(resulet1e==16){e2+=47.5;}else if(resulet1e==17){e2+=57.5;}else if(resulet1e==18){e2+=65.0;}else if(resulet1e==19){e2+=72.5;
					}else if(resulet1e==20){e2+=80.0;}else if(resulet1e==21){e2+=85.0;}else if(resulet1e==22){e2+=90.0;}else if(resulet1e==23){e2+=95.0;}
					
					if(resulet1e<=21.9 )e2+=10.0;else if(resulet1e<=30.3 &&resulet1e>21.9 )e2+=30.0;
					else if(resulet1e<=31.2 &&resulet1e>30.3 )e2+=50.0;else if(resulet1e<=40 &&resulet1e>31.2 )e2+=70.0;else if( resulet1e>40 )e2+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1e<=8){e2+=5.0;}else if(resulet1e==9){e2+=10.0;}else if(resulet1e==10){e2+=12.5;}else if(resulet1e==11){e2+=17.5;
					}else if(resulet1e==12){e2+=25.0;}else if(resulet1e==13){e2+=32.5;}else if(resulet1e==14){e2+=40.0;}else if(resulet1e==15){e2+=47.5;
					}else if(resulet1e==16){e2+=57.5;}else if(resulet1e==17){e2+=65.0;}else if(resulet1e==18){e2+=72.5;}else if(resulet1e==19){e2+=80.0;
					}else if(resulet1e==20){e2+=85.0;}else if(resulet1e==21){e2+=90.0;}else if(resulet1e==22){e2+=92.5;}else if(resulet1e==23){e2+=95.0;}
					
					if(resulet1e<=27  )e2+=10.0;else if(resulet1e<=30.9 &&resulet1e>27 )e2+=30.0;
					else if(resulet1e<=32.1 &&resulet1e>30.9 )e2+=50.0;else if(resulet1e<=39.6 &&resulet1e>32.1 )e2+=70.0;else if( resulet1e>39.6 )e2+=90.0;
					
				} else if (age >=70 && age <= 74) {
					if(resulet1e<=8){e2+=5.0;}else if(resulet1e==9){e2+=10.0;}else if(resulet1e==10){e2+=15.0;}else if(resulet1e==11){e2+=20.0;}else if(resulet1e==12){e2+=27.5;
					}else if(resulet1e==13){e2+=37.5;}else if(resulet1e==14){e2+=47.5;}else if(resulet1e==15){e2+=55.0;}else if(resulet1e==16){e2+=62.5;}else if(resulet1e==17){e2+=72.5;
					}else if(resulet1e==18){e2+=80.0;}else if(resulet1e==19){e2+=85.0;}else if(resulet1e==20){e2+=90.0;}else if(resulet1e==21){e2+=95.0;}
					
					if(resulet1e<=23.9  )e2+=10.0;else if(resulet1e<=28.7 &&resulet1e>23.9 )e2+=30.0;
					else if(resulet1e<=30 &&resulet1e>28.7 )e2+=50.0;else if(resulet1e<=38.4 &&resulet1e>30 )e2+=70.0;else if( resulet1e>38.4 )e2+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1e==7){e2+=5.0;}else if(resulet1e==8){e2+=10.0;}else if(resulet1e==9){e2+=12.5;
					}else if(resulet1e==10){e2+=17.5;}else if(resulet1e==11){e2+=25.0;}else if(resulet1e==12){e2+=32.5;}else if(resulet1e==13){e2+=42.5;
					}else if(resulet1e==14){e2+=50.0;}else if(resulet1e==15){e2+=57.5;}else if(resulet1e==16){e2+=67.5;}else if(resulet1e==17){e2+=75.0;
					}else if(resulet1e==18){e2+=82.5;}else if(resulet1e==19){e2+=87.5;}else if(resulet1e==20){e2+=90.0;}else if(resulet1e==21){e2+=95.5;}
					
					if(resulet1e<=19.2  )e2+=10.0;else if(resulet1e<=24.8 &&resulet1e>19.2 )e2+=30.0;
					else if(resulet1e<=25.8 &&resulet1e>24.8 )e2+=50.0;else if(resulet1e<=33.7 &&resulet1e>25.8 )e2+=70.0;else if( resulet1e>33.7 )e2+=90.0;
					
				} else if (age >= 80 && age <= 84) {
					if(resulet1e<=6){e2+=5.0;}else if(resulet1e==7){e2+=10.0;
					}else if(resulet1e==8){e2+=15.0;}else if(resulet1e==9){e2+=20.0;}else if(resulet1e==10){e2+=27.5;}else if(resulet1e==11){e2+=37.5; }else if(resulet1e==12){e2+=47.5;}else if(resulet1e==13){e2+=57.5;}else if(resulet1e==14){e2+=67.5;}else if(resulet1e==15){e2+=75.0;
					}else if(resulet1e==16){e2+=82.5;}else if(resulet1e==17){e2+=90.0;}else if(resulet1e==18){e2+=92.5;}else if(resulet1e==19){e2+=95.0;}
					
					if(resulet1e<=19.4  )e2+=10.0;else if(resulet1e<=23.2 &&resulet1e>19.4 )e2+=30.0;
					else if(resulet1e<=24.2 &&resulet1e>23.2 )e2+=50.0;else if(resulet1e<=30 &&resulet1e>24.2 )e2+=70.0;else if( resulet1e>30 )e2+=90.0;
					
				} else if (age >= 85 && age <= 89) {
					if(resulet1e<=4){e2+=5.0;}else if(resulet1e==5){e2+=10.0;}else if(resulet1e==6){e2+=15.0;}else if(resulet1e==7){e2+=20.0;
					}else if(resulet1e==8){e2+=25.0;}else if(resulet1e==9){e2+=32.5;}else if(resulet1e==10){e2+=40.0;}else if(resulet1e==11){e2+=47.5;
					}else if(resulet1e==12){e2+=57.5;}else if(resulet1e==13){e2+=67.5;}else if(resulet1e==14){e2+=75.0;}else if(resulet1e==15){e2+=80.0;
					}else if(resulet1e==16){e2+=85.0;}else if(resulet1e==17){e2+=90.0;}else if(resulet1e==18){e2+=92.5;}else if(resulet1e==17){e2+=95.0;}
					
					if(resulet1e<=18.3  )e2+=10.0;else if(resulet1e<=20.6 &&resulet1e>18.3 )e2+=30.0;
					else if(resulet1e<=21.1 &&resulet1e>20.6 )e2+=50.0;else if(resulet1e<=29 &&resulet1e>21.1 )e2+=70.0;else if( resulet1e>29 )e2+=90.0;
					
				} else if (age >= 90 && age <= 100) {
					if(resulet1e<=3){e2+=5.0;}else if(resulet1e==4){e2+=7.5;
					}else if(resulet1e==5){e2+=10.0;}else if(resulet1e==6){e2+=15.0;}else if(resulet1e==7){e2+=22.5;}else if(resulet1e==8){e2+=32.5;
					}else if(resulet1e==9){e2+=42.5;}else if(resulet1e==10){e2+=52.5;}else if(resulet1e==11){e2+=62.5;}else if(resulet1e==12){e2+=72.5;
					}else if(resulet1e==13){e2+=80.0;}else if(resulet1e==14){e2+=85.0;}else if(resulet1e==15){e2+=90.0;}else if(resulet1e==16){e2+=95.0;}
					
					if(resulet1e<=18.3  )e2+=10.0;else if(resulet1e<=20.6 &&resulet1e>18.3 )e2+=30.0;
					else if(resulet1e<=21.1 &&resulet1e>20.6 )e2+=50.0;else if(resulet1e<=29 &&resulet1e>21.1 )e2+=70.0;else if( resulet1e>29 )e2+=90.0;
					
				}
				
			}
			
			resulet= Math.pow(e1+e2-s1-s2-cords,2);
			score+=resulet;
		}
		return score;
	}
	
	/**********************************************************************************************/
	public static Double getTsl_(List<FitnessVO2> recod,int calibrations){
		double score=0.0;
		for(FitnessVO2 f:recod){
			int age=f.getAge();
			double resulet=f.getResultE1();
			double resulet1=f.getResultE2();
			if(f.getSex()==0&&calibrations==3){//女
				//6 7
				if (resulet < 18) {
					score += 1.0;
				} else if (resulet >= 18 && resulet < 24.9) {
					score += 0.5;
				} else if (resulet > 24.9 && resulet < 29.9) {
					score += 0.5;
				} else if (resulet >= 29.9) {
					score +=0.1;
				}
				
			}
			if(f.getSex()==1&&calibrations==3){//男
				
				if (resulet < 18.5) {
					score += 1.0;
				} else if (resulet >= 18.5 && resulet < 23.9) {
					score += 1.0;
				} else if (resulet >= 23.9 && resulet < 27.9) {
					score += 0.5;
				} else if (resulet >= 27.9) {
					score +=0.1;
				}
			}
			
			if(f.getSex()==0&&calibrations==4){//女
				//1  5
				if (age < 65) {
					if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=20.0;}
					else if(resulet1==12){score+=27.5;}else if(resulet1==13){score+=35.0;}else if(resulet1==14){score+=42.5;}else if(resulet1==15){score+=52.5;}
					else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;}
					else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
					if(resulet1<=17.8  )score+=10.0;else if(resulet1<=20.6 &&resulet1>17.8 )score+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=26 &&resulet1>21.1 )score+=70.0;else if( resulet1>26 )score+=90.0;
				
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=22.5;
					}else if(resulet1==12){score+=27.5;}else if(resulet1==13){score+=35.0;}else if(resulet1==14){score+=42.5;}else if(resulet1==15){score+=52.5;
					}else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;
					}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
				
					if(resulet1<=16.6  )score+=10.0;else if(resulet1<=19.8 &&resulet1>16.6 )score+=30.0;
					else if(resulet1<=20.6 &&resulet1>19.8 )score+=50.0;else if(resulet1<=26.4 &&resulet1>20.6 )score+=70.0;else if( resulet1>26.4 )score+=90.0;
				
				} else if (age >=70 && age <= 74) {
					if(resulet1<=7){score+=5.0;}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=15.0;}else if(resulet1==10){score+=22.5;}else if(resulet1==11){score+=32.5;
					}else if(resulet1==12){score+=40.0;}else if(resulet1==13){score+=25.5;}else if(resulet1==14){score+=62.5;}else if(resulet1==15){score+=72.5;
					}else if(resulet1==16){score+=80.0;}else if(resulet1==17){score+=85.0;}else if(resulet1==18){score+=90.0;}else if(resulet1==19){score+=95.0;}
					
					if(resulet1<=16.2  )score+=10.0;else if(resulet1<=19.3 &&resulet1>16.2 )score+=30.0;
					else if(resulet1<=20.1 &&resulet1>19.3 )score+=50.0;else if(resulet1<=25.6 &&resulet1>20.1 )score+=70.0;else if( resulet1>25.6 )score+=90.0;
				
				} else if (age >= 75 && age <= 79) {
					if(resulet1<=6){score+=5.0;}else if(resulet1==7){score+=7.5;
					}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=17.5;}else if(resulet1==10){score+=25.0;}else if(resulet1==11){score+=32.5;
					}else if(resulet1==12){score+=45.0;}else if(resulet1==13){score+=57.5;}else if(resulet1==14){score+=67.5;}else if(resulet1==15){score+=75.0;
					}else if(resulet1==16){score+=82.5;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.0;}else if(resulet1==19){score+=95.0;}
				
					if(resulet1<=14.1  )score+=10.0;else if(resulet1<=17.1 &&resulet1>14.1 )score+=30.0;
					else if(resulet1<=17.6 &&resulet1>17.1 )score+=50.0;else if(resulet1<=22.3 &&resulet1>17.6 )score+=70.0;else if( resulet1>22.3 )score+=90.0;
				
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=7.5;}else if(resulet1==6){score+=10.0;}else if(resulet1==7){score+=15.0;
					}else if(resulet1==8){score+=20.0;}else if(resulet1==9){score+=27.5;}else if(resulet1==10){score+=37.5;}else if(resulet1==11){score+=47.5;
					}else if(resulet1==12){score+=57.5;}else if(resulet1==13){score+=70.0;}else if(resulet1==14){score+=75.0;}else if(resulet1==15){score+=80.0;
					}else if(resulet1==16){score+=85.0;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=95.0;}
				
					if(resulet1<=12.4  )score+=10.0;else if(resulet1<=15.2 &&resulet1>12.4 )score+=30.0;else if(resulet1<=16.4 &&resulet1>15.2 )score+=50.0;
					else if(resulet1<=23.1 &&resulet1>16.4 )score+=70.0;else if( resulet1>23.1 )score+=90.0; 
				
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=20.0;}else if(resulet1==8){score+=27.5;}else if(resulet1==9){score+=37.5;
					}else if(resulet1==10){score+=47.5;}else if(resulet1==11){score+=57.5;}else if(resulet1==12){score+=67.5;}else if(resulet1==13){score+=75.0;
					}else if(resulet1==14){score+=82.5;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=92.5;}else if(resulet1==17){score+=95.0;}
				
					if(resulet1<=10.2  )score+=10.0;else if(resulet1<=17 &&resulet1>10.2 )score+=30.0;else if(resulet1<=17.4 &&resulet1>17 )score+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)score+=70.0;else if( resulet1>23.1 )score+=90.0;
					
				} else if (age >= 89 && age < 100) {
					if(resulet1==0){score+=5.0;}else if(resulet1==1){score+=10.0;}else if(resulet1==2){score+=12.5;}else if(resulet1==3){score+=15.0;
					}else if(resulet1==4){score+=22.5;}else if(resulet1==5){score+=30.0;}else if(resulet1==6){score+=35.0;}else if(resulet1==7){score+=42.5;
					}else if(resulet1==8){score+=50.0;}else if(resulet1==9){score+=62.5;}else if(resulet1==10){score+=65.0;}else if(resulet1==11){score+=72.5;}else if(resulet1==12){score+=80.0;
					}else if(resulet1==13){score+=85.0;}else if(resulet1==14){score+=87.5;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=92.5;}
				
					if(resulet1<=10.2  )score+=10.0;else if(resulet1<=17 &&resulet1>10.2 )score+=30.0;else if(resulet1<=17.4 &&resulet1>17 )score+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)score+=70.0;else if( resulet1>23.1 )score+=90.0;
				}
			}
			if(f.getSex()==1&&calibrations==4){//男
				if (age < 65) {
					if(resulet1<=9){score+=5.0;}else if(resulet1==10){score+=7.5;}else if(resulet1==11){score+=10.0;}else if(resulet1==12){score+=15.0;}else if(resulet1==13){score+=20.0;}else if(resulet1==14){score+=25.0;
					}else if(resulet1==15){score+=37.5;}else if(resulet1==16){score+=47.5;}else if(resulet1==17){score+=57.5;}else if(resulet1==18){score+=65.0;}else if(resulet1==19){score+=72.5;
					}else if(resulet1==20){score+=80.0;}else if(resulet1==21){score+=85.0;}else if(resulet1==22){score+=90.0;}else if(resulet1==23){score+=95.0;}
					
					if(resulet1<=21.9 )score+=10.0;else if(resulet1<=30.3 &&resulet1>21.9 )score+=30.0;
					else if(resulet1<=31.2 &&resulet1>30.3 )score+=50.0;else if(resulet1<=40 &&resulet1>31.2 )score+=70.0;else if( resulet1>40 )score+=90.0;
					
				} else if (age >= 65 && age <= 69) {
					if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=12.5;}else if(resulet1==11){score+=17.5;
					}else if(resulet1==12){score+=25.0;}else if(resulet1==13){score+=32.5;}else if(resulet1==14){score+=40.0;}else if(resulet1==15){score+=47.5;
					}else if(resulet1==16){score+=57.5;}else if(resulet1==17){score+=65.0;}else if(resulet1==18){score+=72.5;}else if(resulet1==19){score+=80.0;
					}else if(resulet1==20){score+=85.0;}else if(resulet1==21){score+=90.0;}else if(resulet1==22){score+=92.5;}else if(resulet1==23){score+=95.0;}
					
					if(resulet1<=27  )score+=10.0;else if(resulet1<=30.9 &&resulet1>27 )score+=30.0;
					else if(resulet1<=32.1 &&resulet1>30.9 )score+=50.0;else if(resulet1<=39.6 &&resulet1>32.1 )score+=70.0;else if( resulet1>39.6 )score+=90.0;
				
				} else if (age >=70 && age <= 74) {
					if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=20.0;}else if(resulet1==12){score+=27.5;
					}else if(resulet1==13){score+=37.5;}else if(resulet1==14){score+=47.5;}else if(resulet1==15){score+=55.0;}else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;
					}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
				
					 if(resulet1<=23.9  )score+=10.0;else if(resulet1<=28.7 &&resulet1>23.9 )score+=30.0;
					else if(resulet1<=30 &&resulet1>28.7 )score+=50.0;else if(resulet1<=38.4 &&resulet1>30 )score+=70.0;else if( resulet1>38.4 )score+=90.0;
					
				} else if (age >= 75 && age <= 79) {
					if(resulet1==7){score+=5.0;}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=12.5;
					}else if(resulet1==10){score+=17.5;}else if(resulet1==11){score+=25.0;}else if(resulet1==12){score+=32.5;}else if(resulet1==13){score+=42.5;
					}else if(resulet1==14){score+=50.0;}else if(resulet1==15){score+=57.5;}else if(resulet1==16){score+=67.5;}else if(resulet1==17){score+=75.0;
					}else if(resulet1==18){score+=82.5;}else if(resulet1==19){score+=87.5;}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.5;}
				
					if(resulet1<=19.2  )score+=10.0;else if(resulet1<=24.8 &&resulet1>19.2 )score+=30.0;
					else if(resulet1<=25.8 &&resulet1>24.8 )score+=50.0;else if(resulet1<=33.7 &&resulet1>25.8 )score+=70.0;else if( resulet1>33.7 )score+=90.0;
						
				} else if (age >= 80 && age <= 84) {
					if(resulet1<=6){score+=5.0;}else if(resulet1==7){score+=10.0;
					}else if(resulet1==8){score+=15.0;}else if(resulet1==9){score+=20.0;}else if(resulet1==10){score+=27.5;}else if(resulet1==11){score+=37.5; }else if(resulet1==12){score+=47.5;}else if(resulet1==13){score+=57.5;}else if(resulet1==14){score+=67.5;}else if(resulet1==15){score+=75.0;
					}else if(resulet1==16){score+=82.5;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.5;}else if(resulet1==19){score+=95.0;}
				
					if(resulet1<=19.4  )score+=10.0;else if(resulet1<=23.2 &&resulet1>19.4 )score+=30.0;
					else if(resulet1<=24.2 &&resulet1>23.2 )score+=50.0;else if(resulet1<=30 &&resulet1>24.2 )score+=70.0;else if( resulet1>30 )score+=90.0;
				
				} else if (age >= 85 && age <= 89) {
					if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=20.0;
					}else if(resulet1==8){score+=25.0;}else if(resulet1==9){score+=32.5;}else if(resulet1==10){score+=40.0;}else if(resulet1==11){score+=47.5;
					}else if(resulet1==12){score+=57.5;}else if(resulet1==13){score+=67.5;}else if(resulet1==14){score+=75.0;}else if(resulet1==15){score+=80.0;
					}else if(resulet1==16){score+=85.0;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.5;}else if(resulet1==17){score+=95.0;}
				
					if(resulet1<=18.3  )score+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )score+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=29 &&resulet1>21.1 )score+=70.0;else if( resulet1>29 )score+=90.0;
				
				} else if (age >= 90 && age <= 100) {
					if(resulet1<=3){score+=5.0;}else if(resulet1==4){score+=7.5;
					}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=22.5;}else if(resulet1==8){score+=32.5;
					}else if(resulet1==9){score+=42.5;}else if(resulet1==10){score+=52.5;}else if(resulet1==11){score+=62.5;}else if(resulet1==12){score+=72.5;
					}else if(resulet1==13){score+=80.0;}else if(resulet1==14){score+=85.0;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=95.0;}
				
					if(resulet1<=18.3  )score+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )score+=30.0;
					else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=29 &&resulet1>21.1 )score+=70.0;else if( resulet1>29 )score+=90.0;
				
				}
				
			}
		}
		return score;
	}
	
	/**
	 * 体适能双选项   
	 * @param f
	 * @param calibrations
	 * @param resulet
	 * @param resulet1
	 * @return
	 */
	public static Double getTSN(FitnessVO2 f,int calibrations,double resulet,double resulet1){
		double score=0.0;
		int age=f.getAge();
		if(f.getSex()==0&&calibrations==3){//女
			//6 7
			if (resulet < 18) {
				score += 1.0;
			} else if (resulet >= 18 && resulet < 24.9) {
				score += 0.5;
			} else if (resulet > 24.9 && resulet < 29.9) {
				score += 0.5;
			} else if (resulet >= 29.9) {
				score +=0.1;
			}
			
		}
		if(f.getSex()==1&&calibrations==3){//男
			
			if (resulet < 18.5) {
				score += 1.0;
			} else if (resulet >= 18.5 && resulet < 23.9) {
				score += 1.0;
			} else if (resulet >= 23.9 && resulet < 27.9) {
				score += 0.5;
			} else if (resulet >= 27.9) {
				score +=0.1;
			}
		}
		
		if(f.getSex()==0&&calibrations==4){//女
			//1  5
			if (age < 65) {
				if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=20.0;}
				else if(resulet1==12){score+=27.5;}else if(resulet1==13){score+=35.0;}else if(resulet1==14){score+=42.5;}else if(resulet1==15){score+=52.5;}
				else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;}
				else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
				if(resulet1<=17.8  )score+=10.0;else if(resulet1<=20.6 &&resulet1>17.8 )score+=30.0;
				else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=26 &&resulet1>21.1 )score+=70.0;else if( resulet1>26 )score+=90.0;
			
			} else if (age >= 65 && age <= 69) {
				if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=22.5;
				}else if(resulet1==12){score+=27.5;}else if(resulet1==13){score+=35.0;}else if(resulet1==14){score+=42.5;}else if(resulet1==15){score+=52.5;
				}else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;
				}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
			
				if(resulet1<=16.6  )score+=10.0;else if(resulet1<=19.8 &&resulet1>16.6 )score+=30.0;
				else if(resulet1<=20.6 &&resulet1>19.8 )score+=50.0;else if(resulet1<=26.4 &&resulet1>20.6 )score+=70.0;else if( resulet1>26.4 )score+=90.0;
			
			} else if (age >=70 && age <= 74) {
				if(resulet1<=7){score+=5.0;}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=15.0;}else if(resulet1==10){score+=22.5;}else if(resulet1==11){score+=32.5;
				}else if(resulet1==12){score+=40.0;}else if(resulet1==13){score+=25.5;}else if(resulet1==14){score+=62.5;}else if(resulet1==15){score+=72.5;
				}else if(resulet1==16){score+=80.0;}else if(resulet1==17){score+=85.0;}else if(resulet1==18){score+=90.0;}else if(resulet1==19){score+=95.0;}
				
				if(resulet1<=16.2  )score+=10.0;else if(resulet1<=19.3 &&resulet1>16.2 )score+=30.0;
				else if(resulet1<=20.1 &&resulet1>19.3 )score+=50.0;else if(resulet1<=25.6 &&resulet1>20.1 )score+=70.0;else if( resulet1>25.6 )score+=90.0;
			
			} else if (age >= 75 && age <= 79) {
				if(resulet1<=6){score+=5.0;}else if(resulet1==7){score+=7.5;
				}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=17.5;}else if(resulet1==10){score+=25.0;}else if(resulet1==11){score+=32.5;
				}else if(resulet1==12){score+=45.0;}else if(resulet1==13){score+=57.5;}else if(resulet1==14){score+=67.5;}else if(resulet1==15){score+=75.0;
				}else if(resulet1==16){score+=82.5;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.0;}else if(resulet1==19){score+=95.0;}
			
				if(resulet1<=14.1  )score+=10.0;else if(resulet1<=17.1 &&resulet1>14.1 )score+=30.0;
				else if(resulet1<=17.6 &&resulet1>17.1 )score+=50.0;else if(resulet1<=22.3 &&resulet1>17.6 )score+=70.0;else if( resulet1>22.3 )score+=90.0;
			
			} else if (age >= 80 && age <= 84) {
				if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=7.5;}else if(resulet1==6){score+=10.0;}else if(resulet1==7){score+=15.0;
				}else if(resulet1==8){score+=20.0;}else if(resulet1==9){score+=27.5;}else if(resulet1==10){score+=37.5;}else if(resulet1==11){score+=47.5;
				}else if(resulet1==12){score+=57.5;}else if(resulet1==13){score+=70.0;}else if(resulet1==14){score+=75.0;}else if(resulet1==15){score+=80.0;
				}else if(resulet1==16){score+=85.0;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=95.0;}
			
				if(resulet1<=12.4  )score+=10.0;else if(resulet1<=15.2 &&resulet1>12.4 )score+=30.0;else if(resulet1<=16.4 &&resulet1>15.2 )score+=50.0;
				else if(resulet1<=23.1 &&resulet1>16.4 )score+=70.0;else if( resulet1>23.1 )score+=90.0; 
			
			} else if (age >= 85 && age <= 89) {
				if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=20.0;}else if(resulet1==8){score+=27.5;}else if(resulet1==9){score+=37.5;
				}else if(resulet1==10){score+=47.5;}else if(resulet1==11){score+=57.5;}else if(resulet1==12){score+=67.5;}else if(resulet1==13){score+=75.0;
				}else if(resulet1==14){score+=82.5;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=92.5;}else if(resulet1==17){score+=95.0;}
			
				if(resulet1<=10.2  )score+=10.0;else if(resulet1<=17 &&resulet1>10.2 )score+=30.0;else if(resulet1<=17.4 &&resulet1>17 )score+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)score+=70.0;else if( resulet1>23.1 )score+=90.0;
				
			} else if (age >= 89 && age < 100) {
				if(resulet1==0){score+=5.0;}else if(resulet1==1){score+=10.0;}else if(resulet1==2){score+=12.5;}else if(resulet1==3){score+=15.0;
				}else if(resulet1==4){score+=22.5;}else if(resulet1==5){score+=30.0;}else if(resulet1==6){score+=35.0;}else if(resulet1==7){score+=42.5;
				}else if(resulet1==8){score+=50.0;}else if(resulet1==9){score+=62.5;}else if(resulet1==10){score+=65.0;}else if(resulet1==11){score+=72.5;}else if(resulet1==12){score+=80.0;
				}else if(resulet1==13){score+=85.0;}else if(resulet1==14){score+=87.5;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=92.5;}
			
				if(resulet1<=10.2  )score+=10.0;else if(resulet1<=17 &&resulet1>10.2 )score+=30.0;else if(resulet1<=17.4 &&resulet1>17 )score+=50.0;else if(resulet1<=23.1 &&resulet1> 17.4)score+=70.0;else if( resulet1>23.1 )score+=90.0;
			}
		}
		if(f.getSex()==1&&calibrations==4){//男
			if (age < 65) {
				if(resulet1<=9){score+=5.0;}else if(resulet1==10){score+=7.5;}else if(resulet1==11){score+=10.0;}else if(resulet1==12){score+=15.0;}else if(resulet1==13){score+=20.0;}else if(resulet1==14){score+=25.0;
				}else if(resulet1==15){score+=37.5;}else if(resulet1==16){score+=47.5;}else if(resulet1==17){score+=57.5;}else if(resulet1==18){score+=65.0;}else if(resulet1==19){score+=72.5;
				}else if(resulet1==20){score+=80.0;}else if(resulet1==21){score+=85.0;}else if(resulet1==22){score+=90.0;}else if(resulet1==23){score+=95.0;}
				
				if(resulet1<=21.9 )score+=10.0;else if(resulet1<=30.3 &&resulet1>21.9 )score+=30.0;
				else if(resulet1<=31.2 &&resulet1>30.3 )score+=50.0;else if(resulet1<=40 &&resulet1>31.2 )score+=70.0;else if( resulet1>40 )score+=90.0;
				
			} else if (age >= 65 && age <= 69) {
				if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=12.5;}else if(resulet1==11){score+=17.5;
				}else if(resulet1==12){score+=25.0;}else if(resulet1==13){score+=32.5;}else if(resulet1==14){score+=40.0;}else if(resulet1==15){score+=47.5;
				}else if(resulet1==16){score+=57.5;}else if(resulet1==17){score+=65.0;}else if(resulet1==18){score+=72.5;}else if(resulet1==19){score+=80.0;
				}else if(resulet1==20){score+=85.0;}else if(resulet1==21){score+=90.0;}else if(resulet1==22){score+=92.5;}else if(resulet1==23){score+=95.0;}
				
				if(resulet1<=27  )score+=10.0;else if(resulet1<=30.9 &&resulet1>27 )score+=30.0;
				else if(resulet1<=32.1 &&resulet1>30.9 )score+=50.0;else if(resulet1<=39.6 &&resulet1>32.1 )score+=70.0;else if( resulet1>39.6 )score+=90.0;
			
			} else if (age >=70 && age <= 74) {
				if(resulet1<=8){score+=5.0;}else if(resulet1==9){score+=10.0;}else if(resulet1==10){score+=15.0;}else if(resulet1==11){score+=20.0;}else if(resulet1==12){score+=27.5;
				}else if(resulet1==13){score+=37.5;}else if(resulet1==14){score+=47.5;}else if(resulet1==15){score+=55.0;}else if(resulet1==16){score+=62.5;}else if(resulet1==17){score+=72.5;
				}else if(resulet1==18){score+=80.0;}else if(resulet1==19){score+=85.0;}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.0;}
			
				 if(resulet1<=23.9  )score+=10.0;else if(resulet1<=28.7 &&resulet1>23.9 )score+=30.0;
				else if(resulet1<=30 &&resulet1>28.7 )score+=50.0;else if(resulet1<=38.4 &&resulet1>30 )score+=70.0;else if( resulet1>38.4 )score+=90.0;
				
			} else if (age >= 75 && age <= 79) {
				if(resulet1==7){score+=5.0;}else if(resulet1==8){score+=10.0;}else if(resulet1==9){score+=12.5;
				}else if(resulet1==10){score+=17.5;}else if(resulet1==11){score+=25.0;}else if(resulet1==12){score+=32.5;}else if(resulet1==13){score+=42.5;
				}else if(resulet1==14){score+=50.0;}else if(resulet1==15){score+=57.5;}else if(resulet1==16){score+=67.5;}else if(resulet1==17){score+=75.0;
				}else if(resulet1==18){score+=82.5;}else if(resulet1==19){score+=87.5;}else if(resulet1==20){score+=90.0;}else if(resulet1==21){score+=95.5;}
			
				if(resulet1<=19.2  )score+=10.0;else if(resulet1<=24.8 &&resulet1>19.2 )score+=30.0;
				else if(resulet1<=25.8 &&resulet1>24.8 )score+=50.0;else if(resulet1<=33.7 &&resulet1>25.8 )score+=70.0;else if( resulet1>33.7 )score+=90.0;
					
			} else if (age >= 80 && age <= 84) {
				if(resulet1<=6){score+=5.0;}else if(resulet1==7){score+=10.0;
				}else if(resulet1==8){score+=15.0;}else if(resulet1==9){score+=20.0;}else if(resulet1==10){score+=27.5;}else if(resulet1==11){score+=37.5; }else if(resulet1==12){score+=47.5;}else if(resulet1==13){score+=57.5;}else if(resulet1==14){score+=67.5;}else if(resulet1==15){score+=75.0;
				}else if(resulet1==16){score+=82.5;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.5;}else if(resulet1==19){score+=95.0;}
			
				if(resulet1<=19.4  )score+=10.0;else if(resulet1<=23.2 &&resulet1>19.4 )score+=30.0;
				else if(resulet1<=24.2 &&resulet1>23.2 )score+=50.0;else if(resulet1<=30 &&resulet1>24.2 )score+=70.0;else if( resulet1>30 )score+=90.0;
			
			} else if (age >= 85 && age <= 89) {
				if(resulet1<=4){score+=5.0;}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=20.0;
				}else if(resulet1==8){score+=25.0;}else if(resulet1==9){score+=32.5;}else if(resulet1==10){score+=40.0;}else if(resulet1==11){score+=47.5;
				}else if(resulet1==12){score+=57.5;}else if(resulet1==13){score+=67.5;}else if(resulet1==14){score+=75.0;}else if(resulet1==15){score+=80.0;
				}else if(resulet1==16){score+=85.0;}else if(resulet1==17){score+=90.0;}else if(resulet1==18){score+=92.5;}else if(resulet1==17){score+=95.0;}
			
				if(resulet1<=18.3  )score+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )score+=30.0;
				else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=29 &&resulet1>21.1 )score+=70.0;else if( resulet1>29 )score+=90.0;
			
			} else if (age >= 90 && age <= 100) {
				if(resulet1<=3){score+=5.0;}else if(resulet1==4){score+=7.5;
				}else if(resulet1==5){score+=10.0;}else if(resulet1==6){score+=15.0;}else if(resulet1==7){score+=22.5;}else if(resulet1==8){score+=32.5;
				}else if(resulet1==9){score+=42.5;}else if(resulet1==10){score+=52.5;}else if(resulet1==11){score+=62.5;}else if(resulet1==12){score+=72.5;
				}else if(resulet1==13){score+=80.0;}else if(resulet1==14){score+=85.0;}else if(resulet1==15){score+=90.0;}else if(resulet1==16){score+=95.0;}
			
				if(resulet1<=18.3  )score+=10.0;else if(resulet1<=20.6 &&resulet1>18.3 )score+=30.0;
				else if(resulet1<=21.1 &&resulet1>20.6 )score+=50.0;else if(resulet1<=29 &&resulet1>21.1 )score+=70.0;else if( resulet1>29 )score+=90.0;
			
			}
			
		}
		return score;
	}	
	/**
	 * 体适能单项选择 分值获取
	 * @param v1
	 * @param calibrations
	 * @param resulet
	 * @return
	 */
	public static double getTSN(FitnessVO1 v1,int calibrations,double resulet){
		double score=0.0;
		if (v1.getSex() == 0&&calibrations==5) {// 女性
			if (v1.getAge() < 65) {
				if(resulet<=52)score+=5.0;else if(resulet<=60&&resulet>52)score+=10.0;else if(resulet<=66 &&resulet>60 )score+=15.0;else if(resulet<=71 &&resulet>66 )score+=20.0;
				else if(resulet<=75 &&resulet>71 )score+=25.0;else if(resulet<=79 &&resulet>75 )score+=30.0;else if(resulet<=82 &&resulet>79 )score+=35.0;else if(resulet<=85 &&resulet>82 )score+=40.0;
				else if(resulet<=88 &&resulet>85 )score+=45.0;else if(resulet<=91 &&resulet>88 )score+=50.0;else if(resulet<=94 &&resulet>91 )score+=55.0;else if(resulet<=97 &&resulet>94 )score+=60.0;
				else if(resulet<=100 &&resulet>97 )score+=65.0;else if(resulet<=103 &&resulet>100 )score+=70.0;else if(resulet<=107 &&resulet>103 )score+=75.0;else if(resulet<=111 &&resulet>107 )score+=80.0;
				else if(resulet<=116 &&resulet>111 )score+=85.0;else if(resulet<=122 &&resulet>116 )score+=90.0;else if(resulet>122 )score+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet<=47)score+=5.0;else if(resulet<=57 &&resulet>47 )score+=10.0;else if(resulet<=63 &&resulet>57 )score+=15.0;
				else if(resulet<=68 &&resulet>63 )score+=20.0;else if(resulet<=73 &&resulet>68 )score+=25.0;else if(resulet<=76 &&resulet>73 )score+=30.0;else if(resulet<=80 &&resulet>76 )score+=35.0;
				else if(resulet<=84 &&resulet>80 )score+=40.0;else if(resulet<=87 &&resulet>84 )score+=45.0;else if(resulet<=90 &&resulet>87 )score+=50.0;else if(resulet<=93 &&resulet>90 )score+=55.0;
				else if(resulet<=96 &&resulet>93 )score+=60.0;else if(resulet<=100 &&resulet>96 )score+=65.0;else if(resulet<=104 &&resulet>100 )score+=70.0;else if(resulet<=107 &&resulet>104 )score+=75.0;
				else if(resulet<=112 &&resulet>107 )score+=80.0;else if(resulet<=117 &&resulet>112 )score+=85.0;else if(resulet<=123 &&resulet>117 )score+=90.0;else if(resulet>123 )score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet<=43)score+=5.0;else if(resulet<=52 &&resulet>43 )score+=10.0;
				else if(resulet<=58 &&resulet>52 )score+=15.0;else if(resulet<=63 &&resulet>58 )score+=20.0;else if(resulet<=68 &&resulet>63 )score+=25.0;else if(resulet<=71 &&resulet>68 )score+=30.0;
				else if(resulet<=74 &&resulet>71 )score+=35.0;else if(resulet<=78 &&resulet>74 )score+=40.0;else if(resulet<=81 &&resulet>78 )score+=45.0;else if(resulet<=84 &&resulet>81 )score+=50.0;
				else if(resulet<=87 &&resulet>84 )score+=55.0;else if(resulet<=90 &&resulet>87 )score+=60.0;else if(resulet<=94 &&resulet>90 )score+=65.0;else if(resulet<=97 &&resulet>94 )score+=70.0;
				else if(resulet<=101 &&resulet>97 )score+=75.0;else if(resulet<=105 &&resulet>101 )score+=80.0;else if(resulet<=110 &&resulet>105 )score+=85.0;else if(resulet>116 )score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet<=45)score+=5.0;else if(resulet<=53 &&resulet>45 )score+=10.0;else if(resulet<=59 &&resulet>53 )score+=15.0;
				else if(resulet<=64 &&resulet>59 )score+=20.0;else if(resulet<=68 &&resulet>64 )score+=25.0;else if(resulet<=72 &&resulet>68 )score+=30.0;else if(resulet<=75 &&resulet>72 )score+=35.0;
				else if(resulet<=78 &&resulet>75 )score+=40.0;else if(resulet<=81 &&resulet>78 )score+=45.0;else if(resulet<=84 &&resulet>81 )score+=50.0;else if(resulet<=87 &&resulet>84 )score+=55.0;
				else if(resulet<=90 &&resulet>87 )score+=60.0;else if(resulet<=93 &&resulet>90 )score+=65.0;else if(resulet<=96 &&resulet>93 )score+=70.0;else if(resulet<=100 &&resulet>96 )score+=75.0;
				else if(resulet<=104 &&resulet>100 )score+=80.0;else if(resulet<=109 &&resulet>104 )score+=85.0;else if(resulet<=115 &&resulet>109 )score+=90.0;else if(resulet>115 )score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet<=37)score+=5.0;else if(resulet<=46 &&resulet>37 )score+=10.0;else if(resulet<=51 &&resulet>46 )score+=15.0;
				else if(resulet<=56 &&resulet>51 )score+=20.0;else if(resulet<=60 &&resulet>56 )score+=25.0;else if(resulet<=63 &&resulet>60  )score+=30.0;else if(resulet<=66 &&resulet>63  )score+=35.0;
				else if(resulet<=69 &&resulet>66  )score+=40.0;else if(resulet<=72 &&resulet>69  )score+=45.0;else if(resulet<=75 &&resulet>72  )score+=50.0;else if(resulet<=78 &&resulet>75  )score+=55.0;
				else if(resulet<=81 &&resulet>78  )score+=60.0;else if(resulet<=84 &&resulet>81  )score+=65.0;else if(resulet<=87 &&resulet>84  )score+=70.0;else if(resulet<=90 &&resulet>87  )score+=75.0;
				else if(resulet<=94 &&resulet>90  )score+=80.0;else if(resulet<=99 &&resulet>94  )score+=85.0;else if(resulet<=104 &&resulet>99 )score+=90.0;else if(resulet>104  )score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet<=39)score+=5.0;else if(resulet<=42 &&resulet>39 )score+=10.0;else if(resulet<=47 &&resulet>42 )score+=15.0;
				else if(resulet<=52 &&resulet>47 )score+=20.0;else if(resulet<=55 &&resulet>52 )score+=25.0;else if(resulet<=59 &&resulet>55 )score+=30.0;else if(resulet<=61 &&resulet>59 )score+=35.0;
				else if(resulet<=64 &&resulet>61 )score+=40.0;else if(resulet<=67 &&resulet>64 )score+=45.0;else if(resulet<=70 &&resulet>67 )score+=50.0;else if(resulet<=73 &&resulet>70 )score+=55.0;
				else if(resulet<=76 &&resulet>73 )score+=60.0;else if(resulet<=79 &&resulet>76 )score+=65.0;else if(resulet<=81 &&resulet>79 )score+=70.0;else if(resulet<=85 &&resulet>81 )score+=75.0;
				else if(resulet<=88 &&resulet>85 )score+=80.0;else if(resulet<=93 &&resulet>88 )score+=85.0;else if(resulet<=98 &&resulet>93 )score+=90.0;else if(resulet>98  )score+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet<=24)score+=5.0;else if(resulet<=31 &&resulet>24 )score+=10.0;else if(resulet<=36 &&resulet>31 )score+=15.0;
				else if(resulet<=40 &&resulet>36 )score+=20.0;else if(resulet<=44 &&resulet>40 )score+=25.0;else if(resulet<=47 &&resulet>44 )score+=30.0;else if(resulet<=50 &&resulet>47 )score+=35.0;
				else if(resulet<=53 &&resulet>50 )score+=40.0;else if(resulet<=55 &&resulet>53 )score+=45.0;else if(resulet<=58 &&resulet>55 )score+=50.0;else if(resulet<=61 &&resulet>58 )score+=55.0;
				else if(resulet<=63 &&resulet>61 )score+=60.0;else if(resulet<=66 &&resulet>63 )score+=65.0;else if(resulet<=69 &&resulet>66 )score+=70.0;else if(resulet<=72 &&resulet>69 )score+=75.0;
				else if(resulet<=76 &&resulet>72 )score+=80.0;else if(resulet<=80 &&resulet>76 )score+=85.0;else if(resulet<=85 &&resulet>80 )score+=90.0;else if(resulet>85  )score+=95.0;
			}
		}
		if (v1.getSex() == 0&&calibrations==6) {// 女性
			if (v1.getAge() < 65) {
				if(resulet >=-6.4 &&resulet<-5.2 ) score+=5.0;else if(resulet >=-5.2 &&resulet<-4.3 )  score+=10.0;else if(resulet >= -4.3 &&resulet<-3.6 ) score+=15.0;
				else if(resulet >=-3.6  &&resulet<-3 ) score+=20.0;else if(resulet >= -3 &&resulet<-2.5 ) score+=25.0;else if(resulet >=-2.5  &&resulet<-2.1 ) score+=30.0;else if(resulet >= -2.1 &&resulet< -1.6) score+=35.0;
				else if(resulet >= -1.6 &&resulet<-1.2 ) score+=40.0;else if(resulet >= -1.2 &&resulet<-0.7 ) score+=45.0;else if(resulet >= -0.7 &&resulet<-0.2 ) score+=50.0;else if(resulet >= -0.2 &&resulet<0.2 ) score+=55.0;
				else if(resulet >= 0.2 &&resulet< 0.7) score+=60.0;else if(resulet >= 0.7 &&resulet< 1.1) score+=65.0;else if(resulet >= 1.1 &&resulet< 1.6) score+=70.0;else if(resulet >= 1.6 &&resulet<2.2 ) score+=75.0;
				else if(resulet >= 2.2 &&resulet<2.9 ) score+=80.0;else if(resulet >= 2.9 &&resulet<3.8 ) score+=85.0;else if(resulet >= 3.8 &&resulet<5 ) score+=90.0;else if(resulet >=  5 ) score+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet >=-7.3 &&resulet<-5.9 ) score+=5.0;else if(resulet >=-5.9 &&resulet< -5)  score+=10.0;else if(resulet >= -5 &&resulet< -4.3) score+=15.0;
				else if(resulet >= -4.3 &&resulet< -3.7) score+=20.0;else if(resulet >= -3.7 &&resulet< -3.1) score+=25.0;else if(resulet >= -3.1 &&resulet< -2.6) score+=30.0;else if(resulet >= -2.6 &&resulet< -2.1) score+=35.0;
				else if(resulet >= -2.1 &&resulet< -1.7) score+=40.0;else if(resulet >= -1.7 &&resulet< -1.2) score+=45.0;else if(resulet >= -1.2 &&resulet<-0.7 ) score+=50.0;else if(resulet >= -0.7 &&resulet<-0.3 ) score+=55.0;
				else if(resulet >= -0.3 &&resulet< 0.2) score+=60.0;else if(resulet >= 0.2 &&resulet<0.7 ) score+=65.0;else if(resulet >= 0.7 &&resulet<1.3 ) score+=70.0;else if(resulet >= 1.3 &&resulet<1.9 ) score+=75.0;
				else if(resulet >= 1.9 &&resulet<2.6 ) score+=80.0;else if(resulet >= 2.6 &&resulet<3.5 ) score+=85.0;else if(resulet >= 3.5 &&resulet<4.9 ) score+=90.0;else if(resulet >= 4.9  ) score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet<=43)score+=5.0;else if(resulet<=52 &&resulet>43 )score+=10.0;
				if(resulet >=-7.9 &&resulet<-6.6 ) score+=5.0;else if(resulet >=-6.6 &&resulet<-5.7 )  score+=10.0;else if(resulet >=-5.7  &&resulet<-4.9 ) score+=15.0;
				else if(resulet >=-4.9  &&resulet<-4.2 ) score+=20.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=25.0;else if(resulet >=-3.7  &&resulet<-3.2 ) score+=30.0;else if(resulet >=-3.2  &&resulet<-2.6 ) score+=35.0;
				else if(resulet >=-2.6  &&resulet<-2.2 ) score+=40.0;else if(resulet >=-2.2  &&resulet<-1.7 ) score+=45.0;else if(resulet >=-1.7  &&resulet<-1.2 ) score+=50.0;else if(resulet >=-1.2  &&resulet<-0.8 ) score+=55.0;
				else if(resulet >=-0.8  &&resulet<-0.2 ) score+=60.0;else if(resulet >=-0.2  &&resulet<0.3 ) score+=65.0;else if(resulet >=0.3  &&resulet<0.8 ) score+=70.0;else if(resulet >=0.8  &&resulet<1.5 ) score+=75.0;
				else if(resulet >=1.5  &&resulet<2.3 ) score+=80.0;else if(resulet >=2.3  &&resulet< 3.2) score+=85.0;else if(resulet >=3.2  &&resulet<4.5 ) score+=90.0;else if(resulet >= 4.5  ) score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet<=8.9  &&resulet>8.3 ) score+=5.0;else if(resulet<=8.3  &&resulet>8 ) score+=10.0;else if(resulet<=8  &&resulet>7.6 ) score+=15.0;else if(resulet<=7.6  &&resulet>7.4 ) score+=20.0;
				else if(resulet<=7.4  &&resulet>7.1 ) score+=25.0;else if(resulet<=7.1  &&resulet>6.9 ) score+=30.0;else if(resulet<=6.9  &&resulet>6.7 ) score+=35.0;
				else if(resulet<=6.7  &&resulet>6.5 ) score+=40.0;else if(resulet<=6.5  &&resulet>6.3 ) score+=45.0;else if(resulet<=6.3  &&resulet>6.1 ) score+=50.0;else if(resulet<=6.1  &&resulet>5.9 ) score+=55.0;
				else if(resulet<=5.9  &&resulet>5.7 ) score+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) score+=70.0;else if(resulet<=5.2  &&resulet>5 ) score+=75.0;
				else if(resulet<=5  &&resulet>4.6 ) score+=80.0;else if(resulet<=4.6  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet >=-9.5 &&resulet<-8 ) score+=5.0;else if(resulet >=-8 &&resulet<-7 )  score+=10.0;else if(resulet >=-7  &&resulet<-6.1 ) score+=15.0;
				else if(resulet >=-6.1  &&resulet<-5.4 ) score+=20.0;else if(resulet >=-5.4  &&resulet<-4.8 ) score+=25.0;else if(resulet >=-4.8  &&resulet<-4.2 ) score+=30.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=35.0;
				else if(resulet >=-3.7  &&resulet<-3.1 ) score+=40.0;else if(resulet >=-3.1  &&resulet<-2.6 ) score+=45.0;else if(resulet >=-2.6  &&resulet<-2.1 ) score+=50.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=55.0;
				else if(resulet >=-1.6 &&resulet< -1) score+=60.0;else if(resulet >=  -1&&resulet<-0.4) score+=65.0;else if(resulet >=  -0.4 &&resulet<  0.2 ) score+=70.0;else if(resulet >= 0.2 &&resulet< 0.9 ) score+=75.0;
				else if(resulet >= 0.9 &&resulet<1.8 ) score+=80.0;else if(resulet >=  2.8&&resulet<2.8 ) score+=85.0;else if(resulet >= 2.8  &&resulet<4.3 ) score+=90.0;else if(resulet >= 4.3  ) score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet >=-11.3 &&resulet<-9.7 ) score+=5.0;else if(resulet >=-9.7 &&resulet<-8.6 )  score+=10.0;else if(resulet >=-8.6  &&resulet<-7.7 ) score+=15.0;
				else if(resulet >=-7.7  &&resulet<-6.9 ) score+=20.0;else if(resulet >=-6.9  &&resulet<-6.2 ) score+=25.0;else if(resulet >=-6.2  &&resulet<-5.7 ) score+=30.0;else if(resulet >=-5.7  &&resulet<-5 ) score+=35.0;
				else if(resulet >=-5  &&resulet<-4.5 ) score+=40.0;else if(resulet >=-4.5  &&resulet<-3.9 ) score+=45.0;else if(resulet >=-3.9  &&resulet<-3.3 ) score+=50.0;else if(resulet >=-3.3  &&resulet<-2.8 ) score+=55.0;
				else if(resulet >=-2.8  &&resulet<-2.1 ) score+=60.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=65.0;else if(resulet >=-1.6  &&resulet<-0.9 ) score+=70.0;else if(resulet >=-0.9  &&resulet<-0.1 ) score+=75.0;
				else if(resulet >=-0.1  &&resulet<1.8 ) score+=80.0;else if(resulet >=1.8  &&resulet<1.9 ) score+=85.0;else if(resulet >= 1.9 &&resulet<3.5 ) score+=90.0;else if(resulet >= 3.5  ) score+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet >=-13 &&resulet<-11.2 ) score+=5.0;else if(resulet >=-11.2 &&resulet<-9.9 )  score+=10.0;else if(resulet >=-9.9  &&resulet<-8.9 ) score+=15.0;
				else if(resulet >=-8.9  &&resulet<-8 ) score+=20.0;else if(resulet >=-8  &&resulet<-7.2 ) score+=25.0;else if(resulet >= -7.2 &&resulet<-6.5 ) score+=30.0;else if(resulet >= -6.5 &&resulet<-5.8 ) score+=35.0;
				else if(resulet >= -5.8 &&resulet<-5.2 ) score+=40.0;else if(resulet >=-5.2  &&resulet<-4.5 ) score+=45.0;else if(resulet >=-4.5  &&resulet<-3.8 ) score+=50.0;else if(resulet >= -3.8 &&resulet<-3.2 ) score+=55.0;
				else if(resulet >= -3.2 &&resulet<-2.5 ) score+=60.0;else if(resulet >=-2.5  &&resulet<-1.8 ) score+=65.0;else if(resulet >=-1.8  &&resulet<-1 ) score+=70.0;else if(resulet >=-1  &&resulet<-0.1 ) score+=75.0;
				else if(resulet >=-0.1  &&resulet<0.9 ) score+=80.0;else if(resulet >=0.9  &&resulet<2.2 ) score+=85.0;else if(resulet >=2.2  &&resulet<3.9 ) score+=90.0;else if(resulet >=3.9   ) score+=95.0;
			}
		}
		if (v1.getSex() == 0&&calibrations==7) {// 女性
			if (v1.getAge() < 65) {
				
				 if(resulet<=7.2  &&resulet>6.7 ) score+=5.0;else if(resulet<=6.7  &&resulet>6.4 ) score+=10.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=15.0;
				else if(resulet<=6.2  &&resulet>6 ) score+=20.0;else if(resulet<=6  &&resulet>5.8 ) score+=25.0;else if(resulet<=5.8  &&resulet>5.7 ) score+=30.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=35.0;
				else if(resulet<=5.5  &&resulet>5.4 ) score+=40.0;else if(resulet<=5.4  &&resulet>5.2 ) score+=45.0;else if(resulet<=5.2  &&resulet>5 ) score+=50.0;else if(resulet<=5  &&resulet>4.9 ) score+=55.0;
				else if(resulet<=4.9  &&resulet>4.7 ) score+=60.0;else if(resulet<=4.7  &&resulet>4.6 ) score+=65.0;else if(resulet<=4.6  &&resulet>4.4 ) score+=70.0;else if(resulet<=4.4  &&resulet>4.2 ) score+=75.0;
				else if(resulet<=4.2  &&resulet>4 ) score+=80.0;else if(resulet<=4  &&resulet>3.7 ) score+=85.0;else if(resulet<=3.7  &&resulet>3.2 ) score+=90.0;else if(resulet<=3.2   ) score+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet<=7.6  &&resulet>7.1 ) score+=5.0;else if(resulet<=7.1  &&resulet>6.8 ) score+=10.0;else if(resulet<=6.8  &&resulet>6.6 ) score+=15.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=20.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=25.0;else if(resulet<=6.2  &&resulet>6.1 ) score+=30.0;else if(resulet<=6.1 &&resulet>5.9 ) score+=35.0;
				else if(resulet<=5.9  &&resulet>5.8 ) score+=40.0;else if(resulet<=5.8  &&resulet>5.6 ) score+=45.0;else if(resulet<=5.6  &&resulet>5.4 ) score+=50.0;else if(resulet<=5.4  &&resulet>5.3 ) score+=55.0;
				else if(resulet<=5.3  &&resulet>5.1 ) score+=60.0;else if(resulet<=5.1  &&resulet>5 ) score+=65.0;else if(resulet<=5  &&resulet>4.8 ) score+=70.0;else if(resulet<=4.8  &&resulet>4.6 ) score+=75.0;
				else if(resulet<=4.6  &&resulet>4.4 ) score+=80.0;else if(resulet<=4.4  &&resulet>4.1 ) score+=85.0;else if(resulet<=4.1  &&resulet>3.6 ) score+=90.0;else if(resulet<=3.6) score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet<=8.6  &&resulet>8 ) score+=5.0;else if(resulet<=8  &&resulet>7.7 ) score+=10.0;else if(resulet<=7.7  &&resulet>7.3 ) score+=15.0;
				else if(resulet<=7.3  &&resulet>7.1 ) score+=20.0;else if(resulet<=7.1  &&resulet>6.8 ) score+=25.0;else if(resulet<=6.8  &&resulet>6.6 ) score+=30.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=35.0;
				else if(resulet<=6.4  &&resulet>6.2 ) score+=40.0;else if(resulet<=6.2  &&resulet>6 ) score+=45.0;else if(resulet<=6  &&resulet>5.8 ) score+=50.0;else if(resulet<=5.8  &&resulet>5.6 ) score+=55.0;
				else if(resulet<=5.6  &&resulet>5.4 ) score+=60.0;else if(resulet<=5.4  &&resulet>5.2 ) score+=65.0;else if(resulet<=5.2  &&resulet>4.9 ) score+=70.0;else if(resulet<=4.9  &&resulet>4.7 ) score+=75.0;
				else if(resulet<=4.7  &&resulet>4.3 ) score+=80.0;else if(resulet<=4.3  &&resulet>4 ) score+=85.0;else if(resulet<=4  &&resulet>3.8 ) score+=90.0;else if(resulet<= 3.8  ) score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet >=-8.8 &&resulet<-7.3 ) score+=5.0;else if(resulet >=-7.3 &&resulet<-6.4 )  score+=10.0;else if(resulet >=-6.4  &&resulet<-5.5 ) score+=15.0;
				else if(resulet >=-5.5  &&resulet<-4.8 ) score+=20.0;else if(resulet >=-4.8  &&resulet<-4.2 ) score+=25.0;else if(resulet >=-4.2  &&resulet<-3.7 ) score+=30.0;else if(resulet >=-3.7  &&resulet<-3.1 ) score+=35.0;
				else if(resulet >=-3.1  &&resulet<-2.6 ) score+=40.0;else if(resulet >=-2.6  &&resulet<-2.1 ) score+=45.0;else if(resulet >=-2.1  &&resulet<-1.6 ) score+=50.0;else if(resulet >=-1.6  &&resulet<-1.1 ) score+=55.0;
				else if(resulet >=-1.1 &&resulet<-0.5 ) score+=60.0;else if(resulet >=-0.5  &&resulet<0 ) score+=65.0;else if(resulet >=0  &&resulet<0.6 ) score+=70.0;else if(resulet >=0.6  &&resulet<1.3 ) score+=75.0;
				else if(resulet >=1.3  &&resulet<2.2 ) score+=80.0;else if(resulet >=2.2  &&resulet<3.1 ) score+=85.0;else if(resulet >=3.1  &&resulet<4.5 ) score+=90.0;else if(resulet >= 4.5  ) score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet<=10.8  &&resulet> 10) score+=5.0;else if(resulet<=10  &&resulet>9.5 ) score+=10.0;else if(resulet<=9.5  &&resulet>9 ) score+=15.0;
				else if(resulet<=9  &&resulet>8.7 ) score+=20.0;else if(resulet<=8.7  &&resulet>8.3 ) score+=25.0;else if(resulet<=8.3  &&resulet>8.1 ) score+=30.0;else if(resulet<=8.1  &&resulet>7.8 ) score+=35.0;
				else if(resulet<=7.8  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.7 ) score+=55.0;
				else if(resulet<=6.7  &&resulet>6.3 ) score+=60.0;else if(resulet<=6.3  &&resulet>6.1 ) score+=65.0;else if(resulet<=6.1  &&resulet>5.7 ) score+=70.0;else if(resulet<=5.7 &&resulet>5.4 ) score+=75.0;
				else if(resulet<=5.4  &&resulet>4.9 ) score+=80.0;else if(resulet<=4.9  &&resulet>4.4 ) score+=85.0;else if(resulet<=4.4  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet<=12  &&resulet>11.1 ) score+=5.0;else if(resulet<=11.1  &&resulet>10.5 ) score+=10.0;else if(resulet<=10.5  &&resulet>10 ) score+=15.0;
				else if(resulet<=10  &&resulet>9.6 ) score+=20.0;else if(resulet<=9.6  &&resulet>9.2 ) score+=25.0;else if(resulet<=9.2  &&resulet>8.9 ) score+=30.0;else if(resulet<=8.9  &&resulet>8.5 ) score+=35.0;
				else if(resulet<=8.5  &&resulet>8.2 ) score+=40.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=45.0;else if(resulet<=7.9  &&resulet>7.6 ) score+=50.0;else if(resulet<=7.6  &&resulet>7.3 ) score+=55.0;
				else if(resulet<=7.3  &&resulet>6.9 ) score+=60.0;else if(resulet<=6.9  &&resulet>6.6 ) score+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) score+=70.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=75.0;
				else if(resulet<=5.8  &&resulet>5.3 ) score+=80.0;else if(resulet<=5.3  &&resulet>4.7 ) score+=85.0;else if(resulet<=4.7  &&resulet>4.5 ) score+=90.0;else if(resulet<=4.5   ) score+=95.0;
			} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
				if(resulet<=14.6  &&resulet>13.5 ) score+=5.0;else if(resulet<=13.5  &&resulet>12.7 ) score+=10.0;else if(resulet<=12.7  &&resulet>12.1 ) score+=15.0;
				else if(resulet<=12.1  &&resulet>11.5 ) score+=20.0;else if(resulet<=11.5  &&resulet>11.1 ) score+=25.0;else if(resulet<=11.1  &&resulet>10.6 ) score+=30.0;else if(resulet<=10.6  &&resulet>10.2) score+=35.0;
				else if(resulet<=10.2  &&resulet>9.8 ) score+=40.0;else if(resulet<=9.8  &&resulet>9.4 ) score+=45.0;else if(resulet<=9.4  &&resulet>9 ) score+=50.0;else if(resulet<=9  &&resulet>8.6 ) score+=55.0;
				else if(resulet<=8.6  &&resulet>8.2 ) score+=60.0;else if(resulet<=8.2  &&resulet>7.7 ) score+=65.0;else if(resulet<=7.7  &&resulet>7.3 ) score+=70.0;else if(resulet<=7.3  &&resulet>6.7 ) score+=75.0;
				else if(resulet<= 6.7 &&resulet>6.1 ) score+=80.0;else if(resulet<=6.1  &&resulet>5.3 ) score+=85.0;else if(resulet<=5.3 &&resulet>5 ) score+=90.0;else if(resulet<= 5  ) score+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==5) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet<=67)score+=5.0;else if(resulet<=74 &&resulet>67 )score+=10.0;else if(resulet<=79 &&resulet>74 )score+=15.0;
				else if(resulet<=83 &&resulet>79 )score+=20.0;else if(resulet<=87 &&resulet>83 )score+=25.0;else if(resulet<=90 &&resulet>87 )score+=30.0;else if(resulet<=93 &&resulet>90 )score+=35.0;
				else if(resulet<=96 &&resulet>93)score+=40.0;else if(resulet<=98 &&resulet>96 )score+=45.0;else if(resulet<=101 &&resulet>98 )score+=50.0;else if(resulet<=104 &&resulet>101 )score+=55.0;
				else if(resulet<=106 &&resulet>104 )score+=60.0;else if(resulet<=109 &&resulet>106 )score+=65.0;else if(resulet<=112 &&resulet>109 )score+=70.0;else if(resulet<=115 &&resulet>112 )score+=75.0;
				else if(resulet<=119 &&resulet>115 )score+=80.0;else if(resulet<=123 &&resulet>119 )score+=85.0;else if(resulet<=128 &&resulet>123 )score+=90.0;else if(resulet>128  )score+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet<=67)score+=5.0;else if(resulet<=72 &&resulet>67 )score+=10.0;else if(resulet<=77 &&resulet>72 )score+=15.0;
				else if(resulet<=82 &&resulet>77 )score+=20.0;else if(resulet<=86 &&resulet>82 )score+=25.0;	else if(resulet<=89 &&resulet>86 )score+=30.0;else if(resulet<=92 &&resulet>89 )score+=35.0;
				else if(resulet<=95 &&resulet>92 )score+=40.0;else if(resulet<=98 &&resulet>95 )score+=45.0;else if(resulet<=101 &&resulet>98 )score+=50.0;else if(resulet<=104 &&resulet>101 )score+=55.0;
				else if(resulet<=107 &&resulet>104 )score+=60.0;else if(resulet<=110 &&resulet>107 )score+=65.0;else if(resulet<=113 &&resulet>110 )score+=70.0;else if(resulet<=116 &&resulet>113 )score+=75.0;
				else if(resulet<=120 &&resulet>116 )score+=80.0;else if(resulet<=125 &&resulet>120 )score+=85.0;else if(resulet<=130 &&resulet>125 )score+=90.0;else if(resulet>130  )score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet<=67)score+=5.0;else if(resulet<=66 &&resulet>67 )score+=10.0;
				else if(resulet<=71 &&resulet>66 )score+=15.0;else if(resulet<=76 &&resulet>71 )score+=20.0;else if(resulet<=80 &&resulet>76 )score+=25.0;else if(resulet<=83 &&resulet>80 )score+=30.0;else if(resulet<=86 &&resulet>83 )score+=35.0;
				else if(resulet<=89 &&resulet>86 )score+=40.0;else if(resulet<=92 &&resulet>89 )score+=45.0;else if(resulet<=95 &&resulet>92 )score+=50.0;else if(resulet<=98 &&resulet>95 )score+=55.0;
				else if(resulet<=101 &&resulet>98 )score+=60.0;else if(resulet<=104 &&resulet>101 )score+=65.0;else if(resulet<=107 &&resulet>104 )score+=70.0;else if(resulet<=110 &&resulet>107 )score+=75.0;
				else if(resulet<=114 &&resulet>110 )score+=80.0;else if(resulet<=119 &&resulet>114 )score+=85.0;else if(resulet<=124 &&resulet>119 )score+=90.0;else if(resulet>124  )score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet<=47)score+=5.0;else if(resulet<=56 &&resulet>47 )score+=10.0;else if(resulet<=63 &&resulet>56 )score+=15.0;
				else if(resulet<=68 &&resulet>63 )score+=20.0;else if(resulet<=73 &&resulet>68 )score+=25.0;else if(resulet<=77 &&resulet>73 )score+=30.0;else if(resulet<=80 &&resulet>77 )score+=35.0;
				else if(resulet<=84 &&resulet>80 )score+=40.0;else if(resulet<=87 &&resulet>84 )score+=45.0;else if(resulet<=91 &&resulet>87 )score+=50.0;else if(resulet<=95 &&resulet>91 )score+=55.0;
				else if(resulet<=98 &&resulet>95 )score+=60.0;else if(resulet<=102 &&resulet>98 )score+=65.0;else if(resulet<=105 &&resulet>102 )score+=70.0;else if(resulet<=109 &&resulet>105 )score+=75.0;
				else if(resulet<=114 &&resulet>109 )score+=80.0;else if(resulet<=119 &&resulet>114 )score+=85.0;else if(resulet<=126 &&resulet>119 )score+=90.0;else if(resulet>126  )score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet<=48)score+=5.0;else if(resulet<=56 &&resulet>48 )score+=10.0;else if(resulet<=62 &&resulet>56 )score+=15.0;else if(resulet<=67 &&resulet>62 )score+=20.0;else if(resulet<=71 &&resulet>67 )score+=25.0;else if(resulet<=75 &&resulet>71 )score+=30.0;
				else if(resulet<=78 &&resulet>75 )score+=35.0;else if(resulet<=81 &&resulet>78 )score+=40.0;else if(resulet<=84 &&resulet>81 )score+=45.0;else if(resulet<=87 &&resulet>84 )score+=50.0;else if(resulet<=90 &&resulet>87 )score+=55.0;
				else if(resulet<=93 &&resulet>90 )score+=60.0;else if(resulet<=96 &&resulet>93 )score+=65.0;else if(resulet<=99 &&resulet>96 )score+=70.0;else if(resulet<=103 &&resulet>99 )score+=75.0;
				else if(resulet<=107 &&resulet>103 )score+=80.0;else if(resulet<=112 &&resulet>107 )score+=85.0;else if(resulet<=118 &&resulet>112 )score+=90.0;else if(resulet>118  )score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet<=36)score+=5.0;else if(resulet<=44 &&resulet>36 )score+=10.0;else if(resulet<=50 &&resulet>44 )score+=15.0;else if(resulet<=55 &&resulet>50 )score+=20.0;
				else if(resulet<=59 &&resulet>55 )score+=25.0;else if(resulet<=63 &&resulet>59 )score+=30.0;else if(resulet<=66 &&resulet>63 )score+=35.0;else if(resulet<=69 &&resulet>66 )score+=40.0;else if(resulet<=72 &&resulet>69 )score+=45.0;
				else if(resulet<=75 &&resulet>72 )score+=50.0;else if(resulet<=78 &&resulet>75 )score+=55.0;else if(resulet<=81 &&resulet>78 )score+=60.0;else if(resulet<=84 &&resulet>81 )score+=65.0;else if(resulet<=87 &&resulet>84 )score+=70.0;
				else if(resulet<=91 &&resulet>87 )score+=75.0;else if(resulet<=95 &&resulet>91 )score+=80.0;else if(resulet<=100 &&resulet>95 )score+=85.0;else if(resulet<=106 &&resulet>100 )score+=90.0;else if(resulet>106  )score+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet<=26)score+=5.0;else if(resulet<=36 &&resulet>26 )score+=10.0;else if(resulet<=42 &&resulet>36 )score+=15.0;else if(resulet<=47 &&resulet>42 )score+=20.0;
				else if(resulet<=52 &&resulet>47 )score+=25.0;else if(resulet<=55 &&resulet>52 )score+=30.0;else if(resulet<=59 &&resulet>55 )score+=35.0;else if(resulet<=62 &&resulet>59 )score+=40.0;else if(resulet<=66 &&resulet>62 )score+=45.0;
				else if(resulet<=69 &&resulet>66 )score+=50.0;else if(resulet<=72 &&resulet>69 )score+=55.0;else if(resulet<=76 &&resulet>72 )score+=60.0;else if(resulet<=79 &&resulet>76 )score+=65.0;else if(resulet<=83 &&resulet>79 )score+=70.0;
				else if(resulet<=86 &&resulet>83 )score+=75.0;else if(resulet<=91 &&resulet>86 )score+=80.0;else if(resulet<=96 &&resulet>91 )score+=85.0;else if(resulet<=102 &&resulet>96 )score+=90.0;else if(resulet>102  )score+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==6) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet >=-11.3    && resulet<-9.5) score+=5.0;else if(resulet >=-9.5 && resulet<-8.4)  score+=10.0;else if(resulet >=-8.4 && resulet<-7.4) score+=15.0;
				else if(resulet >=-7.4 && resulet<-6.6) score+=20.0;else if(resulet >=-6.6 && resulet<-5.9) score+=25.0;else if(resulet >=-5.9 && resulet<-5.3) score+=30.0;else if(resulet >=-5.3 && resulet<-4.6) score+=35.0;
				else if(resulet >=-4.6 && resulet<-4  ) score+=40.0;else if(resulet >=-4   && resulet<-3.4) score+=45.0;else if(resulet >=-3.4 && resulet<-2.8) score+=50.0;else if(resulet >=-2.8 && resulet<-2.2) score+=55.0;
				else if(resulet >=-2.2 && resulet<-1.5) score+=60.0;else if(resulet >=-1.5 && resulet<-0.9) score+=65.0;else if(resulet >=-0.9 && resulet<-0.2) score+=70.0;else if(resulet >=-0.2 && resulet< 0.6) score+=75.0;
				else if(resulet >=0.6  && resulet< 1.6) score+=80.0;else if(resulet >=1.6  && resulet< 2.7) score+=85.0;else if(resulet >=2.7  && resulet< 4.5) score+=85.0;else if(resulet >4.5 ) score+=95.0;
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet>=-12.1&&resulet<-10.4 ) score+=5.0;else if(resulet>=-10.4 &&resulet<-9.2 )  score+=10.0;else if(resulet>=-9.2  &&resulet<-8.2 ) score+=15.0;
				else if(resulet>=-8.2  &&resulet<-7.4 ) score+=20.0;else if(resulet>=-7.4 &&resulet<-6.6 ) score+=25.0;else if(resulet>=-6.6  &&resulet<-6 ) score+=30.0;else if(resulet>= -6 &&resulet<-5.3 ) score+=35.0;
				else if(resulet>=-5.3  &&resulet<-4.7 ) score+=40.0;else if(resulet>=-4.7  &&resulet<-4.1 ) score+=45.0;else if(resulet>=-4.1  &&resulet<-3.5 ) score+=50.0;else if(resulet>=-3.5  &&resulet<-2.9 ) score+=55.0;
				else if(resulet>=-2.9  &&resulet<-2.2 ) score+=60.0;else if(resulet>=-2.2  &&resulet<-1.6 ) score+=65.0;else if(resulet>=-1.6  &&resulet<-0.8 ) score+=70.0;else if(resulet>=-0.8  &&resulet<0 ) score+=75.0;
				else if(resulet>=0  &&resulet<1)score+=80.0;else if(resulet>=1  &&resulet<2.2)score+=85.0;else if(resulet>=2.2  &&resulet<3.9)score+=90.0;else if(resulet>= 3.9  ) score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				if(resulet >=-12.5 &&resulet<-10.8 ) score+=5.0;else if(resulet >=-10.8 &&resulet<-9.6 )  score+=10.0;
				else if(resulet >=-9.6  &&resulet<-8.6 ) score+=15.0;else if(resulet >=-8.6 &&resulet<-7.8 ) score+=20.0;else if(resulet >=-7.8  &&resulet<-7 ) score+=25.0;else if(resulet >=-7 &&resulet<-6.4 ) score+=30.0;
				else if(resulet >-6.4 &&resulet<-5.7 ) score+=35.0;else if(resulet >=-5.7  &&resulet<-5.1 ) score+=40.0;else if(resulet >=-5.1  &&resulet<-4.5 ) score+=45.0;else if(resulet >=-4.5  &&resulet<-3.9 ) score+=50.0;
				else if(resulet >=-3.9  &&resulet<-3.3 ) score+=55.0;else if(resulet >=-3.3  &&resulet<-2.6 ) score+=60.0;else if(resulet >=-2.6 &&resulet< -2) score+=65.0;
				else if(resulet >= -2 &&resulet<-1.2 ) score+=70.0;else if(resulet >=-1.2  &&resulet<-0.4 ) score+=75.0;
				else if(resulet >=-0.4  &&resulet<0.6 ) score+=80.0;else if(resulet >= 0.6 &&resulet<1.8 ) score+=85.0;else if(resulet >=1.8  &&resulet<3.5 ) score+=90.0;else if(resulet >= 3.5  ) score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet >=-14 &&resulet<-12.1 ) score+=5.0;else if(resulet >=-12.1 &&resulet<-10.9 )  score+=10.0;else if(resulet >= -10.9 &&resulet<-9.9 ) score+=15.0;
				else if(resulet >=-9.9  &&resulet<-9 ) score+=20.0;else if(resulet >=-9  &&resulet< -8.3) score+=25.0;else if(resulet >=-8.3  &&resulet<-7.6 ) score+=30.0;else if(resulet >= -7.6 &&resulet<-6.9 ) score+=35.0;
				else if(resulet >=-6.9  &&resulet<-6.3 ) score+=40.0;else if(resulet >=-6.3  &&resulet<-5.6 ) score+=45.0;else if(resulet >=-5.6  &&resulet<-4.9 ) score+=50.0;else if(resulet >=-4.9  &&resulet<-4.3 ) score+=55.0;
				else if(resulet >=-4.3  &&resulet< -3.6) score+=60.0;else if(resulet >= -3.6 &&resulet< -2.9) score+=65.0;else if(resulet >=-2.9  &&resulet< -2.2) score+=70.0;else if(resulet >= -2.2 &&resulet< -1.3) score+=75.0;
				else if(resulet >= -1.3 &&resulet<-0.3 ) score+=80.0;else if(resulet >= -0.3 &&resulet< 0.9) score+=85.0;else if(resulet >= 0.9 &&resulet<2.8 ) score+=90.0;else if(resulet >= 2.8  ) score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet >=-14.6 &&resulet<-12.6 ) score+=5.0;else if(resulet >=-12.6 &&resulet<-11.3 )  score+=10.0;else if(resulet >=-11.3  &&resulet<-10.2 ) score+=15.0;
				else if(resulet >= -10.2 &&resulet<-9.3 ) score+=20.0;else if(resulet >=-9.3  &&resulet<-8.5 ) score+=25.0;else if(resulet >=-8.5  &&resulet<-7.8 ) score+=30.0;else if(resulet >=-7.8  &&resulet<-7.1 ) score+=35.0;
				else if(resulet >=-7.1  &&resulet<-6.4 ) score+=40.0;else if(resulet >=-6.4  &&resulet<-5.7 ) score+=45.0;else if(resulet >=-5.7  &&resulet<-5 ) score+=50.0;else if(resulet >= -5 &&resulet<-4.3 ) score+=55.0;
				else if(resulet >= -4.3 &&resulet< -3.6) score+=60.0;else if(resulet >= -3.6 &&resulet<-2.9 ) score+=65.0;else if(resulet >= -2.9 &&resulet<-2.1 ) score+=70.0;else if(resulet >= -2.1 &&resulet<-1.2 ) score+=75.0;
				else if(resulet >= -1.2 &&resulet<-0.1 ) score+=80.0;else if(resulet >= -0.1  &&resulet< 1.2) score+=85.0;else if(resulet >= 1.2 &&resulet<3.2 ) score+=90.0;else if(resulet >= 3.2  ) score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet<=11.5  &&resulet>10.5 ) score+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) score+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) score+=15.0;
				else if(resulet<=9.4  &&resulet>8.9 ) score+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) score+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) score+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=35.0;
				else if(resulet<=7.9  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) score+=55.0;
				else if(resulet<=6.5  &&resulet>6.2 ) score+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) score+=70.0;else if(resulet<=5.5  &&resulet>5 ) score+=75.0;
				else if(resulet<=5  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet >=-15.1 &&resulet<-13.3 ) score+=5.0;else if(resulet >=-13.3 &&resulet<-12.2 )  score+=10.0;else if(resulet >= -12.2 &&resulet<-11.2 ) score+=15.0;
				else if(resulet >= -11.2 &&resulet<-10.4 ) score+=20.0;	else if(resulet >= -10.4 &&resulet<-9.7 ) score+=25.0;else if(resulet >= -9.7 &&resulet<-9.1 ) score+=30.0;else if(resulet >= -9.1 &&resulet<-8.4 ) score+=35.0;
				else if(resulet >= -8.4 &&resulet<-7.8 ) score+=40.0;else if(resulet >= -7.8 &&resulet<-7.2 ) score+=45.0;else if(resulet >= -7.2 &&resulet<-6.6 ) score+=50.0;else if(resulet >= -6.6 &&resulet<-6 ) score+=55.0;
				else if(resulet >= -6 &&resulet<-5.3 ) score+=60.0;else if(resulet >= -5.3 &&resulet<-4.7 ) score+=65.0;else if(resulet >= -4.7 &&resulet<-4 ) score+=70.0;else if(resulet >= -4 &&resulet<-3.2 ) score+=75.0;
				else if(resulet >= -3.2 &&resulet<-2.2 ) score+=80.0;else if(resulet >= -2.2 &&resulet<-1.1 ) score+=85.0;else if(resulet >=-1.1  &&resulet<0.7 ) score+=90.0;else if(resulet >=0.7   ) score+=95.0;
			}
		}
		if (v1.getSex() == 1&&calibrations==7) {// 男性
			if (v1.getAge() < 65) {	
				if(resulet <=6.8 &&resulet>6.4 ) score+=5.0;else if(resulet <=6.4 &&resulet>6.1  )  score+=10.0;
				else if(resulet <=6.1  &&resulet>5.8  ) score+=15.0;else if(resulet <=5.8  &&resulet>5.6 ) score+=20.0;else if(resulet >=5.6  &&resulet>5.4 ) score+=25.0;else if(resulet <=5.4  &&resulet>5.2 ) score+=30.0;
				else if(resulet <=5.2&&resulet>5.0 ) score+=35.0;else if(resulet <=5.0 &&resulet>4.9 ) score+=40.0;else if(resulet <=4.9  &&resulet>4.7 ) score+=45.0;else if(resulet <=4.7  &&resulet>4.5 ) score+=50.0;
				else if(resulet <=4.5 &&resulet>4.4) score+=55.0;else if(resulet <=4.4  &&resulet>4.2 ) score+=60.0;else if(resulet <=4.2  &&resulet>4.0) score+=65.0;else if(resulet <=4.0  &&resulet>3.8 ) score+=70.0;
				else if(resulet <=3.8  &&resulet>3.6 ) score+=75.0;else if(resulet <=3.6  &&resulet>3.3) score+=80.0;else if(resulet <=3.3  &&resulet>3) score+=85.0;else if(resulet <=3 ) score+=90.0;
			
			} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
				if(resulet <=7.1 &&resulet>6.6 ) score+=5.0;else if(resulet <=6.6  &&resulet> 6.3 )  score+=10.0;else if(resulet <=6.3  &&resulet>6.1  ) score+=15.0;
				else if(resulet <=6.1  &&resulet>5.9 ) score+=20.0;else if(resulet <=5.9  &&resulet>5.7 ) score+=25.0;else if(resulet <=5.7  &&resulet>5.6 ) score+=30.0;else if(resulet <=5.6  &&resulet>5.4 ) score+=35.0;
				else if(resulet <=5.4  &&resulet>5.3 ) score+=40.0;else if(resulet <=5.3 &&resulet>5.1 ) score+=45.0;else if(resulet <=5.1  &&resulet>4.9 ) score+=50.0;else if(resulet <= 4.9&&resulet>4.8) score+=55.0;
				else if(resulet <=4.8  &&resulet>4.6 ) score+=60.0;else if(resulet <=4.6  &&resulet>4.5) score+=65.0;else if(resulet <=4.5  &&resulet>4.3 ) score+=70.0;else if(resulet <=4.3  &&resulet>4.1 ) score+=75.0;
				else if(resulet <=4.1  &&resulet>3.9) score+=80.0;else if(resulet <=3.9  &&resulet>3.6) score+=85.0;else if(resulet <=3.6 &&resulet>3.1 ) score+=90.0;else if(resulet <=3.1   ) score+=95.0;
			} else if (v1.getAge() >=70 && v1.getAge() <= 74) {
				 if(resulet <=7.4 &&resulet>7 ) score+=5.0;else if(resulet <=7 &&resulet> 6.7 )  score+=10.0;else if(resulet <= 6.7 &&resulet> 6.4  ) score+=15.0;
				else if(resulet <= 6.4 &&resulet> 6.2 ) score+=20.0;else if(resulet <= 6.2 &&resulet>6 ) score+=25.0;else if(resulet <= 6 &&resulet>5.8 ) score+=30.0;else if(resulet <=5.8&&resulet>5.6 ) score+=35.0;
				else if(resulet <=5.6 &&resulet>5.5 ) score+=40.0;else if(resulet <=5.5  &&resulet>5.3 ) score+=45.0;else if(resulet <=5.3  &&resulet>5.1 ) score+=50.0;else if(resulet <=5.1 &&resulet>5 ) score+=55.0;
				else if(resulet <=5  &&resulet>4.8 ) score+=60.0;else if(resulet <=4.8  &&resulet>4.6) score+=65.0;else if(resulet <=4.6  &&resulet>4.4 ) score+=70.0;else if(resulet <=4.4  &&resulet>4.2 ) score+=75.0;
				else if(resulet <=4.2  &&resulet>3.9 ) score+=80.0;else if(resulet <=3.9  &&resulet>3.6) score+=85.0;else if(resulet <=3.6 &&resulet>3.2 ) score+=90.0;else if(resulet <=3.2   ) score+=95.0;
			} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
				if(resulet <=9 &&resulet<8.3 ) score+=5.0;else if(resulet <=8.3 &&resulet>7.9)  score+=10.0;else if(resulet <=7.9 &&resulet>7.5) score+=15.0;
				else if(resulet <=7.5 &&resulet>7.2) score+=20.0;else if(resulet <=7.2 &&resulet>6.9) score+=25.0;else if(resulet <=6.9 &&resulet>6.6) score+=30.0;else if(resulet <=6.6 &&resulet>6.4) score+=35.0;
				else if(resulet <=6.4 &&resulet>6.1) score+=40.0;else if(resulet <=6.1 &&resulet>5.9) score+=45.0;else if(resulet <=5.9 &&resulet>5.7) score+=50.0;else if(resulet <=5.7 &&resulet>5.4) score+=55.0;
				else if(resulet <=5.4 &&resulet>5.2) score+=60.0;else if(resulet <=5.2 &&resulet>4.9) score+=65.0;else if(resulet <=4.9  &&resulet>4.6) score+=70.0;else if(resulet <=4.6 &&resulet>4.3) score+=75.0;
				else if(resulet <=4.3  &&resulet>3.9) score+=80.0;else if(resulet <=3.9  &&resulet>3.5) score+=85.0;else if(resulet <=3.5 &&resulet>3.3) score+=90.0;else if(resulet <=3.3   ) score+=95.0;
			} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
				if(resulet<=9.4  &&resulet>8.7 ) score+=5.0;else if(resulet<=8.7  &&resulet>8.3 ) score+=10.0;else if(resulet<=8.3  &&resulet>7.9 ) score+=15.0;
				else if(resulet<=7.9  &&resulet>7.6 ) score+=20.0;else if(resulet<=7.6  &&resulet>7.3 ) score+=25.0;else if(resulet<=7.3  &&resulet>7.1 ) score+=30.0;else if(resulet<=7.1  &&resulet>6.9 ) score+=35.0;
				else if(resulet<=6.9  &&resulet>6.6 ) score+=40.0;else if(resulet<=6.6  &&resulet>6.4 ) score+=45.0;else if(resulet<=6.4  &&resulet>6.2 ) score+=50.0;else if(resulet<=6.2  &&resulet>6 ) score+=55.0;
				else if(resulet<=6    &&resulet>5.7 ) score+=60.0;else if(resulet<=5.7  &&resulet>5.5 ) score+=65.0;else if(resulet<=5.5  &&resulet>5.2 ) score+=70.0;else if(resulet<=5.2  &&resulet>4.9 ) score+=75.0;
				else if(resulet<=4.9  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.1 ) score+=85.0;else if(resulet<=4.1  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
			} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
				if(resulet<=11.5  &&resulet>10.5 ) score+=5.0;else if(resulet<=10.5  &&resulet>9.9 ) score+=10.0;else if(resulet<=9.9  &&resulet>9.4 ) score+=15.0;
				else if(resulet<=9.4  &&resulet>8.9 ) score+=20.0;else if(resulet<=8.9  &&resulet>8.6 ) score+=25.0;else if(resulet<=8.6  &&resulet>8.2 ) score+=30.0;else if(resulet<=8.2  &&resulet>7.9 ) score+=35.0;
				else if(resulet<=7.9  &&resulet>7.5 ) score+=40.0;else if(resulet<=7.5  &&resulet>7.2 ) score+=45.0;else if(resulet<=7.2  &&resulet>6.9 ) score+=50.0;else if(resulet<=6.9  &&resulet>6.5 ) score+=55.0;
				else if(resulet<=6.5  &&resulet>6.2 ) score+=60.0;else if(resulet<=6.2  &&resulet>5.8 ) score+=65.0;else if(resulet<=5.8  &&resulet>5.5 ) score+=70.0;else if(resulet<=5.5  &&resulet>5 ) score+=75.0;
				else if(resulet<=5  &&resulet>4.5 ) score+=80.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=85.0;else if(resulet<=4.3  &&resulet>4 ) score+=90.0;else if(resulet<=4   ) score+=95.0;
			} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
				if(resulet<=12.9  &&resulet>11.8 ) score+=5.0;else if(resulet<=11.8  &&resulet>11.1 ) score+=10.0;else if(resulet<=11.1  &&resulet>10.5 ) score+=15.0;
				else if(resulet<=10.5  &&resulet>10 ) score+=20.0;else if(resulet<=10  &&resulet>9.6 ) score+=25.0;else if(resulet<=9.6  &&resulet>9.2 ) score+=30.0;else if(resulet<=9.2  &&resulet>8.8 ) score+=35.0;
				else if(resulet<=8.8  &&resulet>8.5 ) score+=40.0;else if(resulet<=8.5  &&resulet>8.1 ) score+=45.0;else if(resulet<=8.1  &&resulet>7.7 ) score+=50.0;else if(resulet<=7.7  &&resulet>7.4 ) score+=55.0;
				else if(resulet<=7.4  &&resulet>7 ) score+=60.0;else if(resulet<=7  &&resulet>6.6 ) score+=65.0;else if(resulet<=6.6  &&resulet>6.2 ) score+=70.0;else if(resulet<=6.2  &&resulet>5.7 ) score+=75.0;
				else if(resulet<=5.7  &&resulet>5.1 ) score+=80.0;else if(resulet<=5.1  &&resulet>4.5 ) score+=85.0;else if(resulet<=4.5  &&resulet>4.3 ) score+=90.0;else if(resulet<=4.3   ) score+=95.0;
			
			}
		}
		
		return score;
	}
	
	/**
	 * 计算mmse和moca组合项数据
	 * @param recod
	 * @param calibrations
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static double getMMSEMOCAONE(RecordMOVO recod,int calibrations){
		double scroe=0.0;
		MyBeanWithPerson mb1=getMyBeanWithPerson(recod.getDetailMMSE());
		MyBeanWithPerson mb2=getMyBeanWithPerson(recod.getDetailMOCA());
		List<QuestionVO> mmse=mb1.getResult();
		List<QuestionVO> moca=mb2.getResult();
		for(QuestionVO q:mmse){
			int s=Integer.parseInt(q.getScore());
			if(calibrations==9&&q.getQuestion_id().equals("114")|q.getQuestion_id().equals("115")|q.getQuestion_id().equals("285")){
				scroe+=s;
			}else if(calibrations==10|calibrations==16&&q.getQuestion_id().equals("117")){
				scroe+=s;
			}else if(calibrations==11|calibrations==12&&q.getQuestion_id().equals("116")){
				scroe+=s;
			}else if(calibrations==18&&q.getQuestion_id().equals("118")|q.getQuestion_id().equals("120")|q.getQuestion_id().equals("122")|q.getQuestion_id().equals("124")|q.getQuestion_id().equals("126")|q.getQuestion_id().equals("127")){
				scroe+=s;
			}else if(calibrations==15&&q.getQuestion_id().equals("130")){
				scroe+=s;
			}
		
		}
		for(QuestionVO q:moca){
			int s=Integer.parseInt(q.getScore());
			if(calibrations==9&&q.getQuestion_id().equals("391")){
				//定向力
				scroe+=s;
			}
			else if(calibrations==13&&q.getQuestion_id().equals("389")){
				//抽象
				scroe+=s;
			}
			else if(calibrations==10&&q.getQuestion_id().equals("384")|q.getQuestion_id().equals("385")|q.getQuestion_id().equals("386")){
				//注意力
				scroe+=s;
			}
			else if(calibrations==11&&q.getQuestion_id().equals("383")){
				//记忆力
				scroe+=s;
			}
			else if(calibrations==12&&q.getQuestion_id().equals("390")){
				//回忆力
				scroe+=s;
			}
			else if(calibrations==14&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
				//视结构技
				scroe+=s;
			}
			else if(calibrations==15&&q.getQuestion_id().equals("379")|q.getQuestion_id().equals("380")|q.getQuestion_id().equals("381")){
				//执行能力
				scroe+=s;
			}
			else if(calibrations==16&&q.getQuestion_id().equals("386")){
				//计算力
				scroe+=s;
			}
			else if(calibrations==18&&q.getQuestion_id().equals("382")|q.getQuestion_id().equals("387")|q.getQuestion_id().equals("388")){
				scroe+=s;
		
			}
		}
		
		return scroe;
	}
	
	private static MyBeanWithPerson getMyBeanWithPerson(String m2) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
		classMap.put("result", QuestionVO.class);
		String json=m2;
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");      
		Matcher m = p.matcher(json);      
		String strNoBlank = m.replaceAll("");      
		json=strNoBlank.substring(1, strNoBlank.length()-1);
		return myBeanWithPerson(json, classMap);
	}
	
	private static MyBeanWithPerson getMyBeanWithPerson(RecordVO m2) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
        classMap.put("result", QuestionVO.class);
		String json=m2.getDetail();
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");      
        Matcher m = p.matcher(json);      
        String strNoBlank = m.replaceAll("");      
		json=strNoBlank.substring(1, strNoBlank.length()-1);
		return myBeanWithPerson(json, classMap);
	}
	
	public final static MyBeanWithPerson myBeanWithPerson(String json,Map<String, Class<QuestionVO>> classMap){
		MyBeanWithPerson diyBean = (MyBeanWithPerson)JSONObject.toBean(JSONObject.fromObject(json),MyBeanWithPerson.class , classMap);;
		return diyBean;
	}
	
}
