package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandAccelerate extends Command {
	
	private GameWorld gw;
	
	public CommandAccelerate(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
		
	}
	
	/**
	 * Override for action method
	 */
	@Override
	
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Accelerating the Robot");
		gw.setRobotSpeed(2);
	}

}
