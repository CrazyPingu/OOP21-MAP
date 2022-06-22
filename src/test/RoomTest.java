package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.life_system.impl.ExtendibleMaxLifeSystem;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;
import utilities.texture.EntityTexture;

/**
 * 
 * Junit test for room
 *
 */
public class RoomTest {
  private final WeaponFactory weaponFactory = new WeaponFactoryImpl();
  private final MovementFactory movementFactory = new MovementFactoryImpl();
  private final Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
      movementFactory.createStepMovement(), "Marcello", EntityTexture.PLAYER);
  private final RoomFactory roomFactory = new RoomFactoryImpl(player);

  /**
   * testing the correct dimension of the big room
   */
  @org.junit.Test
  public void bigRoomSize() {
    final Room room = this.roomFactory.createBigRoom();
    assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MAX_X, RoomConstant.MAX_Y));
  }

  /**
   * testing the correct dimension of the small room
   */
  @org.junit.Test
  public void smallRoomSize() {
    final Room room = this.roomFactory.createSmallRoom();
    assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MIN_X, RoomConstant.MIN_Y));
  }

  /**
   * testing the correct spawn of the enemy
   */
  @org.junit.Test
  public void forbiddenZombieSpawn() {
    final Room room = this.roomFactory.createMediumRoom();
    boolean flag = false;
    for (final SimpleEnemy x : room.getEnemyList()) {
      if (x.getPos().getX() < RoomConstant.FORBIDDEN_ZOMBIE_SPAWN) {
        flag = true;
      }
    }
    assertFalse(flag);
  }
}
