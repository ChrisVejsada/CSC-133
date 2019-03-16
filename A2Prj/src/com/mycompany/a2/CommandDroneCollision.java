package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandDroneCollision extends Command {

	
		private GameWorld gw;
		
		/**
		 * constructor for drones
		 */
		public CommandDroneCollision(GameWorld gw) {
			
			super("Collided with robot");
			this.gw = gw;
		}
		/**
		 * @Override for action
		 */
		@Override
		public void actionPerformed(ActionEvent ev) {
			gw.robotCollision('d');
		}
		
}
