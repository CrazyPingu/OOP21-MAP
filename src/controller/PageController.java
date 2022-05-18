package controller;

import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class PageController {

    BasicFrame frame;
    ActionMenuController actionMenuController;
    TotalPanel totalPanel;
    MainMenu mainMenu;
    PauseMenu pauseMenu;
    LoadingScreenImpl loadingScreenImpl;
    LoseGame loseGame;
    WinGame winGame;

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
        this.actionMenuController = actionMenuController;
        this.totalPanel = totalPanel;
        this.mainMenu = mainMenu;
        this.pauseMenu = pauseMenu;
        this.loadingScreenImpl = loadingScreenImpl;
        this.loseGame = loseGame;
        this.winGame = winGame;
        this.setupAllCardLayout();
    }

    /**
     * method to setup all the cardlayout pages
     */
    public void setupAllCardLayout() {

        frame.addToCardLayout(this.mainMenu, "MainMenu");
        frame.addToCardLayout(this.pauseMenu, "PauseMenu");
        frame.addToCardLayout(this.totalPanel, "Game");
        frame.addToCardLayout(this.loadingScreenImpl, "LoadingScreen");
        frame.addToCardLayout(this.loseGame, "Defeat");
        frame.addToCardLayout(this.winGame, "Win");

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

    /**
     * @return the frame
     */
    public BasicFrame getFrame() {
        return frame;
    }

    /**
     * @return the action menu controller
     */
    public ActionMenuController getActionMenuController() {
        return actionMenuController;
    }

    /**
     * @return the total panel
     */
    public TotalPanel getTotalPanel() {
        return totalPanel;
    }

    /**
     * @return the main menu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /**
     * @return the pause menu
     */
    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }

    /**
     * @return the loading screen
     */
    public LoadingScreenImpl getLoadingScreenImpl() {
        return loadingScreenImpl;
    }

    /**
     * @return the lose game page
     */
    public LoseGame getLoseGame() {
        return loseGame;
    }

    /**
     * @return the win game page
     */
    public WinGame getWinGame() {
        return winGame;
    }

}