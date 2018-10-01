package com.mycompany.a2;

import java.util.Vector;
import java.util.Random;
import java.util.Observable;

public class GameWorld extends Observable{
	//maximum score possible, could be changed to number of astronauts * 10 (if astronauts created dynamically)
	private final int maxScore = 300; 
	private int austrRescued;
	private int alienSneakedIn;
	private int austrNotRescued;
	private int alienNotSneakedIn;
	private int score;
	private int clock;
	private boolean sound = false;
	//used to make sure the object are created within these bounds
	private double upperX = 0.0;
	private final double lowerX = 0.0;
	private double upperY = 0.0;
	private final double lowerY = 0.0;
	private GameObjectCollection gameObjectCollection;

	//initializing spaceship, location is random
	Spaceship sh = Spaceship.getSpaceship();
	//initializing a vector that holds game objects
	//private Vector<GameObjects> theWorldVector = new Vector<GameObjects>();
	
	//initializing game objects and adding them to Vector
	//location, direction and size are chosen randomly, color is predetermined
	//health and speed are calculated based on a constant
	public void init() {
		Alien alien1 = new Alien(30.0, 35.0 , 0, 255, 0, 70, 70, 45, 3);
		Alien alien2 = new Alien(30.0, 35.0 , 0, 255, 0, 70, 70, 45, 3);
		Alien alien3 = new Alien(30.0, 35.0 , 0, 255, 0, 70, 70, 45, 3);
		Astronaut astr1 = new Astronaut(30.0, 35.0 , 0, 255, 0, 70, 70, 45);
		Astronaut astr2 = new Astronaut(30.0, 35.0 , 0, 255, 0, 70, 70, 45);
		Astronaut astr3 = new Astronaut(30.0, 35.0 , 0, 255, 0, 70, 70, 45);
		Astronaut astr4 = new Astronaut(30.0, 35.0 , 0, 255, 0, 70, 70, 45);

		/*theWorldVector.add(alien1);
		theWorldVector.add(alien2);
		theWorldVector.add(alien3);
		theWorldVector.add(astr1);
		theWorldVector.add(astr2);
		theWorldVector.add(astr3);
		theWorldVector.add(astr4);
		alienNotSneakedIn = 3;
		austrNotRescued = 4;*/
		gameObjectCollection = new GameObjectCollection();
		gameObjectCollection.add(alien1);
		gameObjectCollection.add(alien2);
		gameObjectCollection.add(alien3);
		gameObjectCollection.add(astr1);
		gameObjectCollection.add(astr2);
		gameObjectCollection.add(astr3);
		gameObjectCollection.add(astr4);
		alienNotSneakedIn = 3;
		austrNotRescued = 4;
	}
	//manipulate world objects and game data

	//move spaceship to a randomly selected alien
	//get error message if no aliens present
	/*public void moveShipToAlien(){ 
		Random rand = new Random();
		Vector<GameObjects> v = new Vector<GameObjects>();
		//IIterator theElements = gameObjectCollection.getIterator();
		for (int i=0; i<theWorldVector.size(); i++) {
			if (theWorldVector.elementAt(i) instanceof Alien) {
				v.add(theWorldVector.elementAt(i));
			}
		}
					int rnd = rand.nextInt( v.size() );
					Alien objAl = (Alien) v.get(rnd);
					double x = objAl.getLocX();
					double y = objAl.getLocY();
					System.out.println("Move spaceship to alien's location at: " + objAl.getLocX() + " " + objAl.getLocY());
					sh.jumpToLocation(x, y);	
					sh.setDoorLoc();
	}*/
	
	//move spaceship to a randomly selected alien
		//get error message if no aliens present
		public void moveShipToAlien(){ 
			Random rand = new Random();
			Vector <GameObjects> v = new Vector<GameObjects>();
			IIterator theElements = gameObjectCollection.getIterator();
			for (int i=0; i<theElements.size(); i++) {
				if(theElements.elementAt(i) instanceof Alien) {
					v.add((GameObjects) theElements.elementAt(i));
				}
			}
						int rnd = rand.nextInt( v.size() );
						Alien objAl = (Alien) v.get(rnd);
						double x = objAl.getLocX();
						double y = objAl.getLocY();
						System.out.println("Move spaceship to alien's location at: " + objAl.getLocX() + " " + objAl.getLocY());
						sh.jumpToLocation(x, y);	
						sh.setDoorLoc();
		}
	
	//move spaceship to a randomly selected astronaut
	//no checking for astronaut's presence in the world is needed, since the game will exit in that case
	public void moveShipToAstr() {
		if(getAstrNotRescued() == 0) {
			exit();
		}
		else {
			Random rand = new Random();
			Vector<GameObjects> v = new Vector<GameObjects>();
			IIterator theElements = gameObjectCollection.getIterator();
			for (int i=0; i<theElements.size(); i++) {
				if (theElements.elementAt(i) instanceof Astronaut) {
					v.add((GameObjects) theElements.elementAt(i));
				}
			}
					int rnd = rand.nextInt( v.size() );
					Astronaut objAstr = (Astronaut) v.get(rnd);
					double x = objAstr.getLocX();
					double y = objAstr.getLocY();
					System.out.println("Move spaceship to astronaut's location at: " + objAstr.getLocX() + " " + objAstr.getLocY());
					sh.jumpToLocation(x, y);
					sh.setDoorLoc();
		}
	}

	//make spaceship move right, update location of the door
	public void moveShipRight(){
		System.out.println("Move to the right");
		sh.moveRight();
		sh.setDoorLoc();
	}

	//make spaceship move left, update location of the door
	public void moveShipLeft() {
		System.out.println("Move to the left");
		sh.moveLeft();
		sh.setDoorLoc();
	}
	
	//make spaceship move up, update location of the door
	public void moveShipUp() {
		System.out.println("Move up");
		sh.moveUp();
		sh.setDoorLoc();
	}

	//make spaceship move down, update location of the door
	public void moveShipDown() {
		System.out.println("Move down");
		sh.moveDown();
		sh.setDoorLoc();
	}

	//expand door size by 10, check if door is open first
	public void expand() {
		if(!sh.isDoorOpen()) {
			System.out.println("Door is closed. Open door <s> and then expand it");
		}
		else {
			sh.changeSize(10);
		}
	}
	
	//contract door size by 10, check if door is open first
	public void contract() {
		if(!sh.isDoorOpen()) {
			System.out.println("Door is closed already");
		}
		else {
			sh.changeSize(-10);
			System.out.println("New ship size :" + sh.getSize());
		}
	}
	
	//move aliens and astronauts, update their direction and speed
	//clock time incremented 
	public void tick() {	
		IIterator theElements = gameObjectCollection.getIterator();
			for (int i=0; i<theElements.size(); i++) {
				Opponents opp = (Opponents)theElements.elementAt(i);
				opp.move(); 
				}
			System.out.println("Time has passed");
			clock +=1;
	}

	/*open door, update score according to the types and conditions of
	opponents that are let in to the spaceship as described above in rules of play. This
	causes all of the opponents whose centers are within the boundaries of the bounding
	square of the door to be removed from the game world.*/
	public void open() {
		sh.openDoor();
		double shxr = sh.getXr();
		double shxl = sh.getXl();
		double shyu = sh.getYu();
		double shyd = sh.getYd();
		IIterator theElements = gameObjectCollection.getIterator();
		for (int i=0; i<theElements.size(); i++) {
			Opponents opp = (Opponents)theElements.elementAt(i);
			double x = opp.getLocX();
			double y = opp.getLocY();
			if(x < shxr && x > shxl && y < shyu && y > shyd && !sh.isDoorOpen()) {
				opp.move(); 
			}
			else if(x < shxr && x > shxl && y < shyu && y > shyd && sh.isDoorOpen()) {
				if(opp instanceof Alien) {
					alienSneakedIn++;
					alienNotSneakedIn --;
					System.out.println("An alien sneaked in the spaceship");
					score = score - 10;
					theElements.removeElement(theElements.elementAt(i));
				}
				if(opp instanceof Astronaut) {
					score = score + ((Astronaut) opp).getPoints();
					if(score > maxScore) {
						score = maxScore;
					}
					austrRescued++;
					austrNotRescued --;
					System.out.println("An astronaut has been rescued");
					sh.doorClose();
					theElements.removeElement(theElements.elementAt(i));
					if(getAstrNotRescued() == 0) {
						System.out.println("All astronauts been rescued");
						exit();
					}
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	
	/*this is a pretend method
	when 2 aliens collide new alien is created, check if at least 2 aliens present, chose one, create
    new alien to the location close to chosen alien, if aliens in world < 2 print error*/
	public void collisionAliens() {
		Random rand = new Random();
		Vector<GameObjects> v = new Vector<GameObjects>();
		IIterator theElements = gameObjectCollection.getIterator();
		for (int i=0; i<theElements.size(); i++) {
			if (theElements.elementAt(i) instanceof Alien) {
				v.add((GameObjects)theElements.elementAt(i));
			}
		}
		if(v.size() < 2) {
			System.out.println("Less than 2 aliens present in the world, no alien collision is possible");
		}
		else {
			int rnd = rand.nextInt( v.size() );
			Alien objAl = (Alien) v.get(rnd);
			double x = objAl.getLocX();
			double y = objAl.getLocY();
			Alien alien4 = new Alien(x + 20.0, y + 30.0 , 0, 255, 0, 70, 70, 45, 3);
			gameObjectCollection.add(alien4);
			System.out.println("New alien created ");
			alienNotSneakedIn++;
	    }
		setChanged();
		notifyObservers();
	}
	
	/*this is a pretend method
	when alien and astronaut collide fight occurs, randomly pick astronaut, decrement it's health
    update it's speed, change the color. no aliens - print error*/
    public void collisionAlienAstr() {
		Random rand = new Random();
		int count = 0;
		Vector<GameObjects> v = new Vector<GameObjects>();
		IIterator theElements = gameObjectCollection.getIterator();
		for (int i=0; i<theElements.size(); i++) {
			if (theElements.elementAt(i) instanceof Astronaut) {
				v.add((GameObjects)theElements.elementAt(i));
			}
			if (theElements.elementAt(i) instanceof Alien) {
				count++;
			}
		}
		if(count < 1) {
			System.out.println("No aliens present in the world, collision is not possible");
		}
		else {
			System.out.println("There has been a fight. Astronaut has been injured");
			int rnd = rand.nextInt( v.size() );
			Astronaut objAstr = (Astronaut) v.get(rnd);
			objAstr.setHealth(objAstr.getHealth() - 1);
			objAstr.setSpeed(objAstr.getHealth());
			objAstr.setColor(0, objAstr.getGreen() - 25, objAstr.getBlue() - 25);
			objAstr.setPoints(1);
	    }
		setChanged();
		notifyObservers();
    }

	//Display game statistics
	public void points(){
		open();
		//map();
		System.out.println("Game statistics:");
		System.out.println("Astronauts rescued: " + getAustrRescued());
		System.out.println("Astronauts in the world: " + getAstrNotRescued());
		System.out.println("Aliens sneaked in the spaceship: " + getAlienSneakedIn());
		System.out.println("Aliens in the world: " + getAlienNotSneakedIn());
		System.out.println("Your score: "+ getScore());  
	}
    
	public int getAustrRescued() {
		return austrRescued;
	}
	public int getAlienSneakedIn() {
		return alienSneakedIn;
	}
	public int getAstrNotRescued() {
		return austrNotRescued;
	}
	public int getAlienNotSneakedIn() {
		//System.out.println("Aliens not sneked: " + alienNotSneakedIn);
		return alienNotSneakedIn;
	}
	public int getScore() {
		//notifyObservers();
		return score;
	}
	public boolean getSound() {
		return sound;
	}
	public void changeSound(){
		if(sound == true){
			sound = false;
		}
		else{
			sound = true;
		}
		setChanged();
		notifyObservers();
	}
	//display world state
	public void map(){
		System.out.println("Map statistics:");
		
		//print spaceship statistics
		System.out.println("Spaceship:  loc=" + sh.getLocX() + "," + sh.getLocY() + 
				"  color=[" + sh.getRed() + "," + sh.getGreen() + "," + sh.getBlue() + 
				"]  size=" + sh.getSize());
		
		//Iterate through the objects to call their toString() method
		IIterator theElements = gameObjectCollection.getIterator();
		for (int i=0; i<theElements.size(); i++) {
			if (theElements.elementAt(i) instanceof Astronaut) {
				Astronaut objAstr = (Astronaut)theElements.elementAt(i);
				System.out.println(objAstr.toString());
			}
			if (theElements.elementAt(i) instanceof Alien) {
				Alien objAl = (Alien)theElements.elementAt(i);
				System.out.println(objAl.toString());
			}
		}
		//setChanged();
		//notifyObservers();
	}
	
	//exit the game
	public void exitGame() {
		System.out.println("Exit the game?");
	}

	//exit the game
	public void exit(){
		System.out.println();
		System.out.println("Game over");
		points();
		System.exit(0);
		if( austrNotRescued < 0) {
			System.exit(0);
		}
	}
	//method to ensure that all objects are within the range of the gameWorld
		private boolean locationStart(){
			IIterator theElements = gameObjectCollection.getIterator();

			boolean validLocationFlag = true;
			for (int i=0; i<theElements.size(); i++) {
					
				GameObjects objGameObject = (GameObjects) theElements.elementAt(i);
				if( objGameObject.getLocX() > upperX){
					validLocationFlag = false;
				}
				else if (objGameObject.getLocX() < lowerX)
				{
					validLocationFlag = false;
				}
		
				if(  objGameObject.getLocY() > upperY){
					validLocationFlag = false;
		
				}
				else if(objGameObject.getLocY() < lowerY)
				{
					validLocationFlag = false;
				}
				
			}
			return validLocationFlag;
		}
	//method to set the bounds of the world, used in Game 
		public void setBounds(double x, double y){
			upperX = x;
			upperY = y;
			//make sure all object are within the Game World
			if(locationStart() == true)
			{
				System.out.println("All objects are contained within the game world");
			}
			else
			{
				System.out.println("One or many objects are not contained within the game world");
				System.exit(0);
			}
		}
}
