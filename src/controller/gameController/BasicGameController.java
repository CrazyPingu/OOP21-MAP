package controller.gameController;

import java.util.List;

import controller.ActionMenuController;
import controller.GameAreaController;
import controller.PageController;
import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_statistics.GameStatistics;
import utilities.Pair;
import view.frame.BasicFrame;

/**
 * 
 * Concrete class that implements a basic type of game.
 *
 */
public class BasicGameController extends GameController {

	private EnemyAIImpl enemyAI;
	private final int ROOM_TO_WIN = 3;
	
	public BasicGameController(ActionMenuController actionMenuController, GameAreaController gameAreaController,
			PageController pageController, GameStatistics gameStats) {
		super(actionMenuController, gameAreaController, pageController, gameStats);
		this.enemyAI = new EnemyAIImpl(this.getTotalPanel());
	}

	@Override
	public void enemyTurn() {
		List<SimpleEnemy> allEnemyList = this.getTotalPanel().getGameArea().getRoom().getEnemyList();
		Player player = this.getTotalPanel().getGameArea().getRoom().getPlayer();
		Pair<Integer, Integer> roomSize = this.getTotalPanel().getGameArea().getRoom().getSize();

		for (SimpleEnemy enemy : allEnemyList) {
			if (this.enemyAI.isPlayerInAttackArea(enemy, player, roomSize)) {
				player.damage(enemy.getWeapon().getDamage());
				if (player.isDead()) {
					this.getPageController().showDefeat();
				} else {
					this.getTotalPanel().getScrollableStats().getStatsValues().update(player);
					this.getTotalPanel().getScrollableLog().getLogMessage().update("" + player.getName() + " ha subito "
							+ enemy.getWeapon().getDamage() + " da " + enemy.getName() + "!");
				}
			} else {
				this.getTotalPanel().getGameArea().moveGameObject(enemy.getPos(), this.enemyAI.move(enemy));
			}
		}
		this.resetActionNumber();
	}

	@Ovveride
	public boolean isDoorAvailable() {
		return true;
	}
	
	@Override
	public boolean isWon() {
		return this.getGameStats() == ROOM_TO_WIN;
	}
}
