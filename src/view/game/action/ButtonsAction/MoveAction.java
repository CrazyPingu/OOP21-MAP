package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.ActionMenuController;
import view.MenuButton;

public class MoveAction implements ActionListener {
    ActionMenuController menucontroller;
    private List<MenuButton> button;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     * @param button
     */
    public MoveAction(ActionMenuController menucontroller, List<MenuButton> button) {
        this.menucontroller = menucontroller;
        this.button = button;
    }

    /**
     * Call the move method in ActionMenuController
     */
    public void actionPerformed(ActionEvent e) {
        this.menucontroller.setMove();
        for (MenuButton x : button) {
            x.setEnabled(false);
        }
    }

}
