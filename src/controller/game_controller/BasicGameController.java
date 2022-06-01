package controller.game_controller;

import java.util.List;

import controller.GameAreaController;
import controller.GameLoop;
import controller.PageController;
import controller.enemy_ai.EnemyAIImpl;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.game_statistics.GameStatisticsImpl;
import utilities.Pair;

/**
 * 
 * Concrete class that implements a basic type of game.
 *
 */
public class BasicGameController extends GameController {

    private final EnemyAIImpl enemyAI;
    private static final int ROOM_TO_WIN = 3;

    public BasicGameController(final GameAreaController gameAreaController, final PageController pageController,
            final GameLoop loop, final GameStatisticsImpl gameStats) {
        super(gameAreaController, pageController, gameStats, loop);
        this.enemyAI = new EnemyAIImpl(loop.getRoom());
    }

    @Override
    public void enemyTurn() {
        final List<SimpleEnemy> allEnemyList = this.getLoop().getRoom().getEnemyList();
        final Player player = this.getLoop().getPlayer();
        final Pair<Integer, Integer> roomSize = this.getLoop().getRoom().getSize();
        allEnemyList.forEach(enemy -> {
            if (this.enemyAI.isPlayerInAttackArea(enemy, player, roomSize)) {
                this.damagePlayer(enemy, player);
            } else {
                this.getLoop().moveGameObject(enemy.getPos(), this.enemyAI.move(enemy));
                this.getLoop().removeHighlight();
            }
        });
        this.resetActionNumber();
    }

    @Override
    public boolean isDoorAvailable() {
        return true;
    }

    @Override
    public boolean isWon() {
        return this.getGameStats().getCompletedRooms() == ROOM_TO_WIN;
    }

    @Override
    public boolean isDefeated() {
        return this.getLoop().getPlayer().isDead();
    }

    /**
     * Player's health is decreased based on damage received. Checks whether the
     * player is dead and the game is lost or not.
     * 
     * @param enemy:  enemy damaging the player
     * @param player: player currently playing
     */
    private void damagePlayer(final SimpleEnemy enemy, final Player player) {
        player.damage(enemy.getWeapon().getDamage());
        if (player.isDead()) {
            this.getPageController().showDefeat();
        } else {
            this.updateStats();
            this.getLoop().updateLog(
                    player.getName() + " got hit " + enemy.getWeapon().getDamage() + " by " + enemy.getName() + "!");
        }
    }

}
