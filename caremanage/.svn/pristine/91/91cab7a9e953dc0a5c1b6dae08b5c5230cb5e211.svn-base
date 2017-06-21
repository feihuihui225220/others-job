package com.anticw.aged.service.assess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MUserIntervene;
import com.anticw.aged.bean.MVenderIntervene;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.RUserAssesscore;
import com.anticw.aged.bean.utils.FCriticalValue;
import com.anticw.aged.bean.utils.KFCriticalValue;
import com.anticw.aged.bean.utils.TCriticalValue;
import com.anticw.aged.dao.data.MPressureDao;
import com.anticw.aged.dao.professional.assess.AssessRecordDao;
import com.anticw.aged.dao.professional.assess.MUserInterveneDao;
import com.anticw.aged.dao.professional.assess.MVenderInterveneDao;
import com.anticw.aged.dao.professional.assess.RUserAssesscoreDao;
import com.anticw.aged.dao.professional.assess.util.ListArrayComparator;
import com.anticw.aged.dao.professional.assess.util.ListArrayComparatore;
import com.anticw.aged.dao.professional.assess.util.assessUtil;
import com.anticw.aged.dao.professional.fitness.FitnessDao;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.assess.MVenderInterveneVO;
import com.anticw.aged.vo.professional.service.DeviceBindVO;
import com.anticw.aged.vo.professional.service.MPressureVO;
import com.anticw.aged.vo.professional.vender.FitnessVO1;
import com.anticw.aged.vo.professional.vender.FitnessVO2;
import com.anticw.aged.vo.professional.vender.MyBeanWithPerson;
import com.anticw.aged.vo.professional.vender.QuestionVO;
import com.anticw.aged.vo.professional.vender.RecordMOVO;
import com.anticw.aged.vo.professional.vender.RecordVO;

/**
 * 
 * @author DX-2016/10/18 财经项目统计分析参与乐活堂活动的老人对失能失智的影响
 * @param <T>
 *
 */
@Service
public class MMAssessEconomicsService extends Thread implements Runnable {

	@Autowired
	private AssessRecordDao assessRecordDao;
	 
	@Autowired
	private FitnessDao fitnessDao;
	 
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private RUserDao rUserDao;
	@Autowired
	private MPressureDao mPressureDao;
	@Autowired
	private MUserInterveneDao mUserInterveneDao;// 归一化
	@Autowired
	private MVenderInterveneDao mVenderInterveneDao;// 最终结论
	@Autowired
	private RUserAssesscoreDao rUserAssesscoreDao;// 原始数据
	@Autowired
	private AssessService assessService;

	private List<?> ts = new ArrayList<Object>();// 干预前
	private List<?> te = new ArrayList<Object>();// 干预后
	private Integer group;// 组名
	private Integer group1;// 组名
	private Integer itemizeid;// 选项（肌力 血压。。。）
	final static int[] marry={254,253,252,250,222,193,192 };//婚姻情况:marry
	final static int[] education={200,198,203,199,202,204,260,223,261,201};//文化程度:education
	final static int[] religion={247,308,309,244,307,246,245,367};//宗教信仰：religion
	final static int[] jobCond={205,330,329,328,206,327,286,284,207,369};//从业状况：jobCond
	final static int[] income={294,293,292,291,290,210,209,208};//经济来源：income
	final static int[] disable={370,227,226,297,372 };//失能与否：disable
	public List<?> getTs() {
		return ts;
	}

	public void setTs(List<?> ts) {
		this.ts = ts;
	}

	public List<?> getTe() {
		return te;
	}

	public void setTe(List<?> te) {
		this.te = te;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getItemizeid() {
		return itemizeid;
	}

	public void setItemizeid(Integer itemizeid) {
		this.itemizeid = itemizeid;
	}

	public MMAssessEconomicsService() {
		super();
	}
	
	public MMAssessEconomicsService(RUserAssesscoreDao rUserAssesscoreDao) {
		super();
		this.rUserAssesscoreDao = rUserAssesscoreDao;
	}

	public Integer getGroup1() {
		return group1;
	}

	public void setGroup1(Integer group1) {
		this.group1 = group1;
	}

	public MMAssessEconomicsService(List<?> ts, List<?> te, Integer group,
			Integer itemizeid) {
		super();
		this.ts = ts;
		this.te = te;
		this.group = group;
		this.itemizeid = itemizeid;
	}

	/********************************* 单体T检验 **********************************************/
	// 本次方法为根据页面不同选项获取不同的检验方法
	/**
	 * T检验单体检验（单表因素）除体适能和血压外
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	// 预处理数据选项
	public void Tone(DateParamVO daParamVO, Integer calibrations, int grouping,
			double a) throws Exception {
		// 获取本次检测用户Id
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
				throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> sRe_ = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordVO> eRe_ = eRe.subList(evg * (grouping - 1), evg * grouping);
		double cords_ = getScroe(sRe) / userLength;// 总体平均值
		double cords_1 = getScroe(eRe_) / evg;// 分组一
		double evg_e1 = getq(eRe_, cords_1, evg);// 样本标准差
		// --------------------------------------单体T检验--------------------------------------------------
		double t_1 = getT(cords_, cords_1, evg_e1, evg);// 单体T检验
		// 测试单项服务效果针对自身是否具有显著性 
		double scords_1 = getScroe(sRe_) / evg;// 分组一
		// d_ 为代表对应前后两组数据之差的平均值 后-前
		double d_1 = cords_1 - scords_1;// 分组一
		// s_对应数据之差的标准差
		double s_1 = assessUtil.getT(sRe_, eRe_, d_1) / evg;
		// t检验值 测试单项服务效果针对自身是否具有显著性 
		double t_s_1 = d_1 / (s_1 / Math.sqrt(evg));
		double t = getT(a, evg);
		savet(calibrations, a, t_1, t_s_1, t, grouping,d_1);
	}

	 private void savet(Integer calibrations, double a, double t_1,
			double t_s_1, double t, int grouping,double d_1) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(t);
		m.setGroup1(grouping);
		m.setItemizeId(calibrations);
		m.setTestValue1(t_1);// 单总体T检验
		m.setTestValue2(t_s_1);// 自身是否（单体）
		m.setVerifyMode(0);
		m.setCreatedBy("cm");
		m.setAverage(d_1);
		mVenderInterveneDao.save(m);
	}

	private double getT(double a, int evg) {
		double t;
		if (evg > 601) {
			evg = 601;
		}
		if(evg<2){
			evg=2;
		}
		if (a == 0.01) {
			t = TCriticalValue.T_001[evg - 2];
		} else if (a == 0.05) {
			t = TCriticalValue.T_002[evg - 2];
		} else {
			t = TCriticalValue.T_003[evg - 2];
		}
		return t;
	}

	/**
	 * mmse moca 组合因素 9,10,11,12,13,14,15,16,18
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void Tone_(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordMOVO> sRe1 = sRe.subList(evg * (grouping - 1), evg
				* grouping);
		List<RecordMOVO> eRe1 = eRe.subList(evg * (grouping - 1), evg
				* grouping);

		double cords_ = getEvgM(sRe, calibrations) / userLength;// 总体平均值
		double cords_1 = getEvgM(eRe1, calibrations) / evg;// 分组一

		double evg_e1 = getEvgq(eRe1, cords_1, evg, calibrations);// 样本标准差

		// --------单体T检验------------------------------------------------
		double t_1 = getT(cords_, cords_1, evg_e1, evg);

		/************** 测试单项服务效果针对自身是否具有显著性 *****************************************************/

		double scords_1 = getEvgM(sRe1, calibrations) / evg;// 分组一

		// d_ 为代表对应前后两组数据之差的平均值 后-前
		double d_1 = cords_1 - scords_1;// 分组一
		// s_对应数据之差的标准差
		double s_1 = assessUtil.getT_mmse(sRe1, eRe1, d_1, calibrations);

		// t检验值
		// 测试单项服务效果针对自身是否具有显著性-----------------------------------------------
		double t_s_1 = d_1 / (s_1 / Math.sqrt(evg));
		double t = getT(a, evg);
		savet(calibrations, a, t_1, t_s_1, t, grouping,d_1);

	}

	/**
	 * 体适能评估 单项选择
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void Tone_T(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 4) {
			throw new Exception("体适能符合要求人数不足4人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO1> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);
		double cords_ = getTsl(list, calibrations) / userLength;// 总体平均值
		double cords_1 = getTsl(eRe1, calibrations) / evg;// 分组一

		double evg_e1 = getTslq(eRe1, cords_1, evg, calibrations);// 样本标准差

		double t_1 = getT(cords_, cords_1, evg_e1, evg);// 单体T检验

		/************** 测试单项服务效果针对自身是否具有显著性 *********************************/
		double scords_1 = assessUtil.getTsl(eRe1, calibrations) / evg;// 分组一
		// d_ 为代表对应前后两组数据之差的平均值 后-前
		double d_1 = cords_1 - scords_1;// 分组一

		double s_1 = assessUtil.getTsls(eRe1, d_1, calibrations);
		// t检验值
		// 测试单项服务效果针对自身是否具有显著性-----------------------------------------------
		double d= Math.sqrt(evg);
		double d_= s_1/d;
		double t_s_1 = d_1 / d_;
		double t = getT(a, evg);
		savet(calibrations, a, t_1, t_s_1, t, grouping,d_1);

	}

	/**
	 * 体适能评估 双项选择
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void Tone_T_(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 4) {
			throw new Exception("体适能符合要求人数不足4人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO2> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);

		double cords_ = getTsl_(list, calibrations) / userLength;// 总体平均值
		double cords_1 = getTsl_(eRe1, calibrations) / evg;// 分组一

		double evg_e1 = getTslq_(eRe1, cords_1, evg, calibrations);// 样本标准差

		double t_1 = getT(cords_, cords_1, evg_e1, evg);// 单体T检验

		/************** 测试单项服务效果针对自身是否具有显著性 *****************************************************/

		double scords_1 = assessUtil.getTsl_(eRe1, calibrations) / evg;// 分组一

		// d_ 为代表对应前后两组数据之差的平均值 后-前
		double d_1 = cords_1 - scords_1;// 分组一

		// s_对应数据之差的标准差
		double s_1 = assessUtil.getTslq_s(eRe1, d_1, calibrations);
		// t检验值
		// 测试单项服务效果针对自身是否具有显著性-----------------------------------------------
		double d_=Math.sqrt(evg);
		double t_s_1 = d_1 / (s_1 / d_);
		double t = getT(a, evg);
		savet(calibrations, a, t_1, t_s_1, t, grouping,d_1);

	}

	/**
	 * 血压
	 * 
	 * @param daParamVO
	 * @throws Exception
	 */
	public void Tone_bp(DateParamVO daParamVO, int grouping, double a,
			int calibrations) throws Exception {

		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = grouping;
		this.itemizeid = 8;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<MPressureVO> eRe1 = pres.subList(evg * (grouping - 1), evg
				* grouping);
		double cords_ = getMPressure(pres) / userLength;// 总体平均值
		double cords_1 = getMPressure(eRe1) / evg;// 分组一

		double evg_e1 = getMPressureq(eRe1, cords_1, evg);// 样本标准差
		double t_1 = getT(cords_, cords_1, evg_e1, evg);// 单体T检验
		/************** 测试单项服务效果针对自身是否具有显著性 *****************************************************/

		double scords_1 = assessUtil.getMPressure(eRe1) / evg;// 分组一
		// d_ 为代表对应前后两组数据之差的平均值 后-前
		double d_1 = cords_1 - scords_1;// 分组一
		// s_对应数据之差的标准差
		double s_1 = assessUtil.getMPressure(eRe1, d_1);

		// t检验值
		// 测试单项服务效果针对自身是否具有显著性-----------------------------------------------
		double t_s_1 = d_1 / (s_1 / Math.sqrt(evg));

		double t = getT(a, evg);
		savet(calibrations, a, t_1, t_s_1, t, grouping,d_1);

	}

	/*************************************** 双因素性别T *******************************************/
	/**
	 * 双音因素获取分组
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @throws Exception
	 */
	public void getListTSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> sRe1 = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordVO> eRe1 = eRe.subList(evg * (grouping - 1), evg * grouping);
		Map<Integer, List<RecordVO>> facmapsre=new HashMap<Integer, List<RecordVO>>();
		Map<Integer, List<RecordVO>> facmapere=new HashMap<Integer, List<RecordVO>>();
		int facLeng=0;//次因素等级或分级
		if(twoFactor==8){
			facmapsre=getaged1(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged1(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==1){//婚姻状况
			facmapsre=getaged1marry(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged1marry(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapere=getaged1education(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged1education(ageds, sRe1, facmapsre, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapere=getaged1jobCond(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged1jobCond(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapere=getaged1religion(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged1religion(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsre=getaged1disable(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged1disable(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapere=getaged1income(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged1income(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		List<Double> t=getMap_(facmapsre, facmapere);
		for(Double d:t){
			saveT_(calibrations, ageds, 0.0, d, twoFactor);//前期双因素T和单因素T在一起 此处单因素暂定为0.0  在数据库中
		}
	}
	

	/**
	 * mmse+moca 无性别
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTMMSESEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordMOVO> sRe1 = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordMOVO> eRe1 = eRe.subList(evg * (grouping - 1), evg * grouping);
		Map<Integer, List<RecordMOVO>> facmapsre=new HashMap<Integer, List<RecordMOVO>>();
		Map<Integer, List<RecordMOVO>> facmapere=new HashMap<Integer, List<RecordMOVO>>();
		int facLeng=0;//次因素等级或分级
		if(twoFactor==8){
			facmapsre=getaged2(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged2(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==1){//婚姻状况
			facmapsre=getaged2marry(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged2marry(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapere=getaged2education(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged2education(ageds, sRe1, facmapsre, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapere=getaged2jobCond(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged2jobCond(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapere=getaged2religion(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged2religion(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsre=getaged2disable(ageds, sRe1, facmapsre, facLeng);
			facmapere=getaged2disable(ageds, eRe1, facmapere, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapere=getaged2income(ageds, eRe1, facmapere, facLeng);
			facmapsre=getaged2income(ageds, sRe1, facmapsre, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		List<Double> t=getMocaMap(facmapsre, facmapere, calibrations);
		for(Double d:t){
			saveT_(calibrations, ageds, 0.0, d, twoFactor);//前期双因素T和单因素T在一起 此处单因素暂定为0.0  在数据库中
		}
	}

	/**
	 * mmse+moca
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTMMSESEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordMOVO> sRe1 = sRe.subList(evg * (grouping - 1), evg
				* grouping);
		List<RecordMOVO> eRe1 = eRe.subList(evg * (grouping - 1), evg
				* grouping);
		double t1 = getMocaMap(eRe1, sRe1, calibrations);
		double t = getT(a, evg);
		save_sex(calibrations, a, t1, t);
	}
	/**
	 * 体适能 双因素 无性别
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO1> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<FitnessVO1>> facmapsre=new HashMap<Integer, List<FitnessVO1>>();
		int facLeng=0;//次因素等级或分级
		if(twoFactor==8){
			facmapsre=getaged3(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==1){//婚姻状况
			facmapsre=getaged3marry(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsre=getaged3education(ageds, eRe1, facmapsre, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsre=getaged3jobCond(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsre=getaged3religion(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsre=getaged3disable(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsre=getaged3income(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		List<Double> t =getMocaMap(facmapsre, calibrations);
		for(Double d:t){
			saveT_(calibrations, ageds, 0.0, d, twoFactor);//前期双因素T和单因素T在一起 此处单因素暂定为0.0  在数据库中
		}
	}
	
	/**
	 * 体适能 单项获取（数据库） 双因素 性别
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO1> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);
		double t1 = gettslMap(eRe1, calibrations);

		double t = getT(a, evg);
		save_sex(calibrations, a, t1, t);
	}

	
	/**
	 * 体适能 双因素 不含性别
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTSSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO2> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<FitnessVO2>> facmapsre=new HashMap<Integer, List<FitnessVO2>>();
		int facLeng=0;//次因素等级或分级
		if(twoFactor==8){
			facmapsre=getaged4(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==1){//婚姻状况
			facmapsre=getaged4marry(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsre=getaged4education(ageds, eRe1, facmapsre, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsre=getaged4jobCond(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsre=getaged4religion(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsre=getaged4disable(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsre=getaged4income(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		List<Double>  t=getMocaMapv2(facmapsre, calibrations);
		for(Double d:t){
			saveT_(calibrations, ageds, 0.0, d, twoFactor);//前期双因素T和单因素T在一起 此处单因素暂定为0.0  在数据库中
		}
	}
	/**
	 * 体适能 双因素
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTSSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<FitnessVO2> eRe1 = list.subList(evg * (grouping - 1), evg
				* grouping);
		double t1 = gettslsMap(eRe1, calibrations);
		double t = getT(a, evg);
		save_sex(calibrations, a, t1, t);
	}
	
	/**
	 * 血压 双因素 不含性别
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void getListTbp(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 4) {
			throw new Exception("本时间段内测试血压不足4人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = grouping;
		this.itemizeid = 8;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<MPressureVO> eRe1 = pres.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<MPressureVO>> facmapsre=new HashMap<Integer, List<MPressureVO>>();
		int facLeng=0;//次因素等级或分级
		if(twoFactor==8){
			facmapsre=getaged5(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==1){//婚姻状况
			facmapsre=getaged5marry(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsre=getaged5education(ageds, eRe1, facmapsre, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsre=getaged5jobCond(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsre=getaged5religion(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsre=getaged5disable(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsre=getaged5income(ageds, eRe1, facmapsre, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		List<Double> t=gettbpMap_(facmapsre);
		for(Double d:t){
			saveT_(calibrations, ageds, 0.0, d, twoFactor);//前期双因素T和单因素T在一起 此处单因素暂定为0.0  在数据库中
		}
	}
	
	/**
	 * 血压 T检验 性别影响
	 * 
	 * @param daParamVO
	 * @throws Exception
	 */
	public void getListTbp(DateParamVO daParamVO, int grouping, double a,
			int calibrations) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 4) {
			throw new Exception("本时间段内测试血压不足4人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = grouping;
		this.itemizeid = 8;
		Thread thread = new Thread(this);
		thread.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<MPressureVO> eRe1 = pres.subList(evg * (grouping - 1), evg
				* grouping);
		double t1 = gettbpMap(eRe1);

		double t = getT(a, evg);
		save_sex(calibrations, a, t1, t);

	}

	/***************************** 独立性检验 卡方检验 ****************************************/
	/**
	 * 卡方 独立性检验 单一量表
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void KFTSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		// 获取指定分组
		List<RecordVO> sRe_ = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordVO> eRe_ = eRe.subList(evg * (grouping - 1), evg * grouping);
		double kf = getKF1(sRe_, eRe_);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, kf);
	}
	
	/**
	 * 双因素 不含性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void KFTS(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		// 获取指定分组
		List<RecordVO> sRe_ = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordVO> eRe_ = eRe.subList(evg * (grouping - 1), evg * grouping);
			
		Map<Integer, List<RecordVO>> facmapsrs=new HashMap<Integer, List<RecordVO>>();
		Map<Integer, List<RecordVO>> facmapsre=new HashMap<Integer, List<RecordVO>>();
			int facLeng=0;//次因素等级或分级
			if(twoFactor==8){
				facmapsrs=getaged1(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==1){//婚姻状况
				facmapsrs=getaged1marry(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1marry(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==2){//文化程度
				facmapsrs=getaged1education(ageds,sRe_, facmapsrs, facLeng);
				facmapsre=getaged1education(ageds, eRe_, facmapsre, facLeng);
			}	
			if(twoFactor==3){//从业状况
				facmapsrs=getaged1jobCond(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1jobCond(ageds,eRe_ , facmapsre, facLeng);
			}
			if(twoFactor==4){//宗教
				facmapsrs=getaged1religion(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1religion(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==5){//失能与否
				facmapsrs=getaged1disable(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1disable(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==6){//经济来源
				facmapsrs=getaged1income(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged1income(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==7){//过去职业
				
			}
			if(twoFactor==9){//神经反应能力
				
			}
			double kf=getKF1_(facmapsrs, facmapsre);
			double kfL = KFL1(a,eRe.size());
			savek(calibrations, a, kfL, kf);
			
		} 
	/**
	 * 双因素 不含性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void KFMMSETSEX_(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}

		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<RecordMOVO> sRe_ = sRe.subList(evg * (grouping - 1), evg
				* grouping);
		List<RecordMOVO> eRe_ = eRe.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<RecordMOVO>> facmapsrs=new HashMap<Integer, List<RecordMOVO>>();
		Map<Integer, List<RecordMOVO>> facmapsre=new HashMap<Integer, List<RecordMOVO>>();
			int facLeng=0;//次因素等级或分级
			if(twoFactor==8){
				facmapsrs=getaged2(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2(ageds, eRe_, facmapsre, facLeng);
			}//assessUtil.getMMSEMOCAONE(m1, call);
			if(twoFactor==1){//婚姻状况
				facmapsrs=getaged2marry(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2marry(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==2){//文化程度
				facmapsrs=getaged2education(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2education(ageds, eRe_, facmapsre, facLeng);
			}	
			if(twoFactor==3){//从业状况
				facmapsrs=getaged2jobCond(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2jobCond(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==4){//宗教
				facmapsrs=getaged2religion(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2religion(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==5){//失能与否
				facmapsrs=getaged2disable(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2disable(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==6){//经济来源
				facmapsrs=getaged2income(ageds, sRe_, facmapsrs, facLeng);
				facmapsre=getaged2income(ageds, eRe_, facmapsre, facLeng);
			}
			if(twoFactor==7){//过去职业
				
			}
			if(twoFactor==9){//神经反应能力
				
			}
		double kf = getKF1_(facmapsrs, facmapsre, calibrations);
		double kfL = KFL1(a,eRe.size());
		savek(calibrations, a, kfL, kf);
	}
	
	/**
	 * mmse
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @throws Exception
	 */
	public void KFMMSETSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}

		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<RecordMOVO> sRe_ = sRe.subList(evg * (grouping - 1), evg
				* grouping);
		List<RecordMOVO> eRe_ = eRe.subList(evg * (grouping - 1), evg
				* grouping);

		double kf = getKF2(sRe_, eRe_, calibrations);
		double kfL = KFL1(a,eRe.size());
		savek(calibrations, a, kfL, kf);
	}

	public void KFTSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		// getTSN
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();

		List<FitnessVO1> sRe_ = list.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<FitnessVO1>> facmapsrs=new HashMap<Integer, List<FitnessVO1>>();
			int facLeng=0;//次因素等级或分级
			if(twoFactor==8){
				facmapsrs=getaged3(ageds, sRe_, facmapsrs, facLeng);
			}//assessUtil.getMMSEMOCAONE(m1, call);
			if(twoFactor==1){//婚姻状况
				facmapsrs=getaged3marry(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==2){//文化程度
				facmapsrs=getaged3education(ageds, sRe_, facmapsrs, facLeng);
			}	
			if(twoFactor==3){//从业状况
				facmapsrs=getaged3jobCond(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==4){//宗教
				facmapsrs=getaged3religion(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==5){//失能与否
				facmapsrs=getaged3disable(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==6){//经济来源
				facmapsrs=getaged3income(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==7){//过去职业
				
			}
			if(twoFactor==9){//神经反应能力
				
			}
		double kf = getKF1_(facmapsrs , calibrations);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, kf);
	}
	
	
	/**
	 * 体适能单项 获取KF值
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @throws Exception
	 */
	public void KFTSLSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		// getTSN
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();

		List<FitnessVO1> sRe_ = list.subList(evg * (grouping - 1), evg
				* grouping);
		double KF = getKF3(sRe_, calibrations);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, KF);
	}
	/**
	 * 不含性别 体适能双项
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void KFTSLTS(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		// getTSN
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();

		List<FitnessVO2> sRe_ = list.subList(evg * (grouping - 1), evg
				* grouping);
		Map<Integer, List<FitnessVO2>> facmapsrs=new HashMap<Integer, List<FitnessVO2>>();
			int facLeng=0;//次因素等级或分级
			if(twoFactor==8){
				facmapsrs=getaged4(ageds, sRe_, facmapsrs, facLeng);
			}//assessUtil.getMMSEMOCAONE(m1, call);
			if(twoFactor==1){//婚姻状况
				facmapsrs=getaged4marry(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==2){//文化程度
				facmapsrs=getaged4education(ageds, sRe_, facmapsrs, facLeng);
			}	
			if(twoFactor==3){//从业状况
				facmapsrs=getaged4jobCond(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==4){//宗教
				facmapsrs=getaged4religion(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==5){//失能与否
				facmapsrs=getaged4disable(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==6){//经济来源
				facmapsrs=getaged4income(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==7){//过去职业
				
			}
			if(twoFactor==9){//神经反应能力
				
			}
		double kf = getKF4_(facmapsrs , calibrations);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, kf);
	}
	public Double getKF4_(Map<Integer, List<FitnessVO2>> facmapsrs,int call) {
		List<Integer> add=new ArrayList<Integer>();//分组增加的人数
		List<Integer> end=new ArrayList<Integer>();//分组无增加的人数
		List<Integer> sum=new ArrayList<Integer>();//分组总人数
		int sum_=0;//累计总人数
		int increaseAccumulation=0;//累计增加人数
		int nonTncreasing=0;//累计无增加人数
		for (int i = 0; i < facmapsrs.size(); i++) {
			List<FitnessVO2> m1 = facmapsrs.get(i);
			int add_=0;
			int end_=0;
			for(int j=0;j<m1.size();j++){
				if ( assessUtil.getTSN(m1.get(j), call, m1.get(j).getResultE1(),
						m1.get(j).getResultE2()) - assessUtil.getTSN(m1.get(i), call, m1.get(j).getResultS1(),m1.get(j).getResultS2()) > 0) {
					add_ += 1;
				}else{
					end_+=1;
				}
			}
			increaseAccumulation+=add_;
			nonTncreasing+=end_;
			add.add(add_);
			end.add(end_);
			int add__=add_+end_;
			sum.add(add__);
			sum_+=add__;
		}
		return getKF_(add, end, sum, sum_, increaseAccumulation,
				nonTncreasing);
	}
	

	/**
	 * 不含性别 血压
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void KFBP(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = grouping;
		this.itemizeid = 8;
		Thread thread = new Thread(this);
		thread.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<MPressureVO> sRe_ = pres.subList(evg * (grouping - 1), evg
				* grouping);

		Map<Integer, List<MPressureVO>> facmapsrs=new HashMap<Integer, List<MPressureVO>>();
			int facLeng=0;//次因素等级或分级
			if(twoFactor==8){
				facmapsrs=getaged5(ageds, sRe_, facmapsrs, facLeng);
			}//assessUtil.getMMSEMOCAONE(m1, call);
			if(twoFactor==1){//婚姻状况
				facmapsrs=getaged5marry(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==2){//文化程度
				facmapsrs=getaged5education(ageds, sRe_, facmapsrs, facLeng);
			}	
			if(twoFactor==3){//从业状况
				facmapsrs=getaged5jobCond(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==4){//宗教
				facmapsrs=getaged5religion(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==5){//失能与否
				facmapsrs=getaged5disable(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==6){//经济来源
				facmapsrs=getaged5income(ageds, sRe_, facmapsrs, facLeng);
			}
			if(twoFactor==7){//过去职业
				
			}
			if(twoFactor==9){//神经反应能力
				
			}
		double kf = getKF5_(facmapsrs , calibrations);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, kf);
	}
	
	
	/**
	 * 血压进行卡方验算
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @throws Exception
	 */
	public void KFBP(DateParamVO daParamVO, Integer calibrations, int grouping,
			double a) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = grouping;
		this.itemizeid = 8;
		Thread thread = new Thread(this);
		thread.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<MPressureVO> sRe_ = pres.subList(evg * (grouping - 1), evg
				* grouping);
		double kf = getKF5(sRe_);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, kf);
	}

	/********************************* 卡方统一性检验 ***********************************/
	
	public void KFT(DateParamVO daParamVO, Integer calibrations, int f1,
			int f2, double a) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}

		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = f1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = f2;
		Thread thread1 = new Thread(this);
		thread1.start();
		// assessService
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> sRe1 = sRe.subList(evg * (f1 - 1), evg * f1);
		List<RecordVO> sRe2 = sRe.subList(evg * (f2 - 1), evg * f2);

		List<RecordVO> eRe1 = eRe.subList(evg * (f1 - 1), evg * f1);
		List<RecordVO> eRe2 = eRe.subList(evg * (f2 - 1), evg * f2);
		Integer[] grade1 = null;
		Integer[] grade2 = null;
		Double KFL = null;
		switch (calibrations) {
		case 1:
			grade1 = new Integer[4];
			grade2 = new Integer[4];
			KFL = KFL1(a, 17);
			break;
		case 2:
			grade1 = new Integer[3];
			grade2 = new Integer[4];
			KFL = KFL1(a, 7);
			break;
		case 17:
			grade1 = new Integer[3];
			grade2 = new Integer[4];
			KFL = KFL1(a, 6);
			break;
		default:
			break;
		}
		Double KF = getkf(sRe1, sRe2, eRe1, eRe2, grade1, grade2, calibrations);
		savekf(calibrations, a, KFL, KF, f1, f2);
	}

	private void savekf(Integer calibrations, double a, double kfL, double kf,
			int f1, int f2) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(kfL);
		m.setGroup1(f1);
		m.setGroup2(f2);
		m.setItemizeId(calibrations);
		m.setTestValue1(kf);// 卡方统一性检验
		m.setTwoFactor(0);// 0性别  ***************************有问题***********************  判定确认为统一性
		m.setVerifyMode(1);
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}

	public Double getkf(List<RecordVO> sRe1, List<RecordVO> sRe2,
			List<RecordVO> eRe1, List<RecordVO> eRe2, Integer[] grade1,
			Integer[] grade2, int calibrations) {
		for (int i = 0; i < sRe1.size(); i++) {
			
			// 干预前
			String s1 = assessService.getAssessRecordDetails(sRe1.get(i)
					.getDetail());
			// 干预后
			String e1 = assessService.getAssessRecordDetails(eRe1.get(i)
					.getDetail());
			int group_1 = 0;
			int group_2 = 0;
			if (s1.equals("完全依赖") | s1.equals("重度失能")
					| s1.equals("中重度抑郁，您有抑郁症倾向，如果两周内不能缓解，建议您去医院进行详细检查。")) {
				group_1 = 0;
			}
			if (s1.equals("严重依賴")
					| s1.equals("轻度失能")
					| s1.equals("轻度抑郁，最近您的心情不太好。建议您多出去走走，呼吸新鲜空气，发现自己的兴趣爱好，多参加活动，这样有助于您获得一个好心情。如果两周内不能缓解，建议您寻求心理帮助。")) {
				group_1 = 1;
			}
			if (s1.equals("显著依賴") | s1.equals("自理")
					| s1.equals("正常，建议您多去户外走走，呼吸新鲜空气。保持健康的生活方式，保持好心情。")) {
				group_1 = 2;
			}
			if (s1.equals("功能独立")) {
				group_1 = 3;
			}
			if (e1.equals("完全依赖") | e1.equals("重度失能")
					| e1.equals("中重度抑郁，您有抑郁症倾向，如果两周内不能缓解，建议您去医院进行详细检查。")) {
				group_2 = 0;
			}
			if (e1.equals("严重依賴")
					| e1.equals("轻度失能")
					| e1.equals("轻度抑郁，最近您的心情不太好。建议您多出去走走，呼吸新鲜空气，发现自己的兴趣爱好，多参加活动，这样有助于您获得一个好心情。如果两周内不能缓解，建议您寻求心理帮助。")) {
				group_2 = 1;
			}
			if (e1.equals("显著依賴") | e1.equals("自理")
					| e1.equals("正常，建议您多去户外走走，呼吸新鲜空气。保持健康的生活方式，保持好心情。")) {
				group_2 = 2;
			}
			if (e1.equals("功能独立")) {
				group_2 = 3;
			}
			if (grade1[Math.abs(group_2 - group_1)] != null) {
				grade1[Math.abs(group_2 - group_1)] += 1;
			} else {
				grade1[Math.abs(group_2 - group_1)] = 0;
			}
		}
		for (int i = 0; i < eRe1.size(); i++) {
			// 干预前
			String s2 = assessService.getAssessRecordDetails(sRe2.get(i)
					.getDetail());
			// 干预后
			String e2 = assessService.getAssessRecordDetails(eRe2.get(i)
					.getDetail());
			int group_1 = 0;
			int group_2 = 0;
			if (s2.equals("完全依赖") | s2.equals("重度失能")
					| s2.equals("中重度抑郁，您有抑郁症倾向，如果两周内不能缓解，建议您去医院进行详细检查。")) {
				group_1 = 0;
			}
			if (s2.equals("严重依賴")
					| s2.equals("轻度失能")
					| s2.equals("轻度抑郁，最近您的心情不太好。建议您多出去走走，呼吸新鲜空气，发现自己的兴趣爱好，多参加活动，这样有助于您获得一个好心情。如果两周内不能缓解，建议您寻求心理帮助。")) {
				group_1 = 1;
			}
			if (s2.equals("显著依賴") | s2.equals("自理")
					| s2.equals("正常，建议您多去户外走走，呼吸新鲜空气。保持健康的生活方式，保持好心情。")) {
				group_1 = 2;
			}
			if (s2.equals("功能独立")) {
				group_1 = 3;
			}
			if (e2.equals("完全依赖") | e2.equals("重度失能")
					| e2.equals("中重度抑郁，您有抑郁症倾向，如果两周内不能缓解，建议您去医院进行详细检查。")) {
				group_2 = 0;
			}
			if (e2.equals("严重依賴")
					| e2.equals("轻度失能")
					| e2.equals("轻度抑郁，最近您的心情不太好。建议您多出去走走，呼吸新鲜空气，发现自己的兴趣爱好，多参加活动，这样有助于您获得一个好心情。如果两周内不能缓解，建议您寻求心理帮助。")) {
				group_2 = 1;
			}
			if (e2.equals("显著依賴") | e2.equals("自理")
					| e2.equals("正常，建议您多去户外走走，呼吸新鲜空气。保持健康的生活方式，保持好心情。")) {
				group_2 = 2;
			}
			if (e2.equals("功能独立")) {
				group_2 = 3;
			}
			if (grade2[Math.abs(group_2 - group_1)] != null) {
				grade2[Math.abs(group_2 - group_1)] += 1;
			} else {
				grade2[Math.abs(group_2 - group_1)] = 1;
			}
		}
		int sum1 = sRe1.size();
		int sum2 = sRe2.size();
		int sum_ = sRe1.size() + sRe2.size();// 人数
		double x2 = 0;
		for (int i = 0; i < grade1.length; i++) {//此处等级分级是可能会导致某一个等级人数为0此时暂不参与运算
			if(grade1[i]==null||grade1[i]==0){
				continue;
			}
			if(grade2[i]==null||grade2[i]==0){
				continue;
			}
			double grade1_ = sum1 * (grade1[i] + grade2[i]) / sum_;
			double grade2_ = sum2 * (grade1[i] + grade2[i]) / sum_;
			x2 += (grade1[i] - grade1_) * (grade1[i] - grade1_) / grade1_;
			x2 += (grade2[i] - grade2_) * (grade2[i] - grade2_) / grade2_;
		}
		return x2;
	}

	/**
	 * 对于moca/mmse量表中的细项，在进行卡方分析时将其具体得分确认为卡方等级，提高等级即前后等级差值。
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void KFTmmse(DateParamVO daParamVO, Integer calibrations, int f1,
			int f2, double a) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = f1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = f2;
		Thread thread1 = new Thread(this);
		thread1.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordMOVO> sRe1 = sRe.subList(evg * (f1 - 1), evg * f1);
		List<RecordMOVO> sRe2 = sRe.subList(evg * (f2 - 1), evg * f2);

		List<RecordMOVO> eRe1 = eRe.subList(evg * (f1 - 1), evg * f1);
		List<RecordMOVO> eRe2 = eRe.subList(evg * (f2 - 1), evg * f2);
		Integer[] grade1 = null;
		Integer[] grade2 = null;
		double KFL = 0;
		switch (calibrations) {
		case 9:
			grade1 = new Integer[17];
			grade2 = new Integer[17];
			KFL = KFL1(a, 17);
			break;
		case 10:
			grade1 = new Integer[7];
			grade2 = new Integer[7];
			KFL = KFL1(a, 7);
			break;
		case 11:
			grade1 = new Integer[6];
			grade2 = new Integer[6];
			KFL = KFL1(a, 6);
			break;
		case 12:
			grade1 = new Integer[9];
			grade2 = new Integer[9];
			KFL = KFL1(a, 9);
			break;
		case 13:
			grade1 = new Integer[3];
			grade2 = new Integer[3];
			KFL = KFL1(a, 13);
			break;
		case 14:
			grade1 = new Integer[4];
			grade2 = new Integer[4];
			KFL = KFL1(a, 4);
			break;
		case 15:
			grade1 = new Integer[9];
			grade2 = new Integer[9];
			KFL = KFL1(a, 9);
			break;
		case 16:
			grade1 = new Integer[9];
			grade2 = new Integer[9];
			KFL = KFL1(a, 9);
			break;
		case 18:
			grade1 = new Integer[11];
			grade2 = new Integer[11];
			KFL = KFL1(a, 11);
			break;
		default:
			break;
		}
		Map<Integer, Integer[]> getmmse = getmmse(sRe1, sRe2, eRe1, eRe2,
				grade1, grade2, calibrations);
		double KF = getmmse(getmmse);
		savekf(calibrations, a, KFL, KF, f1, f2);
	}

	private Double KFL1(double a, int length) {
		double kfL = 0;
		int l=0;
		if(length>=2){
			l=length-2;
		}
		if (a == 0.05) {
			kfL = KFCriticalValue.KF_005[l];
		} else if (a == 0.1) {
			kfL = KFCriticalValue.KF_001[l];
		} else if (a == 0.01) {
			kfL = KFCriticalValue.KF_010[l];
		}
		return kfL;
	}

	/**
	 * 体适能 单项
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @param f1
	 * @param f2
	 * @throws Exception
	 */
	public void KFTSN(DateParamVO daParamVO, Integer calibrations, int f1,
			int f2, double a) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = f1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = f2;
		Thread thread1 = new Thread(this);
		thread1.start();
		List<FitnessVO1> sRe1_ = list.subList(evg * (f1 - 1), evg * f1);

		Double KF = getKFTSN(sRe1_, sRe1_, calibrations);
		double KFL = KFL1(a, 6);
		savekf(calibrations, a, KFL, KF, f1, f2);
	}

	/**
	 * 体适能两项
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @param f1
	 * @param f2
	 * @throws Exception
	 */
	public void KFTSN_(DateParamVO daParamVO, Integer calibrations, int f1,
			int f2, double a) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = f1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = f2;
		Thread thread1 = new Thread(this);
		thread1.start();

		List<FitnessVO2> sRe1_ = list.subList(evg * (f1 - 1), evg * f1);

		Double KF = getKFTSN_(sRe1_, sRe1_, calibrations);
		double KFL = KFL1(a, 6);
		savekf(calibrations, a, KFL, KF, f1, f2);
	}

	public void KFTSN_bp(DateParamVO daParamVO, Integer calibrations, int f1,
			int f2, double a) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<MPressureVO> sRe1_ = pres.subList(evg * (f1 - 1), evg * f1);
		List<MPressureVO> sRe2 = pres.subList(evg * (f2 - 1), evg * f2);

		/*
		 * Double KF = getKFTSN_(sRe1_, sRe1_, calibrations); double KFL =
		 * KFL1(a, 6); savekf(calibrations, a, KFL, KF, f1, f2);
		 */
		double KF=getbpKF(sRe1_, sRe2);
		double KFL = KFL1(a, 6);
		savekf(calibrations, a, KFL, KF, f1, f2);
	}
	/**
	 * 返回血压统一性检验
	 * @param sRe1_
	 * @param sRe2
	 * @return
	 */
	public double getbpKF(List<MPressureVO> sRe1_,List<MPressureVO> sRe2){
		Integer[] grade1={0,0,0};
		Integer[] grade2={0,0,0};
		for(MPressureVO m:sRe1_){
			double hps= m.getHighPressuree();
			double lps= m.getLowPressuree();
			double hpe= m.getHighPressuree();
			double lpe= m.getLowPressuree();
			//高压等级提高，低压无提高现象；
			if(hps<90||hps>140&&hpe>=90||hpe<=140&&lpe<60||lpe>90){
				grade1[1]+=1;
			}
			//高压低压同时提高
			if(hps<90||hps>140&&hpe>=90||hpe<=140&&lpe>=60&&lpe<=90&&lps<60||lps>90){
				grade1[2]+=1;
			}
			
			if(lpe<60||lpe>90&&hpe<90||hpe>140){
				grade1[0]+=1;
			}
			
		}
		for(MPressureVO m:sRe2){
			double hps= m.getHighPressuree();
			double lps= m.getLowPressuree();
			double hpe= m.getHighPressuree();
			double lpe= m.getLowPressuree();
			//高压等级提高，低压无提高现象；
			if(hps<90||hps>140&&hpe>=90||hpe<=140&&lpe<60||lpe>90){
				grade2[1]+=1;
			}
			//高压低压同时提高
			if(hps<90||hps>140&&hpe>=90||hpe<=140&&lpe>=60&&lpe<=90&&lps<60||lps>90){
				grade2[2]+=1;
			}
			
			if(lpe<60||lpe>90&&hpe<90||hpe>140){
				grade2[0]+=1;
			}
			
		}
		int sum1 = 0;// 第一分组和
		int sum2 = 0;// 第二分组和

		for (int i = 0; i < grade1.length; i++) {
			if (grade1[i] != null) {
				sum1 += grade1[i];
			} else {
				grade1[i] = 0;
			}
			if (grade2[i] != null) {
				sum2 += grade2[i];
			} else {
				grade2[i] = 0;
			}
		}
		int sum_ = sum1 + sum2;// 人数
		double x2 = 0;
		for (int i = 0; i < grade1.length; i++) {
			double grade1_ = sum1 * (grade1[i] + grade2[i]) / sum_;
			double grade2_ = sum2 * (grade1[i] + grade2[i]) / sum_;
			x2 += (grade1[i] - grade1_) * (grade1[i] - grade1_) / grade1_;
			x2 += (grade2[i] - grade2_) * (grade2[i] - grade2_) / grade2_;
		}
		return x2;
	}
	
	/********************************** F值单因素方差分析 ***************************************/
	/**
	 * 单因素方差分析
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FC1(DateParamVO daParamVO, Integer calibrations, double a)
			throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}

		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> eRe1 = eRe.subList(0, evg);
		List<RecordVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		double cords_ = getScroe(eRe) / userLength;// 总体平均值
		double cords_1 = getScroe(eRe1) / evg;// 分组一
		double cords_2 = getScroe(eRe2) / evg;// 分组二
		double cords_3 = getScroe(eRe3) / evg;// 分组三
		double cords_4 = getScroe(eRe4) / evg;// 分组四
		Double SST = getSST(eRe1, cords_) + getSST(eRe2, cords_)
				+ getSST(eRe3, cords_) + getSST(eRe4, cords_);
		Double SSE = getSST(eRe1, cords_1) + getSST(eRe2, cords_2)
				+ getSST(eRe3, cords_3) + getSST(eRe4, cords_4);
		Double SSA = SST - SSE;
		Double MSA = SSA / 3;
		Double MSE = SSE / 3;
		Double F = MSA / MSE;
		int length=eRe.size()*4-8;
		double FL = FL(a,length);
		Double S_x_x = Math.sqrt(2 * MSE / evg);
		Double LSD_005 = S_x_x * 1.968011;
		Double LSD_001 = S_x_x * 2.592541;
		savef(calibrations, a, F, FL, LSD_005, LSD_001);
	}

	private void savef(Integer calibrations, double a, double F, double FL,
			Double LSD_005, Double LSD_001) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(FL);
		// m.setGroup1(f1);
		// m.setGroup2(f2);
		m.setItemizeId(calibrations);
		m.setTestValue1(F);//F值单因素方差分析
		m.setTestValue2(LSD_005);
		m.setTestValue3(LSD_001);
		m.setVerifyMode(2);
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}

	private Double FL(double a,int length) {
		double FL = 0;
		
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		
		if (a == 0.01) {
			FL = FCriticalValue.F_001[length][2];// n1>12之後 所有的值都為33
		} else if (a == 0.05) {
			FL = FCriticalValue.F_005[length][2];
		} else if (a == 0.1) {
			FL = FCriticalValue.F_010[length][2];
		}
		return FL;
	}

	/**
	 * mmse+moca
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FC2(DateParamVO daParamVO, Integer calibrations, double a)
			throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<RecordMOVO> eRe1 = eRe.subList(0, evg);
		List<RecordMOVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordMOVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordMOVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		double cords_ = getEvgM(eRe, calibrations) / userLength;// 总体平均值
		double cords_1 = getEvgM(eRe1, calibrations) / evg;// 分组一
		double cords_2 = getEvgM(eRe2, calibrations) / evg;// 分组二
		double cords_3 = getEvgM(eRe3, calibrations) / evg;// 分组三
		double cords_4 = getEvgM(eRe4, calibrations) / evg;// 分组四
		// getMMSEMOCAONE
		Double SST = getSST(eRe1, cords_, calibrations)
				+ getSST(eRe2, cords_, calibrations)
				+ getSST(eRe3, cords_, calibrations)
				+ getSST(eRe4, cords_, calibrations);
		Double SSE = getSST(eRe1, cords_1, calibrations)
				+ getSST(eRe2, cords_2, calibrations)
				+ getSST(eRe3, cords_3, calibrations)
				+ getSST(eRe4, cords_4, calibrations);
		Double SSA = SST - SSE;
		Double MSA = SSA / 3;
		Double MSE = SSE / 3;
		Double F = MSA / MSE;
		int length=eRe.size()*4-8;
		double FL = FL(a,length);
		Double S_x_x = Math.sqrt(2 * MSE / evg);
		Double LSD_005 = S_x_x * 1.968011;
		Double LSD_001 = S_x_x * 2.592541;
		savef(calibrations, a, F, FL, LSD_005, LSD_001);
	}

	/**
	 * 体适能单项
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FC3(DateParamVO daParamVO, Integer calibrations, double a)
			throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		List<FitnessVO1> eRe1 = list.subList(0, evg);
		List<FitnessVO1> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO1> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO1> eRe4 = list.subList(evg * 3, evg * 4);
		double cords_ = assessUtil.getTsl(list, calibrations) / userLength;// 总体平均值
		double cords_1 = assessUtil.getTsl(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl(eRe4, calibrations) / evg;// 分组四
		int length=eRe1.size()*4-8;
		Double SST = getSSTTSN(eRe1, cords_, calibrations)
				+ getSSTTSN(eRe2, cords_, calibrations)
				+ getSSTTSN(eRe3, cords_, calibrations)
				+ getSSTTSN(eRe4, cords_, calibrations);
		Double SSE = getSSTTSN(eRe1, cords_1, calibrations)
				+ getSSTTSN(eRe2, cords_2, calibrations)
				+ getSSTTSN(eRe3, cords_3, calibrations)
				+ getSSTTSN(eRe4, cords_4, calibrations);
		Double SSA = SST - SSE;
		Double MSA = SSA / 3;
		Double MSE = SSE / 3;
		Double F = MSA / MSE;
		double FL = FL(a,length);
		Double S_x_x = Math.sqrt(2 * MSE / evg);
		Double LSD_005 = S_x_x * 1.968011;
		Double LSD_001 = S_x_x * 2.592541;
		savef(calibrations, a, F, FL, LSD_005, LSD_001);

	}

	/**
	 * 体适能双项
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FC4(DateParamVO daParamVO, Integer calibrations, double a)
			throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		List<FitnessVO2> eRe1 = list.subList(0, evg);
		List<FitnessVO2> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO2> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO2> eRe4 = list.subList(evg * 3, evg * 4);
		double cords_ = assessUtil.getTsl_(list, calibrations) / userLength;// 总体平均值
		double cords_1 = assessUtil.getTsl_(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl_(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl_(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl_(eRe4, calibrations) / evg;// 分组四
		Double SST = getSSTTSN_(eRe1, cords_, calibrations)
				+ getSSTTSN_(eRe2, cords_, calibrations)
				+ getSSTTSN_(eRe3, cords_, calibrations)
				+ getSSTTSN_(eRe4, cords_, calibrations);
		Double SSE = getSSTTSN_(eRe1, cords_1, calibrations)
				+ getSSTTSN_(eRe2, cords_2, calibrations)
				+ getSSTTSN_(eRe3, cords_3, calibrations)
				+ getSSTTSN_(eRe4, cords_4, calibrations);
		Double SSA = SST - SSE;
		Double MSA = SSA / 3;
		Double MSE = SSE / 3;
		Double F = MSA / MSE;
		int length=eRe1.size()*4-8;
		double FL = FL(a,length);
		Double S_x_x = Math.sqrt(2 * MSE / evg);
		Double LSD_005 = S_x_x * 1.968011;
		Double LSD_001 = S_x_x * 2.592541;
		savef(calibrations, a, F, FL, LSD_005, LSD_001);
	}

	/**
	 * 血压
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FC5(DateParamVO daParamVO, Integer calibrations, double a)
			throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<MPressureVO> eRe1 = pres.subList(0, evg);
		List<MPressureVO> eRe2 = pres.subList(evg, evg * 2);
		List<MPressureVO> eRe3 = pres.subList(evg * 2, evg * 3);
		List<MPressureVO> eRe4 = pres.subList(evg * 3, evg * 4);
		double cords_ = assessUtil.getMPressure(pres) / userLength;// 总体平均值
		double cords_1 = assessUtil.getMPressure(eRe1) / evg;// 分组一
		double cords_2 = assessUtil.getMPressure(eRe2) / evg;// 分组二
		double cords_3 = assessUtil.getMPressure(eRe3) / evg;// 分组三
		double cords_4 = assessUtil.getMPressure(eRe4) / evg;// 分组四
		Double SST = getSSTHP(eRe1, cords_, calibrations)
				+ getSSTHP(eRe2, cords_, calibrations)
				+ getSSTHP(eRe3, cords_, calibrations)
				+ getSSTHP(eRe4, cords_, calibrations);
		Double SSE = getSSTHP(eRe1, cords_1, calibrations)
				+ getSSTHP(eRe2, cords_2, calibrations)
				+ getSSTHP(eRe3, cords_3, calibrations)
				+ getSSTHP(eRe4, cords_4, calibrations);
		Double SSA = SST - SSE;
		Double MSA = SSA / 3;
		Double MSE = SSE / 3;
		Double F = MSA / MSE;
		int length=eRe1.size()*4-8;
		double FL = FL(a,length);
		Double S_x_x = Math.sqrt(2 * MSE / evg);
		Double LSD_005 = S_x_x * 1.968011;
		Double LSD_001 = S_x_x * 2.592541;
		savef(calibrations, a, F, FL, LSD_005, LSD_001);
	}

	/***************************** F值双因素方差分析性别 *********************************************************/
	/**
	 * 除体适能外单表双项 无性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void FCtwo_factor(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> eRe1 = eRe.subList(0, evg);
		List<RecordVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		// 第一个元素
		double e = getScroe(eRe);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;
		double cords_1 = getScroe(eRe1) / evg;// 分组一
		double cords_2 = getScroe(eRe2) / evg;// 分组二
		double cords_3 = getScroe(eRe3) / evg;// 分组三
		double cords_4 = getScroe(eRe4) / evg;// 分组四
		//从性别到。。。
		int facLeng=0;//次因素等级或分级
		Map<Integer, List<RecordVO>> facmapsrs=new HashMap<Integer, List<RecordVO>>();
		if(twoFactor==8){
			facmapsrs=getaged1(ageds, eRe, facmapsrs, facLeng);
		}//assessUtil.getMMSEMOCAONE(m1, call);
		if(twoFactor==1){//婚姻状况
			facmapsrs=getaged1marry(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsrs=getaged1education(ageds, eRe1, facmapsrs, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsrs=getaged1jobCond(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsrs=getaged1religion(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsrs=getaged1disable(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsrs=getaged1income(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		
		double SSb =  FCtwo_factor_(facmapsrs, calibrations,cords_);
		double SSt = getSST(eRe, c);
		// getScore(RecordVO m){
		double SSab = getSSAB(eRe1, eRe2, eRe3, eRe4, cords_);
		savef(calibrations, a, eRe, evg, cords_, cords_1, cords_2, cords_3,
				cords_4, SSt, SSab, SSb);
		
	}

	
	/**
	 * 除体适能外单表
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FCtwo_factor(DateParamVO daParamVO, Integer calibrations,
			double a) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> eRe1 = eRe.subList(0, evg);
		List<RecordVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		// 第一个元素
		double e = getScroe(eRe);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;
		double cords_1 = getScroe(eRe1) / evg;// 分组一
		double cords_2 = getScroe(eRe2) / evg;// 分组二
		double cords_3 = getScroe(eRe3) / evg;// 分组三
		double cords_4 = getScroe(eRe4) / evg;// 分组四
		// 第二个因素 性别、
		List<Integer> sex = getSexFc(eRe);
		double SSt = getSST(eRe, c);
		// getScore(RecordVO m){
		double SSab = getSSAB(eRe1, eRe2, eRe3, eRe4, cords_);
		double SSb = sex.get(2) * Math.pow(sex.get(1) - cords_, 2) + sex.get(5)
				* Math.pow(sex.get(4) - cords_, 2);
		savef(calibrations, a, eRe, evg, cords_, cords_1, cords_2, cords_3,
				cords_4, SSt, SSab, SSb);
	}
	

	/**
	 * mmse双项 无性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void FCtwo_factorMMse(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<RecordMOVO> eRe1 = eRe.subList(0, evg);
		List<RecordMOVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordMOVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordMOVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		double e = getEvgM(eRe, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = getEvgM(eRe1, calibrations) / evg;// 分组一
		double cords_2 = getEvgM(eRe2, calibrations) / evg;// 分组二
		double cords_3 = getEvgM(eRe3, calibrations) / evg;// 分组三
		double cords_4 = getEvgM(eRe4, calibrations) / evg;// 分组四
		int length=eRe1.size()*4-8;
		//从性别到。。。
		int facLeng=0;//次因素等级或分级
		Map<Integer, List<RecordMOVO>> facmapsrs=new HashMap<Integer, List<RecordMOVO>>();
		if(twoFactor==8){
			facmapsrs=getaged2(ageds, eRe, facmapsrs, facLeng);
		}//assessUtil.getMMSEMOCAONE(m1, call);
		if(twoFactor==1){//婚姻状况
			facmapsrs=getaged2marry(ageds, eRe, facmapsrs, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsrs=getaged2education(ageds, eRe, facmapsrs, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsrs=getaged2jobCond(ageds, eRe, facmapsrs, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsrs=getaged2religion(ageds, eRe, facmapsrs, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsrs=getaged2disable(ageds, eRe, facmapsrs, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsrs=getaged2income(ageds, eRe, facmapsrs, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		double SSb =  getMMseF_(facmapsrs, calibrations,cords_);
		double SSt = getSSTMMse(eRe, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABMMse(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		getmmsef(calibrations, a, evg, cords_, cords_1, cords_2, cords_3,
				cords_4, SSb, length, SSt, SSab);
	}

	public double getMMseF_(Map<Integer, List<RecordMOVO>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<RecordMOVO> eRe:facmapsrs.values()){
			double m = 0;
			for (int i = 0; i < eRe.size(); i++) {
				RecordMOVO m1 = eRe.get(i);
				m += assessUtil.getMMSEMOCAONE(m1, call);
			}
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	
	/**
	 * mmse+moca
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FCtwo_factorMMse(DateParamVO daParamVO, Integer calibrations,
			double a) throws Exception {
		Map<Integer, List<RecordMOVO>> map = assessRecordDao.getIds(daParamVO);
		List<RecordMOVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordMOVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<RecordMOVO> eRe1 = eRe.subList(0, evg);
		List<RecordMOVO> eRe2 = eRe.subList(evg, evg * 2);
		List<RecordMOVO> eRe3 = eRe.subList(evg * 2, evg * 3);
		List<RecordMOVO> eRe4 = eRe.subList(evg * 3, evg * 4);
		double e = getEvgM(eRe, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = getEvgM(eRe1, calibrations) / evg;// 分组一
		double cords_2 = getEvgM(eRe2, calibrations) / evg;// 分组二
		double cords_3 = getEvgM(eRe3, calibrations) / evg;// 分组三
		double cords_4 = getEvgM(eRe4, calibrations) / evg;// 分组四
		// 第二个因素 性别、
		List<Integer> sex = getSexFcMMse(eRe, calibrations);
		double SSb = sex.get(2) * Math.pow(sex.get(1) - cords_, 2) + sex.get(5)
				* Math.pow(sex.get(4) - cords_, 2);
		int length=eRe.size()*4-8;
		double SSt = getSSTMMse(eRe, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABMMse(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		getmmsef(calibrations, a, evg, cords_, cords_1, cords_2, cords_3,
				cords_4, SSb, length, SSt, SSab);
	}

	private void getmmsef(Integer calibrations, double a, int evg,
			double cords_, double cords_1, double cords_2, double cords_3,
			double cords_4, double SSb, int length, double SSt, double SSab) {
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
		Double SSa_b = SSab - SSa - SSb;
		//Double SSe = SSt - SSab;
		double jun = SSa / 3 + SSb / 1 + SSa_b / 3; // 误差均方
		double fa = SSa / 3 / jun;
		double fb = SSb / 1 / jun;
		double fa_b = SSa_b / 3 / jun;
		double f_3 = 0;
		double f_1 = 0;
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		if (a == 0.05) {
			f_3 = FCriticalValue.F_005[length][2];
			f_1 = FCriticalValue.F_005[length][0];
		} else if (a == 0.1) {
			f_3 = FCriticalValue.F_010[length][2];
			f_1 = FCriticalValue.F_010[length][0];
		} else if (a == 0.01) {
			f_3 = FCriticalValue.F_001[length][2];
			f_1 = FCriticalValue.F_001[length][0];
		}
		saveF(calibrations, fa, fa_b, fb, fa_b, f_3, f_1);
	}

	/**
	 * 体适能单项双因素 无性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void FCtwo_factorTSN(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		List<FitnessVO1> eRe1 = list.subList(0, evg);
		List<FitnessVO1> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO1> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO1> eRe4 = list.subList(evg * 3, evg * 4);
		double e = assessUtil.getTsl(list, calibrations);
		double cords_ = e / userLength;// 总体平均值
		//double c = e * e / userLength;//
		double cords_1 = assessUtil.getTsl(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl(eRe4, calibrations) / evg;// 分组四

		int length=eRe1.size()*4-8;
		//从性别到。。。
		int facLeng=0;//次因素等级或分级
		Map<Integer, List<FitnessVO1>> facmapsrs=new HashMap<Integer, List<FitnessVO1>>();
		if(twoFactor==8){
			facmapsrs=getaged3(ageds, list, facmapsrs, facLeng);
		}//assessUtil.getMMSEMOCAONE(m1, call);
		if(twoFactor==1){//婚姻状况
			facmapsrs=getaged3marry(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsrs=getaged3education(ageds, eRe1, facmapsrs, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsrs=getaged3jobCond(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsrs=getaged3religion(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsrs=getaged3disable(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsrs=getaged3income(ageds, eRe1, facmapsrs, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		
		//double SSt = getSSTTSN1(list, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABTSN(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
		double SSb =  getSexFcTSNVO1_(facmapsrs, calibrations,cords_);
		Double SSa_b = SSab - SSa - SSb;
		//Double SSe = SSt - SSab;
		double jun = SSa / 3 + SSb / 1 + SSa_b / 3; // 误差均方
		double fa = SSa / 3 / jun;
		double fb = SSb / 1 / jun;
		double fa_b = SSa_b / 3 / jun;
		double f_3 = 0;
		double f_1 = 0;
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		if (a == 0.05) {
			f_3 = FCriticalValue.F_005[length][2];
			f_1 = FCriticalValue.F_005[length][0];
		} else if (a == 0.1) {
			f_3 = FCriticalValue.F_010[length][2];
			f_1 = FCriticalValue.F_010[length][0];
		} else if (a == 0.01) {
			f_3 = FCriticalValue.F_001[length][2];
			f_1 = FCriticalValue.F_001[length][0];
		}
		saveF(calibrations, fa, fa_b, fb, fa_b, f_3, f_1);
	}

	public double FCtwo_factorTSN_(Map<Integer, List<FitnessVO1>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<FitnessVO1> eRe:facmapsrs.values()){
			Integer m = 0;
			for (int i = 0; i < eRe.size(); i++) {
				FitnessVO1 m1 = eRe.get(i);
				assessUtil.getE1(m1, call, m1.getResultE()).intValue();
			}
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	
	/**
	 * 体适能单项选择
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FCtwo_factorTSN(DateParamVO daParamVO, Integer calibrations,
			double a) throws Exception {
		List<FitnessVO1> list = fitnessDao.list(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();
		List<FitnessVO1> eRe1 = list.subList(0, evg);
		List<FitnessVO1> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO1> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO1> eRe4 = list.subList(evg * 3, evg * 4);
		double e = assessUtil.getTsl(list, calibrations);
		double cords_ = e / userLength;// 总体平均值
		//double c = e * e / userLength;//
		double cords_1 = assessUtil.getTsl(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl(eRe4, calibrations) / evg;// 分组四

		int length=eRe1.size()*4-8;
		List<Integer> sex = getSexFcTSN(list, calibrations);
		//double SSt = getSSTTSN1(list, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABTSN(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
		double SSb = sex.get(2) * Math.pow(sex.get(1) - cords_, 2) + sex.get(5)
				* Math.pow(sex.get(4) - cords_, 2);
		Double SSa_b = SSab - SSa - SSb;
		//Double SSe = SSt - SSab;
		double jun = SSa / 3 + SSb / 1 + SSa_b / 3; // 误差均方
		double fa = SSa / 3 / jun;
		double fb = SSb / 1 / jun;
		double fa_b = SSa_b / 3 / jun;
		double f_3 = 0;
		double f_1 = 0;
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		if (a == 0.05) {
			f_3 = FCriticalValue.F_005[length][2];
			f_1 = FCriticalValue.F_005[length][0];
		} else if (a == 0.1) {
			f_3 = FCriticalValue.F_010[length][2];
			f_1 = FCriticalValue.F_010[length][0];
		} else if (a == 0.01) {
			f_3 = FCriticalValue.F_001[length][2];
			f_1 = FCriticalValue.F_001[length][0];
		}
		saveF(calibrations, fa, fa_b, fb, fa_b, f_3, f_1);
	}
	/**
	 * 体适能双项 无性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void FCtwo_factorTSN_(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		List<FitnessVO2> eRe1 = list.subList(0, evg);
		List<FitnessVO2> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO2> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO2> eRe4 = list.subList(evg * 3, evg * 4);
		double e = assessUtil.getTsl_(list, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = assessUtil.getTsl_(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl_(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl_(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl_(eRe4, calibrations) / evg;// 分组四
		//从性别到。。。
		int facLeng=0;//次因素等级或分级
		Map<Integer, List<FitnessVO2>> facmapsrs=new HashMap<Integer, List<FitnessVO2>>();
		if(twoFactor==8){
			facmapsrs=getaged4(ageds, list, facmapsrs, facLeng);
		}//assessUtil.getMMSEMOCAONE(m1, call);
		if(twoFactor==1){//婚姻状况
			facmapsrs=getaged4marry(ageds, list, facmapsrs, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsrs=getaged4education(ageds, list, facmapsrs, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsrs=getaged4jobCond(ageds, list, facmapsrs, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsrs=getaged4religion(ageds, list, facmapsrs, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsrs=getaged4disable(ageds, list, facmapsrs, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsrs=getaged4income(ageds, list, facmapsrs, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		
		double SSt = getSSTTSN2(list, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABTSN_(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
		double SSb =  getSexFcTSN_(facmapsrs, calibrations,cords_);
		saveF(calibrations, a, eRe1, SSt, SSab, SSa, SSb);
	}

	public double getSexFcTSN_(Map<Integer, List<FitnessVO2>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<FitnessVO2> eRe:facmapsrs.values()){
			Integer m = 0;
			for (int i = 0; i < eRe.size(); i++) {
				FitnessVO2 m1 = eRe.get(i);
				m += assessUtil.getTSN(m1, call, m1.getResultE1(),
						m1.getResultE2()).intValue();
			}
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	public double getSexFcTSNVO1_(Map<Integer, List<FitnessVO1>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<FitnessVO1> eRe:facmapsrs.values()){
			Integer m = 0;
			for (int i = 0; i < eRe.size(); i++) {
				FitnessVO1 m1 = eRe.get(i);
				m += assessUtil.getE1(m1, call, m1.getResultE()).intValue();
			}
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	
	
	/**
	 * 体适能双因素
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FCtwo_factorTSN_(DateParamVO daParamVO, Integer calibrations,
			double a) throws Exception {
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		List<FitnessVO2> eRe1 = list.subList(0, evg);
		List<FitnessVO2> eRe2 = list.subList(evg, evg * 2);
		List<FitnessVO2> eRe3 = list.subList(evg * 2, evg * 3);
		List<FitnessVO2> eRe4 = list.subList(evg * 3, evg * 4);
		double e = assessUtil.getTsl_(list, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = assessUtil.getTsl_(eRe1, calibrations) / evg;// 分组一
		double cords_2 = assessUtil.getTsl_(eRe2, calibrations) / evg;// 分组二
		double cords_3 = assessUtil.getTsl_(eRe3, calibrations) / evg;// 分组三
		double cords_4 = assessUtil.getTsl_(eRe4, calibrations) / evg;// 分组四

		List<Integer> sex = getSexFcTN_(list, calibrations);
		double SSt = getSSTTSN2(list, c, calibrations);
		// getScore(RecordVO m){
		double SSab = getSSABTSN_(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
		double SSb = sex.get(2) * Math.pow(sex.get(1) - cords_, 2) + sex.get(5)
				* Math.pow(sex.get(4) - cords_, 2);
		saveF(calibrations, a, eRe1, SSt, SSab, SSa, SSb);
	}
	
	
	/**
	 * 血压双项 无性别
	 * @param daParamVO
	 * @param calibrations
	 * @param grouping
	 * @param a
	 * @param ageds
	 * @param twoFactor
	 * @throws Exception
	 */
	public void FCtwo_getHPF__(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a,int ageds,int twoFactor) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<MPressureVO> eRe1 = pres.subList(0, evg);
		List<MPressureVO> eRe2 = pres.subList(evg, evg * 2);
		List<MPressureVO> eRe3 = pres.subList(evg * 2, evg * 3);
		List<MPressureVO> eRe4 = pres.subList(evg * 3, evg * 4);
		double e = assessUtil.getMPressure(pres, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = assessUtil.getMPressure(eRe1) / evg;// 分组一
		double cords_2 = assessUtil.getMPressure(eRe2) / evg;// 分组二
		double cords_3 = assessUtil.getMPressure(eRe3) / evg;// 分组三
		double cords_4 = assessUtil.getMPressure(eRe4) / evg;// 分组四
		int length=eRe1.size()*4-8;
		//从性别到。。。
		int facLeng=0;//次因素等级或分级
		Map<Integer, List<MPressureVO>> facmapsrs=new HashMap<Integer, List<MPressureVO>>();
		if(twoFactor==8){
			facmapsrs=getaged5(ageds, pres, facmapsrs, facLeng);
		}//assessUtil.getMMSEMOCAONE(m1, call);
		if(twoFactor==1){//婚姻状况
			facmapsrs=getaged5marry(ageds, pres, facmapsrs, facLeng);
		}
		if(twoFactor==2){//文化程度
			facmapsrs=getaged5education(ageds, pres, facmapsrs, facLeng);
		}	
		if(twoFactor==3){//从业状况
			facmapsrs=getaged5jobCond(ageds, pres, facmapsrs, facLeng);
		}
		if(twoFactor==4){//宗教
			facmapsrs=getaged5religion(ageds, pres, facmapsrs, facLeng);
		}
		if(twoFactor==5){//失能与否
			facmapsrs=getaged5disable(ageds, pres, facmapsrs, facLeng);
		}
		if(twoFactor==6){//经济来源
			facmapsrs=getaged5income(ageds, pres, facmapsrs, facLeng);
		}
		if(twoFactor==7){//过去职业
			
		}
		if(twoFactor==9){//神经反应能力
			
		}
		
		double SSt = getSSTHP_(pres, c, calibrations);
		// getScore(RecordVO m){
		double SSb =  getHPF_(facmapsrs, calibrations,cords_);
		savehpf(calibrations, a, evg, eRe1, eRe2, eRe3, eRe4, cords_, cords_1,
				cords_2, cords_3, cords_4, length, SSt, SSb);
	}

	public double getHPF_(Map<Integer, List<MPressureVO>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<MPressureVO> eRe:facmapsrs.values()){
			double m = 0;
			for (int i = 0; i < eRe.size(); i++) {
				MPressureVO m1 = eRe.get(i);
				m += assessUtil.getMPressure(m1.getLowPressuree(),m1.getHighPressuree());
			}
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	

	/**
	 * 血压双因素 性别 F值
	 * 
	 * @param daParamVO
	 * @param calibrations
	 * @throws Exception
	 */
	public void FCtwo_factorHP(DateParamVO daParamVO, Integer calibrations,
			double a) throws Exception {
		List<DeviceBindVO> vos = orderDao.getDeviceBind(daParamVO);
		if (vos == null || vos.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		List<MPressureVO> pres = mPressureDao.getAlarms(vos,
				daParamVO.getStart(), daParamVO.getEnd());
		if (pres == null || pres.size() < 8) {
			throw new Exception("本时间段内测试血压不足8人，请重新选择！");
		}
		this.ts = pres;
		this.te = null;
		this.group = 1;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		this.group = 2;
		Thread thread2 = new Thread(this);
		thread2.start();
		this.group = 3;
		Thread thread3 = new Thread(this);
		thread3.start();
		Thread thread4 = new Thread(this);
		this.group = 3;
		thread4.start();

		int userLength = pres.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数

		List<MPressureVO> eRe1 = pres.subList(0, evg);
		List<MPressureVO> eRe2 = pres.subList(evg, evg * 2);
		List<MPressureVO> eRe3 = pres.subList(evg * 2, evg * 3);
		List<MPressureVO> eRe4 = pres.subList(evg * 3, evg * 4);
		double e = assessUtil.getMPressure(pres, calibrations);
		double cords_ = e / userLength;// 总体平均值
		double c = e * e / userLength;//
		double cords_1 = assessUtil.getMPressure(eRe1) / evg;// 分组一
		double cords_2 = assessUtil.getMPressure(eRe2) / evg;// 分组二
		double cords_3 = assessUtil.getMPressure(eRe3) / evg;// 分组三
		double cords_4 = assessUtil.getMPressure(eRe4) / evg;// 分组四
		int length=eRe1.size()*4-8;

		List<Double> sex = getSexFcHP(pres, calibrations);
		double SSt = getSSTHP_(pres, c, calibrations);
		// getScore(RecordVO m){
		double SSb = sex.get(2) * Math.pow(sex.get(1) - cords_, 2) + sex.get(5)
				* Math.pow(sex.get(4) - cords_, 2);
		savehpf(calibrations, a, evg, eRe1, eRe2, eRe3, eRe4, cords_, cords_1,
				cords_2, cords_3, cords_4, length, SSt, SSb);

	}

	private void savehpf(Integer calibrations, double a, int evg,
			List<MPressureVO> eRe1, List<MPressureVO> eRe2,
			List<MPressureVO> eRe3, List<MPressureVO> eRe4, double cords_,
			double cords_1, double cords_2, double cords_3, double cords_4,
			int length, double SSt, double SSb) {
		double SSab = getSSABHP_(eRe1, eRe2, eRe3, eRe4, cords_, calibrations);
		getmmsef(calibrations, a, evg, cords_, cords_1, cords_2, cords_3,
				cords_4, SSb, length, SSt, SSab);
	}

	/**************************** 部分逻辑运算 ***************************************************/

	public Double getSSABHP_(List<MPressureVO> eRe1, List<MPressureVO> eRe2,
			List<MPressureVO> eRe3, List<MPressureVO> eRe4, double cords_,
			int calibrations) {
		List<Double> e1 = getSexFcHP(eRe1, calibrations);
		List<Double> e2 = getSexFcHP(eRe2, calibrations);
		List<Double> e3 = getSexFcHP(eRe3, calibrations);
		List<Double> e4 = getSexFcHP(eRe4, calibrations);
		return e1.get(2) * (e1.get(1) - cords_) * (e1.get(1) - cords_)
				+ e2.get(2) * (e2.get(1) - cords_) * (e2.get(1) - cords_)
				+ e3.get(2) * (e3.get(1) - cords_) * (e3.get(1) - cords_)
				+ e4.get(2) * (e4.get(1) - cords_) * (e4.get(1) - cords_)
				+ e1.get(5) * (e1.get(4) - cords_) * (e1.get(4) - cords_)
				+ e2.get(5) * (e2.get(4) - cords_) * (e2.get(4) - cords_)
				+ e3.get(5) * (e3.get(4) - cords_) * (e3.get(4) - cords_)
				+ e4.get(5) * (e4.get(4) - cords_) * (e4.get(4) - cords_);
	}

	public Double getSSTHP_(List<MPressureVO> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (MPressureVO m1 : eRe) {
			double s = assessUtil.getMPressure(m1.getLowPressuree(),
					m1.getHighPressuree());
			sst += s * s;
		}
		return sst;
	}

	public List<Double> getSexFcHP(List<MPressureVO> eRe, int call) {
		List<Double> sex_fc = new ArrayList<Double>();
		List<MPressureVO> man = new ArrayList<MPressureVO>();// 男 前
		List<MPressureVO> woman = new ArrayList<MPressureVO>();// 男 后
		double m = 0;
		double wo = 0;
		for (int i = 0; i < eRe.size(); i++) {
			MPressureVO m1 = eRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			if (r.getGender() == 0) {// 女
				m += assessUtil.getMPressure(m1.getLowPressuree(),
						m1.getHighPressuree());
				woman.add(m1);
			} else {
				wo += assessUtil.getMPressure(m1.getLowPressuree(),
						m1.getHighPressuree());
				man.add(m1);
			}
		}

		sex_fc.add(m);
		sex_fc.add(m / man.size());
		sex_fc.add((double) man.size());
		sex_fc.add(wo);
		sex_fc.add(wo / woman.size());
		sex_fc.add((double) woman.size());
		return sex_fc;

	}

	public Double getSSABTSN_(List<FitnessVO2> eRe1, List<FitnessVO2> eRe2,
			List<FitnessVO2> eRe3, List<FitnessVO2> eRe4, double cords_,
			int calibrations) {
		List<Integer> e1 = getSexFcTN_(eRe1, calibrations);
		List<Integer> e2 = getSexFcTN_(eRe2, calibrations);
		List<Integer> e3 = getSexFcTN_(eRe3, calibrations);
		List<Integer> e4 = getSexFcTN_(eRe4, calibrations);
		return e1.get(2) * (e1.get(1) - cords_) * (e1.get(1) - cords_)
				+ e2.get(2) * (e2.get(1) - cords_) * (e2.get(1) - cords_)
				+ e3.get(2) * (e3.get(1) - cords_) * (e3.get(1) - cords_)
				+ e4.get(2) * (e4.get(1) - cords_) * (e4.get(1) - cords_)
				+ e1.get(5) * (e1.get(4) - cords_) * (e1.get(4) - cords_)
				+ e2.get(5) * (e2.get(4) - cords_) * (e2.get(4) - cords_)
				+ e3.get(5) * (e3.get(4) - cords_) * (e3.get(4) - cords_)
				+ e4.get(5) * (e4.get(4) - cords_) * (e4.get(4) - cords_);
	}

	public Double getSSTTSN2(List<FitnessVO2> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (FitnessVO2 m : eRe) {
			double s = assessUtil.getTSN(m, calibrations, m.getResultE1(),
					m.getResultE2())
					- cords_;
			sst += s * s;
		}
		return sst;
	}

	
	public List<Integer> getSexFcTN_(List<FitnessVO2> eRe, int call) {
		List<Integer> sex_fc = new ArrayList<Integer>();
		List<FitnessVO2> man = new ArrayList<FitnessVO2>();// 男 前
		List<FitnessVO2> woman = new ArrayList<FitnessVO2>();// 男 后
		Integer m = 0;
		Integer wo = 0;
		for (int i = 0; i < eRe.size(); i++) {
			FitnessVO2 m1 = eRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			if (r.getGender() == 0) {// 女
				m += assessUtil.getTSN(m1, call, m1.getResultE1(),
						m1.getResultE2()).intValue();
				woman.add(m1);
			} else {
				wo += assessUtil.getTSN(m1, call, m1.getResultE1(),
						m1.getResultE2()).intValue();
				man.add(m1);
			}
		}

		sex_fc.add(m);
		sex_fc.add(m / man.size());
		sex_fc.add(man.size());
		sex_fc.add(wo);
		sex_fc.add(wo / woman.size());
		sex_fc.add(woman.size());
		return sex_fc;

	}

	public Double getSSABTSN(List<FitnessVO1> eRe1, List<FitnessVO1> eRe2,
			List<FitnessVO1> eRe3, List<FitnessVO1> eRe4, double cords_,
			int calibrations) {
		List<Integer> e1 = getSexFcTSN(eRe1, calibrations);
		List<Integer> e2 = getSexFcTSN(eRe2, calibrations);
		List<Integer> e3 = getSexFcTSN(eRe3, calibrations);
		List<Integer> e4 = getSexFcTSN(eRe4, calibrations);
		return e1.get(2) * (e1.get(1) - cords_) * (e1.get(1) - cords_)
				+ e2.get(2) * (e2.get(1) - cords_) * (e2.get(1) - cords_)
				+ e3.get(2) * (e3.get(1) - cords_) * (e3.get(1) - cords_)
				+ e4.get(2) * (e4.get(1) - cords_) * (e4.get(1) - cords_)
				+ e1.get(5) * (e1.get(4) - cords_) * (e1.get(4) - cords_)
				+ e2.get(5) * (e2.get(4) - cords_) * (e2.get(4) - cords_)
				+ e3.get(5) * (e3.get(4) - cords_) * (e3.get(4) - cords_)
				+ e4.get(5) * (e4.get(4) - cords_) * (e4.get(4) - cords_);
	}

	public Double getSSTTSN1(List<FitnessVO1> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (FitnessVO1 m : eRe) {
			double s = assessUtil.getE1(m, calibrations, m.getResultE())
					- cords_;
			sst += s * s;
		}
		return sst;
	}

	public List<Integer> getSexFcTSN(List<FitnessVO1> eRe, int call) {
		List<Integer> sex_fc = new ArrayList<Integer>();
		List<FitnessVO1> man = new ArrayList<FitnessVO1>();// 男 前
		List<FitnessVO1> woman = new ArrayList<FitnessVO1>();// 男 后
		Integer m = 0;
		Integer wo = 0;
		for (int i = 0; i < eRe.size(); i++) {
			FitnessVO1 m1 = eRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			if (r.getGender() == 0) {// 女
				m += assessUtil.getE1(m1, call, m1.getResultE()).intValue();
				woman.add(m1);
			} else {
				wo += (int) assessUtil.getE1(m1, call, m1.getResultE())
						.intValue();
				man.add(m1);
			}
		}

		sex_fc.add(m);
		sex_fc.add(m / man.size());
		sex_fc.add(man.size());
		sex_fc.add(wo);
		sex_fc.add(wo / woman.size());
		sex_fc.add(woman.size());
		return sex_fc;

	}

	public Double getSSTMMse(List<RecordMOVO> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (RecordMOVO m : eRe) {
			double s = assessUtil.getMMSEMOCAONE(m, calibrations) - cords_;
			sst += s * s;
		}
		return sst;
	}

	public Double getSSABMMse(List<RecordMOVO> eRe1, List<RecordMOVO> eRe2,
			List<RecordMOVO> eRe3, List<RecordMOVO> eRe4, double cords_,
			int calibrations) {
		List<Integer> e1 = getSexFcMMse(eRe1, calibrations);
		List<Integer> e2 = getSexFcMMse(eRe2, calibrations);
		List<Integer> e3 = getSexFcMMse(eRe3, calibrations);
		List<Integer> e4 = getSexFcMMse(eRe4, calibrations);
		return e1.get(2) * (e1.get(1) - cords_) * (e1.get(1) - cords_)
				+ e2.get(2) * (e2.get(1) - cords_) * (e2.get(1) - cords_)
				+ e3.get(2) * (e3.get(1) - cords_) * (e3.get(1) - cords_)
				+ e4.get(2) * (e4.get(1) - cords_) * (e4.get(1) - cords_)
				+ e1.get(5) * (e1.get(4) - cords_) * (e1.get(4) - cords_)
				+ e2.get(5) * (e2.get(4) - cords_) * (e2.get(4) - cords_)
				+ e3.get(5) * (e3.get(4) - cords_) * (e3.get(4) - cords_)
				+ e4.get(5) * (e4.get(4) - cords_) * (e4.get(4) - cords_);
	}

	public List<Integer> getSexFcMMse(List<RecordMOVO> eRe, int call) {
		List<Integer> sex_fc = new ArrayList<Integer>();
		List<RecordMOVO> man = new ArrayList<RecordMOVO>();// 男 前
		List<RecordMOVO> woman = new ArrayList<RecordMOVO>();// 男 后
		int m = 0;
		int wo = 0;
		for (int i = 0; i < eRe.size(); i++) {
			RecordMOVO e = eRe.get(i);
			RUser r = rUserDao.findById(e.getUserId());
			if (r.getGender() == 0) {// 女
				m += assessUtil.getMMSEMOCAONE(e, call);
				woman.add(e);
			} else {
				wo += assessUtil.getMMSEMOCAONE(e, call);
				man.add(e);
			}
		}

		sex_fc.add(m);
		sex_fc.add(m / man.size());
		sex_fc.add(man.size());
		sex_fc.add(wo);
		sex_fc.add(wo / woman.size());
		sex_fc.add(woman.size());
		return sex_fc;

	}

	public Double getSST(List<RecordVO> eRe, Double c) {
		double s = 0;
		for (RecordVO v : eRe) {
			double m = getScore(v);
			s += m * m;
		}
		return s = s - c;
	}

	public Double getSSAB(List<RecordVO> eRe1, List<RecordVO> eRe2,
			List<RecordVO> eRe3, List<RecordVO> eRe4, double cords_) {
		List<Integer> e1 = getSexFc(eRe1);
		List<Integer> e2 = getSexFc(eRe2);
		List<Integer> e3 = getSexFc(eRe3);
		List<Integer> e4 = getSexFc(eRe4);
		return e1.get(2) * (e1.get(1) - cords_) * (e1.get(1) - cords_)
				+ e2.get(2) * (e2.get(1) - cords_) * (e2.get(1) - cords_)
				+ e3.get(2) * (e3.get(1) - cords_) * (e3.get(1) - cords_)
				+ e4.get(2) * (e4.get(1) - cords_) * (e4.get(1) - cords_)
				+ e1.get(5) * (e1.get(4) - cords_) * (e1.get(4) - cords_)
				+ e2.get(5) * (e2.get(4) - cords_) * (e2.get(4) - cords_)
				+ e3.get(5) * (e3.get(4) - cords_) * (e3.get(4) - cords_)
				+ e4.get(5) * (e4.get(4) - cords_) * (e4.get(4) - cords_);
	}

	public List<Integer> getSexFc(List<RecordVO> eRe) {
		List<Integer> sex_fc = new ArrayList<Integer>();
		List<RecordVO> man = new ArrayList<RecordVO>();// 男 前
		List<RecordVO> woman = new ArrayList<RecordVO>();// 男 后
		for (int i = 0; i < eRe.size(); i++) {
			RecordVO e = eRe.get(i);
			RUser r = rUserDao.findById(e.getUserId());
			if (r.getGender() == 0) {// 女
				woman.add(e);
			} else {
				man.add(e);
			}
		}
		int m = getScroe(man);
		int wo = getScroe(woman);
		sex_fc.add(m);
		sex_fc.add(m / man.size());
		sex_fc.add(man.size());
		sex_fc.add(wo);
		sex_fc.add(wo / woman.size());
		sex_fc.add(woman.size());
		return sex_fc;

	}

	/**
	 * 血压检测
	 * 
	 * @param pres
	 * @return
	 */
	public static Double getMPressure(List<MPressureVO> pres) {
		double score = 0.0;
		/*
		 * 收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；
		 * 舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；
		 */
		for (MPressureVO m : pres) {
			double  hp=0.0;
			double  lp=0.0;
			if(m.getHighPressures()!=null){
				hp = m.getHighPressures();
			}
			if(m.getHighPressures()!=null){
				lp = m.getLowPressures();
			}
			if (hp >= 90 && hp <= 140) {
				score += 1;
			} else {
				score += 0.1;
			}
			if (lp >= 60 && lp <= 90) {
				score += 1;
			} else {
				score += 0.1;
			}

		}
		return score;
	}

	public static Double getMPressure(double hp, double lp) {
		double score = 0.0;
		if (hp >= 90 && hp <= 140) {
			score += 1;
		} else {
			score += 0.1;
		}
		if (lp >= 60 && lp <= 90) {
			score += 1;
		} else {
			score += 0.1;
		}
		return score;
	}

	public static Double getMPressureq(List<MPressureVO> pres, double cords,
			double evg) {
		double score = 0.0;
		/*
		 * 收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；
		 * 舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；
		 */
		for (MPressureVO m : pres) {
			double hp = m.getHighPressures();
			//double lp = m.getLowPressures();
			double core = 0.0;
			if (hp >= 90 && hp <= 140) {
				core += 1;
			} else {
				core += 0.1;
			}
			if (hp >= 60 && hp <= 90) {
				core += 1;
			} else {
				core += 0.1;
			}
			core = Math.pow(core - cords, 2) / evg;
			score += core;
		}
		return score;
	}

	public static Double getTslq(List<FitnessVO1> recod, double cords, int evg,
			int calibrations) {
		double score = 0.0;
		for (FitnessVO1 v1 : recod) {
			double resulet = v1.getResultS();
			resulet = Math.pow(resulet - cords, 2) / evg;
			if (v1.getSex() == 0 && calibrations == 5) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 52)
						score += 5.0;
					else if (resulet <= 60 && resulet > 52)
						score += 10.0;
					else if (resulet <= 66 && resulet > 60)
						score += 15.0;
					else if (resulet <= 71 && resulet > 66)
						score += 20.0;
					else if (resulet <= 75 && resulet > 71)
						score += 25.0;
					else if (resulet <= 79 && resulet > 75)
						score += 30.0;
					else if (resulet <= 82 && resulet > 79)
						score += 35.0;
					else if (resulet <= 85 && resulet > 82)
						score += 40.0;
					else if (resulet <= 88 && resulet > 85)
						score += 45.0;
					else if (resulet <= 91 && resulet > 88)
						score += 50.0;
					else if (resulet <= 94 && resulet > 91)
						score += 55.0;
					else if (resulet <= 97 && resulet > 94)
						score += 60.0;
					else if (resulet <= 100 && resulet > 97)
						score += 65.0;
					else if (resulet <= 103 && resulet > 100)
						score += 70.0;
					else if (resulet <= 107 && resulet > 103)
						score += 75.0;
					else if (resulet <= 111 && resulet > 107)
						score += 80.0;
					else if (resulet <= 116 && resulet > 111)
						score += 85.0;
					else if (resulet <= 122 && resulet > 116)
						score += 90.0;
					else if (resulet > 122)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 47)
						score += 5.0;
					else if (resulet <= 57 && resulet > 47)
						score += 10.0;
					else if (resulet <= 63 && resulet > 57)
						score += 15.0;
					else if (resulet <= 68 && resulet > 63)
						score += 20.0;
					else if (resulet <= 73 && resulet > 68)
						score += 25.0;
					else if (resulet <= 76 && resulet > 73)
						score += 30.0;
					else if (resulet <= 80 && resulet > 76)
						score += 35.0;
					else if (resulet <= 84 && resulet > 80)
						score += 40.0;
					else if (resulet <= 87 && resulet > 84)
						score += 45.0;
					else if (resulet <= 90 && resulet > 87)
						score += 50.0;
					else if (resulet <= 93 && resulet > 90)
						score += 55.0;
					else if (resulet <= 96 && resulet > 93)
						score += 60.0;
					else if (resulet <= 100 && resulet > 96)
						score += 65.0;
					else if (resulet <= 104 && resulet > 100)
						score += 70.0;
					else if (resulet <= 107 && resulet > 104)
						score += 75.0;
					else if (resulet <= 112 && resulet > 107)
						score += 80.0;
					else if (resulet <= 117 && resulet > 112)
						score += 85.0;
					else if (resulet <= 123 && resulet > 117)
						score += 90.0;
					else if (resulet > 123)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 43)
						score += 5.0;
					else if (resulet <= 52 && resulet > 43)
						score += 10.0;
					else if (resulet <= 58 && resulet > 52)
						score += 15.0;
					else if (resulet <= 63 && resulet > 58)
						score += 20.0;
					else if (resulet <= 68 && resulet > 63)
						score += 25.0;
					else if (resulet <= 71 && resulet > 68)
						score += 30.0;
					else if (resulet <= 74 && resulet > 71)
						score += 35.0;
					else if (resulet <= 78 && resulet > 74)
						score += 40.0;
					else if (resulet <= 81 && resulet > 78)
						score += 45.0;
					else if (resulet <= 84 && resulet > 81)
						score += 50.0;
					else if (resulet <= 87 && resulet > 84)
						score += 55.0;
					else if (resulet <= 90 && resulet > 87)
						score += 60.0;
					else if (resulet <= 94 && resulet > 90)
						score += 65.0;
					else if (resulet <= 97 && resulet > 94)
						score += 70.0;
					else if (resulet <= 101 && resulet > 97)
						score += 75.0;
					else if (resulet <= 105 && resulet > 101)
						score += 80.0;
					else if (resulet <= 110 && resulet > 105)
						score += 85.0;
					else if (resulet > 116)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 45)
						score += 5.0;
					else if (resulet <= 53 && resulet > 45)
						score += 10.0;
					else if (resulet <= 59 && resulet > 53)
						score += 15.0;
					else if (resulet <= 64 && resulet > 59)
						score += 20.0;
					else if (resulet <= 68 && resulet > 64)
						score += 25.0;
					else if (resulet <= 72 && resulet > 68)
						score += 30.0;
					else if (resulet <= 75 && resulet > 72)
						score += 35.0;
					else if (resulet <= 78 && resulet > 75)
						score += 40.0;
					else if (resulet <= 81 && resulet > 78)
						score += 45.0;
					else if (resulet <= 84 && resulet > 81)
						score += 50.0;
					else if (resulet <= 87 && resulet > 84)
						score += 55.0;
					else if (resulet <= 90 && resulet > 87)
						score += 60.0;
					else if (resulet <= 93 && resulet > 90)
						score += 65.0;
					else if (resulet <= 96 && resulet > 93)
						score += 70.0;
					else if (resulet <= 100 && resulet > 96)
						score += 75.0;
					else if (resulet <= 104 && resulet > 100)
						score += 80.0;
					else if (resulet <= 109 && resulet > 104)
						score += 85.0;
					else if (resulet <= 115 && resulet > 109)
						score += 90.0;
					else if (resulet > 115)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 37)
						score += 5.0;
					else if (resulet <= 46 && resulet > 37)
						score += 10.0;
					else if (resulet <= 51 && resulet > 46)
						score += 15.0;
					else if (resulet <= 56 && resulet > 51)
						score += 20.0;
					else if (resulet <= 60 && resulet > 56)
						score += 25.0;
					else if (resulet <= 63 && resulet > 60)
						score += 30.0;
					else if (resulet <= 66 && resulet > 63)
						score += 35.0;
					else if (resulet <= 69 && resulet > 66)
						score += 40.0;
					else if (resulet <= 72 && resulet > 69)
						score += 45.0;
					else if (resulet <= 75 && resulet > 72)
						score += 50.0;
					else if (resulet <= 78 && resulet > 75)
						score += 55.0;
					else if (resulet <= 81 && resulet > 78)
						score += 60.0;
					else if (resulet <= 84 && resulet > 81)
						score += 65.0;
					else if (resulet <= 87 && resulet > 84)
						score += 70.0;
					else if (resulet <= 90 && resulet > 87)
						score += 75.0;
					else if (resulet <= 94 && resulet > 90)
						score += 80.0;
					else if (resulet <= 99 && resulet > 94)
						score += 85.0;
					else if (resulet <= 104 && resulet > 99)
						score += 90.0;
					else if (resulet > 104)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 39)
						score += 5.0;
					else if (resulet <= 42 && resulet > 39)
						score += 10.0;
					else if (resulet <= 47 && resulet > 42)
						score += 15.0;
					else if (resulet <= 52 && resulet > 47)
						score += 20.0;
					else if (resulet <= 55 && resulet > 52)
						score += 25.0;
					else if (resulet <= 59 && resulet > 55)
						score += 30.0;
					else if (resulet <= 61 && resulet > 59)
						score += 35.0;
					else if (resulet <= 64 && resulet > 61)
						score += 40.0;
					else if (resulet <= 67 && resulet > 64)
						score += 45.0;
					else if (resulet <= 70 && resulet > 67)
						score += 50.0;
					else if (resulet <= 73 && resulet > 70)
						score += 55.0;
					else if (resulet <= 76 && resulet > 73)
						score += 60.0;
					else if (resulet <= 79 && resulet > 76)
						score += 65.0;
					else if (resulet <= 81 && resulet > 79)
						score += 70.0;
					else if (resulet <= 85 && resulet > 81)
						score += 75.0;
					else if (resulet <= 88 && resulet > 85)
						score += 80.0;
					else if (resulet <= 93 && resulet > 88)
						score += 85.0;
					else if (resulet <= 98 && resulet > 93)
						score += 90.0;
					else if (resulet > 98)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet <= 24)
						score += 5.0;
					else if (resulet <= 31 && resulet > 24)
						score += 10.0;
					else if (resulet <= 36 && resulet > 31)
						score += 15.0;
					else if (resulet <= 40 && resulet > 36)
						score += 20.0;
					else if (resulet <= 44 && resulet > 40)
						score += 25.0;
					else if (resulet <= 47 && resulet > 44)
						score += 30.0;
					else if (resulet <= 50 && resulet > 47)
						score += 35.0;
					else if (resulet <= 53 && resulet > 50)
						score += 40.0;
					else if (resulet <= 55 && resulet > 53)
						score += 45.0;
					else if (resulet <= 58 && resulet > 55)
						score += 50.0;
					else if (resulet <= 61 && resulet > 58)
						score += 55.0;
					else if (resulet <= 63 && resulet > 61)
						score += 60.0;
					else if (resulet <= 66 && resulet > 63)
						score += 65.0;
					else if (resulet <= 69 && resulet > 66)
						score += 70.0;
					else if (resulet <= 72 && resulet > 69)
						score += 75.0;
					else if (resulet <= 76 && resulet > 72)
						score += 80.0;
					else if (resulet <= 80 && resulet > 76)
						score += 85.0;
					else if (resulet <= 85 && resulet > 80)
						score += 90.0;
					else if (resulet > 85)
						score += 95.0;
				}
			}
			if (v1.getSex() == 0 && calibrations == 6) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet >= -6.4 && resulet < -5.2)
						score += 5.0;
					else if (resulet >= -5.2 && resulet < -4.3)
						score += 10.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 15.0;
					else if (resulet >= -3.6 && resulet < -3)
						score += 20.0;
					else if (resulet >= -3 && resulet < -2.5)
						score += 25.0;
					else if (resulet >= -2.5 && resulet < -2.1)
						score += 30.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 35.0;
					else if (resulet >= -1.6 && resulet < -1.2)
						score += 40.0;
					else if (resulet >= -1.2 && resulet < -0.7)
						score += 45.0;
					else if (resulet >= -0.7 && resulet < -0.2)
						score += 50.0;
					else if (resulet >= -0.2 && resulet < 0.2)
						score += 55.0;
					else if (resulet >= 0.2 && resulet < 0.7)
						score += 60.0;
					else if (resulet >= 0.7 && resulet < 1.1)
						score += 65.0;
					else if (resulet >= 1.1 && resulet < 1.6)
						score += 70.0;
					else if (resulet >= 1.6 && resulet < 2.2)
						score += 75.0;
					else if (resulet >= 2.2 && resulet < 2.9)
						score += 80.0;
					else if (resulet >= 2.9 && resulet < 3.8)
						score += 85.0;
					else if (resulet >= 3.8 && resulet < 5)
						score += 90.0;
					else if (resulet >= 5)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet >= -7.3 && resulet < -5.9)
						score += 5.0;
					else if (resulet >= -5.9 && resulet < -5)
						score += 10.0;
					else if (resulet >= -5 && resulet < -4.3)
						score += 15.0;
					else if (resulet >= -4.3 && resulet < -3.7)
						score += 20.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 25.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 30.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 35.0;
					else if (resulet >= -2.1 && resulet < -1.7)
						score += 40.0;
					else if (resulet >= -1.7 && resulet < -1.2)
						score += 45.0;
					else if (resulet >= -1.2 && resulet < -0.7)
						score += 50.0;
					else if (resulet >= -0.7 && resulet < -0.3)
						score += 55.0;
					else if (resulet >= -0.3 && resulet < 0.2)
						score += 60.0;
					else if (resulet >= 0.2 && resulet < 0.7)
						score += 65.0;
					else if (resulet >= 0.7 && resulet < 1.3)
						score += 70.0;
					else if (resulet >= 1.3 && resulet < 1.9)
						score += 75.0;
					else if (resulet >= 1.9 && resulet < 2.6)
						score += 80.0;
					else if (resulet >= 2.6 && resulet < 3.5)
						score += 85.0;
					else if (resulet >= 3.5 && resulet < 4.9)
						score += 90.0;
					else if (resulet >= 4.9)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 43)
						score += 5.0;
					else if (resulet <= 52 && resulet > 43)
						score += 10.0;
					if (resulet >= -7.9 && resulet < -6.6)
						score += 5.0;
					else if (resulet >= -6.6 && resulet < -5.7)
						score += 10.0;
					else if (resulet >= -5.7 && resulet < -4.9)
						score += 15.0;
					else if (resulet >= -4.9 && resulet < -4.2)
						score += 20.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 25.0;
					else if (resulet >= -3.7 && resulet < -3.2)
						score += 30.0;
					else if (resulet >= -3.2 && resulet < -2.6)
						score += 35.0;
					else if (resulet >= -2.6 && resulet < -2.2)
						score += 40.0;
					else if (resulet >= -2.2 && resulet < -1.7)
						score += 45.0;
					else if (resulet >= -1.7 && resulet < -1.2)
						score += 50.0;
					else if (resulet >= -1.2 && resulet < -0.8)
						score += 55.0;
					else if (resulet >= -0.8 && resulet < -0.2)
						score += 60.0;
					else if (resulet >= -0.2 && resulet < 0.3)
						score += 65.0;
					else if (resulet >= 0.3 && resulet < 0.8)
						score += 70.0;
					else if (resulet >= 0.8 && resulet < 1.5)
						score += 75.0;
					else if (resulet >= 1.5 && resulet < 2.3)
						score += 80.0;
					else if (resulet >= 2.3 && resulet < 3.2)
						score += 85.0;
					else if (resulet >= 3.2 && resulet < 4.5)
						score += 90.0;
					else if (resulet >= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 8.9 && resulet > 8.3)
						score += 5.0;
					else if (resulet <= 8.3 && resulet > 8)
						score += 10.0;
					else if (resulet <= 8 && resulet > 7.6)
						score += 15.0;
					else if (resulet <= 7.6 && resulet > 7.4)
						score += 20.0;
					else if (resulet <= 7.4 && resulet > 7.1)
						score += 25.0;
					else if (resulet <= 7.1 && resulet > 6.9)
						score += 30.0;
					else if (resulet <= 6.9 && resulet > 6.7)
						score += 35.0;
					else if (resulet <= 6.7 && resulet > 6.5)
						score += 40.0;
					else if (resulet <= 6.5 && resulet > 6.3)
						score += 45.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 50.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 55.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 60.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 65.0;
					else if (resulet <= 5.5 && resulet > 5.2)
						score += 70.0;
					else if (resulet <= 5.2 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.6)
						score += 80.0;
					else if (resulet <= 4.6 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet >= -9.5 && resulet < -8)
						score += 5.0;
					else if (resulet >= -8 && resulet < -7)
						score += 10.0;
					else if (resulet >= -7 && resulet < -6.1)
						score += 15.0;
					else if (resulet >= -6.1 && resulet < -5.4)
						score += 20.0;
					else if (resulet >= -5.4 && resulet < -4.8)
						score += 25.0;
					else if (resulet >= -4.8 && resulet < -4.2)
						score += 30.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 35.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 40.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 45.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 50.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 55.0;
					else if (resulet >= -1.6 && resulet < -1)
						score += 60.0;
					else if (resulet >= -1 && resulet < -0.4)
						score += 65.0;
					else if (resulet >= -0.4 && resulet < 0.2)
						score += 70.0;
					else if (resulet >= 0.2 && resulet < 0.9)
						score += 75.0;
					else if (resulet >= 0.9 && resulet < 1.8)
						score += 80.0;
					else if (resulet >= 2.8 && resulet < 2.8)
						score += 85.0;
					else if (resulet >= 2.8 && resulet < 4.3)
						score += 90.0;
					else if (resulet >= 4.3)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet >= -11.3 && resulet < -9.7)
						score += 5.0;
					else if (resulet >= -9.7 && resulet < -8.6)
						score += 10.0;
					else if (resulet >= -8.6 && resulet < -7.7)
						score += 15.0;
					else if (resulet >= -7.7 && resulet < -6.9)
						score += 20.0;
					else if (resulet >= -6.9 && resulet < -6.2)
						score += 25.0;
					else if (resulet >= -6.2 && resulet < -5.7)
						score += 30.0;
					else if (resulet >= -5.7 && resulet < -5)
						score += 35.0;
					else if (resulet >= -5 && resulet < -4.5)
						score += 40.0;
					else if (resulet >= -4.5 && resulet < -3.9)
						score += 45.0;
					else if (resulet >= -3.9 && resulet < -3.3)
						score += 50.0;
					else if (resulet >= -3.3 && resulet < -2.8)
						score += 55.0;
					else if (resulet >= -2.8 && resulet < -2.1)
						score += 60.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 65.0;
					else if (resulet >= -1.6 && resulet < -0.9)
						score += 70.0;
					else if (resulet >= -0.9 && resulet < -0.1)
						score += 75.0;
					else if (resulet >= -0.1 && resulet < 1.8)
						score += 80.0;
					else if (resulet >= 1.8 && resulet < 1.9)
						score += 85.0;
					else if (resulet >= 1.9 && resulet < 3.5)
						score += 90.0;
					else if (resulet >= 3.5)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet >= -13 && resulet < -11.2)
						score += 5.0;
					else if (resulet >= -11.2 && resulet < -9.9)
						score += 10.0;
					else if (resulet >= -9.9 && resulet < -8.9)
						score += 15.0;
					else if (resulet >= -8.9 && resulet < -8)
						score += 20.0;
					else if (resulet >= -8 && resulet < -7.2)
						score += 25.0;
					else if (resulet >= -7.2 && resulet < -6.5)
						score += 30.0;
					else if (resulet >= -6.5 && resulet < -5.8)
						score += 35.0;
					else if (resulet >= -5.8 && resulet < -5.2)
						score += 40.0;
					else if (resulet >= -5.2 && resulet < -4.5)
						score += 45.0;
					else if (resulet >= -4.5 && resulet < -3.8)
						score += 50.0;
					else if (resulet >= -3.8 && resulet < -3.2)
						score += 55.0;
					else if (resulet >= -3.2 && resulet < -2.5)
						score += 60.0;
					else if (resulet >= -2.5 && resulet < -1.8)
						score += 65.0;
					else if (resulet >= -1.8 && resulet < -1)
						score += 70.0;
					else if (resulet >= -1 && resulet < -0.1)
						score += 75.0;
					else if (resulet >= -0.1 && resulet < 0.9)
						score += 80.0;
					else if (resulet >= 0.9 && resulet < 2.2)
						score += 85.0;
					else if (resulet >= 2.2 && resulet < 3.9)
						score += 90.0;
					else if (resulet >= 3.9)
						score += 95.0;
				}
			}
			if (v1.getSex() == 0 && calibrations == 7) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {

					if (resulet <= 7.2 && resulet > 6.7)
						score += 5.0;
					else if (resulet <= 6.7 && resulet > 6.4)
						score += 10.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 15.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 20.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 25.0;
					else if (resulet <= 5.8 && resulet > 5.7)
						score += 30.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 35.0;
					else if (resulet <= 5.5 && resulet > 5.4)
						score += 40.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 45.0;
					else if (resulet <= 5.2 && resulet > 5)
						score += 50.0;
					else if (resulet <= 5 && resulet > 4.9)
						score += 55.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 60.0;
					else if (resulet <= 4.7 && resulet > 4.6)
						score += 65.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 70.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 75.0;
					else if (resulet <= 4.2 && resulet > 4)
						score += 80.0;
					else if (resulet <= 4 && resulet > 3.7)
						score += 85.0;
					else if (resulet <= 3.7 && resulet > 3.2)
						score += 90.0;
					else if (resulet <= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 7.6 && resulet > 7.1)
						score += 5.0;
					else if (resulet <= 7.1 && resulet > 6.8)
						score += 10.0;
					else if (resulet <= 6.8 && resulet > 6.6)
						score += 15.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 20.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 25.0;
					else if (resulet <= 6.2 && resulet > 6.1)
						score += 30.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 35.0;
					else if (resulet <= 5.9 && resulet > 5.8)
						score += 40.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 45.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 50.0;
					else if (resulet <= 5.4 && resulet > 5.3)
						score += 55.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 60.0;
					else if (resulet <= 5.1 && resulet > 5)
						score += 65.0;
					else if (resulet <= 5 && resulet > 4.8)
						score += 70.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 75.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 80.0;
					else if (resulet <= 4.4 && resulet > 4.1)
						score += 85.0;
					else if (resulet <= 4.1 && resulet > 3.6)
						score += 90.0;
					else if (resulet <= 3.6)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 8.6 && resulet > 8)
						score += 5.0;
					else if (resulet <= 8 && resulet > 7.7)
						score += 10.0;
					else if (resulet <= 7.7 && resulet > 7.3)
						score += 15.0;
					else if (resulet <= 7.3 && resulet > 7.1)
						score += 20.0;
					else if (resulet <= 7.1 && resulet > 6.8)
						score += 25.0;
					else if (resulet <= 6.8 && resulet > 6.6)
						score += 30.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 35.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 40.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 45.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 50.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 55.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 60.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 65.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 70.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 75.0;
					else if (resulet <= 4.7 && resulet > 4.3)
						score += 80.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 85.0;
					else if (resulet <= 4 && resulet > 3.8)
						score += 90.0;
					else if (resulet <= 3.8)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet >= -8.8 && resulet < -7.3)
						score += 5.0;
					else if (resulet >= -7.3 && resulet < -6.4)
						score += 10.0;
					else if (resulet >= -6.4 && resulet < -5.5)
						score += 15.0;
					else if (resulet >= -5.5 && resulet < -4.8)
						score += 20.0;
					else if (resulet >= -4.8 && resulet < -4.2)
						score += 25.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 30.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 35.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 40.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 45.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 50.0;
					else if (resulet >= -1.6 && resulet < -1.1)
						score += 55.0;
					else if (resulet >= -1.1 && resulet < -0.5)
						score += 60.0;
					else if (resulet >= -0.5 && resulet < 0)
						score += 65.0;
					else if (resulet >= 0 && resulet < 0.6)
						score += 70.0;
					else if (resulet >= 0.6 && resulet < 1.3)
						score += 75.0;
					else if (resulet >= 1.3 && resulet < 2.2)
						score += 80.0;
					else if (resulet >= 2.2 && resulet < 3.1)
						score += 85.0;
					else if (resulet >= 3.1 && resulet < 4.5)
						score += 90.0;
					else if (resulet >= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 10.8 && resulet > 10)
						score += 5.0;
					else if (resulet <= 10 && resulet > 9.5)
						score += 10.0;
					else if (resulet <= 9.5 && resulet > 9)
						score += 15.0;
					else if (resulet <= 9 && resulet > 8.7)
						score += 20.0;
					else if (resulet <= 8.7 && resulet > 8.3)
						score += 25.0;
					else if (resulet <= 8.3 && resulet > 8.1)
						score += 30.0;
					else if (resulet <= 8.1 && resulet > 7.8)
						score += 35.0;
					else if (resulet <= 7.8 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.7)
						score += 55.0;
					else if (resulet <= 6.7 && resulet > 6.3)
						score += 60.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 65.0;
					else if (resulet <= 6.1 && resulet > 5.7)
						score += 70.0;
					else if (resulet <= 5.7 && resulet > 5.4)
						score += 75.0;
					else if (resulet <= 5.4 && resulet > 4.9)
						score += 80.0;
					else if (resulet <= 4.9 && resulet > 4.4)
						score += 85.0;
					else if (resulet <= 4.4 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 12 && resulet > 11.1)
						score += 5.0;
					else if (resulet <= 11.1 && resulet > 10.5)
						score += 10.0;
					else if (resulet <= 10.5 && resulet > 10)
						score += 15.0;
					else if (resulet <= 10 && resulet > 9.6)
						score += 20.0;
					else if (resulet <= 9.6 && resulet > 9.2)
						score += 25.0;
					else if (resulet <= 9.2 && resulet > 8.9)
						score += 30.0;
					else if (resulet <= 8.9 && resulet > 8.5)
						score += 35.0;
					else if (resulet <= 8.5 && resulet > 8.2)
						score += 40.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 45.0;
					else if (resulet <= 7.9 && resulet > 7.6)
						score += 50.0;
					else if (resulet <= 7.6 && resulet > 7.3)
						score += 55.0;
					else if (resulet <= 7.3 && resulet > 6.9)
						score += 60.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 65.0;
					else if (resulet <= 6.6 && resulet > 6.2)
						score += 70.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 75.0;
					else if (resulet <= 5.8 && resulet > 5.3)
						score += 80.0;
					else if (resulet <= 5.3 && resulet > 4.7)
						score += 85.0;
					else if (resulet <= 4.7 && resulet > 4.5)
						score += 90.0;
					else if (resulet <= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet <= 14.6 && resulet > 13.5)
						score += 5.0;
					else if (resulet <= 13.5 && resulet > 12.7)
						score += 10.0;
					else if (resulet <= 12.7 && resulet > 12.1)
						score += 15.0;
					else if (resulet <= 12.1 && resulet > 11.5)
						score += 20.0;
					else if (resulet <= 11.5 && resulet > 11.1)
						score += 25.0;
					else if (resulet <= 11.1 && resulet > 10.6)
						score += 30.0;
					else if (resulet <= 10.6 && resulet > 10.2)
						score += 35.0;
					else if (resulet <= 10.2 && resulet > 9.8)
						score += 40.0;
					else if (resulet <= 9.8 && resulet > 9.4)
						score += 45.0;
					else if (resulet <= 9.4 && resulet > 9)
						score += 50.0;
					else if (resulet <= 9 && resulet > 8.6)
						score += 55.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 60.0;
					else if (resulet <= 8.2 && resulet > 7.7)
						score += 65.0;
					else if (resulet <= 7.7 && resulet > 7.3)
						score += 70.0;
					else if (resulet <= 7.3 && resulet > 6.7)
						score += 75.0;
					else if (resulet <= 6.7 && resulet > 6.1)
						score += 80.0;
					else if (resulet <= 6.1 && resulet > 5.3)
						score += 85.0;
					else if (resulet <= 5.3 && resulet > 5)
						score += 90.0;
					else if (resulet <= 5)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 5) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 74 && resulet > 67)
						score += 10.0;
					else if (resulet <= 79 && resulet > 74)
						score += 15.0;
					else if (resulet <= 83 && resulet > 79)
						score += 20.0;
					else if (resulet <= 87 && resulet > 83)
						score += 25.0;
					else if (resulet <= 90 && resulet > 87)
						score += 30.0;
					else if (resulet <= 93 && resulet > 90)
						score += 35.0;
					else if (resulet <= 96 && resulet > 93)
						score += 40.0;
					else if (resulet <= 98 && resulet > 96)
						score += 45.0;
					else if (resulet <= 101 && resulet > 98)
						score += 50.0;
					else if (resulet <= 104 && resulet > 101)
						score += 55.0;
					else if (resulet <= 106 && resulet > 104)
						score += 60.0;
					else if (resulet <= 109 && resulet > 106)
						score += 65.0;
					else if (resulet <= 112 && resulet > 109)
						score += 70.0;
					else if (resulet <= 115 && resulet > 112)
						score += 75.0;
					else if (resulet <= 119 && resulet > 115)
						score += 80.0;
					else if (resulet <= 123 && resulet > 119)
						score += 85.0;
					else if (resulet <= 128 && resulet > 123)
						score += 90.0;
					else if (resulet > 128)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 72 && resulet > 67)
						score += 10.0;
					else if (resulet <= 77 && resulet > 72)
						score += 15.0;
					else if (resulet <= 82 && resulet > 77)
						score += 20.0;
					else if (resulet <= 86 && resulet > 82)
						score += 25.0;
					else if (resulet <= 89 && resulet > 86)
						score += 30.0;
					else if (resulet <= 92 && resulet > 89)
						score += 35.0;
					else if (resulet <= 95 && resulet > 92)
						score += 40.0;
					else if (resulet <= 98 && resulet > 95)
						score += 45.0;
					else if (resulet <= 101 && resulet > 98)
						score += 50.0;
					else if (resulet <= 104 && resulet > 101)
						score += 55.0;
					else if (resulet <= 107 && resulet > 104)
						score += 60.0;
					else if (resulet <= 110 && resulet > 107)
						score += 65.0;
					else if (resulet <= 113 && resulet > 110)
						score += 70.0;
					else if (resulet <= 116 && resulet > 113)
						score += 75.0;
					else if (resulet <= 120 && resulet > 116)
						score += 80.0;
					else if (resulet <= 125 && resulet > 120)
						score += 85.0;
					else if (resulet <= 130 && resulet > 125)
						score += 90.0;
					else if (resulet > 130)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 66 && resulet > 67)
						score += 10.0;
					else if (resulet <= 71 && resulet > 66)
						score += 15.0;
					else if (resulet <= 76 && resulet > 71)
						score += 20.0;
					else if (resulet <= 80 && resulet > 76)
						score += 25.0;
					else if (resulet <= 83 && resulet > 80)
						score += 30.0;
					else if (resulet <= 86 && resulet > 83)
						score += 35.0;
					else if (resulet <= 89 && resulet > 86)
						score += 40.0;
					else if (resulet <= 92 && resulet > 89)
						score += 45.0;
					else if (resulet <= 95 && resulet > 92)
						score += 50.0;
					else if (resulet <= 98 && resulet > 95)
						score += 55.0;
					else if (resulet <= 101 && resulet > 98)
						score += 60.0;
					else if (resulet <= 104 && resulet > 101)
						score += 65.0;
					else if (resulet <= 107 && resulet > 104)
						score += 70.0;
					else if (resulet <= 110 && resulet > 107)
						score += 75.0;
					else if (resulet <= 114 && resulet > 110)
						score += 80.0;
					else if (resulet <= 119 && resulet > 114)
						score += 85.0;
					else if (resulet <= 124 && resulet > 119)
						score += 90.0;
					else if (resulet > 124)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 47)
						score += 5.0;
					else if (resulet <= 56 && resulet > 47)
						score += 10.0;
					else if (resulet <= 63 && resulet > 56)
						score += 15.0;
					else if (resulet <= 68 && resulet > 63)
						score += 20.0;
					else if (resulet <= 73 && resulet > 68)
						score += 25.0;
					else if (resulet <= 77 && resulet > 73)
						score += 30.0;
					else if (resulet <= 80 && resulet > 77)
						score += 35.0;
					else if (resulet <= 84 && resulet > 80)
						score += 40.0;
					else if (resulet <= 87 && resulet > 84)
						score += 45.0;
					else if (resulet <= 91 && resulet > 87)
						score += 50.0;
					else if (resulet <= 95 && resulet > 91)
						score += 55.0;
					else if (resulet <= 98 && resulet > 95)
						score += 60.0;
					else if (resulet <= 102 && resulet > 98)
						score += 65.0;
					else if (resulet <= 105 && resulet > 102)
						score += 70.0;
					else if (resulet <= 109 && resulet > 105)
						score += 75.0;
					else if (resulet <= 114 && resulet > 109)
						score += 80.0;
					else if (resulet <= 119 && resulet > 114)
						score += 85.0;
					else if (resulet <= 126 && resulet > 119)
						score += 90.0;
					else if (resulet > 126)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 48)
						score += 5.0;
					else if (resulet <= 56 && resulet > 48)
						score += 10.0;
					else if (resulet <= 62 && resulet > 56)
						score += 15.0;
					else if (resulet <= 67 && resulet > 62)
						score += 20.0;
					else if (resulet <= 71 && resulet > 67)
						score += 25.0;
					else if (resulet <= 75 && resulet > 71)
						score += 30.0;
					else if (resulet <= 78 && resulet > 75)
						score += 35.0;
					else if (resulet <= 81 && resulet > 78)
						score += 40.0;
					else if (resulet <= 84 && resulet > 81)
						score += 45.0;
					else if (resulet <= 87 && resulet > 84)
						score += 50.0;
					else if (resulet <= 90 && resulet > 87)
						score += 55.0;
					else if (resulet <= 93 && resulet > 90)
						score += 60.0;
					else if (resulet <= 96 && resulet > 93)
						score += 65.0;
					else if (resulet <= 99 && resulet > 96)
						score += 70.0;
					else if (resulet <= 103 && resulet > 99)
						score += 75.0;
					else if (resulet <= 107 && resulet > 103)
						score += 80.0;
					else if (resulet <= 112 && resulet > 107)
						score += 85.0;
					else if (resulet <= 118 && resulet > 112)
						score += 90.0;
					else if (resulet > 118)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 36)
						score += 5.0;
					else if (resulet <= 44 && resulet > 36)
						score += 10.0;
					else if (resulet <= 50 && resulet > 44)
						score += 15.0;
					else if (resulet <= 55 && resulet > 50)
						score += 20.0;
					else if (resulet <= 59 && resulet > 55)
						score += 25.0;
					else if (resulet <= 63 && resulet > 59)
						score += 30.0;
					else if (resulet <= 66 && resulet > 63)
						score += 35.0;
					else if (resulet <= 69 && resulet > 66)
						score += 40.0;
					else if (resulet <= 72 && resulet > 69)
						score += 45.0;
					else if (resulet <= 75 && resulet > 72)
						score += 50.0;
					else if (resulet <= 78 && resulet > 75)
						score += 55.0;
					else if (resulet <= 81 && resulet > 78)
						score += 60.0;
					else if (resulet <= 84 && resulet > 81)
						score += 65.0;
					else if (resulet <= 87 && resulet > 84)
						score += 70.0;
					else if (resulet <= 91 && resulet > 87)
						score += 75.0;
					else if (resulet <= 95 && resulet > 91)
						score += 80.0;
					else if (resulet <= 100 && resulet > 95)
						score += 85.0;
					else if (resulet <= 106 && resulet > 100)
						score += 90.0;
					else if (resulet > 106)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet <= 26)
						score += 5.0;
					else if (resulet <= 36 && resulet > 26)
						score += 10.0;
					else if (resulet <= 42 && resulet > 36)
						score += 15.0;
					else if (resulet <= 47 && resulet > 42)
						score += 20.0;
					else if (resulet <= 52 && resulet > 47)
						score += 25.0;
					else if (resulet <= 55 && resulet > 52)
						score += 30.0;
					else if (resulet <= 59 && resulet > 55)
						score += 35.0;
					else if (resulet <= 62 && resulet > 59)
						score += 40.0;
					else if (resulet <= 66 && resulet > 62)
						score += 45.0;
					else if (resulet <= 69 && resulet > 66)
						score += 50.0;
					else if (resulet <= 72 && resulet > 69)
						score += 55.0;
					else if (resulet <= 76 && resulet > 72)
						score += 60.0;
					else if (resulet <= 79 && resulet > 76)
						score += 65.0;
					else if (resulet <= 83 && resulet > 79)
						score += 70.0;
					else if (resulet <= 86 && resulet > 83)
						score += 75.0;
					else if (resulet <= 91 && resulet > 86)
						score += 80.0;
					else if (resulet <= 96 && resulet > 91)
						score += 85.0;
					else if (resulet <= 102 && resulet > 96)
						score += 90.0;
					else if (resulet > 102)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 6) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet >= -11.3 && resulet < -9.5)
						score += 5.0;
					else if (resulet >= -9.5 && resulet < -8.4)
						score += 10.0;
					else if (resulet >= -8.4 && resulet < -7.4)
						score += 15.0;
					else if (resulet >= -7.4 && resulet < -6.6)
						score += 20.0;
					else if (resulet >= -6.6 && resulet < -5.9)
						score += 25.0;
					else if (resulet >= -5.9 && resulet < -5.3)
						score += 30.0;
					else if (resulet >= -5.3 && resulet < -4.6)
						score += 35.0;
					else if (resulet >= -4.6 && resulet < -4)
						score += 40.0;
					else if (resulet >= -4 && resulet < -3.4)
						score += 45.0;
					else if (resulet >= -3.4 && resulet < -2.8)
						score += 50.0;
					else if (resulet >= -2.8 && resulet < -2.2)
						score += 55.0;
					else if (resulet >= -2.2 && resulet < -1.5)
						score += 60.0;
					else if (resulet >= -1.5 && resulet < -0.9)
						score += 65.0;
					else if (resulet >= -0.9 && resulet < -0.2)
						score += 70.0;
					else if (resulet >= -0.2 && resulet < 0.6)
						score += 75.0;
					else if (resulet >= 0.6 && resulet < 1.6)
						score += 80.0;
					else if (resulet >= 1.6 && resulet < 2.7)
						score += 85.0;
					else if (resulet >= 2.7 && resulet < 4.5)
						score += 85.0;
					else if (resulet > 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet >= -12.1 && resulet < -10.4)
						score += 5.0;
					else if (resulet >= -10.4 && resulet < -9.2)
						score += 10.0;
					else if (resulet >= -9.2 && resulet < -8.2)
						score += 15.0;
					else if (resulet >= -8.2 && resulet < -7.4)
						score += 20.0;
					else if (resulet >= -7.4 && resulet < -6.6)
						score += 25.0;
					else if (resulet >= -6.6 && resulet < -6)
						score += 30.0;
					else if (resulet >= -6 && resulet < -5.3)
						score += 35.0;
					else if (resulet >= -5.3 && resulet < -4.7)
						score += 40.0;
					else if (resulet >= -4.7 && resulet < -4.1)
						score += 45.0;
					else if (resulet >= -4.1 && resulet < -3.5)
						score += 50.0;
					else if (resulet >= -3.5 && resulet < -2.9)
						score += 55.0;
					else if (resulet >= -2.9 && resulet < -2.2)
						score += 60.0;
					else if (resulet >= -2.2 && resulet < -1.6)
						score += 65.0;
					else if (resulet >= -1.6 && resulet < -0.8)
						score += 70.0;
					else if (resulet >= -0.8 && resulet < 0)
						score += 75.0;
					else if (resulet >= 0 && resulet < 1)
						score += 80.0;
					else if (resulet >= 1 && resulet < 2.2)
						score += 85.0;
					else if (resulet >= 2.2 && resulet < 3.9)
						score += 90.0;
					else if (resulet >= 3.9)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet >= -12.5 && resulet < -10.8)
						score += 5.0;
					else if (resulet >= -10.8 && resulet < -9.6)
						score += 10.0;
					else if (resulet >= -9.6 && resulet < -8.6)
						score += 15.0;
					else if (resulet >= -8.6 && resulet < -7.8)
						score += 20.0;
					else if (resulet >= -7.8 && resulet < -7)
						score += 25.0;
					else if (resulet >= -7 && resulet < -6.4)
						score += 30.0;
					else if (resulet > -6.4 && resulet < -5.7)
						score += 35.0;
					else if (resulet >= -5.7 && resulet < -5.1)
						score += 40.0;
					else if (resulet >= -5.1 && resulet < -4.5)
						score += 45.0;
					else if (resulet >= -4.5 && resulet < -3.9)
						score += 50.0;
					else if (resulet >= -3.9 && resulet < -3.3)
						score += 55.0;
					else if (resulet >= -3.3 && resulet < -2.6)
						score += 60.0;
					else if (resulet >= -2.6 && resulet < -2)
						score += 65.0;
					else if (resulet >= -2 && resulet < -1.2)
						score += 70.0;
					else if (resulet >= -1.2 && resulet < -0.4)
						score += 75.0;
					else if (resulet >= -0.4 && resulet < 0.6)
						score += 80.0;
					else if (resulet >= 0.6 && resulet < 1.8)
						score += 85.0;
					else if (resulet >= 1.8 && resulet < 3.5)
						score += 90.0;
					else if (resulet >= 3.5)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet >= -14 && resulet < -12.1)
						score += 5.0;
					else if (resulet >= -12.1 && resulet < -10.9)
						score += 10.0;
					else if (resulet >= -10.9 && resulet < -9.9)
						score += 15.0;
					else if (resulet >= -9.9 && resulet < -9)
						score += 20.0;
					else if (resulet >= -9 && resulet < -8.3)
						score += 25.0;
					else if (resulet >= -8.3 && resulet < -7.6)
						score += 30.0;
					else if (resulet >= -7.6 && resulet < -6.9)
						score += 35.0;
					else if (resulet >= -6.9 && resulet < -6.3)
						score += 40.0;
					else if (resulet >= -6.3 && resulet < -5.6)
						score += 45.0;
					else if (resulet >= -5.6 && resulet < -4.9)
						score += 50.0;
					else if (resulet >= -4.9 && resulet < -4.3)
						score += 55.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 60.0;
					else if (resulet >= -3.6 && resulet < -2.9)
						score += 65.0;
					else if (resulet >= -2.9 && resulet < -2.2)
						score += 70.0;
					else if (resulet >= -2.2 && resulet < -1.3)
						score += 75.0;
					else if (resulet >= -1.3 && resulet < -0.3)
						score += 80.0;
					else if (resulet >= -0.3 && resulet < 0.9)
						score += 85.0;
					else if (resulet >= 0.9 && resulet < 2.8)
						score += 90.0;
					else if (resulet >= 2.8)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet >= -14.6 && resulet < -12.6)
						score += 5.0;
					else if (resulet >= -12.6 && resulet < -11.3)
						score += 10.0;
					else if (resulet >= -11.3 && resulet < -10.2)
						score += 15.0;
					else if (resulet >= -10.2 && resulet < -9.3)
						score += 20.0;
					else if (resulet >= -9.3 && resulet < -8.5)
						score += 25.0;
					else if (resulet >= -8.5 && resulet < -7.8)
						score += 30.0;
					else if (resulet >= -7.8 && resulet < -7.1)
						score += 35.0;
					else if (resulet >= -7.1 && resulet < -6.4)
						score += 40.0;
					else if (resulet >= -6.4 && resulet < -5.7)
						score += 45.0;
					else if (resulet >= -5.7 && resulet < -5)
						score += 50.0;
					else if (resulet >= -5 && resulet < -4.3)
						score += 55.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 60.0;
					else if (resulet >= -3.6 && resulet < -2.9)
						score += 65.0;
					else if (resulet >= -2.9 && resulet < -2.1)
						score += 70.0;
					else if (resulet >= -2.1 && resulet < -1.2)
						score += 75.0;
					else if (resulet >= -1.2 && resulet < -0.1)
						score += 80.0;
					else if (resulet >= -0.1 && resulet < 1.2)
						score += 85.0;
					else if (resulet >= 1.2 && resulet < 3.2)
						score += 90.0;
					else if (resulet >= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 11.5 && resulet > 10.5)
						score += 5.0;
					else if (resulet <= 10.5 && resulet > 9.9)
						score += 10.0;
					else if (resulet <= 9.9 && resulet > 9.4)
						score += 15.0;
					else if (resulet <= 9.4 && resulet > 8.9)
						score += 20.0;
					else if (resulet <= 8.9 && resulet > 8.6)
						score += 25.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 30.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 35.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.5)
						score += 55.0;
					else if (resulet <= 6.5 && resulet > 6.2)
						score += 60.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 65.0;
					else if (resulet <= 5.8 && resulet > 5.5)
						score += 70.0;
					else if (resulet <= 5.5 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet >= -15.1 && resulet < -13.3)
						score += 5.0;
					else if (resulet >= -13.3 && resulet < -12.2)
						score += 10.0;
					else if (resulet >= -12.2 && resulet < -11.2)
						score += 15.0;
					else if (resulet >= -11.2 && resulet < -10.4)
						score += 20.0;
					else if (resulet >= -10.4 && resulet < -9.7)
						score += 25.0;
					else if (resulet >= -9.7 && resulet < -9.1)
						score += 30.0;
					else if (resulet >= -9.1 && resulet < -8.4)
						score += 35.0;
					else if (resulet >= -8.4 && resulet < -7.8)
						score += 40.0;
					else if (resulet >= -7.8 && resulet < -7.2)
						score += 45.0;
					else if (resulet >= -7.2 && resulet < -6.6)
						score += 50.0;
					else if (resulet >= -6.6 && resulet < -6)
						score += 55.0;
					else if (resulet >= -6 && resulet < -5.3)
						score += 60.0;
					else if (resulet >= -5.3 && resulet < -4.7)
						score += 65.0;
					else if (resulet >= -4.7 && resulet < -4)
						score += 70.0;
					else if (resulet >= -4 && resulet < -3.2)
						score += 75.0;
					else if (resulet >= -3.2 && resulet < -2.2)
						score += 80.0;
					else if (resulet >= -2.2 && resulet < -1.1)
						score += 85.0;
					else if (resulet >= -1.1 && resulet < 0.7)
						score += 90.0;
					else if (resulet >= 0.7)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 7) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 6.8 && resulet > 6.4)
						score += 5.0;
					else if (resulet <= 6.4 && resulet > 6.1)
						score += 10.0;
					else if (resulet <= 6.1 && resulet > 5.8)
						score += 15.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 20.0;
					else if (resulet >= 5.6 && resulet > 5.4)
						score += 25.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 30.0;
					else if (resulet <= 5.2 && resulet > 5.0)
						score += 35.0;
					else if (resulet <= 5.0 && resulet > 4.9)
						score += 40.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 45.0;
					else if (resulet <= 4.7 && resulet > 4.5)
						score += 50.0;
					else if (resulet <= 4.5 && resulet > 4.4)
						score += 55.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 60.0;
					else if (resulet <= 4.2 && resulet > 4.0)
						score += 65.0;
					else if (resulet <= 4.0 && resulet > 3.8)
						score += 70.0;
					else if (resulet <= 3.8 && resulet > 3.6)
						score += 75.0;
					else if (resulet <= 3.6 && resulet > 3.3)
						score += 80.0;
					else if (resulet <= 3.3 && resulet > 3)
						score += 85.0;
					else if (resulet <= 3)
						score += 90.0;

				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 7.1 && resulet > 6.6)
						score += 5.0;
					else if (resulet <= 6.6 && resulet > 6.3)
						score += 10.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 15.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 20.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 25.0;
					else if (resulet <= 5.7 && resulet > 5.6)
						score += 30.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 35.0;
					else if (resulet <= 5.4 && resulet > 5.3)
						score += 40.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 45.0;
					else if (resulet <= 5.1 && resulet > 4.9)
						score += 50.0;
					else if (resulet <= 4.9 && resulet > 4.8)
						score += 55.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 60.0;
					else if (resulet <= 4.6 && resulet > 4.5)
						score += 65.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 70.0;
					else if (resulet <= 4.3 && resulet > 4.1)
						score += 75.0;
					else if (resulet <= 4.1 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.6)
						score += 85.0;
					else if (resulet <= 3.6 && resulet > 3.1)
						score += 90.0;
					else if (resulet <= 3.1)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 7.4 && resulet > 7)
						score += 5.0;
					else if (resulet <= 7 && resulet > 6.7)
						score += 10.0;
					else if (resulet <= 6.7 && resulet > 6.4)
						score += 15.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 20.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 25.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 30.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 35.0;
					else if (resulet <= 5.6 && resulet > 5.5)
						score += 40.0;
					else if (resulet <= 5.5 && resulet > 5.3)
						score += 45.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 50.0;
					else if (resulet <= 5.1 && resulet > 5)
						score += 55.0;
					else if (resulet <= 5 && resulet > 4.8)
						score += 60.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 65.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 70.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 75.0;
					else if (resulet <= 4.2 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.6)
						score += 85.0;
					else if (resulet <= 3.6 && resulet > 3.2)
						score += 90.0;
					else if (resulet <= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 9 && resulet < 8.3)
						score += 5.0;
					else if (resulet <= 8.3 && resulet > 7.9)
						score += 10.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 15.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 20.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 25.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 30.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 35.0;
					else if (resulet <= 6.4 && resulet > 6.1)
						score += 40.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 45.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 50.0;
					else if (resulet <= 5.7 && resulet > 5.4)
						score += 55.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 60.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 65.0;
					else if (resulet <= 4.9 && resulet > 4.6)
						score += 70.0;
					else if (resulet <= 4.6 && resulet > 4.3)
						score += 75.0;
					else if (resulet <= 4.3 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.5)
						score += 85.0;
					else if (resulet <= 3.5 && resulet > 3.3)
						score += 90.0;
					else if (resulet <= 3.3)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 9.4 && resulet > 8.7)
						score += 5.0;
					else if (resulet <= 8.7 && resulet > 8.3)
						score += 10.0;
					else if (resulet <= 8.3 && resulet > 7.9)
						score += 15.0;
					else if (resulet <= 7.9 && resulet > 7.6)
						score += 20.0;
					else if (resulet <= 7.6 && resulet > 7.3)
						score += 25.0;
					else if (resulet <= 7.3 && resulet > 7.1)
						score += 30.0;
					else if (resulet <= 7.1 && resulet > 6.9)
						score += 35.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 40.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 45.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 50.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 55.0;
					else if (resulet <= 6 && resulet > 5.7)
						score += 60.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 65.0;
					else if (resulet <= 5.5 && resulet > 5.2)
						score += 70.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 75.0;
					else if (resulet <= 4.9 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.1)
						score += 85.0;
					else if (resulet <= 4.1 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 11.5 && resulet > 10.5)
						score += 5.0;
					else if (resulet <= 10.5 && resulet > 9.9)
						score += 10.0;
					else if (resulet <= 9.9 && resulet > 9.4)
						score += 15.0;
					else if (resulet <= 9.4 && resulet > 8.9)
						score += 20.0;
					else if (resulet <= 8.9 && resulet > 8.6)
						score += 25.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 30.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 35.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.5)
						score += 55.0;
					else if (resulet <= 6.5 && resulet > 6.2)
						score += 60.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 65.0;
					else if (resulet <= 5.8 && resulet > 5.5)
						score += 70.0;
					else if (resulet <= 5.5 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet <= 12.9 && resulet > 11.8)
						score += 5.0;
					else if (resulet <= 11.8 && resulet > 11.1)
						score += 10.0;
					else if (resulet <= 11.1 && resulet > 10.5)
						score += 15.0;
					else if (resulet <= 10.5 && resulet > 10)
						score += 20.0;
					else if (resulet <= 10 && resulet > 9.6)
						score += 25.0;
					else if (resulet <= 9.6 && resulet > 9.2)
						score += 30.0;
					else if (resulet <= 9.2 && resulet > 8.8)
						score += 35.0;
					else if (resulet <= 8.8 && resulet > 8.5)
						score += 40.0;
					else if (resulet <= 8.5 && resulet > 8.1)
						score += 45.0;
					else if (resulet <= 8.1 && resulet > 7.7)
						score += 50.0;
					else if (resulet <= 7.7 && resulet > 7.4)
						score += 55.0;
					else if (resulet <= 7.4 && resulet > 7)
						score += 60.0;
					else if (resulet <= 7 && resulet > 6.6)
						score += 65.0;
					else if (resulet <= 6.6 && resulet > 6.2)
						score += 70.0;
					else if (resulet <= 6.2 && resulet > 5.7)
						score += 75.0;
					else if (resulet <= 5.7 && resulet > 5.1)
						score += 80.0;
					else if (resulet <= 5.1 && resulet > 4.5)
						score += 85.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 90.0;
					else if (resulet <= 4.3)
						score += 95.0;

				}
			}
		}

		return score;
	}

	public static Double getTsl(List<FitnessVO1> recod, int calibrations) {
		double score = 0.0;
		for (FitnessVO1 v1 : recod) {
			double resulet = v1.getResultS();
			if (v1.getSex() == 0 && calibrations == 5) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 52)
						score += 5.0;
					else if (resulet <= 60 && resulet > 52)
						score += 10.0;
					else if (resulet <= 66 && resulet > 60)
						score += 15.0;
					else if (resulet <= 71 && resulet > 66)
						score += 20.0;
					else if (resulet <= 75 && resulet > 71)
						score += 25.0;
					else if (resulet <= 79 && resulet > 75)
						score += 30.0;
					else if (resulet <= 82 && resulet > 79)
						score += 35.0;
					else if (resulet <= 85 && resulet > 82)
						score += 40.0;
					else if (resulet <= 88 && resulet > 85)
						score += 45.0;
					else if (resulet <= 91 && resulet > 88)
						score += 50.0;
					else if (resulet <= 94 && resulet > 91)
						score += 55.0;
					else if (resulet <= 97 && resulet > 94)
						score += 60.0;
					else if (resulet <= 100 && resulet > 97)
						score += 65.0;
					else if (resulet <= 103 && resulet > 100)
						score += 70.0;
					else if (resulet <= 107 && resulet > 103)
						score += 75.0;
					else if (resulet <= 111 && resulet > 107)
						score += 80.0;
					else if (resulet <= 116 && resulet > 111)
						score += 85.0;
					else if (resulet <= 122 && resulet > 116)
						score += 90.0;
					else if (resulet > 122)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 47)
						score += 5.0;
					else if (resulet <= 57 && resulet > 47)
						score += 10.0;
					else if (resulet <= 63 && resulet > 57)
						score += 15.0;
					else if (resulet <= 68 && resulet > 63)
						score += 20.0;
					else if (resulet <= 73 && resulet > 68)
						score += 25.0;
					else if (resulet <= 76 && resulet > 73)
						score += 30.0;
					else if (resulet <= 80 && resulet > 76)
						score += 35.0;
					else if (resulet <= 84 && resulet > 80)
						score += 40.0;
					else if (resulet <= 87 && resulet > 84)
						score += 45.0;
					else if (resulet <= 90 && resulet > 87)
						score += 50.0;
					else if (resulet <= 93 && resulet > 90)
						score += 55.0;
					else if (resulet <= 96 && resulet > 93)
						score += 60.0;
					else if (resulet <= 100 && resulet > 96)
						score += 65.0;
					else if (resulet <= 104 && resulet > 100)
						score += 70.0;
					else if (resulet <= 107 && resulet > 104)
						score += 75.0;
					else if (resulet <= 112 && resulet > 107)
						score += 80.0;
					else if (resulet <= 117 && resulet > 112)
						score += 85.0;
					else if (resulet <= 123 && resulet > 117)
						score += 90.0;
					else if (resulet > 123)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 43)
						score += 5.0;
					else if (resulet <= 52 && resulet > 43)
						score += 10.0;
					else if (resulet <= 58 && resulet > 52)
						score += 15.0;
					else if (resulet <= 63 && resulet > 58)
						score += 20.0;
					else if (resulet <= 68 && resulet > 63)
						score += 25.0;
					else if (resulet <= 71 && resulet > 68)
						score += 30.0;
					else if (resulet <= 74 && resulet > 71)
						score += 35.0;
					else if (resulet <= 78 && resulet > 74)
						score += 40.0;
					else if (resulet <= 81 && resulet > 78)
						score += 45.0;
					else if (resulet <= 84 && resulet > 81)
						score += 50.0;
					else if (resulet <= 87 && resulet > 84)
						score += 55.0;
					else if (resulet <= 90 && resulet > 87)
						score += 60.0;
					else if (resulet <= 94 && resulet > 90)
						score += 65.0;
					else if (resulet <= 97 && resulet > 94)
						score += 70.0;
					else if (resulet <= 101 && resulet > 97)
						score += 75.0;
					else if (resulet <= 105 && resulet > 101)
						score += 80.0;
					else if (resulet <= 110 && resulet > 105)
						score += 85.0;
					else if (resulet > 116)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 45)
						score += 5.0;
					else if (resulet <= 53 && resulet > 45)
						score += 10.0;
					else if (resulet <= 59 && resulet > 53)
						score += 15.0;
					else if (resulet <= 64 && resulet > 59)
						score += 20.0;
					else if (resulet <= 68 && resulet > 64)
						score += 25.0;
					else if (resulet <= 72 && resulet > 68)
						score += 30.0;
					else if (resulet <= 75 && resulet > 72)
						score += 35.0;
					else if (resulet <= 78 && resulet > 75)
						score += 40.0;
					else if (resulet <= 81 && resulet > 78)
						score += 45.0;
					else if (resulet <= 84 && resulet > 81)
						score += 50.0;
					else if (resulet <= 87 && resulet > 84)
						score += 55.0;
					else if (resulet <= 90 && resulet > 87)
						score += 60.0;
					else if (resulet <= 93 && resulet > 90)
						score += 65.0;
					else if (resulet <= 96 && resulet > 93)
						score += 70.0;
					else if (resulet <= 100 && resulet > 96)
						score += 75.0;
					else if (resulet <= 104 && resulet > 100)
						score += 80.0;
					else if (resulet <= 109 && resulet > 104)
						score += 85.0;
					else if (resulet <= 115 && resulet > 109)
						score += 90.0;
					else if (resulet > 115)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 37)
						score += 5.0;
					else if (resulet <= 46 && resulet > 37)
						score += 10.0;
					else if (resulet <= 51 && resulet > 46)
						score += 15.0;
					else if (resulet <= 56 && resulet > 51)
						score += 20.0;
					else if (resulet <= 60 && resulet > 56)
						score += 25.0;
					else if (resulet <= 63 && resulet > 60)
						score += 30.0;
					else if (resulet <= 66 && resulet > 63)
						score += 35.0;
					else if (resulet <= 69 && resulet > 66)
						score += 40.0;
					else if (resulet <= 72 && resulet > 69)
						score += 45.0;
					else if (resulet <= 75 && resulet > 72)
						score += 50.0;
					else if (resulet <= 78 && resulet > 75)
						score += 55.0;
					else if (resulet <= 81 && resulet > 78)
						score += 60.0;
					else if (resulet <= 84 && resulet > 81)
						score += 65.0;
					else if (resulet <= 87 && resulet > 84)
						score += 70.0;
					else if (resulet <= 90 && resulet > 87)
						score += 75.0;
					else if (resulet <= 94 && resulet > 90)
						score += 80.0;
					else if (resulet <= 99 && resulet > 94)
						score += 85.0;
					else if (resulet <= 104 && resulet > 99)
						score += 90.0;
					else if (resulet > 104)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 39)
						score += 5.0;
					else if (resulet <= 42 && resulet > 39)
						score += 10.0;
					else if (resulet <= 47 && resulet > 42)
						score += 15.0;
					else if (resulet <= 52 && resulet > 47)
						score += 20.0;
					else if (resulet <= 55 && resulet > 52)
						score += 25.0;
					else if (resulet <= 59 && resulet > 55)
						score += 30.0;
					else if (resulet <= 61 && resulet > 59)
						score += 35.0;
					else if (resulet <= 64 && resulet > 61)
						score += 40.0;
					else if (resulet <= 67 && resulet > 64)
						score += 45.0;
					else if (resulet <= 70 && resulet > 67)
						score += 50.0;
					else if (resulet <= 73 && resulet > 70)
						score += 55.0;
					else if (resulet <= 76 && resulet > 73)
						score += 60.0;
					else if (resulet <= 79 && resulet > 76)
						score += 65.0;
					else if (resulet <= 81 && resulet > 79)
						score += 70.0;
					else if (resulet <= 85 && resulet > 81)
						score += 75.0;
					else if (resulet <= 88 && resulet > 85)
						score += 80.0;
					else if (resulet <= 93 && resulet > 88)
						score += 85.0;
					else if (resulet <= 98 && resulet > 93)
						score += 90.0;
					else if (resulet > 98)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet <= 24)
						score += 5.0;
					else if (resulet <= 31 && resulet > 24)
						score += 10.0;
					else if (resulet <= 36 && resulet > 31)
						score += 15.0;
					else if (resulet <= 40 && resulet > 36)
						score += 20.0;
					else if (resulet <= 44 && resulet > 40)
						score += 25.0;
					else if (resulet <= 47 && resulet > 44)
						score += 30.0;
					else if (resulet <= 50 && resulet > 47)
						score += 35.0;
					else if (resulet <= 53 && resulet > 50)
						score += 40.0;
					else if (resulet <= 55 && resulet > 53)
						score += 45.0;
					else if (resulet <= 58 && resulet > 55)
						score += 50.0;
					else if (resulet <= 61 && resulet > 58)
						score += 55.0;
					else if (resulet <= 63 && resulet > 61)
						score += 60.0;
					else if (resulet <= 66 && resulet > 63)
						score += 65.0;
					else if (resulet <= 69 && resulet > 66)
						score += 70.0;
					else if (resulet <= 72 && resulet > 69)
						score += 75.0;
					else if (resulet <= 76 && resulet > 72)
						score += 80.0;
					else if (resulet <= 80 && resulet > 76)
						score += 85.0;
					else if (resulet <= 85 && resulet > 80)
						score += 90.0;
					else if (resulet > 85)
						score += 95.0;
				}
			}
			if (v1.getSex() == 0 && calibrations == 6) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet >= -6.4 && resulet < -5.2)
						score += 5.0;
					else if (resulet >= -5.2 && resulet < -4.3)
						score += 10.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 15.0;
					else if (resulet >= -3.6 && resulet < -3)
						score += 20.0;
					else if (resulet >= -3 && resulet < -2.5)
						score += 25.0;
					else if (resulet >= -2.5 && resulet < -2.1)
						score += 30.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 35.0;
					else if (resulet >= -1.6 && resulet < -1.2)
						score += 40.0;
					else if (resulet >= -1.2 && resulet < -0.7)
						score += 45.0;
					else if (resulet >= -0.7 && resulet < -0.2)
						score += 50.0;
					else if (resulet >= -0.2 && resulet < 0.2)
						score += 55.0;
					else if (resulet >= 0.2 && resulet < 0.7)
						score += 60.0;
					else if (resulet >= 0.7 && resulet < 1.1)
						score += 65.0;
					else if (resulet >= 1.1 && resulet < 1.6)
						score += 70.0;
					else if (resulet >= 1.6 && resulet < 2.2)
						score += 75.0;
					else if (resulet >= 2.2 && resulet < 2.9)
						score += 80.0;
					else if (resulet >= 2.9 && resulet < 3.8)
						score += 85.0;
					else if (resulet >= 3.8 && resulet < 5)
						score += 90.0;
					else if (resulet >= 5)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet >= -7.3 && resulet < -5.9)
						score += 5.0;
					else if (resulet >= -5.9 && resulet < -5)
						score += 10.0;
					else if (resulet >= -5 && resulet < -4.3)
						score += 15.0;
					else if (resulet >= -4.3 && resulet < -3.7)
						score += 20.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 25.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 30.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 35.0;
					else if (resulet >= -2.1 && resulet < -1.7)
						score += 40.0;
					else if (resulet >= -1.7 && resulet < -1.2)
						score += 45.0;
					else if (resulet >= -1.2 && resulet < -0.7)
						score += 50.0;
					else if (resulet >= -0.7 && resulet < -0.3)
						score += 55.0;
					else if (resulet >= -0.3 && resulet < 0.2)
						score += 60.0;
					else if (resulet >= 0.2 && resulet < 0.7)
						score += 65.0;
					else if (resulet >= 0.7 && resulet < 1.3)
						score += 70.0;
					else if (resulet >= 1.3 && resulet < 1.9)
						score += 75.0;
					else if (resulet >= 1.9 && resulet < 2.6)
						score += 80.0;
					else if (resulet >= 2.6 && resulet < 3.5)
						score += 85.0;
					else if (resulet >= 3.5 && resulet < 4.9)
						score += 90.0;
					else if (resulet >= 4.9)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 43)
						score += 5.0;
					else if (resulet <= 52 && resulet > 43)
						score += 10.0;
					if (resulet >= -7.9 && resulet < -6.6)
						score += 5.0;
					else if (resulet >= -6.6 && resulet < -5.7)
						score += 10.0;
					else if (resulet >= -5.7 && resulet < -4.9)
						score += 15.0;
					else if (resulet >= -4.9 && resulet < -4.2)
						score += 20.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 25.0;
					else if (resulet >= -3.7 && resulet < -3.2)
						score += 30.0;
					else if (resulet >= -3.2 && resulet < -2.6)
						score += 35.0;
					else if (resulet >= -2.6 && resulet < -2.2)
						score += 40.0;
					else if (resulet >= -2.2 && resulet < -1.7)
						score += 45.0;
					else if (resulet >= -1.7 && resulet < -1.2)
						score += 50.0;
					else if (resulet >= -1.2 && resulet < -0.8)
						score += 55.0;
					else if (resulet >= -0.8 && resulet < -0.2)
						score += 60.0;
					else if (resulet >= -0.2 && resulet < 0.3)
						score += 65.0;
					else if (resulet >= 0.3 && resulet < 0.8)
						score += 70.0;
					else if (resulet >= 0.8 && resulet < 1.5)
						score += 75.0;
					else if (resulet >= 1.5 && resulet < 2.3)
						score += 80.0;
					else if (resulet >= 2.3 && resulet < 3.2)
						score += 85.0;
					else if (resulet >= 3.2 && resulet < 4.5)
						score += 90.0;
					else if (resulet >= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 8.9 && resulet > 8.3)
						score += 5.0;
					else if (resulet <= 8.3 && resulet > 8)
						score += 10.0;
					else if (resulet <= 8 && resulet > 7.6)
						score += 15.0;
					else if (resulet <= 7.6 && resulet > 7.4)
						score += 20.0;
					else if (resulet <= 7.4 && resulet > 7.1)
						score += 25.0;
					else if (resulet <= 7.1 && resulet > 6.9)
						score += 30.0;
					else if (resulet <= 6.9 && resulet > 6.7)
						score += 35.0;
					else if (resulet <= 6.7 && resulet > 6.5)
						score += 40.0;
					else if (resulet <= 6.5 && resulet > 6.3)
						score += 45.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 50.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 55.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 60.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 65.0;
					else if (resulet <= 5.5 && resulet > 5.2)
						score += 70.0;
					else if (resulet <= 5.2 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.6)
						score += 80.0;
					else if (resulet <= 4.6 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet >= -9.5 && resulet < -8)
						score += 5.0;
					else if (resulet >= -8 && resulet < -7)
						score += 10.0;
					else if (resulet >= -7 && resulet < -6.1)
						score += 15.0;
					else if (resulet >= -6.1 && resulet < -5.4)
						score += 20.0;
					else if (resulet >= -5.4 && resulet < -4.8)
						score += 25.0;
					else if (resulet >= -4.8 && resulet < -4.2)
						score += 30.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 35.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 40.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 45.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 50.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 55.0;
					else if (resulet >= -1.6 && resulet < -1)
						score += 60.0;
					else if (resulet >= -1 && resulet < -0.4)
						score += 65.0;
					else if (resulet >= -0.4 && resulet < 0.2)
						score += 70.0;
					else if (resulet >= 0.2 && resulet < 0.9)
						score += 75.0;
					else if (resulet >= 0.9 && resulet < 1.8)
						score += 80.0;
					else if (resulet >= 2.8 && resulet < 2.8)
						score += 85.0;
					else if (resulet >= 2.8 && resulet < 4.3)
						score += 90.0;
					else if (resulet >= 4.3)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet >= -11.3 && resulet < -9.7)
						score += 5.0;
					else if (resulet >= -9.7 && resulet < -8.6)
						score += 10.0;
					else if (resulet >= -8.6 && resulet < -7.7)
						score += 15.0;
					else if (resulet >= -7.7 && resulet < -6.9)
						score += 20.0;
					else if (resulet >= -6.9 && resulet < -6.2)
						score += 25.0;
					else if (resulet >= -6.2 && resulet < -5.7)
						score += 30.0;
					else if (resulet >= -5.7 && resulet < -5)
						score += 35.0;
					else if (resulet >= -5 && resulet < -4.5)
						score += 40.0;
					else if (resulet >= -4.5 && resulet < -3.9)
						score += 45.0;
					else if (resulet >= -3.9 && resulet < -3.3)
						score += 50.0;
					else if (resulet >= -3.3 && resulet < -2.8)
						score += 55.0;
					else if (resulet >= -2.8 && resulet < -2.1)
						score += 60.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 65.0;
					else if (resulet >= -1.6 && resulet < -0.9)
						score += 70.0;
					else if (resulet >= -0.9 && resulet < -0.1)
						score += 75.0;
					else if (resulet >= -0.1 && resulet < 1.8)
						score += 80.0;
					else if (resulet >= 1.8 && resulet < 1.9)
						score += 85.0;
					else if (resulet >= 1.9 && resulet < 3.5)
						score += 90.0;
					else if (resulet >= 3.5)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet >= -13 && resulet < -11.2)
						score += 5.0;
					else if (resulet >= -11.2 && resulet < -9.9)
						score += 10.0;
					else if (resulet >= -9.9 && resulet < -8.9)
						score += 15.0;
					else if (resulet >= -8.9 && resulet < -8)
						score += 20.0;
					else if (resulet >= -8 && resulet < -7.2)
						score += 25.0;
					else if (resulet >= -7.2 && resulet < -6.5)
						score += 30.0;
					else if (resulet >= -6.5 && resulet < -5.8)
						score += 35.0;
					else if (resulet >= -5.8 && resulet < -5.2)
						score += 40.0;
					else if (resulet >= -5.2 && resulet < -4.5)
						score += 45.0;
					else if (resulet >= -4.5 && resulet < -3.8)
						score += 50.0;
					else if (resulet >= -3.8 && resulet < -3.2)
						score += 55.0;
					else if (resulet >= -3.2 && resulet < -2.5)
						score += 60.0;
					else if (resulet >= -2.5 && resulet < -1.8)
						score += 65.0;
					else if (resulet >= -1.8 && resulet < -1)
						score += 70.0;
					else if (resulet >= -1 && resulet < -0.1)
						score += 75.0;
					else if (resulet >= -0.1 && resulet < 0.9)
						score += 80.0;
					else if (resulet >= 0.9 && resulet < 2.2)
						score += 85.0;
					else if (resulet >= 2.2 && resulet < 3.9)
						score += 90.0;
					else if (resulet >= 3.9)
						score += 95.0;
				}
			}
			if (v1.getSex() == 0 && calibrations == 7) {// 女性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {

					if (resulet <= 7.2 && resulet > 6.7)
						score += 5.0;
					else if (resulet <= 6.7 && resulet > 6.4)
						score += 10.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 15.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 20.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 25.0;
					else if (resulet <= 5.8 && resulet > 5.7)
						score += 30.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 35.0;
					else if (resulet <= 5.5 && resulet > 5.4)
						score += 40.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 45.0;
					else if (resulet <= 5.2 && resulet > 5)
						score += 50.0;
					else if (resulet <= 5 && resulet > 4.9)
						score += 55.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 60.0;
					else if (resulet <= 4.7 && resulet > 4.6)
						score += 65.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 70.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 75.0;
					else if (resulet <= 4.2 && resulet > 4)
						score += 80.0;
					else if (resulet <= 4 && resulet > 3.7)
						score += 85.0;
					else if (resulet <= 3.7 && resulet > 3.2)
						score += 90.0;
					else if (resulet <= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 7.6 && resulet > 7.1)
						score += 5.0;
					else if (resulet <= 7.1 && resulet > 6.8)
						score += 10.0;
					else if (resulet <= 6.8 && resulet > 6.6)
						score += 15.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 20.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 25.0;
					else if (resulet <= 6.2 && resulet > 6.1)
						score += 30.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 35.0;
					else if (resulet <= 5.9 && resulet > 5.8)
						score += 40.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 45.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 50.0;
					else if (resulet <= 5.4 && resulet > 5.3)
						score += 55.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 60.0;
					else if (resulet <= 5.1 && resulet > 5)
						score += 65.0;
					else if (resulet <= 5 && resulet > 4.8)
						score += 70.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 75.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 80.0;
					else if (resulet <= 4.4 && resulet > 4.1)
						score += 85.0;
					else if (resulet <= 4.1 && resulet > 3.6)
						score += 90.0;
					else if (resulet <= 3.6)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 8.6 && resulet > 8)
						score += 5.0;
					else if (resulet <= 8 && resulet > 7.7)
						score += 10.0;
					else if (resulet <= 7.7 && resulet > 7.3)
						score += 15.0;
					else if (resulet <= 7.3 && resulet > 7.1)
						score += 20.0;
					else if (resulet <= 7.1 && resulet > 6.8)
						score += 25.0;
					else if (resulet <= 6.8 && resulet > 6.6)
						score += 30.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 35.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 40.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 45.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 50.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 55.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 60.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 65.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 70.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 75.0;
					else if (resulet <= 4.7 && resulet > 4.3)
						score += 80.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 85.0;
					else if (resulet <= 4 && resulet > 3.8)
						score += 90.0;
					else if (resulet <= 3.8)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet >= -8.8 && resulet < -7.3)
						score += 5.0;
					else if (resulet >= -7.3 && resulet < -6.4)
						score += 10.0;
					else if (resulet >= -6.4 && resulet < -5.5)
						score += 15.0;
					else if (resulet >= -5.5 && resulet < -4.8)
						score += 20.0;
					else if (resulet >= -4.8 && resulet < -4.2)
						score += 25.0;
					else if (resulet >= -4.2 && resulet < -3.7)
						score += 30.0;
					else if (resulet >= -3.7 && resulet < -3.1)
						score += 35.0;
					else if (resulet >= -3.1 && resulet < -2.6)
						score += 40.0;
					else if (resulet >= -2.6 && resulet < -2.1)
						score += 45.0;
					else if (resulet >= -2.1 && resulet < -1.6)
						score += 50.0;
					else if (resulet >= -1.6 && resulet < -1.1)
						score += 55.0;
					else if (resulet >= -1.1 && resulet < -0.5)
						score += 60.0;
					else if (resulet >= -0.5 && resulet < 0)
						score += 65.0;
					else if (resulet >= 0 && resulet < 0.6)
						score += 70.0;
					else if (resulet >= 0.6 && resulet < 1.3)
						score += 75.0;
					else if (resulet >= 1.3 && resulet < 2.2)
						score += 80.0;
					else if (resulet >= 2.2 && resulet < 3.1)
						score += 85.0;
					else if (resulet >= 3.1 && resulet < 4.5)
						score += 90.0;
					else if (resulet >= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 10.8 && resulet > 10)
						score += 5.0;
					else if (resulet <= 10 && resulet > 9.5)
						score += 10.0;
					else if (resulet <= 9.5 && resulet > 9)
						score += 15.0;
					else if (resulet <= 9 && resulet > 8.7)
						score += 20.0;
					else if (resulet <= 8.7 && resulet > 8.3)
						score += 25.0;
					else if (resulet <= 8.3 && resulet > 8.1)
						score += 30.0;
					else if (resulet <= 8.1 && resulet > 7.8)
						score += 35.0;
					else if (resulet <= 7.8 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.7)
						score += 55.0;
					else if (resulet <= 6.7 && resulet > 6.3)
						score += 60.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 65.0;
					else if (resulet <= 6.1 && resulet > 5.7)
						score += 70.0;
					else if (resulet <= 5.7 && resulet > 5.4)
						score += 75.0;
					else if (resulet <= 5.4 && resulet > 4.9)
						score += 80.0;
					else if (resulet <= 4.9 && resulet > 4.4)
						score += 85.0;
					else if (resulet <= 4.4 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 12 && resulet > 11.1)
						score += 5.0;
					else if (resulet <= 11.1 && resulet > 10.5)
						score += 10.0;
					else if (resulet <= 10.5 && resulet > 10)
						score += 15.0;
					else if (resulet <= 10 && resulet > 9.6)
						score += 20.0;
					else if (resulet <= 9.6 && resulet > 9.2)
						score += 25.0;
					else if (resulet <= 9.2 && resulet > 8.9)
						score += 30.0;
					else if (resulet <= 8.9 && resulet > 8.5)
						score += 35.0;
					else if (resulet <= 8.5 && resulet > 8.2)
						score += 40.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 45.0;
					else if (resulet <= 7.9 && resulet > 7.6)
						score += 50.0;
					else if (resulet <= 7.6 && resulet > 7.3)
						score += 55.0;
					else if (resulet <= 7.3 && resulet > 6.9)
						score += 60.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 65.0;
					else if (resulet <= 6.6 && resulet > 6.2)
						score += 70.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 75.0;
					else if (resulet <= 5.8 && resulet > 5.3)
						score += 80.0;
					else if (resulet <= 5.3 && resulet > 4.7)
						score += 85.0;
					else if (resulet <= 4.7 && resulet > 4.5)
						score += 90.0;
					else if (resulet <= 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 89 && v1.getAge() < 100) {
					if (resulet <= 14.6 && resulet > 13.5)
						score += 5.0;
					else if (resulet <= 13.5 && resulet > 12.7)
						score += 10.0;
					else if (resulet <= 12.7 && resulet > 12.1)
						score += 15.0;
					else if (resulet <= 12.1 && resulet > 11.5)
						score += 20.0;
					else if (resulet <= 11.5 && resulet > 11.1)
						score += 25.0;
					else if (resulet <= 11.1 && resulet > 10.6)
						score += 30.0;
					else if (resulet <= 10.6 && resulet > 10.2)
						score += 35.0;
					else if (resulet <= 10.2 && resulet > 9.8)
						score += 40.0;
					else if (resulet <= 9.8 && resulet > 9.4)
						score += 45.0;
					else if (resulet <= 9.4 && resulet > 9)
						score += 50.0;
					else if (resulet <= 9 && resulet > 8.6)
						score += 55.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 60.0;
					else if (resulet <= 8.2 && resulet > 7.7)
						score += 65.0;
					else if (resulet <= 7.7 && resulet > 7.3)
						score += 70.0;
					else if (resulet <= 7.3 && resulet > 6.7)
						score += 75.0;
					else if (resulet <= 6.7 && resulet > 6.1)
						score += 80.0;
					else if (resulet <= 6.1 && resulet > 5.3)
						score += 85.0;
					else if (resulet <= 5.3 && resulet > 5)
						score += 90.0;
					else if (resulet <= 5)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 5) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 74 && resulet > 67)
						score += 10.0;
					else if (resulet <= 79 && resulet > 74)
						score += 15.0;
					else if (resulet <= 83 && resulet > 79)
						score += 20.0;
					else if (resulet <= 87 && resulet > 83)
						score += 25.0;
					else if (resulet <= 90 && resulet > 87)
						score += 30.0;
					else if (resulet <= 93 && resulet > 90)
						score += 35.0;
					else if (resulet <= 96 && resulet > 93)
						score += 40.0;
					else if (resulet <= 98 && resulet > 96)
						score += 45.0;
					else if (resulet <= 101 && resulet > 98)
						score += 50.0;
					else if (resulet <= 104 && resulet > 101)
						score += 55.0;
					else if (resulet <= 106 && resulet > 104)
						score += 60.0;
					else if (resulet <= 109 && resulet > 106)
						score += 65.0;
					else if (resulet <= 112 && resulet > 109)
						score += 70.0;
					else if (resulet <= 115 && resulet > 112)
						score += 75.0;
					else if (resulet <= 119 && resulet > 115)
						score += 80.0;
					else if (resulet <= 123 && resulet > 119)
						score += 85.0;
					else if (resulet <= 128 && resulet > 123)
						score += 90.0;
					else if (resulet > 128)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 72 && resulet > 67)
						score += 10.0;
					else if (resulet <= 77 && resulet > 72)
						score += 15.0;
					else if (resulet <= 82 && resulet > 77)
						score += 20.0;
					else if (resulet <= 86 && resulet > 82)
						score += 25.0;
					else if (resulet <= 89 && resulet > 86)
						score += 30.0;
					else if (resulet <= 92 && resulet > 89)
						score += 35.0;
					else if (resulet <= 95 && resulet > 92)
						score += 40.0;
					else if (resulet <= 98 && resulet > 95)
						score += 45.0;
					else if (resulet <= 101 && resulet > 98)
						score += 50.0;
					else if (resulet <= 104 && resulet > 101)
						score += 55.0;
					else if (resulet <= 107 && resulet > 104)
						score += 60.0;
					else if (resulet <= 110 && resulet > 107)
						score += 65.0;
					else if (resulet <= 113 && resulet > 110)
						score += 70.0;
					else if (resulet <= 116 && resulet > 113)
						score += 75.0;
					else if (resulet <= 120 && resulet > 116)
						score += 80.0;
					else if (resulet <= 125 && resulet > 120)
						score += 85.0;
					else if (resulet <= 130 && resulet > 125)
						score += 90.0;
					else if (resulet > 130)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 67)
						score += 5.0;
					else if (resulet <= 66 && resulet > 67)
						score += 10.0;
					else if (resulet <= 71 && resulet > 66)
						score += 15.0;
					else if (resulet <= 76 && resulet > 71)
						score += 20.0;
					else if (resulet <= 80 && resulet > 76)
						score += 25.0;
					else if (resulet <= 83 && resulet > 80)
						score += 30.0;
					else if (resulet <= 86 && resulet > 83)
						score += 35.0;
					else if (resulet <= 89 && resulet > 86)
						score += 40.0;
					else if (resulet <= 92 && resulet > 89)
						score += 45.0;
					else if (resulet <= 95 && resulet > 92)
						score += 50.0;
					else if (resulet <= 98 && resulet > 95)
						score += 55.0;
					else if (resulet <= 101 && resulet > 98)
						score += 60.0;
					else if (resulet <= 104 && resulet > 101)
						score += 65.0;
					else if (resulet <= 107 && resulet > 104)
						score += 70.0;
					else if (resulet <= 110 && resulet > 107)
						score += 75.0;
					else if (resulet <= 114 && resulet > 110)
						score += 80.0;
					else if (resulet <= 119 && resulet > 114)
						score += 85.0;
					else if (resulet <= 124 && resulet > 119)
						score += 90.0;
					else if (resulet > 124)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 47)
						score += 5.0;
					else if (resulet <= 56 && resulet > 47)
						score += 10.0;
					else if (resulet <= 63 && resulet > 56)
						score += 15.0;
					else if (resulet <= 68 && resulet > 63)
						score += 20.0;
					else if (resulet <= 73 && resulet > 68)
						score += 25.0;
					else if (resulet <= 77 && resulet > 73)
						score += 30.0;
					else if (resulet <= 80 && resulet > 77)
						score += 35.0;
					else if (resulet <= 84 && resulet > 80)
						score += 40.0;
					else if (resulet <= 87 && resulet > 84)
						score += 45.0;
					else if (resulet <= 91 && resulet > 87)
						score += 50.0;
					else if (resulet <= 95 && resulet > 91)
						score += 55.0;
					else if (resulet <= 98 && resulet > 95)
						score += 60.0;
					else if (resulet <= 102 && resulet > 98)
						score += 65.0;
					else if (resulet <= 105 && resulet > 102)
						score += 70.0;
					else if (resulet <= 109 && resulet > 105)
						score += 75.0;
					else if (resulet <= 114 && resulet > 109)
						score += 80.0;
					else if (resulet <= 119 && resulet > 114)
						score += 85.0;
					else if (resulet <= 126 && resulet > 119)
						score += 90.0;
					else if (resulet > 126)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 48)
						score += 5.0;
					else if (resulet <= 56 && resulet > 48)
						score += 10.0;
					else if (resulet <= 62 && resulet > 56)
						score += 15.0;
					else if (resulet <= 67 && resulet > 62)
						score += 20.0;
					else if (resulet <= 71 && resulet > 67)
						score += 25.0;
					else if (resulet <= 75 && resulet > 71)
						score += 30.0;
					else if (resulet <= 78 && resulet > 75)
						score += 35.0;
					else if (resulet <= 81 && resulet > 78)
						score += 40.0;
					else if (resulet <= 84 && resulet > 81)
						score += 45.0;
					else if (resulet <= 87 && resulet > 84)
						score += 50.0;
					else if (resulet <= 90 && resulet > 87)
						score += 55.0;
					else if (resulet <= 93 && resulet > 90)
						score += 60.0;
					else if (resulet <= 96 && resulet > 93)
						score += 65.0;
					else if (resulet <= 99 && resulet > 96)
						score += 70.0;
					else if (resulet <= 103 && resulet > 99)
						score += 75.0;
					else if (resulet <= 107 && resulet > 103)
						score += 80.0;
					else if (resulet <= 112 && resulet > 107)
						score += 85.0;
					else if (resulet <= 118 && resulet > 112)
						score += 90.0;
					else if (resulet > 118)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 36)
						score += 5.0;
					else if (resulet <= 44 && resulet > 36)
						score += 10.0;
					else if (resulet <= 50 && resulet > 44)
						score += 15.0;
					else if (resulet <= 55 && resulet > 50)
						score += 20.0;
					else if (resulet <= 59 && resulet > 55)
						score += 25.0;
					else if (resulet <= 63 && resulet > 59)
						score += 30.0;
					else if (resulet <= 66 && resulet > 63)
						score += 35.0;
					else if (resulet <= 69 && resulet > 66)
						score += 40.0;
					else if (resulet <= 72 && resulet > 69)
						score += 45.0;
					else if (resulet <= 75 && resulet > 72)
						score += 50.0;
					else if (resulet <= 78 && resulet > 75)
						score += 55.0;
					else if (resulet <= 81 && resulet > 78)
						score += 60.0;
					else if (resulet <= 84 && resulet > 81)
						score += 65.0;
					else if (resulet <= 87 && resulet > 84)
						score += 70.0;
					else if (resulet <= 91 && resulet > 87)
						score += 75.0;
					else if (resulet <= 95 && resulet > 91)
						score += 80.0;
					else if (resulet <= 100 && resulet > 95)
						score += 85.0;
					else if (resulet <= 106 && resulet > 100)
						score += 90.0;
					else if (resulet > 106)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet <= 26)
						score += 5.0;
					else if (resulet <= 36 && resulet > 26)
						score += 10.0;
					else if (resulet <= 42 && resulet > 36)
						score += 15.0;
					else if (resulet <= 47 && resulet > 42)
						score += 20.0;
					else if (resulet <= 52 && resulet > 47)
						score += 25.0;
					else if (resulet <= 55 && resulet > 52)
						score += 30.0;
					else if (resulet <= 59 && resulet > 55)
						score += 35.0;
					else if (resulet <= 62 && resulet > 59)
						score += 40.0;
					else if (resulet <= 66 && resulet > 62)
						score += 45.0;
					else if (resulet <= 69 && resulet > 66)
						score += 50.0;
					else if (resulet <= 72 && resulet > 69)
						score += 55.0;
					else if (resulet <= 76 && resulet > 72)
						score += 60.0;
					else if (resulet <= 79 && resulet > 76)
						score += 65.0;
					else if (resulet <= 83 && resulet > 79)
						score += 70.0;
					else if (resulet <= 86 && resulet > 83)
						score += 75.0;
					else if (resulet <= 91 && resulet > 86)
						score += 80.0;
					else if (resulet <= 96 && resulet > 91)
						score += 85.0;
					else if (resulet <= 102 && resulet > 96)
						score += 90.0;
					else if (resulet > 102)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 6) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet >= -11.3 && resulet < -9.5)
						score += 5.0;
					else if (resulet >= -9.5 && resulet < -8.4)
						score += 10.0;
					else if (resulet >= -8.4 && resulet < -7.4)
						score += 15.0;
					else if (resulet >= -7.4 && resulet < -6.6)
						score += 20.0;
					else if (resulet >= -6.6 && resulet < -5.9)
						score += 25.0;
					else if (resulet >= -5.9 && resulet < -5.3)
						score += 30.0;
					else if (resulet >= -5.3 && resulet < -4.6)
						score += 35.0;
					else if (resulet >= -4.6 && resulet < -4)
						score += 40.0;
					else if (resulet >= -4 && resulet < -3.4)
						score += 45.0;
					else if (resulet >= -3.4 && resulet < -2.8)
						score += 50.0;
					else if (resulet >= -2.8 && resulet < -2.2)
						score += 55.0;
					else if (resulet >= -2.2 && resulet < -1.5)
						score += 60.0;
					else if (resulet >= -1.5 && resulet < -0.9)
						score += 65.0;
					else if (resulet >= -0.9 && resulet < -0.2)
						score += 70.0;
					else if (resulet >= -0.2 && resulet < 0.6)
						score += 75.0;
					else if (resulet >= 0.6 && resulet < 1.6)
						score += 80.0;
					else if (resulet >= 1.6 && resulet < 2.7)
						score += 85.0;
					else if (resulet >= 2.7 && resulet < 4.5)
						score += 85.0;
					else if (resulet > 4.5)
						score += 95.0;
				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet >= -12.1 && resulet < -10.4)
						score += 5.0;
					else if (resulet >= -10.4 && resulet < -9.2)
						score += 10.0;
					else if (resulet >= -9.2 && resulet < -8.2)
						score += 15.0;
					else if (resulet >= -8.2 && resulet < -7.4)
						score += 20.0;
					else if (resulet >= -7.4 && resulet < -6.6)
						score += 25.0;
					else if (resulet >= -6.6 && resulet < -6)
						score += 30.0;
					else if (resulet >= -6 && resulet < -5.3)
						score += 35.0;
					else if (resulet >= -5.3 && resulet < -4.7)
						score += 40.0;
					else if (resulet >= -4.7 && resulet < -4.1)
						score += 45.0;
					else if (resulet >= -4.1 && resulet < -3.5)
						score += 50.0;
					else if (resulet >= -3.5 && resulet < -2.9)
						score += 55.0;
					else if (resulet >= -2.9 && resulet < -2.2)
						score += 60.0;
					else if (resulet >= -2.2 && resulet < -1.6)
						score += 65.0;
					else if (resulet >= -1.6 && resulet < -0.8)
						score += 70.0;
					else if (resulet >= -0.8 && resulet < 0)
						score += 75.0;
					else if (resulet >= 0 && resulet < 1)
						score += 80.0;
					else if (resulet >= 1 && resulet < 2.2)
						score += 85.0;
					else if (resulet >= 2.2 && resulet < 3.9)
						score += 90.0;
					else if (resulet >= 3.9)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet >= -12.5 && resulet < -10.8)
						score += 5.0;
					else if (resulet >= -10.8 && resulet < -9.6)
						score += 10.0;
					else if (resulet >= -9.6 && resulet < -8.6)
						score += 15.0;
					else if (resulet >= -8.6 && resulet < -7.8)
						score += 20.0;
					else if (resulet >= -7.8 && resulet < -7)
						score += 25.0;
					else if (resulet >= -7 && resulet < -6.4)
						score += 30.0;
					else if (resulet > -6.4 && resulet < -5.7)
						score += 35.0;
					else if (resulet >= -5.7 && resulet < -5.1)
						score += 40.0;
					else if (resulet >= -5.1 && resulet < -4.5)
						score += 45.0;
					else if (resulet >= -4.5 && resulet < -3.9)
						score += 50.0;
					else if (resulet >= -3.9 && resulet < -3.3)
						score += 55.0;
					else if (resulet >= -3.3 && resulet < -2.6)
						score += 60.0;
					else if (resulet >= -2.6 && resulet < -2)
						score += 65.0;
					else if (resulet >= -2 && resulet < -1.2)
						score += 70.0;
					else if (resulet >= -1.2 && resulet < -0.4)
						score += 75.0;
					else if (resulet >= -0.4 && resulet < 0.6)
						score += 80.0;
					else if (resulet >= 0.6 && resulet < 1.8)
						score += 85.0;
					else if (resulet >= 1.8 && resulet < 3.5)
						score += 90.0;
					else if (resulet >= 3.5)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet >= -14 && resulet < -12.1)
						score += 5.0;
					else if (resulet >= -12.1 && resulet < -10.9)
						score += 10.0;
					else if (resulet >= -10.9 && resulet < -9.9)
						score += 15.0;
					else if (resulet >= -9.9 && resulet < -9)
						score += 20.0;
					else if (resulet >= -9 && resulet < -8.3)
						score += 25.0;
					else if (resulet >= -8.3 && resulet < -7.6)
						score += 30.0;
					else if (resulet >= -7.6 && resulet < -6.9)
						score += 35.0;
					else if (resulet >= -6.9 && resulet < -6.3)
						score += 40.0;
					else if (resulet >= -6.3 && resulet < -5.6)
						score += 45.0;
					else if (resulet >= -5.6 && resulet < -4.9)
						score += 50.0;
					else if (resulet >= -4.9 && resulet < -4.3)
						score += 55.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 60.0;
					else if (resulet >= -3.6 && resulet < -2.9)
						score += 65.0;
					else if (resulet >= -2.9 && resulet < -2.2)
						score += 70.0;
					else if (resulet >= -2.2 && resulet < -1.3)
						score += 75.0;
					else if (resulet >= -1.3 && resulet < -0.3)
						score += 80.0;
					else if (resulet >= -0.3 && resulet < 0.9)
						score += 85.0;
					else if (resulet >= 0.9 && resulet < 2.8)
						score += 90.0;
					else if (resulet >= 2.8)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet >= -14.6 && resulet < -12.6)
						score += 5.0;
					else if (resulet >= -12.6 && resulet < -11.3)
						score += 10.0;
					else if (resulet >= -11.3 && resulet < -10.2)
						score += 15.0;
					else if (resulet >= -10.2 && resulet < -9.3)
						score += 20.0;
					else if (resulet >= -9.3 && resulet < -8.5)
						score += 25.0;
					else if (resulet >= -8.5 && resulet < -7.8)
						score += 30.0;
					else if (resulet >= -7.8 && resulet < -7.1)
						score += 35.0;
					else if (resulet >= -7.1 && resulet < -6.4)
						score += 40.0;
					else if (resulet >= -6.4 && resulet < -5.7)
						score += 45.0;
					else if (resulet >= -5.7 && resulet < -5)
						score += 50.0;
					else if (resulet >= -5 && resulet < -4.3)
						score += 55.0;
					else if (resulet >= -4.3 && resulet < -3.6)
						score += 60.0;
					else if (resulet >= -3.6 && resulet < -2.9)
						score += 65.0;
					else if (resulet >= -2.9 && resulet < -2.1)
						score += 70.0;
					else if (resulet >= -2.1 && resulet < -1.2)
						score += 75.0;
					else if (resulet >= -1.2 && resulet < -0.1)
						score += 80.0;
					else if (resulet >= -0.1 && resulet < 1.2)
						score += 85.0;
					else if (resulet >= 1.2 && resulet < 3.2)
						score += 90.0;
					else if (resulet >= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 11.5 && resulet > 10.5)
						score += 5.0;
					else if (resulet <= 10.5 && resulet > 9.9)
						score += 10.0;
					else if (resulet <= 9.9 && resulet > 9.4)
						score += 15.0;
					else if (resulet <= 9.4 && resulet > 8.9)
						score += 20.0;
					else if (resulet <= 8.9 && resulet > 8.6)
						score += 25.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 30.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 35.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.5)
						score += 55.0;
					else if (resulet <= 6.5 && resulet > 6.2)
						score += 60.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 65.0;
					else if (resulet <= 5.8 && resulet > 5.5)
						score += 70.0;
					else if (resulet <= 5.5 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet >= -15.1 && resulet < -13.3)
						score += 5.0;
					else if (resulet >= -13.3 && resulet < -12.2)
						score += 10.0;
					else if (resulet >= -12.2 && resulet < -11.2)
						score += 15.0;
					else if (resulet >= -11.2 && resulet < -10.4)
						score += 20.0;
					else if (resulet >= -10.4 && resulet < -9.7)
						score += 25.0;
					else if (resulet >= -9.7 && resulet < -9.1)
						score += 30.0;
					else if (resulet >= -9.1 && resulet < -8.4)
						score += 35.0;
					else if (resulet >= -8.4 && resulet < -7.8)
						score += 40.0;
					else if (resulet >= -7.8 && resulet < -7.2)
						score += 45.0;
					else if (resulet >= -7.2 && resulet < -6.6)
						score += 50.0;
					else if (resulet >= -6.6 && resulet < -6)
						score += 55.0;
					else if (resulet >= -6 && resulet < -5.3)
						score += 60.0;
					else if (resulet >= -5.3 && resulet < -4.7)
						score += 65.0;
					else if (resulet >= -4.7 && resulet < -4)
						score += 70.0;
					else if (resulet >= -4 && resulet < -3.2)
						score += 75.0;
					else if (resulet >= -3.2 && resulet < -2.2)
						score += 80.0;
					else if (resulet >= -2.2 && resulet < -1.1)
						score += 85.0;
					else if (resulet >= -1.1 && resulet < 0.7)
						score += 90.0;
					else if (resulet >= 0.7)
						score += 95.0;
				}
			}
			if (v1.getSex() == 1 && calibrations == 7) {// 男性
				if (v1.getAge() >= 60 && v1.getAge() < 65) {
					if (resulet <= 6.8 && resulet > 6.4)
						score += 5.0;
					else if (resulet <= 6.4 && resulet > 6.1)
						score += 10.0;
					else if (resulet <= 6.1 && resulet > 5.8)
						score += 15.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 20.0;
					else if (resulet >= 5.6 && resulet > 5.4)
						score += 25.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 30.0;
					else if (resulet <= 5.2 && resulet > 5.0)
						score += 35.0;
					else if (resulet <= 5.0 && resulet > 4.9)
						score += 40.0;
					else if (resulet <= 4.9 && resulet > 4.7)
						score += 45.0;
					else if (resulet <= 4.7 && resulet > 4.5)
						score += 50.0;
					else if (resulet <= 4.5 && resulet > 4.4)
						score += 55.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 60.0;
					else if (resulet <= 4.2 && resulet > 4.0)
						score += 65.0;
					else if (resulet <= 4.0 && resulet > 3.8)
						score += 70.0;
					else if (resulet <= 3.8 && resulet > 3.6)
						score += 75.0;
					else if (resulet <= 3.6 && resulet > 3.3)
						score += 80.0;
					else if (resulet <= 3.3 && resulet > 3)
						score += 85.0;
					else if (resulet <= 3)
						score += 90.0;

				} else if (v1.getAge() >= 65 && v1.getAge() <= 69) {
					if (resulet <= 7.1 && resulet > 6.6)
						score += 5.0;
					else if (resulet <= 6.6 && resulet > 6.3)
						score += 10.0;
					else if (resulet <= 6.3 && resulet > 6.1)
						score += 15.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 20.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 25.0;
					else if (resulet <= 5.7 && resulet > 5.6)
						score += 30.0;
					else if (resulet <= 5.6 && resulet > 5.4)
						score += 35.0;
					else if (resulet <= 5.4 && resulet > 5.3)
						score += 40.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 45.0;
					else if (resulet <= 5.1 && resulet > 4.9)
						score += 50.0;
					else if (resulet <= 4.9 && resulet > 4.8)
						score += 55.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 60.0;
					else if (resulet <= 4.6 && resulet > 4.5)
						score += 65.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 70.0;
					else if (resulet <= 4.3 && resulet > 4.1)
						score += 75.0;
					else if (resulet <= 4.1 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.6)
						score += 85.0;
					else if (resulet <= 3.6 && resulet > 3.1)
						score += 90.0;
					else if (resulet <= 3.1)
						score += 95.0;
				} else if (v1.getAge() >= 70 && v1.getAge() <= 74) {
					if (resulet <= 7.4 && resulet > 7)
						score += 5.0;
					else if (resulet <= 7 && resulet > 6.7)
						score += 10.0;
					else if (resulet <= 6.7 && resulet > 6.4)
						score += 15.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 20.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 25.0;
					else if (resulet <= 6 && resulet > 5.8)
						score += 30.0;
					else if (resulet <= 5.8 && resulet > 5.6)
						score += 35.0;
					else if (resulet <= 5.6 && resulet > 5.5)
						score += 40.0;
					else if (resulet <= 5.5 && resulet > 5.3)
						score += 45.0;
					else if (resulet <= 5.3 && resulet > 5.1)
						score += 50.0;
					else if (resulet <= 5.1 && resulet > 5)
						score += 55.0;
					else if (resulet <= 5 && resulet > 4.8)
						score += 60.0;
					else if (resulet <= 4.8 && resulet > 4.6)
						score += 65.0;
					else if (resulet <= 4.6 && resulet > 4.4)
						score += 70.0;
					else if (resulet <= 4.4 && resulet > 4.2)
						score += 75.0;
					else if (resulet <= 4.2 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.6)
						score += 85.0;
					else if (resulet <= 3.6 && resulet > 3.2)
						score += 90.0;
					else if (resulet <= 3.2)
						score += 95.0;
				} else if (v1.getAge() >= 75 && v1.getAge() <= 79) {
					if (resulet <= 9 && resulet < 8.3)
						score += 5.0;
					else if (resulet <= 8.3 && resulet > 7.9)
						score += 10.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 15.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 20.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 25.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 30.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 35.0;
					else if (resulet <= 6.4 && resulet > 6.1)
						score += 40.0;
					else if (resulet <= 6.1 && resulet > 5.9)
						score += 45.0;
					else if (resulet <= 5.9 && resulet > 5.7)
						score += 50.0;
					else if (resulet <= 5.7 && resulet > 5.4)
						score += 55.0;
					else if (resulet <= 5.4 && resulet > 5.2)
						score += 60.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 65.0;
					else if (resulet <= 4.9 && resulet > 4.6)
						score += 70.0;
					else if (resulet <= 4.6 && resulet > 4.3)
						score += 75.0;
					else if (resulet <= 4.3 && resulet > 3.9)
						score += 80.0;
					else if (resulet <= 3.9 && resulet > 3.5)
						score += 85.0;
					else if (resulet <= 3.5 && resulet > 3.3)
						score += 90.0;
					else if (resulet <= 3.3)
						score += 95.0;
				} else if (v1.getAge() >= 80 && v1.getAge() <= 84) {
					if (resulet <= 9.4 && resulet > 8.7)
						score += 5.0;
					else if (resulet <= 8.7 && resulet > 8.3)
						score += 10.0;
					else if (resulet <= 8.3 && resulet > 7.9)
						score += 15.0;
					else if (resulet <= 7.9 && resulet > 7.6)
						score += 20.0;
					else if (resulet <= 7.6 && resulet > 7.3)
						score += 25.0;
					else if (resulet <= 7.3 && resulet > 7.1)
						score += 30.0;
					else if (resulet <= 7.1 && resulet > 6.9)
						score += 35.0;
					else if (resulet <= 6.9 && resulet > 6.6)
						score += 40.0;
					else if (resulet <= 6.6 && resulet > 6.4)
						score += 45.0;
					else if (resulet <= 6.4 && resulet > 6.2)
						score += 50.0;
					else if (resulet <= 6.2 && resulet > 6)
						score += 55.0;
					else if (resulet <= 6 && resulet > 5.7)
						score += 60.0;
					else if (resulet <= 5.7 && resulet > 5.5)
						score += 65.0;
					else if (resulet <= 5.5 && resulet > 5.2)
						score += 70.0;
					else if (resulet <= 5.2 && resulet > 4.9)
						score += 75.0;
					else if (resulet <= 4.9 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.1)
						score += 85.0;
					else if (resulet <= 4.1 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 85 && v1.getAge() <= 89) {
					if (resulet <= 11.5 && resulet > 10.5)
						score += 5.0;
					else if (resulet <= 10.5 && resulet > 9.9)
						score += 10.0;
					else if (resulet <= 9.9 && resulet > 9.4)
						score += 15.0;
					else if (resulet <= 9.4 && resulet > 8.9)
						score += 20.0;
					else if (resulet <= 8.9 && resulet > 8.6)
						score += 25.0;
					else if (resulet <= 8.6 && resulet > 8.2)
						score += 30.0;
					else if (resulet <= 8.2 && resulet > 7.9)
						score += 35.0;
					else if (resulet <= 7.9 && resulet > 7.5)
						score += 40.0;
					else if (resulet <= 7.5 && resulet > 7.2)
						score += 45.0;
					else if (resulet <= 7.2 && resulet > 6.9)
						score += 50.0;
					else if (resulet <= 6.9 && resulet > 6.5)
						score += 55.0;
					else if (resulet <= 6.5 && resulet > 6.2)
						score += 60.0;
					else if (resulet <= 6.2 && resulet > 5.8)
						score += 65.0;
					else if (resulet <= 5.8 && resulet > 5.5)
						score += 70.0;
					else if (resulet <= 5.5 && resulet > 5)
						score += 75.0;
					else if (resulet <= 5 && resulet > 4.5)
						score += 80.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 85.0;
					else if (resulet <= 4.3 && resulet > 4)
						score += 90.0;
					else if (resulet <= 4)
						score += 95.0;
				} else if (v1.getAge() >= 90 && v1.getAge() <= 100) {
					if (resulet <= 12.9 && resulet > 11.8)
						score += 5.0;
					else if (resulet <= 11.8 && resulet > 11.1)
						score += 10.0;
					else if (resulet <= 11.1 && resulet > 10.5)
						score += 15.0;
					else if (resulet <= 10.5 && resulet > 10)
						score += 20.0;
					else if (resulet <= 10 && resulet > 9.6)
						score += 25.0;
					else if (resulet <= 9.6 && resulet > 9.2)
						score += 30.0;
					else if (resulet <= 9.2 && resulet > 8.8)
						score += 35.0;
					else if (resulet <= 8.8 && resulet > 8.5)
						score += 40.0;
					else if (resulet <= 8.5 && resulet > 8.1)
						score += 45.0;
					else if (resulet <= 8.1 && resulet > 7.7)
						score += 50.0;
					else if (resulet <= 7.7 && resulet > 7.4)
						score += 55.0;
					else if (resulet <= 7.4 && resulet > 7)
						score += 60.0;
					else if (resulet <= 7 && resulet > 6.6)
						score += 65.0;
					else if (resulet <= 6.6 && resulet > 6.2)
						score += 70.0;
					else if (resulet <= 6.2 && resulet > 5.7)
						score += 75.0;
					else if (resulet <= 5.7 && resulet > 5.1)
						score += 80.0;
					else if (resulet <= 5.1 && resulet > 4.5)
						score += 85.0;
					else if (resulet <= 4.5 && resulet > 4.3)
						score += 90.0;
					else if (resulet <= 4.3)
						score += 95.0;

				}
			}
		}

		return score;
	}

	public static Double getTsl_(List<FitnessVO2> recod, int calibrations) {
		double score = 0.0;
		for (FitnessVO2 f : recod) {
			int age = f.getAge();
			double resulet = f.getResultS1();
			double resulet1 = f.getResultS2();
			if (f.getSex() == 0 && calibrations == 3) {// 女
				// 6 7
				if (resulet < 18) {
					score += 1.0;
				} else if (resulet >= 18 && resulet < 24.9) {
					score += 0.5;
				} else if (resulet > 24.9 && resulet < 29.9) {
					score += 0.5;
				} else if (resulet >= 29.9) {
					score += 0.1;
				}

			}
			if (f.getSex() == 1 && calibrations == 3) {// 男

				if (resulet < 18.5) {
					score += 1.0;
				} else if (resulet >= 18.5 && resulet < 23.9) {
					score += 1.0;
				} else if (resulet >= 23.9 && resulet < 27.9) {
					score += 0.5;
				} else if (resulet >= 27.9) {
					score += 0.1;
				}
			}

			if (f.getSex() == 0 && calibrations == 4) {// 女
				// 1 5
				if (age >= 60 && age < 65) {
					if (resulet1 <= 8) {
						score += 5.0;
					} else if (resulet1 == 9) {
						score += 10.0;
					} else if (resulet1 == 10) {
						score += 15.0;
					} else if (resulet1 == 11) {
						score += 20.0;
					} else if (resulet1 == 12) {
						score += 27.5;
					} else if (resulet1 == 13) {
						score += 35.0;
					} else if (resulet1 == 14) {
						score += 42.5;
					} else if (resulet1 == 15) {
						score += 52.5;
					} else if (resulet1 == 16) {
						score += 62.5;
					} else if (resulet1 == 17) {
						score += 72.5;
					} else if (resulet1 == 18) {
						score += 80.0;
					} else if (resulet1 == 19) {
						score += 85.0;
					} else if (resulet1 == 20) {
						score += 90.0;
					} else if (resulet1 == 21) {
						score += 95.0;
					}
					if (resulet1 <= 17.8)
						score += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 17.8)
						score += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						score += 50.0;
					else if (resulet1 <= 26 && resulet1 > 21.1)
						score += 70.0;
					else if (resulet1 > 26)
						score += 90.0;

				} else if (age >= 65 && age <= 69) {
					if (resulet1 <= 8) {
						score += 5.0;
					} else if (resulet1 == 9) {
						score += 10.0;
					} else if (resulet1 == 10) {
						score += 15.0;
					} else if (resulet1 == 11) {
						score += 22.5;
					} else if (resulet1 == 12) {
						score += 27.5;
					} else if (resulet1 == 13) {
						score += 35.0;
					} else if (resulet1 == 14) {
						score += 42.5;
					} else if (resulet1 == 15) {
						score += 52.5;
					} else if (resulet1 == 16) {
						score += 62.5;
					} else if (resulet1 == 17) {
						score += 72.5;
					} else if (resulet1 == 18) {
						score += 80.0;
					} else if (resulet1 == 19) {
						score += 85.0;
					} else if (resulet1 == 20) {
						score += 90.0;
					} else if (resulet1 == 21) {
						score += 95.0;
					}

					if (resulet1 <= 16.6)
						score += 10.0;
					else if (resulet1 <= 19.8 && resulet1 > 16.6)
						score += 30.0;
					else if (resulet1 <= 20.6 && resulet1 > 19.8)
						score += 50.0;
					else if (resulet1 <= 26.4 && resulet1 > 20.6)
						score += 70.0;
					else if (resulet1 > 26.4)
						score += 90.0;

				} else if (age >= 70 && age <= 74) {
					if (resulet1 <= 7) {
						score += 5.0;
					} else if (resulet1 == 8) {
						score += 10.0;
					} else if (resulet1 == 9) {
						score += 15.0;
					} else if (resulet1 == 10) {
						score += 22.5;
					} else if (resulet1 == 11) {
						score += 32.5;
					} else if (resulet1 == 12) {
						score += 40.0;
					} else if (resulet1 == 13) {
						score += 25.5;
					} else if (resulet1 == 14) {
						score += 62.5;
					} else if (resulet1 == 15) {
						score += 72.5;
					} else if (resulet1 == 16) {
						score += 80.0;
					} else if (resulet1 == 17) {
						score += 85.0;
					} else if (resulet1 == 18) {
						score += 90.0;
					} else if (resulet1 == 19) {
						score += 95.0;
					}

					if (resulet1 <= 16.2)
						score += 10.0;
					else if (resulet1 <= 19.3 && resulet1 > 16.2)
						score += 30.0;
					else if (resulet1 <= 20.1 && resulet1 > 19.3)
						score += 50.0;
					else if (resulet1 <= 25.6 && resulet1 > 20.1)
						score += 70.0;
					else if (resulet1 > 25.6)
						score += 90.0;

				} else if (age >= 75 && age <= 79) {
					if (resulet1 <= 6) {
						score += 5.0;
					} else if (resulet1 == 7) {
						score += 7.5;
					} else if (resulet1 == 8) {
						score += 10.0;
					} else if (resulet1 == 9) {
						score += 17.5;
					} else if (resulet1 == 10) {
						score += 25.0;
					} else if (resulet1 == 11) {
						score += 32.5;
					} else if (resulet1 == 12) {
						score += 45.0;
					} else if (resulet1 == 13) {
						score += 57.5;
					} else if (resulet1 == 14) {
						score += 67.5;
					} else if (resulet1 == 15) {
						score += 75.0;
					} else if (resulet1 == 16) {
						score += 82.5;
					} else if (resulet1 == 17) {
						score += 90.0;
					} else if (resulet1 == 18) {
						score += 92.0;
					} else if (resulet1 == 19) {
						score += 95.0;
					}

					if (resulet1 <= 14.1)
						score += 10.0;
					else if (resulet1 <= 17.1 && resulet1 > 14.1)
						score += 30.0;
					else if (resulet1 <= 17.6 && resulet1 > 17.1)
						score += 50.0;
					else if (resulet1 <= 22.3 && resulet1 > 17.6)
						score += 70.0;
					else if (resulet1 > 22.3)
						score += 90.0;

				} else if (age >= 80 && age <= 84) {
					if (resulet1 <= 4) {
						score += 5.0;
					} else if (resulet1 == 5) {
						score += 7.5;
					} else if (resulet1 == 6) {
						score += 10.0;
					} else if (resulet1 == 7) {
						score += 15.0;
					} else if (resulet1 == 8) {
						score += 20.0;
					} else if (resulet1 == 9) {
						score += 27.5;
					} else if (resulet1 == 10) {
						score += 37.5;
					} else if (resulet1 == 11) {
						score += 47.5;
					} else if (resulet1 == 12) {
						score += 57.5;
					} else if (resulet1 == 13) {
						score += 70.0;
					} else if (resulet1 == 14) {
						score += 75.0;
					} else if (resulet1 == 15) {
						score += 80.0;
					} else if (resulet1 == 16) {
						score += 85.0;
					} else if (resulet1 == 17) {
						score += 90.0;
					} else if (resulet1 == 18) {
						score += 95.0;
					}

					if (resulet1 <= 12.4)
						score += 10.0;
					else if (resulet1 <= 15.2 && resulet1 > 12.4)
						score += 30.0;
					else if (resulet1 <= 16.4 && resulet1 > 15.2)
						score += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 16.4)
						score += 70.0;
					else if (resulet1 > 23.1)
						score += 90.0;

				} else if (age >= 85 && age <= 89) {
					if (resulet1 <= 4) {
						score += 5.0;
					} else if (resulet1 == 5) {
						score += 10.0;
					} else if (resulet1 == 6) {
						score += 15.0;
					} else if (resulet1 == 7) {
						score += 20.0;
					} else if (resulet1 == 8) {
						score += 27.5;
					} else if (resulet1 == 9) {
						score += 37.5;
					} else if (resulet1 == 10) {
						score += 47.5;
					} else if (resulet1 == 11) {
						score += 57.5;
					} else if (resulet1 == 12) {
						score += 67.5;
					} else if (resulet1 == 13) {
						score += 75.0;
					} else if (resulet1 == 14) {
						score += 82.5;
					} else if (resulet1 == 15) {
						score += 90.0;
					} else if (resulet1 == 16) {
						score += 92.5;
					} else if (resulet1 == 17) {
						score += 95.0;
					}

					if (resulet1 <= 10.2)
						score += 10.0;
					else if (resulet1 <= 17 && resulet1 > 10.2)
						score += 30.0;
					else if (resulet1 <= 17.4 && resulet1 > 17)
						score += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 17.4)
						score += 70.0;
					else if (resulet1 > 23.1)
						score += 90.0;

				} else if (age >= 89 && age < 100) {
					if (resulet1 == 0) {
						score += 5.0;
					} else if (resulet1 == 1) {
						score += 10.0;
					} else if (resulet1 == 2) {
						score += 12.5;
					} else if (resulet1 == 3) {
						score += 15.0;
					} else if (resulet1 == 4) {
						score += 22.5;
					} else if (resulet1 == 5) {
						score += 30.0;
					} else if (resulet1 == 6) {
						score += 35.0;
					} else if (resulet1 == 7) {
						score += 42.5;
					} else if (resulet1 == 8) {
						score += 50.0;
					} else if (resulet1 == 9) {
						score += 62.5;
					} else if (resulet1 == 10) {
						score += 65.0;
					} else if (resulet1 == 11) {
						score += 72.5;
					} else if (resulet1 == 12) {
						score += 80.0;
					} else if (resulet1 == 13) {
						score += 85.0;
					} else if (resulet1 == 14) {
						score += 87.5;
					} else if (resulet1 == 15) {
						score += 90.0;
					} else if (resulet1 == 16) {
						score += 92.5;
					}

					if (resulet1 <= 10.2)
						score += 10.0;
					else if (resulet1 <= 17 && resulet1 > 10.2)
						score += 30.0;
					else if (resulet1 <= 17.4 && resulet1 > 17)
						score += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 17.4)
						score += 70.0;
					else if (resulet1 > 23.1)
						score += 90.0;
				}
			}
			if (f.getSex() == 1 && calibrations == 4) {// 男
				if (age >= 60 && age < 65) {
					if (resulet1 <= 9) {
						score += 5.0;
					} else if (resulet1 == 10) {
						score += 7.5;
					} else if (resulet1 == 11) {
						score += 10.0;
					} else if (resulet1 == 12) {
						score += 15.0;
					} else if (resulet1 == 13) {
						score += 20.0;
					} else if (resulet1 == 14) {
						score += 25.0;
					} else if (resulet1 == 15) {
						score += 37.5;
					} else if (resulet1 == 16) {
						score += 47.5;
					} else if (resulet1 == 17) {
						score += 57.5;
					} else if (resulet1 == 18) {
						score += 65.0;
					} else if (resulet1 == 19) {
						score += 72.5;
					} else if (resulet1 == 20) {
						score += 80.0;
					} else if (resulet1 == 21) {
						score += 85.0;
					} else if (resulet1 == 22) {
						score += 90.0;
					} else if (resulet1 == 23) {
						score += 95.0;
					}

					if (resulet1 <= 21.9)
						score += 10.0;
					else if (resulet1 <= 30.3 && resulet1 > 21.9)
						score += 30.0;
					else if (resulet1 <= 31.2 && resulet1 > 30.3)
						score += 50.0;
					else if (resulet1 <= 40 && resulet1 > 31.2)
						score += 70.0;
					else if (resulet1 > 40)
						score += 90.0;

				} else if (age >= 65 && age <= 69) {
					if (resulet1 <= 8) {
						score += 5.0;
					} else if (resulet1 == 9) {
						score += 10.0;
					} else if (resulet1 == 10) {
						score += 12.5;
					} else if (resulet1 == 11) {
						score += 17.5;
					} else if (resulet1 == 12) {
						score += 25.0;
					} else if (resulet1 == 13) {
						score += 32.5;
					} else if (resulet1 == 14) {
						score += 40.0;
					} else if (resulet1 == 15) {
						score += 47.5;
					} else if (resulet1 == 16) {
						score += 57.5;
					} else if (resulet1 == 17) {
						score += 65.0;
					} else if (resulet1 == 18) {
						score += 72.5;
					} else if (resulet1 == 19) {
						score += 80.0;
					} else if (resulet1 == 20) {
						score += 85.0;
					} else if (resulet1 == 21) {
						score += 90.0;
					} else if (resulet1 == 22) {
						score += 92.5;
					} else if (resulet1 == 23) {
						score += 95.0;
					}

					if (resulet1 <= 27)
						score += 10.0;
					else if (resulet1 <= 30.9 && resulet1 > 27)
						score += 30.0;
					else if (resulet1 <= 32.1 && resulet1 > 30.9)
						score += 50.0;
					else if (resulet1 <= 39.6 && resulet1 > 32.1)
						score += 70.0;
					else if (resulet1 > 39.6)
						score += 90.0;

				} else if (age >= 70 && age <= 74) {
					if (resulet1 <= 8) {
						score += 5.0;
					} else if (resulet1 == 9) {
						score += 10.0;
					} else if (resulet1 == 10) {
						score += 15.0;
					} else if (resulet1 == 11) {
						score += 20.0;
					} else if (resulet1 == 12) {
						score += 27.5;
					} else if (resulet1 == 13) {
						score += 37.5;
					} else if (resulet1 == 14) {
						score += 47.5;
					} else if (resulet1 == 15) {
						score += 55.0;
					} else if (resulet1 == 16) {
						score += 62.5;
					} else if (resulet1 == 17) {
						score += 72.5;
					} else if (resulet1 == 18) {
						score += 80.0;
					} else if (resulet1 == 19) {
						score += 85.0;
					} else if (resulet1 == 20) {
						score += 90.0;
					} else if (resulet1 == 21) {
						score += 95.0;
					}

					if (resulet1 <= 23.9)
						score += 10.0;
					else if (resulet1 <= 28.7 && resulet1 > 23.9)
						score += 30.0;
					else if (resulet1 <= 30 && resulet1 > 28.7)
						score += 50.0;
					else if (resulet1 <= 38.4 && resulet1 > 30)
						score += 70.0;
					else if (resulet1 > 38.4)
						score += 90.0;

				} else if (age >= 75 && age <= 79) {
					if (resulet1 == 7) {
						score += 5.0;
					} else if (resulet1 == 8) {
						score += 10.0;
					} else if (resulet1 == 9) {
						score += 12.5;
					} else if (resulet1 == 10) {
						score += 17.5;
					} else if (resulet1 == 11) {
						score += 25.0;
					} else if (resulet1 == 12) {
						score += 32.5;
					} else if (resulet1 == 13) {
						score += 42.5;
					} else if (resulet1 == 14) {
						score += 50.0;
					} else if (resulet1 == 15) {
						score += 57.5;
					} else if (resulet1 == 16) {
						score += 67.5;
					} else if (resulet1 == 17) {
						score += 75.0;
					} else if (resulet1 == 18) {
						score += 82.5;
					} else if (resulet1 == 19) {
						score += 87.5;
					} else if (resulet1 == 20) {
						score += 90.0;
					} else if (resulet1 == 21) {
						score += 95.5;
					}

					if (resulet1 <= 19.2)
						score += 10.0;
					else if (resulet1 <= 24.8 && resulet1 > 19.2)
						score += 30.0;
					else if (resulet1 <= 25.8 && resulet1 > 24.8)
						score += 50.0;
					else if (resulet1 <= 33.7 && resulet1 > 25.8)
						score += 70.0;
					else if (resulet1 > 33.7)
						score += 90.0;

				} else if (age >= 80 && age <= 84) {
					if (resulet1 <= 6) {
						score += 5.0;
					} else if (resulet1 == 7) {
						score += 10.0;
					} else if (resulet1 == 8) {
						score += 15.0;
					} else if (resulet1 == 9) {
						score += 20.0;
					} else if (resulet1 == 10) {
						score += 27.5;
					} else if (resulet1 == 11) {
						score += 37.5;
					} else if (resulet1 == 12) {
						score += 47.5;
					} else if (resulet1 == 13) {
						score += 57.5;
					} else if (resulet1 == 14) {
						score += 67.5;
					} else if (resulet1 == 15) {
						score += 75.0;
					} else if (resulet1 == 16) {
						score += 82.5;
					} else if (resulet1 == 17) {
						score += 90.0;
					} else if (resulet1 == 18) {
						score += 92.5;
					} else if (resulet1 == 19) {
						score += 95.0;
					}

					if (resulet1 <= 19.4)
						score += 10.0;
					else if (resulet1 <= 23.2 && resulet1 > 19.4)
						score += 30.0;
					else if (resulet1 <= 24.2 && resulet1 > 23.2)
						score += 50.0;
					else if (resulet1 <= 30 && resulet1 > 24.2)
						score += 70.0;
					else if (resulet1 > 30)
						score += 90.0;

				} else if (age >= 85 && age <= 89) {
					if (resulet1 <= 4) {
						score += 5.0;
					} else if (resulet1 == 5) {
						score += 10.0;
					} else if (resulet1 == 6) {
						score += 15.0;
					} else if (resulet1 == 7) {
						score += 20.0;
					} else if (resulet1 == 8) {
						score += 25.0;
					} else if (resulet1 == 9) {
						score += 32.5;
					} else if (resulet1 == 10) {
						score += 40.0;
					} else if (resulet1 == 11) {
						score += 47.5;
					} else if (resulet1 == 12) {
						score += 57.5;
					} else if (resulet1 == 13) {
						score += 67.5;
					} else if (resulet1 == 14) {
						score += 75.0;
					} else if (resulet1 == 15) {
						score += 80.0;
					} else if (resulet1 == 16) {
						score += 85.0;
					} else if (resulet1 == 17) {
						score += 90.0;
					} else if (resulet1 == 18) {
						score += 92.5;
					} else if (resulet1 == 17) {
						score += 95.0;
					}

					if (resulet1 <= 18.3)
						score += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 18.3)
						score += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						score += 50.0;
					else if (resulet1 <= 29 && resulet1 > 21.1)
						score += 70.0;
					else if (resulet1 > 29)
						score += 90.0;

				} else if (age >= 90 && age <= 100) {
					if (resulet1 <= 3) {
						score += 5.0;
					} else if (resulet1 == 4) {
						score += 7.5;
					} else if (resulet1 == 5) {
						score += 10.0;
					} else if (resulet1 == 6) {
						score += 15.0;
					} else if (resulet1 == 7) {
						score += 22.5;
					} else if (resulet1 == 8) {
						score += 32.5;
					} else if (resulet1 == 9) {
						score += 42.5;
					} else if (resulet1 == 10) {
						score += 52.5;
					} else if (resulet1 == 11) {
						score += 62.5;
					} else if (resulet1 == 12) {
						score += 72.5;
					} else if (resulet1 == 13) {
						score += 80.0;
					} else if (resulet1 == 14) {
						score += 85.0;
					} else if (resulet1 == 15) {
						score += 90.0;
					} else if (resulet1 == 16) {
						score += 95.0;
					}

					if (resulet1 <= 18.3)
						score += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 18.3)
						score += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						score += 50.0;
					else if (resulet1 <= 29 && resulet1 > 21.1)
						score += 70.0;
					else if (resulet1 > 29)
						score += 90.0;

				}

			}
		}
		return score;
	}

	public static Double getTslq_(List<FitnessVO2> recod, double cords,
			int evg, int calibrations) {
		double score = 0.0;
		for (FitnessVO2 f : recod) {
			int age = f.getAge();
			double resulet = f.getResultS1();
			double resulet1 = f.getResultS2();
			double s1 = 0.0;
			double s2 = 0.0;
			if (f.getSex() == 0 && calibrations == 3) {// 女
				// 6 7
				if (resulet < 18) {
					s1 += 1.0;
				} else if (resulet >= 18 && resulet < 24.9) {
					s1 += 0.5;
				} else if (resulet > 24.9 && resulet < 29.9) {
					s1 += 0.5;
				} else if (resulet >= 29.9) {
					s1 += 0.1;
				}

			}
			if (f.getSex() == 1 && calibrations == 3) {// 男

				if (resulet < 18.5) {
					s1 += 1.0;
				} else if (resulet >= 18.5 && resulet < 23.9) {
					s1 += 1.0;
				} else if (resulet >= 23.9 && resulet < 27.9) {
					s1 += 0.5;
				} else if (resulet >= 27.9) {
					s1 += 0.1;
				}
			}

			if (f.getSex() == 0 && calibrations == 4) {// 女
				// 1 5
				if (age >= 60 && age < 65) {
					if (resulet1 <= 8) {
						s2 += 5.0;
					} else if (resulet1 == 9) {
						s2 += 10.0;
					} else if (resulet1 == 10) {
						s2 += 15.0;
					} else if (resulet1 == 11) {
						s2 += 20.0;
					} else if (resulet1 == 12) {
						s2 += 27.5;
					} else if (resulet1 == 13) {
						s2 += 35.0;
					} else if (resulet1 == 14) {
						s2 += 42.5;
					} else if (resulet1 == 15) {
						s2 += 52.5;
					} else if (resulet1 == 16) {
						s2 += 62.5;
					} else if (resulet1 == 17) {
						s2 += 72.5;
					} else if (resulet1 == 18) {
						s2 += 80.0;
					} else if (resulet1 == 19) {
						s2 += 85.0;
					} else if (resulet1 == 20) {
						s2 += 90.0;
					} else if (resulet1 == 21) {
						s2 += 95.0;
					}
					if (resulet1 <= 17.8)
						s2 += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 17.8)
						s2 += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						s2 += 50.0;
					else if (resulet1 <= 26 && resulet1 > 21.1)
						s2 += 70.0;
					else if (resulet1 > 26)
						s2 += 90.0;

				} else if (age >= 65 && age <= 69) {
					if (resulet1 <= 8) {
						s2 += 5.0;
					} else if (resulet1 == 9) {
						s2 += 10.0;
					} else if (resulet1 == 10) {
						s2 += 15.0;
					} else if (resulet1 == 11) {
						s2 += 22.5;
					} else if (resulet1 == 12) {
						s2 += 27.5;
					} else if (resulet1 == 13) {
						s2 += 35.0;
					} else if (resulet1 == 14) {
						s2 += 42.5;
					} else if (resulet1 == 15) {
						s2 += 52.5;
					} else if (resulet1 == 16) {
						s2 += 62.5;
					} else if (resulet1 == 17) {
						s2 += 72.5;
					} else if (resulet1 == 18) {
						s2 += 80.0;
					} else if (resulet1 == 19) {
						s2 += 85.0;
					} else if (resulet1 == 20) {
						s2 += 90.0;
					} else if (resulet1 == 21) {
						s2 += 95.0;
					}

					if (resulet1 <= 16.6)
						s2 += 10.0;
					else if (resulet1 <= 19.8 && resulet1 > 16.6)
						s2 += 30.0;
					else if (resulet1 <= 20.6 && resulet1 > 19.8)
						s2 += 50.0;
					else if (resulet1 <= 26.4 && resulet1 > 20.6)
						s2 += 70.0;
					else if (resulet1 > 26.4)
						s2 += 90.0;

				} else if (age >= 70 && age <= 74) {
					if (resulet1 <= 7) {
						s2 += 5.0;
					} else if (resulet1 == 8) {
						s2 += 10.0;
					} else if (resulet1 == 9) {
						s2 += 15.0;
					} else if (resulet1 == 10) {
						s2 += 22.5;
					} else if (resulet1 == 11) {
						s2 += 32.5;
					} else if (resulet1 == 12) {
						s2 += 40.0;
					} else if (resulet1 == 13) {
						s2 += 25.5;
					} else if (resulet1 == 14) {
						s2 += 62.5;
					} else if (resulet1 == 15) {
						s2 += 72.5;
					} else if (resulet1 == 16) {
						s2 += 80.0;
					} else if (resulet1 == 17) {
						s2 += 85.0;
					} else if (resulet1 == 18) {
						s2 += 90.0;
					} else if (resulet1 == 19) {
						s2 += 95.0;
					}

					if (resulet1 <= 16.2)
						s2 += 10.0;
					else if (resulet1 <= 19.3 && resulet1 > 16.2)
						s2 += 30.0;
					else if (resulet1 <= 20.1 && resulet1 > 19.3)
						s2 += 50.0;
					else if (resulet1 <= 25.6 && resulet1 > 20.1)
						s2 += 70.0;
					else if (resulet1 > 25.6)
						s2 += 90.0;

				} else if (age >= 75 && age <= 79) {
					if (resulet1 <= 6) {
						s2 += 5.0;
					} else if (resulet1 == 7) {
						s2 += 7.5;
					} else if (resulet1 == 8) {
						s2 += 10.0;
					} else if (resulet1 == 9) {
						s2 += 17.5;
					} else if (resulet1 == 10) {
						s2 += 25.0;
					} else if (resulet1 == 11) {
						s2 += 32.5;
					} else if (resulet1 == 12) {
						s2 += 45.0;
					} else if (resulet1 == 13) {
						s2 += 57.5;
					} else if (resulet1 == 14) {
						s2 += 67.5;
					} else if (resulet1 == 15) {
						s2 += 75.0;
					} else if (resulet1 == 16) {
						s2 += 82.5;
					} else if (resulet1 == 17) {
						s2 += 90.0;
					} else if (resulet1 == 18) {
						s2 += 92.0;
					} else if (resulet1 == 19) {
						s2 += 95.0;
					}

					if (resulet1 <= 14.1)
						s2 += 10.0;
					else if (resulet1 <= 17.1 && resulet1 > 14.1)
						s2 += 30.0;
					else if (resulet1 <= 17.6 && resulet1 > 17.1)
						s2 += 50.0;
					else if (resulet1 <= 22.3 && resulet1 > 17.6)
						s2 += 70.0;
					else if (resulet1 > 22.3)
						s2 += 90.0;

				} else if (age >= 80 && age <= 84) {
					if (resulet1 <= 4) {
						s2 += 5.0;
					} else if (resulet1 == 5) {
						s2 += 7.5;
					} else if (resulet1 == 6) {
						s2 += 10.0;
					} else if (resulet1 == 7) {
						s2 += 15.0;
					} else if (resulet1 == 8) {
						s2 += 20.0;
					} else if (resulet1 == 9) {
						s2 += 27.5;
					} else if (resulet1 == 10) {
						s2 += 37.5;
					} else if (resulet1 == 11) {
						s2 += 47.5;
					} else if (resulet1 == 12) {
						s2 += 57.5;
					} else if (resulet1 == 13) {
						s2 += 70.0;
					} else if (resulet1 == 14) {
						s2 += 75.0;
					} else if (resulet1 == 15) {
						s2 += 80.0;
					} else if (resulet1 == 16) {
						s2 += 85.0;
					} else if (resulet1 == 17) {
						s2 += 90.0;
					} else if (resulet1 == 18) {
						s2 += 95.0;
					}

					if (resulet1 <= 12.4)
						s2 += 10.0;
					else if (resulet1 <= 15.2 && resulet1 > 12.4)
						s2 += 30.0;
					else if (resulet1 <= 16.4 && resulet1 > 15.2)
						s2 += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 16.4)
						s2 += 70.0;
					else if (resulet1 > 23.1)
						s2 += 90.0;

				} else if (age >= 85 && age <= 89) {
					if (resulet1 <= 4) {
						s2 += 5.0;
					} else if (resulet1 == 5) {
						s2 += 10.0;
					} else if (resulet1 == 6) {
						s2 += 15.0;
					} else if (resulet1 == 7) {
						s2 += 20.0;
					} else if (resulet1 == 8) {
						s2 += 27.5;
					} else if (resulet1 == 9) {
						s2 += 37.5;
					} else if (resulet1 == 10) {
						s2 += 47.5;
					} else if (resulet1 == 11) {
						s2 += 57.5;
					} else if (resulet1 == 12) {
						s2 += 67.5;
					} else if (resulet1 == 13) {
						s2 += 75.0;
					} else if (resulet1 == 14) {
						s2 += 82.5;
					} else if (resulet1 == 15) {
						s2 += 90.0;
					} else if (resulet1 == 16) {
						s2 += 92.5;
					} else if (resulet1 == 17) {
						s2 += 95.0;
					}

					if (resulet1 <= 10.2)
						s2 += 10.0;
					else if (resulet1 <= 17 && resulet1 > 10.2)
						s2 += 30.0;
					else if (resulet1 <= 17.4 && resulet1 > 17)
						s2 += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 17.4)
						s2 += 70.0;
					else if (resulet1 > 23.1)
						s2 += 90.0;

				} else if (age >= 89 && age < 100) {
					if (resulet1 == 0) {
						s2 += 5.0;
					} else if (resulet1 == 1) {
						s2 += 10.0;
					} else if (resulet1 == 2) {
						s2 += 12.5;
					} else if (resulet1 == 3) {
						s2 += 15.0;
					} else if (resulet1 == 4) {
						s2 += 22.5;
					} else if (resulet1 == 5) {
						s2 += 30.0;
					} else if (resulet1 == 6) {
						s2 += 35.0;
					} else if (resulet1 == 7) {
						s2 += 42.5;
					} else if (resulet1 == 8) {
						s2 += 50.0;
					} else if (resulet1 == 9) {
						s2 += 62.5;
					} else if (resulet1 == 10) {
						s2 += 65.0;
					} else if (resulet1 == 11) {
						s2 += 72.5;
					} else if (resulet1 == 12) {
						s2 += 80.0;
					} else if (resulet1 == 13) {
						s2 += 85.0;
					} else if (resulet1 == 14) {
						s2 += 87.5;
					} else if (resulet1 == 15) {
						s2 += 90.0;
					} else if (resulet1 == 16) {
						s2 += 92.5;
					}

					if (resulet1 <= 10.2)
						s2 += 10.0;
					else if (resulet1 <= 17 && resulet1 > 10.2)
						s2 += 30.0;
					else if (resulet1 <= 17.4 && resulet1 > 17)
						s2 += 50.0;
					else if (resulet1 <= 23.1 && resulet1 > 17.4)
						s2 += 70.0;
					else if (resulet1 > 23.1)
						s2 += 90.0;
				}
			}
			if (f.getSex() == 1 && calibrations == 4) {// 男
				if (age >= 60 && age < 65) {
					if (resulet1 <= 9) {
						s2 += 5.0;
					} else if (resulet1 == 10) {
						s2 += 7.5;
					} else if (resulet1 == 11) {
						s2 += 10.0;
					} else if (resulet1 == 12) {
						s2 += 15.0;
					} else if (resulet1 == 13) {
						s2 += 20.0;
					} else if (resulet1 == 14) {
						s2 += 25.0;
					} else if (resulet1 == 15) {
						s2 += 37.5;
					} else if (resulet1 == 16) {
						s2 += 47.5;
					} else if (resulet1 == 17) {
						s2 += 57.5;
					} else if (resulet1 == 18) {
						s2 += 65.0;
					} else if (resulet1 == 19) {
						s2 += 72.5;
					} else if (resulet1 == 20) {
						s2 += 80.0;
					} else if (resulet1 == 21) {
						s2 += 85.0;
					} else if (resulet1 == 22) {
						s2 += 90.0;
					} else if (resulet1 == 23) {
						s2 += 95.0;
					}

					if (resulet1 <= 21.9)
						s2 += 10.0;
					else if (resulet1 <= 30.3 && resulet1 > 21.9)
						s2 += 30.0;
					else if (resulet1 <= 31.2 && resulet1 > 30.3)
						s2 += 50.0;
					else if (resulet1 <= 40 && resulet1 > 31.2)
						s2 += 70.0;
					else if (resulet1 > 40)
						s2 += 90.0;

				} else if (age >= 65 && age <= 69) {
					if (resulet1 <= 8) {
						s2 += 5.0;
					} else if (resulet1 == 9) {
						s2 += 10.0;
					} else if (resulet1 == 10) {
						s2 += 12.5;
					} else if (resulet1 == 11) {
						s2 += 17.5;
					} else if (resulet1 == 12) {
						s2 += 25.0;
					} else if (resulet1 == 13) {
						s2 += 32.5;
					} else if (resulet1 == 14) {
						s2 += 40.0;
					} else if (resulet1 == 15) {
						s2 += 47.5;
					} else if (resulet1 == 16) {
						s2 += 57.5;
					} else if (resulet1 == 17) {
						s2 += 65.0;
					} else if (resulet1 == 18) {
						s2 += 72.5;
					} else if (resulet1 == 19) {
						s2 += 80.0;
					} else if (resulet1 == 20) {
						s2 += 85.0;
					} else if (resulet1 == 21) {
						s2 += 90.0;
					} else if (resulet1 == 22) {
						s2 += 92.5;
					} else if (resulet1 == 23) {
						s2 += 95.0;
					}

					if (resulet1 <= 27)
						s2 += 10.0;
					else if (resulet1 <= 30.9 && resulet1 > 27)
						s2 += 30.0;
					else if (resulet1 <= 32.1 && resulet1 > 30.9)
						s2 += 50.0;
					else if (resulet1 <= 39.6 && resulet1 > 32.1)
						s2 += 70.0;
					else if (resulet1 > 39.6)
						s2 += 90.0;

				} else if (age >= 70 && age <= 74) {
					if (resulet1 <= 8) {
						s2 += 5.0;
					} else if (resulet1 == 9) {
						s2 += 10.0;
					} else if (resulet1 == 10) {
						s2 += 15.0;
					} else if (resulet1 == 11) {
						s2 += 20.0;
					} else if (resulet1 == 12) {
						s2 += 27.5;
					} else if (resulet1 == 13) {
						s2 += 37.5;
					} else if (resulet1 == 14) {
						s2 += 47.5;
					} else if (resulet1 == 15) {
						s2 += 55.0;
					} else if (resulet1 == 16) {
						s2 += 62.5;
					} else if (resulet1 == 17) {
						s2 += 72.5;
					} else if (resulet1 == 18) {
						s2 += 80.0;
					} else if (resulet1 == 19) {
						s2 += 85.0;
					} else if (resulet1 == 20) {
						s2 += 90.0;
					} else if (resulet1 == 21) {
						s2 += 95.0;
					}

					if (resulet1 <= 23.9)
						s2 += 10.0;
					else if (resulet1 <= 28.7 && resulet1 > 23.9)
						s2 += 30.0;
					else if (resulet1 <= 30 && resulet1 > 28.7)
						s2 += 50.0;
					else if (resulet1 <= 38.4 && resulet1 > 30)
						s2 += 70.0;
					else if (resulet1 > 38.4)
						s2 += 90.0;

				} else if (age >= 75 && age <= 79) {
					if (resulet1 == 7) {
						s2 += 5.0;
					} else if (resulet1 == 8) {
						s2 += 10.0;
					} else if (resulet1 == 9) {
						s2 += 12.5;
					} else if (resulet1 == 10) {
						s2 += 17.5;
					} else if (resulet1 == 11) {
						s2 += 25.0;
					} else if (resulet1 == 12) {
						s2 += 32.5;
					} else if (resulet1 == 13) {
						s2 += 42.5;
					} else if (resulet1 == 14) {
						s2 += 50.0;
					} else if (resulet1 == 15) {
						s2 += 57.5;
					} else if (resulet1 == 16) {
						s2 += 67.5;
					} else if (resulet1 == 17) {
						s2 += 75.0;
					} else if (resulet1 == 18) {
						s2 += 82.5;
					} else if (resulet1 == 19) {
						s2 += 87.5;
					} else if (resulet1 == 20) {
						s2 += 90.0;
					} else if (resulet1 == 21) {
						s2 += 95.5;
					}

					if (resulet1 <= 19.2)
						s2 += 10.0;
					else if (resulet1 <= 24.8 && resulet1 > 19.2)
						s2 += 30.0;
					else if (resulet1 <= 25.8 && resulet1 > 24.8)
						s2 += 50.0;
					else if (resulet1 <= 33.7 && resulet1 > 25.8)
						s2 += 70.0;
					else if (resulet1 > 33.7)
						s2 += 90.0;

				} else if (age >= 80 && age <= 84) {
					if (resulet1 <= 6) {
						s2 += 5.0;
					} else if (resulet1 == 7) {
						s2 += 10.0;
					} else if (resulet1 == 8) {
						s2 += 15.0;
					} else if (resulet1 == 9) {
						s2 += 20.0;
					} else if (resulet1 == 10) {
						s2 += 27.5;
					} else if (resulet1 == 11) {
						s2 += 37.5;
					} else if (resulet1 == 12) {
						s2 += 47.5;
					} else if (resulet1 == 13) {
						s2 += 57.5;
					} else if (resulet1 == 14) {
						s2 += 67.5;
					} else if (resulet1 == 15) {
						s2 += 75.0;
					} else if (resulet1 == 16) {
						s2 += 82.5;
					} else if (resulet1 == 17) {
						s2 += 90.0;
					} else if (resulet1 == 18) {
						s2 += 92.5;
					} else if (resulet1 == 19) {
						s2 += 95.0;
					}

					if (resulet1 <= 19.4)
						s2 += 10.0;
					else if (resulet1 <= 23.2 && resulet1 > 19.4)
						s2 += 30.0;
					else if (resulet1 <= 24.2 && resulet1 > 23.2)
						s2 += 50.0;
					else if (resulet1 <= 30 && resulet1 > 24.2)
						s2 += 70.0;
					else if (resulet1 > 30)
						s2 += 90.0;

				} else if (age >= 85 && age <= 89) {
					if (resulet1 <= 4) {
						s2 += 5.0;
					} else if (resulet1 == 5) {
						s2 += 10.0;
					} else if (resulet1 == 6) {
						s2 += 15.0;
					} else if (resulet1 == 7) {
						s2 += 20.0;
					} else if (resulet1 == 8) {
						s2 += 25.0;
					} else if (resulet1 == 9) {
						s2 += 32.5;
					} else if (resulet1 == 10) {
						s2 += 40.0;
					} else if (resulet1 == 11) {
						s2 += 47.5;
					} else if (resulet1 == 12) {
						s2 += 57.5;
					} else if (resulet1 == 13) {
						s2 += 67.5;
					} else if (resulet1 == 14) {
						s2 += 75.0;
					} else if (resulet1 == 15) {
						s2 += 80.0;
					} else if (resulet1 == 16) {
						s2 += 85.0;
					} else if (resulet1 == 17) {
						s2 += 90.0;
					} else if (resulet1 == 18) {
						s2 += 92.5;
					} else if (resulet1 == 17) {
						s2 += 95.0;
					}

					if (resulet1 <= 18.3)
						s2 += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 18.3)
						s2 += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						s2 += 50.0;
					else if (resulet1 <= 29 && resulet1 > 21.1)
						s2 += 70.0;
					else if (resulet1 > 29)
						s2 += 90.0;

				} else if (age >= 90 && age <= 100) {
					if (resulet1 <= 3) {
						s2 += 5.0;
					} else if (resulet1 == 4) {
						s2 += 7.5;
					} else if (resulet1 == 5) {
						s2 += 10.0;
					} else if (resulet1 == 6) {
						s2 += 15.0;
					} else if (resulet1 == 7) {
						s2 += 22.5;
					} else if (resulet1 == 8) {
						s2 += 32.5;
					} else if (resulet1 == 9) {
						s2 += 42.5;
					} else if (resulet1 == 10) {
						s2 += 52.5;
					} else if (resulet1 == 11) {
						s2 += 62.5;
					} else if (resulet1 == 12) {
						s2 += 72.5;
					} else if (resulet1 == 13) {
						s2 += 80.0;
					} else if (resulet1 == 14) {
						s2 += 85.0;
					} else if (resulet1 == 15) {
						s2 += 90.0;
					} else if (resulet1 == 16) {
						s2 += 95.0;
					}

					if (resulet1 <= 18.3)
						s2 += 10.0;
					else if (resulet1 <= 20.6 && resulet1 > 18.3)
						s2 += 30.0;
					else if (resulet1 <= 21.1 && resulet1 > 20.6)
						s2 += 50.0;
					else if (resulet1 <= 29 && resulet1 > 21.1)
						s2 += 70.0;
					else if (resulet1 > 29)
						s2 += 90.0;

				}

			}
			resulet = Math.pow(s1 + s2 - cords, 2) / evg;
			score += resulet;
		}
		return score;
	}

	/**
	 * mmse+moca量表计算分值
	 * 
	 * @param recod
	 * @param calibrations
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Double getEvgM(List<RecordMOVO> recod, int calibrations) {
		double scroe = 0;
		for (RecordMOVO m : recod) {
			MyBeanWithPerson mb1 = getMyBeanWithPerson(m.getDetailMMSE());
			MyBeanWithPerson mb2 = getMyBeanWithPerson(m.getDetailMOCA());
			List<QuestionVO> mmse = mb1.getResult();
			List<QuestionVO> moca = mb2.getResult();
			for (QuestionVO q : mmse) {
				int s = Integer.parseInt(q.getScore());
				if (calibrations == 9 && q.getQuestion_id().equals("114")
						| q.getQuestion_id().equals("115")
						| q.getQuestion_id().equals("285")) {
					scroe += s;
				} else if (calibrations == 10 | calibrations == 16
						&& q.getQuestion_id().equals("117")) {
					scroe += s;
				} else if (calibrations == 11 | calibrations == 12
						&& q.getQuestion_id().equals("116")) {
					scroe += s;
				} else if (calibrations == 18
						&& q.getQuestion_id().equals("118")
						| q.getQuestion_id().equals("120")
						| q.getQuestion_id().equals("122")
						| q.getQuestion_id().equals("124")
						| q.getQuestion_id().equals("126")
						| q.getQuestion_id().equals("127")) {
					scroe += s;
				} else if (calibrations == 15
						&& q.getQuestion_id().equals("130")) {
					scroe += s;
				}
			}
			for (QuestionVO q : moca) {
				int s = Integer.parseInt(q.getScore());
				if (calibrations == 9 && q.getQuestion_id().equals("391")) {
					// 定向力
					scroe += s;
				} else if (calibrations == 13
						&& q.getQuestion_id().equals("389")) {
					// 抽象
					scroe += s;
				} else if (calibrations == 10
						&& q.getQuestion_id().equals("384")
						| q.getQuestion_id().equals("385")
						| q.getQuestion_id().equals("386")) {
					// 注意力
					scroe += s;
				} else if (calibrations == 11
						&& q.getQuestion_id().equals("383")) {
					// 记忆力
					scroe += s;
				} else if (calibrations == 12
						&& q.getQuestion_id().equals("390")) {
					// 回忆力
					scroe += s;
				} else if (calibrations == 14
						&& q.getQuestion_id().equals("379")
						| q.getQuestion_id().equals("380")
						| q.getQuestion_id().equals("381")) {
					// 视结构技
					scroe += s;
				} else if (calibrations == 15
						&& q.getQuestion_id().equals("379")
						| q.getQuestion_id().equals("380")
						| q.getQuestion_id().equals("381")) {
					// 执行能力
					scroe += s;
				} else if (calibrations == 16
						&& q.getQuestion_id().equals("386")) {
					// 计算力
					scroe += s;
				} else if (calibrations == 18
						&& q.getQuestion_id().equals("382")
						| q.getQuestion_id().equals("387")
						| q.getQuestion_id().equals("388")) {
					scroe += s;

				}
			}
		}
		return scroe;
	}

	@SuppressWarnings("unchecked")
	public static Double getEvgq(List<RecordMOVO> recod, double cords, int evg,
			int calibrations) {
		double scroe = 0;
		for (RecordMOVO m : recod) {
			MyBeanWithPerson mb1 = getMyBeanWithPerson(m.getDetailMMSE());
			MyBeanWithPerson mb2 = getMyBeanWithPerson(m.getDetailMOCA());
			List<QuestionVO> mmse = mb1.getResult();
			List<QuestionVO> moca = mb2.getResult();
			int s1 = 0;
			int s2 = 0;
			for (QuestionVO q : mmse) {
				int s = Integer.parseInt(q.getScore());
				if (calibrations == 9 && q.getQuestion_id().equals("114")
						| q.getQuestion_id().equals("115")
						| q.getQuestion_id().equals("285")) {
					s1 += s;
				} else if (calibrations == 10 | calibrations == 16
						&& q.getQuestion_id().equals("117")) {
					s1 += s;
				} else if (calibrations == 11 | calibrations == 12
						&& q.getQuestion_id().equals("116")) {
					s1 += s;
				} else if (calibrations == 18
						&& q.getQuestion_id().equals("118")
						| q.getQuestion_id().equals("120")
						| q.getQuestion_id().equals("122")
						| q.getQuestion_id().equals("124")
						| q.getQuestion_id().equals("126")
						| q.getQuestion_id().equals("127")) {
					s1 += s;
				} else if (calibrations == 15
						&& q.getQuestion_id().equals("130")) {
					s1 += s;
				}

			}
			for (QuestionVO q : moca) {
				int s = Integer.parseInt(q.getScore());
				if (calibrations == 9 && q.getQuestion_id().equals("391")) {
					// 定向力
					s2 += s;
				} else if (calibrations == 13
						&& q.getQuestion_id().equals("389")) {
					// 抽象
					scroe += s;
				} else if (calibrations == 10
						&& q.getQuestion_id().equals("384")
						| q.getQuestion_id().equals("385")
						| q.getQuestion_id().equals("386")) {
					// 注意力
					s2 += s;
				} else if (calibrations == 11
						&& q.getQuestion_id().equals("383")) {
					// 记忆力
					s2 += s;
				} else if (calibrations == 12
						&& q.getQuestion_id().equals("390")) {
					// 回忆力
					s2 += s;
				} else if (calibrations == 14
						&& q.getQuestion_id().equals("379")
						| q.getQuestion_id().equals("380")
						| q.getQuestion_id().equals("381")) {
					// 视结构技
					s2 += s;
				} else if (calibrations == 15
						&& q.getQuestion_id().equals("379")
						| q.getQuestion_id().equals("380")
						| q.getQuestion_id().equals("381")) {
					// 执行能力
					s2 += s;
				} else if (calibrations == 16
						&& q.getQuestion_id().equals("386")) {
					// 计算力
					s2 += s;
				} else if (calibrations == 18
						&& q.getQuestion_id().equals("382")
						| q.getQuestion_id().equals("387")
						| q.getQuestion_id().equals("388")) {
					s2 += s;
				}
			}
			double a = Math.pow(s1 + s2 - cords, 2) / evg;
			scroe += a;
		}

		return scroe;
	}
	/**
	 * 单体T检验终值
	 * 
	 * @param cords_
	 * @param cords_x
	 * @param evg_ex
	 * @param evg
	 * @return
	 */
	public static double getT(double cords_, double cords_x, double evg_ex,
			int evg) {
		return (cords_ - cords_x) / (evg_ex / Math.sqrt(evg * 4 - 1));
	}
	@SuppressWarnings("unchecked")
	public static double getq(List<RecordVO> eRe, double cords, int evg) {
		double evg_e = 0.0;
		for (RecordVO m : eRe) {
			MyBeanWithPerson mb = getMyBeanWithPerson(m);
			List<QuestionVO> qu = mb.getResult();
			// 获取老人参加活动后评估得分
			int scroe = 0;
			for (QuestionVO q : qu) {
				scroe = Integer.parseInt(q.getScore());
			}
			double a = Math.pow(scroe - cords, 2) / evg;
			evg_e += a;
		}
		return Math.sqrt(evg_e);
	}
	/**
	 * 性别分类
	 * @param eRe
	 * @param sRe
	 * @return
	 * @throws Exception
	 */
	public Double getMap(List<RecordVO> eRe, List<RecordVO> sRe)
			throws Exception {
		List<RecordVO> m_s = new ArrayList<RecordVO>();// 男 前
		List<RecordVO> m_e = new ArrayList<RecordVO>();// 男 后
		List<RecordVO> w_s = new ArrayList<RecordVO>();// 女
		List<RecordVO> w_e = new ArrayList<RecordVO>();// 女后
		for (int i = 0; i < eRe.size(); i++) {
			RecordVO s = sRe.get(i);
			RecordVO e = eRe.get(i);
			RUser r = rUserDao.findById(s.getUserId());
			if(r==null){
				continue;
			}
			if (r.getGender() == 0) {// 女
				w_s.add(s);
				w_e.add(e);
			} else {
				m_s.add(s);
				m_e.add(e);
			}
		}
		if (m_s.size() <= 1 || w_s.size() <= 1) {
			throw new Exception("人数不足,无法分析!");
		}
		double s_st = getScroe(m_s) / m_s.size();// 分组男 参加活动前平均值
		double s_et = getScroe(m_e) / m_s.size();// 分组男 参加活动后平均值
		double s_difference = s_et - s_st;
		double s1 = getq(m_e, s_difference, m_s.size());
		double e_st = getScroe(w_s) / w_s.size();// 分组女 参加活动前平均值
		double e_et = getScroe(w_s) / w_s.size();// 分组女 参加活动后前平均值
		double e_difference = e_et - e_st;
		double s2 = getq(w_e, e_difference, w_s.size());
		double s_size = m_e.size();
		double w_size =w_s.size();
		double m_t_ = (((s_size - 1) * Math.pow(s1, 2) + (w_size - 1)* Math.pow(s2, 2)) / (s_size + w_size - 2))* (1 / s_size + 1 / w_size);
		double t = (s_difference - e_difference) / Math.sqrt(m_t_);
		return t;
	}

	/**
	 * 本方法用于获取 ADL ADLS MOCA 三张量表的分值（另MOCA和MMSE组合选项及体适能另外方法）
	 * 
	 * @param sRe
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static int getScroe(List<RecordVO> sRe) {
		int scroe = 0;
		for (RecordVO m : sRe) {
			MyBeanWithPerson mb = getMyBeanWithPerson(m);
			List<QuestionVO> qu = mb.getResult();
			for (QuestionVO q : qu) {
				scroe += Integer.parseInt(q.getScore());
			}
		}
		return scroe;
	}

	/**
	 * 血压 双因素
	 * 
	 * @param eRe
	 * @return
	 * @throws Exception
	 */
	public Double gettbpMap(List<MPressureVO> eRe) throws Exception {
		List<MPressureVO> m_s = new ArrayList<MPressureVO>();// 男
		List<MPressureVO> w_s = new ArrayList<MPressureVO>();// 女
		for (int i = 0; i < eRe.size(); i++) {
			MPressureVO e = eRe.get(i);
			RUser r = rUserDao.findById(e.getUserId());
			if (r.getGender() == 0) {// 女
				w_s.add(e);
			} else {
				m_s.add(e);
			}
		}
		if (m_s.size() >= 1 || w_s.size() >= 1) {
			throw new Exception("人数不足,无法分析!");
		}
		double s_st = getMPressure(m_s) / m_s.size();// 分组男 参加活动前平均值
		double s_et = assessUtil.getMPressure(m_s) / m_s.size();// 分组男 参加活动前平均值
		double s_difference = s_et - s_st;

		double s1 = assessUtil.getMPressure(m_s, s_difference);

		double e_st = getMPressure(w_s) / w_s.size();// 分组女 参加活动前平均值
		double e_et = assessUtil.getMPressure(m_s) / w_s.size();// 分组女 参加活动后前平均值
		double e_difference = e_et - e_st;
		double s2 = assessUtil.getMPressure(w_s, e_difference);
		double s_size = m_s.size();
		double w_size = w_s.size();
		double m_t_ = (((s_size - 1) * Math.pow(s1, 2) + (w_size - 1)
				* Math.pow(s2, 2)) / (s_size +w_size - 2))
				* (1 / s_size + 1 / w_s.size());
		double t = (s_difference - e_difference) / Math.sqrt(m_t_);
		return t;
	}

	/**
	 * 获取T值 体适能两项组合
	 * 
	 * @param eRe
	 * @param calibrations
	 * @return
	 * @throws Exception
	 */
	public Double gettslsMap(List<FitnessVO2> eRe, int calibrations)
			throws Exception {
		List<FitnessVO2> m_s = new ArrayList<FitnessVO2>();// 男 前
		List<FitnessVO2> w_s = new ArrayList<FitnessVO2>();// 女
		for (int i = 0; i < eRe.size(); i++) {
			FitnessVO2 e = eRe.get(i);
			if (e.getSex() == 0) {// 女
				w_s.add(e);
			} else {
				m_s.add(e);
			}
		}

		if (m_s.size() >= 1 || w_s.size() >= 1) {
			throw new Exception("人数不足,无法分析!");
		}
		double s_st = getTsl_(m_s, calibrations) / m_s.size();// 分组男 参加活动前平均值
		double s_et = assessUtil.getTsl_(m_s, calibrations) / m_s.size();// 分组男
																			// 参加活动前平均值
		double s_difference = s_et - s_st;

		double s1 = assessUtil.getTslq_s(m_s, s_difference, calibrations);

		double e_st = getTsl_(w_s, calibrations) / w_s.size();// 分组女 参加活动前平均值
		double e_et = assessUtil.getTsl_(w_s, calibrations) / w_s.size();// 分组女
																			// 参加活动后前平均值
		double e_difference = e_et - e_st;
		double s2 = assessUtil.getTslq_s(w_s, e_difference, calibrations);
		double s_size = m_s.size();
		double w_size = w_s.size();
		double m_t_ = (((s_size - 1) * Math.pow(s1, 2) + (w_size - 1)
				* Math.pow(s2, 2)) / (s_size +w_size - 2))
				* (1 / s_size + 1 / w_size);
		double t = (s_difference - e_difference) / Math.sqrt(m_t_);
		return t;
	}

	/**
	 * 体适能 获取T值
	 * 
	 * @param eRe
	 * @param calibrations
	 * @return
	 * @throws Exception
	 */
	public Double gettslMap(List<FitnessVO1> eRe, int calibrations)
			throws Exception {
		List<FitnessVO1> m_s = new ArrayList<FitnessVO1>();// 男 前
		List<FitnessVO1> w_s = new ArrayList<FitnessVO1>();// 女
		for (int i = 0; i < eRe.size(); i++) {
			FitnessVO1 e = eRe.get(i);
			if (e.getSex() == 0) {// 女
				w_s.add(e);
			} else {
				m_s.add(e);
			}
		}

		if (m_s.size() >= 1 || w_s.size() >= 1) {
			throw new Exception("人数不足,无法分析!");
		}

		double s_st = getTsl(m_s, calibrations) / m_s.size();// 分组男 参加活动前平均值
		double s_et = assessUtil.getTsl(m_s, calibrations) / m_s.size();// 分组男
																		// 参加活动后平均值
		double s_difference = s_et - s_st;

		double s1 = assessUtil.getTsls(m_s, s_difference, calibrations);

		double e_st = getTsl(w_s, calibrations) / w_s.size();// 分组女 参加活动前平均值
		double e_et = assessUtil.getTsl(w_s, calibrations) / w_s.size();// 分组女
																		// 参加活动后平均值
		double e_difference = e_et - e_st;
		double s2 = assessUtil.getTsls(w_s, e_difference, calibrations);
		int s_size = m_s.size();
		double m_t_ = (((s_size - 1) * Math.pow(s1, 2) + (w_s.size() - 1)
				* Math.pow(s2, 2)) / (s_size + w_s.size() - 2))
				* (1 / s_size + 1 / w_s.size());
		double t = (s_difference - e_difference) / Math.sqrt(m_t_);
		return t;
	}

	public Double getKF5(List<MPressureVO> sRe) {
		double mboost = 0.0;// 男 提高
		double mboostN = 0.0;// 男 未提高人数
		double wmboost = 0.0;// 女 提高
		double wmboostN = 0.0;// 女 未提高人数
		for (int i = 0; i < sRe.size(); i++) {
			MPressureVO m1 = sRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			if(r==null){
				continue;
			}
			double s ;
			if(m1.getLowPressures()!=null&& m1.getLowPressuree()!=null){
				s= assessUtil.getMPressure(m1.getHighPressures(),
						m1.getLowPressures());
			}else{
				continue;
			}
			double e = assessUtil.getMPressure(m1.getHighPressuree(),
					m1.getLowPressuree());
			
			if (r.getGender() == 0) {// 女
				if (e - s > 0) {
					wmboost += 1;
				} else {
					wmboostN += 1;
				}
			} else {
				if (e - s > 0) {
					mboost += 1;
				} else {
					mboostN += 1;
				}
			}
		} 
		double b10 = (mboost + wmboost) / (mboost + mboostN);
		double c10 = (mboostN + wmboostN) / (mboost + mboostN);
		double b11 = (mboost + wmboost) / (wmboost + wmboostN);
		double c11 = (mboostN + wmboostN) / (wmboost + wmboostN);
		double kf = Math.pow(mboost - b10, 2) / b10
				+ Math.pow((wmboost - b11), 2) / b11
				+ Math.pow((mboostN - c10), 2) / c10
				+ Math.pow((wmboostN - c11), 2) / c11;
		if(b10==0||c10==0||b11==0||c11==0){
			return 0.0;
		}
		return kf;
	}

	public Double getKF4(List<FitnessVO2> sRe, int call) {
		double mboost = 0.0;// 男 提高
		double mboostN = 0.0;// 男 未提高人数
		double wmboost = 0.0;// 女 提高
		double wmboostN = 0.0;// 女 未提高人数
		for (int i = 0; i < sRe.size(); i++) {
			FitnessVO2 m1 = sRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			double s = assessUtil.getTSN(m1, call, m1.getResultS1(),
					m1.getResultS2());
			double e = assessUtil.getTSN(m1, call, m1.getResultE1(),
					m1.getResultE2());
			if (r.getGender() == 0) {// 女
				if (e - s > 0) {
					wmboost += 1;
				} else {
					wmboostN += 1;
				}
			} else {
				if (e - s > 0) {
					mboost += 1;
				} else {
					mboostN += 1;
				}
			}
		}
		double b10 = (mboost + wmboost) / (mboost + mboostN);
		double c10 = (mboostN + wmboostN) / (mboost + mboostN);
		double b11 = (mboost + wmboost) / (wmboost + wmboostN);
		double c11 = (mboostN + wmboostN) / (wmboost + wmboostN);
		double kf = Math.pow(mboost - b10, 2) / b10
				+ Math.pow((wmboost - b11), 2) / b11
				+ Math.pow((mboostN - c10), 2) / c10
				+ Math.pow((wmboostN - c11), 2) / c11;
		return kf;
	}

	public Double getKF3(List<FitnessVO1> sRe, int call) {
		double mboost = 0.0;// 男 提高
		double mboostN = 0.0;// 男 未提高人数
		double wmboost = 0.0;// 女 提高
		double wmboostN = 0.0;// 女 未提高人数
		for (int i = 0; i < sRe.size(); i++) {
			FitnessVO1 m1 = sRe.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			double s = assessUtil.getTSN(m1, call, m1.getResultS());
			double e = assessUtil.getTSN(m1, call, m1.getResultE());
			if (r.getGender() == 0) {// 女
				if (e - s > 0) {
					wmboost += 1;
				} else {
					wmboostN += 1;
				}
			} else {
				if (e - s > 0) {
					mboost += 1;
				} else {
					mboostN += 1;
				}
			}
		}
		double b10 = (mboost + wmboost) / (mboost + mboostN);
		double c10 = (mboostN + wmboostN) / (mboost + mboostN);
		double b11 = (mboost + wmboost) / (wmboost + wmboostN);
		double c11 = (mboostN + wmboostN) / (wmboost + wmboostN);
		double kf = Math.pow(mboost - b10, 2) / b10
				+ Math.pow((wmboost - b11), 2) / b11
				+ Math.pow((mboostN - c10), 2) / c10
				+ Math.pow((wmboostN - c11), 2) / c11;

		return kf;
	}

	public Double getKF2(List<RecordMOVO> sRe_, List<RecordMOVO> eRe_, int call) {
		double mboost = 0.0;// 男 提高
		double mboostN = 0.0;// 男 未提高人数
		double wmboost = 0.0;// 女 提高
		double wmboostN = 0.0;// 女 未提高人数
		for (int i = 0; i < sRe_.size(); i++) {
			RecordMOVO m1 = sRe_.get(i);
			RecordMOVO m2 = eRe_.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			double s = assessUtil.getMMSEMOCAONE(m1, call);
			double e = assessUtil.getMMSEMOCAONE(m2, call);
			if (r.getGender() == 0) {// 女
				if (e - s > 0) {
					wmboost += 1;
				} else {
					wmboostN += 1;
				}
			} else {
				if (e - s > 0) {
					mboost += 1;
				} else {
					mboostN += 1;
				}
			}
		}
		double b10 = (mboost + wmboost) / (mboost + mboostN);
		double c10 = (mboostN + wmboostN) / (mboost + mboostN);
		double b11 = (mboost + wmboost) / (wmboost + wmboostN);
		double c11 = (mboostN + wmboostN) / (wmboost + wmboostN);
		double kf = Math.pow(mboost - b10, 2) / b10
				+ Math.pow((wmboost - b11), 2) / b11
				+ Math.pow((mboostN - c10), 2) / c10
				+ Math.pow((wmboostN - c11), 2) / c11;

		return kf;
	}

	public Double getKF1(List<RecordVO> sRe_, List<RecordVO> eRe_) {
		double mboost = 0.0;// 男 提高
		double mboostN = 0.0;// 男 未提高人数
		double wmboost = 0.0;// 女 提高
		double wmboostN = 0.0;// 女 未提高人数
		for (int i = 0; i < sRe_.size(); i++) {
			RecordVO m1 = sRe_.get(i);
			RecordVO m2 = eRe_.get(i);
			RUser r = rUserDao.findById(m1.getUserId());
			if (r.getGender() == 0) {// 女
				if (getScore(m2) - getScore(m1) > 0) {
					wmboost += 1;
				} else {
					wmboostN += 1;
				}
			} else {
				if (getScore(m2) - getScore(m1) > 0) {
					mboost += 1;
				} else {
					mboostN += 1;
				}
			}
		}
		double b10 = (mboost + wmboost) / (mboost + mboostN);
		double c10 = (mboostN + wmboostN) / (mboost + mboostN);
		double b11 = (mboost + wmboost) / (wmboost + wmboostN);
		double c11 = (mboostN + wmboostN) / (wmboost + wmboostN);
		double kf = Math.pow(mboost - b10, 2) / b10
				+ Math.pow((wmboost - b11), 2) / b11
				+ Math.pow((mboostN - c10), 2) / c10
				+ Math.pow((wmboostN - c11), 2) / c11;

		return kf;
	}

	public Double getKFTSN_(List<FitnessVO2> sRe1, List<FitnessVO2> sRe2,
			int call) {
		Integer[] grade1 = new Integer[6];
		Integer[] grade2 = new Integer[6];
		for (int i = 0; i < sRe1.size(); i++) {
			FitnessVO2 m1 = sRe1.get(i);
			FitnessVO2 m2 = sRe2.get(i);
			//RUser r = rUserDao.findById(m1.getUserId());
			double s = assessUtil.getTSN(m1, call, m1.getResultS1(),
					m1.getResultS2());
			double e = assessUtil.getTSN(m1, call, m1.getResultE1(),
					m1.getResultE2());
			double s1 = assessUtil.getTSN(m2, call, m2.getResultS1(),
					m2.getResultS2());
			double e1 = assessUtil.getTSN(m2, call, m2.getResultE1(),
					m2.getResultE2());
			int grade1_ = getgrade(e) - getgrade(s);
			int grade2_ = getgrade(e1) - getgrade(s1);
			if (grade1[grade1_] == null) {
				grade1[grade1_] = 0;
			}
			if (grade2[grade2_] == null) {
				grade2[grade2_] = 0;
			}
			grade1[grade1_] += 1;
			grade2[grade2_] += 1;
		}
		Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(0, grade1);
		map.put(1, grade2);
		return getmmse(map);
	}

	public Double getKFTSN(List<FitnessVO1> sRe1, List<FitnessVO1> sRe2,
			int call) {
		Integer[] grade1 = new Integer[6];
		Integer[] grade2 = new Integer[6];

		for (int i = 0; i < sRe1.size(); i++) {
			FitnessVO1 m1 = sRe1.get(i);
			FitnessVO1 m2 = sRe1.get(i);
			//RUser r = rUserDao.findById(m1.getUserId());
			double s = assessUtil.getTSN(m1, call, m1.getResultS());
			double e = assessUtil.getTSN(m1, call, m1.getResultE());
			double s1 = assessUtil.getTSN(m2, call, m2.getResultS());
			double e1 = assessUtil.getTSN(m2, call, m2.getResultE());
			int grade1_ = getgrade(e) - getgrade(s);
			int grade2_ = getgrade(e1) - getgrade(s1);
			if (grade1[grade1_] == null) {
				grade1[grade1_] = 0;
			}
			if (grade2[grade2_] == null) {
				grade2[grade2_] = 0;
			}
			grade1[grade1_] += 1;
			grade2[grade2_] += 1;
		}
		Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(0, grade1);
		map.put(1, grade2);
		return getmmse(map);
	}

	public int getgrade(double s) {
		if (s >= 90) {
			return 5;
		} else if (s < 90 && s >= 70) {
			return 4;
		} else if (s < 90 && s >= 70) {
			return 3;
		} else if (s < 50 && s >= 30) {
			return 2;
		} else if (s < 30) {
			return 1;
		}
		return 0;

	}
	/**
	 * 获取mmse+moca细项等级划分
	 * 
	 * @param sRe1
	 * @param sRe2
	 * @param eRe1
	 * @param eRe2
	 * @param grade1
	 * @param grade2
	 * @param calibrations
	 * @return
	 */
	public static Map<Integer, Integer[]> getmmse(List<RecordMOVO> sRe1,
			List<RecordMOVO> sRe2, List<RecordMOVO> eRe1,
			List<RecordMOVO> eRe2, Integer[] grade1, Integer[] grade2,
			int calibrations) {
		for (int i = 0; i < sRe1.size(); i++) {
			int s = (int) assessUtil.getMMSEMOCAONE(sRe1.get(i), calibrations);
			int e = (int) assessUtil.getMMSEMOCAONE(eRe1.get(i), calibrations);
			if (grade1[e - s] == null)
				grade1[e - s] = 0;
			grade1[e - s] += 1;
		}
		for (int i = 0; i < sRe2.size(); i++) {
			int s = (int) assessUtil.getMMSEMOCAONE(sRe2.get(i), calibrations);
			int e = (int) assessUtil.getMMSEMOCAONE(eRe2.get(i), calibrations);
			if (grade1[e - s] == null)
				grade1[e - s] = 0;
			grade2[e - s] += 1;
		}
		Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(0, grade1);
		map.put(1, grade2);
		return map;
	}

	public static Double getmmse(Map<Integer, Integer[]> getmmse) {
		Map<Integer, Integer[]> map = getmmse;
		Integer[] grade1 = map.get(0);
		Integer[] grade2 = map.get(1);

		int sum1 = 0;// 第一分组和
		int sum2 = 0;// 第二分组和

		for (int i = 0; i < grade1.length; i++) {
			if (grade1[i] != null) {
				sum1 += grade1[i];
			} else {
				grade1[i] = 0;
			}
			if (grade2[i] != null) {
				sum2 += grade2[i];
			} else {
				grade2[i] = 0;
			}
		}
		int sum_ = sum1 + sum2;// 人数
		double x2 = 0;
		for (int i = 0; i < grade1.length; i++) {
			double grade1_ = sum1 * (grade1[i] + grade2[i]) / sum_;
			double grade2_ = sum2 * (grade1[i] + grade2[i]) / sum_;
			x2 += (grade1[i] - grade1_) * (grade1[i] - grade1_) / grade1_;
			x2 += (grade2[i] - grade2_) * (grade2[i] - grade2_) / grade2_;
		}
		return x2;
	}

	public Double getSSTHP(List<MPressureVO> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (MPressureVO m : eRe) {
			double s = assessUtil.getMPressure(m.getHighPressuree(),
					m.getLowPressuree())
					- cords_;
			sst += s * s;
		}
		return sst;
	}

	public Double getSSTTSN_(List<FitnessVO2> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (FitnessVO2 m : eRe) {
			double s = assessUtil.getTSN(m, calibrations, m.getResultE1(),
					m.getResultE2())
					- cords_;
			sst += s * s;
		}
		return sst;
	}

	public Double getSSTTSN(List<FitnessVO1> eRe, double cords_,
			int calibrations) {
		double sst = 0;
		for (FitnessVO1 m : eRe) {
			double s = assessUtil.getTSN(m, calibrations, m.getResultE())
					- cords_;
			sst += s * s;
		}
		return sst;
	}

	public Double getSST(List<RecordMOVO> eRe, double cords_, int calibrations) {
		double sst = 0;
		for (RecordMOVO m : eRe) {
			double s = assessUtil.getMMSEMOCAONE(m, calibrations) - cords_;
			sst += s * s;
		}
		return sst;
	}

	public Double getSST(List<RecordVO> eRe, double cords_) {
		double sst = 0;
		for (RecordVO m : eRe) {
			double s = getScore(m);
			sst += s * s;
		}
		return sst;
	}

	/*
	 * 除体适能外 量表单表数据累加
	 */
	@SuppressWarnings("unchecked")
	public static double getScore(RecordVO m) {
		double scroe = 0.0;
		MyBeanWithPerson mb = getMyBeanWithPerson(m);
		List<QuestionVO> qu = mb.getResult();
		for (QuestionVO q : qu) {
			scroe += Integer.parseInt(q.getScore());
		}
		return scroe;
	}

	private static MyBeanWithPerson getMyBeanWithPerson(RecordVO m2) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
		classMap.put("result", QuestionVO.class);
		String json = m2.getDetail();
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(json);
		String strNoBlank = m.replaceAll("");
		json = strNoBlank.substring(1, strNoBlank.length() - 1);
		return myBeanWithPerson(json, classMap);
	}

	private static MyBeanWithPerson getMyBeanWithPerson(String m2) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
		classMap.put("result", QuestionVO.class);
		String json = m2;
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(json);
		String strNoBlank = m.replaceAll("");
		json = strNoBlank.substring(1, strNoBlank.length() - 1);
		return myBeanWithPerson(json, classMap);
	}

	public final static MyBeanWithPerson myBeanWithPerson(String json,
			Map<String, Class<QuestionVO>> classMap) {
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(
				JSONObject.fromObject(json), MyBeanWithPerson.class, classMap);
		;
		return diyBean;
	}

	public Double getMocaMap(List<RecordMOVO> eRe, List<RecordMOVO> sRe,
			int call) throws Exception {
		List<RecordMOVO> m_s = new ArrayList<RecordMOVO>();// 男 前
		List<RecordMOVO> m_e = new ArrayList<RecordMOVO>();// 男 后
		List<RecordMOVO> w_s = new ArrayList<RecordMOVO>();// 女
		List<RecordMOVO> w_e = new ArrayList<RecordMOVO>();// 女后
		for (int i = 0; i < eRe.size(); i++) {
			RecordMOVO s = sRe.get(i);
			RecordMOVO e = eRe.get(i);
			RUser r = rUserDao.findById(s.getUserId());
			if(r==null){
				continue;
			}
			if (r.getGender() == 0) {// 女
				w_s.add(s);
				w_e.add(e);
			} else {
				m_s.add(s);
				m_e.add(e);
			}
		}
		if (m_s.size() >= 1 || w_s.size() >= 1) {
			throw new Exception("人数不足,无法分析!");
		}
		double s_st = getEvgM(m_s, call) / m_s.size();// 分组男 参加活动前平均值
		double s_et = getEvgM(m_e, call) / m_s.size();// 分组男 参加活动后前平均值
		double s_difference = s_et - s_st;

		double s1 = getEvgq(m_e, s_difference, m_s.size(), call);
		double e_st = getEvgM(w_s, call) / w_s.size();// 分组女 参加活动前平均值
		double e_et = getEvgM(w_s, call) / w_s.size();// 分组女 参加活动后前平均值
		double e_difference = e_et - e_st;
		double s2 = getEvgq(w_e, e_difference, w_s.size(), call);
		int s_size = m_e.size();
		double m_t_ = (((s_size - 1) * Math.pow(s1, 2) + (w_s.size() - 1)
				* Math.pow(s2, 2)) / (s_size + w_s.size() - 2))
				* (1 / s_size + 1 / w_s.size());
		double t = (s_difference - e_difference) / Math.sqrt(m_t_);
		return t;
	}

	/*
	 * public static void main(String[] args) { List<Integer> a=new
	 * ArrayList<Integer>();
	 * 
	 * }
	 */
	public void run() {
		switch (this.itemizeid) {
		case 1:
			save1(this.ts, this.te, this.group, this.itemizeid);
			break; // 日常生活自理能力
		case 2:
			save2(this.ts, this.te, this.group, this.itemizeid, 2);
			break; // 工具性活动能力

		case 3:
			save3(this.ts, this.group, this.itemizeid);
			break; // 身体成分
		case 4:
			save4(this.ts, this.group, this.itemizeid);
			break; // 肌力（握力）

		case 5:
			save5(this.ts, this.group, this.itemizeid, 5);
			break; // 5,6,7相同获取分值方法 心肺耐力
		case 6:
			save5(this.ts, this.group, this.itemizeid, 5);
			break; // 柔软素质
		case 7:
			save5(this.ts, this.group, this.itemizeid, 5);
			break; // 神经反应能力

		case 8:
			save8(this.ts, this.group, this.itemizeid);
			break; // 血压
		case 9:
			save9(this.ts, this.te, this.group, this.itemizeid, 9);
			break; // 定向力 9,10,11,12,13,14,15,16,18相同获取分值方法
		case 10:
			save9(this.ts, this.te, this.group, this.itemizeid, 10);
			break; // 注意力与集中力
		case 11:
			save9(this.ts, this.te, this.group, this.itemizeid, 11);
			break; // 记忆力
		case 12:
			save9(this.ts, this.te, this.group, this.itemizeid, 12);
			break; // 回忆力
		case 13:
			save9(this.ts, this.te, this.group, this.itemizeid, 13);
			break; // 抽象思维
		case 14:
			save9(this.ts, this.te, this.group, this.itemizeid, 14);
			break; // 视结构技能得分
		case 15:
			save9(this.ts, this.te, this.group, this.itemizeid, 15);
			break; // 执行能力得分
		case 16:
			save9(this.ts, this.te, this.group, this.itemizeid, 16);
			break; // 计算力
		case 17:
			save2(this.ts, this.te, this.group, this.itemizeid, 2);
			break; // 心理素质
		case 18:
			save9(this.ts, this.te, this.group, this.itemizeid, 18);
			break;// 语言能力

		}

	}

	/**
	 * adl
	 * 
	 * @param po
	 * @param group1
	 * @param group2
	 * @param itemizeid
	 * @param twoFactor
	 * @param aValue
	 * @param verifyMode
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void save1(List ts, List te, Integer group, Integer itemizeid) {
		Date date = new Date();
		List<RecordVO> lists = ts;// 干预前
		List<RecordVO> liste = ts;// 干预后
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<RecordVO> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
			List<RecordVO> eRe1 = liste.subList(i * length, (i + 1) * length);// 干预后
			for (int j = 0; j < sRe1.size(); j++) {
				double score = getScore(sRe1.get(i));// 干预前分值
				double score1 = getScore(eRe1.get(i));// 干预后分值
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(1);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(1);
				us.setUserId(sRe1.get(j).getUserId());
				r.setUserId(sRe1.get(j).getUserId());
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				u.add(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setCreatedAt(date);
				rUserAssesscoreDao.save(r);
			}
			saveMUserInter(date, u);
		}
	}

	/**
	 * Iadl
	 * 
	 * @param ts
	 * @param te
	 * @param group
	 * @param itemizeid
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save2(List ts, List te, Integer group, Integer itemizeid, int m) {
		Date date = new Date();
		List<RecordVO> lists = ts;// 干预前
		List<RecordVO> liste = ts;// 干预后
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<RecordVO> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
																				// 干预前
			List<RecordVO> eRe1 = liste.subList(i * length, (i + 1) * length);// 干预后
			for (int j = 0; j < sRe1.size(); j++) {
				double score = getScore(sRe1.get(i));// 干预前分值
				double score1 = getScore(eRe1.get(i));// 干预后分值
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(m);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(m);
				us.setUserId(sRe1.get(j).getUserId());
				r.setUserId(sRe1.get(j).getUserId());
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				u.add(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setCreatedAt(date);
				this.rUserAssesscoreDao.save(r);
			}
			saveMUserInter1(date, u);
		}
	}

	/**
	 * 身体成分
	 * 
	 * @param ts
	 * @param group
	 * @param itemizeid
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save3(List ts, Integer group, Integer itemizeid) {
		Date date = new Date();
		List<FitnessVO2> lists = ts;
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			//List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<FitnessVO2> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
																				// 干预前
			for (int j = 0; j < sRe1.size(); j++) {
				double score = assessUtil.getTSN(sRe1.get(i), 3, sRe1.get(i)
						.getResultS1(), sRe1.get(i).getResultS2());// 干预前分值
				double score1 = assessUtil.getTSN(sRe1.get(i), 3, sRe1.get(i)
						.getResultE1(), sRe1.get(i).getResultE2());// 干预后分值
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(3);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(3);
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				us.setUserId(sRe1.get(j).getUserId());
				us.setCreatedAt(date);
				mUserInterveneDao.save(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setUserId(sRe1.get(j).getUserId());
				r.setCreatedAt(date);
				rUserAssesscoreDao.save(r);
			}

		}
	}

	/**
	 * 肌力
	 * 
	 * @param ts
	 * @param group
	 * @param itemizeid
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save4(List ts, Integer group, Integer itemizeid) {
		Date date = new Date();
		List<FitnessVO2> lists = ts;
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<FitnessVO2> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
			for (int j = 0; j < sRe1.size(); j++) {
				double score = assessUtil.getTSN(sRe1.get(i), 4, sRe1.get(i)
						.getResultS1(), sRe1.get(i).getResultS2());// 干预前分值
				double score1 = assessUtil.getTSN(sRe1.get(i), 4, sRe1.get(i)
						.getResultE1(), sRe1.get(i).getResultE2());// 干预后分值
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(1);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(1);
				us.setUserId(sRe1.get(j).getUserId());
				r.setUserId(sRe1.get(j).getUserId());
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				u.add(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setCreatedAt(date);
				rUserAssesscoreDao.save(r);
			}
			saveMUserInter(date, u);
		}
	}

	/**
	 * m={5,6,7 此三种获取值类型相同}
	 * 
	 * @param ts
	 * @param group
	 * @param itemizeid
	 * @param m
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void save5(List ts, Integer group, Integer itemizeid, int m) {
		Date date = new Date();
		List<FitnessVO1> lists = ts;
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<FitnessVO1> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
																				// 干预前
			for (int j = 0; j < sRe1.size(); j++) {
				double score = assessUtil.getTSN(sRe1.get(i), m, sRe1.get(i)
						.getResultS());// 干预前分值
				double score1 = assessUtil.getTSN(sRe1.get(i), m, sRe1.get(i)
						.getResultE());// 干预后分值
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(m);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(m);
				us.setUserId(sRe1.get(j).getUserId());
				r.setUserId(sRe1.get(j).getUserId());
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				u.add(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setCreatedAt(date);
				rUserAssesscoreDao.save(r);
			}
			saveMUserInter2(date, u);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save8(List ts, Integer group, Integer itemizeid) {
		Date date = new Date();
		List<MPressureVO> lists = ts;
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			//List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<MPressureVO> sRe1 = lists
					.subList(i * length, (i + 1) * length);// 获取分组数据 干预前
			for (int j = 0; j < sRe1.size(); j++) {
				double score = assessUtil.getMPressure(sRe1.get(i)
						.getLowPressures(), sRe1.get(i).getHighPressures());
				double score1 = assessUtil.getMPressure(sRe1.get(i)
						.getLowPressuree(), sRe1.get(i).getHighPressuree());
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(8);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(8);
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				us.setUserId(sRe1.get(j).getUserId());
				us.setCreatedAt(date);
				mUserInterveneDao.save(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setUserId(sRe1.get(j).getUserId());
				r.setCreatedAt(date);
				rUserAssesscoreDao.save(r);
			}
		}

	}
	/**
	 * 9,10,11,12,13,14,15,16,18
	 * 
	 * @param ts
	 * @param te
	 * @param group
	 * @param itemizeid
	 * @param m
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save9(List ts, List te, Integer group, Integer itemizeid, int m) {
		Date date = new Date();
		List<RecordMOVO> lists = ts;
		List<RecordMOVO> liste = te;
		int length = lists.size() / 4;
		if (length < 4) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			List<MUserIntervene> u = new ArrayList<MUserIntervene>();
			List<RecordMOVO> sRe1 = lists.subList(i * length, (i + 1) * length);// 获取分组数据
			List<RecordMOVO> eRe1 = liste.subList(i * length, (i + 1) * length);// 获取分组数据
			for (int j = 0; j < sRe1.size(); j++) {
				double score = assessUtil.getMMSEMOCAONE(sRe1.get(i), m);
				double score1 = assessUtil.getMMSEMOCAONE(eRe1.get(i), m);
				RUserAssesscore r = new RUserAssesscore();
				r.setItemize(m);
				MUserIntervene us = new MUserIntervene();
				us.setTestCategory(m);
				us.setUserId(sRe1.get(j).getUserId());
				r.setUserId(sRe1.get(j).getUserId());
				us.setPacketTypes(i);
				us.setInterveneGo(score);
				us.setInterveneLa(score1);
				u.add(us);
				r.setTotingPointse(score1);
				r.setTotingPointss(score);
				r.setCreatedAt(date);
				r.setSex((short)1);
				r.setCreatedBy("cm");
				r.setItemize(itemizeid);
				rUserAssesscoreDao.save(r);
			}
			saveMUserInter(date, u);
		}
	}
	/**
	 * 添加总数据
	 * 
	 * @param date
	 * @param u
	 */
	@SuppressWarnings("unchecked")
	private void saveMUserInter(Date date, List<MUserIntervene> u) {
		ListArrayComparator comparator = new ListArrayComparator();// 升序
		Collections.sort(u, comparator);
		double smin = u.get(0).getInterveneGo();
		double smax = u.get(u.size() - 1).getInterveneGo();
		ListArrayComparatore comparator1 = new ListArrayComparatore();
		Collections.sort(u, comparator1);
		//double emin = u.get(0).getInterveneLa();
		//double emax = u.get(u.size() - 1).getInterveneLa();
		for (MUserIntervene u1 : u) {
			if (smax - smin != 0) {
				u1.setInterveneGo((u1.getInterveneGo() - smin) / (smax - smin));
				u1.setInterveneLa((u1.getInterveneLa() - smin) / (smax - smin));
			}else{
				u1.setInterveneLa(0.0);
				u1.setInterveneGo(0.0);
			}
			u1.setCreatedAt(date);
			mUserInterveneDao.save(u1);
		}
	}

	@SuppressWarnings("unchecked")
	private void saveMUserInter2(Date date, List<MUserIntervene> u) {
		ListArrayComparator comparator = new ListArrayComparator();// 升序
		Collections.sort(u, comparator);//double smin = u.get(0).getInterveneGo();//double smax = u.get(u.size() - 1).getInterveneGo();
		ListArrayComparatore comparator1 = new ListArrayComparatore();
		Collections.sort(u, comparator1);//double emin = u.get(0).getInterveneLa();//double emax = u.get(u.size() - 1).getInterveneLa();
		for (MUserIntervene u1 : u) {
			u1.setInterveneGo(u1.getInterveneGo() / 100);
			u1.setInterveneLa(u1.getInterveneLa() / 100);
			u1.setCreatedAt(date);
			mUserInterveneDao.save(u1);
		}
	}

	/**
	 * 添加总数据
	 * 
	 * @param date
	 * @param u
	 */
	@SuppressWarnings("unchecked")
	private void saveMUserInter1(Date date, List<MUserIntervene> u) {
		ListArrayComparator comparator = new ListArrayComparator();// 升序
		Collections.sort(u, comparator);
		double smin = u.get(0).getInterveneGo();
		double smax = u.get(u.size() - 1).getInterveneGo();
		ListArrayComparatore comparator1 = new ListArrayComparatore();
		Collections.sort(u, comparator1);
		//double emin = u.get(0).getInterveneLa();
		//double emax = u.get(u.size() - 1).getInterveneLa();

		for (MUserIntervene u1 : u) {
			if (smax - smin != 0) {
				u1.setInterveneLa(1 - (u1.getInterveneLa() - smin)
						/ (smax - smin));
				u1.setInterveneGo(1 - (u1.getInterveneGo() - smin)
						/ (smax - smin));
			}else{
				u1.setInterveneLa(0.0);
				u1.setInterveneGo(0.0);
			}
			u1.setCreatedAt(date);
			mUserInterveneDao.save(u1);
		}
	}
	public List<MVenderInterveneVO> getMVenderInterveneVO(){
		return mVenderInterveneDao.getMVenderInterveneVO();
	}
	/**
	 * 获取当前选择组 最新一条单因素数据
	 * @param itemizeId
	 * @return
	 */
	public List<MVenderIntervene> getList(int itemizeId){
		return mVenderInterveneDao.getList(itemizeId);
	}
	/**
	 * 获取当前选择组 最新一条双因素数据
	 * @param itemizeId
	 * @return
	 */
	public List<MVenderIntervene> getListTwo(int itemizeId){
		return mVenderInterveneDao.getListTwo(itemizeId);
	} 
	/**
	 * T双因素计算结果｛统一性除性别外｝
	 * @param facmapsre
	 * @param facmapere
	 * @return
	 * @throws Exception
	 */
	public List<Double> getMap_(Map<Integer, List<RecordVO>> facmapsre, Map<Integer, List<RecordVO>> facmapere)
			throws Exception {
		//double evg_=0.0; //增加平均值之差double s_s=0.0;  //(n-1)*s*s  double n_n=0.0;  //(1/n_1+1/n_2+...+1/n_n)int ns=-2;    //n1+n2+n3+...+nn-2
		List<Double> ss=new ArrayList<Double>();
		List<Double> evg=new ArrayList<Double>();
		List<Integer> size=new ArrayList<Integer>();
		List<Double> T_=new ArrayList<Double>();
		
		
		for(int i=0;i<facmapsre.size();i++){
			 List<RecordVO> m_s=facmapsre.get(i);
			 List<RecordVO> m_e=facmapere.get(i);
			 if (m_s.size() <= 1 || m_e.size() <= 1) {
					throw new Exception("人数不足,无法分析!");
			 }
			 double s_st = getScroe(m_s) / m_s.size();// 分组男 参加活动前平均值
			 double s_et = getScroe(m_e) / m_s.size();// 分组男 参加活动后平均值
			 double s_difference = s_et - s_st;//增加值的平均值
			 double s1 = getq(m_e, s_difference, m_s.size());
			 size.add(facmapsre.size());
			 evg.add(s_difference);
			 ss.add((m_s.size()-1)*s1*s1);
		}
		while(ss.size()!=0){
			for(int i=0;i<ss.size()-1;i++){
				double evg1=evg.get(i)-evg.get(i-1);
				double ss_=ss.get(i)+ss.get(i+1);
				double nn_=size.get(i)+size.get(i+1)-2;
				double n_n_=1/(double)size.get(i)+1/(double)size.get(i+1);
				double t = evg1 / Math.sqrt(ss_/nn_*n_n_);
				T_.add(t);
			}
			ss.remove(0);
			evg.remove(0);
			size.remove(0);
		}
		
		return T_;
	}
	public List<Double> getMocaMap(Map<Integer, List<RecordMOVO>> facmapsre, Map<Integer, List<RecordMOVO>> facmapere,
			int call) throws Exception {
		List<Double> ss=new ArrayList<Double>();
		List<Double> evg=new ArrayList<Double>();
		List<Integer> size=new ArrayList<Integer>();
		List<Double> T_=new ArrayList<Double>();
				
		for(int i=0;i<facmapsre.size();i++){
			 List<RecordMOVO> m_s=facmapsre.get(i);
			 List<RecordMOVO> m_e=facmapere.get(i);
			 if (m_s.size() <= 1 || m_e.size() <= 1) {
					throw new Exception("人数不足,无法分析!");
			 }
			 double s_st = getEvgM(m_s, call) / m_s.size();// 分组男 参加活动前平均值
			 double s_et = getEvgM(m_e, call) / m_s.size();// 分组男 参加活动后前平均值
			 double s_difference = s_et - s_st;//增加值的平均值
			 double s1 = getEvgq(m_e, s_difference, m_s.size(), call);
			 size.add(facmapsre.size());
			 evg.add(s_difference);
			 ss.add((m_s.size()-1)*s1*s1);
		}
		while(ss.size()!=0){
			for(int i=0;i<ss.size()-1;i++){
				double evg1=evg.get(i)-evg.get(i-1);
				double ss_=ss.get(i)+ss.get(i+1);
				double nn_=size.get(i)+size.get(i+1)-2;
				double n_n_=1/(double)size.get(i)+1/(double)size.get(i+1);
				double t = evg1 / Math.sqrt(ss_/nn_*n_n_);
				T_.add(t);
			}
			ss.remove(0);
			evg.remove(0);
			size.remove(0);
		}

		return T_;
	}
	private void saveT_(Integer calibrations, double a, double t1, double t,int factor) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(t);
		m.setGroup1(group);
		m.setItemizeId(calibrations);
		m.setTestValue1(t1);// 双因素T检验
		m.setVerifyMode(0);
		m.setTwoFactor(factor);
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}
	private void save_sex(Integer calibrations, double a, double t1, double t) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(t);
		m.setGroup1(group);
		m.setItemizeId(calibrations);
		m.setTestValue1(t1);// 双因素T检验
		m.setVerifyMode(0);
		m.setTwoFactor(0);// 0性别
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}
	
	/**
	 * 
	 * @param category
	 * @param classification
	 * @throws Exception
	 */
	public void getListTSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		Map<Integer, List<RecordVO>> map = assessRecordDao.getUserIds(
				daParamVO, calibrations);
		List<RecordVO> sRe = null;
		if (map.get(0) != null) {
			sRe = map.get(0);
		}
		if (sRe == null || sRe.size() < 8) {
			throw new Exception("本次所选人数不足8人，无法进行评估");
		}
		List<RecordVO> eRe = map.get(1);
		this.ts = sRe;
		this.te = eRe;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();
		int userLength = sRe.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		List<RecordVO> sRe1 = sRe.subList(evg * (grouping - 1), evg * grouping);
		List<RecordVO> eRe1 = eRe.subList(evg * (grouping - 1), evg * grouping);
		double t1 = getMap(eRe1, sRe1);
		double t = getT(a, evg);
		save_sex(calibrations, a, t1, t);
	}
	
	public List<Double> getMocaMap(Map<Integer, List<FitnessVO1>> facmapsre, int calibrations)
			throws Exception {
		List<Double> ss=new ArrayList<Double>();
		List<Double> evg=new ArrayList<Double>();
		List<Integer> size=new ArrayList<Integer>();
		List<Double> T_=new ArrayList<Double>();
		 	for(int i=0;i<facmapsre.size();i++){
			 List<FitnessVO1> m_s=facmapsre.get(i);
			 if (m_s.size() <= 1 || m_s.size() <= 1) {
					throw new Exception("人数不足,无法分析!");
			 }
			 double s_st = getTsl(m_s, calibrations) / m_s.size();// 分组  参加活动前平均值
			 double s_et = assessUtil.getTsl(m_s, calibrations) / m_s.size();// 分组 活动后平均值
			
			 double s_difference = s_et - s_st;//增加值的平均值
			 double s1 = assessUtil.getTsls(m_s, s_difference, calibrations);
			 size.add(facmapsre.size());
			 evg.add(s_difference);
			 ss.add((m_s.size()-1)*s1*s1);
		} 
	 	while(ss.size()!=0){
		 		for(int i=0;i<ss.size()-1;i++){
		 			double evg1=evg.get(i)-evg.get(i-1);
		 			double ss_=ss.get(i)+ss.get(i+1);
		 			double nn_=size.get(i)+size.get(i+1)-2;
		 			double n_n_=1/(double)size.get(i)+1/(double)size.get(i+1);
		 			double t = evg1 / Math.sqrt(ss_/nn_*n_n_);
		 			T_.add(t);
		 		}
		 		ss.remove(0);
		 		evg.remove(0);
		 		size.remove(0);
		 	}

	 	return T_;
	}
	public List<Double> getMocaMapv2(Map<Integer, List<FitnessVO2>> facmapsre, int calibrations)
			throws Exception {
		List<Double> ss=new ArrayList<Double>();
		List<Double> evg=new ArrayList<Double>();
		List<Integer> size=new ArrayList<Integer>();
		List<Double> T_=new ArrayList<Double>();
		for(int i=0;i<facmapsre.size();i++){
			List<FitnessVO2> m_s=facmapsre.get(i);
			if (m_s.size() <= 1 || m_s.size() <= 1) {
				throw new Exception("人数不足,无法分析!");
			}
			double s_st = getTsl_(m_s, calibrations) / m_s.size();  // 分组  参加活动前平均值
			double s_et = assessUtil.getTsl_(m_s, calibrations) / m_s.size();// 分组 活动后平均值
			double s_difference = s_et - s_st;//增加值的平均值
			double s1 = assessUtil.getTslq_s(m_s, s_difference, calibrations);
			size.add(facmapsre.size());
			evg.add(s_difference);
			ss.add((m_s.size()-1)*s1*s1);
		} 
		while(ss.size()!=0){
			for(int i=0;i<ss.size()-1;i++){
				double evg1=evg.get(i)-evg.get(i-1);
				double ss_=ss.get(i)+ss.get(i+1);
				double nn_=size.get(i)+size.get(i+1)-2;
				double n_n_=1/(double)size.get(i)+1/(double)size.get(i+1);
				double t = evg1 / Math.sqrt(ss_/nn_*n_n_);
				T_.add(t);
			}
			ss.remove(0);
			evg.remove(0);
			size.remove(0);
		}

		return T_;
	}
	public List<Double> gettbpMap_(Map<Integer, List<MPressureVO>> facmapsre) throws Exception {
		List<Double> ss=new ArrayList<Double>();
		List<Double> evg=new ArrayList<Double>();
		List<Integer> size=new ArrayList<Integer>();
		List<Double> T_=new ArrayList<Double>();
		for (int i = 0; i < facmapsre.size(); i++) {
			List<MPressureVO> m_s=facmapsre.get(i);
			if (m_s.size() >= 1 || m_s.size() >= 1) {
				throw new Exception("人数不足,无法分析!");
			}
			double s_st = getMPressure(m_s) / m_s.size();// 分组男 参加活动前平均值
			double s_et = assessUtil.getMPressure(m_s) / m_s.size();// 分组男 参加活动前平均值
			double s_difference = s_et - s_st;
			double s1 = assessUtil.getMPressure(m_s, s_difference);
			size.add(facmapsre.size());
			evg.add(s_difference);
			ss.add((m_s.size()-1)*s1*s1);
		}
		while(ss.size()!=0){
			for(int i=0;i<ss.size()-1;i++){
				double evg1=evg.get(i)-evg.get(i-1);
				double ss_=ss.get(i)+ss.get(i+1);
				double nn_=size.get(i)+size.get(i+1)-2;
				double n_n_=1/(double)size.get(i)+1/(double)size.get(i+1);
				double t = evg1 / Math.sqrt(ss_/nn_*n_n_);
				T_.add(t);
			}
			ss.remove(0);
			evg.remove(0);
			size.remove(0);
		}
		return T_;
	}
	public Double getKF1_(Map<Integer, List<RecordVO>> sRe_,Map<Integer, List<RecordVO>> eRe_) {
		List<Integer> add=new ArrayList<Integer>();//分组增加的人数
		List<Integer> end=new ArrayList<Integer>();//分组无增加的人数
		List<Integer> sum=new ArrayList<Integer>();//分组总人数
		int sum_=0;//累计总人数
		int increaseAccumulation=0;//累计增加人数
		int nonTncreasing=0;//累计无增加人数
		for (int i = 0; i < sRe_.size(); i++) {
			 List<RecordVO> m1 = sRe_.get(i);
			 List<RecordVO> m2 = eRe_.get(i);
			int add_=0;
			int end_=0;
			 for(int j=0;j<m1.size();j++){
				if (getScore(m2.get(j)) - getScore(m1.get(j)) > 0) {
					add_ += 1;
				}else{
					end_+=1;
				}
			}
			 increaseAccumulation+=add_;
			 nonTncreasing+=end_;
			 add.add(add_);
			 end.add(end_);
			 int add__=add_+end_;
			 sum.add(add__);
			 sum_+=add__;
		}
		return getKF_(add, end, sum, sum_, increaseAccumulation,
				nonTncreasing);
	}
	private Double getKF_(List<Integer> add, List<Integer> end,
			List<Integer> sum, int sum_, int increaseAccumulation,
			int nonTncreasing) {
		double kf=0.0;//提高的总人数(组一+组二+...)*分组总人数（本组提高+未提高）/总人数==该分组期望提高值
		for(int i=0;i<add.size();i++){//没提高的总人数*分组总人数/总人数==没该分组期望提高值 	
			int a=sum.get(i)*increaseAccumulation/sum_;
			kf+=Math.pow(add.get(i) - a, 2) / a;
		}
		for(int i=0;i<end.size();i++){
			int a=sum.get(i)*nonTncreasing/sum_;
			kf+=Math.pow(end.get(i) - a, 2) / a;
		}
		return kf;
	}
	private void savek(Integer calibrations, double a, double kfL, double kf) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(kfL);
		m.setGroup1(group);
		m.setItemizeId(calibrations);
		m.setTestValue1(kf);// 卡方 独立性检验
		m.setVerifyMode(1);
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}
	public Double getKF1_(Map<Integer, List<RecordMOVO>> sRe_,Map<Integer, List<RecordMOVO>> eRe_,int call) {
		List<Integer> add=new ArrayList<Integer>();//分组增加的人数
		List<Integer> end=new ArrayList<Integer>();//分组无增加的人数
		List<Integer> sum=new ArrayList<Integer>();//分组总人数
		int sum_=0;//累计总人数
		int increaseAccumulation=0;//累计增加人数
		int nonTncreasing=0;//累计无增加人数
		for (int i = 0; i < sRe_.size(); i++) {
			List<RecordMOVO> m1 = sRe_.get(i);
			List<RecordMOVO> m2 = eRe_.get(i);
			int add_=0;
			int end_=0;
			for(int j=0;j<m1.size();j++){
				if (assessUtil.getMMSEMOCAONE(m2.get(j),call) - assessUtil.getMMSEMOCAONE(m1.get(j), call) > 0) {
					add_ += 1;
				}else{
					end_+=1;
				}
			}
			increaseAccumulation+=add_;
			nonTncreasing+=end_;
			add.add(add_);
			end.add(end_);
			int add__=add_+end_;
			sum.add(add__);
			sum_+=add__;
		}
		return getKF_(add, end, sum, sum_, increaseAccumulation,
				nonTncreasing);
	}
	
	public Double getKF5_(Map<Integer, List<MPressureVO>> facmapsrs,int call) {
		List<Integer> add=new ArrayList<Integer>();//分组增加的人数
		List<Integer> end=new ArrayList<Integer>();//分组无增加的人数
		List<Integer> sum=new ArrayList<Integer>();//分组总人数
		int sum_=0;//累计总人数
		int increaseAccumulation=0;//累计增加人数
		int nonTncreasing=0;//累计无增加人数
		for (int i = 0; i < facmapsrs.size(); i++) {
			List<MPressureVO> m1 = facmapsrs.get(i);
			int add_=0;
			int end_=0;
			for(int j=0;j<m1.size();j++){
				double s = assessUtil.getMPressure(m1.get(j).getHighPressures(),
						m1.get(j).getLowPressures());
				double e = assessUtil.getMPressure(m1.get(j).getHighPressuree(),
						m1.get(j).getLowPressuree());
				if ((e-s) > 0) {
					add_ += 1;
				}else{
					end_+=1;
				}
			}
			increaseAccumulation+=add_;
			nonTncreasing+=end_;
			add.add(add_);
			end.add(end_);
			int add__=add_+end_;
			sum.add(add__);
			sum_+=add__;
		}
		return getKF_(add, end, sum, sum_, increaseAccumulation,
				nonTncreasing);
	}
	
	/**
	 * 体适能双项 获取KF值
	 */
	public void KFTSLTSEX(DateParamVO daParamVO, Integer calibrations,
			int grouping, double a) throws Exception {
		// getTSN
		List<FitnessVO2> list = fitnessDao.list_(calibrations, daParamVO);
		if (list == null || list.size() < 8) {
			throw new Exception("体适能符合要求人数不足8人，无法测评！");
		}
		int userLength = list.size();// 本次评估总人数
		int evg = userLength / 4;// 每组的人数
		this.ts = list;
		this.te = null;
		this.group = grouping;
		this.itemizeid = calibrations;
		Thread thread = new Thread(this);
		thread.start();

		List<FitnessVO2> sRe_ = list.subList(evg * (grouping - 1), evg
				* grouping);
		double KF = getKF4(sRe_, calibrations);
		double kfL = KFL1(a,sRe_.size());
		savek(calibrations, a, kfL, KF);
	}
	
	public Double getKF1_(Map<Integer, List<FitnessVO1>> facmapsrs,int call) {
		List<Integer> add=new ArrayList<Integer>();//分组增加的人数
		List<Integer> end=new ArrayList<Integer>();//分组无增加的人数
		List<Integer> sum=new ArrayList<Integer>();//分组总人数
		int sum_=0;//累计总人数
		int increaseAccumulation=0;//累计增加人数
		int nonTncreasing=0;//累计无增加人数
		for (int i = 0; i < facmapsrs.size(); i++) {
			List<FitnessVO1> m1 = facmapsrs.get(i);
			int add_=0;
			int end_=0;
			for(int j=0;j<m1.size();j++){
				if ( assessUtil.getTSN(m1.get(j), call, m1.get(j).getResultE()) - assessUtil.getTSN(m1.get(j), call, m1.get(j).getResultS()) > 0) {
					add_ += 1;
				}else{
					end_+=1;
				}
			}
			increaseAccumulation+=add_;
			nonTncreasing+=end_;
			add.add(add_);
			end.add(end_);
			int add__=add_+end_;
			sum.add(add__);
			sum_+=add__;
		}
		return getKF_(add, end, sum, sum_, increaseAccumulation,
				nonTncreasing);
	}
	
	private void saveF(Integer calibrations, double a, List<FitnessVO2> eRe1,
			double SSt, double SSab, double SSa, double SSb) {
		int length=eRe1.size()*4-8;
		Double SSa_b = SSab - SSa - SSb;
		//Double SSe = SSt - SSab;
		double jun = SSa / 3 + SSb / 1 + SSa_b / 3; // 误差均方
		double fa = SSa / 3 / jun;
		double fb = SSb / 1 / jun;
		double fa_b = SSa_b / 3 / jun;
		double f_3 = 0;
		double f_1 = 0;
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		if (a == 0.05) {
			f_3 = FCriticalValue.F_005[length][2];
			f_1 = FCriticalValue.F_005[length][0];
		} else if (a == 0.1) {
			f_3 = FCriticalValue.F_010[length][2];
			f_1 = FCriticalValue.F_010[length][0];
		} else if (a == 0.01) {
			f_3 = FCriticalValue.F_001[length][2];
			f_1 = FCriticalValue.F_001[length][0];
		}
		saveF(calibrations, fa, fa_b, fb, fa_b, f_3, f_1);
	}
	public double FCtwo_factor_(Map<Integer, List<RecordVO>> facmapsrs, int call,double cords_) {
		double f_s=0.0;
		for( List<RecordVO> eRe:facmapsrs.values()){
			int	m  = getScroe(eRe);
			f_s+=eRe.size()*Math.pow(m / eRe.size() - cords_, 2);
		}
		return f_s;
	}
	private void savef(Integer calibrations, double a, List<RecordVO> eRe,
			int evg, double cords_, double cords_1, double cords_2,
			double cords_3, double cords_4, double SSt, double SSab, double SSb) {
		double SSa = Math.pow(cords_1 - cords_, 2) * evg
				+ Math.pow(cords_2 - cords_, 2) * evg
				+ Math.pow(cords_3 - cords_, 2) * evg
				+ Math.pow(cords_4 - cords_, 2) * evg;
	
		Double SSa_b = SSab - SSa - SSb;
		//Double SSe = SSt - SSab;
		double jun = SSa / 3 + SSb / 1 + SSa_b / 3; // 误差均方
		double fa = SSa / 3 / jun;
		double fb = SSb / 1 / jun;
		double fa_b = SSa_b / 3 / jun;
		double f_3 = 0;
		double f_1 = 0;
		int length=eRe.size()*4-8;
		if(length<0){
			length=0;
		}
		if(length>33){
			length=33;
		}
		if (a == 0.05) {
			f_3 = FCriticalValue.F_005[length][2];
			f_1 = FCriticalValue.F_005[length][0];
		} else if (a == 0.1) {
			f_3 = FCriticalValue.F_010[length][2];
			f_1 = FCriticalValue.F_010[length][0];
		} else if (a == 0.01) {
			f_3 = FCriticalValue.F_001[length][2];
			f_1 = FCriticalValue.F_001[length][0];
		}
		saveF(calibrations, fa, fa_b, fb, fa_b, f_3, f_1);
	}

	private void saveF(Integer calibrations, double a, double fa, double fb,
			Double fa_b, Double f_3, double f_1) {
		MVenderIntervene m = new MVenderIntervene();
		m.setAValue(a);
		m.setCreatedAt(new Date());
		m.setCriticalValue1(f_3);
		m.setCriticalValue2(f_1);
		m.setItemizeId(calibrations);
		m.setTestValue1(fa);//F值单因素方差分析
		m.setTestValue2(fb);
		m.setTestValue3(fa_b);
		m.setTwoFactor(0);// 0性别
		m.setVerifyMode(2);
		m.setCreatedBy("cm");
		mVenderInterveneDao.save(m);
	}
		//双因素为年龄
	private Map<Integer, List<RecordVO>> getaged1marry(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:marry){
			
			for(RecordVO v:vos){
				int marry=rUserDao.findById(v.getUserId()).getMarry();
				 List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}		
	private Map<Integer, List<RecordVO>> getaged1education(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:education){
			
			for(RecordVO v:vos){
				int marry=rUserDao.findById(v.getUserId()).getEducation();
				List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}		
	private Map<Integer, List<RecordVO>> getaged1religion(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:religion){
			
			for(RecordVO v:vos){
				int marry=rUserDao.findById(v.getUserId()).getReligion();
				List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}		
	private Map<Integer, List<RecordVO>> getaged1jobCond(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:jobCond){
			
			for(RecordVO v:vos){
				int marry=rUserDao.findById(v.getUserId()).getJobCond();
				List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}		
	private Map<Integer, List<RecordVO>> getaged1income(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:income){
			
			for(RecordVO v:vos){
				int marry=rUserDao.findById(v.getUserId()).getIncome();
				List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}		
	private Map<Integer, List<RecordVO>> getaged1disable(int ageds, List<RecordVO> vos,
			Map<Integer, List<RecordVO>> maps, int facLeng) {
		for(int i:disable){
			
			for(RecordVO v:vos){
				int marry=0;
				RUser r=rUserDao.findById(v.getUserId());
				if(r.getSpecia()!=null&&r.getSpecia().getDisable()!=null){
					marry=rUserDao.findById(v.getUserId()).getSpecia().getDisable();
				}
				List<RecordVO> vo=null;
				if(i==marry){
					if(maps.get(facLeng)==null){
						vo=new ArrayList<RecordVO>();
					}else{
						vo=maps.get(facLeng);
					}
					vo.add(v);
					maps.put(facLeng, vo);
				}
			}
		}
		return maps;
	}
	private Map<Integer, List<RecordVO>> getaged1(int ageds, List<RecordVO> vos,
					Map<Integer, List<RecordVO>> maps, int facLeng) {
				for(int i=30;i<=100;i+=ageds){
					int j=i+ageds;
					for(RecordVO v:vos){
						int age=0;
						if(rUserDao.findById(v.getUserId())!=null&&rUserDao.findById(v.getUserId())!=null){
							age=rUserDao.findById(v.getUserId()).getAge();
						}else{
							continue;
						}
						 List<RecordVO> vo=null;
						if(age>i&&age<=j){
							if(maps.get(facLeng)==null){
								vo=new ArrayList<RecordVO>();
							}else{
								vo=maps.get(facLeng);
							}
							vo.add(v);
							maps.put(facLeng, vo);
						}
					}
				}
				return maps;
			}
			
			private Map<Integer, List<RecordMOVO>> getaged2(int ageds, List<RecordMOVO> vos,
					Map<Integer, List<RecordMOVO>> maps, int facLeng) {
				for(int i=30;i<=100;i+=ageds){
					int j=i+ageds;
					for(RecordMOVO v:vos){
						int age=0;
						if(rUserDao.findById(v.getUserId())!=null&&rUserDao.findById(v.getUserId())!=null){
							age=rUserDao.findById(v.getUserId()).getAge();
						}else{
							continue;
						}
						List<RecordMOVO> vo=null;
						if(age>i&&age<=j){
							if(maps.get(facLeng)==null){
								vo=new ArrayList<RecordMOVO>();
							}else{
								vo=maps.get(facLeng);
							}
							vo.add(v);
							maps.put(facLeng, vo);
						}
					}
				}
				return maps;
			}
		private Map<Integer, List<FitnessVO1>> getaged3(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i=30;i<=100;i+=ageds){
				int j=i+ageds;
				for(FitnessVO1 v:vos){
					int age=0;
					if(rUserDao.findById(v.getUserId())!=null&&rUserDao.findById(v.getUserId())!=null){
						age=rUserDao.findById(v.getUserId()).getAge();
					}else{
						continue;
					}
					List<FitnessVO1> vo=null;
					if(age>i&&age<=j){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}
		
		private Map<Integer, List<MPressureVO>> getaged5(int ageds, List<MPressureVO> vos,
			Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i=30;i<=100;i+=ageds){
				int j=i+ageds;
				for(MPressureVO v:vos){
					int age=0;
					if(rUserDao.findById(v.getUserId())!=null&&rUserDao.findById(v.getUserId())!=null){
						age=rUserDao.findById(v.getUserId()).getAge();
					}else{
						continue;
					}
					List<MPressureVO> vo=null;
					if(age>i&&age<=j){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}

			return maps;
		}
		private Map<Integer, List<FitnessVO2>> getaged4(int ageds, List<FitnessVO2> vos,
			Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i=30;i<=100;i+=ageds){
				int j=i+ageds;
				for(FitnessVO2 v:vos){
					int age=0;
					if(rUserDao.findById(v.getUserId())!=null&&rUserDao.findById(v.getUserId())!=null){
						age=rUserDao.findById(v.getUserId()).getAge();
					}else{
						continue;
					}
					List<FitnessVO2> vo=null;
					if(age>i&&age<=j){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}

			return maps;
		} 
		
		private Map<Integer, List<RecordMOVO>> getaged2marry(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:marry){
				
				for(RecordMOVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getMarry();
					 List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<RecordMOVO>> getaged2education(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:education){
				//int j=i+ageds;
				for(RecordMOVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getEducation();
					List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<RecordMOVO>> getaged2religion(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:religion){
				//int j=i+ageds;
				for(RecordMOVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getReligion();
					List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<RecordMOVO>> getaged2jobCond(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:jobCond){
				
				for(RecordMOVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getJobCond();
					List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<RecordMOVO>> getaged2income(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:income){
				//int j=i+ageds;
				for(RecordMOVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getIncome();
					List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<RecordMOVO>> getaged2disable(int ageds, List<RecordMOVO> vos,
				Map<Integer, List<RecordMOVO>> maps, int facLeng) {
			for(int i:disable){
				
				for(RecordMOVO v:vos){
					int marry=0;
					RUser r=rUserDao.findById(v.getUserId());
					if(r.getSpecia()!=null&&r.getSpecia().getDisable()!=null){
						marry=rUserDao.findById(v.getUserId()).getSpecia().getDisable();
					}
					List<RecordMOVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<RecordMOVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}
		private Map<Integer, List<FitnessVO1>> getaged3marry(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:marry){
				//int j=i+ageds;
				for(FitnessVO1 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getMarry();
					 List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO1>> getaged3education(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:education){
				//int j=i+ageds;
				for(FitnessVO1 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getEducation();
					List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO1>> getaged3religion(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:religion){
				//int j=i+ageds;
				for(FitnessVO1 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getReligion();
					List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO1>> getaged3jobCond(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:jobCond){
				
				for(FitnessVO1 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getJobCond();
					List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO1>> getaged3income(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:income){
				
				for(FitnessVO1 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getIncome();
					List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO1>> getaged3disable(int ageds, List<FitnessVO1> vos,
				Map<Integer, List<FitnessVO1>> maps, int facLeng) {
			for(int i:disable){
				////int j=i+ageds;
				for(FitnessVO1 v:vos){
					int marry=0;
					RUser r=rUserDao.findById(v.getUserId());
					if(r.getSpecia()!=null&&r.getSpecia().getDisable()!=null){
						marry=rUserDao.findById(v.getUserId()).getSpecia().getDisable();
					}
					List<FitnessVO1> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO1>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}
		private Map<Integer, List<FitnessVO2>> getaged4marry(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:marry){
				////int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getMarry();
					 List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO2>> getaged4education(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:education){
				////int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getEducation();
					List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO2>> getaged4religion(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:religion){
				//int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getReligion();
					List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO2>> getaged4jobCond(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:jobCond){
				//int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getJobCond();
					List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO2>> getaged4income(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:income){
				//int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=rUserDao.findById(v.getUserId()).getIncome();
					List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<FitnessVO2>> getaged4disable(int ageds, List<FitnessVO2> vos,
				Map<Integer, List<FitnessVO2>> maps, int facLeng) {
			for(int i:disable){
				//int j=i+ageds;
				for(FitnessVO2 v:vos){
					int marry=0;
					RUser r=rUserDao.findById(v.getUserId());
					if(r.getSpecia()!=null&&r.getSpecia().getDisable()!=null){
						marry=rUserDao.findById(v.getUserId()).getSpecia().getDisable();
					}
					List<FitnessVO2> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<FitnessVO2>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}
		
		private Map<Integer, List<MPressureVO>> getaged5marry(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:marry){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getMarry();
					 List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<MPressureVO>> getaged5education(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:education){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getEducation();
					List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<MPressureVO>> getaged5religion(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:religion){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getReligion();
					List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<MPressureVO>> getaged5jobCond(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:jobCond){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getJobCond();
					List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<MPressureVO>> getaged5income(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:income){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=rUserDao.findById(v.getUserId()).getIncome();
					List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}		
		private Map<Integer, List<MPressureVO>> getaged5disable(int ageds, List<MPressureVO> vos,
				Map<Integer, List<MPressureVO>> maps, int facLeng) {
			for(int i:disable){
				//int j=i+ageds;
				for(MPressureVO v:vos){
					int marry=0;
					RUser r=rUserDao.findById(v.getUserId());
					if(r.getSpecia()!=null&&r.getSpecia().getDisable()!=null){
						marry=rUserDao.findById(v.getUserId()).getSpecia().getDisable();
					}
					List<MPressureVO> vo=null;
					if(i==marry){
						if(maps.get(facLeng)==null){
							vo=new ArrayList<MPressureVO>();
						}else{
							vo=maps.get(facLeng);
						}
						vo.add(v);
						maps.put(facLeng, vo);
					}
				}
			}
			return maps;
		}
}