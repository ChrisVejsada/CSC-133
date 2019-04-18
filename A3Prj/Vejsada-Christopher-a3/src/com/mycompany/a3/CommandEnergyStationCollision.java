package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandEnergyStationCollision extends Command {


	private GameWorld gw;

	/**
	 * constructor for energy
	 * @param gw
	 */
	public CommandEnergyStationCollision(GameWorld gw) {
		super("Collided with Energy Station");
		this.gw = gw;
	}
	
	/**
	 * override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		//gw.energyStationCollision();
	}
	
}