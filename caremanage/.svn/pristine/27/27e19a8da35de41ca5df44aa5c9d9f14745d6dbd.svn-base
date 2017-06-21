package com.anticw.aged.service.position;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MPosition;
import com.anticw.aged.dao.position.MPositionsDao;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.dao.utils.Page;


@Service
@Component
public class PositionService {

	@Autowired
	private MPositionsDao mPositiondao;
	@Autowired
	private OrderDao orderDao;
	//分页查
	public Page<MPosition> list(int page,int num){
		return mPositiondao.list(page, num);
	}
	public Page<MPosition> listByCategory(int page,int num,int category){
		return mPositiondao.listByCategory(page, num, category);
	}
	//插入信息
	public void insertPosition(MPosition mposition){
		mPositiondao.insertPosition(mposition);
	}
	//id查找
	public MPosition findMPositionById(Long id){
		return mPositiondao.findMPositionById(id);
	}
	//按时间与userid查询位置信息
	public List<MPosition> findByIdandTime(long userId,Date createTime){
		return mPositiondao.findByIdandTime(userId, createTime);
	}
	//修改位置
	public void editPosition(MPosition mposition){
		this.mPositiondao.editMPosition(mposition);
	}
	//删除位置通过id（修改状态）
	public void delPositionById(Long id){
		this.mPositiondao.deletePositionById(id);
	}
	//直接删除
	public void delPositionBy(Long id){
		this.mPositiondao.deletePositionBy(id);
	}
	
	/**
	 * 获取用户userid
	 * @param bindId
	 * @return
	 */
	public Long getByDeviceId(String bindId) {
		return orderDao.getByDeviceId(bindId);
	}
	
	/**
	 * 获取腕表的设备id
	 * @param userId
	 * @return
	 */
	public String getByUserId(Long userId){
		return orderDao.getByUserId(userId);
	}
	
}
