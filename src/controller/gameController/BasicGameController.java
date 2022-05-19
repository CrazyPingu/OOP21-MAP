package controller.gameController;

import java.util.List;

import controller.ActionMenuController;
import controller.GameAreaController;
import controller.PageController;
import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;
import view.frame.BasicFrame;

/**
 * 
 * Concrete class that implements a basic type of game.
 *
 */
public class BasicGameController extends GameController {

	private EnemyAIImpl enemyAI;

	public BasicGameController(ActionMenuController actionMenuController, GameAreaController gameAreaController,
            BasicFrame frame, PageController pageController) {
		super(actionMenuController, gameAreaController, frame, pageController);
		this.enemyAI = new EnemyAIImpl(this.getTotalPanel());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param actionMenuController: controller of the action menu
	 */
	@Override
	public void playerTurn() {
		int currentAction = this.getCurrentActionNumber();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		this.setCurrentActionNumber(player.getActionNumber());
		//TODO move current action control in game loop
		while (currentAction > 0)
			;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enemyTurn() {
		List<SimpleEnemy> allEnemyList = this.getTotalPanel().getGameArea().getRoom().getEnemyList();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		Pair<Integer, Integer> roomSize = this.getTotalPanel().getGameArea().getRoom().getSize();

		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea(enemy, player, roomSize)) {
				player.damage(enemy.getWeapon().getDamage());
				if (player.isDead()) {
					// TODO lost game/main menu (pageController)
				} else {
					this.getTotalPanel().getScrollableStats().getStatsValues().update(player);
					this.getTotalPanel().getScrollableLog().getLogMessage().update("" + player.getName() + " ha subito "
							+ enemy.getWeapon().getDamage() + " da " + enemy.getName() + "!");
				}
			} else {
				this.getTotalPanel().getGameArea().moveGameObject(enemy.getPos(), this.enemyAI.move(enemy));
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
