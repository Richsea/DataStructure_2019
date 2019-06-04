public class HeapSort {


    void heapSort(int[] a)
    {
        for(int n = a.length-1; n > 0; n--)
        {
            buildHeap(a, 0, n);

            int temp = a[0];
            a[0] = a[n];
            a[n] = temp;

            heapify(a, 0, n);
        }
    }

    void buildHeap(int[] a, int i, int n) {
        if (i >= n / 2) return;

        buildHeap(a, 2*i+1, n);
        buildHeap(a, 2*i+2, n);
        heapify(a, i, n);
    }

    void heapify(int[] a, int i, int n)
    {
        int ai = a[i];

        while(i < n/2)
        {
            int j = 2*i + 1;

            if(j+1 < n && a[j+1] > a[j])
                j++;
            if(a[j] <= ai) break;

            a[i] = a[j];
            i=j;
        }
        a[i] = ai;
    }

    public void print(int[] array)
    {
        System.out.println("<Heap Sort>");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(" -> ");
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}
