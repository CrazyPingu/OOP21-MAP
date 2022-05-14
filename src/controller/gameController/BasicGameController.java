package controller.gameController;

import java.util.List;

import controller.ActionMenuController;
import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.game.central.GameArea;

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
		actionMenuController.setActionNumber(player.getActionNumber());
		while (currentAction>0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enemyTurn(ActionMenuController actionMenuController) {
		List<SimpleEnemy> allEnemyList = actionMenuController.getGameArea().getRoom().getEnemyList();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		GameArea gameArea = this.getTotalPanel().getGameArea();
		Pair<Integer,Integer> roomSize = this.getTotalPanel().getGameArea().getRoom().getSize();
		
		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea(enemy, player))
				this.enemyAI.attack(enemy, player, roomSize);
			else
				this.enemyAI.move(enemy, player, roomSize, gameArea);
			Thread.sleep(1000);
		}
	}

}
