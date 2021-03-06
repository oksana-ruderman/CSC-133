package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command{
	
	private GameWorld gw;
	
	SoundCommand(GameWorld gw){
		super("Sound");
		this.gw = gw;
		
	}
	@Override //do not forget @Override, makes sure you are overriding parent method
	public void actionPerformed(ActionEvent ev)
	{
		gw.changeSound();
	}
}