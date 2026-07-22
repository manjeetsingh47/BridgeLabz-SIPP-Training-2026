package DSA_Basics.gcr_codebase.sorting_Algo.practice_based;

import java.util.*;

public class StudentMarks {

    public static void bubbleSort(int marks[]) {

        for(int i=0;i<marks.length-1;i++) {

            for(int j=0;j<marks.length-i-1;j++) {

                if(marks[j]>marks[j+1]) {

                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(marks));
    }

    public static void main(String args[]) {

        int marks[]={78,45,90,67,88};

        bubbleSort(marks);
    }
}