package utilis;

public class PosInGrid {

	private PosInGrid() {
	};

	/**
	 * 
	 * @param pos  represents the position to check (coordinate in 0 based sistem)
	 * @param size represents the grid size. First coordinate determinates the
	 *             horizontal number of cells (1 based) and second one the vertical
	 *             number of cells.
	 * @return true if the position is in the grid, false if it isn't
	 */
	public static final boolean checkPosInGrid(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		if (pos.getX() < 0 || pos.getY() < 0 || pos.getX() >= size.getX() || pos.getY() >= size.getY()) {
			return false;
		}
		return true;
	}
}
