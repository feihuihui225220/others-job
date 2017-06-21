/**
 * 
 */
package com.anticw.aged.pool;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MServiceShowtype;
import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.OCountry;
import com.anticw.aged.bean.mongo.IntelligentMattress;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.service.admin.CategoryItemService;
import com.anticw.aged.service.community.country.OCountryService;
import com.anticw.aged.service.icare.combo.ComboService;
import com.anticw.aged.service.professional.SpecShowTypeService;
import com.anticw.aged.vo.icare.PageViewVO;
import com.anticw.aged.vo.professional.activity.NProgrqamVO1;

/**
 * 公共缓存数据
 * 
 * @author guoyongxiang Date: 2014-10-5
 */
@Service
public class SpringDataPool implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(SpringDataPool.class);

	/** ==========依赖注入========== */
	@Autowired
	private CategoryItemService cateItemService;
	@Autowired
	private OCountryService countryService;
	@Autowired
	private SpecShowTypeService specShowTypeService;
	@Autowired
	private ComboService comboService;
	/** ==========内存集合========== */
	private Map<Integer, OCategoryItem> ocategoryItemMap;
	private Map<Integer, LinkedHashMap<Integer, OCategoryItem>> ocategoryMap;
	private Map<Integer, OCountry> countryMap;
	private Map<Integer, Map<Integer, OCountry>> pCountryMap;
	private Map<Integer, MServiceShowtype> serviceShowtypeMap;

	private Map<Integer, NProgram> nProgramItemMap;
	private Map<Integer, Map<Integer, NProgram>> nProgramMap;

	private Map<Integer, PageViewVO> pagevosnpr;
	private Map<Integer, PageViewVO> pagevosmobo;

	/** 床垫解析依赖分析 **/
	private Map<String, IntelligentMattress> intelligentMattressMap;// 获取本次状态对应的初始时间
	private Map<String, Integer> breatheMap; // 呼吸异常是否发送短信
	private Map<String, Integer> heartbeat; // 心跳异常是否发送短信
	private Map<String, String> ambulation; // 离床时长过长异常是否发送短信
	private Map<String, Date> fallAsleep;// 入睡时间｛晚六点以后｝
	private Map<String, Date> ambulationTime;// 夜晚离床时间

	private Map<String, Date> toiletTime;

	private Map<String, Object[]> users;

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}

	private void init() {
		long start = System.currentTimeMillis();
		logger.info("SpringDataPool init..");
		ocategoryMap = new HashMap<Integer, LinkedHashMap<Integer, OCategoryItem>>();
		ocategoryItemMap = new HashMap<Integer, OCategoryItem>();
		countryMap = new HashMap<Integer, OCountry>();
		pCountryMap = new HashMap<Integer, Map<Integer, OCountry>>();
		serviceShowtypeMap = new HashMap<Integer, MServiceShowtype>();
		nProgramItemMap = new HashMap<Integer, NProgram>();
		nProgramMap = new HashMap<Integer, Map<Integer, NProgram>>();
		pagevosnpr = new HashMap<Integer, PageViewVO>();
		pagevosmobo = new HashMap<Integer, PageViewVO>();

		fallAsleep = new HashMap<String, Date>();
		ambulationTime = new HashMap<String, Date>();

		intelligentMattressMap = new HashMap<String, IntelligentMattress>();
		breatheMap = new HashMap<String, Integer>();
		heartbeat = new HashMap<String, Integer>();
		ambulation = new HashMap<String, String>();
		toiletTime = new HashMap<String, Date>();
		users = new HashMap<String, Object[]>();
		this.initOCategoryItemMap();
		this.initSpecShowTypeMap();
		this.initnProgramItemMap();
		logger.info("SpringDataPool end.. cost time:" + (System.currentTimeMillis() - start));
	}

	/** ===========初始化方法============ */
	/**
	 * 初始化分类项
	 * 
	 * @author guoyongxiang Date: 2014-10-6 上午10:29:10
	 */
	public void initOCategoryItemMap() {
		for (CategoryEnum cate : CategoryEnum.values()) {
			List<OCategoryItem> items = this.cateItemService.findListValue(cate.getIndex());
			Map<Integer, OCategoryItem> itemMap = new LinkedHashMap<Integer, OCategoryItem>();
			for (OCategoryItem item : items) {
				itemMap.put(item.getId(), item);
				// 将分类子项放到父级分类下
				ocategoryItemMap.put(item.getId(), item);
			}
			ocategoryMap.put(cate.getIndex(), (LinkedHashMap<Integer, OCategoryItem>) itemMap);
		}
	}

	/**
	 * 初始化专业服务展示类别
	 */
	public void initSpecShowTypeMap() {

		List<MServiceShowtype> list = specShowTypeService.list();

		for (MServiceShowtype item : list) {
			serviceShowtypeMap.put(item.getId(), item);
		}
	}

	public void initnProgramItemMap() {
		List<NProgram> np = comboService.ListNPrograms();
		for (NProgram n : np) {
			nProgramItemMap.put(n.getId(), n);
			comboService.ListNProgramc(n.getId());
			nProgramMap.put(n.getId(), comboService.ListNProgramc(n.getId()));
		}

	}

	/** ===========对外操作方法============ */

	/**
	 * 获取所有分类
	 * 
	 * @author guoyongxiang Date: 2014-10-6 上午11:05:46
	 * @param cateEnum
	 *            分类
	 * @return
	 */
	public Map<Integer, LinkedHashMap<Integer, OCategoryItem>> getOCategory() {
		return ocategoryMap;
	}

	/**
	 * 获取所有分类子项列表
	 * 
	 * @author guoyongxiang Date: 2014-10-6 上午11:45:52
	 * @return
	 */
	public Map<Integer, OCategoryItem> getOCategoryItem() {
		return ocategoryItemMap;
	}

	/**
	 * 根据分类子项ID获取子项信息
	 * 
	 * @author guoyongxiang Date: 2014-10-6 上午11:40:03
	 * @param id
	 * @return
	 */
	public OCategoryItem getOCategoryItem(Integer id) {
		OCategoryItem item = ocategoryItemMap.get(id);
		if (item == null) {
			List<OCategoryItem> items = this.cateItemService.findCategoryName(id);
			if (items != null && !items.isEmpty()) {
				// 更新内存
				item = items.get(0);
				this.saveOCategoryItem(item.getId(), item);
			}
		}
		return item;
	}

	/**
	 * 保存分类子项
	 * 
	 * @author guoyongxiang Date: 2014-10-6 上午11:15:55
	 * @param id
	 *            子项ID
	 * @param item
	 *            子项内容
	 */
	public void saveOCategoryItem(Integer id, OCategoryItem item) {
		ocategoryItemMap.put(id, item);
		ocategoryMap.get(item.getCategoryId()).put(id, item);
	}

	/**
	 * 根据PID返回城市列表
	 * 
	 * @author guoyongxiang Date: 2014-10-16 下午5:21:53
	 * @param pid
	 * @return
	 */
	public List<OCountry> getPCountryList(Integer pid) {
		List<OCountry> countrys = new ArrayList<OCountry>();
		Map<Integer, OCountry> map = this.getPCountryMap(pid);
		for (Integer key : map.keySet()) {
			countrys.add(map.get(key));
		}
		return countrys;
	}

	/**
	 * 根据PID获取country列表
	 * 
	 * @author guoyongxiang Date: 2014-10-16 下午4:45:27
	 * @param pid
	 * @return
	 */
	public Map<Integer, OCountry> getPCountryMap(Integer pid) {
		Map<Integer, OCountry> cmap = this.pCountryMap.get(pid);
		if (cmap != null) {
			return cmap;
		} else {
			List<OCountry> countrys = this.countryService.getCountrysByPid(pid);
			cmap = new HashMap<Integer, OCountry>();
			for (OCountry c : countrys) {
				countryMap.put(c.getId(), c);
				cmap.put(c.getId(), c);
			}
			if (!countrys.isEmpty()) {
				pCountryMap.put(countrys.get(0).getParentId(), cmap);
			}
		}
		return cmap;
	}

	/**
	 * 根据ID获取城市信息
	 * 
	 * @author guoyongxiang Date: 2014-10-16 下午4:45:23
	 * @param id
	 * @return
	 */
	public OCountry getCountry(Integer id) {
		OCountry country = this.countryMap.get(id);
		if (country != null) {
			return country;
		} else {
			// 查询城市信息,并更新单城市缓存
			country = this.countryService.getCountryById(id);
			countryMap.put(country.getId(), country);
			// 校验parentMap 节点列表存在则更新相应子项，不存在则不处理，等待拉取父列表时一并加入，以防父列表信息更新不全。
			Map<Integer, OCountry> cMap = pCountryMap.get(country.getParentId());
			if (cMap != null) {
				cMap.put(country.getId(), country);
			}
			return country;
		}
	}

	/**
	 * 更新城市信息
	 * 
	 * @author guoyongxiang Date: 2014-10-16 下午4:50:00
	 * @param country
	 */
	public void saveCountry(OCountry country) {
		Integer countryId = country.getId();
		if (country.getAvailable() == true) {
			this.countryMap.put(countryId, country);
			Map<Integer, OCountry> map = this.pCountryMap.get(country.getParentId());
			if (map != null) {
				map.put(countryId, country);
			}
		} else {
			this.countryMap.remove(countryId);
			this.pCountryMap.get(country.getParentId()).remove(countryId);
		}
	}

	/**
	 * 删除城市信息
	 * 
	 * @author guoyongxiang Date: 2014-10-16 下午5:44:29
	 * @param id
	 * @param pid
	 */
	public void removeCountry(Integer id, Integer pid) {
		this.countryMap.remove(id);
		Map<Integer, OCountry> map = this.pCountryMap.get(pid);
		if (map != null) {
			map.remove(pid);
		}
	}

	/**
	 * 获取专业服务分类
	 * 
	 * @param id
	 * @return
	 */
	public MServiceShowtype getSpecShowType(Integer id) {
		return serviceShowtypeMap.get(id);
	}

	/**
	 * 添加专业服务分类
	 * 
	 * @param item
	 */
	public void addSpecShowType(MServiceShowtype item) {
		serviceShowtypeMap.put(item.getId(), item);
	}

	public Map<Integer, NProgram> getnProgramItemMap() {
		return nProgramItemMap;
	}

	public Map<Integer, Map<Integer, NProgram>> getnProgramMap() {
		return nProgramMap;
	}

	/**
	 * 返回节目所有分类
	 * 
	 * @return
	 */
	public List<NProgram> getParent() {
		Map<Integer, NProgram> mp = this.nProgramItemMap;
		List<NProgram> np = new ArrayList<NProgram>();
		for (int key : mp.keySet()) {
			if (mp.get(key) != null) {
				np.add(mp.get(key));
			}
		}
		return np;
	}

	/**
	 * 返回节目分类下对应的节目
	 * 
	 * @param id
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public List<NProgrqamVO1> getNProgram(int id) throws IllegalAccessException, InvocationTargetException {
		Map<Integer, NProgram> mp = this.nProgramMap.get(id);
		List<NProgrqamVO1> np = new ArrayList<NProgrqamVO1>();
		for (int key : mp.keySet()) {
			NProgrqamVO1 vo = new NProgrqamVO1();
			BeanUtils.copyProperties(vo, mp.get(key));
			np.add(vo);
		}
		return np;
	}

	/**
	 * 节目修改
	 * 
	 * @param nProgram
	 */
	public void savenProgram(NProgram nProgram) {
		Integer nProgramId = nProgram.getId();
		if (nProgram.getAvaliable() == true && nProgram.getParentId() == 0) {
			this.nProgramItemMap.put(nProgramId, nProgram);
			NProgram map = this.nProgramItemMap.get(nProgram.getParentId());
			if (map != null) {
				nProgramItemMap.put(nProgram.getId(), nProgram);
			}
		} else if (nProgram.getAvaliable() == true && nProgram.getParentId() != 0) {
			if (this.nProgramMap.get(nProgram.getParentId()) == null) {
				Map<Integer, NProgram> map = new HashMap<Integer, NProgram>();
				map.put(nProgram.getId(), nProgram);
				this.nProgramMap.put(nProgram.getParentId(), map);
			} else {
				this.nProgramMap.get(nProgram.getParentId()).put(nProgram.getId(), nProgram);
			}

		} else if (nProgram.getAvaliable() == false) {
			this.nProgramMap.get(nProgram.getParentId()).remove(nProgram.getId());
		}
	}

	public int getnprPage(Integer nprId, String ip) {
		PageViewVO vo = this.pagevosnpr.get(nprId);
		if (vo == null) {
			vo = new PageViewVO();
			Set<String> ips = new HashSet<String>();
			ips.add(ip);
			vo.setIp(ips);
			pagevosnpr.put(nprId, vo);
			return 1;
		} else {
			Set<String> ips = vo.getIp();
			int stare = ips.size();
			ips.add(ip);
			int end = ips.size();
			pagevosnpr.put(nprId, vo);
			if (end - stare > 0) {
				return 1;
			}
			return 0;
		}
	}

	public int getcomboPage(Integer combId, String ip) {
		PageViewVO vo = this.pagevosmobo.get(combId);
		if (vo == null) {
			vo = new PageViewVO();
			Set<String> ips = new HashSet<String>();
			ips.add(ip);
			vo.setIp(ips);
			pagevosnpr.put(combId, vo);
			return 1;
		} else {
			Set<String> ips = vo.getIp();
			int stare = ips.size();
			ips.add(ip);
			int end = ips.size();
			pagevosnpr.put(combId, vo);
			if (end - stare > 0) {
				return 1;
			}
			return 0;
		}
	}

	public void remove() {
		pagevosmobo.clear();
		pagevosnpr.clear();
	}

	/**
	 * 存储本床垫本状态第一次数据
	 * 
	 * @param in
	 */
	public void saveIntelligentMattressMap(IntelligentMattress in) {
		this.intelligentMattressMap.put(in.getSn(), in);
	}

	/**
	 * 呼吸异常 是否已报警
	 * 
	 * @param sn
	 */
	public void saveBreatheMap(String sn) {
		this.breatheMap.put(sn, 1);
	}

	/**
	 * 心跳异常 是否已报警
	 * 
	 * @param sn
	 */
	public void saveHeartbeat(String sn) {
		this.heartbeat.put(sn, 1);
	}

	/**
	 * 
	 * 离床时间是否过长 已报警
	 * 
	 * @param sn
	 */
	public void saveAmbulation(String sn, String data) {
		this.ambulation.put(sn, data);
	}

	/**
	 * 返回参数
	 * 
	 * @param sn
	 * @return
	 */
	public IntelligentMattress getIntelligentMattress(String sn) {
		return this.intelligentMattressMap.get(sn);
	}

	/**
	 * 是否已报警 呼吸
	 * 
	 * @param sn
	 * @return
	 */
	public Integer getBreatheMap(String sn) {
		return this.breatheMap.get(sn);
	}

	/**
	 * 删除
	 * 
	 * @param sn
	 */
	public void removeBreatheMap(String sn) {
		if (this.breatheMap.get(sn) != null) {
			this.breatheMap.remove(sn);
		}
	}

	/**
	 * 是否已报警 心跳
	 * 
	 * @param sn
	 * @return
	 */
	public Integer getHeartbeat(String sn) {
		return this.heartbeat.get(sn);
	}

	/**
	 * 删除
	 * 
	 * @param sn
	 */
	public void removeHeartbeat(String sn) {
		if (this.heartbeat.get(sn) != null) {
			this.heartbeat.remove(sn);
		}
	}

	/**
	 * 是否已报警 离床时长
	 * 
	 * @param sn
	 * @return
	 */
	public String getAmbulation(String sn) {
		return this.ambulation.get(sn);
	}

	public void removeAmbulation(String sn) {
		if (this.heartbeat.get(sn) != null) {
			this.heartbeat.remove(sn);
		}
	}

	/**
	 * 添加上创时间
	 * 
	 * @param sn
	 * @param date
	 */
	public void saveFallAsleep(String sn, Date date) {
		this.fallAsleep.put(sn, date);
	}

	/**
	 * 添加离床时间
	 * 
	 * @param sn
	 * @param date
	 */
	public void saveAmbulationTime(String sn, Date date) {
		this.ambulationTime.put(sn, date);
	}

	/**
	 * 获取上床时间
	 * 
	 * @param sn
	 * @return
	 */
	public Date getFallAsleep(String sn) {
		return fallAsleep.get(sn);
	}

	/**
	 * 获取离床时间
	 * 
	 * @param sn
	 * @return
	 */
	public Date getAmbulationTime(String sn) {
		return ambulationTime.get(sn);
	}

	/**
	 * 删除上床时间
	 * 
	 * @param sn
	 */
	public void removeFallAsleep(String sn) {
		if (this.getFallAsleep(sn) != null) {
			fallAsleep.remove(sn);
		}
	}

	/**
	 * 删除离床时间
	 * 
	 * @param sn
	 */
	public void removeAmbulationTime(String sn) {
		if (this.getAmbulationTime(sn) != null) {
			ambulationTime.remove(sn);
		}
	}

	public void savetoiletTime(String sn, Date date) {
		this.toiletTime.put(sn, date);
	}

	/**
	 * 获取如厕时间
	 * 
	 * @param sn
	 * @return
	 */
	public Date gettoiletTime(String sn) {
		return fallAsleep.get(sn);
	}

	public void removetoiletTime(String sn) {
		if (this.gettoiletTime(sn) != null) {
			toiletTime.remove(sn);
		}
	}

	public void saveUsers(String sn, Object[] user) {
		this.users.put(sn, user);
	}

	/**
	 * 获取床垫上次更新的数据
	 * 
	 * @param sn
	 * @return
	 */
	public Object[] getUsers(String sn) {
		return users.get(sn);
	}
}
