package com.mycompany.a2;

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
	private ScoreView scoreView;
	private MapView mapView;
	public Game() {
		gw = new GameWorld();
		mapView = new MapView(gw);
		scoreView = new ScoreView(gw);
		//gw.init();
		//play();
		
		this.setLayout(new BorderLayout());
		addKeyListener('x', exitCommand);
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('f', energyCommand);
		addKeyListener('g', robocollideCommand);
		addKeyListener('t', tickCommand);
		
		Command exitCommand = new CommandExit(gw);
		Command accelerateCommand = new CommandAccelerate(gw);
		Command leftCommand = new CommandLeftHeading(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command rightCommand = new CommandRightHeading(gw);
		Command robocollideCommand = new CommandDroneCollision(gw);
		Command energyCommand = new CommandEnergyStationCollision(gw);
		Command tickCommand = new CommandGameClockTick(gw);
		
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
		
		
		//South Container
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		
		//Collide with base
		Button baseButton = new Button("Collide with Base");
		
		//vaseButton.setCommand(baseCommand);
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
		toolbar.setTitle("Robo Track");
		
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
		this.add(BorderLayout.NORTH, mapView);
		this.add(BorderLayout.CENTER, scoreView);
		gw.setMapHeight(mapView.getComponentForm().getHeight());
		gw.setMapWidth(mapView.getComponentForm().getWidth());
		gw.init();
		this.show();



		play();
	}	
	private void play() {
	}


}
		
	
	