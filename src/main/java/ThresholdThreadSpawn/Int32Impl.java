package ThresholdThreadSpawn;

public class Int32Impl {

    public static int PARTITION_THRESHOLD = 10_000;

    public static void mergeParallel(int[] arr,  int left, int right){
        // base case
        if (right <= left)
            return;

        // partition with overflow protection
        int mid = left + (right - left) / 2;

        // protect against spawning threads for small partitions
        if( (right - left) < PARTITION_THRESHOLD){
            // Fall Back to non-parallel sort
            mergeSortInt32(arr, left, right);
            return;
        }

        // Spawn thread for left partition sorting
        Thread leftPartition = new Thread(() -> mergeParallel(arr, left, mid));
        leftPartition.start();

        // Recursive call for right partition
        mergeParallel(arr, mid + 1, right);

        //Block until left partition is done
        try {
            leftPartition.join();
        }
        // Need err logging here
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Important to note that the allocation is happening here for the aux array
        int[] aux = new int[right - left + 1];

        // Merge halves into aux array
        mergeHalves(arr, aux, left, mid, right);

        // Copy back sorted values from aux into original array
        System.arraycopy(aux, 0, arr, left, right - left + 1);

    }

    public static void mergeHalves(int[] arr, int[] aux, int left, int mid, int right){
        int i = left, j = mid + 1, k = 0;
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


    public static void mergeSortInt32(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortInt32(arr, left, middle);

            mergeSortInt32(arr, middle + 1, right);

            mergeInt32(arr, left, middle, right);
        }
    }

    private static void mergeInt32(int[] arr, int l, int m, int r) {
        int leftSize = m + 1 - l;
        int rightSize = r - m;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        System.arraycopy(arr, l, left, 0, leftSize);
        System.arraycopy(arr, (m + 1), right, 0, rightSize);

        int i = 0, j = 0, k = l;

        while (i < leftSize || j < rightSize) {
            if (j == rightSize || i < leftSize && left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
    }

}
