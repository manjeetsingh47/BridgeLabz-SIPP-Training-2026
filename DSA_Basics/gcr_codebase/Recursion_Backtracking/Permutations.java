package DSA_Basics.gcr_codebase.Recursion_Backtracking;

import java.util.*;

public class Permutations {

    // Generate all permutations
    public static List<List<String>> generatePermutations(String[] engineers) {

        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];

        backtrack(engineers, used, new ArrayList<>(), result);

        return result;
    }

    // Backtracking
    public static void backtrack(String[] engineers,
                                 boolean[] used,
                                 List<String> path,
                                 List<List<String>> result) {

        // Base Case
        if (path.size() == engineers.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < engineers.length; i++) {

            if (used[i])
                continue;

            // Choose
            used[i] = true;
            path.add(engineers[i]);

            backtrack(engineers, used, path, result);

            // Backtrack
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        String[] engineers = {
                "Alice",
                "Bob",
                "Charlie"
        };

        List<List<String>> schedules = generatePermutations(engineers);

        System.out.println("Possible On-Call Schedules:");

        for (List<String> schedule : schedules) {
            System.out.println(schedule);
        }
    }
}