package DSA_Basics.gcr_codebase.sorting_Algo.practice_based;

import java.util.*;

public class EmployeeIDs {

    static void insertionSort(int id[]) {

        for(int i=1;i<id.length;i++) {

            int key=id[i];
            int j=i-1;

            while(j>=0 && id[j]>key) {

                id[j+1]=id[j];
                j--;
            }

            id[j+1]=key;
        }

        System.out.println(Arrays.toString(id));
    }

    public static void main(String args[]) {

        int id[]={108,102,109,101,105};

        insertionSort(id);
    }
}