package com.heqing.springboot.config.value;

/**
 * @author heqing
 */
public enum PersonEnum {

    /* 大人 */
    ADULT(0,  "大人"),
    /* 小孩 */
    CHILD(1, "小孩");

    private final Integer value;
    private final String desc;

    PersonEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
