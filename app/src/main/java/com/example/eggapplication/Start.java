package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    private Button btn_wan;
    private Button btn_ban;

    private Button btn_start;
    private Button btn_ready;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        findViewById(R.id.start_page);

        btn_wan = findViewById(R.id.btn_wan);
        btn_ban = findViewById(R.id.btn_ban);

        btn_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Timer.class );
                intent.putExtra("sook","bansook");
                startActivity(intent); //액티비티 이동
            }
        });

        btn_wan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Timer.class );
                intent.putExtra("sook","wansook");
                startActivity(intent); //액티비티 이동
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent( Start.this , Start.class );
                    startActivity(intent); //액티비티 이동
            }
        });

        btn_ready.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Ready.class );
                startActivity(intent); //액티비티 이동
            }
        });
    }
}
