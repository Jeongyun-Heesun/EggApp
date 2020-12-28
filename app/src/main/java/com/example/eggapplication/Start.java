package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.eggapplication.databinding.ActivityStartBinding;

public class Start extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityStartBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.btnBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Timer.class );
                intent.putExtra("sook","bansook");
                startActivity(intent); //액티비티 이동
            }
        });

        binding.btnWan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Timer.class );
                intent.putExtra("sook","wansook");
                startActivity(intent); //액티비티 이동
            }
        });

        binding.btnReady.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Start.this , Ready.class );
                startActivity(intent); //액티비티 이동
            }
        });
    }
}
