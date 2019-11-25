package com.lxzh123.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public abstract class Reflector00 {

    static Map<String, Method> reflectorMaps = new HashMap();
    protected Class<?> mClazz;
    protected Object mObject;
    static Class[] nullTypes = new Class[0];
    static Object[] nullParams = new Object[0];

    public Reflector00(Class clazz) {
        mClazz = clazz;
    }

    public Reflector00 of(Object obj) {
        mObject = obj;
        return this;
    }

    public ClassLoader getClassLoader() {
        return mClazz.getClassLoader();
    }

    public synchronized TypeVariable<? extends Class>[] getTypeParameters() {
        return mClazz.getTypeParameters();
    }

    public Class getSuperclass() {
        return mClazz.getSuperclass();
    }

    public Type getGenericSuperclass() {
        return mClazz.getGenericSuperclass();
    }

    public Package getPackage() {
        return mClazz.getPackage();
    }

    public abstract String getPackageName$();

    public Class<?>[] getInterfaces() {
        return mClazz.getInterfaces();
    }

    public Type[] getGenericInterfaces() {
        return mClazz.getGenericInterfaces();
    }

    public Class<?> getComponentType() {
        return mClazz.getComponentType();
    }

    public int getModifiers() {
        return mClazz.getModifiers();
    }

    public Object[] getSigners() {
        return mClazz.getSigners();
    }

    public Method getEnclosingMethod() {
        return mClazz.getEnclosingMethod();
    }

    public Constructor<?> getEnclosingConstructor() {
        return mClazz.getEnclosingConstructor();
    }

    public Class<?> getDeclaringClass() {
        return mClazz.getDeclaringClass();
    }

    public Class<?> getEnclosingClass() {
        return mClazz.getEnclosingClass();
    }

    public String getSimpleName() {
        return mClazz.getSimpleName();
    }

    public abstract String getTypeName();

    public String getCanonicalName(){
        return mClazz.getCanonicalName();
    }

    public boolean isAnonymousClass() {
        return mClazz.isAnonymousClass();
    }

    public boolean isLocalClass() {
        return mClazz.isLocalClass();
    }

    public boolean isMemberClass() {
        return mClazz.isMemberClass();
    }

    public abstract Class<?>[] getClasses();

    public abstract Field[] getFields();

    public Method[] getMethods(){
        return mClazz.getMethods();
    }

    public Constructor<?>[] getConstructors() {
        return mClazz.getConstructors();
    }

    public Field getField(String name) throws NoSuchFieldException{
        return mClazz.getField(name);
    }
    public Method getMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClazz.getMethod(name, parameterTypes);
    }

    public Constructor<?> getConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClazz.getConstructor(parameterTypes);
    }

    public Class<?>[] getDeclaredClasses() {
        return mClazz.getDeclaredClasses();
    }

    public abstract Field[] getDeclaredFields();
}
