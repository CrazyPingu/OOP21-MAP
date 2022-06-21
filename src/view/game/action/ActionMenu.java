package view.game.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import controller.ActionMenuController;
import controller.PageController;
import utilities.GbcDimension;
import view.MenuButton;
import view.game.action.action_button.AttackAction;
import view.game.action.action_button.MoveAction;
import view.game.action.action_button.PauseAction;
import view.game.action.action_button.SkipAction;
/**
 * 
 * Class that create all the buttons in the ActionMenu part
 * 
 */

public class ActionMenu extends JPanel {

  private static final long serialVersionUID = -4962314493991930765L;
  private static final int BUTTON_WIDTH = 200;
  private static final int BUTTON_HEIGHT = 100;

  /**
   * 
   * @param pageController the controller of the page
   * @param menuController the controller of the action menu
   */
  public ActionMenu(final PageController pageController, final ActionMenuController menuController) {
    this.setBackground(Color.BLACK);

    final MenuButton attack = new MenuButton("Attack", 40);
    final MenuButton move = new MenuButton("Move", 40);
    final MenuButton skip = new MenuButton("Skip", 40);
    final MenuButton pause = new MenuButton("Pause", 40);

    attack.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    move.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    skip.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    pause.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

    this.setLayout(new GridBagLayout());

    final Insets buttonInsets = GbcDimension.createInsets(0, 20, 0, 20);
    this.add(attack, new GbcDimension(0, 0, BUTTON_WIDTH, BUTTON_HEIGHT, buttonInsets));
    this.add(move, new GbcDimension(1, 0, BUTTON_WIDTH, BUTTON_HEIGHT, buttonInsets));
    this.add(skip, new GbcDimension(2, 0, BUTTON_WIDTH, BUTTON_HEIGHT, buttonInsets));
    this.add(pause, new GbcDimension(3, 0, BUTTON_WIDTH, BUTTON_HEIGHT, buttonInsets));

    attack.addActionListener(new AttackAction(menuController));
    move.addActionListener(new MoveAction(menuController));
    skip.addActionListener(new SkipAction(menuController));
    pause.addActionListener(new PauseAction(pageController));

  }

}
