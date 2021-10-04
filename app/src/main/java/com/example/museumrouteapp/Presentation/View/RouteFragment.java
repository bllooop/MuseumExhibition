package com.example.museumrouteapp.Presentation.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

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

        ((MainActivity) getActivity()).mBinding.fab.setImageResource(R.drawable.share);

       /* ((MainActivity) getActivity()).setSupportActionBar(mBinding.toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.partyName.setNavigationOnClickListener((View v) -> {
            Navigation.findNavController(v).popBackStack();
        }); */

        if (mViewModel.getRoute() != null) {
            ((MainActivity) getActivity()).mBinding.fab.setOnClickListener((View v) -> {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://info.museumexhibition.app/" + mViewModel.getRoute().getId());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            });

            mBinding.imageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getRoute().getImages(), false, ((MainActivity) requireActivity())));
            mBinding.partyName.setText(mViewModel.getRoute().getName());
            mBinding.partyDescription.setText(mViewModel.getRoute().getDescription());

        }
        return mBinding.getRoot();
    }

}