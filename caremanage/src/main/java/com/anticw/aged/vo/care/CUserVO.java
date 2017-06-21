/**   

* @Title: CuserVo.java 
* @Package com.anticw.aged.vo.care 
* @Description: TODO
* @author ltw   
* @date 2014年10月2日 下午5:30:18 
* @version V1.0   
*/
package com.anticw.aged.vo.care;

/** 
 * CareManager管理用户Vo
 * @ClassName: CuserVo 
 * @Description: TODO 
 * @author ltw
 * @date 2014年10月2日 下午5:30:18 
 *  
 */
public class CUserVO {
	private Integer id;
	private String groupName;
	private String name;
	private String password;
	private String streets;
	private String descr;
	private Boolean available;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStreets() {
		return streets;
	}
	public void setStreets(String streets) {
		this.streets = streets;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

}
