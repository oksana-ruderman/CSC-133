package com.mycompany.a2;

public interface IGuided {//all rescuers are guided
	void moveLeft();
	void moveRight();
	void moveUp();
	void moveDown();
	void jumpToLocation(double x, double y);
}
