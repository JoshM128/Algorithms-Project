package Baseline;

/**
 *
 */
public class BaselineImpl {

    /***********************
     * Integer 8
     ***********************/

    public static void mergeSortInt8(byte[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortInt8(arr, left, middle);

            mergeSortInt8(arr, middle + 1, right);

            mergeInt8(arr, left, middle, right);
        }
    }

    private static void mergeInt8(byte[] arr, int l, int m, int r) {
        int leftSize = m + 1 - l;
        int rightSize = r - m;
        byte[] left = new byte[leftSize];
        byte[] right = new byte[rightSize];

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

    /***********************
     * Integer 32
     ***********************/


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
    /***********************
     * Integer 64
     ***********************/

    public static void mergeSortInt64(long[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortInt64(arr, left, middle);

            mergeSortInt64(arr, middle + 1, right);

            mergeInt64(arr, left, middle, right);
        }
    }

    private static void mergeInt64(long[] arr, int l, int m, int r) {
        int leftSize = m + 1 - l;
        int rightSize = r - m;
        long[] left = new long[leftSize];
        long[] right = new long[rightSize];

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

    /***********************
     * Float 32
     ***********************/

    public static void mergeSortFloat32(float[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSortFloat32(arr, left, middle);

            mergeSortFloat32(arr, middle + 1, right);

            mergeFloat32(arr, left, middle, right);
        }
    }

    private static void mergeFloat32(float[] arr, int l, int m, int r) {
        int leftSize = m + 1 - l;
        int rightSize = r - m;
        float[] left = new float[leftSize];
        float[] right = new float[rightSize];

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
