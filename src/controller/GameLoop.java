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

    public GameLoop() {
        this.createPanel();
        // main menu - loading screen - creazione total panel(new room da
        // gameAreaController)

        // while True
        // conterrà while(getcurrentactionnumber>0) turno player

    }

    private void createPanel() {

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
