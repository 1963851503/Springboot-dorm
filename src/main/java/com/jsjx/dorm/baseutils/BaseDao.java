package com.jsjx.dorm.baseutils;

import java.util.List;

/**
 * @program: dorm
 * @description: dao基类
 * @author: 高峰
 * @create: 2018-08-12 17:51
 **/
public interface BaseDao<T> {
    int insert(T var1);

    int insertAll(List<T> var1);

    T findById(String var1);

    List<T> findBySelective(T var1);

    int updateBySelective(T var1);

    int deleteById(String var1);

    int deleteAll(List<String> var1);

    int deleteBySelective(T var1);
}
