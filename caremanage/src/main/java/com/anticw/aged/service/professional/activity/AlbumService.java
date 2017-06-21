package com.anticw.aged.service.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NAlbum;
import com.anticw.aged.dao.professional.activity.AlbumDao;
import com.anticw.aged.dao.utils.Page;

@Service
public class AlbumService {

	@Autowired
	private AlbumDao albumDao;
	
	public void insertAlbum(NAlbum album) {
		albumDao.insertAlbum(album);

	}

	public void deleteAlbum(NAlbum  nAlbum) {
		albumDao.deleteAlbum(nAlbum);
	}

	 
	public NAlbum findOneAlbum(Integer id) {
		return albumDao.findOneAlbum(id);
	}

	 
	public void editAlbum(NAlbum album) {
		albumDao.editAlbum(album);

	}

	public List<NAlbum> findAllAlbum(String createBy) {
		return albumDao.findAllAlbum(createBy);
	}
	public Page<NAlbum> findAllAlbumWeixin(int page ,int size) {
		return albumDao.findAllAlbumWeixin(page,size);
	}
	
	public List<NAlbum> findAllAlbum(int activityId) {
		return albumDao.findAllAlbum(activityId);
	}

}
