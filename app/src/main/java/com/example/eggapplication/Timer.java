package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    private TextView text;

    private Button btn_start;
    private Button btn_ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        findViewById(R.id.timer_page);

        text = findViewById(R.id.text);

        Intent intent = getIntent();
        String sook = intent.getStringExtra("sook");

        text.setText(sook);

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Timer.this , Start.class );
                startActivity(intent); //액티비티 이동
            }
        });

        btn_ready.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Timer.this , Ready.class );
                startActivity(intent); //액티비티 이동
            }
        });

    }
}
