package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoard;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoardManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesTile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SlidingTilesBoardManagerTest {

    /** The board manager for testing. */
    private SlidingTilesBoardManager slidingTilesBoardManager;

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


    /**
     * Make a set of tiles that are in order.
     * @return a set of tiles that are in order
     */
    private List<SlidingTilesTile> makeTilesBackwards(int numRows, int numCols) {
        List<SlidingTilesTile> slidingTilesTiles = new ArrayList<>();
        final int numTiles = numRows * numCols;
        for (int tileNum = numTiles - 1; tileNum != -1; tileNum--) {
            slidingTilesTiles.add(new SlidingTilesTile(tileNum + 1, tileNum));
        }
        return slidingTilesTiles;
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
     * Make a not solved SlidingTilesBoard.
     */
    private void setUpBackWards(){
        SlidingTilesBoard.setDifficulty(0);
        List<SlidingTilesTile> slidingTilesTiles = makeTilesBackwards(SlidingTilesBoard.getNumRows(), SlidingTilesBoard.getNumCols());
        SlidingTilesBoard slidingTilesBoard = new SlidingTilesBoard(slidingTilesTiles);
        slidingTilesBoardManager = new SlidingTilesBoardManager(slidingTilesBoard);
    }

    /**
     * Shuffle a few tiles.
     */
    private void swapFirstTwoTiles() {
        slidingTilesBoardManager.getSlidingTilesBoard().swapTiles(0, 0, 0, 1);
    }

    /**
     * Test whether swapping two tiles makes a solved board unsolved.
     */
    @Test
    public void testIsSolved() {
        setUpCorrect();
        assertTrue(slidingTilesBoardManager.gameOver());
        swapFirstTwoTiles();
        assertFalse(slidingTilesBoardManager.gameOver());
    }

    /**
     * Test whether swapping the first two tiles works.
     */
    @Test
    public void testSwapFirstTwo() {
        setUpCorrect();
        assertEquals(1, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(2, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 1).getId());
        slidingTilesBoardManager.getSlidingTilesBoard().swapTiles(0, 0, 0, 1);
        assertEquals(2, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(1, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 1).getId());
    }

    /**
     * Test whether swapping the last two tiles works.
     */
    @Test
    public void testSwapLastTwo() {
        setUpCorrect();
        assertEquals(15, slidingTilesBoardManager.getSlidingTilesBoard().getTile(3, 2).getId());
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(3, 3).getId());
        slidingTilesBoardManager.getSlidingTilesBoard().swapTiles(3, 3, 3, 2);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(3, 2).getId());
        assertEquals(15, slidingTilesBoardManager.getSlidingTilesBoard().getTile(3, 3).getId());
    }

    /**
     * Test whether isValidHelp works.
     */
    @Test
    public void testIsValidTap() {
        setUpCorrect();
        assertTrue(slidingTilesBoardManager.isValidTap(11));
        assertTrue(slidingTilesBoardManager.isValidTap(14));
        assertFalse(slidingTilesBoardManager.isValidTap(10));
    }

    /**
     * The blank tile is on the right
     */
    @Test
    public void testTouchMoveLeftRight(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(15, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 1).getId());
        slidingTilesBoardManager.touchMove(1);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 1).getId());
        assertEquals(15, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
    }


    /**
     * The blank tile is on top
     */
    @Test
    public void testTouchMoveUpDown(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(12, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 0).getId());
        slidingTilesBoardManager.touchMove(4);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 0).getId());
        assertEquals(12, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
    }

    /**
     * The blank tile is on the left
     */
    @Test
    public void testTouchMoveInteriorRightLeft(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(10, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
        slidingTilesBoardManager.touchMove(4);
        slidingTilesBoardManager.touchMove(5);
        slidingTilesBoardManager.touchMove(6);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
        assertEquals(10, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 1).getId());
    }

    /**
     * The blank tile is on the right
     */
    @Test
    public void testTouchMoveInteriorRightLeftWhiteRight(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(10, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
        slidingTilesBoardManager.touchMove(4);
        slidingTilesBoardManager.touchMove(5);
        slidingTilesBoardManager.touchMove(6);
        slidingTilesBoardManager.touchMove(5);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 1).getId());
        assertEquals(10, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
    }

    /**
     * The blank tile is on top
     */
    @Test
    public void testTouchMoveInteriorUpDown(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(7, slidingTilesBoardManager.getSlidingTilesBoard().getTile(2, 1).getId());
        slidingTilesBoardManager.touchMove(4);
        slidingTilesBoardManager.touchMove(5);
        slidingTilesBoardManager.touchMove(9);
        slidingTilesBoardManager.touchMove(5);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 1).getId());
        assertEquals(7, slidingTilesBoardManager.getSlidingTilesBoard().getTile(2, 1).getId());
    }

    /**
     * The blank tile is below
     */
    @Test
    public void testTouchMoveInteriorUpDownWhiteDown(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(6, slidingTilesBoardManager.getSlidingTilesBoard().getTile(2, 2).getId());
        slidingTilesBoardManager.touchMove(4);
        slidingTilesBoardManager.touchMove(5);
        slidingTilesBoardManager.touchMove(6);
        slidingTilesBoardManager.touchMove(10);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(2, 2).getId());
        assertEquals(6, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
    }

    /**
     * The blank tile is below
     */
    @Test
    public void testTouchMoveExteriorUpDownWhiteUp(){
        setUpBackWards();
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 0).getId());
        assertEquals(14, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 2).getId());
        slidingTilesBoardManager.touchMove(4);
        slidingTilesBoardManager.touchMove(5);
        slidingTilesBoardManager.touchMove(6);
        slidingTilesBoardManager.touchMove(2);
        assertEquals(16, slidingTilesBoardManager.getSlidingTilesBoard().getTile(0, 2).getId());
        assertEquals(14, slidingTilesBoardManager.getSlidingTilesBoard().getTile(1, 2).getId());
    }

    /**
     * Test to see if the constructor shuffles properly
     */
    @Test
    public void testConstructor(){
        SlidingTilesBoard.setDifficulty(0);
        slidingTilesBoardManager = new SlidingTilesBoardManager();
        assertFalse(slidingTilesBoardManager.isGameStarted());
    }

    /**
     * Tests the getClicks method
     */
    @Test
    public void testGetClicks(){
        setUpCorrect();
        assertEquals(-1, slidingTilesBoardManager.getClicks());
    }

    /**
     * Tests the setClicks method
     */
    @Test
    public void testSetClicks(){
        setUpCorrect();
        assertEquals(-1, slidingTilesBoardManager.getClicks());
        slidingTilesBoardManager.setClicks(45);
        assertEquals(45, slidingTilesBoardManager.getClicks());
    }
}

