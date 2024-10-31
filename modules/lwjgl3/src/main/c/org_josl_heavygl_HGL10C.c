#include "HGL/hgl.h"

#include <jni.h>
#include <stdio.h>
#include <stdint.h>

static int width = 0, height = 0, area = 0;
static uint32_t * pixels = NULL;
static int gl_error = 0;

static int clearColor = 0;

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglXSetPxBuffer(JNIEnv *, jclass, jlong address, jint w, jint h)
{
    glXSetPxBuffer((intptr_t) address, w, h); // Direct HeavyGL call
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglClearColor(JNIEnv *, jclass, jfloat r, jfloat g, jfloat b)
{
    glClearColor(r, g, b); // Direct HeavyGL call
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglClear(JNIEnv *, jclass)
{
    glClear();  // Direct HeavyGL call
}

