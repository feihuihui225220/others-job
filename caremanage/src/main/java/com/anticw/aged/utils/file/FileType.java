package com.anticw.aged.utils.file;


public enum FileType {
	pic("file/picture/"),
	att("file/attchment/");
	String dir;

	private FileType(String dir) {
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}
