package com.example.museumrouteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.net.Uri;
import android.os.Bundle;

import com.example.museumrouteapp.DI.ServiceLocator;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Repository;
import com.example.museumrouteapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ServiceLocator.getInstance().initBase(getApplication());
        Uri income = getIntent().getData();
        if (income != null) {
            String[] parts = income.toString().split("/");
            String id = parts[parts.length - 1];
            ServiceLocator.getInstance().getRepository().findRoute(id, this).observe(this, (Route route) -> {
                if (route != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Route", ServiceLocator.getInstance().getGson().toJson(route));
                    Navigation.findNavController(mBinding.navHostFragment).navigate(
                            R.id.action_routeList_to_routeFragment,
                            bundle
                    );
                }
            });
        }
    }
}