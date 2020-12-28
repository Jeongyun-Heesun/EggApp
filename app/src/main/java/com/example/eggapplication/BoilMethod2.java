package com.example.eggapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BoilMethod2 extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static BoilMethod2 newInstance(int page, String title) {
        BoilMethod2 fragment = new BoilMethod2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boilmethod_2, container, false);
        TextView tvLabel = view.findViewById(R.id.textView);
        //tvLabel.setText(page + " -- " + title);

        tvLabel.setText( "2. 식초와 소금을 넣고 강불로 끓인다.");
        return view;
    }
}