package com.anticw.aged.dao.professional.activity;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.utils.PermissionConstants;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;

/**
 * 节目
 * 
 * @author dx
 */
@Repository
public class NProgramDao extends HibernateEntityDao<NProgram> {
	/**
	 * 分页查询所有用户
	 * 
	 * @param pageIndex
	 * @param pagesize
	 * @param createdBy
	 * @return
	 */
	public Page<NProgram> seeNProgram(int pageIndex, int pagesize,
			String createdBy) {
		return this
				.pagedQuery(
						"from NProgram n where n.createdBy=? and n.avaliable=true order by n.createdAt desc",
						pageIndex, pagesize, createdBy);
	}

	/**
	 * 无分页
	 * 
	 * @return
	 */
	public List<NProgram> listNProgram(String name) {
		return super
				.find("from NProgram n where n.avaliable=? and createdBy=? order by n.createdAt desc",
						PropertyValueConstants.AVAILABLE, name);
	}

	/**
	 * 添加一个节目
	 * 
	 * @param nProgram
	 */
	public NProgram addNProgram(NProgram nProgram) {
		super.save(nProgram);
		return nProgram;
	}

	/**
	 * 查询一个节目
	 * 
	 * @param id
	 * @return
	 */
	public NProgram selNProgram(int id) {
		List<NProgram> nProgram = super
				.find("from NProgram n where n.id=?", id);
		return nProgram.get(0);
	}

	public Page<NProgram> gerList(Integer parentId, int pagesize, int num,
			String keyword) {
		String hql = "from NProgram n where n.parentId=? and n.avaliable=?";
		if (keyword != "" && keyword != null) {
			hql += " and (n.keyword like '%"+keyword+"%' or   n.programName like '%"+keyword+"%') ";
		}

		return super.pagedQuery(hql, pagesize, num, parentId,
				PropertyValueConstants.AVAILABLE);
	}
	
	public Page<NProgram> PageNPrograms(String keywords, int teacherId,
			Integer type,int pagesize, int num) {
		String hql = "from NProgram n where  n.avaliable=? and n.subjectTeacher like '%"
				+ teacherId + "%' ";
		if (type == 0 || type == 2 ) {
			if(keywords!=null&&keywords.trim()!=""){
				hql += " and  n.keyword like '%" + keywords + "%' ";
			}
		} else if (type == 1) {
			if(keywords!=null&&keywords.trim()!=""){
			hql += " and  n.programName '%" + keywords + "%' ";
			}
		}
		return super.pagedQuery(hql, pagesize, num, 
				PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 删除一个节目
	 * 
	 * @param nProgram
	 */
	public void delete(NProgram nProgram) {
		super.update(nProgram);
	}

	/**
	 * 活动管理查询节目
	 * 
	 * @param ids
	 * @return
	 */
	public List<NProgram> findNPrograms(String ids) {
		return super.find("from NProgram where id in(" + ids + ")");
	}

	/**
	 * 查询节目分类
	 * 
	 * @param username
	 * @return
	 */
	public List<NProgram> ListNPrograms(String username) {
		return super.find(
				"from NProgram n where n.createdBy=? and n.parentId=?",
				username, PermissionConstants.PARENT_Id);
	}

	/**
	 * 节目分类下所有节目
	 * 
	 * @param id
	 * @return
	 */
	public List<NProgram> ListNPrograms(int id) {
		return super.find(
				"from NProgram n where n.parentId=?  and n.avaliable=?", id,
				PropertyValueConstants.AVAILABLE);
	}

	/**
	 * 本次活动中专业老师选取课程｛默认｝
	 * 
	 * @param keywords
	 * @param teacherId
	 * @return
	 */
	public List<NProgram> ListNPrograms(String keywords, int teacherId,
			Integer type) {
		String hql = "from NProgram n where n.subjectTeacher like '%"
				+ teacherId + "%' ";
		if (type == 0 || type == 2 ) {
			if(keywords!=null&&keywords.trim()!=""){
				hql += " and  n.keyword like '%" + keywords + "%' ";
			}
		} else if (type == 1) {
			if(keywords!=null&&keywords.trim()!=""){
			hql += " and  n.programName '%" + keywords + "%' ";
			}
		}
		return super.find(hql);
	}

	public NProgram ListNProgram(int teacherId) {
		String hql = "from NProgram n where n.subjectTeacher like '%"
				+ teacherId + "%'  and  n.parentId =0";
		List<NProgram> np = super.find(hql);
		if (np.size() != 0) {
			return np.get(0);
		}
		return null;
	}

	/**
	 * 本次活动中专业老师选取课程｛新增标签｝
	 * 
	 * @param week
	 * @param teacherId
	 * @return
	 */
	public List<NProgram> ListNProgramsTwo(String week, int teacherId) {
		String hql = "from NProgram n where  n.keyword like '%" + week
				+ "%'' and n.subjectTeacher like '%" + teacherId + "%' ";
		return super.find(hql);
	}

	/**
	 * 套餐中课程
	 * 
	 * @param ids
	 * @return
	 */
	public List<NProgram> getVipList(String ids) {
		String hql = "from NProgram n where id in(" + ids + ")";
		return super.find(hql);
	}

	// SELECT * FROM n_program np WHERE np.id IN(SELECT n.program_id FROM
	// n_vender_material n WHERE n.material_name LIKE '%小%') AND
	// np.subject_teacher in(2009)

	public List<NProgram> ListNPrograms() {
		return super.find(
				"from NProgram n where  n.parentId=? and avaliable=?",
				PermissionConstants.PARENT_Id, PermissionConstants.AVAILABLE);
	}

	/**
	 * 查询节目分类admin
	 * 
	 * @param username
	 * @return
	 */
	public List<NProgram> ListNProgramsz() {
		return super.find(
				"from NProgram n where  n.parentId=?",
				 PermissionConstants.PARENT_Id);
	}
	
	
	public List<NProgram> ListNPrograms_(String ids) {
		return super.find("from NProgram n where  id in(" + ids + ") and avaliable=1 and type!=1");
	}
	
	public List<NProgram> Lists() {
		return super.find("from NProgram ");
	}
}
