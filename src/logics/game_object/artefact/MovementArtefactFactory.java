package logics.game_object.artefact;

import utilis.Pair;

public interface MovementArtefactFactory {
	
	/**
	 * 
	 * @return an artefact that change the subject moving strategy in the Step one
	 */
	public Artefact stepArtefact(Pair<Integer, Integer> pos); 
	
	/**
	 * 
	 * @return an artefact that change the subject moving strategy in the Run one
	 */
	public Artefact runArtefact(Pair<Integer, Integer> pos);
	
	
	
	
}
