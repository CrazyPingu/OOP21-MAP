package logics.game_object.artefact;

import utilis.Pair;

public interface HealthArtefactFactory {
	
	/**
	 *
	 * @param pos is the artefact spawn position
	 * @return an artefact that heal the subject 
	 */
	public Artefact littleHealArtefact(Pair<Integer, Integer> pos); 
	
	/**
	 *
	 * @param pos is the artefact spawn position
	 * @return an artefact that heal the subject
	 */
	public Artefact bigHealArtefact(Pair<Integer, Integer> pos); 
	
	/**
	 *
	 * @param pos is the artefact spawn position
	 * @return an artefact that extend the subject's life
	 */
	public Artefact extendsLifeArtefact(Pair<Integer, Integer> pos);
	
}
