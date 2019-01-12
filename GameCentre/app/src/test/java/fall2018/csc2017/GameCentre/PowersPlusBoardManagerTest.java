package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusBoardManager;
import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusBoard;
import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusTile;

import static org.junit.Assert.*;

/**
 * Tests the PowerPlusBoardManager for the PowersPlus game.
 */
public class PowersPlusBoardManagerTest {

    private PowersPlusBoard powersPlusTiles;
    private PowersPlusBoardManager powersPlusBoardManager;

    /**
     * Generates an example board for testing.
     */
    private void setUpTiles() {
        List<PowersPlusTile> tiles = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (row == 0) {
                    tiles.add(null); // no tiles for first row.
                } else if (row < 3) {
                    tiles.add(new PowersPlusTile(2, 2)); // 2's on second/third row.
                } else {
                    tiles.add(new PowersPlusTile(4, 2)); // 4's on last row.
                }
            }
        }
        powersPlusTiles = new PowersPlusBoard(tiles);
    }

    /**
     * Generates a null element board for testing.
     */
    private void setUpBaseTiles() {
        List<PowersPlusTile> tiles = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            tiles.add(new PowersPlusTile(2, 2));
        }
        powersPlusTiles = new PowersPlusBoard(tiles);
    }

    /**
     * Tests the getBase() method.
     */
    @Test
    public void testGetBase() {
        setUpTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,3,8,0,new ArrayList<Integer>());
        assertEquals("PowersPlusBoardManager should return the same base as initialized.",
                2, powersPlusBoardManager.getBase());
    }

    /**
     * Tests the getPower() method.
     */
    @Test
    public void testGetPower() {
        setUpTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 0, new ArrayList<Integer>());
        assertEquals("PowersPlusBoardManager should return the same power as initialized.",
                3, powersPlusBoardManager.getPower());
    }

    /**
     * Tests the getHighestPower() method.
     */
    @Test
    public void testGetHighestPower() {
        setUpTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 0, new ArrayList<Integer>());
        assertEquals("PowersPlusBoardManager should have a highest power of 1 on " +
                "initialization", 1, powersPlusBoardManager.getHighestPower());
        powersPlusBoardManager.doMoveDown();
        assertEquals("PowersPlusBoardManager should hold the highest merged value " +
                "power on a move.", 2, powersPlusBoardManager.getHighestPower());
        powersPlusBoardManager.doMoveDown();
        assertEquals("PowersPlusBoardManager should hold the highest merged value " +
                "power on a move.", 3, powersPlusBoardManager.getHighestPower());
    }

    /**
     * Tests the getCurrentScore() method.
     */
    @Test
    public void testGetCurrentScore() {
        setUpTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 44, new ArrayList<Integer>());
        assertEquals("PowersPlusBoardManager should return the correct current score.",
                44, powersPlusBoardManager.getCurrentScore());
    }

    /**
     * Tests the getHighestValue() method.
     */
    @Test
    public void testGetHighestValue() {
        setUpTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 44, new ArrayList<Integer>());
        powersPlusBoardManager.setHighestValue(1024);
        assertEquals("PowersPlusBoardManager should return the correct highest value.",
                10, powersPlusBoardManager.getHighestPower());
    }

    /**
     * Tests the isGameOver() method.
     */
    @Test
    public void testIsGameOver() {
        setUpTiles();

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 44, new ArrayList<Integer>());
        assertFalse("Game should not be over on initialization",
                powersPlusBoardManager.isGameOver());

        powersPlusBoardManager = new PowersPlusBoardManager();
        assertFalse("Game should not be over on initialization",
                powersPlusBoardManager.isGameOver());
    }

    /**
     * Tests the isWin() method.
     */
    @Test
    public void testIsWin() {
        setUpTiles();

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 3, 8, 44, new ArrayList<Integer>());
        assertFalse("Game should not be won on initialization",
                powersPlusBoardManager.isWin());

        powersPlusBoardManager = new PowersPlusBoardManager();
        assertFalse("Game should not be won on initialization",
                powersPlusBoardManager.isWin());
    }

    /**
     * Tests the getter and setter for the powersDifficulty field.
     */
    @Test
    public void testSetPowersDifficulty() {
        setUpTiles();

        int diff = 1;
        PowersPlusBoardManager.setDifficulty(diff);
        assertEquals("PowersPlusBoardManager should set and get the same difficulty.",
                diff, PowersPlusBoardManager.getPowersDifficulty());
    }

    /**
     * Tests the getter for the PowersPlusBoard.
     */
    @Test
    public void testGetBoard() {
        setUpTiles();

        PowersPlusBoard copy = powersPlusTiles;
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 1, 2, 0, new ArrayList<Integer>());
        assertEquals("The manager should return an equal board given to it.",
                copy, powersPlusBoardManager.getBoard());
    }

    /**
     * Tests the decrease score for the PowersPlusBoardManager.
     */
    @Test
    public void testDecreaseValues() {
        setUpTiles();

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(40);
        scores.add(20);
        scores.add(10);
        int score = 70;

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 1, 2, score, scores);

        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should return the current score minus the last" +
                "score achieved.", 60, powersPlusBoardManager.getCurrentScore());
        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should return the current score minus the last" +
                "score achieved.", 40, powersPlusBoardManager.getCurrentScore());
        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should return the current score minus the last" +
                "score achieved.", 0, powersPlusBoardManager.getCurrentScore());
        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should not go past 0 elements",
                0, powersPlusBoardManager.getCurrentScore());

        setUpBaseTiles();
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2, 1, 2, score, scores);
        powersPlusBoardManager.setHighestValue(4);
        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should change highest power to 1.",
                1, powersPlusBoardManager.getHighestPower());
        powersPlusBoardManager.decreaseValues();
        assertEquals("decreaseValues() should keep the highest power to 1.",
                1, powersPlusBoardManager.getHighestPower());
    }

    /**
     * Tests the move up method of the game.
     */
    @Test
    public void testMoveUp() {
        setUpTiles();
        List<PowersPlusTile> moveUp = new ArrayList<>();

        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));

        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));
        moveUp.add(new PowersPlusTile(4,2));

        moveUp.add(null);
        moveUp.add(null);
        moveUp.add(null);
        moveUp.add(null);

        moveUp.add(null);
        moveUp.add(null);
        moveUp.add(null);
        moveUp.add(null);

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,10,1024,0, new ArrayList<Integer>());
        powersPlusBoardManager.doMoveUp();

        boolean isEqual = true;
        List<PowersPlusTile> movedBoard = powersPlusBoardManager.getBoard().getPowersPlusTiles();
        for (int i = 0; i < 8; i++) {
            if(movedBoard.get(i) == null || !movedBoard.get(i).equals(moveUp.get(i))) {
                isEqual = false;
            }
        }
        assertTrue("The manager should move the board up as defined " +
                "excluding random tiles generated.", isEqual);
    }

    /**
     * Tests the move down method of the game.
     */
    @Test
    public void testMoveDown() {
        setUpTiles();
        List<PowersPlusTile> moveDown = new ArrayList<>();

        moveDown.add(null);
        moveDown.add(null);
        moveDown.add(null);
        moveDown.add(null);

        moveDown.add(null);
        moveDown.add(null);
        moveDown.add(null);
        moveDown.add(null);

        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));

        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));
        moveDown.add(new PowersPlusTile(4,2));

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,10,1024,0, new ArrayList<Integer>());
        powersPlusBoardManager.doMoveDown();

        boolean isEqual = true;
        List<PowersPlusTile> movedBoard = powersPlusBoardManager.getBoard().getPowersPlusTiles();
        for (int i = 8; i < 16; i++) {
            if(movedBoard.get(i) == null || !movedBoard.get(i).equals(moveDown.get(i))) {
                isEqual = false;
            }
        }
        assertTrue("The manager should move the board down as defined " +
                "excluding random tiles generated.", isEqual);
    }

    /**
     * Tests the move left method of the game.
     */
    @Test
    public void testMoveLeft() {
        setUpTiles();
        List<PowersPlusTile> moveLeft = new ArrayList<>();

        moveLeft.add(null);
        moveLeft.add(null);
        moveLeft.add(null);
        moveLeft.add(null);

        moveLeft.add(new PowersPlusTile(4,2));
        moveLeft.add(new PowersPlusTile(4,2));
        moveLeft.add(null);
        moveLeft.add(null);

        moveLeft.add(new PowersPlusTile(4,2));
        moveLeft.add(new PowersPlusTile(4,2));
        moveLeft.add(null);
        moveLeft.add(null);

        moveLeft.add(new PowersPlusTile(8,2));
        moveLeft.add(new PowersPlusTile(8,2));
        moveLeft.add(null);
        moveLeft.add(null);

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,10,1024,0, new ArrayList<Integer>());
        powersPlusBoardManager.doMoveLeft();

        boolean isEqual = true;
        List<PowersPlusTile> movedBoard = powersPlusBoardManager.getBoard().getPowersPlusTiles();
        for (int i = 1; i < 4; i++) {
            if(movedBoard.get(4 * i) == null ||
                    !movedBoard.get(4 * i).equals(moveLeft.get(4 * i + 1)) ||
                    !movedBoard.get(4 * i).equals(moveLeft.get(4 * i + 1))) {
                isEqual = false;
            }
        }
        assertTrue("The manager should move the board left as defined " +
                "excluding random tiles generated.", isEqual);
    }

    /**
     * Tests the move left method of the game.
     */
    @Test
    public void testMoveRightAndGameOver() {
        setUpTiles();
        List<PowersPlusTile> moveRight = new ArrayList<>();

        moveRight.add(null);
        moveRight.add(null);
        moveRight.add(null);
        moveRight.add(null);

        moveRight.add(null);
        moveRight.add(null);
        moveRight.add(new PowersPlusTile(4,2));
        moveRight.add(new PowersPlusTile(4,2));

        moveRight.add(null);
        moveRight.add(null);
        moveRight.add(new PowersPlusTile(4,2));
        moveRight.add(new PowersPlusTile(4,2));

        moveRight.add(null);
        moveRight.add(null);
        moveRight.add(new PowersPlusTile(8,2));
        moveRight.add(new PowersPlusTile(8,2));

        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,3,8,0, new ArrayList<Integer>());
        powersPlusBoardManager.doMoveRight();

        boolean isEqual = true;
        List<PowersPlusTile> movedBoard = powersPlusBoardManager.getBoard().getPowersPlusTiles();
        for (int i = 1; i < 4; i++) {
            if(movedBoard.get(4 * i + 2) == null ||
                    !movedBoard.get(4 * i + 2).equals(moveRight.get(4 * i + 3)) ||
                    !movedBoard.get(4 * i + 2).equals(moveRight.get(4 * i + 3))) {
                isEqual = false;
            }
        }
        assertTrue("The manager should move the board right as defined " +
                "excluding random tiles generated.", isEqual);
        assertTrue("The game should be over as the player reached the" +
                "target of 8.", powersPlusBoardManager.isGameOver());
        assertTrue("The game has been won since the player reached the" +
                "highest tile.", powersPlusBoardManager.isWin());

    }

    /**
     * Tests when the player has lost the game. The board is full.
     */
    @Test
    public void testGameOverLost() {
        ArrayList<PowersPlusTile> lostTiles = new ArrayList<>();

        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(16,2));
        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(4,2));

        lostTiles.add(new PowersPlusTile(2,2));
        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(2,2));
        lostTiles.add(new PowersPlusTile(4,2));

        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(2,2));
        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(2,2));

        lostTiles.add(new PowersPlusTile(2,2));
        lostTiles.add(new PowersPlusTile(4,2));
        lostTiles.add(new PowersPlusTile(2,2));
        lostTiles.add(new PowersPlusTile(4,2));

        powersPlusTiles = new PowersPlusBoard(lostTiles);
        powersPlusBoardManager = new PowersPlusBoardManager(powersPlusTiles,
                2,3,1024,0, new ArrayList<Integer>());
        powersPlusBoardManager.doMoveLeft();

        assertFalse("The game should be lost as the player has not reached" +
                "the target (1024) and there are no more possible moves to make.",
                powersPlusBoardManager.isWin());

    }
}
