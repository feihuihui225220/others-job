package com.anticw.aged.service.icare.vip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZAgreement;
import com.anticw.aged.dao.icare.vip.AgreementDao;

/**
 * 作者：bsd
 * 日期：2016-10-19
 * 功能：TODO	
 */
@Service
public class AgreementService{
	
	@Autowired
	private AgreementDao agreementDao;
	
	/**
	 * 添加
	 */
	public Integer add(ZAgreement agreement){
		agreement.setCreatedAt(new Date());
		agreement.setAvailable(true);
		return (Integer) this.agreementDao.save(agreement);
	}
	/**
	 * 删除
	 */
	public void remove(Integer id){
		agreementDao.removeById(id);
	}
	/**
	 * 修改
	 */
	public void modify(ZAgreement agreeement){
		ZAgreement agr = agreementDao.get(agreeement.getId());
		agr.setChangedAt(new Date());
		agr.setVersion((short) (agr.getVersion()+1));
		agreementDao.update(agr);
	}

	/**
	 * 查询一条
	 */
	public ZAgreement getById(int id){
		return agreementDao.get(id);
	}
	
}
