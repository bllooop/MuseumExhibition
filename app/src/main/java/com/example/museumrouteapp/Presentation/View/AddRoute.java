package com.example.museumrouteapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.museumrouteapp.DI.ServiceLocator;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.View.Adapters.ImageSliderAdapter;
import com.example.museumrouteapp.Presentation.ViewModel.AddRouteViewModel;
import com.example.museumrouteapp.Presentation.ViewModel.RouteViewModel;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.AddRouteFragmentBinding;
import com.example.museumrouteapp.databinding.RouteFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AddRoute extends Fragment {
    private AddRouteViewModel mViewModel;
    private AddRouteFragmentBinding mBinding;
    private List<String> images = new ArrayList<>();

    public static AddRoute newInstance() {
        return new AddRoute();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = AddRouteFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.backButton.setOnClickListener((View v) -> {
            Navigation.findNavController(v).popBackStack();
        });
        ((MainActivity) getActivity()).mBinding.fab.setImageResource(R.drawable.save);
        ((MainActivity) getActivity()).mBinding.fab.setOnClickListener((View v) -> {
            if (!mBinding.routeName.getText().toString().isEmpty()) {
                mViewModel.AddRoute(
                        mBinding.routeName.getText().toString(),
                        mBinding.routeDescription.getText().toString(),
                        images
                );
                Log.i("d", mBinding.routeName.getText().toString());

                Navigation.findNavController(((MainActivity) getActivity()).mBinding.navHostFragment).popBackStack();
            } else {
                Toast.makeText(getContext(), "Вы ввели не все данные", Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.imageSlider.setAdapter(new ImageSliderAdapter(images, true, ((MainActivity) requireActivity())));
        mBinding.imageSlider.setVisibility(View.VISIBLE);
        mBinding.imageSlider.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddRouteViewModel.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
        mViewModel = null;
    }
}

