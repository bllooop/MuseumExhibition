package com.example.museumrouteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.net.Uri;
import android.os.Bundle;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Repository;
import com.example.museumrouteapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        ServiceLocator.getInstance().initBase(getApplication());
        setContentView(R.layout.activity_main);
        Uri income = getIntent().getData();
        if (income != null) {
            String[] parts = income.toString().split("/");
            String id = parts[parts.length - 1];
            ServiceLocator.getInstance().getRepository().findParty(id, this).observe(this, (Route route) -> {
                if (route != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Party", ServiceLocator.getInstance().getGson().toJson(route));


                    Navigation.findNavController(mBinding.navHostFragment).navigate(
                            R.id.action_partyList_to_partyFragment,
                            bundle
                    );
                }
            });
        }
    }
}