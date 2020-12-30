package com.example.eggapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;

import com.example.eggapplication.databinding.ActivityTimerBinding;

public class Timer extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private long timerLeftInMilliSeconds;
    private long timerLeft =10000; //450000*/;
    private boolean timerRunning  = false;
    private ActivityTimerBinding binding;
    private String timerText =  "7:30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTimerBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String sook = intent.getStringExtra("sook");

        Long time = PreferencesUtil.getLongPreferences(this, "time");
        String timelefttext=PreferencesUtil.getPreferences(this,"timetext");


        if (sook.equals("bansook")){/*
            timerText = "7:30";
            timerLeft =10000; //450000*/

            timerLeft= time;
            timerText = timelefttext;

        }/* else if (sook.equals("wansook")){
            timerText = "9:00";
            timerLeft =540000;

        }*/
        binding.countdownText.setText(timerText);
        binding.countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
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
        long count =timerLeft;

        if(PreferencesUtil.getBoolPreferences(this,"timerRunning") == true){
            count = PreferencesUtil.getLongPreferences(this,"time");
        }
        countDownTimer = new CountDownTimer(timerLeftInMilliSeconds = count, 1000) {
            private MediaPlayer mediaPlayer;

            @Override
            public void onTick(long l) {
                timerLeftInMilliSeconds = l;
                updateTimer();

            }

            @Override
            public void onFinish() {
                Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(1000);
                mediaPlayer = MediaPlayer.create(Timer.this, R.raw.alarm2);
                mediaPlayer.start();
            }
        }.start();


        binding.countdownButton.setText("RESET");

        timerRunning=true;
        PreferencesUtil.setBoolPreferences(this,"timerRunning",true);
    }

    public void stopTimer(){
        countDownTimer.cancel();
        binding.countdownText.setText(timerText);
        timerLeftInMilliSeconds=timerLeft;
        binding.countdownButton.setText("START");
        timerRunning=false;
        PreferencesUtil.setBoolPreferences(this,"timerRunning",false);
    }

    public void updateTimer(){

        PreferencesUtil.setLongPreferences(this,"time", timerLeft);
        PreferencesUtil.setBoolPreferences(this,"timerRunning",true);

        int minutes=(int)timerLeftInMilliSeconds/60000;
        int seconds=(int) timerLeftInMilliSeconds%60000/1000;

        String timeLeftText;
        timeLeftText=""+minutes;
        timeLeftText+=":";
        if(seconds<10) timeLeftText+="0";
        timeLeftText+=seconds;

        PreferencesUtil.setPreferences(this,"timetext",timeLeftText);

        binding.countdownText.setText(timeLeftText);

    }
}

