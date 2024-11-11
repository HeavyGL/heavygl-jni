/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl.util;

import static org.josl.heavygl.HGL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.IntBuffer;

public class GLRaster {

	public final int width, height;
	public IntBuffer pixels;
	public long address;

	public GLRaster(int width, int height) {
		this.width = width;
		this.height = height;

		this.pixels = memAllocInt(width * height);
		this.address = memAddress(pixels);
	}

	public void copy(BufferedImage bi) {
		pixels.rewind();
		int[] biPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
		pixels.get(biPixels);
	}

	public void free() {
		memFree(pixels);
	}

	public void makeCurrentContext() {
		glXSetContext(pixels, width, height);
	}

}
