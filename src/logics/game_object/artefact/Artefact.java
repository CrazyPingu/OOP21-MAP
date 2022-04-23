package logics.game_object.artefact;

import logics.game_object.GameObject;
import logics.game_object.entity.Player;
import utilis.Pair;

/**
 * 
 * This interface declare the common method for every artefact. 
 *
 */
public abstract class Artefact implements GameObject {

	private Pair<Integer, Integer> pos; 
	private String name; 
	private String texturePath; 
	
	
	public Artefact(Pair<Integer, Integer> pos, String name, String texturePath ) {
		this.pos = pos;
		this.name = name;
		this.texturePath = texturePath; 
	}

	public Pair<Integer, Integer> getPos(){
		return this.pos; 
	}
	
	/**
	 * 
	 * @return the name of the GameObject
	 */
	public String getName() {
		return this.name; 
	} 
	
	/**
	 * 
	 * @return the object's texture path
	 */
	public String getImagePath() {
		return this.texturePath;
	} 
		
	/**
	 * 
	 * @param player represent the player to which the effect will be applied
	 */
	public abstract void execute(Player player); 
	
}
