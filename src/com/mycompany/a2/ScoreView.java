package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer{
	private GameWorld gameWorld = null;
	
	private Label astrRescued;
	private Label alienSneakedIn;
	private Label astrNotRescued;
	private Label alienNotSneakedIn;
	private Label score;
	private Label sound;

	public ScoreView(GameWorld model) 
	{ 
		gameWorld = model;
		model.addObserver(this); // registers itself as an Observer
		//gameWorld.addObserver(this);
		
		Label totalScoreLabel = new Label("Total Score: ");
		Label astrRescuedLabel = new Label("Astronauts Rescued: ");
		Label alienSneakedInLabel = new Label("Aliens Sneaked In: ");
		Label astrRemainLabel = new Label("Astronauts Remaining: ");
		Label alienRemainLabel = new Label("Aliens Remaining: ");
		Label soundLabel = new Label("Sound: ");
		
		astrRescued = new Label(String.valueOf(gameWorld.getAustrRescued()));
		alienSneakedIn = new Label(String.valueOf(gameWorld.getAlienSneakedIn()));
		astrNotRescued = new Label(String.valueOf(gameWorld.getAstrNotRescued()));
		alienNotSneakedIn = new Label(String.valueOf(gameWorld.getAlienNotSneakedIn()));
		score = new Label(String.valueOf(gameWorld.getScore()));
		
		if(gameWorld.getSound() == false){
			sound = new Label("OFF");
		}
		else{
			sound = new Label("ON");
		}

		totalScoreLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		score.getAllStyles().setFgColor(ColorUtil.BLUE);
		score.getAllStyles().setPaddingRight(0);

		astrRescuedLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		astrRescued.getAllStyles().setFgColor(ColorUtil.BLUE);
		astrRescued.getAllStyles().setPaddingRight(0);

		alienSneakedInLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		alienSneakedIn.getAllStyles().setFgColor(ColorUtil.BLUE);
		alienSneakedIn.getAllStyles().setPaddingRight(0);

		astrRemainLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		astrNotRescued.getAllStyles().setFgColor(ColorUtil.BLUE);
		astrNotRescued.getAllStyles().setPaddingRight(0);

		alienRemainLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		alienNotSneakedIn.getAllStyles().setFgColor(ColorUtil.BLUE);
		alienNotSneakedIn.getAllStyles().setPaddingRight(0);

		soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		sound.getAllStyles().setFgColor(ColorUtil.BLUE);
		sound.getAllStyles().setPaddingRight(0);

		setLayout(new FlowLayout());
		getAllStyles().setPadding(LEFT, 0);
		getAllStyles().setPadding(RIGHT, 0);
		add(astrRescuedLabel);
		add(astrRescued);
		add(alienSneakedInLabel);
		add(alienSneakedIn);
		add(astrRemainLabel);
		add(astrNotRescued);
		add(alienRemainLabel);
		add(alienNotSneakedIn);
		add(totalScoreLabel);
		add(score);
		add(soundLabel);
        add(sound);
	}

	//@Override
	public void update(Observable observable, Object data) {

		alienNotSneakedIn.setText(String.valueOf(gameWorld.getAlienNotSneakedIn()));
		alienNotSneakedIn.getParent().revalidate();
		
		astrNotRescued.setText(String.valueOf(gameWorld.getAstrNotRescued()));
		astrNotRescued.getParent().revalidate();

		alienSneakedIn.setText(String.valueOf(gameWorld.getAlienSneakedIn()));
		alienSneakedIn.getParent().revalidate();

		astrRescued.setText(String.valueOf(gameWorld.getAustrRescued()));
		astrRescued.getParent().revalidate();

		score.setText(String.valueOf(gameWorld.getScore()));
		score.getParent().revalidate();
		
		if(gameWorld.getSound() == false){
			sound.setText("OFF");
		}
		else{
			sound.setText("ON");
		}
		sound.getParent().revalidate();
	}
}
