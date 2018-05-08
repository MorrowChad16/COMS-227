package lab10;

public class IntListTest {

	   public static void main(String[] args) {
	      
	      IntListSorted list = new IntListSorted();
	      
	      list.add(5);
	      list.add(76);
	      list.add(3);
	      list.add(15);
	      list.add(9);
	      list.add(11);
	      list.add(12);
	      System.out.println(list);
	      System.out.println("Size: " + list.size());
	      System.out.println("Min: " + list.getMinimum());
	      System.out.println("Max: " + list.getMaximum());
	      System.out.println("Median: " + list.getMedian());
	   }
	}