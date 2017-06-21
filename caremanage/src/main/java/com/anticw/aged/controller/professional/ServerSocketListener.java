package com.anticw.aged.controller.professional;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.anticw.aged.utils.ServerThread;

public class ServerSocketListener implements ServletContextListener {
	
	 
    /**
     * 初始化当Servlet容器启动Web应用时调用该方法
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	   ServerThread socketThread;
		try {
			socketThread = new ServerThread();
			socketThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          // socketThread.getSocket();
           System.out.println("socket端口启动======");
    }


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}