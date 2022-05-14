package controller.gameController;

import controller.ActionMenuController;
import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.SimpleEnemy;

/**
 * 
 * Concrete class that implements a basic type of game.
 *
 */
public class BasicGameController extends GameController {
	
	EnemyAIImpl enemyAI = new EnemyAIImpl();

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
		List<SimpleEnemy> allEnemyList = actionMenuController.getGameArea().getRoom().getEnemyList();
		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea())
				this.enemyAI.attack();
			else
				this.enemyAI.move();
			Thread.sleep(1000);
		}
	}

}
