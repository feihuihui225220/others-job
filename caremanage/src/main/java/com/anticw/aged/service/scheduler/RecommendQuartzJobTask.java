/**
 * 
 *//*
package com.anticw.aged.service.scheduler;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import com.anticw.aged.service.professional.RecommandService;

*//**
 * 服务推荐
 * @author guoyongxiang
 * Date: 2014-10-17
 *//*
@Service
public class RecommendQuartzJobTask extends QuartzJobBean{

	private static Logger logger = LoggerFactory.getLogger(RecommendQuartzJobTask.class);
	@Resource
	private RecommandService recommandService;
	public void setRecommandService(RecommandService recommandService) {
		this.recommandService = recommandService;
	}


	 (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		doTask();
	}
	
	*//**
	 * 服务推荐定时任务
	 * @author guoyongxiang
	 * Date: 2014-10-17 下午9:33:32
	 *//*
	private void doTask(){
		long start = System.currentTimeMillis();
		logger.info("RecommendQuartzJobTask start.");
		try {
			this.recommandService.recommandServer();
		} catch (Exception e) {
			logger.error("RecommendQuartzJobTask Exception:", e);
		}
		logger.info("RecommendQuartzJobTask end.cost time:" + (System.currentTimeMillis() - start));
	}
}
*/