package com.anticw.aged.controller.professional.fitness;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MAssessFitness;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.professional.fitness.FitnessService;
import com.anticw.aged.vo.permission.UserVO;

@Controller
@RequestMapping("fitness")
public class FitnessCtl {
	/**
	 * 体适能基本信息
	 */
	@Autowired
	private FitnessService fitnessService;
	/**
	 * 老人基本信息
	 */
	@Autowired
	private RUserService rUserService;

	/**
	 * 评估页
	 * 
	 * @return
	 */
	@RequestMapping("fitness")
	public String goToPage(Long userId, HttpServletRequest request) {
		RUser user = rUserService.findById(userId);
		request.setAttribute("user", user);
		return "professional/handle/fitness";
	}

	/**
	 * 添加评估
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("added")
	public String insertFitness(HttpSession session, MAssessFitness maFitness,
			Long userId, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException {
		// request.setAttribute("userId", userId);
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		maFitness = detectResult(userId, request, maFitness);
		maFitness.setCreateBy(userVO.getName());
		maFitness.setCreateTime(Date.valueOf(request
				.getParameter("create_time")));
		RUser user = rUserService.findById(userId);
		maFitness.setName(user.getName());
		maFitness.setUser(user);
		fitnessService.insertFitness(maFitness);
		return "redirect:/fitness/result?userId=" + userId;// 添加后跳转入结果页面
	}

	/**
	 * 跳转到评估结果页面
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("result")
	public ModelAndView resultPage(Long userId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("professional/handle/result");
		List<MAssessFitness> result = fitnessService.selectResult(userId);
		MAssessFitness list = result.get(0);

		mav.addObject("result", list);
		mav.addObject("id", list.getId());
		mav.addObject("name", list.getName());
		mav.addObject("age", list.getAge());
		mav.addObject("sex", list.getSex());
		mav.addObject("result1", list.getResultOne());
		mav.addObject("result2", list.getResultTwo());
		mav.addObject("result3", list.getResultThree());
		mav.addObject("result4", list.getResultFour());
		mav.addObject("result5", list.getResultFive());
		mav.addObject("result6", list.getResultSix());
		mav.addObject("result7", list.getResultSeven());
		mav.addObject("result8", list.getResultEight());
		mav.addObject("result9", list.getResult9());
		mav.addObject("result10", list.getResult10());
		mav.addObject("result11", list.getResult11());
		mav.addObject("result12", list.getResult12());
		mav.addObject("result13", list.getResult13());

		mav.addObject("grade1", list.getGradeOne());
		mav.addObject("grade2", list.getGradeTwo());
		mav.addObject("grade3", list.getGradeThree());
		mav.addObject("grade4", list.getGradeFour());
		mav.addObject("grade5", list.getGradeFive());
		mav.addObject("grade6", list.getGradeSix());
		mav.addObject("grade7", list.getGradeSeven());
		mav.addObject("grade8", list.getGradeEight());
		mav.addObject("grade9", list.getGrade9());
		mav.addObject("grade10", list.getGrade10());
		mav.addObject("grade11", list.getGrade11());
		mav.addObject("grade12", list.getGrade12());
		mav.addObject("grade13", list.getGrade13());

		mav.addObject("advice1", list.getAdviceOne());
		mav.addObject("advice2", list.getAdviceTwo());
		mav.addObject("advice3", list.getAdviceThree());
		mav.addObject("advice4", list.getAdviceFour());
		mav.addObject("advice5", list.getAdviceFive());
		mav.addObject("advice6", list.getAdviceSix());
		mav.addObject("advice7", list.getAdviceSeven());
		mav.addObject("advice8", list.getAdviceEight());
		mav.addObject("advice9", list.getAdvice9());
		mav.addObject("advice10", list.getAdvice10());
		mav.addObject("advice11", list.getAdvice11());
		mav.addObject("advice12", list.getAdvice12());
		mav.addObject("advice13", list.getAdvice13());
		mav.addObject("createTime", list.getCreateTime());
		return mav;
	}

	/**
	 * 查看近一个月评估记录
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView listResult(Long userId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("professional/handle/fitnessRecord");
		List<MAssessFitness> result = fitnessService.listResult(userId);
		mav.addObject("list", result);
		return mav;
	}

	@RequestMapping("delete")
	public ModelAndView deleteFitness(Integer resultId) {
		ModelAndView mav = new ModelAndView("professional/handle/fitnessRecord");
		fitnessService.delete(resultId);
		return mav;
	}

	@RequestMapping("resultDetail")
	public ModelAndView ResultDetail(Integer resultId) {
		ModelAndView mav = new ModelAndView("professional/handle/fitnessDetail");
		List<MAssessFitness> detail = fitnessService
				.getResultDetailByTime(resultId);
		MAssessFitness list = detail.get(0);

		mav.addObject("result", list);
		mav.addObject("id", list.getId());
		mav.addObject("name", list.getName());
		mav.addObject("age", list.getAge());
		mav.addObject("sex", list.getSex());
		mav.addObject("result1", list.getResultOne());
		mav.addObject("result2", list.getResultTwo());
		mav.addObject("result3", list.getResultThree());
		mav.addObject("result4", list.getResultFour());
		mav.addObject("result5", list.getResultFive());
		mav.addObject("result6", list.getResultSix());
		mav.addObject("result7", list.getResultSeven());
		mav.addObject("result8", list.getResultEight());
		mav.addObject("result9", list.getResult9());
		mav.addObject("result10", list.getResult10());
		mav.addObject("result11", list.getResult11());
		mav.addObject("result12", list.getResult12());
		mav.addObject("result13", list.getResult13());
		
		
		mav.addObject("grade1", list.getGradeOne());
		mav.addObject("grade2", list.getGradeTwo());
		mav.addObject("grade3", list.getGradeThree());
		mav.addObject("grade4", list.getGradeFour());
		mav.addObject("grade5", list.getGradeFive());
		mav.addObject("grade6", list.getGradeSix());
		mav.addObject("grade7", list.getGradeSeven());
		mav.addObject("grade8", list.getGradeEight());
		mav.addObject("grade9", list.getGrade9());
		mav.addObject("grade10", list.getGrade10());
		mav.addObject("grade11", list.getGrade11());
		mav.addObject("grade12", list.getGrade12());
		mav.addObject("grade13", list.getGrade13());

		mav.addObject("advice1", list.getAdviceOne());
		mav.addObject("advice2", list.getAdviceTwo());
		mav.addObject("advice3", list.getAdviceThree());
		mav.addObject("advice4", list.getAdviceFour());
		mav.addObject("advice5", list.getAdviceFive());
		mav.addObject("advice6", list.getAdviceSix());
		mav.addObject("advice7", list.getAdviceSeven());
		mav.addObject("advice8", list.getAdviceEight());
		mav.addObject("advice9", list.getAdvice9());
		mav.addObject("advice10", list.getAdvice10());
		mav.addObject("advice11", list.getAdvice11());
		mav.addObject("advice12", list.getAdvice12());
		mav.addObject("advice13", list.getAdvice13());
		mav.addObject("createTime", list.getCreateTime());
		return mav;
	}

	/*
	 * 分析评估内容
	 */
	public MAssessFitness detectResult(Long userId,
			HttpServletRequest request, MAssessFitness maFitness) {
		int sex=-1;
		if(userId==null&&request.getParameter("userId")!=null){
			userId = Long.valueOf(request.getParameter("userId"));
			RUser user = rUserService.findById(userId);
			maFitness.setName(user.getName());
			maFitness.setUser(user);
		}else if(userId!=null){
			RUser user = rUserService.findById(userId);
			sex = user.getGender();
			maFitness.setUser(user);
		}
		if(sex==-1){
			@SuppressWarnings("unused")
			String x=request.getParameter("sex");
			sex= Integer.valueOf(request.getParameter("sex"));
		}
		@SuppressWarnings("unused")
		String date=request
				.getParameter("create_time");
		maFitness.setCreateTime(Date.valueOf(request
				.getParameter("create_time")));
		int age = Integer.valueOf(request.getParameter("age"));
		// int sex = Integer.valueOf(request.getParameter("sex"));
		// int result1 = Integer.valueOf(request.getParameter("result1"));
		// //30s座站 （次）
		return getfitness(request, maFitness, age, sex);
	}

	public MAssessFitness getfitness(HttpServletRequest request,
			MAssessFitness maFitness, int age, int sex) {
		String grade1 = "";
		String advice1 = "";

		String grade2 = "";
		String advice2 = "";

		String grade3 = "";
		String advice3 = "";

		String grade4 = "";
		String advice4 = "";

		String grade5 = "";
		String advice5 = "";

		String grade6 = "";
		String advice6 = "";

		String grade7 = "";
		String advice7 = "";

		String grade8 = "";
		String advice8 = "";
		
		String grade9 = "";
		String advice9 = "";
		
		String grade10 = "";
		String advice10 = "";
		
		String grade11 = "";
		String advice11 = "";
		
		String grade12 = "";
		String advice12 = "";
		
		String grade13 = "";
		String advice13 = "";
		// ----------------30S坐站---------------------
		// 判断性别

		if (sex == 1) {// 男性
			if (age > 40 && age < 64) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 > 0 && result1 <= 14) {
						grade1 = "稍差<=14";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 14 && result1 < 19) {
						grade1 = "14<正常<19";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 19) {
						// >=19
						grade1 = "较好>=19";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 12) {
						grade1 = "稍差<=12";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 12 && result1 < 18) {
						grade1 = "12<正常<18";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 > 19) {
						// >=18
						grade1 = "较好";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 12) {
						grade1 = "稍差<=12";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 12 && result1 < 17) {
						grade1 = "12<正常<17";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 17) {
						// >=17
						grade1 = "较好>=17";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 11) {
						grade1 = "稍差<=11";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 11 && result1 < 17) {
						grade1 = "11<正常<17";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 17) {
						// >=17
						grade1 = "较好>=17";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 10) {
						grade1 = "稍差<=10";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 10 && result1 < 15) {
						grade1 = "10<正常<15";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 15) {
						// >=15
						grade1 = "较好>=15";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 8) {
						grade1 = "稍差<=8";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 8 && result1 < 14) {
						grade1 = "8<正常<14";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 14) {
						// >=14
						grade1 = "较好>=14";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 7) {
						grade1 = "稍差<=7";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 7 && result1 < 12) {
						grade1 = "7<正常<12";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 12) {
						// >=12
						grade1 = "较好>=12";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			}
		} else {// 女性
			if (age > 40 && age < 64) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 > 0 && result1 <= 12) {
						grade1 = "稍差<=12";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 12 && result1 < 17) {
						grade1 = "12<正常<17";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 17) {
						// >=17
						grade1 = "较好<=17";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 11) {
						grade1 = "稍差<=11";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 11 && result1 < 16) {
						grade1 = "11<正常<16";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 16) {
						// >=16
						grade1 = "较好>=16";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 10) {
						grade1 = "稍差<=10";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 10 && result1 < 15) {
						grade1 = "10<正常<15";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 15) {
						// >=15
						grade1 = "较好>=15";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 10) {
						grade1 = "稍差<=10";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 10 && result1 < 15) {
						grade1 = "10<正常<15";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 15) {
						// >=15
						grade1 = "较好>=15";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 9) {
						grade1 = "稍差<=9";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 9 && result1 < 14) {
						grade1 = "9<正常<14";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 14) {
						// >=14
						grade1 = "较好>=14";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 8) {
						grade1 = "稍差<=8";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 8 && result1 < 13) {
						grade1 = "8<正常<13";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 13) {
						// >=13
						grade1 = "较好>=13";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result1str = request.getParameter("result1");
				Integer result1 = null;
				if (result1str!=null&&!"".equals(result1str)) {
					result1 = Integer.valueOf(result1str);
					if (result1 <= 4) {
						grade1 = "稍差<=4";
						advice1 = "下肢肌力稍差，说明您最近日常生活可能有所困难。需要循序渐进地进行下肢肌力训练，但需要进一步筛查，排除危险性。";
					} else if (result1 > 4 && result1 < 11) {
						grade1 = "4<正常<11";
						advice1 = "下肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行下肢肌力训练以缓解肌力下降的趋势。";
					} else if (result1 >= 11) {
						// >=11
						grade1 = "较好>=11";
						advice1 = "下肢肌力很好，说明您最近可以独立处理日常生活。同时进行下肢肌力训练可以维持其肌力。";
					}
				}
			}
		}
		// ----------------两分钟抬腿---------------------
		// 判断性别
		if (sex == 1) {// 男性
			if (age > 40 && age < 64) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 > 0 && result2 <= 87) {
						grade2 = "稍差<=87";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 87 && result2 < 115) {
						grade2 = "87<正常<115";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 115) {
						// >=115
						grade2 = "较好>=115";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 86) {
						grade2 = "稍差<=86";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 86 && result2 < 116) {
						grade2 = "86<正常<116";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 116) {
						// >=116
						grade2 = "较好>=116";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 80) {
						grade2 = "稍差<=80";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 80 && result2 < 110) {
						grade2 = "80<正常<110";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 110) {
						// >=110
						grade2 = "较好>=110";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 77) {
						grade2 = "稍差<=77";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 77 && result2 < 109) {
						grade2 = "77<正常<109";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 109) {
						// >=109
						grade2 = "较好>=109";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 71) {
						grade2 = "稍差<=71";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 71 && result2 < 103) {
						grade2 = "71<正常<103";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 103) {
						// >=103
						grade2 = "较好>=103";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 59) {
						grade2 = "稍差<=59";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 59 && result2 < 91) {
						grade2 = "59<正常<91";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 91) {
						// >=91
						grade2 = "较好>=91";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 52) {
						grade2 = "稍差<=52";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 52 && result2 < 86) {
						grade2 = "52<正常<86";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 86) {
						// >=86
						grade2 = "较好>=86";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			}
		} else {// 女性
			if (age > 40 && age < 64) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 75) {
						grade2 = "稍差<=75";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 75 && result2 < 107) {
						grade2 = "75<正常<107";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 107) {
						// >=107
						grade2 = "较好>=107";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 73) {
						grade2 = "稍差<=73";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 73 && result2 < 107) {
						grade2 = "73<正常<107";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 107) {
						// >=107
						grade2 = "较好>107";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 68) {
						grade2 = "稍差<=68";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 68 && result2 < 101) {
						grade2 = "68<正常<101";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 101) {
						// >=101
						grade2 = "较好>=101";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 68) {
						grade2 = "稍差<=68";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 68 && result2 < 100) {
						grade2 = "68<正常<100";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 100) {
						// >=100
						grade2 = "较好>=100";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 40) {
						grade2 = "稍差<=40";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 40 && result2 < 90) {
						grade2 = "40<正常<90";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 90) {
						// >=90
						grade2 = "较好>=90";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 55) {
						grade2 = "稍差<=55";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 55 && result2 < 85) {
						grade2 = "55<正常<85";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 85) {
						// >=85
						grade2 = "较好>=85";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result2str = request.getParameter("result2");
				Integer result2 = null;
				if (result2str!=null&&!"".equals(result2str)) {
					result2 = Integer.valueOf(result2str);
					if (result2 <= 44) {
						grade2 = "稍差<=44";
						advice2 = "有氧耐力稍差，说明您最近不能维持较长时间的日常生活。需要增加有氧锻炼，但需要进一步筛查，排除危险性。";
					} else if (result2 > 44 && result2 < 72) {
						grade2 = "44<正常<72";
						advice2 = "有氧耐力正常，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					} else if (result2 >= 72) {
						// >=72
						grade2 = "较好>=72";
						advice2 = "有氧耐力很好，说明您最近体力充沛。定期进行有氧运动增强其耐力。";
					}
				}
			}
		}
		// ----------------双手背后相扣---------------------
		// 判断性别
		if (sex == 1) {// 男性
			if (age > 40 && age < 64) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -6.6) {
						grade3 = "稍差<=-6.6";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -6.6 && result3 < -0.2) {
						grade3 = "-6.6<正常<-0.2";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -0.2) {
						// >=-0.2
						grade3 = "较好>= -0.2";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -7.4) {
						grade3 = "稍差<= -7.4";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -7.4 && result3 < -0.8) {
						grade3 = " -7.4<正常< -0.8";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -0.8) {
						// >=-0.8
						grade3 = "较好>= -0.8";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -7.8) {
						grade3 = "稍差<= -7.8";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -7.8 && result3 < -1.2) {
						grade3 = "-7.8<正常< -1.2";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -1.2) {
						// >=-1.2
						grade3 = "较好>= -1";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -9) {
						grade3 = "稍差<= -9";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -9 && result3 < -2.2) {
						grade3 = "-9<正常< -2.2";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -2.2) {
						// >=-2.2
						grade3 = "较好>= -2.2";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -9.3) {
						grade3 = "稍差<= -9.3";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -9.3 && result3 < -2.1) {
						grade3 = "-9.3<正常< -2.1";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -2.1) {
						// >=-2.1
						grade3 = "较好>= -2.1";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -9.4) {
						grade3 = "稍差<= -9.4";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -9.4 && result3 < -3) {
						grade3 = "-9.4<正常< -3";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -3) {
						// >=-3
						grade3 = "较好>= -3";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -10.4) {
						grade3 = "稍差<= -10.4";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -10.4 && result3 < -3) {
						grade3 = "-10.4<正常< -3";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -3) {
						// >=-3
						grade3 = "较好>= -3";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			}
		} else {// 女性
			if (age > 40 && age < 64) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -3) {
						grade3 = "稍差<= -3";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -3 && result3 < 1.6) {
						grade3 = "-3<正常< 1.6";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= 1.6) {
						// >=1.6
						grade3 = "较好>= 1.6";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -3.7) {
						grade3 = "稍差<= -3.7";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -3.7 && result3 < 1.3) {
						grade3 = "-3.7<正常< 1.3";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= 1.3) {
						// >=1.3
						grade3 = "较好>=1.3";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -4.2) {
						grade3 = "稍差<= -4.2";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -4.2 && result3 < 0.8) {
						grade3 = "-4.2<正常<0.8";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= 0.8) {
						// >=0.8
						grade3 = "较好>= 0.8";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -4.8) {
						grade3 = "稍差<= -4.8";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -4.8 && result3 < 0.6) {
						grade3 = "-4.8<正常< 0.6";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= 0.6) {
						// >=0.6
						grade3 = "较好>= 0.6";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -5.4) {
						grade3 = "稍差<= -5.4";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -5.4 && result3 < 0.2) {
						grade3 = "-5.4<正常< 0.2";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= 0.2) {
						// >=0.2
						grade3 = "较好>= 0.2";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -6.9) {
						grade3 = "稍差<= -6.9";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -6.9 && result3 < -0.9) {
						grade3 = "-6.9<正常< -0.9";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -0.9) {
						// >=-0.9
						grade3 = "较好>= -0.9";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result3str = request.getParameter("result3");
				Double result3 = null;
				if (result3str!=null&&!"".equals(result3str)) {
					result3 = Double.valueOf(result3str);
					if (result3 <= -8) {
						grade3 = "稍差<= -8";
						advice3 = "上肢柔韧稍差，说明您最近梳头、搓澡等活动有一定的难度。应增强上肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (result3 > -8 && result3 < -1) {
						grade3 = "-8<正常< -1";
						advice3 = "上肢柔韧正常，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以提高其柔韧性。";
					} else if (result3 >= -1) {
						// >=-1
						grade3 = "较好>= -1";
						advice3 = "上肢柔韧很好，说明您最近可以轻松地进行梳头、搓澡等活动。定期进行上肢柔韧性练习可以维持其柔韧性。";
					}
				}
			}
		}
		// ----------------2.44米折返跑坐---------------------
		// 判断性别
		if (sex == 1) {// 男性
			if (age > 40 && age < 64) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 3.8) {
						grade4 = "较好";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 3.8 && result4 < 5.6) {
						grade4 = "正常";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 5.6) {
						// >=5.6
						grade4 = "稍差";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.3) {
						grade4 = "较好<= 4.3";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.3 && result4 < 5.9) {
						grade4 = "4.3<正常< 5.9";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 5.9) {
						// >=5.9
						grade4 = "稍差>= 5.9";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.4) {
						grade4 = "较好<= 4.4";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.4 && result4 < 6.2) {
						grade4 = "4.4<正常< 6.2";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 6.2) {
						// >=6.2
						grade4 = "稍差>= 6.2";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.2) {
						grade4 = "较好<= 4.2";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.2 && result4 < 7.6) {
						grade4 = "4.2<正常< 7.6";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 7.6) {
						// >=7.6
						grade4 = "稍差>= 7.6";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 5.2) {
						grade4 = "较好<= 5.2";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 5.2 && result4 < 7.6) {
						grade4 = "5.2<正常< 7.6";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 7.6) {
						// >=7.6
						grade4 = "稍差>= 7.6";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 5.5) {
						grade4 = "较好<= 5.5";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 5.5 && result4 < 8.9) {
						grade4 = "5.5<正常< 8.9";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 8.9) {
						// >=8.9
						grade4 = "稍差>= 8.9";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 6.2) {
						grade4 = "较好<= 6.2";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 6.2 && result4 < 10) {
						grade4 = "6.2<正常< 10";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 10) {
						// >=10
						grade4 = "稍差>= 10";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			}
		} else {// 女性
			if (age > 40 && age < 64) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.4) {
						grade4 = "较好<= 4.4";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.4 && result4 < 6.0) {
						grade4 = "4.4<正常< 6.0";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 6.0) {
						// >=6.0
						grade4 = "稍差>= 6.0";
						advice4 = "软度的平衡训练活动如：抬小腿、单脚站立（睁眼和闭眼）折返跑（走）、口令跑（走）曲折行走等。";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.8) {
						grade4 = "较好<= 4.8";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.8 && result4 < 6.4) {
						grade4 = "4.8<正常< 6.4";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 6.4) {
						// >=6.4
						grade4 = "稍差>= 6.4";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 4.9) {
						grade4 = "较好<= 4.9";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 4.9 && result4 < 7.1) {
						grade4 = "4.9<正常< 7.1";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 7.1) {
						// >=7.1
						grade4 = "稍差>= 7.1";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 5.2) {
						grade4 = "较好<= 5.2";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 5.2 && result4 < 7.4) {
						grade4 = "5.2<正常< 7.4";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 7.4) {
						// >=7.4
						grade4 = "稍差>= 7.4";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 5.7) {
						grade4 = "较好<=5.7";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 5.7 && result4 < 8.7) {
						grade4 = "5.7 <正常< 8.7";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 8.7) {
						// >=8.7
						grade4 = "稍差>= 8.7";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 6.2) {
						grade4 = "较好<= 6.2";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 6.2 && result4 < 9.6) {
						grade4 = "6.2<正常< 9.6";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 9.6) {
						// >=9.6
						grade4 = "稍差>= 9.6";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result4str = request.getParameter("result4");
				Double result4 = null;
				if (result4str!=null&&!"".equals(result4str)) {
					result4 = Double.valueOf(result4str);
					if (result4 <= 7.3) {
						grade4 = "较好<= 7.";
						advice4 = "敏捷与动态平衡很好，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 > 7.3 && result4 < 11.5) {
						grade4 = "7.3<正常< 11.5";
						advice4 = "敏捷与动态平衡正常，说明您最近很少发生跌倒。定期进行平衡锻炼可以减少跌倒发生率。";
					} else if (result4 >= 11.5) {
						// >=11.5
						grade4 = "稍差>= 11.5";
						advice4 = "敏捷与动态平衡稍差，说明您最近跌倒的发生率较高。需要增强平衡锻炼，但需要进一步筛查，排除危险性。";
					}
				}
			}
		}
		// ----------------握力---------------------
		// 判断性别
		if (sex == 1) {// 男性
			if (age > 40 && age < 64) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 30.3) {
						grade5 = "稍差<= 30.3";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 30.3 && result5 < 40.0) {
						grade5 = "30.3<正常< 40.0";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 40.0) {
						// >=40.0
						grade5 = "较好>= 40.0";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 30.9) {
						grade5 = "稍差<= 30.9";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 30.9 && result5 < 39.6) {
						grade5 = "30.9<正常< 39.6";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 39.6) {
						// >=39.6
						grade5 = "较好>= 39.6";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 28.7) {
						grade5 = "稍差<= 28.7";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 28.7 && result5 < 38.4) {
						grade5 = "28.7<正常< 38.4";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 38.4) {
						// >=38.4
						grade5 = "较好>= 38.4";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 24.8) {
						grade5 = "稍差<= 24.8";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 24.8 && result5 < 33.7) {
						grade5 = "24.8<正常< 33.7";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 33.7) {
						// >=33.7
						grade5 = "较好>= 33.7";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 23.2) {
						grade5 = "稍差<= 23.2";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 23.2 && result5 < 30.0) {
						grade5 = "23.2<正常< 30.0";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 30.0) {
						// >=30.0
						grade5 = "较好>= 30.0";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 84) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 20.6) {
						grade5 = "稍差<= 20.6";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 20.6 && result5 < 29) {
						grade5 = "20.6<正常< 29";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 29.0) {
						// >=29
						grade5 = "较好>= 29.0";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			}
		} else {// 女性
			if (age > 40 && age < 64) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 20.6) {
						grade5 = "稍差<= 20.6";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 20.6 && result5 < 26) {
						grade5 = "20.6<正常< 26";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 26.0) {
						// >=26
						grade5 = "较好>= 26.0";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 19.8) {
						grade5 = "稍差<= 19.8";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 19.8 && result5 < 26.4) {
						grade5 = "19.8<正常< 26.4";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 26.4) {
						// >=26.4
						grade5 = "较好>= 26.4";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 19.3) {
						grade5 = "稍差<= 19.3";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 19.3 && result5 < 25.6) {
						grade5 = "19.3<正常< 25.6";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 25.6) {
						// >=25.6
						grade5 = "较好>= 25.6";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 17.1) {
						grade5 = "稍差<= 17.1";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 17.1 && result5 < 22.3) {
						grade5 = "17.1<正常22.3";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 22.3) {
						// >=22.3
						grade5 = "较好>=22.3";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 15.2) {
						grade5 = "稍差<= 15.2";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 15.2 && result5 < 23.1) {
						grade5 = "15.2<正常< 23.1";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 23.1) {
						// >=23.1
						grade5 = "较好>= 23.1";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			} else if (age >= 84) {
				String result5str = request.getParameter("result5");
				Double result5 = null;
				if (result5str!=null&&!"".equals(result5str)) {
					result5 = Double.valueOf(result5str);
					if (result5 <= 17) {
						grade5 = "稍差<= 17";
						advice5 = "肌力肌耐力需加强如：自身体重作为负荷，进行坐站、推墙挺身等练习，通过弹力带进行系统的综合肌力训练";
					} else if (result5 > 17 && result5 < 23.1) {
						grade5 = "17<正常< 23.1";
						advice5 = "正常水平，生活之余可适当进行锻炼肌力的运动。";
					} else if (result5 >= 23.1) {
						// >=23.1
						grade5 = "较好>=23.1";
						advice5 = "继续保持正常的生活习惯";
					}
				}
			}
		}
		
		// ----------------身体质量指数--------------------
		if (sex == 1) {
			String result61str = request.getParameter("result61");
			String result62str = request.getParameter("result62");
			Double result6 = null;
			if (result61str!=null&&result62str!=null&&!"".equals(result61str) && !"".equals(result62str)) {
				double result61 = Double.valueOf(result61str);
				double result62 = Double.valueOf(result62str);
				double result66 = result62 * result62;
				result6 = result61 / result66;
				if (result6 < 18.5) {
					grade6 = "偏瘦<18.5";
					advice6 = "偏瘦，建议您进行科学的运动：以重量训练为主，最好少参加耐力性运动（如长跑）；合理的膳食：多样但不可偏食，除了食用富含动物性蛋白质的肉、蛋和奶，还要适当多吃豆类和豆制品及蔬菜和瓜果。";
				} else if (result6 >= 18.5 && result6 < 23.9) {
					grade6 = "18.5<=正常<23.9";
					advice6 = "标准，建议您维持现状，同时也要保持适当的运动量和膳食的摄入。";
				} else if (result6 >= 23.9 && result6 < 27.9) {
					grade6 = "23.9<=超重<27.9";
					advice6 = "超重，建议您经常进行有氧健身训练；膳食方面控制肉食和脂肪含量高的食品，多吃蔬菜（如黄瓜、白萝卜、韭菜、冬瓜、辣椒、大豆及豆制品等）。";
				} else if (result6 >= 27.9) {
					grade6 = "肥胖>=27.9";
					advice6 = "肥胖，建议您坚持快走、慢跑或者健身操，每周运动至少为3-4次，时间控制在30-40分钟；膳食方面减少脂肪及糖类的摄入，多吃富含水分、纤维素及能够促进排便、排尿的食物。";
				}
			}
		} else {
			String result61str = request.getParameter("result61");
			String result62str = request.getParameter("result62");
			Double result6 = null;
			if (result61str!=null&&result62str!=null&&!"".equals(result61str) && !"".equals(result62str)) {
				double result61 = Double.valueOf(result61str);
				double result62 = Double.valueOf(result62str);
				double result66 = result62 * result62;
				result6 = result61 / result66;
				if (result6 < 18) {
					grade6 = "偏瘦<18";
					advice6 = "偏瘦，建议您进行科学的运动：以重量训练为主，最好少参加耐力性运动（如长跑）；合理的膳食：多样但不可偏食，除了食用富含动物性蛋白质的肉、蛋和奶，还要适当多吃豆类和豆制品及蔬菜和瓜果。";
				} else if (result6 >= 18 && result6 < 24.9) {
					grade6 = "18<=正常< 24.9";
					advice6 = "标准，建议您维持现状，同时也要保持适当的运动量和膳食的摄入。";
				} else if (result6 > 24.9 && result6 < 29.9) {
					grade6 = "24.9<=超重<29.9";
					advice6 = "超重，建议您经常进行有氧健身训练；膳食方面控制肉食和脂肪含量高的食品，多吃蔬菜（如黄瓜、白萝卜、韭菜、冬瓜、辣椒、大豆及豆制品等）。";
				} else if (result6 >= 29.9) {
					grade6 = "肥胖>=29.9";
					advice6 = "肥胖，建议您坚持快走、慢跑或者健身操，每周运动至少为3-4次，时间控制在30-40分钟；膳食方面减少脂肪及糖类的摄入，多吃富含水分、纤维素及能够促进排便、排尿的食物。";
				}
			}
		}
		
		// ---------------腰臀比-------------------------
		if (sex == 1) {
			String result71str = request.getParameter("result71");
			String result72str = request.getParameter("result72");
			Double result7 = null;
			if (result71str!=null&&result72str!=null&&!"".equals(result71str) && !"".equals(result72str)) {
				double result71 = Double.valueOf(result71str);
				double result72 = Double.valueOf(result72str);
				result7 = result71 / result72;
				if (result7 <= 0.85) {
					grade7 = "健康<= 0.85";
					advice7 = "继续保持正常的生活习惯";
				} else if (0.85 < result7 && result7 <= 1.0) {
					grade7 = "0.85 <健康<= 1.0";
					advice7 = "继续保持正常的生活习惯";
				} else if (1.0 < result7) {
					grade7 = "中心性肥胖>1.0";
					advice7 = "建议每天做有氧运动，不喝酒，不暴饮暴食。";
				}
			}
		} else {
			String result71str = request.getParameter("result71");
			String result72str = request.getParameter("result72");
			Double result7 = null;
			if (result71str!=null&&result72str!=null&&!"".equals(result71str) && !"".equals(result72str)) {
				double result71 = Double.valueOf(result71str);
				double result72 = Double.valueOf(result72str);
				result7 = result71 / result72;
				if (result7 <= 0.6) {
					grade7 = "健康<= 0.6";
					advice7 = "继续保持正常的生活习惯";
				} else if (0.6 < result7 && result7 <= 0.85) {
					grade7 = "0.6<健康<= 0.85";
					advice7 = "继续保持正常的生活习惯";
				} else if (0.85 < result7) {
					grade7 = "中心性肥胖>0.85";
					advice7 = "建议每天做有氧运动，不喝酒，不暴饮暴食";
				}
			}
		}
		// ---------------------------座椅体前屈-------------------------------
		// 判断性别
		if (sex == 1) {
			if (age > 40 && age < 64) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -2.6) {
						grade8 = "稍差<= -2.6";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-2.6 < result8 && result8 < 3.8) {
						grade8 = "-2.6 <正常< 3.8";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3.8) {
						// >=3.8
						grade8 = "较好>= 3.8";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -3.1) {
						grade8 = "稍差<= -3.1";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-3.1 < result8 && result8 < 3.1) {
						grade8 = "-3.1 <正常< 3.1";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3.1) {
						// >=3.1
						grade8 = "较好>= 3.1";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -3.1) {
						grade8 = "稍差<= -3.1";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-3.1 < result8 && result8 < 3) {
						grade8 = "-3.1 <正常< 3";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3) {
						// >=3
						grade8 = "较好>= 3";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -4.2) {
						grade8 = "稍差<= -4.2";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-4.2 < result8 && result8 < 2) {
						grade8 = "-4.2 <正常< 2";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 2) {
						// >=2
						grade8 = "较好>= 2";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -5.3) {
						grade8 = "稍差<= -5.3";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-5.3 < result8 && result8 < 1.4) {
						grade8 = "-5.3 <正常< 1.4";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 1.4) {
						// >=1.4
						grade8 = "较好>= 1.4";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -5.2) {
						grade8 = "稍差<= -5.2";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-5.2 < result8 && result8 < 0.4) {
						grade8 = "-5.2 <正常< 0.4";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 0.4) {
						// >=0.4
						grade8 = "较好>= 0.4";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -6.5) {
						grade8 = "稍差<= -6.5";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-6.5 < result8 && result8 < 0.7) {
						grade8 = "-6.5 <正常< 0.7";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 0.7) {
						// >=0.7
						grade8 = "较好>= 0.7";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			}
		} else {// 女
			if (age > 40 && age < 64) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -0.6) {
						grade8 = "稍差<= -0.6";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-0.6 < result8 && result8 < 4.8) {
						grade8 = "-0.6 <正常< 4.8";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 4.8) {
						// >=4.8
						grade8 = "较好>= 4.8";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 64 && age < 69) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -0.4) {
						grade8 = "稍差<= -0.4";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-0.4 < result8 && result8 < 4.4) {
						grade8 = "-0.4 <正常< 4.4";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 4.4) {
						// >=4.4
						grade8 = "较好>= 4.4";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 69 && age < 74) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -1.1) {
						grade8 = "稍差<= -1.1";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-1.1 < result8 && result8 < 3.9) {
						grade8 = "-1.1 <正常< 3.9";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3.9) {
						// >=3.9
						grade8 = "较好>= 3.9";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 74 && age < 79) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -1.3) {
						grade8 = "稍差<= -1.3";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-1.3 < result8 && result8 < 3.7) {
						grade8 = "-1.3 <正常< 3.7";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3.7) {
						// >=3.7
						grade8 = "较好>= 3.7";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 79 && age < 84) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -2) {
						grade8 = "稍差<= -2";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-2 < result8 && result8 < 3) {
						grade8 = "-2 <正常< 3";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 3) {
						// >=3
						grade8 = "较好>=3";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 84 && age < 89) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -2.6) {
						grade8 = "稍差<= -2.6";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-2.6 < result8 && result8 < 2.4) {
						grade8 = "-2.6 <正常< 2.4";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 2.4) {
						// >=2.4
						grade8 = "较好>=2.4";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}
			} else if (age >= 89 && age < 100) {
				String result8str = request.getParameter("result8");
				Double result8 = null;
				if (result8str!=null&&!"".equals(result8str)) {
					result8 = Double.valueOf(result8str);
					if (result8 <= -4.4) {
						grade8 = "稍差<= -4.4";
						advice8 = "下肢柔韧稍差，说明您最近姿势、步态等活动不正常。应增强下肢柔韧性锻炼，但需要进一步筛查，排除危险性。";
					} else if (-4.4 < result8 && result8 < 1) {
						grade8 = "-4.4 <正常< 1";
						advice8 = "下肢柔韧正常，说明您最近可以维持良好的姿势、步态等活动。定期进行下肢柔韧性练习可以提高其柔韧性。";
					} else if (result8 >= 1) {
						// >=1
						grade8 = "较好>= 1";
						advice8 = "下肢柔韧很好，说明您最近可以维持良好的姿势、步态等活动。定期进行上肢柔韧性练习可以维持其柔韧性";
					}
				}

			}
		}
// ==========================30秒手臂卷起==============================================================
//========================== 30秒手臂卷起==============================================================				
		       // 判断性别

				if (sex == 1) {// 男性
					if (age > 40 && age < 64) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 > 0 && result9 <= 16) {
								grade9 = "稍差<=16";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 16 && result9 < 22) {
								grade9 = "16<正常<22";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 22) {
								// >=19
								grade9 = "较好>=22";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 64 && age < 69) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 15) {
								grade9 = "稍差<=15";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 15 && result9 < 21) {
								grade9 = "15<正常<21";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 21) {
								// >=21
								grade9 = "较好";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 69 && age < 74) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 14) {
								grade9 = "稍差<=14";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 14 && result9 < 21) {
								grade9 = "14<正常<21";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 21) {
								// >=21
								grade9 = "较好>=21";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 74 && age < 79) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 13) {
								grade9 = "稍差<=13";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 13 && result9 < 19) {
								grade9 = "13<正常<19";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 19) {
								// >=19
								grade9 = "较好>=19";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 79 && age < 84) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 13) {
								grade9 = "稍差<=13";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 13 && result9 < 19) {
								grade9 = "13<正常<19";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 19) {
								// >=19
								grade9 = "较好>=19";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 84 && age < 89) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 11) {
								grade9 = "稍差<=11";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 11 && result9 < 17) {
								grade9 = "11<正常<17";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 17) {
								// >=17
								grade9 = "较好>=17";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 89 && age < 100) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 10) {
								grade9 = "稍差<=10";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 10 && result9 < 14) {
								grade9 = "10<正常<14";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 14) {
								// >=12
								grade9 = "较好>=14";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					}
				} else {// 女性
					if (age > 40 && age < 64) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if ( result9 <= 13) {
								grade9 = "稍差<=13";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 13 && result9 < 19) {
								grade9 = "13<正常<19";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 19) {
								// >=19
								grade9 = "较好>=19";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 64 && age < 69) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 12) {
								grade9 = "稍差<=12";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 12 && result9 < 18) {
								grade9 = "12<正常<18";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 18) {
								// >=18
								grade9 = "较好>=18";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 69 && age < 74) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 12) {
								grade9 = "稍差<=12";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 12 && result9 < 17) {
								grade9 = "12<正常<17";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 17) {
								// >=17
								grade9 = "较好>=17";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 74 && age < 79) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 11) {
								grade9 = "稍差<=11";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 11 && result9 < 17) {
								grade9 = "11<正常<17";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 17) {
								// >=17
								grade9 = "较好>=17";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 79 && age < 84) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 10) {
								grade9 = "稍差<=10";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 10 && result9 < 16) {
								grade9 = "10<正常<16";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 16) {
								// >=16
								grade9 = "较好>=16";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 84 && age < 89) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 10) {
								grade9 = "稍差<=10";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 10 && result9 < 15) {
								grade9 = "10<正常<15";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 15) {
								// >=15
								grade9 = "较好>=15";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					} else if (age >= 89 && age < 100) {
						String result9str = request.getParameter("result9");
						Double result9 = null;
						if (result9str!=null&&!"".equals(result9str)) {
							result9 = Double.valueOf(result9str);
							if (result9 <= 8) {
								grade9 = "稍差<=8";
								advice9 = "上肢肌力稍差，说明您最近日常生活可能有所困难。可以循序渐进地进行上肢肌力训练，但需要进一步筛查，排除危险性。";
							} else if (result9 > 8 && result9 < 13) {
								grade9 = "8<正常<13";
								advice9 = "上肢肌力正常，说明您最近可以独立处理日常生活。需要定期进行上肢肌力训练以缓解肌力下降的趋势。";
							} else if (result9 >= 13) {
								// >=13
								grade9 = "较好>=13";
								advice9 = "上肢肌力很好，说明您最近可以独立处理日常生活。需要进行上肢肌力训练可以维持其肌力。";
							}
						}
					}
				}
 /*
  * ----------------------10.平衡感(闭眼硬表面)---------------------
    ----------------------10.平衡感(闭眼硬表面)---------------------
 */
				// 判断性别

				if (sex == 1) {// 男性
					if (age > 55 && age <= 59 ) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.99) {
								grade10 = "不好>= 0.99";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.78 && result10 < 0.99) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.65 && result10 < 0.78) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.52 && result10 < 0.65) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.52) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1) {
								grade10 = "不好>= 1";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.74 && result10 < 1) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.62 && result10 < 0.74) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.5 && result10 < 0.62) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.5) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 65 && age <= 69) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.01) {
								grade10 = "不好>= 1.01";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.75 && result10 < 1.01) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.65 && result10 < 0.75) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.55 && result10 < 0.65) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.55) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.99) {
								grade10 = "不好>= 0.99";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.79 && result10 < 0.99) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.65 && result10 < 0.79) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.53 && result10 < 0.65) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.53) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.02) {
								grade10 = "不好>= 1.02";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.79 && result10 < 1.02) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.66 && result10 < 0.79) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.56 && result10 < 0.66) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.56) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.06) {
								grade10 = "不好>= 1.06";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.86 && result10 < 1.06) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.67 && result10 < 0.86) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.59 && result10 < 0.67) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.59) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1) {
								grade10 = "不好>= 1";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.73 && result10 < 1) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.66 && result10 < 0.73) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.53 && result10 < 0.66) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.53) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.05) {
								grade10 = "不好>= 1.05";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.69 && result10 < 1.05) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.63 && result10 < 0.69) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.54 && result10 < 0.63) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.54) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					}
				} else {// 女性
					if (age > 55 && age <= 59) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.86) {
								grade10 = "不好>= 0.86";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.69 && result10 < 0.86) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.6 && result10 < 0.69) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.5 && result10 < 0.6) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.5) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.94) {
								grade10 = "不好>= 0.94";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.73 && result10 < 0.94) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.62 && result10 < 0.73) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.53 && result10 < 0.62) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.53) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					}else if (age >= 65 && age <= 69) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.93) {
								grade10 = "不好>= 0.93";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.71 && result10 < 0.93) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.61 && result10 < 0.71) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.51 && result10 < 0.61) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.51) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.97) {
								grade10 = "不好>= 0.97";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.76 && result10 < 0.97) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.63 && result10 < 0.76) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.53 && result10 < 0.63) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.53) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.1) {
								grade10 = "不好>= 1.1";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.76 && result10 < 1.1) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.65 && result10 < 0.76) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.55 && result10 < 0.65) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.55) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 1.03) {
								grade10 = "不好>= 1.03";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.81 && result10 < 1.03) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.67 && result10 < 0.81) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.57 && result10 < 0.67) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.57) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.98) {
								grade10 = "不好>= 0.98";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.73 && result10 < 0.98) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.66 && result10 < 0.73) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.53 && result10 < 0.66) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.53) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90 ) {
						String result10str = request.getParameter("result10");
						Double result10 = null;
						if (result10str!=null&&!"".equals(result10str)) {
							result10 = Double.valueOf(result10str);
							if (result10 >= 0.95) {
								grade10 = "不好>= 0.95";
								advice10 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result10 >= 0.77 && result10 < 0.95) {
								grade10 = "稍差";
								advice10 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result10 >= 0.7 && result10 < 0.77) {
								//
								grade10 = "普通";
								advice10 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result10 >= 0.61 && result10 < 0.7) {
								//
								grade10 = "尚好";
								advice10 = "继续保持正常的生活习惯";
							}else if (result10 < 0.61) {
								//
								grade10 = "很好";
								advice10 = "继续保持正常的生活习惯";
							}
						}
					}
				}
// ----------------==========11.常模（闭眼软表面）=====================---------------------
// ----------------==========11.常模（闭眼软表面）=====================---------------------
				// 判断性别

				if (sex == 1) {// 男性
					if (age > 55 && age <= 59 ) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.55) {
								grade11 = "不好>= 2.55";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 1.98 && reault11 < 2.55) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 0.69 && reault11 < 1.98) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 0.54 && reault11 < 0.69) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 0.54) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.57) {
								grade11 = "不好>= 2.57";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.02 && reault11 < 2.57) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.83 && reault11 < 2.02) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.56 && reault11 < 1.83) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.56) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 65 && age <= 69) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.58) {
								grade11 = "不好>= 2.58";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.02 && reault11 < 2.58) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.52 && reault11 < 2.02) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.2 && reault11 < 1.52) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.2) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.7) {
								grade11 = "不好>= 2.7";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.15 && reault11 < 2.7) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.9 && reault11 < 2.15) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.53 && reault11 < 1.9) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.53) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.85) {
								grade11 = "不好>= 2.85";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.25 && reault11 < 2.85) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.96 && reault11 < 2.25) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.7 && reault11 < 1.96) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.7) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.79) {
								grade11 = "不好>= 2.79";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.27 && reault11 < 2.79) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.98 && reault11 < 2.27) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.71 && reault11 < 1.98) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.71) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.89) {
								grade11 = "不好>= 2.89";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.22 && reault11 < 2.89) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.97 && reault11 < 2.22) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.62 && reault11 < 1.97) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.62) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.52) {
								grade11 = "不好>= 2.52";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.31 && reault11 < 2.52) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 2 && reault11 < 2.31) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.83 && reault11 < 2) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 <1.83) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					}
				} else {// 女性
					if (age > 55 && age <= 59) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.41) {
								grade11 = "不好>= 2.41";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 1.9 && reault11 < 2.41) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.65 && reault11 < 1.9) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.38 && reault11 < 1.65) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.38) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.63) {
								grade11 = "不好>= 2.63";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.09 && reault11 < 2.63) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.81 && reault11 < 2.09) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.55 && reault11 < 1.81) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.55) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					}else if (age >= 65 && age <= 69) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.53) {
								grade11 = "不好>= 2.53";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.1 && reault11 < 2.53) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.86 && reault11 < 2.1) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.55 && reault11 <1.86) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.55) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.65) {
								grade11 = "不好>= 2.65";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.12 && reault11 < 2.65) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.83 && reault11 < 2.12) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.58 && reault11 < 1.83) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.58) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.81) {
								grade11 = "不好>= 2.81";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.22 && reault11 < 2.81) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.93 && reault11 < 2.22) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.63 && reault11 <1.93) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.63) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.82) {
								grade11 = "不好>= 2.82";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.32 && reault11 < 2.82) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.98 && reault11 < 2.32) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.59 && reault11 < 1.98) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.59) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.74) {
								grade11 = "不好>= 2.74";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 2.3 && reault11 < 2.74) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.98 && reault11 < 2.3) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.78 && reault11 < 1.98) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.78) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90 ) {
						String reault11str = request.getParameter("reault11");
						Double reault11 = null;
						if (reault11str!=null&&!"".equals(reault11str)) {
							reault11 = Double.valueOf(reault11str);
							if (reault11 >= 2.6) {
								grade11 = "不好>= 2.6";
								advice11 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (reault11 >= 1.98 && reault11 < 2.6) {
								grade11 = "稍差";
								advice11 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (reault11 >= 1.94 && reault11 < 1.98) {
								//
								grade11 = "普通";
								advice11 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (reault11 >= 1.78 && reault11 < 1.94) {
								//
								grade11 = "尚好";
								advice11 = "继续保持正常的生活习惯";
							}else if (reault11 < 1.78) {
								//
								grade11 = "很好";
								advice11 = "继续保持正常的生活习惯";
							}
						}
					}
				}
// ------------------------------睁眼（软表面）---------------------------------------------------
// ------------------------------睁眼（软表面）---------------------------------------------------
				if (sex == 1) {// 男性
					if (age > 55 && age <= 59 ) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.12) {
								grade12 = "不好>= 1.12";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.9 && result12 < 1.12) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.76 && result12 < 0.9) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.62 && result12 < 0.76) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.62) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.24) {
								grade12 = "不好>= 1.24";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.92 && result12 < 1.24) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.78 && result12 < 0.92) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.62 && result12 < 0.78) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.62) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 65 && age <= 69) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.33) {
								grade12 = "不好>= 1.33";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.96 && result12 < 1.33) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.82 && result12 < 0.96) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.66 && result12 < 0.82) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.66) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.32) {
								grade12 = "不好>= 1.32";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.96 && result12 < 1.32) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.8 && result12 < 0.96) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.7 && result12 < 0.8) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.7) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.37) {
								grade12 = "不好>= 1.37";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.02 && result12 < 1.37) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.9 && result12 < 1.02) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.78 && result12 < 0.9) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.78) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.41) {
								grade12 = "不好>= 1.41";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.08 && result12 < 1.41) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.94 && result12 < 1.08) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.79 && result12 < 0.94) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.79) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.32) {
								grade12 = "不好>= 1.32";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.06 && result12 < 1.32) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.97 && result12 < 1.06) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.87 && result12 < 0.97) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.87) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.42) {
								grade12 = "不好>= 1.42";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.04 && result12 < 1.42) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.91 && result12 < 1.04) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.83 && result12 < 0.91) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 <0.83) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					}
				} else {// 女性
					if (age > 55 && age <= 59) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.12) {
								grade12 = "不好>= 1.12";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.84 && result12 < 1.12) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.68 && result12 < 0.84) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.58 && result12 < 0.68) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.58) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.17) {
								grade12 = "不好>= 1.17";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.9 && result12 < 1.17) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.78 && result12 < 0.9) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.66 && result12 < 0.78) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.66) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					}else if (age >= 65 && age <= 69) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.25) {
								grade12 = "不好>= 1.25";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.94 && result12 < 1.25) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.79 && result12 < 0.94) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.62 && result12 <0.79) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.62) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.27) {
								grade12 = "不好>= 1.27";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.98 && result12 < 1.27) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.84 && result12 < 0.98) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.7 && result12 < 0.84) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.7) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.31) {
								grade12 = "不好>= 1.31";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 0.99 && result12 < 1.31) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.87 && result12 < 0.99) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.73 && result12 < 0.87) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.73) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.43) {
								grade12 = "不好>= 1.43";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.08 && result12 < 1.43) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.95 && result12 < 1.08) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.81 && result12 < 0.95) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.81) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.59) {
								grade12 = "不好>= 1.59";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.05 && result12 < 1.59) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 0.92 && result12 < 1.05) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.8 && result12 < 0.92) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.8) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90 ) {
						String result12str = request.getParameter("result12");
						Double result12 = null;
						if (result12str!=null&&!"".equals(result12str)) {
							result12 = Double.valueOf(result12str);
							if (result12 >= 1.53) {
								grade12 = "不好>= 1.53";
								advice12 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result12 >= 1.26 && result12 < 1.53) {
								grade12 = "稍差";
								advice12 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result12 >= 1.02 && result12 < 1.26) {
								//
								grade12 = "普通";
								advice12 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result12 >= 0.9 && result12 < 1.02) {
								//
								grade12 = "尚好";
								advice12 = "继续保持正常的生活习惯";
							}else if (result12 < 0.9) {
								//
								grade12 = "很好";
								advice12 = "继续保持正常的生活习惯";
							}
						}
					}
				}

// ---------------------------睁眼硬表面------------------------------------
// ---------------------------睁眼硬表面------------------------------------				
				if (sex == 1) {// 男性
					if (age > 55 && age <= 59 ) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.78) {
								grade13 = "不好>= 0.78";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.59 && result13 < 0.78) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.51 && result13 < 0.59) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.39 && result13 < 0.51) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.39) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.65) {
								grade13 = "不好>= 0.65";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.55 && result13 < 0.65) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.46 && result13 < 0.55) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.38 && result13 < 0.46) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.38) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 65 && age <= 69) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.8) {
								grade13 = "不好>= 0.8";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.58 && result13 < 0.8) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.48 && result13 < 0.58) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.39 && result13 < 0.48) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.39) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.85) {
								grade13 = "不好>= 0.85";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.58 && result13 < 0.85) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.51 && result13 < 0.58) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.42 && result13 < 0.51) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.42) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.82) {
								grade13 = "不好>= 0.82";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.59 && result13 < 0.82) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.52 && result13 < 0.59) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.42 && result13 < 0.52) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.42) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >=0.8) {
								grade13 = "不好>= 0.8";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.61 && result13 < 0.8) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.53 && result13 < 0.61) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.45 && result13 < 0.53) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.45) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.82) {
								grade13 = "不好>= 0.82";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.63 && result13 < 0.82) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.55 && result13 < 0.63) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.45 && result13 < 0.55) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.45) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.93) {
								grade13 = "不好>= 0.93";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.69 && result13 < 0.93) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.63 && result13 < 0.69) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.54 && result13 < 0.63) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.54) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					}
				} else {// 女性
					if (age > 55 && age <= 59) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.71) {
								grade13 = "不好>= 0.71";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.54 && result13 < 0.71) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.45 && result13 < 0.54) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.38 && result13 < 0.45) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.38) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 60 && age <= 64) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.74) {
								grade13 = "不好>= 0.74";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.57 && result13 < 0.74) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.48 && result13 < 0.57) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.39 && result13 < 0.48) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.39) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					}else if (age >= 65 && age <= 69) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.76) {
								grade13 = "不好>= 0.76";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.56 && result13 < 0.76) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.47 && result13 < 0.56) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.39 && result13 < 0.47) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.39) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 70 && age <= 74) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.77) {
								grade13 = "不好>= 0.77";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.57 && result13 < 0.77) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.48 && result13 < 0.57) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.41 && result13 < 0.48) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.41) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 75 && age <= 79) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.78) {
								grade13 = "不好>= 0.78";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.59 && result13 < 0.78) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.52 && result13 < 0.59) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.41 && result13 < 0.52) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.41) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 80 && age <= 84) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.74) {
								grade13 = "不好>= 0.74";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.57 && result13 < 0.74) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.49 && result13 < 0.57) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.41 && result13 < 0.49) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.41) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 85 && age <= 89) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.75) {
								grade13 = "不好>= 0.75";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.59 && result13 < 0.75) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.49 && result13 < 0.59) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.42 && result13 < 0.49) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.42) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					} else if (age >= 90 ) {
						String result13str = request.getParameter("result13");
						Double result13 = null;
						if (result13str!=null&&!"".equals(result13str)) {
							result13 = Double.valueOf(result13str);
							if (result13 >= 0.86) {
								grade13 = "不好>= 0.86";
								advice13 = "平衡能力需加强，做针对性训练如：跨越障碍物行走、运动平面维持身体平衡、减少支撑基础的行走等。";
							} else if (result13 >= 0.63 && result13 < 0.86) {
								grade13 = "稍差";
								advice13 = "平衡能力稍差，建议做简单平衡锻炼如：闭眼站立、双脚一前一后站立、侧步走等。";
							} else if (result13 >= 0.55 && result13 < 0.63) {
								//
								grade13 = "普通";
								advice13 = "正常水平，生活之余可适当进行增强平衡能力的运动。";
							}else if (result13 >= 0.44 && result13 < 0.55) {
								//
								grade13 = "尚好";
								advice13 = "继续保持正常的生活习惯";
							}else if (result13 < 0.44) {
								//
								grade13 = "很好";
								advice13 = "继续保持正常的生活习惯";
							}
						}
					}
				}

		MAssessFitness m = maFitness;
		String result1str = request.getParameter("result1");
		Integer result1 = null;
		if (result1str!=null&&!"".equals(result1str)) {
			result1 = Integer.valueOf(result1str);
			m.setResultOne(result1);
		}
		String result2str = request.getParameter("result2");
		Integer result2 = null;
		if (result2str!=null&&!"".equals(result2str)) {
			result2 = Integer.valueOf(result2str);
			m.setResultTwo(result2);
		}
		String result3str = request.getParameter("result3");
		Double result3 = null;
		if (result3str!=null&&!"".equals(result3str)) {
			result3 = Double.valueOf(result3str);
			m.setResultThree(result3);
		}

		String result4str = request.getParameter("result4");
		Double result4 = null;
		if (result4str!=null&&!"".equals(result4str)) {
			result4 = Double.valueOf(result4str);
			m.setResultFour(result4);
		}
		String result5str = request.getParameter("result5");
		Double result5 = null;
		if (result5str!=null&&!"".equals(result5str)) {
			result5 = Double.valueOf(result5str);
			m.setResultFive(result5);
		}
		String result61str = request.getParameter("result61");
		String result62str = request.getParameter("result62");
		Double result6 = null;
		if (result61str!=null&&result62str!=null&&!"".equals(result61str) && !"".equals(result62str)) {
			double result61 = Double.valueOf(result61str);
			double result62 = Double.valueOf(result62str);
			double result66 = result62 * result62;
			result6 = result61 / result66;
			m.setResultSix(result6);
		}
		String result71str = request.getParameter("result71");
		String result72str = request.getParameter("result72");
		Double result7 = null;
		if (result71str!=null&&result72str!=null&&!"".equals(result71str) && !"".equals(result72str)) {
			double result71 = Double.valueOf(result71str);
			double result72 = Double.valueOf(result72str);
			result7 = result71 / result72;
			m.setResultSeven(result7);
		}
		String result8str = request.getParameter("result8");
		Double result8 = null;
		if (result8str!=null&&!"".equals(result8str)) {
			result8 = Double.valueOf(result8str);
			m.setResultEight(result8);
		}
		
		String result9str = request.getParameter("result9");
		Double result9 = null;
		if (result9str!=null&&!"".equals(result9str)) {
			result9 = Double.valueOf(result9str);
			m.setResult9(result9);
		}
		
		String result10str = request.getParameter("result10");
		Double result10 = null;
		if (result10str!=null&&!"".equals(result10str)) {
			result10 = Double.valueOf(result10str);
			m.setResult10(result10);
		}
		
		String result11str = request.getParameter("result11");
		Double result11 = null;
		if (result11str!=null&&!"".equals(result11str)) {
			result11 = Double.valueOf(result11str);
			m.setResult11(result11);
		}
		
		String result12str = request.getParameter("result12");
		Double result12 = null;
		if (result12str!=null&&!"".equals(result12str)) {
			result12 = Double.valueOf(result12str);
			m.setResult12(result12);
		}
		
		String result13str = request.getParameter("result13");
		Double result13 = null;
		if (result13str!=null&&!"".equals(result13str)) {
			result13 = Double.valueOf(result13str);
			m.setResult13(result13);
		}
		
		m.setGradeOne(grade1);
		m.setGradeTwo(grade2);
		m.setGradeThree(grade3);
		m.setGradeFour(grade4);
		m.setGradeFive(grade5);
		m.setGradeSix(grade6);
		m.setGradeSeven(grade7);
		m.setGradeEight(grade8);
		m.setGrade9(grade9);
		m.setGrade10(grade10);
		m.setGrade11(grade11);
		m.setGrade12(grade12);
		m.setGrade13(grade13);

		m.setAdviceOne(advice1);
		m.setAdviceTwo(advice2);
		m.setAdviceThree(advice3);
		m.setAdviceFour(advice4);
		m.setAdviceFive(advice5);
		m.setAdviceSix(advice6);
		m.setAdviceSeven(advice7);
		m.setAdviceEight(advice8);
		m.setAdvice9(advice9);
		m.setAdvice10(advice10);
		m.setAdvice11(advice11);
		m.setAdvice12(advice12);
		m.setAdvice13(advice13);
		m.setSex(sex);
		return m;
	}
}
