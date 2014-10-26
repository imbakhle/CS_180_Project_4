import java.util.Arrays;

public class Sudoku {
    
    private int[][] board;
    
    public Sudoku () {
        board = new int[9][9];
    }
    
    public Sudoku (int[][] board) {
        this.board = board;
    }
    
    // Returns a copy of the current state of the board--Done
    public int[][] board() {
        int[][] copyboard = new int[9][9];
        
      
        return Arrays.copyOf(board, board.length);
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