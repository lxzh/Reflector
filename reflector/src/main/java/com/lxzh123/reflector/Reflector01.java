package com.lxzh123.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
class Reflector01 extends Reflector00 {
    Reflector01(Class clazz) {
        super(clazz);
    }

    @Override
    protected synchronized Method getMethodInternal(String methodName) {
        Method method = methodsMaps.get(methodName);
        if (method == null) {
            try {
                method = (Method) mClazz.getDeclaredMethod(methodName, nullTypes);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            methodsMaps.put(methodName, method);
        }
        return method;
    }

    @Override
    protected synchronized Method getMethodInternal(String methodName, Class<?>... parameterTypes) {
        Method method = methodsMaps.get(methodName + parameterTypes.hashCode());
        if (method == null) {
            try {
                method = (Method) mClazz.getDeclaredMethod(methodName, parameterTypes);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            methodsMaps.put(methodName + parameterTypes.hashCode(), method);
        }
        return method;
    }

    @Override
    protected synchronized Field getFieldInternal(String fieldName) {
        Field field = fieldsMaps.get(fieldName);
        if (field == null) {
            try {
                field = (Field) mClazz.getDeclaredField(fieldName);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            fieldsMaps.put(fieldName, field);
        }
        return field;
    }

    @Override
    String getPackageName$() {
        return super.getPackageName$();
    }

    @Override
    String getTypeName() {
        return mClazz.getName();
    }

    @Override
    Class<?>[] getClasses() {
        return mClazz.getClasses();
    }

    @Override
    Field[] getFields() {
        return mClazz.getFields();
    }

    @Override
    Field[] getDeclaredFields() {
        return mClazz.getDeclaredFields();
    }

    @Override
    Field getDeclaredField(String name) throws NoSuchFieldException {
        return mClazz.getDeclaredField(name);
    }

    @Override
    Field[] getDeclaredFieldsUnchecked(boolean publicOnly) {
        return super.getDeclaredFieldsUnchecked(publicOnly);
    }

    @Override
    Method[] getDeclaredMethods(){
        return mClazz.getDeclaredMethods();
    }

    @Override
    Method getInstanceMethod(String name, Class<?>[] parameterTypes) {
        return super.getInstanceMethod(name,parameterTypes);
    }

    @Override
    Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException{
        return mClazz.getDeclaredConstructor(parameterTypes);
    }

    @Override
    public boolean unHide(String method) {
        return true;
    }

    @Override
    public boolean unHideAll() {
        return true;
    }
}
