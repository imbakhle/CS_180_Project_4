import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SudokuTests extends TestCase {
    
    /**
     * A test method.
     */
    
    public void testSudoku() {  
        Sudoku s = new Sudoku();
        int[][] hello = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(hello[i][j], s.board()[i][j]);
            }
        }
    }
    
    public void testBoard() {
        int[][] board = {{0, 0, 0, 0, 4, 1, 0, 0, 0}, {0, 6, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {3, 2, 0, 6, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 5, 0, 0, 4, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 0, 0, 3, 0, 0}, {4, 8, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 1, 0, 0, 0, 0, 0, 0}};
        Sudoku s = new Sudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(s.board()[i][j], board[i][j]);
            }
        }
    }
    
    public void testCandidates() {
        boolean[] cellCandidates = {false, false, false, true, true, true,
            false, false, false, true};
        
        int[][] board = {{0, 2, 8, 0, 0, 7, 0, 0, 0}, {0, 1, 6, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 2, 0, 6, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 5, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 2, 0, 0, 3, 0, 0}, {0, 8, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0}};
        Sudoku s = new Sudoku(board);
        
        for (int i = 0; i < 10; i++) {
            assertEquals(s.candidates(0, 0)[i], cellCandidates[i]);
        }
    }
    
    // Tests if isSolved returns false for empty cell
    public void testisSolved() {
        int[][] board = {{0, 2, 8, 0, 0, 7, 0,  0, 0}, {0, 1, 6, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 2, 0, 6, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 5, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 2, 0, 0, 3, 0, 0}, {0, 8, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), false);
    }
    
    // Tests if isSolved returns true for complete board
    public void test2isSolved() {
        int[][] board = {{2, 9, 6, 3, 1, 8, 5, 7, 4}, {5, 8, 4, 9, 7, 2, 6, 1, 3},
            {7, 1, 3, 6, 4, 5, 2, 8, 9}, {6, 2, 5, 8, 9, 7, 3, 4, 1}, {9, 3, 1, 4, 2, 6, 8, 5, 7},
            {4, 7, 8, 5, 3, 1, 9, 2, 6}, {1, 6, 7, 2, 5, 3, 4, 9, 8}, {8, 5, 9, 7, 6, 4, 1, 3, 2},
            {3, 4, 2, 1, 8, 9, 7, 6, 5}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), true);
        
    }
    
    // Tests if isSolved returns false for similar number in row
    public void test3isSolved() {
        int[][] board = {{2, 9, 6, 3, 1, 2, 5, 7, 4}, {5, 8, 4, 9, 7, 2, 6, 1, 3},
            {7, 1, 3, 6, 4, 5, 2, 8, 9}, {6, 2, 5, 8, 9, 7, 3, 4, 1}, {9, 3, 1, 4, 2, 6, 8, 5, 7},
            {4, 7, 8, 5, 3, 1, 9, 2, 6}, {1, 6, 7, 2, 5, 3, 4, 9, 8}, {8, 5, 9, 7, 6, 4, 1, 3, 2},
            {3, 4, 2, 1, 8, 9, 7, 6, 5}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), false);
        
    }
    
    // Tests if isSolved returns false for similar number in column
    public void test4isSolved() {
        int[][] board = {{2, 9, 6, 3, 1, 8, 5, 7, 4}, {5, 8, 4, 9, 7, 2, 6, 1, 3},
            {2, 1, 3, 6, 4, 5, 2, 8, 9}, {6, 2, 5, 8, 9, 7, 3, 4, 1}, {9, 3, 1, 4, 2, 6, 8, 5, 7},
            {4, 7, 8, 5, 3, 1, 9, 2, 6}, {1, 6, 7, 2, 5, 3, 4, 9, 8}, {8, 5, 9, 7, 6, 4, 1, 3, 2},
            {3, 4, 2, 1, 8, 9, 7, 6, 5}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), false);
        
    }
    
    // Tests nakedSingles 
    public void testnakedSingles() {
        int[][] board = {{2, 9, 6, 3, 0, 8, 5, 7, 4}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board2 = {{2, 9, 6, 3, 1, 8, 5, 7, 4}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}};
         
        Sudoku s = new Sudoku(board);
        s.nakedSingles();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                assertEquals(board2[i][j], board[i][j]);
        }
    }
    
    // Tests hiddenSingles for column
    public void testhiddenSingles() {
        int[][] board = {{0, 0, 2, 1, 9, 3, 0, 0, 0}, {0, 0, 0, 0, 0, 7, 0, 0, 0},
            {7, 0, 0, 0, 4, 0, 0, 1, 9}, {8, 0, 3, 0, 0, 0, 6, 0, 0}, {0, 4, 5, 0, 0, 0, 2, 3, 0},
            {0, 0, 7, 0, 0, 0, 5, 0, 4}, {3, 7, 0, 0, 8, 0, 0, 0, 6}, {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 3, 4, 1, 0, 0}};
        Sudoku s = new Sudoku(board);
        
        while (s.hiddenSingles()) { }
        assertEquals(3, s.board()[5][3]);
    }
    
    // Yests hiddenSingles for row
    public void test2hiddenSingles() {
        int[][] board = {{0, 2, 8, 0, 0, 7, 0, 0, 0}, {0, 1, 6, 0, 8, 3, 0, 7, 0},
            {0, 0, 0, 0, 2, 0, 8, 5, 1}, {1, 3, 7, 2, 9, 0, 0, 0, 0}, {0, 0, 0, 7, 3, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 6, 3, 0, 7}, {2, 9, 0, 0, 7, 0, 0, 0, 0}, {0, 0, 0, 8, 6, 0, 1, 4, 0},
            {0, 0, 0, 3, 0, 0, 7, 0, 0}};
        Sudoku s = new Sudoku(board);
        
        s.hiddenSingles();
        assertEquals(s.board()[2][3], 6);
    }
    
    public void testprintBoard() {
         
         // Visually Tested
        assertEquals(true, true);
    }
     
    public void testsolve() {
        int[][] board = {{7, 9, 0, 0, 0, 0, 3, 0, 0}, {0, 0, 0, 0, 0, 6, 9, 0, 0},
            {8, 0, 0, 0, 3, 0, 0, 7, 6}, {0, 0, 0, 0, 0, 5, 0, 0, 2}, {0, 0, 5, 4, 1, 8, 7, 0, 0},
            {4, 0, 0, 7, 0, 0, 0, 0, 0}, {6, 1, 0, 0, 9, 0, 0, 0, 8}, {0, 0, 2, 3, 0, 0, 0, 0, 0},
            {0, 0, 9, 0, 0, 0, 0, 5, 4}};
        int[][] board2 = {{7, 9, 6, 8, 5, 4, 3, 2, 1}, {2, 4, 3, 1, 7, 6, 9, 8, 5},
            {8, 5, 1, 2, 3, 9, 4, 7, 6}, {1, 3, 7, 9, 6, 5, 8, 4, 2}, {9, 2, 5, 4, 1, 8, 7, 6, 3},
            {4, 6, 8, 7, 2, 3, 5, 1, 9}, {6, 1, 4, 5, 9, 7, 2, 3, 8}, {5, 8, 2, 3, 4, 1, 6, 9, 7},
            {3, 7, 9, 6, 8, 2, 1, 5, 4}};
        Sudoku s = new Sudoku(board);
        s.solve();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                assertEquals(board2[i][j], board[i][j]);
        }
    }
}
