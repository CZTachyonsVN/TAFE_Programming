import Archive.CD;

public final class Sort
{
// Source: https://www.geeksforgeeks.org/insertion-sort-algorithm/
    public static CD[] QuickSortThree(CD[] input, int low, int high)
    {
        if (low >= 0 && low < high){
            CD pivot = input[(low+high)/2];
            int lessThan = low;
            int equals = low;
            int greatThan = high;
            
            while (equals <= greatThan){
                if (new Compare().compare(input[equals].getAuthor(), pivot.getAuthor()) < 0)
                {
                    Swap(input,equals,lessThan);
                    lessThan++;
                    equals++;
                }
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
            
            QuickSortThree(input,low,lessThan - 1);
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

