package logics.game_object.artefact;

import java.awt.Image;

import logics.game_object.ArtefactUserObject;
import logics.game_object.GameObject;
import utilities.Pair;

/**
 * 
 * This interface declare the common method for every artefact.
 *
 */
public abstract class Artefact implements GameObject {

	private Pair<Integer, Integer> pos;
	private String name;
	private Image textureImage;

	/**
	 * 
	 * @param pos  represent the position of the artefact in the game grid
	 * @param name is the artefact name
	 * @param the  texture of the player. Texture can be found in utilis.texture
	 */
	public Artefact(Pair<Integer, Integer> pos, String name, Image textureImage) {
		this.pos = pos;
		this.name = name;
		this.textureImage = textureImage;
	}

	/**
	 * 
	 * @return the current position of the object
	 */
	public Pair<Integer, Integer> getPos() {
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
	 * @return the object's texture image
	 */
	@Override
	public Image getTextureImage() {
		return this.textureImage;
	}

	/**
	 * 
	 * @param subject represent the subject to which the effect will be applied
	 */
	public abstract void execute(ArtefactUserObject subject);

}
