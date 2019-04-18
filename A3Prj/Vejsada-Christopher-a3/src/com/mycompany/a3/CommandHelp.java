package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

public class CommandHelp extends Command {

    private GameWorld gw;
    /**
     * constructor made for help
     * @param gw
     */
    public CommandHelp(GameWorld gw) {
        super("Help");
        this.gw = gw;
    }
    /**
     * override for action
     */
    @Override
    public void actionPerformed(ActionEvent ev) {

        Dialog helpBox = new Dialog("Help", new TableLayout(10, 2));

        helpBox.add(new Label("Command"));
        helpBox.add(new Label("Key Bindings"));
        helpBox.add(new Label("Accelerate"));
        helpBox.add(new Label("a"));
        helpBox.add(new Label("Brake"));
        helpBox.add(new Label("b"));
        helpBox.add(new Label("Left Turn"));
        helpBox.add(new Label("l"));
        helpBox.add(new Label("Right Turn"));
        helpBox.add(new Label("r"));
        helpBox.add(new Label("Energy"));
        helpBox.add(new Label("e"));
        helpBox.add(new Label("Robo"));
        helpBox.add(new Label("s"));
        helpBox.add(new Label("Tick"));
        helpBox.add(new Label("t"));
        helpBox.add(new Label("Exit"));
        helpBox.add(new Label("x"));

        Command okCommand = new Command("ok");
        Command c = Dialog.show("", helpBox, okCommand);
        if (c == okCommand) {
            return;
        }

    }

}