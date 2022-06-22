package model.game_object.artefact.factories;

import model.game_object.ArtefactUserObject;
import model.game_object.artefact.Artefact;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

/**
 * 
 * This class implements the method for the creation of the action number
 * artefact. This class follow the pattern Factory.
 */
public class ActionNumberArtefactFactoryImpl implements ActionNumberArtefactFactory {

  @Override
  public Artefact createActionNumberArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "number action increaser", ArtefactTexture.ACTION_NUMBER_INCREASER) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.increaseActionNumber();
      }
    };
  }

}
