package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * creates the SZ shape in the orginal state of GREEN
 * 
 * @return the SHAPE SZ
 */
public class SZShape extends AbstractShape {
	private Position position;
	private Cell[] cell = new Cell[4];
	private boolean red = false;

	public SZShape(Position position, boolean magic) {
		super(position);
		this.position = position;
		Position position1 = new Position(position.row(), position.col());
		cell[0] = new Cell(new Block(Color.GREEN, magic), position1);
		Position position2 = new Position(position.row() + 1, position.col());
		cell[1] = new Cell(new Block(Color.GREEN, false), position2);
		Position position3 = new Position(position.row() + 1, position.col() + 1);
		cell[2] = new Cell(new Block(Color.GREEN, false), position3);
		Position position4 = new Position(position.row() + 2, position.col() + 1);
		cell[3] = new Cell(new Block(Color.GREEN, false), position4);
		super.setCells(cell);
	}

	/**
	 * Overrides the basic transform method checks to see if the cell is magic and
	 * sets variable to true if any are. This transform flips the shape over the
	 * y-axis and changes the color to either GREEN or RED
	 * 
	 * @return the transformed shape with the new color
	 */
	@Override
	public void transform() {
		if (!red) {
			cell[0].setCol(cell[0].getCol() + 1);
			cell[1].setCol(cell[1].getCol() + 1);
			cell[2].setCol(cell[2].getCol() - 1);
			cell[3].setCol(cell[3].getCol() - 1);
			for (int i = 0; i < cell.length; i++) {
				Block temp = cell[i].getBlock();
				cell[i].setBlock(new Block(Color.RED, temp.isMagic()));
			}
			red = true;
		} else {
			cell[0].setCol(cell[0].getCol() - 1);
			cell[1].setCol(cell[1].getCol() - 1);
			cell[2].setCol(cell[2].getCol() + 1);
			cell[3].setCol(cell[3].getCol() + 1);
			for (int i = 0; i < cell.length; i++) {
				Block temp = cell[i].getBlock();
				cell[i].setBlock(new Block(Color.GREEN, temp.isMagic()));
			}
			red = false;
		}
	}

	@Override
	public Shape clone() {
		SZShape s = (SZShape) super.clone();
		// then make it into a deep copy
		s.position = new Position(position);
		s.cell = new Cell[cell.length];
		for (int i = 0; i < cell.length; i++) {
			s.cell[i] = new Cell(cell[i]);
		}
		return s;
	}
}
