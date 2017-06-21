package com.anticw.aged.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

import cn.emay.sdk.service.SMSService;

import com.alibaba.fastjson.JSONObject;
import com.anticw.aged.bean.OMessage;
import com.anticw.aged.bean.mongo.IntelligentMattress;
import com.anticw.aged.dao.professional.service.OrderDao;
import com.anticw.aged.pool.SpringDataPool;
import com.anticw.aged.service.message.OMessageService;
import com.anticw.aged.service.professional.data.base.IntelligentMattressService;

public class Task implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(Task.class);
	private Socket socket;
	private static IntelligentMattressService intelligentMattressService = SpringContextHolder
			.getBean("intelligentMattressService", IntelligentMattressService.class);

	private final SpringDataPool springDataPool = (SpringDataPool) ContextLoader.getCurrentWebApplicationContext()
			.getBean("springDataPool");
	private final OrderDao orderDao = (OrderDao) ContextLoader.getCurrentWebApplicationContext().getBean("orderDao");
	private final SMSService sMSService = (SMSService) ContextLoader.getCurrentWebApplicationContext()
			.getBean("sMSService");
	private final OMessageService oMessageService = (OMessageService) ContextLoader.getCurrentWebApplicationContext()
			.getBean("oMessageService");

	/**
	 * 构造函数
	 */
	public Task(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求
	public void run() {

		InputStream is = null;
		// InputStreamReader isr = null;
		DataInputStream dis = null;
		try {
			socket.setSoTimeout(3 * 1000);
			// 获取输入流，并读取客户端信息
			is = socket.getInputStream();
			// isr = new InputStreamReader(is);
			dis = new DataInputStream(is);
			Byte info = null;
			int i = 1;
			byte[] b1 = new byte[68];
			byte[] b2 = new byte[69];

			if (dis != null) {
				while ((info = (byte) dis.readByte()) != null) {// 循环读取客户端的信息
					if (i < 69) {
						b1[i - 1] = info;
					}
					if (i < 70) {
						b2[i - 1] = info;
					} else if (i >= 70) {
						break;
					}
					byte[] b3 = null;
					if (i >= 68 && (b1[67] == 2 | b2[68] == 2)) {
						if (b1[67] == 2) {
							b3 = Arrays.copyOf(b1, 68);
						} else {
							b3 = Arrays.copyOf(b2, 69);
						}
						IntelligentMattress in = AnalysisBed.getMMattress(b3);
						if (in != null) {
							try {
								Date d = new Date();
								in.setDeviceId(in.getSn());
								in.setUploadTime(d);
								try {
									this.springDataPool.saveHeartbeat(in.getSn());
									Object[] arrayO = null;
									if (this.springDataPool.getUsers(in.getSn()) != null) {
										arrayO = this.springDataPool.getUsers(in.getSn());
									//	logger.info(Arrays.toString(arrayO) + "缓存中的数据**********");
									} else {
										arrayO = this.orderDao.getUserId(in.getSn());
										this.springDataPool.saveUsers(in.getSn(), arrayO);
									}
									if (arrayO != null && arrayO[3] != null && arrayO[3] != "") {
										OMessage o = new OMessage();
										o.setComeFrom(1);
										o.setPhone(arrayO[3].toString());
										o.setCreatedTime(d);
										// 心跳骤停 获取对应的用户紧急联系人信息 短信提醒
										if (!in.getState().equals("off") && in.getBreath() == 0) {
											this.springDataPool.saveBreatheMap(in.getSn());
											sMSService.sendSmartDevice(arrayO[3].toString(), arrayO[0].toString(),
													"60秒内未检测到心跳数据，请关注。”");
											o.setContent(arrayO[0].toString() + "60秒内未检测到心跳数据，请关注。”");
											oMessageService.insertOMessage(o);
										}
										// 呼吸异常 获取紧急联系人信息 报警
										if (!in.getState().equals("off") && in.getHeartbeat() == 0) {
											this.springDataPool.saveHeartbeat(in.getSn());
											sMSService.sendSmartDevice(arrayO[3].toString(), arrayO[0].toString(),
													"呼吸60秒内未检测到，请关注。");
											o.setContent(arrayO[0].toString() + "呼吸60秒内未检测到，请关注。”");
											oMessageService.insertOMessage(o);
										}
										if (this.springDataPool.getBreatheMap(in.getSn()) != null
												&& !in.getState().equals("off") && in.getBreath() != 0) {
											this.springDataPool.removeBreatheMap(in.getSn());
										}

										if (this.springDataPool.getHeartbeat(in.getSn()) != null
												&& !in.getState().equals("off") && in.getBreath() != 0) {
											this.springDataPool.removeHeartbeat(in.getSn());
										}
										// 离床时间过长报警
										int date_ = Integer
												.parseInt(DateUtil.parseDateToString(d, DateUtil.TIME_MIN_FORMAT_));
										if (date_ >= 22 && date_ <= 5) {
											// 如果上床时间为空并且状态为在床 则添加一条上床时间
											if (!in.getState().equals("off")
													&& this.springDataPool.getFallAsleep(in.getSn()) == null) {
												this.springDataPool.saveFallAsleep(in.getSn(), d);
											}
											// 如果状态为在床 并且离床时间不为空
											if (!in.getState().equals("off")
													&& this.springDataPool.getAmbulationTime(in.getSn()) != null) {
												this.springDataPool.removeAmbulationTime(in.getSn());// 删除离床时间状态
											}
											// 如果为离床状态 并且离床时间为空 并且上床时间不为空
											// //获取离床时间 ////获取上床时间
											if (in.getState().equals("off")
													&& this.springDataPool.getAmbulationTime(in.getSn()) == null
													&& this.springDataPool.getFallAsleep(in.getSn()) != null) {
												Date d_ = this.springDataPool.getFallAsleep(in.getSn());// 获取上床时间
												// 如果上床时间超过一小时则为睡眠状态
												Float time_ = (float) (d.getTime() - d_.getTime());
												time_ = (time_ / 3600000F);
												if (time_ >= 1) {
													this.springDataPool.saveAmbulationTime(in.getSn(), d);// 添加离床时间
												} else {
													this.springDataPool.removeFallAsleep(in.getSn());// 删除上床时间
												}
											}
											// 报警 如果离床时间不为空 并且离床超过0.5小时 则发送短信
											Date times = this.springDataPool.getAmbulationTime(in.getSn());
											Float time = null;
											if (times != null) {
												time = Float.valueOf(
														this.springDataPool.getAmbulationTime(in.getSn()).getTime());
												time = (time / 1800000F);
											}
											if (times != null && time >= 0.5 && in.getState().equals("off")) {
												// 是否已报警
												if (this.springDataPool.getFallAsleep(in.getSn()) != null
														&& this.springDataPool.getAmbulation(in.getSn()) == null) {// 是否已报警
																													// 离床时长
													this.springDataPool.saveAmbulation(in.getSn(), in.getSn());
													sMSService.sendSmartDevice(arrayO[3].toString(),
															arrayO[0].toString(), "离床超过30分钟，请多关注。");
													o.setContent(arrayO[0].toString() + "离床超过30分钟，请多关注。”");
													oMessageService.insertOMessage(o);
												}
											}
										}
										// 如果老人在发出警报后再次回到床上 清空对应的
										if (!in.getState().equals("off")
												&& this.springDataPool.getAmbulation(in.getSn()) != null) {
											this.springDataPool.removeAmbulation(in.getSn());
										}

									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								JSONObject json=new JSONObject();
								if (this.springDataPool.getIntelligentMattress(in.getSn()) != null) {
									IntelligentMattress in_ = this.springDataPool.getIntelligentMattress(in.getSn());
									json.put("缓存",in_);
									json.put("解析",in);
									//logger.info(json.toJSONString()+"两次数据比较*********************");
									if (in.getBreath().equals(in_.getBreath())
											&& in.getHeartbeat().equals(in_.getHeartbeat())
											&& in.getState().equals(in_.getState())) {
										
									} else {
										intelligentMattressService.save(in);
										this.springDataPool.saveIntelligentMattressMap(in);
									}
								} else {
									json.put("解析",in);
									//logger.info(json.toJSONString()+"添加的数据*********************");
									intelligentMattressService.save(in);
									this.springDataPool.saveIntelligentMattressMap(in);
								}
								break;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								logger.error("添加床垫信息出错！");
								e.printStackTrace();
							}
						}
					}
					i++;
				}
			}

			socket.shutdownInput();// 关闭输入流
			// 获取输出流，响应客户端的请求

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("解析信息出错！");
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				/*
				 * if (isr != null) isr.close();
				 */
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
