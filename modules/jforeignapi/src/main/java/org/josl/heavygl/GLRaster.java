/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static org.josl.heavygl.HGL11.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout.OfInt;

public class GLRaster {

	public final int width, height;
	public MemorySegment address;

	public GLRaster(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.address = Arena.global().allocate(width * height);
	}

	public void copy(BufferedImage bi) {
		// Get pixels from the address (as java integer)
		int[] array = this.address.toArray(OfInt.JAVA_INT);
		
		System.out.println(this.address.address());
		// Retrieve image pixels
		int[] biPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
		
		// Calculate the minimum between the two arrays (to not cause stack underflow/overflow problems)
		int len = Math.min(array.length, biPixels.length);

		// Use Java system array copy function
		System.arraycopy(array, 0, biPixels, 0, len);
	}

	public void free() {
		//address.unload();
	}

	public void makeCurrentContext() {
		glXSetContext(address, width, height);
	}

}
