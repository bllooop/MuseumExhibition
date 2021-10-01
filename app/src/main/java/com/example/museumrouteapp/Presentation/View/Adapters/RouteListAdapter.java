package com.example.museumrouteapp.Presentation.View.Adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.MainActivity;
import com.example.museumrouteapp.R;
import com.example.museumrouteapp.databinding.RouteListElementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.RouteViewHolder> {
    private List<Route> data;
    private MainActivity mActivity;

    public RouteListAdapter(List<Route> data, MainActivity activity) {
        mActivity = activity;
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        RouteListElementBinding binding = RouteListElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RouteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PartyViewHolder holder, int position) {
        holder.binding.partyCard.setOnClickListener((View v) -> {
            Bundle bundle = new Bundle();
            String json = ServiceLocator.getInstance().getGson().toJson(data.get(position));
            bundle.putString("Route", json);

            Navigation.findNavController(mActivity.mBinding.navHostFragment)
                    .navigate(R.id.action_partyList_to_partyFragment, bundle);
        });

        holder.binding.partyName.setText(data.get(position).getName());




        if (data.get(position).getImages() != null && !data.get(position).getImages().isEmpty()) {
            holder.binding.imageSlider.setVisibility(View.VISIBLE);
            holder.binding.imageSlider.setAdapter(new ImageSliderAdapter(data.get(position).getImages(), false, mActivity));
        } else {
            holder.binding.imageSlider.setVisibility(View.GONE);
        }
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
