package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandEnergyStationCollision extends Command {

    private GameWorld gw;

    /**
     * constuctor for energy
     * @param gw
     */
    public CommandEnergyStationCollision(GameWorld gw){
        super("Collided with Energy Station");
        this.gw = gw;
    }

    /**
     * @Override for action
     */ 
    @Override
    public void actionPerfomed(ActionEvent ev){
        gw.energyStationCollision();
    }

}

