package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * creates the O shape
 * 
 * @return the SHAPE O
 */
public class OShape extends AbstractShape {

	private Cell[] cell = new Cell[4];

	public OShape(Position position, boolean magic) {
		super(position);
		Position position0 = new Position(position.row(), position.col());
		cell[0] = new Cell(new Block(Color.YELLOW, magic), position0);
		Position position1 = new Position(position.row(), position.col() + 1);
		cell[1] = new Cell(new Block(Color.YELLOW, false), position1);
		Position position2 = new Position(position.row() + 1, position.col());
		cell[2] = new Cell(new Block(Color.YELLOW, false), position2);
		Position position3 = new Position(position.row() + 1, position.col() + 1);
		cell[3] = new Cell(new Block(Color.YELLOW, false), position3);
		super.setCells(cell);
	}

	/**
	 * overrides the basic transform method It changes NOTHING
	 * 
	 * @return the same cell locations
	 */
	@Override
	public void transform() {
	}
}
