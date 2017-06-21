/*package com.anticw.aged.controller.care;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.vo.professional.vender.CVenderAddress;
import com.anticw.aged.vo.professional.vender.ServiceCategoryVO;
import com.anticw.aged.vo.professional.vender.VenderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.CServiceManager;
import com.anticw.aged.bean.utils.CareConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.care.CServiceManagerService;
import com.anticw.aged.service.care.CvendorService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.community.CountOrderVo;
import com.anticw.aged.vo.community.CountVendorVO;
import com.anticw.aged.vo.permission.UserVO;

*//**
 * 服务商管理页（服务商首页）
 *
 * @author li
 *//*
@Controller
@RequestMapping("/care/careManager")
public class CareManagerCtl {
    @Autowired
    private CvendorService cvendorService;
    @Autowired
    private CServiceManagerService cServiceManagerService;
    @Autowired
    private SpringDataPool springDataPool;

    *//**
     * @param session
     * @param vendorName
     * @return
     *//*
    @RequestMapping(value = "list")
    public ModelAndView createOrder(HttpSession session, PageParamVO pageVO, String vendorName) {
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        String cmName = null;
        if(userVo.isSuper_()) {
			cmName = userVo.getName();
		}else{
			//TODO:该处需要获取父级Id
			cmName = userVo.getName();
		}
        Page<CVendor> vendorList = cvendorService.listVendersByCommunityIds(pageVO, communityIds, vendorName);

        for (int a = 0; a < vendorList.getResult().size(); a++) {
            CVendor tmp = vendorList.getResult().get(a);
            String serviceType = tmp.getCategoryIds();
            List<CServiceManager> serviceTypeList = cServiceManagerService.getServiceManagerByIds(serviceType, "1");
            tmp.setcServiceManagerList(serviceTypeList);
        }
        ModelAndView mv = new ModelAndView("/care/vendor/vendorList");
        mv.addObject("page", vendorList);
        return mv;
    }

    @RequestMapping(value = "goToAdd")
    public ModelAndView goToAdd() {
        List<CServiceManager> result = cServiceManagerService.loadAllServiceManager();
        Map<Integer,Map<Integer,OCategoryItem>> map = springDataPool.getOCategory();
        ModelAndView mv = new ModelAndView("/care/vendor/vendorAdd");
        mv.addObject("serviceList", result);
        mv.addObject("map", map);
        return mv;
    }

    *//**
     * 便民服务商统计
     *
     * @return
     *//*
    @RequestMapping("count/vendor")
    public ModelAndView countVendor(HttpSession session) {
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        List<CountVendorVO> serviceVos = cServiceManagerService.countVendor(communityIds);//统计数量
        List<CVenderAddress> addressVos = cServiceManagerService.getAllCVendorAddress(communityIds);//地址

        ModelAndView mv = new ModelAndView("/care/serviceType/countVendor");
        mv.addObject("counts", serviceVos);
        mv.addObject("map", addressVos);
        return mv;
    }

    *//**
     * 便民服务商地址的json
     *//*
    @RequestMapping("/getAddressJson")
    public @ResponseBody JSONObject getAddressJson(HttpSession session) {
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        List<CVenderAddress> addressVos = cServiceManagerService.getAllCVendorAddress(communityIds);//地址

        session.setAttribute("searchUserVo", addressVos);
        JSONObject json  = new JSONObject();
        json.put("address", addressVos);
        return json;
    }

    *//**
     * 关爱服务商--分类--json
     *//*
    @RequestMapping("/serviceCategory")
    public @ResponseBody JSONObject serviceCategory(HttpSession session) {
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        List<ServiceCategoryVO> Categorys = cServiceManagerService.serviceCategory();

        session.setAttribute("searchUserVo", Categorys);
        JSONObject json  = new JSONObject();
        json.put("categorys", Categorys);
        return json;
    }

    *//**
     * 地图-搜索
     *//*
    @RequestMapping("/map/search/{word}")
    public @ResponseBody JSONObject search(HttpSession session,@PathVariable("word") String word){
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        List<CVenderAddress> addressVos = cServiceManagerService.mapSeacrh(communityIds, word);//地址

        session.setAttribute("searchUserVo", addressVos);
        JSONObject json  = new JSONObject();
        json.put("address", addressVos);
        return json;
    }

    *//**
     * 便民服务订单统计
     *
     * @param session
     * @param dateVo
     * @return
     *//*
    @RequestMapping("count/order")
    public ModelAndView countOrder(HttpSession session, DateParamVO dateVo, Integer type) {

        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        if (type == null)
            type = CareConstants.TYPE_COUNTORDER;
        List<CountOrderVo> countVos = cServiceManagerService.countOrder(communityIds, dateVo, type);
        ModelAndView mv = new ModelAndView("/care/serviceType/countOrder");
        mv.addObject("counts", countVos);
        mv.addObject("type", type);
        mv.addObject("datevo", dateVo);
        return mv;
    }


    @RequestMapping("count/vendor/order")
    public ModelAndView countOrderByServiceType(HttpSession session, DateParamVO dateVo, Integer type, Integer serviceTypeId) {
        UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        String communityIds = userVo.getCommunityId();
        if (type == null)
            type = CareConstants.TYPE_COUNTORDER;
        List<CountOrderVo> countVos = cServiceManagerService.countOrder(communityIds, dateVo, type, serviceTypeId);
        ModelAndView mv = new ModelAndView("/care/serviceType/countVendorOrder");
        mv.addObject("counts", countVos);
        mv.addObject("type", type);
        mv.addObject("serviceType", serviceTypeId);
        mv.addObject("datevo", dateVo);
        return mv;
    }

}
*/