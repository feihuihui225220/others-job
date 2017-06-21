package com.anticw.aged.dao.transfer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anticw.aged.bean.HTransfer;
import com.anticw.aged.dao.utils.HibernateEntityDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Component
public class HTransferDao extends  HibernateEntityDao<HTransfer>{


	/**
	 * 查询所有转诊信息 巡诊管理
	 * @return
	 */
	public Page<HTransfer> listHTransfer(PageParamVO page,
			String start,String end,String state,Integer esc,String uId){
		//查询条件
		String hqlStr = "from HTransfer where 1=1";
		if(uId!=null){
			hqlStr+=" and rUser.id="+uId;
		}
		if(state!=null){
			hqlStr+=" and state="+state;
		}
		if(start!=null&&end!=null){
			hqlStr+=" and createTime BETWEEN '"+start+"' AND '"+end+"'";
		}
		if(start!=null&&end==null){
			hqlStr+="and createTime > '"+start+"'";
		}
		if(start==null&&end!=null){
			hqlStr+="and createTime <'" +end+"'";
		}
		if(esc==1){
			hqlStr+="order by applyTime";
		}else{
			hqlStr+="order by applyTime desc";
		}//分页查询
		return super.pagedQuery(hqlStr, page.getPage(), page.getNum());
	}
	/**添加Htransfer*/
	public void addHTransfer(HTransfer transfer){
		super.save(transfer);
	}
	/**根据Id查询htransfer*/
	public HTransfer htransferById(Integer hId){
		String hql="from HTransfer where id="+hId;
		return (HTransfer) super.find(hql).get(0);
	}
	/**
	 * 修改htransfer
	 */
	public void modifyHTransfer(HTransfer transfer){
		super.update(transfer);
	}
	//统计
	public List<HTransfer> countTransfer() {
		String hql="SELECT count(id),id, hGroup.userName FROM HTransfer  GROUP BY hGroup.id";
		return super.find(hql);
	}
	public Long sumTransfer() {
		String hql="from HTransfer";
		return super.getCount(hql);
	}
	
	
	
	
}
