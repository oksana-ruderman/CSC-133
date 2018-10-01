package com.mycompany.a2;

public class Astronaut extends Opponents{
	
	private int health;
	private int points = 10;
	
	//constructor
	public Astronaut(double x, double y, int r, int g, int b, int s, int c, int sp) {
		super(x, y, 0, 255, 255, s, c, sp);
		health = 5;
		super.setDirection();
		super.setSpeed(getHealth());
	}
	
//getter
	public int getHealth() {
		return health;
	}
	
	public int getPoints() {
		return points;
	}
	
//setter
	//health range is 0 - 5
	public void setHealth(int h) {
		if(h>5) {
			health = 5;
		}
		else if(h<0) {
			health = 0;
		}
		else {
			health = h;
		}
	}
	
	//astronaut's speed = health*constant
	public void setSpeed(int h) {
		super.setSpeed(getHealth());
	}
	
	//astronaut's color fades as it gets into fights
	@Override
	public void setColor(int red, int green, int blue) {
		super.setColor(0, getGreen() - 25, getBlue()-25);
	}
	//calculating points
	public void setPoints(int f) {
		points = (getPoints() - f); 
		if(points < 0) {
			points = 0;
		}
		if(points > 10) {
			points = 10;
		}
	}
	//used to print map() in GameWorld class
	public String toString(){
		return "Astronaut:  loc=" + getLocX() + "," + getLocY() + "  color=[" + getRed() + "," + getGreen() + "," + getBlue() + "]  "
				+ "direction=" + getDirection() + "  speed=" + getSpeed() + "  size=" + getSize() +  "  health=" + getHealth() + " points=" + getPoints();
	}
}