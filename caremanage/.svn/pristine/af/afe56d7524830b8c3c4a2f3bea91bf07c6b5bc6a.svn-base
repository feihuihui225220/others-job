package com.anticw.aged.service.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.ZCombo;
import com.anticw.aged.bean.ZSubscriber;
import com.anticw.aged.dao.icare.combo.ZSubscriberDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.professional.activity.NProgramService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.vo.professional.activity.NProgramVO;

@Service("zSubscriberService")
public class ZSubscriberService {

	@Autowired
	private ZSubscriberDao zSubscriberDao;

	@Autowired
	private NProgramService nProgramService;
	
	@Autowired
	private ComboService comboService;

	/**
	 * 定时查看用户课程使用情况
	 */
	public void update() {
		List<ZSubscriber> zs = zSubscriberDao.getList();
		Date d = new Date();
		for (ZSubscriber z : zs) {
			Date end = DateUtil.addDays(z.getCreateAt(),
					(z.getLearnFate() * 2 + z.getRestFate()) - 1);// 下一天开始计算
																	// 获取最终上课时间
			if (d.getTime() <= end.getTime()) {
				z.setAvailabe(false);
				zSubscriberDao.update(z);
			}
		}
	}
	public List<NProgramVO> getVipList1(String ids) {//
		
		List<NProgram> npr = nProgramService.ListNPrograms_(ids);
		List<NProgramVO> vos=new ArrayList<NProgramVO>();
		NProgramVO vo;
		for(NProgram n:npr){
			vo=new NProgramVO();
			if(n.getThumbs()!=null&&n.getThumbs()!=""&&!n.getThumbs().split(",")[0].equals("")){
				n.setThumbs(n.getThumbs().split(",").length+"");
			}else{
				n.setThumbs("0");
			}
			try {
				BeanUtils.copyProperties(vo, n);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vos.add(vo);
		}
		return vos;
	}
	/**
	 * 获取免费订阅的的课程
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Set<NProgramVO>> getList(Long userId) {
		List<ZSubscriber> zs = zSubscriberDao.getList(userId);
		Map<String, Set<NProgramVO>> map = new HashMap<String, Set<NProgramVO>>();
		Date d = new Date();
		for (ZSubscriber z : zs) {
			Date end = DateUtil.addDays(z.getCreateAt(),
					(z.getLearnFate() * 2 + z.getRestFate()) - 1);// 下一天开始计算
																	// 获取最终上课时间
			int length = DateUtil.getTotalDay(d, end);// 根据当前时间和最后一天时间 获取时间之差
														// 从下一天开始计算
			if (length <= 0) {
				z.setAvailabe(false);
				zSubscriberDao.update(z);
				continue;
			}
			for (int i = 0; i < length + 1; i++) {
				String datye = DateUtil.getDayFormatDate(DateUtil
						.minusDays(end, i));
				 
				List<NProgramVO> npr=getVipList1(z.getProgramIds());
				
				
				if (map.get(datye) != null) {
					map.get(datye).addAll(npr);
				} else {
					Set<NProgramVO> zs1 = new HashSet<NProgramVO>();
					zs1.addAll(npr);
					map.put(datye, zs1);
				}
				if ((i + 1) % z.getLearnFate() == 0) { // 上课天书
					i = i + z.getRestFate(); // 休息天数
				}
			}

		}

		return map;
	}
	/**
	 * 获取套餐中天数
	 * @param userId
	 * @return
	 */
	public Map<String, Set<NProgramVO>> getList(int id) {
		ZCombo zb=comboService.getById(id);
		List<NProgramVO> npr=getVipList1(zb.getNprogramIds());
		if(npr.size()==0){
			return null;
		}
		Map<String, Set<NProgramVO>> map = new HashMap<String, Set<NProgramVO>>();
		Date end = DateUtil.addDays(new Date(),14);// 下一天开始计算
		for (int i = 0; i < 15; i++) {
			String datye = DateUtil.getDayFormatDate(DateUtil
					.minusDays(end, i));
			if (map.get(datye) != null) {
				map.get(datye).addAll(npr);
			} else {
				Set<NProgramVO> zs1 = new HashSet<NProgramVO>();
				zs1.addAll(npr);
				map.put(datye, zs1);
			}
		}
		return map;
	}
	
	
	/**
	 * 添加一条记录
	 */
	public void save(int comboId,Long userId){
		ZSubscriber zs=new ZSubscriber();
		ZCombo zb=comboService.getById(comboId);
		zs.setLearnFate(zb.getAttendClass().intValue());
		zs.setRestFate(zb.getFinishClass().intValue());
		zs.setAvailabe(true);
		zs.setUserId(userId);
		zs.setProgramIds(zb.getNprogramIds());
		zs.setWatch(0);
		zs.setComboId(comboId);
		zs.setCreateAt(new Date());
		zSubscriberDao.save(zs);
	}

	public void update(Long userId){
		List<ZSubscriber> zs=zSubscriberDao.getList(userId);
		for(ZSubscriber z:zs){
			z.setAvailabe(false);
			zSubscriberDao.update(z);
		}
	}
	
	public List<ZSubscriber> getZSubscribers(Long userId){
		 return zSubscriberDao.getList(userId);
	}
 	
	public  ZSubscriber getZSubscriber(Long userId,Integer comboId){
		return zSubscriberDao.getZSubscriber(userId,comboId);
	}
	
	public void update(int Id){
		ZSubscriber z=zSubscriberDao.get(Id);
		z.setAvailabe(false);
		zSubscriberDao.update(z);
	}
	/*
	 * public Set<String> getList(int args) { Set<String> date=new
	 * HashSet<String>(); Date
	 * end=DateUtil.addDays(DateUtil.parseStrToDate("2016-12-18"),
	 * 9-1);//下一天开始计算 获取最终上课时间 int length=DateUtil.getTotalDay(new Date(), end
	 * );//根据当前时间和最后一天时间 获取时间之差 从下一天开始计算 for(int i=0;i<length+1;i++){ String
	 * datye=DateUtil.getCurrentFormatDate(DateUtil.minusDays(end, i));
	 * date.add(datye); System.out.println(datye+ i); if((i+1)%3==0){ //上课天书
	 * i=i+1; //休息天数 } } return date; }
	 */
}
