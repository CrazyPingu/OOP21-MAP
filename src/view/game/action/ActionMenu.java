package view.game.action;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.ActionMenuController;
import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import view.MenuButton;
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
        List<MenuButton> button = new ArrayList<>();
        MenuButton attack = new MenuButton("Attack", 30);
        MenuButton move = new MenuButton("Move", 30);
        MenuButton skip = new MenuButton("Skip", 30);
        MenuButton pause = new MenuButton("Pause", 30);
        button.add(attack);
        button.add(move);
        attack.addActionListener(new AttackAction(menucontroller, button));
        move.addActionListener(new MoveAction(menucontroller, button));
        skip.addActionListener(new SkipAction(menucontroller));
        pause.addActionListener(new PauseAction(controller));
        this.setLayout(new GridBagLayout());

        Insets buttonInsets = GbcDimension.createInsets(0, 150, 30, 90);
        this.add(attack, new GbcDimension(0, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                buttonInsets));
        this.add(move, new GbcDimension(1, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                buttonInsets));
        this.add(skip, new GbcDimension(2, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                buttonInsets));
        this.add(pause, new GbcDimension(3, 0, Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150),
                buttonInsets));
    }
}
