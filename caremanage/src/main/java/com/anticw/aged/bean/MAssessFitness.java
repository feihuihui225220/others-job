package com.anticw.aged.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "m_assess_fitness")
public class MAssessFitness implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer sex;
	private Integer age;
	private String name;
	
	private Integer result1;
	private Integer result2;
	private Double result3;
	private Double result4;
	private Double result5;
	private Double result6;
	private Double result7;
	private Double result8;
	private Double result9;
	private Double result10;
	private Double result11;
	private Double result12;
	private Double result13;
	
	private String grade1;
	private String grade2;
	private String grade3;
	private String grade4;
	private String grade5;
	private String grade6;
	private String grade7;
	private String grade8;
	private String grade9;
	private String grade10;
	private String grade11;
	private String grade12;
	private String grade13;
	
	private String advice1;
	private String advice2;
	private String advice3;
	private String advice4;
	private String advice5;
	private String advice6;
	private String advice7;
	private String advice8;
	private String advice9;
	private String advice10;
	private String advice11;
	private String advice12;
	private String advice13;
	
	private Date create_time;
	private String create_by;
	private String change_by;
	
	private RUser user;
	// Constructors

		/** default constructor */
		public MAssessFitness() {
		}
		
		/** full constructor */
		public MAssessFitness(Integer id, Integer sex, Integer age,String name,RUser user,
				Integer result1,Integer result2,Double result3,Double result4,Double result5,Double result6,Double result7,Double result8,Double result9,Double result10,Double result11,Double result12,Double result13, 
				String grade1,String grade2,String grade3,String grade4,String grade5,String grade6,String grade7, String grade8,String grade9,String grade10,String grade11,String grade12,String grade13,
				String advice1,String advice2,String advice3,String advice4,String advice5,String advice6,String advice7,String advice8,String advice9,String advice10,String advice11,String advice12,String advice13,
				Date create_time,String create_by,String change_by) 
		{
			super();
			this.user = user;
			this.id =id;
			this.sex = sex;
			this.age = age;
			this.name =name;
			this.result1 = result1;
			this.result2 = result2;
			this.result3 = result3;
			this.result4 = result4;
			this.result5 = result5;
			this.result6 = result6;
			this.result7 = result7;
			this.result8 = result8;
			this.setResult9(result9);
			this.setResult10(result10);
			this.setResult11(result11);
			this.setResult12(result12);
			this.setResult13(result13);
			
			this.grade1 = grade1;
			this.grade2 = grade2;
			this.grade3 = grade3;
			this.grade4 = grade4;
			this.grade5 = grade5;
			this.grade6 = grade6;
			this.grade7 = grade7;
			this.grade8 = grade8;
			this.setGrade9(grade9);
			this.setGrade10(grade10);
			this.setGrade11(grade11);
			this.setGrade12(grade12);
			this.setGrade13(grade13);
			
			this.advice1 = advice1;
			this.advice2 = advice2;
			this.advice3 = advice3;
			this.advice4 = advice4;
			this.advice5 = advice5;
			this.advice6 = advice6;
			this.advice7 = advice7;
			this.advice8 = advice8;
			this.setAdvice9(advice9);
			this.setAdvice10(advice10);
			this.setAdvice11(advice11);
			this.setAdvice12(advice12);
			this.setAdvice13(advice13);
			
			this.create_time = create_time;
			this.create_by = create_by;
			this.change_by = change_by;
		}

		// Property accessors
		@Id
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		/*@Column(name = "user_id")
		public Long getUserId() {
			return this.userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}*/

		@Column(name = "sex")
		public Integer getSex() {
			return this.sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		@Column(name = "age")
		public Integer getAge() {
			return this.age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
		@Column(name = "user_name")
		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}
//		---------------输入框内容-------------------
		
		@Column(name = "result_1")
		public Integer getResultOne() {
			return this.result1;
		}

		public void setResultOne(Integer result1) {
			this.result1 = result1;
		}
		
		@Column(name = "result_2")
		public Integer getResultTwo() {
			return this.result2;
		}

		public void setResultTwo(Integer result2) {
			this.result2 = result2;
		}
		
		@Column(name = "result_3")
		public Double getResultThree() {
			return this.result3;
		}

		public void setResultThree(Double result3) {
			this.result3 = result3;
		}
		
		@Column(name = "result_4")
		public Double getResultFour() {
			return this.result4;
		}

		public void setResultFour(Double result4) {
			this.result4 = result4;
		}
		
		@Column(name = "result_5")
		public Double getResultFive() {
			return this.result5;
		}

		public void setResultFive(Double result5) {
			this.result5= result5;
		}
		
		@Column(name = "result_6")
		public Double getResultSix() {
			return this.result6;
		}

		public void setResultSix(Double result6) {
			this.result6 = result6;
		}
		
		@Column(name = "result_7")
		public Double getResultSeven() {
			return this.result7;
		}

		public void setResultSeven(Double result7) {
			this.result7 = result7;
		}
		
		@Column(name = "result_8")
		public Double getResultEight() {
			return this.result8;
		}

		public void setResultEight(Double result8) {
			this.result8 = result8;
		}
		
//		------------------百分比等级-----------------
		@Column(name = "grade_1")
		public String getGradeOne() {
			return this.grade1;
		}

		public void setGradeOne(String grade1) {
			this.grade1 = grade1;
		}
		
		@Column(name = "grade_2")
		public String getGradeTwo() {
			return this.grade2;
		}

		public void setGradeTwo(String grade2) {
			this.grade2 = grade2;
		}
		
		@Column(name = "grade_3")
		public String getGradeThree() {
			return this.grade3;
		}

		public void setGradeThree(String grade3) {
			this.grade3 = grade3;
		}
		
		@Column(name = "grade_4")
		public String getGradeFour() {
			return this.grade4;
		}

		public void setGradeFour(String grade4) {
			this.grade4 = grade4;
		}
		
		@Column(name = "grade_5")
		public String getGradeFive() {
			return this.grade5;
		}

		public void setGradeFive(String grade5) {
			this.grade5 = grade5;
		}
		
		@Column(name = "grade_6")
		public String getGradeSix() {
			return this.grade6;
		}

		public void setGradeSix(String grade6) {
			this.grade6 = grade6;
		}
		
		@Column(name = "grade_7")
		public String getGradeSeven() {
			return this.grade7;
		}

		public void setGradeSeven(String grade7) {
			this.grade7 = grade7;
		}
		
		@Column(name = "grade_8")
		public String getGradeEight() {
			return this.grade8;
		}

		public void setGradeEight(String grade8) {
			this.grade8 = grade8;
		}
//      -----------------建议---------------------
		
		@Column(name = "advice_1")
		public String getAdviceOne() {
			return this.advice1;
		}

		public void setAdviceOne(String advice1) {
			this.advice1 = advice1;
		}
		
		@Column(name = "advice_2")
		public String getAdviceTwo() {
			return this.advice2;
		}

		public void setAdviceTwo(String advice2) {
			this.advice2 = advice2;
		}
		
		@Column(name = "advice_3")
		public String getAdviceThree() {
			return this.advice3;
		}

		public void setAdviceThree(String advice3) {
			this.advice3 = advice3;
		}
		
		@Column(name = "advice_4")
		public String getAdviceFour() {
			return this.advice4;
		}

		public void setAdviceFour(String advice4) {
			this.advice4 = advice4;
		}
		
		@Column(name = "advice_5")
		public String getAdviceFive() {
			return this.advice5;
		}

		public void setAdviceFive(String advice5) {
			this.advice5 = advice5;
		}
		
		@Column(name = "advice_6")
		public String getAdviceSix() {
			return this.advice6;
		}

		public void setAdviceSix(String advice6) {
			this.advice6 = advice6;
		}
		
		@Column(name = "advice_7")
		public String getAdviceSeven() {
			return this.advice7;
		}

		public void setAdviceSeven(String advice7) {
			this.advice7 = advice7;
		}
		
		@Column(name = "advice_8")
		public String getAdviceEight() {
			return this.advice8;
		}

		public void setAdviceEight(String advice8) {
			this.advice8 = advice8;
		}
//     ------------------创建时间--------------		
		@Column(name = "create_time", length = 19)
		public Date getCreateTime() {
			return this.create_time;
		}

		public void setCreateTime(Date create_time) {
			this.create_time = create_time;
		}
//     ------------创建者-------------		
		@Column(name = "create_by")
		public String getCreateBy() {
			return this.create_by;
		}

		public void setCreateBy(String create_by) {
			this.create_by = create_by;
		}
//		-----------修改人--------------
		@Column(name = "change_by")
		public String getChangeBy() {
			return this.change_by;
		}
		public void setChangeBy(String change_by) {
			this.change_by = change_by;
		}
//      ------------------用户信息表-----------------
		/**
		 * @return the user
		 */
		
		@ManyToOne(optional=true)
		@JoinColumn(name="user_id")
		public RUser getUser() {
			return user;
		}

		public void setUser(RUser user) {
			this.user = user;
		}
//======================================================================
		@Column(name = "result_9")
		public Double getResult9() {
			return result9;
		}

		public void setResult9(Double result9) {
			this.result9 = result9;
		}
		@Column(name = "result_10")
		public Double getResult10() {
			return result10;
		}

		public void setResult10(Double result10) {
			this.result10 = result10;
		}
		@Column(name = "result_11")
		public Double getResult11() {
			return result11;
		}

		public void setResult11(Double result11) {
			this.result11 = result11;
		}
		@Column(name = "result_12")
		public Double getResult12() {
			return result12;
		}

		public void setResult12(Double result12) {
			this.result12 = result12;
		}
		@Column(name = "result_13")
		public Double getResult13() {
			return result13;
		}

		public void setResult13(Double result13) {
			this.result13 = result13;
		}
		@Column(name = "grade_9")
		public String getGrade9() {
			return grade9;
		}

		public void setGrade9(String grade9) {
			this.grade9 = grade9;
		}
		@Column(name = "grade_10")
		public String getGrade10() {
			return grade10;
		}

		public void setGrade10(String grade10) {
			this.grade10 = grade10;
		}
		@Column(name = "grade_11")
		public String getGrade11() {
			return grade11;
		}

		public void setGrade11(String grade11) {
			this.grade11 = grade11;
		}
		@Column(name = "grade_12")
		public String getGrade12() {
			return grade12;
		}

		public void setGrade12(String grade12) {
			this.grade12 = grade12;
		}
		@Column(name = "grade_13")
		public String getGrade13() {
			return grade13;
		}

		public void setGrade13(String grade13) {
			this.grade13 = grade13;
		}
		@Column(name = "advice_9")
		public String getAdvice9() {
			return advice9;
		}

		public void setAdvice9(String advice9) {
			this.advice9 = advice9;
		}
		@Column(name = "advice_10")
		public String getAdvice10() {
			return advice10;
		}

		public void setAdvice10(String advice10) {
			this.advice10 = advice10;
		}
		@Column(name = "advice_11")
		public String getAdvice11() {
			return advice11;
		}

		public void setAdvice11(String advice11) {
			this.advice11 = advice11;
		}
		@Column(name = "advice_12")
		public String getAdvice12() {
			return advice12;
		}

		public void setAdvice12(String advice12) {
			this.advice12 = advice12;
		}
		@Column(name = "advice_13")
		public String getAdvice13() {
			return advice13;
		}

		public void setAdvice13(String advice13) {
			this.advice13 = advice13;
		}
		
}
