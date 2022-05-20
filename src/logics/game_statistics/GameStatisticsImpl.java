package logics.game_statistics;

import utilities.counter.Counter;
import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private Counter killedEnemiesCounter;
	private Counter completedRoomsCounter;
	private Counter collectedArtefactsCounter;
	private Counter attackActionCounter;
	private Counter moveActionCounter;

	public GameStatisticsImpl() {
		this.killedEnemiesCounter = new CounterImpl();
		this.completedRoomsCounter = new CounterImpl();
		this.collectedArtefactsCounter = new CounterImpl();
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
				+ this.getAttackActionCounter() + "\n Movements performed: "
				+ this.getMoveActionCounter() + "\n";
	}
}
