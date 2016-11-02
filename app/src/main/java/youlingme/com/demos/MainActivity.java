package youlingme.com.demos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import youlingme.com.demos.bean.Bean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new Adapter(this, R.layout.item_text, getData()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, ((Bean)listView.getAdapter().getItem(position)).getIntentClass()));
            }
        });
    }

    private ArrayList<Bean> getData() {
        ArrayList<Bean> myStringArray = new ArrayList<>();

        myStringArray.add(new Bean("ListView", youlingme.com.demos.activity.listview.MainActivity.class));
        myStringArray.add(new Bean("Service", youlingme.com.demos.activity.service.MainActivity.class));

        return myStringArray;
    }

    private class Adapter extends ArrayAdapter<Bean> {

        private final Context context;

        private final int resourceId;

        public Adapter(Context context, int resourceId, ArrayList<Bean> data) {
            super(context, resourceId, data);
            this.context = context;
            this.resourceId = resourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(resourceId, null);
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(getItem(position).getName());
            return convertView;
        }
    }

}
