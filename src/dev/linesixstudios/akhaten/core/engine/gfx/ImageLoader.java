package dev.linesixstudios.akhaten.core.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(URL path) {

		BufferedImage img = null;
		
		if (path == null) {
	
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}
		
		try {
			img = ImageIO.read(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (img != null) {
			return img;
		} else {
			return null;
		}
		
	}
	
}
