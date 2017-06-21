package com.anticw.aged.bean.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.anticw.aged.bean.MAssessGds;
import com.anticw.aged.bean.RUser;
import com.anticw.aged.bean.gds.Patient;
import com.anticw.aged.bean.gds.SimCase;
import com.anticw.aged.utils.DateUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class GdsUtil {
	static String orgid = "68";
	static String auth = "c7b244fa9533b2ea";							//授权码
	static String[] pid={"100000000","10000000","1000000","100000","10000","1000","100","10","1"};
	//static final URI uri = UriBuilder.fromUri("http://www.hmgds.com/api").build();	//
	static final URI uri = UriBuilder.fromUri("http://114.251.187.71:8070/api").build();	//
	static final WebResource resource = Client.create().resource(uri);
	
	public static Map<String, String> getHtml(RUser r,MAssessGds gds) throws Exception{
		Long userId=r.getId();
		int rId=userId.toString().length();
		String patientId=pid[rId-1]+userId;
		Method method = new Method();
		//测试接口
		if(!GdsUtil.testInterface()){
			throw new Exception("GDS系统异常,请联系管理员！");
		}
		//创建新患者
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		patient.setAge((short)r.getAge().intValue());
		patient.setName(r.getName());
		patient.setBirthday(DateUtil.getCurrentFormatDate(r.getBirthday()));
		method.createOrupdatePatient(patient, patientId, orgid, auth, uri);
		SimCase simcase = new SimCase();
		SimCase.Family simfamily = new SimCase.Family();	//家族病
		if(gds.getDm()!=null){
			simfamily.setDm(gds.getDm());
		}
		if(gds.getDsLip()!=null){
			simfamily.setDsLip(gds.getDsLip());
		}
		if(gds.getHbp()!=null){
			simfamily.setHbp(gds.getHbp());
		}
		simcase.setFamily(simfamily);		
		SimCase.Measure simmeasure = new SimCase.Measure();//体检检测值			
		
		if(gds.getSbp()!=null){
		simmeasure.setSbp(gds.getSbp());
		}
		if(gds.getDbp()!=null){
		simmeasure.setDbp(gds.getDbp());
		}
		if(gds.getPulse()!=null){
		simmeasure.setPulse(gds.getPulse());
		}
		if(gds.getFpg()!=null){
		simmeasure.setFpg(gds.getFpg());
		}
		if(gds.getHeight()!=null){
		simmeasure.setHeight(gds.getHeight());
		}
		if(gds.getWeight()!=null){
		simmeasure.setWeight(gds.getWeight());
		}
		if(gds.getTc()!=null){
		simmeasure.setTc(gds.getTc());
		}
		if(gds.getLdlc()!=null){
		simmeasure.setLdlc(gds.getLdlc());
		}
		if(gds.getHdlc()!=null){
		simmeasure.setHdlc(gds.getHdlc());
		}
		if(gds.getTg()!=null){
		simmeasure.setTg(gds.getTg());
		}
		simcase.setMeasure(simmeasure);
		method.createSimCase(simcase, DateUtil.getCurrentFormatDate(new Date()),patientId, orgid, auth, uri);
		method.getReportOfWord("84",patientId, orgid, auth, uri,r.getId());
		String brief=method.getSummary(patientId, orgid, auth, uri); 
		String gdsText=getHtml(r.getId(),brief);
		Map<String, String> map=new HashMap<String, String>();
		map.put("brief", brief);
		map.put("gdsText", gdsText);
		return map;
	}
	
	public static void canExtractImage(Long id) throws IOException {
		File f = new File("d:/report"+id+".docx");
		if (!f.exists()) {
			System.out.println("Sorry File does not Exists!");
		} else {
			if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {
				
				// 1) Load DOCX into XWPFDocument
				InputStream in = new FileInputStream(f);
				XWPFDocument document = new XWPFDocument(in);

				// 2) Prepare XHTML options (here we set the IURIResolver to
				// load images from a "word/media" folder)
				File imageFolderFile = new File("d:/media/report"+id+"/"+new Date().getTime());
				XHTMLOptions options = XHTMLOptions.create().URIResolver(
						new FileURIResolver(imageFolderFile));
				options.setExtractor(new FileImageExtractor(imageFolderFile));
				//options.setIgnoreStylesIfUnused(false);
				//options.setFragment(true);
				
				// 3) Convert XWPFDocument to XHTML
				OutputStream out = new FileOutputStream(new File(
						"d:/test"+id+".html"));
				XHTMLConverter.getInstance().convert(document, out, options);
			} else {
				System.out.println("Enter only MS Office 2007+ files");
			}
		}
	}
	
	public static String getHtml(Long id,String brief){
		try {
			canExtractImage(id);
			File input = new File("D:\\test"+id+".html");
			Document doc = Jsoup.parse(input, "UTF-8");
			Elements budy=doc.getElementsByTag("body");
			Elements  el=	doc.getElementsByTag("div");
			Iterator<Element> els= el.iterator();
			int i=0;
			Elements  el_=new Elements();
			Element e1=null;//  
			 while(els.hasNext()){
				e1=els.next();
				if(i!=0){
					
					e1.addClass("gds_css");
					el_.add(e1);
				}
				i++;
			}
			budy.remove();
			String body=el_.toString();
			body=body.replaceAll("<table>", "<table style=\"border-collapse:collapse;width:95%; \">");
			body=body.replaceAll("<td>", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:50.0pt;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:124.65pt;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:323.95pt;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:42.5pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:56.7pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:111.75pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:21.3pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:150.0pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:75.0pt;background-color:#ebf6f9;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:150.0pt;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:75.0pt;\">", "<td style=\"border:1px solid #999;\">");
			body=body.replaceAll("<td style=\"width:73.6pt;\">", "<td style=\"border:1px solid #999;text-align:left;\">");
			body=body.replaceAll("<td style=\"width:412.5pt;\">", "<td style=\"border:1px solid #999;text-align:left;\">");
			body=body.replaceAll("<td style=\"width:54.95pt;\">", "<td style=\"border:1px solid #999;text-align:left;\">");
			body=body.replaceAll("<td style=\"width:431.15pt;\">", "<td style=\"border:1px solid #999;text-align:left;\">");
			
			
			body=body.replaceAll("[\\[][^\\[\\]]+[\\]]", "");
			body=body.replaceAll("<span style=\"font-size:20px;\">", "");
			body=body.replaceAll("<span style=\"font-family:'����';font-size:10.0pt;\">", "");
			body=body.replaceAll("</span>", "");
			body=body.replace(brief, "&nbsp;");
			body=body.replace("评估摘要", "&nbsp;");
			body=body.replace("d:\\media\\", "/gds/");
			body=body.replace("width:595.0pt",  "width:580.0pt");
			body=body.replace("font-size:15.0pt;",  "font-size:20px;");
			body=body.replace("font-size:13.0pt;",  "font-size:20px;");
			body=body.replace("font-size:10.0pt;", "font-size:20px;");
			body=body.replace("margin-left:53.0pt", "margin-left:-20.0pt");
			body=body.replace("9.0pt", "15px");
			body=body.replace("font-family:'����';", "");
			body=body.replace("width:595.0pt;margin-bottom:72.0pt;margin-top:69.0pt;margin-left:80.0pt;margin-right:80.0pt;", "margin-left:8%;font-size:20px;width:85%;font-family:宋体;");
			
			DeleteFolder("D:\\test"+id+".html");
			DeleteFolder("d:/report"+id+".docx");
			return body;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 public static boolean DeleteFolder(String sPath) {  
		 boolean   flag = false;  
	     File    file = new File(sPath);  
	     // 判断目录或文件是否存在  
	     if (!file.exists()) {  // 不存在返回 false  
	         return flag;  
	     } else {  
	         // 判断是否为文件  
	         if (file.isFile()) {  // 为文件时调用删除文件方法  
	             return deleteFile(sPath);  
	         } else {  // 为目录时调用删除目录方法  
	             return deleteDirectory(sPath);  
	         }  
	     }  
	 }  
	 /** 
	  * 删除单个文件 
	  * @param   sPath    被删除文件的文件名 
	  * @return 单个文件删除成功返回true，否则返回false 
	  */  
	 public static boolean deleteFile(String sPath) {  
		 boolean   flag = false;  
		 File   file = new File(sPath);  
	     // 路径为文件且不为空则进行删除  
	     if (file.isFile() && file.exists()) {  
	         file.delete();  
	         flag = true;  
	     }  
	     return flag;  
	 }  
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean    flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
	
	//测试接口
	public static Boolean testInterface(){
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.get(ClientResponse.class);
		int status = response.getStatus();
		if (status == 200){
			//System.out.println("GDS心跳正常。");
			return true; 
		}
		return false;
			//System.out.println("GDS心跳异常，需要重启。");
	}
  
  

}
