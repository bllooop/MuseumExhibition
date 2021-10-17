package com.example.museumrouteapp.Presentation.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import com.example.museumrouteapp.Domain.Model.Items;
import com.example.museumrouteapp.Domain.Model.News;
import com.example.museumrouteapp.Domain.Model.News;
import com.example.museumrouteapp.Domain.Model.Response2;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.NetworkClient;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.VkApi;
import com.example.museumrouteapp.databinding.NewsTimelineBinding;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsTimeline extends Fragment {
    private NewsTimelineBinding mBinding;


    public static NewsTimeline newInstance() {
        return new NewsTimeline();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = NewsTimelineBinding.inflate(getLayoutInflater(), container, false);
      //  mBinding.textView.setText("lol");
        
        //private void getresponse() throws IOException {
        Retrofit retrofit = NetworkClient.getRetrofitClient();
            VkApi VkApi = retrofit.create(VkApi.class);
            Call<Response2> call = VkApi.getresponse("-39575430", "1", "1", "5.131","0", "162dc14d76ab3a6dec41d09b0a41b0eef716f47d25cf161219bd9ad18f2d7356fe4de37bb25fd0a19e7b4");
            call.enqueue(new Callback<Response2> () {
                @Override
                public void onResponse(Call <Response2>  call, Response<Response2>  response) {
                    if(!response.isSuccessful()){
                        mBinding.textView.setText("Code"+response.code());
                        return;
                    }
                    if (response.isSuccessful()){
                        /*if (response.body() !=null){
                            String jsonresponse = response.body().toString();
                            mBinding.textView.setText(jsonresponse);

                        } else {
                            System.out.println("not Success");
                        }*/

                       // Date date = new java.util.Date(unixSeconds*1000L);
                        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                        //String formattedDate = sdf.format(date);
                      Response2 news = response.body();
                        //for (News news : items) {
                           String content = "";
//                            content += content += "Дата:" + news.getItems().getDate();
                           // content += content += "Пост сообщества: " + news.getCount();
                           mBinding.textView.setText(String.valueOf(news.getCount()));
                        //}
                    }
                }

                @Override
                public void onFailure(Call <Response2>  call, Throwable t) {
                    mBinding.textView.setText(t.getMessage());
                }
            });
      //  }
        return mBinding.getRoot();
    }
}
