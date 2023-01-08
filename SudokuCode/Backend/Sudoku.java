package SudokuCode.Backend;

import java.util.*;

public class Sudoku {
    public static Random random = new Random();
    private int[][] fullGrid;
    private int[][] maskedGrid;
    private int difficulty;

    private static int[][] arr;

    private static Set<Integer> set = new HashSet<>();

    //obstho polzvane
    public Sudoku(int difficulty) {
        setDifficulty(difficulty);
        int[][] board = Solver.solve(new int[9][9]);
        setFullGrid(board);
        arr = copyArray(board);
        setMaskedGrid(maskArray(difficulty));


    }

    //podrazbirane
    public Sudoku() {
        setDifficulty(30);
        int[][] board = Solver.solve(new int[9][9]);
        setFullGrid(board);
        arr = copyArray(board);
        setMaskedGrid(maskArray(30));
    }
    //kopirane???
    public Sudoku(Sudoku s){
        setDifficulty(s.getDifficulty());
        setFullGrid(s.getFullGrid());
        setMaskedGrid(s.getMaskedGrid());
    }

    public int[][] getFullGrid() {
        return fullGrid;
    }

    public void setFullGrid(int[][] fullGrid) {
        this.fullGrid = fullGrid;
    }

    public int[][] getMaskedGrid() {
        return maskedGrid;
    }

    public void setMaskedGrid(int[][] maskedGrid) {
        this.maskedGrid = maskedGrid;
    }


    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public static int calcNumOfOptions(int row, int col) {
        set.clear();
        for (int i = 0; i < 9; i++) {
            set.add(arr[row][i]);
            set.add(arr[i][col]);
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                set.add(arr[i][j]);
            }
        }
        set.remove(0);
        return 9 - set.size();
    }



    public static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[9][9];
        int index = 0;
        for (int[] ints : arr) {
            System.arraycopy(ints, 0, copy[index], 0, ints.length);
            index++;
        }
        return copy;
    }

    public static int[][] maskArray(int difficulty) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < difficulty; i++) {
            int x = random.nextInt(0, 9);
            int y = random.nextInt(0, 9);
            int temp = arr[x][y];
            if (arr[x][y] != 0) {
                arr[x][y] = 0;
            } else {
                i--;
                continue;
            }
            list.add(new Position(temp, x, y));
            if (!isPresentPosUnique(list)) {
                list.remove(list.size() - 1);
            }
        }
        return arr;
    }

    public static boolean isPresentPosUnique(List<Position> list) {
        for (Position p : list) {
            if (calcNumOfOptions(p.getRow(), p.getCol()) == 1) return true;
        }
        return false;
    }

    public static List<Integer> possibleNumsInPosition(int[][] array, int row, int col) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(array[row][i]);
            set.add(array[i][col]);
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                set.add(array[i][j]);
            }
        }
        set.remove(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        for (Integer integer : set) {
            list.remove(integer);
        }
        return list;
    }


}

