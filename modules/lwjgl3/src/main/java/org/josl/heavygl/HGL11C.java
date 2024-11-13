/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

/**
 * The class where all the native methods are located.
 */
public class HGL11C {

	/** Don't let anyone instantiate this class */
	private HGL11C() {
	}

	// --- [ glXSetContext ] ---

	/**
	 * Sets the specified buffer to use in order to draw pixels and do graphics
	 * stuff.
	 * 
	 * @param address The address of the buffer used for rendering (integer RGB
	 *                type)
	 * @param w       The width of the viewport
	 * @param h       The height of the viewport
	 */
	static native void nglXSetContext(long address, int w, int h);

	// --- [ glClearColor ] ---

	/**
	 * Sets the clear value for fixed-point and floating-point color buffers in RGB
	 * mode. The specified components are stored as floating-point values.
	 *
	 * @param red   the value to which to clear the R channel of the color buffer
	 * @param green the value to which to clear the G channel of the color buffer
	 * @param blue  the value to which to clear the B channel of the color buffer
	 */
	static native void nglClearColor(float r, float g, float b);
	
	static native void nglFillRect(float x, float y, float width, float height);
	
	// --- [ glClear ] ---

	/**
	 * Clears the current pixel buffer with the selected clear color.
	 */
	static native void nglClear();

	// --- [ glGetError ] ---

	/**
	 * Returns the latest error occurred in HeavyGL runtime.
	 * 
	 * @return the latest error occurred in HeavyGL runtime.
	 */
	static native int nglGetError();

	// --- [ glGetString ] ---
	
	/**
	 * Returns a string constant specified by the following id.
	 * 
	 * @return a string constant specified by the following id.
	 */
	static native long nglGetString(int id);
}
