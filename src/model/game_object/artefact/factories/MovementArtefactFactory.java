package model.game_object.artefact.factories;

import model.game_object.artefact.Artefact;
import utilities.Pair;

/**
 * 
 * This interface declare the method for a class that create movement artefacts.
 * The implementation class follow the pattern Factory.
 */
public interface MovementArtefactFactory {

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the subject moving strategy in the Step one
   */
  Artefact createStepArtefact(Pair<Integer, Integer> pos);

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that change the subject moving strategy in the Run one
   */
  Artefact createRunArtefact(Pair<Integer, Integer> pos);

}
