package examples;
import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
import api.Block;

/**
 * Partial implementation of the Shape interface for experimentation.
 */
public class SampleShape implements Shape
{
  private Position position;
  private Cell[] cells;
  
  public SampleShape(Position givenPosition, boolean magic)
  {
    position = givenPosition;
    cells = new Cell[4];
    magic = true;
    cells[0] = new Cell(new Block(Color.RED, magic), givenPosition);
    
    // another cell just below the first one
    Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
    cells[1] = new Cell(new Block(Color.RED, false), position1);
    // another cell just below the first one
    Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() + 1);
    cells[2] = new Cell(new Block(Color.RED, false), position2);
    // another cell just below the first one
    Position position3 = new Position(givenPosition.row() + 2, givenPosition.col()+ 1);
    cells[3] = new Cell(new Block(Color.RED, false), position3);
  }
  
  @Override
  public Cell[] getCells()
  {
    Cell[] copy = new Cell[cells.length];
    for(int i = 0; i < cells.length; i++) {
    	copy[i] = new Cell(cells[i]);
    }
    return copy;
  }

  @Override
  public void shiftDown()
  {
      position.setRow(position.row() + 1);
      for(int i = 0; i < cells.length; i++) {
    	  cells[i].setRow(cells[i].getRow() + 1);
      }
  }

  @Override
  public void shiftLeft()
  {
	  position.setRow(position.row() + 1);
      for(int i = 0; i < cells.length; i++) {
    	  cells[i].setCol(cells[i].getCol() - 1);
      }
    
  }

  @Override
  public void shiftRight()
  {
	  position.setRow(position.row() + 1);
	  for(int i = 0; i < cells.length; i++) {
		  cells[i].setCol(cells[i].getCol() + 1);
	  }
  }

  @Override
  public void transform()
  {
	     
  }

  @Override
  public void cycle()
  { 
	 Block temp = cells[cells.length-1].getBlock();
	 for(int i = cells.length-1; i > 0; i--) {
			 cells[i].setBlock(cells[i-1].getBlock());
	 }
	 cells[0].setBlock(temp);
  }

  @Override
  public Shape clone()
  {
    try
    {
      // call the Object clone() method to create a shallow copy
      SampleShape s = (SampleShape) super.clone();

      // then make it into a deep copy
      s.position = new Position(position);
      s.cells = new Cell[cells.length];
      for(int i = 0; i < cells.length; i++) {
    	  s.cells[i] = new Cell(cells[i]);
      }
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }    
  }
}
