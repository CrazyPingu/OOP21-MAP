package logics.game_statistics;

import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private CounterImpl killedEnemiesCounter;
	private CounterImpl passedRoomsCounter;
	private CounterImpl collectedArtefactsCounter;

	@Override
	public void increaseKilledEnemies() {
		this.killedEnemiesCounter.increment();
	}

	@Override
	public void increasePassedRooms() {
		this.passedRoomsCounter.increment();
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
	public int getPassedRoom() {
		return this.passedRoomsCounter.getCountValue();
	}
	
	@Override
	public int getCollectedArtefacts() {
		return this.collectedArtefactsCounter.getCountValue();
	}
}
