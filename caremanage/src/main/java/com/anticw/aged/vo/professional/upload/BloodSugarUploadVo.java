package com.anticw.aged.vo.professional.upload;

/**
 * 血糖数据管理
 * @author bsd
 *
 */
public class BloodSugarUploadVo  extends PublicDataUploadVo {
 
	/**
	 * 血糖为xxx类型为float，表示一个单精度浮点数字，单位为mmol(1mmol=18mg/dl)。
	 */
	private float bloodsugar;
	 
	public float getBloodsugar() {
		return bloodsugar;
	}
	public void setBloodsugar(float bloodsugar) {
		this.bloodsugar = bloodsugar;
	}

}
