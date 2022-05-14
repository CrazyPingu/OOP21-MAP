package controller.enemyAI;

/**
 * 
 * Methods to define enemies behaviors during their turn.
 *
 */
public interface EnemyAI {
	
	/**
	 * enemy automated movement
	 */
	public void move();
	
	/**
	 * enemy automated attack
	 */
    public void attack();
    
    /**
     * checks if player is reachable by the enemy attack
     */
    public boolean isPlayerInAttackArea();

}
