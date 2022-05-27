package model.life.impl;

import model.life.ExtendibleMaxHealthSystem;

public class ExtendibleMaxLifeSystem implements ExtendibleMaxHealthSystem {

  private HealLifeSystem life;
  private final int maxHealthReachable;

  
  public ExtendibleMaxLifeSystem(final int startingLife, final int maxHealth, final int maxHealthReachable) {
    final int newMaxHealth = maxHealth <= maxHealthReachable ? maxHealth : maxHealthReachable;
    this.life = new HealLifeSystem(startingLife, newMaxHealth);
    this.maxHealthReachable = maxHealthReachable;
  }

  @Override
  public void setMaxHealth(final int lifeExtension) {
    final int newLifeExtension = lifeExtension <= maxHealthReachable ? lifeExtension : maxHealthReachable;
    if (lifeExtension > 0) {
      final int newStartingLifeValue = this.life.getCurrentHealth() <= lifeExtension ? this.life.getCurrentHealth()
          : lifeExtension;
      this.life = new HealLifeSystem(newStartingLifeValue, newLifeExtension);
    }
  }

  @Override
  public int getMaxHealthReachable() {
    return this.maxHealthReachable;
  }

  @Override
  public int getCurrentHealth() {
    return this.life.getCurrentHealth();
  }

  @Override
  public void damage(final int damageValue) {
    this.life.damage(damageValue);

  }

  @Override
  public Boolean isDead() {
    return this.life.isDead();
  }

  @Override
  public void heal(final int healValue) {
    this.life.heal(healValue);

  }

  @Override
  public int getMaxHealth() {
    return this.life.getMaxHealth();
  }

}
