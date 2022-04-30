package logics.strategy.weapon;

import logics.strategy.concrete_strategies.*;

/**
 * 
 * Factory with methods to create different types of weapons.
 *
 */

public class WeaponFactoryImpl implements WeaponFactory {
	
	private static int STICK_DAMAGE = 1;
	private static int TUBE_DAMAGE = 2;
	private static int AX_DAMAGE = 3;
	private static int DAGGER_DAMAGE = 3;
	private static int GUN_DAMAGE = 4;

	/**
	 * {@inheritDoc}
	 */
	public Weapon createStick() {
		return new WeaponImpl(STICK_DAMAGE, "stick", new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createAxe() {
		return new WeaponImpl(AX_DAMAGE, "axe", new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createDagger() {
		return new WeaponImpl(DAGGER_DAMAGE, "dagger", new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Weapon createTube() {
		return new WeaponImpl(TUBE_DAMAGE, "tube", new AsteriskArea(VariableDistanceConstants.SINGLE_DISTANCE));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Weapon createGun() {
		return new WeaponImpl(GUN_DAMAGE, "gun", new AroundArea(VariableDistanceConstants.DOUBLE_DISTANCE));
	}
	
}
