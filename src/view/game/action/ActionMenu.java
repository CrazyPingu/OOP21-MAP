package view.game.action;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import utilities.Constant;
import utilities.GbcDimension;
import view.MenuButtonsAppearance;

public class ActionMenu extends JPanel {

    private static final long serialVersionUID = -4962314493991930765L;

    public ActionMenu() {

        JButton attack = new JButton("Attack");
        JButton move = new JButton("Move");
        JButton skip = new JButton("Skip");
        JButton pause = new JButton("Pause");
        MenuButtonsAppearance.SetMenuButtonsAppearance(attack);
        MenuButtonsAppearance.SetMenuButtonsAppearance(move);
        MenuButtonsAppearance.SetMenuButtonsAppearance(skip);
        MenuButtonsAppearance.SetMenuButtonsAppearance(pause);
        this.setLayout(new GridBagLayout());
        this.add(attack, new GbcDimension(0,0,0,0,GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(move, new GbcDimension(1,0,0,0,GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(skip, new GbcDimension(2,0,0,0,GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(pause, new GbcDimension(3,0,0,0,GbcDimension.createInsets(0, 30, 0, 30)));
    }
}
