package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import logics.game_object.entity.Player;
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

public class RoomTest {
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
	}

	@org.junit.Test
	/**
	 * testing the correct dimension of the big room
	 */
	public void bigRoomSize() {
		Room room = this.roomFactory.createBigRoom();
		assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MAX_X, RoomConstant.MAX_Y));
	}

	@org.junit.Test
	/**
	 * testing the correct dimension of the small room
	 */
	public void smallRoomSize() {
		Room room = this.roomFactory.createSmallRoom();
		assertEquals(room.getSize(), new Pair<Integer, Integer>(RoomConstant.MIN_X, RoomConstant.MIN_Y));
	}
}
