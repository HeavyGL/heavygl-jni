/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static org.josl.heavygl.HGL10.*;
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
		pixels.position(0);
		int[] biPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
		{
			for (int i = 0; pixels.hasRemaining(); i++)
				biPixels[i] = pixels.get();
		}
	}

	public void free() {
		memFree(pixels);
	}

	public void makeCurrentContext() {
		glXSetPxBuffer(pixels, width, height);
	}

}
