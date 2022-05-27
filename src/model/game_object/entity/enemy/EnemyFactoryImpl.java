package model.game_object.entity.enemy;

import model.game_object.entity.SimpleEnemy;
import model.life.impl.SimpleLifeSystem;
import model.strategy.movement.MovementFactoryImpl;
import model.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.texture.EntityTexture;

/**
 * 
 * Factory to create new enemy.
 *
 */
public class EnemyFactoryImpl implements EnemyFactory {
    private final static int LOW_HEALTH = 5;
    private final static int MID_HEALTH = 7;
    private final static int HIGH_HEALTH = 10;

    @Override
    public SimpleEnemy createZombieStick(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(LOW_HEALTH), pos, new WeaponFactoryImpl().createStick(),
                new MovementFactoryImpl().stepMovement(), "zombie stick", EntityTexture.ZOMBIE_STICK);
    }

    @Override
    public SimpleEnemy createZombieAxe(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(LOW_HEALTH), pos, new WeaponFactoryImpl().createAxe(),
                new MovementFactoryImpl().stepMovement(), "zombie axe", EntityTexture.ZOMBIE_AXE);
    }

    @Override
    public SimpleEnemy createZombieDagger(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(MID_HEALTH), pos, new WeaponFactoryImpl().createDagger(),
                new MovementFactoryImpl().runMovement(), "zombie dagger", EntityTexture.ZOMBIE_DAGGER);
    }

    @Override
    public SimpleEnemy createZombieTube(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(HIGH_HEALTH), pos, new WeaponFactoryImpl().createTube(),
                new MovementFactoryImpl().stepMovement(), "zombie tube", EntityTexture.ZOMBIE_TUBE);
    }

    @Override
    public SimpleEnemy createZombieGun(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(HIGH_HEALTH), pos, new WeaponFactoryImpl().createGun(),
                new MovementFactoryImpl().runMovement(), "zombie gun", EntityTexture.ZOMBIE_GUN);
    }
}
