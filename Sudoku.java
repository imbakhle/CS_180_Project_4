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
                    // Box 7
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
                    
                    // Box 8
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
                    
                    // Box 9
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
    
    // Creates a nice on-screen view of the current board
    public void printBoard() {
        System.out.println("    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");
        System.out.printf("A | %d %d %d | %d %d %d | %d %d %d |", 
        board()[0][0], board()[0][1], board()[0][2], board()[0][3],
        board()[0][4], board()[0][5], board()[0][6], board()[0][7],
        board()[0][8]);
        System.out.printf("B | %d %d %d | %d %d %d | %d %d %d |", 
        board()[1][0], board()[1][1], board()[1][2], board()[1][3],
        board()[1][4], board()[1][5], board()[1][6], board()[1][7],
        board()[1][8]);
        System.out.printf("C | %d %d %d | %d %d %d | %d %d %d |", 
        board()[2][0], board()[2][1], board()[2][2], board()[2][3],
        board()[2][4], board()[2][5], board()[2][6], board()[2][7],
        board()[2][8]);        
        System.out.println("  +-------+-------+-------+");
        System.out.printf("D | %d %d %d | %d %d %d | %d %d %d |", 
        board()[3][0], board()[3][1], board()[3][2], board()[3][3],
        board()[3][4], board()[3][5], board()[3][6], board()[3][7],
        board()[3][8]);
        System.out.printf("E | %d %d %d | %d %d %d | %d %d %d |", 
        board()[4][0], board()[4][1], board()[4][2], board()[4][3],
        board()[4][4], board()[4][5], board()[4][6], board()[4][7],
        board()[4][8]);
        System.out.printf("F | %d %d %d | %d %d %d | %d %d %d |", 
        board()[5][0], board()[5][1], board()[5][2], board()[5][3],
        board()[5][4], board()[5][5], board()[5][6], board()[5][7],
        board()[5][8]);                        
        System.out.println("  +-------+-------+-------+");
        System.out.printf("G | %d %d %d | %d %d %d | %d %d %d |", 
        board()[6][0], board()[6][1], board()[6][2], board()[6][3],
        board()[6][4], board()[6][5], board()[6][6], board()[6][7],
        board()[6][8]);        
        System.out.printf("H | %d %d %d | %d %d %d | %d %d %d |", 
        board()[7][0], board()[7][1], board()[7][2], board()[7][3],
        board()[7][4], board()[7][5], board()[7][6], board()[7][7],
        board()[7][8]);        
        System.out.printf("I | %d %d %d | %d %d %d | %d %d %d |", 
        board()[8][0], board()[8][1], board()[8][2], board()[8][3],
        board()[8][4], board()[8][5], board()[8][6], board()[8][7],
        board()[8][8]);        
        System.out.println("  +-------+-------+-------+");        
    }
}