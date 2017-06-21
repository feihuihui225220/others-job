package com.anticw.aged.vo.icare;

/**
 * <p>微信调用接口vo类 实体类增加类型name</p>
 * @author DX  2016/12/20
 *
 */
public class ZAssessVO {

	private Integer id;
	private Integer version;
	private Integer title;//对应o_category_item中category_id=124的Id
	private String content;
	private String coverUrl;
	private String bgUrl;
	private String course;
	private Integer assessId;
	private Integer pageview;
	private Integer assessCount;
	private Integer sort;
	private String ItemName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getBgUrl() {
		return bgUrl;
	}
	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getAssessId() {
		return assessId;
	}
	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}
	public Integer getPageview() {
		return pageview;
	}
	public void setPageview(Integer pageview) {
		this.pageview = pageview;
	}
	public Integer getAssessCount() {
		return assessCount;
	}
	public void setAssessCount(Integer assessCount) {
		this.assessCount = assessCount;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	
	
}
