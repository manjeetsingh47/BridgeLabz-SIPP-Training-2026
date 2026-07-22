package DSA_Basics.gcr_codebase.Binary_search;



public class SearchRotatedArray {

    static int search(int arr[], int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[low] <= arr[mid]) {

                if (target >= arr[low] && target < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;

            } else {

                if (target > arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {

        int arr[] = {6,7,8,1,2,3,4,5};

        System.out.println(search(arr,3));
    }
}