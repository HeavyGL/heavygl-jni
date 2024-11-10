/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import static org.lwjgl.system.MemoryUtil.*;

import java.io.*;
import java.nio.ByteBuffer;

public class GLObject {

	GLObject() {
	}
	
	/**
	 * This method returns the address of the selected object.
	 * 
	 * @apiNote its more recommended to use the method
	 *          {@link HGL12T#GL_OBJECT(GLObject)}
	 */
	public long address() {
		byte[] serial = serialize();
		ByteBuffer bff = memAlloc(serial.length);
		bff.put(serial);
		bff.flip();

		return memAddressSafe(bff);
	}

	public byte[] serialize() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (DataOutputStream dos = new DataOutputStream(baos)) {
			serialize(dos);
		} catch (IOException impossible) {
			throw new IllegalStateException(impossible.getMessage());
		}
		return baos.toByteArray();
	}

	public void serialize(DataOutputStream dos) throws IOException {
		dos.writeUTF("Serialization not available yet!");
	}
	
	public void destroy() {
		
	}

}
