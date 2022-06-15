package model.game_object.obstacle;

import utilities.Pair;

public interface ObstacleFactory {
  
  /**
   * 
   * @param pos the position of the ostacle in the game field
   * @return a rock obstacle
   */
  Obstacle createRock (Pair <Integer, Integer> pos);
  
  /**
   * 
   * @param pos the position of the obstacle in the game field
   * @return a pebble obstacle
   */
  Obstacle createPebble (Pair <Integer, Integer> pos);

}
