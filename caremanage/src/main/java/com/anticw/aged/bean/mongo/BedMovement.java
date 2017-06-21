package com.anticw.aged.bean.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 台湾床垫动作数据表
 * @author L
 *
 */
@Document(collection="m_bedMovement")
public class BedMovement extends MetaData {
	
	private String m_01;
	private String m_02;
	private String m_03;
	private String m_04;
	private String m_05;
	private String m_06;
	private String m_07;
	private String m_08;
	private String atitle;
	/**
	 * @return the m_01
	 */
	public String getM_01() {
		return m_01;
	}
	/**
	 * @param m_01 the m_01 to set
	 */
	public void setM_01(String m_01) {
		this.m_01 = m_01;
	}
	/**
	 * @return the m_02
	 */
	public String getM_02() {
		return m_02;
	}
	/**
	 * @param m_02 the m_02 to set
	 */
	public void setM_02(String m_02) {
		this.m_02 = m_02;
	}
	/**
	 * @return the m_03
	 */
	public String getM_03() {
		return m_03;
	}
	/**
	 * @param m_03 the m_03 to set
	 */
	public void setM_03(String m_03) {
		this.m_03 = m_03;
	}
	/**
	 * @return the m_04
	 */
	public String getM_04() {
		return m_04;
	}
	/**
	 * @param m_04 the m_04 to set
	 */
	public void setM_04(String m_04) {
		this.m_04 = m_04;
	}
	/**
	 * @return the m_05
	 */
	public String getM_05() {
		return m_05;
	}
	/**
	 * @param m_05 the m_05 to set
	 */
	public void setM_05(String m_05) {
		this.m_05 = m_05;
	}
	/**
	 * @return the m_06
	 */
	public String getM_06() {
		return m_06;
	}
	/**
	 * @param m_06 the m_06 to set
	 */
	public void setM_06(String m_06) {
		this.m_06 = m_06;
	}
	/**
	 * @return the m_07
	 */
	public String getM_07() {
		return m_07;
	}
	/**
	 * @param m_07 the m_07 to set
	 */
	public void setM_07(String m_07) {
		this.m_07 = m_07;
	}
	/**
	 * @return the m_08
	 */
	public String getM_08() {
		return m_08;
	}
	/**
	 * @param m_08 the m_08 to set
	 */
	public void setM_08(String m_08) {
		this.m_08 = m_08;
	}
	/**
	 * @return the atitle
	 */
	public String getAtitle() {
		return atitle;
	}
	/**
	 * @param atitle the atitle to set
	 */
	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}
}
