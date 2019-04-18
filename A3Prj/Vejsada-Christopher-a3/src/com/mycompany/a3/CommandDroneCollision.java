package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandDroneCollision extends Command {


	private GameWorld gw;

	/**
	 * constructor for drone
	 * @param gw
	 */
	public CommandDroneCollision(GameWorld gw) {
		super("Collide with Drone");
		this.gw = gw;
	}
	
	/**
	 * override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.robotCollision('d');

	}
}