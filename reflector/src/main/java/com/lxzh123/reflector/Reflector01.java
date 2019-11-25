package com.lxzh123.reflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public class Reflector01 extends Reflector00 {
    public Reflector01(Class clazz) {
        super(clazz);
    }

    @Override
    public String getPackageName$() {
        if (mObject == null) {
            throw new NullPointerException("mObject");
        }
        String methodName = "getPackageName$";
        Method method = reflectorMaps.get(methodName);
        if (method == null) {
            try {
                method = mClazz.getDeclaredMethod(methodName, nullTypes);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            reflectorMaps.put(methodName, method);
        }
        String rtn = null;
        try {
            rtn = (String) method.invoke(mClazz, nullParams);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rtn;
    }

    @Override
    public String getTypeName() {
        return mClazz.getName();
    }

    @Override
    public Class<?>[] getClasses() {
        return mClazz.getClasses();
    }

    @Override
    public Field[] getFields() {
        return mClazz.getFields();
    }

    @Override
    public Field[] getDeclaredFields() {
        return mClazz.getDeclaredFields();
    }
}
