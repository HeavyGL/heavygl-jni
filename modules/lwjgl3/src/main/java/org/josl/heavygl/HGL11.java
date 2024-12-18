/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static org.lwjgl.system.MemoryUtil.*;

import java.nio.IntBuffer;

import org.lwjgl.system.NativeType;

/**
 * The HeavyGL functionality up to version 1.2.
 */
public class HGL11 {

	/** Features */
	public static final int GL_DOUBLEBUFFER = 0xC32;
	
	/** Strings */
	public static final int GL_VERSION = 0x1F02;

	/** Errors */
	public static final int GL_NO_ERROR                      = 0x0,
							GL_INVALID_ENUM                  = 0x500,
							GL_INVALID_VALUE                 = 0x501,
							GL_INVALID_OPERATION             = 0x502,
							GL_STACK_OVERFLOW                = 0x503,
							GL_STACK_UNDERFLOW               = 0x504,
							GL_OUT_OF_MEMORY                 = 0x505,
							GL_INVALID_FRAMEBUFFER_OPERATION = 0x506,
							GL_CONTEXT_LOST                  = 0x507,
							GL_TABLE_TOO_LARGE1              = 0x8031;

	static { HGL.initialize(); }

	/** Don't let anyone instantiate this class */
	private HGL11() {}

	// --- [ glClearColor ] ---

	/**
	 * Sets the clear value for fixed-point and floating-point color buffers in RGB
	 * mode. The specified components are stored as floating-point values.
	 *
	 * @param red   the value to which to clear the R channel of the color buffer
	 * @param green the value to which to clear the G channel of the color buffer
	 * @param blue  the value to which to clear the B channel of the color buffer
	 */
	public static void glClearColor(float r, float g, float b) {
		HGL11C.nglClearColor(r, g, b);
	}

	// --- [ glDisable ] ---

	/**
	 * Disables a HeavyGL capability or feature.
	 * 
	 * @param capability the feature to disable
	 */
	public static void glDisable(int capability) {
		HGL11C.nglDisable(capability);
	}

	// --- [ glEnable ] ---

	/**
	 * Enables a HeavyGL capability or feature.
	 * 
	 * @param capability the feature to enable
	 */
	public static void glEnable(int capability) {
		HGL11C.nglEnable(capability);
	}

	// --- [ glFillRect ] ---

	/**
	 * Fills a rectangle with the selected bounds.
	 * 
	 * @param x      the x offset of the rectangle.
	 * @param y      the y offset of the rectangle.
	 * @param width  the width of the rectangle.
	 * @param height the height of the rectangle.
	 */
	public static void glFillRect(float x, float y, float width, float height) {
		HGL11C.nglFillRect(x, y, width, height);
	}

	// --- [ glFlush ] ---
	
	/**
	 * Sends data from the back buffer to the front one.
	 */
	public static void glFlush() {
		HGL11C.nglFlush();
	}
	
	// --- [ glClear ] ---

	/**
	 * Clears the current pixel buffer with the selected clear color.
	 */
	public static void glClear() {
		HGL11C.nglClear();
	}

	// --- [ glGetError ] ---

	/**
	 * Returns the latest error occurred in HeavyGL runtime.
	 * 
	 * @return the latest error occurred in HeavyGL runtime.
	 */
	public static @NativeType("GLerror") int glGetError() {
		return HGL11C.nglGetError();
	}
	
	/**
	 * Returns a string constant specified by the following id.
	 * 
	 * @return a string constant specified by the following id.
	 */
	public static String glGetString(int id) {
		long address = HGL11C.nglGetString(id);
		return memUTF8(address);
	}
	
	// --- [ glXSetContext ] ---

	/**
	 * Sets the specified buffer to use in order to draw pixels and do graphics
	 * stuff.
	 * 
	 * @param pixels The buffer used for rendering (integer RGB type)
	 * @param w      The width of the viewport
	 * @param h      The height of the viewport
	 */
	public static void glXSetContext(@NativeType("uint32_t *") IntBuffer pixels, int w, int h) {
		HGL11C.nglXSetContext(memAddress(pixels), w, h);
	}

}
