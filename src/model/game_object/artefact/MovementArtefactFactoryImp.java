package model.game_object.artefact;

import model.game_object.ArtefactUserObject;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
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
    return new Artefact(pos, "run artefact", ArtefactTexture.RUN) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeMovement(movementFactory.runMovement());
      }
    };
  }

}
