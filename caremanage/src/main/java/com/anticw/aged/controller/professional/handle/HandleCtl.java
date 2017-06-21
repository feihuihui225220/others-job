package com.anticw.aged.controller.professional.handle;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessResult;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.professional.handle.HandleService;

@Controller
@RequestMapping("handle")
public class HandleCtl {

	@Autowired
	private HandleService handleService;
	@Autowired
	private SpringDataPool springDataPool;
	/**
	 * 保存评估结果
	 * @param maHandle
	 * @param userId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("")
	public  String insertHandle(MAssessHandle maHandle,String userId) throws IllegalAccessException, InvocationTargetException{
		handleService.insertHandle(maHandle);
		//return "redirect:professional/vender/service/assess?"+userId;
		return "redirect:handle/assessResult?userId="+userId;
		
	}
	
	@RequestMapping("toAssess")
	public String toAssess(String userId,HttpServletRequest request){
		//return "redirect:/professional/vender/user/detail/"+userId;
		return "redirect:professional/vender/service/assess?"+userId;
	}
	/**
	 * 跳转到评估页面
	 * @return
	 */
	@RequestMapping("assess")
	public String goToPage(String userId,HttpServletRequest request){
		request.setAttribute("userId", userId);
		//查询省份
		List<OCountry> countrys = this.springDataPool.getPCountryList(0);
		request.setAttribute("country", countrys);
		return "professional/handle/assess";
	}
		
	/**
	 * 查看评估结果
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("assessResult")
	public String reportPage(String userId,HttpServletRequest request){
		List<MAssessResult>  result  = handleService.selectResult(userId);
		MAssessResult MRObj = result.get(0);
		//判断是否失智
		//失智概率
		double disable = MRObj.getLogisDisable();
		BigDecimal disableBigD = new BigDecimal(disable); 
		disableBigD = disableBigD.setScale(4,BigDecimal.ROUND_HALF_UP);
		//不失智的概率
		BigDecimal noDisable = new BigDecimal(1 - disable);
		noDisable=noDisable.setScale(4, BigDecimal.ROUND_HALF_UP);
		double noDisability = noDisable.doubleValue();
		int i = 0 ;
		int j = 0 ;
		String logshineng = "";//比较logistics失能与不失能
		if (disableBigD.compareTo(noDisable) >= 0 ) {
			i++;
			logshineng = "大于";
		}else{
			logshineng = "小于";
		}
		double fisherDisable = MRObj.getFisherDisable();  //0不失智   1  失智
		String treeResult = MRObj.getTreeResult();  //disability不健康  healthy  健康
		String fisshineng = "";
		if(fisherDisable == 1){
			i++;
			fisshineng = "大于";
		}else{
			fisshineng = "小于";
		}
		if("disability".equals(treeResult)){
			i++;
			j++;
		}
		String lastResultDisable = "";  //失能
		if(i >= 2){
			lastResultDisable = "较大";
		}else{
			lastResultDisable = "较小";
		}
		//判断是否失智
		//失智概率
		double logisticsDementia = MRObj.getLogisDementia();
		BigDecimal logisticDemen = new BigDecimal(logisticsDementia);
		logisticDemen = logisticDemen.setScale(4, BigDecimal.ROUND_HALF_UP);
		//不失智概率
		BigDecimal noLogDementia = new BigDecimal(1 - logisticsDementia);
		noLogDementia = noLogDementia.setScale(4, BigDecimal.ROUND_HALF_UP);
		double noLogisticDementia = noLogDementia.doubleValue();
		double fisherDementia  = MRObj.getFisherDementia();
		String fisshizhi= "";
		if (fisherDementia ==1 ) {
			j++;
			fisshizhi = "大于";
		}else{
			fisshizhi = "小于";
		}
		String lastResultDementia = "";  //失能
		String logshizhi = ""; 
		if (logisticDemen.compareTo(noLogDementia) >= 0) {
			j++;
			logshizhi = "大于";
		} else {
			logshizhi = "小于";
		}
		if (j >= 2) {
			lastResultDementia = "较大";
		}else{
			lastResultDementia = "较小";
		}
		double deYes = MRObj.getFisherDementiaYes();
		double deNo = MRObj.getFisherDementiaNo();
		double disYes = MRObj.getFisherDisableYes();
		double disNo = MRObj.getFisherDisableNo();
		
		request.setAttribute("userId", userId);
		//logistic 失能分析结果
 		request.setAttribute("lastResultDisable", lastResultDisable);  //失能可能性大小
		request.setAttribute("disable", disableBigD);  //失能得分
		request.setAttribute("noDisability", noDisability);  //不失能得分
		request.setAttribute("logshineng", logshineng);  //失能和不失能概率比较
		//logistic 失智分析结果
		request.setAttribute("lastResultDementia", lastResultDementia);  //失智可能性大小
		request.setAttribute("logisticsDementia", logisticDemen);  //失智概率
		request.setAttribute("noLogisticDementia", noLogisticDementia);  //不失智概率
		request.setAttribute("logshizhi", logshizhi);  //失智和不失智概率比较
		request.setAttribute("report", MRObj);
		//fisher 计算失智得分
		request.setAttribute("deYes", deYes);
		request.setAttribute("deNo", deNo);
		request.setAttribute("disYes", disYes);
		request.setAttribute("disNo", disNo);
		request.setAttribute("fisshineng", fisshineng);
		request.setAttribute("fisshizhi", fisshizhi);
		return "professional/handle/report";
		
	}
	@RequestMapping(value = "sesses")
	public @ResponseBody JSONObject getAssess(HttpServletRequest request,HttpServletResponse response,String userId) throws Exception {
		// 评估列表 
		List<MAssessResult>  result  = handleService.selectResult(userId);
		JSONObject json = new JSONObject();
		if(result.size()!=0){
			MAssessResult MRObj = result.get(0);
			//判断是否失智
			//失智概率
			double disable = MRObj.getLogisDisable();
			BigDecimal disableBigD = new BigDecimal(disable); 
			disableBigD = disableBigD.setScale(4,BigDecimal.ROUND_HALF_UP);
			//不失智的概率
			BigDecimal noDisable = new BigDecimal(1 - disable);
			noDisable=noDisable.setScale(4, BigDecimal.ROUND_HALF_UP);
			double noDisability = noDisable.doubleValue();
			int i = 0 ;
			int j = 0 ;
			String logshineng = "";//比较logistics失能与不失能
			if (disableBigD.compareTo(noDisable) >= 0 ) {
				i++;
				logshineng = "大于";
			}else{
				logshineng = "小于";
			}
			double fisherDisable = MRObj.getFisherDisable();  //0不失智   1  失智
			String treeResult = MRObj.getTreeResult();  //disability不健康  healthy  健康
			String fisshineng = "";
			if(fisherDisable == 1){
				i++;
				fisshineng = "大于";
			}else{
				fisshineng = "小于";
			}
			if("disability".equals(treeResult)){
				i++;
				j++;
			}
			String lastResultDisable = "";  //失能
			if(i >= 2){
				lastResultDisable = "较大";
			}else{
				lastResultDisable = "较小";
			}
			//判断是否失智
			//失智概率
			double logisticsDementia = MRObj.getLogisDementia();
			BigDecimal logisticDemen = new BigDecimal(logisticsDementia);
			logisticDemen = logisticDemen.setScale(4, BigDecimal.ROUND_HALF_UP);
			//不失智概率
			BigDecimal noLogDementia = new BigDecimal(1 - logisticsDementia);
			noLogDementia = noLogDementia.setScale(4, BigDecimal.ROUND_HALF_UP);
			double noLogisticDementia = noLogDementia.doubleValue();
			double fisherDementia  = MRObj.getFisherDementia();
			String fisshizhi= "";
			if (fisherDementia ==1 ) {
				j++;
				fisshizhi = "大于";
			}else{
				fisshizhi = "小于";
			}
			String lastResultDementia = "";  //失能
			String logshizhi = ""; 
			if (logisticDemen.compareTo(noLogDementia) >= 0) {
				j++;
				logshizhi = "大于";
			} else {
				logshizhi = "小于";
			}
			if (j >= 2) {
				lastResultDementia = "较大";
			}else{
				lastResultDementia = "较小";
			}
			double deYes = MRObj.getFisherDementiaYes();
			double deNo = MRObj.getFisherDementiaNo();
			double disYes = MRObj.getFisherDisableYes();
			double disNo = MRObj.getFisherDisableNo();
			
			json.put("userId", userId);
			//logistic 失能分析结果
			json.put("lastResultDisable", lastResultDisable);  //失能可能性大小
			json.put("disable", disableBigD);  //失能得分
			json.put("noDisability", noDisability);  //不失能得分
			json.put("logshineng", logshineng);  //失能和不失能概率比较
			//logistic 失智分析结果
			json.put("lastResultDementia", lastResultDementia);  //失智可能性大小
			json.put("logisticsDementia", logisticDemen);  //失智概率
			json.put("noLogisticDementia", noLogisticDementia);  //不失智概率
			json.put("logshizhi", logshizhi);  //失智和不失智概率比较
			json.put("report", MRObj);
			//fisher 计算失智得分
			json.put("deYes", deYes);
			json.put("deNo", deNo);
			json.put("disYes", disYes);
			json.put("disNo", disNo);
			json.put("fisshineng", fisshineng);
			json.put("fisshizhi", fisshizhi);
			json.put("boolean", true);
		}else{
			json.put("boolean", false);
		}
		return json;
	}
}
