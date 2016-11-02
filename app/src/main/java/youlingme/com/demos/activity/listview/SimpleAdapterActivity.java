package youlingme.com.demos.activity.listview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import youlingme.com.demos.R;

public class SimpleAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listview);

        String[] from = {"img", "title"};
        int[] to = {R.id.img, R.id.tv};

        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.item_btn_tv, from, to);
        listView.setAdapter(adapter);

    }

    private List<HashMap<String, Object>> getData() {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i=0; i<5; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("img", R.drawable.ic_launcher);
            hashMap.put("title", "title:" + i);
            list.add(hashMap);
        }
        return list;
    }

}
