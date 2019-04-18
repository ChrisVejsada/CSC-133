package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;


public class CommandPosition extends Command {

	private GameWorld gw;

	
	/**
	 * Constructor for about
	 * @param gw
	 */
	public CommandPosition(GameWorld gw) {
		super("Position");
		this.gw = gw;
		
	}
	
	/**
	 * override method for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {

		gw.setPositionable(true);
	}
	
	
}