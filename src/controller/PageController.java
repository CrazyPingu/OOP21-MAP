package controller;

import logics.game_object.entity.Player;
import logics.room.works.Room;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class PageController {

    Room room;
    BasicFrame frame;
    ActionMenuController actionMenuController;
    TotalPanel totalPanel;
    MainMenu mainMenu;
    PauseMenu pauseMenu;
    LoadingScreenImpl loadingScreenImpl;
    LoseGame loseGame;
    WinGame winGame;

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
    }

    public void setupAllCardLayout() {

        frame.addToCardLayout(this.mainMenu, "MainMenu");
        frame.addToCardLayout(this.pauseMenu, "PauseMenu");
        frame.addToCardLayout(this.totalPanel, "Game");
        frame.addToCardLayout(this.loadingScreenImpl, "LoadingScreen");
        frame.addToCardLayout(this.loseGame, "Defeat");
        frame.addToCardLayout(this.winGame, "Win");

    }

    public void showMainMenu() {
        frame.showInFrame("MainMenu");
    }

    public void showLoadingScreen() {
        frame.showInFrame("LoadingScreen");
    }

    public void showGame() {
        frame.showInFrame("Game");
    }

    public void showPauseMenu() {
        frame.showInFrame("PauseMenu");
    }

    public void showLostGame() {
        frame.showInFrame("Defeat");
    }

    public void showWinGame() {
        frame.showInFrame("Win");
    }

    public void quitGame() {
        System.exit(0);
    }

    public Room getRoom() {
        return room;
    }

    public BasicFrame getFrame() {
        return frame;
    }

    public ActionMenuController getActionMenuController() {
        return actionMenuController;
    }

    public TotalPanel getTotalPanel() {
        return totalPanel;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }

    public LoadingScreenImpl getLoadingScreenImpl() {
        return loadingScreenImpl;
    }

    public LoseGame getLoseGame() {
        return loseGame;
    }

    public WinGame getWinGame() {
        return winGame;
    }
    
    

}