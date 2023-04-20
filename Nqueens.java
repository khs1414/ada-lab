public class Nqueens {
    public static boolean solveNQueens(int n) {
        int[] positions = new int[n];
        return solveNQueensHelper(positions, 0, n);
    }

    private static boolean solveNQueensHelper(int[] positions, int row, int n) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean isValid = true;
            for (int i = 0; i < row; i++) {
                if (positions[i] == col || positions[i] - i == col - row || positions[i] + i == col + row) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                positions[row] = col;
                if (solveNQueensHelper(positions, row + 1, n)) {
                    return true;
                }
            }
        }

        positions[row] = 0;
        return false;
    }

    public static void printSolution(int[] positions) {
        int n = positions.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (positions[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        if (solveNQueens(n)) {
            printSolution(positions);
        } else {
            System.out.println("No solution exists");
        }
    }
}