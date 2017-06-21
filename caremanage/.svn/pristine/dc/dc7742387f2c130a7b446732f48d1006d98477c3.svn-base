package com.anticw.aged.controller.user;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.OKnowledge;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.KnowledgeService;
import com.anticw.aged.vo.common.PageParamVO;

/**
 * 知识库相关请求控制器
 * <P>File name : KnowledgeController.java </P>
 * <P>Author : baishuangdong </P> 
 * <P>Date : 2014-10-13 </P>
 */
@RequestMapping("/user")
@Controller
public class KnowLedgeUserController {
	
	@Autowired
	private KnowledgeService  knowledgeService;
	@Autowired
	private SpringDataPool springDataPool;
	
	/**
	 * 获取知识库列表
	 * <P>Date : 2014-9-22 </P>
	 */
	@RequestMapping("knowledgelist")
	public ModelAndView list(PageParamVO pageVO,Integer category,HttpServletRequest request){
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = springDataPool.getOCategory();
		Map<Integer,OCategoryItem> maplist = map.get(CategoryEnum.KNOWLEDGE.getIndex());
		Page<OKnowledge> know= null;
		if(category==null || category==0){
			know = knowledgeService.list(pageVO.getPage(), pageVO.getNum());	
		}else{
			know = knowledgeService.listCategory(pageVO.getPage(), pageVO.getNum(), category);
		}
		ModelAndView mv = new ModelAndView("user/knowledgelist");
		mv.addObject("knowledgelist",know);
		mv.addObject("maplist",maplist);
		mv.addObject("category", category);
		return mv;
	}
	
	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	@RequestMapping("knowledgedetail")
	public ModelAndView findKnowDetial(Integer id){
		OKnowledge know = knowledgeService.findKnowledgeById(id);
		ModelAndView mv = new ModelAndView("user/knowledgedetail");
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = springDataPool.getOCategory();
		Map<Integer,OCategoryItem> maplist = map.get(CategoryEnum.KNOWLEDGE.getIndex());
		mv.addObject("maplist",maplist);
		mv.addObject("know", know);
		return mv;	
	}
	
	
}
