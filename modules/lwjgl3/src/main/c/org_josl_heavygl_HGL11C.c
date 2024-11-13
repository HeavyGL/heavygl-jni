#include <HGL/hgl.h>

#include <jni.h>
#include <stdint.h>

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL11C_nglXSetContext(JNIEnv*, jclass, jlong address, jint w, jint h)
{
    glXSetContext((intptr_t) address, (int) w, (int) h);  // Direct HeavyGL call
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL11C_nglClearColor(JNIEnv*, jclass, jfloat r, jfloat g, jfloat b)
{
    glClearColor((float) r, (float) g, (float) b); // Direct HeavyGL call
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL11C_nglClear(JNIEnv*, jclass)
{
    glClear(); // Direct HeavyGL call
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL11C_nglFillRect (JNIEnv *, jclass, jfloat x, jfloat y, jfloat width, jfloat height)
{
    glFillRect((float) x, (float) y, (float) width, (float) height); // Direct HeavyGL call
}

JNIEXPORT jint JNICALL Java_org_josl_heavygl_HGL11C_nglGetError(JNIEnv*, jclass)
{
    return (jint) (int) glGetError(); // Direct HeavyGL call
}

JNIEXPORT jlong JNICALL Java_org_josl_heavygl_HGL11C_nglGetString(JNIEnv*, jclass, jint id)
{
    const char* str = glGetString((int) id);
    return (jlong) (uintptr_t) str;
}
