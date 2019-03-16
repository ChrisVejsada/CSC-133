<<<<<<< HEAD
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
=======
package com.mycompany.a2;

import java.awt.event.ActionEvent;

public class CommandDroneCollision extends Command{
    private GameWorld gw;

    /**
     * constuctor for drone
     * @param gw
     */
    public CommandDroneCollision(GameWorld gw){
        super("Collided with Robot");
        this.gw = gw;
    }

    /**
     * override for actionevent
     */
    @Override
    public void actionPerformed(ActionEvent ev){
        gw.robotCollision('d');
    }
}

>>>>>>> branch 'master' of https://github.com/ChrisVejsada/CSC-133.git
