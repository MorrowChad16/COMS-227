package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * creates the T shape
 * 
 * @return the SHAPE T
 */
public class TShape extends AbstractShape {

	private Cell[] cell = new Cell[4];

	public TShape(Position position, boolean magic) {
		super(position);
		Position position1 = new Position(position.row() - 1, position.col());
		cell[0] = new Cell(new Block(Color.MAGENTA, magic), position1);
		Position position2 = new Position(position.row(), position.col() - 1);
		cell[1] = new Cell(new Block(Color.MAGENTA, false), position2);
		Position position3 = new Position(position.row(), position.col());
		cell[2] = new Cell(new Block(Color.MAGENTA, false), position3);
		Position position4 = new Position(position.row(), position.col() + 1);
		cell[3] = new Cell(new Block(Color.MAGENTA, false), position4);
		super.setCells(cell);
	}
}
