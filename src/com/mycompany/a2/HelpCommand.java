package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command{
	

	public HelpCommand() {
		super("Help");
	}
	@Override //do not forget @Override, makes sure you are overriding parent method
	public void actionPerformed(ActionEvent ev)
	{
		Command cOk = new Command("Ok");

		
		String aMessage = new String("a: Move Ship To Alien");
		String oMessage = new String("o: Move Ship To Astronaut");
		String lMessage = new String("l: Move Ship Left");
		String rMessage = new String("r: Move Ship Right");
		String uMessage = new String("u: Move Ship Up");
		String dMessage = new String("d: Move Ship Down");
		String eMessage = new String("e: Expand");
		String cMessage = new String("c: Contract");
		String wMessage = new String("w: Aliens Collide");
		String fMessage = new String("f: Fight");
		String sMessage = new String("s: Open Door");
		String tMessage = new String("t: Time Ticks Forward");
		String xMessage = new String("x: Exit Game");

		List<String> myList = new List<String>();
		
		myList.addItem(aMessage);
		myList.addItem(oMessage);
		myList.addItem(lMessage);
		myList.addItem(rMessage);
		myList.addItem(uMessage);
		myList.addItem(dMessage);
		myList.addItem(eMessage);
		myList.addItem(cMessage);
		myList.addItem(wMessage);
		myList.addItem(fMessage);
		myList.addItem(sMessage);
		myList.addItem(tMessage);
		myList.addItem(xMessage);

	
		Dialog.show("Help", myList, cOk);
	}
}
