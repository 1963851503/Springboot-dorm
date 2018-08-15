package com.jsjx.dorm.baseutils;

import com.github.pagehelper.PageInfo;
import java.io.Serializable;
import java.util.List;

/**
 * @program: dorm
 * @description: mybatis分页基类
 * @author: 高峰
 * @create: 2018-08-12 17:49
 **/
public class PageVo<E> implements Serializable {
    private static final long serialVersionUID = -289835974324582481L;
    private int page;
    private long total;
    private List<E> list;

    public PageVo(long total, List<E> content) {
        this.total = total;
        this.list = content;
    }

    public PageVo(List<E> list) {
        PageInfo<E> pageInfo = new PageInfo(list);
        this.page = pageInfo.getPageNum();
        this.list = pageInfo.getList();
        this.total = pageInfo.getTotal();
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getList() {
        return this.list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal(int total) {
        this.total = (long)total;
    }
}
