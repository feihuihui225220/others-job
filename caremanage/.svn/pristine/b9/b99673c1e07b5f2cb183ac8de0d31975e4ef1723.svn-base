package com.anticw.aged.service.professional.activity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.NVenderMaterial;
import com.anticw.aged.bean.NVideo;
import com.anticw.aged.dao.professional.activity.NProgramDao;
import com.anticw.aged.dao.professional.activity.NVenderMaterialDao;
import com.anticw.aged.dao.professional.activity.NVideoDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.professional.activity.NProgramVO;

@Service
public class NProgramService {

	@Autowired
	private NProgramDao nProgramDao;
	@Autowired
	private NVideoDao nVideoDao;
	@Autowired
	private NVenderMaterialDao nVenderMaterialDao;

	public Page<NProgramVO> seeNProgram(int pageIndex, int pagesize,
			String createdBy) {
		Page<NProgram> pa = nProgramDao.seeNProgram(pageIndex, pagesize,
				createdBy);
		List<NProgramVO> li = new ArrayList<NProgramVO>();
		for (NProgram n : pa.getResult()) {
			NProgramVO np = new NProgramVO();
			if (nVideoDao.fingByNPId(n.getId()) != null) {
				NVideo nv = nVideoDao.fingByNPId(n.getId());
				np.setImgUrl(nv.getImgUrl());
				np.setFileUrl(nv.getFileUrl());
				np.setFileName(nv.getFileName());
				np.setCreateId(nv.getCreateId());
				np.setDescript(nv.getDescript());
			}
			np.setAvaliable(n.getAvaliable());
			np.setCreatedAt(n.getCreatedAt());
			np.setCreatedBy(n.getCreatedBy());
			np.setId(n.getId());
			np.setProgramDesc(n.getProgramDesc());
			np.setProgramName(n.getProgramName());
			li.add(np);
		}
		Page<NProgramVO> page = new Page<NProgramVO>();
		page.setOrderBy(pa.getOrder());
		page.setPageNo(pa.getPageNo());
		page.setPageSize(pa.getPageSize());
		page.setResult(li);
		page.setTotalCount(pa.getTotalCount());
		return page;
	}

	public List<NProgram> listNProgram(String name) {
		return nProgramDao.listNProgram(name);
	}

	public Page<NProgram> gerList(Integer parentId, int pagesize, int num,
			String keyword) {
		return nProgramDao.gerList(parentId, pagesize, num, keyword);
	}
	public Page<NProgram> PageNPrograms(String keywords, int teacherId,
			Integer type,int pagesize, int num){
		return nProgramDao.PageNPrograms(keywords,teacherId,type, pagesize, num);
	}

	public NProgram addNProgram(NProgram nProgram) {
		nProgram.setPageView(0);
		return nProgramDao.addNProgram(nProgram);
	}

	public NProgram selNProgram(int id) {
		return nProgramDao.selNProgram(id);
	}

	public void delete(NProgram nProgram) {
		nProgramDao.delete(nProgram);
	}

	public NProgram update(NProgram nProgram) {
		nProgramDao.update(nProgram);
		return nProgram;
	}

	public List<NProgram> ListNPrograms(String name) {
		return nProgramDao.ListNPrograms(name);
	}

	public NVenderMaterial saveNVenderMaterial(NVenderMaterial nVenderMaterial) {
		nVenderMaterialDao.save(nVenderMaterial);
		return nVenderMaterial;
	}

	public NProgram  ListNProgram(int teacherId){
		return nProgramDao.ListNProgram(teacherId);
	}
	
	public void deleteNVenderMaterial(NProgram nProgram) {
		nVenderMaterialDao.delete(nProgram);
	}

	/**
	 * 节目分类下所有节目
	 * 
	 * @param id
	 * @return
	 */
	public List<NProgram> ListNPrograms(int id) {
		return nProgramDao.ListNPrograms(id);
	}
	
	public NProgram get(int id){
		return nProgramDao.get(id);
	}

	public List<NProgram> ListNProgramsz() {
		return nProgramDao.ListNProgramsz();
	}
	
	public List<NProgram> ListNPrograms_(String ids) {
		return nProgramDao.ListNPrograms_(ids);
	}
	
	public int update(int id){
		NProgram n=get(id);
		if(n.getPageView()!=null){
			n.setPageView(n.getPageView()+1);
		}else{
			n.setPageView(1);
		}
		nProgramDao.update(n);
		return n.getPageView();
	}
	public int update(int id,Long userId){
		NProgram n=get(id);
		if(n.getThumbs()==null||n.getThumbs().equals("")){
			 n.setThumbs(String.valueOf(userId));
		}else{
			String Thumbs=n.getThumbs();
			 String[] thumb=n.getThumbs().split(",");
			 int th=0;
			 for(String t:thumb){
				 if(userId.toString().equals(t)){
					 th=1;
					 break;
				 }
			 }
			 if(th==0){
				 Thumbs+=",";
				 Thumbs+=userId;
				 n.setThumbs(Thumbs);
			 }else{
				 return -1;
			 }
			 
		}
		nProgramDao.update(n);
		if(!n.getThumbs().split(",")[0].equals("")){
			return n.getThumbs().split(",").length;
		}
		return 0;
	}
	
}
