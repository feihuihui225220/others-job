package com.anticw.aged.controller.professional;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.MOrderDevice;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserCategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.community.user.RUserService;
import com.anticw.aged.service.position.PositionService;
import com.anticw.aged.service.professional.OrderService;
import com.anticw.aged.service.professional.RecommandService;
import com.anticw.aged.service.professional.SpecService;
import com.anticw.aged.utils.ConfigUtil;
import com.anticw.aged.utils.PostUrlUtil;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.recommand.RecQueryCondVO;
import com.anticw.aged.vo.professional.recommand.RecommandVO;
import com.anticw.aged.vo.professional.recommand.ServiceExVO;
import com.anticw.aged.vo.professional.service.ServiceBriefVO;
import com.anticw.aged.vo.professional.service.ServiceCheckoutVO;
import com.anticw.aged.vo.professional.service.ServiceVO;
import com.anticw.aged.vo.professional.vender.VenderDistrVO;

/**
 * 专业服务相关请求控制器
 * <P>
 * File name : ServiceCtl.java
 * </P>
 * <P>
 * Author : zhouyanxin
 * </P>
 * <P>
 * Date : 2014-10-4
 * </P>
 */
@Controller
public class SpecCtl {

	/**
	 * 专业服务业务逻辑处理类
	 */
	@Autowired
	private SpecService specService;

	/**
	 * 专业服务推荐业务逻辑处理类
	 */
	@Autowired
	private RecommandService recService;

	/**
	 * 分类选项业务逻辑处理类
	 */
	@Autowired
	private CategoryItemService categoryItemService;

	/**
	 * 用户持久化逻辑
	 */
	@Autowired
	private RUserService rUserService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PositionService positionService;
	
	/**
	 * 用于处理日期格式的绑定 VenderCtl.initBinder()<BR>
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(df, false);
		binder.registerCustomEditor(Date.class, editor);
	}

	/***************************************************************** 专业服务维护 ***************************************************************************/

	/**
	 * 获取专业服务列表 SpecCtl.list()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-4
	 * </P>
	 * 
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value="/professional") public ModelAndView
	 * list(PageParamVO pageParamVo) throws Exception { //Page<MService> vo =
	 * specService.list(pageParamVo); ModelAndView mv = new
	 * ModelAndView("professional/service/service"); //mv.addObject("page", vo);
	 * return mv; }
	 */

	/**
	 * 跳转至添加页面 SpecCtl.goAddPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-4
	 * </P>
	 * 
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value="/professional/add") public ModelAndView
	 * goAddPage(PageParamVO pageParamVo) throws Exception {
	 * 
	 * //获取元服务 List<MetaVO> metaVos = metaService.getAllMeta();
	 * 
	 * //获取评估量表 List<AssessVO> assessVos = assessService.getAllAssess();
	 * 
	 * //服务分类 List<OCategoryItem> catItems =
	 * categoryItemService.findListValue(CategoryEnum.PROSER.getIndex());
	 * 
	 * ModelAndView mv = new ModelAndView("professional/service/serviceInput");
	 * mv.addObject("page", pageParamVo); mv.addObject("metas", metaVos);
	 * mv.addObject("assesses", assessVos); mv.addObject("catItems", catItems);
	 * 
	 * return mv; }
	 */
	/**
	 * 跳转至修改页面 SpecCtl.goModifyPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-4
	 * </P>
	 * 
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value="/professional/modify") public ModelAndView
	 * goModifyPage(Integer id, PageParamVO pageParamVo) throws Exception {
	 * 
	 * //获取专业服务信息 ServiceVO vo = specService.get(id);
	 * 
	 * //获取元服务 List<MetaVO> metaVos = metaService.getAllMeta();
	 * 
	 * 获取评估量表 List<AssessVO> assessVos = assessService.getAllAssess();
	 * 
	 * //服务分类 List<OCategoryItem> catItems =
	 * categoryItemService.findListValue(CategoryEnum.PROSER.getIndex());
	 * 
	 * ModelAndView mv = new ModelAndView("professional/service/serviceInput");
	 * mv.addObject("page", pageParamVo); mv.addObject("metas", metaVos);
	 * mv.addObject("assesses", assessVos); mv.addObject("spec", vo);
	 * mv.addObject("catItems", catItems);
	 * 
	 * return mv; }
	 */

	/**
	 * 保存或修改专业服务 SpecCtl.saveOrUpdate()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-4
	 * </P>
	 * 
	 * @param vo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value="/professional/commit") public ModelAndView
	 * saveOrUpdate(HttpSession session, @RequestParam(value = "file", required
	 * = false) MultipartFile file, ServiceVO vo, PageParamVO pageParamVo)
	 * throws Exception {
	 * 
	 * //自检 vo.selfValidate();
	 * 
	 * //获取用户信息 String userName =
	 * ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).
	 * getName();
	 * 
	 * //增加或修改评估量表 .saveOrUpdate(file, vo, userName);
	 * 
	 * return list(pageParamVo); }
	 */

	/**
	 * 删除专业服务 SpecCtl.remove()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-4
	 * </P>
	 * 
	 * @param id
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value="/professional/delete") public ModelAndView
	 * remove(HttpSession session, Integer id, PageParamVO pageParamVo) throws
	 * Exception {
	 * 
	 * //获取用户信息 String userName =
	 * ((UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER)).
	 * getName();
	 * 
	 * //删除评估量表 specService.delete(id, userName);
	 * 
	 * return list(pageParamVo); }
	 */

	/***************************************************************** 专业订购 *********************************************************************************/

	/**
	 * 跳转至专业服务开通列表页面 SpecCtl.goOpenPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-6
	 * </P>
	 * 
	 * @param userId
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/list")
	public ModelAndView goServiceListPage(HttpSession session, Long userId, String error) throws Exception {

		// 当前用户信息
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		// 用户类型
		ModelAndView mv = null;
		if (userVO.getCateEnum().getType() == UserCategoryEnum.PRO.getType()) {
			return new ModelAndView(new RedirectView("/professional/service/myservices?userId=" + userId));
		} else {

			List<ServiceBriefVO> vos = null;
			// 获取用户专业服务分配信息
			VenderDistrVO distrVo = null;
			vos = specService.getSpecServiceList(userId, true);
			mv = new ModelAndView("professional/service/list");
			/// mv.addObject("mMetaService", mMetaService);
			mv.addObject("specList", vos);
			mv.addObject("userId", userId);
			mv.addObject("distrVo", distrVo);
			mv.addObject("error", error);
			return mv;
		}

		// 专业服务开通页面

	}

	/**
	 * 根据用户name加载出所有订单
	 * 
	 * @author dx
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/professional/service/report")
	public @ResponseBody JSONObject getgoServiceList(HttpSession session, Long userId) throws Exception {
		// 用户类型
		List<ServiceBriefVO> vos = specService.getSpecServiceList(userId, false);
		List<ServiceBriefVO> vs = new ArrayList<ServiceBriefVO>();
		for (ServiceBriefVO v : vos) {
			if (v.getStatus() != null) {
				vs.add(v);
			}
		}
		JSONObject mjson = new JSONObject();
		mjson.put("serviceBrief", vs);
		return mjson;
	}

	/**
	 * 开通专业服务结算页面 SpecCtl.goCheckoutPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-7
	 * </P>
	 * 
	 * @param serviceId
	 * @param userId
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/checkout")
	public ModelAndView goCheckoutPage(Integer serviceId, Long userId, Long orderId, String type) throws Exception {

		// 获取订购专业服务所需的基本信息
		ServiceCheckoutVO checkoutVo = specService.getCheckoutVO(serviceId, userId, orderId);

		// 专业服务开通页面
		ModelAndView mv = new ModelAndView("professional/service/checkout");
		mv.addObject("checkout", checkoutVo);
		mv.addObject("userId", userId);
		mv.addObject("orderId", orderId);
		mv.addObject("type", type);
		// mv.addObject("serviceId", serviceId);
		return mv;
	}

	/**
	 * 开通专业服务 SpecCtl.openService()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-8
	 * </P>
	 * 
	 * @param checkout
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/open")
	public ModelAndView openService(HttpSession session, ServiceCheckoutVO checkout, String type) throws Exception {
		// 获取用户信息
		String msg = "";
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		if (type != null && "4".equals(type)) {
			String tokenUrl = ConfigUtil.getInstance().getProperty("login");
			String apiKey = ConfigUtil.getInstance().getProperty("apiKey");
			StringBuffer key = new StringBuffer();
			key.append("apiKey=").append(URLEncoder.encode(apiKey, "UTF-8"));
			String token = PostUrlUtil.getToken(tokenUrl, key.toString());
			String url = ConfigUtil.getInstance().getProperty("deviceBind");
			StringBuffer sb = new StringBuffer();
			String md5 = checkout.getDeviceParam().get(0).getDeviceBindId();
			sb.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
					.append(URLEncoder.encode(md5, "UTF-8"));
			msg = PostUrlUtil.getPost(url, sb.toString());
			// 绑定紧急联系人

			RUser r = rUserService.findById(checkout.getUserId());
			StringBuffer phone = new StringBuffer();
			phone.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
					.append(URLEncoder.encode(md5, "UTF-8")).append("&content=");
			if (r.getrContact().size() != 0) {
				List<RContact> rc = r.getrContact();
				for (RContact r1 : rc) {
					phone.append(r1.getMobilePhone() + "," + URLEncoder.encode(r1.getName(), "UTF-8"));
					phone.append("|");
				}

				String setSos = ConfigUtil.getInstance().getProperty("setSos");
				PostUrlUtil.getPost(setSos, phone.toString());
				/*
				 * token={token}&md5=CJCKCJDW
				 * WINRDLIQPTGOWYWTRWOGHAUP&content=13735878001,爸爸|13735878002,
				 * 妈妈|13735878003,姐姐|......
				 */
			}
		}
		if ("error".equals(msg)) {
			return new ModelAndView(
					new RedirectView("/professional/service/list?userId=" + checkout.getUserId() + "&error=绑定失败"));
		} else if (msg != "") {
			JSONObject json = JSONObject.parseObject(msg);
			String state = json.getString("state");
			if ("1".equals(state)) {
				return new ModelAndView(
						new RedirectView("/professional/service/list?userId=" + checkout.getUserId() + "&error=绑定失败"));
			}
		}

		// 参数检测
		checkout.selfValidate();
		// 开通专业服务
		specService.openService(checkout, userName);

		return goServiceListPage(session, checkout.getUserId(), null);
	}

	/**
	 * 关闭服务 SpecCtl.closeService()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-9
	 * </P>
	 * 
	 * @param serviceId
	 * @param userId
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/close")
	public ModelAndView closeService(HttpSession session, Integer serviceId, Long userId, Long orderId, String type)
			throws Exception {
		// 获取用户信息
		String msg = "";
		if (type != null && "4".equals(type)) {
			String tokenUrl = ConfigUtil.getInstance().getProperty("login");
			String apiKey = ConfigUtil.getInstance().getProperty("apiKey");
			StringBuffer key = new StringBuffer();
			key.append("apiKey=").append(URLEncoder.encode(apiKey, "UTF-8"));
			String token = PostUrlUtil.getToken(tokenUrl, key.toString());
			MOrder order = orderService.getById(orderId);
			Iterator<MOrderDevice> iter = order.getOrderDevices().iterator();
			String md5 = iter.next().getDeviceBindId();
			StringBuffer phone = new StringBuffer();
			phone.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
					.append(URLEncoder.encode(md5, "UTF-8")).append("&content=").append(URLEncoder.encode("", "UTF-8"));

			String setSos = ConfigUtil.getInstance().getProperty("setSos");
			PostUrlUtil.getPost(setSos, phone.toString());
			/*
			 * token={token}&md5=CJCKCJDW
			 * WINRDLIQPTGOWYWTRWOGHAUP&content=13735878001,爸爸|13735878002,
			 * 妈妈|13735878003,姐姐|......
			 */

			String url = ConfigUtil.getInstance().getProperty("deviceUnbind");
			StringBuffer sb = new StringBuffer();

			// String md5=checkout.getDeviceParam().get(0).getDeviceBindId();
			sb.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
					.append(URLEncoder.encode(md5, "UTF-8"));
			msg = PostUrlUtil.getPost(url, sb.toString());

		}
		if ("error".equals(msg)) {
			return new ModelAndView(new RedirectView("/professional/service/list?userId=" + userId + "&error=绑定失败"));
		} else if (msg != "") {
			JSONObject json = JSONObject.parseObject(msg);
			String state = json.getString("state");
			String code = json.getString("code");
			if ("1".equals(state) && !code.equals("103") && !code.equals("108")) {
				return new ModelAndView(
						new RedirectView("/professional/service/list?userId=" + userId + "&error=绑定失败"));
			}
		}
		String userName = ((UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER)).getName();
		specService.closeService(orderId, userName);
		return

		goServiceListPage(session, userId, null);
	}

	/***************************************************************** 推荐服务 *********************************************************************************/

	/**
	 * 跳转至推荐页面 SpecCtl.goRecommandPage()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/recommand")
	public ModelAndView goRecommandPage(HttpSession session, PageParamVO pageCond) throws Exception {

		// DateParamVO dateCond = new
		// DateParamVO(DateUtil.getFirstDayInMonth(new Date()),
		// DateUtil.getLastDayInMonth(new Date()));
		RecQueryCondVO condVo = new RecQueryCondVO();
		condVo.setCatId(-1);

		// 服务分类
		List<OCategoryItem> catItems = categoryItemService.findListValue(CategoryEnum.PROSER.getIndex());

		ModelAndView mv = new ModelAndView("professional/recommand/recommand");
		mv.addObject("catItems", catItems);
		// mv.addObject("page", recommandVos);
		return mv;
	}

	/**
	 * 专业服务推荐 SpecCtl.getRecommand()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @param condVo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/recommand/query")
	public ModelAndView getRecommand(HttpSession session, RecQueryCondVO condVo, PageParamVO pageParamVo)
			throws Exception {

		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);

		// 获取推荐服务列表
		Page<RecommandVO> recommandVos = recService.getRecommand(condVo, userVo.getCommunityId(), pageParamVo);

		// 服务分类
		List<OCategoryItem> catItems = categoryItemService.findListValue(CategoryEnum.PROSER.getIndex());

		ModelAndView mv = new ModelAndView("professional/recommand/recommand");
		mv.addObject("pageVo", pageParamVo);
		mv.addObject("condVo", condVo);
		mv.addObject("page", recommandVos);
		mv.addObject("catItems", catItems);
		mv.addObject("catId", condVo.getCatId());
		return mv;
	}

	/**
	 * 申请服务页面
	 * 
	 * @name SpecCtl.applyService()
	 * @author zhoupeipei
	 * @Date 2014-10-23 上午8:35:01
	 * @param session
	 * @param condVo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/apply")
	public ModelAndView applyService(HttpSession session, Long userId, RecQueryCondVO condVo, PageParamVO pageParamVo)
			throws Exception {
		// 从session中获取用户信息
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);

		condVo = new RecQueryCondVO();
		condVo.setCatId(-1);

		// 获取推荐服务列表
		List<ServiceExVO> services = new ArrayList<ServiceExVO>();
		Collection<RecommandVO> recommandVos = null;
		if (userVo.getCateEnum().getType() == UserCategoryEnum.CC.getType()) {
			RUser user = rUserService.findById(userId);
			condVo.setName(user.getName());
			condVo.setIdCard(user.getIdCardNo());
			recommandVos = recService.getRecommand(condVo, userVo.getCommunityId().toString(), pageParamVo).getResult();
			if (recommandVos != null) {
				for (RecommandVO recommandVO : recommandVos) {
					if (recommandVO.getName().equals(user.getName())
							&& recommandVO.getIdCard().equals(user.getIdCardNo())) {
						services = recommandVO.getServices();
						break;
					}
				}
			}
		} else {
			recommandVos = recService.getRecommand(condVo, userVo.getCommunityId(), pageParamVo).getResult();
			if (recommandVos != null) {
				for (RecommandVO recommandVO : recommandVos) {
					if (recommandVO.getName().equals(userVo.getRealName())
							&& recommandVO.getIdCard().equals(userVo.getName())) {
						services = recommandVO.getServices();
						break;
					}
				}
			}
		}

		ModelAndView mv = new ModelAndView("professional/data/service_recommand");
		mv.addObject("pageCond", pageParamVo);
		mv.addObject("condVo", condVo);
		mv.addObject("services", services);
		return mv;
	}

	/**
	 * 专业服务详情
	 * 
	 * @name SpecCtl.serviceDetail()
	 * @author zhoupeipei
	 * @Date 2014-10-26 下午3:45:10
	 * @param ServiceId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/detail")
	public @ResponseBody String serviceDetail(Integer ServiceId) throws Exception {
		ServiceVO serviceVO = null;
		try {
			serviceVO = specService.get(ServiceId);
		} catch (BusinessException e) {
			return PublicService.returnJSONP(e.getCode(), serviceVO, null);
		} catch (Exception e) {
			return PublicService.returnJSONP(ExceptionCode.FAILED, serviceVO, null);
		}
		return PublicService.returnJSONP(ExceptionCode.SUCCESS, serviceVO, null);
	}

	/**
	 * 更新推荐状态 SpecCtl.updateRecommandStatus()<BR>
	 * <P>
	 * Author : zhouyanxin
	 * </P>
	 * <P>
	 * Date : 2014-10-5
	 * </P>
	 * 
	 * @param recommandId
	 * @param status
	 * @param condVo
	 * @param pageParamVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/recommand/handle")
	public ModelAndView updateRecommandStatus(HttpSession session, Long recommandId, Short status,
			RecQueryCondVO condVo, PageParamVO pageParamVo) throws Exception {
		recService.updateRecommandStatus(recommandId, status);
		return getRecommand(session, condVo, pageParamVo);
	}


	/**
	 * @author dx 腕表实施测试血压与心率 type==1 血压 type==2 心率
	 * @param userId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/professional/service/realtimedata")
	public @ResponseBody String realtimedata(Long userId, Integer type) throws Exception {
		// 获取用户信息
		String msg = "";

		String tokenUrl = ConfigUtil.getInstance().getProperty("login");
		String apiKey = ConfigUtil.getInstance().getProperty("apiKey");
		StringBuffer key = new StringBuffer();
		key.append("apiKey=").append(URLEncoder.encode(apiKey, "UTF-8"));
		String token = PostUrlUtil.getToken(tokenUrl, key.toString());

		String md5 = positionService.getByUserId(userId);
		if (md5 == null) {
			return "请您先开通腕表服务再测试进行！";
		}

		String url = "";
		if (type == 1) {
			url = ConfigUtil.getInstance().getProperty("bloodpressure");
		} else if (type == 2) {
			url = ConfigUtil.getInstance().getProperty("HeartRate");
		} else {
			return "非法类型！";
		}
		StringBuffer sb = new StringBuffer();

		sb.append("token=").append(URLEncoder.encode(token, "UTF-8")).append("&md5=")
				.append(URLEncoder.encode(md5, "UTF-8"));
		msg = PostUrlUtil.getPost(url, sb.toString());

		if (msg != "") {
			JSONObject json = JSONObject.parseObject(msg);
			String state = json.getString("state");
			if ("0".equals(state)) {
				return "success";
			}

		}
		return "error";
	}

}
