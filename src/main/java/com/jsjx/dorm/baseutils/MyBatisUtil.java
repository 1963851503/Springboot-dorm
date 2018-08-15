package com.jsjx.dorm.baseutils;

/**
 * @program: dorm
 * @description: mybatis工具类
 * @author: 高峰
 * @create: 2018-08-12 18:01
 **/
import com.github.pagehelper.PageHelper;
import java.text.MessageFormat;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;

public class MyBatisUtil {
    public MyBatisUtil() {
    }

    public static RowBounds fetchRb(BaseVo baseVo) {
        RowBounds rb = RowBounds.DEFAULT;
        if (baseVo != null && baseVo.getPage() > 0 && baseVo.getSize() > 0) {
            rb = new RowBounds(baseVo.getPage(), baseVo.getSize());
        }

        return rb;
    }

    public static void dynamicSorting(BaseVo baseVo) {
        if (baseVo != null) {
            if (!StringUtils.isEmpty(baseVo.getSortBy()) && !StringUtils.isEmpty(baseVo.getDescending())) {
                PageHelper.orderBy(MessageFormat.format("{0} {1}", CamelCaseUtil.toUnderscoreName(baseVo.getSortBy()), "true".equals(baseVo.getDescending()) ? "desc" : "asc"));
            }

        }
    }

    public static void paging(BaseVo baseVo) {
        if (baseVo != null) {
            PageHelper.startPage(baseVo.getPage(), baseVo.getSize());
            if (!StringUtils.isEmpty(baseVo.getSortBy()) && !StringUtils.isEmpty(baseVo.getDescending())) {
                PageHelper.orderBy(MessageFormat.format("{0} {1}", CamelCaseUtil.toUnderscoreName(baseVo.getSortBy()), "true".equals(baseVo.getDescending()) ? "desc" : "asc"));
            }

        }
    }
}