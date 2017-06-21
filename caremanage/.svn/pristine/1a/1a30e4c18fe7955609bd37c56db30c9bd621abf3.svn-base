package com.anticw.aged.dao.icare.photo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.ZPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class IcarePhotoDao extends HibernateEntityDao<ZPhoto> {

	@Autowired
	private FileHandle fileHandle;

	/**
	 * 添加照片
	 * 
	 * @param activityPlan
	 * @return
	 */
	public void insertPhoto(ZPhoto photo) {
		super.save(photo);
		// 清理缓存
		super.currentSession().clear();
	}

	/**
	 * 删除一个照片
	 * 
	 * @param id
	 */
	public void deletePhoto(ZPhoto ZPhoto) {
		try {
			// fileHandle.remove(ZPhoto.getPhotoUrl());
			super.removeById(ZPhoto.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 查询一个照片内容
	 * 
	 * @param id
	 * @return
	 */
	public ZPhoto findOnePhoto(Long id) {
		return super.get(id);

	}

	/**
	 * 编辑照片
	 * 
	 * @param photo
	 */
	public void editPhoto(ZPhoto photo) {
		super.update(photo);
	}

	/**
	 * 按创建者查询所有照片(当前相册)
	 * 
	 * @param createBy：创建人账号
	 * @return
	 */
	public Page<ZPhoto> findAllPhoto(PageParamVO vo, String startTime, String endTime, Long rId) {
		String hql = "from ZPhoto where avaliable=?";
		if (rId != null) {
			hql += "and userId=" + rId;
		}
		if (startTime != null && endTime != null) {
			hql += "and createdAt BETWEEN '" + startTime + "' And '" + endTime + "'";
		}
		if (startTime != null && endTime == null) {
			hql += "and createdAt >'" + startTime + "' ";
		}
		if (startTime == null && endTime != null) {
			hql += "and createdAt <'" + endTime + "' ";
		}
		hql += "order by createdAt desc";
		return super.pagedQuery(hql, vo.getPage(), vo.getNum(), PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 删除同一个相册中的照片
	 * 
	 * @param albumId
	 */
	public void deleteAlbum(List<ZPhoto> zphoto) {
		try {
			for (ZPhoto n : zphoto) {
				fileHandle.remove(n.getPhotoUrl());
			}
			this.executeSQL("DELETE FROM z_photo WHERE z_photo.come_from =?", zphoto.get(0).getComeFrom());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("相册中无照片");
		}
	}

	/**
	 * 获取相册中所有的照片
	 * 
	 * @param albumId
	 * @return
	 */
	public List<ZPhoto> findsPhoto(int albumId) {
		String hql = "from ZPhoto where albumId=?";
		return super.find(hql, albumId);
	}

	/**
	 * 微信端
	 */
	public List<ZPhoto> listPhotoByIdAndDay(Long rId, Date date) {
		String hql = "from ZPhoto where userId=? and avaliable=?";
		Date start = DateUtil.getStartDate(date);
		Date end = DateUtil.getEndDate(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sta = format.format(start);
		String en = format.format(end);
		hql += "and createdAt BETWEEN'" + sta + "'AND'" + en + "'";
		return super.find(hql, rId, PropertyValueConstants.AVAILABLE);
	}

	@SuppressWarnings("unchecked")
	public List<ZPhoto> listWX(Long rId) {
		String hql = "FROM ZPhoto  WHERE  userId='" + rId
				+ "' AND avaliable=1  GROUP BY DATE_FORMAT(createdAt,'%Y%m%d') ORDER BY createdAt DESC";
		Session session = currentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		return query.list();
	}
}
