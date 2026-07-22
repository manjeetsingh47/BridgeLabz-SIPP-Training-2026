package DSA_Basics.gcr_codebase.sorting_Algo.practice_based;

import java.util.*;

public class EmployeeAttendance {

    static int[] topKEmployees(int ids[], int attendance[], int k) {

        int n = ids.length;

        // Sort according to attendance (descending)
        // If attendance is same -> smaller ID first

        for(int i=0;i<n-1;i++) {

            int best=i;

            for(int j=i+1;j<n;j++) {

                if(attendance[j]>attendance[best] ||
                   (attendance[j]==attendance[best] && ids[j]<ids[best])) {

                    best=j;
                }
            }

            int temp=attendance[i];
            attendance[i]=attendance[best];
            attendance[best]=temp;

            temp=ids[i];
            ids[i]=ids[best];
            ids[best]=temp;
        }

        int ans[]=new int[k];

        for(int i=0;i<k;i++)
            ans[i]=ids[i];

        return ans;
    }

    public static void main(String args[]) {

        int ids[]={101,102,103,104,105};
        int attendance[]={92,85,98,92,80};
        int k=3;

        int result[]=topKEmployees(ids,attendance,k);

        System.out.println(Arrays.toString(result));
    }
}