package com.mycompany.a2;

import java.util.Random;
import java.lang.Math;

public abstract class Opponents extends GameObjects implements IMoving{
	
	//looks like in the future all opponents should have square class that extends Shape class, right now there is no need for it
	private int speed;
	private int direction;
	private final int constant = 1;
	private Random rand = new Random();
	
	//constructor used for alien ( x y location, color,       size, speed, direction
	public Opponents(double x, double y, int r, int g, int b, int s, int c, int sp) {
		super (x, y, r, g, b);
		super.setSize(rand.nextInt(31) + 20);
		speed = sp;
		//super.setDirection();
	}

//getters
	public int getSpeed() {
		return speed;
	}
	public int getDirection() {
		return direction;
	}
	public int getConstant() {
		return constant;
	}

//setters
	public void setSpeed(int h) {
		speed = constant * h;
	}
	
	//direction is chosen randomly
	public void setDirection() {
		direction = rand.nextInt(359);
		if(direction >= 360.0)//if the heading direction is greater than 359, 
		{
			direction = direction%360;
		}
		else//if the heading direction is less than 0 
		{
			direction = direction%360+360;
		}
	}
	
	//all opponents move the same way, according to their direction and speed
	public void move () {
		double curX = getLocX();
		double curY = getLocY();
		double theta = Math.toRadians(90 - direction - 5);
		double deltaX = Math.round(Math.cos(theta)*speed*10.0)/10.0;
		double deltaY = Math.round(Math.sin(theta)*speed*10.0)/10.0;
		double newX = Math.round((curX + deltaX)*10.0)/10.0;
		double newY = Math.round((curY + deltaY)*10.0)/10.0;
		setLocation(newX, newY);
		setDirection();//setting new direction
	}

	//opponents can't change size
	@Override
	public void changeSize(int s) {
		System.out.println("ERROR: opponents can not change the size");
	}
}
