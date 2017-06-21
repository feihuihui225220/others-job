package com.anticw.aged.controller.professional.activity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.bean.MMaterial;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.NProgram;
import com.anticw.aged.bean.NVenderMaterial;
import com.anticw.aged.bean.NVideo;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.dao.utils.Page;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.service.professional.activity.ActivityManagerService;
import com.anticw.aged.service.professional.activity.NProgramService;
import com.anticw.aged.service.professional.activity.NVideoService;
import com.anticw.aged.service.professional.material.MMaterialService;
import com.anticw.aged.utils.UpdateVideo;
import com.anticw.aged.utils.VideoThumbTaker;
import com.anticw.aged.vo.common.PageParamVO;
import com.anticw.aged.vo.permission.UserVO;
import com.anticw.aged.vo.professional.activity.NProgtemVOThree;
import com.anticw.aged.vo.professional.upload.SubjectTeacherVO;
@Controller
public class NProgramCtl {
	/**
	 * 节目
	 */
	@Autowired
	private NProgramService nProgramService;
	
	@Autowired
	private NVideoService nVideoService;
	
	@Autowired
    private ActivityManagerService activityManagerService;
	
	//添加视频
	@Autowired
	private UpdateVideo updateVideo;
	
	@Autowired
	private VenderService venderService;

	@Autowired
	private MMaterialService mMaterialService;
	 
	
	/**
	 * 分页加载节目到页面
	 * @author dx
	 * @param session
	 * @param pageVO
	 * @return
	 */
	@RequestMapping("/professional/fete")
	public ModelAndView  seeProgram(HttpSession session){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		ModelAndView mv=null;
		List<NProgram> nProgram = null;
		
		Set<ARole> ar=	userVO.getRoles();
		for(ARole a:ar){
			if("专业老师".equals(a.getName())){
				NProgram n=nProgramService.ListNProgram((int)userVO.getId());
				if(n==null){
					n=new NProgram(); 
					n.setId(0);
				}
				mv=new ModelAndView(new RedirectView("/professional/fete/programSelect?id="+n.getId()));
			}
		}
		if(mv==null){
			mv=new ModelAndView("professional/activity/n_program/program");
			if(!userVO.isSuper_()){
				MVender m=	venderService.getVender(userVO.getVenderId());
				userVO.setName( m.getContact());
			}
			nProgram = nProgramService.ListNPrograms(userVO.getName());
		}
		/*String name;
 		AUser aUser=activityManagerService.findName(userVO.getName(),userVO.getVenderId());
 		if(aUser.getSuper_()==true){
    		name=aUser.getName();
 		}else{
 			MVender m=activityManagerService.getMvender(userVO.getVenderId());
 			name=m.getContact();
 		}
		Page<NProgramVO> nprogram = nProgramService.seeNProgram(page.getPage(), page.getNum(), name);*/
		//获取专业老师
		//List<SubjectTeacherVO> users=venderService.getListT(userVO.getName());
		//加载出所有的课程分类
		
		
		//mv.addObject("users",users);
		mv.addObject("nProgram",nProgram);
		mv.addObject("name",userVO.getName());
		return mv;
	}
	/**
	 * 添加课程分类
	 * @param session
	 * @param nProgram
	 * @return
	 */
	@RequestMapping("/professional/fete/parentAdd")
	public String parentAdd(HttpSession session,NProgram nProgram){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		nProgram.setChangedBy(userVO.getName());
		nProgram.setCreatedBy(userVO.getName());
		nProgram.setChangedAt(new Date());
		nProgram.setCreatedAt(new Date());
		nProgram.setAvaliable(true);
		nProgram.setVersion((short)0);
		nProgramService.addNProgram(nProgram);
		springDataPool.savenProgram(nProgram);
        return "redirect:/professional/fete";
    }
	/**
	 * 查询专业老师
	 * @param session
	 * @param name
	 * @return
	 */
	@RequestMapping("/professional/fete/SubjectTeacher")
	public @ResponseBody List<SubjectTeacherVO> getList(HttpSession session,String name){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		List<SubjectTeacherVO> users=venderService.getListT(userVO.getName(),name);
		return users;
	}
	/**
	 * 修改课程类别信息
	 * @param session
	 * @param nProgram
	 * @return
	 */
    @RequestMapping("/professional/fete/parentUpdate")
    public @ResponseBody String parentUpdate(NProgram nProgram){
    	NProgram n=nProgramService.selNProgram(nProgram.getId());
    	n.setProgramDesc(nProgram.getProgramDesc());
    	if(nProgram.getSubjectTeacher()!=null){
    		n.setSubjectTeacher(nProgram.getSubjectTeacher());
    	}
    	n.setVersion((short)(n.getVersion()+1));
    	nProgramService.update(n);
    	return "修改成功";
	}
    @RequestMapping("/professional/fete/programSelect")
    public ModelAndView parentUpdate(Integer id,PageParamVO page,String keyword){
    	ModelAndView mv=new ModelAndView("professional/activity/n_program/programSelect");
    	if(id!=0){
    		Page<NProgram> nPrograms=nProgramService.gerList(id,page.getPage(),page.getNum(),keyword);
    		NProgram nProgram=nProgramService.selNProgram(id);
    		mv.addObject("nProgram",nProgram);
    		mv.addObject("keyword",keyword);
    		mv.addObject("page",nPrograms);
    	}
		//mv.addObject("users",users);
		return mv;
    }
    @RequestMapping("/professional/fete/subUpdate")
    public ModelAndView subUpdate(Integer id){
    	NProgram nProgram=nProgramService.selNProgram(id);
    	ModelAndView mv=new ModelAndView("professional/activity/n_program/subUpdate");
    	//mv.addObject("users",users);
    	List<AUser> subjectTeacher = venderService.getListT(nProgram.getSubjectTeacher());
    	mv.addObject("nProgram",nProgram);
    	mv.addObject("subjectTeacher",subjectTeacher);
    	return mv;
    }
    @RequestMapping("/professional/fete/tovoid")
    public ModelAndView tovoid(int parentId){
    	List<NProgram> np= nProgramService.ListNPrograms(parentId);
    	ModelAndView mv=new ModelAndView("professional/activity/n_program/void");
    	mv.addObject("nProgram", np);
    	mv.addObject("parentId", parentId);
    	return mv;
    }
    @SuppressWarnings("rawtypes")
	@RequestMapping("/professional/fete/savevoid")
    public ModelAndView upload(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
		final
		HttpSession hs = request.getSession();  
        ModelAndView mv=new ModelAndView();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        if(!isMultipart){  
            return mv;  
        }  
        // Create a factory for disk-based file items  
        FileItemFactory factory = new DiskFileItemFactory();  
  
        // Create a new file upload handler  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setProgressListener(new ProgressListener(){  
               public void update(long pBytesRead, long pContentLength, int pItems) {  
                   ProcessInfo pri = new ProcessInfo();  
                   pri.itemNum = pItems;  
                   pri.readSize = pBytesRead;  
                   pri.totalSize = pContentLength;  
                   pri.show = pBytesRead+"/"+pContentLength+" byte";  
                   pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength)*100);  
                   hs.setAttribute("proInfo", pri);  
               }  
            });  
      NProgram np = null; 
      String url = null;
      List items = upload.parseRequest(request);  
      Iterator iter = items.iterator();  
      while (iter.hasNext()) {  
          FileItem item = (FileItem) iter.next();  
          if (item.isFormField()) {  
              String name = item.getFieldName();  
              String value = item.getString(); 
              if("nprpgramId".equals(name)){
            	  np= nProgramService.get(Integer.parseInt(value));
              }
          } else {  
           		  /* 
           		  String fieldName = item.getFieldName();  
                  String contentType = item.getContentType();  
                  boolean isInMemory = item.isInMemory();  
                  long sizeInBytes = item.getSize();  */
           		  String name=new Date().getTime()+".mp4";
                  File uploadedFile = new File(getServletContext()+"file/",name );  
                  url="file/"+name;
                  item.write(uploadedFile);  
                  
          } 
          if(url!=null){
        	  new VideoThumbTaker(this.getServletContext()+"tools/ffmpeg.exe").getThumb(getServletContext()+url, getServletContext()+"file/"+new Date().getTime()+".png",800, 600, 0, 0, 5);
              np.setCoverUrl("/file/"+new Date().getTime()+".png");
        	  np.setAviUrl(url);
              nProgramService.update(np);
             // return new ModelAndView(new RedirectView("/professional/fete/programSelect?id="+np.getParentId()));  
          }
      }  
      return mv;
    }  
      
      
    /** 
     * process 获取进度 
     * @param request 
     * @param response 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping("/professional/fete/process")
    @ResponseBody  
    public Object process(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        return ( ProcessInfo)request.getSession().getAttribute("proInfo");  
    }  
      
    class ProcessInfo{  
        public long totalSize = 1;  
        public long readSize = 0;  
        public String show = "";  
        public int itemNum = 0;  
        public int rate = 0;  
    }  
	
	/**
	 * 
	 * @param id  父Id 分类Id
	 * @return
	 */
	@RequestMapping("/professional/fete/toAdd")
	public ModelAndView  seeProgram(Integer id){
		ModelAndView mv=new ModelAndView("professional/activity/n_program/n_program_add");
		mv.addObject("programId", id); 
		return mv;
	}
	
	/**
	 * 添加
	 * @author dx
	 * @param nProgram
	 * @param name
	 * @return
	 */
	@RequestMapping("/professional/fete/add")
	public String  addProgram(HttpSession session, NProgram nProgram){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String name;
 		AUser aUser=activityManagerService.findName(userVO.getName(),userVO.getVenderId());
 		if(aUser.getSuper_()==true){
    		name=aUser.getName();
 		}else{
 			MVender m=activityManagerService.getMvender(userVO.getVenderId());
 			name=m.getContact();
 		}
		nProgram.setCreatedBy(name);
        nProgram.setCreatedAt(new  Date());
        nProgram.setVersion((short) 0);
        nProgram.setAvaliable(true);
        nProgramService.addNProgram(nProgram);
        return "redirect:/professional/fete";
	}
	/**
	 * @author dx
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/professional/fete/delete/{id}")
	public @ResponseBody String deleteProgram(HttpSession session, @PathVariable Integer id){
		NProgram nProgram=nProgramService.selNProgram(id);
		nProgram.setAvaliable(false);
		nProgramService.delete(nProgram);
		return "success";
	}
	@RequestMapping("/professional/fete/updata")
	public ModelAndView updateeProgram(HttpSession session, @RequestParam("id") int id){
		NProgram nProgram=nProgramService.selNProgram(id);
		ModelAndView mv=new ModelAndView("professional/activity/n_program/n_programUpdate");
		mv.addObject("nProgram",nProgram);
		return mv;
	}
	/**
	 * @author dx
	 * @param session
	 * @param nProgram
	 * @param id
	 * @return
	 */
	@RequestMapping("/professional/fete/update_update")
	public String updateProgram(HttpSession session, NProgram nProgram,@RequestParam("id") int id){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		NProgram program=nProgramService.selNProgram(id);
		short a=(short)(program.getVersion()+1);
		program.setVersion(a);
		program.setChangedAt(new Date());
		program.setProgramDesc(nProgram.getProgramDesc());
		program.setChangedBy(userVO.getName());
		program.setProgramName(nProgram.getProgramName());
		nProgramService.delete(program);
		return "redirect:/professional/fete";
	}
	
	@RequestMapping("/professional/fete/video/toAdd")
	public ModelAndView toAdd(int id){
		ModelAndView mv = new ModelAndView("professional/activity/n_program/video");
		mv.addObject("programId", id);
		return mv;
	}
	
	public void doPost(Integer id,HttpSession session,HttpServletRequest request, HttpServletResponse response,NVideo nv)
			throws ServletException, IOException {
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
			// 提供解析时的一些缺省配置
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建一个解析器,分析InputStream,该解析器会将分析的结果封装成一个FileItem对象的集合
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				
				List<FileItem> items = sfu.parseRequest(request);
				boolean flag = false; // 转码成功与否的标记
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					// 要区分是上传文件还是普通的表单域
					if (item.isFormField()) {// isFormField()为true,表示这不是文件上传表单域
						// 普通表单域
						 String paramName = item.getFieldName();
						 String paramValue = item.getString();
							if (paramName.equals("descript")) {
								paramValue=new String(item.getString()
										.getBytes("ISO8859-1"), "UTF-8");
								nv.setDescript(paramValue);
							}
					} else {
						// 上传文件
						String sctx = this.getServletContext();
						// 获得保存文件的路径
						String basePath = sctx+"file/video";
						// 获得文件名
						String fileUrl = item.getName();
						// 在某些操作系统上,item.getName()方法会返回文件的完整名称,即包括路径
						// 自定义方式产生文件名
						String serialName = String.valueOf(System
								.currentTimeMillis());
						// 待转码的文件
						File uploadFile = new File("E:/test");
						item.write(uploadFile);

						String codcFilePath = basePath + "/" + serialName
								+ ".flv"; // 设置转换为flv格式后文件的保存路径
						String mediaPicPath = basePath + "/images"
								+ File.separator + serialName + ".jpg"; // 设置上传视频截图的保存路径

						// 获取配置的转换工具（ffmpeg.exe）的存放路径
						StringBuffer sb=new StringBuffer();
						sb.append(this.getServletContext()).append("tools/ffmpeg.exe");
						String ffmpegPath =sb.toString();
						
						File f=new File(ffmpegPath);
						File mediaPic=new File(mediaPicPath);
						File codcFile=new File(codcFilePath);
						// 转码

						flag = updateVideo.executeCodecs(f.getAbsolutePath(),
								uploadFile.getAbsolutePath(),codcFile.getAbsolutePath() ,
								mediaPic.getAbsolutePath());
						if (flag) {
							nv.setProgramId(id);
							nv.setFileName(fileUrl);
							nv.setFileUrl("/file/video/"+serialName + ".flv");
							nv.setImgUrl("/file/video/"+serialName + ".jpg");
							nv.setCreateId((int)userVO.getId());
							nv.setCreatedBy(userVO.getName());
							nv.setCreatedAt(new Date());
							nv.setAvaliable(true);
							nVideoService.save(nv);
						}
					}
				}
				

				

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}

	private String getServletContext() {
		String path = this.getClass().getClassLoader().getResource("/").toString().replace("/classes/", "/").substring(6);
		return path;
	}
	@Autowired
	private SpringDataPool springDataPool;
	@RequestMapping("professional/fete/addNProgram")
	public String addNProgram(HttpSession session,NProgram nProgram,Integer[] materialId,Integer[] materialAmount){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String name;
 		AUser aUser=activityManagerService.findName(userVO.getName(),userVO.getVenderId());
 		if(aUser.getSuper_()==true){
    		name=aUser.getName();
 		}else{
 			MVender m=activityManagerService.getMvender(userVO.getVenderId());
 			name=m.getContact();
 		}
 		NProgram parent=nProgramService.selNProgram(nProgram.getParentId());
 		nProgram.setSubjectTeacher(parent.getSubjectTeacher());
 		nProgram.setCreatedBy(name);
        nProgram.setCreatedAt(new  Date());
        nProgram.setVersion((short) 0);
        nProgram.setAvaliable(true);
        NProgram  nProgram_ = nProgramService.addNProgram(nProgram);
        springDataPool.savenProgram(nProgram_);
        for(int i=0;i<materialId.length;i++){
        	MMaterial mMaterial=mMaterialService.selectById(materialId[i]);
        	NVenderMaterial n=new NVenderMaterial();
        	n.setnProgram(nProgram_);
        	n.setMaterialId(materialId[i]);
        	n.setMaterialAmount(materialAmount[i]);
        	n.setMaterialStandard(mMaterial.getMaterialStandard());
			n.setMaterialName(mMaterial.getMaterialName());
			n.setCreatedBy(name);
	        n.setCreatedAt(new  Date());
			nProgramService.saveNVenderMaterial(n);
        }
        return "redirect:/professional/fete/programSelect?id="+parent.getId();
	}
	@RequestMapping("professional/fete/updateNProgram")
	public String updateNProgram(HttpSession session,NProgram nProgram,Integer[] materialId,Integer[] materialAmount){
		UserVO userVO = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String name;
		AUser aUser=activityManagerService.findName(userVO.getName(),userVO.getVenderId());
		if(aUser.getSuper_()==true){
			name=aUser.getName();
		}else{
			MVender m=activityManagerService.getMvender(userVO.getVenderId());
			name=m.getContact();
		}
		NProgram parent=nProgramService.selNProgram(nProgram.getId());
		parent.setKeyword(nProgram.getKeyword());
		parent.setProgramContent(nProgram.getProgramContent());
		parent.setProgramDesc(nProgram.getProgramDesc());
		parent.setProgramTime(nProgram.getProgramTime());
		parent.setProgramName(nProgram.getProgramName());
		parent.setProgramExperience(nProgram.getProgramExperience());
		parent.setVersion((short)(parent.getVersion()+1));
		NProgram  nProgram_ = nProgramService.update(parent);
		springDataPool.savenProgram(nProgram_);
		nProgramService.deleteNVenderMaterial(nProgram_);
		for(int i=0;i<materialId.length;i++){
			MMaterial mMaterial=mMaterialService.selectById(materialId[i]);
			NVenderMaterial n=new NVenderMaterial();
			n.setnProgram(nProgram_);
			n.setMaterialId(materialId[i]);
			n.setMaterialAmount(materialAmount[i]);
			n.setMaterialStandard(mMaterial.getMaterialStandard());
			n.setMaterialName(mMaterial.getMaterialName());
			n.setCreatedBy(name);
			n.setCreatedAt(new  Date());
			nProgramService.saveNVenderMaterial(n);
		}
		return "redirect:/professional/fete/programSelect?id="+parent.getParentId();
	}
	@RequestMapping("professional/fete/gpupdate")
	public ModelAndView toupdate(int id){
		NProgram n=nProgramService.selNProgram(id);
		ModelAndView mv=new ModelAndView("professional/activity/n_program/n_program_add");
		mv.addObject("programId", n.getParentId());
		mv.addObject("nProgram", n);
		return mv;
	}
	
	/**
	 * 获取本类别下所有节目
	 * @param id
	 * @return
	 */
	@RequestMapping("/professional/fete/plan")
	public @ResponseBody NProgtemVOThree getList(int id){
		List<NProgram> nProgram=nProgramService.ListNPrograms(id);
		NProgtemVOThree npr=new NProgtemVOThree();
		List<String> keywor=new ArrayList<String>();
		for(NProgram n:nProgram){
			if(n.getKeyword()!=null&&n.getKeyword().trim()!=""){
				keywor.add(n.getKeyword());
			}
		}
		HashSet<String> h = new  HashSet<String>(keywor);        
		npr.getKeyword().addAll(h);        

		NProgram ns=nProgramService.selNProgram(id);
		List<AUser> auser=venderService.getListT(ns.getSubjectTeacher());
		for(AUser a:auser){
			npr.getTeacher().put(a.getId().toString(), a.getName());
		}
		return npr;
	}
}
