package test;

import static org.junit.Assert.assertEquals;

import model.game_object.entity.Player;
import model.life_system.impl.ExtendibleMaxLifeSystem;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.RoomConstant;
import utilities.texture.EntityTexture;

/**
 * 
 * JUnit test for GameObject spawn.
 *
 */

public class GameObjectSpawnTest {

  private final WeaponFactory weaponFactory = new WeaponFactoryImpl();
  private final MovementFactory movementFactory = new MovementFactoryImpl();
  private Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
      movementFactory.stepMovement(), "Marcello", EntityTexture.PLAYER);
  private final RoomFactory roomFactory = new RoomFactoryImpl(player);
  private final Room room = roomFactory.createMediumRoom();

  /**
   * testing the number of enemy spawned
   */
  @org.junit.Test
  public void numSimpleEnemy() {
    assertEquals(room.getEnemyList().size(),
        room.getSize().getX() * room.getSize().getY() / RoomConstant.SPAWNING_RATIO);
  }

  /**
   * testing the number of artefact spawned
   */
  @org.junit.Test
  public void numArtefact() {
    assertEquals(room.getArtefactList().size(),
        room.getSize().getX() * room.getSize().getY() / RoomConstant.SPAWNING_RATIO);
  }
}
