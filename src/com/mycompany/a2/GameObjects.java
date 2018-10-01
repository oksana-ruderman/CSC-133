package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public abstract class GameObjects {
	
	private int size;
	private double locX;
	private double locY;
	private int color;
	private Random rand = new Random();
	
	
//constructor used for opponents and rescuers
	public GameObjects(double x, double y, int r, int g, int b, int s) {
		locX = (double)rand.nextInt(1024);//random starting X position within the game world, initial location is randomized
		locY = (double)rand.nextInt(768);//random starting Y position within the game world;
		color = ColorUtil.rgb(r, g, b);
		size = s;
	}
	public GameObjects(double x, double y, int r, int g, int b) {
		locX = (double)rand.nextInt(1024);//random starting X position within the game world, initial location is randomized
		locY = (double)rand.nextInt(768);//random starting Y position within the game world;
		color = ColorUtil.rgb(r, g, b);
	}
//getters
	public int getSize() {
		return size;
	}
	public double getLocX() {
		return locX;
	}
	public double getLocY() {
		return locY;
	}
	public int getGreen() {
		return ColorUtil.green(color);
	}
	public int getRed() {
		return ColorUtil.red(color);
	}
	public int getBlue() {
		return ColorUtil.blue(color);
	}

//setters
	//size should be smaller than world 
	public void setSize(int s) {
		if ( s <= 1024 && s >= 0) {
			size = s;
		}
		else if (s > 1024) {
			size = 1024;
		}
	}
	
	//the location must be within the game world	
	public void setLocation(double x, double y) {
		if(x <= 1024.0 && x >=0.0){
			locX = x;
		}
		else if( x > 1024.0){
			locX = 1024.0;
		}
		else
		{
			locX = 0.0;
		}
		if(y <= 768.0 && y >=0.0){
			locY = y;
		}
		else if( y > 768.0){
			locY = 768.0;
		}
		else
		{
			locY = 0.0;
		}
	}
	
	public void setColor(int red, int green, int blue) {
		color = ColorUtil.rgb(red, green, blue);
	}
	
	public void changeSize(int s) {
		size += s;
	}
}
