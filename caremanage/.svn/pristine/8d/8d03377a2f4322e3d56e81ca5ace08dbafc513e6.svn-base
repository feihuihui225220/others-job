package com.anticw.aged;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.anticw.aged.bean.Bp;
import com.anticw.aged.bean.Measure;
import com.anticw.aged.bean.Patient;
import com.anticw.aged.bean.SimCase;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ClientTest {
	static String orgid = "68";
	static String auth = "c7b244fa9533b2ea";							//授权码
	static String patientId = "5700000019";										//
	//static final URI uri = UriBuilder.fromUri("http://www.hmgds.com/api").build();	//
	static final URI uri = UriBuilder.fromUri("http://114.251.187.71:8070/api").build();	//
	static final WebResource resource = Client.create().resource(uri);
	public static void main(String[] args) {
		Method method = new Method();
		//测试接口
		ClientTest.testInterface();
		//创建新患者
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		patient.setAge((short) 66);
		patient.setBirthday("1989-04-13");
		method.createOrupdatePatient(patient, patientId, orgid, auth, uri);
		
		
		SimCase simcase = new SimCase();
		simcase.setChd(true);
		simcase.setDm(false);
		simcase.setDrink((float)2.0);
		simcase.setDsLip(true);
		simcase.setHbp(true);
		SimCase.Family simfamily = new SimCase.Family();	//家族病
		simfamily.setAcs(true);
		simfamily.setDm(true);
		simfamily.setDsLip(true);
		simfamily.setHbp(true);
		simfamily.setStroke(false);
		simcase.setFamily(simfamily);		
		SimCase.Measure simmeasure = new SimCase.Measure();//体检检测值			
		simmeasure.setSbp((short)120);
		simmeasure.setDbp((short)70);
		simmeasure.setPulse((short)50);
		simmeasure.setFpg(67.0f);
		simmeasure.setHeight((short)154);
		simmeasure.setWeight((short)43);
		simcase.setMeasure(simmeasure);
		simcase.setSmoke(true);
		simcase.setStroke(true);
		simcase.setStrokeHm(true);
		simcase.setStrokeIs(true);
		simcase.setTia(true);
		simcase.setYearsAcs(0.08f);
		simcase.setYearsCaRc(0.33f);
		simcase.setYearsStroke(0.0f);
		simcase.setYearsStrokeLoc(5.0f);
		method.createSimCase(simcase, "2016-05-04",patientId, orgid, auth, uri);
		// 接口“6.4.创建一条随访记录”
		Measure data = new Measure(); // 体检检测值
		data.setHeight((short) 160);
		data.setWeight((short) 64);
		data.setWaist((short) 75);
		data.setHip((short) 85);
		data.setPulse((short) 90);
		data.setSbp((short) 168);
		data.setDbp((short) 92);
		data.setHbA1c(2f);
		data.setFpg(9.3f);
		data.setOgtt(3f);
		data.setTc(5.68f);
		data.setLdlc(4.06f);
		data.setHdlc(0.97f);
		data.setTg(1.43f);
		Bp bp = new Bp();
		bp.setMeasuretime("2016-05-16 22:40");
		bp.setSbp((short) 91);
		bp.setDbp((short) 60);
		bp.setPulse((short) 60);
		method.createFollowCase(data, "2016-04-30",patientId, orgid, auth, uri);
		method.getBpDayReport("2016-04-30", patientId, orgid, auth, uri);
		method.getSummary(patientId, orgid, auth, uri); 
		/*//接口“7.1.获得患者的病情汇总”
		//接口“7.3.获得患者的病情概要”
		method.getOutline(patientId, orgid, auth, uri); 
		//接口“7.5.获得患者的正常、治疗目标和药物启动值”
		method.getStandard(patientId, orgid, auth, uri); 
		//接口“7.4.获得患者的病情及治疗要点”
*/	//	method.getKeypoint(patientId, orgid, auth, uri);
		// 接口“7.6.获得患者的病情分析”
		/*method.getAnalysis(patientId, orgid, auth, uri);

		// 接口“7.7.获得患者的推荐治疗方案”
		method.getTreatment(patientId, orgid, auth, uri);
		// 接口“7.8.获得患者的临床问题”
		method.getProblems(patientId, orgid, auth, uri);
		// 接口“7.9.获得患者的风险分析”
		method.getRisk(patientId, orgid, auth, uri);
		method.createBp(bp, patientId, orgid, auth, uri);
		
		// 接口“7.13.根据患者最近一次诊疗制定随访规划”
		method.makeFollowPlan("2016-04-30",patientId, orgid, auth, uri);
		// 接口“7.5.获得患者的正常、治疗目标和药物启动值”
		method.getFollowPlan(patientId, orgid, auth, uri);
		// 接口“7.14.获得患者最近的随访规划”
		method.getNextFollow(patientId, orgid, auth, uri);
		// 接口“7.15.获得WORD版分析报告”
		// 接口“8.2.自测血压即时分析报告”（前提是周内必须有自测数据）
		method.getBpInstantReport(patientId, orgid, auth, uri);
		// 接口“8.3.自测血压周期分析报告”（前提是指定日期之前的一月内至少有15天的自测数据）
			method.getBpMonthReport("2016-05-15", patientId, orgid, auth, uri); 
	
		// 接口“8.3.自测血压周期分析报告”（前提是指定日期之前的一周内至少有4天的自测数据）
		method.getBpWeekReport("2016-05-10", patientId, orgid, auth, uri);
		// 接口“8.3.自测血压周期分析报告”（前提是指定日期必须有自测数据）
*/	//	System.out.println("=======================");
		// 获得WORD版分析报告{有错}
	//	method.getReportOfWord("84",patientId, orgid, auth, uri);
		// 接口“7.16.数字查房”{有错}
		/*//可能是没有签约医生导致错误
		method.getWardround(patientId, orgid, auth, uri);

		// 接口“7.10.获得患者10年风险比较”{有错}
		method.getRisktenyears( patientId, orgid, auth, uri);
		// 接口“7.11.获得规范化治疗、不治疗及同龄人最低风险”{有错}
		method.getRiskownpeer( patientId, orgid, auth, uri);
	*/
		
		
		//==========================================
		//以下接口调用失败
		// 接口“8.1.自测血压采集”
		/*Bp bp = new Bp();
		bp.setMeasuretime("2016-04-12 22:40");
		bp.setSbp((short) 91);
		bp.setDbp((short) 60);
		bp.setPulse((short) 60);
		method.getBpDayReport("2016-04-26", patientId, orgid, auth, uri);
		*/
		/*ClientResponse response = resource
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
			System.out.println("自测血压采集,接口调用失败，返回状态码是：" + status);*/
		
		
		
		
	}
	//测试接口
	public static void testInterface(){
		WebResource resource = Client.create().resource(uri);
		ClientResponse response = resource.get(ClientResponse.class);
		int status = response.getStatus();
		if (status == 200)
			System.out.println("GDS心跳正常。");
		else
			System.out.println("GDS心跳异常，需要重启。");
	}
  
  

}
