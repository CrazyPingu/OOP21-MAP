package logics.life;

public interface HealSystem {
	
	/**
	 * 
	 * @param healValue represent the amount of life to increase. The helth value
	 *                  can't be greater than max health. Don't work with negative
	 *                  values
	 */
	void heal(int healValue); 

	/**
	 * 
	 * @return the maximum amount of health that can be reached
	 */
	int getMaxHealth(); 
}
