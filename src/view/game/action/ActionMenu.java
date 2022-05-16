package view.game.action;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ActionMenuController;
import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import view.MenuButtonsAppearance;
import view.game.action.ButtonsAction.AttackAction;
import view.game.action.ButtonsAction.MoveAction;
import view.game.action.ButtonsAction.PauseAction;
import view.game.action.ButtonsAction.SkipAction;

public class ActionMenu extends JPanel {

    private static final long serialVersionUID = -4962314493991930765L;

    /**
     * 
     * @param controller     : the PageController
     * @param menucontroller : the ActionMenuController
     */
    public ActionMenu(PageController controller, ActionMenuController menucontroller) {

        JButton attack = new JButton("Attack");
        JButton move = new JButton("Move");
        JButton skip = new JButton("Skip");
        JButton pause = new JButton("Pause");
        MenuButtonsAppearance.SetMenuButtonsAppearance(attack);
        MenuButtonsAppearance.SetMenuButtonsAppearance(move);
        MenuButtonsAppearance.SetMenuButtonsAppearance(skip);
        MenuButtonsAppearance.SetMenuButtonsAppearance(pause);
        attack.addActionListener(new AttackAction(menucontroller));
        move.addActionListener(new MoveAction(menucontroller));
        skip.addActionListener(new SkipAction(menucontroller));
        pause.addActionListener(new PauseAction(controller));
        this.setLayout(new GridBagLayout());
        this.add(attack, new GbcDimension(0, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(move, new GbcDimension(1, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(skip, new GbcDimension(2, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                GbcDimension.createInsets(0, 30, 0, 30)));
        this.add(pause, new GbcDimension(3, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                GbcDimension.createInsets(0, 30, 0, 30)));
    }
}
