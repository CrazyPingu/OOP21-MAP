package logics.game_statistics;

import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private CounterImpl killedEnemies;
	private CounterImpl passedRooms;
	private CounterImpl collectedArtefacts;

	@Override
	public void increaseKilledEnemies() {
		killedEnemies.increment();
	}

	@Override
	public void increasePassedRooms() {
		passedRooms.increment();
	}
	
	@Override
	public void increaseCollectedArtefacts() {
		passedRooms.increment();
	}

	@Override
	public CounterImpl getKilledEnemies() {
		return killedEnemies;
	}

	@Override
	public CounterImpl getPassedRoom() {
		return passedRooms;
	}
	
	@Override
	public CounterImpl getCollectedArtefacts() {
		return collectedArtefacts;
	}
}
