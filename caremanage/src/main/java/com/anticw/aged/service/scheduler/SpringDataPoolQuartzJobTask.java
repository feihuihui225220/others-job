package com.anticw.aged.service.scheduler;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.anticw.aged.pool.SpringDataPool;

public class SpringDataPoolQuartzJobTask extends QuartzJobBean {


	@Resource
	private SpringDataPool springDataPool;
	public void setRuserService(SpringDataPool springDataPool) {
		this.springDataPool = springDataPool;
	}

	/**
	 * 清空当天的浏览记录
	 */
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		 doTask();
	}
	private void doTask(){
		springDataPool.remove();
	}
}
