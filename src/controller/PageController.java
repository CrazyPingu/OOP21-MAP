package controller;

import view.frame.BasicFrame;

public class PageController {

    private BasicFrame frame;
    private GameLoop gameLoop; 

    /**
     * @param frame the frame of the game
     */
    public PageController(BasicFrame frame, GameLoop gameLoop) {
        this.frame = frame;
        this.gameLoop = gameLoop; 
    }
    
    public void showMainMenu() {
        frame.showInFrame("MainMenu");
    }

    /**
     * show the loading screen
     */
    public void showLoadingScreen() {
        frame.showInFrame("LoadingScreen");
    }

    /**
     * show the game screen
     */
    public void showGame() {
        frame.showInFrame("Game");
    }

    /**
     * show the pause menu
     */
    public void showPauseMenu() {
        frame.showInFrame("PauseMenu");
    }

    /**
     * show the lost game page
     */
    public void showDefeat() {
        frame.showInFrame("Defeat");
    }

    /**
     * show the win game page
     */
    public void showVictory() {
        frame.showInFrame("Victory");
    }
  
    
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