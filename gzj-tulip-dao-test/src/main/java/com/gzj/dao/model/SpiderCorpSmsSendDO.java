package com.gzj.dao.model;

import com.gzj.tulip.jade.plugin.sql.annotations.Column;
import com.gzj.tulip.jade.plugin.sql.annotations.Table;
import java.io.Serializable;
import java.util.Date;

@Table(pk = "ID")
public class SpiderCorpSmsSendDO implements Serializable {
    @Column(pk = true)
    private Integer id;

    @Column
    private Integer dianzhangId;

    @Column
    private String dianzhangName;

    @Column
    private String dianzhangName2;

    @Column
    private String dianzhangContacter;

    @Column
    private Integer spiderCorpId;

    @Column
    private String spiderCorpName;

    @Column
    private String spiderCorpContacter;

    @Column
    private String phone;

    @Column
    private String smsContent;

    @Column
    private Integer smsType;

    @Column
    private String smsTypeDesc;

    @Column
    private Date firstSendTime;

    @Column
    private Integer smsCount;

    @Column
    private String jobName;

    @Column
    private Integer sendFrom;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDianzhangId() {
        return dianzhangId;
    }

    public void setDianzhangId(Integer dianzhangId) {
        this.dianzhangId = dianzhangId;
    }

    public String getDianzhangName() {
        return dianzhangName;
    }

    public void setDianzhangName(String dianzhangName) {
        this.dianzhangName = dianzhangName;
    }

    public String getDianzhangName2() {
        return dianzhangName2;
    }

    public void setDianzhangName2(String dianzhangName2) {
        this.dianzhangName2 = dianzhangName2;
    }

    public String getDianzhangContacter() {
        return dianzhangContacter;
    }

    public void setDianzhangContacter(String dianzhangContacter) {
        this.dianzhangContacter = dianzhangContacter;
    }

    public Integer getSpiderCorpId() {
        return spiderCorpId;
    }

    public void setSpiderCorpId(Integer spiderCorpId) {
        this.spiderCorpId = spiderCorpId;
    }

    public String getSpiderCorpName() {
        return spiderCorpName;
    }

    public void setSpiderCorpName(String spiderCorpName) {
        this.spiderCorpName = spiderCorpName;
    }

    public String getSpiderCorpContacter() {
        return spiderCorpContacter;
    }

    public void setSpiderCorpContacter(String spiderCorpContacter) {
        this.spiderCorpContacter = spiderCorpContacter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    public String getSmsTypeDesc() {
        return smsTypeDesc;
    }

    public void setSmsTypeDesc(String smsTypeDesc) {
        this.smsTypeDesc = smsTypeDesc;
    }

    public Date getFirstSendTime() {
        return firstSendTime;
    }

    public void setFirstSendTime(Date firstSendTime) {
        this.firstSendTime = firstSendTime;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(Integer sendFrom) {
        this.sendFrom = sendFrom;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}