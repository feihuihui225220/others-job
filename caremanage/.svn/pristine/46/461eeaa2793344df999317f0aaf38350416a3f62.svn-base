package com.anticw.aged.service.professional.handle;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessHandle;
import com.anticw.aged.bean.MAssessHandleTree;
import com.anticw.aged.bean.MAssessHandled;
import com.anticw.aged.bean.MAssessResult;
import com.anticw.aged.dao.professional.handle.HandleDao;
import com.anticw.aged.dao.professional.handle.MAccessResultDao;

@Service
public class HandleService {

	@Autowired
	private HandleDao handleDao;
	@Autowired
	private HandleToolService handleToolService;
	@Autowired
	private HandleTreeService handleTreeService;
	@Autowired
	private LogisticsAndFisherModelService logisticsAndFisherJudgeService;
	@Autowired
	private MAccessResultDao mAccessResultDao;
	@Autowired
	private TreeJudgeModelService treeJudgeModelService;
	
	public void insertHandle(MAssessHandle maHandle) throws IllegalAccessException, InvocationTargetException{
		//插入原始数据
		handleDao.insertHandle(maHandle);
		//logistic,fisher预处理
		MAssessHandled mAssessHandle = handleToolService.handled(maHandle);
		//插入预处理结果
		handleDao.insertHandled(mAssessHandle);
		//决策树预处理
		MAssessHandleTree mTree = handleTreeService.handled(maHandle);
		//插入决策树预处理结果
		handleDao.insertHandleTree(mTree);
		
		MAssessResult mr = logisticsAndFisherJudgeService.disability(mAssessHandle,maHandle);
		//决策树 sql
		MAssessResult assessResult = treeJudgeModelService.disability(mTree);
		
		double disability = assessResult.getTreeDisability()/100;
		BigDecimal disable  = new BigDecimal(disability);
		
		BigDecimal health = new BigDecimal(1- disability);
		health = health.setScale(4, BigDecimal.ROUND_HALF_UP);
		double healthy = health.doubleValue();
		
		mr.setTreeDisability(disability);
		mr.setTreeHealthy(healthy);
		if (disable != null && health != null) {
			if (disable.compareTo(health) >=0) {
				mr.setTreeResult("disability");
			} else {
				mr.setTreeResult("healthy");
			}
		}
		mAccessResultDao.insertResult(mr);
	}
	
	public List<MAssessResult> selectResult(String userId){
		return handleDao.selectResult(userId);
	}
	
}
