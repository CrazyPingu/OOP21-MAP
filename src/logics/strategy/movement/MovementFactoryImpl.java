package logics.strategy.movement;

import java.util.ArrayList;
import java.util.List;

import logics.strategy.Strategy;
import utilis.Pair;
import utilis.PosInGrid;

public class MovementFactoryImpl implements MovementFactory {

	@Override
	public MovementImpl stepMovement(int actioNum) {
		return new MovementImpl(new Strategy() {

			@Override
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				List<Pair<Integer, Integer>> availableCell = new ArrayList<Pair<Integer,Integer>>(); 
				for(int i = pos.getX()-1;  i < pos.getX()+1; i++) { 
					for(int j = pos.getY()-1; j < pos.getY()+1; j++) { 
						Pair<Integer, Integer> cellToAdd = new Pair<>(i, j); 
						if(!pos.equals(cellToAdd) && PosInGrid.checkPosInGrid(cellToAdd, size)) { 
							availableCell.add(cellToAdd); 
						}
					}
				}
				return availableCell;
			}
		}, actioNum);
	}

	@Override
	public MovementImpl jumpMovement(int actioNum) {
		return new MovementImpl(new Strategy() {

			@Override
			public List<Pair<Integer, Integer>> execute(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
				// TODO Auto-generated method stub
				return null;
			}
		}, actioNum);
	}
	

}
