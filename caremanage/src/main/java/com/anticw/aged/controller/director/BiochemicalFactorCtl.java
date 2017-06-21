package com.anticw.aged.controller.director;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anticw.aged.bean.HBloodFat;
import com.anticw.aged.bean.HBloodGasAnalysis;
import com.anticw.aged.bean.HBloodRoutine;
import com.anticw.aged.bean.HCellularImmunity;
import com.anticw.aged.bean.HDicCheck;
import com.anticw.aged.bean.HElectrolyte;
import com.anticw.aged.bean.HHepatitisVirus;
import com.anticw.aged.bean.HHormone;
import com.anticw.aged.bean.HHumoralImmunity;
import com.anticw.aged.bean.HLiverFunction;
import com.anticw.aged.bean.HRenalFunction;
import com.anticw.aged.bean.HUrineRoutine;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.director.HBloodFatService;
import com.anticw.aged.service.director.HBloodGasAnalysisService;
import com.anticw.aged.service.director.HBloodRoutineService;
import com.anticw.aged.service.director.HCellularImmunityService;
import com.anticw.aged.service.director.HDicCheckService;
import com.anticw.aged.service.director.HElectrolyteService;
import com.anticw.aged.service.director.HHepatitisVirusService;
import com.anticw.aged.service.director.HHormoneService;
import com.anticw.aged.service.director.HHumoralImmunityService;
import com.anticw.aged.service.director.HLiverFunctionService;
import com.anticw.aged.service.director.HRenalFunctionService;
import com.anticw.aged.service.director.HUrineRoutineService;
import com.anticw.aged.vo.permission.UserVO;
/**
 * 
 * @author DX-2016-09-12
 * 生化指标
 *
 */
@Controller
public class BiochemicalFactorCtl {

	@Autowired
	private HBloodRoutineService hBloodRoutineService;
	@Autowired
	private HUrineRoutineService hUrineRoutineService;
	@Autowired
	private HDicCheckService hDicCheckService;
	@Autowired
	private HLiverFunctionService hLiverFunctionService;
	@Autowired
	private HRenalFunctionService hRenalFunctionService;
	@Autowired
	private HElectrolyteService hElectrolyteService;
	@Autowired
	private HBloodGasAnalysisService hBloodGasAnalysisService;
	@Autowired
	private HHormoneService hHormoneService;
	@Autowired
	private HBloodFatService hBloodFatService;
	@Autowired
	private HHumoralImmunityService hHumoralImmunityService;
	@Autowired
	private HCellularImmunityService hCellularImmunityService;
	@Autowired
	private HHepatitisVirusService hHepatitisVirusService;
	/**
	 * 根据userId将生化指标对应的所有参数加载出来
	 * @param session
	 * @param userId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/director/biochemistry")	
	public ModelAndView biochemistry(HttpSession session,Long userId) throws IllegalAccessException, InvocationTargetException{
		ModelAndView mv=new ModelAndView("director/biochemistry");
		HBloodRoutine hrt = hBloodRoutineService.getHBloodRoutine(userId);//血常规
		HUrineRoutine uri = hUrineRoutineService.getHUrineRoutine(userId);//尿常规
		HDicCheck dic = hDicCheckService.getHDicCheck(userId);//dic相关检查
		HLiverFunction hli = hLiverFunctionService.getHLiverFunction(userId);//肝功能		
		HRenalFunction hre = hRenalFunctionService.getHRenalFunction(userId);//肾功能
		HElectrolyte elect = hElectrolyteService.getHElectrolyte(userId);//电解质
		HBloodGasAnalysis blood = hBloodGasAnalysisService.getHBloodGasAnalysis(userId);//血气分析
		HHormone hor = hHormoneService.getHHormone(userId);//激素
		HBloodFat fat = hBloodFatService.getHBloodFat(userId);//血脂
		HHumoralImmunity hum = hHumoralImmunityService.getHHumoralImmunity(userId);//体液免疫
		HCellularImmunity cell = hCellularImmunityService.getHCellularImmunity(userId);//细胞免疫
		HHepatitisVirus virus = hHepatitisVirusService.getHHepatitisVirus(userId);//肝炎病毒
		mv.addObject("hrt", hrt);
		mv.addObject("uri",uri);		
		mv.addObject("dic", dic);
		mv.addObject("hli", hli);
		mv.addObject("hre", hre);
		mv.addObject("elect", elect);
		mv.addObject("blood", blood);
		mv.addObject("hor", hor);
		mv.addObject("fat", fat);
		mv.addObject("hum", hum);	
		mv.addObject("cell", cell);
		mv.addObject("virus", virus);
		return mv;
	}
	
	/**
	 *
	 * *********************血常规*******************
	 */	
	//添加
	@RequestMapping("/director/hBloodRoutine")
	public  String getHBloodRoutine(HBloodRoutine hrt,HttpSession session){
			hrt.setVersion(1);
			UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
			hrt.setCreateBy(userVo.getName());
			hrt.setCreateTime(new Date());
			hrt.setChangeBy(userVo.getName());
			hrt.setChangeTime(new Date());
			hBloodRoutineService.save(hrt);
			return "redirect:/director/biochemistry?userId="+hrt.getUserId();
				
		
	}
	//记录列表
	@RequestMapping("/director/hrtList")
	public ModelAndView hrtList(HBloodRoutine hrt,Long userId){
		    ModelAndView mv=new ModelAndView("director/biochem/hrtlist");
		    List<HBloodRoutine> list = hBloodRoutineService.getList(userId);//血常规
		    mv.addObject("list", list);
		    return mv;	
		
	}
	
	//编辑
	@RequestMapping("/director/hrtEdit")
	public @ResponseBody String hrtEdit(HBloodRoutine hrt){
		HBloodRoutine hr=hBloodRoutineService.selectById(hrt.getId());
		hr.setBasophileGranulocyte(hrt.getBasophileGranulocyte());
		hr.setEosinophileGranulocyte(hrt.getEosinophileGranulocyte());
		hr.setEsr(hrt.getEsr());
		hr.setHemoglobin(hrt.getHemoglobin());
		hr.setLymphocyte(hrt.getLymphocyte());
		hr.setMonocyte(hrt.getMonocyte());
		hr.setNeutrophilicGranulocyte(hrt.getNeutrophilicGranulocyte());
		hr.setPlatelet(hrt.getPlatelet());
		hr.setRedBloodCell(hrt.getRedBloodCell());
		hr.setVersion(hr.getVersion()+1);
		hr.setWhiteBloodCell(hrt.getWhiteBloodCell());
		hr.setChangeTime(new Date());
		hBloodRoutineService.edit(hr);
		return "sucess";
	}

	/**
	 *
	 * *********************尿常规*******************
	 */	
	@RequestMapping("/director/hUrineRoutine")
	public String getHUrineRoutine(HUrineRoutine huri,HttpSession session){		
			huri.setVersion(1);
			UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
			huri.setCreateBy(userVo.getName());
			huri.setCreateTime(new Date());
			huri.setChangeBy(userVo.getName());
			huri.setChangeTime(new Date());
			hUrineRoutineService.save(huri);
			return "redirect:/director/biochemistry?userId="+huri.getUserId();		
	}

	@RequestMapping("/director/uriList")
	public ModelAndView uriList(HUrineRoutine huri,Long userId){
		    ModelAndView mv=new ModelAndView("director/biochem/urilist");
		    List<HUrineRoutine> list = hUrineRoutineService.getList(userId);//血常规
		    mv.addObject("list", list);
		    return mv;	
		
	}
	
	@RequestMapping("/director/hUrineEdit")
	public @ResponseBody String hUrineEdit(HUrineRoutine huri){
		if(huri.getId() != null){
		HUrineRoutine hr=hUrineRoutineService.selectById(huri.getId());		
		hr.setUrineSpecificGravity(huri.getUrineSpecificGravity());
		hr.setPh(huri.getPh());
		hr.setRedBloodCell(huri.getRedBloodCell());
		hr.setWhiteBloodCell(huri.getWhiteBloodCell());
		hr.setNitrite(huri.getNitrite());
		hr.setGlucose(huri.getGlucose());
		hr.setProtein(huri.getProtein());
		hr.setKetone(huri.getKetone());
		hr.setUrinaryBladder(huri.getUrinaryBladder());
		hr.setUrineBilirubin(huri.getUrineBilirubin());
		if (huri.getVersion()!=null) {
			hr.setVersion(huri.getVersion() + 1);
		}else{
			hr.setVersion(1);
		}
		hr.setChangeTime(new Date());
		hUrineRoutineService.edit(hr);
		}
		return "sucess";
	}
	/**
	 *
	 * *********************DIC常规检查*******************
	 */	
		@RequestMapping("/director/hDicCheck")
		public  String getHDicCheck(HDicCheck dic,HttpSession session){			
				dic.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				dic.setCreateBy(userVo.getName());
				dic.setChangeTime(new Date());
				dic.setChangeBy(userVo.getName());
				dic.setChangeTime(new Date());
				hDicCheckService.save(dic);
				return "redirect:/director/biochemistry?userId="+dic.getUserId();
		}
		
		@RequestMapping("/director/dicList")
		public ModelAndView dicList(HDicCheck dic,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/diclist");
			    List<HDicCheck> list = hDicCheckService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		@RequestMapping("/director/editDic")
		public @ResponseBody String editDic(HDicCheck dic,HttpSession session){
			HDicCheck hr= hDicCheckService.selectById(dic.getId());
			hr.setAptt(dic.getAptt());
			hr.setPt(dic.getPt());
			hr.setTt(dic.getTt());
			hr.setFg(dic.getFg());
			hr.setFdps(dic.getFdps());
			hr.setDimer(dic.getDimer());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hDicCheckService.edit(hr);
			return "sucess";
		}

		/**
		 *
		 * *********************肝功能*******************
		 */	
		@RequestMapping("/director/hLiverFunction")
		public  String getHLiverFunction(HLiverFunction hli,HttpSession session){			
				hli.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hli.setCreateBy(userVo.getName());
				hli.setChangeTime(new Date());
				hli.setChangeBy(userVo.getName());
				hli.setChangeTime(new Date());
				hLiverFunctionService.save(hli);
				return "redirect:/director/biochemistry?userId="+hli.getUserId();			
			
		}
		@RequestMapping("/director/hliList")
		public ModelAndView hliList(HLiverFunction hli,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/hlilist");
			    List<HLiverFunction> list = hLiverFunctionService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editHliver")
		public @ResponseBody String editHliver(HLiverFunction hli){
			HLiverFunction hr=hLiverFunctionService.selectById(hli.getId());
			hr.setPreAlbumin(hli.getPreAlbumin());
			hr.setTotalProtein(hli.getTotalProtein());
			hr.setAlbumin(hli.getAlbumin());
			hr.setAlbuminRatio(hli.getAlbuminRatio());
			hr.setAtl(hli.getAtl());
			hr.setAst(hli.getAst());
			hr.setAkp(hli.getAkp());
			hr.setGt(hli.getGt());
			hr.setSerumAmylase(hli.getSerumAmylase());
			hr.setTotalBilirubin(hli.getTotalBilirubin());
			hr.setDirectBilirubin(hli.getDirectBilirubin());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hLiverFunctionService.edit(hr);
			return "sucess";
		}

		/**
		 *
		 * *********************肾功能*******************
		 */			
		@RequestMapping("/director/hRenalFunction")
		public  String getHRenalFunction(HRenalFunction hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hRenalFunctionService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();
		}
		
		@RequestMapping("/director/hreList")
		public ModelAndView hreList(HRenalFunction hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/hrelist");
			    List<HRenalFunction> list = hRenalFunctionService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editHre")
		public @ResponseBody String editHre(HRenalFunction hre){			
			HRenalFunction hr=hRenalFunctionService.selectById(hre.getId());
			hr.setBun(hre.getBun());
	        hr.setCr(hre.getCr());
	        hr.setUricAcid(hre.getUricAcid());
	        hr.setBloodSugar(hre.getBloodSugar());
			hr.setVersion(hr.getVersion()+1);
		    hr.setChangeTime(new Date());
			hRenalFunctionService.edit(hr);
			return "sucess";
		}
		
		/**
		 *
		 * *********************电解质*******************
		 */		
		@RequestMapping("/director/hElectrolyte")
		public  String getHElectrolyte(HElectrolyte hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hElectrolyteService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();			
		}
		
		@RequestMapping("/director/electList")
		public ModelAndView electList(HElectrolyte hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/electlist");
			    List<HElectrolyte> list = hElectrolyteService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editElect")
		public @ResponseBody String editElect(HElectrolyte hre){			
			HElectrolyte hr=hElectrolyteService.selectById(hre.getId());
			hr.setPotassium(hre.getPotassium());
	        hr.setSodium(hre.getSodium());
	        hr.setChlorine(hre.getChlorine());
	        hr.setCalcium(hre.getCalcium());
	        hr.setPhosphorus(hre.getPhosphorus());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hElectrolyteService.edit(hr);
			return "sucess";
		}

		/**
		 *
		 * *********************血气分析******************
		 */		
		@RequestMapping("/director/hBloodGasAnalysis")
		public  String getHBloodGasAnalysis(HBloodGasAnalysis hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hBloodGasAnalysisService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();			
		}
		@RequestMapping("/director/bloodList")
		public ModelAndView bloodList(HBloodGasAnalysis hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/bloodlist");
			    List<HBloodGasAnalysis> list = hBloodGasAnalysisService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editBlood")
		public @ResponseBody String editBlood(HBloodGasAnalysis hre){
			HBloodGasAnalysis hr=hBloodGasAnalysisService.selectById(hre.getId());
			hr.setPh(hre.getPh());
            hr.setPo2(hre.getPo2());
            hr.setPco2(hre.getPco2());
            hr.setStandardBicarbonate(hre.getStandardBicarbonate());
            hr.setBufferBase(hre.getBufferBase());
            hr.setResidualAlkali(hre.getResidualAlkali());
            hr.setOxygenSaturation(hre.getOxygenSaturation());
            hr.setHydrogenIonConcentration(hre.getHydrogenIonConcentration());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hBloodGasAnalysisService.edit(hr);
			return "sucess";
		}
		/**
		 *
		 * *********************激素*******************
		 */		
		@RequestMapping("/director/hHormone")
		public  String getHHormone(HHormone hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hHormoneService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();
			
		}
		
		@RequestMapping("/director/horList")
		public ModelAndView bloodList(HHormone hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/horlist");
			    List<HHormone> list = hHormoneService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editHor")
		public @ResponseBody String editHor(HHormone hre){
			HHormone hr=hHormoneService.selectById(hre.getId());
			hr.setT3(hre.getT3());
	        hr.setT4(hre.getT4());
	        hr.setFt4(hre.getFt4());
	        hr.setFt3(hre.getFt3());
	        hr.setTsh(hre.getTsh());
	        hr.setTgab(hre.getTgab());
	        hr.setTpoab(hre.getTpoab());
	        hr.setPth(hre.getPth());
	        hr.setSerumInsulin(hre.getSerumInsulin());
	        hr.setCalciumReducingHormone(hre.getCalciumReducingHormone());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hHormoneService.edit(hr);
			return "sucess";
		}
		/**
		 *
		 * *********************血脂*******************
		 */		
		@RequestMapping("/director/hBloodFat")
		public  String getHBloodFat(HBloodFat hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hBloodFatService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();			
		}
		
		@RequestMapping("/director/fatList")
		public ModelAndView fatList(HBloodFat hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/fatlist");
			    List<HBloodFat> list = hBloodFatService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editFat")
		public @ResponseBody String editFat(HBloodFat hre){			
			 HBloodFat hr=hBloodFatService.selectById(hre.getId());
			 hr.setTriglyceride(hre.getTriglyceride());
	         hr.setCholesterol(hre.getCholesterol());
	         hr.setFreeFattyAcids(hre.getFreeFattyAcids());
	         hr.setBileAcid(hre.getBileAcid());
	         hr.setHdl(hre.getHdl());
	         hr.setLdl(hre.getLdl());
	         hr.setKetone(hre.getKetone());
	         hr.setPhospholipid(hre.getPhospholipid());
			 hr.setVersion(hr.getVersion()+1);
			 hr.setChangeTime(new Date());
			hBloodFatService.edit(hr);
			return "sucess";
		}
		/**
		 *
		 * ********************体液免疫*******************
		 */		
		@RequestMapping("/director/hHumoralImmunity")
		public  String getHHumoralImmunity(HHumoralImmunity hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hHumoralImmunityService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();
		}
		
		@RequestMapping("/director/humList")
		public ModelAndView humList(HHumoralImmunity hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/humlist");
			    List<HHumoralImmunity> list = hHumoralImmunityService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editHum")
		public @ResponseBody String editHum(HHumoralImmunity hre){
			HHumoralImmunity hr=hHumoralImmunityService.selectById(hre.getId());
			hr.setG(hre.getG());
	        hr.setA(hre.getA());
	        hr.setM(hre.getM());
	        hr.setD(hre.getD());
	        hr.setE(hre.getE());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hHumoralImmunityService.edit(hr);
			return "sucess";
		}
		/**
		 *
		 * *********************细胞免疫*******************
		 */		
		@RequestMapping("/director/hCellularImmunity")
		public  String getHCellularImmunity(HCellularImmunity hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hCellularImmunityService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();
		}
		
		@RequestMapping("/director/cellList")
		public ModelAndView cellList(HCellularImmunity hre,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/celllist");
			    List<HCellularImmunity> list = hCellularImmunityService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}
		
		@RequestMapping("/director/editCell")
		public @ResponseBody String editCell(HCellularImmunity hre){			
			HCellularImmunity hr=hCellularImmunityService.selectById(hre.getId());
			hr.setNk(hre.getNk());
	        hr.setLak(hre.getLak());
	        hr.setTCellSubsets(hre.getTCellSubsets());
			hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hCellularImmunityService.edit(hr);
			return "sucess";
		}
		/**
		 *
		 * *********************肝炎病毒*******************
		 */		
		@RequestMapping("/director/hHepatitisVirus")
		public  String getHHepatitisVirus(HHepatitisVirus hre,HttpSession session){			
				hre.setVersion(1);
				UserVO userVo = (UserVO)session.getAttribute(PropertyValueConstants.SESSION_USER);
				hre.setCreateBy(userVo.getName());
				hre.setChangeTime(new Date());
				hre.setChangeBy(userVo.getName());
				hre.setChangeTime(new Date());
				hHepatitisVirusService.save(hre);
				return "redirect:/director/biochemistry?userId="+hre.getUserId();
			}
			
		@RequestMapping("/director/virusList")
		public ModelAndView virusList(HHepatitisVirus hrt,Long userId){
			    ModelAndView mv=new ModelAndView("director/biochem/viruslist");
			    List<HHepatitisVirus> list = hHepatitisVirusService.getList(userId);//血常规
			    mv.addObject("list", list);
			    return mv;	
			
		}	
		
		@RequestMapping("/director/editVirus")
		public @ResponseBody String editVirus(HHepatitisVirus hre){
			HHepatitisVirus hr=hHepatitisVirusService.selectById(hre.getId());
			hr.setHavIgm(hre.getHavIgm());
            hr.setHbsag(hre.getHbsag());
            hr.setHbsab(hre.getHbsab());
            hr.setHbcab(hre.getHbcab());
            hr.setHbeag(hre.getHbeag());
            hr.setHbeab(hre.getHbeab());
            hr.setHbv(hre.getHbv());
            hr.setHbvDna(hre.getHbvDna());
            hr.setHcvRna(hre.getHcvRna());
            hr.setHcv(hre.getHcv());
            hr.setHdv(hre.getHdv());
            hr.setHdvag(hre.getHdvag());
            hr.setHdvRna(hre.getHdvRna());
            hr.setHev(hre.getHev());
            hr.setHevRna(hre.getHevRna());
            hr.setRpr(hre.getRpr());
            hr.setTppa(hre.getTppa());
            hr.setVersion(hr.getVersion()+1);
			hr.setChangeTime(new Date());
			hHepatitisVirusService.edit(hr);
			return "sucess";
		}
		
}
		

