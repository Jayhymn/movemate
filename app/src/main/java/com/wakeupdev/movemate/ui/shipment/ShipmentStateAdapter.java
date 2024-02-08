package com.wakeupdev.movemate.ui.shipment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.databinding.ParcelItemStateBinding;
import com.wakeupdev.movemate.models.ParcelModel;

import java.util.List;

public class ShipmentStateAdapter extends RecyclerView.Adapter<ShipmentStateAdapter.ShipmentStateViewHolder> {

    private final Context context;
    private List<ParcelModel> parcels;

    public ShipmentStateAdapter (Context context, List<ParcelModel> parcels){
        this.context = context;
        this.parcels = parcels;
    }

    public void updateParcels(List<ParcelModel> parcels) {
        this.parcels = parcels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShipmentStateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ParcelItemStateBinding itemStateBinding = ParcelItemStateBinding.inflate(LayoutInflater.from(context), parent, false);

        return new ShipmentStateViewHolder(itemStateBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShipmentStateViewHolder holder, int position) {
        ParcelModel parcel = parcels.get(position);

        determineStatus(parcel, holder);
        holder.itemStateBinding.costDelivery.setText(parcel.getDeliveryCost());
        holder.itemStateBinding.message.setText(parcel.getMessage());
        holder.itemStateBinding.arrivalDate.setText(parcel.getArrivalDate());
        holder.itemStateBinding.deliveryDetails.setText(String.format(
                context.getString(R.string.delivery_details),
                parcel.getTrackingId(),
                parcel.getOrigin()
        ));

        holder.itemStateBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(context, R.anim.animation_slide_up));
    }

    private void determineStatus(ParcelModel parcel, ShipmentStateViewHolder holder) {
        Drawable statusDrawable;
        int statusColor;

        switch (parcel.getState()) {
            case PENDING: {
                holder.itemStateBinding.status.setText(" pending");
                statusDrawable = AppCompatResources.getDrawable(context, R.drawable.ic_pending);
                statusColor = context.getResources().getColor(R.color.accent_color, null);
            }
            break;

            case IN_PROGRESS: {
                holder.itemStateBinding.status.setText(" in progress");
                statusDrawable = AppCompatResources.getDrawable(context, R.drawable.refresh_icon);
                statusColor = context.getResources().getColor(R.color.progress_color, null);
            }
            break;

            case LOADING: {
                holder.itemStateBinding.status.setText(" loading");
                statusDrawable = AppCompatResources.getDrawable(context, R.drawable.loading);
                statusColor = context.getResources().getColor(R.color.loading_color, null);
            }
            break;

            default: {
                // Handle other states if needed
                statusDrawable = null;
                statusColor = Color.BLACK; // Default color
            }
            break;
        }

        // Set the drawable and color to the status TextView
        if (statusDrawable != null) {
            statusDrawable = DrawableCompat.wrap(statusDrawable);
            DrawableCompat.setTint(statusDrawable, statusColor);
            statusDrawable.setBounds(0, 0, statusDrawable.getIntrinsicWidth(), statusDrawable.getIntrinsicHeight());
            holder.itemStateBinding.status.setCompoundDrawables(statusDrawable, null, null, null);
            holder.itemStateBinding.status.setCompoundDrawablePadding(8); // Adjust padding as needed
        }

        holder.itemStateBinding.status.setTextColor(statusColor);
    }

    @Override
    public int getItemCount() {
        return parcels.size();
    }

    public static class ShipmentStateViewHolder extends RecyclerView.ViewHolder {
        public ParcelItemStateBinding itemStateBinding;

        public ShipmentStateViewHolder(@NonNull ParcelItemStateBinding stateBinding) {
            super(stateBinding.getRoot());
            this.itemStateBinding = stateBinding;
        }
    }
}
