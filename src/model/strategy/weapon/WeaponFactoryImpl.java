package model.strategy.weapon;

import model.strategy.concrete_strategies.AroundArea;
import model.strategy.concrete_strategies.AsteriskArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;

/**
 * 
 * Factory with methods to create different types of weapons.
 *
 */

public class WeaponFactoryImpl implements WeaponFactory {
    final private static int STICK_DAMAGE = 1;
    final private static int TUBE_DAMAGE = 2;
    final private static int AXE_DAMAGE = 3;
    final private static int DAGGER_DAMAGE = 3;
    final private static int GUN_DAMAGE = 4;

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
        return new WeaponImpl(AXE_DAMAGE, "axe", new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
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
