/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
package org.josl.heavygl.swing;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import org.josl.heavygl.util.GLRaster;

public class GLPanel extends JComponent implements ComponentListener {

	private static final long serialVersionUID = 1L;
	private GLRaster raster = null;
	private BufferedImage bi;
	
	public GLPanel() {
		addComponentListener(this);
	}

	public void componentResized(ComponentEvent e) {
		raster = GLRaster.get(getSize());
		bi = raster.createCompatibleImage();
	}
	
	public final void paintComponent(Graphics g) {
		if (raster == null)
			return;
		
		super.paintComponent(g);
		{
			draw();
		}
		raster.copy(bi);
		g.drawImage(bi, 0, 0, this);
		g.dispose();
		
	}
	
	// Ready to override
	public void draw() {
	}
	
	/* Useless methods */

	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	public void componentHidden(ComponentEvent e) {}
	
}
