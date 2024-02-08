package com.wakeupdev.movemate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.databinding.VehicleLayoutBinding;
import com.wakeupdev.movemate.models.VehicleModel;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {
    private final List<VehicleModel> availableVehicles;
    private final Context mContext;

    public VehicleAdapter(Context mContext, List<VehicleModel> availableVehicles) {
        this.mContext = mContext;
        this.availableVehicles = availableVehicles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        VehicleLayoutBinding vehicleLayoutBinding = VehicleLayoutBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new ViewHolder(vehicleLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VehicleModel vehicleModel = availableVehicles.get(position);

        // Set data to the views using data binding
        holder.vehicleLayoutBinding.vehicleType.setText(vehicleModel.getVehicleType());
        holder.vehicleLayoutBinding.transitType.setText(vehicleModel.getTransitType());
        holder.vehicleLayoutBinding.freightUrl.setImageDrawable(
                AppCompatResources.getDrawable(mContext, vehicleModel.getImageUrl())
        );

        Animation slideInRight = AnimationUtils.loadAnimation(mContext, R.anim.animation_slide_left);
        holder.vehicleLayoutBinding.freightUrl.startAnimation(slideInRight);

        // Load image using Glide (uncomment and replace placeholder URL)
//         Glide.with(mContext).load(vehicleModel.getImageUrl()).into(holder.vehicleLayoutBinding.freightUrl);
    }

    @Override
    public int getItemCount() {
        return availableVehicles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        VehicleLayoutBinding vehicleLayoutBinding;

        public ViewHolder(VehicleLayoutBinding layoutBinding) {
            super(layoutBinding.getRoot());
            this.vehicleLayoutBinding = layoutBinding;
        }
    }
}
