package controller;

import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class PageController {

    BasicFrame frame;

    /**
     * 
     * @param frame                the frame of the game
     * @param actionMenuController the actionMenuController
     * @param totalPanel           the container of game screen
     * @param mainMenu             the main menu
     * @param pauseMenu            the pause menu
     * @param loadingScreenImpl    the loading screen
     * @param loseGame             the lose game page
     * @param winGame              the win game page
     */
    public PageController(BasicFrame frame, ActionMenuController actionMenuController, TotalPanel totalPanel,
            MainMenu mainMenu, PauseMenu pauseMenu, LoadingScreenImpl loadingScreenImpl, LoseGame loseGame,
            WinGame winGame) {
        this.frame = frame;
        frame.addToCardLayout(mainMenu, "MainMenu");
        frame.addToCardLayout(pauseMenu, "PauseMenu");
        frame.addToCardLayout(totalPanel, "Game");
        frame.addToCardLayout(loadingScreenImpl, "LoadingScreen");
        frame.addToCardLayout(loseGame, "Defeat");
        frame.addToCardLayout(winGame, "Win");
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