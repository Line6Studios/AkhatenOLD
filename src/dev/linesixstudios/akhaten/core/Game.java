package dev.linesixstudios.akhaten.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import dev.linesixstudios.akhaten.Window;
import dev.linesixstudios.akhaten.core.engine.gfx.ImageLoader;
import dev.linesixstudios.akhaten.core.engine.input.KeyInput;
import dev.linesixstudios.akhaten.core.engine.object.ID;
import dev.linesixstudios.akhaten.core.engine.object.Handler;
import dev.linesixstudios.akhaten.core.engine.object.Player;

public class Game implements Runnable {

	private Window window;
	
	public boolean running = false;
	
	public int width, height;
	public String title;
	
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;

	private Image background;
	
	private Handler handler;
	
	public Game(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		this.title = title;	
		
		window = new Window(title, width, height);

		handler = new Handler(window.getFrame());
		
	}
	
	private void init() {
		
		//Call this method right before the Game-loop starts
		
		window.getFrame().requestFocus();
		
		background = ImageLoader.loadImage(getClass().getResource("/textures/tempbackground.png"));
		
		handler.addObj(new Player("/textures/Player.png", window, 5, window.getFrame().getHeight() - 190, ID.Player));
		
	}
	
	@Override
	public void run() {	
		
		long oldTimestamp = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		int frames = 0;
		
		long now;
		
		init();
		
		while(running) {
			
			now = System.nanoTime();
			
			delta += (now - oldTimestamp) / ns;
			oldTimestamp = now;
			
			while(delta > 1 ) {
				
				tick();
				delta--;
				
			}
			
			if (running)
				render(frames);
			
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				
				frames = 0;
				
			}
			
			try {
				thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void start() {
		
		thread = new Thread(this);
		thread.start();
		
		running = true;
		
	}
	
	public void stop() throws InterruptedException {
		
		if (!running)
			return;
		
		thread.join();
		running = false;
		
	}
	
	public void tick() {
		
	}
	
	public void render(int fps) {
		
		bs = window.getCanvas().getBufferStrategy();
		
		//Create a BufferStrategy if there is none
		if (bs == null) {
			
			window.getCanvas().createBufferStrategy(3);
			return;
			
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, window.getFrame().getWidth(), window.getFrame().getHeight()); //Clear the canvas
		
		// Drawing stuff here
		
		//g.setColor(new Color(0, 59, 111));
		//g.fillRect(0, 0, window.getFrame().getWidth(), window.getFrame().getHeight());
		
		g.drawImage(background, 0, 0,window.getFrame().getWidth(), window.getFrame().getHeight(), window.getCanvas());
		
		handler.render(g);
		
		g.setColor(new Color(249, 202, 36));
		g.drawString(fps+" fps", window.getFrame().getWidth() - 50, 10);
		
		
		// End drawing stuff
		
		g.dispose();
		bs.show();
		
	}
	
}
