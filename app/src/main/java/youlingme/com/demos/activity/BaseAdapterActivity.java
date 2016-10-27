package youlingme.com.demos.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import youlingme.com.demos.R;

public class BaseAdapterActivity extends AppCompatActivity {

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
        MyBaseAdapter adapter = new MyBaseAdapter(this, getData());
        listView.setAdapter(adapter);
    }

    private List<HashMap<String,Object>> getData() {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("ItemImage", images[i]);
            map.put("ItemTitle", "This is Title " + i);
            map.put("ItemText", "This is text " + i);
            data.add(map);
        }
        return data;
    }


    private class MyBaseAdapter extends BaseAdapter {

        private final Context context;
        private final List<HashMap<String, Object>> dataList;

        public MyBaseAdapter(Context context, List<HashMap<String, Object>> dataList){
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public HashMap<String, Object> getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            VH viewholder;
            if (convertView == null) {
                viewholder = new VH();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_btn_tv, null);
                viewholder.btn = (Button) convertView.findViewById(R.id.btn);
                viewholder.tv = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(viewholder);
            } else {
                viewholder = (VH) convertView.getTag();
            }

            viewholder.btn.setText((CharSequence) getItem(position).get("ItemTitle"));
            viewholder.tv.setText((CharSequence) getItem(position).get("ItemText"));

            return convertView;
        }

        final class VH{
            Button btn;
            TextView tv;
        }
    }

}

