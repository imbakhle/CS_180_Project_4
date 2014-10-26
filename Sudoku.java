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
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Board is not solved if there are any 0s in the board
                if (board[i][j] == 0)
                    return false;
                
                // Board is not solved if there is a similar number in a row
                if (j != 8) {
                    for (int k = j + 1; k < 9; k++) {
                        if (board[i][j] == board[i][k])
                            return false;
                    }
                }
                
                // Board is not solved if there is a similar number in column
                if (i != 8) {
                    for (int k = i + 1; k < 9; k++) {
                        if (board[j][i] == board[k][i])
                            return false;
                    }
                }
            }
        }
        
        // Board is not solved if there is a similar number in a box
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (row >= 0 && row <= 2) {
                    // Box 1
                    if (column >= 0 && column <= 2) {
                        for (int check = row; check < 3; check++) {
                            if (check == row) {
                                if (column != 2) {
                                    for (int check2 = column + 1; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 2) {
                                    for (int check2 = column; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 2
                    if (column >= 3 && column <= 5) {
                        for (int check = row; check < 3; check++) {
                            if (check == row) {
                                if (column != 5) {
                                    for (int check2 = column + 1; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 5) {
                                    for (int check2 = column; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 3
                    if (column >= 6 && column <= 8) {
                        for (int check = row; check < 3; check++) {
                            if (check == row) {
                                if (column != 8) {
                                    for (int check2 = column + 1; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 8) {
                                    for (int check2 = column; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                } else if (row >= 3 && row <= 5) {
                    // Box 4
                    if (column >= 0 && column <= 2) {
                        for (int check = row; check < 6; check++) {
                            if (check == row) {
                                if (column != 2) {
                                    for (int check2 = column + 1; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 2) {
                                    for (int check2 = column; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 5
                    if (column >= 3 && column <= 5) {
                        for (int check = row; check < 6; check++) {
                            if (check == row) {
                                if (column != 5) {
                                    for (int check2 = column + 1; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 5) {
                                    for (int check2 = column; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 6
                    if (column >= 6 && column <= 8) {
                        for (int check = row; check < 6; check++) {
                            if (check == row) {
                                if (column != 8) {
                                    for (int check2 = column + 1; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 8) {
                                    for (int check2 = column; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                } else if (row >= 6 && row <= 8) {
                    // Box 4
                    if (column >= 0 && column <= 2) {
                        for (int check = row; check < 9; check++) {
                            if (check == row) {
                                if (column != 2) {
                                    for (int check2 = column + 1; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 2) {
                                    for (int check2 = column; check2 < 3; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 5
                    if (column >= 3 && column <= 5) {
                        for (int check = row; check < 9; check++) {
                            if (check == row) {
                                if (column != 5) {
                                    for (int check2 = column + 1; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 5) {
                                    for (int check2 = column; check2 < 6; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                    
                    // Box 6
                    if (column >= 6 && column <= 8) {
                        for (int check = row; check < 9; check++) {
                            if (check == row) {
                                if (column != 8) {
                                    for (int check2 = column + 1; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                            else {
                                if (column != 8) {
                                    for (int check2 = column; check2 < 9; check2++) {
                                        if (board[row][column] == board[check][check2])
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                }
            } 
        }
        
        
        
        return true;
    }
    
    public void solve() {
       
    }
}