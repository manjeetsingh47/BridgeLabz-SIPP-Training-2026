package DSA_Basics.gcr_codebase.Efficient_Sorting;

import java.util.*;

public class MergeSortScenario {

    static void merge(int arr[], int low, int mid, int high) {

        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[low + x] = temp[x];
    }

    static void mergeSort(int arr[], int low, int high) {

        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void main(String args[]) {

        int arr[] = {38,27,43,3,9,82,10};

        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
