package logics.game_object.artefact;

import utilis.Pair;

public interface WeaponArtefactFactory {
	
	/**
	 * 
	 * @param pos is the artefact spawn position
	 * @return an artefact that change the weapon into a stick
	 */
	public Artefact stickArtefact(Pair<Integer, Integer> pos);
	
	/**
	 * 
	 * @param pos is the artefact spawn position
	 * @return an artefact that change the weapon into a tube
	 */
	public Artefact tubeArtefact(Pair<Integer, Integer> pos);

	/**
	 * 
	 * @param pos is the artefact spawn position
	 * @return an artefact that change the weapon into a axe
	 */
	public Artefact axeArtefact(Pair<Integer, Integer> pos);

	/**
	 * 
	 * @param pos is the artefact spawn position
	 * @return an artefact that change the weapon into a dagger
	 */
	public Artefact daggerArtefact(Pair<Integer, Integer> pos);
	
	/**
	 * 
	 * @param pos is the artefact spawn position
	 * @return an artefact that change the weapon into a gun
	 */
	public Artefact gunArtefact(Pair<Integer, Integer> pos);
}
