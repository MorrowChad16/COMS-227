package lab10;

/**
 * Subclass of IntList that guarantees that the elements are always
 * in ascending order.
 */
public class IntListSorted extends IntList
{
  /**
   * Constructs an empty list.
   */
  public IntListSorted()
  {
    super();
  }
  
  /**
   * Adds a new item to this list, inserting it so that
   * the list remains sorted.
   */
  @Override
  public void add(int newItem)
  {
   super.add(newItem);
 
   int temp;
   for (int i = size - 1; i > 0 && list[i - 1] > list[i]; --i) {
       temp = list[i];
       list[i] = list[i - 1];
       list[i - 1] = temp;
   }
  }
  
  /**
   * Inserts a new item in this list, inserting it so that
   * the list remains sorted.  (The given index is ignored.)
   */
  @Override
  public void insert(int index, int newItem)
  {
    this.add(newItem);
  }
  
  public int getMedian() {
	  
	  if(size % 2 == 0) {
		   return list[(size/2) - 1];
		  }
	  return list[(size/2)];
  }
}