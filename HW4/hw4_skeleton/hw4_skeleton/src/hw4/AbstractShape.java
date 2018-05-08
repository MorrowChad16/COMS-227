
package hw4;

import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
{
  
  // TODO - add the methods and constructors you want
  // (constructors must be declared protected)
  
  
  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape) super.clone();

      // TODO: make it into a deep copy
      
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
