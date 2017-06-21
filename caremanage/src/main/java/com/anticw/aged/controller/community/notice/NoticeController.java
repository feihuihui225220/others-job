package com.anticw.aged.controller.community.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.service.community.notice.NoticeService;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
@RequestMapping("/community/notice")
@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	/**
	 * 获取社区下所有公告
	 * @param pageVO
	 * @param request
	 * @param response
	 * @return
	 */
	/*@RequestMapping("list")
	public String getNoticeList(PageParamVO pageVO,HttpServletRequest request,HttpServletResponse response){
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> categoryMap = category.get(CommunityConstants.NOTICECATEGORYID);
		request.setAttribute("categoryMap", categoryMap);
		request.setAttribute("page", noticeService.list(pageVO.getPage(), pageVO.getNum(), communityId));
		return "community/notice/list";
	}*/
	@RequestMapping("list.json")
	public @ResponseBody String getNoticeListJson(PageParamVO pageVO,int communityId,String callback){
		return PublicService.returnPageJSONP(ExceptionCode.SUCCESS, noticeService.list(pageVO.getPage(), pageVO.getNum(), communityId), callback) ;
	}
	/**
	 * 搜索公告
	 * @param pageVO
	 * @param searchVo
	 * @param request
	 * @param response
	 * @return
	 */
	/*@RequestMapping("search")
	public String search(PageParamVO pageVO,NoticeSearchVo searchVo,HttpServletRequest request,HttpServletResponse response){
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> categoryMap = category.get(CommunityConstants.NOTICECATEGORYID);
		request.setAttribute("categoryMap", categoryMap);
		request.setAttribute("searchVo", searchVo);
		request.setAttribute("page", noticeService.listByCriteria(pageVO.getPage(), pageVO.getNum(), searchVo, communityId));
		return "community/notice/list";
	}*/
	@RequestMapping("detail")
	public String getNotice(int id,HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("notice",noticeService.getNotice(id));
		return "";
	}
	/**
	 * 添加页
	 * @param request
	 * @return
	 */
	/*@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request){
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> categoryMap = category.get(CommunityConstants.NOTICECATEGORYID);
		request.setAttribute("categoryMap", categoryMap);
		return "community/notice/toAdd";
	}*/
	/**
	 * 编辑页
	 * @param id
	 * @param request
	 * @return
	 */
	/*@RequestMapping("toEdit")
	public String toEdit(int id,HttpServletRequest request){
		ONotice notice = noticeService.getNotice(id);
		request.setAttribute("notice", notice);
		Map<Integer, Map<Integer, OCategoryItem>> category = pool.getOCategory();
		Map<Integer, OCategoryItem> categoryMap = category.get(CommunityConstants.NOTICECATEGORYID);
		request.setAttribute("categoryMap", categoryMap);
		return "community/notice/toEdit";
	}*/
	/**
	 * 增加公告
	 * @param notice
	 * @param files
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping("add")
	public void addNotice(ONotice notice,@RequestParam(value = "file", required = false) MultipartFile[] file,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		String opUser = user.getName();
		try {
			noticeService.addNotice(notice, file, opUser, communityId);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw e;
		}
		
	}*/
	@RequestMapping("deleteAtt")
	public void deleteAtt(int index,int id,HttpServletResponse response) throws IOException{
		noticeService.deleteAtt(index, id);
		response.getWriter().print("<script type='text/javascript'>window.location.href=document.referrer</script>");
	}
	/**
	 * 删除公告
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("delete")
	public void deleteNotice(int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		String opUser = user.getName();
		try {
			noticeService.deleteNotice(id,opUser);
			response.getWriter().print("<script type='text/javascript'>window.location.href=document.referrer</script>");
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 编辑公告
	 * @param notice
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping("edit")
	public void editNotice(ONotice notice,@RequestParam(value = "file", required = false) MultipartFile[] file,HttpServletResponse response,HttpServletRequest request) throws Exception{
		UserVO user = (UserVO)request.getSession().getAttribute(PropertyValueConstants.SESSION_USER);
		int communityId = Integer.parseInt(user.getCommunityId());
		String opUser = user.getName();
		try {
			noticeService.editNotice(notice, file, opUser, communityId);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw e;
		}
	}*/
	
}
