package test;

import static org.junit.Assert.*;

import java.util.List;

import controller.enemyAI.EnemyAIImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import logics.life.ExtendibleMaxLifeSystem;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

/**
 * 
 * JUnit test for enemy AI methods.
 *
 */

public class EnemyAITest {
	private EnemyAIImpl enemyAI;
	private WeaponFactoryImpl wf;
    private MovementFactoryImpl mf;
    private Player player;
    private EnemyFactoryImpl ef;
    private SimpleEnemy enemy;
    private Pair<Integer,Integer> expectedResult;
    private Pair<Integer,Integer> roomSize = new Pair<> (10, 4);
    
    @org.junit.Before
	public void init() {
    	this.enemyAI = new EnemyAIImpl();
    	this.wf = new WeaponFactoryImpl();
    	this.mf = new MovementFactoryImpl();
    	this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(2,3), wf.createAxe(),
                mf.stepMovement(), "Marcello", EntityTexture.PLAYER);
		this.enemy = ef.createZombieStick(new Pair<> (5,1));
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's moving area with different coordinates than player's position
	 */
	public void playerOutside() {
		this.player.setPos(new Pair<>(2,3));
		
		this.expectedResult = new Pair<>(4,2);
		this.enemyAI.move(enemy, player, roomSize, null);
		assertEquals(expectedResult, this.enemy.getPos());
	}
	
	
}
