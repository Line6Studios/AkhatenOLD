package dev.linesixstudios.akhaten.core.engine.object;

import java.awt.Graphics;

import dev.linesixstudios.akhaten.core.engine.object.ID;

public abstract class GameObject {

	protected int x, y; // The size of the object
	protected int velX, velY; // The velocity of the object

	
	protected ID id; // The id of the Object that is going to be added
	
	// Constructor method for Game Objects
	public GameObject(int x, int y, ID id) {
		this.x = x; // Set the Object length
		this.y = y; // Set the Object height
		this.id = id; // Set the Object ObjectID
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
		
}
