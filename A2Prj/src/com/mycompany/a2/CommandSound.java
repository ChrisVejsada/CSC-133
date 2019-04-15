package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandSound extends Command {
	private GameWorld gw;
	/**
	 * constuctor for sound
	 * @param gw
	 */
	public CommandSound(GameWorld gw) {
		super("Sound");
		this.gw = gw;
		
	}
	/**
	 * override for sound
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.toggleSound();
	}

}
