package test;

import static org.junit.Assert.assertEquals;

import logics.game_object.entity.Player;
import logics.life.ExtendibleMaxLifeSystem;
import logics.room.Room;
import logics.room.RoomFactory;
import logics.room.RoomFactoryImpl;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.RoomConstant;
import utilities.texture.EntityTexture;

/**
 * 
 * JUnit test for GameObject spawn.
 *
 */

public class GameObjectSpawnTest {

  private WeaponFactory weaponFactory = new WeaponFactoryImpl();;
  private MovementFactory movementFactory = new MovementFactoryImpl();;
  private Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
      movementFactory.stepMovement(), "Marcello", EntityTexture.PLAYER);
  private RoomFactory roomFactory = new RoomFactoryImpl(player);
  private Room room = roomFactory.createRandomRoom();
	
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
