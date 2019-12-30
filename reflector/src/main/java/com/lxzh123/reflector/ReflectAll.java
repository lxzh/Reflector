package com.lxzh123.reflector;

import android.util.Log;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static android.os.Build.VERSION.SDK_INT;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public class ReflectAll {
    private final Class mClass;
    private final Object mObject;
    private Reflector00 reflector;
//    private final boolean isClass;

    private void init() {
        if (SDK_INT < 24) {
            reflector = new Reflector01(mClass);
        } else if (SDK_INT < 26) {
            reflector = new Reflector24(mClass);
        } else if (SDK_INT < 28) {
            reflector = new Reflector26(mClass);
        } else {
            reflector = new Reflector28(mClass);
        }
    }

    private ReflectAll(Class<?> type) {
        mClass = type;
        mObject = null;
        init();
    }

    private ReflectAll(Object object) {
        mClass = object.getClass();
        mObject = object;
        init();
    }

    public Class<?> get() {
        return mClass;
    }

    public Object getValue() {
        return mObject;
    }

    public static ReflectAll forName(String name) throws ReflectException {
        try {
            return new ReflectAll(Class.forName(name));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static ReflectAll on(Class clazz) {
        return new ReflectAll(clazz);
    }

    public static ReflectAll with(Object object) {
        return new ReflectAll(object);
    }


    public ClassLoader getClassLoader() {
        return mClass.getClassLoader();
    }

    public synchronized TypeVariable<? extends Class>[] getTypeParameters() {
        return mClass.getTypeParameters();
    }

    public Class getSuperclass() {
        return mClass.getSuperclass();
    }

    public Type getGenericSuperclass() {
        return mClass.getGenericSuperclass();
    }

    public Package getPackage() {
        return mClass.getPackage();
    }

    public String getPackageName$() {
        return reflector.getPackageName$();
    }

    public Class<?>[] getInterfaces() {
        return mClass.getInterfaces();
    }

    public Type[] getGenericInterfaces() {
        return mClass.getGenericInterfaces();
    }

    public Class<?> getComponentType() {
        return mClass.getComponentType();
    }

    public int getModifiers() {
        return mClass.getModifiers();
    }

    public Object[] getSigners() {
        return mClass.getSigners();
    }

    public Method getEnclosingMethod() {
        return mClass.getEnclosingMethod();
    }

    public Constructor<?> getEnclosingConstructor() {
        return mClass.getEnclosingConstructor();
    }

    public Class<?> getDeclaringClass() {
        return mClass.getDeclaringClass();
    }

    public Class<?> getEnclosingClass() {
        return mClass.getEnclosingClass();
    }

    public String getSimpleName() {
        return mClass.getSimpleName();
    }

    public String getTypeName() {
        return reflector.getTypeName();
    }


    public String getCanonicalName() {
        return mClass.getCanonicalName();
    }

    public boolean isAnonymousClass() {
        return mClass.isAnonymousClass();
    }

    public boolean isLocalClass() {
        return mClass.isLocalClass();
    }

    public boolean isMemberClass() {
        return mClass.isMemberClass();
    }

    public Class<?>[] getClasses() {
        return mClass.getClasses();
    }

    public Field[] getFields() {
        return mClass.getFields();
    }

    public Method[] getMethods() {
        return mClass.getMethods();
    }

    public Constructor<?>[] getConstructors() {
        return mClass.getConstructors();
    }

    public Field getField(String name) throws NoSuchFieldException {
        return mClass.getField(name);
    }

    public Method getMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClass.getMethod(name, parameterTypes);
    }

    public Constructor<?> getConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClass.getConstructor(parameterTypes);
    }

    public Class<?>[] getDeclaredClasses() {
        return mClass.getDeclaredClasses();
    }

    public Field[] getDeclaredFields() {
        return mClass.getDeclaredFields();
    }

    public Field[] getDeclaredFieldsUnchecked(boolean publicOnly) {
        return reflector.getDeclaredFieldsUnchecked(publicOnly);
    }

    public Method[] getDeclaredMethods() {
        return mClass.getDeclaredMethods();
    }

    public Method getInstanceMethod(String name, Class<?>[] parameterTypes) {
        return reflector.getInstanceMethod(name, parameterTypes);
    }

    public Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return mClass.getDeclaredConstructor(parameterTypes);
    }

    public InputStream getResourceAsStream(String name) {
        return mClass.getResourceAsStream(name);
    }

    public java.net.URL getResource(String name) {
        return mClass.getResource(name);
    }

    public java.security.ProtectionDomain getProtectionDomain() {
        return mClass.getProtectionDomain();
    }

    public boolean desiredAssertionStatus() {
        return mClass.desiredAssertionStatus();
    }

    public boolean isEnum() {
        return mClass.isEnum();
    }

    public <T> T[] getEnumConstants() {
        return (T[])mClass.getEnumConstants();
    }

    //hide
    public <T> T[] getEnumConstantsShared() {
        return reflector.getEnumConstantsShared();
    }

    public <T> T cast(Object obj) {
        return (T)mClass.cast(obj);
    }

    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        return mClass.asSubclass(clazz);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return (A)mClass.getAnnotation(annotationClass);
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return mClass.isAnnotationPresent(annotationClass);
    }

    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        return reflector.getAnnotationsByType(annotationClass);
    }

    public Annotation[] getAnnotations() {
        return reflector.getAnnotations();
    }

    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return reflector.getDeclaredAnnotation(annotationClass);
    }

    public Annotation[] getDeclaredAnnotations() {
        return mClass.getDeclaredAnnotations();
    }

    //hide
    public boolean isProxy() {
        return reflector.isProxy();
    }

    //hide
    public int getAccessFlags() {
        return reflector.getAccessFlags();
    }

    /**
     * 仅对API28有效，API29失效
     */
    public static void unhideAll() {
        try {
            Class reflectAll = Class.forName("com.lxzh123.reflector.ReflectAll");
            Class classClz = Class.class;
            Method getDeclaredField = classClz.getDeclaredMethod("getDeclaredField", String.class);
            Field classLoaderField = (Field) getDeclaredField.invoke(classClz, "classLoader");
            classLoaderField.setAccessible(true);
            classLoaderField.set(reflectAll, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static String TAG = "TestReflector";

    public static void testMethod() {
        try {
            Class clz = Class.forName("android.app.ActivityThread");
            Method method = clz.getDeclaredMethod("getIntentBeingBroadcast");
            method.setAccessible(true);
            method.invoke(null);
            Log.e(TAG, "testMethod: getDeclaredMethod->getIntentBeingBroadcast success");
        } catch (Exception e) {
//            e.printStackTrace();
            Log.e(TAG, "testMethod: getDeclaredMethod->getIntentBeingBroadcast failed");
        }
    }

    public static void testField() {
        try {
            Class clz = Class.forName("android.app.ActivityThread");
            Field field = clz.getDeclaredField("TAG");
            field.setAccessible(true);
            field.get(null);
            Log.e(TAG, "testField: getDeclaredField->TAG of ActivityThread success");
        } catch (Exception e) {
//            e.printStackTrace();
            Log.e(TAG, "testField: getDeclaredField->TAG of ActivityThread failed");
        }

    }
}