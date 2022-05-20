package logics.game_statistics;

import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private CounterImpl killedEnemies;
	private CounterImpl passedRooms;
	private CounterImpl collectedArtefacts;

	@Override
	public void increaseKilledEnemies() {
		this.killedEnemies.increment();
	}

	@Override
	public void increasePassedRooms() {
		this.passedRooms.increment();
	}
	
	@Override
	public void increaseCollectedArtefacts() {
		this.passedRooms.increment();
	}

	@Override
	public int getKilledEnemies() {
		return this.killedEnemies.getCountValue();
	}

	@Override
	public int getPassedRoom() {
		return this.passedRooms.getCountValue();
	}
	
	@Override
	public int getCollectedArtefacts() {
		return this.collectedArtefacts.getCountValue();
	}
}
