package fall2018.csc2017.GameCentre.PowersPlus;

/*
Taken from:
https://github.com/DaveNOTDavid/sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/CustomAdapter.java

This Class is an overwrite of the Base Adapter class
It is designed to aid setting the textView sizes and positions in the GridView
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The adapter that allows the PowersPlus board to be displayed.
 */
public class PowersPlusAdapter extends BaseAdapter {
    private ArrayList<TextView> mTextViews;
    private int mColumnWidth, mColumnHeight;

    /**
     * Constructs the Adapter.
     *
     * @param textViews:    what TextViews to update in the GridView.
     * @param columnWidth:  each column's width.
     * @param columnHeight: each column's height.
     */
    PowersPlusAdapter(ArrayList<TextView> textViews, int columnWidth, int columnHeight) {
        mTextViews = textViews;
        mColumnWidth = columnWidth;
        mColumnHeight = columnHeight;
    }

    /**
     * Gets the number of elements in the GridView.
     *
     * @return int: the number of elements.
     */
    @Override
    public int getCount() {
        return mTextViews.size();
    }

    /**
     * Returns any item given a specified position.
     *
     * @param position: the position to get the desired item.
     * @return Object: the item to return at that position.
     */
    @Override
    public Object getItem(int position) {
        return mTextViews.get(position);
    }

    /**
     * Gets the items ID number given a specified position.
     *
     * @param position: the position to get the item id.
     * @return long: the desired item ID.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Constructs the view for each cell of the grid view.
     *
     * @param position:    the position of the cell.
     * @param convertView: given view to convert to TextView.
     * @param parent:      the parent object of the View.
     * @return View: the desired view of the cell.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textview;

        if (convertView == null) {
            textview = mTextViews.get(position);
        } else {
            textview = (TextView) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(mColumnWidth, mColumnHeight);
        textview.setLayoutParams(params);

        return textview;
    }
}

