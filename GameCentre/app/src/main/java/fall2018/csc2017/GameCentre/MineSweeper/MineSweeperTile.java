package fall2018.csc2017.GameCentre.MineSweeper;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.R;

/**
 * A Tile in a sliding tiles puzzle.
 */
public class MineSweeperTile implements Comparable<MineSweeperTile>, Serializable {

    /**
     * The background id to find the tile image.
     */
    private int background;

    /**
     * The unique id.
     */
    private int id;

    /**
     * The list contains information about background
     */
    private List<Integer> tileList = new ArrayList<>();

    /**
     * Get the value of if the tile is opened or not.
     *
     * @return boolean representing isNotOpened tile.
     */
    public boolean isNotOpened() {
        return !this.isOpened;
    }

    /**
     * Set the tile to be opened.
     *
     */
    void setOpened() {
        this.isOpened = true;
    }

    /**
     * Determines if the tile is opened or not
     */
    private boolean isOpened;

    /**
     * Set the background value as given value, following such rule:
     * -1: has a bomb on it
     * 0-8: number of bombs adjacent to this tile
     *
     * @param backgroundValue the value given to be set
     */
    public void setBackgroundValue(int backgroundValue) {
        this.backgroundValue = backgroundValue;
    }

    /**
     * Set the image according to its background value
     *
     * @param backgroundValue the value representing the condition of this tile.
     */
    public void setBackground(int backgroundValue) {
        background = tileList.get(backgroundValue + 1);
    }

    /**
     * The background value.
     */
    private int backgroundValue;

    /**
     * Get the background value of this tile.
     *
     * @return the background value of this tile
     */
    public int getBackgroundValue() {
        return backgroundValue;
    }

    /**
     * Return the background id.
     *
     * @return the background id
     */
    public int getBackground() {
        return background;
    }

    /**
     * Return the tile id.
     *
     * @return the tile id
     */
    public int getId() {
        return id;
    }

    /**
     * A tile with a background id; look up and set the id.
     *
     * @param backgroundId the id of this tile
     */
    public MineSweeperTile(int backgroundId) {

        //Experimenting with putting drawables in a list
        id = backgroundId + 1;

        tileList.add(R.drawable.minesweeper_mine);
        tileList.add(R.drawable.minesweeper_0);
        tileList.add(R.drawable.minesweeper_1);
        tileList.add(R.drawable.minesweeper_2);
        tileList.add(R.drawable.minesweeper_3);
        tileList.add(R.drawable.minesweeper_4);
        tileList.add(R.drawable.minesweeper_5);
        tileList.add(R.drawable.minesweeper_6);
        tileList.add(R.drawable.minesweeper_7);
        tileList.add(R.drawable.minesweeper_8);
        tileList.add(R.drawable.minesweeper_unopened);

        //Initialize the tile to a closed tile
        background = tileList.get(10);
        this.backgroundValue = 0;
        this.isOpened = false;
    }

    /**
     * Compares the ID of two MineSweeperTiles
     *
     * @param o The other MineSweeperTile object
     * @return Returns the difference of the two ids
     */
    @Override
    public int compareTo(@NonNull MineSweeperTile o) {
        return o.id - this.id;
    }
}
