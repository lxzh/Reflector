package com.lxzh123.reflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public class Reflector28 extends Reflector26 {
    static Method forNameMethod = null;
    static Method getDeclareMethod = null;

    static {
        try {
            forNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            getDeclareMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    public Reflector28(Class clazz) {
        super(clazz);
    }

    private synchronized Method getMethod(String methodName) {
        Method method = reflectorMaps.get(methodName);
        if (method == null) {
            try {
                method = (Method)getDeclareMethod.invoke(Class.class, methodName, nullTypes);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            reflectorMaps.put(methodName, method);
        }
        return method;
    }

    @Override
    public String getPackageName$() {
        Method method = getMethod("getPackageName$");
        String rtn = null;
        try {
            rtn = (String) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    public static Class<?> forName(String name) {
        Class<?> rtn = null;
        try {
            rtn = (Class<?>)forNameMethod.invoke(Class.class, name);
        }catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    public Class<?>[] getClasses() {
        Method method = getMethod("getClasses");
        Class<?>[] rtn = null;
        try {
            rtn = (Class<?>[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    public Field[] getFields() {
        Method method = getMethod("getFields");
        Field[] rtn = null;
        try {
            rtn = (Field[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    public Field[] getDeclaredFields() {
        Method method = getMethod("getDeclaredFields");
        Field[] rtn = null;
        try {
            rtn = (Field[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }
}
