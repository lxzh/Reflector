package com.lxzh123.reflector;

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
public class Reflector {
    private final Class mClass;
    private final Object mObject;
    private Reflector00 reflector;
    private static volatile Reflector instance;
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

    private Reflector(Class<?> type) {
        mClass = type;
        mObject = null;
        init();
    }

    private Reflector(Object object) {
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

    public static Reflector forName(String name) throws ReflectException {
        try {
            if (SDK_INT < 28) {
                return new Reflector(Class.forName(name));
            } else {
                return new Reflector(Reflector28.forName(name));
            }
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static Reflector on(Class clazz) {
        return new Reflector(clazz);
    }

    public static Reflector with(Object object) {
        return new Reflector(object);
    }


    public ClassLoader getClassLoader() {
        return reflector.getClassLoader();
    }

    public synchronized TypeVariable<? extends Class>[] getTypeParameters() {
        return reflector.getTypeParameters();
    }

    public Class getSuperclass() {
        return reflector.getSuperclass();
    }

    public Type getGenericSuperclass() {
        return reflector.getGenericSuperclass();
    }

    public Package getPackage() {
        return reflector.getPackage();
    }

    public String getPackageName$() {
        return reflector.getPackageName$();
    }

    public Class<?>[] getInterfaces() {
        return reflector.getInterfaces();
    }

    public Type[] getGenericInterfaces() {
        return reflector.getGenericInterfaces();
    }

    public Class<?> getComponentType() {
        return reflector.getComponentType();
    }

    public int getModifiers() {
        return reflector.getModifiers();
    }

    public Object[] getSigners() {
        return reflector.getSigners();
    }

    public Method getEnclosingMethod() {
        return reflector.getEnclosingMethod();
    }

    public Constructor<?> getEnclosingConstructor() {
        return reflector.getEnclosingConstructor();
    }

    public Class<?> getDeclaringClass() {
        return reflector.getDeclaringClass();
    }

    public Class<?> getEnclosingClass() {
        return reflector.getEnclosingClass();
    }

    public String getSimpleName() {
        return reflector.getSimpleName();
    }

    public String getTypeName() {
        return reflector.getTypeName();
    }


    public String getCanonicalName() {
        return reflector.getCanonicalName();
    }

    public boolean isAnonymousClass() {
        return reflector.isAnonymousClass();
    }

    public boolean isLocalClass() {
        return reflector.isLocalClass();
    }

    public boolean isMemberClass() {
        return reflector.isMemberClass();
    }

    public Class<?>[] getClasses() {
        return reflector.getClasses();
    }

    public Field[] getFields() {
        return reflector.getFields();
    }

    public Method[] getMethods() {
        return reflector.getMethods();
    }

    public Constructor<?>[] getConstructors() {
        return reflector.getConstructors();
    }

    public Field getField(String name) throws NoSuchFieldException {
        return reflector.getField(name);
    }

    public Method getMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return reflector.getMethod(name, parameterTypes);
    }

    public Constructor<?> getConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return reflector.getConstructor(parameterTypes);
    }

    public Class<?>[] getDeclaredClasses() {
        return reflector.getDeclaredClasses();
    }

    public Field[] getDeclaredFields() {
        return reflector.getDeclaredFields();
    }

    public Field[] getDeclaredFieldsUnchecked(boolean publicOnly) {
        return reflector.getDeclaredFieldsUnchecked(publicOnly);
    }

    public Method[] getDeclaredMethods() {
        return reflector.getDeclaredMethods();
    }

    public Method getInstanceMethod(String name, Class<?>[] parameterTypes) {
        return reflector.getInstanceMethod(name, parameterTypes);
    }

    public Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return reflector.getDeclaredConstructor(parameterTypes);
    }

    public InputStream getResourceAsStream(String name) {
        return reflector.getResourceAsStream(name);
    }

    public java.net.URL getResource(String name) {
        return reflector.getResource(name);
    }

    public java.security.ProtectionDomain getProtectionDomain() {
        return reflector.getProtectionDomain();
    }

    public boolean desiredAssertionStatus() {
        return reflector.desiredAssertionStatus();
    }

    public boolean isEnum() {
        return reflector.isEnum();
    }

    public <T> T[] getEnumConstants() {
        return reflector.getEnumConstants();
    }

    //hide
    public <T> T[] getEnumConstantsShared() {
        return reflector.getEnumConstantsShared();
    }

    public <T> T cast(Object obj) {
        return reflector.cast(obj);
    }

    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        return reflector.asSubclass(clazz);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return reflector.getAnnotation(annotationClass);
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return reflector.isAnnotationPresent(annotationClass);
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
        return reflector.getDeclaredAnnotations();
    }

    //hide
    public boolean isProxy() {
        return reflector.isProxy();
    }

    //hide
    public int getAccessFlags() {
        return reflector.getAccessFlags();
    }

//    static {
//        try {
//            System.loadLibrary("reflector");
//        }catch (Throwable t){
//            t.printStackTrace();
//        }
//    }

//    public static native void unhideAll();

    private static Reflector getInstance() {
        if (instance == null) {
            synchronized (Reflector.class) {
                if (instance == null) {
                    instance = new Reflector(Class.class);
                }
            }
        }
        return instance;
    }

    public static boolean unHide(String method) {
        return getInstance().reflector.unHide(method);
    }

    public static boolean unHideAll() {
        return getInstance().reflector.unHideAll();
    }
}