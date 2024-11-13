/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl.util;

import static org.josl.heavygl.HGL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.IntBuffer;

public final class GLRaster {

	private static GLRaster shared;
	
	public int width, height;
	IntBuffer pixels;

	GLRaster(int width, int height) {
		size(width, height);
	}

	private void allocate() {
		free();
		this.pixels = memAllocInt(width * height);
		makeContextCurrent();
	}
	
	public GLRaster size(int width, int height) {
		if (this.width == width && this.height == height)
			return this;
		
		this.width = width;
		this.height = height;
		this.allocate();
		
		return this;
	}

	public void copy(BufferedImage bi) {
		pixels.rewind();
		int[] biPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
		pixels.get(biPixels);
	}

	public void free() {
		memFree(pixels);
	}

	private void makeContextCurrent() {
		glXSetContext(pixels, width, height);
	}
	
	public static GLRaster get(int width, int height) {
		if (shared == null)
			return GLRaster.create(width, height);
		
		return shared.size(width, height);
	}
	
	public static GLRaster create(int width, int height) {
		return shared = new GLRaster(width, height);
	}

	public static GLRaster get(Dimension size) {
		return GLRaster.get(size.width, size.height);
	}

	public BufferedImage createCompatibleImage() {
		return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

}
