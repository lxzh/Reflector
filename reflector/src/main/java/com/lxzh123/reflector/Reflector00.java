package com.lxzh123.reflector;

import java.io.InputStream;
import java.lang.annotation.Annotation;
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

    Reflector00(Class clazz) {
        mClazz = clazz;
    }

    Reflector00 of(Object obj) {
        mObject = obj;
        return this;
    }

    protected abstract Method getMethodInternal(String methodName);

    protected abstract Method getMethodInternal(String methodName, Class<?>... parameterTypes);

    ClassLoader getClassLoader() {
        return mClazz.getClassLoader();
    }

    synchronized TypeVariable<? extends Class>[] getTypeParameters() {
        return mClazz.getTypeParameters();
    }

    Class getSuperclass() {
        return mClazz.getSuperclass();
    }

    Type getGenericSuperclass() {
        return mClazz.getGenericSuperclass();
    }

    Package getPackage() {
        return mClazz.getPackage();
    }

    String getPackageName$() {
        Method method = getMethodInternal("getPackageName$");
        String rtn = null;
        try {
            rtn = (String) method.invoke(mClazz, nullParams);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rtn;
    }

    Class<?>[] getInterfaces() {
        return mClazz.getInterfaces();
    }

    Type[] getGenericInterfaces() {
        return mClazz.getGenericInterfaces();
    }

    Class<?> getComponentType() {
        return mClazz.getComponentType();
    }

    int getModifiers() {
        return mClazz.getModifiers();
    }

    Object[] getSigners() {
        return mClazz.getSigners();
    }

    Method getEnclosingMethod() {
        return mClazz.getEnclosingMethod();
    }

    Constructor<?> getEnclosingConstructor() {
        return mClazz.getEnclosingConstructor();
    }

    Class<?> getDeclaringClass() {
        return mClazz.getDeclaringClass();
    }

    Class<?> getEnclosingClass() {
        return mClazz.getEnclosingClass();
    }

    String getSimpleName() {
        return mClazz.getSimpleName();
    }

    abstract String getTypeName();

    String getCanonicalName(){
        return mClazz.getCanonicalName();
    }

    boolean isAnonymousClass() {
        return mClazz.isAnonymousClass();
    }

    boolean isLocalClass() {
        return mClazz.isLocalClass();
    }

    boolean isMemberClass() {
        return mClazz.isMemberClass();
    }

    abstract Class<?>[] getClasses();

    abstract Field[] getFields();

    Method[] getMethods(){
        return mClazz.getMethods();
    }

    Constructor<?>[] getConstructors() {
        return mClazz.getConstructors();
    }

    Field getField(String name) throws NoSuchFieldException{
        return mClazz.getField(name);
    }
    Method getMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClazz.getMethod(name, parameterTypes);
    }

    Constructor<?> getConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClazz.getConstructor(parameterTypes);
    }

    Class<?>[] getDeclaredClasses() {
        return mClazz.getDeclaredClasses();
    }

    abstract Field[] getDeclaredFields();

    //hide
    Field[] getDeclaredFieldsUnchecked(boolean publicOnly) {
        Method method = getMethodInternal("getDeclaredFieldsUnchecked", boolean.class);
        Field[] rtn = null;
        try {
            rtn = (Field[]) method.invoke(mClazz, publicOnly);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    abstract Method[] getDeclaredMethods();

    //hide
    Method getInstanceMethod(String name, Class<?>[] parameterTypes) {
        Method method = getMethodInternal("getInstanceMethod", parameterTypes);
        Method rtn = null;
        try {
            rtn = (Method) method.invoke(mClazz, parameterTypes);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    abstract Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException;

    InputStream getResourceAsStream(String name) {
        return mClazz.getResourceAsStream(name);
    }

    public java.net.URL getResource(String name) {
        return mClazz.getResource(name);
    }

    public java.security.ProtectionDomain getProtectionDomain() {
        return mClazz.getProtectionDomain();
    }

    public boolean desiredAssertionStatus() {
        return mClazz.desiredAssertionStatus();
    }

    public boolean isEnum() {
        return mClazz.isEnum();
    }

    public <T> T[] getEnumConstants() {
        return (T[])mClazz.getEnumConstants();
    }

    //hide
    public <T> T[] getEnumConstantsShared() {
        Method method = getMethodInternal("getEnumConstantsShared");
        T[] rtn = null;
        try {
            rtn = (T[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    public <T> T cast(Object obj) {
        return (T)mClazz.cast(obj);
    }

    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        return mClazz.asSubclass(clazz);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return mClazz.getAnnotation(annotationClass);
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return mClazz.isAnnotationPresent(annotationClass);
    }

    //start from api 24
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        return null;
    }

    public Annotation[] getAnnotations() {
        return mClazz.getAnnotations();
    }

    //start from api 24
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return null;
    }

    public  Annotation[] getDeclaredAnnotations() {
        return mClazz.getDeclaredAnnotations();
    }

    //hide
    public boolean isProxy() {
        Method method = getMethodInternal("isProxy");
        boolean rtn = false;
        try {
            rtn = (boolean) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }
    //hide
    public int getAccessFlags() {
        Method method = getMethodInternal("getAccessFlags");
        int rtn = -1;
        try {
            rtn = (int) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }
}
