package com.wakeupdev.movemate.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.databinding.FragmentHomeBinding;
import com.wakeupdev.movemate.databinding.ParcelItemViewBinding;
import com.wakeupdev.movemate.models.ParcelModel;

import java.util.List;
import java.util.Locale;

public class ParcelAdapter extends RecyclerView.Adapter<ParcelAdapter.ParcelViewHolder> {
    private final List<ParcelModel> parcels;
    private final Context context;

    public ParcelAdapter(Context context, List<ParcelModel> parcels){
        this.parcels = parcels;
        this.context = context;
    }

    @NonNull
    @Override
    public ParcelAdapter.ParcelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ParcelItemViewBinding itemViewBinding = ParcelItemViewBinding.inflate(LayoutInflater.from(context), parent, false);

        return new ParcelViewHolder(itemViewBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull ParcelAdapter.ParcelViewHolder holder, int position) {
        ParcelModel parcel = parcels.get(position);

        String parcelName = parcel.getParcelName();
        String trackingId = parcel.getTrackingId();
        String origin = parcel.getOrigin();
        String destination = parcel.getDestination();

        holder.binding.parcelName.setText(parcelName);

        holder.binding.trackingId.setText(
                String.format(
                        Locale.getDefault(),
                        context.getResources().getString(R.string.tracking_details ),
                        trackingId,
                        origin,
                        destination
                )
        );

        holder.binding.horizontalLine.setVisibility(position == parcels.size() - 1 ? View.GONE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return parcels.size();
    }

    public static class ParcelViewHolder extends RecyclerView.ViewHolder {
        private final ParcelItemViewBinding binding;

        public ParcelViewHolder(@NonNull ParcelItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
