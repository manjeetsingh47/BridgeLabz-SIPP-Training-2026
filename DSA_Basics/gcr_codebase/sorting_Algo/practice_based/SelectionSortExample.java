package DSA_Basics.gcr_codebase.sorting_Algo.practice_based;

import java.util.*;

public class SelectionSortExample {

    static void selectionSort(int arr[]) {

        int n=arr.length;

        for(int i=0;i<n-1;i++) {

            int min=i;

            for(int j=i+1;j<n;j++) {

                if(arr[j]<arr[min])
                    min=j;
            }

            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {

        int score[]={56,90,34,78,21};

        selectionSort(score);
    }
}