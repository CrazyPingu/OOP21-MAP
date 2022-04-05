package view.pause;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class PauseMenu extends JPanel{
    /**
     * 
     */
    private static final long serialVersionUID = 8006565750742104587L;

    /*
     * Sarà composto da 4 bottoni: Continue, New Game, Main Menu, Quit
     * Continue : Mostra la CardLayout del Gioco e chiude quella del menu di pausa
     * New Game : Mostra la CardLayout del Gioco ma dall'inizio, perdendo tutti i salvataggi fatti finora
     * Main Menu : Mostrerà il CardLayout del Menù Principale (tutti i salvataggi verranno persi anche in questo caso)
     * Quit : Chiuderà il gioco (System.Exit(0);)
     * 
     */
    
    public PauseMenu() {
        JButton resume = createJB("Resume");
        JButton newgame = createJB("New Game");
        JButton mainmenu = createJB("Main Menu");
        JButton quit = createJB("Quit");
        
        this.setLayout(new GridBagLayout());
        this.add(resume, setButtonPosition(0));
        this.add(newgame, setButtonPosition(1));
        this.add(mainmenu, setButtonPosition(2));
        this.add(quit, setButtonPosition(3));
        
        
    }
    
    private JButton createJB(String name) {
        return new JButton(name);
    }
    
    private GridBagConstraints setButtonPosition (int gridy) {
        GridBagConstraints a = new GridBagConstraints();
        a.gridy = gridy;
        return a;
        
    }
}
