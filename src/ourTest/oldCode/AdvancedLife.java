package ourTest.oldCode;

public interface AdvancedLife extends BasicLife {
	/**
	 * 
	 * @param maxHealthValue upgrade maximum amount of health that can be currently
	 *                       reached. The maximum amount of health can't be greater
	 *                       than the limit specified in the constructor and have to
	 *                       be equals or greater than 1. 
	 */
	public void upgradeMaxHealth(int maxHealthValue);

	/**
	 * 
	 * @return the maximum value that maxHealth can reach. This parameter is
	 *         specified in the constructor.
	 */
	public int getMaxHealthLimit();
}
