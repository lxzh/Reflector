package com.lxzh123.reflector;

import android.annotation.TargetApi;

import java.lang.annotation.Annotation;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public class Reflector24 extends Reflector01 {
    Reflector24(Class clazz) {
        super(clazz);
    }

    @TargetApi(24)
    @Override
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        return mClazz.getAnnotationsByType(annotationClass);
    }

    @TargetApi(24)
    @Override
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return mClazz.getDeclaredAnnotation(annotationClass);
    }
}
