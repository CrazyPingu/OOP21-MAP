package model.game_object.artefact.factories;

import model.game_object.ArtefactUserObject;
import model.game_object.artefact.Artefact;
import model.movement.MovementFactory;
import model.movement.MovementFactoryImpl;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

/**
 * 
 * This class implements the method for the creation of the movement artefacts.
 * This class follow the pattern Factory.
 */
public class MovementArtefactFactoryImp implements MovementArtefactFactory {

  final private MovementFactory movementFactory = new MovementFactoryImpl();

  @Override
  public Artefact createStepArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "step artefact", ArtefactTexture.STEP) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeMovement(movementFactory.createStepMovement());
      }
    };
  }

  @Override
  public Artefact createRunArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "run artefact", ArtefactTexture.RUN) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeMovement(movementFactory.createRunMovement());
      }
    };
  }

}
