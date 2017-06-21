package com.anticw.aged.vo.professional.vender.alarm;

import java.util.Iterator;
import java.util.List;

import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.vo.common.BaseVO;
import com.anticw.aged.vo.professional.meta.DataModuleItemVO;

/**
 * 报警设置vo
 * <P>File name : AlarmSetVO.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
public class AlarmSetVO implements BaseVO {

	/**
	 * 数据模块列表
	 */
	private List<DataModuleItemVO> items;

	/**
	 * @return List<DataModuleItemVO> 取得域 items 的方法。
	 */
	public List<DataModuleItemVO> getItems() {
		return items;
	}

	/**
	 * @param items 对域 items 的设置方法.
	 */
	public void setItems(List<DataModuleItemVO> items) {
		this.items = items;
	}

	/**
	 * 自检
	 * <P>Author : zhouyanxin </P>      
	 * <P>Date : 2014-10-6 </P>
	 * @return
	 * @throws BusinessException
	 * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
	 */
	public boolean selfValidate() throws BusinessException {
		for(Iterator<DataModuleItemVO> iter = items.iterator(); iter.hasNext();) {
			DataModuleItemVO item = iter.next();
			//如果需要报警但又没有设置报警信息则抛出异常
			if(item.getIsAlarm() == true && (item.getAlarmLower() == null || item.getAlarmUpper() == null)) {
				throw new BusinessException(ExceptionCode.ALARM_SETUP_ERROR);
			}
			//如果需要报警并且没有指定阈则默认设置为0
			if(item.getIsAlarm() == false && (item.getAlarmLower() == null || item.getAlarmUpper() == null)) {
				item.setAlarmLower(0f);
				item.setAlarmUpper(0f);
			}
		}
		return false;
	}
}
