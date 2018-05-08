
package lab9;

import java.io.File;
import java.util.ArrayList;

public class FileLister2
{
  public static void main(String[] args)
  {
    // Choose the directory you want to list.
    // If running in Eclipse, "." will just be the current project directory.
    // Use ".." to list the whole workspace directory, or enter a path to
    // some other directory.
    File rootDirectory = new File(".");
    //ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> result = findFiles(rootDirectory);
    System.out.println(result);
  }

  /**
   * Returns a list of files beneath the given file or directory.
   * 
   * @param file
   * @return
   */
  /*
  public static ArrayList<String> findFiles(File file)
  {
    // create an empty array list...
    ArrayList<String> arr = new ArrayList<String>();

    // pass it into the recursive method
    findFiles(file, arr);

    // and return the filled-up ArrayList
    return arr;
  }
  */

  /**
   * Recursive helper method includes an array list as an argument. Filenames
   * are added to the array list as they are found.
   * 
   * @param file
   * @param list
 * @return 
   */
  private static ArrayList<String> findFiles(File file)
  {  
	ArrayList<String> arr = new ArrayList<>();
    if (!file.isDirectory())
    {
      // base case
      arr.add(file.getName());
    }
    else
    {
      //recursively search the sub directory
      //System.out.println("+ " + file.getName());
      //File[] files = file.listFiles();
      for (File f : file.listFiles())
      {
    	  //if(arr){
        arr.addAll(findFiles(f));
    	  //}
      }
    }
    return arr;
  }

}