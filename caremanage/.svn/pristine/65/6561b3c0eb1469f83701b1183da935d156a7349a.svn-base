package com.anticw.aged.service.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.HTransfer;
import com.anticw.aged.dao.transfer.HTransferDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.PageParamVO;

@Service
public class HTransferService {

	@Autowired
	private HTransferDao transferDao;
	
	/**
	 * 查询所有转诊信息
	 */
	public Page<HTransfer> lsitHtransfer(PageParamVO page,
			String start,String end,String state,Integer esc,String uId){
		if(("").equals(start)){
			start=null;
		}
		if(("").equals(end)){
			end=null;
		}
		if(("").equals(state)||("0").equals(state)){
			state=null;
		}
		if(esc==null){
			esc=0;
		}
		if(("").equals(uId)){
			uId=null;
		}
		return transferDao.listHTransfer(page,start,end,state,esc,uId);
	}
	public void addHTransfer(HTransfer transfer){
		transferDao.addHTransfer(transfer);
	}
	/**根据id查询htransfer*/
	public HTransfer htransferById(Integer hId){
		return transferDao.htransferById(hId);
	}
	/**
	 * 修改htransfer
	 */
	public void modifyHTransfer(HTransfer transfer){
		transferDao.modifyHTransfer(transfer);
	}
	/**
	 * 统计
	 */
	public List<HTransfer> countTransfer() {
		
		return transferDao.countTransfer();
	}
	/**
	 * 求和
	 */

	public Long sumTransfer() {
		return transferDao.sumTransfer();
	}
}
