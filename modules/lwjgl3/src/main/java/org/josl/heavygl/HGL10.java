/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static org.lwjgl.system.MemoryUtil.*;

import java.nio.IntBuffer;

import org.lwjgl.system.NativeType;

/**
 * The HeavyGL functionality up to version 1.0.
 */
public class HGL10 {

	static { HGL.initialize(); }
	
	/** Don't let anyone instantiate this class */
	private HGL10() {}
	
	// --- [ glXSetPxBuffer ] ---
	
	/**
	 * Sets the specified buffer to use in order to draw pixels and do graphics stuff.
	 * 
	 * @param pixels  The buffer used for rendering (integer RGB type)
	 * @param w       The width of the viewport
	 * @param h       The height of the viewport
	 */
	public static void glXSetPxBuffer(@NativeType("uint32_t *") IntBuffer pixels, int w, int h) {
		HGL10C.nglXSetPxBuffer(memAddress(pixels), w, h);
	}
	
	
	
	// --- [ glClearColor ] ---
	
	/**
     * Sets the clear value for fixed-point and floating-point color buffers in RGBA mode. The specified components are stored as floating-point values.
     *
     * @param red   the value to which to clear the R channel of the color buffer
     * @param green the value to which to clear the G channel of the color buffer
     * @param blue  the value to which to clear the B channel of the color buffer
     * @param alpha the value to which to clear the A channel of the color buffer
     */
	public static void glClearColor(float r, float g, float b) {
		HGL10C.nglClearColor(r, g, b);
	}
	
	// --- [ glClear ] ---
	
	/**
	 * Clears the current pixel buffer with the selected clear color.
	 */
	public static void glClear() {
		HGL10C.nglClear();
	}
	
}
