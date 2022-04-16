package logics.weapon;

import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;

public class WeaponFactoryImpl implements WeaponFactory {
	
	private static int STICK_DAMAGE = 10;
	private static int AX_DAMAGE = 20;
	private static int DAGGER_DAMAGE = 30;
	private static int GUN_DAMAGE = 40;

	/**
	 * {@inheritDoc}
	 */
	public Weapon createStick() {
		Strategy stickStrategy = new Strategy() {
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}		
		};
		
		WeaponImpl stick = new WeaponImpl(STICK_DAMAGE, stickStrategy);		
		return stick;
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createAx() {
		Strategy axStrategy = new Strategy() {
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}		
		};
		
		WeaponImpl ax = new WeaponImpl(AX_DAMAGE, axStrategy);		
		return ax;
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon createDagger() {
		Strategy daggerStrategy = new Strategy() {
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}		
		};
		
		WeaponImpl dagger = new WeaponImpl(DAGGER_DAMAGE, daggerStrategy);		
		return dagger;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Weapon createGun() {
		Strategy gunStrategy = new Strategy() {
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}		
		};
		
		WeaponImpl gun = new WeaponImpl(GUN_DAMAGE, gunStrategy);		
		return gun;
	}
	
}
