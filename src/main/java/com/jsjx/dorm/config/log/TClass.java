package com.jsjx.dorm.config.log;

public class TClass {

    /**
     * defalut
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T defaultT(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
