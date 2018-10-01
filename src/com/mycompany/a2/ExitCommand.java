package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command{
	
	ExitCommand(){
		super("Exit");		
	}
	
	@Override 
	public void actionPerformed(ActionEvent ev)
	{
		Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");

		//instead of System.exit(0), CN1 recommends using exitApplication()
		if (bOk)
		{
			Display.getInstance().exitApplication();
		}
	}
}