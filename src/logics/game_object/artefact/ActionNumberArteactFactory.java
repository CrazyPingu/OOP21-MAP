package logics.game_object.artefact;

import utilis.Pair;

public interface ActionNumberArteactFactory {

	/**
	 *
	 * @param pos is the artefact spawn position
	 * @return an artefact that increase the subject action number
	 */
	public Artefact increaseActionNumberArtefact(Pair<Integer, Integer> pos);
}
