package com.anticw.aged.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.OCategory;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.ZAssess;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.icare.ZAssessService;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.admin.OCategoryItemVO;
import com.anticw.aged.vo.permission.UserVO;


/**
 * 类型相关请求控制器
 * <P>File name : CategoryItemController.java </P>aa
 * <P>Author : baishuangdong </P>
 * <P>Date : 2014-10-02 </P>
 */
@RequestMapping(value = "/admin")
@Controller
public class CategoryItemController {

    @Autowired
    private CategoryItemService categoryItemService;
    @Autowired
    private SpringDataPool springDataPool;
    @Autowired
    private ZAssessService zAssessService;
    @Autowired
    private FileHandle fileHandle;
    /**
     * 获取类型选项列表
     */

    @RequestMapping(value = "findCategoryItem")
    public ModelAndView findCategoryList(Integer categoryId) {
        if (categoryId == null) {
            categoryId = 1;
        }
        ModelAndView mv = new ModelAndView("admin/categoryitem");

        List<OCategory> vo = categoryItemService.findCategoryList();
        List<OCategoryItem> cit = categoryItemService.findListValue(categoryId);
        List<OCategoryItem> loi = categoryItemService.findAllList();
        OCategoryItemVO vo_=null;
        if(categoryId==124){
        	List<OCategoryItemVO> vos = new ArrayList<OCategoryItemVO>();
        	for(OCategoryItem o:cit){
        		vo_=new OCategoryItemVO();
        		BeanUtils.copyProperties(o, vo_);
        		Integer zId=zAssessService.getZAssess(o.getId());
        		vo_.setItemId(zId);
        		vos.add(vo_);
        	}
        	mv.addObject("categoryItem", vos);
        }else{
        	mv.addObject("categoryItem", cit);
        }

        mv.addObject("category", vo);
        mv.addObject("categoryItemList", loi);
        mv.addObject("categoryId", categoryId);
        return mv;
    }

    /**
     * 添加类型选项值//新增对应到量表类型中  图片修改问题
     *
     * @param OCategoryItem
     * @param request
     * @return
     * @throws IOException 
     */

    @RequestMapping(value = "addCategoryItem")
    public ModelAndView insertCategoryItem(HttpSession session,OCategoryItem categoryItem, Integer categoryId, String createdBy, HttpServletRequest request,
    		@RequestParam(value = "coverUrl", required = false)MultipartFile coverUrl,@RequestParam(value = "bgUrl", required = false)MultipartFile bgUrl) throws IOException {
    	Integer itemId=categoryItemService.insertCategoryItem(categoryItem, categoryId, createdBy);
        springDataPool.initOCategoryItemMap();
        if(coverUrl!=null|bgUrl!=null){
        ZAssess zAssess=new ZAssess();//zassess
        String coverUrl_=fileHandle.zassess(coverUrl);
        zAssess.setCoverUrl(coverUrl_);
        String bgUrl_=fileHandle.zassess(bgUrl);
        zAssess.setBgUrl(bgUrl_);
        zAssess.setTitle(itemId);
        Date d=new Date();
        zAssess.setCreateTime(d);
        zAssess.setCreateUser(createdBy);
        zAssess.setChangeTime(d);
        zAssess.setChangeUser(createdBy);
        zAssess.setAvailable(PropertyValueConstants.AVAILABLE);
        zAssess.setVersion(0);
        zAssessService.addAssess(zAssess);
        }
        request.setAttribute("categoryId", categoryId);
        ModelAndView mv = new ModelAndView("redirect:findCategoryItem?categoryId=" + categoryId);

        return mv;
    }

    /**
     * 根据Id删除类型选项值
     *
     * @param id
     * @param request
     * @return
     */

    @RequestMapping(value = "delCategoryItemById")
    public String delCategoryItem(int id, HttpServletRequest request) {
        categoryItemService.delCategoryItem(id);
        return "redirect:admin/categoryitem";
    }

    /**
     * 编辑类型值 //新增对应到量表类型中  图片修改问题
     *
     * @param oCategoryItem
     * @param request
     * @return
     */
    @RequestMapping(value = "editCategoryItemById")
    public ModelAndView editCategoryItem(HttpSession session, OCategoryItemVO oCategoryItem, Integer categoryId, HttpServletRequest request,
    		@RequestParam(value = "coverUrl", required = false)MultipartFile coverUrl,@RequestParam(value = "bgUrl", required = false)MultipartFile bgUrl) throws IOException {
    	UserVO userVO=(UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
    	OCategoryItem o=new OCategoryItem();
    	BeanUtils.copyProperties(oCategoryItem, o);
    	categoryItemService.editCategoryItem(o);
        springDataPool.initOCategoryItemMap();
        if(oCategoryItem.getItemId()!=null){
        	ZAssess z=zAssessService.getAssessById(oCategoryItem.getItemId());
        	if(z!=null){
        		if(coverUrl!=null){
            		fileHandle.remove(z.getCoverUrl()); 
            		String coverUrl_=fileHandle.zassess(coverUrl);
            		 z.setCoverUrl(coverUrl_);
            	}
            	if(bgUrl!=null){
            		fileHandle.remove(z.getBgUrl()); 
            		String bgUrl_=fileHandle.zassess(bgUrl);
            		z.setBgUrl(bgUrl_);
            	}
        		
            	zAssessService.modifyAssess(z);
        		
        	}else{
        		 ZAssess zAssess=new ZAssess();//zassess
        	        String coverUrl_=fileHandle.zassess(coverUrl);
        	        zAssess.setCoverUrl(coverUrl_);
        	        String bgUrl_=fileHandle.zassess(bgUrl);
        	        zAssess.setBgUrl(bgUrl_);
        	        zAssess.setTitle(o.getId());
        	        Date d=new Date();
        	        zAssess.setCreateTime(d);
        	        zAssess.setCreateUser(userVO.getName());
        	        zAssess.setChangeTime(d);
        	        zAssess.setChangeUser(userVO.getName());
        	        zAssess.setAvailable(PropertyValueConstants.AVAILABLE);
        	        zAssess.setVersion(0);
        	        zAssessService.addAssess(zAssess);
        	}
        	
        }
        request.setAttribute("categoryId", categoryId);
        ModelAndView mv = new ModelAndView("redirect:findCategoryItem?categoryId=" + categoryId);
        return mv;
    }


}
