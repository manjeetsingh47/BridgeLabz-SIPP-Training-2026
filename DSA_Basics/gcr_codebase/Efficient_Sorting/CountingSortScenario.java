package DSA_Basics.gcr_codebase.Efficient_Sorting;

import java.util.*;

public class CountingSortScenario {

    static void countingSort(int arr[]){

        int max=20;

        int count[]=new int[max+1];

        for(int x:arr)
            count[x]++;

        int index=0;

        for(int i=1;i<=max;i++){

            while(count[i]>0){

                arr[index++]=i;
                count[i]--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]){

        int arr[]={5,3,10,1,20,5,3,2};

        countingSort(arr);
    }
}
