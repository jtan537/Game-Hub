package fall2018.csc2017.GameCentre.UserInterfaces;

/*
Taken from:
https://github.com/DaveNOTDavid/sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/CustomAdapter.java

This Class is an overwrite of the Base Adapter class
It is designed to aid setting the button sizes and positions in the GridView
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A custom adapted used for games that require a special tile button, like slidingtiles
 * and mine sweeper
 */
public class TilesAdapter extends BaseAdapter {

    /**
     * The list of buttons
     */
    private ArrayList<Button> mButtons;

    /**
     * The heights and widths of columns
     */
    private int mColumnWidth, mColumnHeight;

    /**
     * Constructor
     *
     * @param buttons The list of buttons
     * @param columnWidth The width of each column
     * @param columnHeight The height of each column
     */
    public TilesAdapter(ArrayList<Button> buttons, int columnWidth, int columnHeight) {
        mButtons = buttons;
        mColumnWidth = columnWidth;
        mColumnHeight = columnHeight;
    }

    /**
     * Get the total number of buttons
     *
     * @return Returns the number of tiles
     */
    @Override
    public int getCount() {
        return mButtons.size();
    }

    /**
     * Get the item at a specific position
     *
     * @param position The position of the user click
     * @return Return the item at position
     */
    @Override
    public Object getItem(int position) {
        return mButtons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(mColumnWidth, mColumnHeight);
        button.setLayoutParams(params);

        return button;
    }
}