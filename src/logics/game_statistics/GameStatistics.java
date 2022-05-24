package logics.game_statistics;

/**
 * 
 * Contains game's statistics.
 *
 */
public interface GameStatistics {
    /**
     * Increase killed enemies counter.
     */
    void increaseKilledEnemies();

    /**
     * Increase passed rooms counter.
     */
    void increaseCompletedRooms();

    /**
     * Increase collected artefacts counter.
     */
    void increaseCollectedArtefacts();

    /**
     * Increase attack action counter.
     */
    void increaseAttackActionCounter();

    /**
     * Increase move action counter.
     */
    void increaseMoveActionCounter();

    /**
     * @return killed enemies counter.
     */
    int getKilledEnemies();

    /**
     * @return passed rooms counter.
     */
    int getCompletedRooms();

    /**
     * @return collected artefacts counter.
     */
    int getCollectedArtefacts();

    /**
     * @return attack action counter.
     */
    int getAttackActionCounter();

    /**
     * @return move action counter.
     */
    int getMoveActionCounter();

    /**
     * @return a string with all fields
     */
    String toString();
}
