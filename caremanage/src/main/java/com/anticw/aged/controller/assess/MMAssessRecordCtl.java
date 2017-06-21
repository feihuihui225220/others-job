package com.anticw.aged.controller.assess;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.MVenderIntervene;
import com.anticw.aged.service.assess.MMAssessEconomicsService;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.assess.MVenderInterveneVO;
import com.anticw.aged.vo.professional.assess.QueryPropertiesVO;

/**
 * 
 * @author DX 2016-09-02
 *
 */
@Controller
@RequestMapping("/assess")
public class MMAssessRecordCtl {
	/*
	 * @Autowired private MMAssessRecordService mMAssessRecordService;
	 */
	@Autowired
	private MMAssessEconomicsService mMAssessEconomicsService;
	
	final String[]  assess={"assess1","assess2","assess3","assess4","assess5","assess6","assess7","assess8","assess9",
			"assess10","assess11","assess12","assess13","assess14","assess15","assess16","assess17","assess18"};

	/**
	 * 财经项目 根据量表结论分析 失能失智有所缓解 是否与参与乐活堂项目有关
	 * if(vo.getTimeFactor()!=0)此判断为双因素中除性别以外的次因素
	 * vo.getGroup2() == null || vo.getGroup2() == -1 单组
	 * vo.getModelingCategory() 为建模类型 T检验 KF检验 以及F值检验
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/finance")
	public ModelAndView saveAssess(DateParamVO paramVO, QueryPropertiesVO vo)
			throws Exception {
		// 第二组不存在，单因素分析
		if (vo.getGroup2() == null || vo.getGroup2() == -1) {
			if (vo.getModelingCategory() == 0) {
				switch (vo.getChoice()) {
				case 1:
				 	mMAssessEconomicsService.Tone(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA()); 
					break;
				case 2:
					mMAssessEconomicsService.Tone(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 3:
					mMAssessEconomicsService.Tone_T_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 4:
					mMAssessEconomicsService.Tone_T_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 5:
					mMAssessEconomicsService.Tone_T(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 6:
					mMAssessEconomicsService.Tone_T(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 7:
					mMAssessEconomicsService.Tone_T(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 8:
					mMAssessEconomicsService.Tone_bp(paramVO, vo.getGroup1(),
							vo.getA(), vo.getChoice());
					break;
				case 9:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 10:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 11:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 12:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 13:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 14:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 15:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 16:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 17:
					mMAssessEconomicsService.Tone(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 18:
					mMAssessEconomicsService.Tone_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				default:
					break;
				}

			}// KFMMSETSEX
			if (vo.getModelingCategory() == 2) {
				switch (vo.getChoice()) {
				case 1:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTS(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 2://RecordVO
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTS(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 3://FitnessVO2
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTSLTS(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSLTSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 4:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTSLTS(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSLTSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 5://FitnessVO1
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSLSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 6:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSLSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 7:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSLSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 8:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFBP(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFBP(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 9:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 10:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 11:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 12:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 13:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 14:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 15:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 16:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 17:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFTS(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFTSEX(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getA());
					break;
				case 18:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.KFMMSETSEX_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				default:
					break;
				}
			}
			if (vo.getModelingCategory() == 4) {
				switch (vo.getChoice()) {
				case 1:
					mMAssessEconomicsService.FC1(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 2:
					mMAssessEconomicsService.FC1(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 3:
					mMAssessEconomicsService.FC4(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 4:
					mMAssessEconomicsService.FC4(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 5:
					mMAssessEconomicsService.FC3(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 6:
					mMAssessEconomicsService.FC3(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 7:
					mMAssessEconomicsService.FC3(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 8:
					mMAssessEconomicsService.FC5(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 9:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 10:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 11:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 12:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 13:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 14:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 15:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 16:
					mMAssessEconomicsService.FC2(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 17:
					mMAssessEconomicsService.FC1(paramVO, vo.getChoice(),
							vo.getA());
					break;
				case 18:
					mMAssessEconomicsService.KFMMSETSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				default:
					break;
				}
			}
			if (vo.getModelingCategory() == 5 ) {
				switch (vo.getChoice() ) {
				case 1:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factor(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factor(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 2:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factor(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factor(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 3:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorTSN_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorTSN_(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 4:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorTSN_(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorTSN_(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 5:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorTSN(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorTSN(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 6:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorTSN(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorTSN(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 7:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorTSN(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorTSN(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 8:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_getHPF__(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorHP(paramVO,
							 vo.getChoice(),vo.getA());
					break;
				case 9:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 10:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 11:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 12:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 13:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 14:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 15:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 16:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 17:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factor(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factor(paramVO,
							vo.getChoice(), vo.getA());
					break;
				case 18:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.FCtwo_factorMMse(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.FCtwo_factorMMse(paramVO,
							vo.getChoice(), vo.getA());
					break;
				default:
					break;
				}
			}
		} else if (vo.getGroup2() != null || vo.getGroup2() != -1
				|| vo.getGroup1() != null) {
			if (vo.getModelingCategory() == 1 ) {
				switch (vo.getChoice() ) {
				case 1:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					
					break;
				case 2:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 3:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSSLSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 4:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSSLSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 5:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSLSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 6:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSLSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 7:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSLSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSLSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 8:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTbp(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTbp(paramVO,
							vo.getGroup1(), vo.getA(), vo.getChoice());
					break;
				case 9:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 10:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 11:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 12:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 13:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 14:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 15:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 16:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 17:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTSEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTSEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				case 18:
					if(vo.getTimeFactor()!=0){
						mMAssessEconomicsService.getListTMMSESEX(paramVO,vo.getChoice(), vo.getGroup1(), vo.getA(), vo.getAgeds(), vo.getTimeFactor());
						break;
					}
					mMAssessEconomicsService.getListTMMSESEX(paramVO,
							vo.getChoice(), vo.getGroup1(), vo.getA());
					break;
				default:
					break;
				}
			}
			if (vo.getModelingCategory() == 3 && vo.getTimeFactor() == -1) {
				switch (vo.getChoice() ) {
				case 1:
					mMAssessEconomicsService.KFT(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 2:
					mMAssessEconomicsService.KFT(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 3:
					mMAssessEconomicsService.KFTSN_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 4:
					mMAssessEconomicsService.KFTSN_(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 5:
					mMAssessEconomicsService.KFTSN(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 6:
					mMAssessEconomicsService.KFTSN(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 7:
					mMAssessEconomicsService.KFTSN(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				/*
				 * case 7:等级暂无法划分 mMAssessEconomicsService.getListTbp(paramVO,
				 * vo.getGroup1(), vo.getA(), vo.getChoice()); break;
				 */
				case 9:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 10:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 11:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 12:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 13:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 14:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 15:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 16:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 17:
					mMAssessEconomicsService.KFT(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				case 18:
					mMAssessEconomicsService.KFTmmse(paramVO, vo.getChoice(),
							vo.getGroup1(), vo.getGroup2(), vo.getA());
					break;
				default:
					break;
				}
			}
			

		}
		return new ModelAndView(new RedirectView("/assess/lookOver"));
	}

	/**
	 * 查看量表分析结论
	 * 需要查询最近一次分析情况
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lookOver")
	public ModelAndView selectAssess() throws Exception {
		ModelAndView mv = new ModelAndView("/professional/data/lookOver");
		List<MVenderInterveneVO>  vos=mMAssessEconomicsService.getMVenderInterveneVO();
		for(MVenderInterveneVO vo:vos){
			if(vo.getItemizeId()==0){
				continue;
			}
			mv.addObject(assess[vo.getItemizeId()-1], vo);
		} 
		return mv;
	}

	@RequestMapping("/lookAssess")
	public ModelAndView getList(int itemizeId){
		ModelAndView mv = new ModelAndView("/professional/data/lookAssess");
		List<MVenderIntervene> mv1=	mMAssessEconomicsService.getList(itemizeId);
		List<MVenderIntervene> mv2=	mMAssessEconomicsService.getListTwo(itemizeId);
		mv.addObject("mv1", mv1);
		mv.addObject("mv2", mv2);
		return mv;
	}
	
	@RequestMapping("/downFinance")
	public void export(HttpSession session, HttpServletResponse response)
			throws Exception {
		// List<MAnalysisStudy> list = mMAssessRecordService.getList();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		String filename = formatter.format(new Date()) + ".xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment;filename="
				+ new String(filename.getBytes(), "iso-8859-1"));
		OutputStream os = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// mMAssessRecordService.assessExcel(workbook,list);
		workbook.write();
		workbook.close();
	}
}
