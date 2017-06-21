package com.anticw.aged.service.professional.data.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.ZSleep;
import com.anticw.aged.bean.mongo.IntelligentMattress;
import com.anticw.aged.dao.data.IntelligentMattressDao;
import com.anticw.aged.dao.professional.data.base.ZSleepDao;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.utils.DateUtil;
@Service
@Component
public class IntelligentMattressService extends AbstractDataService<IntelligentMattress> {

	@Autowired
	private IntelligentMattressDao intelligentMattressDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ZSleepDao zSleepDao;
	
	private static String deviceBindId;
	private static String userId;
	private static String sex;
	
	public Class<IntelligentMattress> getEntityClass() {
		return IntelligentMattress.class;
	}

	protected String getCollectionName() {
		return Constants.COLLECTION_ZHINENGCHUANGDIAN;
	}
	@Autowired
	private IntelligentMattressDao mattressDao;
	
	@SuppressWarnings("static-access")
	public void see(){
		List<Object[]>  oders=orderDao.getDeviceBindId();
		System.out.println(oders.size());
		  
		for(Object[] m:oders){
			this.deviceBindId=m[0].toString();
			this.userId=m[1].toString();
			this.sex=m[2].toString();
			run();
		}
	}

	
	@SuppressWarnings("unused")
	public void run() {
		List<IntelligentMattress>  list=intelligentMattressDao.getIntelligentMattress(deviceBindId);
		if(list.size()<0){
			return;
		}
		Date start=null;
		Map<List<Date>,String> dates=null;
		List<Map<List<Date>,String>> list_=new ArrayList<Map<List<Date>,String>>();//
		List<Date> dates_=null;
		 
		int i=1;
		float heartbeat=0;//心跳
		float breathe=0; //呼吸
		int suspend=0;//呼吸暂停次数
		Date movStart=null;
		int movCount=0;//体动次数
		for(IntelligentMattress in:list){
			if(!in.getState().equals("off")){
				if(start==null){
					start=in.getUploadTime();
				}
				heartbeat+=in.getHeartbeat();
				breathe+=in.getBreath();
				if(in.getHeartbeat()==0){
					suspend+=1;
				}
			i++;
			}else if(in.getState().equals("off")&&start!=null){
				dates_=new ArrayList<Date>();
				dates=new HashMap<List<Date>, String>();
				dates_.add(start);dates_.add(in.getUploadTime());
				dates.put(dates_,in.getDeviceId());
				list_.add(dates);
				start=null;
			}
			if(in.getState().equals("mov")){
				if(movStart==null){
					movStart=in.getUploadTime();
				}	
				 
			}else if(!in.getState().equals("mov")&&movStart!=null){
				movCount+=1;
			}
			
		}
		heartbeat=heartbeat/i;
		breathe=breathe/i;
		Date stare_s=null;
		Date stare_=null;
		Date end=null;
		Date end_=null;
		Date end_s=null;
		String deviceId=null;
		List<Float> times=new ArrayList<Float>();//睡眠时长
		
		Float time=0F;
		Float time_=0F;//睡眠时长
		//睡眠时长 睡眠质量   离床次数 
		for(int m=0;m<list_.size();m++){
			Map<List<Date>,String> map=list_.get(m);
			stare_=map.keySet().iterator().next().get(0);
			if(stare_s==null){
				stare_s=map.keySet().iterator().next().get(0);
			}
			end=map.keySet().iterator().next().get(1);
			if(m!=list_.size()-1){
				end_=list_.get(m+1).keySet().iterator().next().get(0);
			}
			if(end_!=null&&end_.getTime()-end.getTime()<3000*60){
				
				time+=(end.getTime()-stare_.getTime())/1000/60/60;
			}else if(end_==null){
				end_s=end;
				time+=(end.getTime()-stare_.getTime())/1000/60/60;
			}else if(end_.getTime()-end.getTime()>=3000*60){
				if(time>1){times.add(time);time_+=time;}
				time=0F;
			}
			if(m+1==list_.size()&&time>1){
				time_+=time;
				times.add(time);
			}
			deviceId=map.get(map.keySet().iterator().next());
		}
 
		ZSleep  zs=new ZSleep();
		zs.setApnea(suspend);//呼吸暂停
		//zs.setApneaAnalysis(apneaAnalysis);//呼吸暂停分析
		zs.setAvailable(true);//是否有效
		zs.setBedtime(stare_s);//上床时间
		zs.setBreathingRate((int)breathe);//呼吸频率
		if(breathe<16){
			zs.setBreathingRateAnalysis("偏少");//呼吸频率分析
		}else if(breathe>20){
			zs.setBreathingRateAnalysis("偏多");//呼吸频率分析
		}else{
			zs.setBreathingRateAnalysis("正常");//呼吸频率分析
		}
		zs.setContent("");//综合分析
		zs.setCreateTime(new Date());//数据分析时间
		zs.setCreateUser("定时");//数据创建者
		zs.setDataTime(new Date());//数据日期 昨晚
		zs.setDuration(time_.toString());//睡眠时长
		if(time_<7){
			zs.setDurationAnalysis("过短");//睡眠时长分析
		}else if(time_>8){
			zs.setDurationAnalysis("过长");//睡眠时长分析
		}else{
			zs.setDurationAnalysis("正常");//睡眠时长分析
		}
		zs.setHeartRate((int)heartbeat);//心跳频率
		if(heartbeat<50&&sex=="0"|heartbeat<60&&sex=="1"){
			zs.setHeartRateAnalysis("偏少");//心跳频率率分析
		}else if(heartbeat>70){
			zs.setHeartRateAnalysis("偏多");//心跳频率分析
		}else{
			zs.setHeartRateAnalysis("正常");//心跳频率分析
		}
		String[] qut=getIntelligentMattress( deviceBindId);
		 zs.setOutBed(Integer.parseInt(qut[0]));//离床次数
		zs.setOutBedAnalysis(qut[1]);//离床次数分析
		zs.setQuality(time_.toString());//睡眠质量
		/*zs.setQualityAnalysis(qualityAnalysis);//睡眠质量分析
		 *此处有问题  方案未提供****************************************
		 */
		if(time_<7){
			zs.setQualityAnalysis("过短");//睡眠时长分析
		}else if(time_>8){
			zs.setDurationAnalysis("过长");//睡眠时长分析
		}else{
			zs.setQualityAnalysis("正常");//睡眠时长分析
		}
 		zs.setTurnFrequency(movCount);//翻身次数
		if(movCount<200){
			zs.setTurnFrequencyAnlysis("正常");//翻身次数分析
		}else{
			zs.setTurnFrequencyAnlysis("偏多");//翻身次数分析
		}
		zs.setUserId(Long.parseLong(userId));//用户id
		zs.setWakeUpTime(end_s);//起床时间
		System.out.println("=================================");
		zSleepDao.save(zs);
		
	}
	public String[] getIntelligentMattress(String snId){
		try {
			//晚上10点到第二天早上5点的所有数据集合
			List<IntelligentMattress> list= mattressDao.getIntelligentMattresswxs(snId);
			//记录离床次数
			Integer count=0;
			//是否警报
			Integer isTrue=0;
			//生命String数组，存储离床次数，状态和是否是警报(0,1)
			String[] strs = new String[3];
			for (int i = 0; i < list.size(); i++) {
				//获取离床次数
				int newId=i+1;
				String stat=list.get(i).getState();
				Date statTime=list.get(i).getUploadTime();
				if(newId<list.size()){
					Date endTime=list.get(newId).getUploadTime();
					//计算两条信息的时间差
					long cha=DateUtil.getDatePoor(endTime,statTime);
					String stats=list.get(newId).getState();
					if(cha>30){
						isTrue=1;
						System.out.println("警报！！！！！！！！！！");
					}else{//在床 			离床
						if(!stat.equals(stats)&&!stat.equals("off")&&stats.equals("off")){
							count++;
							continue;
						}
					}
					
				}else{
					String perv=list.get(i-1).getState();
					if(!stat.equals(perv)&&!stat.equals("off")){
						count++;
						break;
					}
				}
			}
			String type = null;
			if(count <= 1){
				type = "正常";
			}else{
				type = "频繁";
			}
			strs[0]=count.toString();
			strs[1]=type;
			strs[2]=isTrue.toString();
			return strs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<IntelligentMattress> getIntelligentMattressdeviceId(String deviceId) {
		return intelligentMattressDao.getIntelligentMattress(deviceId);
	}
}
