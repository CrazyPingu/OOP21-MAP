package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.RoomImpl;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;
import view.game.TotalPanel;

/**
 * 
 * JUnit test for enemy AI methods.
 *
 */

public class EnemyAITest {
	private EnemyAIImpl enemyAI;
	private WeaponFactoryImpl wf;
	private MovementFactoryImpl mf;
	private EnemyFactoryImpl ef;
	private Player player;
	private RoomImpl room;
	private TotalPanel totalPanel;
	private SimpleEnemy enemyAroundArea, enemyCrossArea;
	private List<Pair<Integer, Integer>> expectedResult;
	private Pair<Integer, Integer> roomSize = new Pair<>(10, 4);

	@org.junit.Before
	public void init() {
		this.expectedResult = new ArrayList<>();
		this.wf = new WeaponFactoryImpl();
		this.mf = new MovementFactoryImpl();
		this.ef = new EnemyFactoryImpl();
		this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(2, 3), wf.createAxe(),
				mf.stepMovement(), "Marcello", EntityTexture.PLAYER);
		this.room = new RoomImpl(roomSize, this.player, new Pair<>(2, 1));
		this.totalPanel = new TotalPanel(room);
		this.enemyAI = new EnemyAIImpl(totalPanel);
		this.room.getEnemyList().clear();
		this.enemyAroundArea = ef.createZombieStick(new Pair<>(5, 1));
		this.room.getEnemyList().add(this.enemyAroundArea);
		this.enemyCrossArea = ef.createZombieGun(new Pair<>(3, 3));
		this.room.getEnemyList().add(this.enemyCrossArea);
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
		this.totalPanel.getGameArea().moveGameObject(enemyAroundArea.getPos(), this.enemyAI.move(this.enemyAroundArea));
		assertTrue(expectedResult.contains(this.enemyAroundArea.getPos()));
		
		this.expectedResult.clear();
		this.player.setPos(new Pair<>(2, 0));
		this.expectedResult.add(new Pair<>(3, 1));
		this.totalPanel.getGameArea().moveGameObject(enemyCrossArea.getPos(), this.enemyAI.move(this.enemyCrossArea));
		assertTrue(expectedResult.contains(this.enemyCrossArea.getPos()));
		
		this.expectedResult.clear();
		this.enemyCrossArea.setPos(new Pair<>(3,3));
		this.player.setPos(new Pair<>(6, 0));
		this.expectedResult.add(new Pair<>(3, 1));
		this.expectedResult.add(new Pair<>(3, 2));
		this.expectedResult.add(new Pair<>(4, 3));
		this.expectedResult.add(new Pair<>(5, 3));
		this.totalPanel.getGameArea().moveGameObject(enemyCrossArea.getPos(), this.enemyAI.move(this.enemyCrossArea));
		assertTrue(expectedResult.contains(this.enemyCrossArea.getPos()));
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
		this.totalPanel.getGameArea().moveGameObject(enemyAroundArea.getPos(), this.enemyAI.move(this.enemyAroundArea));
		assertTrue(expectedResult.contains(this.enemyAroundArea.getPos()));
		
		this.expectedResult.clear();
		this.player.setPos(new Pair<>(7, 3));
		this.expectedResult.add(new Pair<>(5, 3));
		this.totalPanel.getGameArea().moveGameObject(enemyCrossArea.getPos(), this.enemyAI.move(this.enemyCrossArea));
		assertTrue(expectedResult.contains(this.enemyCrossArea.getPos()));
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
		this.totalPanel.getGameArea().moveGameObject(enemyAroundArea.getPos(), this.enemyAI.move(this.enemyAroundArea));
		assertTrue(expectedResult.contains(this.enemyAroundArea.getPos()));
		
		this.expectedResult.clear();
		this.player.setPos(new Pair<>(3, 0));
		this.expectedResult.add(new Pair<>(3, 1));
		this.totalPanel.getGameArea().moveGameObject(enemyCrossArea.getPos(), this.enemyAI.move(this.enemyCrossArea));
		assertTrue(expectedResult.contains(this.enemyCrossArea.getPos()));
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
		this.totalPanel.getGameArea().moveGameObject(enemyAroundArea.getPos(), this.enemyAI.move(this.enemyAroundArea));
		assertTrue(expectedResult.contains(this.enemyAroundArea.getPos()));
		
		this.expectedResult.clear();
		this.player.setPos(new Pair<>(5, 2));
		this.expectedResult.add(new Pair<>(4, 3));
		this.expectedResult.add(new Pair<>(5, 3));
		this.totalPanel.getGameArea().moveGameObject(enemyCrossArea.getPos(), this.enemyAI.move(this.enemyCrossArea));
		assertTrue(expectedResult.contains(this.enemyCrossArea.getPos()));
	}

}
