package CompleteParallelization;

import Baseline.BaselineImpl;
import Util.Generator;

public class Driver {



    public static void main(String[] args) {
        // Source Array
        int[] arr = Generator.generateInt32(1_000_000, 10000);

        // Configuration
        int processorCount = Runtime.getRuntime().availableProcessors();
        int mergerThreads = 4;

        int len = arr.length;

        int partSize = len / processorCount;
        int remainder = len % processorCount;


        int lastIndex = 0;
        for(int i = 0; i < processorCount - 1; i++){
            System.out.format("Start Index: %d\t End Index: %d\t Part Size: %d\n", lastIndex, (lastIndex + partSize), partSize);
            lastIndex += partSize;
        }

        System.out.format("Start Index: %d\t End Index: %d\t Part Size: %d\n", lastIndex, (lastIndex + partSize + remainder), (partSize + remainder));


//        int[] a = new int[partSize + remainder];
//
//        System.arraycopy(arr, lastIndex, a, 0, (partSize + remainder));
//
//
//        System.out.println();
//        Thread[] sorters = new Thread[processorCount];
//        for(int i = 0; i < (processorCount - 1); i++) {
//
//            //sorters[i] = new Thread(() -> BaselineImpl.mergeSortInt32())
//        }

    }
}
