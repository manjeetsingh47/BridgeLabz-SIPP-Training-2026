package DSA_Basics.gcr_codebase.Efficient_Sorting;

import java.util.*;

public class PatientIDs {

    static void merge(int arr[],int l,int m,int r){

        int temp[]=new int[r-l+1];

        int i=l;
        int j=m+1;
        int k=0;

        while(i<=m && j<=r){

            if(arr[i]<=arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }

        while(i<=m)
            temp[k++]=arr[i++];

        while(j<=r)
            temp[k++]=arr[j++];

        for(int x=0;x<temp.length;x++)
            arr[l+x]=temp[x];
    }

    static void mergeSort(int arr[],int l,int r){

        if(l>=r) return;

        int m=(l+r)/2;

        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);

        merge(arr,l,m,r);
    }

    public static void main(String args[]){

        int id[]={105,101,108,102,104};

        mergeSort(id,0,id.length-1);

        System.out.println(Arrays.toString(id));
    }
}
