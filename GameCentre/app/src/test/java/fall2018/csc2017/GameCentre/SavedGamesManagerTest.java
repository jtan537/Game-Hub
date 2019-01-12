package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.DataManagers.SavedGamesManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoard;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoardManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesTile;

import static org.junit.Assert.*;

public class SavedGamesManagerTest {
    /** The board manager for testing. */
    private SlidingTilesBoardManager slidingTilesBoardManager;
    /** The saved games manager for testing. */
    private SavedGamesManager<SlidingTilesBoardManager> slidingTilesSavedGamesManager = new SavedGamesManager<>();

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
     * Tests that we can correctly save an easy difficulty board manager.
     */
    @Test
    public void testSetSaveEasy(){
        setUpCorrect();
        slidingTilesSavedGamesManager.setSave("Easy", slidingTilesBoardManager);
        SlidingTilesBoardManager testBoardManager = slidingTilesSavedGamesManager.getSave("Easy");
        assertEquals(testBoardManager, slidingTilesBoardManager);
    }

    /**
     * Tests that we can correctly save a medium difficulty board manager.
     */
    @Test
    public void testSetSaveMedium(){
        setUpCorrect();
        slidingTilesSavedGamesManager.setSave("Medium", slidingTilesBoardManager);
        SlidingTilesBoardManager testBoardManager = slidingTilesSavedGamesManager.getSave("Medium");
        assertEquals(testBoardManager, slidingTilesBoardManager);
    }

    /**
     * Tests that we can correctly save a hard difficulty board manager.
     */
    @Test
    public void testSetSaveHard(){
        setUpCorrect();
        slidingTilesSavedGamesManager.setSave("Hard", slidingTilesBoardManager);
        SlidingTilesBoardManager testBoardManager = slidingTilesSavedGamesManager.getSave("Hard");
        assertEquals(testBoardManager, slidingTilesBoardManager);
    }
}
