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

    @Override
    public SimpleEnemy createZombieStick(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(Health.LOW_HEALTH.getHealth()), pos, new WeaponFactoryImpl().createStick(),
                new MovementFactoryImpl().stepMovement(), Name.STICK.getName(), EntityTexture.ZOMBIE_STICK);
    }

    @Override
    public SimpleEnemy createZombieAxe(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(Health.LOW_HEALTH.getHealth()), pos, new WeaponFactoryImpl().createAxe(),
                new MovementFactoryImpl().stepMovement(), Name.AXE.getName(), EntityTexture.ZOMBIE_AXE);
    }

    @Override
    public SimpleEnemy createZombieDagger(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(Health.MID_HEALTH.getHealth()), pos, new WeaponFactoryImpl().createDagger(),
                new MovementFactoryImpl().runMovement(), Name.DAGGER.getName(), EntityTexture.ZOMBIE_DAGGER);
    }

    @Override
    public SimpleEnemy createZombieTube(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(Health.HIGH_HEALTH.getHealth()), pos, new WeaponFactoryImpl().createTube(),
                new MovementFactoryImpl().stepMovement(), Name.TUBE.getName(), EntityTexture.ZOMBIE_TUBE);
    }

    @Override
    public SimpleEnemy createZombieGun(final Pair<Integer, Integer> pos) {
        return new SimpleEnemy(new SimpleLifeSystem(Health.HIGH_HEALTH.getHealth()), pos, new WeaponFactoryImpl().createGun(),
                new MovementFactoryImpl().runMovement(), Name.GUN.getName(), EntityTexture.ZOMBIE_GUN);
    }
}
