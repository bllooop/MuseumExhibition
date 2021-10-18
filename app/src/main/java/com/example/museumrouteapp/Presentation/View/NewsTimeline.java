package com.example.museumrouteapp.Presentation.View;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.Item;
import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.NetworkClient;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.VkApi;
import com.example.museumrouteapp.Presentation.View.Adapters.NewsListAdapter;
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
    public String Nsize;


    public static NewsTimeline newInstance() {
        return new NewsTimeline();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = NewsTimelineBinding.inflate(getLayoutInflater(), container, false);
        mBinding.routeListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            ((MainActivity) getActivity()).mBinding.fab.setVisibility(View.GONE);
        mBinding.button.setOnClickListener((View v) -> {
            if (!mBinding.newsSize.getText().toString().isEmpty()) {
                Nsize = mBinding.newsSize.getText().toString();
                Retrofit retrofit = NetworkClient.getRetrofitClient();
                VkApi VkApi = retrofit.create(VkApi.class);
                mBinding.button.setVisibility(View.GONE);
                Call<News> call = VkApi.getresponse("-39575430", "0", Nsize, "5.131", "0", "162dc14d76ab3a6dec41d09b0a41b0eef716f47d25cf161219bd9ad18f2d7356fe4de37bb25fd0a19e7b4");
                call.enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (!response.isSuccessful()) {
                            mBinding.textView.setText("Code" + response.code());
                            return;
                        }
                        if (response.isSuccessful()) {
                            mBinding.newsSize.setVisibility(View.GONE);
                            News item = response.body();
                            NewsListAdapter adapter = new NewsListAdapter(item, Integer.valueOf(Nsize));
                            mBinding.routeListRecycler.setAdapter(adapter);
                            // mBinding.textView.append(content);
                            // }
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        mBinding.textView.setText(t.getMessage());
                    }
                });
            }
        });

        return mBinding.getRoot();
    }
}
