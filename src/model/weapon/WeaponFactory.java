package model.weapon;

/**
 * 
 * Interface that declares methods for the weapon factory.
 *
 */
public interface WeaponFactory {
    
    /**
     * Different types of damage values.
     */
    enum Damage {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4);
        
        private final int damage;

        Damage(final int damage) {
            this.damage = damage;
        }

        public int getDamage() {
            return this.damage;
        }

    }

    /**
     * Different weapons' names.
     */
    enum Name {
        STICK("stick"),
        AXE("axe"),
        DAGGER("dagger"),
        TUBE("tube"),
        GUN("gun");

        private String name;

        Name(final String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }    
    
    /**
     * @return a stick
     */
    Weapon createStick();

    /**
     * @return a axe
     */
    Weapon createAxe();

    /**
     * @return a dagger
     */
    Weapon createDagger();

    /**
     * @return a tube
     */
    Weapon createTube();

    /**
     * @return a gun
     */
    Weapon createGun();
}
