/*package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play() {
	//accept and execute user commands	
		Label myLabel = new Label ("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String sCommand = myTextField.getText().toString();
					myTextField.clear();
					//these inputs invoke corresponding functions from GameWorld class
					//each function has a comment inside the GameWorld class
					
			 //check for correct input
			 if(sCommand.charAt(0) == 'a' || sCommand.charAt(0) == 'o' || sCommand.charAt(0) == 'r' || sCommand.charAt(0) == 'l' || sCommand.charAt(0) == 'u' || sCommand.charAt(0) == 'd'
					 || sCommand.charAt(0) == 'e' || sCommand.charAt(0) == 'c' || sCommand.charAt(0) == 't' || sCommand.charAt(0) == 's' || sCommand.charAt(0) == 'w' || sCommand.charAt(0) == 'f'
					 || sCommand.charAt(0) == 'p' || sCommand.charAt(0) == 'm' || sCommand.charAt(0) == 'x') {
				switch (sCommand.charAt(0)) {
					case 'a':
						gw.moveShipToAlien(); 
						break;
					case 'o':
						gw.moveShipToAstr();
						break;
					case 'r':
						gw.moveShipRight();
						break;
					case 'l':
						gw.moveShipLeft();
						break;
					case 'u':
						gw.moveShipUp();
						break;
					case 'd':
						gw.moveShipDown();
						break;
					case 'e':
						gw.expand();
						break;
					case 'c':
						gw.contract();
						break;
					case 't':
						gw.tick();
						break;
					case 's':
						gw.open();
						break;
					case 'w':
						gw.collisionAliens();
						break;
					case 'f':
						gw.collisionAlienAstr();
						break;
					case 'p':
						gw.points();
						break;
					case 'm':
						gw.map();
						break;
					case 'x':
						gw.exitGame();//this will ask if the player wants to exit the game ( in the text)
						final TextField myTextField2=new TextField(); //create a new input for y and n
						addComponent(myTextField2);//add it to the form
						removeComponent(myTextField);//remove the previous text field temporarily
						show();//update form
						myTextField2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt2) {
								String sCommand2=myTextField2.getText().toString();
								myTextField2.clear();
								if(sCommand2.charAt(0) == 'y' || sCommand2.charAt(0) == 'n'){ 
										switch (sCommand2.charAt(0)){
										case'y':
											gw.exit();//exits the game
											break;
										case 'n':
											System.out.println("You chose to stay in the game. "
													+ "If you want to exit the game input <x> and then <y>");
											//restore form before exit was called
											addComponent(myTextField);
											removeComponent(myTextField2);
											show();
											break;
										}
								}
								else {
									System.out.println("Please enter an appropriate letter");
								}
							}
						});
						break;
			}
				} //switch
			 else {
				 System.out.println("Please enter an appropriate letter");
			 }
			} //actionPerformed
		} ); //new ActionListener
		//addActionListener
	} //play
}*/


package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	public Game() {

		//create "Observable" GameWorld, "Observers" for MapView and ScoreView
		gw = new GameWorld();
		gw.init();
		mv = new MapView(gw);
		sv = new ScoreView(gw);
		
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Button expandButton = new Button("Expand");
		Button upButton = new Button("Up");
		Button leftButton = new Button("Left");
		Button moveToAstrButton = new Button("MoveToAstronaut");
		Button contractButton = new Button("Contract");
		Button downButton = new Button("Down");
		Button rightButton = new Button("Right");
		Button moveToAlienButton = new Button("MoveToAlien");
		Button scoreButton = new Button("Score");
		Button newAlienButton = new Button("NewAlien");
		Button fightButton = new Button("Fight");
		Button tickButton = new Button("Tick");
		Button exitButton = new Button("Exit");
		
		//setting toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		myToolbar.setTitle("Space Fights Game");

		setLayout(new BorderLayout());

		//assigning buttons with commands
		ExpandCommand expandCommand = new ExpandCommand(gw);
		expandButton.setCommand(expandCommand);
		addKeyListener('e', expandCommand);
		
		UpCommand upCommand = new UpCommand(gw);
		upButton.setCommand(upCommand);
		addKeyListener('u', upCommand);
		
		DownCommand downCommand = new DownCommand(gw);
		downButton.setCommand(downCommand);
		addKeyListener('d', downCommand);
		
		LeftCommand leftCommand = new LeftCommand(gw);
		leftButton.setCommand(leftCommand);
		addKeyListener('l', leftCommand);
		
		RightCommand rightCommand = new RightCommand(gw);
		rightButton.setCommand(rightCommand);
		addKeyListener('r', rightCommand);		
		
		MoveShipToAlienCommand moveToAlCommand = new MoveShipToAlienCommand(gw);
		moveToAlienButton.setCommand(moveToAlCommand);
		addKeyListener('a', moveToAlCommand);
		
		MoveShipToAstronautCommand moveToAstrCommand = new MoveShipToAstronautCommand(gw);
		moveToAstrButton.setCommand(moveToAstrCommand);
		addKeyListener('o', moveToAstrCommand);
		
		ContractCommand contractCommand = new ContractCommand(gw);
		contractButton.setCommand(contractCommand);
		addKeyListener('c', contractCommand);
		
		TickCommand tickCommand = new TickCommand(gw);
		tickButton.setCommand(tickCommand);
		addKeyListener('t', tickCommand);
		
		NewAlienCommand newAlienCommand = new NewAlienCommand(gw);
		newAlienButton.setCommand(newAlienCommand);
		addKeyListener('w', newAlienCommand);
		
		FightCommand fightCommand = new FightCommand(gw);
		fightButton.setCommand(fightCommand);
		addKeyListener('f', fightCommand);
		
		ScoreCommand scoreCommand = new ScoreCommand(gw);
		scoreButton.setCommand(scoreCommand);
		addKeyListener('s', scoreCommand);
		myToolbar.addCommandToSideMenu(scoreCommand);

		ExitCommand  exitCommand = new ExitCommand();
		exitButton.setCommand(exitCommand);
		addKeyListener('x', exitCommand);
		myToolbar.addCommandToSideMenu(exitCommand);
		
		SoundCommand soundCommand = new SoundCommand(gw);
		CheckBox soundSideMenuComp = new CheckBox("Sound");
		soundSideMenuComp.getAllStyles().setBgTransparency(255);
		soundSideMenuComp.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundSideMenuComp.setCommand(soundCommand);	
		soundCommand.putClientProperty("SideComponent", soundSideMenuComp);	
		myToolbar.addCommandToSideMenu(soundCommand);
		
		AboutCommand aboutCommand = new AboutCommand();
		myToolbar.addCommandToSideMenu(aboutCommand);
		
		HelpCommand myHelpCommand = new HelpCommand();
		myToolbar.addCommandToRightBar(myHelpCommand);
		
		//adding ScoreView to NORTH component
		add(BorderLayout.NORTH,sv);
		
		leftContainer.getAllStyles().setPadding(Component.TOP, 100);

		//setting styles for all the buttons
		expandButton.getUnselectedStyle().setBgTransparency(255);
		expandButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		expandButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		expandButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		expandButton.getAllStyles().setPadding(Component.TOP, 5);
		expandButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		expandButton.getAllStyles().setPadding(Component.RIGHT, 5);
		expandButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		moveToAstrButton.getUnselectedStyle().setBgTransparency(255);
		moveToAstrButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		moveToAstrButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		moveToAstrButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		moveToAstrButton.getAllStyles().setPadding(Component.TOP, 5);
		moveToAstrButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		moveToAstrButton.getAllStyles().setPadding(Component.RIGHT, 5);
		moveToAstrButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		leftButton.getUnselectedStyle().setBgTransparency(255);
		leftButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		leftButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		leftButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		leftButton.getAllStyles().setPadding(Component.TOP, 5);
		leftButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		leftButton.getAllStyles().setPadding(Component.RIGHT, 5);
		leftButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		upButton.getUnselectedStyle().setBgTransparency(255);
		upButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		upButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		upButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		upButton.getAllStyles().setPadding(Component.TOP, 5);
		upButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		upButton.getAllStyles().setPadding(Component.RIGHT, 5);
		upButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		exitButton.getUnselectedStyle().setBgTransparency(255);
		exitButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		exitButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		exitButton.getAllStyles().setPadding(Component.TOP, 5);
		exitButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		exitButton.getAllStyles().setPadding(Component.RIGHT, 5);
		exitButton.getAllStyles().setPadding(Component.LEFT, 5);
		exitButton.getSelectedStyle().setBgTransparency(125);
		
		//setting left buttons to same height and width
		Component.setSameWidth(expandButton, upButton, leftButton, moveToAstrButton);
		Component.setSameHeight(expandButton, upButton, leftButton, moveToAstrButton);
		
		//adding buttons to left container and WEST component
		leftContainer.add(expandButton);
		leftContainer.add(upButton);
		leftContainer.add(leftButton);
		leftContainer.add(moveToAstrButton);
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		add(BorderLayout.WEST,leftContainer);

		mv.getAllStyles().setBgTransparency(255);
		mv.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		mv.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		add(BorderLayout.CENTER,mv);
		
		//creating new container 
		Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		//setting styles for all buttons
		contractButton.getUnselectedStyle().setBgTransparency(255);
		contractButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		contractButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		contractButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		contractButton.getAllStyles().setPadding(Component.TOP, 5);
		contractButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		contractButton.getAllStyles().setPadding(Component.RIGHT, 5);
		contractButton.getAllStyles().setPadding(Component.LEFT, 5);

		downButton.getUnselectedStyle().setBgTransparency(255);
		downButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		downButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		downButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		downButton.getAllStyles().setPadding(Component.TOP, 5);
		downButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		downButton.getAllStyles().setPadding(Component.RIGHT, 5);
		downButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		rightButton.getUnselectedStyle().setBgTransparency(255);
		rightButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		rightButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		rightButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		rightButton.getAllStyles().setPadding(Component.TOP, 5);
		rightButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		rightButton.getAllStyles().setPadding(Component.RIGHT, 5);
		rightButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		moveToAlienButton.getUnselectedStyle().setBgTransparency(255);
		moveToAlienButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		moveToAlienButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		moveToAlienButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		moveToAlienButton.getAllStyles().setPadding(Component.TOP, 5);
		moveToAlienButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		moveToAlienButton.getAllStyles().setPadding(Component.RIGHT, 0);
		moveToAlienButton.getAllStyles().setPadding(Component.LEFT, 0);
		
		scoreButton.getUnselectedStyle().setBgTransparency(255);
		scoreButton.getUnselectedStyle().setBgColor(ColorUtil.CYAN);
		scoreButton.getUnselectedStyle().setFgColor(ColorUtil.BLACK);
		scoreButton.getAllStyles().setBorder(Border.createDottedBorder(4, 255));
		scoreButton.getAllStyles().setPadding(Component.TOP, 5);
		scoreButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		scoreButton.getAllStyles().setPadding(Component.RIGHT, 5);
		scoreButton.getAllStyles().setPadding(Component.LEFT, 5);
		
		rightContainer.getAllStyles().setPadding(Component.TOP, 100);
		
		//setting same height and width for buttons on the right side
		Component.setSameWidth(scoreButton, moveToAlienButton, rightButton, downButton, contractButton);
		Component.setSameHeight(scoreButton, moveToAlienButton, rightButton, downButton, contractButton);
		
		//adding buttons to right container
		rightContainer.add(contractButton);
		rightContainer.add(downButton);
		rightContainer.add(rightButton);
		rightContainer.add(moveToAlienButton);
		rightContainer.add(scoreButton);
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		add(BorderLayout.EAST,rightContainer);

		//create bottom container
		//Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));
		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		//bottomContainer.getAllStyles().setPadding(Component.LEFT, 425);
		
		//setting style for bottom buttons
		newAlienButton.getUnselectedStyle().setBgTransparency(255);
		newAlienButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		newAlienButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		newAlienButton.getAllStyles().setBorder(Border.createDottedBorder(4, 100));
		newAlienButton.getAllStyles().setPadding(Component.TOP, 5);
		newAlienButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		newAlienButton.getAllStyles().setPadding(Component.RIGHT, 0);
		newAlienButton.getAllStyles().setPadding(Component.LEFT, 0);
		newAlienButton.getSelectedStyle().setBgTransparency(125);
		
		fightButton.getUnselectedStyle().setBgTransparency(255);
		fightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		fightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);	
		fightButton.getAllStyles().setBorder(Border.createDottedBorder(4, 100));
		fightButton.getAllStyles().setPadding(Component.TOP, 5);
		fightButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		fightButton.getAllStyles().setPadding(Component.RIGHT, 0);
		fightButton.getAllStyles().setPadding(Component.LEFT, 0);
		fightButton.getSelectedStyle().setBgTransparency(125);

		tickButton.getUnselectedStyle().setBgTransparency(255);
		tickButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		tickButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBorder(Border.createDottedBorder(4, 100));
		tickButton.getAllStyles().setPadding(Component.TOP, 5);
		tickButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		tickButton.getAllStyles().setPadding(Component.RIGHT, 0);
		tickButton.getAllStyles().setPadding(Component.LEFT, 0);
		tickButton.getSelectedStyle().setBgTransparency(125);
		
		//setting bottom buttons to same height and width
		Component.setSameWidth(tickButton, fightButton, newAlienButton);
		Component.setSameHeight(tickButton, fightButton, newAlienButton);
		
		//adding bottom buttons to bottom container
		bottomContainer.add(newAlienButton);
		bottomContainer.add(fightButton);
		bottomContainer.add(tickButton);
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		
		//adding bottom container to SOUTH component
		add(BorderLayout.SOUTH,bottomContainer);
		this.show();
		
		//must be done after the show, or it won't exist yet
		gw.setBounds(mv.getWidth(), mv.getHeight());
	}
}
