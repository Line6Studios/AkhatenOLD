package dev.linesixstudios.akhaten;

import dev.linesixstudios.akhaten.core.Game;

public class Launcher {
	public static void main(String args[]) {
		
		System.out.println("Akhaten 0.0.0 Copyright (c) 2018 Line-6 Studios //");
		System.out.println("Placeholder background by Birritan (https://www.deviantart.com/birritan)");
		
		Game mn = new Game("Akhaten", 1080, 540);
		mn.start();
		
	}
}
