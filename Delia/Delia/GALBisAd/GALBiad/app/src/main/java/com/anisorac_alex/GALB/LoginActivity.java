package com.anisorac_alex.GALB;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mAuth=FirebaseAuth.getInstance();
    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v)   {
        attemptLogin();
    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, com.anisorac_alex.GALB.RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    private void attemptLogin() {


       String mail=mEmailView.getText().toString();
       String parola=mPasswordView.getText().toString();
        mAuth.signInWithEmailAndPassword(mail,parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                  //  Toast.makeText(getApplicationContext(),"Logare....",Toast.LENGTH_SHORT).show();
                    trecere();

                }
                else
                    show();
            }
        });



    }

    private void trecere()
    {
        Intent intent=new Intent(this,MainChatActivity.class);
        finish();
        startActivity(intent);
    }

    private void show()
    {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(android.R.string.ok,null).setMessage("Acest utilizator nu exista sau nu a fost inregistrat cu succes.Va rugam sa va inregistrati din nou").setTitle("Error").show();
    }




}