package fall2018.csc2017.GameCentre;

import org.junit.Test;

import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperBoard;
import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperBoardManager;
import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperTile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for class MineSweeperBoardManager.
 */
public class MineSweeperBoardManagerTest {

    /**
     * The testing MineSweeperBoardManager.
     */
    private MineSweeperBoardManager mineSweeperBoardManager;

    /**
     * The testing MineSweeperBoard.
     */
    private MineSweeperBoard board;

    /**
     * Number of bombs.
     */
    private int bombCount;

    /**
     * Initialize the testing board as 3 X 5 board.
     */
    public MineSweeperBoardManagerTest() {
        MineSweeperBoard.setNumCols(3);
        MineSweeperBoard.setNumRows(5);
        mineSweeperBoardManager = new MineSweeperBoardManager();
        board = mineSweeperBoardManager.getBoard();
        for (MineSweeperTile curTile : mineSweeperBoardManager.getTiles()) {
            if (curTile.getBackgroundValue() == -1) {
                bombCount += 1;
            }
        }
    }

    /**
     * Test that the constructor correctly generates the correct tile array.
     */
    @Test
    public void MineSweeperBoardManagerConstructorTest() {
        assertEquals(board.getTiles(), mineSweeperBoardManager.getTiles());
        assertEquals(1, bombCount);
    }

    /**
     * Test the correctness of the setter and getter for clicks.
     */
    @Test
    public void setClicksAndGetClicksTest() {
        mineSweeperBoardManager.setClicks(2);
        assertEquals(2, mineSweeperBoardManager.getClicks());
    }

    /**
     * Test a game where we lost.
     */
    @Test
    public void gameOverTest() {
        assertFalse(mineSweeperBoardManager.gameOver());
        for (int i = 0; i != 3; i++) {
            for (int j = 0; j != 5; j++) {
                if (board.getTile(j, i).getBackgroundValue() == -1) {
                    board.open(j, i);
                }
            }
        }
        assertTrue(mineSweeperBoardManager.gameOver());
    }

    /**
     * Test that the touch move correctly modifies the board
     */
    @Test
    public void touchMoveTest() {
        mineSweeperBoardManager.setClicks(5);
        mineSweeperBoardManager.touchMove(1);
        assertEquals(6, mineSweeperBoardManager.getClicks());
        assertFalse(mineSweeperBoardManager.getBoard().getTile(0, 1).isNotOpened());

    }

    /**
     * Test a game where we won.
     */
    @Test
    public void isWinTest() {
        MineSweeperBoard.setNumCols(3);
        MineSweeperBoard.setNumRows(5);
        mineSweeperBoardManager = new MineSweeperBoardManager();
        for (int i = 0; i != mineSweeperBoardManager.getTiles().size(); i++) {
            if (mineSweeperBoardManager.getTiles().get(i).getBackgroundValue() != -1) {
                mineSweeperBoardManager.touchMove(i);
            }
        }
        assertTrue(mineSweeperBoardManager.isWin());
    }

}
