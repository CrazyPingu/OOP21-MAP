package model.game_object.obstacle;

import utilities.Pair;
import utilities.texture.EntityTexture;

public class ObstacleFactoryImpl implements ObstacleFactory{

  public Obstacle createObstacle(final Pair<Integer, Integer> pos) {
    return new Obstacle (pos, "rock",EntityTexture.OBSTACLE);
  }

}
