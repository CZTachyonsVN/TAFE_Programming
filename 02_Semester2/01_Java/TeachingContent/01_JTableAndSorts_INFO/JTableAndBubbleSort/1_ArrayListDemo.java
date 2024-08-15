
//Source:  http://java-samples.com/showtutorial.php?tutorialid=234

import java.util.*;

public class ArrayListDemo {
    
   public static void main(String args[]) {
      // create an array list
      ArrayList<Object[]> al = new ArrayList();
      
      System.out.println("Initial size of al: " + al.size());

      // add elements to the array list
      al.add(new Object[] {"Yes","No"});
      al.add(new Object[] {"Hi","there"});
      al.add(new Object[] {"True","False"});
      al.add(new Object[] {"Yes","No"});
      System.out.println("Size of al after additions: " + al.size());

      // display the array list
      System.out.println("Contents of al: " + al);
      // Remove elements from the array list
      al.remove("F");
      al.remove(2);
      System.out.println("Size of al after deletions: " + al.size());
      System.out.println("Contents of al: " + al);

      System.out.println("Item 1.1: " + al.get(0)[0]);
      System.out.println("Item 1.2: " + al.get(0)[1]);
      System.out.println("Item 2.1: " + al.get(1)[0]);
      System.out.println("Item 2.2: " + al.get(1)[1]);
   }
}
 
/**************************************************************

al.add(new Object[] {"Data","Data","...", etc...}); 
al.get(3)[2];
al.set(i, anObjectArray);
al.set(j, al.get(i));
al.remove(2);
al.size();

**************************************************************/
