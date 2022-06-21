package view.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

/**
 * 
 * Action listener that is related to the button "new game"
 *
 */
public class NewGameAction implements ActionListener {

  private final PageController pageController;

  /**
   * 
   * @param pageController the controller to change the card layout
   */
  public NewGameAction(final PageController pageController) {
    this.pageController = pageController;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    this.pageController.startGame();

  }

}
