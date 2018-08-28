package dev.linesixstudios.akhaten.core.engine.object;

import java.awt.Graphics;
import java.awt.Image;

import dev.linesixstudios.akhaten.Window;
import dev.linesixstudios.akhaten.core.engine.gfx.ImageLoader;

public class Player extends GameObject {
	
	private int x, y;
	private Image spriteImage;
	
	private Window window;
	
	public Player(String sprite, Window window, int x, int y, ID id) {
	
		super(x, y, id);
		
		this.window = window;
		this.x = x;
		this.y = y;
		
		spriteImage = ImageLoader.loadImage(getClass().getResource(sprite));
		
	}

	public void tick() {
		
		x += velX;
		y += velY;
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(spriteImage, x, y, window.getCanvas());
		
	}
	
	public int getX() {
		
		return x;
		
	}

	public void setX(int x) {
		
		this.x = x;
		
	}

	public int getY() {
		
		return y;
		
	}

	public void setY(int y) {
		
		this.y = y;
		
	}
	
}
