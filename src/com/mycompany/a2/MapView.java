package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

public class MapView extends Container implements Observer{
	
	private GameWorld gameWorld = null;
	//private TextArea mapStats;
	
	//private GameWorld gameWorld;
	public MapView(GameWorld model) 
	{ // this constructor also
		gameWorld = model;
		model.addObserver(this); // registers itself as an Observer
		//gameWorld.addObserver(this);
		//Label mapStats = new Label("Map Statistics: ");
		/*mapStats = new TextArea();
		setLayout(new BoxLayout(BoxLayout.X_AXIS));
		getAllStyles().setPadding(LEFT, 100);
		add(mapStats);*/
	}

	//@Override
	public void update(Observable o, Object arg) {
		gameWorld.map();
		//mapStats.setText(String.valueOf(gameWorld.getAlienNotSneakedIn()));
		//mapStats.getParent().revalidate();
		//gameWorld.map().revalidate();
	}
}