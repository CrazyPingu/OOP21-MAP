package model.game_object.artefact;

import utilities.Pair;

/**
 * 
 * This interface declare the method for a class that create action number
 * artefacts. The implementation class follow the pattern Factory.
 */
public interface ActionNumberArtefactFactory {

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that increase the subject action number
   */
  Artefact increaseActionNumberArtefact(Pair<Integer, Integer> pos);
}
