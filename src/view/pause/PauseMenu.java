package view.pause;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import utilis.Constant;
import view.pause.action.MainMenuAction;
import view.pause.action.NewGameAction;
import view.pause.action.QuitAction;
import view.pause.action.ResumeAction;

public class PauseMenu extends JPanel implements ActionListener{
    /**
     * 
     */
    
    public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
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
        this.setOpaque(false);
        JButton resume = createJB("Resume");
        JButton newgame = createJB("New Game");
        JButton mainmenu = createJB("Main Menu");
        JButton quit = createJB("Quit");
        JLabel pausetext =  labeltext("Pause Menu");
        
        this.setLayout(new GridBagLayout());
        this.add(pausetext, setButtonPosition(0, 70, 30));
        this.add(resume, setButtonPosition(1, 30, 30));
        this.add(newgame, setButtonPosition(2, 30, 30));
        this.add(mainmenu, setButtonPosition(3, 30, 30));
        this.add(quit, setButtonPosition(4, 30, 30));
        resume.addActionListener(new ResumeAction());
        newgame.addActionListener(new NewGameAction());
        mainmenu.addActionListener(new MainMenuAction());
        quit.addActionListener(new QuitAction());
        
        
    }
    
    private JButton createJB(String name) {
        JButton temp = new JButton(name);
        temp.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(40)));
        temp.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(350),Constant.verticalAspectRatio(150)));
        
        return temp;
    }
    
   private JLabel labeltext(String name) {
       JLabel pause = new JLabel(name, SwingConstants.CENTER);
       pause.setForeground(Color.white);
       pause.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(500),Constant.verticalAspectRatio(100)));
       pause.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(80)));
       return pause;
   }
    
    private GridBagConstraints setButtonPosition (int gridy, int topPad, int botPad) {
        GridBagConstraints a = new GridBagConstraints();
        topPad = Constant.verticalAspectRatio(topPad);
        botPad = Constant.verticalAspectRatio(botPad);
        a.gridy = gridy;
        a.insets = new Insets(topPad, 0, botPad, 0);
        return a;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
