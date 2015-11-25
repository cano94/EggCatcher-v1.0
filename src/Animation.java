

import java.awt.Image;

import java.util.ArrayList;

import javax.jws.Oneway;

public class Animation {
    

	private Sprites[] frames;
	private int currentFrame;
	
	private long startTime;
	private long delay;
	
	public Animation() {}
	
	public void setFrames(Sprites[] frames) {
		this.frames = frames;
		if(currentFrame >= frames.length) currentFrame = 0;
	}
	
	public void setDelay(long d) {
		delay = d;
	}
	
	public void update() {
		
		if(delay == -1) return;
		
		long elapsed = (System.nanoTime() - startTime) / 1000000;
		if(elapsed > delay) {
			currentFrame++;
			startTime = System.nanoTime();
		}
		if(currentFrame == frames.length) {
			currentFrame = 0;
		}
		
	}
	
	public Sprites getImage() {
		return frames[currentFrame];
	}
	
}

