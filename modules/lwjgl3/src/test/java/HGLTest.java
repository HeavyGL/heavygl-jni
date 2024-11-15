
/*
 * Copyleft HeavyGL. Open for everyone.
 * Licensed Under JOSL: https://opensource.org/license/bsd-3-clause
 */
import static java.lang.Math.*;
import static javax.swing.JFrame.*;
import static org.josl.heavygl.HGL11.*;

import java.awt.*;

import javax.swing.*;

import org.josl.heavygl.swing.GLPanel;

public class HGLTest implements Runnable {

	private JFrame win;
	private GLPanel panel;
	private final int width, height;

	public HGLTest(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void run() {
		init();

		Timer timer = new Timer(16, e -> panel.repaint());
		timer.start();
		glClearColor(0.2f, 0.2f, 0.4f);
		System.out.println("Currently running on HeavyGL " + glGetString(GL_VERSION));
	}

	private void render() {
		glClear();
		{
			double time = System.currentTimeMillis();
			double freq = 900;
			
			freq = 10000 - freq;
			double a = time / freq % (int) freq * PI * 2;
			float amplitude = 100;
			int side = 120;

			float x = (float) cos(a) * amplitude + ((width - side) / 2);
			float y = (float) sin(a) * amplitude + ((height - side) / 2);

			// TODO: glColorHSB(1, 0, 0);
			glFillRect(x, y, side, side);
		}
		glFlush();
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

		win.add(panel = new GLPanel() {
			private static final long serialVersionUID = 1L;

			public void draw() {
				render();
			}

		}, BorderLayout.CENTER);
		win.pack();

		win.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new HGLTest(500, 500));
	}

}
