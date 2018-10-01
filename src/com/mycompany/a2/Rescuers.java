package com.mycompany.a2;

import java.lang.Math;
public abstract class Rescuers extends GameObjects implements IGuided{
	
	//constructor for spaceship(location x and y, r g b colors, size
	public Rescuers(double x, double y, int r, int g, int b, int s) {
		super(x, y, r, g, b, s);
	}
	
//implementation of IGuided interface, which are only used for spaceship at this point
	public void moveLeft() {
		setLocation(getLocX() - 10.0 - Math.round(Math.cos(Math.toRadians(90 - 270))), getLocY());
	}
	
	public void moveRight() {
		setLocation(getLocX() + 10.0 + Math.round(Math.cos(Math.toRadians(90 - 90))), getLocY());
	}
	
	public void moveUp() {
		setLocation(getLocX(),getLocY() + 10.0 + Math.round(Math.sin(Math.toRadians(90))));
	}
	
	public void moveDown() {
		setLocation(getLocX(), getLocY() - 10.0 - Math.round(Math.sin(Math.toRadians(90 - 180))));
	}
	
	public void jumpToLocation(double x, double y) {
		setLocation(x, y);
	}
}
