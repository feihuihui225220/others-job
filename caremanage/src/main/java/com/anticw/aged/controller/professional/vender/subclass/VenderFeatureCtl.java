package com.anticw.aged.controller.professional.vender.subclass;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.MUserVender;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.community.policy.UserPolicyService;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.vender.MVenderSiteService;
import com.anticw.aged.service.professional.vender.venderfeatureservice.VenderFeatureService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.vender.MVenderSiteVO;
import com.anticw.aged.vo.user.FeatureUserVO;
import com.anticw.aged.vo.user.FeatureVO;

/**
 * 
 * @author dx 老人特征信息
 *
 */
@Controller
public class VenderFeatureCtl {

	@Autowired
	private CategoryItemService categoryItemService;
	@Autowired
	private VenderFeatureService venderFeatureService;
	@Autowired
	private MVenderSiteService mVenderSiteService;
	@Autowired
	private VenderService venderService;
	@Autowired
	private UserPolicyService userPolicyService;

	/**
	 * 加载各项信息
	 * 
	 * @param session
	 * @param pageVO
	 * @param mUserVender
	 * @param m
	 * @param feat
	 * @return
	 */
	@RequestMapping("/professional/feature")
	public ModelAndView getCountAndUserList(HttpSession session, PageParamVO pageVO, MUserVender mUserVender,
			MVenderSiteVO m, FeatureVO feat) {
		ModelAndView mv = new ModelAndView("/professional/vender/venderFeature/distinction");
		Map<Integer, String> oCategoryItem = getOCategoryItem(feat);
		Page<FeatureUserVO> page = null;
		HashMap<String, Long> hash = null;
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		int venderId = userVO.getVenderId();
		if (userVO.isSuper_() == true) {
			page = venderFeatureService.getgetCountAndUserList(venderId, pageVO.getPage(), pageVO.getNum(), mUserVender,
					oCategoryItem, feat);
			hash = venderFeatureService.getCount(venderId, oCategoryItem, feat);
			mv.addObject("mVenderSite", mVenderSiteService.fingByVenderId(userVO.getVenderId()));
		} else {
			page = venderFeatureService.getUserList(venderId, pageVO.getPage(), pageVO.getNum(), mUserVender,
					oCategoryItem, feat, (int) userVO.getId());
			hash = venderFeatureService.getStaffCount(venderId, oCategoryItem, feat, (int) userVO.getId());
			String Ids = venderService.getAUser((int) userVO.getId()).getSiteIds();
			mv.addObject("mVenderSite", mVenderSiteService.findByIds(Ids));
		}
		mv.addObject("hash", hash);
		mv.addObject("page", page);
		mv.addObject("siteId", m.getSiteId());
		mv.addObject("feat", feat);
		StringBuffer sb = new StringBuffer("/professional/feature?theme=");
		sb.append(feat.getTheme()).append("&classify=").append(feat.getClassify()).append("&exhibition=")
				.append(feat.getExhibition());
		mv.addObject("url", sb.toString());
		return mv;
	}

	public Map<Integer, String> getOCategoryItem(FeatureVO feat) {

		if (!"'independent'".equals(feat.getExhibition())) {
			return categoryItemService.findCategory(feat.getClassify());
		} else {
			return null;
		}
	}

	/**
	 * 导出excle
	 * 
	 * @param session
	 * @param pageVO
	 * @param mUserVender
	 * @param m
	 * @param feat
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/professional/feature/export")
	public void exportExcel(HttpSession session, PageParamVO pageVO, MUserVender mUserVender, MVenderSiteVO m,
			FeatureVO feat, HttpServletRequest request, HttpServletResponse response) throws Exception {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String filename = formatter.format(new Date()) + ".xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(filename.getBytes(), "iso-8859-1"));
		OutputStream os = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		Map<Integer, String> oCategoryItem = getOCategoryItem(feat);
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		userPolicyService.exportExcel(workbook, userVO, oCategoryItem, mUserVender, feat);
		workbook.write();
		workbook.close();
	}

}
