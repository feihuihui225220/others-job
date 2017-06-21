package com.anticw.aged.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;

/*
 * 服务器线程处理类
 */
@Service
public class ServerThread extends Thread{

	private static Logger logger = LoggerFactory.getLogger(ServerThread.class);
	private ServerSocket serverSocket;
	public ServerThread() throws IOException {
		  serverSocket  = new ServerSocket(5858);
		  System.out.println("启动监听======");
	}
	 
	public void run() {
		try {
			handleSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ServerSocket getSocket(){
		return null;
	}
	
	public void handleSocket() throws IOException{
		while (true) {
			try {
				// 调用accept()方法开始监听，等待客户端的连接
				Socket socket = serverSocket.accept();
				// 启动线程
				new Thread(new Task(socket)).start();  
			} catch (IOException e) {
				logger.error("床垫线程出错"+e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
