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
	
	private EnemyAIImpl enemyAI;

	public BasicGameController () {
		super();
		this.enemyAI = new EnemyAIImpl(this.getTotalPanel(), this.getTotalPanel().getGameArea().getRoom().getPlayer());
	}
	
	/**
	 * {@inheritDoc}
	 * @param actionMenuController: controller of the action menu
	 */
	@Override
	public void playerTurn(ActionMenuController actionMenuController) {
		int currentAction = actionMenuController.getCurrentActionNumber();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		actionMenuController.setActionNumber(player.getActionNumber());
		while (currentAction>0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enemyTurn() {
		List<SimpleEnemy> allEnemyList =  this.getTotalPanel().getGameArea().getRoom().getEnemyList();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		Pair<Integer,Integer> roomSize = this.getTotalPanel().getGameArea().getRoom().getSize();
		
		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea(enemy, player, roomSize))
				this.enemyAI.attack(enemy, player);
			else
				this.getTotalPanel().getGameArea().moveGameObject(enemy.getPos(), this.enemyAI.move(enemy));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
