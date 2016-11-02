package youlingme.com.demos.activity.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import youlingme.com.demos.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_main);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrayAdapter:
                startActivity(new Intent(MainActivity.this, ArrayAdapterActivity.class));
                break;
            case R.id.baseAdapter:
                startActivity(new Intent(MainActivity.this, BaseAdapterActivity.class));
                break;
            case R.id.simpleAdapter:
                startActivity(new Intent(MainActivity.this, SimpleAdapterActivity.class));
                break;
        }
    }
}
