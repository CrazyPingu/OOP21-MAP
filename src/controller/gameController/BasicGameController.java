package controller.gameController;

import java.util.List;

import controller.ActionMenuController;
import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;

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
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		actionMenuController.setInitialActionNumber(player.getActionNumber());
		while (currentAction>0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enemyTurn(ActionMenuController actionMenuController) {
		List<SimpleEnemy> allEnemyList = actionMenuController.getGameArea().getRoom().getEnemyList();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		Pair<Integer,Integer> roomSize = this.getTotalPanel().getGameArea().getRoom().getSize();
		
		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea(enemy, player))
				this.enemyAI.attack(enemy, player, roomSize);
			else
				this.enemyAI.move();
			Thread.sleep(1000);
		}
	}

}
