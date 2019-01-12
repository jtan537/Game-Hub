package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.DataManagers.StateManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoard;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoardManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesTile;

import static org.junit.Assert.*;

/**
 * Tests the StateManager class using a sliding tiles game
 */
public class StateManagerTest {

    /** The board manager for testing. */
    private SlidingTilesBoardManager slidingTilesBoardManager;
    /** The state manager for testing. */
    private StateManager<List> stateManager = new StateManager<>();

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
     * Make a solved SlidingTilesBoard.
     */
    private void setUpCorrect() {
        SlidingTilesBoard.setDifficulty(0);
        List<SlidingTilesTile> slidingTilesTiles = makeTiles(SlidingTilesBoard.getNumRows(), SlidingTilesBoard.getNumCols());
        SlidingTilesBoard slidingTilesBoard = new SlidingTilesBoard(slidingTilesTiles);
        slidingTilesBoardManager = new SlidingTilesBoardManager(slidingTilesBoard);
    }

    /**
     * Saves a a state.
     */
    private void getTileList(){
        stateManager.save(slidingTilesBoardManager.getSlidingTilesBoard().getSlidingTilesTiles());
    }

    /**
     * Test that undoing from a game where there was at least one move, can undo.
     */
    @Test
    public void testIsNotEmpty(){
        setUpCorrect();
        getTileList();
        assertNotEquals(null, stateManager.undo());
    }

    /**
     * Test that undoing from a game where no moves were made, can't undo.
     */
    @Test
    public void testIsEmpty(){
        setUpCorrect();
        assertNull(stateManager.undo());
    }
}
