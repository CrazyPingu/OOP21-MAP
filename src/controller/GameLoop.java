package controller;

import controller.gameController.GameController;
import logics.game_object.entity.Player;
import utilities.Pair;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class GameLoop {
    private BasicFrame frame;
    private LoadingScreenImpl loadingScreen;
    private MainMenu mainMenu;
    private TotalPanel totalPanel;
    private PauseMenu pauseMenu;
    private WinGame winGame;
    private LoseGame loseGame;
    private GameController gameController;
    private ActionMenuController actionMenuController;
    private GameAreaController gameAreaController;
    private PageController pageController;

    public GameLoop() {
        this.
        this.init();
        // main menu - loading screen - creazione total panel(new room da
        // gameAreaController)

        // while True
        // conterrà while(getcurrentactionnumber>0) turno player
        
        
        /*
         *         
         *         
         *         frame.addToCardLayout(mainMenu, "MainMenu");
        frame.addToCardLayout(pauseMenu, "PauseMenu");
        frame.addToCardLayout(totalPanel, "Game");
        frame.addToCardLayout(loadingScreenImpl, "LoadingScreen");
        frame.addToCardLayout(loseGame, "Defeat");
        frame.addToCardLayout(winGame, "Win");
         */

    }
    
    private void init() {
        this.actionMenuController = new ActionMenuController(this);
        this.gameAreaController = new GameAreaController(this);
        this.pageController = new PageController(frame);
        
        
    }

    public ActionFlag getFlag() {
        return this.gameController.getFlag();
    }

    public void attack(Pair<Integer, Integer> pos) {
        this.gameController.attack(pos);
    }

    public void move(Pair<Integer, Integer> pos) {
        this.gameController.move(pos);
    }

    public Player getPlayer() {
        return this.gameController.getPlayer();
    }

    public void skipTurn() {
        this.gameController.skipTurn();
    }

    public void setFlag(ActionFlag flag) {
        this.gameController.setFlag(flag);
    }

}
