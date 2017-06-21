package com.anticw.aged.controller.icare.combo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.anticw.aged.bean.ZFitness;
import com.anticw.aged.service.icare.combo.ZFitnessService;
import com.anticw.aged.vo.icare.ZFitnessVO;

/**
 * 
 * @author DX-2016/12/15
 *
 */
@Controller
@RequestMapping("/ICareFitness")
public class ZFitnessController {

	@Autowired
	private ZFitnessService zFitnessService;

	/**
	 * 添加一个新的类型或者选项
	 * 
	 * @param z
	 * @param session
	 * @param imgs
	 * @return
	 */
	@RequestMapping("/zfitness/insert")
	public ModelAndView insert(ZFitness z, HttpSession session) {
		ModelAndView mv;
		if (z.getParentId() != null) {
			zFitnessService.save(z, session);
		}
		if (z.getParentId() != null && z.getParentId() != 0) {
			return operationChild(z.getFId(), z.getParentId());
		} else {
			mv = new ModelAndView(new RedirectView("/ICareFitness/zfitness/zfitnessList"));
		}
		return mv;
	}

	/**
	 * 展示内容
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping("/zfitness/zfitnessList")
	public ModelAndView getList() throws IllegalAccessException, InvocationTargetException {
		ModelAndView mv = new ModelAndView("/ICare/zfitness/zfitnessList");
		List<ZFitnessVO> vos = zFitnessService.getList();
		mv.addObject("vos", vos);
		return mv;
	}

	/**
	 * 修改类型或者选项
	 * 
	 * @param z
	 * @param session
	 * @param imgs
	 * @return
	 */
	@RequestMapping("/zfitness/update")
	public ModelAndView update(ZFitness z, HttpSession session) {
		ModelAndView mv;
		zFitnessService.update(z);
		if (z.getParentId() != 0) {
			return operationChild(z.getFId(), z.getParentId());
		} else {
			mv = new ModelAndView(new RedirectView("/ICareFitness/zfitness/zfitnessList"));
		}
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param fId
	 * @return
	 */
	@RequestMapping("/zfitness/delete")
	public ModelAndView delete(Integer fId) {
		ModelAndView mv = new ModelAndView(new RedirectView("/ICareFitness/zfitness/zfitnessList"));
		Integer parentId = zFitnessService.remove(fId);
		if (parentId != 0) {
			return operationChild(null, parentId);
		}
		return mv;
	}

	/*	*//**
			 * 微信端获取体适能信息
			 * 
			 * @param gameId
			 * @param response
			 * @return
			 * @throws IllegalAccessException
			 * @throws InvocationTargetException
			 *//*
			 * @RequestMapping("/zfitness/getfitness")
			 * 
			 * @ResponseBody public List<ZFitnessVO> getTSN(int gameId,
			 * HttpServletResponse response) throws IllegalAccessException,
			 * InvocationTargetException {
			 * response.setHeader("Access-Control-Allow-Origin", "*"); return
			 * zFitnessService.getList(); }
			 */

	/**
	 * parentId!=0跳转体适能试题详情页 parentId==0跳转类型修改页
	 * 
	 * @param fid
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/zfitness/savevoid")
	public ModelAndView operation(Integer fid, Integer parentId) {
		ModelAndView mv = null;
		if (parentId != 0) {
			return operationChild(fid, parentId);
		} else {
			mv = new ModelAndView("/ICare/zfitness/operation");
		}
		if (fid != null) {
			mv.addObject("zfit", zFitnessService.getById(fid));
		}
		mv.addObject("fid", fid);
		mv.addObject("parentId", parentId);
		return mv;
	}

	/**
	 * 体适能详情页
	 * 
	 * @param fid
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/zfitness/operationChild")
	public ModelAndView operationChild(Integer fid, Integer parentId) {
		ModelAndView mv = new ModelAndView("/ICare/zfitness/operationChild");
		if (fid != null) {
			mv.addObject("fid", fid);
			mv.addObject("zfit", zFitnessService.getById(fid));
		}
		if (parentId != null && parentId != 0) {
			List<ZFitness> list = zFitnessService.getChildList(parentId);
			mv.addObject("list", list);
		}
		mv.addObject("parentId", parentId);
		return mv;
	}

	/**
	 * 上传视频
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zfitness/operation")
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final HttpSession hs = request.getSession();
		ModelAndView mv = new ModelAndView();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return mv;
		}
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setProgressListener(new ProgressListener() {
			public void update(long pBytesRead, long pContentLength, int pItems) {
				ProcessInfo pri = new ProcessInfo();
				pri.itemNum = pItems;
				pri.readSize = pBytesRead;
				pri.totalSize = pContentLength;
				pri.show = pBytesRead + "/" + pContentLength + " byte";
				pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength) * 100);
				hs.setAttribute("proInfo", pri);
			}
		});
		@SuppressWarnings("rawtypes")
		List items = upload.parseRequest(request);
		@SuppressWarnings("rawtypes")
		Iterator iter = items.iterator();
		String fileName = "";
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {
				String name = item.getFieldName();
				if ("fileNames".equals(name)) {
					fileName = item.getString();
				}

			} else {
				File uploadedFile = new File(getServletContext() + "file/", fileName);

				item.write(uploadedFile);
			}
		}
		return mv;
	}

	/**
	 * 获取存储路径
	 * 
	 * @return
	 */
	private String getServletContext() {
		String path = this.getClass().getClassLoader().getResource("/").toString().replace("/classes/", "/")
				.substring(6);
		return path;
	}

	/**
	 * process 获取进度
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zfitness/process")
	@ResponseBody
	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProcessInfo pro = (ProcessInfo) request.getSession().getAttribute("proInfo");
		return pro;
	}

	class ProcessInfo {
		public long totalSize = 1;
		public long readSize = 0;
		public String show = "";
		public int itemNum = 0;
		public int rate = 0;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/zfitness/imgs")
	@ResponseBody
	public String uploadImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final HttpSession hs = request.getSession();
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setProgressListener(new ProgressListener() {
			public void update(long pBytesRead, long pContentLength, int pItems) {
				ProcessInfo pri = new ProcessInfo();
				pri.itemNum = pItems;
				pri.readSize = pBytesRead;
				pri.totalSize = pContentLength;
				pri.show = pBytesRead + "/" + pContentLength + " byte";
				pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength) * 100);
				hs.setAttribute("proInfo", pri);
			}
		});

		List items = upload.parseRequest(request);
		Iterator iter = items.iterator();
		@SuppressWarnings("unused")
		String fileName;
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {
				String name = item.getFieldName();
				if ("fileNames".equals(name)) {
					fileName = item.getString();
				}

			} else {
				File uploadedFile = new File(getServletContext() + "file/", item.getName());

				item.write(uploadedFile);
				return "/file/" + item.getName();
			}
		}
		return null;
	}

	@RequestMapping("/ZFitness/toAddAll")
	public ModelAndView getzfitALL(ZFitness z) {
		ModelAndView mv = new ModelAndView("/ICare/zfitness/addorUpdateChild");
		if (z.getFId() != null) {
			mv.addObject("zfit", zFitnessService.getById(z.getFId()));
		} else {
			mv.addObject("zfit", z);
		}
		return mv;
	}

}
