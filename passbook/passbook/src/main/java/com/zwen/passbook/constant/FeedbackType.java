package com.zwen.passbook.constant;

public enum FeedbackType {

    PASS(1, "针对优惠券的评论"),
    APP(2, "针对卡包APP的评论");

    /** Feedback type code*/
    private Integer code;

    /** Feedback type description*/
    private String desc;

    FeedbackType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String detDesc() {
        return this.desc;
    }
}
