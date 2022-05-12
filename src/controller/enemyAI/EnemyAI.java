package controller.enemyAI;

/**
 * 
 * Methods to define enemies behaviors during their turn.
 *
 */
public interface EnemyAI {
	
	/**
	 * 
	 */
	public void move();
	
	/**
	 * 
	 */
    public void attack();
    
    /**
     * 
     */
    public boolean isPlayerInAttackArea();

}
