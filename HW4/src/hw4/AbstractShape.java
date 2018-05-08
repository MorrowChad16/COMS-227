
package hw4;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape {
	private Cell[] cell;
	private Position position;

	protected AbstractShape(Position a) {
		position = a;
	}

	/**
	 * gets cell locations.
	 * 
	 * @return array of locations
	 */
	@Override
	public Cell[] getCells() {
		Cell[] copy = new Cell[cell.length];
		for (int i = 0; i < cell.length; i++) {
			copy[i] = new Cell(cell[i]);
		}
		return copy;
	}

	/**
	 * setter method for the position sets the position created by the generator to
	 * be used by the shapes
	 */
	protected void setGivenPosition(Position position) {
		this.position = position;
	}

	/**
	 * setter method for the cell sets the cell to be used by the shapes
	 */
	protected void setCells(Cell[] cell) {
		this.cell = cell;
	}

	/**
	 * reduces code for the shape classes by using this basic template
	 */
	protected AbstractShape(Position position, boolean magic) {
		setGivenPosition(position);
		setCells(new Cell[4]);
	}

	/**
	 * creates a deep copy of the the cells that is essential for many other methods
	 * if the Exception is found it catches it and returns null.
	 * 
	 * @return positions of cell
	 */
	@Override
	public Shape clone() {
		try {
			AbstractShape s = (AbstractShape) super.clone();
			// then make it into a deep copy
			s.position = new Position(position);
			s.cell = new Cell[cell.length];
			for (int i = 0; i < cell.length; i++) {
				s.cell[i] = new Cell(cell[i]);
			}
			return s;
		} catch (CloneNotSupportedException e) {
			// can't happen
			return null;
		}
	}

	/**
	 * shifts the shape to the left after each call
	 */
	@Override
	public void shiftLeft() {
		position.setRow(position.col() - 1);
		for (int i = 0; i < cell.length; i++) {
			cell[i].setCol(cell[i].getCol() - 1);
		}
	}

	/**
	 * shifts the shape to the right after each call
	 */
	@Override
	public void shiftRight() {
		position.setRow(position.col() + 1);
		for (int i = 0; i < cell.length; i++) {
			cell[i].setCol(cell[i].getCol() + 1);
		}
	}

	/**
	 * shifts the shape to the down after each call
	 */
	@Override
	public void shiftDown() {
		position.setRow(position.row() + 1);
		for (int i = 0; i < cell.length; i++) {
			cell[i].setRow(cell[i].getRow() + 1);
		}
	}

	/**
	 * rotates the shape CounterClockWise
	 */
	@Override
	public void transform() {
		int tempRow = 0;
		int tempCol = 0;
		for (int i = 0; i < cell.length; i++) {
			tempRow = ((cell[i].getRow() - position.row()) + position.col());
			tempCol = (-(cell[i].getCol() - position.col()) + position.row());
			cell[i].setCol(tempRow);
			cell[i].setRow(tempCol);
		}
	}

	/**
	 * shifts the "magic" cell one position
	 */
	@Override
	public void cycle() {
		Block temp = cell[cell.length - 1].getBlock();
		for (int i = cell.length - 1; i > 0; i--) {
			cell[i].setBlock(cell[i - 1].getBlock());
		}
		cell[0].setBlock(temp);
	}
}
