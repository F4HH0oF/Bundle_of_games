package SudokuCode.Backend;

class Position {
    private int num;
    private int row;
    private int col;

    Position(int num, int row, int col) {
        setNum(num);
        setNum(row);
        setCol(col);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

