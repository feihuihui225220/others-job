package com.anticw.aged.dao.professional.activity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NAlbum;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.utils.file.FileHandle;

@Component
public class AlbumDao extends HibernateEntityDao<NAlbum>{
	@Autowired
	private FileHandle fileHandle;
	/**
	 * 添加相册
	 * @param activityPlan
	 * @return
	 */
	public void insertAlbum(NAlbum album){
		Date date = new Date();
		album.setAvaliable(PropertyValueConstants.AVAILABLE);
		album.setCreatedAt(date);
		album.setChangedAt(date);
		super.save(album);
	}
	/**
	 * 删除一个相册
	 * @param id
	 */
	public void deleteAlbum(NAlbum nAlbum){
		try {
			fileHandle.removePic(nAlbum.getAlbumUrl());
			super.removeById(nAlbum.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("相册封面未删除");
		}
		
	}
	/**
	 * 查询一个相册内容
	 * @param id
	 * @return
	 */
	public NAlbum findOneAlbum(Integer id){
		return super.get(id);
		
	}
	/**
	 * 编辑相册
	 * @param album
	 */
	public void editAlbum(NAlbum album){
		NAlbum al = findOneAlbum(album.getId());
		Date date = new Date();
		al.setChangedAt(date);
		al.setChangedBy(album.getChangedBy());
		super.update(al);
	}
	/**
	 * 按创建者查询所有相册
	 * @param createBy：创建人账号
	 * @return
	 */
	public List<NAlbum> findAllAlbum(String createBy){
		String hql = "from NAlbum where avaliable=? and createdBy=? order by createdAt  desc";
		return super.find(hql, PropertyValueConstants.AVAILABLE,createBy);
	}
	/**
	 * 查询所有相册
	 * @param createBy：创建人账号
	 * @return
	 */
	public Page<NAlbum>   findAllAlbumWeixin(int page, int size){
		
		String hql = "from NAlbum where avaliable=? order by createdAt  desc";
		return super.pagedQuery(hql,page, size, PropertyValueConstants.AVAILABLE);
	}
	
	/**
	 * 按计划查询所有相册
	 * @param createBy：创建人账号
	 * @return
	 */
	public List<NAlbum> findAllAlbum(int activityId){
		String hql = "from NAlbum where avaliable=? and activityId=?";
		return super.find(hql, PropertyValueConstants.AVAILABLE,activityId);
	}
}
