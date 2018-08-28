package dev.linesixstudios.akhaten;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window  {
	
	private JFrame frame;
	private Canvas cvs;

	public Window(String title, int width, int height) {
		initComponents(title, width, height);
	}

	private void initComponents(String title, int width, int height) {
		
		 frame = new JFrame(title);
		 
		 frame.setSize(width, height);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
		 cvs = new Canvas();
		 cvs.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
		 cvs.setMaximumSize(new Dimension(width, height));
		 cvs.setMinimumSize(new Dimension(width, height));
		 
		 
		 frame.add(cvs);
		 frame.pack();
		 frame.setVisible(true);
		 
	}
	
	public Canvas getCanvas() {
		
		return cvs;
		
	}
	
	public JFrame getFrame() {
		
		return frame;
		
	}
	
}
