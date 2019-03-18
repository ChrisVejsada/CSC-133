package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {
	
	private GameWorld model;
	
	//labels
	private Label livesLabel;
	private Label livesValue;
	private Label clockLabel;
	private Label clockValue;
	private Label lastBaseLabel;
	private Label lastBaseValue;
	private Label energyLevelLabel; 
	private Label energyLevelValue; 
	private Label healthLevelLabel;
	private Label healthLevelValue;
	private Label soundLabel;
	private Label soundValue;
	
	public ScoreView(Observable gw) {
		model = ((GameWorld) gw);
		gw.addObserver(this);
		this.setLayout(new FlowLayout(Component.CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.MAGENTA));
		this.setupLabels();
		
		this.add(livesLabel);
		this.add(livesValue);
		this.add(clockLabel);
		this.add(clockValue);
		this.add(lastBaseLabel);
		this.add(lastBaseValue);
		this.add(energyLevelLabel);
		this.add(energyLevelValue);
		this.add(healthLevelLabel);
		this.add(healthLevelValue);
		this.add(soundLabel);
		this.add(soundValue);
	// TODO Auto-generated constructor stub
	}
	
public void setupLabels() {
		
		// show number of lives left
		livesLabel = new Label("Lives: ");
		livesValue = new Label("" + model.getLives());
		livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		// show current clock value
		clockLabel = new Label("Clock: ");
		clockValue = new Label("" + model.getClock());
		clockLabel.getAllStyles().setFgColor(ColorUtil.BLUE);

		// show last base Reached
		lastBaseLabel = new Label("Last Base Reached: ");
		lastBaseValue = new Label("" + model.getRobotBaseReached());
		lastBaseLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		lastBaseValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		// show energy Level
		energyLevelLabel = new Label("Player Energy Level: ");
		energyLevelValue = new Label("" + model.getEnergyLevel());
		energyLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		energyLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
		// show healthLevel
		healthLevelLabel = new Label("Damage Level: ");
		healthLevelValue = new Label("" + model.getRobotHealthLevel());
		healthLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		healthLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		soundLabel = new Label("Sound: ");
		soundValue = new Label("" + model.isSound());
		soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
	}

	public void updatew() {
		livesValue.setText("" + model.getLives());
		livesValue.getParent().revalidate();
		clockValue.setText("" + model.getClock());
		clockValue.getParent().revalidate();
		lastBaseValue.setText("" + model.getRobotBaseReached());
		lastBaseValue.getParent().revalidate();
		energyLevelValue.setText("" + model.getEnergyLevel());
		energyLevelLabel.getParent().revalidate();
		healthLevelValue.setText("" + model.getRobotHealthLevel());
		healthLevelValue.getParent().revalidate();
		soundValue.setText("" + model.isSound());
		soundValue.getParent().revalidate();
	}

	@Override
	public void update(Observable observable, Object data) {
		this.updatew();
		
	}
}


