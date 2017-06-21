package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_analysis_study")
public class MAnalysisStudy {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "user_id")
	private long userId;  
	@Column(name = "ADLScoreC")
	private Double ADLScoreC;//（ADL）得分
	@Column(name = "IADLScoreC")
	private Double IADLScoreC;//（IADL）得分
	@Column(name = "BodyWeight")
	private Double BodyWeight;//  身体成分为BMI和腰臀围比例
	@Column(name = "myodyNamia")
	private Double myodyNamia;//一半 肌力得分为握力值，得分越高力量越好；肌耐力为30秒坐站次次数，次数越多，肌耐力越好；肌耐力得分可根据其性别、年龄层和30秒坐站次数确认出其具体的肌耐力得分，对应表见(常模)；
	@Column(name = "xinfen")
	private Double xinfen;//心肺力
	@Column(name = "rouruan")
	private Double rouruan;//     柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
	@Column(name = "shenjing")
	private Double shenjing;//   神经反应能力得分为2.44米折返走速度，神经反应能力得分可根据其性别、年龄层和2.44米折返跑时间确认出其具体的神经反应能力得分，对应表见(常模)；；
	@Column(name = "xueya")
	private Double xueya;//血压：收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；
	@Column(name = "dingxiangli")
	private Double dingxiangli;//定向力得分为0-10分（MMSE）/0-6分（MoCA），得分越高定向力越好；
	@Column(name = "zhuyili")
	private Double zhuyili;//注意力与集中力得分为0-5分（MMSE）/0-1分（MoCA），得分越高注意力与集中力越好；
	@Column(name = "jiyili")
	private Double jiyili;//记忆力得分为0~3分（MMSE）/0-2分（MoCA），得分越高记忆力越好；
	@Column(name = "yuyanli")
	private Double yuyanli;//	语言能力得分为0-4分（MMSE）/0-6分（MoCA），得分越高语言能力越强；
	@Column(name = "huiyili")
	private Double huiyili;//回忆力得分为0-3分（MMSE）/0-5分（MoCA），得分越高回忆力越好；
	@Column(name = "choxiang")
	private Double choxiang;//抽象思维得分0-2分（MoCA），得分越高抽象能力越强；
	@Column(name = "shijiegou")
	private Double shijiegou;//视结构技能得分0-1分（MMSE）/0-2分(MoCA)，得分越高能力越强；
	@Column(name = "zhixingli")
	private Double zhixingli;//执行能力得分 0-4分（MMSE）/0-3分（MoCA）
	@Column(name = "jisuanli")
	private Double jisuanli;//计算力0-5分（MMSE）/0-3分（MoCA），得分越高计算能力越强；
	@Column(name = "GDSScroe")
	private Double GDSScroe;//心理素质得分0-30分（GDS得分），得分越高抑郁程度越强。
	@Column(name = "MoCaScroe")
	private Double MoCaScroe;//心理素质得分0-30分（GDS得分），得分越高抑郁程度越强。
	@Column(name = "MMSEScroe")
	private Double MMSEScroe;//心理素质得分0-30分（GDS得分），得分越高抑郁程度越强。
	@Column(name = "start")
	private Date start;
	@Column(name = "end")
	private Date end;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "grouping")
	private int grouping;//分组类型(四组)
	
	@Column(name = "calculating_type")
	private int calculatingType;//验算类型
	
	@Column(name = "user_sex")
	private int userSex;//验算类型

	public Double getBodyWeight() {
		return BodyWeight;
	}
	public void setBodyWeight(Double bodyWeight) {
		BodyWeight = bodyWeight;
	}
	public Double getMyodyNamia() {
		return myodyNamia;
	}
	public void setMyodyNamia(Double myodyNamia) {
		this.myodyNamia = myodyNamia;
	}
	public Double getXinfen() {
		return xinfen;
	}
	public void setXinfen(Double xinfen) {
		this.xinfen = xinfen;
	}
	public Double getRouruan() {
		return rouruan;
	}
	public void setRouruan(Double rouruan) {
		this.rouruan = rouruan;
	}
	public Double getShenjing() {
		return shenjing;
	}
	public void setShenjing(Double shenjing) {
		this.shenjing = shenjing;
	}
	public Double getXueya() {
		return xueya;
	}
	public void setXueya(Double xueya) {
		this.xueya = xueya;
	}
	public Double getDingxiangli() {
		return dingxiangli;
	}
	public void setDingxiangli(Double d) {
		this.dingxiangli = d;
	}
	public Double getZhuyili() {
		return zhuyili;
	}
	public void setZhuyili(Double zhuyili) {
		this.zhuyili = zhuyili;
	}
	public Double getJiyili() {
		return jiyili;
	}
	public void setJiyili(Double jiyili) {
		this.jiyili = jiyili;
	}
	public Double getHuiyili() {
		return huiyili;
	}
	public void setHuiyili(Double huiyili) {
		this.huiyili = huiyili;
	}
	public Double getChoxiang() {
		return choxiang;
	}
	public void setChoxiang(Double choxiang) {
		this.choxiang = choxiang;
	}
	public Double getShijiegou() {
		return shijiegou;
	}
	public void setShijiegou(Double shijiegou) {
		this.shijiegou = shijiegou;
	}
	public Double getZhixingli() {
		return zhixingli;
	}
	public void setZhixingli(Double zhixingli) {
		this.zhixingli = zhixingli;
	}
	public Double getJisuanli() {
		return jisuanli;
	}
	public void setJisuanli(Double jisuanli) {
		this.jisuanli = jisuanli;
	}
	public Double getGDSScroe() {
		return GDSScroe;
	}
	public void setGDSScroe(Double gDSScroe) {
		GDSScroe = gDSScroe;
	}
	public Double getYuyanli() {
		return yuyanli;
	}
	public void setYuyanli(Double yuyanli) {
		this.yuyanli = yuyanli;
	}
	public Double getMoCaScroe() {
		return MoCaScroe;
	}
	public void setMoCaScroe(Double moCaScroe) {
		MoCaScroe = moCaScroe;
	}
	public Double getMMSEScroe() {
		return MMSEScroe;
	}
	public void setMMSEScroe(Double mMSEScroe) {
		MMSEScroe = mMSEScroe;
	}
	
	public Double getADLScoreC() {
		return ADLScoreC;
	}
	public void setADLScoreC(Double aDLScoreC) {
		ADLScoreC = aDLScoreC;
	}
	public Double getIADLScoreC() {
		return IADLScoreC;
	}
	public void setIADLScoreC(Double iADLScoreC) {
		IADLScoreC = iADLScoreC;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getGrouping() {
		return grouping;
	}
	public void setGrouping(int grouping) {
		this.grouping = grouping;
	}
	public int getCalculatingType() {
		return calculatingType;
	}
	public void setCalculatingType(int calculatingType) {
		this.calculatingType = calculatingType;
	}
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "MAnalysisStudy [id=" + id + ", userId=" + userId
				+ ", ADLScoreC=" + ADLScoreC + ", IADLScoreC=" + IADLScoreC
				+ ", BodyWeight=" + BodyWeight + ", myodyNamia=" + myodyNamia
				+ ", xinfen=" + xinfen + ", rouruan=" + rouruan + ", shenjing="
				+ shenjing + ", xueya=" + xueya + ", dingxiangli="
				+ dingxiangli + ", zhuyili=" + zhuyili + ", jiyili=" + jiyili
				+ ", yuyanli=" + yuyanli + ", huiyili=" + huiyili
				+ ", choxiang=" + choxiang + ", shijiegou=" + shijiegou
				+ ", zhixingli=" + zhixingli + ", jisuanli=" + jisuanli
				+ ", GDSScroe=" + GDSScroe + ", MoCaScroe=" + MoCaScroe
				+ ", MMSEScroe=" + MMSEScroe + ", start=" + start + ", end="
				+ end + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", grouping=" + grouping + ", calculatingType="
				+ calculatingType + ", userSex=" + userSex + "]";
	}
	
	
	
	
	
}
