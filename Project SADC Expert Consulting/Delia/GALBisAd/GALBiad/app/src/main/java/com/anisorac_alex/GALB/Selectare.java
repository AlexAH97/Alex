package com.anisorac_alex.GALB;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Selectare extends AppCompatActivity {

    private ImageButton backButton;
    private ListView listefinantare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectare);

        backButton=(ImageButton)findViewById(R.id.backbutton);
        listefinantare=(ListView)findViewById(R.id.listaview);

        ArrayAdapter<String> adaptor=new ArrayAdapter<String>(Selectare.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.finantare));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Selectare.this,MainChatActivity.class);
                finish();
                startActivity(intent);
            }
        });

        listefinantare.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(Selectare.this,Liniidefinantare.class);
                finish();
                intent.putExtra("linie",listefinantare.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });


        listefinantare.setAdapter(adaptor);
    }
}
