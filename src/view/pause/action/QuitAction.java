package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;
/*
 * 
 * Class that define the Quit Action in Pause Menu
 * 
 */
public class QuitAction implements ActionListener {

  PageController controller;

  /**
   * 
   * @param controller the controller of the game
   */
  public QuitAction(final PageController controller) {
    this.controller = controller;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    controller.quitGame();
  }
}
