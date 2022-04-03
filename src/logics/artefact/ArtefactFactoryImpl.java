package logics.artefact;

import logics.artefact.Artefact.StatType;

/**
 * 
 * Factory to create new artefact.
 *
 */
public class ArtefactFactoryImpl implements ArtefactFactory {

	/**
	 * {@inheritDoc}
	 */
	public Artefact createMaxHealthIncreaser() {
		return new ArtefactImpl(1, StatType.MAX_HEALTH, "MaxHealthIncreaser");
	}

	/**
	 * {@inheritDoc}
	 */
	public Artefact createDamageIncreaser() {
		return new ArtefactImpl(1, StatType.DAMAGE, "DamageIncreaser");
	}

	/**
	 * {@inheritDoc}
	 */
	public Artefact createActionIncreaser() {
		return new ArtefactImpl(1, StatType.NUMBERACTION, "ActionIncreaser");
	}

}