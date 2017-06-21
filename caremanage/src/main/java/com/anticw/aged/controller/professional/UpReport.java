package com.anticw.aged.controller.professional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.MVender;
import com.anticw.aged.bean.RReport;
import com.anticw.aged.bean.utils.PropertyValueConstants;
import com.anticw.aged.service.professional.RReportSrevice;
import com.anticw.aged.service.professional.VenderService;
import com.anticw.aged.utils.ChineseCharacterCode;
import com.anticw.aged.utils.file.FileHandle;
import com.anticw.aged.vo.permission.UserVO;

@Controller
public class UpReport {
	@Autowired
	private RReportSrevice rReportSrevice;
	@Autowired
	private VenderService venderService;
	@Autowired
	private ChineseCharacterCode chineseCharacterCode;

	/**
	 * 将报告信息加入数据库
	 * 
	 * @author dx
	 * @param request
	 * @param response
	 * @param report
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/UpReport/service/upReport")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response, RReport report,
			HttpSession session) throws UnsupportedEncodingException {
		UserVO userVo = (UserVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
		String initial = "";
		String venderName = "";
		if (userVo.getVenderId() != null) {
			MVender mVender = venderService.getVender(userVo.getVenderId());
			String name = mVender.getName();
			initial = chineseCharacterCode.getFirstLetter(name);
			venderName = mVender.getContact();
		} else {
			initial = "GLY";
		}
		Date d;
		RReport r;
		String time;
		if (rReportSrevice.listRReport(venderName).size() != 0) {
			r = rReportSrevice.listRReport(venderName).get(0);
			String ms = r.getDateTime();
			Date s = new Date(Long.parseLong(ms));
			d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (sdf.format(d).equals(sdf.format(s))) {
				String num = r.getNumber().substring(r.getNumber().length() - 4, r.getNumber().length());
				String number = Integer.parseInt(num) + 1 + "";
				if (number.length() == 1) {
					number = "000" + number;
				} else if (number.length() == 2) {
					number = "00" + number;
				} else if (number.length() == 3) {
					number = "0" + number;
				} else if (number.length() == 4) {
				} else {
					number = "XXXX";
				}
				report.setNumber(initial + number);
			} else {
				report.setNumber(initial + "0001");
			}
			time = d.getTime() + "";
		} else {
			report.setNumber(initial + "0001");
			d = new Date();
			time = d.getTime() + "";
		}
		String strChineseString = request.getParameter("hidden");
		String path = request.getSession().getServletContext().getRealPath("/");
		File f = new File(path + "bao_gao/" + time + ".txt");// key是.txt文件名
		if (f.exists()) {
			f.delete();
		}
		FileOutputStream fos = null;
		try {
			f.createNewFile();
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			pw.write(strChineseString);
			pw.flush();
			fos.close();
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (venderService.getMVender(report.getPrincipal()) != null) {
			report.setReportSource(venderService.getMVender(report.getPrincipal()).getName());
		}
		report.setDateTime(time);
		rReportSrevice.setRReport(report);
		ModelAndView mv = new ModelAndView("/professional/vender/bao_gao_list");
		mv.addObject("userId", report.getrUserId());
		return mv;
	}

	/**
	 * 
	 * @author dx 根据用户老年id查询下面所有的报告
	 * @param userId
	 * @return
	 */
	@RequestMapping("/UpReport/service/refer")
	public @ResponseBody JSONObject getRsfer(long userId) {
		List<RReport> list = rReportSrevice.listRReport(userId);
		JSONObject jsonlist = new JSONObject();
		jsonlist.put("list", list);
		return jsonlist;
	}

	/**
	 * 加载一条报告
	 * 
	 * @param dateTime
	 * @return
	 */
	@RequestMapping("/UpReport/service/refer/rReport")
	public @ResponseBody JSONObject getRsfer(String dateTime) {
		RReport rReport = rReportSrevice.rReport(dateTime);
		JSONObject jsonlist = new JSONObject();
		jsonlist.put("rReport", rReport);
		return jsonlist;
	}

	@RequestMapping("/UpReport/service/refer/rReportId")
	public @ResponseBody JSONObject getRsferId(long id) {
		RReport rReport = rReportSrevice.rReport(id);
		JSONObject jsonlist = new JSONObject();
		jsonlist.put("rReport", rReport);
		return jsonlist;
	}

	/**
	 * @author dx 查看报告
	 * @param request
	 * @param response
	 * @param report
	 * @return
	 */
	@RequestMapping("/UpReport/service/check")
	public ModelAndView getString(HttpServletRequest request, HttpServletResponse response, RReport report) {
		InputStreamReader inputReader = null;
		BufferedReader bufferReader = null;
		@SuppressWarnings("unused")
		OutputStream outputStream = null;
		String path = request.getSession().getServletContext().getRealPath("/");
		RReport r = rReportSrevice.rReport(report.getDateTime());
		File f = new File(path + "bao_gao/" + report.getDateTime() + ".txt");// key是.txt文件名\
		StringBuffer strBuffer = new StringBuffer();
		try {
			InputStream inputStream = new FileInputStream(f);
			inputReader = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(inputReader);

			// 读取一行
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				strBuffer.append(line);
			}
		} catch (IOException e) {
			System.out.println("/UpReport/service/check  报错");
		}
		ModelAndView mv = new ModelAndView("/professional/vender/bao_gao_check");
		mv.addObject("str", strBuffer.toString());
		mv.addObject("number", r.getNumber());
		return mv;
	}

	/**
	 * 打印
	 * 
	 * @param request
	 * @param response
	 * @param report
	 * @throws IOException
	 */

	@RequestMapping("/UpReport/service/check_stamp")
	public void getStamp(HttpServletRequest request, HttpServletResponse response, RReport report) throws IOException {
		InputStreamReader inputReader = null;
		BufferedReader bufferReader = null;
		@SuppressWarnings("unused")
		OutputStream outputStream = null;
		String path = request.getSession().getServletContext().getRealPath("/");
		File f = new File(path + "bao_gao/" + report.getDateTime() + ".txt");// key是.txt文件名\
		StringBuffer strBuffer = new StringBuffer();
		try {
			InputStream inputStream = new FileInputStream(f);
			inputReader = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(inputReader);

			// 读取一行
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				strBuffer.append(line);
			}
		} catch (IOException e) {
			System.out.println("/UpReport/service/check  报错");
		}
		PrintWriter out = response.getWriter();
		out.print(strBuffer.toString());
	}

	@Autowired
	private FileHandle fileHandle;

	@RequestMapping("/UpReport/service/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, RReport report)
			throws UnsupportedEncodingException {
		// 删除该用户上传的某个文件
		RReport reports = rReportSrevice.rReport(report.getDateTime());
		String url = reports.getUrl();
		if (url != null) {
			String urls = url.substring(url.lastIndexOf("/") + 1, url.length());
			fileHandle.removePic(urls);
		}
		rReportSrevice.delete(reports);
		String path = request.getSession().getServletContext().getRealPath("/");
		File f = new File(path + "bao_gao/" + report.getDateTime() + ".txt");// key是.txt文件名\
		if (f.exists()) {
			f.delete();
		}

	}
}
