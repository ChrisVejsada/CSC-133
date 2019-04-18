package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class StrategyCommand extends Command {


	private GameWorld gw;

	/**
	 * constructor for right
	 * @param gw
	 */
	public StrategyCommand(GameWorld gw) {
		super("changing stratgy");
		this.gw = gw;
	}
	
	/**
	 * override for action
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.changeNPCStrategies();
	}
	
}