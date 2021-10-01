package com.example.museumrouteapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.View.Adapters.ImageSliderAdapter;
import com.example.museumrouteapp.Presentation.ViewModel.AddRouteViewModel;
import com.example.museumrouteapp.Presentation.ViewModel.RouteViewModel;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.AddRouteFragmentBinding;

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
       mBinding.fab.setImageResource(R.drawable.save);
        mBinding.fab.setOnClickListener((View v) -> {
            if (!mBinding.partyName.getText().toString().isEmpty()) {
                mViewModel.AddRoute(
                        mBinding.partyName.getText().toString(),
                        mBinding.partyDescription.getText().toString(),
                        images
                );

                Navigation.findNavController(mBinding.navHostFragment).popBackStack();
            } else {
                Toast.makeText(getContext(), "Вы ввели не все данные", Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.imageSlider.setAdapter(new ImageSliderAdapter(images, true, ((MainActivity) requireActivity())));
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

    public static class RouteFragment extends Fragment {

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

            mBinding.fab.setImageResource(R.drawable.share);

            ((MainActivity) getActivity()).setSupportActionBar(mBinding.toolbar);
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mBinding.toolbar.setNavigationOnClickListener((View v) -> {
                Navigation.findNavController(v).popBackStack();
            });

            if (mViewModel.getRoute() != null) {
                ((MainActivity) getActivity()).mBinding.fab.setOnClickListener((View v) -> {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "https://info.museumexhibition.app/" + mViewModel.getRoute().getId());
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                });

                mBinding.imageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getPagetRouterty().getImages(), false, ((MainActivity) requireActivity())));
                mBinding.toolbarLayout.setTitle(mViewModel.getRoute().getName());
                mBinding.partyDescription.setText(mViewModel.getRoute().getDescription());

            }
            return mBinding.getRoot();
        }

    }
}