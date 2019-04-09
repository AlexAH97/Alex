package com.anisorac_alex.GALB;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class MainChatActivity extends AppCompatActivity {


    private EditText searchText;
    private ListView mChatListView;
    private EditText mInputText;
    private ImageButton mSendButton;
    private CharListAdapter adapter;
   private  DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
    private ImageButton linie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        linie=(ImageButton)findViewById(R.id.Liniedefinant);
        mInputText = (EditText) findViewById(R.id.messageInput);
        mSendButton = (ImageButton) findViewById(R.id.sendButton);
        mChatListView = (ListView) findViewById(R.id.chat_list_view);
        searchText=(EditText)findViewById(R.id.search);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        linie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(MainChatActivity.this,Selectare.class);
                finish();
                startActivity(intent);
            }
        });
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }




    private void sendMessage() {

      String txt=mInputText.getText().toString();
        if(!txt.equals(""))
        {
            Date date =new Date();
            CharSequence s = DateFormat.format("dd MM yyyy",date.getTime());
            String string;
            string=s.toString();
            MesajInstant msj=new MesajInstant(string,txt);
            reference.child("Anunt").push().setValue(msj);
            mInputText.setText("");
        }



    }



    @Override
    public void onStart()
    {
        super.onStart();
        adapter=new CharListAdapter(this,reference,"");
        mChatListView.setAdapter(adapter);


    }

    @Override
    public void onStop() {
        super.onStop();

        adapter.cleaner();
    }

}
