package model.game_object.artefact;

import model.game_object.ArtefactUserObject;
import model.weapon.WeaponFactory;
import model.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.ArtefactTexture;

public class WeaponArtefactFactoryImpl implements WeaponArtefactFactory {

    final private WeaponFactory weaponFactory = new WeaponFactoryImpl();

    @Override
    public Artefact stickArtefact(final Pair<Integer, Integer> pos) {
        return new Artefact(pos, "stick artefact", ArtefactTexture.STRICK) {
            @Override
            public void execute(final ArtefactUserObject subject) {
                subject.changeWeapon(weaponFactory.createStick());
            }
        };
    }

    @Override
    public Artefact tubeArtefact(final Pair<Integer, Integer> pos) {
        return new Artefact(pos, "tube artefact", ArtefactTexture.TUBE) {
            @Override
            public void execute(final ArtefactUserObject subject) {
                subject.changeWeapon(weaponFactory.createTube());
            }
        };
    }

    @Override
    public Artefact axeArtefact(final Pair<Integer, Integer> pos) {
        return new Artefact(pos, "axe artefact", ArtefactTexture.AXE) {
            @Override
            public void execute(final ArtefactUserObject subject) {
                subject.changeWeapon(weaponFactory.createAxe());
            }
        };
    }

    @Override
    public Artefact daggerArtefact(final Pair<Integer, Integer> pos) {
        return new Artefact(pos, "dagger artefact", ArtefactTexture.DAGGER) {
            @Override
            public void execute(final ArtefactUserObject subject) {
                subject.changeWeapon(weaponFactory.createDagger());
            }
        };
    }

    @Override
    public Artefact gunArtefact(final Pair<Integer, Integer> pos) {
        return new Artefact(pos, "gun artefact", ArtefactTexture.GUN) {
            @Override
            public void execute(final ArtefactUserObject subject) {
                subject.changeWeapon(weaponFactory.createGun());
            }
        };
    }

}
