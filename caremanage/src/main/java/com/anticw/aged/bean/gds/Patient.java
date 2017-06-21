package com.anticw.aged.bean.gds;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ������Ϣ��
 * WEB SERVICES �ӿ�����ļ���
 */
@XmlRootElement(name = "patient")
public class Patient
{
    private String	patientId;     			//�����
	private String idCardNo;      			//���֤��
	private String name;       			//����
	private String gender;         		//�Ա�"��","Ů"
	private String	birthday;    			//�������ڣ���ʽ"YYYY-mm-DD"
	private short 	age;         			//����
	private String race;       			//���֣�"������","������","������"
	private String address;     			//��ַ
	private String tel;         			//�绰
	
	public String 	getPatientId() 			{ return patientId; }
	public String 	getIdCardNo() 			{ return idCardNo; }
	public String 	getName() 				{ return name; }
	public String 	getGender() 			{ return gender; }
	public String 	getBirthday() 			{ return birthday; }
	public short 	getAge() 				{ return age; }
	public String 	getAddress() 			{ return address; }
	public String 	getTel() 				{ return tel; }
	public String 	getRace() 				{ return race; }
	
	public void 	setPatientId(String s) 	{ patientId = s; }
	public void 	setIdCardNo(String s) 	{ idCardNo = s; }
	public void 	setName(String s) 		{ name = s; }
	public void 	setGender(String s) 	{ gender = s; }
	public void 	setBirthday(String s) 	{ birthday = s; }
	public void 	setAge(short n) 		{ age = n; }
	public void 	setAddress(String s) 	{ address = s; }
	public void 	setTel(String s) 		{ tel = s; }
	public void 	setRace(String s) 		{ race = s; }
}
