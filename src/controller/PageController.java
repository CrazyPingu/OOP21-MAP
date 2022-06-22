package controller;

import view.BasicFrame;

/**
 * 
 * Class that contains all the methods to switch the page showed to the player
 * 
 */
public class PageController {

    private final BasicFrame frame;
    private final GameLoop gameLoop; 

    /**
     * @param frame the frame of the game
     * @param gameLoop the game loop
     */
    public PageController(final BasicFrame frame, final GameLoop gameLoop) {
        this.frame = frame;
        this.gameLoop = gameLoop; 
    }
     /**
      * show the main menu
      */
    public void showMainMenu() {
        frame.showInFrame(CardName.MAIN_MENU);
    }

    /**
     * show the loading screen
     */
    public void showLoadingScreen() {
        frame.showInFrame(CardName.LOADING_SCREEN);
    }

    /**
     * show the game screen
     */
    public void showGame() {
        frame.showInFrame(CardName.TOTAL_PANEL);
    }

    /**
     * show the pause menu
     */
    public void showPauseMenu() {
        frame.showInFrame(CardName.PAUSE_MENU);
    }

    /**
     * show the lost game page
     */
    public void showDefeat() {
        frame.showInFrame(CardName.DEFEAT);
    }

    /**
     * show the win game page
     */
    public void showVictory() {
        frame.showInFrame(CardName.VICTORY);
    }
  
    /**
     * method that start the game
     */
    public void startGame() {
    	this.gameLoop.startGame();
    }
    
    /**
     * close the application
     */
    public void quitGame() {
      System.exit(0);
    }
}