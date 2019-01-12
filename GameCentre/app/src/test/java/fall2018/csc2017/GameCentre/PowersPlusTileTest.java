package fall2018.csc2017.GameCentre;

import org.junit.Test;

import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusTile;

import static org.junit.Assert.*;

/**
 * Tests the PowersPlusTile class for the PowersPlus game.
 */
public class PowersPlusTileTest {

    /**
     * Tests the getter for the value of the Tile.
     */
    @Test
    public void testGetValue() {
        int value = 16;
        int power = 2;
        PowersPlusTile tile = new PowersPlusTile(value, power);
        int newValue = tile.getValue();
        assertEquals(".getValue() not returning the correct value.", value, newValue);
    }

    /**
     * Tests the getter for the power of the Tile.
     */
    @Test
    public void testGetPower() {
        int value = 64;
        int power = 4;
        PowersPlusTile tile = new PowersPlusTile(value, power);
        int newPower = tile.getPower();
        assertEquals(".getPower() not returning the correct value.", power, newPower);
    }

    /**
     * Tests the setIsMerged() method for the Tile.
     */
    @Test
    public void testSetIsMerged() {
        int value = 81;
        int power = 3;
        PowersPlusTile tile1 = new PowersPlusTile(value, power);
        tile1.setIsMerged(true); // Makes the Tile merged
        boolean actual = tile1.isMerged();//tile1.canMerge(tile2); // Should not be able to merge.
        assertTrue("Does not return the collect value for isMerged", actual);
    }

    /**
     * Tests the setIsMerged() method for the Tile.
     */
    @Test
    public void testCanMerged() {
        int value = 81;
        int power = 3;
        PowersPlusTile tile1 = new PowersPlusTile(value, power);
        PowersPlusTile tile2 = new PowersPlusTile(value, power);

        boolean actual;

        actual = tile1.canMerge(tile2); // Can merge together because both have not been merged.
        assertTrue("Two tiles of same value/base should merge if they" +
                " have not already merged.", actual);

        tile1.setIsMerged(true); // Makes the Tile merged
        actual = tile1.canMerge(tile2); // Should not be able to merge.
        assertFalse("Tiles with same value/base should not be able to merge" +
                " if they have already been merged.", actual);
    }

    /**
     * Tests the merge method for the Tile.
     */
    @Test
    public void testMerge() {
        int value = 64;
        int power = 2;
        PowersPlusTile tile1 = new PowersPlusTile(value, power);
        PowersPlusTile tile2 = new PowersPlusTile(value, power);
        int expected;
        int actual;

        //tile1.merge(tile2);
        expected = 128;
        actual = tile1.merge(tile2);
        assertEquals("Value should be multiplied by base if tiles merge.",
                expected, actual);

        actual = tile1.getPower();
        assertEquals("Power should not be changed after merge.",
                power, actual);

        tile2 = new PowersPlusTile(128, 3);
        actual = tile1.merge(tile2);
        assertEquals("Should return -1 if the merge method is called on " +
                "non-merge-able tiles", actual, -1);
    }

    /**
     * Tests the equals method for the Tile.
     */
    @Test
    public void testEquals() {
        PowersPlusTile item1 = new PowersPlusTile(256, 4);
        PowersPlusTile item2 = new PowersPlusTile(256, 4);

        assertEquals("Same tile should be equal to itself.", item1, item1);
        assertNotEquals("Tile should not equal to null", item1, null);
        assertNotEquals("Tile should not be equal to a random object.", item1, 3);
        assertEquals("Tile should be equal with same value, power, and merge.", item1, item2);

    }
}
