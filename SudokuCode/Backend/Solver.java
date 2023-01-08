package SudokuCode.Backend;


//package private class that generates a 9 by 9 sudoku grid
class Solver {
    private static boolean validRow(int[][] arr, int num, int row) {
        for (int i = 0; i < 9; i++) {
            if (num == arr[row][i]) return false;

        }
        return true;
    }

    private static boolean validCol(int[][] arr, int num, int col) {
        for (int i = 0; i < 9; i++) {
            if (num == arr[i][col]) return false;
        }
        return true;
    }

    private static boolean validBox(int[][] arr, int num, int row, int col) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (num == arr[i][j]) return false;
            }
        }
        return true;
    }

    private static boolean validAll(int[][] arr, int num, int row, int col) {
        return validRow(arr, num, row) && validCol(arr, num, col) && validBox(arr, num, row, col);
    }

    private static boolean recursionSolver(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int k = 0; k < 9; k++) {
                        int num = Sudoku.random.nextInt(1, 10);
                        if (validAll(board, num, row, col)) {
                            board[row][col] = num;

                            if (recursionSolver(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] solve(int[][] arr) {
        recursionSolver(arr);
        return arr;
    }



//    public static void printArr(int[][] arr) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(arr[i][j] + "  ");
//            }
//            System.out.println();
//        }
//    }
}