
package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Block;
//import api.GameStatus;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame {
	private int score;
	private boolean gravityMagic;
	private int numMagic;

	/**
	 * Constructs a game with the given width (columns) and height (rows). This game
	 * will use a new instance of BasicGenerator to generate new shapes.
	 * 
	 * @param width
	 *            width of the game grid (number of columns)
	 * @param height
	 *            height of the game grid (number of rows)
	 */
	public MagicTetris(int width, int height) {
		super(width, height, new BasicGenerator());
		score = 0;
		gravityMagic = false;
	}

	/**
	 * runs the game by noticing whether the gravity function is being implemented.
	 * This is tracked by the numMagic and gravityMagic variables the blocks will
	 * hang of edges until the gravity state is initiated the gravity state is in
	 * effect when there are 3 magic blocks in a single complete row
	 * 
	 * @return position locations to "collapse"
	 */
	@Override
	public List<Position> determinePositionsToCollapse() {
		numMagic = 0;
		List<Position> collapse = new ArrayList<>();
		List<Block> keep = new ArrayList<>();

		if (!gravityMagic) {
			for (int i = 0; i < super.getHeight(); i++) {
				for (int j = 0; j < super.getWidth(); j++) {
					keep.add(super.getBlock(i, j));
					if (super.getBlock(i, j) != null && super.getBlock(i, j).isMagic()) {
						numMagic++;
					}
				}
				if (keep.contains(null)) {
					numMagic = 0;
					keep.clear();
				} else {
					score += Math.pow(2, numMagic);
					for (int n = 0; n < keep.size(); n++) {
						collapse.add(new Position(i, n));
					}
				}
				if (numMagic >= 3) {
					gravityMagic = true;
				}
			}
			keep.clear();
			return collapse;
		}

		else {
			for (int i = 1; i < super.getHeight(); i++) {
				for (int j = 0; j < super.getWidth(); j++) {
					if (super.getBlock(i, j) == null && super.getBlock(i - 1, j) != null) {
						collapse.add(new Position(i, j));
					}
					for (int k = 0; k < collapse.size(); k++) {
						if (super.getBlock(i, j) == null && collapse.get(k).row() + 1 == i
								&& collapse.get(k).col() == j) {
							collapse.add(new Position(i, j));
						}
					}
				}
			}
			gravityMagic = false;
		}
		return collapse;
	}

	/**
	 * score is 2^numMagic blocks
	 * 
	 * @return the score
	 */
	@Override
	public int determineScore() {
		return score;
	}
}
