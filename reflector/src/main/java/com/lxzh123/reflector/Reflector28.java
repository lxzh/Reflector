package com.lxzh123.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
class Reflector28 extends Reflector26 {
    static Method forNameMethod = null;
    static Method getDeclareMethod = null;
    private static Object sVmRuntime = null;
    private static Method setHiddenApiExemptions = null;

    static {
        try {
            forNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            getDeclareMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);

            Class<?> vmRuntimeClass = (Class<?>) forNameMethod.invoke(null, "dalvik.system.VMRuntime");
            Method getRuntime = (Method) getDeclareMethod.invoke(vmRuntimeClass, "getRuntime", null);
            setHiddenApiExemptions = (Method) getDeclareMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});
            sVmRuntime = getRuntime.invoke(null);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    Reflector28(Class clazz) {
        super(clazz);
    }

    @Override
    protected synchronized Method getMethodInternal(String methodName) {
        Method method = methodsMaps.get(methodName);
        if (method == null) {
            try {
                method = (Method) getDeclareMethod.invoke(Class.class, methodName, nullTypes);
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
                method = (Method) getDeclareMethod.invoke(Class.class, methodName, parameterTypes);
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

    static Class<?> forName(String name) {
        Class<?> rtn = null;
        try {
            rtn = (Class<?>) forNameMethod.invoke(Class.class, name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Class<?>[] getClasses() {
        Method method = getMethodInternal("getClasses");
        Class<?>[] rtn = null;
        try {
            rtn = (Class<?>[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Field[] getFields() {
        Method method = getMethodInternal("getFields");
        Field[] rtn = null;
        try {
            rtn = (Field[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Field[] getDeclaredFields() {
        Method method = getMethodInternal("getDeclaredFields");
        Field[] rtn = null;
        try {
            rtn = (Field[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Field getDeclaredField(String name) {
        Method method = getMethodInternal("getDeclaredField", String.class);
        Field rtn = null;
        try {
            rtn = (Field) method.invoke(mClazz, name);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Field[] getDeclaredFieldsUnchecked(boolean publicOnly) {
        return super.getDeclaredFieldsUnchecked(publicOnly);
    }

    @Override
    Method[] getDeclaredMethods() {
        Method method = getMethodInternal("getDeclaredMethods");
        Method[] rtn = null;
        try {
            rtn = (Method[]) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    @Override
    Method getInstanceMethod(String name, Class<?>[] parameterTypes) {
        return super.getInstanceMethod(name, parameterTypes);
    }

    @Override
    Constructor<?> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        Method method = getMethodInternal("getDeclaredConstructor", parameterTypes);
        Constructor<?> rtn = null;
        try {
            rtn = (Constructor<?>) method.invoke(mClazz, nullParams);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rtn;
    }

    public boolean unHide(String... methods) {
        if (sVmRuntime == null || setHiddenApiExemptions == null) {
            return false;
        }

        try {
            setHiddenApiExemptions.invoke(sVmRuntime, new Object[]{methods});
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    @Override
    public boolean unHide(String method) {
        return unHide(new String[]{method});
    }

    @Override
    public boolean unHideAll() {
        return unHide(new String[]{"L"});
    }
}
