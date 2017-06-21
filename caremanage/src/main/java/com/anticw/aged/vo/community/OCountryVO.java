/**
 * 
 */
package com.anticw.aged.vo.community;

/**
 * @author ltw
 * 
 */
public class OCountryVO {
	private Integer id;
	private String name;
	//private String fullName;
	private String type;
	private Integer parentId;
	private Boolean available;

	/**
	 * 
	 */
	public OCountryVO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}


}
