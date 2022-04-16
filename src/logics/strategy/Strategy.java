package logics.strategy;

import java.util.List;

import utilis.Pair;

/**
 * 
 * Interface that defines the method execute for the "Strategy" design pattern.
 * 
 */
public interface Strategy {
	/**
	 * 
	 * @param pos  an absolute position in the map grid
	 * @param size represent the size of the map grid
	 * @return the choosable position calculated by an internal algoritm
	 */
	public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size);
}
