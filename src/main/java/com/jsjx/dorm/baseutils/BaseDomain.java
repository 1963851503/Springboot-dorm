package com.jsjx.dorm.baseutils;


import com.google.common.collect.Maps;
import java.util.Date;
import java.util.Map;

/**
 * @program: dorm
 * @description: domain基类
 * @author: 高峰
 * @create: 2018-08-12 17:53
 **/
public class BaseDomain extends BaseVo {
    private static final long serialVersionUID = 1L;
    protected int page;
    protected int size;
    protected String sortBy;
    protected String descending;
    private String notes;
    private String enableFlag;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    protected Map<String, String> sqlMap;
    private String companyCode;

    public BaseDomain() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEnableFlag() {
        return this.enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Map<String, String> getSqlMap() {
        if (this.sqlMap == null) {
            this.sqlMap = Maps.newHashMap();
        }

        return this.sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getDescending() {
        return this.descending;
    }

    public void setDescending(String descending) {
        this.descending = descending;
    }
}

