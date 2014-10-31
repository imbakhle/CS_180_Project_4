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
        Sudoku s = new Sudoku();
        s.main(new String[] {"0000410000600002000000000003206000"
            + "00000050040700000000000200300480000000501000000"});
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(s.board()[i][j], board[i][j]);
            }
        }
    }
    
}
