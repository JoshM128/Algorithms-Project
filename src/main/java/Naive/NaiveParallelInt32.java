package Naive;


public class NaiveParallelInt32 {


    // This puts the sorted array into aux
    public static void runNaiveParallelSort(int[] arr){
        int[] aux = new int[arr.length];
        int mid = 0 + (arr.length - 0) / 2;
        naiveParallelSort(arr,aux, mid);
    }


    public static void naiveParallelSort(int[] arr, int[] aux, int mid){
        Thread firstPartition = new Thread(() -> mergeSort(arr, aux, 0, mid));
        firstPartition.start();
        Thread secondPartition = new Thread(() -> mergeSort(arr, aux, mid + 1, arr.length - 1));
        secondPartition.start();

        // Better Logging here
        try{
            firstPartition.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        // Better Logging here
        try{
            secondPartition.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        mergeHalves(arr, aux, 0, mid, arr.length - 1);

    }

    // Inclusive on the mid for first half - [ Pass the Midpoint ]
    // Inclusive on the right for the second half - [ Pass Partition.len - 1 ]
    public static void mergeHalves(int[] arr, int[] aux, int left, int mid, int right){
        int i = left, j = mid + 1, k = left;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
            }
        }

        while(i <= mid){
            aux[k++] = arr[i++];
        }

        while(j <= right){
            aux[k++] = arr[j++];
        }

    }

    public static void mergeSort(int[] arr, int[] aux, int left, int right) {
        if (right <= left)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);

    }

    public static void merge(int[] arr, int[] aux, int l, int m, int r) {
        for (int k = l; k <= r; k++) {
            aux[k] = arr[k];
        }
        int i = l, j = m+1;
        for (int k = l; k <= r; k++) {
            if      (i > m)
                arr[k] = aux[j++];
            else if (j > r)
                arr[k] = aux[i++];
            else if (aux[j] < aux[i])
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }

    }



}
