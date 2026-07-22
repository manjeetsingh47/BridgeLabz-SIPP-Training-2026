package DSA_Basics.gcr_codebase.sorting_Algo.scenario_based;

import java.util.*;

public class BubbleSortScenario {

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        int swaps = 0;
        boolean sorted = true;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                    sorted = false;
                }
            }

            if (!swapped)
                break;
        }

        System.out.println("Sorted Array : " + Arrays.toString(arr));
        System.out.println("Total Swaps : " + swaps);

        if (sorted)
            System.out.println("Already Sorted (Best Case)");
        else
            System.out.println("Array was not sorted");
    }

    public static void main(String[] args) {

        int arr[] = {64, 25, 12, 22, 11};

        bubbleSort(arr);
    }
}