package logics.game_statistics;

import utilities.counter.CounterImpl;

public class GameStatisticsImpl implements GameStatistics {
	private CounterImpl killedEnemies;
	private CounterImpl passedRooms;
	private CounterImpl collectedArtefacts;

	public void increaseKilledEnemies() {
		killedEnemies.increment();
	}

	public void increasePassedRooms() {
		passedRooms.increment();
	}
	
	public void increaseCollectedArtefacts() {
		passedRooms.increment();
	}

	public CounterImpl getKilledEnemies() {
		return killedEnemies;
	}

	public CounterImpl getPassedRoom() {
		return passedRooms;
	}
	
	public CounterImpl getCollectedArtefacts() {
		return collectedArtefacts;
	}
}
