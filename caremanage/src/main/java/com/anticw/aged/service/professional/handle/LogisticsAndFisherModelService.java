package com.anticw.aged.service.professional.handle;
/**
 * @author bsd
 * @失能失智模型处理
 */
import java.util.Date;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessHandled;
import com.anticw.aged.bean.MAssessResult;

@Service
public class LogisticsAndFisherModelService {
	/**
	 * 基于logistics和Fisher模型进行数据处理
	 * @param m
	 * @return
	 */
	
	public MAssessResult disability(MAssessHandled m,MAssessHandle mHandle){
		MAssessResult mAssessResult = new MAssessResult();
		mAssessResult.setUserId(m.getUserId());
		//logistic 失能模型
		double logisDisable = -2.894 + 0.055 * mHandle.getAge() - 0.333 * m.getECon()
				+ 0.329 * m.getResidenc() - 0.973 * m.getLivewith() - 1.411
				* m.getLivewith() + 0.040 * mHandle.getEducation() + 0.434
				* m.getSourceincome() + 0.443 * m.getSourceincome() - 1.472
				* m.getSourceincome() - 0.292 * m.getSourceincome() - 0.725
				* m.getG1() + 0.181 * m.getGCon() - 0.155 * m.getF1Con()
				- 0.349 * m.getF1Con() + 0.416 * m.getF1Con() - 0.831
				* m.getF3Con() - 0.721 * m.getF3Con1() - 0.245
				* m.getDConnow60() + 0.684 * m.getD4Con() + 0.702
				* m.getD4Con() + 0.087 * m.getD4Con();
		double p = Math.exp(logisDisable)/(1+Math.exp(logisDisable));
		
		//logistic 失智模型
		double logisDementia = -3.082 + 0.049 * mHandle.getAge() - 0.085
				* mHandle.getEducation() - 0.38 * m.getMarriage() - 0.702
				* m.getSourceincome() + 0.219 * m.getSourceincome() - 0.858
				* m.getSourceincome() - 0.213 * m.getSourceincome() - 0.331
				* m.getGoodEmotion() + 0.161 * m.getBadEmotion() - 0.647
				* m.getF1Con() - 0.102 * m.getF1Con() - 0.371 * m.getF1Con()
				+ 0.620 * m.getF21() - 0.116 * m.getF3Con() - 0.573
				* m.getF3Con1() - 0.088 * m.getDConnow60() + 0.287
				* m.getD4Con() + 0.727 * m.getD4Con() + 0.204 * m.getD4Con();
		double p1 = Math.exp(logisDementia)/(1+Math.exp(logisDementia));
		
		double noDisable= -63.371 + 1.264 * mHandle.getAge() + 0.454
				* mHandle.getEducation() + 2.769 * m.getGCon() + 4.353 * m.getF3Con()
				+ 2.438 * m.getF3Con1() + 0.660 * m.getDConnow() + 1.812
				* m.getF3Con1();
		//失能结果
		double disable = -68.508 + 1.340 * mHandle.getAge() + 0.515
				* mHandle.getEducation() + 2.984 * m.getGCon() + 3.252 * m.getF3Con()
				+ 1.977 * m.getF3Con1() + 0.762 * m.getDConnow() + 1.609
				* m.getDConnow60();
		Integer fisherDisable = 0;
		if (noDisable >= disable) {
			fisherDisable = 0;
		}else {
			fisherDisable = 1;
		}
		mAssessResult.setFisherDisable(fisherDisable);
		//Fisher 失智模型   值大为准
		//不失智 
		double noDementia = -66.217 + 1.279 * mHandle.getAge() + 0.551
				* mHandle.getEducation() + 0.577 * m.getGoodEmotion() + 3.061
				* m.getBadEmotion() + 2.641 * m.getGCon() + 4.602
				* m.getF3Con() + 2.239 * m.getF3Con1() + 0.373
				* m.getDConstruct() + 1.938 * m.getDConnow60();
		//失智 
		double dementia = -68.750 + 1.333 * mHandle.getAge() + 0.428
				* mHandle.getEducation() + 0.250 * m.getGoodEmotion() + 3.258
				* m.getBadEmotion() + 2.517 * m.getGCon() + 4.419
				* m.getF3Con() + 1.782 * m.getF3Con1() + 0.245
				* m.getDConstruct() + 1.794 * m.getDConnow60();
		Integer fisherDementia = 0;
		mAssessResult.setFisherDementia(fisherDementia);
		if (noDementia >= dementia) {
			fisherDementia = 0;
		} else {
			fisherDementia = 1;
		}
		
		mAssessResult.setLogisDisable(p);
		mAssessResult.setLogisDementia(p1);
		mAssessResult.setFisherDisableNo(noDisable);
		mAssessResult.setFisherDisableYes(disable);
		
		mAssessResult.setFisherDementiaNo(noDementia);
		mAssessResult.setFisherDementiaYes(dementia);
		mAssessResult.setCreatedAt(new Date());
		return mAssessResult;
		
	}

}
