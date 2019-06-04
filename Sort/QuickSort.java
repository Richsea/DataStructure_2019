public class QuickSort {

    void QuickSort(int[] quickArray, int low, int high)
    {
        if(low < high)
        {
            int pivot_loc = Partition(quickArray, low, high);
            QuickSort(quickArray, low, pivot_loc);
            QuickSort(quickArray, pivot_loc+1, high);
        }
    }

    private int Partition(int[] quickArray, int low, int high)
    {
        int pivot = quickArray[low];
        int leftwall = low;

        for(int i = low+1; i < high; i++)
        {
            if(quickArray[i] < pivot)
            {
                int temp = quickArray[leftwall+1];
                quickArray[leftwall+1] = quickArray[i];
                quickArray[i] = temp;
                leftwall++;
            }
        }
        quickArray[low] = quickArray[leftwall];
        quickArray[leftwall] = pivot;

        return leftwall;
    }
    public void print(int[] array)
    {
        System.out.println("<Quick Sort>");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(" -> ");
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}
