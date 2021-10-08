package com.example.museumrouteapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.museumrouteapp.DI.ServiceLocator;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.View.Adapters.ImageSliderAdapter;
import com.example.museumrouteapp.Presentation.ViewModel.RouteViewModel;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.RouteFragmentBinding;


public class RouteFragment extends Fragment {

    private RouteViewModel mViewModel;
    private RouteFragmentBinding mBinding;

    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(RouteViewModel.class);

        if (getArguments() != null) {
            mViewModel.setRoute(
                    ServiceLocator.getInstance().getGson().fromJson(getArguments().getString("Route"), Route.class)
            );
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = RouteFragmentBinding.inflate(inflater, container, false);
        mBinding.imageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getRoute().getImages(), false, ((MainActivity) requireActivity())));
        mBinding.routeDescription.setText(mViewModel.getRoute().getDescription());
        mBinding.routeName.setText(mViewModel.getRoute().getName());

        if (mViewModel.getRoute() != null) {
            ((MainActivity) getActivity()).mBinding.fab.setOnClickListener((View v) -> {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://rf.party_app/" + mViewModel.getRoute().getId());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            });

        }

            return mBinding.getRoot();
        }


}