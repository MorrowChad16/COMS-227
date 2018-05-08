
package hw4;

import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
{
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }

  @Override
  public List<Position> determinePositionsToCollapse()
  {
    // TODO
    return null;
  }

  @Override
  protected int determineScore()
  {
    // TODO
    return 0;
  }

}
