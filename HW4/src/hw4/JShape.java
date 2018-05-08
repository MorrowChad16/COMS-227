package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * creates the J shape
 * 
 * @return the SHAPE J
 */
public class JShape extends AbstractShape {
	private Cell[] cell = new Cell[4];

	public JShape(Position position, boolean magic) {
		super(position);
		Position position1 = new Position(position.row(), position.col() - 1);
		cell[0] = new Cell(new Block(Color.BLUE, magic), position1);
		Position position2 = new Position(position.row() + 1, position.col() - 1);
		cell[1] = new Cell(new Block(Color.BLUE, false), position2);
		Position position3 = new Position(position.row() + 1, position.col());
		cell[2] = new Cell(new Block(Color.BLUE, false), position3);
		Position position4 = new Position(position.row() + 1, position.col() + 1);
		cell[3] = new Cell(new Block(Color.BLUE, false), position4);
		super.setCells(cell);
	}
}
