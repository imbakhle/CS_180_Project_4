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
        return Arrays.copyOf(board, board.length);
    }
    
    public boolean[] candidates(int row, int column) {
        boolean[] hi = {true};
        return hi;
    }
    
    public boolean isSolved() {
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Board is not solved if there are any 0s in the board
                if (board[i][j] == 0)
                    return false;
                
                // Board is not solved if there is a similar number in a row
                for (int k = j; k < 9; k++) {
                    if (board[i][j] == board[i][k])
                        return false;
                }
                
                // Board is not solved if there is a similar number in column
                for (int k = i; k < 9; k++) {
                    if (board[j][i] == board[k][i])
                        return false;
                }
            }
        }
        
        
        
        
        return true;
    }
    
    public void solve() {
       
    }
}