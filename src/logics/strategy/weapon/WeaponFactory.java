package logics.strategy.weapon;

/**
 * 
 * Interface that declares methods for the weapon factory.
 *
 */
public interface WeaponFactory {
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
