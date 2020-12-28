package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;

import com.example.eggapplication.databinding.ActivityTimerBinding;

public class Timer extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private long timerLeftInMilliSeconds;
    private long timerLeft;
    private boolean timerRunning;
    private ActivityTimerBinding binding;
    private String timerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTimerBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String sook = intent.getStringExtra("sook");

        if (sook.equals("bansook")){
            timerText = "7:30";
            timerLeft =10000; //450000

        } else if (sook.equals("wansook")){
            timerText = "9:00";
            timerLeft =540000;

        }
        binding.countdownText.setText(timerText);


        binding.countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });


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

    public void startStop(){
        if(timerRunning){
            stopTimer();
        } else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timerLeftInMilliSeconds=timerLeft, 1000) {
            private MediaPlayer mediaPlayer;

            @Override
            public void onTick(long l) {
                timerLeftInMilliSeconds=l;
                updateTimer();

            }

            @Override
            public void onFinish() {
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(1000);
                mediaPlayer = MediaPlayer.create(Timer.this, R.raw.alarm2);
                mediaPlayer.start();
            }
        }.start();

        binding.countdownButton.setText("RESET");
        timerRunning=true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        binding.countdownText.setText(timerText);
        timerLeftInMilliSeconds=timerLeft;
        binding.countdownButton.setText("START");
        timerRunning=false;
    }

    public void updateTimer(){
        int minutes=(int)timerLeftInMilliSeconds/60000;
        int seconds=(int) timerLeftInMilliSeconds%60000/1000;

        String timeLeftText;
        timeLeftText=""+minutes;
        timeLeftText+=":";
        if(seconds<10) timeLeftText+="0";
        timeLeftText+=seconds;
        binding.countdownText.setText(timeLeftText);

    }
}
