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
        boolean[] candidate = new boolean[10];
        if (board[row][column] == 0) {        
            numCheck: for (int i = 1; i < 10; i++) {
                // Check corresponding column
                for (int j = 1; j < 10; j++) {
                    if (board[j][column] == i){
                        continue numCheck;
                    }
                }
                
                // Check corresponding row
                for (int j = 1; j < 10; j++) {
                    if (board[row][j] == i) {
                        continue numCheck;
                    }
                }
                
                // Check box
                if (row >= 1 && row <= 3) {
                    // Box 1
                    if (column >= 1 && column <= 3) {
                    }
                    
                    // Box 2
                    if (column >= 4 && column <= 6) {
                    }
                    
                    // Box 3
                    if (column >= 7 && column <= 9) {
                    }
                } else if (row >= 4 && row <= 6) {
                    // Box 4
                    if (column >= 1 && column <= 3) {
                    }
                    
                    // Box 5
                    if (column >= 4 && column <= 6) {
                    }
                    
                    // Box 6
                    if (column >= 7 && column <= 9) {
                    }
                } else if (row >= 7 && row <= 9) {
                    // Box 4
                    if (column >= 1 && column <= 3) {
                    }
                    
                    // Box 5
                    if (column >= 4 && column <= 6) {
                    }
                    
                    // Box 6
                    if (column >= 7 && column <= 9) {
                    }
                }
                    
            }
        }
        return candidate;
    }
    
    public boolean isSolved() {
        return true;
    }
    
    public void solve() {
       
    }
}