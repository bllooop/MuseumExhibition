package com.example.museumrouteapp.Presentation.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.museumrouteapp.Presentation.Repository.ApiWork.VkApi;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.NewsTimelineBinding;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsTimeline extends Fragment {
    private NewsTimelineBinding mBinding;

    public NewsTimeline() {
    }

    public static NewsTimeline newInstance() {
        return new NewsTimeline();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_timeline, container, false);
        mBinding = NewsTimelineBinding.inflate(getLayoutInflater(), container, false);
        private void getresponse() throws IOException {
            Retrofit retrofit = NetworkClient.getRetrofitClient();
            VkApi VkApi = retrofit.create(VkApi.class);
            Call<String> call = VkApi.getresponse("-39575430", "2", "1", "5.131", "THIS_IS_SECRET_DATA");
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()){
                        if (response.body() !=null){
                            System.out.println("onSuccess - " +response.body().toString());
                            String jsonresponse = response.body().toString();
                            mBinding.textView.setText(jsonresponse);

                        } else {
                            System.out.println("not Success");
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }
}
