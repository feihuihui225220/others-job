package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NPhoto;
import com.anticw.aged.dao.professional.activity.PhotoDao;
 

@Service
public class PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	public void insertPhoto(NPhoto Photo) {
		photoDao.insertPhoto(Photo);
	}

	 
	public void deletePhoto(NPhoto nPhoto) {
		photoDao.deletePhoto(nPhoto);
	}

	public NPhoto findOnePhoto(Integer id) {
		return photoDao.findOnePhoto(id);
	}

	public void editPhoto(NPhoto Photo) {
		photoDao.editPhoto(Photo);

	}

	public List<NPhoto> findAllPhoto(int albumId) {
		return photoDao.findAllPhoto(albumId);
	}
	public void deleteAlbum(List<NPhoto> nPhoto){
		photoDao.deleteAlbum(nPhoto);
	}
	/**
	 * 查询一个相册中所有照片
	 */
	public List<NPhoto> findsPhoto(int albumId) {
		return photoDao.findsPhoto(albumId);
	}
}
