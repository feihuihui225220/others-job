package com.anticw.aged.service.icare.photo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZPhoto;
import com.anticw.aged.dao.icare.photo.IcarePhotoDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Service
public class IcarePhotoService {
	@Autowired
	private IcarePhotoDao photoDao;
	
	public void insertPhoto(ZPhoto Photo) {
		photoDao.insertPhoto(Photo);
	}

	 
	public void deletePhoto(ZPhoto photo) {
		photoDao.deletePhoto(photo);
	}

	public ZPhoto findOnePhoto(Long id) {
		return photoDao.findOnePhoto(id);
	}

	public void editPhoto(ZPhoto Photo) {
		photoDao.editPhoto(Photo);

	}

	public Page<ZPhoto> findAllPhoto(PageParamVO vo,String startTime,String endTime,Long rId) {
		if(("").equals(startTime)){
			startTime=null;
		}
		if(("").equals(endTime)){
			endTime=null;
		}
		return photoDao.findAllPhoto(vo,startTime,endTime,rId);
	}
	public void deleteAlbum(List<ZPhoto> photo){
		photoDao.deleteAlbum(photo);
	}
	/**
	 * 查询一个相册中所有照片
	 */
	public List<ZPhoto> findsPhoto(int albumId) {
		return photoDao.findsPhoto(albumId);
	}
	/**
	 * 微信端
	 */
	public List<ZPhoto> listPhotoByIdAndDay(Long rId,Date date){
		return photoDao.listPhotoByIdAndDay(rId,date);
	}
	public List<ZPhoto> listWX(Long rId){
		return photoDao.listWX(rId);
	}
}
