package model.game_object.entity.enemy;

import model.game_object.entity.SimpleEnemy;
import utilities.Pair;

/**
 * 
 * Interface that declares methods for the enemy factory.
 *
 */
public interface EnemyFactory {

    /**
     * Different types of health values.
     */
    enum Health {
        LOW_HEALTH(5), MID_HEALTH(7), HIGH_HEALTH(10);
        
        private final int health;

        Health(final int health) {
            this.health = health;
        }

        public int getHealth() {
            return this.health;
        }

    }

    /**
     * Different enemies' names.
     */
    enum Name {
        STICK("zombie stick"),
        AXE("zombie axe"),
        DAGGER("zombie dagger"),
        TUBE("zombie tube"),
        GUN("zombie gun");

        private String name;

        Name(final String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

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
