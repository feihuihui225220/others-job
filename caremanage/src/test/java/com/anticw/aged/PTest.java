package com.anticw.aged;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.dao.professional.assess.AssessRecordDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.professional.assess.AssessRecordAnswerVo;
import com.anticw.aged.vo.professional.assess.AssessRecordDetailVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml",
		"classpath:/spring/webApplicationContext.xml" })
public class PTest {

	@Autowired
	private RUserDao rUserDao;
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private AssessRecordDao assessRecordDao;
	@Autowired
	private AssessService assessService;

	@Test
	public void test() throws Exception {
		int mm = 0;
		int lendth = rUserDao.getUser();
		List<AssessUtil> li = new ArrayList<AssessUtil>();
		for (int i = 0; i < lendth;) {
			List<RUser> user = rUserDao.getUser(i, 1000);
			// Date das=DateUtil.parseStrToDate("2015-01-01");
			List<Object[]> vos = null;
			AssessUtil ass = null;
			List<AssessRecordDetailVo> assess = null;
			List<Date> date = null;
			for (RUser r : user) {
				vos = assessRecordDao.getList(r.getId());
				if(r.getCommunityId()==null){
					continue;
				}
				try {
					OCountry o=oCountryService.getCountryById(r.getCommunityId());
					String com=o.getName()==null?"未知社区":o.getName();
					ass.setoName(com);
					
					
					
				} catch (Exception e) {
					System.out.println(r.getCommunityId());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (vos.size() > 0) {
					mm++;
					ass = new AssessUtil();
					assess = new ArrayList<AssessRecordDetailVo>();
					date = new ArrayList<Date>();
					for (Object[] v : vos) {
						AssessRecordDetailVo vo = assessService
								.getAssessRecordDetailBydetail((String) v[2]);
						assess.add(vo);
						date.add((Date) v[3]);
					}
					ass.setAssess(assess);
					ass.setDate1(date);
					ass.setId(r.getId());
					ass.setName(r.getName());
					ass.setGender(r.getGender());
					if (r.getAge() != null) {
						// private String oName;
						ass.setAge(r.getAge());
					}
					if (r.getSpecia() != null
							&& r.getSpecia().getDisable() != null) {
						ass.setDisplay(r.getSpecia().getDisable());
					}
					if (r.getMarry() != null) {
						ass.setMarry(r.getMarry());
					}
					if (r.getEducation() != null) {
						ass.setEducation(r.getEducation());
					}
					if (r.getReligion() != null) {
						ass.setReligion(r.getReligion());
					}
					if (r.getJobCond() != null) {
						ass.setJobCond(r.getJobCond());
					}

					li.add(ass);
				}
			}
			 i += 1000;
		}
		for (AssessUtil a : li) {
			System.out.println(a.getName());
		}
		exportExcel(li);
		System.out.println(li.size() + "==========" + lendth + "===" + mm);

	}

	/*
	 * private Integer display; //"失能与否 private Integer marry;//婚姻状况 private
	 * Integer education;//文化程度 private Integer religion;//宗教信仰 private Integer
	 * jobCond;//从业情况"
	 */public static void exportExcel(List<AssessUtil> li) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(372, "否");
		map.put(370, "中度失能");
		map.put(227, "重度失能");
		map.put(226, "轻度失能");
		map.put(297, "自理");
		map.put(254, "不详");
		map.put(192, "丧偶");
		map.put(253, "其他");
		map.put(252, "再婚");
		map.put(250, "离婚");
		map.put(222, "未婚");
		map.put(193, "已婚");
		map.put(261,"不详");  
		map.put(201,"文盲或半文盲");  
		map.put(200,"小学");  
		map.put(198,"初中");  
		map.put(203,"中专");  
		map.put(199,"高中");  
		map.put(202,"大专");  
		map.put(204,"大学"); 
		map.put(260,"研究生");  
		map.put(223,"其他"); 
		map.put(247,"不详");
		map.put(367,"其他");
		map.put(308," 无");
		map.put(309,"道教");
		map.put(244,"伊斯兰教");
		map.put(307,"天主教");
		map.put(246,"佛教");
		map.put(245,"基督教");
		map.put(286,"不详");
		map.put(369,"专业技术人员");
		map.put(205,"退（离）休");
		map.put(330,"退养");
		map.put(329,"自谋职业");
		map.put(328,"灵活就业");
		map.put(206,"无业");
		map.put(327,"失业");
		map.put(284,"在职");
		map.put(207,"其他");
		
		WritableWorkbook book = null;
		try {
			// 打开文件
			book = Workbook.createWorkbook(new File("D:/adl.xls"));
			// 生成名为"学生"的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("Iadl量表导出", 0);
			// 指定单元格位置是第一列第一行(0, 0)以及单元格内容为张三
			int column = 0;
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
			Label label6 = new Label(column, 1, "失能与否");
			sheet.addCell(label6);
			column++;
			Label label7 = new Label(column, 1, "婚姻状况");
			sheet.addCell(label7);
			column++;
			Label label8 = new Label(column, 1, "文化程度");
			sheet.addCell(label8);
			column++;
			Label label9 = new Label(column, 1, "宗教信仰");
			sheet.addCell(label9);
			column++;
			Label label10 = new Label(column, 1, "从业情况");
			sheet.addCell(label10);
			column++;
			int row = 2;
			for (int i = 0; i < li.size(); i++) {
				AssessUtil vo1 = li.get(i);
				for (int j = 0; j < vo1.getAssess().size(); j++) {
					int column1 = 0;
					AssessRecordDetailVo vo = vo1.getAssess().get(j);
					Date data=vo1.getDate1().get(j);
					System.out.println(vo1.getName() + "xxxxxxxx");
					Label label11 = new Label(column1, row, vo1.getId()
							.toString());
					sheet.addCell(label11);
					column1++;
					Label label12 = new Label(column1, row, vo1.getName());
					sheet.addCell(label12);
					column1++;
					Label label13 = new Label(column1, row,
							vo1.getGender() == 1 ? "男" : "女");
					sheet.addCell(label13);
					column1++;
					Label label14 = new Label(column1, row, vo1.getAge()
							.toString());
					sheet.addCell(label14);
					column1++;
					Label label15;
					if (vo1.getoName() != null) {
						label15 = new Label(column1, row, vo1.getoName());
					} else {
						label15 = new Label(column1, row, "");
					}
					sheet.addCell(label15);
					column1++;
					Label label16;
					if (vo1.getDisplay() != null) {
						label16 = new Label(column1, row,map.get( vo1.getDisplay()));
					} else {
						label16 = new Label(column1, row, " ");
					}
					sheet.addCell(label16);
					column1++;
					Label label17;
					if (vo1.getMarry() != null) {
						label17 = new Label(column1, row,map.get( vo1.getMarry()) 
								);
					} else {
						label17 = new Label(column1, row, " ");
					}
					sheet.addCell(label17);
					column1++;
					Label label18;
					if (vo1.getEducation() != null) {
						label18 = new Label(column1, row, map.get(vo1.getEducation()) 
								 );
					} else {
						label18 = new Label(column1, row, " ");
					}
					sheet.addCell(label18);
					column1++;
					Label label19;
					if (vo1.getEducation() != null) {
						label19 = new Label(column1, row,map.get(vo1.getEducation())  
								 );
					} else {
						label19 = new Label(column1, row, " ");
					}
					sheet.addCell(label19);
					column1++;
					Label label20;
					if (vo1.getJobCond() != null) {
						label20 = new Label(column1, row,map.get(vo1.getJobCond())   
								 );
					} else {
						label20 = new Label(column1, row, " ");
					}
					sheet.addCell(label20);
					column1++;
					Label label30;
						label30 = new Label(column1, row, DateUtil.getCurrentFormatDate(data));
				
					sheet.addCell(label30);
					column1++;
					for (int m = 0; m < vo.getResult().size(); m++) {
						AssessRecordAnswerVo vox = vo.getResult().get(m);
						sheet.addCell(new Label(column1, row, vox
								.getAnswerName()));
						column1++;
						sheet.addCell(new Label(column1, row, vox
								.getQuestionName()));
						column1++;
						sheet.addCell(new Label(column1, row, vox.getScore()
								.toString()));
						column1++;
					}
					sheet.addCell(new Label(column1, row, vo.getConclusion()));
					column1++;
					row++;
				}
			}

			book.write();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
