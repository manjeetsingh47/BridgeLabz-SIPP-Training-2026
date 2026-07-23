package DSA_Basics.gcr_codebase.Recursion_Backtracking;

import java.util.*;

public class NQueens {

    // Store all solutions
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        int[] queenCol = new int[n];

        backtrack(n, 0, queenCol, result);

        return result;
    }

    // Backtracking
    public static void backtrack(int n,
                                 int row,
                                 int[] queenCol,
                                 List<List<String>> result) {

        // Base Case
        if (row == n) {
            result.add(buildBoard(n, queenCol));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, queenCol)) {

                queenCol[row] = col;

                backtrack(n, row + 1, queenCol, result);
            }
        }
    }

    // Check if current position is safe
    public static boolean isSafe(int row, int col, int[] queenCol) {

        for (int r = 0; r < row; r++) {

            // Same column
            if (queenCol[r] == col)
                return false;

            // Same diagonal
            if (Math.abs(queenCol[r] - col) == Math.abs(r - row))
                return false;
        }

        return true;
    }

    // Convert solution into board
    public static List<String> buildBoard(int n, int[] queenCol) {

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if (queenCol[i] == j)
                    row.append("Q");
                else
                    row.append(".");
            }

            board.add(row.toString());
        }

        return board;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Total Solutions = " + solutions.size());

        for (List<String> board : solutions) {

            System.out.println();

            for (String row : board) {
                System.out.println(row);
            }
        }
    }
}
