package utilis;

public class PosInGrid {

	private PosInGrid() {
	};

	/**
	 * 
	 * @param pos  represent the position to check
	 * @param size represent the grid size
	 * @return true if the position is in the grid, false if it isn't
	 */
	public static final boolean checkPosInGrid(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		return pos.getX() < size.getX() ? (pos.getY() < size.getY()? true: false) : false;
	}
}
