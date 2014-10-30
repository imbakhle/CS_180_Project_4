import java.util.Arrays;
import java.util.ArrayList;

public class Sudoku {
    
    private int[][] board;
    
    public Sudoku () {
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], 0);
        }
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
                for (int j = 0; j < 9; j++) {
                    if (board[j][column] == i){
                        continue numCheck;
                    }
                }
                
                // Check corresponding row
                for (int j = 0; j < 9; j++) {
                    if (board[row][j] == i) {
                        continue numCheck;
                    }
                }
                
                // Check box
                if (row >= 0 && row <= 2) {
                    // Box 1
                    if (column >= 0 && column <= 2) {
                        for (int j = 0; j < 3; j++) {
                            for (int k = 0; k < 3; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 2
                    if (column >= 3 && column <= 5) {
                        for (int j = 0; j < 3; j++) {
                            for (int k = 3; k < 6; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                        
                    }
                    
                    // Box 3
                    if (column >= 6 && column <= 8) {
                        for (int j = 0; j < 3; j++) {
                            for (int k = 6; k < 9; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                } else if (row >= 3 && row <= 5) {
                    // Box 4
                    if (column >= 0 && column <= 2) {
                        for (int j = 3; j < 6; j++) {
                            for (int k = 0; k < 3; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 5
                    if (column >= 3 && column <= 5) {
                        for (int j = 3; j < 6; j++) {
                            for (int k = 3; k < 6; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 6
                    if (column >= 6 && column <= 8) {
                        for (int j = 3; j < 6; j++) {
                            for (int k = 6; k < 9; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                } else if (row >= 6 && row <= 8) {
                    // Box 7
                    if (column >= 0 && column <= 2) {
                        for (int j = 6; j < 9; j++) {
                            for (int k = 0; k < 3; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }                        
                    }
                    
                    // Box 8
                    if (column >= 3 && column <= 5) {
                        for (int j = 6; j < 9; j++) {
                            for (int k = 3; k < 6; k++) {
                                if (board[j][k] == i) {
                                    continue numCheck;
                                }
                            }
                        }
                    }
                    
                    // Box 9
                    if (column >= 6 && column <= 8) {
                        for (int j = 6; j < 9; j++) {
                            for (int k = 6; k < 9; k++) {
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
                        if (board[i][j] == board[i][k]) {
                            System.out.println("row");
                            return false;
                        }
                        
                    }
                }
                
                // Board is not solved if there is a similar number in column
                if (i != 8) {
                    for (int k = i + 1; k < 9; k++) {
                        if (board[i][j] == board[k][j]) {
                            System.out.println("column");
                            return false;
                        }
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
        boolean check = false;
        while (isSolved() == true) {
        }
        do {
            check = nakedSingles();  
        } while(check == true);
        
    }
        
    // Naked Singles Method
    public boolean nakedSingles() {
        boolean[] options;
        int countTrue = 0;
        int locationTrue = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                options = candidates(i, j);
                countTrue = 0;
                for (int h = 1; h < 10; h++) {
                    if (options[h] == true) {
                        countTrue++;
                        locationTrue = h;
                    }
                }
                if (countTrue == 1) {
                    board[i][j] = locationTrue;
                    return true;
                }
            }
        }
        return false;
    }
    
    // Creates a nice on-screen view of the current board
    public void printBoard() {
        String line;
        int num;
        System.out.println("    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+"); 
        
        // A
        line = "A | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[0][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // B
        line = "B | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[1][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // C
        line = "C | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[2][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        
        System.out.println("  +-------+-------+-------+"); 
        
        // D
        line = "D | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[3][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // E
        line = "E | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[4][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // F
        line = "F | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[5][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        
        System.out.println("  +-------+-------+-------+"); 
        
        // G
        line = "G | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[6][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // H
        line = "H | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[7][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        // I
        line = "I | ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = board()[8][3*i + j];
                if (num != 0) {
                    line += String.format("%d ", num);
                } else {
                    line += "  ";
                }
            }
            line += "| ";
        }
        System.out.println(line);
        
        System.out.println("  +-------+-------+-------+");        
    }
    
    public static void main(String[] args) {
        int[][] puzzle = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = (int) args[0].charAt(9 * i + j) - 48;
            }
        }
        
        Sudoku s = new Sudoku(puzzle);
        s.printBoard();
        /*for (int i = 1; i < 10; i++)
            System.out.println(s.candidates(1,0)[i]);*/
        s.solve();
        System.out.println("\n\tSolved Board\n");
        s.printBoard();
        
        //System.out.println(s.isSolved());
    }
}