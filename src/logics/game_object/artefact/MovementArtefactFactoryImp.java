package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import logics.strategy.movement.MovementFactory;
import logics.strategy.movement.MovementFactoryImpl;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

public class MovementArtefactFactoryImp implements MovementArtefactFactory {

  final private MovementFactory movementFactory = new MovementFactoryImpl();

  @Override
  public Artefact stepArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "step artefact", ArtefactTexture.STEP) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeMovement(movementFactory.stepMovement());
      }
    };
  }

  @Override
  public Artefact runArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "step artefact", ArtefactTexture.RUN) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeMovement(movementFactory.runMovement());
      }
    };
  }

}
