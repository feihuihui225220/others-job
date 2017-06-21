package com.anticw.aged.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket = null;
			long starTime=System.currentTimeMillis();
			for (int i = 0; i < 160000; i++) {
				socket = new Socket("localhost", 8081);
				//2.获取输出流，向服务器端发送信息
				OutputStream os=socket.getOutputStream();//字节输出流
				PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
				pw.write("我是客户端"+i);
				pw.flush();
				socket.shutdownOutput();//关闭输出流
				//3.获取输入流，并读取服务器端的响应信息
				InputStream is=socket.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(is));
				String info=null;
				long endTime=System.currentTimeMillis();
				long Time=endTime-starTime;
				while((info=br.readLine())!=null){
					System.out.print("我是客户端"+(i+1)+"，服务器说："+info);
				}
				System.out.println(":消耗时间:"+Time+"毫秒");
				//4.关闭资源
				br.close();
				is.close();
				pw.close();
				os.close();
				socket.close();
			}
			long endTime=System.currentTimeMillis();
			 long Time=endTime-starTime;
			 System.out.println(Time);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
