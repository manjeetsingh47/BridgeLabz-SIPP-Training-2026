package DSA_Basics.gcr_codebase.sorting_Algo.scenario_based;

import java.util.*;

public class InsertionSortScenario {

    static void insertionSort(int arr[]) {

        int shifts = 0;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                shifts++;
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Sorted Array : " + Arrays.toString(arr));
        System.out.println("Total Shifts : " + shifts);
    }

    public static void main(String args[]) {

        int arr[] = {64, 25, 12, 22, 11};

        insertionSort(arr);
    }
}
