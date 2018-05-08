package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * creates the L shape
 * 
 * @return the SHAPE L
 */
public class LShape extends AbstractShape {
	private Cell[] cell = new Cell[4];

	public LShape(Position position, boolean magic) {
		super(position);
		cell[0] = new Cell(new Block(Color.ORANGE, magic), position);
		Position position1 = new Position(position.row() + 1, position.col() - 2);
		cell[1] = new Cell(new Block(Color.ORANGE, false), position1);
		Position position2 = new Position(position.row() + 1, position.col() - 1);
		cell[2] = new Cell(new Block(Color.ORANGE, false), position2);
		Position position3 = new Position(position.row() + 1, position.col());
		cell[3] = new Cell(new Block(Color.ORANGE, false), position3);
		super.setCells(cell);
	}
}
