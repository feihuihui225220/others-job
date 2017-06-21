package com.anticw.aged.vo.professional.assess;

/**
 * Created by WSS on 2015/8/17.<br>
 *    用于给页面传答案的结论字段。
 */
public class ConclusionVO {
    private Integer answerId;
    private String conclusion;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
