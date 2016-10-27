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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import youlingme.com.demos.R;

public class ArrayAdapterActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<String>();

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


        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());

        final MyArrayAdapter<String> arrayAdapter = new MyArrayAdapter<>(this, R.layout.item_btn_tv, getData());

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayAdapterActivity.this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<String> getData() {
        list.add("180平米的房子");
        list.add("一个勤劳漂亮的老婆");
        list.add("一辆宝马");
        list.add("一个强壮且永不生病的身体");
        list.add("一个喜欢的事业");
        return list;
    }

    private class MyArrayAdapter<String> extends ArrayAdapter<String> {

        private Context context;
        private int resourceId;

        public MyArrayAdapter(Context context, int resourceId, ArrayList<String> list) {
            super(context, resourceId, list);
            this.context = context;
            this.resourceId = resourceId;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(resourceId, null);
                holder.btn = (Button) convertView.findViewById(R.id.btn);
                holder.tv = (TextView) convertView.findViewById(R.id.tv);
                //将holder绑定到convertView上
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            //向viewholder填充数据
            holder.btn.setText((CharSequence) getItem(position));
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ArrayAdapterActivity.this, "Button:" + (CharSequence) getItem(position), Toast.LENGTH_SHORT).show();
                }
            });

            holder.tv.setText((CharSequence) getItem(position));

            return convertView;
        }

        /**
         * ViewHolder类用以存储item中的引用
         */
        final class ViewHolder {
            Button btn;
            TextView tv;
        }

    }


}
