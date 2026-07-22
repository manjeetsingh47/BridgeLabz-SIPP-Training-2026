package DSA_Basics.gcr_codebase.Binary_search;


public class MinimumRotated {

    static int findMin(int arr[]) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }

        return arr[low];
    }

    public static void main(String args[]) {

        int arr[] = {6,7,8,1,2,3,4};

        System.out.println(findMin(arr));
    }
}