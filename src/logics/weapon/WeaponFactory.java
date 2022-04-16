package logics.weapon;

/**
 * 
 * Interface that declares methods for the weapon factory.
 *
 */
public interface WeaponFactory {

	/**
	 * @return a stick
	 */
	public Weapon createStick();
	/**
	 * @return a ax
	 */
	public Weapon createAx();
	/**
	 * @return a dagger
	 */
	public Weapon createDagger();
	/**
	 * @return a gun
	 */
	public Weapon createGun();

}
