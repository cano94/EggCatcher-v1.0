package GameEntities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Sprites {
	
	private Image image;

	
	public Sprites(Image image) {
		this.image = image;
	}

	
	public int getWidth() {
		return image.getWidth(null);
	}

	
	public int getHeight() {
		return image.getHeight(null);
	}


	public void draw(Graphics2D g,int x,int y) {
		g.drawImage(image,x,y,null);
	}
	public Image getImage(){
		return image;
	}

}