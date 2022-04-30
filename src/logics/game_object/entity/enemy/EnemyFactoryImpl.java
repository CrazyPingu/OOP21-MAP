package logics.game_object.entity.enemy;

import logics.game_object.entity.SimpleEntity;
import logics.life.SimpleLifeSystem;
import logics.strategy.movement.MovementFactoryImpl;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.Pair;
import utilis.texture.EntityTexture;

/**
 * 
 * Factory to create new enemy.
 *
 */
public class EnemyFactoryImpl implements EnemyFactory {
	
	private static int LOW_HEALTH = 5;
	private static int MID_HEALTH = 7;
	private static int HIGH_HEALTH = 10;

	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieStick(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(LOW_HEALTH), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie stick", EntityTexture.ZOMBIE_STICK);
	}

	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieAxe(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(LOW_HEALTH), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie axe", EntityTexture.ZOMBIE_AXE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieDagger(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(MID_HEALTH), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().runMovement(), "zombie dagger", EntityTexture.ZOMBIE_DAGGER);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieTube(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(HIGH_HEALTH), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie tube", EntityTexture.ZOMBIE_TUBE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieGun(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(HIGH_HEALTH), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().runMovement(), "zombie gun", EntityTexture.ZOMBIE_GUN);
	}
	
}
