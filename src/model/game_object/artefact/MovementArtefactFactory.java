package model.game_object.artefact;

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
  Artefact stepArtefact(Pair<Integer, Integer> pos);

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that change the subject moving strategy in the Run one
   */
  Artefact runArtefact(Pair<Integer, Integer> pos);

}
