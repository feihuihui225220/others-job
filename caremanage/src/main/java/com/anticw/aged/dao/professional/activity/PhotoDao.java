package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anticw.aged.bean.NPhoto;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.utils.file.FileHandle;
/**
 * 
 * @authordx
 *
 */
@Component
public class PhotoDao extends HibernateEntityDao<NPhoto>{

	@Autowired
	private FileHandle fileHandle;
	/**
	 * 添加照片
	 * @param activityPlan
	 * @return
	 */
	public void insertPhoto(NPhoto photo){
		super.save(photo);
		//清理缓存
		super.currentSession().clear();
	}
	/**
	 * 删除一个照片
	 * @param id
	 */
	public void deletePhoto(NPhoto nPhoto){
		try {
			fileHandle.remove(nPhoto.getPhotoUrl());
			super.removeById(nPhoto.getId()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**
	 * 查询一个照片内容
	 * @param id
	 * @return
	 */
	public NPhoto findOnePhoto(Integer id){
		return super.get(id);
		
	}
	/**
	 * 编辑照片
	 * @param photo
	 */
	public void editPhoto(NPhoto photo){
		super.update(photo);
	}
	/**
	 * 按创建者查询所有照片(当前相册)
	 * @param createBy：创建人账号
	 * @return
	 */
	public List<NPhoto> findAllPhoto(int albumId){
		String hql = "from NPhoto where avaliable=? and albumId=? order by createdAt desc";
		List<NPhoto> nPhoto=super.find(hql, PropertyValueConstants.AVAILABLE,albumId);
		return nPhoto;
	}
	/**
	 * 删除同一个相册中的照片
	 * @param albumId
	 */
	public void deleteAlbum(List<NPhoto> nPhoto){
		try {
			for(NPhoto n:nPhoto){
				fileHandle.remove(n.getPhotoUrl());
			}
			this.executeSQL("DELETE FROM n_photo WHERE n_photo.album_id =?",nPhoto.get(0).getAlbumId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("相册中无照片");
		}
	}
	/**
	 * 获取相册中所有的照片
	 * @param albumId
	 * @return
	 */
	public List<NPhoto> findsPhoto(int albumId){
		String hql = "from NPhoto where albumId=?";
		return super.find(hql, albumId);
	}
}
