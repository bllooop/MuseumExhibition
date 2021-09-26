package com.example.museumrouteapp.Presentation.View.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.databinding.RouteListElementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.RouteViewHolder> {
    private List<Route> data;

    public RouteListAdapter(List<Route> data) {

        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        RouteListElementBinding binding = RouteListElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RouteViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull RouteViewHolder holder, int position) {
        holder.binding.partyName.setText(data.get(position).getName());
        holder.binding.partyDescription.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Route> getData() {
        return data;
    }

    class RouteViewHolder extends RecyclerView.ViewHolder{

        RouteListElementBinding binding;

        public RouteViewHolder(RouteListElementBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
