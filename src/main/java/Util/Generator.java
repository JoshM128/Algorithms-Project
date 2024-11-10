package Util;

import java.util.Random;

public class Generator {

    public static byte[] generateInt8(int size, int bound){
        Random random = new Random();
        byte[] arr = new byte[size];
        random.nextBytes(arr);
        return arr;
    }

    public static int[] generateInt32(int size, int bound){
        Random random = new Random();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static long[] generateInt64(int size, int bound){
        Random random = new Random();
        long[] arr = new long[size];

        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static float[] generateFloat32(int size, int bound){
        Random random = new Random();
        float[] arr = new float[size];

        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static double[] generateFloat64(int size, int bound){
        Random random = new Random();
        double[] arr = new double[size];

        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
