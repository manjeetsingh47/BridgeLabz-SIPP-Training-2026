package DSA_Basics.gcr_codebase.Recursion_Backtracking;

public class WordSearch {

    // Check if word exists in grid
    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (backtrack(board, word, 0, i, j, visited))
                    return true;
            }
        }

        return false;
    }

    // Backtracking
    public static boolean backtrack(char[][] board,
                                    String word,
                                    int index,
                                    int row,
                                    int col,
                                    boolean[][] visited) {

        // Word found
        if (index == word.length())
            return true;

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length)
            return false;

        // Already visited or character mismatch
        if (visited[row][col] ||
            board[row][col] != word.charAt(index))
            return false;

        // Choose
        visited[row][col] = true;

        boolean found =
                backtrack(board, word, index + 1, row + 1, col, visited) ||
                backtrack(board, word, index + 1, row - 1, col, visited) ||
                backtrack(board, word, index + 1, row, col + 1, visited) ||
                backtrack(board, word, index + 1, row, col - 1, visited);

        // Backtrack
        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        if (exist(board, word)) {
            System.out.println("Word Found");
        } else {
            System.out.println("Word Not Found");
        }
    }
}