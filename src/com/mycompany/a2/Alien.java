package com.mycompany.a2;

public class Alien extends Opponents{
	
	public Alien(double x, double y, int r, int g, int b, int s, int sp, int dir, int c) {
		super(x, y, 0, 0, 255, s, dir, c);
		super.setDirection();
		super.setSpeed(5);
	}
	
	//aliens can't change color
	@Override
	public void setColor(int r, int g, int b) {
		System.out.println("ERROR: Aliens can not change color");
	}
	
	//speed of aliens = constant * 5 
	@Override
	public void setSpeed(int h) {
		super.setSpeed(5);
	}
	
	//used to print map() in GameWorld class
	public String toString() {
		return "Alien:  loc=" + getLocX() + "," + getLocY() + "  color=[" + getRed() + "," + getGreen() + "," + getBlue() + 
				"]  direction=" + getDirection() + "  speed=" + getSpeed() + "  size=" + getSize();
	}
}
