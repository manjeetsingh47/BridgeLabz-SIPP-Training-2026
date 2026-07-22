package DSA_Basics.gcr_codebase.Efficient_Sorting;

import java.util.*;

public class FlightPrices {

    static int partition(int arr[],int low,int high){

        int pivot=arr[high];

        int i=low-1;

        for(int j=low;j<high;j++){

            if(arr[j]<pivot){

                i++;

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    static void quickSort(int arr[],int low,int high){

        if(low<high){

            int p=partition(arr,low,high);

            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    public static void main(String args[]){

        int price[]={4500,2200,3800,1800,5200};

        quickSort(price,0,price.length-1);

        System.out.println(Arrays.toString(price));
    }
}