package model.game_object.artefact;

import utilities.Pair;

public interface HealthArtefactFactory {

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that heal the subject
   */
  Artefact littleHealArtefact(Pair<Integer, Integer> pos);

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that heal the subject
   */
  Artefact bigHealArtefact(Pair<Integer, Integer> pos);

  /**
   *
   * @param pos is the artefact spawn position
   * @return an artefact that extend the subject's life
   */
  Artefact extendsLifeArtefact(Pair<Integer, Integer> pos);

}
