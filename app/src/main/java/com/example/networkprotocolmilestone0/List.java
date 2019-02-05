package com.example.networkprotocolmilestone0;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {
    ListView itemList;
    ArrayAdapter adapter;
    String[] strings={"iphone","android","blackberry","windows","linux"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        itemList=(ListView) findViewById(R.id.listView);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,strings);
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent4 = new Intent(List.this, ThirdWindow.class);
                startActivity(intent4);
            }
        });


    }
}
