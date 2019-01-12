package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusBoard;
import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusTile;

import static org.junit.Assert.*;

/**
 * Tests the PowersPlusBoard class for the PowersPlus game.
 */
public class PowersPlusBoardTest {

    private PowersPlusBoard powersPlusTiles;

    /**
     * Generates an example board for testing. Rows of 2, 4, 8, 16.
     */
    private void setUpTiles() {
        List<PowersPlusTile> tiles = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                tiles.add(new PowersPlusTile((int) Math.pow(2, row + 1), 2));
            }
        }
        powersPlusTiles = new PowersPlusBoard(tiles);
    }

    /**
     * Tests getNumRows() for the board.
     */
    @Test
    public void testGetNumRows() {
        assertEquals("Number of rows should always be 4.", 4,
                PowersPlusBoard.getNumRows());
    }

    /**
     * Tests getNumCols() for the board.
     */
    @Test
    public void testGetNumCols() {
        assertEquals("Number of columns should always be 4.", 4,
                PowersPlusBoard.getNumCols());
    }

    /**
     * Tests getNumTiles() for the board.
     */
    @Test
    public void testGetNumTiles() {
        setUpTiles();
        assertEquals("Number of tiles should always be 16", 16,
                powersPlusTiles.getNumTiles());
    }

    /**
     * Tests the getPowersPlusTiles() for testing and unwanted aliasing.
     */
    @Test
    public void testGetPowersPlusTiles() {
        setUpTiles(); // New board.
        PowersPlusBoard newBoard = new PowersPlusBoard(powersPlusTiles.getPowersPlusTiles());
        assertEquals("getPowersPlusTiles() should return the original list.",
                powersPlusTiles, newBoard);

        List<PowersPlusTile> original = powersPlusTiles.getPowersPlusTiles();
        List<PowersPlusTile> changed = powersPlusTiles.getPowersPlusTiles();
        changed.set(0, null);
        changed.set(3, null);
        PowersPlusBoard originalBoard = new PowersPlusBoard(original);
        PowersPlusBoard changedBoard = new PowersPlusBoard(changed);
        assertNotEquals("getPowersPlusTiles() should return a copy of the original.",
                originalBoard, changedBoard);
    }

    /**
     * Tests to get the PowersPlusTile from the board and wanted aliasing.
     */
    @Test
    public void testGetTile() {
        setUpTiles(); // Fresh new board.
        PowersPlusTile tile = powersPlusTiles.getTile(2, 3); // should be 8
        assertEquals("Should return the tile with same value, isMerged, power",
                new PowersPlusTile(8, 2), tile);

        tile.merge(new PowersPlusTile(8, 2));
        PowersPlusTile other = new PowersPlusTile(16, 2);
        other.setIsMerged(true);
        assertEquals("Should return the tile with same properties as merged tile.",
                other, tile);
    }

    /**
     * Tests the set method for the new PowersPlusTile from the board.
     */
    @Test
    public void testSetTile() {
        setUpTiles(); // Fresh new awesome board.
        PowersPlusTile newTile = new PowersPlusTile(64, 2);
        powersPlusTiles.setTile(1, 1, newTile);
        assertEquals("Should set a new tile at position (1,1)",
                powersPlusTiles.getTile(1, 1), newTile);
    }

    /**
     * Tests the shift Tiles method for proper shifting.
     */
    @Test
    public void testShiftTiles() {
        setUpTiles(); // New board.
        List<PowersPlusTile> newList = powersPlusTiles.getPowersPlusTiles();
        newList.set(0, null);
        powersPlusTiles.shiftTiles(0, 1, 0, 0);
        assertNull("Tile at (0, 1) should be null.",
                powersPlusTiles.getTile(0, 1));
        assertEquals("Tile at (0, 0) should be equal to the tile that was at (0, 1)",
                new PowersPlusTile(2, 2), powersPlusTiles.getTile(0, 0));
    }

    /**
     * Tests the undo method for the board.
     */
    @Test
    public void testUndo() {
        setUpTiles();
        List<PowersPlusTile> undoList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            undoList.add(new PowersPlusTile(2, 2));
        }
        PowersPlusBoard undoBoard = new PowersPlusBoard(undoList);

        powersPlusTiles.undo(undoList);
        assertEquals("The board should undo to a board of all 2's",
                undoBoard, powersPlusTiles);
    }

    /**
     * Tests the equals method for the board.
     */
    @Test
    public void testEquals() {
        setUpTiles(); // New board
        PowersPlusBoard item1 = powersPlusTiles;

        List<PowersPlusTile> newList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            newList.add(new PowersPlusTile(4, 4));
        }
        newList.add(null);
        PowersPlusBoard item2 = new PowersPlusBoard(newList);

        assertEquals("Same tile should be equal to itself.", item1, item1);
        assertNotEquals("Tile should not equal to null", item1, null);
        assertNotEquals("Tile should not be equal to a random object.", item1, 4);
        assertNotEquals("Tile should be equal with same value, power, and merge.", item1, item2);
    }

    /**
     * Tests the iterator for the board.
     */
    @Test
    public void testPowersPlusBoardIterator() {
        setUpTiles();
        Iterator<PowersPlusTile> it = powersPlusTiles.iterator();
        List<Boolean> values = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                values.add(powersPlusTiles.getTile(row, col).equals(it.next()));
            }
        }
        assertTrue("Iterator should yield the correct next value based on row and column.",
                !values.contains(false));
    }

    /**
     * Tests the iterator for the board after no such element exists.
     */
    @Test(expected = NoSuchElementException.class)//IndexOutOfBoundsException.class)
    public void testPowersPlusBoardIteratorHasNext() {
        setUpTiles();
        Iterator<PowersPlusTile> it = powersPlusTiles.iterator();
        for (int i = 0; i < 17; i++) {
            it.next();
        }
    }
}
