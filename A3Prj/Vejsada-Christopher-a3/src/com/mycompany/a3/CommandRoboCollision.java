package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandRoboCollision extends Command {

	private GameWorld gw;

	public CommandRoboCollision(GameWorld gw) {
		super("Collide with AnotherRobot");
		this.gw = gw;
	}
	
	/**
	 * override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.robotCollision('r');
	}

}