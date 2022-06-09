package model.weapon;

import model.strategy.concrete_strategies.AroundArea;
import model.strategy.concrete_strategies.AsteriskArea;
import model.strategy.concrete_strategies.VariableDistanceConstants;

/**
 * 
 * Factory with methods to create different types of weapons.
 *
 */

public class WeaponFactoryImpl implements WeaponFactory {

    @Override
    public Weapon createStick() {
        return new WeaponImpl(Damage.ONE.getDamage(), Name.STICK.getName(), new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
    }

    @Override
    public Weapon createAxe() {
        return new WeaponImpl(Damage.THREE.getDamage(), Name.AXE.getName(), new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
    }

    @Override
    public Weapon createDagger() {
        return new WeaponImpl(Damage.THREE.getDamage(), Name.DAGGER.getName(), new AroundArea(VariableDistanceConstants.SINGLE_DISTANCE));
    }

    @Override
    public Weapon createTube() {
        return new WeaponImpl(Damage.TWO.getDamage(), Name.TUBE.getName(), new AsteriskArea(VariableDistanceConstants.SINGLE_DISTANCE));
    }

    @Override
    public Weapon createGun() {
        return new WeaponImpl(Damage.FOUR.getDamage(), Name.GUN.getName(), new AroundArea(VariableDistanceConstants.DOUBLE_DISTANCE));
    }

}
