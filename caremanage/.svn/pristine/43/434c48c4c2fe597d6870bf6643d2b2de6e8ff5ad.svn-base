/**
 * 
 */
package com.anticw.aged.service.scheduler;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.anticw.aged.service.community.user.RUserService;

/**
 * 更新年龄定时任务
 * @author guoyongxiang
 * Date: 2014-10-30
 */
public class UserAgeQuartzJobTask extends QuartzJobBean {

	private static Logger logger = LoggerFactory.getLogger(UserAgeQuartzJobTask.class);

	@Resource
	private RUserService ruserService;
	public void setRuserService(RUserService ruserService) {
		this.ruserService = ruserService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		doTask();
	}
	
	/**
	 * 更新当天生日的用户的年龄
	 * @author guoyongxiang
	 * Date: 2014-11-7 下午1:56:45
	 */
	private void doTask(){
		long start = System.currentTimeMillis();
		logger.info("UserAgeQuartzJobTask start.");
		try {
			this.ruserService.updateAge();
		} catch (Exception e) {
			logger.error("UserAgeQuartzJobTask Exception:", e);
		}
		logger.info("UserAgeQuartzJobTask end.cost time:" + (System.currentTimeMillis() - start));
	}
}
