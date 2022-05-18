package controller;

import view.frame.BasicFrame;

public class PageController {

    BasicFrame frame;

    /**
     * @param frame the frame of the game
     */
    public PageController(BasicFrame frame) {
        this.frame = frame;
    }

    /**
     * show the main menu
     */
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
    public void showLostGame() {
        frame.showInFrame("Defeat");
    }

    /**
     * show the win game page
     */
    public void showWinGame() {
        frame.showInFrame("Win");
    }

    /**
     * close the application
     */
    public void quitGame() {
        System.exit(0);
    }
}