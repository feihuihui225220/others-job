/**
 * 
 */
package com.anticw.aged.controller.community.country;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.controller.care.BaseCtl;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.utils.JacksonMapper;
import com.anticw.aged.utils.PublicService;
import com.anticw.aged.vo.community.OCountryVO;
import com.anticw.aged.vo.permission.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author ltw
 * 
 */
@Controller
@RequestMapping(value="/community")
public class OCountryCtl extends BaseCtl{
	
	private static Logger logger = LoggerFactory.getLogger(OCountryCtl.class);
	@Autowired
	private OCountryService oCountryService;
	@Autowired
	private SpringDataPool springDataPool;

	/**
	 * 根据countryID删除 country信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "country/delete")
	public void removeById(Integer id) {
		oCountryService.deleteById(id);
	}

	/**
	 * 更新省份信息
	 * 
	 * @param id
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "country/saveOrUpdate")
	public @ResponseBody String saveOrUpdate(HttpSession session,OCountryVO oCountryVo) {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		OCountry oCountry = null;
		if (oCountryVo.getId() == null) {
			String parentNmae=null;
			if(oCountryVo.getParentId()!=0){
				OCountry parent=oCountryService.getCountryById(oCountryVo.getParentId());
				parentNmae=parent.getFullName();
			}else{
				parentNmae="全国";
			}
			oCountry = new OCountry(oCountryVo.getName(), parentNmae+","+oCountryVo.getName(), (Integer.valueOf(oCountryVo.getType())+1)+"", userVO.getName(), oCountryVo.getParentId());
		} else{
			oCountry = oCountryService.getCountryById(oCountryVo.getId());
			oCountry.setChangedAt(new Date());
			oCountry.setChangedBy(userVO.getName());
			if(oCountryVo.getAvailable()!=null&&oCountryVo.getAvailable()==false) {
				oCountry.setAvailable(oCountryVo.getAvailable());
			}else{
				oCountry.setName(oCountryVo.getName());
			}
		}
		
		try {
			oCountryService.saveOrUpdate(oCountry);
			this.springDataPool.saveCountry(oCountry);
		} catch (Exception e) {
			e.printStackTrace();
			PublicService.returnValue(ExceptionCode.FAILED, e.getMessage(), null);
		}
		
		return PublicService.returnValue(ExceptionCode.SUCCESS, oCountry);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "country/returnJsonByPid")
	public ModelAndView getCountryByPid(Integer pid) {
		if (pid == null) {
			return null;
		}
		OCountry oCountry = oCountryService.getCountryById(pid);
		String jsonString = null;
		try {
			jsonString = JacksonMapper.toJson(oCountry);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("community/country/returnJson");
		mv.addObject("countryJson", jsonString);
		return mv;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "country/returnJson")
	public ModelAndView getAllCountryInfo(Integer id) {
		if (id == null) {
			return null;
		}
		OCountry oCountry = oCountryService.getCountryById(id);
		String jsonString = null;
		try {
			jsonString = JacksonMapper.toJson(oCountry);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("community/country/returnJson");
		mv.addObject("countryJson", jsonString);
		return mv;
	}
	/**
	 * 根据PID获取子列表
	 * @author guoyongxiang
	 * Date: 2014-10-14 下午6:34:04
	 * @param pid
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("getCountrys/{pid}")
	public @ResponseBody String getCountrys(HttpServletResponse response, @PathVariable Integer pid, String callback) throws IOException {
		try {
			List<OCountry> countrys = this.springDataPool.getPCountryList(pid);
			return PublicService.returnJSONP(ExceptionCode.SUCCESS, countrys, callback);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("拉取城市列表失败 pid "+pid, e);
			return PublicService.returnJSONP(ExceptionCode.FAILED, null, callback);
		}
	}
	
	/**
	 * 写返回
	 * @author guoyongxiang
	 * Date: 2014-10-16 上午11:24:44
	 * @param response
	 * @param json
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void write(HttpServletResponse response, String json) throws IOException{
		response.setContentType("application/json");
        response.getOutputStream().write(json.toString().getBytes("UTF-8"));  
        response.getOutputStream().flush();  
	}

}
