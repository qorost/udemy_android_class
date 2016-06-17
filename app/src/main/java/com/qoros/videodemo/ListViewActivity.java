package com.qoros.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        ListView myListView = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> myFamily = new ArrayList<String>();
        //= new ArrayList<String>(asList("a","b","c"));

        myFamily.add("Huang");
        myFamily.add("Chen");
        myFamily.add("Qoros");
        myFamily.add("Dream");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //parent.setVisi
                Log.i("Person tapped",myFamily.get(position));
            }
        });

    }
}
