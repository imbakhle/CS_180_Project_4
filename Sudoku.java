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
        boolean[] candidate = new boolean[10];
        Arrays.fill(candidate, false);
        
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
                        for (int j = 1; j < 4; j++) {
                            for (int k = 1; k < 4; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 2
                    if (column >= 4 && column <= 6) {
                        for (int j = 1; j < 4; j++) {
                            for (int k = 4; k < 7; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                        
                    }
                    
                    // Box 3
                    if (column >= 7 && column <= 9) {
                        for (int j = 1; j < 4; j++) {
                            for (int k = 7; k < 10; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                } else if (row >= 4 && row <= 6) {
                    // Box 4
                    if (column >= 1 && column <= 3) {
                        for (int j = 4; j < 7; j++) {
                            for (int k = 1; k < 4; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 5
                    if (column >= 4 && column <= 6) {
                        for (int j = 4; j < 7; j++) {
                            for (int k = 4; k < 7; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 6
                    if (column >= 7 && column <= 9) {
                        for (int j = 4; j < 7; j++) {
                            for (int k = 7; k < 10; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                } else if (row >= 7 && row <= 9) {
                    // Box 7
                    if (column >= 1 && column <= 3) {
                        for (int j = 7; j < 10; j++) {
                            for (int k = 1; k < 4; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }                        
                    }
                    
                    // Box 8
                    if (column >= 4 && column <= 6) {
                        for (int j = 7; j < 10; j++) {
                            for (int k = 4; k < 7; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 9
                    if (column >= 7 && column <= 9) {
                        for (int j = 7; j < 10; j++) {
                            for (int k = 7; k < 10; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                }
                
                // If the number is not present in any subunit
                candidate[i] = true;
            }
        }
        return candidate;
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