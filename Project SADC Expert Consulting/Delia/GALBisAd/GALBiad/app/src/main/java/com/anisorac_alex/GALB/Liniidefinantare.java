package com.anisorac_alex.GALB;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.FileInputStream;

public class Liniidefinantare extends AppCompatActivity {


    private ImageButton btn;
    private PDFView pdfview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_liniidefinantare);
        pdfview=(PDFView)findViewById(R.id.pdf);
        btn = (ImageButton) findViewById(R.id.imageButton);
        if (bundle != null) {
            String string = bundle.getString("linie").toString();
            if (string.equals("00 V3 Introducere"))
                pdfview.fromAsset("00 V3 INTRODUCERE.pdf").load();
             else if (string.equals("01 V3 Capitolul 1"))
                pdfview.fromAsset("01 V3 CAPITOLUL I.pdf").load();
            else if(string.equals("02 V3 Cap.II BN"))
                pdfview.fromAsset("02 V3 Cap.II BN.pdf").load();
            else if(string.equals("03 V3 Capitolul III-SWOT"))
                pdfview.fromAsset("03 V3 CAPITOLUL III-SWOT.pdf").load();
            else if(string.equals("04 V3 Capitolul IV obiective-prioritati"))
                pdfview.fromAsset("04 V3 Capitolul IV obiective-prioritati.pdf").load();
            else if(string.equals("05 V3 M3.1-cu track"))
                pdfview.fromAsset("05 V3 M3.1-cu track.pdf").load();
            else if(string.equals("05 V3 M6.1-cu track"))
                pdfview.fromAsset("05 V3 M6.1-cu track.pdf").load();
            else if(string.equals("05 V3 M6.2-cu track"))
                pdfview.fromAsset("05 V3 M6.2-cu track.pdf").load();
            else if(string.equals("05 V3 M6.3-cu track"))
                pdfview.fromAsset("05 V3 M6.3-cu track.pdf").load();
            else if(string.equals("05 V3 M6.4-cu track"))
                pdfview.fromAsset("05 V3 M6.4-cu track.pdf").load();
            else if(string.equals("05 V3 M6.5-cu track"))
                pdfview.fromAsset("05 V3 M6.5-cu track.pdf").load();
            else if(string.equals("05 V3 M6.6-cu track"))
                pdfview.fromAsset("05 V3 M6.6-cu track.pdf").load();
            else if(string.equals("06 V3 Capitolul VI"))
                pdfview.fromAsset("06 V3 Capitolul VI.pdf").load();
            else if(string.equals("07 V3 Capitolul VII"))
                pdfview.fromAsset("07 V3 Capitolul VII.pdf").load();
            else if(string.equals("08 V3 Cap.VIII Animare BN"))
                pdfview.fromAsset("08 V3 Cap.VIII Animare BN.pdf").load();
            else if(string.equals("09 V3 Capitolul IX-cu track"))
                pdfview.fromAsset("09 V3 CAPITOLUL IX-cu track.pdf").load();
            else if(string.equals("10 V2 Capitolul X"))
                pdfview.fromAsset("10 V2 CAPITOLUL X.pdf").load();
            else if(string.equals("11 V3 Capitolul XI"))
                pdfview.fromAsset("11 V3 CAPITOLUL XI.pdf").load();
            else if(string.equals("12 V3 Capitolul XII"))
                pdfview.fromAsset("12 V3 Capitolul XII.pdf").load();
            else if(string.equals("Anexa 2 Fisa-de-prezentare-a-teritoriului"))
                pdfview.fromAsset("Anexa 2 Fisa-de-prezentare-a-teritoriului.pdf").load();
            else if(string.equals("Anexa 4 Planul-de-finantare dupa bonusare"))
                pdfview.fromAsset("Anexa 4 Planul-de-finantare dupa bonusare.pdf").load();
            else if(string.equals("Anexa 5 Harta Lider Bistrita Nasaud"))
                pdfview.fromAsset("Anexa 5 Harta Lider Bistrita Nasaud.pdf").load();
            else if(string.equals("Anexa 8 Fisa Postului-cu track"))
                pdfview.fromAsset("Anexa 8 Fisa Postului-cu track.pdf").load();
            else if(string.equals("Anexa-1-Modificare-GAL Lider"))
                pdfview.fromAsset("Anexa-1-Modificarea-GAL Lider.pdf").load();
            else
                pdfview.fromAsset("Anexa-3-Componenta-parteneriatului.pdf").load();





        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Liniidefinantare.this, Selectare.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
