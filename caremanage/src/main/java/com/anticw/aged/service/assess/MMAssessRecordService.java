package com.anticw.aged.service.assess;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.anticw.aged.bean.MAnalysisStudy;
import com.anticw.aged.bean.MAssessFitness;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.MAnalysisStudystants;
import com.anticw.aged.dao.assess.MAnalysisStudyDao;
import com.anticw.aged.dao.professional.assess.AssessRecordDao;
import com.anticw.aged.dao.professional.fitness.FitnessDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.vo.professional.assess.Analyperson;
import com.anticw.aged.vo.professional.assess.AnalysisStudyVO;
import com.anticw.aged.vo.professional.assess.EvaluatedPrivatelyVO;
import com.anticw.aged.vo.professional.assess.FitnseeVO;
import com.anticw.aged.vo.professional.vender.MyBeanWithPerson;
import com.anticw.aged.vo.professional.vender.QuestionVO;

@Service
@Component
public class MMAssessRecordService {

	@Autowired
	private AssessRecordDao assessRecordDao;

	@Autowired
	private FitnessDao fitnessDao;

	@Autowired
	private MAnalysisStudyDao mAnalysisStudyDao;
	/**
	 * 老人基本信息
	 */
	@Autowired
	private RUserService rUserService;

	public List<MAnalysisStudy> getList() {
		return mAnalysisStudyDao.getList();
	}

	@SuppressWarnings("unchecked")
	public void assessExcel(WritableWorkbook workbook, List<MAnalysisStudy> list) throws Exception {
		// 首先先查看量表类型 组合体 分数提 开站评估
		WritableSheet sheet = workbook.createSheet("综合分析", 0);
		int column = 0;
		Label label0 = new Label(column, 0, "序号");
		sheet.addCell(label0);
		column++;
		Label label1 = new Label(column, 0, "用户Id");
		sheet.addCell(label1);
		column++;
		Label label2 = new Label(column, 0, "姓名");
		sheet.addCell(label2);
		column++;
		Label label3 = new Label(column, 0, "性别");
		sheet.addCell(label3);
		column++;
		Label label4 = new Label(column, 0, "年龄");
		sheet.addCell(label4);
		column++;
		Label label5 = new Label(column, 0, "社区");
		sheet.addCell(label5);
		column++;
		Label label6 = new Label(column, 0, "社区");
		sheet.addCell(label6);
		column++;
		Label label7 = new Label(column, 0, "社区");
		sheet.addCell(label7);
		column++;
		Label label8 = new Label(column, 0, "社区");
		sheet.addCell(label8);
		column++;
		Label label9 = new Label(column, 0, "社区");
		sheet.addCell(label9);
		column++;
		Label label10 = new Label(column, 0, "社区");
		sheet.addCell(label10);
		column++;
		Label label11 = new Label(column, 0, "社区");
		sheet.addCell(label11);
		column++;
		Label label12 = new Label(column, 0, "社区");
		sheet.addCell(label12);
		column++;
		Label label13 = new Label(column, 0, "社区");
		sheet.addCell(label13);
		column++;
		Label label14 = new Label(column, 0, "社区");
		sheet.addCell(label14);
		column++;
		Label label15 = new Label(column, 0, "社区");
		sheet.addCell(label15);
		column++;
		Label label16 = new Label(column, 0, "社区");
		sheet.addCell(label16);
		column++;
		Label label17 = new Label(column, 0, "社区");
		sheet.addCell(label17);
		column++;
		Label label18 = new Label(column, 0, "社区");
		sheet.addCell(label18);
		column++;
		Label label19 = new Label(column, 0, "社区");
		sheet.addCell(label19);
		column++;
		Label label20 = new Label(column, 0, "社区");
		sheet.addCell(label20);
		column++;
		Label label21 = new Label(column, 0, "社区");
		sheet.addCell(label21);
		column++;

		int row = 1;
		for (int j = 0; j < list.size(); j++) {
			int col = 0;
			MAnalysisStudy li = list.get(j);
			Map<String, String> e12 = BeanUtils.describe(li);
			for (String k : e12.keySet()) {
				if ("id".equals(k) || "class".equals(k) || "userId".equals(k) || "start".equals(k) || "end".equals(k)
						|| "createdAt".equals(k) || "createdBy".equals(k) || "grouping".equals(k)
						|| "calculatingType".equals(k) || "userSex".equals(k)) {
					continue;
				}
				sheet.addCell(new Label(col, row, e12.get(k)));
				col++;
			}
			row++;
		}

	}

	@SuppressWarnings("unused")
	private static void handleException(Exception e) {
		String msg = null;
		if (e instanceof InvocationTargetException) {
			Throwable targetEx = ((InvocationTargetException) e).getTargetException();
			if (targetEx != null) {
				msg = targetEx.getMessage();
			}
		} else {
			msg = e.getMessage();
		}
	}

	/**
	 * 将map装换为javabean对象
	 * 
	 * @param map
	 * @param bean
	 * @return
	 */
	public static <T> T mapToBean(Map<String, Object> map, T bean) {
		BeanMap beanMap = BeanMap.create(bean);
		beanMap.putAll(map);
		return bean;
	}

	/**
	 * 将List<Map<String,Object>>转换为List<T>
	 * 
	 * @param maps
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz)
			throws InstantiationException, IllegalAccessException {
		List<T> list = new ArrayList();
		if (maps != null && maps.size() > 0) {
			Map<String, Object> map = null;
			T bean = null;
			for (int i = 0, size = maps.size(); i < size; i++) {
				map = maps.get(i);
				bean = clazz.newInstance();
				mapToBean(map, bean);
				list.add(bean);
			}
		}
		return list;
	}

	/**
	 * 根据两个时间获取本月内评估六大量表的所有用户
	 * 
	 * @param sDate
	 * @param eDate
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void sum(Date sDate, Date eDate)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		List<MAnalysisStudy> list = new ArrayList<MAnalysisStudy>();

		List<Long> ids1 = assessRecordDao.getUserIds(sDate);
		Set<Long> set1 = new HashSet<Long>(ids1);
		List<Long> ids2 = assessRecordDao.getUserIds(eDate);
		Set<Long> set2 = new HashSet<Long>();
		set2.addAll(ids2);// 给set填充
		set1.retainAll(set2);
		int num = set1.size();
		int evg = num / 4;// 每组的人数
		if (evg == 0) {
			throw new RuntimeException("分析发现每组人数不足一人，无法进行");
		}

		Object[] o = set1.toArray();
		Object[] o1 = Arrays.copyOfRange(o, 0, evg);
		Object[] o2 = Arrays.copyOfRange(o, evg, evg * 2);
		Object[] o3 = Arrays.copyOfRange(o, evg * 2, evg * 3);
		Object[] o4 = Arrays.copyOfRange(o, evg * 3, evg * 4);
		Object[] o5 = Arrays.copyOfRange(o, 0, evg * 4);

		String mindIds = StringUtils.join(o1, ",");// 头脑体操干预组
		String fitnessIds = StringUtils.join(o2, ",");// 体适能训练干预组
		String mixtureIds = StringUtils.join(o3, ",");// 混合组
		String contrastIds = StringUtils.join(o4, ",");// 对照组
		String quan = StringUtils.join(o5, ",");// 对照组

		// --------------------------获取量表干预前----------------------------------
		List<EvaluatedPrivatelyVO> quanqian = assessRecordDao.getListMAssessRecordDetail(quan, sDate);
		List<MAssessFitness> massessFitnessqian = fitnessDao.list(quan, sDate);
		//List<EvaluatedPrivatelyVO> quanhou = assessRecordDao.getListMAssessRecordDetail(quan, eDate);
		//List<MAssessFitness> massessFitnesshou = fitnessDao.list(quan, eDate);
		AnalysisStudyVO an = getAnalysisStudyVO(quanqian, massessFitnessqian);// 干预前
		MAnalysisStudy an1 = new MAnalysisStudy();
		BeanUtils.copyProperties(an1, an);
		an1.setGrouping(MAnalysisStudystants.UNIFORMIZATION);// 归一化需要再次分析
		an1.setCalculatingType(MAnalysisStudystants.Z_COUNT);
		an1.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(an1);
		// --------------------------获取每一组对应的量表
		// 干预后----------------------------------
		List<EvaluatedPrivatelyVO> mindhou = assessRecordDao.getListMAssessRecordDetail(mindIds, eDate);
		List<EvaluatedPrivatelyVO> fitnesshou = assessRecordDao.getListMAssessRecordDetail(fitnessIds, eDate);
		List<EvaluatedPrivatelyVO> mixturehou = assessRecordDao.getListMAssessRecordDetail(mixtureIds, eDate);
		List<EvaluatedPrivatelyVO> contrasthou = assessRecordDao.getListMAssessRecordDetail(contrastIds, eDate);
		// 干预前----------------------------------
		List<EvaluatedPrivatelyVO> minds = assessRecordDao.getListMAssessRecordDetail(mindIds, sDate);
		List<EvaluatedPrivatelyVO> fitness = assessRecordDao.getListMAssessRecordDetail(fitnessIds, sDate);
		List<EvaluatedPrivatelyVO> mixtures = assessRecordDao.getListMAssessRecordDetail(mixtureIds, sDate);
		List<EvaluatedPrivatelyVO> contrasts = assessRecordDao.getListMAssessRecordDetail(contrastIds, sDate);

		List<MAssessFitness> mindtiqian = fitnessDao.list(mindIds, sDate);
		List<MAssessFitness> fitnesstiqian = fitnessDao.list(mindIds, sDate);
		List<MAssessFitness> mixturetiqian = fitnessDao.list(mindIds, sDate);
		List<MAssessFitness> contrasttiqian = fitnessDao.list(contrastIds, sDate);

		List<MAssessFitness> mindtihou = fitnessDao.list(mindIds, eDate);
		List<MAssessFitness> fitnesstihou = fitnessDao.list(mindIds, eDate);
		List<MAssessFitness> mixturetihou = fitnessDao.list(mindIds, eDate);
		List<MAssessFitness> contrasttihou = fitnessDao.list(contrastIds, eDate);

		AnalysisStudyVO anmindhou = getAnalysisStudyVO(mindhou, mindtihou);// 干预后
																			// MMSE/MoCA
																			// 认知功能
																			// 平均差
		AnalysisStudyVO anfitnessIds = getAnalysisStudyVO(fitnesshou, fitnesstihou);// 干预后
																					// 体适能
																					// 平均差
		AnalysisStudyVO anmixturetihou = getAnalysisStudyVO(mixturehou, mixturetihou);// 干预后
																						// 心理素质
																						// 平均差
		AnalysisStudyVO ancontrasttihou = getAnalysisStudyVO(contrasthou, contrasttihou);// 对比组
																							// 平均差

		// 方差验算------------------------------------------------
		// 全部观察值的总均值
		AnalysisStudyVO x_ = xevg(anmindhou, anfitnessIds, anmixturetihou, ancontrasttihou, massessFitnessqian.size(),
				mindtihou.size());
		List<AnalysisStudyVO> v1 = getlist(mindhou, mindtihou);
		List<AnalysisStudyVO> v2 = getlist(fitnesshou, fitnesstihou);
		List<AnalysisStudyVO> v3 = getlist(mixturehou, mixturetihou);
		List<AnalysisStudyVO> v4 = getlist(contrasthou, contrasttihou);

		AnalysisStudyVO SST = sst(v1, v2, v3, v4, x_);
		AnalysisStudyVO SSE = sse(v1, v2, v3, v4, anmindhou, anfitnessIds, anmixturetihou, ancontrasttihou);

		Map<String, Map<String, Object>> map = ssa(SST, SSE);

		// AnalysisStudyVO SSA=
		// mapToBean(map.get("SSA"),AnalysisStudyVO.class.newInstance());
		AnalysisStudyVO MSA = mapToBean(map.get("MSA"), AnalysisStudyVO.class.newInstance());
		AnalysisStudyVO MSE = mse(SST, SSE, massessFitnessqian.size());
		AnalysisStudyVO F = f(MSA, MSE);
		MAnalysisStudy F1 = new MAnalysisStudy();
		BeanUtils.copyProperties(F1, F);
		F1.setGrouping(MAnalysisStudystants.F_SINGLE_FACTOR);// 归一化需要再次分析
		F1.setCalculatingType(MAnalysisStudystants.Z_COUNT);
		F1.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(F1);
		// 未知 要不要
		// AnalysisStudyVO SXX=SXX(MSE, mindtihou.size());
		// F值-------------------------------------------------------------------------
		// Set<AnalysisStudyVO> xij1= manAndWM_(mindhou, mindtihou);//分组平均值 认知功能
		// ｛男女分开｝
		// Set<AnalysisStudyVO> xij2=manAndWM_(contrasthou,
		// contrasttihou);//分组平均值 体适能 ｛男女分开｝
		// Set<AnalysisStudyVO> xij3=manAndWM_(mixturehou, mixturetihou);//分组平均值
		// 心理素质 ｛男女分开｝
		// Set<AnalysisStudyVO> xij4=manAndWM_(fitnesshou, fitnesstihou);//分组平均值
		// 平均差 ｛男女分开｝

		// Set<AnalysisStudyVO> xi=manAndWM_(quanhou,
		// massessFitnesshou);//总体的平均值 ｛男女分开｝
		// AnalysisStudyVO C_x=getAnalysisStudyVO(quanhou,
		// massessFitnesshou);//干预后平均值
		// AnalysisStudyVO C=getC(quanhou, massessFitnesshou);//矫正数
		// List<AnalysisStudyVO> users=getlistUsers(quanhou, massessFitnesshou);

		// AnalysisStudyVO SSt=SST(users, C);

		// -------------------------------------------总体T检验
		AnalysisStudyVO biaoCha1 = getEcartType(anmindhou, mindhou, mindtihou);// MMSE/MoCA
		AnalysisStudyVO biaoCha2 = getEcartType(anfitnessIds, fitnesshou, fitnesstihou);// 体适能
		AnalysisStudyVO biaoCha3 = getEcartType(anmixturetihou, mixturehou, mixturetihou);// 心理素质
		AnalysisStudyVO biaoCha4 = getEcartType(ancontrasttihou, contrasthou, contrasttihou);// 对比组
		MAnalysisStudy biaoCha11 = new MAnalysisStudy();
		BeanUtils.copyProperties(biaoCha11, biaoCha1);
		biaoCha11.setGrouping(MAnalysisStudystants.T_INDEPENDENT);
		biaoCha11.setCalculatingType(MAnalysisStudystants.Z_PERCEIVE);
		biaoCha11.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(biaoCha11);
		MAnalysisStudy biaoCha21 = new MAnalysisStudy();
		BeanUtils.copyProperties(biaoCha21, biaoCha2);
		biaoCha21.setGrouping(MAnalysisStudystants.T_INDEPENDENT);
		biaoCha21.setCalculatingType(MAnalysisStudystants.Z_PHYSICAL_FITNESS);
		biaoCha21.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(biaoCha21);
		MAnalysisStudy biaoCha31 = new MAnalysisStudy();
		BeanUtils.copyProperties(biaoCha31, biaoCha3);
		biaoCha31.setGrouping(MAnalysisStudystants.T_INDEPENDENT);
		biaoCha31.setCalculatingType(MAnalysisStudystants.Z_PSYCHOLOGICAL_QUALITY);
		biaoCha31.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(biaoCha31);
		MAnalysisStudy biaoCha41 = new MAnalysisStudy();
		BeanUtils.copyProperties(biaoCha41, biaoCha4);
		biaoCha41.setGrouping(MAnalysisStudystants.T_MONOMER);
		biaoCha41.setCalculatingType(MAnalysisStudystants.Z_CONTRAST);
		biaoCha41.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(biaoCha41);

		// -------------------------------------------单体T检验
		AnalysisStudyVO s1 = getAnalysisStudyVO(minds, mindtiqian);// 干预前
		AnalysisStudyVO s2 = getAnalysisStudyVO(fitness, fitnesstiqian);// 干预前
		AnalysisStudyVO s3 = getAnalysisStudyVO(mixtures, mixturetiqian);// 干预前
		AnalysisStudyVO s4 = getAnalysisStudyVO(contrasts, contrasttiqian);// 干预前

		AnalysisStudyVO evgD1 = getEVG(anmindhou, s1);// 代表对应前后两组数据之差的平均值
		AnalysisStudyVO vmdS1 = getAnSSVOEVG(mindhou, minds, mindtiqian, mindtihou);// 单体T检验标准差
		double n1 = Math.sqrt(minds.size());

		AnalysisStudyVO evgD2 = getEVG(anfitnessIds, s2);// 代表对应前后两组数据之差的平均值
		AnalysisStudyVO vmdS2 = getAnSSVOEVG(mindhou, minds, mindtiqian, mindtihou);// 单体T检验标准差
		double n2 = Math.sqrt(minds.size());

		AnalysisStudyVO evgD3 = getEVG(anmixturetihou, s3);// 代表对应前后两组数据之差的平均值
		AnalysisStudyVO vmdS3 = getAnSSVOEVG(mindhou, minds, mindtiqian, mindtihou);// 单体T检验标准差
		double n3 = Math.sqrt(minds.size());

		AnalysisStudyVO evgD4 = getEVG(anmixturetihou, s4);// 代表对应前后两组数据之差的平均值
		AnalysisStudyVO vmdS4 = getAnSSVOEVG(mindhou, minds, mindtiqian, mindtihou);// 单体T检验标准差
		double n4 = Math.sqrt(minds.size());

		AnalysisStudyVO TD1 = getTD(evgD1, vmdS1, n1);

		AnalysisStudyVO TD2 = getTD(evgD2, vmdS2, n2);
		AnalysisStudyVO TD3 = getTD(evgD3, vmdS3, n3);
		AnalysisStudyVO TD4 = getTD(evgD4, vmdS4, n4);
		MAnalysisStudy TD11 = new MAnalysisStudy();
		BeanUtils.copyProperties(TD11, TD1);
		MAnalysisStudy TD21 = new MAnalysisStudy();
		BeanUtils.copyProperties(TD21, TD2);
		MAnalysisStudy TD31 = new MAnalysisStudy();
		BeanUtils.copyProperties(TD31, TD3);
		MAnalysisStudy TD41 = new MAnalysisStudy();
		BeanUtils.copyProperties(TD41, TD4);
		TD11.setGrouping(MAnalysisStudystants.T_MONOMER);
		TD11.setCalculatingType(MAnalysisStudystants.Z_PERCEIVE);
		TD11.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(TD11);
		TD21.setGrouping(MAnalysisStudystants.T_MONOMER);
		TD21.setCalculatingType(MAnalysisStudystants.Z_PHYSICAL_FITNESS);
		TD21.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(TD21);
		TD31.setGrouping(MAnalysisStudystants.T_MONOMER);
		TD31.setCalculatingType(MAnalysisStudystants.Z_PSYCHOLOGICAL_QUALITY);
		TD31.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(TD31);
		TD41.setGrouping(MAnalysisStudystants.T_MONOMER);
		TD41.setCalculatingType(MAnalysisStudystants.Z_CONTRAST);
		TD41.setUserSex(MAnalysisStudystants.USER_SEX);
		list.add(TD41);
		// 测试同样的服务对不同的特征群体产生效用的差异 按照性别
		AnalysisStudyVO Tsex1 = manAndWM(minds, mindtiqian, mindhou, mindtihou);
		AnalysisStudyVO Tsex2 = manAndWM(fitness, fitnesstiqian, fitnesshou, fitnesstihou);
		AnalysisStudyVO Tsex3 = manAndWM(mixtures, mixturetiqian, mixturehou, mixturetihou);
		AnalysisStudyVO Tsex4 = manAndWM(contrasts, contrasttiqian, contrasthou, contrasttihou);
		MAnalysisStudy Tsex11 = new MAnalysisStudy();
		BeanUtils.copyProperties(Tsex11, Tsex1);
		MAnalysisStudy Tsex21 = new MAnalysisStudy();
		BeanUtils.copyProperties(Tsex21, Tsex2);
		MAnalysisStudy Tsex31 = new MAnalysisStudy();
		BeanUtils.copyProperties(Tsex31, Tsex3);
		MAnalysisStudy Tsex41 = new MAnalysisStudy();
		BeanUtils.copyProperties(Tsex41, Tsex4);
		Tsex11.setGrouping(MAnalysisStudystants.T_MONOMER);
		Tsex11.setCalculatingType(MAnalysisStudystants.Z_PERCEIVE);
		Tsex11.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Tsex11);
		Tsex21.setGrouping(MAnalysisStudystants.T_MONOMER);
		Tsex21.setCalculatingType(MAnalysisStudystants.Z_PHYSICAL_FITNESS);
		Tsex21.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Tsex21);
		Tsex31.setGrouping(MAnalysisStudystants.T_MONOMER);
		Tsex31.setCalculatingType(MAnalysisStudystants.Z_PSYCHOLOGICAL_QUALITY);
		Tsex31.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Tsex31);
		Tsex41.setGrouping(MAnalysisStudystants.T_MONOMER);
		Tsex41.setCalculatingType(MAnalysisStudystants.Z_CONTRAST);
		Tsex41.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Tsex41);
		// ------------------卡方检验----------------------------------------------
		AnalysisStudyVO Ksex1 = mK(minds, mindtiqian, mindhou, mindtihou);
		AnalysisStudyVO Ksex2 = mK(fitness, fitnesstiqian, fitnesshou, fitnesstihou);
		AnalysisStudyVO Ksex3 = mK(mixtures, mixturetiqian, mixturehou, mixturetihou);
		AnalysisStudyVO Ksex4 = mK(contrasts, contrasttiqian, contrasthou, contrasttihou);
		MAnalysisStudy Ksex11 = new MAnalysisStudy();
		BeanUtils.copyProperties(Ksex11, Ksex1);
		MAnalysisStudy Ksex21 = new MAnalysisStudy();
		BeanUtils.copyProperties(Ksex21, Ksex2);
		MAnalysisStudy Ksex31 = new MAnalysisStudy();
		BeanUtils.copyProperties(Ksex31, Ksex3);
		MAnalysisStudy Ksex41 = new MAnalysisStudy();
		BeanUtils.copyProperties(Ksex41, Ksex4);
		Ksex11.setGrouping(MAnalysisStudystants.K_INDEPENDENT);
		Ksex11.setCalculatingType(MAnalysisStudystants.Z_PERCEIVE);
		Ksex11.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Ksex11);
		Ksex21.setGrouping(MAnalysisStudystants.K_INDEPENDENT);
		Ksex21.setCalculatingType(MAnalysisStudystants.Z_PHYSICAL_FITNESS);
		Ksex21.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Ksex21);
		Ksex31.setGrouping(MAnalysisStudystants.K_INDEPENDENT);
		Ksex31.setCalculatingType(MAnalysisStudystants.Z_PSYCHOLOGICAL_QUALITY);
		Ksex31.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Ksex31);
		Ksex41.setGrouping(MAnalysisStudystants.K_INDEPENDENT);
		Ksex41.setCalculatingType(MAnalysisStudystants.Z_CONTRAST);
		Ksex41.setUserSex(MAnalysisStudystants._USERSEX);
		list.add(Ksex41);
		Date da = new Date();
		@SuppressWarnings("unused")
		int i = 1;
		for (MAnalysisStudy m : list) {
			m.setXueya(0.0);
			mAnalysisStudyDao.select(m, sDate, eDate, da);
			i++;
		}
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private AnalysisStudyVO SST(List<AnalysisStudyVO> v1, AnalysisStudyVO C)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		Map<String, String> m2 = BeanUtils.describe(C);
		Map<String, Object> Tchecking = new HashMap<String, Object>();
		for (int i = 0; i < v1.size(); i++) {
			Map<String, String> m1 = BeanUtils.describe(v1.get(i));
			for (String o : m1.keySet()) {
				if ("class".equals(o)) {
					TcheckingZ.put(o, m1.get(o));
					continue;
				}
				if (TcheckingZ.get(o) == null) {
					TcheckingZ.put(o, Math.pow(Double.valueOf(m1.get(o)), 2));
				} else {
					TcheckingZ.put(o,
							Math.pow((Double.valueOf(m1.get(o)) + Double.valueOf(TcheckingZ.get(o).toString())), 2));
				}
			}

		}
		for (String o : TcheckingZ.keySet()) {
			if ("class".equals(o)) {
				Tchecking.put(o, m2.get(o));
				continue;
			}
			Tchecking.put(o, Double.parseDouble(TcheckingZ.get(o).toString()) - Double.parseDouble(m2.get(o)));
		}

		return mapToBean(Tchecking, AnalysisStudyVO.class.newInstance());
	}

	@SuppressWarnings("unchecked")
	private AnalysisStudyVO f(AnalysisStudyVO MSA, AnalysisStudyVO MSE)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Map<String, Object> mse = new HashMap<String, Object>();
		Map<String, String> m1 = BeanUtils.describe(MSA);
		Map<String, String> m2 = BeanUtils.describe(MSE);
		for (String o : m1.keySet()) {
			if ("class".equals(o)) {
				mse.put(o, m1.get(o));
				continue;
			}
			Double m1_ = Double.parseDouble(m1.get(o)) / Double.parseDouble(m2.get(o));
			mse.put(o, m1_);

		}

		return mapToBean(mse, AnalysisStudyVO.class.newInstance());
	}

	@SuppressWarnings("unchecked")
	private AnalysisStudyVO mse(AnalysisStudyVO SST, AnalysisStudyVO SSE, int size)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Map<String, Object> mse = new HashMap<String, Object>();
		Map<String, String> m1 = BeanUtils.describe(SST);
		for (String o : m1.keySet()) {
			if ("class".equals(o)) {
				mse.put(o, m1.get(o));
				continue;
			}
			Double m1_ = Double.parseDouble(m1.get(o)) / (size - 3);
			mse.put(o, m1_);

		}

		return mapToBean(mse, AnalysisStudyVO.class.newInstance());
	}

	/**
	 * 获取SSA
	 * 
	 * @param SST
	 * @param SSE
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Map<String, Object>> ssa(AnalysisStudyVO SST, AnalysisStudyVO SSE)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Map<String, Map<String, Object>> amp = new HashMap<String, Map<String, Object>>();
		Map<String, Object> SSA = new HashMap<String, Object>();
		Map<String, Object> MSA = new HashMap<String, Object>();
		Map<String, String> m1 = BeanUtils.describe(SST);
		Map<String, String> m2 = BeanUtils.describe(SSE);
		for (String o : m1.keySet()) {
			if ("class".equals(o)) {
				SSA.put(o, m1.get(o));
				continue;
			}
			Double m1_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(m2.get(o));
			SSA.put(o, m1_);
			MSA.put(o, m1_ / 3);
		}
		amp.put("SSA", SSA);
		amp.put("MSA", MSA);
		return amp;
	}

	/**
	 * 获取sse
	 * 
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param v4
	 * @param anmindhou
	 * @param anfitnessIds
	 * @param anmixturetihou
	 * @param ancontrasttihou
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	private AnalysisStudyVO sse(List<AnalysisStudyVO> v1, List<AnalysisStudyVO> v2, List<AnalysisStudyVO> v3,
			List<AnalysisStudyVO> v4, AnalysisStudyVO anmindhou, AnalysisStudyVO anfitnessIds,
			AnalysisStudyVO anmixturetihou, AnalysisStudyVO ancontrasttihou) throws IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, InstantiationException {

		Map<String, Object> TcheckingZ = new HashMap<String, Object>();

		for (int i = 0; i < v1.size(); i++) {
			Map<String, String> m1 = BeanUtils.describe(v1.get(i));
			//Map<String, String> m2 = BeanUtils.describe(v2.get(i));
			//Map<String, String> m3 = BeanUtils.describe(v3.get(i));
			//Map<String, String> m4 = BeanUtils.describe(v4.get(i));
			Map<String, String> mx1 = BeanUtils.describe(anmindhou);
			Map<String, String> mx2 = BeanUtils.describe(anfitnessIds);
			Map<String, String> mx3 = BeanUtils.describe(anmixturetihou);
			Map<String, String> mx4 = BeanUtils.describe(ancontrasttihou);
			for (String o : m1.keySet()) {
				if ("class".equals(o)) {
					TcheckingZ.put(o, m1.get(o));
					continue;
				}

				Double m1_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(mx1.get(o));
				Double m2_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(mx2.get(o));
				Double m3_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(mx3.get(o));
				Double m4_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(mx4.get(o));
				Double x_2 = Math.pow(m1_, 2) + Math.pow(m2_, 2) + Math.pow(m3_, 2) + Math.pow(m4_, 2);
				if (TcheckingZ.get(o) != null) {
					TcheckingZ.put(o, (double) TcheckingZ.get(o) + x_2);
				} else {
					TcheckingZ.put(o, x_2);
				}
			}

		}

		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	/**
	 * 获取sst
	 * 
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param v4
	 * @param x_
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	private AnalysisStudyVO sst(List<AnalysisStudyVO> v1, List<AnalysisStudyVO> v2, List<AnalysisStudyVO> v3,
			List<AnalysisStudyVO> v4, AnalysisStudyVO x_) throws IllegalAccessException, InvocationTargetException,
					NoSuchMethodException, InstantiationException {

		Map<String, String> x_1 = BeanUtils.describe(x_);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();

		for (int i = 0; i < v1.size(); i++) {
			Map<String, String> m1 = BeanUtils.describe(v1.get(i));
			Map<String, String> m2 = BeanUtils.describe(v2.get(i));
			Map<String, String> m3 = BeanUtils.describe(v3.get(i));
			Map<String, String> m4 = BeanUtils.describe(v4.get(i));
			for (String o : m1.keySet()) {
				if ("class".equals(o)) {
					TcheckingZ.put(o, m1.get(o));
					continue;
				}

				Double m1_ = Double.parseDouble(m1.get(o)) - Double.parseDouble(x_1.get(o));
				Double m2_ = Double.parseDouble(m2.get(o)) - Double.parseDouble(x_1.get(o));
				Double m3_ = Double.parseDouble(m3.get(o)) - Double.parseDouble(x_1.get(o));
				Double m4_ = Double.parseDouble(m4.get(o)) - Double.parseDouble(x_1.get(o));
				Double x_2 = Math.pow(m1_, 2) + Math.pow(m2_, 2) + Math.pow(m3_, 2) + Math.pow(m4_, 2);
				if (TcheckingZ.get(o) != null) {
					TcheckingZ.put(o, (double) TcheckingZ.get(o) + x_2);
				} else {
					TcheckingZ.put(o, x_2);
				}
			}

		}

		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	@SuppressWarnings("unchecked")
	private AnalysisStudyVO xevg(AnalysisStudyVO anmindhou, AnalysisStudyVO anfitnessIds,
			AnalysisStudyVO anmixturetihou, AnalysisStudyVO ancontrasttihou, int sumLength, int lisize)
					throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
					InstantiationException {
		Map<String, String> wmsu1 = BeanUtils.describe(anmindhou);
		Map<String, String> wmn1 = BeanUtils.describe(anfitnessIds);
		Map<String, String> msu1 = BeanUtils.describe(anmixturetihou);
		Map<String, String> mn1 = BeanUtils.describe(ancontrasttihou);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		for (String o : wmsu1.keySet()) {
			if ("class".equals(o)) {
				TcheckingZ.put(o, wmsu1.get(o));
				continue;
			}
			Double evg1 = Double.parseDouble(wmsu1.get(o)) * lisize;
			Double evg2 = Double.parseDouble(wmn1.get(o)) * lisize;
			Double evg3 = Double.parseDouble(msu1.get(o)) * lisize;
			Double evg4 = Double.parseDouble(mn1.get(o)) * lisize;
			TcheckingZ.put(o, (evg1 + evg2 + evg3 + evg4) / sumLength);
		}
		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	/**
	 * 卡方验算
	 * 
	 * @param minds
	 * @param mindtiqian
	 * @param mindhou
	 * @param mindtihou
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	private AnalysisStudyVO mK(List<EvaluatedPrivatelyVO> minds, List<MAssessFitness> mindtiqian,
			List<EvaluatedPrivatelyVO> mindhou, List<MAssessFitness> mindtihou) throws IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, InstantiationException {
		List<EvaluatedPrivatelyVO> evM = new ArrayList<EvaluatedPrivatelyVO>();
		List<MAssessFitness> maM = new ArrayList<MAssessFitness>(); // 男性
		List<EvaluatedPrivatelyVO> evWM = new ArrayList<EvaluatedPrivatelyVO>();// 女性
		List<MAssessFitness> maWM = new ArrayList<MAssessFitness>();

		List<EvaluatedPrivatelyVO> evME = new ArrayList<EvaluatedPrivatelyVO>();
		List<MAssessFitness> maME = new ArrayList<MAssessFitness>(); // 男性

		List<EvaluatedPrivatelyVO> evWME = new ArrayList<EvaluatedPrivatelyVO>();// 女性
		List<MAssessFitness> maWME = new ArrayList<MAssessFitness>();

		for (EvaluatedPrivatelyVO a : minds) {
			for (MAssessFitness ma : mindtiqian) {
				if (ma.getUser().getId() == a.getUserId() && ma.getUser().getGender() == 0) {// 女性
					evWM.add(a);
					maWM.add(ma);
				} else if (ma.getUser().getId() == a.getUserId() && ma.getUser().getGender() == 1) {
					evM.add(a);
					maM.add(ma);
				}
			}

		}
		for (EvaluatedPrivatelyVO a : mindhou) {
			for (MAssessFitness ma : mindtihou) {
				if (ma.getUser().getId() == a.getUserId() && ma.getUser().getGender() == 0) {// 女性
					evWME.add(a);
					maWME.add(ma);
				} else if (ma.getUser().getId() == a.getUserId() && ma.getUser().getGender() == 1) {
					evME.add(a);
					maME.add(ma);
				}
			}

		}
		// 未提高人数 女性
		Integer ADLT = 0;
		Integer IADLT = 0;
		Integer BodyWeightT = 0;
		Integer myodyNamiaT = 0;
		Integer xinfenT = 0;
		Integer rouruanT = 0;
		Integer shenjingT = 0;
		Integer xueyaT = 0;
		Integer dingxiangliT = 0;
		Integer zhuyiliT = 0;
		Integer jiyiliT = 0;
		Integer yuyanliT = 0;
		Integer huiyiliT = 0;
		Integer choxiangT = 0;
		Integer shijiegouT = 0;
		Integer zhixingliT = 0;
		Integer jisuanliT = 0;
		Integer GDSScroeT = 0;
		Integer mocaScroeT = 0;
		Integer mmseScroeT = 0;
		// 提高人数 女性
		Integer ADLTee = 0;
		Integer IADLTe = 0;
		Integer BodyWeightTe = 0;
		Integer myodyNamiaTe = 0;
		Integer xinfenTe = 0;
		Integer rouruanTe = 0;
		Integer shenjingTe = 0;
		Integer xueyaTe = 0;
		Integer dingxiangliTe = 0;
		Integer zhuyiliTe = 0;
		Integer jiyiliTe = 0;
		Integer yuyanliTe = 0;
		Integer huiyiliTe = 0;
		Integer choxiangTe = 0;
		Integer shijiegouTe = 0;
		Integer zhixingliTe = 0;
		Integer jisuanliTe = 0;
		Integer GDSScroeTe = 0;
		Integer mocaScroeTe = 0;
		Integer mmseScroeTe = 0;

		// 未提高人数 男性
		Integer ADLTm = 0;
		Integer IADLTm = 0;
		Integer BodyWeightTm = 0;
		Integer myodyNamiaTm = 0;
		Integer xinfenTm = 0;
		Integer rouruanTm = 0;
		Integer shenjingTm = 0;
		Integer xueyaTm = 0;
		Integer dingxiangliTm = 0;
		Integer zhuyiliTm = 0;
		Integer jiyiliTm = 0;
		Integer yuyanliTm = 0;
		Integer huiyiliTm = 0;
		Integer choxiangTm = 0;
		Integer shijiegouTm = 0;
		Integer zhixingliTm = 0;
		Integer jisuanliTm = 0;
		Integer GDSScroeTm = 0;
		Integer mocaScroeTm = 0;
		Integer mmseScroeTm = 0;
		// 提高人数 男性
		Integer ADLTme = 0;
		Integer IADLTme = 0;
		Integer BodyWeightTme = 0;
		Integer myodyNamiaTme = 0;
		Integer xinfenTme = 0;
		Integer rouruanTme = 0;
		Integer shenjingTme = 0;
		Integer xueyaTme = 0;
		Integer dingxiangliTme = 0;
		Integer zhuyiliTme = 0;
		Integer jiyiliTme = 0;
		Integer yuyanliTme = 0;
		Integer huiyiliTme = 0;
		Integer choxiangTme = 0;
		Integer shijiegouTme = 0;
		Integer zhixingliTme = 0;
		Integer jisuanliTme = 0;
		Integer GDSScroeTme = 0;
		Integer mocaScroeTme = 0;
		Integer mmseScroeTme = 0;

		// 提高人数 女性
		List<AnalysisStudyVO> we = getlist(evWME, maWME);// 女干预后
		List<AnalysisStudyVO> me = getlist(evME, maME);// 男干预后
		List<AnalysisStudyVO> ws = getlist(evWM, maWM);// 女干预前
		List<AnalysisStudyVO> ms = getlist(evM, maM);// 男干预前
		int wsize = mindtiqian.size();
		for (int i = 0; i < me.size(); i++) {// 女性干预后对比
			AnalysisStudyVO ve = me.get(i);
			AnalysisStudyVO vs = ms.get(i);
			Map<String, String> e11 = BeanUtils.describe(ve);
			Map<String, String> e12 = BeanUtils.describe(vs);// 干预前
			for (String beanName : e11.keySet()) {
				if ("class".equals(beanName)) {
					continue;
				}
				double x1 = Double.parseDouble(e11.get(beanName));
				double x2 = Double.parseDouble(e12.get(beanName));
				if (x1 - x2 > 0) {
					if ("ADLScoreC".equals(beanName)) {
						ADLTme += 1;
					}
					if ("ADLScoreC".equals(beanName)) {
						IADLTme += 1;
					}
					if ("BodyWeight".equals(beanName)) {
						BodyWeightTme += 1;
					}
					if ("myodyNamia".equals(beanName)) {
						myodyNamiaTme += 1;
					}
					if ("xinfen".equals(beanName)) {
						xinfenTme += 1;
					}
					if ("rouruan".equals(beanName)) {
						rouruanTme += 1;
					}
					if ("yuyanli".equals(beanName)) {
						yuyanliTme += 1;
					}
					if ("shenjing".equals(beanName)) {
						shenjingTme += 1;
					}
					if ("xueya".equals(beanName)) {
						xueyaTme += 1;
					}
					if ("dingxiangli".equals(beanName)) {
						dingxiangliTme += 1;
					}
					if ("zhuyili".equals(beanName)) {
						zhuyiliTme += 1;
					}
					if ("jiyili".equals(beanName)) {
						jiyiliTme += 1;
					}
					if ("GDSScroe".equals(beanName)) {
						GDSScroeTme += 1;
					}
					if ("MoCaScroe".equals(beanName)) {
						mocaScroeTme += 1;
					}
					if ("MMSEScroe".equals(beanName)) {
						mmseScroeTme += 1;
					}
					if ("huiyili".equals(beanName)) {
						huiyiliTme += 1;
					}
					if ("shijiegou".equals(beanName)) {
						shijiegouTme += 1;
					}
					if ("zhixingli".equals(beanName)) {
						zhixingliTme += 1;
					}
					if ("jisuanli".equals(beanName)) {
						jisuanliTme += 1;
					}
					if ("choxiang".equals(beanName)) {
						choxiangTme += 1;
					}
				} else {
					if ("ADLScoreC".equals(beanName)) {
						ADLTm += 1;
					}
					if ("ADLScoreC".equals(beanName)) {
						IADLTm += 1;
					}
					if ("BodyWeight".equals(beanName)) {
						BodyWeightTm += 1;
					}
					if ("myodyNamia".equals(beanName)) {
						myodyNamiaTm += 1;
					}
					if ("xinfen".equals(beanName)) {
						xinfenTm += 1;
					}
					if ("rouruan".equals(beanName)) {
						rouruanTm += 1;
					}
					if ("yuyanli".equals(beanName)) {
						yuyanliTm += 1;
					}
					if ("shenjing".equals(beanName)) {
						shenjingTm += 1;
					}
					if ("xueya".equals(beanName)) {
						xueyaTm += 1;
					}
					if ("dingxiangli".equals(beanName)) {
						dingxiangliTm += 1;
					}
					if ("zhuyili".equals(beanName)) {
						zhuyiliTm += 1;
					}
					if ("jiyili".equals(beanName)) {
						jiyiliTm += 1;
					}
					if ("GDSScroe".equals(beanName)) {
						GDSScroeTm += 1;
					}
					if ("MoCaScroe".equals(beanName)) {
						mocaScroeTm += 1;
					}
					if ("MMSEScroe".equals(beanName)) {
						mmseScroeTm += 1;
					}
					if ("huiyili".equals(beanName))
						huiyiliTm += 1;
				}
				if ("shijiegou".equals(beanName)) {
					shijiegouTm += 1;
				}
				if ("zhixingli".equals(beanName)) {
					zhixingliTm += 1;
				}
				if ("jisuanli".equals(beanName)) {
					jisuanliTm += 1;
				}
				if ("choxiang".equals(beanName)) {
					choxiangTm += 1;
				}
			}
		}

		for (int i = 0; i < we.size(); i++) {// 女性干预后对比
			AnalysisStudyVO ve = we.get(i);
			AnalysisStudyVO vs = ws.get(i);
			Map<String, String> e11 = BeanUtils.describe(ve);
			Map<String, String> e12 = BeanUtils.describe(vs);// 干预前
			for (String beanName : e11.keySet()) {
				if ("class".equals(beanName)) {
					continue;
				}
				double x1 = Double.parseDouble(e11.get(beanName));
				double x2 = Double.parseDouble(e12.get(beanName));
				if (x1 - x2 > 0) {
					if ("ADLScoreC".equals(beanName))
						ADLTee += 1;
					if ("ADLScoreC".equals(beanName))
						IADLTe += 1;
					if ("BodyWeight".equals(beanName))
						BodyWeightTe += 1;
					if ("myodyNamia".equals(beanName))
						myodyNamiaTe += 1;
					if ("xinfen".equals(beanName))
						xinfenTe += 1;
					if ("rouruan".equals(beanName))
						rouruanTe += 1;
					if ("yuyanli".equals(beanName))
						yuyanliTe += 1;
					if ("shenjing".equals(beanName))
						shenjingTe += 1;
					if ("xueya".equals(beanName))
						xueyaTe += 1;
					if ("dingxiangli".equals(beanName))
						dingxiangliTe += 1;
					if ("zhuyili".equals(beanName))
						zhuyiliTe += 1;
					if ("jiyili".equals(beanName))
						jiyiliTe += 1;
					if ("GDSScroe".equals(beanName))
						GDSScroeTe += 1;
					if ("MoCaScroe".equals(beanName))
						mocaScroeTe += 1;
					if ("MMSEScroe".equals(beanName))
						mmseScroeTe += 1;
					if ("huiyili".equals(beanName))
						huiyiliTe += 1;
					if ("shijiegou".equals(beanName))
						shijiegouTe += 1;
					if ("zhixingli".equals(beanName))
						zhixingliTe += 1;
					if ("jisuanli".equals(beanName))
						jisuanliTe += 1;
					if ("choxiang".equals(beanName))
						choxiangTe += 1;
				} else {
					if ("ADLScoreC".equals(beanName))
						ADLT += 1;
					if ("ADLScoreC".equals(beanName))
						IADLT += 1;
					if ("BodyWeight".equals(beanName))
						BodyWeightT += 1;
					if ("myodyNamia".equals(beanName))
						myodyNamiaT += 1;
					if ("xinfen".equals(beanName))
						xinfenT += 1;
					if ("rouruan".equals(beanName))
						rouruanT += 1;
					if ("yuyanli".equals(beanName))
						yuyanliT += 1;
					if ("shenjing".equals(beanName))
						shenjingT += 1;
					if ("xueya".equals(beanName))
						xueyaT += 1;
					if ("dingxiangli".equals(beanName))
						dingxiangliT += 1;
					if ("zhuyili".equals(beanName))
						zhuyiliT += 1;
					if ("jiyili".equals(beanName))
						jiyiliT += 1;
					if ("GDSScroe".equals(beanName))
						GDSScroeT += 1;
					if ("MoCaScroe".equals(beanName))
						mocaScroeT += 1;
					if ("MMSEScroe".equals(beanName))
						mmseScroeT += 1;
					if ("huiyili".equals(beanName))
						huiyiliT += 1;
					if ("shijiegou".equals(beanName))
						shijiegouT += 1;
					if ("zhixingli".equals(beanName))
						zhixingliT += 1;
					if ("jisuanli".equals(beanName))
						jisuanliT += 1;
					if ("choxiang".equals(beanName))
						choxiangT += 1;
				}
			}

		}
		Analyperson wmsu = new Analyperson(ADLTee, IADLTe, BodyWeightTe, myodyNamiaTe, xinfenTe, rouruanTe, shenjingTe,
				xueyaTe, dingxiangliTe, zhuyiliTe, jiyiliTe, yuyanliTe, huiyiliTe, choxiangTe, shijiegouTe, zhixingliTe,
				jisuanliTe, GDSScroeTe, mocaScroeTe, mmseScroeTe);
		Analyperson wmn = new Analyperson(ADLT, IADLT, BodyWeightT, myodyNamiaT, xinfenT, rouruanT, shenjingT, xueyaT,
				dingxiangliT, zhuyiliT, jiyiliT, yuyanliT, huiyiliT, choxiangT, shijiegouT, zhixingliT, jisuanliT,
				GDSScroeT, mocaScroeT, mmseScroeT);
		Analyperson msu = new Analyperson(ADLTm, IADLTm, BodyWeightTm, myodyNamiaTm, xinfenTm, rouruanTm, shenjingTm,
				xueyaTm, dingxiangliTm, zhuyiliTm, jiyiliTm, yuyanliTm, huiyiliTm, choxiangTm, shijiegouTm, zhixingliTm,
				jisuanliTm, GDSScroeTm, mocaScroeTm, mmseScroeTm);
		Analyperson mn = new Analyperson(ADLTme, IADLTme, BodyWeightTme, myodyNamiaTme, xinfenTme, rouruanTme,
				shenjingTme, xueyaTme, dingxiangliTme, zhuyiliTme, jiyiliTme, yuyanliTme, huiyiliTme, choxiangTme,
				shijiegouTme, zhixingliTme, jisuanliTme, GDSScroeTme, mocaScroeTme, mmseScroeTme);
		Map<String, String> wmsu1 = BeanUtils.describe(wmsu);
		Map<String, String> wmn1 = BeanUtils.describe(wmn);
		Map<String, String> msu1 = BeanUtils.describe(msu);
		Map<String, String> mn1 = BeanUtils.describe(mn);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		Map<String, String> e11 = BeanUtils.describe(new AnalysisStudyVO());
		for (String o : wmsu1.keySet()) {
			if ("class".equals(o)) {
				TcheckingZ.put(o, e11.get(o));
				continue;
			}
			if ("zhuyili".equals(o)) {
			}
			Integer wsu = Integer.parseInt(wmsu1.get(o)); // 女提高
			Integer wn = Integer.parseInt(wmn1.get(o));
			Integer msu2 = Integer.parseInt(msu1.get(o)); // 男提高
			Integer mn2 = Integer.parseInt(mn1.get(o));
			double b10 = (wsu + msu2) * (msu2 + mn2) / wsize;
			double c10 = (wn + mn2) * (msu2 + mn2) / wsize;
			double b11 = (wsu + msu2) * (wsu + wn) / wsize;
			double c11 = (wn + mn2) * (wsu + wn) / wsize;
			double d1 = 0.0;
			if (c11 != 0.0 && c10 != 0.0 && b11 != 0.0 && b10 != 0.0) {
				d1 = Math.pow((msu2 - b10), 2) / b10 + Math.pow((wsu - b11), 2) / b11 + Math.pow((mn2 - c10), 2) / c10
						+ Math.pow((wn - c11), 2) / c11;
			}

			TcheckingZ.put(o, d1);
		}
		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	@SuppressWarnings("unused")
	private Set<AnalysisStudyVO> manAndWM_(List<EvaluatedPrivatelyVO> mindhou, List<MAssessFitness> mindtihou)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

		List<EvaluatedPrivatelyVO> evME = new ArrayList<EvaluatedPrivatelyVO>();
		List<MAssessFitness> maME = new ArrayList<MAssessFitness>(); // 男性

		List<EvaluatedPrivatelyVO> evWME = new ArrayList<EvaluatedPrivatelyVO>();// 女性
		List<MAssessFitness> maWME = new ArrayList<MAssessFitness>();

		for (EvaluatedPrivatelyVO a : mindhou) {
			for (MAssessFitness ma : mindtihou) {
				if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 0) {// 女性
					evWME.add(a);
					maWME.add(ma);
				} else if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 1) {
					evME.add(a);
					maME.add(ma);
				}
			}

		}
		AnalysisStudyVO v1 = getAnalysisStudyVO(evME, maME);// 单组男平均值
		AnalysisStudyVO v2 = getAnalysisStudyVO(evWME, maWME);// 单组女平均值
		Set<AnalysisStudyVO> set = new HashSet<AnalysisStudyVO>();
		set.add(v1);
		set.add(v2);
		return set;

	}

	/**
	 * 根据性别获取T
	 * 
	 * @param minds
	 * @param mindtiqian
	 * @return
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	private AnalysisStudyVO manAndWM(List<EvaluatedPrivatelyVO> minds, List<MAssessFitness> mindtiqian,
			List<EvaluatedPrivatelyVO> mindhou, List<MAssessFitness> mindtihou) throws IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, InstantiationException {
		List<EvaluatedPrivatelyVO> evM = new ArrayList<EvaluatedPrivatelyVO>();
		List<MAssessFitness> maM = new ArrayList<MAssessFitness>(); // 男性

		List<EvaluatedPrivatelyVO> evWM = new ArrayList<EvaluatedPrivatelyVO>();// 女性
		List<MAssessFitness> maWM = new ArrayList<MAssessFitness>();

		List<EvaluatedPrivatelyVO> evME = new ArrayList<EvaluatedPrivatelyVO>();
		List<MAssessFitness> maME = new ArrayList<MAssessFitness>(); // 男性

		List<EvaluatedPrivatelyVO> evWME = new ArrayList<EvaluatedPrivatelyVO>();// 女性
		List<MAssessFitness> maWME = new ArrayList<MAssessFitness>();

		for (EvaluatedPrivatelyVO a : minds) {
			for (MAssessFitness ma : mindtiqian) {
				if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 0) {// 女性
					evWM.add(a);
					maWM.add(ma);
				} else if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 1) {
					evM.add(a);
					maM.add(ma);
				}
			}

		}
		for (EvaluatedPrivatelyVO a : mindhou) {
			for (MAssessFitness ma : mindtihou) {
				if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 0) {// 女性
					evWME.add(a);
					maWME.add(ma);
				} else if (ma.getUser().getId() == a.getId() && ma.getUser().getGender() == 1) {
					evME.add(a);
					maME.add(ma);
				}
			}

		}
		// 为柔韧素质增加值的平均值 即为后减前
		AnalysisStudyVO evgM = getAnalysisStudyVO(evM, maM);// 男组平均值 前
		AnalysisStudyVO evgWM = getAnalysisStudyVO(evWM, maWM);// 女组平均值 前
		AnalysisStudyVO evgME = getAnalysisStudyVO(evME, maME);// 男组平均值 前
		AnalysisStudyVO evgWME = getAnalysisStudyVO(evWME, maWME);// 女组平均值 前

		AnalysisStudyVO egWM = getEVG(evgME, evgM);// 男组 代表对应前后两组数据之差的平均值
		AnalysisStudyVO egM = getEVG(evgWME, evgWM);// 女组 代表对应前后两组数据之差的平均值
		AnalysisStudyVO aWM = getAnSSVOEVG(evWME, evWM, maWM, maWME);// 差值平方和
		AnalysisStudyVO aM = getAnSSVOEVG(evME, evM, maM, maME);
		int n1 = evM.size();
		int n2 = evWM.size();
		if (n1 != 0 && n2 != 0) {
			Map<String, String> e11 = BeanUtils.describe(egWM);// 男组
																// 代表对应前后两组数据之差的平均值
			Map<String, String> e12 = BeanUtils.describe(egM);
			Map<String, String> e111 = BeanUtils.describe(aWM);
			Map<String, String> e122 = BeanUtils.describe(aM);
			Map<String, Object> TcheckingZ = new HashMap<String, Object>();
			for (String beanName : e11.keySet()) {
				if ("class".equals(beanName)) {
					TcheckingZ.put(beanName, e11.get(beanName));
					continue;
				}
				double x1 = Double.parseDouble(e11.get(beanName));// 男组
																	// 代表对应前后两组数据之差的平均值
				double s2 = Double.parseDouble(e111.get(beanName));// 女组 差值平方和
				double x2 = Double.parseDouble(e12.get(beanName));// 女组
																	// 代表对应前后两组数据之差的平均值
				double s1 = Double.parseDouble(e122.get(beanName));// 男组 差值平方和
				// double z1=z-x;
				double x1_x2 = x2 - x1;
				double s1_s2 = ((n1 - 1) * s1 * s1 + (n2 - 1) * s2 * s2) / (n1 + n2 - 2);
				double n1_n2 = (1 / n1 + 1 / n2) * s1_s2;
				double evg = x1_x2 / Math.sqrt(n1_n2);
				TcheckingZ.put(beanName, evg);
			}
			return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
		} else {
			AnalysisStudyVO vo = new AnalysisStudyVO(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
			AnalysisStudyVO a = new AnalysisStudyVO();
			BeanUtils.copyProperties(vo, a);
			return a;
		}

	}

	@SuppressWarnings("unchecked")
	private AnalysisStudyVO getEVG(AnalysisStudyVO anmindhou, AnalysisStudyVO s1)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, String> e11 = BeanUtils.describe(anmindhou);
		Map<String, String> e12 = BeanUtils.describe(s1);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		for (String beanName : e11.keySet()) {
			if ("class".equals(beanName)) {
				TcheckingZ.put(beanName, e11.get(beanName));
				continue;
			}
			double z = Double.parseDouble(e11.get(beanName));
			double x = Double.parseDouble(e12.get(beanName));
			double z1 = z - x;
			TcheckingZ.put(beanName, z1);
		}

		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	/**
	 * 单体T验算
	 * 
	 * @param evgD1
	 * @param vmdS1
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	private AnalysisStudyVO getTD(AnalysisStudyVO evgD1, AnalysisStudyVO vmdS1, Double n)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Map<String, String> e11 = BeanUtils.describe(evgD1);
		Map<String, String> e12 = BeanUtils.describe(vmdS1);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		for (String beanName : e11.keySet()) {
			if ("class".equals(beanName)) {
				TcheckingZ.put(beanName, e11.get(beanName));
				continue;
			}
			double z = Double.parseDouble(e11.get(beanName));
			double x = Double.parseDouble(e12.get(beanName));
			double z1 = 0.0;
			if (x != 0.0) {
				z1 = z * n / x;
			}
			TcheckingZ.put(beanName, z1);
		}
		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
	}

	/**
	 * 为对应数据之差的标准差
	 * 
	 * @param mindhou
	 * @param minds
	 * @param mindtiqian
	 * @param mindtihou
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({  "unchecked" })
	private AnalysisStudyVO getAnSSVOEVG(List<EvaluatedPrivatelyVO> mindhou, List<EvaluatedPrivatelyVO> minds,
			List<MAssessFitness> mindtiqian, List<MAssessFitness> mindtihou) throws IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, InstantiationException {
		List<AnalysisStudyVO> userS = getlist(minds, mindtiqian);// 获取每位老人的测量信息
		List<AnalysisStudyVO> userE = getlist(mindhou, mindtihou);// 获取每位老人的测量信息
		List<AnalysisStudyVO> userEVG = new ArrayList<AnalysisStudyVO>();
		for (int i = 0; i < userS.size(); i++) {
			AnalysisStudyVO s = userS.get(i);
			AnalysisStudyVO e = userE.get(i);
			Map<String, String> s11 = BeanUtils.describe(s);
			Map<String, String> e11 = BeanUtils.describe(e);
			Map<String, Object> TcheckingZ = new HashMap<String, Object>();
			for (String beanName : s11.keySet()) {
				if ("class".equals(beanName)) {
					TcheckingZ.put(beanName, s11.get(beanName));
					continue;
				}
				double z = Double.parseDouble(s11.get(beanName));
				double x = Double.parseDouble(e11.get(beanName));
				double z1 = Math.pow((x - z), 2);
				TcheckingZ.put(beanName, z1);
			}
			AnalysisStudyVO v1 = mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());
			userEVG.add(v1);
		}
		return kaifang(userEVG);
	}

	/**
	 * 开平方
	 * 
	 * @param userEVG
	 * @return
	 */
	private AnalysisStudyVO kaifang(List<AnalysisStudyVO> userEVG) {
		Double ADLT = 0.0;
		Double IADLT = 0.0;
		Double BodyWeightT = 0.0;
		Double myodyNamiaT = 0.0;
		Double xinfenT = 0.0;
		Double rouruanT = 0.0;
		Double shenjingT = 0.0;
		Double xueyaT = 0.0;
		Double dingxiangliT = 0.0;
		Double zhuyiliT = 0.0;
		Double jiyiliT = 0.0;
		Double yuyanliT = 0.0;
		Double huiyiliT = 0.0;
		Double choxiangT = 0.0;
		Double shijiegouT = 0.0;
		Double zhixingliT = 0.0;
		Double jisuanliT = 0.0;
		Double GDSScroeT = 0.0;
		Double mocaScroeT = 0.0;
		Double mmseScroeT = 0.0;
		AnalysisStudyVO voc = new AnalysisStudyVO();
		for (AnalysisStudyVO a : userEVG) {
			ADLT += a.getADLScoreC();
			IADLT += a.getIADLScoreC();
			BodyWeightT += a.getBodyWeight();
			myodyNamiaT += a.getMyodyNamia();
			xinfenT += a.getXinfen();
			rouruanT += a.getRouruan();
			shenjingT += a.getShenjing();
			xueyaT += a.getXueya();
			dingxiangliT += a.getDingxiangli();
			zhuyiliT += a.getZhuyili();
			jiyiliT += a.getJiyili();
			yuyanliT += a.getYuyanli();
			huiyiliT += a.getHuiyili();
			choxiangT += a.getChoxiang();
			shijiegouT += a.getShijiegou();
			zhixingliT += a.getZhixingli();
			jisuanliT += a.getJisuanli();
			GDSScroeT += a.getGDSScroe();
			mocaScroeT += a.getMoCaScroe();
			mmseScroeT += a.getMMSEScroe();
		}
		voc.setADLScoreC(Math.sqrt(ADLT / userEVG.size()));
		voc.setIADLScoreC(Math.sqrt(IADLT / userEVG.size()));
		voc.setMyodyNamia(Math.sqrt(myodyNamiaT / userEVG.size()));
		voc.setDingxiangli(Math.sqrt(dingxiangliT / userEVG.size()));
		voc.setZhuyili(Math.sqrt(zhuyiliT / userEVG.size()));
		voc.setJiyili(Math.sqrt(jiyiliT / userEVG.size()));
		voc.setYuyanli(Math.sqrt(yuyanliT / userEVG.size()));
		voc.setHuiyili(Math.sqrt(huiyiliT / userEVG.size()));
		voc.setChoxiang(Math.sqrt(choxiangT / userEVG.size()));
		voc.setShijiegou(Math.sqrt(shijiegouT / userEVG.size()));
		voc.setZhixingli(Math.sqrt(zhixingliT / userEVG.size()));
		voc.setJisuanli(Math.sqrt(jisuanliT / userEVG.size()));
		voc.setBodyWeight(Math.sqrt(BodyWeightT / userEVG.size())); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		voc.setMyodyNamia(Math.sqrt(myodyNamiaT / userEVG.size()));// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		voc.setXinfen(Math.sqrt(xinfenT / userEVG.size()));// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		voc.setRouruan(Math.sqrt(rouruanT / userEVG.size())); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		voc.setShenjing(Math.sqrt(shenjingT / userEVG.size()));// 神经反应能力得分为2.44米折返走速度，神经反应能力得分可根据其性别、年龄层和2.44米折返跑时间确认出其具体的神经反应能力得分，对应表见(常模)；；
		voc.setXueya(Math.sqrt(xueyaT / userEVG.size()));
		voc.setGDSScroe(Math.sqrt(GDSScroeT / userEVG.size()));
		voc.setMoCaScroe(Math.sqrt(mocaScroeT / userEVG.size()));
		voc.setMMSEScroe(Math.sqrt(mmseScroeT / userEVG.size()));
		return voc;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private AnalysisStudyVO getAnlysisStudyVO(AnalysisStudyVO an, List<MAssessFitness> mindtihou,
			AnalysisStudyVO anmindhou, AnalysisStudyVO biaoCha) throws IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, InstantiationException {
		double t1 = Math.sqrt(mindtihou.size() - 1);
		Map<String, String> map = BeanUtils.describe(biaoCha);
		Map<String, String> mapanmindhou = BeanUtils.describe(anmindhou);
		Map<String, String> mapan = BeanUtils.describe(an);
		Map<String, Object> TcheckingZ = new HashMap<String, Object>();
		for (String beanName : map.keySet()) {
			if ("class".equals(beanName)) {
				TcheckingZ.put(beanName, map.get(beanName));
				continue;
			}
			double z = Double.parseDouble(mapanmindhou.get(beanName));
			double s = Double.parseDouble(mapan.get(beanName));
			double z1 = z - s;
			Double m = Double.parseDouble(map.get(beanName)) / t1;
			Double d = z1 / m;
			if ("NaN".equals(d)) {
				d = 0.0;
			}
			TcheckingZ.put(beanName, d);
		}

		return mapToBean(TcheckingZ, AnalysisStudyVO.class.newInstance());//// 干预后
																			//// MMSE/MoCA
																			//// 认知功能T验算
	}

	public final static MyBeanWithPerson myBeanWithPerson(String json, Map<String, Class<QuestionVO>> classMap) {
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(JSONObject.fromObject(json),
				MyBeanWithPerson.class, classMap);
		;
		return diyBean;
	}

	public static MyBeanWithPerson getMyBeanWithPerson(EvaluatedPrivatelyVO vo1) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
		classMap.put("result", QuestionVO.class);

		String json = vo1.getRecordDetail();
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(json);
		String strNoBlank = m.replaceAll("");
		json = strNoBlank.substring(1, strNoBlank.length() - 1);
		/* json = json.replaceAll("\r|\n", ""); */
		return myBeanWithPerson(json, classMap);
	}

	private FitnseeVO Result(Long userId, MAssessFitness maFitness) {
		RUser user = rUserService.findById(userId);
		int age = user.getAge();
		int sex = user.getGender();
		Double grade1 = 0.0;
		Double grade2 = 0.0;
		Double grade3 = 0.0;
		Double grade4 = 0.0;
		Double grade5 = 0.0;
		Double grade6 = 0.0;
		Double grade8 = 0.0;// Double grade7 = 0.0;

		int result1 = maFitness.getResultOne();// ----------------30S坐站---------------------
		Integer result2 = maFitness.getResultTwo(); // ----------------两分钟抬腿---------------------
		Double result3 = maFitness.getResultThree();// ----------------双手背后相扣
													// 柔软度---------------------
		Double result4 = maFitness.getResultFour();// ----------------2.44米折返跑坐---------------------
		Double result5 = maFitness.getResultFive(); // ----------------握力---------------------
		Double result8 = maFitness.getResultEight();// ---------------------------座椅体前屈------------------------------
		Double result6 = maFitness.getResultSix();// ----------------身体质量指数--------------------
		if (sex == 0) {// 女性
			if (result6 < 18) {
				grade6 = 1.0;
			} else if (result6 >= 18 && result6 < 24.9) {
				grade6 = 0.5;
			} else if (result6 > 24.9 && result6 < 29.9) {
				grade6 = 0.5;
			} else if (result6 >= 29.9) {
				grade6 = 0.1;
			}
			if (age >= 60 && age < 65) {
				if (result1 <= 8) {
					grade1 = 5.0;
				} else if (result1 == 9) {
					grade1 = 10.0;
				} else if (result1 == 10) {
					grade1 = 15.0;
				} else if (result1 == 11) {
					grade1 = 20.0;
				} else if (result1 == 12) {
					grade1 = 27.5;
				} else if (result1 == 13) {
					grade1 = 35.0;
				} else if (result1 == 14) {
					grade1 = 42.5;
				} else if (result1 == 15) {
					grade1 = 52.5;
				} else if (result1 == 16) {
					grade1 = 62.5;
				} else if (result1 == 17) {
					grade1 = 72.5;
				} else if (result1 == 18) {
					grade1 = 80.0;
				} else if (result1 == 19) {
					grade1 = 85.0;
				} else if (result1 == 20) {
					grade1 = 90.0;
				} else if (result1 == 21) {
					grade1 = 95.0;
				}

				if (result2 <= 52)
					grade2 = 5.0;
				else if (result2 <= 60 && result2 > 52)
					grade2 = 10.0;
				else if (result2 <= 66 && result2 > 60)
					grade2 = 15.0;
				else if (result2 <= 71 && result2 > 66)
					grade2 = 20.0;
				else if (result2 <= 75 && result2 > 71)
					grade2 = 25.0;
				else if (result2 <= 79 && result2 > 75)
					grade2 = 30.0;
				else if (result2 <= 82 && result2 > 79)
					grade2 = 35.0;
				else if (result2 <= 85 && result2 > 82)
					grade2 = 40.0;
				else if (result2 <= 88 && result2 > 85)
					grade2 = 45.0;
				else if (result2 <= 91 && result2 > 88)
					grade2 = 50.0;
				else if (result2 <= 94 && result2 > 91)
					grade2 = 55.0;
				else if (result2 <= 97 && result2 > 94)
					grade2 = 60.0;
				else if (result2 <= 100 && result2 > 97)
					grade2 = 65.0;
				else if (result2 <= 103 && result2 > 100)
					grade2 = 70.0;
				else if (result2 <= 107 && result2 > 103)
					grade2 = 75.0;
				else if (result2 <= 111 && result2 > 107)
					grade2 = 80.0;
				else if (result2 <= 116 && result2 > 111)
					grade2 = 85.0;
				else if (result2 <= 122 && result2 > 116)
					grade2 = 90.0;
				else if (result2 > 122)
					grade2 = 95.0;

				if (result3 >= -6.4 && result3 < -5.2)
					grade3 = 5.0;
				else if (result3 >= -5.2 && result3 < -4.3)
					grade3 = 10.0;
				else if (result3 >= -4.3 && result3 < -3.6)
					grade3 = 15.0;
				else if (result3 >= -3.6 && result3 < -3)
					grade3 = 20.0;
				else if (result3 >= -3 && result3 < -2.5)
					grade3 = 25.0;
				else if (result3 >= -2.5 && result3 < -2.1)
					grade3 = 30.0;
				else if (result3 >= -2.1 && result3 < -1.6)
					grade3 = 35.0;
				else if (result3 >= -1.6 && result3 < -1.2)
					grade3 = 40.0;
				else if (result3 >= -1.2 && result3 < -0.7)
					grade3 = 45.0;
				else if (result3 >= -0.7 && result3 < -0.2)
					grade3 = 50.0;
				else if (result3 >= -0.2 && result3 < 0.2)
					grade3 = 55.0;
				else if (result3 >= 0.2 && result3 < 0.7)
					grade3 = 60.0;
				else if (result3 >= 0.7 && result3 < 1.1)
					grade3 = 65.0;
				else if (result3 >= 1.1 && result3 < 1.6)
					grade3 = 70.0;
				else if (result3 >= 1.6 && result3 < 2.2)
					grade3 = 75.0;
				else if (result3 >= 2.2 && result3 < 2.9)
					grade3 = 80.0;
				else if (result3 >= 2.9 && result3 < 3.8)
					grade3 = 85.0;
				else if (result3 >= 3.8 && result3 < 5)
					grade3 = 90.0;
				else if (result3 >= 5)
					grade3 = 95.0;

				if (result4 <= 7.2 && result4 > 6.7)
					grade4 = 5.0;
				else if (result4 <= 6.7 && result4 > 6.4)
					grade4 = 10.0;
				else if (result4 <= 6.4 && result4 > 6.2)
					grade4 = 15.0;
				else if (result4 <= 6.2 && result4 > 6)
					grade4 = 20.0;
				else if (result4 <= 6 && result4 > 5.8)
					grade4 = 25.0;
				else if (result4 <= 5.8 && result4 > 5.7)
					grade4 = 30.0;
				else if (result4 <= 5.7 && result4 > 5.5)
					grade4 = 35.0;
				else if (result4 <= 5.5 && result4 > 5.4)
					grade4 = 40.0;
				else if (result4 <= 5.4 && result4 > 5.2)
					grade4 = 45.0;
				else if (result4 <= 5.2 && result4 > 5)
					grade4 = 50.0;
				else if (result4 <= 5 && result4 > 4.9)
					grade4 = 55.0;
				else if (result4 <= 4.9 && result4 > 4.7)
					grade4 = 60.0;
				else if (result4 <= 4.7 && result4 > 4.6)
					grade4 = 65.0;
				else if (result4 <= 4.6 && result4 > 4.4)
					grade4 = 70.0;
				else if (result4 <= 4.4 && result4 > 4.2)
					grade4 = 75.0;
				else if (result4 <= 4.2 && result4 > 4)
					grade4 = 80.0;
				else if (result4 <= 4 && result4 > 3.7)
					grade4 = 85.0;
				else if (result4 <= 3.7 && result4 > 3.2)
					grade4 = 90.0;
				else if (result4 <= 3.2)
					grade4 = 95.0;

				if (result8 < -3)
					grade4 = 5.0;
				else if (result8 < -2.1 && result8 >= -3)
					grade8 = 10.0;
				else if (result8 < -1.3 && result8 >= -2.1)
					grade8 = 15.0;
				else if (result8 < -0.6 && result8 >= -1.3)
					grade8 = 20.0;
				else if (result8 < 0 && result8 >= -0.6)
					grade8 = 25.0;
				else if (result8 < 0.5 && result8 >= 0)
					grade8 = 30.0;
				else if (result8 < 1.1 && result8 >= 0.5)
					grade8 = 35.0;
				else if (result8 < 1.6 && result8 >= 1.1)
					grade8 = 40.0;
				else if (result8 < 2.1 && result8 >= 1.6)
					grade8 = 45.0;
				else if (result8 < 2.6 && result8 >= 2.1)
					grade8 = 50.0;
				else if (result8 < 3.1 && result8 >= 2.6)
					grade8 = 55.0;
				else if (result8 < 3.7 && result8 >= 3.1)
					grade8 = 60.0;
				else if (result8 < 4.2 && result8 >= 3.7)
					grade8 = 65.0;
				else if (result8 < 4.8 && result8 >= 4.2)
					grade8 = 70.0;
				else if (result8 < 5.5 && result8 >= 4.8)
					grade8 = 75.0;
				else if (result8 < 6.3 && result8 >= 5.5)
					grade8 = 80.0;
				else if (result8 < 7.2 && result8 >= 6.3)
					grade8 = 85.0;
				else if (result8 < 8.7 && result8 >= 7.2)
					grade8 = 90.0;
				else if (result8 >= 8.7)
					grade8 = 95.0;

				if (result5 <= 17.8)
					grade5 = 10.0;
				else if (result5 <= 20.6 && result5 > 17.8)
					grade5 = 30.0;
				else if (result5 <= 21.1 && result5 > 20.6)
					grade5 = 50.0;
				else if (result5 <= 26 && result5 > 21.1)
					grade5 = 70.0;
				else if (result5 > 26)
					grade5 = 90.0;

			} else if (age >= 65 && age <= 69) {
				if (result1 <= 8) {
					grade1 = 5.0;
				} else if (result1 == 9) {
					grade1 = 10.0;
				} else if (result1 == 10) {
					grade1 = 15.0;
				} else if (result1 == 11) {
					grade1 = 22.5;
				} else if (result1 == 12) {
					grade1 = 27.5;
				} else if (result1 == 13) {
					grade1 = 35.0;
				} else if (result1 == 14) {
					grade1 = 42.5;
				} else if (result1 == 15) {
					grade1 = 52.5;
				} else if (result1 == 16) {
					grade1 = 62.5;
				} else if (result1 == 17) {
					grade1 = 72.5;
				} else if (result1 == 18) {
					grade1 = 80.0;
				} else if (result1 == 19) {
					grade1 = 85.0;
				} else if (result1 == 20) {
					grade1 = 90.0;
				} else if (result1 == 21) {
					grade1 = 95.0;
				}

				if (result2 <= 47)
					grade2 = 5.0;
				else if (result2 <= 57 && result2 > 47)
					grade2 = 10.0;
				else if (result2 <= 63 && result2 > 57)
					grade2 = 15.0;
				else if (result2 <= 68 && result2 > 63)
					grade2 = 20.0;
				else if (result2 <= 73 && result2 > 68)
					grade2 = 25.0;
				else if (result2 <= 76 && result2 > 73)
					grade2 = 30.0;
				else if (result2 <= 80 && result2 > 76)
					grade2 = 35.0;
				else if (result2 <= 84 && result2 > 80)
					grade2 = 40.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 45.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 50.0;
				else if (result2 <= 93 && result2 > 90)
					grade2 = 55.0;
				else if (result2 <= 96 && result2 > 93)
					grade2 = 60.0;
				else if (result2 <= 100 && result2 > 96)
					grade2 = 65.0;
				else if (result2 <= 104 && result2 > 100)
					grade2 = 70.0;
				else if (result2 <= 107 && result2 > 104)
					grade2 = 75.0;
				else if (result2 <= 112 && result2 > 107)
					grade2 = 80.0;
				else if (result2 <= 117 && result2 > 112)
					grade2 = 85.0;
				else if (result2 <= 123 && result2 > 117)
					grade2 = 90.0;
				else if (result2 > 123)
					grade2 = 95.0;

				if (result3 >= -7.3 && result3 < -5.9)
					grade3 = 5.0;
				else if (result3 >= -5.9 && result3 < -5)
					grade3 = 10.0;
				else if (result3 >= -5 && result3 < -4.3)
					grade3 = 15.0;
				else if (result3 >= -4.3 && result3 < -3.7)
					grade3 = 20.0;
				else if (result3 >= -3.7 && result3 < -3.1)
					grade3 = 25.0;
				else if (result3 >= -3.1 && result3 < -2.6)
					grade3 = 30.0;
				else if (result3 >= -2.6 && result3 < -2.1)
					grade3 = 35.0;
				else if (result3 >= -2.1 && result3 < -1.7)
					grade3 = 40.0;
				else if (result3 >= -1.7 && result3 < -1.2)
					grade3 = 45.0;
				else if (result3 >= -1.2 && result3 < -0.7)
					grade3 = 50.0;
				else if (result3 >= -0.7 && result3 < -0.3)
					grade3 = 55.0;
				else if (result3 >= -0.3 && result3 < 0.2)
					grade3 = 60.0;
				else if (result3 >= 0.2 && result3 < 0.7)
					grade3 = 65.0;
				else if (result3 >= 0.7 && result3 < 1.3)
					grade3 = 70.0;
				else if (result3 >= 1.3 && result3 < 1.9)
					grade3 = 75.0;
				else if (result3 >= 1.9 && result3 < 2.6)
					grade3 = 80.0;
				else if (result3 >= 2.6 && result3 < 3.5)
					grade3 = 85.0;
				else if (result3 >= 3.5 && result3 < 4.9)
					grade3 = 90.0;
				else if (result3 >= 4.9)
					grade3 = 95.0;

				if (result4 <= 7.6 && result4 > 7.1)
					grade4 = 5.0;
				else if (result4 <= 7.1 && result4 > 6.8)
					grade4 = 10.0;
				else if (result4 <= 6.8 && result4 > 6.6)
					grade4 = 15.0;
				else if (result4 <= 6.6 && result4 > 6.4)
					grade4 = 20.0;
				else if (result4 <= 6.4 && result4 > 6.2)
					grade4 = 25.0;
				else if (result4 <= 6.2 && result4 > 6.1)
					grade4 = 30.0;
				else if (result4 <= 6.1 && result4 > 5.9)
					grade4 = 35.0;
				else if (result4 <= 5.9 && result4 > 5.8)
					grade4 = 40.0;
				else if (result4 <= 5.8 && result4 > 5.6)
					grade4 = 45.0;
				else if (result4 <= 5.6 && result4 > 5.4)
					grade4 = 50.0;
				else if (result4 <= 5.4 && result4 > 5.3)
					grade4 = 55.0;
				else if (result4 <= 5.3 && result4 > 5.1)
					grade4 = 60.0;
				else if (result4 <= 5.1 && result4 > 5)
					grade4 = 65.0;
				else if (result4 <= 5 && result4 > 4.8)
					grade4 = 70.0;
				else if (result4 <= 4.8 && result4 > 4.6)
					grade4 = 75.0;
				else if (result4 <= 4.6 && result4 > 4.4)
					grade4 = 80.0;
				else if (result4 <= 4.4 && result4 > 4.1)
					grade4 = 85.0;
				else if (result4 <= 4.1 && result4 > 3.6)
					grade4 = 90.0;
				else if (result4 <= 3.6)
					grade4 = 95.0;

				if (result8 < -2.6)
					grade4 = 5.0;
				else if (result8 < -1.7 && result8 >= -2.6)
					grade8 = 10.0;
				else if (result8 < -1 && result8 >= -1.7)
					grade8 = 15.0;
				else if (result8 < -0.4 && result8 >= -1)
					grade8 = 20.0;
				else if (result8 < 0.1 && result8 >= -0.4)
					grade8 = 25.0;
				else if (result8 < 0.6 && result8 >= 0.1)
					grade8 = 30.0;
				else if (result8 < 1.1 && result8 >= 0.6)
					grade8 = 35.0;
				else if (result8 < 1.5 && result8 >= 1.1)
					grade8 = 40.0;
				else if (result8 < 2 && result8 >= 1.5)
					grade8 = 45.0;
				else if (result8 < 2.5 && result8 >= 2)
					grade8 = 50.0;
				else if (result8 < 2.9 && result8 >= 2.5)
					grade8 = 55.0;
				else if (result8 < 3.4 && result8 >= 2.9)
					grade8 = 60.0;
				else if (result8 < 3.9 && result8 >= 3.4)
					grade8 = 65.0;
				else if (result8 < 4.4 && result8 >= 3.9)
					grade8 = 70.0;
				else if (result8 < 5 && result8 >= 4.4)
					grade8 = 75.0;
				else if (result8 < 5.7 && result8 >= 5)
					grade8 = 80.0;
				else if (result8 < 6.6 && result8 >= 5.7)
					grade8 = 85.0;
				else if (result8 < 7.9 && result8 >= 6.6)
					grade8 = 90.0;
				else if (result8 >= 7.9)
					grade8 = 95.0;

				if (result5 <= 16.6)
					grade5 = 10.0;
				else if (result5 <= 19.8 && result5 > 16.6)
					grade5 = 30.0;
				else if (result5 <= 20.6 && result5 > 19.8)
					grade5 = 50.0;
				else if (result5 <= 26.4 && result5 > 20.6)
					grade5 = 70.0;
				else if (result5 > 26.4)
					grade5 = 90.0;

			} else if (age >= 70 && age <= 74) {
				if (result1 <= 7) {
					grade1 = 5.0;
				} else if (result1 == 8) {
					grade1 = 10.0;
				} else if (result1 == 9) {
					grade1 = 15.0;
				} else if (result1 == 10) {
					grade1 = 22.5;
				} else if (result1 == 11) {
					grade1 = 32.5;
				} else if (result1 == 12) {
					grade1 = 40.0;
				} else if (result1 == 13) {
					grade1 = 25.5;
				} else if (result1 == 14) {
					grade1 = 62.5;
				} else if (result1 == 15) {
					grade1 = 72.5;
				} else if (result1 == 16) {
					grade1 = 80.0;
				} else if (result1 == 17) {
					grade1 = 85.0;
				} else if (result1 == 18) {
					grade1 = 90.0;
				} else if (result1 == 19) {
					grade1 = 95.0;
				}

				if (result2 <= 43)
					grade2 = 5.0;
				else if (result2 <= 52 && result2 > 43)
					grade2 = 10.0;
				else if (result2 <= 58 && result2 > 52)
					grade2 = 15.0;
				else if (result2 <= 63 && result2 > 58)
					grade2 = 20.0;
				else if (result2 <= 68 && result2 > 63)
					grade2 = 25.0;
				else if (result2 <= 71 && result2 > 68)
					grade2 = 30.0;
				else if (result2 <= 74 && result2 > 71)
					grade2 = 35.0;
				else if (result2 <= 78 && result2 > 74)
					grade2 = 40.0;
				else if (result2 <= 81 && result2 > 78)
					grade2 = 45.0;
				else if (result2 <= 84 && result2 > 81)
					grade2 = 50.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 55.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 60.0;
				else if (result2 <= 94 && result2 > 90)
					grade2 = 65.0;
				else if (result2 <= 97 && result2 > 94)
					grade2 = 70.0;
				else if (result2 <= 101 && result2 > 97)
					grade2 = 75.0;
				else if (result2 <= 105 && result2 > 101)
					grade2 = 80.0;
				else if (result2 <= 110 && result2 > 105)
					grade2 = 85.0;
				else if (result2 > 116)
					grade2 = 95.0;

				if (result3 >= -7.9 && result3 < -6.6)
					grade3 = 5.0;
				else if (result3 >= -6.6 && result3 < -5.7)
					grade3 = 10.0;
				else if (result3 >= -5.7 && result3 < -4.9)
					grade3 = 15.0;
				else if (result3 >= -4.9 && result3 < -4.2)
					grade3 = 20.0;
				else if (result3 >= -4.2 && result3 < -3.7)
					grade3 = 25.0;
				else if (result3 >= -3.7 && result3 < -3.2)
					grade3 = 30.0;
				else if (result3 >= -3.2 && result3 < -2.6)
					grade3 = 35.0;
				else if (result3 >= -2.6 && result3 < -2.2)
					grade3 = 40.0;
				else if (result3 >= -2.2 && result3 < -1.7)
					grade3 = 45.0;
				else if (result3 >= -1.7 && result3 < -1.2)
					grade3 = 50.0;
				else if (result3 >= -1.2 && result3 < -0.8)
					grade3 = 55.0;
				else if (result3 >= -0.8 && result3 < -0.2)
					grade3 = 60.0;
				else if (result3 >= -0.2 && result3 < 0.3)
					grade3 = 65.0;
				else if (result3 >= 0.3 && result3 < 0.8)
					grade3 = 70.0;
				else if (result3 >= 0.8 && result3 < 1.5)
					grade3 = 75.0;
				else if (result3 >= 1.5 && result3 < 2.3)
					grade3 = 80.0;
				else if (result3 >= 2.3 && result3 < 3.2)
					grade3 = 85.0;
				else if (result3 >= 3.2 && result3 < 4.5)
					grade3 = 90.0;
				else if (result3 >= 4.5)
					grade3 = 95.0;

				if (result4 <= 8.6 && result4 > 8)
					grade4 = 5.0;
				else if (result4 <= 8 && result4 > 7.7)
					grade4 = 10.0;
				else if (result4 <= 7.7 && result4 > 7.3)
					grade4 = 15.0;
				else if (result4 <= 7.3 && result4 > 7.1)
					grade4 = 20.0;
				else if (result4 <= 7.1 && result4 > 6.8)
					grade4 = 25.0;
				else if (result4 <= 6.8 && result4 > 6.6)
					grade4 = 30.0;
				else if (result4 <= 6.6 && result4 > 6.4)
					grade4 = 35.0;
				else if (result4 <= 6.4 && result4 > 6.2)
					grade4 = 40.0;
				else if (result4 <= 6.2 && result4 > 6)
					grade4 = 45.0;
				else if (result4 <= 6 && result4 > 5.8)
					grade4 = 50.0;
				else if (result4 <= 5.8 && result4 > 5.6)
					grade4 = 55.0;
				else if (result4 <= 5.6 && result4 > 5.4)
					grade4 = 60.0;
				else if (result4 <= 5.4 && result4 > 5.2)
					grade4 = 65.0;
				else if (result4 <= 5.2 && result4 > 4.9)
					grade4 = 70.0;
				else if (result4 <= 4.9 && result4 > 4.7)
					grade4 = 75.0;
				else if (result4 <= 4.7 && result4 > 4.3)
					grade4 = 80.0;
				else if (result4 <= 4.3 && result4 > 4)
					grade4 = 85.0;
				else if (result4 <= 4 && result4 > 3.8)
					grade4 = 90.0;
				else if (result4 <= 3.8)
					grade4 = 95.0;

				if (result8 < -3.3)
					grade8 = 5.0;
				else if (result8 < -2.4 && result8 >= -3.3)
					grade8 = 10.0;
				else if (result8 < -1.7 && result8 >= -2.4)
					grade8 = 15.0;
				else if (result8 < -1.1 && result8 >= -1.7)
					grade8 = 20.0;
				else if (result8 < -0.5 && result8 >= -1.1)
					grade8 = 25.0;
				else if (result8 < 0 && result8 >= -0.5)
					grade8 = 30.0;
				else if (result8 < 0.5 && result8 >= 0)
					grade8 = 35.0;
				else if (result8 < 0.9 && result8 >= 0.5)
					grade8 = 40.0;
				else if (result8 < 1.4 && result8 >= 0.9)
					grade8 = 45.0;
				else if (result8 < 1.9 && result8 >= 1.4)
					grade8 = 50.0;
				else if (result8 < 2.3 && result8 >= 1.9)
					grade8 = 55.0;
				else if (result8 < 2.8 && result8 >= 2.3)
					grade8 = 60.0;
				else if (result8 < 3.3 && result8 >= 2.8)
					grade8 = 65.0;
				else if (result8 < 3.9 && result8 >= 3.3)
					grade8 = 70.0;
				else if (result8 < 4.5 && result8 >= 3.9)
					grade8 = 75.0;
				else if (result8 < 5.2 && result8 >= 4.5)
					grade8 = 80.0;
				else if (result8 < 6.1 && result8 >= 5.2)
					grade8 = 85.0;
				else if (result8 < 7.5 && result8 >= 6.1)
					grade8 = 90.0;
				else if (result8 >= 7.5)
					grade8 = 95.0;

				if (result5 <= 16.2)
					grade5 = 10.0;
				else if (result5 <= 19.3 && result5 > 16.2)
					grade5 = 30.0;
				else if (result5 <= 20.1 && result5 > 19.3)
					grade5 = 50.0;
				else if (result5 <= 25.6 && result5 > 20.1)
					grade5 = 70.0;
				else if (result5 > 25.6)
					grade5 = 90.0;

			} else if (age >= 75 && age <= 79) {
				if (result1 <= 6) {
					grade1 = 5.0;
				} else if (result1 == 7) {
					grade1 = 7.5;
				} else if (result1 == 8) {
					grade1 = 10.0;
				} else if (result1 == 9) {
					grade1 = 17.5;
				} else if (result1 == 10) {
					grade1 = 25.0;
				} else if (result1 == 11) {
					grade1 = 32.5;
				} else if (result1 == 12) {
					grade1 = 45.0;
				} else if (result1 == 13) {
					grade1 = 57.5;
				} else if (result1 == 14) {
					grade1 = 67.5;
				} else if (result1 == 15) {
					grade1 = 75.0;
				} else if (result1 == 16) {
					grade1 = 82.5;
				} else if (result1 == 17) {
					grade1 = 90.0;
				} else if (result1 == 18) {
					grade1 = 92.0;
				} else if (result1 == 19) {
					grade1 = 95.0;
				}

				if (result2 <= 45)
					grade2 = 5.0;
				else if (result2 <= 53 && result2 > 45)
					grade2 = 10.0;
				else if (result2 <= 59 && result2 > 53)
					grade2 = 15.0;
				else if (result2 <= 64 && result2 > 59)
					grade2 = 20.0;
				else if (result2 <= 68 && result2 > 64)
					grade2 = 25.0;
				else if (result2 <= 72 && result2 > 68)
					grade2 = 30.0;
				else if (result2 <= 75 && result2 > 72)
					grade2 = 35.0;
				else if (result2 <= 78 && result2 > 75)
					grade2 = 40.0;
				else if (result2 <= 81 && result2 > 78)
					grade2 = 45.0;
				else if (result2 <= 84 && result2 > 81)
					grade2 = 50.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 55.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 60.0;
				else if (result2 <= 93 && result2 > 90)
					grade2 = 65.0;
				else if (result2 <= 96 && result2 > 93)
					grade2 = 70.0;
				else if (result2 <= 100 && result2 > 96)
					grade2 = 75.0;
				else if (result2 <= 104 && result2 > 100)
					grade2 = 80.0;
				else if (result2 <= 109 && result2 > 104)
					grade2 = 85.0;
				else if (result2 <= 115 && result2 > 109)
					grade2 = 90.0;
				else if (result2 > 115)
					grade2 = 95.0;

				if (result4 <= 8.9 && result4 > 8.3)
					grade4 = 5.0;
				else if (result4 <= 8.3 && result4 > 8)
					grade4 = 10.0;
				else if (result4 <= 8 && result4 > 7.6)
					grade4 = 15.0;
				else if (result4 <= 7.6 && result4 > 7.4)
					grade4 = 20.0;
				else if (result4 <= 7.4 && result4 > 7.1)
					grade4 = 25.0;
				else if (result4 <= 7.1 && result4 > 6.9)
					grade4 = 30.0;
				else if (result4 <= 6.9 && result4 > 6.7)
					grade4 = 35.0;
				else if (result4 <= 6.7 && result4 > 6.5)
					grade4 = 40.0;
				else if (result4 <= 6.5 && result4 > 6.3)
					grade4 = 45.0;
				else if (result4 <= 6.3 && result4 > 6.1)
					grade4 = 50.0;
				else if (result4 <= 6.1 && result4 > 5.9)
					grade4 = 55.0;
				else if (result4 <= 5.9 && result4 > 5.7)
					grade4 = 60.0;
				else if (result4 <= 5.7 && result4 > 5.5)
					grade4 = 65.0;
				else if (result4 <= 5.5 && result4 > 5.2)
					grade4 = 70.0;
				else if (result4 <= 5.2 && result4 > 5)
					grade4 = 75.0;
				else if (result4 <= 5 && result4 > 4.6)
					grade4 = 80.0;
				else if (result4 <= 4.6 && result4 > 4.3)
					grade4 = 85.0;
				else if (result4 <= 4.3 && result4 > 4)
					grade4 = 90.0;
				else if (result4 <= 4)
					grade4 = 95.0;

				if (result3 >= -8.8 && result3 < -7.3)
					grade3 = 5.0;
				else if (result3 >= -7.3 && result3 < -6.4)
					grade3 = 10.0;
				else if (result3 >= -6.4 && result3 < -5.5)
					grade3 = 15.0;
				else if (result3 >= -5.5 && result3 < -4.8)
					grade3 = 20.0;
				else if (result3 >= -4.8 && result3 < -4.2)
					grade3 = 25.0;
				else if (result3 >= -4.2 && result3 < -3.7)
					grade3 = 30.0;
				else if (result3 >= -3.7 && result3 < -3.1)
					grade3 = 35.0;
				else if (result3 >= -3.1 && result3 < -2.6)
					grade3 = 40.0;
				else if (result3 >= -2.6 && result3 < -2.1)
					grade3 = 45.0;
				else if (result3 >= -2.1 && result3 < -1.6)
					grade3 = 50.0;
				else if (result3 >= -1.6 && result3 < -1.1)
					grade3 = 55.0;
				else if (result3 >= -1.1 && result3 < -0.5)
					grade3 = 60.0;
				else if (result3 >= -0.5 && result3 < 0)
					grade3 = 65.0;
				else if (result3 >= 0 && result3 < 0.6)
					grade3 = 70.0;
				else if (result3 >= 0.6 && result3 < 1.3)
					grade3 = 75.0;
				else if (result3 >= 1.3 && result3 < 2.2)
					grade3 = 80.0;
				else if (result3 >= 2.2 && result3 < 3.1)
					grade3 = 85.0;
				else if (result3 >= 3.1 && result3 < 4.5)
					grade3 = 90.0;
				else if (result3 >= 4.5)
					grade3 = 95.0;

				if (result8 < -3.7)
					grade4 = 5.0;
				else if (result8 < -2.8 && result8 >= -3.7)
					grade8 = 10.0;
				else if (result8 < -2 && result8 >= -2.8)
					grade8 = 15.0;
				else if (result8 < -1.3 && result8 >= -2)
					grade8 = 20.0;
				else if (result8 < -0.8 && result8 >= -1.3)
					grade8 = 25.0;
				else if (result8 < -0.3 && result8 >= -0.8)
					grade8 = 30.0;
				else if (result8 < 0.2 && result8 >= -0.3)
					grade8 = 35.0;
				else if (result8 < 0.7 && result8 >= 0.2)
					grade8 = 40.0;
				else if (result8 < 1.2 && result8 >= 0.7)
					grade8 = 45.0;
				else if (result8 < 1.7 && result8 >= 1.2)
					grade8 = 50.0;
				else if (result8 < 2.1 && result8 >= 1.7)
					grade8 = 55.0;
				else if (result8 < 2.7 && result8 >= 2.1)
					grade8 = 60.0;
				else if (result8 < 3.2 && result8 >= 2.7)
					grade8 = 65.0;
				else if (result8 < 3.7 && result8 >= 3.2)
					grade8 = 70.0;
				else if (result8 < 4.4 && result8 >= 3.7)
					grade8 = 75.0;
				else if (result8 < 5.2 && result8 >= 4.4)
					grade8 = 80.0;
				else if (result8 < 6.1 && result8 >= 5.2)
					grade8 = 85.0;
				else if (result8 < 7.4 && result8 >= 6.1)
					grade8 = 90.0;
				else if (result8 >= 7.4)
					grade8 = 95.0;

				if (result5 <= 14.1)
					grade5 = 10.0;
				else if (result5 <= 17.1 && result5 > 14.1)
					grade5 = 30.0;
				else if (result5 <= 17.6 && result5 > 17.1)
					grade5 = 50.0;
				else if (result5 <= 22.3 && result5 > 17.6)
					grade5 = 70.0;
				else if (result5 > 22.3)
					grade5 = 90.0;

			} else if (age >= 80 && age <= 84) {
				if (result1 <= 4) {
					grade1 = 5.0;
				} else if (result1 == 5) {
					grade1 = 7.5;
				} else if (result1 == 6) {
					grade1 = 10.0;
				} else if (result1 == 7) {
					grade1 = 15.0;
				} else if (result1 == 8) {
					grade1 = 20.0;
				} else if (result1 == 9) {
					grade1 = 27.5;
				} else if (result1 == 10) {
					grade1 = 37.5;
				} else if (result1 == 11) {
					grade1 = 47.5;
				} else if (result1 == 12) {
					grade1 = 57.5;
				} else if (result1 == 13) {
					grade1 = 70.0;
				} else if (result1 == 14) {
					grade1 = 75.0;
				} else if (result1 == 15) {
					grade1 = 80.0;
				} else if (result1 == 16) {
					grade1 = 85.0;
				} else if (result1 == 17) {
					grade1 = 90.0;
				} else if (result1 == 18) {
					grade1 = 95.0;
				}

				if (result2 <= 37)
					grade2 = 5.0;
				else if (result2 <= 46 && result2 > 37)
					grade2 = 10.0;
				else if (result2 <= 51 && result2 > 46)
					grade2 = 15.0;
				else if (result2 <= 56 && result2 > 51)
					grade2 = 20.0;
				else if (result2 <= 60 && result2 > 56)
					grade2 = 25.0;
				else if (result2 <= 63 && result2 > 60)
					grade2 = 30.0;
				else if (result2 <= 66 && result2 > 63)
					grade2 = 35.0;
				else if (result2 <= 69 && result2 > 66)
					grade2 = 40.0;
				else if (result2 <= 72 && result2 > 69)
					grade2 = 45.0;
				else if (result2 <= 75 && result2 > 72)
					grade2 = 50.0;
				else if (result2 <= 78 && result2 > 75)
					grade2 = 55.0;
				else if (result2 <= 81 && result2 > 78)
					grade2 = 60.0;
				else if (result2 <= 84 && result2 > 81)
					grade2 = 65.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 70.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 75.0;
				else if (result2 <= 94 && result2 > 90)
					grade2 = 80.0;
				else if (result2 <= 99 && result2 > 94)
					grade2 = 85.0;
				else if (result2 <= 104 && result2 > 99)
					grade2 = 90.0;
				else if (result2 > 104)
					grade2 = 95.0;

				if (result3 >= -9.5 && result3 < -8)
					grade3 = 5.0;
				else if (result3 >= -8 && result3 < -7)
					grade3 = 10.0;
				else if (result3 >= -7 && result3 < -6.1)
					grade3 = 15.0;
				else if (result3 >= -6.1 && result3 < -5.4)
					grade3 = 20.0;
				else if (result3 >= -5.4 && result3 < -4.8)
					grade3 = 25.0;
				else if (result3 >= -4.8 && result3 < -4.2)
					grade3 = 30.0;
				else if (result3 >= -4.2 && result3 < -3.7)
					grade3 = 35.0;
				else if (result3 >= -3.7 && result3 < -3.1)
					grade3 = 40.0;
				else if (result3 >= -3.1 && result3 < -2.6)
					grade3 = 45.0;
				else if (result3 >= -2.6 && result3 < -2.1)
					grade3 = 50.0;
				else if (result3 >= -2.1 && result3 < -1.6)
					grade3 = 55.0;
				else if (result3 >= -1.6 && result3 < -1)
					grade3 = 60.0;
				else if (result3 >= -1 && result3 < -0.4)
					grade3 = 65.0;
				else if (result3 >= -0.4 && result3 < 0.2)
					grade3 = 70.0;
				else if (result3 >= 0.2 && result3 < 0.9)
					grade3 = 75.0;
				else if (result3 >= 0.9 && result3 < 1.8)
					grade3 = 80.0;
				else if (result3 >= 2.8 && result3 < 2.8)
					grade3 = 85.0;
				else if (result3 >= 2.8 && result3 < 4.3)
					grade3 = 90.0;
				else if (result3 >= 4.3)
					grade3 = 95.0;

				if (result4 <= 10.8 && result4 > 10)
					grade4 = 5.0;
				else if (result4 <= 10 && result4 > 9.5)
					grade4 = 10.0;
				else if (result4 <= 9.5 && result4 > 9)
					grade4 = 15.0;
				else if (result4 <= 9 && result4 > 8.7)
					grade4 = 20.0;
				else if (result4 <= 8.7 && result4 > 8.3)
					grade4 = 25.0;
				else if (result4 <= 8.3 && result4 > 8.1)
					grade4 = 30.0;
				else if (result4 <= 8.1 && result4 > 7.8)
					grade4 = 35.0;
				else if (result4 <= 7.8 && result4 > 7.5)
					grade4 = 40.0;
				else if (result4 <= 7.5 && result4 > 7.2)
					grade4 = 45.0;
				else if (result4 <= 7.2 && result4 > 6.9)
					grade4 = 50.0;
				else if (result4 <= 6.9 && result4 > 6.7)
					grade4 = 55.0;
				else if (result4 <= 6.7 && result4 > 6.3)
					grade4 = 60.0;
				else if (result4 <= 6.3 && result4 > 6.1)
					grade4 = 65.0;
				else if (result4 <= 6.1 && result4 > 5.7)
					grade4 = 70.0;
				else if (result4 <= 5.7 && result4 > 5.4)
					grade4 = 75.0;
				else if (result4 <= 5.4 && result4 > 4.9)
					grade4 = 80.0;
				else if (result4 <= 4.9 && result4 > 4.4)
					grade4 = 85.0;
				else if (result4 <= 4.4 && result4 > 4)
					grade4 = 90.0;
				else if (result4 <= 4)
					grade4 = 95.0;

				if (result8 < -4.2)
					grade4 = 5.0;
				else if (result8 < -3.3 && result8 >= -4.2)
					grade8 = 10.0;
				else if (result8 < -2.6 && result8 >= -3.3)
					grade8 = 15.0;
				else if (result8 < -2 && result8 >= -2.6)
					grade8 = 20.0;
				else if (result8 < -1.4 && result8 >= -2)
					grade8 = 25.0;
				else if (result8 < -0.9 && result8 >= -1.4)
					grade8 = 30.0;
				else if (result8 < -0.4 && result8 >= -0.9)
					grade8 = 35.0;
				else if (result8 < 0 && result8 >= -0.4)
					grade8 = 40.0;
				else if (result8 < 0.5 && result8 >= 0)
					grade8 = 45.0;
				else if (result8 < 1 && result8 >= 0.5)
					grade8 = 50.0;
				else if (result8 < 1.4 && result8 >= 1)
					grade8 = 55.0;
				else if (result8 < 1.9 && result8 >= 1.4)
					grade8 = 60.0;
				else if (result8 < 2.4 && result8 >= 1.9)
					grade8 = 65.0;
				else if (result8 < 3 && result8 >= 2.4)
					grade8 = 70.0;
				else if (result8 < 3.6 && result8 >= 3)
					grade8 = 75.0;
				else if (result8 < 4.3 && result8 >= 3.6)
					grade8 = 80.0;
				else if (result8 < 5.2 && result8 >= 4.3)
					grade8 = 85.0;
				else if (result8 < 6.6 && result8 >= 5.2)
					grade8 = 90.0;
				else if (result8 >= 6.6)
					grade8 = 95.0;

				if (result5 <= 12.4)
					grade5 = 10.0;
				else if (result5 <= 15.2 && result5 > 12.4)
					grade5 = 30.0;
				else if (result5 <= 16.4 && result5 > 15.2)
					grade5 = 50.0;
				else if (result5 <= 23.1 && result5 > 16.4)
					grade5 = 70.0;
				else if (result5 > 23.1)
					grade5 = 90.0;

			} else if (age >= 85 && age <= 89) {
				if (result1 <= 4) {
					grade1 = 5.0;
				} else if (result1 == 5) {
					grade1 = 10.0;
				} else if (result1 == 6) {
					grade1 = 15.0;
				} else if (result1 == 7) {
					grade1 = 20.0;
				} else if (result1 == 8) {
					grade1 = 27.5;
				} else if (result1 == 9) {
					grade1 = 37.5;
				} else if (result1 == 10) {
					grade1 = 47.5;
				} else if (result1 == 11) {
					grade1 = 57.5;
				} else if (result1 == 12) {
					grade1 = 67.5;
				} else if (result1 == 13) {
					grade1 = 75.0;
				} else if (result1 == 14) {
					grade1 = 82.5;
				} else if (result1 == 15) {
					grade1 = 90.0;
				} else if (result1 == 16) {
					grade1 = 92.5;
				} else if (result1 == 17) {
					grade1 = 95.0;
				}

				if (result2 <= 39)
					grade2 = 5.0;
				else if (result2 <= 42 && result2 > 39)
					grade2 = 10.0;
				else if (result2 <= 47 && result2 > 42)
					grade2 = 15.0;
				else if (result2 <= 52 && result2 > 47)
					grade2 = 20.0;
				else if (result2 <= 55 && result2 > 52)
					grade2 = 25.0;
				else if (result2 <= 59 && result2 > 55)
					grade2 = 30.0;
				else if (result2 <= 61 && result2 > 59)
					grade2 = 35.0;
				else if (result2 <= 64 && result2 > 61)
					grade2 = 40.0;
				else if (result2 <= 67 && result2 > 64)
					grade2 = 45.0;
				else if (result2 <= 70 && result2 > 67)
					grade2 = 50.0;
				else if (result2 <= 73 && result2 > 70)
					grade2 = 55.0;
				else if (result2 <= 76 && result2 > 73)
					grade2 = 60.0;
				else if (result2 <= 79 && result2 > 76)
					grade2 = 65.0;
				else if (result2 <= 81 && result2 > 79)
					grade2 = 70.0;
				else if (result2 <= 85 && result2 > 81)
					grade2 = 75.0;
				else if (result2 <= 88 && result2 > 85)
					grade2 = 80.0;
				else if (result2 <= 93 && result2 > 88)
					grade2 = 85.0;
				else if (result2 <= 98 && result2 > 93)
					grade2 = 90.0;
				else if (result2 > 98)
					grade2 = 95.0;

				if (result3 >= -11.3 && result3 < -9.7)
					grade3 = 5.0;
				else if (result3 >= -9.7 && result3 < -8.6)
					grade3 = 10.0;
				else if (result3 >= -8.6 && result3 < -7.7)
					grade3 = 15.0;
				else if (result3 >= -7.7 && result3 < -6.9)
					grade3 = 20.0;
				else if (result3 >= -6.9 && result3 < -6.2)
					grade3 = 25.0;
				else if (result3 >= -6.2 && result3 < -5.7)
					grade3 = 30.0;
				else if (result3 >= -5.7 && result3 < -5)
					grade3 = 35.0;
				else if (result3 >= -5 && result3 < -4.5)
					grade3 = 40.0;
				else if (result3 >= -4.5 && result3 < -3.9)
					grade3 = 45.0;
				else if (result3 >= -3.9 && result3 < -3.3)
					grade3 = 50.0;
				else if (result3 >= -3.3 && result3 < -2.8)
					grade3 = 55.0;
				else if (result3 >= -2.8 && result3 < -2.1)
					grade3 = 60.0;
				else if (result3 >= -2.1 && result3 < -1.6)
					grade3 = 65.0;
				else if (result3 >= -1.6 && result3 < -0.9)
					grade3 = 70.0;
				else if (result3 >= -0.9 && result3 < -0.1)
					grade3 = 75.0;
				else if (result3 >= -0.1 && result3 < 1.8)
					grade3 = 80.0;
				else if (result3 >= 1.8 && result3 < 1.9)
					grade3 = 85.0;
				else if (result3 >= 1.9 && result3 < 3.5)
					grade3 = 90.0;
				else if (result3 >= 3.5)
					grade3 = 95.0;

				if (result4 <= 12 && result4 > 11.1)
					grade4 = 5.0;
				else if (result4 <= 11.1 && result4 > 10.5)
					grade4 = 10.0;
				else if (result4 <= 10.5 && result4 > 10)
					grade4 = 15.0;
				else if (result4 <= 10 && result4 > 9.6)
					grade4 = 20.0;
				else if (result4 <= 9.6 && result4 > 9.2)
					grade4 = 25.0;
				else if (result4 <= 9.2 && result4 > 8.9)
					grade4 = 30.0;
				else if (result4 <= 8.9 && result4 > 8.5)
					grade4 = 35.0;
				else if (result4 <= 8.5 && result4 > 8.2)
					grade4 = 40.0;
				else if (result4 <= 8.2 && result4 > 7.9)
					grade4 = 45.0;
				else if (result4 <= 7.9 && result4 > 7.6)
					grade4 = 50.0;
				else if (result4 <= 7.6 && result4 > 7.3)
					grade4 = 55.0;
				else if (result4 <= 7.3 && result4 > 6.9)
					grade4 = 60.0;
				else if (result4 <= 6.9 && result4 > 6.6)
					grade4 = 65.0;
				else if (result4 <= 6.6 && result4 > 6.2)
					grade4 = 70.0;
				else if (result4 <= 6.2 && result4 > 5.8)
					grade4 = 75.0;
				else if (result4 <= 5.8 && result4 > 5.3)
					grade4 = 80.0;
				else if (result4 <= 5.3 && result4 > 4.7)
					grade4 = 85.0;
				else if (result4 <= 4.7 && result4 > 4.5)
					grade4 = 90.0;
				else if (result4 <= 4.5)
					grade4 = 95.0;

				if (result8 < -4.8)
					grade4 = 5.0;
				else if (result8 < -3.9 && result8 >= -4.8)
					grade8 = 10.0;
				else if (result8 < -3.2 && result8 >= -3.9)
					grade8 = 15.0;
				else if (result8 < -2.6 && result8 >= -3.2)
					grade8 = 20.0;
				else if (result8 < -2 && result8 >= -2.6)
					grade8 = 25.0;
				else if (result8 < -1.5 && result8 >= -2)
					grade8 = 30.0;
				else if (result8 < -1 && result8 >= -1.5)
					grade8 = 35.0;
				else if (result8 < -0.6 && result8 >= -1)
					grade8 = 40.0;
				else if (result8 < -0.1 && result8 >= -0.6)
					grade8 = 45.0;
				else if (result8 < 0.4 && result8 >= -0.1)
					grade8 = 50.0;
				else if (result8 < 0.8 && result8 >= 0.4)
					grade8 = 55.0;
				else if (result8 < 1.3 && result8 >= 0.8)
					grade8 = 60.0;
				else if (result8 < 1.8 && result8 >= 1.3)
					grade8 = 65.0;
				else if (result8 < 2.4 && result8 >= 1.8)
					grade8 = 70.0;
				else if (result8 < 3 && result8 >= 2.4)
					grade8 = 75.0;
				else if (result8 < 3.7 && result8 >= 3)
					grade8 = 80.0;
				else if (result8 < 4.6 && result8 >= 3.7)
					grade8 = 85.0;
				else if (result8 < 6 && result8 >= 4.6)
					grade8 = 90.0;
				else if (result8 >= 6)
					grade8 = 95.0;

				if (result5 <= 10.2)
					grade5 = 10.0;
				else if (result5 <= 17 && result5 > 10.2)
					grade5 = 30.0;
				else if (result5 <= 17.4 && result5 > 17)
					grade5 = 50.0;
				else if (result5 <= 23.1 && result5 > 17.4)
					grade5 = 70.0;
				else if (result5 > 23.1)
					grade5 = 90.0;

			} else if (age >= 89 && age < 100) {
				if (result1 == 0) {
					grade1 = 5.0;
				} else if (result1 == 1) {
					grade1 = 10.0;
				} else if (result1 == 2) {
					grade1 = 12.5;
				} else if (result1 == 3) {
					grade1 = 15.0;
				} else if (result1 == 4) {
					grade1 = 22.5;
				} else if (result1 == 5) {
					grade1 = 30.0;
				} else if (result1 == 6) {
					grade1 = 35.0;
				} else if (result1 == 7) {
					grade1 = 42.5;
				} else if (result1 == 8) {
					grade1 = 50.0;
				} else if (result1 == 9) {
					grade1 = 62.5;
				} else if (result1 == 10) {
					grade1 = 65.0;
				} else if (result1 == 11) {
					grade1 = 72.5;
				} else if (result1 == 12) {
					grade1 = 80.0;
				} else if (result1 == 13) {
					grade1 = 85.0;
				} else if (result1 == 14) {
					grade1 = 87.5;
				} else if (result1 == 15) {
					grade1 = 90.0;
				} else if (result1 == 16) {
					grade1 = 92.5;
				}

				if (result2 <= 24)
					grade2 = 5.0;
				else if (result2 <= 31 && result2 > 24)
					grade2 = 10.0;
				else if (result2 <= 36 && result2 > 31)
					grade2 = 15.0;
				else if (result2 <= 40 && result2 > 36)
					grade2 = 20.0;
				else if (result2 <= 44 && result2 > 40)
					grade2 = 25.0;
				else if (result2 <= 47 && result2 > 44)
					grade2 = 30.0;
				else if (result2 <= 50 && result2 > 47)
					grade2 = 35.0;
				else if (result2 <= 53 && result2 > 50)
					grade2 = 40.0;
				else if (result2 <= 55 && result2 > 53)
					grade2 = 45.0;
				else if (result2 <= 58 && result2 > 55)
					grade2 = 50.0;
				else if (result2 <= 61 && result2 > 58)
					grade2 = 55.0;
				else if (result2 <= 63 && result2 > 61)
					grade2 = 60.0;
				else if (result2 <= 66 && result2 > 63)
					grade2 = 65.0;
				else if (result2 <= 69 && result2 > 66)
					grade2 = 70.0;
				else if (result2 <= 72 && result2 > 69)
					grade2 = 75.0;
				else if (result2 <= 76 && result2 > 72)
					grade2 = 80.0;
				else if (result2 <= 80 && result2 > 76)
					grade2 = 85.0;
				else if (result2 <= 85 && result2 > 80)
					grade2 = 90.0;
				else if (result2 > 85)
					grade2 = 95.0;

				if (result3 >= -13 && result3 < -11.2)
					grade3 = 5.0;
				else if (result3 >= -11.2 && result3 < -9.9)
					grade3 = 10.0;
				else if (result3 >= -9.9 && result3 < -8.9)
					grade3 = 15.0;
				else if (result3 >= -8.9 && result3 < -8)
					grade3 = 20.0;
				else if (result3 >= -8 && result3 < -7.2)
					grade3 = 25.0;
				else if (result3 >= -7.2 && result3 < -6.5)
					grade3 = 30.0;
				else if (result3 >= -6.5 && result3 < -5.8)
					grade3 = 35.0;
				else if (result3 >= -5.8 && result3 < -5.2)
					grade3 = 40.0;
				else if (result3 >= -5.2 && result3 < -4.5)
					grade3 = 45.0;
				else if (result3 >= -4.5 && result3 < -3.8)
					grade3 = 50.0;
				else if (result3 >= -3.8 && result3 < -3.2)
					grade3 = 55.0;
				else if (result3 >= -3.2 && result3 < -2.5)
					grade3 = 60.0;
				else if (result3 >= -2.5 && result3 < -1.8)
					grade3 = 65.0;
				else if (result3 >= -1.8 && result3 < -1)
					grade3 = 70.0;
				else if (result3 >= -1 && result3 < -0.1)
					grade3 = 75.0;
				else if (result3 >= -0.1 && result3 < 0.9)
					grade3 = 80.0;
				else if (result3 >= 0.9 && result3 < 2.2)
					grade3 = 85.0;
				else if (result3 >= 2.2 && result3 < 3.9)
					grade3 = 90.0;
				else if (result3 >= 3.9)
					grade3 = 95.0;

				if (result4 <= 14.6 && result4 > 13.5)
					grade4 = 5.0;
				else if (result4 <= 13.5 && result4 > 12.7)
					grade4 = 10.0;
				else if (result4 <= 12.7 && result4 > 12.1)
					grade4 = 15.0;
				else if (result4 <= 12.1 && result4 > 11.5)
					grade4 = 20.0;
				else if (result4 <= 11.5 && result4 > 11.1)
					grade4 = 25.0;
				else if (result4 <= 11.1 && result4 > 10.6)
					grade4 = 30.0;
				else if (result4 <= 10.6 && result4 > 10.2)
					grade4 = 35.0;
				else if (result4 <= 10.2 && result4 > 9.8)
					grade4 = 40.0;
				else if (result4 <= 9.8 && result4 > 9.4)
					grade4 = 45.0;
				else if (result4 <= 9.4 && result4 > 9)
					grade4 = 50.0;
				else if (result4 <= 9 && result4 > 8.6)
					grade4 = 55.0;
				else if (result4 <= 8.6 && result4 > 8.2)
					grade4 = 60.0;
				else if (result4 <= 8.2 && result4 > 7.7)
					grade4 = 65.0;
				else if (result4 <= 7.7 && result4 > 7.3)
					grade4 = 70.0;
				else if (result4 <= 7.3 && result4 > 6.7)
					grade4 = 75.0;
				else if (result4 <= 6.7 && result4 > 6.1)
					grade4 = 80.0;
				else if (result4 <= 6.1 && result4 > 5.3)
					grade4 = 85.0;
				else if (result4 <= 5.3 && result4 > 5)
					grade4 = 90.0;
				else if (result4 <= 5)
					grade4 = 95.0;

				if (result8 < -6.8)
					grade4 = 5.0;
				else if (result8 < -5.9 && result8 >= -6.8)
					grade8 = 10.0;
				else if (result8 < -5.1 && result8 >= -5.9)
					grade8 = 15.0;
				else if (result8 < -4.4 && result8 >= -5.1)
					grade8 = 20.0;
				else if (result8 < -3.8 && result8 >= -4.4)
					grade8 = 25.0;
				else if (result8 < -3.3 && result8 >= -3.8)
					grade8 = 30.0;
				else if (result8 < -2.7 && result8 >= -3.3)
					grade8 = 35.0;
				else if (result8 < -2.2 && result8 >= -2.7)
					grade8 = 40.0;
				else if (result8 < -1.7 && result8 >= -2.2)
					grade8 = 45.0;
				else if (result8 < -1.2 && result8 >= -1.7)
					grade8 = 50.0;
				else if (result8 < -0.7 && result8 >= -1.2)
					grade8 = 55.0;
				else if (result8 < -0.1 && result8 >= -0.7)
					grade8 = 60.0;
				else if (result8 < 0.4 && result8 >= -0.1)
					grade8 = 65.0;
				else if (result8 < 1 && result8 >= 0.4)
					grade8 = 70.0;
				else if (result8 < 1.7 && result8 >= 1)
					grade8 = 75.0;
				else if (result8 < 2.5 && result8 >= 1.7)
					grade8 = 80.0;
				else if (result8 < 3.4 && result8 >= 2.5)
					grade8 = 85.0;
				else if (result8 < 4.9 && result8 >= 3.4)
					grade8 = 90.0;
				else if (result8 >= 4.9)
					grade8 = 95.0;

				if (result5 <= 10.2)
					grade5 = 10.0;
				else if (result5 <= 17 && result5 > 10.2)
					grade5 = 30.0;
				else if (result5 <= 17.4 && result5 > 17)
					grade5 = 50.0;
				else if (result5 <= 23.1 && result5 > 17.4)
					grade5 = 70.0;
				else if (result5 > 23.1)
					grade5 = 90.0;

			}
		} else {// 男性

			if (age >= 60 && age < 65) {
				if (result1 <= 9) {
					grade1 = 5.0;
				} else if (result1 == 10) {
					grade1 = 7.5;
				} else if (result1 == 11) {
					grade1 = 10.0;
				} else if (result1 == 12) {
					grade1 = 15.0;
				} else if (result1 == 13) {
					grade1 = 20.0;
				} else if (result1 == 14) {
					grade1 = 25.0;
				} else if (result1 == 15) {
					grade1 = 37.5;
				} else if (result1 == 16) {
					grade1 = 47.5;
				} else if (result1 == 17) {
					grade1 = 57.5;
				} else if (result1 == 18) {
					grade1 = 65.0;
				} else if (result1 == 19) {
					grade1 = 72.5;
				} else if (result1 == 20) {
					grade1 = 80.0;
				} else if (result1 == 21) {
					grade1 = 85.0;
				} else if (result1 == 22) {
					grade1 = 90.0;
				} else if (result1 == 23) {
					grade1 = 95.0;
				}

				if (result2 <= 67)
					grade2 = 5.0;
				else if (result2 <= 74 && result2 > 67)
					grade2 = 10.0;
				else if (result2 <= 79 && result2 > 74)
					grade2 = 15.0;
				else if (result2 <= 83 && result2 > 79)
					grade2 = 20.0;
				else if (result2 <= 87 && result2 > 83)
					grade2 = 25.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 30.0;
				else if (result2 <= 93 && result2 > 90)
					grade2 = 35.0;
				else if (result2 <= 96 && result2 > 93)
					grade2 = 40.0;
				else if (result2 <= 98 && result2 > 96)
					grade2 = 45.0;
				else if (result2 <= 101 && result2 > 98)
					grade2 = 50.0;
				else if (result2 <= 104 && result2 > 101)
					grade2 = 55.0;
				else if (result2 <= 106 && result2 > 104)
					grade2 = 60.0;
				else if (result2 <= 109 && result2 > 106)
					grade2 = 65.0;
				else if (result2 <= 112 && result2 > 109)
					grade2 = 70.0;
				else if (result2 <= 115 && result2 > 112)
					grade2 = 75.0;
				else if (result2 <= 119 && result2 > 115)
					grade2 = 80.0;
				else if (result2 <= 123 && result2 > 119)
					grade2 = 85.0;
				else if (result2 <= 128 && result2 > 123)
					grade2 = 90.0;
				else if (result2 > 128)
					grade2 = 95.0;

				if (result3 >= -11.3 && result3 < -9.5)
					grade3 = 5.0;
				else if (result3 >= -9.5 && result3 < -8.4)
					grade3 = 10.0;
				else if (result3 >= -8.4 && result3 < -7.4)
					grade3 = 15.0;
				else if (result3 >= -7.4 && result3 < -6.6)
					grade3 = 20.0;
				else if (result3 >= -6.6 && result3 < -5.9)
					grade3 = 25.0;
				else if (result3 >= -5.9 && result3 < -5.3)
					grade3 = 30.0;
				else if (result3 >= -5.3 && result3 < -4.6)
					grade3 = 35.0;
				else if (result3 >= -4.6 && result3 < -4)
					grade3 = 40.0;
				else if (result3 >= -4 && result3 < -3.4)
					grade3 = 45.0;
				else if (result3 >= -3.4 && result3 < -2.8)
					grade3 = 50.0;
				else if (result3 >= -2.8 && result3 < -2.2)
					grade3 = 55.0;
				else if (result3 >= -2.2 && result3 < -1.5)
					grade3 = 60.0;
				else if (result3 >= -1.5 && result3 < -0.9)
					grade3 = 65.0;
				else if (result3 >= -0.9 && result3 < -0.2)
					grade3 = 70.0;
				else if (result3 >= -0.2 && result3 < 0.6)
					grade3 = 75.0;
				else if (result3 >= 0.6 && result3 < 1.6)
					grade3 = 80.0;
				else if (result3 >= 1.6 && result3 < 2.7)
					grade3 = 85.0;
				else if (result3 >= 2.7 && result3 < 4.5)
					grade3 = 85.0;
				else if (result3 > 4.5)
					grade3 = 95.0;

				if (result8 < -5.5)
					grade4 = 5.0;
				else if (result8 < -4.4 && result8 >= -5.5)
					grade8 = 10.0;
				else if (result8 < -3.4 && result8 >= -4.4)
					grade8 = 15.0;
				else if (result8 < -2.6 && result8 >= -3.4)
					grade8 = 20.0;
				else if (result8 < -1.9 && result8 >= -2.6)
					grade8 = 25.0;
				else if (result8 < -1.3 && result8 >= -1.9)
					grade8 = 30.0;
				else if (result8 < -0.6 && result8 >= -1.3)
					grade8 = 35.0;
				else if (result8 < 0 && result8 >= -0.6)
					grade8 = 40.0;
				else if (result8 < 0.6 && result8 >= 0)
					grade8 = 45.0;
				else if (result8 < 1.2 && result8 >= 0.6)
					grade8 = 50.0;
				else if (result8 < 1.8 && result8 >= 1.2)
					grade8 = 55.0;
				else if (result8 < 2.5 && result8 >= 1.8)
					grade8 = 60.0;
				else if (result8 < 3.1 && result8 >= 2.5)
					grade8 = 65.0;
				else if (result8 < 3.8 && result8 >= 3.1)
					grade8 = 70.0;
				else if (result8 < 4.6 && result8 >= 3.8)
					grade8 = 75.0;
				else if (result8 < 5.6 && result8 >= 4.6)
					grade8 = 80.0;
				else if (result8 < 6.7 && result8 >= 5.6)
					grade8 = 85.0;
				else if (result8 < 8.5 && result8 >= 6.7)
					grade8 = 90.0;
				else if (result8 >= 8.5)
					grade8 = 95.0;

				if (result4 <= 6.8 && result4 > 6.4)
					grade4 = 5.0;
				else if (result4 <= 6.4 && result4 > 6.1)
					grade4 = 10.0;
				else if (result4 <= 6.1 && result4 > 5.8)
					grade4 = 15.0;
				else if (result4 <= 5.8 && result4 > 5.6)
					grade4 = 20.0;
				else if (result4 >= 5.6 && result4 > 5.4)
					grade4 = 25.0;
				else if (result4 <= 5.4 && result4 > 5.2)
					grade4 = 30.0;
				else if (result4 <= 5.2 && result4 > 5.0)
					grade4 = 35.0;
				else if (result4 <= 5.0 && result4 > 4.9)
					grade4 = 40.0;
				else if (result4 <= 4.9 && result4 > 4.7)
					grade4 = 45.0;
				else if (result4 <= 4.7 && result4 > 4.5)
					grade4 = 50.0;
				else if (result4 <= 4.5 && result4 > 4.4)
					grade4 = 55.0;
				else if (result4 <= 4.4 && result4 > 4.2)
					grade4 = 60.0;
				else if (result4 <= 4.2 && result4 > 4.0)
					grade4 = 65.0;
				else if (result4 <= 4.0 && result4 > 3.8)
					grade4 = 70.0;
				else if (result4 <= 3.8 && result4 > 3.6)
					grade4 = 75.0;
				else if (result4 <= 3.6 && result4 > 3.3)
					grade4 = 80.0;
				else if (result4 <= 3.3 && result4 > 3)
					grade4 = 85.0;
				else if (result4 <= 3)
					grade4 = 90.0;

				if (result5 <= 21.9)
					grade5 = 10.0;
				else if (result5 <= 30.3 && result5 > 21.9)
					grade5 = 30.0;
				else if (result5 <= 31.2 && result5 > 30.3)
					grade5 = 50.0;
				else if (result5 <= 40 && result5 > 31.2)
					grade5 = 70.0;
				else if (result5 > 40)
					grade5 = 90.0;

			} else if (age >= 65 && age <= 69) {
				if (result1 <= 8) {
					grade1 = 5.0;
				} else if (result1 == 9) {
					grade1 = 10.0;
				} else if (result1 == 10) {
					grade1 = 12.5;
				} else if (result1 == 11) {
					grade1 = 17.5;
				} else if (result1 == 12) {
					grade1 = 25.0;
				} else if (result1 == 13) {
					grade1 = 32.5;
				} else if (result1 == 14) {
					grade1 = 40.0;
				} else if (result1 == 15) {
					grade1 = 47.5;
				} else if (result1 == 16) {
					grade1 = 57.5;
				} else if (result1 == 17) {
					grade1 = 65.0;
				} else if (result1 == 18) {
					grade1 = 72.5;
				} else if (result1 == 19) {
					grade1 = 80.0;
				} else if (result1 == 20) {
					grade1 = 85.0;
				} else if (result1 == 21) {
					grade1 = 90.0;
				} else if (result1 == 22) {
					grade1 = 92.5;
				} else if (result1 == 23) {
					grade1 = 95.0;
				}

				if (result2 <= 67)
					grade2 = 5.0;
				else if (result2 <= 72 && result2 > 67)
					grade2 = 10.0;
				else if (result2 <= 77 && result2 > 72)
					grade2 = 15.0;
				else if (result2 <= 82 && result2 > 77)
					grade2 = 20.0;
				else if (result2 <= 86 && result2 > 82)
					grade2 = 25.0;
				else if (result2 <= 89 && result2 > 86)
					grade2 = 30.0;
				else if (result2 <= 92 && result2 > 89)
					grade2 = 35.0;
				else if (result2 <= 95 && result2 > 92)
					grade2 = 40.0;
				else if (result2 <= 98 && result2 > 95)
					grade2 = 45.0;
				else if (result2 <= 101 && result2 > 98)
					grade2 = 50.0;
				else if (result2 <= 104 && result2 > 101)
					grade2 = 55.0;
				else if (result2 <= 107 && result2 > 104)
					grade2 = 60.0;
				else if (result2 <= 110 && result2 > 107)
					grade2 = 65.0;
				else if (result2 <= 113 && result2 > 110)
					grade2 = 70.0;
				else if (result2 <= 116 && result2 > 113)
					grade2 = 75.0;
				else if (result2 <= 120 && result2 > 116)
					grade2 = 80.0;
				else if (result2 <= 125 && result2 > 120)
					grade2 = 85.0;
				else if (result2 <= 130 && result2 > 125)
					grade2 = 90.0;
				else if (result2 > 130)
					grade2 = 95.0;

				if (result3 >= -12.1 && result3 < -10.4)
					grade3 = 5.0;
				else if (result3 >= -10.4 && result3 < -9.2)
					grade3 = 10.0;
				else if (result3 >= -9.2 && result3 < -8.2)
					grade3 = 15.0;
				else if (result3 >= -8.2 && result3 < -7.4)
					grade3 = 20.0;
				else if (result3 >= -7.4 && result3 < -6.6)
					grade3 = 25.0;
				else if (result3 >= -6.6 && result3 < -6)
					grade3 = 30.0;
				else if (result3 >= -6 && result3 < -5.3)
					grade3 = 35.0;
				else if (result3 >= -5.3 && result3 < -4.7)
					grade3 = 40.0;
				else if (result3 >= -4.7 && result3 < -4.1)
					grade3 = 45.0;
				else if (result3 >= -4.1 && result3 < -3.5)
					grade3 = 50.0;
				else if (result3 >= -3.5 && result3 < -2.9)
					grade3 = 55.0;
				else if (result3 >= -2.9 && result3 < -2.2)
					grade3 = 60.0;
				else if (result3 >= -2.2 && result3 < -1.6)
					grade3 = 65.0;
				else if (result3 >= -1.6 && result3 < -0.8)
					grade3 = 70.0;
				else if (result3 >= -0.8 && result3 < 0)
					grade3 = 75.0;
				else if (result3 >= 0 && result3 < 1)
					grade3 = 80.0;
				else if (result3 >= 1 && result3 < 2.2)
					grade3 = 85.0;
				else if (result3 >= 2.2 && result3 < 3.9)
					grade3 = 90.0;
				else if (result3 >= 3.9)
					grade3 = 95.0;

				if (result8 < -7.5)
					grade4 = 5.0;
				else if (result8 < -5.9 && result8 >= -7.5)
					grade8 = 10.0;
				else if (result8 < -4.8 && result8 >= -5.9)
					grade8 = 15.0;
				else if (result8 < -3.9 && result8 >= -4.8)
					grade8 = 20.0;
				else if (result8 < -3.1 && result8 >= -3.9)
					grade8 = 25.0;
				else if (result8 < -2.4 && result8 >= -3.1)
					grade8 = 30.0;
				else if (result8 < -1.8 && result8 >= -2.4)
					grade8 = 35.0;
				else if (result8 < -1.1 && result8 >= -1.8)
					grade8 = 40.0;
				else if (result8 < -0.6 && result8 >= -1.1)
					grade8 = 45.0;
				else if (result8 < 0 && result8 >= -0.6)
					grade8 = 50.0;
				else if (result8 < 1.1 && result8 >= 0)
					grade8 = 55.0;
				else if (result8 < 1.8 && result8 >= 1.1)
					grade8 = 60.0;
				else if (result8 < 2.4 && result8 >= 1.8)
					grade8 = 65.0;
				else if (result8 < 3.1 && result8 > 2.4)
					grade8 = 70.0;
				else if (result8 < 3.9 && result8 >= 3.1)
					grade8 = 75.0;
				else if (result8 < 4.8 && result8 >= 3.9)
					grade8 = 80.0;
				else if (result8 < 5.9 && result8 >= 4.8)
					grade8 = 85.0;
				else if (result8 < 7.5 && result8 >= 5.9)
					grade8 = 90.0;
				else if (result8 >= 7.5)
					grade8 = 95.0;

				if (result4 <= 7.1 && result3 > 6.6)
					grade4 = 5.0;
				else if (result4 <= 6.6 && result4 > 6.3)
					grade4 = 10.0;
				else if (result4 <= 6.3 && result4 > 6.1)
					grade4 = 15.0;
				else if (result4 <= 6.1 && result4 > 5.9)
					grade4 = 20.0;
				else if (result4 <= 5.9 && result4 > 5.7)
					grade4 = 25.0;
				else if (result4 <= 5.7 && result4 > 5.6)
					grade4 = 30.0;
				else if (result4 <= 5.6 && result4 > 5.4)
					grade4 = 35.0;
				else if (result4 <= 5.4 && result4 > 5.3)
					grade4 = 40.0;
				else if (result4 <= 5.3 && result4 > 5.1)
					grade4 = 45.0;
				else if (result4 <= 5.1 && result4 > 4.9)
					grade4 = 50.0;
				else if (result4 <= 4.9 && result4 > 4.8)
					grade4 = 55.0;
				else if (result4 <= 4.8 && result4 > 4.6)
					grade4 = 60.0;
				else if (result4 <= 4.6 && result4 > 4.5)
					grade4 = 65.0;
				else if (result4 <= 4.5 && result4 > 4.3)
					grade4 = 70.0;
				else if (result4 <= 4.3 && result4 > 4.1)
					grade4 = 75.0;
				else if (result4 <= 4.1 && result4 > 3.9)
					grade4 = 80.0;
				else if (result4 <= 3.9 && result4 > 3.6)
					grade4 = 85.0;
				else if (result4 <= 3.6 && result4 > 3.1)
					grade4 = 90.0;
				else if (result4 <= 3.1)
					grade4 = 95.0;

				if (result5 <= 27)
					grade5 = 10.0;
				else if (result5 <= 30.9 && result5 > 27)
					grade5 = 30.0;
				else if (result5 <= 32.1 && result5 > 30.9)
					grade5 = 50.0;
				else if (result5 <= 39.6 && result5 > 32.1)
					grade5 = 70.0;
				else if (result5 > 39.6)
					grade5 = 90.0;

			} else if (age >= 70 && age <= 74) {
				if (result1 <= 8) {
					grade1 = 5.0;
				} else if (result1 == 9) {
					grade1 = 10.0;
				} else if (result1 == 10) {
					grade1 = 15.0;
				} else if (result1 == 11) {
					grade1 = 20.0;
				} else if (result1 == 12) {
					grade1 = 27.5;
				} else if (result1 == 13) {
					grade1 = 37.5;
				} else if (result1 == 14) {
					grade1 = 47.5;
				} else if (result1 == 15) {
					grade1 = 55.0;
				} else if (result1 == 16) {
					grade1 = 62.5;
				} else if (result1 == 17) {
					grade1 = 72.5;
				} else if (result1 == 18) {
					grade1 = 80.0;
				} else if (result1 == 19) {
					grade1 = 85.0;
				} else if (result1 == 20) {
					grade1 = 90.0;
				} else if (result1 == 21) {
					grade1 = 95.0;
				}

				if (result2 <= 67)
					grade2 = 5.0;
				else if (result2 <= 66 && result2 > 67)
					grade2 = 10.0;
				else if (result2 <= 71 && result2 > 66)
					grade2 = 15.0;
				else if (result2 <= 76 && result2 > 71)
					grade2 = 20.0;
				else if (result2 <= 80 && result2 > 76)
					grade2 = 25.0;
				else if (result2 <= 83 && result2 > 80)
					grade2 = 30.0;
				else if (result2 <= 86 && result2 > 83)
					grade2 = 35.0;
				else if (result2 <= 89 && result2 > 86)
					grade2 = 40.0;
				else if (result2 <= 92 && result2 > 89)
					grade2 = 45.0;
				else if (result2 <= 95 && result2 > 92)
					grade2 = 50.0;
				else if (result2 <= 98 && result2 > 95)
					grade2 = 55.0;
				else if (result2 <= 101 && result2 > 98)
					grade2 = 60.0;
				else if (result2 <= 104 && result2 > 101)
					grade2 = 65.0;
				else if (result2 <= 107 && result2 > 104)
					grade2 = 70.0;
				else if (result2 <= 110 && result2 > 107)
					grade2 = 75.0;
				else if (result2 <= 114 && result2 > 110)
					grade2 = 80.0;
				else if (result2 <= 119 && result2 > 114)
					grade2 = 85.0;
				else if (result2 <= 124 && result2 > 119)
					grade2 = 90.0;
				else if (result2 > 124)
					grade2 = 95.0;

				if (result3 >= -12.5 && result3 < -10.8)
					grade3 = 5.0;
				else if (result3 >= -10.8 && result3 < -9.6)
					grade3 = 10.0;
				else if (result3 >= -9.6 && result3 < -8.6)
					grade3 = 15.0;
				else if (result3 >= -8.6 && result3 < -7.8)
					grade3 = 20.0;
				else if (result3 >= -7.8 && result3 < -7)
					grade3 = 25.0;
				else if (result3 >= -7 && result3 < -6.4)
					grade3 = 30.0;
				else if (result3 > -6.4 && result3 < -5.7)
					grade3 = 35.0;
				else if (result3 >= -5.7 && result3 < -5.1)
					grade3 = 40.0;
				else if (result3 >= -5.1 && result3 < -4.5)
					grade3 = 45.0;
				else if (result3 >= -4.5 && result3 < -3.9)
					grade3 = 50.0;
				else if (result3 >= -3.9 && result3 < -3.3)
					grade3 = 55.0;
				else if (result3 >= -3.3 && result3 < -2.6)
					grade3 = 60.0;
				else if (result3 >= -2.6 && result3 < -2)
					grade3 = 65.0;
				else if (result3 >= -2 && result3 < -1.2)
					grade3 = 70.0;
				else if (result3 >= -1.2 && result3 < -0.4)
					grade3 = 75.0;
				else if (result3 >= -0.4 && result3 < 0.6)
					grade3 = 80.0;
				else if (result3 >= 0.6 && result3 < 1.8)
					grade3 = 85.0;
				else if (result3 >= 1.8 && result3 < 3.5)
					grade3 = 90.0;
				else if (result3 >= 3.5)
					grade3 = 95.0;

				if (result8 < -5.9)
					grade8 = 5.0;
				else if (result8 < -4.8 && result8 >= -5.9)
					grade8 = 10.0;
				else if (result8 < -3.9 && result8 >= -4.8)
					grade8 = 15.0;
				else if (result8 < -3.1 && result8 >= -3.9)
					grade8 = 20.0;
				else if (result8 < -2.4 && result8 >= -3.1)
					grade8 = 25.0;
				else if (result8 < -1.8 && result8 >= -2.4)
					grade8 = 30.0;
				else if (result8 < -1.2 && result8 >= -1.8)
					grade8 = 35.0;
				else if (result8 < -0.6 && result8 >= -1.2)
					grade8 = 40.0;
				else if (result8 < 0 && result8 >= -0.6)
					grade8 = 45.0;
				else if (result8 < 0.6 && result8 >= 0)
					grade8 = 50.0;
				else if (result8 < 1.1 && result8 >= 0.6)
					grade8 = 55.0;
				else if (result8 < 1.8 && result8 >= 1.1)
					grade8 = 60.0;
				else if (result8 < 2.4 && result8 >= 1.8)
					grade8 = 65.0;
				else if (result8 < 3 && result8 >= 2.4)
					grade8 = 70.0;
				else if (result8 < 3.8 && result8 >= 3)
					grade8 = 75.0;
				else if (result8 < 4.7 && result8 >= 3.8)
					grade8 = 80.0;
				else if (result8 < -5.9 && result8 >= 4.7)
					grade8 = 85.0;
				else if (result8 < 7.5 && result8 >= -5.9)
					grade8 = 90.0;
				else if (result8 > 7.5)
					grade8 = 95.0;

				if (result4 <= 7.4 && result4 > 7)
					grade4 = 5.0;
				else if (result4 <= 7 && result4 > 6.7)
					grade4 = 10.0;
				else if (result4 <= 6.7 && result4 > 6.4)
					grade4 = 15.0;
				else if (result4 <= 6.4 && result4 > 6.2)
					grade4 = 20.0;
				else if (result4 <= 6.2 && result4 > 6)
					grade4 = 25.0;
				else if (result4 <= 6 && result4 > 5.8)
					grade4 = 30.0;
				else if (result4 <= 5.8 && result4 > 5.6)
					grade4 = 35.0;
				else if (result4 <= 5.6 && result4 > 5.5)
					grade4 = 40.0;
				else if (result4 <= 5.5 && result4 > 5.3)
					grade4 = 45.0;
				else if (result4 <= 5.3 && result4 > 5.1)
					grade4 = 50.0;
				else if (result4 <= 5.1 && result4 > 5)
					grade4 = 55.0;
				else if (result4 <= 5 && result4 > 4.8)
					grade4 = 60.0;
				else if (result4 <= 4.8 && result4 > 4.6)
					grade4 = 65.0;
				else if (result4 <= 4.6 && result4 > 4.4)
					grade4 = 70.0;
				else if (result4 <= 4.4 && result4 > 4.2)
					grade4 = 75.0;
				else if (result4 <= 4.2 && result4 > 3.9)
					grade4 = 80.0;
				else if (result4 <= 3.9 && result4 > 3.6)
					grade4 = 85.0;
				else if (result4 <= 3.6 && result4 > 3.2)
					grade4 = 90.0;
				else if (result4 <= 3.2)
					grade4 = 95.0;

				if (result5 <= 23.9)
					grade5 = 10.0;
				else if (result5 <= 28.7 && result5 > 23.9)
					grade5 = 30.0;
				else if (result5 <= 30 && result5 > 28.7)
					grade5 = 50.0;
				else if (result5 <= 38.4 && result5 > 30)
					grade5 = 70.0;
				else if (result5 > 38.4)
					grade5 = 90.0;

			} else if (age >= 75 && age <= 79) {
				if (result1 == 7) {
					grade1 = 5.0;
				} else if (result1 == 8) {
					grade1 = 10.0;
				} else if (result1 == 9) {
					grade1 = 12.5;
				} else if (result1 == 10) {
					grade1 = 17.5;
				} else if (result1 == 11) {
					grade1 = 25.0;
				} else if (result1 == 12) {
					grade1 = 32.5;
				} else if (result1 == 13) {
					grade1 = 42.5;
				} else if (result1 == 14) {
					grade1 = 50.0;
				} else if (result1 == 15) {
					grade1 = 57.5;
				} else if (result1 == 16) {
					grade1 = 67.5;
				} else if (result1 == 17) {
					grade1 = 75.0;
				} else if (result1 == 18) {
					grade1 = 82.5;
				} else if (result1 == 19) {
					grade1 = 87.5;
				} else if (result1 == 20) {
					grade1 = 90.0;
				} else if (result1 == 21) {
					grade1 = 95.5;
				}

				if (result2 <= 47)
					grade2 = 5.0;
				else if (result2 <= 56 && result2 > 47)
					grade2 = 10.0;
				else if (result2 <= 63 && result2 > 56)
					grade2 = 15.0;
				else if (result2 <= 68 && result2 > 63)
					grade2 = 20.0;
				else if (result2 <= 73 && result2 > 68)
					grade2 = 25.0;
				else if (result2 <= 77 && result2 > 73)
					grade2 = 30.0;
				else if (result2 <= 80 && result2 > 77)
					grade2 = 35.0;
				else if (result2 <= 84 && result2 > 80)
					grade2 = 40.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 45.0;
				else if (result2 <= 91 && result2 > 87)
					grade2 = 50.0;
				else if (result2 <= 95 && result2 > 91)
					grade2 = 55.0;
				else if (result2 <= 98 && result2 > 95)
					grade2 = 60.0;
				else if (result2 <= 102 && result2 > 98)
					grade2 = 65.0;
				else if (result2 <= 105 && result2 > 102)
					grade2 = 70.0;
				else if (result2 <= 109 && result2 > 105)
					grade2 = 75.0;
				else if (result2 <= 114 && result2 > 109)
					grade2 = 80.0;
				else if (result2 <= 119 && result2 > 114)
					grade2 = 85.0;
				else if (result2 <= 126 && result2 > 119)
					grade2 = 90.0;
				else if (result2 > 126)
					grade2 = 95.0;

				if (result3 >= -14 && result3 < -12.1)
					grade3 = 5.0;
				else if (result3 >= -12.1 && result3 < -10.9)
					grade3 = 10.0;
				else if (result3 >= -10.9 && result3 < -9.9)
					grade3 = 15.0;
				else if (result3 >= -9.9 && result3 < -9)
					grade3 = 20.0;
				else if (result3 >= -9 && result3 < -8.3)
					grade3 = 25.0;
				else if (result3 >= -8.3 && result3 < -7.6)
					grade3 = 30.0;
				else if (result3 >= -7.6 && result3 < -6.9)
					grade3 = 35.0;
				else if (result3 >= -6.9 && result3 < -6.3)
					grade3 = 40.0;
				else if (result3 >= -6.3 && result3 < -5.6)
					grade3 = 45.0;
				else if (result3 >= -5.6 && result3 < -4.9)
					grade3 = 50.0;
				else if (result3 >= -4.9 && result3 < -4.3)
					grade3 = 55.0;
				else if (result3 >= -4.3 && result3 < -3.6)
					grade3 = 60.0;
				else if (result3 >= -3.6 && result3 < -2.9)
					grade3 = 65.0;
				else if (result3 >= -2.9 && result3 < -2.2)
					grade3 = 70.0;
				else if (result3 >= -2.2 && result3 < -1.3)
					grade3 = 75.0;
				else if (result3 >= -1.3 && result3 < -0.3)
					grade3 = 80.0;
				else if (result3 >= -0.3 && result3 < 0.9)
					grade3 = 85.0;
				else if (result3 >= 0.9 && result3 < 2.8)
					grade3 = 90.0;
				else if (result3 >= 2.8)
					grade3 = 95.0;

				if (result4 <= 9 && result4 < 8.3)
					grade4 = 5.0;
				else if (result4 <= 8.3 && result4 > 7.9)
					grade4 = 10.0;
				else if (result4 <= 7.9 && result4 > 7.5)
					grade4 = 15.0;
				else if (result4 <= 7.5 && result4 > 7.2)
					grade4 = 20.0;
				else if (result4 <= 7.2 && result4 > 6.9)
					grade4 = 25.0;
				else if (result4 <= 6.9 && result4 > 6.6)
					grade4 = 30.0;
				else if (result4 <= 6.6 && result4 > 6.4)
					grade4 = 35.0;
				else if (result4 <= 6.4 && result4 > 6.1)
					grade4 = 40.0;
				else if (result4 <= 6.1 && result4 > 5.9)
					grade4 = 45.0;
				else if (result4 <= 5.9 && result4 > 5.7)
					grade4 = 50.0;
				else if (result4 <= 5.7 && result4 > 5.4)
					grade4 = 55.0;
				else if (result4 <= 5.4 && result4 > 5.2)
					grade4 = 60.0;
				else if (result4 <= 5.2 && result4 > 4.9)
					grade4 = 65.0;
				else if (result4 <= 4.9 && result4 > 4.6)
					grade4 = 70.0;
				else if (result4 <= 4.6 && result4 > 4.3)
					grade4 = 75.0;
				else if (result4 <= 4.3 && result4 > 3.9)
					grade4 = 80.0;
				else if (result4 <= 3.9 && result4 > 3.5)
					grade4 = 85.0;
				else if (result4 <= 3.5 && result4 > 3.3)
					grade4 = 90.0;
				else if (result4 <= 3.3)
					grade4 = 95.0;

				if (result8 < -7.1)
					grade4 = 5.0;
				else if (result8 < -6 && result8 >= -7.1)
					grade8 = 10.0;
				else if (result8 < -5 && result8 >= -6)
					grade8 = 15.0;
				else if (result8 < -4.2 && result8 >= -5)
					grade8 = 20.0;
				else if (result8 < -3.5 && result8 >= -4.2)
					grade8 = 25.0;
				else if (result8 < -2.9 && result8 >= -3.5)
					grade8 = 30.0;
				else if (result8 < -2.3 && result8 >= -2.9)
					grade8 = 35.0;
				else if (result8 < -1.7 && result8 >= -2.3)
					grade8 = 40.0;
				else if (result8 < -1.1 && result8 >= -1.7)
					grade8 = 45.0;
				else if (result8 < -0.5 && result8 >= -1.1)
					grade8 = 50.0;
				else if (result8 < 0.1 && result8 >= -0.5)
					grade8 = 55.0;
				else if (result8 < 0.7 && result8 >= 0.1)
					grade8 = 60.0;
				else if (result8 < 1.3 && result8 >= 0.7)
					grade8 = 65.0;
				else if (result8 < 2 && result8 >= 1.3)
					grade8 = 70.0;
				else if (result8 < 2.8 && result8 >= 2)
					grade8 = 75.0;
				else if (result8 < 3.8 && result8 >= 2.8)
					grade8 = 80.0;
				else if (result8 < 4.9 && result8 >= 3.8)
					grade8 = 85.0;
				else if (result8 < 6.6 && result8 >= 4.9)
					grade8 = 90.0;
				else if (result8 >= 6.6)
					grade8 = 95.0;

				if (result5 <= 19.2)
					grade5 = 10.0;
				else if (result5 <= 24.8 && result5 > 19.2)
					grade5 = 30.0;
				else if (result5 <= 25.8 && result5 > 24.8)
					grade5 = 50.0;
				else if (result5 <= 33.7 && result5 > 25.8)
					grade5 = 70.0;
				else if (result5 > 33.7)
					grade5 = 90.0;

			} else if (age >= 80 && age <= 84) {
				if (result1 <= 6) {
					grade1 = 5.0;
				} else if (result1 == 7) {
					grade1 = 10.0;
				} else if (result1 == 8) {
					grade1 = 15.0;
				} else if (result1 == 9) {
					grade1 = 20.0;
				} else if (result1 == 10) {
					grade1 = 27.5;
				} else if (result1 == 11) {
					grade1 = 37.5;
				} else if (result1 == 12) {
					grade1 = 47.5;
				} else if (result1 == 13) {
					grade1 = 57.5;
				} else if (result1 == 14) {
					grade1 = 67.5;
				} else if (result1 == 15) {
					grade1 = 75.0;
				} else if (result1 == 16) {
					grade1 = 82.5;
				} else if (result1 == 17) {
					grade1 = 90.0;
				} else if (result1 == 18) {
					grade1 = 92.5;
				} else if (result1 == 19) {
					grade1 = 95.0;
				}

				if (result2 <= 48)
					grade2 = 5.0;
				else if (result2 <= 56 && result2 > 48)
					grade2 = 10.0;
				else if (result2 <= 62 && result2 > 56)
					grade2 = 15.0;
				else if (result2 <= 67 && result2 > 62)
					grade2 = 20.0;
				else if (result2 <= 71 && result2 > 67)
					grade2 = 25.0;
				else if (result2 <= 75 && result2 > 71)
					grade2 = 30.0;
				else if (result2 <= 78 && result2 > 75)
					grade2 = 35.0;
				else if (result2 <= 81 && result2 > 78)
					grade2 = 40.0;
				else if (result2 <= 84 && result2 > 81)
					grade2 = 45.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 50.0;
				else if (result2 <= 90 && result2 > 87)
					grade2 = 55.0;
				else if (result2 <= 93 && result2 > 90)
					grade2 = 60.0;
				else if (result2 <= 96 && result2 > 93)
					grade2 = 65.0;
				else if (result2 <= 99 && result2 > 96)
					grade2 = 70.0;
				else if (result2 <= 103 && result2 > 99)
					grade2 = 75.0;
				else if (result2 <= 107 && result2 > 103)
					grade2 = 80.0;
				else if (result2 <= 112 && result2 > 107)
					grade2 = 85.0;
				else if (result2 <= 118 && result2 > 112)
					grade2 = 90.0;
				else if (result2 > 118)
					grade2 = 95.0;

				if (result3 >= -14.6 && result3 < -12.6)
					grade3 = 5.0;
				else if (result3 >= -12.6 && result3 < -11.3)
					grade3 = 10.0;
				else if (result3 >= -11.3 && result3 < -10.2)
					grade3 = 15.0;
				else if (result3 >= -10.2 && result3 < -9.3)
					grade3 = 20.0;
				else if (result3 >= -9.3 && result3 < -8.5)
					grade3 = 25.0;
				else if (result3 >= -8.5 && result3 < -7.8)
					grade3 = 30.0;
				else if (result3 >= -7.8 && result3 < -7.1)
					grade3 = 35.0;
				else if (result3 >= -7.1 && result3 < -6.4)
					grade3 = 40.0;
				else if (result3 >= -6.4 && result3 < -5.7)
					grade3 = 45.0;
				else if (result3 >= -5.7 && result3 < -5)
					grade3 = 50.0;
				else if (result3 >= -5 && result3 < -4.3)
					grade3 = 55.0;
				else if (result3 >= -4.3 && result3 < -3.6)
					grade3 = 60.0;
				else if (result3 >= -3.6 && result3 < -2.9)
					grade3 = 65.0;
				else if (result3 >= -2.9 && result3 < -2.1)
					grade3 = 70.0;
				else if (result3 >= -2.1 && result3 < -1.2)
					grade3 = 75.0;
				else if (result3 >= -1.2 && result3 < -0.1)
					grade3 = 80.0;
				else if (result3 >= -0.1 && result3 < 1.2)
					grade3 = 85.0;
				else if (result3 >= 1.2 && result3 < 3.2)
					grade3 = 90.0;
				else if (result3 >= 3.2)
					grade3 = 95.0;

				if (result4 <= 9.4 && result4 > 8.7)
					grade4 = 5.0;
				else if (result4 <= 8.7 && result4 > 8.3)
					grade4 = 10.0;
				else if (result4 <= 8.3 && result4 > 7.9)
					grade4 = 15.0;
				else if (result4 <= 7.9 && result4 > 7.6)
					grade4 = 20.0;
				else if (result4 <= 7.6 && result4 > 7.3)
					grade4 = 25.0;
				else if (result4 <= 7.3 && result4 > 7.1)
					grade4 = 30.0;
				else if (result4 <= 7.1 && result4 > 6.9)
					grade4 = 35.0;
				else if (result4 <= 6.9 && result4 > 6.6)
					grade4 = 40.0;
				else if (result4 <= 6.6 && result4 > 6.4)
					grade4 = 45.0;
				else if (result4 <= 6.4 && result4 > 6.2)
					grade4 = 50.0;
				else if (result4 <= 6.2 && result4 > 6)
					grade4 = 55.0;
				else if (result4 <= 6 && result4 > 5.7)
					grade4 = 60.0;
				else if (result4 <= 5.7 && result4 > 5.5)
					grade4 = 65.0;
				else if (result4 <= 5.5 && result4 > 5.2)
					grade4 = 70.0;
				else if (result4 <= 5.2 && result4 > 4.9)
					grade4 = 75.0;
				else if (result4 <= 4.9 && result4 > 4.5)
					grade4 = 80.0;
				else if (result4 <= 4.5 && result4 > 4.1)
					grade4 = 85.0;
				else if (result4 <= 4.1 && result4 > 4)
					grade4 = 90.0;
				else if (result4 <= 4)
					grade4 = 95.0;

				if (result8 < -8.4)
					grade8 = 5.0;
				else if (result8 < -7.2 && result8 >= -8.4)
					grade8 = 10.0;
				else if (result8 < -6.2 && result8 >= -7.2)
					grade8 = 15.0;
				else if (result8 < -5.3 && result8 >= -6.2)
					grade8 = 20.0;
				else if (result8 < -4.6 && result8 >= -5.3)
					grade8 = 25.0;
				else if (result8 < -4 && result8 >= -4.6)
					grade8 = 30.0;
				else if (result8 < -3.2 && result8 >= -4)
					grade8 = 35.0;
				else if (result8 < -2.6 && result8 >= -3.2)
					grade8 = 40.0;
				else if (result8 < -2 && result8 >= -2.6)
					grade8 = 45.0;
				else if (result8 < -1.4 && result8 >= -2)
					grade8 = 50.0;
				else if (result8 < 0.8 && result8 >= -1.4)
					grade8 = 55.0;
				else if (result8 < 0 && result8 >= 0.8)
					grade8 = 60.0;
				else if (result8 < 0.6 && result8 >= 0)
					grade8 = 65.0;
				else if (result8 < 1.4 && result8 >= 0.6)
					grade8 = 70.0;
				else if (result8 < 2.2 && result8 >= 1.4)
					grade8 = 75.0;
				else if (result8 < 3.2 && result8 >= 2.2)
					grade8 = 80.0;
				else if (result8 < 4.4 && result8 >= 3.2)
					grade8 = 85.0;
				else if (result8 < 6.2 && result8 >= 4.4)
					grade8 = 90.0;
				else if (result8 >= 6.2)
					grade8 = 95.0;

				if (result5 <= 19.4)
					grade5 = 10.0;
				else if (result5 <= 23.2 && result5 > 19.4)
					grade5 = 30.0;
				else if (result5 <= 24.2 && result5 > 23.2)
					grade5 = 50.0;
				else if (result5 <= 30 && result5 > 24.2)
					grade5 = 70.0;
				else if (result5 > 30)
					grade5 = 90.0;

			} else if (age >= 85 && age <= 89) {
				if (result1 <= 4) {
					grade1 = 5.0;
				} else if (result1 == 5) {
					grade1 = 10.0;
				} else if (result1 == 6) {
					grade1 = 15.0;
				} else if (result1 == 7) {
					grade1 = 20.0;
				} else if (result1 == 8) {
					grade1 = 25.0;
				} else if (result1 == 9) {
					grade1 = 32.5;
				} else if (result1 == 10) {
					grade1 = 40.0;
				} else if (result1 == 11) {
					grade1 = 47.5;
				} else if (result1 == 12) {
					grade1 = 57.5;
				} else if (result1 == 13) {
					grade1 = 67.5;
				} else if (result1 == 14) {
					grade1 = 75.0;
				} else if (result1 == 15) {
					grade1 = 80.0;
				} else if (result1 == 16) {
					grade1 = 85.0;
				} else if (result1 == 17) {
					grade1 = 90.0;
				} else if (result1 == 18) {
					grade1 = 92.5;
				} else if (result1 == 17) {
					grade1 = 95.0;
				}

				if (result2 <= 36)
					grade2 = 5.0;
				else if (result2 <= 44 && result2 > 36)
					grade2 = 10.0;
				else if (result2 <= 50 && result2 > 44)
					grade2 = 15.0;
				else if (result2 <= 55 && result2 > 50)
					grade2 = 20.0;
				else if (result2 <= 59 && result2 > 55)
					grade2 = 25.0;
				else if (result2 <= 63 && result2 > 59)
					grade2 = 30.0;
				else if (result2 <= 66 && result2 > 63)
					grade2 = 35.0;
				else if (result2 <= 69 && result2 > 66)
					grade2 = 40.0;
				else if (result2 <= 72 && result2 > 69)
					grade2 = 45.0;
				else if (result2 <= 75 && result2 > 72)
					grade2 = 50.0;
				else if (result2 <= 78 && result2 > 75)
					grade2 = 55.0;
				else if (result2 <= 81 && result2 > 78)
					grade2 = 60.0;
				else if (result2 <= 84 && result2 > 81)
					grade2 = 65.0;
				else if (result2 <= 87 && result2 > 84)
					grade2 = 70.0;
				else if (result2 <= 91 && result2 > 87)
					grade2 = 75.0;
				else if (result2 <= 95 && result2 > 91)
					grade2 = 80.0;
				else if (result2 <= 100 && result2 > 95)
					grade2 = 85.0;
				else if (result2 <= 106 && result2 > 100)
					grade2 = 90.0;
				else if (result2 > 106)
					grade2 = 95.0;

				if (result3 >= -14.1 && result3 < -12.3)
					grade3 = 5.0;
				else if (result3 >= -12.3 && result3 < -11.2)
					grade3 = 10.0;
				else if (result3 >= -11.2 && result3 < -10.2)
					grade3 = 15.0;
				else if (result3 >= -10.2 && result3 < -9.4)
					grade3 = 20.0;
				else if (result3 >= -9.4 && result3 < -8.7)
					grade3 = 25.0;
				else if (result3 >= -8.7 && result3 < -8.1)
					grade3 = 30.0;
				else if (result3 >= -8.1 && result3 < -7.4)
					grade3 = 35.0;
				else if (result3 >= -7.4 && result3 < -6.8)
					grade3 = 40.0;
				else if (result3 >= -6.8 && result3 < -6.2)
					grade3 = 45.0;
				else if (result3 >= -6.2 && result3 < -5.6)
					grade3 = 50.0;
				else if (result3 >= -5.6 && result3 < -5)
					grade3 = 55.0;
				else if (result3 >= -5 && result3 < -4.3)
					grade3 = 60.0;
				else if (result3 >= -4.3 && result3 < -3.7)
					grade3 = 65.0;
				else if (result3 >= -3.7 && result3 < -3)
					grade3 = 70.0;
				else if (result3 >= -3 && result3 < -2.2)
					grade3 = 75.0;
				else if (result3 >= -2.2 && result3 < -1.2)
					grade3 = 80.0;
				else if (result3 >= -1.2 && result3 < -0.1)
					grade3 = 85.0;
				else if (result3 >= -0.1 && result3 < 1.7)
					grade3 = 90.0;
				else if (result3 >= 1.7)
					grade3 = 95.0;

				if (result8 < -7.8)
					grade4 = 5.0;
				else if (result8 < -6.8 && result8 >= -7.8)
					grade8 = 10.0;
				else if (result8 < -5.9 && result8 >= -6.8)
					grade8 = 15.0;
				else if (result8 < -5.2 && result8 >= -5.9)
					grade8 = 20.0;
				else if (result8 < -4.6 && result8 >= -5.2)
					grade8 = 25.0;
				else if (result8 < -4 && result8 >= -4.6)
					grade8 = 30.0;
				else if (result8 < -3.5 && result8 >= -4)
					grade8 = 35.0;
				else if (result8 < -2.9 && result8 >= -3.5)
					grade8 = 40.0;
				else if (result8 < -2.4 && result8 >= -2.9)
					grade8 = 45.0;
				else if (result8 < -1.9 && result8 >= -2.4)
					grade8 = 50.0;
				else if (result8 < -1.3 && result8 >= -1.9)
					grade8 = 55.0;
				else if (result8 < -0.8 && result8 >= -1.3)
					grade8 = 60.0;
				else if (result8 < -0.2 && result8 >= -0.8)
					grade8 = 65.0;
				else if (result8 < 0.4 && result8 >= -0.2)
					grade8 = 70.0;
				else if (result8 < 1.1 && result8 >= 0.4)
					grade8 = 75.0;
				else if (result8 < 2 && result8 >= 1.1)
					grade8 = 80.0;
				else if (result8 < 3 && result8 >= 2)
					grade8 = 85.0;
				else if (result8 < 4.5 && result8 >= 3)
					grade8 = 90.0;
				else if (result8 >= 4.5)
					grade8 = 95.0;

				if (result4 <= 11.5 && result4 > 10.5)
					grade4 = 5.0;
				else if (result4 <= 10.5 && result4 > 9.9)
					grade4 = 10.0;
				else if (result4 <= 9.9 && result4 > 9.4)
					grade4 = 15.0;
				else if (result4 <= 9.4 && result4 > 8.9)
					grade4 = 20.0;
				else if (result4 <= 8.9 && result4 > 8.6)
					grade4 = 25.0;
				else if (result4 <= 8.6 && result4 > 8.2)
					grade4 = 30.0;
				else if (result4 <= 8.2 && result4 > 7.9)
					grade4 = 35.0;
				else if (result4 <= 7.9 && result4 > 7.5)
					grade4 = 40.0;
				else if (result4 <= 7.5 && result4 > 7.2)
					grade4 = 45.0;
				else if (result4 <= 7.2 && result4 > 6.9)
					grade4 = 50.0;
				else if (result4 <= 6.9 && result4 > 6.5)
					grade4 = 55.0;
				else if (result4 <= 6.5 && result4 > 6.2)
					grade4 = 60.0;
				else if (result4 <= 6.2 && result4 > 5.8)
					grade4 = 65.0;
				else if (result4 <= 5.8 && result4 > 5.5)
					grade4 = 70.0;
				else if (result4 <= 5.5 && result4 > 5)
					grade4 = 75.0;
				else if (result4 <= 5 && result4 > 4.5)
					grade4 = 80.0;
				else if (result4 <= 4.5 && result4 > 4.3)
					grade4 = 85.0;
				else if (result4 <= 4.3 && result4 > 4)
					grade4 = 90.0;
				else if (result4 <= 4)
					grade4 = 95.0;

				if (result5 <= 18.3)
					grade5 = 10.0;
				else if (result5 <= 20.6 && result5 > 18.3)
					grade5 = 30.0;
				else if (result5 <= 21.1 && result5 > 20.6)
					grade5 = 50.0;
				else if (result5 <= 29 && result5 > 21.1)
					grade5 = 70.0;
				else if (result5 > 29)
					grade5 = 90.0;

			} else if (age >= 90 && age <= 100) {
				if (result1 <= 3) {
					grade1 = 5.0;
				} else if (result1 == 4) {
					grade1 = 7.5;
				} else if (result1 == 5) {
					grade1 = 10.0;
				} else if (result1 == 6) {
					grade1 = 15.0;
				} else if (result1 == 7) {
					grade1 = 22.5;
				} else if (result1 == 8) {
					grade1 = 32.5;
				} else if (result1 == 9) {
					grade1 = 42.5;
				} else if (result1 == 10) {
					grade1 = 52.5;
				} else if (result1 == 11) {
					grade1 = 62.5;
				} else if (result1 == 12) {
					grade1 = 72.5;
				} else if (result1 == 13) {
					grade1 = 80.0;
				} else if (result1 == 14) {
					grade1 = 85.0;
				} else if (result1 == 15) {
					grade1 = 90.0;
				} else if (result1 == 16) {
					grade1 = 95.0;
				}

				if (result2 <= 26)
					grade2 = 5.0;
				else if (result2 <= 36 && result2 > 26)
					grade2 = 10.0;
				else if (result2 <= 42 && result2 > 36)
					grade2 = 15.0;
				else if (result2 <= 47 && result2 > 42)
					grade2 = 20.0;
				else if (result2 <= 52 && result2 > 47)
					grade2 = 25.0;
				else if (result2 <= 55 && result2 > 52)
					grade2 = 30.0;
				else if (result2 <= 59 && result2 > 55)
					grade2 = 35.0;
				else if (result2 <= 62 && result2 > 59)
					grade2 = 40.0;
				else if (result2 <= 66 && result2 > 62)
					grade2 = 45.0;
				else if (result2 <= 69 && result2 > 66)
					grade2 = 50.0;
				else if (result2 <= 72 && result2 > 69)
					grade2 = 55.0;
				else if (result2 <= 76 && result2 > 72)
					grade2 = 60.0;
				else if (result2 <= 79 && result2 > 76)
					grade2 = 65.0;
				else if (result2 <= 83 && result2 > 79)
					grade2 = 70.0;
				else if (result2 <= 86 && result2 > 83)
					grade2 = 75.0;
				else if (result2 <= 91 && result2 > 86)
					grade2 = 80.0;
				else if (result2 <= 96 && result2 > 91)
					grade2 = 85.0;
				else if (result2 <= 102 && result2 > 96)
					grade2 = 90.0;
				else if (result2 > 102)
					grade2 = 95.0;

				if (result3 >= -15.1 && result3 < -13.3)
					grade3 = 5.0;
				else if (result3 >= -13.3 && result3 < -12.2)
					grade3 = 10.0;
				else if (result3 >= -12.2 && result3 < -11.2)
					grade3 = 15.0;
				else if (result3 >= -11.2 && result3 < -10.4)
					grade3 = 20.0;
				else if (result3 >= -10.4 && result3 < -9.7)
					grade3 = 25.0;
				else if (result3 >= -9.7 && result3 < -9.1)
					grade3 = 30.0;
				else if (result3 >= -9.1 && result3 < -8.4)
					grade3 = 35.0;
				else if (result3 >= -8.4 && result3 < -7.8)
					grade3 = 40.0;
				else if (result3 >= -7.8 && result3 < -7.2)
					grade3 = 45.0;
				else if (result3 >= -7.2 && result3 < -6.6)
					grade3 = 50.0;
				else if (result3 >= -6.6 && result3 < -6)
					grade3 = 55.0;
				else if (result3 >= -6 && result3 < -5.3)
					grade3 = 60.0;
				else if (result3 >= -5.3 && result3 < -4.7)
					grade3 = 65.0;
				else if (result3 >= -4.7 && result3 < -4)
					grade3 = 70.0;
				else if (result3 >= -4 && result3 < -3.2)
					grade3 = 75.0;
				else if (result3 >= -3.2 && result3 < -2.2)
					grade3 = 80.0;
				else if (result3 >= -2.2 && result3 < -1.1)
					grade3 = 85.0;
				else if (result3 >= -1.1 && result3 < 0.7)
					grade3 = 90.0;
				else if (result3 >= 0.7)
					grade3 = 95.0;

				if (result4 <= 12.9 && result4 > 11.8)
					grade4 = 5.0;
				else if (result4 <= 11.8 && result4 > 11.1)
					grade4 = 10.0;
				else if (result4 <= 11.1 && result4 > 10.5)
					grade4 = 15.0;
				else if (result4 <= 10.5 && result4 > 10)
					grade4 = 20.0;
				else if (result4 <= 10 && result4 > 9.6)
					grade4 = 25.0;
				else if (result4 <= 9.6 && result4 > 9.2)
					grade4 = 30.0;
				else if (result4 <= 9.2 && result4 > 8.8)
					grade4 = 35.0;
				else if (result4 <= 8.8 && result4 > 8.5)
					grade4 = 40.0;
				else if (result4 <= 8.5 && result4 > 8.1)
					grade4 = 45.0;
				else if (result4 <= 8.1 && result4 > 7.7)
					grade4 = 50.0;
				else if (result4 <= 7.7 && result4 > 7.4)
					grade4 = 55.0;
				else if (result4 <= 7.4 && result4 > 7)
					grade4 = 60.0;
				else if (result4 <= 7 && result4 > 6.6)
					grade4 = 65.0;
				else if (result4 <= 6.6 && result4 > 6.2)
					grade4 = 70.0;
				else if (result4 <= 6.2 && result4 > 5.7)
					grade4 = 75.0;
				else if (result4 <= 5.7 && result4 > 5.1)
					grade4 = 80.0;
				else if (result4 <= 5.1 && result4 > 4.5)
					grade4 = 85.0;
				else if (result4 <= 4.5 && result4 > 4.3)
					grade4 = 90.0;
				else if (result4 <= 4.3)
					grade4 = 95.0;

				if (result8 < -9.1)
					grade4 = 5.0;
				else if (result8 < -8.1 && result8 >= -9.1)
					grade8 = 10.0;
				else if (result8 < -7.2 && result8 >= -8.1)
					grade8 = 15.0;
				else if (result8 < -6.5 && result8 >= -7.2)
					grade8 = 20.0;
				else if (result8 < -5.8 && result8 >= -6.5)
					grade8 = 25.0;
				else if (result8 < -5.3 && result8 >= -5.8)
					grade8 = 30.0;
				else if (result8 < -4.7 && result8 >= -5.3)
					grade8 = 35.0;
				else if (result8 < -4.2 && result8 >= -4.7)
					grade8 = 40.0;
				else if (result8 < -3.6 && result8 >= -4.2)
					grade8 = 45.0;
				else if (result8 < -3 && result8 >= -3.6)
					grade8 = 50.0;
				else if (result8 < -2.5 && result8 >= -3)
					grade8 = 55.0;
				else if (result8 < -1.9 && result8 >= -2.5)
					grade8 = 60.0;
				else if (result8 < -1.4 && result8 >= -1.9)
					grade8 = 65.0;
				else if (result8 < -0.7 && result8 >= -1.4)
					grade8 = 70.0;
				else if (result8 < 0 && result8 >= -0.7)
					grade8 = 75.0;
				else if (result8 < 0.9 && result8 >= 0)
					grade8 = 80.0;
				else if (result8 < 1.9 && result8 >= 0.9)
					grade8 = 85.0;
				else if (result8 < 3.5 && result8 >= 1.9)
					grade8 = 90.0;
				else if (result8 >= 3.5)
					grade8 = 95.0;

				if (result5 <= 18.3)
					grade5 = 10.0;
				else if (result5 <= 20.6 && result5 > 18.3)
					grade5 = 30.0;
				else if (result5 <= 21.1 && result5 > 20.6)
					grade5 = 50.0;
				else if (result5 <= 29 && result5 > 21.1)
					grade5 = 70.0;
				else if (result5 > 29)
					grade5 = 90.0;

			}
			if (result6 < 18.5) {
				grade6 = 1.0;
			} else if (result6 >= 18.5 && result6 < 23.9) {
				grade6 = 1.0;
			} else if (result6 >= 23.9 && result6 < 27.9) {
				grade6 = 0.5;
			} else if (result6 >= 27.9) {
				grade6 = 0.1;
			}
		}

		/*
		 * // ---------------腰臀比------------------------- Double result7 =
		 * maFitness.getResultSeven(); if (sex == 1) { if (result7 <= 0.85) {
		 * grade7 = 1.0; } else if (0.85 < result7 && result7 <= 1.0) { grade7 =
		 * 1.0; } else if (1.0 < result7) { grade7 =0.5; } } else { if (result7
		 * <= 0.6) { grade7 = 1.0; } else if (0.6 < result7 && result7 <= 0.85)
		 * { grade7 = 1.0; } else if (0.85 < result7) { grade7 =0.5; } }
		 */
		FitnseeVO fi = new FitnseeVO();

		Double myodyNamia = (grade1 + grade5) / 2; // 肌力得分
		Double xinfen = grade2;// 心肺力
		Double rouruan = (grade3 + grade8) / 2;// 柔软素质
		Double shenjing = grade4;// 神经反应能力
		Double BodyWeight = grade6;
		fi.setBodyWeight(BodyWeight);
		fi.setMyodyNamia(myodyNamia);
		fi.setRouruan(rouruan);
		fi.setShenjing(shenjing);
		fi.setXinfen(xinfen);
		return fi;
	}

	@SuppressWarnings("unchecked")
	public AnalysisStudyVO getC(List<EvaluatedPrivatelyVO> v1, List<MAssessFitness> m1) {
		Integer ADLScore = 0;
		Integer IADLScoro = 0;
		Double BodyWeight = 0.0;
		Double myodyNamia = 0.0;
		Double xinfen = 0.0;
		Double rouruan = 0.0;
		Double shenjing = 0.0;
		Double xueya = 0.0;
		Double dingxiangli = 0.0;
		Double zhuyili = 0.0;
		Double jiyili = 0.0;
		Double yuyanli = 0.0;
		Double huiyili = 0.0;
		Double choxiang = 0.0;
		Double shijiegou = 0.0;
		Double zhixingli = 0.0;
		Double jisuanli = 0.0;
		Double GDSScroe = 0.0;
		Double mocaScroe = 0.0;
		Double mmseScroe = 0.0;
		int lengthz = v1.size();
		AnalysisStudyVO an = new AnalysisStudyVO();
		Iterator<EvaluatedPrivatelyVO> li = v1.iterator();
		while (li.hasNext()) {
			EvaluatedPrivatelyVO v = li.next();
			MyBeanWithPerson m = getMyBeanWithPerson(v);
			List<QuestionVO> qu = m.getResult();
			for (QuestionVO q : qu) {
				int score = Integer.parseInt(q.getScore());
				if (v.getAssessId() == 78) { // 简易智能精神状态检查量表(MMSE)
					mmseScroe += score;
					if (q.getQuestion_id().equals("114") | q.getQuestion_id().equals("115")
							| q.getQuestion_id().equals("285")) {
						dingxiangli += score;
					} else if (q.getQuestion_id().equals("117")) {
						zhuyili += score;
						jisuanli += score;
					} else if (q.getQuestion_id().equals("116")) {
						jiyili += score;
						huiyili += score;
					} else if (q.getQuestion_id().equals("118") | q.getQuestion_id().equals("120")
							| q.getQuestion_id().equals("122") | q.getQuestion_id().equals("124")
							| q.getQuestion_id().equals("126") | q.getQuestion_id().equals("127")) {
						yuyanli += score;
					} else if (q.getQuestion_id().equals("130")) {
						zhixingli += score;
					}
				} else if (v.getAssessId() == 110) {// MoCA量表
					mocaScroe += score;
					if (q.getQuestion_id().equals("391")) {
						dingxiangli += score;
					} else if (q.getQuestion_id().equals("384") | q.getQuestion_id().equals("385")
							| q.getQuestion_id().equals("386")) {
						zhuyili += score;
						if (q.getQuestion_id().equals("386")) {
							jisuanli += score;
						}
					} else if (q.getQuestion_id().equals("383")) {
						jiyili += score;
					} else if (q.getQuestion_id().equals("382") | q.getQuestion_id().equals("387")
							| q.getQuestion_id().equals("388")) {
						yuyanli += score;
					} else if (q.getQuestion_id().equals("390")) {
						// 回忆
						huiyili += score;
					} else if (q.getQuestion_id().equals("389")) {
						// 抽象
						choxiang += score;
					} else if (q.getQuestion_id().equals("379") | q.getQuestion_id().equals("380")
							| q.getQuestion_id().equals("381")) {
						// 视结构
						shijiegou += score;
						zhixingli += score;
					}
				} else if (v.getAssessId() == 79) {// 日常生活活动评估表(ADL)
					ADLScore += score;
				} else if (v.getAssessId() == 61) {// 工具日常生活量表（IADLs）
					IADLScoro += score;
				} else if (v.getAssessId() == 97) {// 老年抑郁量表
					GDSScroe += score;
				}
			}
		}
		an.setADLScoreC(Math.pow((double) ADLScore, 2) / lengthz);
		an.setIADLScoreC(Math.pow((double) IADLScoro, 2) / lengthz);
		an.setBodyWeight(Math.pow(BodyWeight, 2) / lengthz);
		an.setMyodyNamia(Math.pow(mmseScroe, 2) / lengthz);
		an.setDingxiangli(Math.pow(dingxiangli, 2) / lengthz);
		an.setZhuyili(Math.pow(zhuyili, 2) / lengthz);
		an.setJiyili(Math.pow(jiyili, 2) / lengthz);
		an.setYuyanli(Math.pow(yuyanli, 2) / lengthz);
		an.setHuiyili(Math.pow(huiyili, 2) / lengthz);
		an.setChoxiang(Math.pow(choxiang, 2) / lengthz);
		an.setShijiegou(Math.pow(shijiegou, 2) / lengthz);
		an.setZhixingli(Math.pow(zhixingli, 2) / lengthz);
		an.setJisuanli(Math.pow(jisuanli, 2) / lengthz);
		an.setGDSScroe(Math.pow(GDSScroe, 2) / lengthz);
		an.setMoCaScroe(Math.pow(mocaScroe, 2) / lengthz);
		an.setMMSEScroe(Math.pow(mmseScroe, 2) / lengthz);

		for (MAssessFitness m : m1) {
			FitnseeVO vo = Result(m.getUser().getId(), m);
			BodyWeight += vo.getBodyWeight();
			myodyNamia += vo.getMyodyNamia();
			xinfen += vo.getXinfen();
			rouruan += vo.getRouruan();
			shenjing += vo.getShenjing();
		}
		an.setBodyWeight(Math.pow(BodyWeight, 2) / lengthz); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setMyodyNamia(Math.pow(myodyNamia, 2) / lengthz);// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setXinfen(Math.pow(xinfen, 2) / lengthz);// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setRouruan(Math.pow(rouruan, 2) / lengthz); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setShenjing(Math.pow(shenjing, 2) / lengthz);// 神经反应能力得分为2.44米折返走速度，神经反应能力得分可根据其性别、年龄层和2.44米折返跑时间确认出其具体的神经反应能力得分，对应表见(常模)；；
		an.setXueya(Math.pow(xueya, 2) / lengthz);// 血压：收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；
		return an;
	}

	/**
	 * 解析量表 获取对应组平均值
	 * 
	 * @param v1
	 * @param m1
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public AnalysisStudyVO getAnalysisStudyVO(List<EvaluatedPrivatelyVO> v1, List<MAssessFitness> m1) {
		Integer ADLScore = 0;
		Integer IADLScoro = 0;
		Double BodyWeight = 0.0;
		Double myodyNamia = 0.0;
		Double xinfen = 0.0;
		Double rouruan = 0.0;
		Double shenjing = 0.0;
		Double xueya = 0.0;
		Double dingxiangli = 0.0;
		Double zhuyili = 0.0;
		Double jiyili = 0.0;
		Double yuyanli = 0.0;
		Double huiyili = 0.0;
		Double choxiang = 0.0;
		Double shijiegou = 0.0;
		Double zhixingli = 0.0;
		Double jisuanli = 0.0;
		Double GDSScroe = 0.0;
		Double mocaScroe = 0.0;
		Double mmseScroe = 0.0;
		int lengthz = v1.size();
		AnalysisStudyVO an = new AnalysisStudyVO();
		Iterator<EvaluatedPrivatelyVO> li = v1.iterator();
		while (li.hasNext()) {
			EvaluatedPrivatelyVO v = li.next();
			MyBeanWithPerson m = getMyBeanWithPerson(v);
			List<QuestionVO> qu = m.getResult();
			for (QuestionVO q : qu) {
				int score = Integer.parseInt(q.getScore());
				if (v.getAssessId() == 78) { // 简易智能精神状态检查量表(MMSE)
					mmseScroe += score;
					if (q.getQuestion_id().equals("114") | q.getQuestion_id().equals("115")
							| q.getQuestion_id().equals("285")) {
						dingxiangli += score;
					} else if (q.getQuestion_id().equals("117")) {
						zhuyili += score;
						jisuanli += score;
					} else if (q.getQuestion_id().equals("116")) {
						jiyili += score;
						huiyili += score;
					} else if (q.getQuestion_id().equals("118") | q.getQuestion_id().equals("120")
							| q.getQuestion_id().equals("122") | q.getQuestion_id().equals("124")
							| q.getQuestion_id().equals("126") | q.getQuestion_id().equals("127")) {
						yuyanli += score;
					} else if (q.getQuestion_id().equals("130")) {
						zhixingli += score;
					}
				} else if (v.getAssessId() == 110) {// MoCA量表
					mocaScroe += score;
					if (q.getQuestion_id().equals("391")) {
						dingxiangli += score;
					} else if (q.getQuestion_id().equals("384") | q.getQuestion_id().equals("385")
							| q.getQuestion_id().equals("386")) {
						zhuyili += score;
						if (q.getQuestion_id().equals("386")) {
							jisuanli += score;
						}
					} else if (q.getQuestion_id().equals("383")) {
						jiyili += score;
					} else if (q.getQuestion_id().equals("382") | q.getQuestion_id().equals("387")
							| q.getQuestion_id().equals("388")) {
						yuyanli += score;
					} else if (q.getQuestion_id().equals("390")) {
						// 回忆
						huiyili += score;
					} else if (q.getQuestion_id().equals("389")) {
						// 抽象
						choxiang += score;
					} else if (q.getQuestion_id().equals("379") | q.getQuestion_id().equals("380")
							| q.getQuestion_id().equals("381")) {
						// 视结构
						shijiegou += score;
						zhixingli += score;
					}
				} else if (v.getAssessId() == 79) {// 日常生活活动评估表(ADL)
					ADLScore += score;
				} else if (v.getAssessId() == 61) {// 工具日常生活量表（IADLs）
					IADLScoro += score;
				} else if (v.getAssessId() == 97) {// 老年抑郁量表
					GDSScroe += score;
				}
			}
		}
		an.setADLScoreC((double) ADLScore / lengthz);
		an.setIADLScoreC((double) IADLScoro / lengthz);
		an.setBodyWeight(BodyWeight / lengthz);
		an.setMyodyNamia(mmseScroe / lengthz);
		an.setDingxiangli(dingxiangli / lengthz);
		an.setZhuyili(zhuyili / lengthz);
		an.setJiyili(jiyili / lengthz);
		an.setYuyanli(yuyanli / lengthz);
		an.setHuiyili(huiyili / lengthz);
		an.setChoxiang(choxiang / lengthz);
		an.setShijiegou(shijiegou / lengthz);
		an.setZhixingli(zhixingli / lengthz);
		an.setJisuanli(jisuanli / lengthz);
		an.setGDSScroe(GDSScroe / lengthz);
		an.setMoCaScroe(mocaScroe / lengthz);
		an.setMMSEScroe(mmseScroe / lengthz);

		for (MAssessFitness m : m1) {
			FitnseeVO vo = Result(m.getUser().getId(), m);
			BodyWeight += vo.getBodyWeight();
			myodyNamia += vo.getMyodyNamia();
			xinfen += vo.getXinfen();
			rouruan += vo.getRouruan();
			shenjing += vo.getShenjing();
		}
		an.setBodyWeight(BodyWeight / lengthz); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setMyodyNamia(myodyNamia / lengthz);// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setXinfen(xinfen / lengthz);// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setRouruan(rouruan / lengthz); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
		an.setShenjing(shenjing / lengthz);// 神经反应能力得分为2.44米折返走速度，神经反应能力得分可根据其性别、年龄层和2.44米折返跑时间确认出其具体的神经反应能力得分，对应表见(常模)；；
		an.setXueya(xueya);// 血压：收缩压90-140为正常，低于90为收缩压偏低，高于140为收缩压偏高；舒张压60-90为正常，低于60为舒张压偏低，高于90为舒张压偏高；
		return an;
	}

	@SuppressWarnings({  "unchecked" })
	public List<AnalysisStudyVO> getlistUsers(List<EvaluatedPrivatelyVO> v1, List<MAssessFitness> m1) {
		List<AnalysisStudyVO> vos = new ArrayList<AnalysisStudyVO>();
		for (MAssessFitness m : m1) {
			Integer ADLScore = 0;
			Integer IADLScoro = 0;
			Double xueya = 0.0;
			Double dingxiangli = 0.0;
			Double zhuyili = 0.0;
			Double jiyili = 0.0;
			Double yuyanli = 0.0;
			Double huiyili = 0.0;
			Double choxiang = 0.0;
			Double shijiegou = 0.0;
			Double zhixingli = 0.0;
			Double jisuanli = 0.0;
			Double GDSScroe = 0.0;
			Double mocaScroe = 0.0;
			Double mmseScroe = 0.0;
			AnalysisStudyVO an = new AnalysisStudyVO();
			for (EvaluatedPrivatelyVO v : v1) {
				if (v.getUserId() == m.getUser().getId()) {
					MyBeanWithPerson mb = getMyBeanWithPerson(v);
					List<QuestionVO> qu = mb.getResult();
					for (QuestionVO q : qu) {
						int score = Integer.parseInt(q.getScore());
						if (v.getAssessId() == 78) { // 简易智能精神状态检查量表(MMSE)
							mmseScroe += score;
							if (q.getQuestion_id().equals("114") | q.getQuestion_id().equals("115")
									| q.getQuestion_id().equals("285")) {
								dingxiangli += score;
							} else if (q.getQuestion_id().equals("117")) {
								zhuyili += score;
								jisuanli += score;
							} else if (q.getQuestion_id().equals("116")) {
								jiyili += score;
								huiyili += score;
							} else if (q.getQuestion_id().equals("118") | q.getQuestion_id().equals("120")
									| q.getQuestion_id().equals("122") | q.getQuestion_id().equals("124")
									| q.getQuestion_id().equals("126") | q.getQuestion_id().equals("127")) {
								yuyanli += score;
							} else if (q.getQuestion_id().equals("130")) {
								zhixingli += score;
							}
						} else if (v.getAssessId() == 110) {// MoCA量表
							mocaScroe += score;
							if (q.getQuestion_id().equals("391")) {
								dingxiangli += score;
							} else if (q.getQuestion_id().equals("384") | q.getQuestion_id().equals("385")
									| q.getQuestion_id().equals("386")) {
								zhuyili += score;
								if (q.getQuestion_id().equals("386")) {
									jisuanli += score;
								}
							} else if (q.getQuestion_id().equals("383")) {
								jiyili += score;
							} else if (q.getQuestion_id().equals("382") | q.getQuestion_id().equals("387")
									| q.getQuestion_id().equals("388")) {
								yuyanli += score;
							} else if (q.getQuestion_id().equals("390")) {
								// 回忆
								huiyili += score;
							} else if (q.getQuestion_id().equals("389")) {
								// 抽象
								choxiang += score;
							} else if (q.getQuestion_id().equals("379") | q.getQuestion_id().equals("380")
									| q.getQuestion_id().equals("381")) {
								// 视结构
								shijiegou += score;
								zhixingli += score;
							}
						} else if (v.getAssessId() == 79) {// 日常生活活动评估表(ADL)
							ADLScore += score;
						} else if (v.getAssessId() == 61) {// 工具日常生活量表（IADLs）
							IADLScoro += score;
						} else if (v.getAssessId() == 97) {// 老年抑郁量表
							GDSScroe += score;
						}
					}
				}
			}
			FitnseeVO vo = Result(m.getUser().getId(), m);
			an.setBodyWeight(Math.pow(vo.getBodyWeight(), 2)); // 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setMyodyNamia(Math.pow(vo.getMyodyNamia(), 2));// 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setXinfen(Math.pow(vo.getXinfen(), 2));// 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setRouruan(Math.pow(vo.getRouruan(), 2)); // 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setShenjing(Math.pow(vo.getShenjing(), 2));// 绁炵粡鍙嶅簲鑳藉姏寰楀垎涓�.44绫虫姌杩旇蛋閫熷害锛岀缁忓弽搴旇兘鍔涘緱鍒嗗彲鏍规嵁鍏舵�鍒�骞撮緞灞傚拰2.44绫虫姌杩旇窇鏃堕棿纭鍑哄叾鍏蜂綋鐨勭缁忓弽搴旇兘鍔涘緱鍒嗭紝瀵瑰簲琛ㄨ(甯告ā)锛涳紱
			an.setXueya(Math.pow(xueya, 2));
			an.setADLScoreC(Math.pow(ADLScore, 2));
			an.setIADLScoreC(Math.pow(IADLScoro, 2));
			an.setMyodyNamia(Math.pow(mmseScroe, 2));
			an.setDingxiangli(Math.pow(dingxiangli, 2));
			an.setZhuyili(Math.pow(dingxiangli, 2));
			an.setJiyili(Math.pow(dingxiangli, 2));
			an.setYuyanli(Math.pow(dingxiangli, 2));
			an.setHuiyili(Math.pow(huiyili, 2));
			an.setChoxiang(Math.pow(huiyili, 2));
			an.setShijiegou(Math.pow(shijiegou, 2));
			an.setZhixingli(Math.pow(shijiegou, 2));
			an.setJisuanli(Math.pow(shijiegou, 2));
			an.setGDSScroe(Math.pow(shijiegou, 2));
			an.setMoCaScroe(Math.pow(mocaScroe, 2));
			an.setMMSEScroe(Math.pow(mmseScroe, 2));
			an.setUserId(m.getUser().getId());
			vos.add(an);
		}

		return vos;
	}

	@SuppressWarnings({  "unchecked" })
	public List<AnalysisStudyVO> getlist(List<EvaluatedPrivatelyVO> v1, List<MAssessFitness> m1) {
		List<AnalysisStudyVO> vos = new ArrayList<AnalysisStudyVO>();
		for (MAssessFitness m : m1) {
			Integer ADLScore = 0;
			Integer IADLScoro = 0;
			Double xueya = 0.0;
			Double dingxiangli = 0.0;
			Double zhuyili = 0.0;
			Double jiyili = 0.0;
			Double yuyanli = 0.0;
			Double huiyili = 0.0;
			Double choxiang = 0.0;
			Double shijiegou = 0.0;
			Double zhixingli = 0.0;
			Double jisuanli = 0.0;
			Double GDSScroe = 0.0;
			Double mocaScroe = 0.0;
			Double mmseScroe = 0.0;
			AnalysisStudyVO an = new AnalysisStudyVO();
			for (EvaluatedPrivatelyVO v : v1) {
				if (v.getUserId() == m.getUser().getId()) {
					MyBeanWithPerson mb = getMyBeanWithPerson(v);
					List<QuestionVO> qu = mb.getResult();
					for (QuestionVO q : qu) {
						int score = Integer.parseInt(q.getScore());
						if (v.getAssessId() == 78) { // 简易智能精神状态检查量表(MMSE)
							mmseScroe += score;
							if (q.getQuestion_id().equals("114") | q.getQuestion_id().equals("115")
									| q.getQuestion_id().equals("285")) {
								dingxiangli += score;
							} else if (q.getQuestion_id().equals("117")) {
								zhuyili += score;
								jisuanli += score;
							} else if (q.getQuestion_id().equals("116")) {
								jiyili += score;
								huiyili += score;
							} else if (q.getQuestion_id().equals("118") | q.getQuestion_id().equals("120")
									| q.getQuestion_id().equals("122") | q.getQuestion_id().equals("124")
									| q.getQuestion_id().equals("126") | q.getQuestion_id().equals("127")) {
								yuyanli += score;
							} else if (q.getQuestion_id().equals("130")) {
								zhixingli += score;
							}
						} else if (v.getAssessId() == 110) {// MoCA量表
							mocaScroe += score;
							if (q.getQuestion_id().equals("391")) {
								dingxiangli += score;
							} else if (q.getQuestion_id().equals("384") | q.getQuestion_id().equals("385")
									| q.getQuestion_id().equals("386")) {
								zhuyili += score;
								if (q.getQuestion_id().equals("386")) {
									jisuanli += score;
								}
							} else if (q.getQuestion_id().equals("383")) {
								jiyili += score;
							} else if (q.getQuestion_id().equals("382") | q.getQuestion_id().equals("387")
									| q.getQuestion_id().equals("388")) {
								yuyanli += score;
							} else if (q.getQuestion_id().equals("390")) {
								// 回忆
								huiyili += score;
							} else if (q.getQuestion_id().equals("389")) {
								// 抽象
								choxiang += score;
							} else if (q.getQuestion_id().equals("379") | q.getQuestion_id().equals("380")
									| q.getQuestion_id().equals("381")) {
								// 视结构
								shijiegou += score;
								zhixingli += score;
							}
						} else if (v.getAssessId() == 79) {// 日常生活活动评估表(ADL)
							ADLScore += score;
						} else if (v.getAssessId() == 61) {// 工具日常生活量表（IADLs）
							IADLScoro += score;
						} else if (v.getAssessId() == 97) {// 老年抑郁量表
							GDSScroe += score;
						}
					}
				}
			}
			FitnseeVO vo = Result(m.getUser().getId(), m);
			an.setBodyWeight(vo.getBodyWeight()); // 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setMyodyNamia(vo.getMyodyNamia());// 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setXinfen(vo.getXinfen());// 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setRouruan(vo.getRouruan()); // 鏌旇蒋绱犺川寰楀垎鍒嗘暟瓒婇珮鏌旇蒋搴﹁秺寮猴紝鏌旇蒋绱犺川寰楀垎鍙牴鎹叾鎬у埆銆佸勾榫勫眰鍜屽弻鎵嬬浉鎵ｈ窛绂荤‘璁ゅ嚭鍏跺叿浣撶殑鏌旇蒋绱犺川寰楀垎锛屽搴旇〃瑙�甯告ā)锛�
			an.setShenjing(vo.getShenjing());// 绁炵粡鍙嶅簲鑳藉姏寰楀垎涓�.44绫虫姌杩旇蛋閫熷害锛岀缁忓弽搴旇兘鍔涘緱鍒嗗彲鏍规嵁鍏舵�鍒�骞撮緞灞傚拰2.44绫虫姌杩旇窇鏃堕棿纭鍑哄叾鍏蜂綋鐨勭缁忓弽搴旇兘鍔涘緱鍒嗭紝瀵瑰簲琛ㄨ(甯告ā)锛涳紱
			an.setXueya(xueya);
			an.setADLScoreC((double) ADLScore);
			an.setIADLScoreC((double) IADLScoro);
			an.setMyodyNamia(mmseScroe);
			an.setDingxiangli(dingxiangli);
			an.setZhuyili(zhuyili);
			an.setJiyili(jiyili);
			an.setYuyanli(yuyanli);
			an.setHuiyili(huiyili);
			an.setChoxiang(choxiang);
			an.setShijiegou(shijiegou);
			an.setZhixingli(zhixingli);
			an.setJisuanli(jisuanli);
			an.setGDSScroe(GDSScroe);
			an.setMoCaScroe(mocaScroe);
			an.setMMSEScroe(mmseScroe);
			an.setUserId(m.getUser().getId());
			vos.add(an);
		}

		return vos;
	}

	public AnalysisStudyVO getEcartType(AnalysisStudyVO intervention, List<EvaluatedPrivatelyVO> mindhou,
			List<MAssessFitness> mindtihou) {
		List<AnalysisStudyVO> userT = getlist(mindhou, mindtihou);// 获取每位老人的测量信息
																	// 累加获取标准差
		AnalysisStudyVO voc = new AnalysisStudyVO();// 样本标准差
		double ADLT = 0;
		double IADLT = 0;
		Double BodyWeightT = 0.0;
		Double myodyNamiaT = 0.0;
		Double xinfenT = 0.0;
		Double rouruanT = 0.0;
		Double shenjingT = 0.0;
		Double xueyaT = 0.0;
		Double dingxiangliT = 0.0;
		Double zhuyiliT = 0.0;
		Double jiyiliT = 0.0;
		Double yuyanliT = 0.0;
		Double huiyiliT = 0.0;
		Double choxiangT = 0.0;
		Double shijiegouT = 0.0;
		Double zhixingliT = 0.0;
		Double jisuanliT = 0.0;
		Double GDSScroeT = 0.0;
		Double mocaScroeT = 0.0;
		Double mmseScroeT = 0.0;
		for (int i = 1; i <= userT.size(); i++) {
			AnalysisStudyVO a1 = userT.get(i - 1);
			ADLT += Math.pow(intervention.getIADLScoreC() - a1.getIADLScoreC(), 2);
			IADLT += Math.pow(intervention.getIADLScoreC() - a1.getIADLScoreC(), 2);
			BodyWeightT += Math.pow(intervention.getBodyWeight() - a1.getBodyWeight(), 2);
			myodyNamiaT += Math.pow(intervention.getMyodyNamia() - a1.getMyodyNamia(), 2);
			xinfenT += Math.pow(intervention.getXinfen() - a1.getXinfen(), 2);
			rouruanT += Math.pow(intervention.getRouruan() - a1.getRouruan(), 2);
			shenjingT += Math.pow(intervention.getShenjing() - a1.getShenjing(), 2);
			xueyaT += Math.pow(intervention.getXueya() - a1.getXueya(), 2);
			dingxiangliT += Math.pow(intervention.getDingxiangli() - a1.getDingxiangli(), 2);
			zhuyiliT += Math.pow(intervention.getZhuyili() - a1.getZhuyili(), 2);
			jiyiliT += Math.pow(intervention.getJiyili() - a1.getJiyili(), 2);
			yuyanliT += Math.pow(intervention.getYuyanli() - a1.getYuyanli(), 2);
			huiyiliT += Math.pow(intervention.getHuiyili() - a1.getHuiyili(), 2);
			choxiangT += Math.pow(intervention.getChoxiang() - a1.getChoxiang(), 2);
			shijiegouT += Math.pow(intervention.getShijiegou() - a1.getShijiegou(), 2);
			zhixingliT += Math.pow(intervention.getZhixingli() - a1.getZhixingli(), 2);
			jisuanliT += Math.pow(intervention.getJisuanli() - a1.getJisuanli(), 2);
			GDSScroeT += Math.pow(intervention.getGDSScroe() - a1.getGDSScroe(), 2);
			mocaScroeT += Math.pow(intervention.getMoCaScroe() - a1.getMoCaScroe(), 2);
			mmseScroeT += Math.pow(intervention.getMMSEScroe() - a1.getMMSEScroe(), 2);
			if (i == userT.size()) {
				voc.setADLScoreC(Math.sqrt(ADLT / userT.size()));
				voc.setIADLScoreC(Math.sqrt(IADLT / userT.size()));
				voc.setMyodyNamia(Math.sqrt(myodyNamiaT / userT.size()));
				voc.setDingxiangli(Math.sqrt(dingxiangliT / userT.size()));
				voc.setZhuyili(Math.sqrt(zhuyiliT / userT.size()));
				voc.setJiyili(Math.sqrt(jiyiliT / userT.size()));
				voc.setYuyanli(Math.sqrt(yuyanliT / userT.size()));
				voc.setHuiyili(Math.sqrt(huiyiliT / userT.size()));
				voc.setChoxiang(Math.sqrt(choxiangT / userT.size()));
				voc.setShijiegou(Math.sqrt(shijiegouT / userT.size()));
				voc.setZhixingli(Math.sqrt(zhixingliT / userT.size()));
				voc.setJisuanli(Math.sqrt(jisuanliT / userT.size()));
				voc.setBodyWeight(Math.sqrt(BodyWeightT / userT.size())); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
				voc.setMyodyNamia(Math.sqrt(myodyNamiaT / userT.size()));// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
				voc.setXinfen(Math.sqrt(xinfenT / userT.size()));// 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
				voc.setRouruan(Math.sqrt(rouruanT / userT.size())); // 柔软素质得分分数越高柔软度越强，柔软素质得分可根据其性别、年龄层和双手相扣距离确认出其具体的柔软素质得分，对应表见(常模)；
				voc.setShenjing(Math.sqrt(shenjingT / userT.size()));// 神经反应能力得分为2.44米折返走速度，神经反应能力得分可根据其性别、年龄层和2.44米折返跑时间确认出其具体的神经反应能力得分，对应表见(常模)；；
				voc.setXueya(Math.sqrt(xueyaT / userT.size()));
				voc.setGDSScroe(Math.sqrt(GDSScroeT / userT.size()));
				voc.setMoCaScroe(Math.sqrt(mocaScroeT / userT.size()));
				voc.setMMSEScroe(Math.sqrt(mmseScroeT / userT.size()));
			}

		}
		return voc;
	}

}
