/*package com.anticw.aged.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.TbUserBaseInfo;
import com.anticw.aged.bean.TbUserInfo;
import com.anticw.aged.dao.community.country.OCountryDao;
import com.anticw.aged.dao.user.ImportRUserBaseInfoDao;
import com.anticw.aged.dao.user.ImportRUserDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.utils.DateUtil;

*//**
 * 作者：bsd
 * 日期：2016-8-9
 * 功能：导入人口数据
 *//*
@Service
public class ImportUserService {
	@Autowired 
	private ImportRUserDao importRUserDao;
	@Autowired 
	private ImportRUserBaseInfoDao importRUserBaseInfoDao;
	@Autowired
	private RUserDao rUserDao;
	@Autowired
	private OCountryDao oCountryDao;
	*//**
	 * 查询出要导入的数据TODO
	 *@return
	 *//*
	public List<TbUserInfo> findTbUser(){
		return importRUserDao.findtbUser();
	}
	*//**
	 * 查询出要导入的用户基本数据以及问卷数据TODO
	 *@return
	 *//*
	public List<TbUserBaseInfo> findTbUserBaseInfo(){
		return importRUserBaseInfoDao.findtbUserBaseInfo();
	}
	
	public void get(){
		Pattern pattern = Pattern.compile("[//s//p{Zs}]");
		List<TbUserInfo> users= this.findTbUser();
		List<OCountry> 北京市所有的区 = oCountryDao.getCountrysByPid(35);
		List<OCountry>  congfu=new ArrayList<OCountry>();
		Map<String, OCountry> map=new HashMap<String, OCountry>();
		
		for(int a = 0; a < users.size(); a++){
			String province = users.get(a).getProvince();
			Matcher re = pattern.matcher(province);
			province=re.replaceAll("");
			String area = users.get(a).getArea();
			Matcher re1 = pattern.matcher(area);
			area=re1.replaceAll("");
			String street = users.get(a).getStreet();
			Matcher re11 = pattern.matcher(street);
			street=re11.replaceAll("");
			String commounity = users.get(a).getCommittee();
			Matcher re111 = pattern.matcher(commounity);
			commounity=re111.replaceAll("");
			String key=province+area+street;
			System.out.println(province+","+area+","+street+","+commounity);
			OCountry countryPare = null;
			StringBuffer fullname = new StringBuffer("全国,北京市,北京市");
			for (int j = 0; j < 北京市所有的区.size(); j++) {
				int xx=0;
				countryPare = 北京市所有的区.get(j); //得到区信息
				String name=countryPare.getName();
				Matcher re1111 = pattern.matcher(name);
				name=re1111.replaceAll("");
				if (area.equals(name)) {
					List<OCountry> 某个区下的所有街道 = oCountryDao.getCountrysByPid(countryPare.getId());
					for (int h = 0; h < 某个区下的所有街道.size(); h++) {
						countryPare = 某个区下的所有街道.get(h); //得到区信息
						String name1=countryPare.getName();
						Matcher re11111 = pattern.matcher(name1);
						name1=re11111.replaceAll("");
						if (street.equals(name1)) {
							xx++;
						}
					}
					if(xx==0){
						OCountry country = new OCountry();
						country.setName(street);
						country.setFullName(fullname.toString());
						country.setParentId(countryPare.getParentId());
						country.setAvailable(true);
						//country.setCreatedAt(new Date());
						country.setCreatedBy("admin");
						//country.setChangedAt(new Date());
						country.setChangedBy("admin");
						country.setType("4");
						//oCountryDao.save(country);
						map.put(key, country);
						fullname.delete(0,fullname.length()-1);
						System.out.println("插入区："+countryPare.getName());
					}
					
					
				} 
			}
			
			
		}
		for(String k:map.keySet()){
			System.out.println(k);
			
		}
		
		
	}
	
	
	public Integer importCountry(){
		
		get();
		if(1==1){
			return 0;
		}
		int i = 0;
		Pattern pattern = Pattern.compile("[//s//p{Zs}]");
       
		List<TbUserInfo> users= this.findTbUser();
		Set<OCountry> s1=new HashSet<OCountry>();
		for (int a = 0; a < users.size(); a++) {
			 
			String province = users.get(a).getProvince();
			Matcher re = pattern.matcher(province);
			province=re.replaceAll("");
			String area = users.get(a).getArea();
			Matcher re1 = pattern.matcher(area);
			area=re1.replaceAll("");
			String street = users.get(a).getStreet();
			Matcher re11 = pattern.matcher(street);
			street=re11.replaceAll("");
			String commounity = users.get(a).getCommittee();
			Matcher re111 = pattern.matcher(commounity);
			commounity=re111.replaceAll("");
			System.out.println(province+","+area+","+street+","+commounity);
			List<OCountry> 北京市所有的区 = oCountryDao.getCountrysByPid(35);
			StringBuffer fullname = new StringBuffer("全国,北京市,北京市");
			int q = 0;
			int s = 0;
			int c = 0;
			OCountry countryPare = new OCountry();
			for (int j = 0; j < 北京市所有的区.size(); j++) {
				countryPare = 北京市所有的区.get(j); //得到区信息
				String name=countryPare.getName();
				Matcher re1111 = pattern.matcher(name);
				name=re1111.replaceAll("");
				if (area.equals(name)) {
					q += 1;
					fullname.append(","+countryPare.getName());
					List<OCountry> 某个区下的所有街道 = oCountryDao.getCountrysByPid(countryPare.getId());
					for (int h = 0; h < 某个区下的所有街道.size(); h++) {
						countryPare = 某个区下的所有街道.get(h); //得到区信息
						if (street.equals(countryPare.getName())) {
							s += 1;
							fullname.append(","+countryPare.getName());
							List<OCountry> 某个街道的所有社区 = oCountryDao.getCountrysByPid(countryPare.getId());
							for (int k = 0; k < 某个街道的所有社区.size(); k++) {
								countryPare = 某个街道的所有社区.get(k); //得到区信息
								if (commounity.equals(countryPare.getName())) {
									c += 1;
									fullname.append(","+countryPare.getName());
									System.out.println("该社区已存在："+fullname);
								} 
							}
						} 
					}
				} 

			}
			if (q== 0 && s == 0 && c == 0) {
				OCountry country = new OCountry();
				country.setName(area);
				country.setFullName(fullname.toString());
				country.setParentId(countryPare.getParentId());
				country.setAvailable(true);
				//country.setCreatedAt(new Date());
				country.setCreatedBy("admin");
				//country.setChangedAt(new Date());
				country.setChangedBy("admin");
				country.setType("3");
				//oCountryDao.save(country);
				s1.add(country);
				fullname.delete(0,fullname.length()-1);
				System.out.println("插入区："+countryPare.getName());
				
			}else if (s == 0 && c == 0) {
				OCountry country = new OCountry();
				country.setName(street);
				country.setFullName(fullname.toString());
				country.setParentId(countryPare.getParentId());
				country.setAvailable(true);
				//country.setCreatedAt(new Date());
				country.setCreatedBy("admin");
				//country.setChangedAt(new Date());
				country.setChangedBy("admin");
				country.setType("4");
				s1.add(country);
				 
//				oCountryDao.save(country);
				q  -= 1 ;
				fullname.delete(0,fullname.length()-1);
				System.out.println("插入街道："+countryPare.getName());
			}else if (c == 0) {
				OCountry country = new OCountry();
				country.setName(commounity);
				country.setFullName(fullname.toString());
				country.setParentId(countryPare.getParentId());
				country.setAvailable(true);
				//country.setCreatedAt(new Date());
				country.setCreatedBy("admin");
				//country.setChangedAt(new Date());
				country.setChangedBy("admin");
				country.setType("5");
				s1.add(country);
//				oCountryDao.save(country);
				q = 0;
				c  = 0 ;
				s = 0;
				fullname.delete(0,fullname.length()-1);
				System.out.println("插入街道："+countryPare.getName());
			}

		}
		for(OCountry o:s1){
			System.out.println(o.getName());
		}
		return i;
	}
	//导入用户基本信息
	public Integer importUser(){
		int i = 0;
		List<TbUserInfo> users= this.findTbUser();
		List<OCountry> community = oCountryDao.getCountryByType("5");
		List<OCountry> allOrg = oCountryDao.getCountryAll();
		
		for (int j = 0; j < users.size(); j++) {
			try {
				RUser us = rUserDao.findByIdCardNo(users.get(j).getIdCard());
				if (us == null) {
					if (users.size() > 0) {
							RUser user;
							try {
								user = new RUser();
								TbUserInfo u = users.get(j);
								user.setName(u.getName()); //姓名
								user.setBirthday(DateUtil.parseStrToDate(u.getBirthDate())); //生日
								if ("男".equals(u.getSex())) { //性别
									user.setGender(1);
								} else {
									user.setGender(0);
								}
								for (int k = 0; k < orgiUsers.size(); k++) {
									if (orgiUsers.get(k).getIdCardNo().equals(u.getIdCard())) {
										 
										user.setIdCardNo(u.getIdCard()); //身份证
									}
									
								}
								user.setIdCardNo(u.getIdCard()); //身份证
								user.setChangedAt(new Date());
								user.setCreatedAt(new Date());
								//社区id
								for (int k = 0; k < community.size(); k++) {
									if (community.get(k).getName().equals(u.getCommittee())) {
										user.setCommunityId(community.get(k).getId());
									}
								}
								user.setAvailable(true);
								long result = rUserDao.save(user);
								if(result > 0){
									i++;
								}
							} catch (Exception e) {
							}
					}
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	*//**
	 * TODO 导入人员信息
	 *@return
	 *//*
	public Integer importUserBaseInfo(){
		int i = 0;
		List<TbUserBaseInfo> userInfo = this.findTbUserBaseInfo();
		List<OCountry> community = oCountryDao.getCountryByType("5");
		if (userInfo.size() > 0) {
			
			for (int j = 0; j < userInfo.size(); j++) {
				try {
					TbUserBaseInfo u = userInfo.get(j);
					RUser tUser = rUserDao.findByIdCardNo(u.getIdCard());
					if (tUser == null ) {
						
						RUser user = new RUser();
						if(u.getName() != null){
							user.setName(u.getName()); //姓名
						}
						
						if (u.getBirthDate() != null) {
							user.setBirthday(DateUtil.parseStrToDate(u
									.getBirthDate())); //生日
						}
						if ("男".equals(u.getSex())) { //性别
							user.setGender(1);
						} else {
							user.setGender(0);
						}
						if (u.getIdCard() !=null) {
							user.setIdCardNo(u.getIdCard()); //身份证
						}
						user.setChangedAt(new Date());
						user.setCreatedAt(new Date());
						//社区id
						for (int k = 0; k < community.size(); k++) {
							if (community.get(k).getName()
									.equals(u.getRegisterAddressCommunity())) {
								user.setCommunityId(community.get(k).getId());
							}
						}
						user.setAvailable(true);
						
						if (u.getCulturalDegree() != null) {
							//{"ILLITERATE":"未受过正式教育"}  ||  文盲或半文盲 201
							//{"JUNIOR_SCHOOL":"初中或小学"} ||   小学 200   初中198 
							//{"SENIOR_SCHOOL":"高中/技校/中专"} || 高中 199
							//{"COLLEGE":"大专"}            ||   大专202
							//{"BACHELORDEGREE_OR_ABOVE":"本科及以上"} ||  大学 204  研究生 206
							//                                       || 其他 223
							String education = u.getCulturalDegree();
							if (education.contains("未受过正式教育")) {
								user.setEducation(201);
							} else if (education.contains("初中或小学")) {
								user.setEducation(198);
							} else if (education.contains("高中/技校/中专")) {
								user.setEducation(199);
							} else if (education.contains("大专")) {
								user.setEducation(202);
							} else if (education.contains("本科及以上")) {
								user.setEducation(204);
							} else {
								user.setEducation(223);
							}
						}
						user.setCreatedBy("cm");
						long result = rUserDao.save(user);
						if (result > 0) {
							i++;
						}
					}

				}catch (Exception e) {
				}
			} 
		}
		return i;
	}
}
*/