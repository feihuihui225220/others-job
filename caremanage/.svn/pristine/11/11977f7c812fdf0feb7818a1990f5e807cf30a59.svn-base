package com.anticw.aged.vo.professional.assess;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.anticw.aged.bean.utils.ProfessionalConstants;
import com.anticw.aged.exception.BusinessException;
import com.anticw.aged.exception.ExceptionCode;

/**
 * 评估量表问题vo
 * <P>File name : AssessQuestionVO.java </P>
 * <P>Author : zhouyanxin </P>
 * <P>Date : 2014-10-1 </P>
 */
public class AssessQuestionVO extends AssessBaseVO {
    /**
     * 评估量表Id
     */
    private Integer assessId;
    /**
     * 多选选项
     */
    private Boolean assessType;
    /**
     * 问题Id
     */
    private Integer id;
	/**
	 * 问题内容
	 */
	private String content;
	/**
	 * 问题答案
	 */
	private List<AssessAnswerVO> answers;
	
	/**
	 * 问题图片
	 */
	private String picture;
	
	/**
	 * 组合表Id
	 */
	private List<Integer> assessIds;

    public Integer getId() {
        return id;
    }
	
	
    public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setId(Integer id) {
        this.id = id;
    }
	

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<AssessAnswerVO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AssessAnswerVO> answers) {
        this.answers = answers;
    }

    public Integer getAssessId() {
        return assessId;
    }

    public void setAssessId(Integer assessId) {
        this.assessId = assessId;
    }

    public List<Integer> getAssessIds() {
        return assessIds;
    }

    public void setAssessIds(List<Integer> assessIds) {
        this.assessIds = assessIds;
    }

    public Boolean getAssessType() {
        return assessType;
    }

    public void setAssessType(Boolean assessType) {
        this.assessType = assessType;
    }

    /**
     * 自检
     * <P>Author : zhouyanxin </P>
     * <P>Date : 2014-10-1 </P>
     *
     * @return
     * @throws BusinessException
     * @see com.anticw.aged.vo.common.BaseVO#selfValidate()
     */
    public boolean selfValidate() throws BusinessException {

        //父类自检
        super.selfValidate();

        //根据评估来量表的类型进行分别检查
        if (this.getType() == ProfessionalConstants.ASSESS_TYPE_SCORE) {
            if (assessId == null || StringUtils.isEmpty(content) || answers == null || answers.isEmpty()) {
                throw new BusinessException(ExceptionCode.ASSESS_QA_ERROR);
            } else {
                for (AssessAnswerVO aaVo : answers) {
                    aaVo.selfValidate();
                }
                return true;
            }
        } else {
            if (assessId == null) {
                throw new BusinessException(ExceptionCode.ASSESS_QA_ERROR);
            } else {
                return true;
            }
        }
    }
}
