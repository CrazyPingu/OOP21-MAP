package view.end_game_menu;

import controller.PageController;
/*
 * 
 * Class that call method to show Victory's page
 * 
 */
public class Victory extends EndGameMenu {

    private static final long serialVersionUID = 808197648331262308L;
    /**
     * 
     * @param imageName the name of the image
     * @param controller the controller of the game
     */
    public Victory(final String imageName, final PageController controller) {
        super(imageName, controller);
    }
}
