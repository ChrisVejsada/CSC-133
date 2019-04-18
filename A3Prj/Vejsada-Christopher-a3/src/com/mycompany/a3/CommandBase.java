package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CommandBase extends Command {

	private GameWorld gw;

	/**
	 * Constructor for base
	 * @param gw
	 */
	public CommandBase(GameWorld gw) {
		super("Collide with Base");
		this.gw = gw;
	}
	
	
	/**
	 * override for action
	 * @param baseNumber 
	 */
	public void actionPerformed(ActionEvent ev, int baseNumber) {
		
		gw.baseCollision(baseNumber);
	}
}