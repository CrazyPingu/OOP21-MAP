package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.life.impl.ExtendibleMaxLifeSystem;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import model.strategy.movement.MovementFactory;
import model.strategy.movement.MovementFactoryImpl;
import model.strategy.weapon.WeaponFactory;
import model.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;
import utilities.texture.EntityTexture;

/**
 * 
 * Junit test for room
 *
 */
public class RoomTest {
  private WeaponFactory weaponFactory = new WeaponFactoryImpl();;
  private MovementFactory movementFactory = new MovementFactoryImpl();;
  private Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
      movementFactory.stepMovement(), "Marcello", EntityTexture.PLAYER);
  private RoomFactory roomFactory = new RoomFactoryImpl(player);

  @org.junit.Test
  /**
   * testing the correct dimension of the big room
   */
  public void bigRoomSize() {
    final Room room = this.roomFactory.createBigRoom();
    assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MAX_X, RoomConstant.MAX_Y));
  }

  @org.junit.Test
  /**
   * testing the correct dimension of the small room
   */
  public void smallRoomSize() {
    final Room room = this.roomFactory.createSmallRoom();
    assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MIN_X, RoomConstant.MIN_Y));
  }

  @org.junit.Test
  /**
   * testing the correct spawn of the enemy
   */
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
