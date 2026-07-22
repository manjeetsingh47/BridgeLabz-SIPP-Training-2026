package DSA_Basics.gcr_codebase.Binary_search;


public class BinarySearchScenario {

    static int binarySearch(int arr[], int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String args[]) {

        int arr[] = {2,5,8,10,15,20,25,30};

        int target = 20;

        System.out.println("Index = " + binarySearch(arr, target));
    }
}
