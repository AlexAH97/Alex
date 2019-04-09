package com.anisorac_alex.GALBi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainChatActivity extends AppCompatActivity {



    private ListView mChatListView;
    private DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
    private ListAdaptor adapter;
    private ImageButton ldfinan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);




        // Link the Views in the layout to the Java code

        mChatListView = (ListView) findViewById(R.id.chat_list_view);
        ldfinan=(ImageButton)findViewById(R.id.Liniidefinantare);

        ldfinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainChatActivity.this,Selectare.class);
                finish();
                startActivity(intent);
            }
        });


    }



    @Override
    public void onStart()
    {
        super.onStart();
        adapter=new ListAdaptor(this,reference);
        mChatListView.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.cleaner();

    }

}
