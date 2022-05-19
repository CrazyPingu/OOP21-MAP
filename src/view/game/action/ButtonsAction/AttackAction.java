package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

/**
 *
 */
public class AttackAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     */
    public AttackAction(ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    /**
     * Call attack method in ActionMenuController
     */
    public void actionPerformed(ActionEvent e) {
        this.menucontroller.setAttack();
    }

}
