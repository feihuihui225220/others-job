package com.anticw.aged.controller.icare.combo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.ZFitnessConclusion;
import com.anticw.aged.service.icare.combo.ComboService;
import com.anticw.aged.service.icare.combo.ZFitnessConclusionService;
/**
 * 
 * @author DX   结论维护
 *
 */
@Controller
@RequestMapping("/ICareFitness")
public class ZFitnessConclusionController {

	@Autowired
	private ZFitnessConclusionService zFitnessConclusionService;
	/**
	 * 获取全部结论
	 * @return
	 */
	@RequestMapping("/Conclusion/list")
	public ModelAndView getList(){
		ModelAndView mv=new ModelAndView("/ICareFitness/zfitness/conclusionList");
		mv.addObject("zfit", zFitnessConclusionService.getList());
		return mv;
	} 
	 
	@RequestMapping("/zfitness/conclusion")
	public ModelAndView getList(Integer fid){
		ModelAndView mv=new ModelAndView("/ICare/zfitness/conclusionList");
		mv.addObject("zfit", zFitnessConclusionService.getList(fid));
		return mv;
	}
	
	/**
	 * 修改
	 * @param z
	 * @return
	 */
	@RequestMapping("/Conclusion/update")
	public ModelAndView getUpdate(ZFitnessConclusion z){
		ModelAndView mv=new ModelAndView(new RedirectView("/ICareFitness/zfitness/conclusion?fid="+z.getFitnessId()));
		zFitnessConclusionService.update(z);
		return mv;
	}
	@Autowired
	private ComboService comboService;
	/**
	 * 去修改页
	 * @param id
	 * @return
	 */
	@RequestMapping("/Conclusion/toupdate")
	public ModelAndView getUpdate(int id){
		ModelAndView mv=new ModelAndView("/ICare/zfitness/conclusion");
		mv.addObject("combo", comboService.getZComboAll());
		mv.addObject("zfit", zFitnessConclusionService.getById(id));
		return mv;
	}
	
}
