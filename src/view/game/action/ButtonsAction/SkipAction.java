package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

public class SkipAction implements ActionListener {

    ActionMenuController menucontroller;

    public SkipAction(ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    public void actionPerformed(ActionEvent e) {
        menucontroller.skip();
    }

}
