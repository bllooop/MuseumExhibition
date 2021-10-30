package com.example.museumrouteapp.Presentation.View;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.Item;
import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.NetworkClient;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.VkApi;
import com.example.museumrouteapp.Presentation.View.Adapters.NewsListAdapter;
import com.example.museumrouteapp.Presentation.View.Adapters.RouteListAdapter;
import com.example.museumrouteapp.Presentation.ViewModel.NewsListViewModel;
import com.example.museumrouteapp.Presentation.ViewModel.RouteListViewModel;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.NewsTimelineBinding;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsTimeline extends Fragment {
    private NewsTimelineBinding mBinding;
    private NewsListViewModel mViewModel;


    public static NewsTimeline newInstance() {
        return new NewsTimeline();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = NewsTimelineBinding.inflate(getLayoutInflater(), container, false);
        mBinding.routeListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ((MainActivity) getActivity()).mBinding.fab.setVisibility(View.GONE);
        return mBinding.getRoot();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       mBinding.button.setOnClickListener((View v) -> {

               mBinding.button.setVisibility(View.GONE);

        mViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        mViewModel.getNewsList().observe(getViewLifecycleOwner(), v1 ->{
            NewsListAdapter adapter = new NewsListAdapter(v1, 30);
            mBinding.routeListRecycler.setAdapter(adapter);
        });

        });

    }
}
