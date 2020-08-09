package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eggapplication.databinding.ActivityTimerBinding;

public class Timer extends AppCompatActivity {

    private ActivityTimerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTimerBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String sook = intent.getStringExtra("sook");

        Timer timer = new Timer();

        if (sook.equals("ban")){

        }

        binding.text.setText(sook);

        binding.btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Timer.this , Start.class );
                startActivity(intent); //액티비티 이동
            }
        });

        binding.btnReady.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Timer.this , Ready.class );
                startActivity(intent); //액티비티 이동
            }
        });

    }
}
