package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String; 
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import java.util.Observable; 

public class Game extends Form {
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		gw.addObserver(mv); // register the map observer
		gw.addObserver(sv);
		//gw.init();
		//play();
		this.setLayout(new BorderLayout());
		Command exitCommand = new CommandExit(gw);
		Command accelerateCommand = new CommandAccelerate(gw);
		Command leftCommand = new CommandLeftHeading(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command rightCommand = new CommandRightHeading(gw);
		Command robocollideCommand = new CommandDroneCollision(gw);
		Command nprcollideCommand = new CommandRobotCollision(gw);
		Command energyCommand = new CommandEnergyStationCollision(gw);
		Command tickCommand = new CommandGameClockTick(gw);
		
		addKeyListener('x', exitCommand);
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('f', energyCommand);
		addKeyListener('g', robocollideCommand);
		addKeyListener('t', tickCommand);
		
		//West Container
		Container westContainer = new Container();
		westContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		westContainer.setLayout(new BoxLayout(2));
		
		//Accelerate
		Button accelerateButton = new Button("Accelerate");
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginBottom(10); 
		
		
		
		//Left
		Button leftButton = new Button("Left");
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);	
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);	
		leftButton.getAllStyles().setMarginBottom(10);
		
		Button changeButton = new Button("Change Strategies");
		//changeButton.setCommand(changeCommand);
		westContainer.addComponent(changeButton);	
		changeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		changeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		changeButton.getAllStyles().setBgTransparency(255);	
		changeButton.getAllStyles().setMarginBottom(10);
		
		//East Container with brake and right
		Container eastContainer = new Container();
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		eastContainer.setLayout(new BoxLayout(2));
		
		//Brake
		Button brakeButton = new Button("Brake");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);	
		brakeButton.getAllStyles().setMarginBottom(10);
		
		//Right
		Button rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);	
		rightButton.getAllStyles().setMarginBottom(10);
		
		Container centerContainer = new Container();
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.MAGENTA));
		
		//South Container
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		
		//Collide with NPR
		Button NPRButton = new Button("Collide with NPR");
		southContainer.addComponent(NPRButton);
		NPRButton.setCommand(nprcollideCommand);
		NPRButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		NPRButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		NPRButton.getAllStyles().setBgTransparency(255);	
		NPRButton.getAllStyles().setMarginRight(5);
		
		//Collide with base
		Button baseButton = new Button("Collide with Base");
		//baseButton.setCommand(baseCommand);
		baseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		baseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		baseButton.getAllStyles().setBgTransparency(255);	
		baseButton.getAllStyles().setMarginRight(5);
		southContainer.addComponent(baseButton);
		
		//Collide with Drone
		Button collideButton = new Button("Collide with Drone");
		southContainer.addComponent(collideButton);
		collideButton.setCommand(robocollideCommand);
		collideButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		collideButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		collideButton.getAllStyles().setBgTransparency(255);	
		collideButton.getAllStyles().setMarginRight(5);
		
		//Collide with Energy
		Button energyButton = new Button("Collide with Energy Station");
		southContainer.add(energyButton);
		energyButton.setCommand(energyCommand);
		energyButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		energyButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		energyButton.getAllStyles().setBgTransparency(255);	
		energyButton.getAllStyles().setMarginRight(5);
		
		//Tick/game time
		Button tickButton  = new Button("Tick");
		tickButton.setCommand(tickCommand);
		southContainer.add(tickButton);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);	
		tickButton.getAllStyles().setMarginRight(5);
		
		//setup the toolbar for the gui
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Robo Track ");
		
		//Acc,left and change 
		toolbar.addCommandToSideMenu(accelerateCommand);
		Command soundCommand = new CommandSound(gw);
		CheckBox soundCheck = new CheckBox("Sound");
		soundCheck.setCommand(soundCommand);
		toolbar.addComponentToSideMenu(soundCheck );
		Command aboutInfoCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutInfoCommand);

		toolbar.addCommandToSideMenu(exitCommand);	
		
		Command helpButton = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpButton);
		
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, mv);
		this.add(BorderLayout.CENTER, sv);
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		gw.init();
		this.show();



		
	}	
	private void play() {
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt) {
				
			
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch(sCommand.charAt(0)) {
				case 'x':
					//System.out.println("Please Confirm to exit");
					myLabel.setText("Please enter y or n");
					gw.quitGame();
					break;
				
				case 'a':
					gw.setRobotSpeed(2);
					break;
				
				case 'b':
					gw.setRobotSpeed(-2);
					break;
				
				case 'l':
					gw.changeHeading('l');
					break;
				
				case 'r':
					gw.changeHeading('r');
					break;
				
				case 'c':
					gw.robotCollision('r');
					break;
				
				case '1':
					gw.baseCollision(1);
					break;
				
				case '2':
					gw.baseCollision(2);
					break;
				
				case '3':
					gw.baseCollision(3);
					break;
				
				case '4':
					gw.baseCollision(4);
					break;
				
				case '5':
					gw.baseCollision(5);
					break;
				
				case '6':
					gw.baseCollision(6);
					break;
				
				case '7':
					gw.baseCollision(7);
					break;
				
				case '8':
					gw.baseCollision(8);
					break;
				
				case '9':
					gw.baseCollision(9);
					break;
				
				case 'e':
					gw.energyStationCollision();
					break;
				
				case 'g':
					gw.robotCollision('d');
					break;
				
				case 't':
					gw.tick();;
					break;
				
				case 'd':
					gw.display();
					break;
				
				case 'm':
					gw.map();
					break;
				
				case 'n':
					gw.dontQuit();
					myLabel.setText("Enter a Command:");
					break;
				
				case 'y':
					gw.exit();
					break;
					
				
				}
			}
		});
	}
	
}
	
	