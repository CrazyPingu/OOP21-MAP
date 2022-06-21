package model.game_object.artefact.factories;

import model.game_object.ArtefactUserObject;
import model.game_object.artefact.Artefact;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

/**
 * 
 * This class implements the method for the creation of the change weapon
 * artefacts. This class follow the pattern Factory.
 */
public class WeaponArtefactFactoryImpl implements WeaponArtefactFactory {

  final private WeaponFactory weaponFactory = new WeaponFactoryImpl();

  @Override
  public Artefact createStickArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "stick artefact", ArtefactTexture.STRICK) {
      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeWeapon(weaponFactory.createStick());
      }
    };
  }

  @Override
  public Artefact createTubeArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "tube artefact", ArtefactTexture.TUBE) {
      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeWeapon(weaponFactory.createTube());
      }
    };
  }

  @Override
  public Artefact createAxeArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "axe artefact", ArtefactTexture.AXE) {
      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeWeapon(weaponFactory.createAxe());
      }
    };
  }

  @Override
  public Artefact createDaggerArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "dagger artefact", ArtefactTexture.DAGGER) {
      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeWeapon(weaponFactory.createDagger());
      }
    };
  }

  @Override
  public Artefact createGunArtefact(final Pair<Integer, Integer> pos) {
    return new Artefact(pos, "gun artefact", ArtefactTexture.GUN) {
      @Override
      public void execute(final ArtefactUserObject subject) {
        subject.changeWeapon(weaponFactory.createGun());
      }
    };
  }

}
