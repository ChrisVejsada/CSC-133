package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorld model;
	public MapView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.MAGENTA));
	}
	
	public MapView () {
		
	}
	
	/**
	 * update function for when notified
	 */
	public void update (Observable o, Object arg) {
		//code to call the method in GameWorld (Observable) that output the 
		//game object info to the console
		model.map();
	
	}
}
