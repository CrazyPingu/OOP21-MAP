package logics.strategy.weapon;

import java.util.List;

import logics.strategy.Strategy;
import utilities.Pair;

/**
 * 
 * Create the weapon designed by the passed value implementing the weapon
 * interface.
 *
 */
public class WeaponImpl implements Weapon {
    final private int damage;
    final private String name;
    final private Strategy shootingStrategy;

    /**
     * @param damage           is the damage that the weapon can inflict
     * @param shootingStrategy is the area within the weapon can reach
     */
    public WeaponImpl(final int damage, final String name, final Strategy shootingStrategy) {
        this.damage = damage;
        this.name = name;
        this.shootingStrategy = shootingStrategy;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Pair<Integer, Integer>> getAttackArea(final Pair<Integer, Integer> pos,
            final Pair<Integer, Integer> size) {
        return this.shootingStrategy.execute(pos, size);
    }

}
