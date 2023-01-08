package SudokuCode.Frontend;
public class Container {
    public int i;
    public int j;
    public Container(int i, int j){
        this.i = i;
        this.j = j;
    }
    public Container(int i){
        this.i = i;
        this.j = -1;
    }
}
