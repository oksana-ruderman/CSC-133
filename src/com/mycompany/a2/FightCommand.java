package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FightCommand extends Command{
	
	private GameWorld gw;
	
	FightCommand(GameWorld gw){
		super("Fight");
		this.gw = gw;
	}
	@Override //do not forget @Override, makes sure you are overriding parent method
	public void actionPerformed(ActionEvent ev)
	{
		gw.collisionAlienAstr();
	}
}
