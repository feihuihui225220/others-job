package com.anticw.aged.vo.icare;

import java.util.HashSet;
import java.util.Set;

/**
 * 浏览量
 * @author DX 
 *
 */
public class PageViewVO {

	Set<String> ip=new HashSet<String>();

	public Set<String> getIp() {
		return ip;
	}

	public void setIp(Set<String> ip) {
		this.ip = ip;
	}
	
}
