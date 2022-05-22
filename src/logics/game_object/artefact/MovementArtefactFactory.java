package logics.game_object.artefact;

import utilities.Pair;

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
