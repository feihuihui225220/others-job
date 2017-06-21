package com.anticw.aged.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MAssessHandleTree entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_assess_handle_tree", catalog = "")
public class MAssessHandleTree  implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Integer sex;
	private Integer age;
	private Integer nation;
	private Integer sheng;
	private Integer livewith;
	private Integer education;
	private Integer job;
	private Integer sourceincome;
	private Integer booleanIncome;
	private Integer economic;
	private Integer residenc;
	private Integer marriage;
	private Integer b11;
	private Integer b12;
	private Integer b13;
	private Integer b21;
	private Integer b22;
	private Integer b23;
	private Integer b24;
	private Integer b25;
	private Integer b26;
	private Integer b27;
	private Integer goodEmotion;
	private Integer badEmotion;
	private Integer c11;
	private Integer c12;
	private Integer c13;
	private Integer c14;
	private Integer c15;
	private Integer c16;
	private Integer c211;
	private Integer c212;
	private Integer c213;
	private Integer c22;
	private Integer c311;
	private Integer c312;
	private Integer c313;
	private Integer c314;
	private Integer c315;
	private Integer c32;
	private Integer c411;
	private Integer c412;
	private Integer c413;
	private Integer c511;
	private Integer c512;
	private Integer c52;
	private Integer c521;
	private Integer c522;
	private Integer c531;
	private Integer c532;
	private Integer c533;
	private Integer score;
	private Integer d11;
	private Integer d12;
	private Integer DConstruct;
	private Integer d221;
	private Integer d2211;
	private Integer d222;
	private Integer d2221;
	private Integer d223;
	private Integer d2231;
	private Integer DConnow;
	private Integer DConnow60;
	private Integer d31;
	private Integer d32;
	private Integer d3Con;
	private Integer d41;
	private Integer d42;
	private Integer d4Con;
	private Integer e1;
	private Integer e2;
	private Integer e3;
	private Integer e4;
	private Integer e5;
	private Integer e6;
	private Integer ECon;
	private Integer f11;
	private Integer f12;
	private Integer f1Con;
	private Integer f21;
	private Integer f31;
	private Integer f32;
	private Integer f33;
	private Integer f34;
	private Integer f35;
	private Integer f36;
	private Integer f37;
	private Integer f38;
	private Integer f4;
	private Integer f3Con;
	private Integer f3Con1;
	private Integer g1;
	private Integer g01;
	private Integer g02;
	private Integer g03;
	private Integer g04;
	private Integer g05;
	private Integer g06;
	private Integer g07;
	private Integer g08;
	private Integer g09;
	private Integer g10;
	private Integer g11;
	private Integer g12;
	private Integer g13;
	private Integer g14;
	private Integer g15;
	private Integer GCon;
	private Integer GJibing;
	private Date createdAt;

	// Constructors

	/** default constructor */
	public MAssessHandleTree() {
	}

	/** full constructor */
	public MAssessHandleTree(Integer userId, Integer sex, Integer age,
			Integer nation, Integer sheng, Integer livewith, Integer education,
			Integer job, Integer sourceincome, Integer booleanIncome,
			Integer economic, Integer residenc, Integer marriage, Integer b11,
			Integer b12, Integer b13, Integer b21, Integer b22, Integer b23,
			Integer b24, Integer b25, Integer b26, Integer b27,
			Integer goodEmotion, Integer badEmotion, Integer c11, Integer c12,
			Integer c13, Integer c14, Integer c15, Integer c16, Integer c211,
			Integer c212, Integer c213, Integer c22, Integer c311,
			Integer c312, Integer c313, Integer c314, Integer c315,
			Integer c32, Integer c411, Integer c412, Integer c413,
			Integer c511, Integer c512, Integer c52, Integer c521,
			Integer c522, Integer c531, Integer c532, Integer c533,
			Integer score, Integer d11, Integer d12, Integer DConstruct,
			Integer d221, Integer d2211, Integer d222, Integer d2221,
			Integer d223, Integer d2231, Integer DConnow, Integer DConnow60,
			Integer d31, Integer d32, Integer d3Con, Integer d41, Integer d42,
			Integer d4Con, Integer e1, Integer e2, Integer e3, Integer e4,
			Integer e5, Integer e6, Integer ECon, Integer f11, Integer f12,
			Integer f1Con, Integer f21, Integer f31, Integer f32, Integer f33,
			Integer f34, Integer f35, Integer f36, Integer f37, Integer f38,
			Integer f4, Integer f3Con, Integer f3Con1, Integer g1, Integer g01,
			Integer g02, Integer g03, Integer g04, Integer g05, Integer g06,
			Integer g07, Integer g08, Integer g09, Integer g10, Integer g11,
			Integer g12, Integer g13, Integer g14, Integer g15, Integer GCon,
			Integer GJibing, Date createdAt) {
		this.userId = userId;
		this.sex = sex;
		this.age = age;
		this.nation = nation;
		this.sheng = sheng;
		this.livewith = livewith;
		this.education = education;
		this.job = job;
		this.sourceincome = sourceincome;
		this.booleanIncome = booleanIncome;
		this.economic = economic;
		this.residenc = residenc;
		this.marriage = marriage;
		this.b11 = b11;
		this.b12 = b12;
		this.b13 = b13;
		this.b21 = b21;
		this.b22 = b22;
		this.b23 = b23;
		this.b24 = b24;
		this.b25 = b25;
		this.b26 = b26;
		this.b27 = b27;
		this.goodEmotion = goodEmotion;
		this.badEmotion = badEmotion;
		this.c11 = c11;
		this.c12 = c12;
		this.c13 = c13;
		this.c14 = c14;
		this.c15 = c15;
		this.c16 = c16;
		this.c211 = c211;
		this.c212 = c212;
		this.c213 = c213;
		this.c22 = c22;
		this.c311 = c311;
		this.c312 = c312;
		this.c313 = c313;
		this.c314 = c314;
		this.c315 = c315;
		this.c32 = c32;
		this.c411 = c411;
		this.c412 = c412;
		this.c413 = c413;
		this.c511 = c511;
		this.c512 = c512;
		this.c52 = c52;
		this.c521 = c521;
		this.c522 = c522;
		this.c531 = c531;
		this.c532 = c532;
		this.c533 = c533;
		this.score = score;
		this.d11 = d11;
		this.d12 = d12;
		this.DConstruct = DConstruct;
		this.d221 = d221;
		this.d2211 = d2211;
		this.d222 = d222;
		this.d2221 = d2221;
		this.d223 = d223;
		this.d2231 = d2231;
		this.DConnow = DConnow;
		this.DConnow60 = DConnow60;
		this.d31 = d31;
		this.d32 = d32;
		this.d3Con = d3Con;
		this.d41 = d41;
		this.d42 = d42;
		this.d4Con = d4Con;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
		this.e5 = e5;
		this.e6 = e6;
		this.ECon = ECon;
		this.f11 = f11;
		this.f12 = f12;
		this.f1Con = f1Con;
		this.f21 = f21;
		this.f31 = f31;
		this.f32 = f32;
		this.f33 = f33;
		this.f34 = f34;
		this.f35 = f35;
		this.f36 = f36;
		this.f37 = f37;
		this.f38 = f38;
		this.f4 = f4;
		this.f3Con = f3Con;
		this.f3Con1 = f3Con1;
		this.g1 = g1;
		this.g01 = g01;
		this.g02 = g02;
		this.g03 = g03;
		this.g04 = g04;
		this.g05 = g05;
		this.g06 = g06;
		this.g07 = g07;
		this.g08 = g08;
		this.g09 = g09;
		this.g10 = g10;
		this.g11 = g11;
		this.g12 = g12;
		this.g13 = g13;
		this.g14 = g14;
		this.g15 = g15;
		this.GCon = GCon;
		this.GJibing = GJibing;
		this.createdAt = createdAt;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "nation")
	public Integer getNation() {
		return this.nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	@Column(name = "sheng")
	public Integer getSheng() {
		return this.sheng;
	}

	public void setSheng(Integer sheng) {
		this.sheng = sheng;
	}

	@Column(name = "livewith")
	public Integer getLivewith() {
		return this.livewith;
	}

	public void setLivewith(Integer livewith) {
		this.livewith = livewith;
	}

	@Column(name = "education")
	public Integer getEducation() {
		return this.education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	@Column(name = "job")
	public Integer getJob() {
		return this.job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	@Column(name = "sourceincome")
	public Integer getSourceincome() {
		return this.sourceincome;
	}

	public void setSourceincome(Integer sourceincome) {
		this.sourceincome = sourceincome;
	}

	@Column(name = "boolean_income")
	public Integer getBooleanIncome() {
		return this.booleanIncome;
	}

	public void setBooleanIncome(Integer booleanIncome) {
		this.booleanIncome = booleanIncome;
	}

	@Column(name = "economic")
	public Integer getEconomic() {
		return this.economic;
	}

	public void setEconomic(Integer economic) {
		this.economic = economic;
	}

	@Column(name = "residenc")
	public Integer getResidenc() {
		return this.residenc;
	}

	public void setResidenc(Integer residenc) {
		this.residenc = residenc;
	}

	@Column(name = "marriage")
	public Integer getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}

	@Column(name = "b1_1")
	public Integer getB11() {
		return this.b11;
	}

	public void setB11(Integer b11) {
		this.b11 = b11;
	}

	@Column(name = "b1_2")
	public Integer getB12() {
		return this.b12;
	}

	public void setB12(Integer b12) {
		this.b12 = b12;
	}

	@Column(name = "b1_3")
	public Integer getB13() {
		return this.b13;
	}

	public void setB13(Integer b13) {
		this.b13 = b13;
	}

	@Column(name = "b2_1")
	public Integer getB21() {
		return this.b21;
	}

	public void setB21(Integer b21) {
		this.b21 = b21;
	}

	@Column(name = "b2_2")
	public Integer getB22() {
		return this.b22;
	}

	public void setB22(Integer b22) {
		this.b22 = b22;
	}

	@Column(name = "b2_3")
	public Integer getB23() {
		return this.b23;
	}

	public void setB23(Integer b23) {
		this.b23 = b23;
	}

	@Column(name = "b2_4")
	public Integer getB24() {
		return this.b24;
	}

	public void setB24(Integer b24) {
		this.b24 = b24;
	}

	@Column(name = "b2_5")
	public Integer getB25() {
		return this.b25;
	}

	public void setB25(Integer b25) {
		this.b25 = b25;
	}

	@Column(name = "b2_6")
	public Integer getB26() {
		return this.b26;
	}

	public void setB26(Integer b26) {
		this.b26 = b26;
	}

	@Column(name = "b2_7")
	public Integer getB27() {
		return this.b27;
	}

	public void setB27(Integer b27) {
		this.b27 = b27;
	}

	@Column(name = "good_emotion")
	public Integer getGoodEmotion() {
		return this.goodEmotion;
	}

	public void setGoodEmotion(Integer goodEmotion) {
		this.goodEmotion = goodEmotion;
	}

	@Column(name = "bad_emotion")
	public Integer getBadEmotion() {
		return this.badEmotion;
	}

	public void setBadEmotion(Integer badEmotion) {
		this.badEmotion = badEmotion;
	}

	@Column(name = "c1_1")
	public Integer getC11() {
		return this.c11;
	}

	public void setC11(Integer c11) {
		this.c11 = c11;
	}

	@Column(name = "c1_2")
	public Integer getC12() {
		return this.c12;
	}

	public void setC12(Integer c12) {
		this.c12 = c12;
	}

	@Column(name = "c1_3")
	public Integer getC13() {
		return this.c13;
	}

	public void setC13(Integer c13) {
		this.c13 = c13;
	}

	@Column(name = "c1_4")
	public Integer getC14() {
		return this.c14;
	}

	public void setC14(Integer c14) {
		this.c14 = c14;
	}

	@Column(name = "c1_5")
	public Integer getC15() {
		return this.c15;
	}

	public void setC15(Integer c15) {
		this.c15 = c15;
	}

	@Column(name = "c1_6")
	public Integer getC16() {
		return this.c16;
	}

	public void setC16(Integer c16) {
		this.c16 = c16;
	}

	@Column(name = "c2_11")
	public Integer getC211() {
		return this.c211;
	}

	public void setC211(Integer c211) {
		this.c211 = c211;
	}

	@Column(name = "c2_12")
	public Integer getC212() {
		return this.c212;
	}

	public void setC212(Integer c212) {
		this.c212 = c212;
	}

	@Column(name = "c2_13")
	public Integer getC213() {
		return this.c213;
	}

	public void setC213(Integer c213) {
		this.c213 = c213;
	}

	@Column(name = "c2_2")
	public Integer getC22() {
		return this.c22;
	}

	public void setC22(Integer c22) {
		this.c22 = c22;
	}

	@Column(name = "c3_11")
	public Integer getC311() {
		return this.c311;
	}

	public void setC311(Integer c311) {
		this.c311 = c311;
	}

	@Column(name = "c3_12")
	public Integer getC312() {
		return this.c312;
	}

	public void setC312(Integer c312) {
		this.c312 = c312;
	}

	@Column(name = "c3_13")
	public Integer getC313() {
		return this.c313;
	}

	public void setC313(Integer c313) {
		this.c313 = c313;
	}

	@Column(name = "c3_14")
	public Integer getC314() {
		return this.c314;
	}

	public void setC314(Integer c314) {
		this.c314 = c314;
	}

	@Column(name = "c3_15")
	public Integer getC315() {
		return this.c315;
	}

	public void setC315(Integer c315) {
		this.c315 = c315;
	}

	@Column(name = "c3_2")
	public Integer getC32() {
		return this.c32;
	}

	public void setC32(Integer c32) {
		this.c32 = c32;
	}

	@Column(name = "c4_11")
	public Integer getC411() {
		return this.c411;
	}

	public void setC411(Integer c411) {
		this.c411 = c411;
	}

	@Column(name = "c4_12")
	public Integer getC412() {
		return this.c412;
	}

	public void setC412(Integer c412) {
		this.c412 = c412;
	}

	@Column(name = "c4_13")
	public Integer getC413() {
		return this.c413;
	}

	public void setC413(Integer c413) {
		this.c413 = c413;
	}

	@Column(name = "c5_11")
	public Integer getC511() {
		return this.c511;
	}

	public void setC511(Integer c511) {
		this.c511 = c511;
	}

	@Column(name = "c5_12")
	public Integer getC512() {
		return this.c512;
	}

	public void setC512(Integer c512) {
		this.c512 = c512;
	}

	@Column(name = "c5_2")
	public Integer getC52() {
		return this.c52;
	}

	public void setC52(Integer c52) {
		this.c52 = c52;
	}

	@Column(name = "c5_2_1")
	public Integer getC521() {
		return this.c521;
	}

	public void setC521(Integer c521) {
		this.c521 = c521;
	}

	@Column(name = "c5_2_2")
	public Integer getC522() {
		return this.c522;
	}

	public void setC522(Integer c522) {
		this.c522 = c522;
	}

	@Column(name = "c5_31")
	public Integer getC531() {
		return this.c531;
	}

	public void setC531(Integer c531) {
		this.c531 = c531;
	}

	@Column(name = "c5_32")
	public Integer getC532() {
		return this.c532;
	}

	public void setC532(Integer c532) {
		this.c532 = c532;
	}

	@Column(name = "c5_33")
	public Integer getC533() {
		return this.c533;
	}

	public void setC533(Integer c533) {
		this.c533 = c533;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "d1_1")
	public Integer getD11() {
		return this.d11;
	}

	public void setD11(Integer d11) {
		this.d11 = d11;
	}

	@Column(name = "d1_2")
	public Integer getD12() {
		return this.d12;
	}

	public void setD12(Integer d12) {
		this.d12 = d12;
	}

	@Column(name = "d_construct")
	public Integer getDConstruct() {
		return this.DConstruct;
	}

	public void setDConstruct(Integer DConstruct) {
		this.DConstruct = DConstruct;
	}

	@Column(name = "d2_2_1")
	public Integer getD221() {
		return this.d221;
	}

	public void setD221(Integer d221) {
		this.d221 = d221;
	}

	@Column(name = "d2_2_11")
	public Integer getD2211() {
		return this.d2211;
	}

	public void setD2211(Integer d2211) {
		this.d2211 = d2211;
	}

	@Column(name = "d2_2_2")
	public Integer getD222() {
		return this.d222;
	}

	public void setD222(Integer d222) {
		this.d222 = d222;
	}

	@Column(name = "d2_2_21")
	public Integer getD2221() {
		return this.d2221;
	}

	public void setD2221(Integer d2221) {
		this.d2221 = d2221;
	}

	@Column(name = "d2_2_3")
	public Integer getD223() {
		return this.d223;
	}

	public void setD223(Integer d223) {
		this.d223 = d223;
	}

	@Column(name = "d2_2_31")
	public Integer getD2231() {
		return this.d2231;
	}

	public void setD2231(Integer d2231) {
		this.d2231 = d2231;
	}

	@Column(name = "d_connow")
	public Integer getDConnow() {
		return this.DConnow;
	}

	public void setDConnow(Integer DConnow) {
		this.DConnow = DConnow;
	}

	@Column(name = "d_connow60")
	public Integer getDConnow60() {
		return this.DConnow60;
	}

	public void setDConnow60(Integer DConnow60) {
		this.DConnow60 = DConnow60;
	}

	@Column(name = "d3_1")
	public Integer getD31() {
		return this.d31;
	}

	public void setD31(Integer d31) {
		this.d31 = d31;
	}

	@Column(name = "d3_2")
	public Integer getD32() {
		return this.d32;
	}

	public void setD32(Integer d32) {
		this.d32 = d32;
	}

	@Column(name = "d3_con")
	public Integer getD3Con() {
		return this.d3Con;
	}

	public void setD3Con(Integer d3Con) {
		this.d3Con = d3Con;
	}

	@Column(name = "d4_1")
	public Integer getD41() {
		return this.d41;
	}

	public void setD41(Integer d41) {
		this.d41 = d41;
	}

	@Column(name = "d4_2")
	public Integer getD42() {
		return this.d42;
	}

	public void setD42(Integer d42) {
		this.d42 = d42;
	}

	@Column(name = "d4_con")
	public Integer getD4Con() {
		return this.d4Con;
	}

	public void setD4Con(Integer d4Con) {
		this.d4Con = d4Con;
	}

	@Column(name = "e1")
	public Integer getE1() {
		return this.e1;
	}

	public void setE1(Integer e1) {
		this.e1 = e1;
	}

	@Column(name = "e2")
	public Integer getE2() {
		return this.e2;
	}

	public void setE2(Integer e2) {
		this.e2 = e2;
	}

	@Column(name = "e3")
	public Integer getE3() {
		return this.e3;
	}

	public void setE3(Integer e3) {
		this.e3 = e3;
	}

	@Column(name = "e4")
	public Integer getE4() {
		return this.e4;
	}

	public void setE4(Integer e4) {
		this.e4 = e4;
	}

	@Column(name = "e5")
	public Integer getE5() {
		return this.e5;
	}

	public void setE5(Integer e5) {
		this.e5 = e5;
	}

	@Column(name = "e6")
	public Integer getE6() {
		return this.e6;
	}

	public void setE6(Integer e6) {
		this.e6 = e6;
	}

	@Column(name = "e_con")
	public Integer getECon() {
		return this.ECon;
	}

	public void setECon(Integer ECon) {
		this.ECon = ECon;
	}

	@Column(name = "f1_1")
	public Integer getF11() {
		return this.f11;
	}

	public void setF11(Integer f11) {
		this.f11 = f11;
	}

	@Column(name = "f1_2")
	public Integer getF12() {
		return this.f12;
	}

	public void setF12(Integer f12) {
		this.f12 = f12;
	}

	@Column(name = "f1_con")
	public Integer getF1Con() {
		return this.f1Con;
	}

	public void setF1Con(Integer f1Con) {
		this.f1Con = f1Con;
	}

	@Column(name = "f2_1")
	public Integer getF21() {
		return this.f21;
	}

	public void setF21(Integer f21) {
		this.f21 = f21;
	}

	@Column(name = "f3_1")
	public Integer getF31() {
		return this.f31;
	}

	public void setF31(Integer f31) {
		this.f31 = f31;
	}

	@Column(name = "f3_2")
	public Integer getF32() {
		return this.f32;
	}

	public void setF32(Integer f32) {
		this.f32 = f32;
	}

	@Column(name = "f3_3")
	public Integer getF33() {
		return this.f33;
	}

	public void setF33(Integer f33) {
		this.f33 = f33;
	}

	@Column(name = "f3_4")
	public Integer getF34() {
		return this.f34;
	}

	public void setF34(Integer f34) {
		this.f34 = f34;
	}

	@Column(name = "f3_5")
	public Integer getF35() {
		return this.f35;
	}

	public void setF35(Integer f35) {
		this.f35 = f35;
	}

	@Column(name = "f3_6")
	public Integer getF36() {
		return this.f36;
	}

	public void setF36(Integer f36) {
		this.f36 = f36;
	}

	@Column(name = "f3_7")
	public Integer getF37() {
		return this.f37;
	}

	public void setF37(Integer f37) {
		this.f37 = f37;
	}

	@Column(name = "f3_8")
	public Integer getF38() {
		return this.f38;
	}

	public void setF38(Integer f38) {
		this.f38 = f38;
	}

	@Column(name = "f4")
	public Integer getF4() {
		return this.f4;
	}

	public void setF4(Integer f4) {
		this.f4 = f4;
	}

	@Column(name = "f3_con")
	public Integer getF3Con() {
		return this.f3Con;
	}

	public void setF3Con(Integer f3Con) {
		this.f3Con = f3Con;
	}

	@Column(name = "f3_con1")
	public Integer getF3Con1() {
		return this.f3Con1;
	}

	public void setF3Con1(Integer f3Con1) {
		this.f3Con1 = f3Con1;
	}

	@Column(name = "g1")
	public Integer getG1() {
		return this.g1;
	}

	public void setG1(Integer g1) {
		this.g1 = g1;
	}

	@Column(name = "g01")
	public Integer getG01() {
		return this.g01;
	}

	public void setG01(Integer g01) {
		this.g01 = g01;
	}

	@Column(name = "g02")
	public Integer getG02() {
		return this.g02;
	}

	public void setG02(Integer g02) {
		this.g02 = g02;
	}

	@Column(name = "g03")
	public Integer getG03() {
		return this.g03;
	}

	public void setG03(Integer g03) {
		this.g03 = g03;
	}

	@Column(name = "g04")
	public Integer getG04() {
		return this.g04;
	}

	public void setG04(Integer g04) {
		this.g04 = g04;
	}

	@Column(name = "g05")
	public Integer getG05() {
		return this.g05;
	}

	public void setG05(Integer g05) {
		this.g05 = g05;
	}

	@Column(name = "g06")
	public Integer getG06() {
		return this.g06;
	}

	public void setG06(Integer g06) {
		this.g06 = g06;
	}

	@Column(name = "g07")
	public Integer getG07() {
		return this.g07;
	}

	public void setG07(Integer g07) {
		this.g07 = g07;
	}

	@Column(name = "g08")
	public Integer getG08() {
		return this.g08;
	}

	public void setG08(Integer g08) {
		this.g08 = g08;
	}

	@Column(name = "g09")
	public Integer getG09() {
		return this.g09;
	}

	public void setG09(Integer g09) {
		this.g09 = g09;
	}

	@Column(name = "g10")
	public Integer getG10() {
		return this.g10;
	}

	public void setG10(Integer g10) {
		this.g10 = g10;
	}

	@Column(name = "g11")
	public Integer getG11() {
		return this.g11;
	}

	public void setG11(Integer g11) {
		this.g11 = g11;
	}

	@Column(name = "g12")
	public Integer getG12() {
		return this.g12;
	}

	public void setG12(Integer g12) {
		this.g12 = g12;
	}

	@Column(name = "g13")
	public Integer getG13() {
		return this.g13;
	}

	public void setG13(Integer g13) {
		this.g13 = g13;
	}

	@Column(name = "g14")
	public Integer getG14() {
		return this.g14;
	}

	public void setG14(Integer g14) {
		this.g14 = g14;
	}

	@Column(name = "g15")
	public Integer getG15() {
		return this.g15;
	}

	public void setG15(Integer g15) {
		this.g15 = g15;
	}

	@Column(name = "g_con")
	public Integer getGCon() {
		return this.GCon;
	}

	public void setGCon(Integer GCon) {
		this.GCon = GCon;
	}

	@Column(name = "g_jibing")
	public Integer getGJibing() {
		return this.GJibing;
	}

	public void setGJibing(Integer GJibing) {
		this.GJibing = GJibing;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}