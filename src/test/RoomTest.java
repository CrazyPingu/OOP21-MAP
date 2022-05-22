package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.life.ExtendibleMaxLifeSystem;
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
 * Junit test for room
 *
 */
public class RoomTest {
  private WeaponFactory weaponFactory = new WeaponFactoryImpl();;
  private MovementFactory movementFactory = new MovementFactoryImpl();;
  private Player player = new Player(new ExtendibleMaxLifeSystem(4, 10, 20), weaponFactory.createAxe(),
      movementFactory.stepMovement(), "Marcello", EntityTexture.PLAYER);
  private RoomFactory roomFactory = new RoomFactoryImpl(player);;

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
    final Room room = this.roomFactory.createRandomRoom();
    boolean flag = false;
    for (final SimpleEnemy x : room.getEnemyList()) {
      if (x.getPos().getX() < RoomConstant.FORBIDDEN_ZOMBIE_SPAWN) {
        flag = true;
      }
    }
    assertFalse(flag);
  }
}
