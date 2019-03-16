package com.mycompany.a2;

//import java.awt.event.ActionEvent;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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
     * override for action
     */
    @Override
    public void actionPerformed(ActionEvent ev){
        gw.robotCollision('d');
    }
}

