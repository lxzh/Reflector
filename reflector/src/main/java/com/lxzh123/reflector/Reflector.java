package com.lxzh123.reflector;

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
//    private final boolean isClass;

    private void init() {
        if (SDK_INT < 26) {
            reflector = new Reflector01(mClass);
        } else if (SDK_INT < 28) {
            reflector = new Reflector26(mClass);
        } else {
            reflector = new Reflector28(mClass);
        }
    }

    private Reflector(Class<?> type) {
//        this.object = type;
//        this.isClass = true;
        mClass = type;
        mObject = null;
        init();
    }

    private Reflector(Object object) {
//        this.object = object;
//        this.isClass = false;
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


    public String getCanonicalName(){
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

    public Method[] getMethods(){
        return reflector.getMethods();
    }

    public Constructor<?>[] getConstructors() {
        return reflector.getConstructors();
    }

    public Field getField(String name) throws NoSuchFieldException{
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
}
