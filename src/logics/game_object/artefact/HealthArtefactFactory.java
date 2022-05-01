package logics.game_object.artefact;

import utilis.Pair;

public interface HealthArtefactFactory {
	
	/**
	 * 
	 * @return an artefact that heal a little who consume it
	 */
	public Artefact littleHealArtefact(Pair<Integer, Integer> pos); 
	
	/**
	 * 
	 * @return an artefact that heal a lot who consume it
	 */
	public Artefact bigHealArtefact(Pair<Integer, Integer> pos); 
	
	/**
	 * 
	 * @return a life-extending artefact 
	 */
	public Artefact extendsLifeArtefact(Pair<Integer, Integer> pos);
	
}
