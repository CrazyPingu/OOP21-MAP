package logics.game_object;

import utilis.Pair;

/**
 * 
 * This class declare the common method for every object in game that can be
 * displayed in the game grid.
 *
 */
public interface GameObject {
	
	/**
	 * 
	 * @return the current position of the object
	 */
	public Pair<Integer, Integer> getPos();
	
	/**
	 * 
	 * @return the name of the GameObject
	 */
	public String getName(); 
	
	/**
	 * 
	 * @return the object's texture path
	 */
	public String getImagePath(); 

}
