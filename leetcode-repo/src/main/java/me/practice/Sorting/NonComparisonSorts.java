package me.practice.Sorting;

import java.util.Arrays;

public class NonComparisonSorts {
    
    public static int[] basicCountSort(int[] arr){
        int[] sortedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sortedArr[arr[i]] = arr[i];
        }
        return sortedArr;
    }

    public static int[] extendedCountSort(int[] arr){
        int K = Arrays.stream(arr).max().getAsInt();
        int[] counts = new int[K + 1];
        for (int elem : arr) {
            counts[elem] += 1;
        }
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingIndex = 0;
        for (int i = 0; i < K + 1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int sortedArray[] = new int[arr.length];
        for (int elem : arr) {
            sortedArray[counts[elem]] = elem;
            // since we have placed an item in index counts[elem], we need to
            // increment counts[elem] index by 1 so the next duplicate element
            // is placed in appropriate index
            counts[elem] += 1;
        }

        // common practice to copy over sorted list into original arr
        // it's fine to just return the sortedArray at this point as well
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
        return arr;
    }

    public static int[] radixSort(int[] arr){

        return arr;
    }
}
