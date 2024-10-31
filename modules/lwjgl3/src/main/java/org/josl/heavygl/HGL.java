/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl;

/**
 * This class must be used before any HeavyGL function is called. It has the following responsibilities:
 * <ul>
 * 	<li>Loads the HeavyGL native library into the JVM process.</li>
 * </ul>
 *
 * <h3>Library lifecycle</h3>
 * <p>The HeavyGL library is loaded automatically when this class is initialized.</p>
 */
public class HGL {

	public static void initialize() throws UnsatisfiedLinkError {
		System.loadLibrary("heavygl");
	}

}
