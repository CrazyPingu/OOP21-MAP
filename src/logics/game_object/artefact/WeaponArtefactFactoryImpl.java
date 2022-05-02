package logics.game_object.artefact;

import logics.game_object.ArtefactUserObject;
import logics.strategy.weapon.WeaponFactory;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.Pair;
import utilis.texture.ArtefactTexture;

public class WeaponArtefactFactoryImpl implements WeaponArtefactFactory {

	private WeaponFactory weaponFactory = new WeaponFactoryImpl();

	@Override
	public Artefact stickArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "stick artefact", ArtefactTexture.STRICK) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeWeapon(weaponFactory.createStick());
			}
		};
	}

	@Override
	public Artefact tubeArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "tube artefact", ArtefactTexture.TUBE) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeWeapon(weaponFactory.createTube());

			}
		};
	}

	@Override
	public Artefact axeArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "axe artefact", ArtefactTexture.AXE) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeWeapon(weaponFactory.createAxe());

			}
		};

	}

	@Override
	public Artefact daggerArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "dagger artefact", ArtefactTexture.DAGGER) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeWeapon(weaponFactory.createDagger());

			}
		};
	}

	@Override
	public Artefact gunArtefact(Pair<Integer, Integer> pos) {
		return new Artefact(pos, "gun artefact", ArtefactTexture.GUN) {

			@Override
			public void execute(ArtefactUserObject subject) {
				subject.changeWeapon(weaponFactory.createGun());

			}
		};
	}

}
