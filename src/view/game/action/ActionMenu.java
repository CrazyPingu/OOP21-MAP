package view.game.action;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import utilities.Constant;
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
        this.add(attack, setButtonPosition(0, 30, 30));
//      this.add(move, setButtonPosition(1, 30, 30));
//      this.add(skip, setButtonPosition(2, 30, 30));
//      this.add(pause, setButtonPosition(3, 30, 30));
    }

    private GridBagConstraints setButtonPosition(int gridx, int leftPad, int rightPad) {
        GridBagConstraints a = new GridBagConstraints();
        leftPad = Constant.verticalAspectRatio(leftPad);
        rightPad = Constant.verticalAspectRatio(rightPad);
        a.gridx = gridx;
        a.insets = new Insets(0, leftPad, 0, rightPad);
        return a;
    }
}
