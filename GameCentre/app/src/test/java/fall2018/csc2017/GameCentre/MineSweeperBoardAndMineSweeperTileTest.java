package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperBoard;
import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperTile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MineSweeperBoardAndMineSweeperTileTest {

    private MineSweeperBoard mineSweeperBoard;

    /**
     * Make a set of tiles with
     */
    private List<MineSweeperTile> makeTiles(int numRows, int numCols) {
        List<MineSweeperTile> mineSweeperTiles = new ArrayList<>();
        final int numTiles = numCols * numRows;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            mineSweeperTiles.add(new MineSweeperTile(tileNum));
        }
        return mineSweeperTiles;
    }

    /**
     * Test that we can correctly set and get the number of rows.
     */
    @Test
    public void testSetterAndGetterForColumnsAndRowAndBombs() {
        MineSweeperBoard.setNumCols(3);
        MineSweeperBoard.setNumRows(5);
        assertEquals(1, MineSweeperBoard.getNumBombs());
        assertEquals(3, MineSweeperBoard.getNumCols());
        assertEquals(5, MineSweeperBoard.getNumRows());
    }

    /**
     * Test that we can correctly get a tile given row and col.
     */
    @Test
    public void testGetTilesAndGetTile() {
        MineSweeperBoard.setNumCols(3);
        MineSweeperBoard.setNumRows(5);
        List<MineSweeperTile> lst = makeTiles(MineSweeperBoard.getNumRows(),
                MineSweeperBoard.getNumCols());
        mineSweeperBoard = new MineSweeperBoard(lst);
        List<MineSweeperTile> tiles = mineSweeperBoard.getTiles();
        for (int i = 0; i != tiles.size(); i++) {
            assertEquals(mineSweeperBoard.getTile(i / MineSweeperBoard.getNumCols(),
                    i % MineSweeperBoard.getNumCols()), tiles.get(i));
        }
    }

    /**
     * Test that if we open every non bomb tile, every tile that is opened should only be the non
     * bomb tiles. Also we should heve not lost the game at this point, so test this as well.
     */
    @Test
    public void testOpenAndIsLost() {
        MineSweeperBoard.setNumRows(5);
        MineSweeperBoard.setNumCols(3);
        List<MineSweeperTile> lst = makeTiles(5, 3);
        mineSweeperBoard = new MineSweeperBoard(lst);
        MineSweeperTile bombTile = mineSweeperBoard.getTile(0, 0);
        bombTile.setBackground(-1);
        mineSweeperBoard.getTile(1, 0).setBackgroundValue(1);
        mineSweeperBoard.getTile(0, 1).setBackgroundValue(1);
        mineSweeperBoard.getTile(1, 1).setBackgroundValue(1);
        mineSweeperBoard.open(4, 2);
        for (int i = 0; i != MineSweeperBoard.getNumRows(); i++) {
            for (int j = 0; j != MineSweeperBoard.getNumCols(); j++) {
                if (i == 0 && j == 0) {
                    assertTrue(mineSweeperBoard.getTile(i, j).isNotOpened());
                } else {
                    assertFalse(mineSweeperBoard.getTile(i, j).isNotOpened());
                }
            }
        }
        assertFalse(mineSweeperBoard.isLost());
    }

    /**
     * Testing compareTo() from MineSweeperTile
     */
    @Test
    public void testCompareTo() {
        MineSweeperTile t1 = new MineSweeperTile(1);
        MineSweeperTile t2 = new MineSweeperTile(2);
        assertEquals(-1, t2.compareTo(t1));
    }

    /**
     * Test that the iterator for the board fully iterates through the tiles, and has the correct
     * values.
     */
    @Test
    public void testMineSweeperBoardIterator() {
        MineSweeperBoard.setNumCols(12);
        MineSweeperBoard.setNumRows(20);
        List<MineSweeperTile> tileList = makeTiles(20, 12);
        mineSweeperBoard = new MineSweeperBoard(tileList);
        Iterator<MineSweeperTile> it = mineSweeperBoard.iterator();
        List<Boolean> values = new ArrayList<>();
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 12; col++) {
                values.add(mineSweeperBoard.getTile(row, col).equals(it.next()));
            }
        }
        assertTrue("Iterator should yield the correct next value based on row and column.",
                !values.contains(false));
    }


    /**
     * Test that we correctly register that we iterated too many times(past the number of elements
     * we have).
     */
    @Test(expected = NoSuchElementException.class)//IndexOutOfBoundsException.class)
    public void testMinesweeperBoardIteratorHasNext() {
        MineSweeperBoard.setNumCols(12);
        MineSweeperBoard.setNumRows(20);
        List<MineSweeperTile> tileList = makeTiles(20, 12);
        mineSweeperBoard = new MineSweeperBoard(tileList);
        Iterator<MineSweeperTile> it = mineSweeperBoard.iterator();
        for (int i = 0; i != 241; i++) {
            it.next();
        }
    }

    /**
     * Test that we can correctly set the difficulty of the board.
     */
    @Test
    public void setDifficultyTest(){
        MineSweeperBoard.setDifficulty(-1);
        assertEquals(14, MineSweeperBoard.getNumRows());
        assertEquals(8, MineSweeperBoard.getNumCols());
    }

    /**
     * Test that we can correctly get the background id(image in this case) of the board.
     */
    @Test
    public void getBackgroundTest(){
        MineSweeperTile tile = new MineSweeperTile(1);
        //2131165281 is the value assigned to the image with background id 1
        assertEquals(2131165281, tile.getBackground());
    }
}
