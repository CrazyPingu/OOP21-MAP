package view.end_game_menu;

import controller.PageController;

/**
 * 
 * Class that call method to show Defeat's page
 * 
 */
public class Defeat extends EndGameMenu {

  private static final long serialVersionUID = 3843742944194787112L;

  /**
   * 
   * @param imageName  the name of the image
   * @param controller the controller of the game
   */
  public Defeat(final String imageName, final PageController controller) {
    super(imageName, controller);
  }

}
