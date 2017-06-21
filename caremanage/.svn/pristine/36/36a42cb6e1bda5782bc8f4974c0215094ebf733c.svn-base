package com.anticw.aged.service.community.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.ONotice;
import com.anticw.aged.bean.utils.CommunityConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.community.notice.NoticeDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.service.attchment.AttchmentHandle;
import com.anticw.aged.vo.community.NoticeSearchVo;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private AttchmentHandle attchsrc;
	
	public Page<ONotice> list(int pageNo,int pageSize,int communityId){
		return noticeDao.list(pageNo,pageSize,communityId);
	}
	public Page<ONotice> listByCriteria(int pageNo,int pageSize,NoticeSearchVo searchVo,int communityId){
		List<Criterion> criterions= new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("available", PropertyValueConstants.AVAILABLE));
		criterions.add(Restrictions.eq("communityId", communityId));
		if(!("".equals(searchVo.getTitle())||null==searchVo.getTitle())){
			criterions.add(Restrictions.like("title", searchVo.getTitle(),MatchMode.ANYWHERE));//标题
		}
		if(!("".equals(searchVo.getPublisher())||null==searchVo.getPublisher())){
			criterions.add(Restrictions.like("publisher", searchVo.getPublisher(),MatchMode.ANYWHERE));//发布单位
		}
		if(!("".equals(searchVo.getKeyword())||null==searchVo.getKeyword())){
			criterions.add(Restrictions.like("keyword", searchVo.getKeyword(),MatchMode.ANYWHERE));//关键词
		}
		if(searchVo.getCategory()!=0){
			criterions.add(Restrictions.eq("categoryId", searchVo.getCategory()));//分类
		}
		return noticeDao.listByCriteria(pageNo, pageSize, criterions);
	}
	/**
	 * 增加公告
	 * 李飞
	 * @param oNotice
	 * @param files
	 * @param opUser
	 * @param communityId
	 * @throws IOException 
	 */
	public void addNotice(ONotice oNotice,MultipartFile[] file,String opUser,int communityId) throws IOException{
		String attdir = "";
		Date date = new Date();
		oNotice.setVersion(PropertyValueConstants.DEFAULT_VERSION);
		oNotice.setAvailable(PropertyValueConstants.AVAILABLE);
		oNotice.setCreatedAt(date);
		oNotice.setCreatedBy(opUser);
		oNotice.setChangedAt(date);
		oNotice.setChangedBy(opUser);
		oNotice.setCommunityId(communityId);
		if(file!=null&&file.length>0){
			String[] directorys = attchsrc.upload(CommunityConstants.NOTICEATTTYPE, file, oNotice.getCommunityId().toString());
			if(directorys!=null){	
				StringBuilder directory = new StringBuilder();
				for(String str:directorys){
					directory.append(str+",");
				}
				directory.deleteCharAt(directory.lastIndexOf(","));
				attdir = directory.toString();
			}
		}
		
		oNotice.setDirectory(attdir);
		noticeDao.addNotice(oNotice);
	}
	public ONotice getNotice(int id){
		return noticeDao.get(id);
	}
	/**
	 * 编辑公告
	 * @param oNotice
	 * @param file
	 * @param opUser
	 * @param communityId
	 * @throws IOException 
	 */
	public void editNotice(ONotice oNotice,MultipartFile[] file,String opUser,int communityId) throws IOException{
		Date date = new Date();
		ONotice oriNotice = getNotice(oNotice.getId());
		oriNotice.setTitle(oNotice.getTitle());
		oriNotice.setPublisher(oNotice.getPublisher());
		oriNotice.setContent(oNotice.getContent());
		oriNotice.setKeyword(oNotice.getKeyword());
		oriNotice.setCategoryId(oNotice.getCategoryId());
		String attdir = "";
		if(file!=null&&file.length>0){
			String[] directorys = attchsrc.upload(CommunityConstants.NOTICEATTTYPE, file, oriNotice.getCommunityId().toString());
			if(directorys!=null){	
				StringBuilder directory = new StringBuilder();
				for(String str:directorys){
					directory.append(str+",");
				}
				directory.deleteCharAt(directory.lastIndexOf(","));
				attdir = directory.toString();
				String finaldir = oriNotice.getDirectory().trim().length()>0?oriNotice.getDirectory()+","+attdir:attdir;
				oriNotice.setDirectory(finaldir);
			}
		}
		oriNotice.setChangedBy(opUser);
		oriNotice.setChangedAt(date);
		noticeDao.editNotice(oriNotice);
	}
	public void deleteAtt(int index,int id){
		ONotice oriNotice = getNotice(id);
		String directory = oriNotice.getDirectory();
		String[] dirs = directory.split(",");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<dirs.length;i++){
			if(i!=index){
				sb.append(dirs[i]);
				sb.append(',');
			}
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.lastIndexOf(","));
		}
		oriNotice.setDirectory(sb.toString());
		noticeDao.editNotice(oriNotice);
	}
	/**
	 * 逻辑删除
	 * @param id
	 */
	public void deleteNotice(int id,String opUser){
		Date date = new Date();
		ONotice notice = noticeDao.getNotice(id);
		notice.setAvailable(CommunityConstants.UNAVAILABLE);
		notice.setChangedBy(opUser);
		notice.setChangedAt(date);
		noticeDao.editNotice(notice);
	}
}
