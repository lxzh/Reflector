package com.lxzh123.demo;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.lxzh123.reflector.Reflector;
import com.lxzh123.reflector.Reflector00;
import com.lxzh123.reflector.Reflector28;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "TestReflector";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Class[] classes = null;
        Field[] fields = null;

        Reflector00 reflector = new Reflector28(MainActivity.class);
        Log.d(TAG, "packageName$=" + reflector.of(this).getPackageName$());
        Log.d(TAG, "package=" + reflector.of(this).getPackage());
        classes = Reflector.forName("android.app.ActivityThread").getClasses();
        for (Class clz : classes) {
            Log.d(TAG, "class1=" + clz);
        }
        try {
            classes = Class.forName("android.app.ActivityThread").getClasses();
            for (Class clz : classes) {
                Log.d(TAG, "class2=" + clz);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        classes = Reflector.forName("java.lang.invoke.MethodHandles").getClasses();
        for (Class clz : classes) {
            Log.d(TAG, "class1=" + clz);
        }
        try {
            classes = Class.forName("java.lang.invoke.MethodHandles").getClasses();
            for (Class clz : classes) {
                Log.d(TAG, "class2=" + clz);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        Log.d(TAG, "VMRuntime1=" + Reflector.forName("dalvik.system.VMRuntime").get());
        try {
            Log.d(TAG, "VMRuntime2=" + Class.forName("dalvik.system.VMRuntime"));
        } catch (Throwable t) {
            t.printStackTrace();
        }

        fields = Reflector.forName("android.app.Dialog").getDeclaredFields();
        for (Field field : fields) {
            Log.d(TAG, "field1=" + field);
        }

        fields = Dialog.class.getDeclaredFields();
        for (Field field : fields) {
            Log.d(TAG, "field2=" + field);
        }

    }
}
