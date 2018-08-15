package com.jsjx.dorm.baseutils;

import java.io.Serializable;

/**
 * @program: dorm
 * @description: Vo基类
 * @author: 高峰
 * @create: 2018-08-12 17:50
 **/
public class BaseVo implements Serializable {
    private static final long serialVersionUID = -5716898911307725165L;
    private int page;
    private int size;
    private String sortBy;
    private String descending;

    public BaseVo() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
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
