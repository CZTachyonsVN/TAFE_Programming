package Archive;

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
    
// Source:https://www.geeksforgeeks.org/insertion-sort-algorithm/
    public static CD[] InsertSort(CD[] input)
    {

        //TODO: Implement InsertSort
        return input;
    }
    
    public static void Swap(CD[] array, int a, int b){
        CD temp = new CD(array[a]);
        array[a] = array[b];
        array[b] = temp;
    }
}

