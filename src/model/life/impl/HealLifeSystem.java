package model.life.impl;

import model.life.HealSystem;

public class HealLifeSystem implements HealSystem {

  private SimpleLifeSystem life;
  private final int maxHealth;

  /**
   * 
   * @param startingLife is the amount of health the system start with. If greater
   *                     than maxHealth it will automatically replaced with
   *                     maxHealth value
   * @param maxHealth    the maximum amount of health that can be reached using
   *                     heal method
   */
  public HealLifeSystem(final int startingLife, final int maxHealth) {
    final int newStartingLife = startingLife <= maxHealth ? startingLife : maxHealth;
    this.life = new SimpleLifeSystem(newStartingLife);
    this.maxHealth = maxHealth;
  }

  @Override
  public void heal(final int healValue) {
    if (healValue > 0 && !this.isDead()) {
      final int newHealthValue = (this.life.getCurrentHealth() + healValue) > maxHealth ? maxHealth
          : this.life.getCurrentHealth() + healValue;
      this.life = new SimpleLifeSystem(newHealthValue);
    }
  }

  @Override
  public int getMaxHealth() {
    return this.maxHealth;
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

}
