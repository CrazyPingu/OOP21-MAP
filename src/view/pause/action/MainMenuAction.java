package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

/**
 * 
 * 
 * Class that define the Main Menu Action in Pause Menu
 * 
 */
public class MainMenuAction implements ActionListener {

  private final PageController controller;

  /**
   * 
   * @param controller the controller of the game
   */
  public MainMenuAction(final PageController controller) {
    this.controller = controller;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    controller.showMainMenu();
  }
}
