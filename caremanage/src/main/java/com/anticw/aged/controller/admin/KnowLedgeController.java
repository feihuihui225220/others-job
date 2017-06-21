package com.anticw.aged.controller.admin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * <P>Date : 2014-9-22 </P>
 */
@RequestMapping("/admin")
@Controller
public class KnowLedgeController {
	
	@Autowired
	private KnowledgeService  knowledgeService;
	@Autowired
	private SpringDataPool springDataPool;
	
	/**
	 * 获取知识库列表
	 * <P>Date : 2014-9-22 </P>
	 */
	@RequestMapping("knowledgelist")
	public ModelAndView list(PageParamVO pageVO,HttpServletRequest request){
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = springDataPool.getOCategory();
		Map<Integer,OCategoryItem> maplist = map.get(CategoryEnum.KNOWLEDGE.getIndex());
		Page<OKnowledge> vo = null;
		vo = knowledgeService.list(pageVO.getPage(), pageVO.getNum());
		ModelAndView mv = new ModelAndView("admin/knowledgelist");
		mv.addObject("page",vo);
		mv.addObject("maplist",maplist);
		return mv;
	}
	
	/**
	 *  添加知识库题
	 *  获取知识库的类型值，
	 * @param oKnowledge
	 * @param request
	 * @param response
	 * @return
	 */
	 
	@RequestMapping("knowledgeadd")
	public ModelAndView insertKnowledge(OKnowledge oKnowledge,HttpServletRequest request ,HttpServletResponse response){
	    knowledgeService.insertKnowledge(oKnowledge);
	    ModelAndView mv = new ModelAndView("redirect:knowledgelist");	    
		return mv;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("addpage")
	public ModelAndView addKnowledgePage(HttpServletRequest request ,HttpServletResponse response){
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = springDataPool.getOCategory();
		Map<Integer,OCategoryItem> maplist = map.get(CategoryEnum.KNOWLEDGE.getIndex());
		List<OCategoryItem> oci= null;
	    oci=knowledgeService.knowledgeType();
	    ModelAndView mv = new ModelAndView("admin/knowledgeadd");
	    mv.addObject("knowledgeType",oci);
	    mv.addObject("maplist",maplist);
		return  mv;
	}

	
	/**
	 * 根据Id删除知识库详细内容
	 */
	@RequestMapping("delKnowledgeById")
	public ModelAndView delKnowledge(int id,HttpServletRequest request ,HttpServletResponse response){
	    knowledgeService.delKnowledgeById(id);	   
		return new ModelAndView("redirect:knowledgelist");
	}
	
	/**
	 * 根据Id查询知识库详细内容并编辑
	 */
	@RequestMapping("edit")
	public ModelAndView findKnowledge(int id,HttpServletRequest request ,HttpServletResponse response){
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = springDataPool.getOCategory();
		Map<Integer,OCategoryItem> maplist = map.get(CategoryEnum.KNOWLEDGE.getIndex());
		
		OKnowledge know = knowledgeService.findKnowledgeById(id);

		ModelAndView mv = new  ModelAndView("admin/knowledgeedit");
	    request.setAttribute("detail", know);
	    mv.addObject("maplist",maplist);
		return mv;
	}
	
	/**
	 * 编辑知识库详细内容
	 */
	@RequestMapping("editKnowledgeById")
	public String editKnowledge(OKnowledge knowledge,HttpServletRequest request ,HttpServletResponse response){
	    knowledgeService.editKnowledge(knowledge);
		return "redirect:knowledgelist";
	}
	
}
