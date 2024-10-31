/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */

import static java.awt.image.BufferedImage.*;
import static java.lang.Math.*;
import static javax.swing.JFrame.*;
import static org.josl.heavygl.HGL10.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import org.josl.heavygl.GLRaster;

public class HGLTest extends JComponent implements Runnable {

	private static final long serialVersionUID = 1L;

	private JFrame win;
	private BufferedImage bi;
	private GLRaster raster;

	private final int width, height;

	public HGLTest(int width, int height) {
		this.width = width;
		this.height = height;

		this.raster = new GLRaster(width, height);
		this.bi = new BufferedImage(width, height, TYPE_INT_RGB);
	}

	public void run() {
		init();
		raster.makeCurrentContext();

		Timer timer = new Timer(16, e -> repaint());
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		{
			glClearColor((float) random(), (float) random(), (float) random());
			glClear();
		}
		raster.copy(bi);
		g.drawImage(bi, 0, 0, this);
		g.dispose();
	}

	private void init() {
		this.win = new JFrame("HGL JNI Test");
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Dimension size = new Dimension(width, height);
		win.setSize(size);
		win.setPreferredSize(size);
		win.setLocationRelativeTo(null);

		win.setResizable(false);
		win.setLayout(new BorderLayout());

		win.add(this, BorderLayout.CENTER);
		win.pack();

		win.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new HGLTest(500, 500));
	}

}
