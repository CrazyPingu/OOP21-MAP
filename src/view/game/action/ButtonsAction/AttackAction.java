package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.ActionMenuController;
import view.MenuButton;

/**
 *
 */
public class AttackAction implements ActionListener {
    ActionMenuController menucontroller;
    private List<MenuButton> button;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     * @param button 
     */
    public AttackAction(ActionMenuController menucontroller, List<MenuButton> button) {
        this.menucontroller = menucontroller;
        this.button=button;
    }

    /**
     * Call attack method in ActionMenuController
     */
    public void actionPerformed(ActionEvent e) {
        this.menucontroller.setAttack();
        for(MenuButton x : button) {
            x.setEnabled(false);
        }
    }

}
