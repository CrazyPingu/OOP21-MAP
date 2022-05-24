package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

public class ActionNumberArtefactFactoryImpl implements ActionNumberArtefactFactory {

  @Override
  public Artefact increaseActionNumberArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "number action increaser", ArtefactTexture.ACTION_NUMBER_INCREASER) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.increaseActionNumber();
      }
    };
  }

}
