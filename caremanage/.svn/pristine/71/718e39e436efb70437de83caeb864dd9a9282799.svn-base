package com.anticw.aged.service.community.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.professional.vender.MUserVenderDao;
import com.anticw.aged.dao.professional.vender.VenderUserDao;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.assess.AssessRecordAnswerVo;
import com.anticw.aged.vo.professional.assess.AssessRecordDetailVo;
import com.anticw.aged.vo.professional.vender.MyBeanWithPerson;
import com.anticw.aged.vo.professional.vender.QuestionVO;
import com.anticw.aged.vo.user.AssessUserVO;
import com.anticw.aged.vo.user.FeatureUserVO;
import com.anticw.aged.vo.user.FeatureVO;

@Service("userPolicyService")
public class UserPolicyService {
	private static Logger logger = LoggerFactory.getLogger(UserPolicyService.class);
	@Autowired
	private VenderUserDao VenderUserDao;
	@Autowired
	private MUserVenderDao mUserVenderDao;

	@Autowired
	private AssessService AssessService;

	/**
	 * 特征信息
	 * 
	 * @author dx
	 * @param workbook
	 * @param userVO
	 * @param oCategoryItem
	 * @param mUserVender
	 * @param feat
	 * @throws Exception
	 */
	public void exportExcel(WritableWorkbook workbook, UserVO userVO, Map<Integer, String> oCategoryItem,
			MUserVender mUserVender, FeatureVO feat) throws Exception {
		WritableSheet sheet = workbook.createSheet("汇总", 0);
		List<FeatureUserVO> vo = null;
		if (userVO.isSuper_()) {
			vo = mUserVenderDao.getVenderFeatureList(userVO.getVenderId(), mUserVender, oCategoryItem, feat);
		} else {
			vo = VenderUserDao.getVenderFeatureList(userVO.getVenderId(), mUserVender, oCategoryItem, feat,
					(int) userVO.getId());
		}
		vo = this.getFeatureUserVO(vo, feat);
		int column = 0;
		Label label0 = new Label(column, 0, "序号");
		sheet.addCell(label0);
		column++;
		Label label1 = new Label(column, 0, "姓名");
		sheet.addCell(label1);
		column++;
		Label label2 = new Label(column, 0, "身份证号");
		sheet.addCell(label2);
		column++;
		Label label3 = new Label(column, 0, "性别");
		sheet.addCell(label3);
		column++;
		Label label4 = new Label(column, 0, "其他属性");
		sheet.addCell(label4);
		column++;
		int row = 1;
		for (FeatureUserVO up : vo) {
			int column1 = 0;
			Label label10 = new Label(column1, row, row + "");
			sheet.addCell(label10);
			column1++;
			if (up.getUserName() != null) {
				Label label11 = new Label(column1, row, up.getUserName());
				sheet.addCell(label11);
			} else {
				Label label11 = new Label(column1, row, "缺失");
				sheet.addCell(label11);
			}
			column1++;
			if (up.getUserIdCard() != null) {
				Label label12 = new Label(column1, row, up.getUserIdCard());
				sheet.addCell(label12);
			} else {
				Label label12 = new Label(column1, row, "暂无");
				sheet.addCell(label12);
			}
			column1++;
			if (up.getUserSex() == 1) {
				Label label13 = new Label(column1, row, "男");
				sheet.addCell(label13);
			} else {
				Label label13 = new Label(column1, row, "女");
				sheet.addCell(label13);
			}
			column1++;
			Label label14 = new Label(column1, row, up.getRest());
			sheet.addCell(label14);
			column1++;
			row++;
		}
	}

	public final static MyBeanWithPerson myBeanWithPerson(String json, Map<String, Class<QuestionVO>> classMap) {
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(JSONObject.fromObject(json),
				MyBeanWithPerson.class, classMap);
		return diyBean;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public java.util.List List(List<AssessUserVO> vo1) {
		List<List> li = new ArrayList<List>();
		MyBeanWithPerson diyBean = null;
		for (AssessUserVO vo : vo1) {
			try {
				if (vo.getType() == 0) {
					li.add(getAssessUserVO(vo));
				} else if (vo.getType() == 1) {
					li.add(AssessService.List1(vo));
				}
			} catch (Exception e) {
				logger.info("量表解析错误。。。", e);
				logger.info("量表解析错误对应量表信息:" + vo.toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return li;

	}

	@SuppressWarnings("rawtypes")
	public List getAssessUserVO(AssessUserVO vo) {
		Map<String, Class<QuestionVO>> classMap = new HashMap<String, Class<QuestionVO>>();
		classMap.put("result", QuestionVO.class);
		MyBeanWithPerson diyBean = null;
		String json = vo.getRecordDetail();
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(json);
		String strNoBlank = m.replaceAll("");
		json = strNoBlank.substring(1, strNoBlank.length() - 1);
		/* json = json.replaceAll("\r|\n", ""); */
		System.out.println(json);
		diyBean = myBeanWithPerson(json, classMap);
		List list = diyBean.getResult();
		return list;
	}

	/**
	 * 评估信息
	 * 
	 * @author dx
	 * @param workbook
	 * @param vo1
	 * @param dateCond
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void assessExcel(HttpSession session, WritableWorkbook workbook, List<AssessUserVO> vo1,
			DateParamVO dateCond, String assessName, String assessConclusion, String array1) throws Exception {
		// 首先先查看量表类型 组合体 分数提 开站评估
		List list = new ArrayList();
		list = List(vo1);
		String[] array = array1.split(",");
		boolean bean = Arrays.asList(array).contains("10");
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		WritableSheet sheet = workbook.createSheet("量表结论", 0);
		int column2 = 0;
		if (!assessName.equals("undefined")) {
			Label label01 = new Label(column2, 0, assessName);
			column2++;
			sheet.addCell(label01);
		}
		if (!assessConclusion.equals("undefined")) {
			Label label02 = new Label(column2, 0, assessConclusion);
			sheet.addCell(label02);
			column2++;
		}

		int column = 0;
		Label label0 = new Label(column, 1, "序号");
		sheet.addCell(label0);
		column++;
		Label label1 = new Label(column, 1, "用户Id");
		sheet.addCell(label1);
		column++;
		if (vo1.get(0).getType() == 0) {
			type1(vo1, assessName, assessConclusion, list, array, bean, sheet, column);
		} else if (vo1.get(0).getType() == 1) {
			type2(vo1, assessName, assessConclusion, list, array, bean, sheet, column);
		}
	}

	/**
	 * 评估信息
	 * 
	 * @author dx
	 * @param workbook
	 * @param vo1
	 * @param dateCond
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void assessExcel(HttpSession session, WritableWorkbook workbook, List<AssessUserVO> vo1,
			DateParamVO dateCond, String assessName, String assessConclusion) throws Exception {
		// 首先先查看量表类型 组合体 分数提 开站评估
		List list = new ArrayList();
		if (vo1.get(0).getType() == 0) {
			list = List(vo1);
		} else if (vo1.get(0).getType() == 1) {
			list = AssessService.List1(vo1);
		}

		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		WritableSheet sheet = workbook.createSheet("量表结论", 0);
		int column2 = 0;
		Label label01 = new Label(column2, 0, assessName);
		column2++;
		sheet.addCell(label01);
		Label label02 = new Label(column2, 0, assessConclusion);
		sheet.addCell(label02);
		column2++;

		int column = 0;
		Label label0 = new Label(column, 1, "序号");
		sheet.addCell(label0);
		column++;
		Label label1 = new Label(column, 1, "用户Id");
		sheet.addCell(label1);
		column++;
		Label label2 = new Label(column, 1, "姓名");
		sheet.addCell(label2);
		column++;
		Label label3 = new Label(column, 1, "性别");
		sheet.addCell(label3);
		column++;
		Label label4 = new Label(column, 1, "年龄");
		sheet.addCell(label4);
		column++;
		Label label5 = new Label(column, 1, "社区");
		sheet.addCell(label5);
		column++;

		Label label7 = new Label(column, 1, "添加时间");
		sheet.addCell(label7);
		column++;
		if (vo1.get(0).getType() == 0) {
			typecm1(vo1, list, sheet, column);
		} else if (vo1.get(0).getType() == 1) {
			typecm2(vo1, list, sheet, column);
		}

	}

	@SuppressWarnings("rawtypes")
	private void typecm2(List<AssessUserVO> vo1, List list, WritableSheet sheet, int column)
			throws WriteException, RowsExceededException {
		AssessRecordDetailVo assessRecordDetailVo = (AssessRecordDetailVo) list.get(0);
		for (int j = 0; j < assessRecordDetailVo.getResult().size(); j++) {
			sheet.addCell(new Label(column, 1, "第" + (j + 1) + "题"));
			column++;
			sheet.addCell(new Label(column, 1, "选项"));
			column++;
			sheet.addCell(new Label(column, 1, "分值"));
			column++;
		}
		sheet.addCell(new Label(column, 1, "分项结论"));
		column++;
		AssessRecordDetailVo vo = null;
		int row = 2;
		// 获取老人信息
		for (int i = 0; i < vo1.size(); i++) {
			int column1 = 0;
			Label label10 = new Label(column1, row, row - 1 + "");
			sheet.addCell(label10);
			column1++;
			Label label111 = new Label(column1, row, vo1.get(i).getId().toString());
			sheet.addCell(label111);
			column1++;
			Label label11 = new Label(column1, row, vo1.get(i).getName());
			sheet.addCell(label11);
			column1++;
			if (vo1.get(i).getGender() == 1) {
				Label label12 = new Label(column1, row, "男");
				sheet.addCell(label12);
			} else {
				Label label12 = new Label(column1, row, "女");
				sheet.addCell(label12);
			}
			column1++;
			if (vo1.get(i).getAge() != null) {
				Label label13 = new Label(column1, row, vo1.get(i).getAge().toString());
				sheet.addCell(label13);
			} else {
				Label label13 = new Label(column1, row, "暂无");
				sheet.addCell(label13);
			}
			column1++;
			Label label14 = new Label(column1, row, vo1.get(i).getCommunityName());
			sheet.addCell(label14);
			column1++;

			Label label16 = new Label(column1, row, DateUtil.getCurrentFormatDate(vo1.get(i).getCreatedAt()));
			sheet.addCell(label16);
			column1++;

			vo = (AssessRecordDetailVo) list.get(i);
			for (int j = 0; j < vo.getResult().size(); j++) {
				AssessRecordAnswerVo vox = vo.getResult().get(j);
				sheet.addCell(new Label(column1, row, vox.getQuestionName()));
				column1++;
				sheet.addCell(new Label(column1, row, vox.getAnswerName()));
				column1++;
				sheet.addCell(new Label(column1, row, vox.getScore().toString()));
				column1++;
			}
			sheet.addCell(new Label(column1, row, vo.getConclusion()));
			column1++;
			row++;
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private void typecm1(List<AssessUserVO> vo1, List list, WritableSheet sheet, int column)
			throws WriteException, RowsExceededException {
		List li1 = (java.util.List) list.get(0);
		for (int j = 0; j < li1.size(); j++) {
			if (li1.get(j) instanceof QuestionVO) {
				QuestionVO p = (QuestionVO) li1.get(j);
				sheet.addCell(new Label(column, 1, "第" + (j + 1) + "题"));
				column++;
				sheet.addCell(new Label(column, 1, "选项"));
				column++;
				sheet.addCell(new Label(column, 1, "分值"));
				column++;
			}
		}

		int row = 2;
		// 获取老人信息
		for (int i = 0; i < vo1.size(); i++) {
			int column1 = 0;
			Label label10 = new Label(column1, row, row - 1 + "");
			sheet.addCell(label10);
			column1++;
			Label label111 = new Label(column1, row, vo1.get(i).getId().toString());
			sheet.addCell(label111);
			column1++;
			Label label11 = new Label(column1, row, vo1.get(i).getName());
			sheet.addCell(label11);
			column1++;
			if (vo1.get(i).getGender() == 1) {
				Label label12 = new Label(column1, row, "男");
				sheet.addCell(label12);
			} else {
				Label label12 = new Label(column1, row, "女");
				sheet.addCell(label12);
			}
			column1++;
			if (vo1.get(i).getAge() != null) {
				Label label13 = new Label(column1, row, vo1.get(i).getAge().toString());
				sheet.addCell(label13);
			} else {
				Label label13 = new Label(column1, row, "暂无");
				sheet.addCell(label13);
			}
			column1++;
			Label label14 = new Label(column1, row, vo1.get(i).getCommunityName());
			sheet.addCell(label14);
			column1++;

			Label label16 = new Label(column1, row, DateUtil.getCurrentFormatDate(vo1.get(i).getCreatedAt()));
			sheet.addCell(label16);
			column1++;

			List li = (java.util.List) list.get(i);
			for (int j = 0; j < li.size(); j++) {

				if (li.get(j) instanceof QuestionVO) {
					QuestionVO p = (QuestionVO) li.get(j);
					sheet.addCell(new Label(column1, row, p.getQuestion_name()));
					column1++;
					sheet.addCell(new Label(column1, row, p.getAnswer_name()));
					column1++;
					sheet.addCell(new Label(column1, row, p.getScore()));
					column1++;
				}
			}
			row++;
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private void type1(List<AssessUserVO> vo1, String assessName, String assessConclusion, List list, String[] array,
			boolean bean, WritableSheet sheet, int column) throws WriteException, RowsExceededException {
		List li1 = (java.util.List) list.get(0);
		for (String str : array) {
			if ("0".equals(str)) {
				Label label2 = new Label(column, 1, "姓名");
				sheet.addCell(label2);
				column++;
			} else if ("1".equals(str)) {
				Label label8 = new Label(column, 1, "身份证号");
				sheet.addCell(label8);
				column++;
			} else if ("2".equals(str)) {
				Label label3 = new Label(column, 1, "性别");
				sheet.addCell(label3);
				column++;
			} else if ("3".equals(str)) {
				Label label4 = new Label(column, 1, "年龄");
				sheet.addCell(label4);
				column++;
			} else if ("4".equals(str)) {
				Label label6 = new Label(column, 1, "站点");
				sheet.addCell(label6);
				column++;
			} else if ("5".equals(str)) {
				Label label5 = new Label(column, 1, "社区");
				sheet.addCell(label5);
				column++;
			} else if ("6".equals(str)) {
				Label label9 = new Label(column, 1, "量表名称");
				sheet.addCell(label9);
				column++;
			} else if ("7".equals(str)) {
				Label label7 = new Label(column, 1, "添加时间");
				sheet.addCell(label7);
				column++;
			} else if ("8".equals(str)) {
				Label labe20 = new Label(column, 1, "主要结论");
				sheet.addCell(labe20);
				column++;
			} else if ("9".equals(str)) {
				for (int j = 0; j < li1.size(); j++) {
					if (li1.get(j) instanceof QuestionVO) {
						QuestionVO p = (QuestionVO) li1.get(j);
						sheet.addCell(new Label(column, 1, "第" + (j + 1) + "题"));
						column++;
						sheet.addCell(new Label(column, 1, "选项"));
						column++;
						if (bean) {
							sheet.addCell(new Label(column, 1, "分值"));
							column++;
						}
					}
				}
			}
		}
		// Label labe20 = new Label(column, 1,
		// "主要结论");sheet.addCell(labe21);column++;
		int row = 2;
		// 获取老人信息
		for (int i = 0; i < list.size(); i++) {
			try {
				int column1 = 0;
				Label label10 = new Label(column1, row, row - 1 + "");
				sheet.addCell(label10);
				column1++;
				Label label111 = new Label(column1, row, vo1.get(i).getId().toString());
				sheet.addCell(label111);
				column1++;
				List li = (java.util.List) list.get(i);
				for (String str : array) {
					if ("0".equals(str)) {
						Label label11 = new Label(column1, row, vo1.get(i).getName());
						sheet.addCell(label11);
						column1++;
					} else if ("1".equals(str)) {
						Label label19 = new Label(column1, row, vo1.get(i).getIdCardNo());
						sheet.addCell(label19);
						column1++;
					} else if ("2".equals(str)) {
						Label label12 = new Label(column1, row, vo1.get(i).getGender() == 1 ? "男" : "女");
						sheet.addCell(label12);
						column1++;
					} else if ("3".equals(str)) {
						Label label13 = new Label(column1, row,
								vo1.get(i).getAge() == null ? "未知" : vo1.get(i).getAge().toString());
						sheet.addCell(label13);
						column1++;
					} else if ("4".equals(str)) {
						Label label15 = new Label(column1, row, vo1.get(i).getSiteName());
						sheet.addCell(label15);
						column1++;
					} else if ("5".equals(str)) {
						Label label14 = new Label(column1, row, vo1.get(i).getCommunityName());
						sheet.addCell(label14);
						column1++;
					} else if ("6".equals(str)) {
						Label label20 = new Label(column1, row, vo1.get(i).getAssessName());
						sheet.addCell(label20);
						column1++;
					} else if ("7".equals(str)) {
						Label label16 = new Label(column1, row,
								DateUtil.getCurrentFormatDate(vo1.get(i).getCreatedAt()));
						sheet.addCell(label16);
						column1++;
					} else if ("8".equals(str)) {
						Label label21 = new Label(column1, row, vo1.get(i).getConContent());
						sheet.addCell(label21);
						column1++;
					} else if ("9".equals(str)) {
						for (int j = 0; j < li.size(); j++) {
							if (li.get(j) instanceof QuestionVO) {
								QuestionVO p = (QuestionVO) li.get(j);
								sheet.addCell(new Label(column1, row, p.getQuestion_name()));
								column1++;
								sheet.addCell(new Label(column1, row, p.getAnswer_name()));
								column1++;
								if (bean) {
									sheet.addCell(new Label(column1, row, p.getScore()));
									column1++;
								}
							}
						}
					}

				}
				row++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void type2(List<AssessUserVO> vo1, String assessName, String assessConclusion, List list, String[] array,
			boolean bean, WritableSheet sheet, int column) throws WriteException, RowsExceededException {
		AssessRecordDetailVo assessRecordDetailVo = (AssessRecordDetailVo) list.get(0);
		for (String str : array) {
			if ("0".equals(str)) {
				Label label2 = new Label(column, 1, "姓名");
				sheet.addCell(label2);
				column++;
			} else if ("1".equals(str)) {
				Label label8 = new Label(column, 1, "身份证号");
				sheet.addCell(label8);
				column++;
			} else if ("2".equals(str)) {
				Label label3 = new Label(column, 1, "性别");
				sheet.addCell(label3);
				column++;
			} else if ("3".equals(str)) {
				Label label4 = new Label(column, 1, "年龄");
				sheet.addCell(label4);
				column++;
			} else if ("4".equals(str)) {
				Label label6 = new Label(column, 1, "站点");
				sheet.addCell(label6);
				column++;
			} else if ("5".equals(str)) {
				Label label5 = new Label(column, 1, "社区");
				sheet.addCell(label5);
				column++;
			} else if ("6".equals(str)) {
				Label label9 = new Label(column, 1, "量表名称");
				sheet.addCell(label9);
				column++;
			} else if ("7".equals(str)) {
				Label label7 = new Label(column, 1, "添加时间");
				sheet.addCell(label7);
				column++;
			} else if ("8".equals(str)) {
				Label labe20 = new Label(column, 1, "主要结论");
				sheet.addCell(labe20);
				column++;
			} else if ("9".equals(str)) {
				for (int j = 0; j < assessRecordDetailVo.getResult().size(); j++) {
					sheet.addCell(new Label(column, 1, "第" + (j + 1) + "题"));
					column++;
					sheet.addCell(new Label(column, 1, "选项"));
					column++;
					if (bean) {
						sheet.addCell(new Label(column, 1, "分值"));
						column++;
					}
				}
				sheet.addCell(new Label(column, 1, "分项结论"));
				column++;
			}
		}

		int row = 2;
		// 获取老人信息
		for (int i = 0; i < vo1.size(); i++) {
			AssessRecordDetailVo v1 = (AssessRecordDetailVo) list.get(i);
			int column1 = 0;
			Label label10 = new Label(column1, row, row - 1 + "");
			sheet.addCell(label10);
			column1++;
			Label label111 = new Label(column1, row, vo1.get(i).getId().toString());
			sheet.addCell(label111);
			column1++;
			for (String str : array) {
				if ("0".equals(str)) {
					Label label11 = new Label(column1, row, vo1.get(i).getName());
					sheet.addCell(label11);
					column1++;
				} else if ("1".equals(str)) {
					Label label19 = new Label(column1, row, vo1.get(i).getIdCardNo());
					sheet.addCell(label19);
					column1++;
				} else if ("2".equals(str)) {
					Label label12 = new Label(column1, row, vo1.get(i).getGender() == 1 ? "男" : "女");
					sheet.addCell(label12);
					column1++;
				} else if ("3".equals(str)) {
					Label label13 = new Label(column1, row,
							vo1.get(i).getAge() == null ? "未知" : vo1.get(i).getAge().toString());
					sheet.addCell(label13);
					column1++;
				} else if ("4".equals(str)) {
					Label label15 = new Label(column1, row, vo1.get(i).getSiteName());
					sheet.addCell(label15);
					column1++;
				} else if ("5".equals(str)) {
					Label label14 = new Label(column1, row, vo1.get(i).getCommunityName());
					sheet.addCell(label14);
					column1++;
				} else if ("6".equals(str)) {
					Label label20 = new Label(column1, row, assessName);
					sheet.addCell(label20);
					column1++;
				} else if ("7".equals(str)) {
					Label label16 = new Label(column1, row, DateUtil.getCurrentFormatDate(vo1.get(i).getCreatedAt()));
					sheet.addCell(label16);
					column1++;
				} else if ("8".equals(str)) {
					Label label21 = new Label(column1, row, assessConclusion);
					sheet.addCell(label21);
					column1++;
				} else if ("9".equals(str)) {
					for (int j = 0; j < v1.getResult().size(); j++) {
						AssessRecordAnswerVo vo = v1.getResult().get(j);
						sheet.addCell(new Label(column1, row, vo.getQuestionName()));
						column1++;
						sheet.addCell(new Label(column1, row, vo.getAnswerName()));
						column1++;
						if (bean) {
							sheet.addCell(new Label(column1, row, vo.getScore().toString()));
							column1++;
						}
					}
					sheet.addCell(new Label(column1, row, v1.getConclusion()));
					column1++;
				}

			}
			row++;
		}
	}

	public List<FeatureUserVO> getFeatureUserVO(List<FeatureUserVO> vo, FeatureVO feat) {
		int i = 0;
		List<FeatureUserVO> vs = new ArrayList<FeatureUserVO>();
		for (FeatureUserVO v : vo) {
			FeatureUserVO va = new FeatureUserVO();
			Map<String, Integer> map = vo.get(i).getMap();
			map.remove(feat.getExhibition());
			String result = "";
			for (String s : map.keySet()) {
				if (map.get(s) != 225 && s == "three" && feat.getExhibition() != "three") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 372 && s == "disable" && feat.getExhibition() != "disable") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 231 && s == "lonely" && feat.getExhibition() != "lonely") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 229 && s == "noSecurity" && feat.getExhibition() != "noSecurity") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 233 && s == "lessIncome" && feat.getExhibition() != "lessIncome") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 298 && s == "emptyNest" && feat.getExhibition() != "emptyNest") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 237 && s == "lostOnly" && feat.getExhibition() != "lostOnly") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 239 && s == "specialCare" && feat.getExhibition() != "specialCare") {
					result = "有其他特征信息!";
				}
				if (map.get(s) != 299 && s == "lifeLonely" && feat.getExhibition() != "lifeLonely") {
					result = "有其他特征信息!";
				}
				if ("".endsWith(result) | result == null) {
					result = "没有其他特征信息!";
				}
			}
			va.setRest(result);
			va.setUserIdCard(v.getUserIdCard());
			va.setUserName(v.getUserName());
			va.setUserSex(v.getUserSex());
			vs.add(va);
			i++;

		}

		return vs;
	}
}
