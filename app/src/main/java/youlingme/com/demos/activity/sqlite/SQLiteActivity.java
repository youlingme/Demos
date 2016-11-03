package youlingme.com.demos.activity.sqlite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

import youlingme.com.demos.R;

public class SQLiteActivity extends ListActivity {

    private SimpleCursorAdapter adapter;
    private Db db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        db = new Db(this);

        final EditText et_name = (EditText) findViewById(R.id.et_name);
        final EditText et_sex = (EditText) findViewById(R.id.et_sex);
        Button btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(et_name.getText().toString(), et_sex.getText().toString());
            }
        });


        adapter = new CursorAdapter(this, android.R.layout.simple_list_item_1, null, new String[]{"name"}, new int[]{android.R.id.text1});
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(SQLiteActivity.this).setTitle("提醒")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Cursor cursor = adapter.getCursor();
//                                cursor.moveToPosition(position);
                                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                                deleteValues(_id);
                            }
                        }).show();
                return false;
            }
        });

        refreshListView();

    }

    private void insertValues(String name, String sex) {
        SQLiteDatabase writableDatabase = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("sex", sex);
        writableDatabase.insert("user", null, values);
        refreshListView();
    }

    private void deleteValues(int id) {
        SQLiteDatabase writableDatabase = db.getWritableDatabase();
        writableDatabase.delete("user", "_id=?", new String[]{id + ""});
        refreshListView();
    }

    private void refreshListView(){
        SQLiteDatabase readableDatabase = db.getReadableDatabase();
        cursor = readableDatabase.query("user", null, null, null, null, null, null);
        adapter.changeCursor(cursor);
    }



}
