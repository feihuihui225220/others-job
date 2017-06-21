package com.anticw.aged.service.scheduler;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.anticw.aged.service.icare.combo.ZSubscriberService;
/**
 * 
 * @author DX-2016/12/31
 * <p>订阅定时管理</p>
 *
 */
public class ZSubscriberQuartzJobTask extends  QuartzJobBean {

	private static Logger logger = LoggerFactory.getLogger(UserAgeQuartzJobTask.class);

	 
	@Resource
	private ZSubscriberService zSubscriberService;
	
	public void setzSubscriberService(ZSubscriberService zSubscriberService) {
		this.zSubscriberService = zSubscriberService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		doTask();
	}
	
	/**
	 *  
	 * @author dx
	 * Date: 2016/12/21 15:43 管家中确认用户订阅是否到期
	 */
	private void doTask(){
		long start = System.currentTimeMillis();
		logger.info("ZSubscriberQuartzJobTask start.");
		try {
			this.zSubscriberService.update();
		} catch (Exception e) {
			logger.error("UserAgeQuartzJobTask Exception:", e);
		}
		logger.info("UserAgeQuartzJobTask end.cost time:" + (System.currentTimeMillis() - start));
	}
	
	
}
