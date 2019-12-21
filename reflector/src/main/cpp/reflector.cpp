#include "reflector.h"
#include "fake_dlfcn.h"
#include "common.h"

#include <android/asset_manager.h>
#include <android/asset_manager_jni.h>
#include <string.h>
#include <errno.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <dlfcn.h>

#define JNIREG_CLASS "com/lxzh123/reflector/Reflector"

static int g_sdk_int = 0;

void (*setClassLoader)(void *pClass, void *new_cl);
ObjPtr (*toClass)(jclass global_jclass);

extern "C"
JNIEXPORT jstring JNICALL Reflector_unhideAll
        (JNIEnv *env, jclass) {
    LOGV("api level: %d", g_sdk_int);
    if (g_sdk_int >= 30) {
        void *handle = dlopen_ex("libart.so", RTLD_NOW);
        void *jit_lib = dlopen_ex("libart-compiler.so", RTLD_NOW);
        LOGI("[+] unhideAll 1");
        *(void **)(&toClass) = dlsym_ex(handle, "_ZN3art16WellKnownClasses7ToClassEP7_jclass");
        *(void **)(&setClassLoader) = dlsym_ex(handle, "_ZN3art6mirror5Class14SetClassLoaderENS_6ObjPtrINS0_11ClassLoaderEEE");
        LOGI("[+] unhideAll 2 toClass=0?%d setClassLoader==0?%d", (int)(toClass==0), (int)(setClassLoader==0));
        jclass cls = env->FindClass(JNIREG_CLASS);
        LOGI("[+] unhideAll 3");
        ObjPtr op = toClass(cls);
        LOGI("[+] unhideAll 4");
        setClassLoader((void *) op.reference, NULL);
        LOGI("[+] unhideAll 5");
    }
    return env->NewStringUTF("unhideAll");
}


static JNINativeMethod gMethods[] = {
        {"unhideAll", "()V", (void *) Reflector_unhideAll},
};

int jniRegisterNativeMethods(JNIEnv *env, const char *className, const JNINativeMethod *gMethods,
                             int numMethods) {
    LOGI("[+] jniRegisterNativeMethods");
    jclass clazz;
    clazz = env->FindClass(className);
    if (clazz == NULL) {
        return -1;
    }
    if (env->RegisterNatives(clazz, gMethods, numMethods) < 0) {
        LOGE("[-] RegisterNatives failed");
        return -1;
    }
    return 0;
}

void init(JNIEnv *env) {
    LOGI("[+] init");
    jclass jclazz = env->FindClass("android/os/Build$VERSION");
    jfieldID SDK_INT = env->GetStaticFieldID(jclazz, "SDK_INT", "I");

    g_sdk_int = env->GetStaticIntField(jclazz, SDK_INT);
    LOGD("[+] sdk_int:%d", g_sdk_int);
    jclass System = env->FindClass("java/lang/System");
    jmethodID System_getProperty = env->GetStaticMethodID(System, "getProperty",
                                                          "(Ljava/lang/String;)Ljava/lang/String;");

    jstring vm_version_name = env->NewStringUTF("java.vm.version");
    jstring vm_version_value = (jstring) (env->CallStaticObjectMethod(System,
                                                                      System_getProperty,
                                                                      vm_version_name));

    char *cvm_version_value = (char *) env->GetStringUTFChars(vm_version_value, NULL);
    double version = atof(cvm_version_value);
    LOGD("[+] Android VmVersion:%f", version);

    env->ReleaseStringUTFChars(vm_version_value, cvm_version_value);
    env->DeleteLocalRef(System);
    env->DeleteLocalRef(vm_version_name);
    env->DeleteLocalRef(vm_version_value);
    jniRegisterNativeMethods(env, JNIREG_CLASS, gMethods, NELEM(gMethods));
    env->DeleteLocalRef(jclazz);
}

JNIEXPORT int JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGI("[+] JNI_OnLoad");
    JNIEnv *env;
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    init(env);
    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    LOGI("[+] JNI_OnUnload");
}