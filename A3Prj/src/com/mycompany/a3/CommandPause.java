package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;


public class CommandPause extends Command {

	private GameWorld gw;

	
	/**
	 * Constructor for about
	 * @param gw
	 */
	public CommandPause(GameWorld gw) {
		super("Pause");
		this.gw = gw;
		
	}
	
	/**
	 * override method for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(gw.isIspause())
			gw.setIspause(false);
		else
			gw.setIspause(true);
		}
	
	
}