package com.anticw.aged.service.icare.combo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.ZCombo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.icare.combo.ZComboDao;
import com.anticw.aged.dao.professional.activity.NProgramDao;
import com.anticw.aged.dao.utils.BeanUtils;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.icare.ZComboVO;
import com.anticw.aged.vo.icare.ZComboVO1;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.NProgramVO;

@Service
public class ComboService {

	@Autowired
	private ZComboDao zComboDao;

	@Autowired
	private NProgramDao nProgramDao;
	
	 
	/**
	 * 获取套餐中的课程
	 * 
	 * @param ids
	 * @return
	 */
	public List<NProgram> getVipList(String ids) {
		return nProgramDao.getVipList(ids);
	}
	 
	public List<NProgramVO> getVipList1(String ids) {
		List<NProgram> list= nProgramDao.getVipList(ids);
		List<NProgramVO> vos=new ArrayList<NProgramVO>();
		NProgramVO vo;
		for(NProgram n:list){
			vo=new NProgramVO();
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

	
	public List<NProgramVO> getVipList2(String ids) {
		List<NProgram> list= nProgramDao.getVipList(ids);
		List<NProgramVO> vos=new ArrayList<NProgramVO>();
		NProgramVO vo;
		for(NProgram n:list){
			if(n.getThumbs()!=null&&n.getThumbs()!=""&&!n.getThumbs().split(",")[0].equals("")){
				n.setThumbs(n.getThumbs().split(",").length+"");
			}else{
				n.setThumbs("0");
			}
			vo=new NProgramVO();
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
	 * 根据Id获取套餐
	 * 
	 * @param id
	 * @return
	 */
	public ZCombo getById(int id) {
		return zComboDao.get(id);
	}

	/**
	 * 套餐展示内容
	 * 
	 * @param id
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ZComboVO getVO(int id) throws IllegalAccessException,
			InvocationTargetException {
		ZCombo z = getById(id);
		ZComboVO vo = new ZComboVO();
		BeanUtils.copyProperties(vo, z);
		/*List<NProgrqamVO1> np = new ArrayList<NProgrqamVO1>();
		for (int key : mp.keySet()) {
			NProgrqamVO1 vo = new NProgrqamVO1();
			BeanUtils.copyProperties(vo, mp.get(key));
			np.add(vo);
		}*/
		if (z.getNprogramIds() != null && z.getNprogramIds() != "") {
			vo.setnProgram(getVipList(z.getNprogramIds()));
			
		}
		return vo;
	}
	public ZComboVO1 getVO1(int id) throws IllegalAccessException,
	InvocationTargetException {
		ZCombo z = getById(id);
		ZComboVO1 vo = new ZComboVO1();
		BeanUtils.copyProperties(vo, z);
		/*List<NProgrqamVO1> np = new ArrayList<NProgrqamVO1>();
		for (int key : mp.keySet()) {
			NProgrqamVO1 vo = new NProgrqamVO1();
			BeanUtils.copyProperties(vo, mp.get(key));
			np.add(vo);
		}*/
		if (z.getNprogramIds() != null && z.getNprogramIds() != "") {
			vo.setnProgram(getVipList1(z.getNprogramIds()));
			
		}
		return vo;
	}

	/**
	 * 修改套餐
	 * 
	 * @param z
	 * @param session
	 */
	public void update(ZCombo z, HttpSession session) {
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		ZCombo zc = getById(z.getComboId());
		zc.setPrice(z.getPrice());
		zc.setComboName(z.getComboName());
		zc.setEffect(z.getEffect());
		zc.setFinishClass(z.getFinishClass());
		zc.setForAge(z.getForAge());
		zc.setNprogramIds(z.getNprogramIds());
		zc.setOriginalPrice(z.getOriginalPrice());
		zc.setChangeAt(new Date());
		zc.setChangeBy(userVO.getName());
		if(z.getImgUrl()!=null&&z.getImgUrl()!=""){
			zc.setImgUrl(z.getImgUrl());
		}
		zc.setVersion((short) (zc.getVersion() + 1));
		zComboDao.update(zc);
	}

	/**
	 * 逻辑删除
	 * 
	 * @param id
	 */
	public void remove(int id) {
		ZCombo z = zComboDao.get(id);
		zComboDao.remover(z);
	}

	/**
	 * 分页展示
	 * 
	 * @param pageVO
	 * @param zName
	 * @param dateVO
	 * @return
	 */
	public Page<ZCombo> getPage(PageParamVO pageVO, String zName,
			DateParamVO dateVO) {
		return zComboDao.getPage(pageVO, zName, dateVO);
	}

	/**
	 * 查询节目分类
	 * 
	 * @param username
	 * @return
	 */
	public List<NProgram> ListNPrograms() {
		List<NProgram> prantnp = nProgramDao.ListNPrograms();
		/*
		 * Map<String,List<NProgram>> map=new HashMap<String, List<NProgram>>();
		 * for(NProgram n:prantnp){ map.put(n.getProgramName(),
		 * nProgramDao.ListNPrograms(n.getId())); }
		 */
		return prantnp;
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

	/**
	 * 所有节目分类下所有节目
	 * 
	 * @param id
	 * @return
	 */
	public Map<Integer, NProgram> ListNProgramc(int id) {
		Map<Integer, NProgram> map = new HashMap<Integer, NProgram>();
		List<NProgram> np = nProgramDao.ListNPrograms(id);
		for (NProgram n : np) {
			map.put(n.getId(), n);
		}
		return map;
	}

	/**
	 * 新增一个套餐，默认为未上架
	 * 
	 * @param z
	 * @param session
	 */
	public void add(ZCombo z, HttpSession session) {
		UserVO userVO = (UserVO) session
				.getAttribute(PropertyValueConstants.SESSION_USER);
		Date d = new Date();
		z.setPutaway(false);
		z.setAvailable(true);
		z.setChangeAt(d);
		z.setChangeBy(userVO.getName());
		z.setCreateBy(userVO.getName());
		z.setCreateAt(d);
		z.setVersion((short) 0);
		z.setPageView(0);
		nProgramDao.save(z);

	}

	/**
	 * 获取所有的节目｛套餐中｝
	 * 
	 * @param ids
	 * @return
	 */
	public List<NProgram> ListNPrograms(String ids) {
		return nProgramDao.getVipList(ids);
	}

	/**
	 * 上架状态
	 * 
	 * @param id
	 */
	public void getPutaway(int id) {
		ZCombo zc = getById(id);
		if (zc.getPutaway()!=null&&zc.getPutaway()==false) {
			zc.setPutaway(true);
		} else {
			zc.setPutaway(false);
		}
		nProgramDao.update(zc);
	}
	
	public List<ZCombo>  getZComboAll(){
		return  zComboDao.getZComboAll();
	}
	
	/**
	 * 获取套餐
	 * @param page
	 * @return
	 */
	public List<ZCombo>  getZComboAll(Integer page){
		List<ZCombo> zb=zComboDao.getZComboAll();
		List<ZCombo> zs=new ArrayList<ZCombo>();
		for(ZCombo z:zb){
			if(z.getNprogramIds()!=null){
				List<NProgram>  n=nProgramDao.ListNPrograms_(z.getNprogramIds());
				if(n.size()!=0){
					zs.add(z);
				}
			}
		}
		if(page==null){
			page=1;
		}
		int end=page*5;
		if(end>zs.size()){
			end=zs.size();
		}
		return zs.subList((page-1)*5, end);
	}
	public List<NProgramVO>  getNProgramAll(Integer id){
		ZCombo zb=zComboDao.get(id);
		return	getVipList2(zb.getNprogramIds());
	}
	
	
	/*@Autowired
	private AssessConclusionDao assessConclusionDao;
	public void updateAssess(Integer comboId,AssessVO vo1,Integer assessCluId){
		//套餐id  量表结论Id    z_assess
		AssessConclusion z=	assessConclusionDao.getZAssess_(vo1.getItemId());
		z.setAssessId(assessCluId);
		z.setCourse(comboId.toString());
		zAssessDao.update(z);
	}*/
	

	/**
	 * 判断数组中是否包含某个元素
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
		 return
				 ArrayUtils.contains(arr,targetValue);
	}
	
	public int update(int id){
		ZCombo n=zComboDao.get(id);
		if(n.getPageView()!=null){
			n.setPageView(n.getPageView()+1);
		}else{
			n.setPageView(1);
		}
		zComboDao.update(n);
		return n.getPageView();
	}
}
