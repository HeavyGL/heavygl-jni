/*
 * HeavyGL Specification 1.0
 */

#pragma once

#ifndef HGL_H
#define HGL_H 1
#include <stdint.h>

typedef int GLerror;

/* HeavyGL Special Functions */
void glXSetPxBuffer(intptr_t, int, int);

/* HeavyGL Common Functions */
void glClearColor(float, float, float);
void glClear();

GLerror glGetError();

#endif
