package dev.linesixstudios.akhaten.core.engine.object;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;

import dev.linesixstudios.akhaten.core.engine.input.KeyInput;
import dev.linesixstudios.akhaten.Window;

public class Handler {

	public LinkedList<GameObject> obj = new LinkedList<GameObject>(); 
	
	private KeyInput ki = new KeyInput(obj);
	
	public Handler(JFrame frame) {
		frame.addKeyListener(ki);
	}

	public void tick() {
	     Iterator<GameObject> iter = obj.iterator();
	    
	     while (iter.hasNext()) {
	    	 
	          GameObject tempObject = iter.next();
	          tempObject.tick();
	          
	     }
	}
	
	public void render(Graphics g) {
	     Iterator<GameObject> iter = obj.iterator();

	     while (iter.hasNext()) {
	    	 
	          GameObject tempObject = iter.next();
	          tempObject.render(g);
	          
	     }
	}
	
	public void addObj(GameObject object) {
		
		try {
			
			this.obj.add(object); 
			
			System.out.println("Added object " + object);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeObj(GameObject object) {
		
		this.obj.remove(object);
		
	}
	
}
