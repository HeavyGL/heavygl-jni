/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout.OfByte;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;

import org.josl.heavygl.annotations.NativeType;

/**
 * The HeavyGL functionality up to version 1.2.
 */
public class HGL11 {

	/** GlGetString */
	public static final int GL_VERSION = 0x1F00, GL_VENDOR = 0x1F02;

	/** GlErrors */
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

	// --- [ glXSetContext ] ---

	/**
	 * Sets the specified buffer to use in order to draw pixels and do graphics
	 * stuff.
	 * 
	 * @param pixels The buffer used for rendering (integer RGB type)
	 * @param w      The width of the viewport
	 * @param h      The height of the viewport
	 * 
	 * @deprecated Just used for the LWJGL 3 API, it is more recommended to
	 * 			   use {@link #glXSetContext(MemorySegment, int, int)}
	 */
	@Deprecated
	public static void glXSetContext(@NativeType("uint32_t *") IntBuffer pixels, int w, int h) {
		HGL11.glXSetContext(MemorySegment.ofBuffer(pixels), w, h);
	}
	
	/**
	 * Sets the specified buffer to use in order to draw pixels and do graphics
	 * stuff.
	 * 
	 * @param pixels The buffer used for rendering (integer RGB type)
	 * @param w      The width of the viewport
	 * @param h      The height of the viewport
	 */
	public static void glXSetContext(@NativeType("intptr_t") MemorySegment ms, int w, int h) {
		HGL11C.nglXSetContext(ms.address(), w, h);
	}

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

	public static String glGetString(int id) {
		// Get the memory address of the string in memory
		long address = HGL11C.nglGetString(id);
		
		System.out.println("okay!");

		// Make a memory segment pointing to that object
		MemorySegment ms = MemorySegment.ofAddress(address);
		
		return "STR";
		/*
		System.out.println("okay2!");
		// Get the content from that pointer
		byte[] strContents = ms.toArray(OfByte.JAVA_BYTE);
		
		System.out.println("okay3!");
		// Return a string encoded using UTF-8
		return new String(strContents);*/
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

}
