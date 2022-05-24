package view.game.action;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import controller.ActionMenuController;
import controller.PageController;
import utilities.GbcDimension;
import view.MenuButton;
import view.game.action.action_button.AttackAction;
import view.game.action.action_button.MoveAction;
import view.game.action.action_button.PauseAction;
import view.game.action.action_button.SkipAction;

public class ActionMenu extends JPanel {

        private static final long serialVersionUID = -4962314493991930765L;
        
        /**
         * 
         * @param controller     : the PageController
         * @param menucontroller : the ActionMenuController
         */
        public ActionMenu(final PageController controller, final ActionMenuController menuController) {
                this.setBackground(Color.BLACK);
                
                final MenuButton attack = new MenuButton("Attack", 30);
                final MenuButton move = new MenuButton("Move", 30);
                final MenuButton skip = new MenuButton("Skip", 30);
                final MenuButton pause = new MenuButton("Pause", 30);
                
                attack.addActionListener(new AttackAction(menuController));
                move.addActionListener(new MoveAction(menuController));
                skip.addActionListener(new SkipAction(menuController));
                pause.addActionListener(new PauseAction(controller));
                
                this.setLayout(new GridBagLayout());

                final Insets buttonInsets = GbcDimension.createInsets(30, 30, 30, 0);
                this.add(attack, new GbcDimension(0, 0, 350, 150, buttonInsets));
                this.add(move, new GbcDimension(1, 0, 350, 150, buttonInsets));
                this.add(skip, new GbcDimension(2, 0, 350, 150, buttonInsets));
                this.add(pause, new GbcDimension(3, 0, 350, 150, buttonInsets));
        }

}
