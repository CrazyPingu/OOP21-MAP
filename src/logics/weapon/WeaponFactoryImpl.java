package logics.weapon;

import java.util.List;

import logics.strategy.concrete_strategies.*;

public class WeaponFactoryImpl implements WeaponFactory {
	
	private static int STICK_DAMAGE = 10;
	private static int AX_DAMAGE = 20;
	private static int DAGGER_DAMAGE = 30;
	private static int GUN_DAMAGE = 40;

	/**
	 * {@inheritDoc}
	 */
	public Weapon createStick() {
		return new WeaponImpl(STICK_DAMAGE, new AroundArea());
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createAx() {
		return new WeaponImpl(AX_DAMAGE, new AroundArea());
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createDagger() {
		return new WeaponImpl(DAGGER_DAMAGE, new CrossArea());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Weapon createGun() {
		return new WeaponImpl(GUN_DAMAGE, new AroundArea());
	}
	
}
