package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import utilis.Pair;
import utilis.texture.ArtefactTexture;

public class MovementArtefactFactoryImp implements MovementArtefactFactory {

	private MovementFactory movementFactory = new MovementFactoryImpl(); 
	
	@Override
	public Artefact stepArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "step artefact", ArtefactTexture.STEP) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeMovement(movementFactory.stepMovement());
			}
		};
	}

	@Override
	public Artefact runArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "step artefact", ArtefactTexture.RUN) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeMovement(movementFactory.runMovement());
			}
		};
	}

}