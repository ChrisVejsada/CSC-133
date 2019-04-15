package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

public class CommandAbout extends Command{
	private GameWorld gw;
	
	/**
	 * Constructor for about
	 * @param gw
	 */
	
	public CommandAbout(GameWorld gw) {
		super("About");
		this.gw = gw;
	}
	
	/**
	 * @Override method for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		Dialog aboutBox = new Dialog("About", new TableLayout(4,1));
		Command okCommand = new Command("ok");
		
		aboutBox.add(new Label ("Robotrac Game"));
		aboutBox.add(new Label ("v1.2"));
		aboutBox.add(new Label ("Created by: Christopher Vejsada"));
		aboutBox.add(new Label ("CSC 133 A2Prj"));
		
		Command c = Dialog.show("",  aboutBox, okCommand);
		if (c == okCommand) {
			return;
		}
		
	}
	

}
