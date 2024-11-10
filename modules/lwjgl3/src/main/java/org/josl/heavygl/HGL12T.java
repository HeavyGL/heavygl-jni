/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

import org.lwjgl.system.MemoryUtil;

/**
 * HeavyGL Specification 1.2 protoType
 */
public class HGL12T {

	/**
	 * Returns the address of an object.
	 */
	public static long GL_OBJECT(GLObject obj) {
		return obj == null ? MemoryUtil.NULL : obj.address();
	}
	
	public static GLObject glCreateObject() {
		return new GLObject();
	}
	
	public static void glDestroyObject(GLObject obj) {
		obj.destroy();
	}
	
	public static void glLoadObject(long address) {
	}
	
	public static void glCloneEntity(long[] entities) {
	}
	
	public static void glCloneEntityV(int entities) {
	}
	
	public static void glBindBuffer(long vao, float[] buffer, int len) {
	}
	
	public static void glMakeLink() {
	}
	
	public static void glLinkUpstream(long address) {
	}
	
	public static void glLinkDwstream(long address) {
	}
	
	public static void glApplyLink() {
	}
	
	/* GlRenderingQueue */
	
	public static boolean glRQueueEmpty() {
		return false;
	}
	
	public static void glRQueueNext() {
	}
	
	public static /* TODO */ void glRQueueGet() {
	}
	
}
