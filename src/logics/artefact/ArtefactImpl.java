package logics.artefact;

/**
 * 
 * Create an artefact designed by the passed value implementing the artefact
 * interface.
 *
 */
public class ArtefactImpl implements Artefact {
	private int value;
	private StatType statType;
	private String name;

	/**
	 * @param value    : the health of the entity.
	 * @param statType : the type of the artefact.
	 * @param name     : the name of the artefact.
	 */
	public ArtefactImpl(int value, StatType statType, String name) {
		this.value = value;
		this.statType = statType;
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * {@inheritDoc}
	 */
	public StatType getArtefactType() {
		return this.statType;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return this.name;
	}
}
