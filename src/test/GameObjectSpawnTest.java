package test;

import static org.junit.Assert.assertEquals;

import logics.game_object.entity.Player;
import logics.game_object.entity.enemy.EnemyFactoryImpl;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.works.RandomEnemyList;
import logics.room.works.Room;
import logics.room.works.RoomFactory;
import logics.room.works.RoomFactoryImpl;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;
import utilities.texture.EntityTexture;

/**
 * 
 * JUnit test for GameObject spawn.
 *
 */

public class GameObjectSpawnTest {

	private Room room;
	private RoomFactory roomFactory;
	private WeaponFactory weaponFactory;
	private MovementFactory movementFactory;
	private Player player;
	
	@org.junit.Before
	public void init() {
		this.weaponFactory = new WeaponFactoryImpl();
		this.movementFactory = new MovementFactoryImpl();
		this.player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
				movementFactory.stepMovement(), "Marcello", EntityTexture.PLAYER);
		this.roomFactory = new RoomFactoryImpl(player);
		this.room = roomFactory.createRandomRoom();
	}
	
	@org.junit.Test
	/**
	 * testing the number of enemy spawned
	 */
	public void numSimpleEnemy() {
		assertEquals(room.getEnemyList().size(),room.getSize().getX() * room.getSize().getY() / RoomConstant.SPAWNING_RATIO);
	}
	
	@org.junit.Test
	/**
	 * testing the number of artefact spawned
	 */
	public void numArtefact() {
		assertEquals(room.getArtefactList().size(),room.getSize().getX() * room.getSize().getY() / RoomConstant.SPAWNING_RATIO);
	}
}
