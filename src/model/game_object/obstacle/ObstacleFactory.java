package model.game_object.obstacle;

import utilities.Pair;

public interface ObstacleFactory {
  
  Obstacle createObstacle (Pair <Integer, Integer> pos);

}
