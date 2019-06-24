package com.zwen.passbook.constant;

/**
 * <h1>The status of the coupon</h1>
 *
 */

public enum PassStatus {
    UNUSED(1, "未被使用的"),
    USED(2, "已经是用的"),
    ALL(3, "全部领取的");

    /** Status code */
    private Integer code;

    private String desc;

    PassStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
