public class MergeSort {

    int[] mergeSort(int[] divideArray)
    {
        if(divideArray.length == 1) return divideArray;

        int[] array_1 = new int[divideArray.length / 2];
        int[] array_2 = new int[divideArray.length - divideArray.length/2];

        System.arraycopy(divideArray, 0, array_1, 0, array_1.length);
        System.arraycopy(divideArray, array_1.length, array_2, 0, array_2.length);

        array_1 = mergeSort(array_1);
        array_2 = mergeSort(array_2);

        return merge(array_1, array_2);
    }

    private int[] merge(int[] array_1, int[] array_2)
    {
        int[] mergeArray = new int[array_1.length + array_2.length];
        int array_1_loc = 0, array_2_loc = 0, merge_loc = 0;

        while(array_1_loc < array_1.length && array_2_loc < array_2.length)
        {
            if(array_1[array_1_loc] < array_2[array_2_loc])
            {
                mergeArray[merge_loc] = array_1[array_1_loc];
                merge_loc++;
                array_1_loc++;
            }
            else
            {
                mergeArray[merge_loc] = array_2[array_2_loc];
                merge_loc++;
                array_2_loc++;
            }
        }

        while(array_1_loc < array_1.length)
        {
            mergeArray[merge_loc] = array_1[array_1_loc];
            merge_loc++;
            array_1_loc++;
        }

        while(array_2_loc < array_2.length)
        {
            mergeArray[merge_loc] = array_2[array_2_loc];
            merge_loc++;
            array_2_loc++;
        }

        return mergeArray;
    }
    public void print(int[] array)
    {
        System.out.println("<Merge Sort>");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(" -> ");
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}
