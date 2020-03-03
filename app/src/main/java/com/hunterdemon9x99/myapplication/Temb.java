package com.hunterdemon9x99.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Temb extends AppCompatActivity {
    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temb);
        txt = (TextView) findViewById(R.id.txt);
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("KEY"));
    }
}
