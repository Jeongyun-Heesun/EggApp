package com.example.eggapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eggapplication.databinding.ActivityReadyBinding;

public class Ready extends AppCompatActivity {
    private ActivityReadyBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadyBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        for(int i=0;i<Egg.READY.length;i++){
            binding.textView.setText(Egg.READY[i]);
        }

        binding.btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Ready.this, Ready.class );
                startActivity(intent); //액티비티 이동
            }
        });

        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Ready.this , Start.class );
                startActivity(intent); //액티비티 이동
            }
        });


    }


}
