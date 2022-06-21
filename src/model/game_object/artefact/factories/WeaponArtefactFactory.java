package model.game_object.artefact.factories;

import model.game_object.artefact.Artefact;
import utilities.Pair;

/**
 * 
 * This interface declare the method for a class that create change weapon
 * artefacts. The implementation class follow the pattern Factory.
 */
public interface WeaponArtefactFactory {

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a stick
   */
  Artefact createStickArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a tube
   */
  Artefact createTubeArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a axe
   */
  Artefact createAxeArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a dagger
   */
  Artefact createDaggerArtefact(Pair<Integer, Integer> pos);

  /**
   * 
   * @param pos is the artefact spawn position
   * @return an artefact that change the weapon into a gun
   */
  Artefact createGunArtefact(Pair<Integer, Integer> pos);
}
