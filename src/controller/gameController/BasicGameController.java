package controller.gameController;

import controller.ActionMenuController;

/**
 * 
 * Concrete class that implements a basic type of game.
 *
 */
public class BasicGameController extends GameController {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void playerTurn(ActionMenuController actionMenuController) {
		int currentAction;
		actionMenuController.setInitialActionNumber(actionMenuController.getGameArea().getRoom().getPlayer().getActionNumber());
		while (currentAction>0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enemyTurn(ActionMenuController actionMenuController) {
		
	}

}
