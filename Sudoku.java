public class Sudoku {
    
    private int[][] board;
    
    public Sudoku () {
        board = new int[9][9];
    }
    
    public Sudoku (int[][] board) {
        this.board = board;
    }
    
    public int[][] board() {
        return board;
    }
    
    public boolean[] candidates(int row, int column) {
        boolean[] hi = {true};
        return hi;
    }
    
    public boolean isSolved() {
        return true;
    }
    
    public void solve() {
       
    }
}