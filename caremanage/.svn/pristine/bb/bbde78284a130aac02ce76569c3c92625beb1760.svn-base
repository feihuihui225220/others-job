package com.anticw.agedq.bed;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(5858);
		System.out.println(ss.isBound()+ss.toString());
		while(true) {
			Socket s = ss.accept();
			System.out.println("a client connect!");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
		
	}
}
