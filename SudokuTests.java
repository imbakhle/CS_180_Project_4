import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SudokuTests extends TestCase {
    
    /**
     * A test method.
     * (Replace "X" with a name describing the test.  You may write as
     * many "testSomething" methods in this class as you wish, and each
     * one will be called when running JUnit over this class.)
     */
    public void testBoard() {
        int[][] board = {{0,0,0,0,4,1,0,0,0},{0,6,0,0,0,0,2,0,0},
            {0,0,0,0,0,0,0,0,0},{3,2,0,6,0,0,0,0,0},{0,0,0,0,5,0,0,4,0},
            {7,0,0,0,0,0,0,0,0},{0,0,0,2,0,0,3,0,0},{4,8,0,0,0,0,0,0,0},
            {5,0,1,0,0,0,0,0,0}};
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
        
        int[][] board = {{0,2,8,0,0,7,0,0,0},{0,1,6,0,0,0,2,0,0},
            {0,0,0,0,0,0,0,0,0},{1,2,0,6,0,0,0,0,0},{0,0,0,0,5,0,0,4,0},
            {0,0,0,0,0,0,0,0,0},{2,0,0,2,0,0,3,0,0},{0,8,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0}};
        Sudoku s = new Sudoku(board);
        
        for (int i = 0; i < 10; i++) {
            assertEquals(s.candidates(0,0)[i], cellCandidates[i]);
        }
    }
    
    public void testIsSolved() {
        int[][] board = {{0,2,8,0,0,7,0,0,0},{0,1,6,0,0,0,2,0,0},
            {0,0,0,0,0,0,0,0,0},{1,2,0,6,0,0,0,0,0},{0,0,0,0,5,0,0,4,0},
            {0,0,0,0,0,0,0,0,0},{2,0,0,2,0,0,3,0,0},{0,8,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), false);
    }
    
    public void test2IsSolved() {
        int[][] board = {{2,9,6,3,1,8,5,7,4},{5,8,4,9,7,2,6,1,3},
            {7,1,3,6,4,5,2,8,9},{6,2,5,8,9,7,3,4,1},{9,3,1,4,2,6,8,5,7},
            {4,7,8,5,3,1,9,2,6},{1,6,7,2,5,3,4,9,8},{8,5,9,7,6,4,1,3,2},
            {3,4,2,1,8,9,7,6,5}};
        Sudoku s = new Sudoku(board);
        
        assertEquals(s.isSolved(), true);
        
    }
    
    public void testnakedSingles() {
        int[][] board = {{2,9,6,3,0,8,5,7,4},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};
         int[][] board2 = {{2,9,6,3,1,8,5,7,4},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};
         
        Sudoku s = new Sudoku(board);
        s.nakedSingles();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
            assertEquals(board[i][j], board2[i][j]);
        }
        
    }
}
