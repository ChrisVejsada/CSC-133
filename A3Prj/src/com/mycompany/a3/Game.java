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
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable{
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	private Command pauseCommand;
	private Button pauseButton;
	UITimer timer = new UITimer(this);
	private boolean isSelected = true;
	private static int mapX, mapY;
	private BGSound bgSound = new BGSound("MechDrone7.mp3");
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		
		//gw.init();
		//play();
		this.setLayout(new BorderLayout());
		Command exitCommand = new CommandExit(gw);
		Command accelerateCommand = new CommandAccelerate(gw);
		Command leftCommand = new CommandLeftHeading(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command rightCommand = new CommandRightHeading(gw);
		//Command robocollideCommand = new CommandDroneCollision(gw);
		//Command nprcollideCommand = new CommandRobotCollision(gw);
		Command energyCommand = new CommandEnergyStationCollision(gw);
		Command tickCommand = new CommandGameClockTick(gw);
		Command positionCommand;
		positionCommand = new CommandPosition(gw);
		pauseCommand = new CommandPause(gw);
		Command strategyCommand = new StrategyCommand(gw);
		
		addKeyListener('x', exitCommand);
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('e', energyCommand);
		//addKeyListener('g', robocollideCommand);
		//addKeyListener('t', tickCommand);
		
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
		
		pauseButton = new Button("Pause");
		southContainer.addComponent(pauseButton);
		pauseButton.setCommand(pauseCommand);
		pauseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setBgTransparency(255);	
		pauseButton.getAllStyles().setMarginRight(5);
		
		Button positionButton = new Button("Position");
		southContainer.addComponent(positionButton);
		positionButton.setCommand(positionCommand);
		positionButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setBgTransparency(255);	
		positionButton.getAllStyles().setMarginRight(5);
		positionButton.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		positionButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
		
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
		gw.setWidthHeight(mv.getComponentForm().getX(), mv.getComponentForm().getY());
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		gw.init();
		UITimer timer = new UITimer(this);
		timer.schedule(20, true, this);



		play();
	}
	private void play() {
		
	}
	public void playSounds() {
		if(gw.isSound()) {
		if(gw.isEnergyCol()) {
			gw.setEnergyCol(false);
			Sound energySound = new Sound("evergy.wav", "audio/wav");
			if(!gw.isIspause())
				energySound.play();
			
		}
		if(gw.isCrashCol()) {
			gw.setCrashCol(false);
			Sound crashSound = new Sound("crash.wav", "audio/wav");
			if(!gw.isIspause())
				crashSound.play();
		}
		
		if(gw.isDeathCol()) {
			gw.setCrashCol(false);
			Sound deathSound = new Sound("death.wav", "audio/wav");
			if(!gw.isIspause())
				deathSound.play();
		}
		if(gw.isIspause()) {
			bgSound.pause();
		}else {
			
		bgSound.play(gw.isIspause());
		}
		
		}
		else {
			bgSound.pause();
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(gw.isIspause()) {
			pauseButton.setText("Play");
			bgSound.pause();
		}
		else {
			pauseButton.setText("Pause");
			playSounds();
			gw.tick(20);
		}
	}
	
	
}
		
		

		
	
	


	
	

					
				
				
			
		



	