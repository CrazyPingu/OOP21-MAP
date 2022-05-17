package controller;

import logics.room.works.Room;
import view.frame.BasicFrame;
import view.game.TotalPanel;
import view.loadingScreen.LoadingScreenImpl;
import view.pause.PauseMenu;

public class PageController {
    
    PageController controller;
    Room room;
    BasicFrame frame;
    
    public PageController(BasicFrame frame) {
        this.frame = frame;
    }
    
    public void setupAllCardLayout() {
        MainMenu mm = new MainMenu();
        PauseMenu pm = new PauseMenu(controller);
        TotalPanel tp = new TotalPanel(room);
        LoadingScreenImpl ls = new LoadingScreenImpl();
        LoseGame lg = new LoseGame();
        WinGame wg = new WinGame();
        
        
        frame.addToCardLayout(mm, "MainMenu");
        frame.addToCardLayout(pm, "PauseMenu");
        frame.addToCardLayout(tp, "Game");
        frame.addToCardLayout(ls, "LoadingScreen");
        frame.addToCardLayout(lg, "Defeat");
        frame.addToCardLayout(wg, "Win");
        
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
    
    /*public void quitGame() {
        System.exit(0);
    }*/

}