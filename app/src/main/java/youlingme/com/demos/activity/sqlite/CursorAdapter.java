package youlingme.com.demos.activity.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

/**
 * Created by wanghan on 16/11/3.
 */
public class CursorAdapter extends SimpleCursorAdapter {

    public CursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

}
