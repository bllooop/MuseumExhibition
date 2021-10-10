package com.example.museumrouteapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.View.Adapters.RouteListAdapter;
import com.example.museumrouteapp.Presentation.ViewModel.RouteListViewModel;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.RouteListFragmentBinding;
import com.example.museumrouteapp.DI.ServiceLocator;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class RouteList extends Fragment {

    private RouteListViewModel mViewModel;
    private RouteListFragmentBinding mBinding;

    public static RouteList newInstance() {
        return new RouteList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = RouteListFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.routeListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        ((MainActivity) getActivity()).mBinding.fab.setImageResource(R.drawable.add);
        ((MainActivity) getActivity()).mBinding.fab.setOnClickListener((View v) -> {
            Navigation.findNavController(((MainActivity) getActivity()).mBinding.navHostFragment)
                    .navigate(R.id.action_routeList_to_addRoute);
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
           @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull
                    RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mViewModel.deleteRoute(((RouteListAdapter)
                        mBinding.routeListRecycler.getAdapter()).getData().get(position));
            }
        }).attachToRecyclerView(mBinding.routeListRecycler);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RouteListViewModel.class);

        mViewModel.getRouteList().observe(getViewLifecycleOwner(), (List<Route> routeList) -> {
            mBinding.routeListRecycler
                    .setAdapter(new RouteListAdapter(routeList, ((MainActivity) requireActivity())));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
        mViewModel = null;
    }
}