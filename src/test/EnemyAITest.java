package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import controller.enemy_ai.EnemyAIImpl;
import model.game_object.artefact.HealthArtefactFactory;
import model.game_object.artefact.HealthArtefactFactoryImpl;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.game_object.entity.enemy.EnemyFactoryImpl;
import model.life.impl.ExtendibleMaxLifeSystem;
import model.room.Room;
import model.room.RoomImpl;
import model.strategy.movement.MovementFactory;
import model.strategy.movement.MovementFactoryImpl;
import model.strategy.weapon.WeaponFactory;
import model.strategy.weapon.WeaponFactoryImpl;
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
    final EnemyFactoryImpl ef = new EnemyFactoryImpl();
    private EnemyAIImpl enemyAI;
    private Player player;
    private SimpleEnemy enemyAroundArea, enemyCrossArea;
    private List<Pair<Integer, Integer>> expectedResult;
    private final Pair<Integer, Integer> roomSize = new Pair<>(10, 4);

    @org.junit.Before
    public void init() {
        this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), wf.createAxe(), mf.stepMovement(),
                "Marcello-test", EntityTexture.PLAYER);
        final Room room = new RoomImpl(roomSize, this.player, new Pair<>(2, 1));
        this.expectedResult = new ArrayList<>();
        this.enemyAI = new EnemyAIImpl(room);
        room.getEnemyList().clear();
        this.enemyAroundArea = ef.createZombieStick(new Pair<>(5, 1));
        room.getEnemyList().add(this.enemyAroundArea);
        this.enemyCrossArea = ef.createZombieGun(new Pair<>(3, 3));
        room.getEnemyList().add(this.enemyCrossArea);
    }

    @org.junit.Test
    /**
     * testing of enemy's moving behavior whether there's an artefact on chosen cell
     */
    public void artefactPlayerOutside() {
        hf.bigHealArtefact(new Pair<Integer,Integer>(4,2));
        this.player.setPos(new Pair<>(2, 3));
        //NOT EXPECTED TO MOVE IN this.expectedResult.add(new Pair<>(4, 2));
        this.expectedResult.add(new Pair<>(4, 1));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyAroundArea)));
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with different coordinates than player's
     * position
     */
    public void playerOutside() {
        this.player.setPos(new Pair<>(2, 3));
        this.expectedResult.add(new Pair<>(4, 2));
        this.expectedResult.add(new Pair<>(4, 1));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyAroundArea)));

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(2, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyCrossArea)));

        this.expectedResult.clear();
        this.enemyCrossArea.setPos(new Pair<>(3, 3));
        this.player.setPos(new Pair<>(6, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        this.expectedResult.add(new Pair<>(3, 2));
        this.expectedResult.add(new Pair<>(4, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyCrossArea)));
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player with the same X
     * coordinate
     */
    public void playerAlignedX() {
        this.player.setPos(new Pair<>(2, 1));
        this.expectedResult.add(new Pair<>(4, 0));
        this.expectedResult.add(new Pair<>(4, 1));
        this.expectedResult.add(new Pair<>(4, 2));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyAroundArea)));

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(7, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyCrossArea)));
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player with the same X
     * coordinate
     */
    public void playerAlignedY() {
        this.player.setPos(new Pair<>(5, 3));
        this.expectedResult.add(new Pair<>(4, 2));
        this.expectedResult.add(new Pair<>(5, 2));
        this.expectedResult.add(new Pair<>(6, 2));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyAroundArea)));

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(3, 0));
        this.expectedResult.add(new Pair<>(3, 1));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyCrossArea)));
    }

    @org.junit.Test
    /**
     * testing of enemy's moving area with enemy and player on the right of enemy's
     * area (not exactly aligned with enemy pos)
     */
    public void playerRightArea() {
        this.player.setPos(new Pair<>(8, 2));
        this.expectedResult.add(new Pair<>(6, 0));
        this.expectedResult.add(new Pair<>(6, 1));
        this.expectedResult.add(new Pair<>(6, 2));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyAroundArea)));

        this.expectedResult.clear();
        this.player.setPos(new Pair<>(5, 2));
        this.expectedResult.add(new Pair<>(4, 3));
        this.expectedResult.add(new Pair<>(5, 3));
        assertTrue(expectedResult.contains(this.enemyAI.move(this.enemyCrossArea)));
    }

}
