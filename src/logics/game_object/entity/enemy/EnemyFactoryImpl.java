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

	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieStick(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(5), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie", EntityTexture.ZOMBIE_STICK);
	}

	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieAxe(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(5), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie", EntityTexture.ZOMBIE_AXE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieDagger(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(5), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().runMovement(), "zombie", EntityTexture.ZOMBIE_DAGGER);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieTube(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(5), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().stepMovement(), "zombie", EntityTexture.ZOMBIE_TUBE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SimpleEntity createZombieGun(Pair<Integer, Integer> pos) {
		return new SimpleEntity(new SimpleLifeSystem(5), pos, new WeaponFactoryImpl().createStick(),
				new MovementFactoryImpl().runMovement(), "zombie", EntityTexture.ZOMBIE_GUN);
	}
	
}
