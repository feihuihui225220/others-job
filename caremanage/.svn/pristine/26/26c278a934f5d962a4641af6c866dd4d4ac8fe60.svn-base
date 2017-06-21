package com.anticw.aged.controller.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.MAssessFitness;
import com.anticw.aged.bean.ZAssess;
import com.anticw.aged.bean.ZCombo;
import com.anticw.aged.bean.ZFitness;
import com.anticw.aged.bean.ZFitnessConclusion;
import com.anticw.aged.bean.ZSubscriber;
import com.anticw.aged.controller.professional.fitness.FitnessCtl;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.icare.ZAssessService;
import com.anticw.aged.service.icare.combo.ComboService;
import com.anticw.aged.service.icare.combo.ZCourseService;
import com.anticw.aged.service.icare.combo.ZFitnessConclusionService;
import com.anticw.aged.service.icare.combo.ZFitnessService;
import com.anticw.aged.service.icare.combo.ZSubscriberService;
import com.anticw.aged.service.professional.AssessService;
import com.anticw.aged.service.professional.activity.NProgramService;
import com.anticw.aged.service.professional.fitness.FitnessService;
import com.anticw.aged.utils.CusAccessObjectUtil;
import com.anticw.aged.vo.icare.ZCourserVO;
import com.anticw.aged.vo.professional.activity.MAssessFitnessVO;
import com.anticw.aged.vo.professional.activity.NProgramVO;
import com.anticw.aged.vo.professional.assess.AssessVO;

@Controller
@RequestMapping("/WeiXin")
public class ConnectorWeiXinController {

	@Autowired
	private ComboService comboService;

	@Autowired
	private ZFitnessService zFitnessService;

	@Autowired
	private ZAssessService zAssessService;

	@Autowired
	private ZFitnessConclusionService conclusionService;

	@Autowired
	private NProgramService nProgramService;

	@Autowired
	private FitnessService fitnessService;

	@Autowired
	private FitnessCtl fitnessCtl;

	@Autowired
	private AssessService assessService;

	@Autowired
	private ZSubscriberService zSubscriberService;

	@Autowired
	private ZCourseService zCourseService;

	@Autowired
	private SpringDataPool springDataPool;

	/**
	 * 返回体适能介绍视频
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zfitness/zfitnessAll")
	@ResponseBody
	public List<ZFitness> getVodio(HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return zFitnessService.getListz();
	}

	/**
	 * 量表展示
	 * 
	 * @param assessId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zfitness/assess")
	@ResponseBody
	public AssessVO getAssess(int assessId, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// return
		// JSONArray.fromObject(zFitnessService.getAssess(assessId)).toString();
		return zFitnessService.getAssess(assessId);
	}

	/**
	 * 去订阅页面
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/assess/ToAssess")
	@ResponseBody
	public JSONObject ToAssess(HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return null;
	}

	/**
	 * 体适能评估
	 * 
	 * @param session
	 * @param maFitness
	 * @param userId
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/addfitAssess/assess")
	@ResponseBody
	public MAssessFitnessVO insertFitnessWeiXin(HttpSession session, MAssessFitness maFitness,
			HttpServletRequest request, HttpServletResponse response)
					throws IllegalAccessException, InvocationTargetException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// request.setAttribute("userId", userId);
		@SuppressWarnings("unused")
		String sex = (String) request.getParameter("sex");
		maFitness = fitnessCtl.detectResult(null, request, maFitness);
		MAssessFitness massess = fitnessService.insertFitness(maFitness);
		List<ZFitnessConclusion> conclusion = null;
		MAssessFitnessVO vo = new MAssessFitnessVO();
		BeanUtils.copyProperties(vo, massess);
		conclusion = conclusionService.getList(1);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeOne() != null && massess.getGradeOne() != ""
					&& get(massess.getGradeOne()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId1(ab.getComboId());
						vo.setComboName1(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl1(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(2);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeTwo() != null && massess.getGradeTwo() != ""
					&& get(massess.getGradeTwo()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId2(ab.getComboId());
						vo.setComboName2(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl2(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(3);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeThree() != null && massess.getGradeThree() != ""
					&& get(massess.getGradeThree()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId3(ab.getComboId());
						vo.setComboName3(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl3(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(4);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeFour() != null && massess.getGradeFour() != ""
					&& get(massess.getGradeFour()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId4(ab.getComboId());
						vo.setComboName4(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl4(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(5);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeFive() != null && massess.getGradeFive() != "" && massess.getGradeFive() != ""
					&& get(massess.getGradeFive()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId5(ab.getComboId());
						vo.setComboName5(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl5(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(6);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeSix() != null && massess.getGradeSix() != ""
					&& get(massess.getGradeSix()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId6(ab.getComboId());
						vo.setComboName6(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl6(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(7);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeSeven() != null && massess.getGradeSeven() != ""
					&& get(massess.getGradeSeven()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId7(ab.getComboId());
						vo.setComboName7(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl7(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(8);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGradeEight() != null && massess.getGradeEight() != ""
					&& get(massess.getGradeEight()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId8(ab.getComboId());
						vo.setComboName8(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl8(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(9);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGrade9() != null && massess.getGrade9() != ""
					&& get(massess.getGrade9()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId9(ab.getComboId());
						vo.setComboName9(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl9(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(10);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGrade10() != null && massess.getGrade10() != ""
					&& get(massess.getGrade10()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId10(ab.getComboId());
						vo.setComboName10(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl10(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(11);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGrade11() != null && massess.getGrade11() != ""
					&& get(massess.getGrade11()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId11(ab.getComboId());
						vo.setComboName11(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl11(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(12);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGrade12() != null && massess.getGrade12() != ""
					&& get(massess.getGrade12()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId12(ab.getComboId());
						vo.setComboName12(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl12(ab.getImgUrl());
						}
					}
				}
			}
		}
		conclusion = conclusionService.getList(13);
		for (ZFitnessConclusion z : conclusion) {
			if (massess.getGrade13() != null && massess.getGrade13() != ""
					&& get(massess.getGrade13()).equals(z.getFitnessConclusion())) {
				if (z.getComboId() != null) {
					ZCombo ab = comboService.getById(z.getComboId());
					if (ab != null) {
						vo.setComboId13(ab.getComboId());
						vo.setComboName13(ab.getComboName());
						if (ab.getImgUrl() != null) {
							vo.setImgUrl13(ab.getImgUrl());
						}
					}
				}
			}

		}
		return vo;// JSONArray.fromObject(vo).toString();
	}

	public static String get(String str) {
		String regex = "([\u4e00-\u9fa5]+)";
		Matcher matcher = Pattern.compile(regex).matcher(str);
		if (matcher.find()) {
			return matcher.group(0);
		}
		return null;
	}

	/**
	 * 获取对应的套餐中的课程
	 * 
	 * @param comboId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zassess/vedio")
	@ResponseBody
	public String getAssessVedio(int comboId, HttpServletResponse response) throws Exception {
		return JSONArray.fromObject(comboService.getVO1(comboId)).toString();
		// 此处原本计划导出所有课程 现在是导出套餐所有信息
	}

	/**
	 * 线上评估类型
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/oCategoryItem/listAll")
	@ResponseBody
	public String getoCategoryItemList(HttpServletResponse response) throws Exception {
		// List<OCategoryItem> cit = zAssessService.getAssessList(page, num);
		return JSONArray.fromObject(zAssessService.getList()).toString();
	}

	/**
	 * 类型下对应的所有量表以及此类型的背景图片
	 * 
	 * @param oCategoryItemId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/oCategoryItem/asessAndimg")
	@ResponseBody
	public JSONObject getoCategoryItemList(int zId, HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		ZAssess z = zAssessService.getAssessById(zId);
		if (z.getBgUrl() != null) {
			json.put("backgroundImg", z.getBgUrl());
		}
		json.put("assessTable", assessService.getList(z.getTitle()));
		// OCategoryItem o=oCategoryItemService.getItemName(oCategoryItemId);
		return json;
	}
	/*********************************** 按照日历展示套餐 ****************************************/

	/**
	 * 获取免费的套餐 此处需要修改 按照日历展示出来
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combos/course")
	@ResponseBody
	public String course(HttpServletResponse response, Integer page) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (page != null) {
			page = 1;
		}
		return JSONArray.fromObject(comboService.getZComboAll(page)).toString();
	}

	/**
	 * 获取个人定制课程
	 * 
	 * @param response
	 * 
	 * 
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combos/coursenpr")
	@ResponseBody
	public JSONObject coursenpr(HttpServletResponse response, Long userId) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// comboService.getNProgramAll(id);
		Map<String, Set<NProgramVO>> communal = zSubscriberService.getList(userId);
		List<ZCourserVO> vos = zCourseService.getDate(new java.util.Date(), userId);
		JSONObject json = new JSONObject();
		json.put("communal", communal);
		json.put("vip", vos);
		return json;
	}

	/**
	 * 订阅
	 * 
	 * @param response
	 * @param comboId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/combos/saveCommunal")
	@ResponseBody
	public String saveCommunal(HttpServletResponse response, int comboId, Long userId) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		zSubscriberService.save(comboId, userId);
		return "success";
	}

	@RequestMapping("/combos/removeCommunal")
	@ResponseBody
	public String removeCommunal(HttpServletResponse response, Long userId) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		zSubscriberService.update(userId);
		return "success";
	}

	@RequestMapping("/combos/removeCommunalCombo")
	@ResponseBody
	public String removeCommunal(HttpServletResponse response, Long userId, Integer comboId) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ZSubscriber z = zSubscriberService.getZSubscriber(userId, comboId);
		if (z != null) {
			zSubscriberService.update(z.getId());
		}
		return "success";
	}

	/**
	 * 课程悦览
	 * 
	 * @param page
	 * @param response
	 * @return
	 */
	@RequestMapping("/combos/combosList")
	@ResponseBody
	public com.alibaba.fastjson.JSONObject getZComboAll(Integer page, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (page == null) {
			page = 1;
		}
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		json.put("zComboAll", comboService.getZComboAll(page));
		return json;
	}

	/**
	 * 课程悦览中的课程（免费）
	 * 
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/combos/nPrograms")
	@ResponseBody
	public com.alibaba.fastjson.JSONObject getVO1(Integer id, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		json.put("nPrograms", comboService.getNProgramAll(id));
		return json;
	}

	@RequestMapping("/combos/nproMap")
	@ResponseBody
	public JSONObject nproMap(HttpServletResponse response, int id, Long userId) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// comboService.getNProgramAll(id);
		Map<String, Set<NProgramVO>> communal = zSubscriberService.getList(id);
		JSONObject json = new JSONObject();
		if (userId != null) {
			List<ZSubscriber> zs = zSubscriberService.getZSubscribers(userId);
			for (ZSubscriber z : zs) {
				if (z.getComboId() == id) {
					json.put("dingyue", true);
					break;
				} else {
					json.put("dingyue", false);
				}
			}
			// json.put("list", );
		}
		json.put("communal", communal);
		return json;
	}

	/**
	 * type=0 课程； type=1 套餐
	 * 
	 * @param type
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/pageView")
	@ResponseBody
	public String pageView(HttpServletResponse response, int type, int id, HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String ip = CusAccessObjectUtil.getIpAddress(request);
		if (type == 0) {
			int num = springDataPool.getnprPage(id, ip);
			if (num == 0) {
				return "defeat";
			}
			nProgramService.update(id);
			return "success";
		} else {
			int num = springDataPool.getcomboPage(id, ip);
			if (num == 0) {
				return "defeat";
			}
			comboService.update(id);
			return "success";
		}
	}

	@RequestMapping("/thumbs")
	@ResponseBody
	public int thumbs(HttpServletResponse response, int id, Long userId) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return nProgramService.update(id, userId);
	}
}
