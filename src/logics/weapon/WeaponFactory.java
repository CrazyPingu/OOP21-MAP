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
	 * @return a axe
	 */
	public Weapon createAxe();
	/**
	 * @return a dagger
	 */
	public Weapon createDagger();
	/**
	 * @return a tube
	 */
	public Weapon createTube();
	/**
	 * @return a gun
	 */
	public Weapon createGun();

}
