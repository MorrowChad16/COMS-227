
package hw4;

import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;
//import examples.SampleShape;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 */
public class BasicGenerator implements Generator
{
	/**
	   * creates the new shape after the previous
	   * cell has reached a static state
	   * the position is different for every shape
	   * the shape has a 1/6 probability
	   * the magic state has a 1/5 probability
	   * @return
	   * 	New, Random Shape
	   */
  @Override
  public Shape getNext(int width)
  {
	int mid = width / 2;
	boolean isMagic = false;
	
	Random magic = new Random();
	int k = magic.nextInt(5);
	if(k == 1) {
		isMagic = true;
	}
	
	Random rand = new Random();
	int n = rand.nextInt(6);
	if(n == 0) {
		return new LShape(new Position(-1, mid+1), isMagic);
	}
	else if(n == 1) {
		return new JShape(new Position(-1, mid), isMagic);
	}
	else if(n == 2) {
		return new IShape(new Position(-2, mid), isMagic);
	}
	else if(n == 3) {
		return new OShape(new Position(-1, mid), isMagic);
	}
	else if(n == 4) {
		return new TShape(new Position(0, mid), isMagic);
	}
	else {
		return new SZShape(new Position(-1, mid), isMagic);
	}
	    
  }
}

