package com.anticw.aged.vo.professional.activity;

import java.util.ArrayList;
import java.util.List;

public class NActivityPlanVO {

		 
		private Integer siteId;//站点
		
		private String weeks;//选中日期
		
		private Integer weeksId;//第几周

		private String  min; //时长

		private List<CourseVO> coursevo=new ArrayList<CourseVO>();
		

		public String getWeeks() {
			return weeks;
		}

		public void setWeeks(String weeks) {
			this.weeks = weeks;
		}

		
		public String getMin() {
			return min;
		}

		public void setMin(String min) {
			this.min = min;
		}

		public List<CourseVO> getCoursevo() {
			return coursevo;
		}

		public void setCoursevo(List<CourseVO> coursevo) {
			this.coursevo = coursevo;
		}

		

		public Integer getSiteId() {
			return siteId;
		}

		public void setSiteId(Integer siteId) {
			this.siteId = siteId;
		}

		public Integer getWeeksId() {
			return weeksId;
		}

		public void setWeeksId(Integer weeksId) {
			this.weeksId = weeksId;
		}

		@Override
		public String toString() {
			return "NActivityPlanVO [siteId=" + siteId + ", weeks=" + weeks
					+ ", weeksId=" + weeksId + ", min=" + min + ", coursevo="
					+ coursevo + "]";
		}

		
		
	
}
