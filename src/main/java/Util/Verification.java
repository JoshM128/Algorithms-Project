package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verification {

    public static boolean verifySortedInt8(byte[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean verifySortedInt32(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean verifySortedInt64(long[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean verifySortedFloat32(float[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static SortDebug<Integer> debugSortedInt8(byte[] arr){
        Integer[] boxedInput = boxPrimitiveArrayInt8(arr);

        SortDebug<Integer> debugRecord;
        List<Integer> indexes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for(int i = 0; i < boxedInput.length - 1; i++){
            if(boxedInput[i] > boxedInput[i+1]){
                indexes.add(i);
                values.add(boxedInput[i]);
            }
        }
        debugRecord = new SortDebug<>(boxedInput,indexes,values);
        return debugRecord;
    }

    public static SortDebug<Integer> debugSortedInt32(int[] arr){
        Integer[] boxedInput = boxPrimitiveArrayInt32(arr);

        SortDebug<Integer> debugRecord;
        List<Integer> indexes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for(int i = 0; i < boxedInput.length - 1; i++){
            if(boxedInput[i] > boxedInput[i+1]){
                indexes.add(i);
                values.add(boxedInput[i]);
            }
        }
        debugRecord = new SortDebug<>(boxedInput,indexes,values);
        return debugRecord;
    }

    public static SortDebug<Long> debugSortedInt64(long[] arr){
        Long[] boxedInput = boxPrimitiveArrayInt64(arr);

        SortDebug<Long> debugRecord;
        List<Integer> indexes = new ArrayList<>();
        List<Long> values = new ArrayList<>();

        for(int i = 0; i < boxedInput.length - 1; i++){
            if(boxedInput[i] > boxedInput[i+1]){
                indexes.add(i);
                values.add(boxedInput[i]);
            }
        }
        debugRecord = new SortDebug<>(boxedInput,indexes,values);
        return debugRecord;
    }

    public static SortDebug<Double> debugSortedFloat32(float[] arr){
        Double[] boxedInput = boxPrimitiveArrayFloat32(arr);

        SortDebug<Double> debugRecord;
        List<Integer> indexes = new ArrayList<>();
        List<Double> values = new ArrayList<>();

        for(int i = 0; i < boxedInput.length - 1; i++){
            if(boxedInput[i] > boxedInput[i+1]){
                indexes.add(i);
                values.add(boxedInput[i]);
            }
        }
        debugRecord = new SortDebug<>(boxedInput,indexes,values);
        return debugRecord;
    }

    public record SortDebug<T>(T[] source, List<Integer> incorrectIndex, List<T> indexValue){

    }

    private static Integer[] boxPrimitiveArrayInt8(byte[] arr){
        int[] castedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            castedArray[i] = arr[i];

        return Arrays.stream(castedArray)
                .boxed()
                .toArray(Integer[]::new);
    }


    private static Integer[] boxPrimitiveArrayInt32(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);
    }

    private static Long[] boxPrimitiveArrayInt64(long[] arr){
        return Arrays.stream(arr)
                .boxed()
                .toArray(Long[]::new);
    }

    private static Double[] boxPrimitiveArrayFloat32(float[] arr){
        double[] castedArray = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
            castedArray[i] = arr[i];
        return Arrays.stream(castedArray)
                .boxed()
                .toArray(Double[]::new);
    }
}
