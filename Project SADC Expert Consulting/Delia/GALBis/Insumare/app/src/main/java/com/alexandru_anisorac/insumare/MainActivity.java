package com.alexandru_anisorac.insumare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button Sum;
    private EditText n1,n2;
    private TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sum =(Button)findViewById(R.id.button);
        n1 = (EditText)findViewById(R.id.editText);
        n2 = (EditText)findViewById(R.id.editText2);
        txtView = (TextView)findViewById(R.id.textView3);
        Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1,number2;
                number1=Integer.parseInt(n1.getText().toString());
                number2=Integer.parseInt(n2.getText().toString());
                txtView.setText(String.valueOf(number1+number2));
            }
        });
    }
}
