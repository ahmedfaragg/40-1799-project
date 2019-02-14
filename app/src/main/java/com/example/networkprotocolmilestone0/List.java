package com.example.networkprotocolmilestone0;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class List extends AppCompatActivity {
    ListView itemList;
    ArrayAdapter adapter;
    String[] Names={"iphone","android","blackberry","windows","linux"};
    int[] Images = {R.drawable.ios,R.drawable.android,R.drawable.blackberry,R.drawable.windows,R.drawable.linux};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        itemList=(ListView) findViewById(R.id.listView);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Names);
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent4 = new Intent(List.this, ThirdWindow.class);
                startActivity(intent4);
            }
        });
        CustomAdapter customAdapter=new CustomAdapter();
        itemList.setAdapter(customAdapter);
//        ImageView myImageView1=(ImageView) findViewById(R.id.imageView);
//        myImageView1.setImageResource(R.drawable.ios);
//        ImageView myImageView=(ImageView) findViewById(R.id.imageView);
//        myImageView.setImageResource(R.drawable.android);
//        ImageView myImageView2=(ImageView) findViewById(R.id.imageView);
//        myImageView2.setImageResource(R.drawable.blackberry);
//        ImageView myImageView3=(ImageView) findViewById(R.id.imageView);
//        myImageView3.setImageResource(R.drawable.windows);
//        ImageView myImageView4=(ImageView) findViewById(R.id.imageView);
//        myImageView4.setImageResource(R.drawable.linux);

    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view=getLayoutInflater().inflate(R.layout.customslayout,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name;

            //error yesterday
            textView_name = (TextView) view.findViewById(R.id.textView);
            imageView.setImageResource(Images[position]);
            textView_name.setText(Names[position]);
            return view;
        }
    }
}
