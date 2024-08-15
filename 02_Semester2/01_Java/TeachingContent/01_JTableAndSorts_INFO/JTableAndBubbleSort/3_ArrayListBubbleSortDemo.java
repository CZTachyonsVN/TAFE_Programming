
//Source:  http://java-samples.com/showtutorial.php?tutorialid=234
//   and:  http://www.dreamincode.net/forums/topic/273324-bubble-sort-arrayliststring/

import java.util.*;

public class ArrayListBubbleSortDemo 
{
    
    public static void main(String args[]) 
    {
        // create an array list
        ArrayList<Object[]> al = new ArrayList();

        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add(new Object[] {"Yes","No"});
        al.add(new Object[] {"Hi","there"});
        al.add(new Object[] {"True","False"});
        al.add(new Object[] {"Cat","Mouse"});
        System.out.println("Size of al after additions: " + al.size());

        // display the array list
        System.out.println("Contents of al: " + al);
        // Remove elements from the array list
        //al.remove("F");
        //al.remove(2);
        //System.out.println("Size of al after deletions: " + al.size());
        //System.out.println("Contents of al: " + al);
        
        for (int m = 0; m < al.size(); m++)
        {
            System.out.println("Item " + m + ".1: " + al.get(m)[0] + "     Item " + m + ".2: " + al.get(m)[1]);
        }

        System.out.println();
        bubbleSort(al);
    }
   
    public static void bubbleSort(ArrayList<Object[]> arr) 
    {
        
        for(int j=0; j<arr.size(); j++) 
        {  
            for(int i=j+1; i<arr.size(); i++)
            {  
                if((arr.get(i)[0]).toString().compareToIgnoreCase(arr.get(j)[0].toString())<0)
                {  
                   Object[] words = arr.get(j); 
                   arr.set(j, arr.get(i));
                   arr.set(i, words);
                }  
            }  
            System.out.println(arr.get(j)[0] + " - " + arr.get(j)[1]);  
        }  
    }  
}
   
