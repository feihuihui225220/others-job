package com.anticw.aged.vo.icare;

import java.util.ArrayList;
import java.util.List;

import com.anticw.aged.bean.ZFitness;

public class ZFitnessVO {

	private Integer FId;
	private String FName;
	private Integer parentId;
	private String imgUrl;
	private String videoUrl;
	private String monad;
	private List<ZFitness> childZFitness=new ArrayList<ZFitness>();
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer fId) {
		FId = fId;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getMonad() {
		return monad;
	}
	public void setMonad(String monad) {
		this.monad = monad;
	}
	public List<ZFitness> getChildZFitness() {
		return childZFitness;
	}
	public void setChildZFitness(List<ZFitness> childZFitness) {
		this.childZFitness = childZFitness;
	}
	
}
