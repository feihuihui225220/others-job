/**
 * 
 */
package com.anticw.aged.service.community.user;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anticw.aged.bean.OCategoryItem;
import com.anticw.aged.bean.RContact;
import com.anticw.aged.bean.RNuser;
import com.anticw.aged.bean.RSpecia;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.utils.CategoryEnum;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.bean.utils.UserConstants;
import com.anticw.aged.dao.user.RContactDao;
import com.anticw.aged.dao.user.RNuserDao;
import com.anticw.aged.dao.user.RSpeciaDao;
import com.anticw.aged.dao.user.RUserDao;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.permission.PermissionService;
import com.anticw.aged.utils.DateUtil;
import com.anticw.aged.utils.ExportExcelUtil;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.common.DateParamVO;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.community.RUserSearchVO;
import com.anticw.aged.vo.director.HGroupUserVO;
import com.anticw.aged.vo.professional.assess.ConclusionScreenVO;
import com.anticw.aged.vo.user.AssessUserVO;
import com.anticw.aged.vo.user.CountColumnEnum;
import com.anticw.aged.vo.user.CountParamItemVO;
import com.anticw.aged.vo.user.CountParamVO;
import com.anticw.aged.vo.user.CountUserItemVO;
import com.anticw.aged.vo.user.CountUserVO;
import com.anticw.aged.vo.user.RegisterVO;

/**
 * 用户业务层
 * 
 * @author guoyongxiang Date: 2014-9-21
 */
@Service("ruserService")
public class RUserService {

	private static Logger logger = LoggerFactory.getLogger(RUserService.class);
	@Autowired
	private RUserDao userDao;
	@Autowired
	private RSpeciaDao speciaDao;
	@Autowired
	private RContactDao contactDao;

	@Autowired
	private SpringDataPool springDataPool;

	@Autowired
	private RNuserDao rNuserDao;

	public void saveRNuser(RNuser rNuser) {
		rNuserDao.save(rNuser);
	}

	/**
	 * 用户登录(老年人)
	 * 
	 * @author guoyongxiang Date: 2014-10-2 下午3:58:58
	 * @param name
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public RUser login(String name, String password) throws BusinessException {
		RUser user = this.userDao.findByIdCardNo(name);
		if (this.userDao.findByIdCardNo(name) == null) {
			user = userDao.findByIdmobilePhone(name);
		}
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pass = md5.encodePassword(password, name);
		if (user != null) {
			if (!pass.equals(user.getPassword())) {
				logger.warn("用户密码不匹配: idCardNo {} ,password {}", name, password);
				throw new BusinessException(ExceptionCode.USER_PASSWORD_ERROR);
			}
		} else {
			logger.warn("用户不存在: idCardNo {}", name);
			throw new BusinessException(ExceptionCode.USER_ID_CARD_NO_INVALID);
		}
		return user;
	}

	/**
	 * 用户注册(校验用户信息,设置密码)
	 * 
	 * @author guoyongxiang Date: 2014-10-1 下午4:41:38
	 * @param regVO
	 * @throws BusinessException
	 */
	public void register(RegisterVO regVO) throws BusinessException {
		// RUser user = this.userDao.findByIdCardNo(regVO.getIdCardNo());
		regVO.setGender(1);
		RUser user = new RUser();
		user.setPassword(regVO.getPassword());
		user.setMobilePhone(regVO.getMobilePhone());
		user.setName(regVO.getName());
		user.setChangedAt(new Date());
		user.setChangedBy(regVO.getName());
		user.setActive(UserConstants.USER_STATUS_ACTIVE);
		user.setAvailable(true);
		user.setGender(regVO.getGender());
		user.setCommunityId(regVO.getCommunityId());
		user.setVersion((short) 0);
		user.setActive(1);
		// 1.校验用户信息
		// boolean compare = regVO.compare(user);
		// if(!compare){
		// logger.warn("用户信息不匹配: voIdCardNo {}, dbIdCardNo {}",
		// regVO.getIdCardNo(), user.getIdCardNo());
		// throw new BusinessException(ExceptionCode.USER_INFO_DIFF);
		// }else{
		// 2.设置用户密码
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pass = md5.encodePassword(user.getPassword(), user.getMobilePhone());
		user.setPassword(pass);
		this.userDao.save(user);

	}

	public long simplenessUser(RUser user) {
		Date date = new Date();
		user.setActive(UserConstants.USER_STATUS_ACTIVE);
		user.setAvailable(true);
		user.setVersion((short) 0);
		user.setActive(0);
		user.setBirthday(date);
		user.setChangedAt(date);
		user.setCreatedAt(date);
		String mobilePhone = user.getMobilePhone();
		int lastCount = UserConstants.USER_DEF_PASS_LAST_COUNT;
		lastCount = mobilePhone.length() > lastCount ? lastCount : mobilePhone.length();
		String last = mobilePhone.substring(mobilePhone.length() - lastCount, mobilePhone.length());
		String password = new Md5PasswordEncoder().encodePassword(last, mobilePhone);
		user.setPassword(password);
		long uId = this.userDao.save(user);
		return uId;
	}

	/**
	 * 根据条件查询列表
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午5:53:41
	 * @param pageNo
	 * @param pageSize
	 * @param userVO
	 * @return
	 */
	public Page<RUser> list(int pageNo, int pageSize, RUserSearchVO userVO, String venderName, String communityId,
			int active) {
		String hql = "";
		if (active != 0) {
			if (active != -1) {
				hql = " and createdBy in(" + venderName + ") and active=" + active;
			} else {
				hql = " and createdBy in(" + venderName + ") ";
			}
		} else {
			hql = "and active=" + active;
		}
		if (communityId != "-1") {
			if (communityId.length() < 6) {
				hql = " and communityId=" + communityId;
			}
		}

		if (userVO != null) {
			// 参数校验
			hql += userVO.verify();
		}
		return this.userDao.findByPage(pageNo, pageSize, hql);
	}

	/**
	 * 根据条件查询列表
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午5:53:41
	 * @param pageNo
	 * @param pageSize
	 * @param userVO
	 * @return
	 */
	public List<RUser> list(RUserSearchVO userVO, String communityId) {
		String hql = "";
		if (communityId.indexOf(",") >= 0) {
			hql = " and communityId in(" + communityId + ")";
		} else {
			hql = " and communityId=" + communityId;
		}
		if (userVO != null) {
			// 参数校验
			hql += userVO.verify();
		}
		return this.userDao.list(hql);
	}

	/**
	 * 根据ID查找信息
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午6:36:18
	 * @param id
	 * @return
	 */
	public RUser findById(Long id) {
		if (userDao.findById(id) != null) {
			RUser user = this.userDao.findById(id);
			/*
			 * if(user.getBuildingId()!=null){ OBuilding building =
			 * buildingService.getById(user.getBuildingId());
			 * user.setBuilding(building); }
			 */
			return user;
		} else {
			return null;
		}
	}

	/**
	 * 根据身份证号查找
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午6:36:18
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public RUser findByIdCardNo(String idCardNo) throws BusinessException {
		RUser user = this.userDao.findByIdCardNo(idCardNo);
		/*
		 * if(user.getBuildingId()!=null){ OBuilding building =
		 * buildingService.getById(user.getBuildingId());
		 * user.setBuilding(building); }
		 */
		return user;
	}

	public RUser findBymobilePhone(String mobilePhone) throws BusinessException {
		return this.userDao.findBymobilePhone(mobilePhone);
	}

	/**
	 * 根据电话查找
	 * 
	 * @author L 2014年11月11日20:57:36
	 * @param number
	 * @return
	 * @throws BusinessException
	 */
	public List<RUser> findByNumber(String number) throws BusinessException {
		return this.userDao.findByIdNumber(number);
	}

	/**
	 * 根据姓名或者身份证号码查找
	 * 
	 * @param idCardNo
	 * @return
	 * @throws BusinessException
	 */
	public List<RUser> findByIdAndName(String idCardNo) throws BusinessException {
		List<RUser> users = userDao.findByIdAndName(idCardNo);
		return users;
	}

	/**
	 * 更新
	 * 
	 * @author guoyongxiang Date: 2014-10-3 下午11:35:36
	 * @param user
	 * @param opUser
	 * @param encryptPass
	 *            是否需要对密码进行加密处理
	 */
	public void update(RUser user, String opUser, boolean encryptPass) {
		if (encryptPass) {
			if (user.getPassword() != null && !"".equals(user.getPassword())) {
				user.setPassword(PermissionService.encryptPass(user.getPassword(), user.getName()));
			}
		}
		user.setChangedAt(new Date());
		user.setChangedBy(opUser);
		this.userDao.saveOrUpdate(user);
	}

	public void update(RUser user) {
		user.setChangedAt(new Date());
		this.userDao.update_shenhe(user);
	}

	public void update_shenhe(RUser user) {
		this.userDao.update_shenhe(user);
	}

	@Autowired
	private FileHandle fileHandle;

	@Autowired
	private RContactDao rContactDao;

	/**
	 * 保存用户信息
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午6:36:08
	 * @param user
	 * @param communityId
	 * @param opUser
	 * @param files
	 */
	public long saveUser(RUser user, String communityId, String opUser, MultipartFile file, String rCName,
			String rCPhone) {
		RUser dbUser = null;
		long id = 0;
		user.setCommunityId(Integer.valueOf(communityId));
		// 处理文件上传
		if (file != null) {
			String albumName;
			try {
				albumName = fileHandle.uploadPic(file);
				user.setHead(albumName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 保存用户数据
		if (user.getId() == null || user.getId().equals(0)) {
			try {
				dbUser = new RUser(user.getIdCardNo(), user.getHead(), user.getName(), user.getMobilePhone(),
						user.getContactPhone(), user.getAge(), user.getGender(), user.getBirthday(), user.getHrType(),
						user.getHrAddr(), user.getMarry(), user.getPolitical(), user.getEducation(), user.getCommunityId(),
						user.getAddr(), user.getLifeCond(), user.getJobCond(), user.getMedical(), user.getReligion(),
						user.getNation(), user.getActive(), user.getIncome(), opUser);
				dbUser.setBuildingId(user.getBuildingId());
				dbUser.setActive(1);
				id = this.userDao.save(dbUser);
				this.speciaDao.save(new RSpecia(user.getSpecia().getThree(), user.getSpecia().getDisable(),
						user.getSpecia().getNoSecurity(), user.getSpecia().getLonely(), user.getSpecia().getLessIncome(),
						user.getSpecia().getEmptyNest(), user.getSpecia().getLostOnly(), user.getSpecia().getSpecialCare(),
						user.getSpecia().getLifeLonely(), opUser, dbUser));
				//添加rContact表
				/*List<RContact> listSave = new ArrayList<RContact>();*/
				String[] str = rCName.split(",");
				String[] strPhone = rCPhone.split(",");
				RUser ru = userDao.findById(id);
				for (int i = 0; i < str.length; i++) {
					RContact contact = new RContact();
					contact.setName(str[i]);
					contact.setMobilePhone(strPhone[i]);
					contact.setUser(ru);
					rContactDao.save(contact);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
				/*//根据userId查询rContact
				listSave = rContactDao.getRContact(dbUser);
				dbUser.setrContact(listSave);*/
			/*
			 * r.setUser(dbUser); this.rContactDao.save(r);
			 */
		} else {
			// 更新
			dbUser = this.findById(user.getId());
			if (user.getHead() != null) {
				dbUser.setHead(user.getHead());
			}
			dbUser.setName(user.getName());
			dbUser.setMobilePhone(user.getMobilePhone());
			dbUser.setIdCardNo(user.getIdCardNo());
			dbUser.setContactPhone(user.getContactPhone());
			dbUser.setAge(user.getAge());
			dbUser.setGender(user.getGender());
			dbUser.setBirthday(user.getBirthday());
			dbUser.setHrType(user.getHrType());
			dbUser.setHrAddr(user.getHrAddr());
			dbUser.setMarry(user.getMarry());
			dbUser.setPolitical(user.getPolitical());
			dbUser.setEducation(user.getEducation());
			dbUser.setAddr(user.getAddr());
			dbUser.setLifeCond(user.getLifeCond());
			dbUser.setJobCond(user.getJobCond());
			dbUser.setMedical(user.getMedical());
			dbUser.setNation(user.getNation());
			dbUser.setIncome(user.getIncome());
			dbUser.setChangedBy(opUser);
			dbUser.setChangedAt(new Date());
			dbUser.setBuildingId(user.getBuildingId());
			dbUser.setActive(1);

			List<RContact> listRcs = new ArrayList<RContact>();
			if (dbUser.getrContact().size() > 0) {
				List<RContact> listRc = dbUser.getrContact();
				String[] str = rCName.split(",");
				String[] strPhone = rCPhone.split(",");
				for (int i = 0; i < listRc.size(); i++) {
					RContact rContact = dbUser.getrContact().get(i);
					rContact.setName(str[i]);
					rContact.setMobilePhone(strPhone[i]);
					listRcs.add(rContact);
				}
				dbUser.setrContact(listRcs);
			} else {
				String[] str = rCName.split(",");
				String[] strPhone = rCPhone.split(",");
				for (int i = 0; i < str.length; i++) {
					RContact rContact = new RContact();
					rContact.setName(str[i]);
					rContact.setMobilePhone(strPhone[i]);
					rContact.setUser(dbUser);
					this.rContactDao.save(rContact);
				}
			}

			if (dbUser.getSpecia() == null) {
				RSpecia specia = new RSpecia(user.getSpecia().getThree(), user.getSpecia().getDisable(),
						user.getSpecia().getNoSecurity(), user.getSpecia().getLonely(),
						user.getSpecia().getLessIncome(), user.getSpecia().getEmptyNest(),
						user.getSpecia().getLostOnly(), user.getSpecia().getSpecialCare(),
						user.getSpecia().getLifeLonely(), opUser, dbUser);
				dbUser.setSpecia(specia);
			} else {
				dbUser.getSpecia().setLessIncome(user.getSpecia().getLessIncome());
				dbUser.getSpecia().setLifeLonely(user.getSpecia().getLifeLonely());
				dbUser.getSpecia().setLonely(user.getSpecia().getLonely());
				dbUser.getSpecia().setNoSecurity(user.getSpecia().getNoSecurity());
				dbUser.getSpecia().setLostOnly(user.getSpecia().getLostOnly());
				dbUser.getSpecia().setSpecialCare(user.getSpecia().getSpecialCare());
				dbUser.getSpecia().setThree(user.getSpecia().getThree());
				dbUser.getSpecia().setDisable(user.getSpecia().getDisable());
				dbUser.getSpecia().setEmptyNest(user.getSpecia().getEmptyNest());
				dbUser.getSpecia().setChangedAt(new Date());
				dbUser.getSpecia().setChangedBy(opUser);
			}
			id = dbUser.getId();
			this.userDao.updates(dbUser);
			/*
			 * RContact r=user.getrContact(); r.setUser(dbUser);
			 * if(rContactDao.getByUser(dbUser).getId()==null){
			 * this.rContactDao.save(r); }else{ RContact
			 * rr=rContactDao.getByUser(dbUser); rr.setName(r.getName());
			 * rr.setMobilePhone(r.getMobilePhone());
			 * this.rContactDao.update(rr); }
			 */
		}
		return id;
	}

	/**
	 * 添加临时用户
	 * 
	 * @author L
	 * @param user
	 * @param opUser
	 */
	public void saveTempUser(RUser user, String opUser) {
		user.setChangedBy(opUser);
		user.setActive(UserConstants.USER_STATUS_TEMP);
		user.setBirthday(new Date());
		user.setAvailable(PropertyValueConstants.AVAILABLE);
		this.userDao.save(user);
	}

	/**
	 * 逻辑删除
	 * 
	 * @author guoyongxiang Date: 2014-9-27 下午6:35:55
	 * @param id
	 * @param opUser
	 */
	public void delete(Long id, String opUser) {
		this.userDao.delete(id, opUser);
	}

	public void remove(long id) {
		this.userDao.remove(id);
	}

	/**
	 * 物理删除
	 * 
	 * @author guoyongxiang Date: 2014-10-8 上午10:25:45
	 * @param id
	 */
	public void remove(Long id) {
		this.userDao.removeById(id);
	}

	/**
	 * 创建联系人
	 * 
	 * @author guoyongxiang Date: 2014-10-6 下午7:18:13
	 * @param id
	 * @param countact
	 * @param opUser
	 */
	public void saveCoutact(Long id, RContact coutact, String opUser) {
		RUser user = this.userDao.get(id);
		RContact _contact = new RContact(coutact.getIdCardNo(), coutact.getName(), coutact.getRelation(),
				coutact.getMobilePhone(), coutact.getGender(), coutact.getBirthday(), coutact.getAddr(), opUser, user);
		this.contactDao.save(_contact);
	}
	/**
	 * 上传证据
	 * 
	 * @author guoyongxiang Date: 2014-10-6 下午7:18:13
	 * @param id
	 * @param countact
	 * @param opUser
	 */
	/*
	 * public void uploadCert(Long id, RCert cert, String communityId, String
	 * opUser, MultipartFile[] files){ RUser user = this.userDao.get(id); //
	 * 处理文件上传 if(files!=null&&files.length>0){ String[] filePaths =
	 * this.attHandle.upload(11, files, communityId); if(filePaths!=null &&
	 * filePaths.length>0){ for(String directory:filePaths){
	 * this.contactDao.save(new RCert(user, cert.getCategoryId(),
	 * cert.getNumber(), directory, opUser)); } } } }
	 */

	/**
	 * 根据Id删除证据
	 * 
	 * @author guoyongxiang Date: 2014-10-8 上午10:55:41
	 * @param id
	 *//*
		 * public void removeCert(Long id){ RCert cert = this.certDao.get(id);
		 * // 删除文件 if(cert != null && cert.getDirectory()!=null &&
		 * !"".equals(cert.getDirectory())){
		 * this.attHandle.remove(cert.getDirectory()); } // 删除记录
		 * this.certDao.removeById(id); }
		 */
	/**
	 * 更新年龄
	 * 
	 * @author guoyongxiang Date: 2014-11-7 下午1:50:47
	 */
	public void updateAge() {
		this.userDao.updateAge();
	}

	/**
	 * excel导入信息保存
	 * 
	 * @author guoyongxiang Date: 2014-12-8 下午3:19:06
	 * @param file
	 * @param communityId
	 * @param opUser
	 * @throws IOException
	 */
	public void readExcel(MultipartFile file, String communityId, String opUser) throws IOException {
		List<Object[]> rows = null;
		if (file != null) {
			rows = ExportExcelUtil.importExcel(file.getInputStream());
		} else {
			return;
		}
		for (Object[] cols : rows) {
			if (cols == null) {
				continue;
			}
			RUser user = new RUser();
			user.setIdCardNo((String) cols[0]);
			user.setName((String) cols[1]);

			int gender = "女".equals((String) cols[2]) ? 0 : 1;
			user.setGender(gender);
			Date birthday = DateUtil.parseStrToDate((String) cols[3]);
			user.setBirthday(birthday);
			user.setMobilePhone((String) cols[4]);
			user.setContactPhone((String) cols[5]);

			int religion = getCategoryItemId(CategoryEnum.RELIGION.getIndex(), (String) cols[6]);
			if (religion == 0) {
				logger.warn("Excel导入数据无效religion=" + religion);
				continue;
			}
			user.setReligion(religion);

			int hrType = getCategoryItemId(CategoryEnum.HRTYPE.getIndex(), (String) cols[7]);
			if (hrType == 0) {
				logger.warn("Excel导入数据无效hrType=" + hrType);
				continue;
			}
			user.setHrType(hrType);

			user.setHrAddr((String) cols[8]);

			int marry = getCategoryItemId(CategoryEnum.MARRY.getIndex(), (String) cols[9]);
			if (marry == 0) {
				logger.warn("Excel导入数据无效marry=" + marry);
				continue;
			}
			user.setMarry(marry);

			int political = getCategoryItemId(CategoryEnum.POLITICAL.getIndex(), (String) cols[10]);
			if (political == 0) {
				logger.warn("Excel导入数据无效political=" + political);
				continue;
			}
			user.setPolitical(political);

			int education = getCategoryItemId(CategoryEnum.EDUCATION.getIndex(), (String) cols[11]);
			if (education == 0) {
				logger.warn("Excel导入数据无效education=" + education);
				continue;
			}
			user.setEducation(education);

			int nation = getCategoryItemId(CategoryEnum.NATION.getIndex(), (String) cols[12]);
			if (nation == 0) {
				logger.warn("Excel导入数据无效nation=" + nation);
				continue;
			}
			user.setNation(nation);

			user.setAddr((String) cols[13]);

			int lifeCond = getCategoryItemId(CategoryEnum.LIFECOND.getIndex(), (String) cols[14]);
			if (lifeCond == 0) {
				logger.warn("Excel导入数据无效lifeCond=" + lifeCond);
				continue;
			}
			user.setLifeCond(lifeCond);

			int jobCond = getCategoryItemId(CategoryEnum.JOBCOND.getIndex(), (String) cols[15]);
			if (jobCond == 0) {
				logger.warn("Excel导入数据无效jobCond=" + jobCond);
				continue;
			}
			user.setJobCond(jobCond);

			int income = getCategoryItemId(CategoryEnum.INCOME.getIndex(), (String) cols[16]);
			if (income == 0) {
				logger.warn("Excel导入数据无效income=" + income);
				continue;
			}
			user.setIncome(income);

			int medical = getCategoryItemId(CategoryEnum.MEDICAL.getIndex(), (String) cols[17]);
			;
			if (medical == 0) {
				logger.warn("Excel导入数据无效medical=" + medical);
				continue;
			}
			user.setMedical(medical);
			user.setActive(UserConstants.USER_STATUS_TEMP);
			user.setSpecia(new RSpecia(0, 0, 0, 0, 0, 0, 0, 0, 0, opUser, null));
			try {
				this.saveUser(user, communityId, opUser, null,null,null);
			} catch (Exception e) {
				logger.error("execl保存用户信息失败", e);
				continue;
			}
		}
	}

	/**
	 * 根据分类内容获取对应ID
	 * 
	 * @author guoyongxiang Date: 2014-12-8 下午3:06:18
	 * @param cateId
	 * @param val
	 * @return
	 */
	private int getCategoryItemId(int cateId, String val) {
		Map<Integer, LinkedHashMap<Integer, OCategoryItem>> map = this.springDataPool.getOCategory();
		Map<Integer, OCategoryItem> itemMap = map.get(cateId);
		if (itemMap != null) {
			for (Integer itemId : itemMap.keySet()) {
				OCategoryItem item = itemMap.get(itemId);
				if (item != null) {
					String itemVal = item.getItemName().trim();
					if (val.trim().equals(itemVal)) {
						return itemId;
					}
				}
			}
		}
		return 0;
	}

	/**
	 * 统计社区人口信息
	 * 
	 * @param param
	 * @return
	 */
	public List<CountUserVO> countUser(CountParamVO param) {
		List<CountUserVO> result = new ArrayList<CountUserVO>();
		String communityId = param.getCommunityId();
		for (CountParamItemVO item : param.getItems()) {
			if (item.getIsCount()) {
				// 统计单项信息
				List<CountUserItemVO> list = userDao.count(item, communityId);
				CountUserVO countVo = new CountUserVO();
				// 封装VO
				countVo.setItemList(list);
				CountColumnEnum column = CountColumnEnum.getColumn(item.getTitle());
				// 设置标题
				if (item.getIsSpec()) {
					countVo.setTitle(item.getTitle());
				} else if (column == CountColumnEnum.年龄) {
					countVo.setTitle(item.getTitle() + item.getValue() + "~" + item.getValue2());
				} else if (column == CountColumnEnum.性别) {
					countVo.setTitle(CountColumnEnum.性别.name());

				} else {
					OCategoryItem categoryItem = springDataPool.getOCategoryItem(new Integer(item.getValue()));
					countVo.setTitle(categoryItem.getItemName());
				}
				result.add(countVo);
			}
		}

		return result;
	}

	public void exportCount(List<CountUserVO> list, HttpServletResponse response) throws Exception {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String filename = formatter.format(new Date()) + ".xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(filename.getBytes(), "iso-8859-1"));
		WritableWorkbook wbook;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			wbook = Workbook.createWorkbook(os);
			WritableSheet wsheet = wbook.createSheet("人口统计", 0); // 工作表名称
			// 设置社区列
			Label label00 = new Label(0, 0, "社区");
			wsheet.addCell(label00);
			for (int i = 0; i < list.get(0).getItemList().size(); i++) {
				Label label0i = new Label(0, i + 1, list.get(0).getItemList().get(i).getCommunityName());
				wsheet.addCell(label0i);
			}
			// 设置统计列
			for (int i = 0; i < list.size(); i++) {

				CountUserVO item = list.get(i);
				Label labeli0 = new Label(i + 1, 0, item.getTitle());
				wsheet.addCell(labeli0);
				List<CountUserItemVO> items = item.getItemList();
				for (int j = 0; j < items.size(); j++) {
					Label labelij = new Label(i + 1, j + 1, items.get(j).getCount() + "");
					wsheet.addCell(labelij);
				}
			}
			wbook.write();
			wbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}

	}

	/**
	 * 获取评估状态‘
	 * 
	 * @author dx
	 * @param vo
	 * @param dateCond
	 * @param pagevo
	 * @return
	 */
	public Page<AssessUserVO> getdemand(ConclusionScreenVO vo, DateParamVO dateCond, PageParamVO pagevo,
			String creatBy) {
		return userDao.getdemand(vo, dateCond, pagevo, creatBy);
	}

	public Page<RUser> getUserlist(PageParamVO page, RUser user) {
		return userDao.getUserlist(page, user);
	}

	public Page<HGroupUserVO> getUserlist(Integer avaible, PageParamVO page) {
		return userDao.getUserlist(avaible, page);
	}

	/**
	 * 导出结论
	 * 
	 * @param vo
	 * @param dateCond
	 * @param pagevo
	 * @param creatBy
	 * @return
	 */
	public List<AssessUserVO> demandList(ConclusionScreenVO vo, DateParamVO dateCond, String creatBy) {
		return userDao.demandList(vo, dateCond, creatBy);
	}

	/**
	 * ruser加联系人 @author lenovo @exception
	 */
	public void addRcontact(RUser user) {
		RContact contact = new RContact();
		contact.setUser(user);
		contactDao.save(contact);
	}

	public void addRcontacts(RUser user, String nameL, String mobilePhoneL) {
		RContact contact = new RContact();
		contact.setUser(user);
		contact.setName(nameL);
		contact.setMobilePhone(mobilePhoneL);
		contactDao.save(contact);
	}

	public RContact rContactsById(Long id) {
		return contactDao.rContactsById(id);
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public void modifyRcontacts(RContact contact) {
		contactDao.modifyRcontacts(contact);
	}

	/**
	 * 在线管家、、查询所有ruser表信息
	 * 
	 * @param page
	 * @param user
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public Page<RUser> listAllCustomer(PageParamVO page, RUser user, String startTime, String endTime) {
		if (("").equals(startTime)) {
			startTime = null;
		}
		if (("").equals(endTime)) {
			endTime = null;
		}
		return userDao.listAllCustomer(page, user, startTime, endTime);
	}

	public void deleteCustomer(long cId, String createBy) {
		userDao.deleteCustomer(cId, createBy);
	}

	// 人口统计图
	public List<RUser> countUser() {
		return userDao.countUser();
	}

	public List<RUser> countUsers() {
		return userDao.countUsers();
	}

	// sum求和
	public Long sumUser() {
		return userDao.sumUser();

	}

	public Long sumUser2() {

		return userDao.sumUser2();
	}
	
	/**
	 * 根据user_id查询r_contacts表中的信息
	 * @param user
	 * @return
	 */
	public RContact rContactsByIds(RUser user){
		return contactDao.rContactsByIds(user);
	}
	/**
	 * 添加r_contacts
	 * @param rContact
	 */
	public Boolean saveRContacts(String urgentName,String urgentPhone,RUser user,String createName){
		RContact contact=new RContact();
		contact.setName(urgentName);
		contact.setMobilePhone(urgentPhone);
		contact.setAvailable(PropertyValueConstants.AVAILABLE);
		contact.setUser(user);
		contact.setVersion((short)0);
		contact.setCreatedBy(createName);
		contact.setCreatedAt(new Date());
		return contactDao.saveRContacts(contact);
	}
	
	 

}
