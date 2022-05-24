package logics.game_object.artefact;

import utilities.Pair;

public interface WeaponArtefactFactory {

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a stick
   */
  Artefact stickArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a tube
   */
  Artefact tubeArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a axe
   */
  Artefact axeArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a dagger
   */
  Artefact daggerArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a gun
   */
  Artefact gunArtefact(Pair<Integer, Integer> pos);
}
