package DSA_Basics.gcr_codebase.Binary_search;


public class FirstLastOccurrence {

    static int first(int arr[], int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }

    static int last(int arr[], int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }

    public static void main(String args[]) {

        int arr[] = {2,4,4,4,5,6,7};

        System.out.println(first(arr,4));
        System.out.println(last(arr,4));
    }
}
