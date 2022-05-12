package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import utilis.texture.ArtefactTexture;
import utilities.Pair;

public class HealthArtefactFactoryImpl implements HealthArtefactFactory {

	public final int LITTLE_HEAL_VALUE = 2;
	public final int BIG_HEAL_VALUE = 4;
	public final int LIFE_EXTENSION_VALUE = 1;

	@Override
	public Artefact littleHealArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "little heal", ArtefactTexture.LITTLE_HEAL) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.heal(LITTLE_HEAL_VALUE);
			}
		};
	}

	@Override
	public Artefact bigHealArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "big heal", ArtefactTexture.BIG_HEAL) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.heal(BIG_HEAL_VALUE);
			}
		};
	}

	@Override
	public Artefact extendsLifeArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "life extension", ArtefactTexture.HEALTH_EXTENDER) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.setMaxHealth(subject.getMaxHealth() + LIFE_EXTENSION_VALUE);
			}
		};
	}

}
