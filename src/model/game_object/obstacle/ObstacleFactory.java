package model.game_object.obstacle;

import utilities.Pair;

public interface ObstacleFactory {
  
  Obstacle createRock (Pair <Integer, Integer> pos);
  
  Obstacle createPebble (Pair <Integer, Integer> pos);

}
