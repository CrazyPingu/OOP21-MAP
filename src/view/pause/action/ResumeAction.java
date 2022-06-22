package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

/**
 * 
 * Class to define the Resume Action in Pause Menu
 * 
 */
public class ResumeAction implements ActionListener {

  PageController controller;

  /**
   * 
   * @param controller the controller of the game
   */
  public ResumeAction(final PageController controller) {
    this.controller = controller;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    controller.showGame();

  }

}
