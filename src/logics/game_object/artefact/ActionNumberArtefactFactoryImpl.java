package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import utilis.Pair;
import utilis.texture.ArtefactTexture;

public class ActionNumberArtefactFactoryImpl implements ActionNumberArtefactFactory {

	@Override
	public Artefact increaseActionNumberArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "number action increaser", ArtefactTexture.ACTION_NUMBER_INCREASER) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.increaseActionNumber();
			}
		};
	}

}
