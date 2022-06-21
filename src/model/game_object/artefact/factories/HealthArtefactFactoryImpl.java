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
public class HealthArtefactFactoryImpl implements HealthArtefactFactory {

  private static final int LITTLE_HEAL_VALUE = 2;
  private static final int BIG_HEAL_VALUE = 4;
  private static final int LIFE_EXTENSION_VALUE = 1;

  @Override
  public Artefact littleHealArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "little heal", ArtefactTexture.LITTLE_HEAL) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.heal(LITTLE_HEAL_VALUE);
      }
    };
  }

  @Override
  public Artefact bigHealArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "big heal", ArtefactTexture.BIG_HEAL) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.heal(BIG_HEAL_VALUE);
      }
    };
  }

  @Override
  public Artefact extendsLifeArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "life extension", ArtefactTexture.HEALTH_EXTENDER) {

      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.setMaxHealth(subject.getMaxHealth() + LIFE_EXTENSION_VALUE);
      }
    };
  }

}
