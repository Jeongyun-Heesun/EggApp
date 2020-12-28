package com.example.eggapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eggapplication.databinding.ActivityReadyBinding;
import com.example.eggapplication.databinding.FragmentStartBinding;

import static com.example.eggapplication.databinding.FragmentStartBinding.inflate;


public class Start extends Fragment {

    private FragmentStartBinding binding;

    public static Start newInstance(int page, String title) {
        Start fragment = new Start();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , Timer.class );
                intent.putExtra("sook","bansook");
                startActivity(intent); //액티비티 이동
            }
        });

        binding.btnWan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), Timer.class );
                intent.putExtra("sook","wansook");
                startActivity(intent); //액티비티 이동
            }
        });

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}