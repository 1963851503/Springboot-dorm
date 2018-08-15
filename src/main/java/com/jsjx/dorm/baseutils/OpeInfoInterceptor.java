package com.jsjx.dorm.baseutils;

/**
 * @program: dorm
 * @description: 公共字段赋值基类
 * @author: 高峰
 * @create: 2018-08-12 18:12
 **/
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class OpeInfoInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();

        //遍历处理所有参数，update方法有两个参数，参见Executor类中的update()方法。
        SqlCommandType sqlCommandType = null;
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            String className = arg.getClass().getName();

            //第一个参数处理。根据它判断是否给“操作属性”赋值。
            if (arg instanceof MappedStatement) {//如果是第一个参数 MappedStatement
                MappedStatement ms = (MappedStatement) arg;
                sqlCommandType = ms.getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT || sqlCommandType == SqlCommandType.UPDATE) {//如果是“增加”或“更新”操作，则继续进行默认操作信息赋值。否则，则退出
                    continue;
                } else {
                    break;
                }
            }

            //第二个参数处理。（只有第二个程序才能跑到这）
            if (arg instanceof DefaultSqlSession.StrictMap) {
                SqlCommandType finalSqlCommandType = sqlCommandType;
                ((List<?>)((DefaultSqlSession.StrictMap)arg).get("list")).forEach(p-> {
                    setProperty(p, finalSqlCommandType);
                });
            } else if (arg instanceof Map) {//如果是map，有两种情况：（1）使用@Param多参数传入，由Mybatis包装成map。（2）原始传入Map
                Map map = (Map) arg;
                for (Object obj : map.values()) {
                    setProperty(obj, sqlCommandType);
                }
            } else {//原始参数传入
                setProperty(arg, sqlCommandType);
            }

        }

        return invocation.proceed();

    }

    /**
     * 为对象的操作属性赋值
     *
     * @param obj
     */
    private void setProperty(Object obj, SqlCommandType sqlCommandType) {
        try {
//            Subject subject = SecurityUtils.getSubject();
//            if(subject.isAuthenticated()) {
//                Session session = subject.getSession();
            Date now = new Date();
            if (sqlCommandType == SqlCommandType.INSERT) {
                BeanUtils.setProperty(obj, "enableFlag", "1");
                BeanUtils.setProperty(obj, "createdBy", "jyy");//session.getAttribute("s_userCode"));
                BeanUtils.setProperty(obj, "createdDate", now);
                BeanUtils.setProperty(obj, "companyCode", "8000");//session.getAttribute("s_companyCode"));
            }
            BeanUtils.setProperty(obj, "updatedBy", "jyy");//session.getAttribute("s_userCode"));
            BeanUtils.setProperty(obj, "updatedDate", now);
            BeanUtils.setProperty(obj, "companyCode", "8000");//session.getAttribute("s_companyCode"));
//            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }

}
