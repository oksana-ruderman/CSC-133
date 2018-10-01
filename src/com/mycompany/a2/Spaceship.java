package com.mycompany.a2;

//import java.util.Random;

public class Spaceship extends Rescuers{
	
	private boolean door;
	private double xr;
	private double xl;
	private double yu;
	private double yd;
	
	private static Spaceship sh;

	//initialize spaceship's location, color, size
	private Spaceship(double x, double y, int r, int g, int b, int s) {
		super(x, y, 255, 255, 0, 100);
		door = !isDoorOpen();
	}

//getters
	public static Spaceship getSpaceship() {
		if(sh == null)
			sh = new Spaceship(30.0, 35.0 , 0, 255, 0, 70);
		return sh;
	}
	public boolean getDoor() {
		return door;
	}
	
	public double getXr() {
		return xr;
	}
	
	public double getXl() {
		return xl;
	}
	
	public double getYu() {
		return yu;
	}
	
	public double getYd() {
		return yd;
	}
	
    public void doorClose() {
    	door = !isDoorOpen();
    }
    
	public void openDoor() {
		door = isDoorOpen();
	}

	public boolean isDoorOpen() {
		return true;
	}
	
	public boolean setDoor() {
		if(isDoorOpen())
			return true;
		else
			return false;
	}
//setters
	//spaceship can't change color
	@Override 
	public void setColor(int r, int g, int b) {
		System.out.println("ERROR: A spaceship can not change color");
	}
	
	// the size of the spaceship should be between 50 and 1024 inclusive
	@Override 
	public void setSize(int s) {
		if ( s < 50) {
			s = 50;
		}
		else if ( s > 1024) {
			s = 1024;
		}
	}
	
	//set location of the door, right, left, up and down
	public void setDoorLoc() {
		int s = getSize()/2;
		xr = (double)(getLocX() + s);
		xl = (double)(getLocX() - s);
		yu = (double)(getLocY() + s);
		yd = (double)(getLocY() - s);
	}
}
