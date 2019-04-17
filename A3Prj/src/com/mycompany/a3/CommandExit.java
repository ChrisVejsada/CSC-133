package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class CommandExit extends Command {


	private GameWorld gw;

	/**
	 * Constructor for exit
	 * @param gw
	 */
	public CommandExit(GameWorld gw) {
		super("Exit");
		this.gw = gw;
		
	}
	
	/**
	 * Override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.quitGame();
		Command yes = new Command("yes");
		Command  no  = new Command("no");
		
		Label label1 = new Label("");
		
		Command c = Dialog.show("Are you sure you would like to exit", label1, yes, no);
		
		if(c == yes) {
			gw.exit();
		}
		else if (c == no) {
			gw.dontQuit();
		}
	}
}