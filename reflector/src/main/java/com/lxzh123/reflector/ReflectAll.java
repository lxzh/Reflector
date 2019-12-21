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
public class ReflectAll {
    private final Class mClass;
    private final Object mObject;
    private Reflector00 reflector;
//    private final boolean isClass;

    private void init() {
        reflector = new Reflector01(mClass);
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
            if (SDK_INT < 28) {
                return new ReflectAll(Class.forName(name));
            } else {
                return new ReflectAll(Class.forName(name));
            }
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
}