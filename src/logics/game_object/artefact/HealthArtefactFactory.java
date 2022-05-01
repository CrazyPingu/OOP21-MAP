package logics.game_object.artefact;

public interface ArtefactFactory {
	
	/**
	 * 
	 * @return an artefact that heal who consume it
	 */
	public Artefact healArtefact(); 
	
	/**
	 * 
	 * @return a life-extending artefact 
	 */
	public Artefact extendsLifeArtefact();
	
	
	/**
	 * 
	 * @return a movement-changer artefact; 
	 */
	public Artefact changeMovingStrategyArtefact(); 
}
