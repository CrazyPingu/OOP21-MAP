package view.pause;

import java.awt.*;
import javax.swing.*;

import controller.PageController;
import utilities.GbcDimension;
import view.MenuButton;
import view.MenuLabel;
import view.pause.action.MainMenuAction;
import view.pause.action.QuitAction;
import view.pause.action.ResumeAction;

/**
 * 
 * PauseMenu is a class that is used to implement the pause menu himself. Here
 * we can find three buttons: Resume, Main Menu and Quit.
 *
 */

public class PauseMenu extends JPanel {

  private static final long serialVersionUID = 8006565750742104587L;
  private static final int BUTTON_WIDTH = 200;
  private static final int BUTTON_HEIGHT = 70;

  /**
   * @param controller the controller passed in input
   */
  public PauseMenu(final PageController controller) {

    final MenuButton resume = new MenuButton("Resume", 40);
    final MenuButton mainmenu = new MenuButton("Main Menu", 40);
    final MenuButton quit = new MenuButton("Quit", 40);
    final MenuLabel pausetext = new MenuLabel("Pause Menu");

    resume.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    mainmenu.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    quit.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

    this.setLayout(new GridBagLayout());

    this.setBackground(Color.black);
    this.add(pausetext, new GbcDimension(0, 1, BUTTON_WIDTH, BUTTON_HEIGHT));
    this.add(resume, new GbcDimension(0, 2, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
    this.add(mainmenu, new GbcDimension(0, 3, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
    this.add(quit, new GbcDimension(0, 4, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));

    resume.addActionListener(new ResumeAction(controller));
    mainmenu.addActionListener(new MainMenuAction(controller));
    quit.addActionListener(new QuitAction(controller));

  }

}
