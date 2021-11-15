package com.heqing.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heqing
 * @date 2021/7/16 16:34
 */
public class User implements Serializable {

    private String name;
    private Integer age;
    private String address;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
