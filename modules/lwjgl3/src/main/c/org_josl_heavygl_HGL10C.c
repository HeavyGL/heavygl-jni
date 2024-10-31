#include <jni.h>
#include <stdint.h>
#include <stdio.h>

static int width = 0, height = 0, area = 0;
static uint32_t * pixels = NULL;
static int gl_error = 0;

static int clearColor = 0;

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglXSetPxBuffer(JNIEnv *, jclass, jlong address, jint w, jint h)
{
    width = w;
    height = h;
    area = w * h;
    pixels = (uint32_t *) (intptr_t) address;
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglClearColor(JNIEnv *, jclass, jfloat r, jfloat g, jfloat b)
{
    int ubr = (int) ((float) r * 255.0);
    int ubg = (int) ((float) g * 255.0);
    int ubb = (int) ((float) b * 255.0);

    clearColor = (ubr << 16) + (ubg << 8) + (ubb);
}

JNIEXPORT void JNICALL Java_org_josl_heavygl_HGL10C_nglClear(JNIEnv *, jclass)
{
    for (int i = 0; i < area; i++)
        pixels[i] = clearColor;
}

