package com.anisorac_alex.GALBi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import static android.R.id.list;

public class Selectare extends AppCompatActivity {

    private ListView listview;
    private ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectare);
        btn=(ImageButton)findViewById(R.id.BackButton);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Selectare.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.linii_de_finantare));
        listview=(ListView)findViewById(R.id.lista);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Selectare.this,Liniidefinantare.class);
                finish();
                intent.putExtra("linie",listview.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });

        listview.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Selectare.this,MainChatActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }



}


