package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoard;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoardManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesTile;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SlidingTilesBoardAndSlidingTilesTileTest {

    /** The board manager for testing. */
    private SlidingTilesBoardManager slidingTilesBoardManager;
    /** The tile to be used for testing. */
    private SlidingTilesTile slidingTilesTile;

    /**
     * Make a set of tiles that are in order.
     * @return a set of tiles that are in order
     */
    private List<SlidingTilesTile> makeTiles(int numRows, int numCols) {
        List<SlidingTilesTile> slidingTilesTiles = new ArrayList<>();
        final int numTiles = numRows * numCols;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            slidingTilesTiles.add(new SlidingTilesTile(tileNum + 1, tileNum));
        }
        return slidingTilesTiles;
    }

    private void setUpTile(){
        slidingTilesTile = new SlidingTilesTile(16, 16);
    }



    /**
     * Make a solved SlidingTilesBoard.
     */
    private void setUpCorrect() {
        SlidingTilesBoard.setDifficulty(0);
        List<SlidingTilesTile> slidingTilesTiles = makeTiles(SlidingTilesBoard.getNumRows(), SlidingTilesBoard.getNumCols());
        SlidingTilesBoard slidingTilesBoard = new SlidingTilesBoard(slidingTilesTiles);
        slidingTilesBoardManager = new SlidingTilesBoardManager(slidingTilesBoard);
    }

    /**
     * Test whether getSlidingTilesTiles works.
     */
    @Test
    public void testGetSlidingTilesTiles() {
        setUpCorrect();
        List<SlidingTilesTile> initialArrangement = makeTiles(SlidingTilesBoard.getNumRows(), SlidingTilesBoard.getNumCols());
        assertEquals(initialArrangement,slidingTilesBoardManager.getSlidingTilesBoard().getSlidingTilesTiles());
        initialArrangement.add(3, initialArrangement.remove(5));
        assertNotEquals(initialArrangement, slidingTilesBoardManager.getSlidingTilesBoard().getSlidingTilesTiles());
    }

    /**
     * Test whether getTile works.
     */
    @Test
    public void testGetTile() {
        setUpCorrect();
        SlidingTilesBoard board = slidingTilesBoardManager.getSlidingTilesBoard();
        assertEquals(board.getTile(1, 1), (new SlidingTilesTile(5)));
        assertNotEquals(board.getTile(1 , 1),(new SlidingTilesTile(3)));
    }

    /**
     * Test whether swapTiles works.
     */
    @Test
    public void testSwapTiles() {
        setUpCorrect();
        SlidingTilesBoard board = slidingTilesBoardManager.getSlidingTilesBoard();
        board.swapTiles(0,0,1,0);
        assertEquals(board.getTile(1, 0), (new SlidingTilesTile(0)));
        assertEquals(board.getTile(0 , 0),(new SlidingTilesTile(4)));
    }

    /**
     * Test whether undo works.
     */
    @Test
    public void testUndo() {
        setUpCorrect();
        List<SlidingTilesTile> initialArrangement = makeTiles(SlidingTilesBoard.getNumRows(), SlidingTilesBoard.getNumCols());
        SlidingTilesBoard board = slidingTilesBoardManager.getSlidingTilesBoard();

        SlidingTilesBoard originalBoard = new SlidingTilesBoard(initialArrangement);
        board.swapTiles(0,0,1,0);
        board.undo(initialArrangement);
        assertEquals(board, originalBoard);
    }

    /**
     * Test whether getting the number of tiles from a 4 x 4 game is correct.
     */
    @Test
    public void testNumTiles(){
        setUpCorrect();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().numTiles());
    }

    /**
     * Test whether getting the background value of a tile is correct.
     */
    @Test
    public void testGetBackGround(){
        setUpCorrect();
        assertEquals(0, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getBackground());
    }

    /**
     * Test whether the compare to between 2 tiles is correct.
     */
    @Test
    public void testCompareTo(){
        setUpCorrect();
        setUpTile();
        assertEquals(15,slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).compareTo(slidingTilesTile));
    }

    /**
     * Tests the iterator for the board after no such element exists.
     */
    @Test(expected = NoSuchElementException.class)//IndexOutOfBoundsException.class)
    public void testSlidingTilesBoardIteratorHasNext() {
        setUpCorrect();
        Iterator<SlidingTilesTile> it = slidingTilesBoardManager.getSlidingTilesBoard().iterator();
        for (int i = 0; i < 17; i++) {
            it.next();
        }
    }
}
