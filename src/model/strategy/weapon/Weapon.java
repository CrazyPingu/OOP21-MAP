package model.strategy.weapon;

import java.util.List;

import utilities.Pair;

/**
 * 
 * Interface that declares methods for the weapon. Represent the "Context" of
 * Factory interface.
 *
 */
public interface Weapon {
    /**
     * @return the damage of the weapon.
     */
    int getDamage();

    /**
     * @return the name of the weapon.
     */
    String getName();

    /**
     * @return list of available cells to attack based on shooting strategy applied.
     */
    List<Pair<Integer, Integer>> getAttackArea(Pair<Integer, Integer> pos, Pair<Integer, Integer> size);
}
