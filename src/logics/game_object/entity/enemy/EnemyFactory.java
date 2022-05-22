package logics.game_object.entity.enemy;

import logics.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Interface that declares methods for the enemy factory.
 *
 */
public interface EnemyFactory {
    /**
     * @return a new enemy using a stick as a weapon.
     */
    SimpleEnemy createZombieStick(Pair<Integer, Integer> pos);
    /**
     * @return a new enemy using an axe as a weapon.
     */
    SimpleEnemy createZombieAxe(Pair<Integer, Integer> pos);
    /**
     * @return a new enemy using a dagger as a weapon.
     */
    SimpleEnemy createZombieDagger(Pair<Integer, Integer> pos);
    /**
     * @return a new enemy using a tube as a weapon.
     */
    SimpleEnemy createZombieTube(Pair<Integer, Integer> pos);
    /**
     * @return a new enemy using a gun as a weapon.
     */
    SimpleEnemy createZombieGun(Pair<Integer, Integer> pos);

}
