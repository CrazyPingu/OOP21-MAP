package model.game_object.obstacle;

import utilities.Pair;
import utilities.texture.EntityTexture;

/*
 * 
 * Factory to create a new Obstacle 
 *
 */
public class ObstacleFactoryImpl implements ObstacleFactory{

  public Obstacle createRock(final Pair<Integer, Integer> pos) {
    return new Obstacle (pos, "rock",EntityTexture.ROCK);
  }
  
  public Obstacle createPebble(final Pair<Integer, Integer> pos) {
    return new Obstacle (pos, "pebble", EntityTexture.PEBBLE);
  }

}
