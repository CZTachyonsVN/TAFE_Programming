package Archive;

import java.util.Arrays;

public final class Sort
{
// Source:
    public static CD[] QuickSortThree(CD[] input, int low, int high)
    {
        if (low >= 0 && low < high){
            // Pivot value
            CD pivot = input[(low+high)/2];
            // Lesser, equal and greater index
            int lessThan = low;
            int equals = low;
            int greatThan = high;
            
            //Divides array into three partitions
            while (equals <= greatThan){
                // Swap the elements at the equal and lesser indices
                if (new Compare().compare(input[equals].getAuthor(), pivot.getAuthor()) < 0)
                {
                    Swap(input,equals,lessThan);
                    lessThan++;
                    equals++;
                }
                // Swap the elements at the equal and greater indices
                else if (new Compare().compare(input[equals].getAuthor(), pivot.getAuthor()) > 0)
                {
                    Swap(input, equals,greatThan);
                    greatThan--;
                }
                else
                {
                    equals++;
                }
            }
            //Repeat quicksort on the lower partition
            QuickSortThree(input,low,lessThan - 1);
            //Repeat quicksort on the higher partition
            QuickSortThree(input,greatThan + 1, high);
        }
        return input;
    }
// Source:https://www.geeksforgeeks.org/merge-sort/
    public static CD[] MergeSort(CD[] input)
    {
        //TODO: Implement MergeSort
        return input;
    }
    
// Source:
    public static CD[] RadixSort(CD[] archive)
    {
        int[] arr = new int[archive.length];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = archive[i].getBarcode();
        }
        
        int[] sortedBarcodes = new int[arr.length];
        int highest = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] > highest)
            {
                highest = arr[i];
            }
        }
        
        for (int exp = 1; highest/exp > 0; exp *= 10)
        {
            int i;
            int[] count = new int[10];
            Arrays.fill(count, 0);
            
            for (i = 0; i < arr.length; i++)
            {
                count[(arr[i]/ exp) % 10]++;
            }
            
            for (i = 1; i < 10; i++)
            {
                count[i] += count[i - 1];
            }
            
            for (i = arr.length - 1; i >= 0; i--) {
                sortedBarcodes[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
            }
            for (i = 0; i < sortedBarcodes.length; i++)
            {
                arr[i] = sortedBarcodes[i];
            }
        }
        
        CD[] output = new CD[archive.length];
        for (int i = 0; i < archive.length; i++)
        {
            output[i] = new CD(Repository.GetCDByBarcode(sortedBarcodes[i]));
        }
        
        return output;
    }
    
    public static void Swap(CD[] array, int a, int b){
        CD temp = new CD(array[a]);
        array[a] = array[b];
        array[b] = temp;
    }
}

