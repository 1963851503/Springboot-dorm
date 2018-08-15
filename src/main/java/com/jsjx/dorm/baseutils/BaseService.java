package com.jsjx.dorm.baseutils;

/**
 * @program: dorm
 * @description: service基类
 * @author: 高峰
 * @create: 2018-08-12 17:51
 **/
import java.util.List;

public interface BaseService<D extends BaseDao<T>, T extends BaseDomain> {
    T findById(String var1);

    int putUpdate(T var1);

    int postInsert(T var1);

    int delete(String var1);

    int deleteAll(List<String> var1);
}
