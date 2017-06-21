package com.anticw.aged.dao.professional.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.MMetaService;
import com.anticw.aged.bean.MOrder;
import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.professional.service.DeviceBindVO;

/**
 * 专业服务订单持久化对象
 * <P>File name : OrderDao.java </P>
 * <P>Author : zhouyanxin </P> 
 * <P>Date : 2014-10-6 </P>
 */
@Repository
@Component
public class OrderDao extends HibernateEntityDao<MOrder> {
	
	private final static Integer smartWatch=33;

	/**
	 * 查询指定用户指定状态的订单
	 * OrderDao.findByUser()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-6 </P>
	 * @param userId
	 * @return
	 */
	public List<MOrder> findByUserAndStatus(Long userId, Short status) {
		String hql = "from MOrder m where m.userId = ? and m.status = ?";
		return find(hql, new Object[]{new Long(userId), Short.valueOf(status)});
	}
	public void  getsave(MOrder mOrder){
		String sql="INSERT INTO m_order(user_id,user_name,meta_service_id,start_time,end_time,total_pay,id_card,status,created_at,created_by,changed_at,changed_by,version) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		super.executeSQL(sql, mOrder.getUserId(),mOrder.getUserName(),mOrder.getmMetaService(),mOrder.getStartTime(),mOrder.getEndTime(),mOrder.getTotalPay(),mOrder.getIdCard(),mOrder.getStatus(),mOrder.getCreatedAt(),mOrder.getCreatedBy(),mOrder.getChangedAt(),mOrder.getChangedBy(),mOrder.getVersion());
	}
	/**
	 * 判断用户是否已经开通过指定服务
	 * OrderDao.isOpened()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-8 </P>
	 * @param userId
	 * @param serviceId
	 * @return
	 */
	public boolean isOpened(Long userId, MMetaService mMetaService) {
		String hql = "from MOrder m where m.userId = ? and m.mMetaService = ? and m.endTime > sysdate() and m.status = ?";
		List<MOrder> orders = this.find(hql, new Object[]{userId, mMetaService, ProfessionalConstants.ORDER_STATUS_OPENED});
		return orders != null && !orders.isEmpty();
	}
	
	/**
	 * 获取指定用户指定服务的订单信息
	 * OrderDao.getOrderByUserAndServiceId()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-8 </P>
	 * @param userId
	 * @param serviceId
	 * @return
	 */
	public MOrder getOrderByUserAndServiceId(Long userId, MMetaService mMetaService) {
		String hql = "from MOrder m where m.userId = ? and m.mMetaService = ? and m.status = ?";
		List<MOrder> orders = this.find(hql, new Object[]{userId, mMetaService ,ProfessionalConstants.ORDER_STATUS_OPENED});
		if(orders == null || orders.isEmpty()) {
			return null;
		}else{
			return orders.get(0);
		}
	}
	public List<MOrder> getListMOrder(long userId){
		String hql = "from MOrder m where m.userId = ? and m.status = ?";
		List<MOrder> orders = this.find(hql, new Object[]{userId, ProfessionalConstants.ORDER_STATUS_OPENED});
		return orders;
	}
	/**
	 * 查询指定状态的全部订单
	 * OrderDao.getOrders()<BR>
	 * <P>Author : zhouyanxin </P>  
	 * <P>Date : 2014-10-13 </P>
	 * @param status
	 * @return
	 */
	public List<MOrder> getOrders(Short status) {
		String hql = "from MOrder m where m.status = ?";
		return find(hql, new Object[]{Short.valueOf(status)});
	}
	
	/**
	 * 批量更新
	 * @param orders
	 * @param status
	 */
	public void updateOrdersStatus(List<MOrder> orders, Short status) {
		//super.txBegin();
		for(Iterator<MOrder> iter = orders.iterator(); iter.hasNext();) {
			MOrder order = iter.next();
			order.setStatus(status);
		}
		//super.txCommit();
	}
	
	public List<DeviceBindVO> getDeviceBind(DateParamVO vo){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT m.user_id,d.`device_bind_id` FROM m_order m,m_order_device d WHERE m.status=1 AND m.created_at BETWEEN '");
		sb.append(DateUtil.getCurrentFormatDate(vo.getStart())).append("' AND '").append(DateUtil.getCurrentFormatDate(vo.getEnd()));
		sb.append("' AND m.id=d.`order_id` AND d.`device_type_name`='血压计'");
		List<Object[]> query= super.findBySQLQuery(sb.toString());
		List<DeviceBindVO> fit=new ArrayList<DeviceBindVO>();//第一次录入的数据
		for(int i=0;i<query.size();i++) {
			DeviceBindVO vo1=new DeviceBindVO();
			try {
				Object[]  column= query.get(i);
				vo1.setUserId(((BigInteger)column[0]).longValue());
				vo1.setDeviceBindId(column[1].toString()); 
				fit.add(vo1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return fit;
	}
	
	public List<Object[]> getDeviceBindId(){
		String sql="SELECT m_order_device.`device_bind_id`,m_order.user_id,r_user.`gender` FROM m_order,m_order_device,r_user WHERE `m_order_device`.`device_type_name`='智能床垫（二）' AND m_order.id=m_order_device.`order_id` AND r_user.id=m_order.`user_id` AND m_order.`status`=1";
		List<Object[]> object=   super.findBySQLQuery(sql);
		return object;
		 
	}
	
	/**
	 * 获取用户性别,姓名，紧急联系人手机号
	 * @param deviceBindId
	 * @return
	 */
	public Object[] getUserId(String  deviceBindId){
		StringBuffer sb=new StringBuffer("SELECT r_user.name, m_order.user_id,r_user.`gender`,r_contact.`mobile_phone` ");
		sb.append("FROM m_order,m_order_device,r_user,r_contact WHERE r_user.id=r_contact.`user_id`  ");
		sb.append("  AND m_order.id=m_order_device.`order_id`  ");
		sb.append("AND r_user.id=m_order.`user_id` AND m_order.`status`=1  and m_order_device.`device_bind_id`='").append(deviceBindId).append("'");
		List<Object[]> object=super.findBySQLQuery(sb.toString());
		if(object.size()!=0){
			return object.get(0);
		}
		return null;
	}
	
	public Object[] getUserId_(String  deviceBindId){
		StringBuffer sb=new StringBuffer("SELECT r_user.name,r_contact.`mobile_phone` ");
		sb.append("FROM m_order,m_order_device,r_user,r_contact WHERE r_user.id=r_contact.`user_id`  ");
		sb.append("and `m_order_device`.`device_type_name`='马桶垫' AND m_order.id=m_order_device.`order_id`  ");
		sb.append("AND r_user.id=m_order.`user_id` AND m_order.`status`=1  and m_order_device.`device_bind_id`='").append(deviceBindId).append("'");
		List<Object[]> object=super.findBySQLQuery(sb.toString());
		if(object.size()!=0){
			return object.get(0);
		}
		return null;
	}
	
	/**
	 * 根据类型名称和设备Id获取对应的参数
	 * @param deviceBindId
	 * @param deviceTypeName
	 * @return
	 */
	public Object[] getUserId(String  deviceBindId,String deviceTypeName){
		StringBuffer sb=new StringBuffer("SELECT  r_user.id,r_user.name,`m_order_device`.meta_service_id ");
		sb.append("FROM m_order,m_order_device,r_user WHERE  ");
		sb.append(" `m_order_device`.`device_type_name`='").append(deviceTypeName).append("' AND m_order.id=m_order_device.`order_id`  ");
		sb.append("AND r_user.id=m_order.`user_id` AND m_order.`status`=1  and m_order_device.`device_bind_id`='").append(deviceBindId).append("'");
		List<Object[]> object=super.findBySQLQuery(sb.toString());
		if(object.size()!=0){
			return object.get(0);
		}
		return null;
	}
	
	/**
	 * 根据设备Id获取用户UserID
	 * @param bindId
	 * @return
	 */
	public Long getByDeviceId(String bindId) {
		String sql = "SELECT m_order.`user_id`  FROM  m_order,m_order_device WHERE m_order.id=m_order_device.`order_id` AND m_order_device.`device_bind_id`=? AND m_order.status=1";
		List<Object[]> object = super.findBySQLQuery(sql, bindId);
		if (object.size() != 0) {
			Object o = object.get(0);
			return Long.parseLong(o.toString());
		}
		return 0L;
	}
	
	/**
	 * 根据用户id获取用户智能腕表的设备Id
	 * @param userId
	 * @return
	 */
	public String getByUserId(Long userId) {
		String sql = "SELECT   m_order_device.`device_bind_id`   FROM  m_order,m_order_device WHERE m_order.id=m_order_device.`order_id` AND m_order.status=1 AND m_order.`meta_service_id`=?  AND m_order.`user_id`=? ";
		List<Object[]> object = super.findBySQLQuery(sql, smartWatch,userId);
		if (object.size() != 0) {
			Object o = object.get(0);
			return  o.toString();
		}
		return null;
	}
}
