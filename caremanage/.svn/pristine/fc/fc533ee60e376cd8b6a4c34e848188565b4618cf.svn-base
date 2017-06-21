package com.anticw.aged;

import java.io.FileOutputStream;
import java.net.URI;

import javax.ws.rs.core.MultivaluedMap;

import com.anticw.aged.bean.Bp;
import com.anticw.aged.bean.BpInstantReport;
import com.anticw.aged.bean.Case;
import com.anticw.aged.bean.Measure;
import com.anticw.aged.bean.Patient;
import com.anticw.aged.bean.Risktenyears;
import com.anticw.aged.bean.SimCase;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 作者：bsd 日期：2016-5-4 功能：TODO
 */
public class Method {
	
	

	public void createBp(Bp bp,String patientId,String orgid,String auth,URI uri ) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource
				.path("bp")
				.path("patients") // 固定的路径参数
				.path(patientId) // 病历号作为路径参数
				.path("input")
				.header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.post(ClientResponse.class, bp);
		
		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) {
			System.out.println("成功创建了一条连续血压数据。");
		} else
			System.out.println("自测血压采集,接口调用失败，返回状态码是：" + status);
	}

	public void getBpInstantReport(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		
		ClientResponse response = resource
				.path("bp")			
				.path("patients")			
				.path(patientId)						//假定患者病历号为"1000032357"
				.path("instant")			
				.header("orgid", orgid)						//假定根单位编码为"0"
				.header("auth", auth)		//假定授权码为"0000000000000000"
				.get(ClientResponse.class); 				//---------------------------------- ①


		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			BpInstantReport entity = response.getEntity(BpInstantReport.class); //--------  ②
			System.out.println(entity.toString());
		} else
			System.out.println("自测血压即时分析报告,接口调用失败，返回状态码是：" + status);
	}

	public void getBpDayReport(String today,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("period", "day");
		params.add("today", today);

		ClientResponse response = resource.path("bp").path("patients")
				.path(patientId).path("report").queryParams(params)
				.header("orgid", orgid).header("auth", auth)
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("自测血压周期分析报告,接口调用失败，返回状态码是：" + status);
	}

	public void getBpWeekReport(String today,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("period", "week");
		params.add("today", today);

		ClientResponse response = resource.path("bp").path("patients")
				.path(patientId).path("report").queryParams(params)
				.header("orgid", orgid).header("auth", auth)
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("自测血压周期分析报告,接口调用失败，返回状态码是：" + status);
	}

	public void getBpMonthReport(String today,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("period", "month");
		params.add("today", today);

		ClientResponse response = resource.path("bp").path("patients")
				.path(patientId).path("report").queryParams(params)
				.header("orgid", orgid).header("auth", auth)
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("自测血压周期分析报告,接口调用失败，返回状态码是：" + status);
	}

	public void getWardround(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("contractdoctor", "lihai"); // 签约医生登录名
		params.add("fromdate", "2016-04-19");

		ClientResponse response = resource.path("wardround")
				.header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("接口调用失败(签约医生)，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得WORD版分析报告
	public void getReportOfWord(String type,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("type", type);

		ClientResponse response = resource.path("patients").path(patientId)
				.path("docx").queryParams(params).header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			byte bytes[] = response.getEntity(byte[].class);
			FileOutputStream out = null;
			try {
				out = new FileOutputStream("D:\\report.docx");
				out.write(bytes);
				out.flush();
				out.close();
				System.out.println("已经将分析报告下载到D盘根目录下report.docx里了。");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("分析报告接口调用失败,无法生成docx文件，返回状态码是：" + status);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////
	// 创建一个新患者（客户端提供病历号）或. 修改一个已有的患者（如果patientId制定的患者已经存在）
	public void createOrupdatePatient(Patient patient,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients") // 固定的路径参数
				.path(patientId) // 病历号作为路径参数
				.header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.put(ClientResponse.class, patient); // 患者信息作为PUT请求参数

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200)
			System.out.println("成功创建或修改了病历号为" + patientId + "的患者。");
		else
			System.out.println("接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 为指定的病人创建一个新的诊疗记录
	// 如果未指定就诊日期，默认就是今天的日期。
	public void createCase(Case acase, String curdate,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("date", curdate);

		ClientResponse response = resource.path("patients").path(patientId)
				.path("cases").queryParams(params).header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.post(ClientResponse.class, acase);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String caseSn = response.getEntity(String.class); // 读取诊次序号
			System.out.println("已经为患者" + patientId + "创建了一条诊疗记录，返回的诊次序号为："
					+ caseSn);
		} else
			System.out.println("接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 为指定的病人创建一个新的诊疗记录
	// 如果未指定就诊日期，默认就是今天的日期。
	public void createSimCase(SimCase acase, String curdate,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("date", curdate);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("simcases").queryParams(params).header("orgid", orgid)
				.header("auth", auth).post(ClientResponse.class, acase);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String caseSn = response.getEntity(String.class);
			System.out.println("已经为患者" + patientId + "创建了一条诊疗记录，返回的诊次序号为："
					+ caseSn);
		} else
			System.out.println("创建简易就诊记录失败，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 为指定的病人创建一个新的诊疗记录
	// 如果未指定就诊日期，默认就是今天的日期。
	public void createFollowCase(Measure data, String curdate,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("date", curdate);

		ClientResponse response = resource.path("patients").path(patientId)
				.path("cases").path("measure").queryParams(params)
				.header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.post(ClientResponse.class, data);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String caseSn = response.getEntity(String.class); // 读取诊次序号
			System.out.println("已经为患者" + patientId + "创建了一条随访记录，返回的诊次序号为："
					+ caseSn);
		} else
			System.out.println("创建随访记录失败，接口调用失败，返回状态码是：" + status);
	}

	public void getOutline(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("outline").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得患者当前的病情汇总
	public void getSummary(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("summary").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			com.alibaba.fastjson.JSONObject js=com.alibaba.fastjson.JSONObject.parseObject(entity);
			System.out.println(js.get("text").toString());
		} else
			System.out.println("接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	public void getKeypoint(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("keypoint").queryParam("mime", "html")
				.header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的病情及治疗要点失败，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	public void getRisktenyears(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		/*ClientResponse response = resource.path("patients").path(patientId)
				.path("risktenyears").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);*/
		ClientResponse response = resource
	       		.path("patients")
				.path(patientId)					//假定患者病历号为"1000032357"
				.path("risktenyears")
				.header("orgid", orgid)				//假定根单位编码为"0"
				.header("auth", auth)	//假定授权码为"0000000000000000"
				.get(ClientResponse.class);		
		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			Risktenyears  entity = response.getEntity(Risktenyears .class);
			System.out.println(entity);
		} else
			System.out.println("获得患者10年风险比较(risktenyears)，接口调用失败，返回状态码是：" + status);
	}

	public void getRiskownpeer(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("riskownpeer").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String json = response.getEntity(String.class);
			System.out.println(json);
		} else
			System.out.println("获得规范化治疗、不治疗及同龄人最低风险，接口调用失败，返回状态码是(riskownpeer)：" + status);
	}

	// =====================================================================================
	public void getStandard(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("standard").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码

		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的正常、治疗目标和药物启动值，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得患者当前的简化的病情分析
	public void getAnalysis(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("analysis").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的病情分析，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得患者最后一次就诊的治疗方案
	public void getTreatment(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("treatment").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的推荐治疗方案。接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得患者当前的临床问题
	public void getProblems(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("problems").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功 {
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的临床问题，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得的风险评估
	public void getRisk(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("risk").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的风险分析，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 根据患者的最新病情生成随访规划
	// 参数makeDate是规划日期
	// =====================================================================================
	public void makeFollowPlan(String makeDate,String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("makeDate", makeDate);
		params.add("newBp", "false");

		ClientResponse response = resource.path("patients").path(patientId)
				.path("followplan").queryParams(params).header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.post(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码
		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("根据患者最近一次诊疗制定随访规划，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 根据患者的最新病情生成随访规划
	public void getFollowPlan(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("followplan").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码

		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("获得患者的正常、治疗目标和药物启动值，接口调用失败，返回状态码是：" + status);
	}

	// =====================================================================================
	// 获得患者下一次随访信息
	public void getNextFollow(String patientId,String orgid,String auth,URI uri) {
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.path("patients").path(patientId)
				.path("follow").header("orgid", orgid) // 单位标识作为头信息
				.header("auth", auth) // 授权码作为头信息
				.accept("application/json") // 接口返回JSON字符串。如果希望返回XML字符串或对象，参见《GDS
											// WEB SERVICES接口手册》
				.get(ClientResponse.class);

		int status = response.getStatus(); // 获得应答的状态码

		if (status == 200) { // 如果执行成功
			String entity = response.getEntity(String.class);
			System.out.println(entity);
		} else
			System.out.println("接口调用失败，返回状态码是：" + status);
	}
}
