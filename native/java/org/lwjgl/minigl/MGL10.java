package org.lwjgl.minigl;

import java.nio.*;
import static org.lwjgl.system.MemoryUtil.*;

public final class MGL10 {

	private MGL10() {}
	
	public static void glSetPxBuffer(IntBuffer buffer, int width, int height) {
		if (buffer == null)
			return;
		
		long ptr = memAddressSafe(buffer);
		nglSetPxBuffer(ptr, width, height);
	}
	
	private static native void nglSetPxBuffer(long ptr, int w, int h);
	
	public static native void glClearColor(float r, float g, float b);
	public static native void glClear();
	
	public static native int glGetError();
	
}