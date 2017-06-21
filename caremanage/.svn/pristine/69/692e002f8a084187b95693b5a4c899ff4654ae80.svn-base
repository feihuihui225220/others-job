package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.CareMusic;
import com.anticw.aged.dao.icare.vip.IcareMusicDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class CareMusicService{
	@Autowired
	private IcareMusicDao icareMusicDao;

	/**
	 * 查询一首音乐TODO
	 *@param id
	 *@return
	 */
	public CareMusic getMusicById(int id){
		return icareMusicDao.get(id);
	}
	/**
	 * 添加音乐
	 *@param careMusic
	 *@return
	 */
	public Integer addMusic(CareMusic careMusic){
		careMusic.setCreateTime(new Date());
		careMusic.setChangeTime(new Date());
		careMusic.setAvailable(true);
		return (Integer) icareMusicDao.save(careMusic);
	}
	/**
	 * 删除音乐
	 *@param careMusic
	 *@return
	 */
	public void removeMusic(Integer id){
		icareMusicDao.removeById(id);
	}
	/**
	 * 修改音乐TODO
	 *@param careMusic
	 */
	public void modifyMusic(CareMusic careMusic){
		careMusic.setChangeTime(new Date());
		icareMusicDao.update(careMusic);
	}
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<CareMusic> getMusicList(int page, int num) {
		return icareMusicDao.getMusicList(page, num);
	}
	
	/**
	 * 查询所有有效的音乐
	 *@param page
	 *@param num
	 *@return
	 */
	public Page<CareMusic> getMusicListByCategory(int page, int num,Integer category) {
		return icareMusicDao.getMusicListByCategory(page, num,category);
	}
}
