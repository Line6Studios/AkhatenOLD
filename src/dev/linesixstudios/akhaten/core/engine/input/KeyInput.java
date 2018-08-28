package dev.linesixstudios.akhaten.core.engine.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

import dev.linesixstudios.akhaten.core.engine.object.GameObject;
import dev.linesixstudios.akhaten.core.engine.object.Handler;
import dev.linesixstudios.akhaten.core.engine.object.ID;



public class KeyInput extends KeyAdapter {
	
    private LinkedList<GameObject> m_objects;

    public KeyInput(LinkedList<GameObject> objects) {
        m_objects = objects;
    }
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
	    Iterator<GameObject> iter = m_objects.iterator();
	    
	    while (iter.hasNext()) {
	    	
	         	GameObject tempObject = iter.next();
	         	
	         	if (tempObject.getId() == ID.Player) {

	         		if (key == 65) {

	         			tempObject.setX(tempObject.getX() - 1);

					} else if (key == 68) {

	         			tempObject.setX(tempObject.getX() + 1);

					}

	         	}
	         	
	     }
	    
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
	}
	
}
