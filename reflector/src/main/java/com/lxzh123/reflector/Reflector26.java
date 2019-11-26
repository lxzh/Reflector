package com.lxzh123.reflector;

import android.annotation.TargetApi;

/**
 * description $
 * author      Created by lxzh
 * date        2019-11-25
 */
public class Reflector26 extends Reflector01 {
    Reflector26(Class clazz) {
        super(clazz);
    }

    @TargetApi(26)
    @Override
    public String getTypeName() {
        return mClazz.getTypeName();
    }
}
