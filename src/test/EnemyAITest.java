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
import logics.strategy.concrete_strategies.AroundArea;
import logics.strategy.concrete_strategies.VariableDistanceConstants;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.movement.MovementImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;
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
		this.totalPanel = new TotalPanel(room, player);
		this.enemyAI = new EnemyAIImpl(totalPanel, player);
		this.room.getEnemyList().clear();
		this.enemyAroundArea = ef.createZombieStick(new Pair<>(5, 1));
		this.room.getEnemyList().add(this.enemyAroundArea);
		this.enemyCrossArea = ef.createZombieGun(new Pair<>(3, 3));
		this.room.getEnemyList().add(this.enemyCrossArea);
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's attack
	 */
	public void attackPlayerInArea() {
		this.player.setPos(new Pair<>(4, 1));
		int expectedHealth = this.player.getHealth() - this.enemyAroundArea.getWeapon().getDamage();
		this.enemyAI.attack(this.enemyAroundArea, this.player);
		assertEquals(expectedHealth, this.player.getHealth());
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's moving area with enemy and player with the same X coordinate
	 */
	public void playerAlignedX() {
		this.player.setPos(new Pair<>(2,1));
		
		this.expectedResult = new Pair<>(4,1);
		this.enemyAI.move(enemy, player, roomSize, null);
		assertEquals(expectedResult, this.enemy.getPos());
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's moving area with enemy and player with the same X coordinate
	 */
	public void playerAlignedY() {
		this.player.setPos(new Pair<>(5,3));
		
		this.expectedResult = new Pair<>(5,2);
		this.enemyAI.move(enemy, player, roomSize, null);
		assertEquals(expectedResult, this.enemy.getPos());
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's attack
	 */
	public void attackPlayerInArea() {
		this.player.setPos(new Pair<>(4,1));
		
		int expectedHealth = this.player.getHealth()-this.enemy.getWeapon().getDamage();
		this.enemyAI.attack(enemy, player);
		assertEquals(expectedHealth, this.player.getHealth());
	}
}
