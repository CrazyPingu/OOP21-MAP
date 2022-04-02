package logics.artefact;

/**
 * 
 * Interface that declares methods for the artefact factory.
 *
 */

public interface ArtefactFactory {
	
	/**
	 * @return a new artefact that encrease the maxHealth of 1 unit.
	 */
	public Artefact createMaxHealthIncreaser();
	
	/**
	 * @return a new artefact that encrease the damage of 1 unit.
	 */
	public Artefact createDamageIncreaser();
	
	/**
	 * @return a new artefact that encrease the number action of 1 unit.
	 */
	public Artefact createActionIncreaser();
}
