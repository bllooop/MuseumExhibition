package com.example.museumrouteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.museumrouteapp.Presentation.Repository.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository.init(getApplication());
    }
}