package model.game_statistics;

import utilities.counter.Counter;
import utilities.counter.CounterImpl;

/**
 * 
 * Class to count the statistics of the game
 *
 */
public class GameStatisticsImpl implements GameStatistics {
  final private Counter killedEnemiesCounter;
  final private Counter completedRoomsCounter;
  final private Counter collectedArtefactsCounter;
  final private Counter attackActionCounter;
  final private Counter moveActionCounter;

  /**
   * Constructor that initializes all counters.
   */
  public GameStatisticsImpl() {
    this.killedEnemiesCounter = new CounterImpl();
    this.completedRoomsCounter = new CounterImpl();
    this.collectedArtefactsCounter = new CounterImpl();
    this.attackActionCounter = new CounterImpl();
    this.moveActionCounter = new CounterImpl();
  }

  @Override
  public void increaseKilledEnemies() {
    this.killedEnemiesCounter.increment();
  }

  @Override
  public void increaseCompletedRooms() {
    this.completedRoomsCounter.increment();
  }

  @Override
  public void increaseCollectedArtefacts() {
    this.collectedArtefactsCounter.increment();
  }

  @Override
  public void increaseAttackActionCounter() {
    this.attackActionCounter.increment();
  }

  @Override
  public void increaseMoveActionCounter() {
    this.moveActionCounter.increment();
  }

  @Override
  public int getKilledEnemies() {
    return this.killedEnemiesCounter.getCountValue();
  }

  @Override
  public int getCompletedRooms() {
    return this.completedRoomsCounter.getCountValue();
  }

  @Override
  public int getCollectedArtefacts() {
    return this.collectedArtefactsCounter.getCountValue();
  }

  @Override
  public int getAttackActionCounter() {
    return this.attackActionCounter.getCountValue();
  }

  @Override
  public int getMoveActionCounter() {
    return this.moveActionCounter.getCountValue();

  }

  @Override
  public String toString() {
    return "\n\n Killed enemies: " + this.getKilledEnemies() + "\n Completed rooms: " + this.getCompletedRooms()
        + "\n Collected artefacts: " + this.getCollectedArtefacts() + "\n\n Attacks performed: "
        + this.getAttackActionCounter() + "\n Movements performed: " + this.getMoveActionCounter() + "\n";
  }
}
