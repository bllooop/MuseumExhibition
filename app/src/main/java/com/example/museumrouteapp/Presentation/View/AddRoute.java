package com.example.museumrouteapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.museumrouteapp.Presentation.ViewModel.AddRouteViewModel;
import com.example.museumrouteapp.databinding.AddRouteFragmentBinding;

public class AddRoute extends Fragment {
    private AddRouteViewModel mViewModel;
    private AddRouteFragmentBinding mBinding;
    public static AddRoute newInstance() {
        return new AddRoute();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = AddRouteFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mViewModel.AddRoute(
                            mBinding.partyName.getText().toString(),
                            mBinding.partyDescription.getText().toString()
                    );
                    Navigation.findNavController(v).popBackStack();
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "Вы ввели не все данные", Toast.LENGTH_SHORT).show();
                }
            }
        });
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