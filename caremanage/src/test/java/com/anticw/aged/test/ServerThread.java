package com.anticw.aged.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

import com.anticw.agedq.bed.MsgpackTest;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//线程执行的操作，响应客户端的请求
	public void run(){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			//获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			DataInputStream dis = new DataInputStream(is);
			byte[] b=new byte[1024];
			Byte info=null;
			int i=1;
			//System.out.println(dis.readUTF());
			byte[] b1=new byte[69];
			if(dis!=null){
				while((info=(byte) dis.readByte())!=null){//循环读取客户端的信息
					b1[i-1]=info;
					System.out.print(info+"--");
					if(i%68==0){
						System.out.println(Arrays.toString(b1));
						///System.out.println(Arrays.toString(content));
						MsgpackTest.getMMattress(b1);
						break;
					}
					i++;
					
				}
				
				
			}
			
			socket.shutdownInput();//关闭输入流
			//获取输出流，响应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您！"+ socket.getInetAddress());
			pw.flush();//调用flush()方法将缓冲输出
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(pw!=null)
					pw.close();
				if(os!=null)
					os.close();
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(is!=null)
					is.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
