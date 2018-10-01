package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
	private Command cOk = new Command("OK");
	
	AboutCommand(){
		super("About");
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		Label myLabel = new Label("Oksana Ruderman, CSC133, Assignment 2");
		Dialog.show("About", myLabel, cOk);
	}
}
