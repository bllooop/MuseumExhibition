package com.example.museumrouteapp.Presentation.View.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;
import com.example.museumrouteapp.databinding.NewsElementBinding;

import org.jetbrains.annotations.NotNull;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private News data;
    private int size;

    public NewsListAdapter(News data, int size) {
        this.size = size;
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        NewsElementBinding binding = NewsElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewsViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {
        holder.binding.newsName.setText(data.getResponse().getItems().get(position).getText());
    }


    @Override
    public int getItemCount() {

            return size;

    }

    public News getData() {
        return data;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        NewsElementBinding binding;

        public NewsViewHolder(NewsElementBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
