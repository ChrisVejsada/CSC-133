package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandEnergyStationCollision extends Command {


	private GameWorld gw;

	/**
	 * constructor for energy
	 * @param gw
	 */
	public CommandEnergyStationCollision(GameWorld gw) {
		super("Collide with Energy Station");
		this.gw = gw;
	}
	
	/**
	 * override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.energyStationCollision();
	}
	
}