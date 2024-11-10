/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static java.lang.foreign.ValueLayout.*;
import static org.josl.heavygl.HGL11.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public final class GLRaster {

	public final int width, height;
	private final Arena arena;
	public MemorySegment mem;

	public GLRaster(int width, int height) {
		this.width = width;
		this.height = height;

		this.arena = Arena.ofShared();
		this.mem = arena.allocate(JAVA_INT, width * height);
	}

	public void copy(BufferedImage bi) {
		int[] biPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
		int len = Math.min(biPixels.length, width * height);

		for (int i = 0; i < len; i++)
			biPixels[i] = mem.getAtIndex(JAVA_INT, i);
	}

	public void free() {
		this.arena.close();
	}

	public void makeCurrentContext() {
		glXSetContext(mem, width, height);
	}
}
