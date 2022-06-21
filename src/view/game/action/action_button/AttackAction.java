package view.game.action.action_button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

/**
 * The action that make the player attack
 */
public class AttackAction implements ActionListener {
  ActionMenuController menucontroller;

  /**
   * 
   * @param menucontroller : the ActionMenuController
   */
  public AttackAction(final ActionMenuController menucontroller) {
    this.menucontroller = menucontroller;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    this.menucontroller.setAttack();
  }

}
