package com.anticw.aged.controller.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.service.scheduler.AlarmTaskService;

/**
 * 通用定时任务控制器
 * 定时任务由linux crontab进行调度
 * @author zhouyanxin
 */
@Controller
@RequestMapping("/common")
public class SchedulerCtl {

	/**
	 * 报警数据抓取定时任务处理类
	 */
	@Autowired
	private AlarmTaskService alarmTaskService;
	
	/**
	 * 抓取警报数据
	 */
	@RequestMapping("/catchAlarm")
	public @ResponseBody String catchAlarmData() {
		try {
			alarmTaskService.alarmCatchTask();
			return "success";
		} catch (BusinessException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
