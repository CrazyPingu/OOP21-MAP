package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import controller.enemy_ai.EnemyAIImpl;
import model.game_object.artefact.HealthArtefactFactory;
import model.game_object.artefact.HealthArtefactFactoryImpl;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.game_object.entity.enemy.EnemyFactory;
import model.game_object.entity.enemy.EnemyFactoryImpl;
import model.game_object.obstacle.ObstacleFactory;
import model.game_object.obstacle.ObstacleFactoryImpl;
import model.life_system.impl.ExtendibleMaxLifeSystem;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import model.room.Room;
import model.room.RoomImpl;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

/**
 * 
 * JUnit test for enemy AI methods.
 *
 */

public class EnemyAITest {
    final WeaponFactory wf = new WeaponFactoryImpl();
    final HealthArtefactFactory hf = new HealthArtefactFactoryImpl();
    final MovementFactory mf = new MovementFactoryImpl();
    final EnemyFactory ef = new EnemyFactoryImpl();
    final ObstacleFactory of = new ObstacleFactoryImpl();
    private EnemyAIImpl enemyAI;
    private Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), wf.createAxe(), mf.stepMovement(),
            "Marcello-test", EntityTexture.PLAYER);
    private SimpleEnemy enemyAroundArea, enemyCrossArea;
    private List<Pair<Integer, Integer>> expectedResult;
    private final Pair<Integer, Integer> roomSize = new Pair<>(10, 4);
    Room room = new RoomImpl(roomSize, this.player, new Pair<>(2, 1));

    @org.junit.Before
    public void init() {
        this.expectedResult = new ArrayList<>();
        this.enemyAI = new EnemyAIImpl(room);
        this.room.getEnemyList().clear();
        this.room.getArtefactList().clear();
        this.room.getObstacleList().clear();
        this.enemyAroundArea = ef.createZombieStick(new Pair<>(5, 1));
        this.room.getEnemyList().add(this.enemyAroundArea);
        this.enemyCrossArea = ef.createZombieGun(new Pair<>(3, 3));
        room.getEnemyList().add(this.enemyCrossArea);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving behavior whether there's an artefact on chosen cell
     */
    public void objectInArea() {
        System.out.println("\n-- objectInArea\n");
        this.player.setPos(new Pair<>(2, 3));
        
        this.room.getArtefactList().add(hf.bigHealArtefact(new Pair<Integer,Integer>(4,2)));        
        this.expectedResult.add(new Pair<>(4, 1));
        this.expectedResult.add(new Pair<>(5, 2));
        resultsToString(this.enemyAI.move(this.enemyAroundArea), this.expectedResult);
        
        this.room.getArtefactList().clear();
        this.room.getObstacleList().add(of.createPebble(new Pair<Integer,Integer>(4,2)));
        resultsToString(this.enemyAI.move(this.enemyAroundArea), this.expectedResult);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with different coordinates than player's
     * position
     */
    public void playerOutside() {
        System.out.println("\n-- playerOutside\n");
        this.player.setPos(new Pair<>(2, 3));
        this.expectedResult.add(new Pair<>(4, 2));
        this.expectedResult.add(new Pair<>(4, 1));
        resultsToString(this.enemyAI.move(this.enemyAroundArea), this.expectedResult);

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(2, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        resultsToString(this.enemyAI.move(this.enemyCrossArea), this.expectedResult);

        this.expectedResult.clear();
        this.enemyCrossArea.setPos(new Pair<>(3, 3));
        this.player.setPos(new Pair<>(6, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        this.expectedResult.add(new Pair<>(3, 2));
        this.expectedResult.add(new Pair<>(4, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        resultsToString(this.enemyAI.move(this.enemyCrossArea), this.expectedResult);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player with the same X
     * coordinate
     */
    public void playerAlignedX() {
        System.out.println("\n-- playerAlignedX\n");
        this.player.setPos(new Pair<>(2, 1));
        this.expectedResult.add(new Pair<>(4, 0));
        this.expectedResult.add(new Pair<>(4, 1));
        this.expectedResult.add(new Pair<>(4, 2));
        resultsToString(this.enemyAI.move(this.enemyAroundArea), this.expectedResult);

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(7, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        resultsToString(this.enemyAI.move(this.enemyCrossArea), this.expectedResult);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player with the same X
     * coordinate
     */
    public void playerAlignedY() {
        System.out.println("\n-- playerAlignedY\n");
        this.player.setPos(new Pair<>(5, 3));
        this.expectedResult.add(new Pair<>(4, 2));
        this.expectedResult.add(new Pair<>(5, 2));
        this.expectedResult.add(new Pair<>(6, 2));
        resultsToString(this.enemyAI.move(this.enemyAroundArea),this.expectedResult);

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(3, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        resultsToString(this.enemyAI.move(this.enemyCrossArea), this.expectedResult);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player on the right of enemy's
     * area (not exactly aligned with enemy pos)
     */
    public void playerRightArea() {
        System.out.println("\n-- playerRightArea\n");
        this.player.setPos(new Pair<>(8, 2));
        this.expectedResult.add(new Pair<>(6, 0));
        this.expectedResult.add(new Pair<>(6, 1));
        this.expectedResult.add(new Pair<>(6, 2));
        resultsToString(this.enemyAI.move(this.enemyAroundArea), this.expectedResult);

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(5, 2));
        this.expectedResult.add(new Pair<>(4, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        resultsToString(this.enemyAI.move(this.enemyCrossArea), this.expectedResult);
    }
    
    /**
     * Results are printed on console and tested with JUnit.
     */
    private void resultsToString(final Pair<Integer, Integer> newPos, final List<Pair<Integer, Integer>> expected) {
        System.out.println(" Result:\r" + newPos + "\n Expected:\r" + expected);
        assertTrue(expectedResult.contains(newPos));
    }

}
