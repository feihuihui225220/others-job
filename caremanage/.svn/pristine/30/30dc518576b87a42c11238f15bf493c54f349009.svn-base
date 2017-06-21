package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZGuidePhoto;
import com.anticw.aged.dao.icare.vip.GuidePhotoDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class GuidePhotoService{
	@Autowired
	private GuidePhotoDao guidePhotoDao;
	/**
	 * 添加
	 */
	public Integer add(ZGuidePhoto guidePhone){
		guidePhone.setCreatedAt(new Date());
		guidePhone.setChangedAt(new Date());
		guidePhone.setVersion((short) 1);
		guidePhone.setAvailable(true);
		return (Integer) guidePhotoDao.save(guidePhone);
	}
	/**
	 * 删除
	 */
	public void remove(Integer id){
		guidePhotoDao.removeById(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZGuidePhoto guidePhoto){
		ZGuidePhoto guide = guidePhotoDao.get(guidePhoto.getId());
		guide.setChangedAt(new Date());
		guide.setVersion((short)1);
		guide.setAvailable(guidePhoto.getAvailable());
		guidePhotoDao.update(guide);
	}

	/**
	 * 查询一条
	 */
	public ZGuidePhoto getById(int id){
		return guidePhotoDao.get(id);
	}
	/**
	 * 分页查询所有
	 */
	public Page<ZGuidePhoto> getList(int page, int num) {
		return guidePhotoDao.getGuidePhone(page, num);
	}
	
}
