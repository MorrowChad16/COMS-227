package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * creates the I shape by creating 3 positions right below each other.
 * 
 * @return the SHAPE I
 */

public class IShape extends AbstractShape {

	private Cell[] cell = new Cell[3];

	public IShape(Position position, boolean magic) {
		super(position);
		Position position0 = new Position(position.row(), position.col());
		cell[0] = new Cell(new Block(Color.CYAN, magic), position0);
		Position position1 = new Position(position.row() + 1, position.col());
		cell[1] = new Cell(new Block(Color.CYAN, false), position1);
		Position position2 = new Position(position.row() + 2, position.col());
		cell[2] = new Cell(new Block(Color.CYAN, false), position2);
		super.setCells(cell);
	}
}
