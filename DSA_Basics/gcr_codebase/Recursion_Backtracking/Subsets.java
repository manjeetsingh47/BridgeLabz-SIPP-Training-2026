package DSA_Basics.gcr_codebase.Recursion_Backtracking;

import java.util.*;

public class Subsets {

    // Generate all subsets
    public static List<List<String>> generateSubsets(String[] flags) {

        List<List<String>> result = new ArrayList<>();
        backtrack(flags, 0, new ArrayList<>(), result);
        return result;
    }

    // Backtracking
    public static void backtrack(String[] flags, int index,
                                 List<String> current,
                                 List<List<String>> result) {

        // Base Case
        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current flag
        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current flag
        backtrack(flags, index + 1, current, result);
    }

    public static void main(String[] args) {

        String[] flags = {
                "DarkMode",
                "NewCheckout",
                "BetaSearch"
        };

        List<List<String>> subsets = generateSubsets(flags);

        System.out.println("All Feature Flag Combinations:");

        for (List<String> subset : subsets) {
            System.out.println(subset);
        }
    }
}
