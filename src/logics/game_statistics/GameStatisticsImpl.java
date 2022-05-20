package logics.game_statistics;

import utilities.counter.Counter;
import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private Counter killedEnemiesCounter;
	private Counter completedRoomsCounter;
	private Counter collectedArtefactsCounter;

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
	public String toString() {
		return "\n\n Killed enemies: " + this.killedEnemiesCounter.getCountValue() + "\n Completed rooms: "
				+ this.completedRoomsCounter.getCountValue() + "\n Collected artefacts: "
				+ this.collectedArtefactsCounter.getCountValue() + "\n";
	}
}
