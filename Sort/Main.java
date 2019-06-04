public class Main {
    public static void main(String[] args)
    {
        int[] array1 = new int[]{21, 10, 12, 20, 25, 13, 15, 22};
        int[] array2 = new int[]{21, 10, 12, 20, 25, 13, 15, 22};
        int[] array3 = new int[]{21, 10, 12, 20, 25, 13, 15, 22};

        HeapSort heapSort = new HeapSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        heapSort.buildHeap(array1, 0, array1.length);
        array2 = mergeSort.mergeSort(array2);
        quickSort.QuickSort(array3, 0, array3.length);


        heapSort.print(array1);
        mergeSort.print(array2);
        quickSort.print(array3);



    }
}
