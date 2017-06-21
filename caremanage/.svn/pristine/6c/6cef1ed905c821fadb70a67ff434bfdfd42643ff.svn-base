package com.anticw.agedq.bed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.dao.professional.assess.AssessRecordDetailDao;
import com.anticw.aged.service.position.PositionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/webApplicationContext.xml" })
public class PTest {

    @Autowired
    AssessRecordDetailDao dao;
    @Autowired
    PositionService positionService;
   /* public static void main(String[] args){

    }*/

   /* @Test
    public void test(){
    	System.out.println(positionService.getByDeviceId("8CDDA07C98FC3F20"));  
    }*/
 /*   @Test
    public void test(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*");
//        context.getBean(VenderCtl.class);
       String conclusion = dao.getConclusion().get(0).getConclusion();
        System.out.print("xxxxxxxxxxxxxx");
    }*/
       public static void main(String[] args){
    	 
    	   PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            //URL realUrl = new URL("https://mp.le-ho.cn/data/receive/smartwatch");
	            URL realUrl = new URL("http://localhost:8080/data/receive/smartwatch");
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setRequestProperty("connection", "keep-alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
	            JSONObject jsoncent=new JSONObject();
				JSONObject jsre=new JSONObject();
				jsoncent.put("event", "LATEST_HEART_RATE");		
				jsoncent.put("md5", "1913CD19BFCD2BBA");	
				jsoncent.put("dateTime", "2017-05-18 15:40:22");	
				jsre.put("lat", "30.266458");
				jsre.put("lon", "120.162332");
				jsre.put("road", "浙江省 ,杭州市,下城区,武林街道,凤起路");
				JSONObject jso=new JSONObject();
				jso.put("heartRate", 60);
				/*jso.put("diastolic_pressure", 60);
				jso.put("systolic_pressure", 120);*/
				jsre.put("data", jso);
				jsoncent.put("result", jsre);
	        //  String  content = "apiKey=" + URLEncoder.encode("08A1A1A8F6D94A86855E126FAACAA39A", "UTF-8");
	          //content +="&md5="+URLEncoder.encode("1913CD19BFCD2BBA", "UTF-8");;
	            out.print( URLEncoder.encode(jsoncent.toJSONString(), "UTF-8"));
	            // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
	           // out.write(content);
	            
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	           /* JSONObject json=JSONObject.parseObject(result);
	            JSONObject re= json.getJSONObject("result");
	            result=(String) re.get("accessToken");*/
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	      System.out.println(result);
    }  
}
