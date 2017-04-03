package com.hiveview.entity;

import java.util.Date;
import java.util.List;

public class UserNeed {
    private Long id;

    private String categoryCode;

    private String needDesc;

    private String mobile;

    private Date addTime;

    private int isContact;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getNeedDesc() {
        return needDesc;
    }

    public void setNeedDesc(String needDesc) {
        this.needDesc = needDesc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getIsContact() {
        return isContact;
    }

    public void setIsContact(int isContact) {
        this.isContact = isContact;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}