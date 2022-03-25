package logics.artefact;

/**
 * 
 * Interface that declares methods for the artefact.
 *
 */
public interface Artefact {

	/**
	 * Type that the artefact can be.
	 */
	static public enum StatType {
		/**
		 * An artefact can increase the maximum health of an entity.
		 */
		MAX_HEALTH,

		/**
		 * An artefact can increase the number of action in a turn of an entity.
		 */
		NUMBERACTION,

		/**
		 * An artefact can increase the base damage of an entity.
		 */
		DAMAGE;
	}

	/**
	 * @return the value of the statistic change.
	 */
	public int getValue();

	/**
	 * @return type of artefact.
	 */
	public StatType getArtefactType();
	
	/**
	 * @return the name of the artefact.
	 */
	public String getName();

}
