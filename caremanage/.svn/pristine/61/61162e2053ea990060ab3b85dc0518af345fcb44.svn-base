package com.anticw.aged.service.professional.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NActivityPlan;
import com.anticw.aged.bean.NVolunteer;
import com.anticw.aged.bean.NVolunteerServiceRecord;
import com.anticw.aged.bean.NVolunteerTrain;
import com.anticw.aged.bean.NVolunteerTrainRecord;
import com.anticw.aged.dao.community.country.OCountryDao;
import com.anticw.aged.dao.professional.activity.NActivityPlanDao;
import com.anticw.aged.dao.professional.activity.NVolunteerServiceRecordDao;
import com.anticw.aged.dao.professional.activity.NVolunteerTrainDao;
import com.anticw.aged.dao.professional.activity.NVolunteerTrainRecordDao;
import com.anticw.aged.dao.professional.activity.VolunteerDao;
import com.anticw.aged.vo.professional.activity.VolunteerTrainingRecordVo;

@Service
public class LogSheetSrevice {
	@Autowired
	private NVolunteerServiceRecordDao nVolunteerServiceRecordDao;
	@Autowired
	private VolunteerDao volunteerDao;;
	@Autowired
	private NActivityPlanDao nActivityPlanDao;
	@Autowired
	private NVolunteerTrainDao nVolunteerTrainDao;
	@Autowired
	private NVolunteerTrainRecordDao nVolunteerTrainRecordDao;
	@Autowired
	private OCountryDao oCountryDao;
	@Autowired
	private NVolunteerAssessService volunteerAssessService; 
	/**
	 * 获取志愿者培训记录表信息
	 * @param createdBy
	 * @param createdAt
	 * @return
	 */
	public List<VolunteerTrainingRecordVo>  getList(String createdBy,Date start,Date end,String venderId){
		List<VolunteerTrainingRecordVo> vo=new ArrayList<VolunteerTrainingRecordVo>();
		List<NVolunteer> nVolunteer= volunteerDao.findListValue(venderId);
		
		//for循环获取所有培训记录
		List<NVolunteerTrain> li=nVolunteerTrainDao.getListNVolunteerTrain(createdBy, start, end);
		 for(NVolunteer nv:nVolunteer){
			 VolunteerTrainingRecordVo v= new VolunteerTrainingRecordVo();
			 for(int i=0;i<li.size();i++){
				 v.getSignIn().put(li.get(i).getTraindate(), "0");
			 }
			 //根据志愿者Id和操作人账户及填加时间
			 int coummountiyId = Integer.parseInt(nv.getCommunity());
			 v.setCommunity(oCountryDao.getCountryById(coummountiyId).getName());
			 v.setSex(nv.getSex());
			 v.setVolunteerName(nv.getName());
			 if(nVolunteerTrainRecordDao.getListVolunteer(createdBy, start, end, nv.getId()).size()!=0){
				 List<NVolunteerTrainRecord> nVolunteerTrain=nVolunteerTrainRecordDao.getListVolunteer(createdBy, start, end,nv.getId());
				 v.setCountRecord(nVolunteerTrain.size());
				 for(int i=0;i<li.size();i++){
					 for(NVolunteerTrainRecord nt:nVolunteerTrain){
					 //获取当前培训信息的详情
							 NVolunteerTrain  nVolunteerTrain1 = nVolunteerTrainDao.getNVolunteerTrain(nt.getTrainId());
							 if(li.get(i).getTraindate()==nVolunteerTrain1.getTraindate()){
								 v.getSignIn().remove(li.get(i).getTraindate());
								 v.getSignIn().put(li.get(i).getTraindate(), "1");
							 }
								
					 }
				 }
			 }
			 vo.add(v);
		 }
		return vo;
	}
	
	public List<Date> getListDate(String createdBy,Date start,Date end){
		List<NVolunteerTrain> li=nVolunteerTrainDao.getListNVolunteerTrain(createdBy, start, end);
		List<Date> date1=new ArrayList<Date>();
		for(NVolunteerTrain d:li){
			date1.add(d.getTraindate());
		}
		return date1;
	}
	public VolunteerTrainingRecordVo  getListPlan(List<String> name,Date start,Date end,int id){
		//获取所有的活动当前月份,得到所需要的时间
		List<NActivityPlan> nActivityPlan=new ArrayList<NActivityPlan>();
		for(String createdBy:name){
			nActivityPlan.addAll(nActivityPlanDao.getList(createdBy, start, end));
		}
		//通过志愿者Id获取所有有效的活动
		List<NVolunteerServiceRecord> nVolunteerServiceRecord=nVolunteerServiceRecordDao.getListNVolunteerServiceRecords(id, start, end);
		VolunteerTrainingRecordVo vo=new VolunteerTrainingRecordVo();
		NVolunteer nVolunteer =volunteerDao.findVolunteerById(id);
		vo.setVolunteerName(nVolunteer.getName());
		vo.setSex(nVolunteer.getSex());
		vo.setCountRecord(nVolunteerServiceRecord.size());
		vo.setPlanNum(nActivityPlanDao.getNum(volunteerDao.get(id).getSiteId().toString()));
		//id换内容
		int coummountiyId = Integer.parseInt(nVolunteer.getCommunity());
		vo.setCommunity(oCountryDao.getCountryById(coummountiyId).getName());
		 for(int i=0;i<nActivityPlan.size();i++){
			 int assessId=volunteerAssessService.getNVolunteerAssessId(nActivityPlan.get(i).getId());//获取本次活动总结量表
			 vo.getVolunteerAssessIds().put(nActivityPlan.get(i).getPubdate(), assessId);
			 vo.getServiceItem().put(nActivityPlan.get(i).getPubdate(),"未签到");//活动名称
			 vo.getPlanDel().put(nActivityPlan.get(i).getPubdate()," ");
			 for(NVolunteerServiceRecord n:nVolunteerServiceRecord){
				 if(nActivityPlan.get(i).getId()==n.getActivityId()){
					 if(n.getServiceItem()!=null){
						 vo.getServiceItem().remove(nActivityPlan.get(i).getPubdate());
						 vo.getServiceItem().put(nActivityPlan.get(i).getPubdate(), n.getServiceItem());
					 }
					 vo.getPlanDel().remove(nActivityPlan.get(i).getPubdate());
					// vo.getPlanDel().put(nActivityPlan.get(i).getPubdate(),nActivityPlan.get(i).getPlanDel());
					 vo.getSignIn().remove(nActivityPlan.get(i).getPubdate());
					 vo.getSignIn().put(nActivityPlan.get(i).getPubdate(), "1");
					 vo.getContent().put(nActivityPlan.get(i).getPubdate(), nActivityPlan.get(i).getPlanDesc());
					 vo.getTitle().put(nActivityPlan.get(i).getPubdate(), nActivityPlan.get(i).getPlanName());
				 }
				 
			 }
		 }
		 //获取志愿者基本信息
		return vo;
	}
}
