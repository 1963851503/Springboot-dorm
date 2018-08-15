package com.jsjx.dorm.baseutils.impl;

/**
 * @program: dorm
 * @description: serviceImpl基类
 * @author: 高峰
 * @create: 2018-08-12 17:52
 **/
import java.util.List;

import com.jsjx.dorm.baseutils.BaseDao;
import com.jsjx.dorm.baseutils.BaseDomain;
import com.jsjx.dorm.baseutils.BaseService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<D extends BaseDao<T>, T extends BaseDomain> implements BaseService<D, T> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected DozerBeanMapper mapper;
    @Autowired
    protected D dao;

    public BaseServiceImpl() {
    }

    public T findById(String id) {
        T t = (T) this.dao.findById(id);
        return t;
    }

    public int putUpdate(T param) {
        return this.dao.updateBySelective(param);
    }

    public int postInsert(T param) {
        return this.dao.insert(param);
    }

    public int delete(String id) {
        return this.dao.deleteById(id);
    }

    public int deleteAll(List<String> idList) {
        return this.dao.deleteAll(idList);
    }
}
