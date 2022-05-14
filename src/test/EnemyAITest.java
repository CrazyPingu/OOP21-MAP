package test;

import static org.junit.Assert.*;

import java.util.List;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.RoomImpl;
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
	WeaponFactoryImpl wf;
    MovementFactoryImpl mf;
    Player player;
    RoomImpl room;
    EnemyFactoryImpl ef;
    SimpleEnemy enemy;
    List<Pair<Integer,Integer>> expectedResults;
    
    @org.junit.Before
	public void init() {
    	this.wf = new WeaponFactoryImpl();
    	this.mf = new MovementFactoryImpl();
    	this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), new Pair<>(2,3), wf.createAxe(),
                mf.stepMovement(), "Marcello", EntityTexture.PLAYER);
		this.room = new RoomImpl(new Pair<> (10, 4), player,  new Pair<>(2,3));
		this.enemy = ef.createZombieStick(new Pair<> (1,5));
		this.expectedResults.clear();
	}
	
	@org.junit.Test
	/**
	 * testing of enemy's moving area with different coordinates than player's position
	 */
	public void playerOutside() {
		
	}
}
